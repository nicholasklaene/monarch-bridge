package com.nicholasklaene.monarchproxy.services

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.nicholasklaene.monarchproxy.config.MonarchProperties
import com.nicholasklaene.monarchproxy.models.MonarchSession
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir
import java.nio.file.Files
import java.nio.file.Path
import java.time.Instant

class MonarchSessionTest {
    @TempDir
    lateinit var tmpDir: Path

    private fun makeService(sessionPath: String): MonarchSessionService {
        val mapper =
            ObjectMapper()
                .registerKotlinModule()
                .findAndRegisterModules()
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
        val props = MonarchProperties(sessionPath = sessionPath)
        return MonarchSessionService(props, mapper)
    }

    @Test
    fun `load returns null when file absent`() {
        val svc = makeService("$tmpDir/absent/.mm-session.json")
        assertThat(svc.load()).isNull()
    }

    @Test
    fun `load returns null when JSON is corrupt`() {
        val file = tmpDir.resolve(".mm-session.json")
        Files.writeString(file, "{ invalid json }")
        val svc = makeService(file.toString())
        assertThat(svc.load()).isNull()
    }

    @Test
    fun `save and load round-trip preserves all fields`() {
        val file = tmpDir.resolve(".mm-session.json")
        val svc = makeService(file.toString())
        val now = Instant.parse("2026-05-09T10:00:00Z")
        val session = MonarchSession(token = "tok123", email = "nick@klaenerealestate.com", lastVerifiedAt = now)

        svc.save(session)

        val loaded = svc.load()
        assertThat(loaded).isNotNull
        assertThat(loaded!!.token).isEqualTo("tok123")
        assertThat(loaded.email).isEqualTo("nick@klaenerealestate.com")
        assertThat(loaded.lastVerifiedAt).isEqualTo(now)
    }

    @Test
    fun `save is atomic — writes to tmp then renames`() {
        val file = tmpDir.resolve(".mm-session.json")
        val svc = makeService(file.toString())
        val session = MonarchSession(token = "tok-atomic", email = "test@example.com", lastVerifiedAt = Instant.now())

        svc.save(session)

        // The .tmp file should not exist after a successful save
        val tmpFile = tmpDir.resolve(".mm-session.json.tmp")
        assertThat(tmpFile).doesNotExist()
        // But the actual file should exist
        assertThat(file).exists()
    }

    @Test
    fun `save updates in-memory holder`() {
        val file = tmpDir.resolve(".mm-session.json")
        val svc = makeService(file.toString())
        val session = MonarchSession(token = "tok-hold", email = "hold@example.com", lastVerifiedAt = Instant.now())

        assertThat(svc.current()).isNull()
        svc.save(session)
        assertThat(svc.current()?.token).isEqualTo("tok-hold")
    }

    @Test
    fun `reload updates in-memory holder from disk`() {
        val file = tmpDir.resolve(".mm-session.json")
        val svc = makeService(file.toString())
        val session = MonarchSession(token = "tok-reload", email = "reload@example.com", lastVerifiedAt = Instant.now())

        // Write directly to disk bypassing svc.save()
        val mapper =
            ObjectMapper()
                .registerKotlinModule()
                .findAndRegisterModules()
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
        mapper.writeValue(file.toFile(), session)

        val reloaded = svc.reload()
        assertThat(reloaded?.token).isEqualTo("tok-reload")
        assertThat(svc.current()?.token).isEqualTo("tok-reload")
    }

    @Test
    fun `reload returns null when file absent and clears holder`() {
        val svc = makeService("$tmpDir/nowhere/.mm-session.json")
        val result = svc.reload()
        assertThat(result).isNull()
        assertThat(svc.current()).isNull()
    }

    @Test
    fun `home tilde expansion works`() {
        val home = System.getProperty("user.home")
        val svc = makeService("~/.config/monarch-proxy/.mm-session.json")
        val resolved = svc.resolvePath()
        assertThat(resolved.toString()).startsWith(home)
        assertThat(resolved.toString()).doesNotContain("~")
    }

    @Test
    fun `save creates parent directories`() {
        val nested = tmpDir.resolve("deep/nested/dir/.mm-session.json")
        val svc = makeService(nested.toString())
        val session = MonarchSession(token = "tok-deep", email = "deep@example.com", lastVerifiedAt = Instant.now())

        svc.save(session)

        assertThat(nested).exists()
    }
}
