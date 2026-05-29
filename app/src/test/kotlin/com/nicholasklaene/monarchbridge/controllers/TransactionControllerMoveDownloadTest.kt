package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.config.GlobalExceptionHandler
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.FAKE_SESSION
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.stubExec
import com.nicholasklaene.monarchbridge.exceptions.MonarchSessionMissingException
import com.nicholasklaene.monarchbridge.generated.model.GetDownloadTransactionsSessionResponseData
import com.nicholasklaene.monarchbridge.generated.model.MatchSearchTransactionsResponseData
import com.nicholasklaene.monarchbridge.generated.model.MatchSearchTransactionsResponseDataResultsInner
import com.nicholasklaene.monarchbridge.generated.model.MoveTransactionsResponseData
import com.nicholasklaene.monarchbridge.generated.model.StartDownloadTransactionsResponseData
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

@WebMvcTest(TransactionController::class)
@Import(GlobalExceptionHandler::class)
class TransactionControllerMoveDownloadTest {
    @Autowired private lateinit var mvc: MockMvc

    @MockitoBean private lateinit var sessionService: MonarchSessionService

    @MockitoBean private lateinit var client: MonarchClient

    @Test
    fun `moveTransactions returns count and any errors`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, MoveTransactionsResponseData(numTransactionsMoved = 2, errors = null))
        mvc
            .perform(
                post("/v1/transactions/move")
                    .contentType("application/json")
                    .content("""{"transactionIds": ["t-1","t-2"], "toAccountId": "a-1"}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.numTransactionsMoved").value(2))
    }

    @Test
    fun `moveTransactions returns 503 when session missing`() {
        `when`(sessionService.requireCurrent()).thenThrow(MonarchSessionMissingException())
        mvc
            .perform(
                post("/v1/transactions/move")
                    .contentType("application/json")
                    .content("""{"transactionIds": ["t-1"], "toAccountId": "a-1"}"""),
            ).andExpect(status().isServiceUnavailable)
    }

    @Test
    fun `matchSearchTransactions returns trimmed result rows`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            MatchSearchTransactionsResponseData(
                results =
                    listOf(
                        MatchSearchTransactionsResponseDataResultsInner(
                            id = "t-1",
                            amount = -12.34,
                            date = "2026-05-26",
                            plaidName = "STARBUCKS",
                        ),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/transactions/match-search").param("search", "starbucks").param("limit", "20"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.results[0].id").value("t-1"))
            .andExpect(jsonPath("$.data.results[0].plaidName").value("STARBUCKS"))
    }

    @Test
    fun `startDownloadTransactions returns sessionKey + status`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            StartDownloadTransactionsResponseData(sessionKey = "sk-1", status = "RUNNING"),
        )
        mvc
            .perform(
                post("/v1/transactions/download")
                    .contentType("application/json")
                    .content("""{"filters": {}}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.sessionKey").value("sk-1"))
            .andExpect(jsonPath("$.data.status").value("RUNNING"))
    }

    @Test
    fun `getDownloadTransactionsSession returns url when complete`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetDownloadTransactionsSessionResponseData(
                sessionKey = "sk-1",
                status = "COMPLETE",
                url = "https://x/file.csv",
            ),
        )
        mvc
            .perform(get("/v1/transactions/download/sk-1"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.url").value("https://x/file.csv"))
    }
}
