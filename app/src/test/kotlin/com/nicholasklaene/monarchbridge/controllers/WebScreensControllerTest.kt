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
 * Slice test for [WebScreensController]. Hits one query-bucket route and one
 * mutation-bucket route to prove dispatch + envelope wrapping + 503-on-no-session
 * gating works for the generated 200+ endpoints. The per-operation parse/variables
 * contract is exercised in [com.nicholasklaene.monarchbridge.graphql.operations.web.WebOperationsTest].
 */
@WebMvcTest(WebScreensController::class)
@Import(GlobalExceptionHandler::class)
class WebScreensControllerTest {
    @Autowired private lateinit var mvc: MockMvc

    @MockitoBean private lateinit var sessionService: MonarchSessionService

    @MockitoBean private lateinit var client: MonarchClient

    @Test
    fun `query route Web_AccountDetailsRouter_getAccountType wraps Monarch data in FreeForm response envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, mapOf("anything" to "goes"))

        mvc
            .perform(
                post("/v1/web/screens/account-details-router-get-account-type")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"variables": {}}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.anything").value("goes"))
    }

    @Test
    fun `query route Web_AccountDetailsRouter_getAccountType returns 503 when no session`() {
        `when`(sessionService.requireCurrent()).thenThrow(MonarchSessionMissingException())

        mvc
            .perform(
                post("/v1/web/screens/account-details-router-get-account-type")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{}"),
            ).andExpect(status().isServiceUnavailable)
            .andExpect(jsonPath("$.code").value("session_missing"))
    }

    @Test
    fun `mutation route Web_AnswerQuestionMutation wraps Monarch data in FreeForm response envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, mapOf("anything" to "goes"))

        mvc
            .perform(
                post("/v1/web/aggregates/answer-question-mutation")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"variables": {}}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.anything").value("goes"))
    }

    @Test
    fun `mutation route Web_AnswerQuestionMutation returns 503 when no session`() {
        `when`(sessionService.requireCurrent()).thenThrow(MonarchSessionMissingException())

        mvc
            .perform(
                post("/v1/web/aggregates/answer-question-mutation")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{}"),
            ).andExpect(status().isServiceUnavailable)
            .andExpect(jsonPath("$.code").value("session_missing"))
    }
}
