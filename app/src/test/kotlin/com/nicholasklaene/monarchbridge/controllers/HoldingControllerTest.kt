package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.config.GlobalExceptionHandler
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.FAKE_SESSION
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.stubExec
import com.nicholasklaene.monarchbridge.exceptions.MonarchSessionMissingException
import com.nicholasklaene.monarchbridge.generated.model.CreateManualAccountResponseData
import com.nicholasklaene.monarchbridge.generated.model.CreateManualHoldingResponseData
import com.nicholasklaene.monarchbridge.generated.model.DeleteAccountResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetPortfolioAllocationByHoldingsResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetPortfolioAllocationHoldingsDetailResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetPortfolioAllocationResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetSecurityHistoricalPerformanceResponseData
import com.nicholasklaene.monarchbridge.generated.model.PortfolioAllocationBucket
import com.nicholasklaene.monarchbridge.generated.model.PortfolioAllocationHolding
import com.nicholasklaene.monarchbridge.generated.model.SearchSecuritiesResponseData
import com.nicholasklaene.monarchbridge.generated.model.Security
import com.nicholasklaene.monarchbridge.generated.model.SecurityHistoricalPoint
import com.nicholasklaene.monarchbridge.generated.model.SecurityHistoricalSummary
import com.nicholasklaene.monarchbridge.generated.model.UpdateHoldingResponseData
import com.nicholasklaene.monarchbridge.graphql.MonarchClient
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.context.annotation.Import
import org.springframework.http.MediaType
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.time.LocalDate

/**
 * MockMvc slice for [HoldingController]. Exercises every HoldingsApi endpoint: manual
 * holding/account CRUD, security search, the four portfolio-allocation endpoints, and
 * per-security historical performance.
 */
@WebMvcTest(HoldingController::class)
@Import(GlobalExceptionHandler::class)
class HoldingControllerTest {
    @Autowired private lateinit var mvc: MockMvc

    @MockitoBean private lateinit var sessionService: MonarchSessionService

    @MockitoBean private lateinit var client: MonarchClient

    @Test
    fun `createManualHolding wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            CreateManualHoldingResponseData(holdingId = "h-new", ticker = "AAPL"),
        )
        mvc
            .perform(
                post("/v1/account/acc-1/holdings")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"securityId":"sec-aapl","quantity":10.0}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.holdingId").value("h-new"))
            .andExpect(jsonPath("$.data.ticker").value("AAPL"))
    }

    @Test
    fun `createManualHolding returns 400 when required field missing`() {
        mvc
            .perform(
                post("/v1/account/acc-1/holdings")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"securityId":"sec-aapl"}"""),
            ).andExpect(status().isBadRequest)
            .andExpect(jsonPath("$.code").value("invalid_input"))
    }

    @Test
    fun `updateHolding wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, UpdateHoldingResponseData(holdingId = "h-1"))
        mvc
            .perform(
                patch("/v1/holdings/h-1")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"quantity":25.0,"userCostBasis":12000.0}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.holdingId").value("h-1"))
    }

    @Test
    fun `deleteHolding wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, DeleteAccountResponseData(deleted = true))
        mvc
            .perform(delete("/v1/holdings/h-1"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.deleted").value(true))
    }

    @Test
    fun `createManualInvestmentsAccount wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, CreateManualAccountResponseData(accountId = "acc-new"))
        mvc
            .perform(
                post("/v1/accounts/manual-investments")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"name":"My Brokerage","subtype":"brokerage"}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.accountId").value("acc-new"))
    }

    @Test
    fun `searchSecurities wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            SearchSecuritiesResponseData(
                securities =
                    listOf(
                        Security(id = "sec-1", name = "Apple Inc.", ticker = "AAPL", type = "equity"),
                        Security(id = "sec-2", name = "Microsoft Corp.", ticker = "MSFT", type = "equity"),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/securities/search").param("q", "tech"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.securities[0].id").value("sec-1"))
            .andExpect(jsonPath("$.data.securities[0].ticker").value("AAPL"))
            .andExpect(jsonPath("$.data.securities[1].ticker").value("MSFT"))
    }

    @Test
    fun `searchSecurities returns 503 when session missing`() {
        `when`(sessionService.requireCurrent()).thenThrow(MonarchSessionMissingException())
        mvc
            .perform(get("/v1/securities/search").param("q", "tech"))
            .andExpect(status().isServiceUnavailable)
            .andExpect(jsonPath("$.code").value("session_missing"))
    }

    @Test
    fun `getPortfolioAllocation wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetPortfolioAllocationResponseData(
                buckets =
                    listOf(
                        PortfolioAllocationBucket(
                            type = "equity",
                            typeDisplay = "Equity",
                            allocationPercent = 0.65,
                            totalValue = 65000.0,
                        ),
                        PortfolioAllocationBucket(
                            type = "fixed_income",
                            typeDisplay = "Fixed Income",
                            allocationPercent = 0.35,
                            totalValue = 35000.0,
                        ),
                    ),
                totalValue = 100000.0,
            ),
        )
        mvc
            .perform(get("/v1/portfolio/allocation"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.totalValue").value(100000.0))
            .andExpect(jsonPath("$.data.buckets[0].type").value("equity"))
            .andExpect(jsonPath("$.data.buckets[1].totalValue").value(35000.0))
    }

    @Test
    fun `getPortfolioAllocationByAccount wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetPortfolioAllocationByHoldingsResponseData(
                buckets =
                    listOf(
                        PortfolioAllocationBucket(
                            type = "acc-1",
                            typeDisplay = "Brokerage",
                            allocationPercent = 1.0,
                            totalValue = 50000.0,
                        ),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/portfolio/allocation/by-account"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.buckets[0].type").value("acc-1"))
    }

    @Test
    fun `getPortfolioAllocationByHoldings wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetPortfolioAllocationByHoldingsResponseData(
                buckets =
                    listOf(
                        PortfolioAllocationBucket(
                            type = "VTI",
                            typeDisplay = "Vanguard Total Stock",
                            allocationPercent = 0.25,
                            totalValue = 25000.0,
                        ),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/portfolio/allocation/by-holdings"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.buckets[0].type").value("VTI"))
    }

    @Test
    fun `getPortfolioAllocationHoldingsDetail wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetPortfolioAllocationHoldingsDetailResponseData(
                holdings =
                    listOf(
                        PortfolioAllocationHolding(
                            securityName = "Apple Inc.",
                            ticker = "AAPL",
                            value = 5000.0,
                        ),
                    ),
                totalCount = 1,
            ),
        )
        mvc
            .perform(
                get("/v1/portfolio/allocation/holdings-detail")
                    .param("classificationField", "type")
                    .param("classificationValue", "equity"),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.totalCount").value(1))
            .andExpect(jsonPath("$.data.holdings[0].securityName").value("Apple Inc."))
            .andExpect(jsonPath("$.data.holdings[0].ticker").value("AAPL"))
    }

    @Test
    fun `getSecurityHistoricalPerformance wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetSecurityHistoricalPerformanceResponseData(
                security =
                    SecurityHistoricalSummary(
                        id = "sec-aapl",
                        currentPrice = 150.0,
                        closingPrice = 148.5,
                    ),
                chart =
                    listOf(
                        SecurityHistoricalPoint(date = LocalDate.parse("2026-05-01"), value = 145.0),
                        SecurityHistoricalPoint(date = LocalDate.parse("2026-05-02"), value = 148.5),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/securities/sec-aapl/performance"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.security.currentPrice").value(150.0))
            .andExpect(jsonPath("$.data.chart[0].date").value("2026-05-01"))
            .andExpect(jsonPath("$.data.chart[1].value").value(148.5))
    }
}
