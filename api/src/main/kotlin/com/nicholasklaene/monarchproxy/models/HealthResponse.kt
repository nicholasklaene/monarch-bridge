package com.nicholasklaene.monarchproxy.models

import com.nicholasklaene.monarchproxy.services.MonarchSessionService
import java.time.Instant

/**
 * Response body for `GET /healthz`.
 */
data class HealthResponse(
    val status: String,
    val authenticated: Boolean,
    val lastVerifiedAt: Instant?,
) {
    companion object {
        fun from(sessionService: MonarchSessionService): HealthResponse {
            val session = sessionService.current()
            return HealthResponse(
                status = "UP",
                authenticated = session != null,
                lastVerifiedAt = session?.lastVerifiedAt,
            )
        }
    }
}
