package com.nicholasklaene.monarchbridge.config

import com.nicholasklaene.monarchbridge.exceptions.MonarchRateLimitedException
import com.nicholasklaene.monarchbridge.exceptions.MonarchRequestFailedException
import com.nicholasklaene.monarchbridge.exceptions.MonarchSessionExpiredException
import com.nicholasklaene.monarchbridge.exceptions.MonarchSessionMissingException
import com.nicholasklaene.monarchbridge.exceptions.PayloadErrorException
import com.nicholasklaene.monarchbridge.graphql.PayloadError
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.springframework.http.HttpStatus
import org.springframework.web.servlet.resource.NoResourceFoundException

/**
 * Direct unit tests for every [GlobalExceptionHandler] method — call the handlers in-process
 * with a constructed exception and assert the ResponseEntity. This sidesteps MockMvc setup
 * and gives clean per-branch coverage of the handler.
 */
class GlobalExceptionHandlerTest {
    private val handler = GlobalExceptionHandler()

    @Test
    fun `handleSessionMissing returns 503 with session_missing code`() {
        val response = handler.handleSessionMissing(MonarchSessionMissingException())
        assertThat(response.statusCode).isEqualTo(HttpStatus.SERVICE_UNAVAILABLE)
        assertThat(response.body?.code).isEqualTo("session_missing")
    }

    @Test
    fun `handleSessionExpired returns 401 with session_expired code`() {
        val response = handler.handleSessionExpired(MonarchSessionExpiredException())
        assertThat(response.statusCode).isEqualTo(HttpStatus.UNAUTHORIZED)
        assertThat(response.body?.code).isEqualTo("session_expired")
    }

    @Test
    fun `handleRateLimited with retry-after sets header + detail`() {
        val response = handler.handleRateLimited(MonarchRateLimitedException(45L))
        assertThat(response.statusCode).isEqualTo(HttpStatus.TOO_MANY_REQUESTS)
        assertThat(response.headers.getFirst("Retry-After")).isEqualTo("45")
        assertThat(response.body?.code).isEqualTo("rate_limited")
        assertThat(response.body?.details?.get("retry_after_seconds")).isEqualTo(45L)
    }

    @Test
    fun `handleRateLimited without retry-after omits header`() {
        val response = handler.handleRateLimited(MonarchRateLimitedException(null))
        assertThat(response.statusCode).isEqualTo(HttpStatus.TOO_MANY_REQUESTS)
        assertThat(response.headers.getFirst("Retry-After")).isNull()
        assertThat(response.body?.code).isEqualTo("rate_limited")
    }

    @Test
    fun `handleRequestFailed returns 502 with upstream details and body`() {
        val response = handler.handleRequestFailed(MonarchRequestFailedException(500, "body", "Upstream failed"))
        assertThat(response.statusCode).isEqualTo(HttpStatus.BAD_GATEWAY)
        assertThat(response.body?.code).isEqualTo("monarch_request_failed")
        assertThat(response.body?.details?.get("upstream_status")).isEqualTo(500)
        assertThat(response.body?.details?.get("upstream_body")).isEqualTo("body")
    }

    @Test
    fun `handleRequestFailed omits upstream_body when body is blank`() {
        val response = handler.handleRequestFailed(MonarchRequestFailedException(400, "", "Upstream failed"))
        assertThat(response.body?.details?.get("upstream_status")).isEqualTo(400)
        assertThat(response.body?.details).doesNotContainKey("upstream_body")
    }

    @Test
    fun `handleRequestFailed truncates large upstream bodies to 2000 chars`() {
        val huge = "x".repeat(5000)
        val response = handler.handleRequestFailed(MonarchRequestFailedException(502, huge, "Upstream failed"))
        val echoed = response.body?.details?.get("upstream_body") as? String
        assertThat(echoed).isNotNull()
        assertThat(echoed!!.length).isEqualTo(2000)
    }

    @Test
    fun `handlePayloadError returns 422 with structured details`() {
        val err =
            PayloadError(
                message = "bad",
                code = "INVALID",
                fieldErrors = listOf(PayloadError.FieldError(field = "x", messages = listOf("required"))),
            )
        val response = handler.handlePayloadError(PayloadErrorException("doThing", listOf(err)))
        assertThat(response.statusCode).isEqualTo(HttpStatus.UNPROCESSABLE_ENTITY)
        assertThat(response.body?.code).isEqualTo("INVALID")
        assertThat(response.body?.message).isEqualTo("bad")
        assertThat(response.body?.details?.get("mutation")).isEqualTo("doThing")
    }

    @Test
    fun `handlePayloadError with empty error list falls back to default code+message`() {
        val response = handler.handlePayloadError(PayloadErrorException("emptyOp", emptyList()))
        assertThat(response.body?.code).isEqualTo("payload_error")
        assertThat(response.body?.message).isEqualTo("Monarch returned application errors.")
    }

    @Test
    fun `handleIllegalArgument returns 400`() {
        val response = handler.handleIllegalArgument(IllegalArgumentException("bad input"))
        assertThat(response.statusCode).isEqualTo(HttpStatus.BAD_REQUEST)
        assertThat(response.body?.code).isEqualTo("invalid_input")
        assertThat(response.body?.message).isEqualTo("bad input")
    }

    @Test
    fun `handleIllegalArgument with null message uses default`() {
        val response = handler.handleIllegalArgument(IllegalArgumentException())
        assertThat(response.body?.message).isEqualTo("Invalid input.")
    }

    @Test
    fun `handleBadParam returns 400 invalid_param with name + expected type`() {
        val ex = mock(org.springframework.web.method.annotation.MethodArgumentTypeMismatchException::class.java)
        `when`(ex.name).thenReturn("start")
        `when`(ex.value).thenReturn("not-a-date")
        `when`(ex.requiredType).thenAnswer { java.time.LocalDate::class.java }
        val response = handler.handleBadParam(ex)
        assertThat(response.statusCode).isEqualTo(HttpStatus.BAD_REQUEST)
        assertThat(response.body?.code).isEqualTo("invalid_param")
        assertThat(response.body?.message).contains("start").contains("LocalDate")
    }

    @Test
    fun `handleNoResource returns 404 with resourcePath`() {
        val ex = mock(NoResourceFoundException::class.java)
        `when`(ex.resourcePath).thenReturn("/foo/bar")
        val response = handler.handleNoResource(ex)
        assertThat(response.statusCode).isEqualTo(HttpStatus.NOT_FOUND)
        assertThat(response.body?.code).isEqualTo("not_found")
        assertThat(response.body?.message).contains("/foo/bar")
    }

    @Test
    fun `handleUnexpected returns 500 with generic message`() {
        @Suppress("TooGenericExceptionThrown")
        val response = handler.handleUnexpected(RuntimeException("boom"))
        assertThat(response.statusCode).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR)
        assertThat(response.body?.code).isEqualTo("internal_error")
        assertThat(response.body?.message).isEqualTo("An unexpected error occurred.")
    }

    @Test
    fun `handleValidation maps field errors to invalid_input 400`() {
        val bindingResult = mock(org.springframework.validation.BindingResult::class.java)
        val fieldError = org.springframework.validation.FieldError("body", "name", "must not be blank")
        `when`(bindingResult.fieldErrors).thenReturn(listOf(fieldError))
        val ex = mock(org.springframework.web.bind.MethodArgumentNotValidException::class.java)
        `when`(ex.bindingResult).thenReturn(bindingResult)

        val response = handler.handleValidation(ex)
        assertThat(response.statusCode).isEqualTo(HttpStatus.BAD_REQUEST)
        assertThat(response.body?.code).isEqualTo("invalid_input")
        assertThat(response.body?.message).contains("name").contains("must not be blank")
    }

    @Test
    fun `handleValidation empty errors uses fallback message`() {
        val bindingResult = mock(org.springframework.validation.BindingResult::class.java)
        `when`(bindingResult.fieldErrors).thenReturn(emptyList())
        val ex = mock(org.springframework.web.bind.MethodArgumentNotValidException::class.java)
        `when`(ex.bindingResult).thenReturn(bindingResult)

        val response = handler.handleValidation(ex)
        assertThat(response.body?.message).isEqualTo("Request body validation failed.")
    }

    @Test
    fun `handleUnreadableBody surfaces missing kotlin parameter`() {
        // Trigger a real Jackson failure — empty JSON for a non-null Kotlin field.
        // This produces the actual MissingKotlinParameterException without us instantiating it.
        val mapper =
            com.fasterxml.jackson.databind
                .ObjectMapper()
                .registerModule(
                    com.fasterxml.jackson.module.kotlin
                        .kotlinModule(),
                )
        val cause: Throwable =
            try {
                mapper.readValue("{}", SampleNonNullBody::class.java)
                error("expected throw")
            } catch (jacksonEx: com.fasterxml.jackson.databind.JsonMappingException) {
                jacksonEx
            }
        val ex =
            org.springframework.http.converter.HttpMessageNotReadableException(
                "x",
                cause,
                mock(org.springframework.http.HttpInputMessage::class.java),
            )
        val response = handler.handleUnreadableBody(ex)
        assertThat(response.statusCode).isEqualTo(HttpStatus.BAD_REQUEST)
        assertThat(response.body?.code).isEqualTo("invalid_input")
        assertThat(response.body?.message).contains("missing required field")
    }

    @Test
    fun `handleUnreadableBody surfaces wrong field type as 400`() {
        val mapper =
            com.fasterxml.jackson.databind
                .ObjectMapper()
                .registerModule(
                    com.fasterxml.jackson.module.kotlin
                        .kotlinModule(),
                )
        val cause: Throwable =
            try {
                mapper.readValue("""{"date":[1,2,3]}""", SampleNonNullBody::class.java)
                error("expected throw")
            } catch (jacksonEx: com.fasterxml.jackson.databind.exc.MismatchedInputException) {
                jacksonEx
            }
        val ex =
            org.springframework.http.converter.HttpMessageNotReadableException(
                "x",
                cause,
                mock(org.springframework.http.HttpInputMessage::class.java),
            )
        val response = handler.handleUnreadableBody(ex)
        assertThat(response.body?.message).contains("wrong type")
    }

    @Test
    fun `handleUnreadableBody falls back to malformed JSON when cause is unknown`() {
        val ex =
            org.springframework.http.converter.HttpMessageNotReadableException(
                "x",
                RuntimeException("random"),
                mock(org.springframework.http.HttpInputMessage::class.java),
            )
        val response = handler.handleUnreadableBody(ex)
        assertThat(response.body?.message).contains("malformed JSON")
    }

    /** Fixture: non-nullable Kotlin field used to trigger MissingKotlinParameterException. */
    private data class SampleNonNullBody(
        val date: String,
    )

    @Test
    fun `handleBadParam falls back to questionmark when requiredType is null`() {
        val ex = mock(org.springframework.web.method.annotation.MethodArgumentTypeMismatchException::class.java)
        `when`(ex.name).thenReturn("foo")
        `when`(ex.requiredType).thenReturn(null)
        val response = handler.handleBadParam(ex)
        assertThat(response.body?.message).contains("foo").contains("?")
    }
}
