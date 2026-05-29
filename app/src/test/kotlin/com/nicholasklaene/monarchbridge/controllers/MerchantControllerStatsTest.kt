package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.config.GlobalExceptionHandler
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.FAKE_SESSION
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.stubExec
import com.nicholasklaene.monarchbridge.exceptions.MonarchSessionMissingException
import com.nicholasklaene.monarchbridge.generated.model.GetMerchantStatsResponseData
import com.nicholasklaene.monarchbridge.generated.model.MerchantStats
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

@WebMvcTest(MerchantController::class)
@Import(GlobalExceptionHandler::class)
class MerchantControllerStatsTest {
    @Autowired private lateinit var mvc: MockMvc

    @MockitoBean private lateinit var sessionService: MonarchSessionService

    @MockitoBean private lateinit var client: MonarchClient

    @Test
    fun `getMerchantStats returns aggregate totals and first-last seen`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetMerchantStatsResponseData(
                stats =
                    MerchantStats(
                        merchantId = "m1",
                        totalSpend = -1842.50,
                        transactionCount = 42,
                        averageTransaction = -43.87,
                        firstSeen = "2024-08-15",
                        lastSeen = "2026-05-20",
                        monthsActive = 21,
                    ),
            ),
        )
        mvc
            .perform(get("/v1/merchants/m1/stats"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.stats.merchantId").value("m1"))
            .andExpect(jsonPath("$.data.stats.totalSpend").value(-1842.50))
            .andExpect(jsonPath("$.data.stats.transactionCount").value(42))
            .andExpect(jsonPath("$.data.stats.firstSeen").value("2024-08-15"))
            .andExpect(jsonPath("$.data.stats.monthsActive").value(21))
    }

    @Test
    fun `getMerchantStats returns 503 when session missing`() {
        `when`(sessionService.requireCurrent()).thenThrow(MonarchSessionMissingException())
        mvc
            .perform(get("/v1/merchants/m1/stats"))
            .andExpect(status().isServiceUnavailable)
            .andExpect(jsonPath("$.code").value("session_missing"))
    }
}
