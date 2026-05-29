package com.nicholasklaene.monarchbridge.auth

import java.time.Instant

/**
 * Represents a persisted Monarch Money session.
 * Written to ~/.config/monarch-bridge/.mm-session.json by MonarchBootstrapMain.
 * Loaded at startup by MonarchSession.
 */
data class MonarchSession(
    val token: String,
    val email: String,
    val lastVerifiedAt: Instant,
) {
    /**
     * Masks the token in `toString()` output so any future log line that prints the
     * session object (e.g. `log.info("session={}", session)`) does NOT leak credentials.
     * Without this override Kotlin's auto-generated toString includes the raw token.
     */
    override fun toString(): String = "MonarchSession(token=***, email=$email, lastVerifiedAt=$lastVerifiedAt)"
}
