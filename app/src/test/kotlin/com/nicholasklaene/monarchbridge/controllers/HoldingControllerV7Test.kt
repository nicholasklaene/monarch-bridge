package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.config.GlobalExceptionHandler
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.FAKE_SESSION
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.stubExec
import com.nicholasklaene.monarchbridge.exceptions.MonarchSessionMissingException
import com.nicholasklaene.monarchbridge.generated.model.BulkUpdateHoldingsFailure
import com.nicholasklaene.monarchbridge.generated.model.BulkUpdateHoldingsResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetHoldingTransactionsResponseData
import com.nicholasklaene.monarchbridge.generated.model.HoldingTransactionRow
import com.nicholasklaene.monarchbridge.graphql.MonarchClient
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.context.annotation.Import
import org.springframework.http.MediaType
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(HoldingController::class)
@Import(GlobalExceptionHandler::class)
class HoldingControllerV7Test {
    @Autowired private lateinit var mvc: MockMvc

    @MockitoBean private lateinit var sessionService: MonarchSessionService

    @MockitoBean private lateinit var client: MonarchClient

    @Test
    fun `getHoldingTransactions returns buy and dividend rows with correct shapes`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetHoldingTransactionsResponseData(
                transactions =
                    listOf(
                        HoldingTransactionRow(
                            id = "ht1",
                            date = "2026-05-01",
                            type = "buy",
                            quantity = 10.0,
                            price = 150.25,
                            amount = -1502.50,
                            fees = 0.0,
                            notes = "initial buy",
                        ),
                        HoldingTransactionRow(id = "ht2", date = "2026-05-15", type = "dividend", amount = 12.40),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/holdings/h1/transactions"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.transactions[0].id").value("ht1"))
            .andExpect(jsonPath("$.data.transactions[0].type").value("buy"))
            .andExpect(jsonPath("$.data.transactions[0].amount").value(-1502.50))
            .andExpect(jsonPath("$.data.transactions[0].notes").value("initial buy"))
            .andExpect(jsonPath("$.data.transactions[1].type").value("dividend"))
            .andExpect(jsonPath("$.data.transactions[1].amount").value(12.40))
    }

    @Test
    fun `getHoldingTransactions returns 503 when session missing`() {
        `when`(sessionService.requireCurrent()).thenThrow(MonarchSessionMissingException())
        mvc
            .perform(get("/v1/holdings/h1/transactions"))
            .andExpect(status().isServiceUnavailable)
            .andExpect(jsonPath("$.code").value("session_missing"))
    }

    @Test
    fun `bulkUpdateHoldings reports partial success with failed-row reasons`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            BulkUpdateHoldingsResponseData(
                updatedCount = 8,
                failedCount = 2,
                failures =
                    listOf(
                        BulkUpdateHoldingsFailure(holdingId = "h-bad-1", reason = "quantity_negative"),
                        BulkUpdateHoldingsFailure(holdingId = "h-bad-2", reason = "not_owned"),
                    ),
            ),
        )
        mvc
            .perform(
                patch("/v1/holdings/bulk")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"updates":[{"holdingId":"h1","quantity":10.0,"costBasis":1500.0}]}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.updatedCount").value(8))
            .andExpect(jsonPath("$.data.failedCount").value(2))
            .andExpect(jsonPath("$.data.failures[0].holdingId").value("h-bad-1"))
            .andExpect(jsonPath("$.data.failures[0].reason").value("quantity_negative"))
            .andExpect(jsonPath("$.data.failures[1].reason").value("not_owned"))
    }

    @Test
    fun `bulkUpdateHoldings returns 400 when updates field missing`() {
        // `updates` is required in the spec; an empty body must fail validation.
        mvc
            .perform(
                patch("/v1/holdings/bulk")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{}"""),
            ).andExpect(status().isBadRequest)
            .andExpect(jsonPath("$.code").value("invalid_input"))
    }

    @Test
    fun `bulkUpdateHoldings returns 503 when session missing`() {
        `when`(sessionService.requireCurrent()).thenThrow(MonarchSessionMissingException())
        mvc
            .perform(
                patch("/v1/holdings/bulk")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"updates":[{"holdingId":"h1"}]}"""),
            ).andExpect(status().isServiceUnavailable)
            .andExpect(jsonPath("$.code").value("session_missing"))
    }
}
