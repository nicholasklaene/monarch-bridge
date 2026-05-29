package com.nicholasklaene.monarchbridge.graphql.operations.goals

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.WithdrawFromGoalRequest
import com.nicholasklaene.monarchbridge.generated.model.WithdrawFromGoalResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import java.time.LocalDate

/** Withdraw cash from a savings goal back into a source account. */
object WithdrawFromGoal :
    MonarchOperation<WithdrawFromGoal.Input, WithdrawFromGoalResponseData> {
    override val operationName: String = "Common_WithdrawFromSavingsGoal"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val goalId: String,
        val amount: Double,
        val accountId: String,
        val date: LocalDate?,
    ) {
        companion object {
            fun from(
                id: String,
                req: WithdrawFromGoalRequest,
            ): Input = Input(goalId = id, amount = req.amount, accountId = req.accountId, date = req.date)
        }
    }

    override fun variables(input: Input): Map<String, Any?> {
        val map =
            mutableMapOf<String, Any?>(
                "goalId" to input.goalId,
                "amount" to input.amount,
                "accountId" to input.accountId,
            )
        input.date?.let { map["date"] = it.toString() }
        return mapOf("input" to map)
    }

    override fun parseOutput(data: JsonNode): WithdrawFromGoalResponseData {
        val event = data.path("createSavingsGoalWithdrawal").path("goalEvent")
        val goal = event.path("goal")
        val account = event.path("account")
        return WithdrawFromGoalResponseData(
            goalEventId = event.path("id").asText(""),
            goalId = goal.path("id").asTextOrNull(),
            goalCurrentBalance = goal.path("currentBalance").asDoubleOrNull(),
            goalProgress = goal.path("progress").asDoubleOrNull(),
            goalStatus = goal.path("status").asTextOrNull(),
            accountId = account.path("id").asTextOrNull(),
            accountAvailableBalanceForGoals = account.path("availableBalanceForGoalsUnmemoized").asDoubleOrNull(),
        )
    }
}
