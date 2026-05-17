package com.nicholasklaene.monarchproxy.models

import java.time.Instant

/**
 * Response body for `GET /v1/auth/status` and `POST /v1/auth/refresh`.
 */
data class AuthStatusResponse(
    val authenticated: Boolean,
    val email: String?,
    val lastVerifiedAt: Instant?,
) {
    companion object {
        fun from(session: MonarchSession?): AuthStatusResponse =
            AuthStatusResponse(
                authenticated = session != null,
                email = session?.email,
                lastVerifiedAt = session?.lastVerifiedAt,
            )
    }
}
