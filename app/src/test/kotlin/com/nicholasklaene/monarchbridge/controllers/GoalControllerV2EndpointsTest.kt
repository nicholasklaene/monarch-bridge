package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.config.GlobalExceptionHandler
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.FAKE_SESSION
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.stubExec
import com.nicholasklaene.monarchbridge.exceptions.MonarchSessionMissingException
import com.nicholasklaene.monarchbridge.generated.model.LinkTransactionToGoalResponseData
import com.nicholasklaene.monarchbridge.generated.model.MarkGoalCompleteResponseData
import com.nicholasklaene.monarchbridge.generated.model.MarkTransactionStreamAsNotRecurringResponseData
import com.nicholasklaene.monarchbridge.generated.model.SpendFromGoalResponseData
import com.nicholasklaene.monarchbridge.generated.model.WithdrawFromGoalResponseData
import com.nicholasklaene.monarchbridge.graphql.MonarchClient
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(value = [GoalController::class, TransactionController::class])
@Import(GlobalExceptionHandler::class)
class GoalControllerV2EndpointsTest {
    @Autowired private lateinit var mvc: MockMvc

    @MockitoBean private lateinit var sessionService: MonarchSessionService

    @MockitoBean private lateinit var client: MonarchClient

    @Test
    fun `markGoalComplete returns completedAt`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, MarkGoalCompleteResponseData(id = "g-1", completedAt = "now"))
        mvc
            .perform(post("/v1/goals/g-1/complete"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.completedAt").value("now"))
    }

    @Test
    fun `markGoalIncomplete returns null completedAt`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, MarkGoalCompleteResponseData(id = "g-1", completedAt = null))
        mvc
            .perform(post("/v1/goals/g-1/incomplete"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.id").value("g-1"))
    }

    @Test
    fun `deleteGoalV2 returns success boolean`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, MarkTransactionStreamAsNotRecurringResponseData(success = true))
        mvc
            .perform(delete("/v1/goals/g-1/v2-delete"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.success").value(true))
    }

    @Test
    fun `spendFromGoal returns goalEventId`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, SpendFromGoalResponseData(goalEventId = "e-1"))
        mvc
            .perform(
                post("/v1/goals/g-1/spend")
                    .contentType("application/json")
                    .content("""{"amount": 12.34}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.goalEventId").value("e-1"))
    }

    @Test
    fun `withdrawFromGoal returns full goal+account snapshot`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            WithdrawFromGoalResponseData(
                goalEventId = "e-1",
                goalId = "g-1",
                goalCurrentBalance = 500.0,
                accountId = "a-1",
                accountAvailableBalanceForGoals = 1000.0,
            ),
        )
        mvc
            .perform(
                post("/v1/goals/g-1/withdraw")
                    .contentType("application/json")
                    .content("""{"amount": 50.0, "accountId": "a-1"}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.goalCurrentBalance").value(500.0))
            .andExpect(jsonPath("$.data.accountAvailableBalanceForGoals").value(1000.0))
    }

    @Test
    fun `linkTransactionToGoal returns goalEventId`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            LinkTransactionToGoalResponseData(goalEventId = "e-1", transactionId = "t-1", goalId = "g-1"),
        )
        mvc
            .perform(
                post("/v1/transactions/t-1/goal-link")
                    .contentType("application/json")
                    .content("""{"goalId": "g-1"}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.goalEventId").value("e-1"))
    }

    @Test
    fun `unlinkTransactionGoalRecords returns success`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, MarkTransactionStreamAsNotRecurringResponseData(success = true))
        mvc
            .perform(delete("/v1/transactions/t-1/goal-link"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.success").value(true))
    }

    @Test
    fun `markGoalComplete returns 503 when session missing`() {
        `when`(sessionService.requireCurrent()).thenThrow(MonarchSessionMissingException())
        mvc
            .perform(post("/v1/goals/g-1/complete"))
            .andExpect(status().isServiceUnavailable)
    }
}
