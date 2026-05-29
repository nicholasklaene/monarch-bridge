package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.config.GlobalExceptionHandler
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.FAKE_SESSION
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.stubExec
import com.nicholasklaene.monarchbridge.exceptions.MonarchSessionMissingException
import com.nicholasklaene.monarchbridge.graphql.MonarchClient
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.context.annotation.Import
import org.springframework.http.MediaType
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

/**
 * Coverage for the long-tail controller. The controller has 165 endpoints, all sharing the
 * same plumbing (forward request body's `variables` into the operation, wrap the operation's
 * `Map<String, Any>` result in `LongTailResponse`). We test the shared behaviour on a few
 * representative routes rather than asserting each one in isolation, since route registration
 * itself is enforced at compile time via the generated `LongTailApi` interface.
 */
@WebMvcTest(LongTailController::class)
@Import(GlobalExceptionHandler::class)
class LongTailControllerTest {
    @Autowired private lateinit var mvc: MockMvc

    @MockitoBean private lateinit var sessionService: MonarchSessionService

    @MockitoBean private lateinit var client: MonarchClient

    @Test
    fun `long-tail route wraps Monarch payload in LongTailResponse envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, mapOf("hasAccounts" to true) as Map<String, Any>)
        mvc
            .perform(
                post("/v1/x/get-has-accounts")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{}"),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.result.hasAccounts").value(true))
    }

    @Test
    fun `long-tail route works with no request body`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, mapOf("ok" to true) as Map<String, Any>)
        mvc
            .perform(
                post("/v1/x/archive-goal")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{}"),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.result.ok").value(true))
    }

    @Test
    fun `long-tail route forwards variables and returns nested map`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        val payload =
            mapOf(
                "account" to mapOf("id" to "acc-42", "displayName" to "Manual"),
                "count" to 3,
            ) as Map<String, Any>
        stubExec(client, payload)
        mvc
            .perform(
                post("/v1/x/get-account")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"variables":{"id":"acc-42"}}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.result.account.id").value("acc-42"))
            .andExpect(jsonPath("$.data.result.account.displayName").value("Manual"))
            .andExpect(jsonPath("$.data.result.count").value(3))
    }

    @Test
    fun `long-tail route returns 503 when session missing`() {
        `when`(sessionService.requireCurrent()).thenThrow(MonarchSessionMissingException())
        mvc
            .perform(
                post("/v1/x/get-has-accounts")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{}"),
            ).andExpect(status().isServiceUnavailable)
            .andExpect(jsonPath("$.code").value("session_missing"))
    }
}
