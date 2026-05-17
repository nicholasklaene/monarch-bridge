package com.nicholasklaene.monarchproxy.controllers

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.JsonNodeFactory
import com.nicholasklaene.monarchproxy.config.GlobalExceptionHandler
import com.nicholasklaene.monarchproxy.models.MonarchSession
import com.nicholasklaene.monarchproxy.services.MonarchClient
import com.nicholasklaene.monarchproxy.services.MonarchSessionService
import org.junit.jupiter.api.Test
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.context.annotation.Import
import org.springframework.http.MediaType
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.time.Instant

/**
 * Controller-slice tests for [MonarchController] — healthz, auth, and session-guard.
 *
 * See [MonarchControllerDataTest] for data-endpoint and exception-mapping tests.
 *
 * Mockito + Kotlin: static matchers like anyString() return null in Kotlin (non-nullable).
 * Use the [anyStr] / [anyVariables] helpers defined in [MonarchControllerDataTest.Companion].
 */
@WebMvcTest(MonarchController::class)
@Import(GlobalExceptionHandler::class)
class MonarchControllerTest {
    @Autowired
    private lateinit var mvc: MockMvc

    @MockitoBean
    private lateinit var monarchClient: MonarchClient

    @MockitoBean
    private lateinit var monarchSessionService: MonarchSessionService

    companion object {
        internal val FAKE_SESSION =
            MonarchSession(
                token = "fake-token",
                email = "test@example.com",
                lastVerifiedAt = Instant.parse("2026-05-03T10:00:00Z"),
            )

        internal fun dataNode(field: String = "result"): JsonNode {
            val node = JsonNodeFactory.instance.objectNode()
            node.put(field, "ok")
            return node
        }

        /** Kotlin-safe Mockito anyString() — returns "" rather than null. */
        internal fun anyStr(): String = org.mockito.ArgumentMatchers.any(String::class.java) ?: ""

        /** Kotlin-safe Mockito anyMap() for executeGraphQL variables. */
        @Suppress("UNCHECKED_CAST")
        internal fun anyVariables(): Map<String, Any?> =
            org.mockito.ArgumentMatchers.any(Map::class.java) as? Map<String, Any?> ?: emptyMap()
    }

    // -----------------------------------------------------------------------------------------
    // GET /healthz
    // -----------------------------------------------------------------------------------------

    @Test
    fun `healthz returns 200 with authenticated false when no session`() {
        `when`(monarchSessionService.current()).thenReturn(null)

        mvc
            .perform(get("/healthz").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.status").value("UP"))
            .andExpect(jsonPath("$.authenticated").value(false))
            .andExpect(jsonPath("$.lastVerifiedAt").doesNotExist())
    }

    @Test
    fun `healthz returns 200 with authenticated true when session present`() {
        `when`(monarchSessionService.current()).thenReturn(FAKE_SESSION)

        mvc
            .perform(get("/healthz").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.status").value("UP"))
            .andExpect(jsonPath("$.authenticated").value(true))
            .andExpect(jsonPath("$.lastVerifiedAt").value("2026-05-03T10:00:00Z"))
    }

    // -----------------------------------------------------------------------------------------
    // GET /v1/auth/status
    // -----------------------------------------------------------------------------------------

    @Test
    fun `auth status returns correct shape with no session`() {
        `when`(monarchSessionService.current()).thenReturn(null)

        mvc
            .perform(get("/v1/auth/status").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.authenticated").value(false))
            .andExpect(jsonPath("$.email").doesNotExist())
    }

    @Test
    fun `auth status returns correct shape with session`() {
        `when`(monarchSessionService.current()).thenReturn(FAKE_SESSION)

        mvc
            .perform(get("/v1/auth/status").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.authenticated").value(true))
            .andExpect(jsonPath("$.email").value("test@example.com"))
    }

    // -----------------------------------------------------------------------------------------
    // POST /v1/auth/refresh
    // -----------------------------------------------------------------------------------------

    @Test
    fun `auth refresh calls reload and returns updated status`() {
        `when`(monarchSessionService.reload()).thenReturn(FAKE_SESSION)

        mvc
            .perform(post("/v1/auth/refresh").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.authenticated").value(true))
            .andExpect(jsonPath("$.email").value("test@example.com"))

        verify(monarchSessionService).reload()
    }

    @Test
    fun `auth refresh returns unauthenticated when reload returns null`() {
        `when`(monarchSessionService.reload()).thenReturn(null)

        mvc
            .perform(post("/v1/auth/refresh").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.authenticated").value(false))
    }

    // -----------------------------------------------------------------------------------------
    // GET /v1/accounts — session guard
    // -----------------------------------------------------------------------------------------

    @Test
    fun `accounts returns 503 session_missing when no session`() {
        `when`(monarchSessionService.current()).thenReturn(null)

        mvc
            .perform(get("/v1/accounts").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isServiceUnavailable)
            .andExpect(jsonPath("$.code").value("session_missing"))
    }

    @Test
    fun `accounts returns 200 with data wrapper when session present`() {
        `when`(monarchSessionService.current()).thenReturn(FAKE_SESSION)
        `when`(monarchClient.executeGraphQL(anyStr(), anyStr(), anyVariables()))
            .thenReturn(dataNode("accounts"))

        mvc
            .perform(get("/v1/accounts").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.accounts").value("ok"))
    }
}
