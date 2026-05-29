package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.config.GlobalExceptionHandler
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.FAKE_SESSION
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.stubExec
import com.nicholasklaene.monarchbridge.exceptions.MonarchSessionMissingException
import com.nicholasklaene.monarchbridge.generated.model.GetAccountBalanceAtDateResponseData
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

@WebMvcTest(AccountController::class)
@Import(GlobalExceptionHandler::class)
class AccountControllerBalanceAtTest {
    @Autowired private lateinit var mvc: MockMvc

    @MockitoBean private lateinit var sessionService: MonarchSessionService

    @MockitoBean private lateinit var client: MonarchClient

    @Test
    fun `getAccountBalanceAtDate returns balance envelope for the requested date`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetAccountBalanceAtDateResponseData(
                id = "acc-1",
                displayBalance = 12345.67,
                includeInNetWorth = true,
                accountType = "brokerage",
            ),
        )

        mvc
            .perform(get("/v1/accounts/acc-1/balance/at").param("date", "2026-05-01"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.id").value("acc-1"))
            .andExpect(jsonPath("$.data.displayBalance").value(12345.67))
            .andExpect(jsonPath("$.data.includeInNetWorth").value(true))
            .andExpect(jsonPath("$.data.accountType").value("brokerage"))
    }

    @Test
    fun `getAccountBalanceAtDate returns null displayBalance for dates before account link`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetAccountBalanceAtDateResponseData(
                id = "acc-1",
                displayBalance = null,
                includeInNetWorth = true,
                accountType = null,
            ),
        )

        mvc
            .perform(get("/v1/accounts/acc-1/balance/at").param("date", "2010-01-01"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.id").value("acc-1"))
            .andExpect(jsonPath("$.data.displayBalance").doesNotExist())
    }

    @Test
    fun `getAccountBalanceAtDate returns 400 when date param is missing`() {
        mvc
            .perform(get("/v1/accounts/acc-1/balance/at"))
            .andExpect(status().isBadRequest)
    }

    @Test
    fun `getAccountBalanceAtDate returns 503 when session missing`() {
        `when`(sessionService.requireCurrent()).thenThrow(MonarchSessionMissingException())

        mvc
            .perform(get("/v1/accounts/acc-1/balance/at").param("date", "2026-05-01"))
            .andExpect(status().isServiceUnavailable)
            .andExpect(jsonPath("$.code").value("session_missing"))
    }
}
