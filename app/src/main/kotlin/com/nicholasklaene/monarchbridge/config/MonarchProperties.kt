package com.nicholasklaene.monarchbridge.config

import org.springframework.boot.context.properties.ConfigurationProperties

/**
 * Binds `monarch.*` from application.yaml / env vars.
 *
 * Properties:
 * - `sessionPath`  — path to the JSON session file (tilde-expanded at use time).
 * - `baseUrl`      — Monarch API base URL (SSRF-pinned to api.monarch.com in MonarchClient).
 * - `requestTimeoutSeconds` — read timeout for GraphQL POSTs.
 */
@ConfigurationProperties("monarch")
data class MonarchProperties(
    val sessionPath: String = "\${user.home}/.config/monarch-bridge/.mm-session.json",
    val baseUrl: String = "https://api.monarch.com",
    val requestTimeoutSeconds: Long = 30,
)
