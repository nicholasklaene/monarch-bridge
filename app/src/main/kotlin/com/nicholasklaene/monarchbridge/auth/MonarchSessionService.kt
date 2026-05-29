package com.nicholasklaene.monarchbridge.auth

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.nicholasklaene.monarchbridge.config.MonarchProperties
import com.nicholasklaene.monarchbridge.exceptions.MonarchSessionMissingException
import io.github.oshai.kotlinlogging.KotlinLogging
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Component
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.attribute.PosixFilePermission
import java.util.concurrent.atomic.AtomicReference

/**
 * Manages the persisted Monarch Money session token.
 *
 * The session JSON lives at `monarch.session-path` (default: ~/.config/monarch-bridge/.mm-session.json).
 * The file is written by [com.nicholasklaene.monarchbridge.MonarchBootstrapMain] after a successful
 * login. This component loads it at startup (best-effort) and exposes the current value via [current].
 *
 * Thread-safety: the in-memory holder is an [AtomicReference]; file I/O is synchronized on `this`.
 */
@Component
class MonarchSessionService(
    private val properties: MonarchProperties,
    private val objectMapper: ObjectMapper,
) {
    private val holder = AtomicReference<MonarchSession?>(null)

    private companion object {
        private val log = KotlinLogging.logger {}
    }

    /**
     * Returns the currently-held session, or null if none has been loaded.
     */
    fun current(): MonarchSession? = holder.get()

    /**
     * Returns the currently-held session, or throws [MonarchSessionMissingException] (→ HTTP 503)
     * if none is loaded. Use this from controllers as a one-line session gate; reserve [current]
     * for read-only checks that should tolerate the unauthenticated state.
     */
    fun requireCurrent(): MonarchSession = current() ?: throw MonarchSessionMissingException()

    /**
     * Loads the session from disk.
     *
     * Returns null (and logs a warning) if the file is absent or the JSON is unparseable.
     * Does NOT throw.
     */
    @Suppress("SwallowedException")
    fun load(): MonarchSession? {
        val path = resolvePath()
        if (!Files.exists(path)) {
            log.debug { "Monarch session file not found at $path - not authenticated" }
            return null
        }
        return try {
            objectMapper.readValue<MonarchSession>(path.toFile())
        } catch (ex: IOException) {
            log.warn { "Monarch session file at $path is corrupt or unreadable: ${ex.message}. Re-run :app:bootstrapMonarch." }
            null
        }
    }

    /**
     * Atomically writes the session to disk (write to .tmp, then rename).
     * Creates parent directories with 0700 permissions if they don't exist.
     */
    @Synchronized
    fun save(session: MonarchSession) {
        val path = resolvePath()
        val parent = path.parent
        if (!Files.exists(parent)) {
            Files.createDirectories(parent)
            setDirectoryPermissions(parent)
        }
        val tmp = path.resolveSibling(path.fileName.toString() + ".tmp")
        objectMapper.writeValue(tmp.toFile(), session)
        Files.move(
            tmp,
            path,
            java.nio.file.StandardCopyOption.REPLACE_EXISTING,
            java.nio.file.StandardCopyOption.ATOMIC_MOVE,
        )
        // Lock the file down to owner-read+write only. The session token is the only
        // gate to the user's Monarch account — a permissive umask would expose it to
        // other local users.
        setFilePermissions(path)
        holder.set(session)
        log.info { "Monarch session saved to $path (email=${session.email})" }
    }

    @Suppress("SwallowedException")
    private fun setFilePermissions(file: Path) {
        try {
            Files.setPosixFilePermissions(
                file,
                setOf(PosixFilePermission.OWNER_READ, PosixFilePermission.OWNER_WRITE),
            )
        } catch (ex: UnsupportedOperationException) {
            log.debug { "Non-POSIX filesystem; skipping 0600 permission on $file" }
        }
    }

    /**
     * Re-reads from disk and updates the in-memory holder.
     * Returns the new value (may be null if the file is absent or unparseable).
     */
    fun reload(): MonarchSession? {
        val session = load()
        holder.set(session)
        return session
    }

    /** Loads the session at startup. Tolerates missing/corrupt file. */
    @PostConstruct
    fun init() {
        reload()
        if (holder.get() == null) {
            log.warn { "MONARCH_SESSION missing - bootstrap required. Run ./gradlew :app:bootstrapMonarch" }
        } else {
            log.info { "Monarch session loaded (email=${holder.get()?.email})" }
        }
    }

    /** Resolve ~ to the actual home directory. */
    internal fun resolvePath(): Path {
        val raw = properties.sessionPath
        val expanded =
            if (raw.startsWith("~")) {
                System.getProperty("user.home") + raw.substring(1)
            } else {
                raw
            }
        return Path.of(expanded)
    }

    @Suppress("SwallowedException")
    private fun setDirectoryPermissions(dir: Path) {
        try {
            Files.setPosixFilePermissions(
                dir,
                setOf(
                    PosixFilePermission.OWNER_READ,
                    PosixFilePermission.OWNER_WRITE,
                    PosixFilePermission.OWNER_EXECUTE,
                ),
            )
        } catch (ex: UnsupportedOperationException) {
            log.debug { "Non-POSIX filesystem; skipping 0700 permission on $dir" }
        }
    }
}
