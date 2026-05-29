package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.config.GlobalExceptionHandler
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.FAKE_SESSION
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.stubExec
import com.nicholasklaene.monarchbridge.exceptions.MonarchSessionMissingException
import com.nicholasklaene.monarchbridge.generated.model.GetTaxBracketEstimatesResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetTaxYearOverviewResponseData
import com.nicholasklaene.monarchbridge.generated.model.TaxBracket
import com.nicholasklaene.monarchbridge.generated.model.TaxBracketEstimates
import com.nicholasklaene.monarchbridge.generated.model.TaxScheduleSummary
import com.nicholasklaene.monarchbridge.generated.model.TaxYearOverview
import com.nicholasklaene.monarchbridge.graphql.MonarchClient
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(TaxController::class)
@Import(GlobalExceptionHandler::class)
class TaxControllerV7Test {
    @Autowired private lateinit var mvc: MockMvc

    @MockitoBean private lateinit var sessionService: MonarchSessionService

    @MockitoBean private lateinit var client: MonarchClient

    @Test
    fun `getTaxYearOverview returns totals plus per-schedule summaries`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetTaxYearOverviewResponseData(
                overview =
                    TaxYearOverview(
                        taxYear = 2025,
                        totalIncome = 120000.0,
                        totalDeductions = -22000.0,
                        estimatedTax = 18500.0,
                        transactionCount = 342,
                        scheduleSummaries =
                            listOf(
                                TaxScheduleSummary(schedule = "SCHEDULE_C", total = -12500.0, lineItemCount = 18),
                                TaxScheduleSummary(schedule = "SCHEDULE_E", total = -9500.0, lineItemCount = 7),
                            ),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/tax/year-overview").param("taxYear", "2025"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.overview.taxYear").value(2025))
            .andExpect(jsonPath("$.data.overview.totalIncome").value(120000.0))
            .andExpect(jsonPath("$.data.overview.scheduleSummaries[0].schedule").value("SCHEDULE_C"))
            .andExpect(jsonPath("$.data.overview.scheduleSummaries[0].lineItemCount").value(18))
            .andExpect(jsonPath("$.data.overview.scheduleSummaries[1].schedule").value("SCHEDULE_E"))
    }

    @Test
    fun `getTaxYearOverview returns 400 when taxYear missing`() {
        // taxYear is a required query param.
        mvc
            .perform(get("/v1/tax/year-overview"))
            .andExpect(status().isBadRequest)
    }

    @Test
    fun `getTaxYearOverview returns 503 when session missing`() {
        `when`(sessionService.requireCurrent()).thenThrow(MonarchSessionMissingException())
        mvc
            .perform(get("/v1/tax/year-overview").param("taxYear", "2025"))
            .andExpect(status().isServiceUnavailable)
            .andExpect(jsonPath("$.code").value("session_missing"))
    }

    @Test
    fun `getTaxBracketEstimates returns marginal rate and per-bracket rows`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetTaxBracketEstimatesResponseData(
                estimates =
                    TaxBracketEstimates(
                        taxYear = 2025,
                        filingStatus = "single",
                        estimatedAgi = 85000.0,
                        marginalRate = 0.22,
                        effectiveRate = 0.135,
                        brackets =
                            listOf(
                                TaxBracket(lowerBound = 0.0, upperBound = 11600.0, rate = 0.10, taxOwed = 1160.0),
                                TaxBracket(lowerBound = 11600.0, upperBound = 47150.0, rate = 0.12, taxOwed = 4266.0),
                            ),
                    ),
            ),
        )
        mvc
            .perform(
                get("/v1/tax/bracket-estimates")
                    .param("taxYear", "2025")
                    .param("filingStatus", "single"),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.estimates.filingStatus").value("single"))
            .andExpect(jsonPath("$.data.estimates.marginalRate").value(0.22))
            .andExpect(jsonPath("$.data.estimates.effectiveRate").value(0.135))
            .andExpect(jsonPath("$.data.estimates.brackets[0].rate").value(0.10))
            .andExpect(jsonPath("$.data.estimates.brackets[1].taxOwed").value(4266.0))
    }

    @Test
    fun `getTaxBracketEstimates works without optional filingStatus (default to household)`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetTaxBracketEstimatesResponseData(
                estimates = TaxBracketEstimates(taxYear = 2025, brackets = emptyList()),
            ),
        )
        mvc
            .perform(get("/v1/tax/bracket-estimates").param("taxYear", "2025"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.estimates.taxYear").value(2025))
    }

    // NOTE: spec-side enum-on-query-param validation is a follow-up. The current spec accepts
    // free-form strings for filingStatus; tightening the spec to `enum: [single, married_joint, ...]`
    // is tracked separately so the 400-on-bad-enum test becomes meaningful again.
}
