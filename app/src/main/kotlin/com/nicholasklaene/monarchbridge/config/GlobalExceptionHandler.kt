package com.nicholasklaene.monarchbridge.config

import com.nicholasklaene.monarchbridge.exceptions.MonarchRateLimitedException
import com.nicholasklaene.monarchbridge.exceptions.MonarchRequestFailedException
import com.nicholasklaene.monarchbridge.exceptions.MonarchSessionExpiredException
import com.nicholasklaene.monarchbridge.exceptions.MonarchSessionMissingException
import com.nicholasklaene.monarchbridge.exceptions.PayloadErrorException
import com.nicholasklaene.monarchbridge.generated.model.ErrorResponse
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException
import org.springframework.web.servlet.resource.NoResourceFoundException

/**
 * Maps Monarch exceptions to HTTP status codes with a uniform error body.
 *
 * Error shape comes from the spec-generated [ErrorResponse]: `{"code", "message", "details"}`.
 * Stack traces are logged server-side only; never leaked in the response body.
 */
@RestControllerAdvice
class GlobalExceptionHandler {
    @Suppress("UNCHECKED_CAST")
    private fun error(
        code: String,
        message: String,
        details: Map<String, Any?>? = null,
    ): ErrorResponse =
        ErrorResponse(
            code = code,
            message = message,
            // Spec ErrorResponse.details is `Map<String, Any>` (non-null values); strip any
            // null entries our helper code may have built before casting.
            details = details?.filterValues { it != null } as Map<String, Any>?,
        )

    @ExceptionHandler(MonarchSessionMissingException::class)
    fun handleSessionMissing(ex: MonarchSessionMissingException): ResponseEntity<ErrorResponse> {
        log.warn { "Monarch session missing: ${ex.message}" }
        return ResponseEntity
            .status(HttpStatus.SERVICE_UNAVAILABLE)
            .body(error("session_missing", "Run :app:bootstrapMonarch"))
    }

    @ExceptionHandler(MonarchSessionExpiredException::class)
    fun handleSessionExpired(ex: MonarchSessionExpiredException): ResponseEntity<ErrorResponse> {
        log.warn { "Monarch session expired: ${ex.message}" }
        return ResponseEntity
            .status(HttpStatus.UNAUTHORIZED)
            .body(error("session_expired", "Re-run :app:bootstrapMonarch"))
    }

    @ExceptionHandler(MonarchRateLimitedException::class)
    fun handleRateLimited(ex: MonarchRateLimitedException): ResponseEntity<ErrorResponse> {
        log.warn { "Monarch rate limited, retry after ${ex.retryAfterSeconds}s" }
        val headers = HttpHeaders()
        ex.retryAfterSeconds?.let { headers.set("Retry-After", it.toString()) }
        return ResponseEntity
            .status(HttpStatus.TOO_MANY_REQUESTS)
            .headers(headers)
            .body(
                error(
                    code = "rate_limited",
                    message = "Monarch rate limit hit. Retry after ${ex.retryAfterSeconds ?: "unknown"} seconds.",
                    details = buildMap { ex.retryAfterSeconds?.let { put("retry_after_seconds", it) } },
                ),
            )
    }

    @ExceptionHandler(MonarchRequestFailedException::class)
    fun handleRequestFailed(ex: MonarchRequestFailedException): ResponseEntity<ErrorResponse> {
        val truncatedBody = ex.body.take(UPSTREAM_BODY_MAX_CHARS)
        log.warn { "Monarch request failed with status ${ex.status}: ${ex.message} body=$truncatedBody" }
        val errDetails = mutableMapOf<String, Any?>("upstream_status" to ex.status)
        if (ex.body.isNotBlank()) {
            errDetails["upstream_body"] = truncatedBody
        }
        return ResponseEntity
            .status(HttpStatus.BAD_GATEWAY)
            .body(
                error(
                    code = "monarch_request_failed",
                    message = ex.message,
                    details = errDetails,
                ),
            )
    }

    @ExceptionHandler(PayloadErrorException::class)
    fun handlePayloadError(ex: PayloadErrorException): ResponseEntity<ErrorResponse> {
        log.warn { "PayloadError on ${ex.mutationName}: ${ex.errors.firstOrNull()?.message}" }
        val first = ex.errors.firstOrNull()
        val details = mapOf("mutation" to ex.mutationName, "errors" to ex.errors.map(::serializeError))
        return ResponseEntity
            .status(HttpStatus.UNPROCESSABLE_ENTITY)
            .body(
                error(
                    code = first?.code ?: "payload_error",
                    message = first?.message ?: "Monarch returned application errors.",
                    details = details,
                ),
            )
    }

    private fun serializeError(err: com.nicholasklaene.monarchbridge.graphql.PayloadError): Map<String, Any?> =
        mapOf(
            "message" to err.message,
            "code" to err.code,
            "fieldErrors" to err.fieldErrors.map { mapOf("field" to it.field, "messages" to it.messages) },
        )

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleIllegalArgument(ex: IllegalArgumentException): ResponseEntity<ErrorResponse> {
        log.debug { "Invalid input: ${ex.message}" }
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(error("invalid_input", ex.message ?: "Invalid input."))
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException::class)
    fun handleBadParam(ex: MethodArgumentTypeMismatchException): ResponseEntity<ErrorResponse> {
        log.debug { "Bad request param ${ex.name}=${ex.value}: ${ex.message}" }
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(
                error(
                    code = "invalid_param",
                    message = "Invalid value for '${ex.name}': expected ${ex.requiredType?.simpleName ?: "?"}",
                ),
            )
    }

    @ExceptionHandler(org.springframework.web.bind.MissingServletRequestParameterException::class)
    fun handleMissingParam(ex: org.springframework.web.bind.MissingServletRequestParameterException): ResponseEntity<ErrorResponse> {
        log.debug { "Missing required request param ${ex.parameterName}: ${ex.message}" }
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(
                error(
                    code = "invalid_param",
                    message = "Missing required query parameter '${ex.parameterName}'.",
                ),
            )
    }

    @ExceptionHandler(org.springframework.http.converter.HttpMessageNotReadableException::class)
    fun handleUnreadableBody(ex: org.springframework.http.converter.HttpMessageNotReadableException): ResponseEntity<ErrorResponse> {
        // Most common cause: Jackson can't construct the Kotlin data class because a
        // non-nullable field was missing in the JSON body (e.g. POST {} on a request
        // that requires `date`/`accountId`/etc.). Surface as 400 with the field name.
        // Jackson 2.17+ collapsed `MissingKotlinParameterException` into
        // `MismatchedInputException`; we distinguish missing-field vs wrong-type by the
        // exception message rather than the (removed) subclass.
        val cause = ex.cause
        val (field, kind) =
            if (cause is com.fasterxml.jackson.databind.exc.MismatchedInputException) {
                val fieldName = cause.path.firstOrNull()?.fieldName ?: "<body>"
                val msg = cause.message.orEmpty()
                val isMissing =
                    msg.contains("missing", ignoreCase = true) ||
                        msg.contains("null value", ignoreCase = true) ||
                        msg.contains("non-nullable", ignoreCase = true)
                fieldName to if (isMissing) "missing required field" else "wrong type"
            } else {
                "<body>" to "malformed JSON"
            }
        log.debug { "Unreadable request body: ${ex.message}" }
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(
                error(
                    code = "invalid_input",
                    message = "$field: $kind",
                    details = mapOf("fieldErrors" to listOf(mapOf("field" to field, "message" to kind))),
                ),
            )
    }

    @ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException::class)
    fun handleValidation(ex: org.springframework.web.bind.MethodArgumentNotValidException): ResponseEntity<ErrorResponse> {
        val fieldErrors =
            ex.bindingResult.fieldErrors.map {
                mapOf("field" to it.field, "message" to (it.defaultMessage ?: "invalid"))
            }
        val first = fieldErrors.firstOrNull()
        val message = first?.let { "${it["field"]}: ${it["message"]}" } ?: "Request body validation failed."
        log.debug { "Validation failed: $message" }
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(error(code = "invalid_input", message = message, details = mapOf("fieldErrors" to fieldErrors)))
    }

    @ExceptionHandler(NoResourceFoundException::class)
    fun handleNoResource(ex: NoResourceFoundException): ResponseEntity<ErrorResponse> =
        ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(error("not_found", "No such path: ${ex.resourcePath}"))

    @ExceptionHandler(Exception::class)
    fun handleUnexpected(ex: Exception): ResponseEntity<ErrorResponse> {
        log.error(ex) { "Unexpected error in controller" }
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(error("internal_error", "An unexpected error occurred."))
    }

    private companion object {
        private val log = KotlinLogging.logger {}

        /**
         * Hard cap on the upstream body we echo back in error responses. Monarch's GraphQL
         * error payloads are usually well under 1KB, but a misbehaving 5xx could return an
         * HTML error page; bound the response size so callers/logs stay readable.
         */
        private const val UPSTREAM_BODY_MAX_CHARS = 2000
    }
}
