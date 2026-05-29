package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.config.GlobalExceptionHandler
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.FAKE_SESSION
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.stubExec
import com.nicholasklaene.monarchbridge.exceptions.MonarchSessionMissingException
import com.nicholasklaene.monarchbridge.generated.model.BudgetTimelineMonth
import com.nicholasklaene.monarchbridge.generated.model.GetBudgetTimelineResponseData
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

@WebMvcTest(BudgetController::class)
@Import(GlobalExceptionHandler::class)
class BudgetControllerTimelineTest {
    @Autowired private lateinit var mvc: MockMvc

    @MockitoBean private lateinit var sessionService: MonarchSessionService

    @MockitoBean private lateinit var client: MonarchClient

    @Test
    fun `getBudgetTimeline returns per-month budget vs actual rows`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetBudgetTimelineResponseData(
                months =
                    listOf(
                        BudgetTimelineMonth("2026-01", 4000.0, 3850.0, 150.0, 0.0375),
                        BudgetTimelineMonth("2026-02", 4000.0, 4200.0, -200.0, -0.05),
                    ),
            ),
        )
        mvc
            .perform(
                get("/v1/budgets/timeline")
                    .param("startMonth", "2026-01-01")
                    .param("monthCount", "2"),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.months[0].month").value("2026-01"))
            .andExpect(jsonPath("$.data.months[0].varianceAmount").value(150.0))
            .andExpect(jsonPath("$.data.months[1].variancePercent").value(-0.05))
    }

    @Test
    fun `getBudgetTimeline returns 400 when startMonth missing`() {
        // startMonth is a required query param.
        mvc
            .perform(get("/v1/budgets/timeline"))
            .andExpect(status().isBadRequest)
    }

    @Test
    fun `getBudgetTimeline uses spec default of 12 when monthCount omitted`() {
        // The spec sets monthCount default = 12, so requests without it should succeed
        // (the controller will see Int = 12 from Spring).
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetBudgetTimelineResponseData(months = emptyList()),
        )
        mvc
            .perform(get("/v1/budgets/timeline").param("startMonth", "2026-01-01"))
            .andExpect(status().isOk)
    }

    @Test
    fun `getBudgetTimeline returns 503 when session missing`() {
        `when`(sessionService.requireCurrent()).thenThrow(MonarchSessionMissingException())
        mvc
            .perform(get("/v1/budgets/timeline").param("startMonth", "2026-01-01"))
            .andExpect(status().isServiceUnavailable)
            .andExpect(jsonPath("$.code").value("session_missing"))
    }
}
