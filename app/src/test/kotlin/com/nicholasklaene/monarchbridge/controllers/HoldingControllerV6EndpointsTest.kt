package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.config.GlobalExceptionHandler
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.FAKE_SESSION
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.stubExec
import com.nicholasklaene.monarchbridge.generated.model.GetHoldingHistoryResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetSecurityDetailsResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetSecurityDividendsResponseData
import com.nicholasklaene.monarchbridge.generated.model.HoldingHistoryPoint
import com.nicholasklaene.monarchbridge.generated.model.SecurityDetails
import com.nicholasklaene.monarchbridge.generated.model.SecurityDividend
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
import java.time.LocalDate

/**
 * R6 holdings/securities read endpoints on [HoldingController]:
 *  GET /v1/holdings/{id}/history       getHoldingHistory
 *  GET /v1/securities/{id}             getSecurityDetails
 *  GET /v1/securities/{id}/dividends   getSecurityDividends
 */
@WebMvcTest(HoldingController::class)
@Import(GlobalExceptionHandler::class)
class HoldingControllerV6EndpointsTest {
    @Autowired private lateinit var mvc: MockMvc

    @MockitoBean private lateinit var sessionService: MonarchSessionService

    @MockitoBean private lateinit var client: MonarchClient

    @Test
    fun `getHoldingHistory wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetHoldingHistoryResponseData(
                history =
                    listOf(
                        HoldingHistoryPoint(
                            date = LocalDate.parse("2026-04-01"),
                            quantity = 100.0,
                            value = 5000.0,
                            price = 50.0,
                        ),
                        HoldingHistoryPoint(
                            date = LocalDate.parse("2026-04-02"),
                            quantity = 100.0,
                            value = 5050.0,
                            price = 50.5,
                        ),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/holdings/h-1/history?start=2026-04-01&end=2026-04-30"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.history[0].date").value("2026-04-01"))
            .andExpect(jsonPath("$.data.history[0].quantity").value(100.0))
            .andExpect(jsonPath("$.data.history[1].price").value(50.5))
    }

    @Test
    fun `getSecurityDetails wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetSecurityDetailsResponseData(
                security =
                    SecurityDetails(
                        id = "sec-1",
                        ticker = "AAPL",
                        name = "Apple Inc",
                        type = "EQUITY",
                        currentPrice = 180.0,
                        sector = "Technology",
                        industry = "Consumer Electronics",
                    ),
            ),
        )
        mvc
            .perform(get("/v1/securities/sec-1"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.security.id").value("sec-1"))
            .andExpect(jsonPath("$.data.security.ticker").value("AAPL"))
            .andExpect(jsonPath("$.data.security.sector").value("Technology"))
    }

    @Test
    fun `getSecurityDividends wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetSecurityDividendsResponseData(
                dividends =
                    listOf(
                        SecurityDividend(
                            date = LocalDate.parse("2026-03-15"),
                            amount = 0.24,
                            type = "regular",
                        ),
                        SecurityDividend(
                            date = LocalDate.parse("2026-01-15"),
                            amount = 1.0,
                            type = "special",
                        ),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/securities/sec-1/dividends?start=2026-01-01&end=2026-04-01"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.dividends[0].date").value("2026-03-15"))
            .andExpect(jsonPath("$.data.dividends[0].amount").value(0.24))
            .andExpect(jsonPath("$.data.dividends[1].type").value("special"))
    }
}
