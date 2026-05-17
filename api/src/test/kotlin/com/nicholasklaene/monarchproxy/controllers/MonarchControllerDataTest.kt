package com.nicholasklaene.monarchproxy.controllers

import com.nicholasklaene.monarchproxy.config.GlobalExceptionHandler
import com.nicholasklaene.monarchproxy.exceptions.MonarchRateLimitedException
import com.nicholasklaene.monarchproxy.exceptions.MonarchRequestFailedException
import com.nicholasklaene.monarchproxy.exceptions.MonarchSessionExpiredException
import com.nicholasklaene.monarchproxy.services.MonarchClient
import com.nicholasklaene.monarchproxy.services.MonarchSessionService
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.context.annotation.Import
import org.springframework.http.MediaType
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.header
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

/**
 * Controller-slice tests for [MonarchController] — data endpoints and exception mapping.
 *
 * Shared fixtures live in [MonarchControllerTest.Companion].
 * See [MonarchControllerTest] for healthz, auth, and session-guard tests.
 */
@WebMvcTest(MonarchController::class)
@Import(GlobalExceptionHandler::class)
class MonarchControllerDataTest {
    @Autowired
    private lateinit var mvc: MockMvc

    @MockitoBean
    private lateinit var monarchClient: MonarchClient

    @MockitoBean
    private lateinit var monarchSessionService: MonarchSessionService

    // -----------------------------------------------------------------------------------------
    // GET /v1/account/{id}/history
    // -----------------------------------------------------------------------------------------

    @Test
    fun `account history returns 200 with data wrapper`() {
        `when`(monarchSessionService.current()).thenReturn(MonarchControllerTest.FAKE_SESSION)
        `when`(
            monarchClient.executeGraphQL(
                MonarchControllerTest.anyStr(),
                MonarchControllerTest.anyStr(),
                MonarchControllerTest.anyVariables(),
            ),
        ).thenReturn(MonarchControllerTest.dataNode("account"))

        mvc
            .perform(get("/v1/account/acc-123/history").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.account").value("ok"))
    }

    // -----------------------------------------------------------------------------------------
    // GET /v1/transactions
    // -----------------------------------------------------------------------------------------

    @Test
    fun `transactions parses query params and returns 200`() {
        `when`(monarchSessionService.current()).thenReturn(MonarchControllerTest.FAKE_SESSION)
        `when`(
            monarchClient.executeGraphQL(
                MonarchControllerTest.anyStr(),
                MonarchControllerTest.anyStr(),
                MonarchControllerTest.anyVariables(),
            ),
        ).thenReturn(MonarchControllerTest.dataNode("allTransactions"))

        mvc
            .perform(
                get("/v1/transactions")
                    .param("start", "2026-01-01")
                    .param("end", "2026-02-01")
                    .param("limit", "10")
                    .accept(MediaType.APPLICATION_JSON),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.allTransactions").value("ok"))
    }

    @Test
    fun `transactions uses default date range when params omitted`() {
        `when`(monarchSessionService.current()).thenReturn(MonarchControllerTest.FAKE_SESSION)
        `when`(
            monarchClient.executeGraphQL(
                MonarchControllerTest.anyStr(),
                MonarchControllerTest.anyStr(),
                MonarchControllerTest.anyVariables(),
            ),
        ).thenReturn(MonarchControllerTest.dataNode("allTransactions"))

        mvc
            .perform(get("/v1/transactions").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
    }

    // -----------------------------------------------------------------------------------------
    // GET /v1/cashflow
    // -----------------------------------------------------------------------------------------

    @Test
    fun `cashflow returns 200 with data wrapper`() {
        `when`(monarchSessionService.current()).thenReturn(MonarchControllerTest.FAKE_SESSION)
        `when`(
            monarchClient.executeGraphQL(
                MonarchControllerTest.anyStr(),
                MonarchControllerTest.anyStr(),
                MonarchControllerTest.anyVariables(),
            ),
        ).thenReturn(MonarchControllerTest.dataNode("summary"))

        mvc
            .perform(
                get("/v1/cashflow")
                    .param("start", "2026-01-01")
                    .param("end", "2026-01-31")
                    .accept(MediaType.APPLICATION_JSON),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.summary").value("ok"))
    }

    // -----------------------------------------------------------------------------------------
    // GET /v1/categories
    // -----------------------------------------------------------------------------------------

    @Test
    fun `categories returns 200 with data wrapper`() {
        `when`(monarchSessionService.current()).thenReturn(MonarchControllerTest.FAKE_SESSION)
        `when`(
            monarchClient.executeGraphQL(
                MonarchControllerTest.anyStr(),
                MonarchControllerTest.anyStr(),
                MonarchControllerTest.anyVariables(),
            ),
        ).thenReturn(MonarchControllerTest.dataNode("categories"))

        mvc
            .perform(get("/v1/categories").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.categories").value("ok"))
    }

    // -----------------------------------------------------------------------------------------
    // GET /v1/tags
    // -----------------------------------------------------------------------------------------

    @Test
    fun `tags returns 200 with data wrapper`() {
        `when`(monarchSessionService.current()).thenReturn(MonarchControllerTest.FAKE_SESSION)
        `when`(
            monarchClient.executeGraphQL(
                MonarchControllerTest.anyStr(),
                MonarchControllerTest.anyStr(),
                MonarchControllerTest.anyVariables(),
            ),
        ).thenReturn(MonarchControllerTest.dataNode("householdTransactionTags"))

        mvc
            .perform(get("/v1/tags").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.householdTransactionTags").value("ok"))
    }

    // -----------------------------------------------------------------------------------------
    // POST /v1/refresh
    // -----------------------------------------------------------------------------------------

    @Test
    fun `refresh returns 202 accepted`() {
        `when`(monarchSessionService.current()).thenReturn(MonarchControllerTest.FAKE_SESSION)
        `when`(
            monarchClient.executeGraphQL(
                MonarchControllerTest.anyStr(),
                MonarchControllerTest.anyStr(),
                MonarchControllerTest.anyVariables(),
            ),
        ).thenReturn(MonarchControllerTest.dataNode("forceRefreshAccounts"))

        mvc
            .perform(post("/v1/refresh").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isAccepted)
    }

    // -----------------------------------------------------------------------------------------
    // Exception mapping
    // -----------------------------------------------------------------------------------------

    @Test
    fun `accounts returns 401 when MonarchSessionExpiredException thrown`() {
        `when`(monarchSessionService.current()).thenReturn(MonarchControllerTest.FAKE_SESSION)
        `when`(
            monarchClient.executeGraphQL(
                MonarchControllerTest.anyStr(),
                MonarchControllerTest.anyStr(),
                MonarchControllerTest.anyVariables(),
            ),
        ).thenThrow(MonarchSessionExpiredException())

        mvc
            .perform(get("/v1/accounts").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isUnauthorized)
            .andExpect(jsonPath("$.code").value("session_expired"))
    }

    @Test
    fun `accounts returns 429 with Retry-After when MonarchRateLimitedException thrown`() {
        `when`(monarchSessionService.current()).thenReturn(MonarchControllerTest.FAKE_SESSION)
        `when`(
            monarchClient.executeGraphQL(
                MonarchControllerTest.anyStr(),
                MonarchControllerTest.anyStr(),
                MonarchControllerTest.anyVariables(),
            ),
        ).thenThrow(MonarchRateLimitedException(60L))

        mvc
            .perform(get("/v1/accounts").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isTooManyRequests)
            .andExpect(header().string("Retry-After", "60"))
            .andExpect(jsonPath("$.code").value("rate_limited"))
            .andExpect(jsonPath("$.details.retry_after_seconds").value(60))
    }

    @Test
    fun `accounts returns 502 when MonarchRequestFailedException thrown`() {
        `when`(monarchSessionService.current()).thenReturn(MonarchControllerTest.FAKE_SESSION)
        `when`(
            monarchClient.executeGraphQL(
                MonarchControllerTest.anyStr(),
                MonarchControllerTest.anyStr(),
                MonarchControllerTest.anyVariables(),
            ),
        ).thenThrow(MonarchRequestFailedException(500, "upstream error", "Upstream failed"))

        mvc
            .perform(get("/v1/accounts").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadGateway)
            .andExpect(jsonPath("$.code").value("monarch_request_failed"))
            .andExpect(jsonPath("$.details.upstream_status").value(500))
    }
}
