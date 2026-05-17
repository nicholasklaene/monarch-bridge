package com.nicholasklaene.monarchproxy.config

import com.nicholasklaene.monarchproxy.exceptions.MonarchRateLimitedException
import com.nicholasklaene.monarchproxy.exceptions.MonarchRequestFailedException
import com.nicholasklaene.monarchproxy.exceptions.MonarchSessionExpiredException
import com.nicholasklaene.monarchproxy.exceptions.MonarchSessionMissingException
import com.nicholasklaene.monarchproxy.models.ErrorResponse
import org.slf4j.LoggerFactory
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

private val log = LoggerFactory.getLogger(GlobalExceptionHandler::class.java)

/**
 * Maps Monarch exceptions to HTTP status codes with a uniform error body.
 *
 * Error shape: `{"code": "...", "message": "...", "details": {...}}` — matches PDS convention.
 * Stack traces are logged server-side only; never leaked in the response body.
 */
@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(MonarchSessionMissingException::class)
    fun handleSessionMissing(ex: MonarchSessionMissingException): ResponseEntity<ErrorResponse> {
        log.warn("Monarch session missing: {}", ex.message)
        return ResponseEntity
            .status(HttpStatus.SERVICE_UNAVAILABLE)
            .body(
                ErrorResponse.from(
                    code = "session_missing",
                    message = "Run :api:bootstrapMonarch",
                ),
            )
    }

    @ExceptionHandler(MonarchSessionExpiredException::class)
    fun handleSessionExpired(ex: MonarchSessionExpiredException): ResponseEntity<ErrorResponse> {
        log.warn("Monarch session expired: {}", ex.message)
        return ResponseEntity
            .status(HttpStatus.UNAUTHORIZED)
            .body(
                ErrorResponse.from(
                    code = "session_expired",
                    message = "Re-run :api:bootstrapMonarch",
                ),
            )
    }

    @ExceptionHandler(MonarchRateLimitedException::class)
    fun handleRateLimited(ex: MonarchRateLimitedException): ResponseEntity<ErrorResponse> {
        log.warn("Monarch rate limited, retry after {}s", ex.retryAfterSeconds)
        val headers = HttpHeaders()
        ex.retryAfterSeconds?.let { headers.set("Retry-After", it.toString()) }
        return ResponseEntity
            .status(HttpStatus.TOO_MANY_REQUESTS)
            .headers(headers)
            .body(
                ErrorResponse.from(
                    code = "rate_limited",
                    message = "Monarch rate limit hit. Retry after ${ex.retryAfterSeconds ?: "unknown"} seconds.",
                    details = buildMap { ex.retryAfterSeconds?.let { put("retry_after_seconds", it) } },
                ),
            )
    }

    @ExceptionHandler(MonarchRequestFailedException::class)
    fun handleRequestFailed(ex: MonarchRequestFailedException): ResponseEntity<ErrorResponse> {
        log.warn("Monarch request failed with status {}: {}", ex.status, ex.message)
        return ResponseEntity
            .status(HttpStatus.BAD_GATEWAY)
            .body(
                ErrorResponse.from(
                    code = "monarch_request_failed",
                    message = ex.message ?: "Upstream request to Monarch failed.",
                    details = mapOf("upstream_status" to ex.status),
                ),
            )
    }

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleIllegalArgument(ex: IllegalArgumentException): ResponseEntity<ErrorResponse> {
        log.debug("Invalid input: {}", ex.message)
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(
                ErrorResponse.from(
                    code = "invalid_input",
                    message = ex.message ?: "Invalid input.",
                ),
            )
    }

    @ExceptionHandler(Exception::class)
    fun handleUnexpected(ex: Exception): ResponseEntity<ErrorResponse> {
        log.error("Unexpected error in controller", ex)
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(
                ErrorResponse.from(
                    code = "internal_error",
                    message = "An unexpected error occurred.",
                ),
            )
    }
}
