package com.nicholasklaene.monarchproxy.models

/**
 * Standard error response shape — mirrors PDS convention (`code`, `message`, `details`).
 * Stack traces are never included in the response body.
 */
data class ErrorResponse(
    val code: String,
    val message: String,
    val details: Map<String, Any> = emptyMap(),
) {
    companion object {
        fun from(
            code: String,
            message: String,
            details: Map<String, Any> = emptyMap(),
        ): ErrorResponse = ErrorResponse(code = code, message = message, details = details)
    }
}
