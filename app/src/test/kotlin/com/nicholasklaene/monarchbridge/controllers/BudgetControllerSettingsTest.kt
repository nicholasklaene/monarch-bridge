package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.config.GlobalExceptionHandler
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.FAKE_SESSION
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.stubExec
import com.nicholasklaene.monarchbridge.exceptions.MonarchSessionMissingException
import com.nicholasklaene.monarchbridge.generated.model.UpdateBudgetSettingsResponseData
import com.nicholasklaene.monarchbridge.graphql.MonarchClient
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(BudgetController::class)
@Import(GlobalExceptionHandler::class)
class BudgetControllerSettingsTest {
    @Autowired private lateinit var mvc: MockMvc

    @MockitoBean private lateinit var sessionService: MonarchSessionService

    @MockitoBean private lateinit var client: MonarchClient

    @Test
    fun `updateBudgetSettings returns effective settings`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            UpdateBudgetSettingsResponseData(
                budgetSystem = "category",
                budgetApplyToFutureMonthsDefault = true,
                budgetRolloverPeriodId = "r-1",
                budgetRolloverPeriodStartMonth = "2026-01-01",
            ),
        )
        mvc
            .perform(
                patch("/v1/budgets/settings")
                    .contentType("application/json")
                    .content("""{"budgetSystem": "category"}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.budgetSystem").value("category"))
            .andExpect(jsonPath("$.data.budgetRolloverPeriodId").value("r-1"))
    }

    @Test
    fun `updateBudgetSettings returns 503 when session missing`() {
        `when`(sessionService.requireCurrent()).thenThrow(MonarchSessionMissingException())
        mvc
            .perform(
                patch("/v1/budgets/settings")
                    .contentType("application/json")
                    .content("""{}"""),
            ).andExpect(status().isServiceUnavailable)
    }
}
