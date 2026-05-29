package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.config.GlobalExceptionHandler
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.FAKE_SESSION
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.stubExec
import com.nicholasklaene.monarchbridge.exceptions.MonarchSessionMissingException
import com.nicholasklaene.monarchbridge.generated.model.ContributeToGoalResponseData
import com.nicholasklaene.monarchbridge.generated.model.ContributeToGoalResponseDataGoalEvent
import com.nicholasklaene.monarchbridge.generated.model.CreateGoalResponseData
import com.nicholasklaene.monarchbridge.generated.model.DeleteAccountResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetGoalsCurrentMonthTotalsResponseData
import com.nicholasklaene.monarchbridge.generated.model.Goal
import com.nicholasklaene.monarchbridge.generated.model.GoalCurrentMonthTotal
import com.nicholasklaene.monarchbridge.generated.model.GoalEvent
import com.nicholasklaene.monarchbridge.generated.model.GoalPriority
import com.nicholasklaene.monarchbridge.generated.model.ListGoalEventsResponseData
import com.nicholasklaene.monarchbridge.generated.model.ListGoalsResponseData
import com.nicholasklaene.monarchbridge.generated.model.MarkTransactionStreamAsNotRecurringResponseData
import com.nicholasklaene.monarchbridge.generated.model.UpdateGoalsPrioritiesResponseData
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

/**
 * MockMvc slice for [GoalController]. Exercises every endpoint on the GoalsApi surface so the
 * thin dispatcher wiring stays covered as new operations land.
 */
@WebMvcTest(GoalController::class)
@Import(GlobalExceptionHandler::class)
class GoalControllerTest {
    @Autowired private lateinit var mvc: MockMvc

    @MockitoBean private lateinit var sessionService: MonarchSessionService

    @MockitoBean private lateinit var client: MonarchClient

    @Test
    fun `listGoals wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            ListGoalsResponseData(
                goals =
                    listOf(
                        Goal(id = "g1", name = "Emergency Fund", targetAmount = 10000.0),
                        Goal(id = "g2", name = "Vacation"),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/goals"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.goals[0].id").value("g1"))
            .andExpect(jsonPath("$.data.goals[0].name").value("Emergency Fund"))
            .andExpect(jsonPath("$.data.goals[0].targetAmount").value(10000.0))
            .andExpect(jsonPath("$.data.goals[1].id").value("g2"))
    }

    @Test
    fun `listGoals returns 503 when session missing`() {
        `when`(sessionService.requireCurrent()).thenThrow(MonarchSessionMissingException())
        mvc
            .perform(get("/v1/goals"))
            .andExpect(status().isServiceUnavailable)
            .andExpect(jsonPath("$.code").value("session_missing"))
    }

    @Test
    fun `getGoal wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            CreateGoalResponseData(goal = Goal(id = "g-9", name = "Travel")),
        )
        mvc
            .perform(get("/v1/goals/g-9"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.goal.id").value("g-9"))
            .andExpect(jsonPath("$.data.goal.name").value("Travel"))
    }

    @Test
    fun `createGoal wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            CreateGoalResponseData(goal = Goal(id = "g-new", name = "Down Payment", targetAmount = 50000.0)),
        )
        mvc
            .perform(
                post("/v1/goals")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"name":"Down Payment","targetAmount":50000.0}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.goal.id").value("g-new"))
            .andExpect(jsonPath("$.data.goal.targetAmount").value(50000.0))
    }

    @Test
    fun `createGoal returns 400 when name missing`() {
        mvc
            .perform(
                post("/v1/goals")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"targetAmount":1000.0}"""),
            ).andExpect(status().isBadRequest)
            .andExpect(jsonPath("$.code").value("invalid_input"))
    }

    @Test
    fun `updateGoal patches goal and returns updated entity`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            CreateGoalResponseData(goal = Goal(id = "g-1", name = "Renamed", targetAmount = 7500.0)),
        )
        mvc
            .perform(
                patch("/v1/goals/g-1")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"name":"Renamed","targetAmount":7500.0}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.goal.name").value("Renamed"))
            .andExpect(jsonPath("$.data.goal.targetAmount").value(7500.0))
    }

    @Test
    fun `contributeToGoal wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            ContributeToGoalResponseData(
                goalEvent = ContributeToGoalResponseDataGoalEvent(id = "ev-1"),
                userNotice = null,
            ),
        )
        mvc
            .perform(
                post("/v1/goals/g-1/contributions")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"accountId":"a-1","amount":250.0,"date":"2026-05-15"}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.goalEvent.id").value("ev-1"))
    }

    @Test
    fun `archiveGoal wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, CreateGoalResponseData(goal = Goal(id = "g-1", name = "Old", archivedAt = "2026-05-26T10:00:00Z")))
        mvc
            .perform(delete("/v1/goals/g-1"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.goal.id").value("g-1"))
            .andExpect(jsonPath("$.data.goal.archivedAt").value("2026-05-26T10:00:00Z"))
    }

    @Test
    fun `unarchiveGoal wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, CreateGoalResponseData(goal = Goal(id = "g-1", name = "Restored")))
        mvc
            .perform(post("/v1/goals/g-1/unarchive"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.goal.id").value("g-1"))
            .andExpect(jsonPath("$.data.goal.name").value("Restored"))
    }

    @Test
    fun `hardDeleteGoal wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, DeleteAccountResponseData(deleted = true))
        mvc
            .perform(delete("/v1/goals/g-1/hard"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.deleted").value(true))
    }

    @Test
    fun `listGoalEvents wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            ListGoalEventsResponseData(
                events =
                    listOf(
                        GoalEvent(id = "ev-1", amount = 200.0, type = "contribution"),
                        GoalEvent(id = "ev-2", amount = 300.0, type = "contribution"),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/goals/g-1/events"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.events[0].id").value("ev-1"))
            .andExpect(jsonPath("$.data.events[1].amount").value(300.0))
    }

    @Test
    fun `getGoalsCurrentMonthTotals returns per-goal totals`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetGoalsCurrentMonthTotalsResponseData(
                totals =
                    listOf(
                        GoalCurrentMonthTotal(goalId = "g-1", totalPlannedAmount = 500.0),
                        GoalCurrentMonthTotal(goalId = "g-2", totalPlannedAmount = 200.0),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/goals/totals/current-month").param("startMonth", "2026-05-01").param("endMonth", "2026-05-01"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.totals[0].goalId").value("g-1"))
            .andExpect(jsonPath("$.data.totals[0].totalPlannedAmount").value(500.0))
            .andExpect(jsonPath("$.data.totals[1].goalId").value("g-2"))
    }

    @Test
    fun `getGoalsCurrentMonthTotals defaults month when params absent`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetGoalsCurrentMonthTotalsResponseData(totals = emptyList()),
        )
        mvc
            .perform(get("/v1/goals/totals/current-month"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.totals").isArray)
    }

    @Test
    fun `updateGoalsPriorities reorders goals and returns the new priority list`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            UpdateGoalsPrioritiesResponseData(
                goals =
                    listOf(
                        GoalPriority(goalId = "g-1", priority = 1),
                        GoalPriority(goalId = "g-2", priority = 2),
                    ),
            ),
        )
        mvc
            .perform(
                put("/v1/goals/priorities")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"goalIds":["g-1","g-2"]}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.goals[0].goalId").value("g-1"))
            .andExpect(jsonPath("$.data.goals[0].priority").value(1))
            .andExpect(jsonPath("$.data.goals[1].priority").value(2))
    }

    @Test
    fun `setGoalBudgetAmount wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, MarkTransactionStreamAsNotRecurringResponseData(success = true))
        mvc
            .perform(
                put("/v1/goals/g-1/budget")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"amount":250.0,"month":"2026-05-01","applyToFuture":true}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.success").value(true))
    }
}
