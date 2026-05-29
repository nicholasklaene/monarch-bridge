package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.config.GlobalExceptionHandler
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.FAKE_SESSION
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.stubExec
import com.nicholasklaene.monarchbridge.generated.model.GetGoalContributionHistoryResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetGoalProjectionResponseData
import com.nicholasklaene.monarchbridge.generated.model.GoalContribution
import com.nicholasklaene.monarchbridge.generated.model.GoalProjection
import com.nicholasklaene.monarchbridge.generated.model.GoalProjectionPoint
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
 * R6 goals history endpoints on [GoalController]:
 *  GET /v1/goals/{id}/contribution-history  getGoalContributionHistory
 *  GET /v1/goals/{id}/projection            getGoalProjection
 */
@WebMvcTest(GoalController::class)
@Import(GlobalExceptionHandler::class)
class GoalControllerProjectionTest {
    @Autowired private lateinit var mvc: MockMvc

    @MockitoBean private lateinit var sessionService: MonarchSessionService

    @MockitoBean private lateinit var client: MonarchClient

    @Test
    fun `getGoalContributionHistory wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetGoalContributionHistoryResponseData(
                contributions =
                    listOf(
                        GoalContribution(
                            id = "k-1",
                            date = "2026-04-15",
                            amount = 250.0,
                            accountId = "a-1",
                            notes = "April auto-contribution",
                        ),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/goals/g-1/contribution-history"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.contributions[0].id").value("k-1"))
            .andExpect(jsonPath("$.data.contributions[0].amount").value(250.0))
            .andExpect(jsonPath("$.data.contributions[0].notes").value("April auto-contribution"))
    }

    @Test
    fun `getGoalProjection wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetGoalProjectionResponseData(
                projection =
                    GoalProjection(
                        projectedCompletionDate = "2027-01-15",
                        monthsToTarget = 8,
                        series =
                            listOf(
                                GoalProjectionPoint(date = LocalDate.parse("2026-06-01"), projectedBalance = 1500.0),
                                GoalProjectionPoint(date = LocalDate.parse("2026-07-01"), projectedBalance = 1750.0),
                            ),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/goals/g-1/projection"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.projection.monthsToTarget").value(8))
            .andExpect(jsonPath("$.data.projection.series[0].projectedBalance").value(1500.0))
            .andExpect(jsonPath("$.data.projection.series[1].projectedBalance").value(1750.0))
    }
}
