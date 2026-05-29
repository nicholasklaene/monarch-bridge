package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.config.GlobalExceptionHandler
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.FAKE_SESSION
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.stubExec
import com.nicholasklaene.monarchbridge.exceptions.MonarchSessionMissingException
import com.nicholasklaene.monarchbridge.generated.model.ExplainTransactionResponseData
import com.nicholasklaene.monarchbridge.generated.model.MarkTransactionAsReviewedResponseData
import com.nicholasklaene.monarchbridge.graphql.MonarchClient
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

/**
 * WebMvc slice for [TransactionController]'s v4 endpoints: mark-as-reviewed and the
 * canonical `/v1/transactions/{id}/explain` path.
 */
@WebMvcTest(TransactionController::class)
@Import(GlobalExceptionHandler::class)
class TransactionControllerNewEndpointsTest {
    @Autowired private lateinit var mvc: MockMvc

    @MockitoBean private lateinit var sessionService: MonarchSessionService

    @MockitoBean private lateinit var client: MonarchClient

    @Test
    fun `markTransactionAsReviewed returns id and reviewedAt envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            MarkTransactionAsReviewedResponseData(
                id = "txn-1",
                reviewedAt = "2026-05-26T18:00:00Z",
                needsReview = false,
            ),
        )

        mvc
            .perform(post("/v1/transactions/txn-1/reviewed"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.id").value("txn-1"))
            .andExpect(jsonPath("$.data.reviewedAt").value("2026-05-26T18:00:00Z"))
            .andExpect(jsonPath("$.data.needsReview").value(false))
    }

    @Test
    fun `markTransactionAsReviewed returns 503 when session missing`() {
        `when`(sessionService.requireCurrent()).thenThrow(MonarchSessionMissingException())

        mvc
            .perform(post("/v1/transactions/txn-1/reviewed"))
            .andExpect(status().isServiceUnavailable)
            .andExpect(jsonPath("$.code").value("session_missing"))
    }

    @Test
    fun `explainTransactionByPath returns explanation at canonical path`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            ExplainTransactionResponseData(explanation = "Auto-categorized as Coffee."),
        )

        mvc
            .perform(get("/v1/transactions/txn-1/explain"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.explanation").value("Auto-categorized as Coffee."))
    }

    @Test
    fun `explainTransactionByPath surfaces null explanation when Monarch has none`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, ExplainTransactionResponseData(explanation = null))

        mvc
            .perform(get("/v1/transactions/txn-1/explain"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.explanation").doesNotExist())
    }
}
