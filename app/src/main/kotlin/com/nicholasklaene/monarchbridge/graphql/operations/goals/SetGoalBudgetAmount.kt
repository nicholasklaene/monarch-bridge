package com.nicholasklaene.monarchbridge.graphql.operations.goals

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.MarkTransactionStreamAsNotRecurringResponseData
import com.nicholasklaene.monarchbridge.generated.model.SetGoalBudgetAmountRequest
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import java.time.LocalDate

/**
 * Set a savings goal's monthly planned-contribution allocation. `month` is `YYYY-MM-DD`
 * (use day 1 by convention). `applyToFuture` (default false) cascades the amount to all
 * future months. `accountId` is optional — null sets the household-level amount.
 *
 * Returns Monarch's reported success flag.
 */
object SetGoalBudgetAmount :
    MonarchOperation<SetGoalBudgetAmount.Input, MarkTransactionStreamAsNotRecurringResponseData> {
    override val operationName: String = "Common_SetSavingsGoalBudgetAmount"
    override val query: String by lazy { GraphQLLoader.load(operationName, fragments = listOf("PayloadErrorFields")) }

    data class Input(
        val goalId: String,
        val amount: Double,
        val month: String = LocalDate.now().withDayOfMonth(1).toString(),
        val applyToFuture: Boolean = false,
        val accountId: String? = null,
    ) {
        companion object {
            fun from(
                goalId: String,
                req: SetGoalBudgetAmountRequest,
            ): Input =
                Input(
                    goalId = goalId,
                    amount = req.amount,
                    month = req.month ?: LocalDate.now().withDayOfMonth(1).toString(),
                    applyToFuture = req.applyToFuture ?: false,
                    accountId = req.accountId,
                )
        }
    }

    override fun variables(input: Input): Map<String, Any?> {
        val payload =
            buildMap<String, Any?> {
                put("savingsGoalId", input.goalId)
                put("month", input.month)
                put("amount", input.amount)
                put("applyToFuture", input.applyToFuture)
                put("accountId", input.accountId)
            }
        return mapOf("input" to payload)
    }

    override fun parseOutput(data: JsonNode): MarkTransactionStreamAsNotRecurringResponseData =
        MarkTransactionStreamAsNotRecurringResponseData(
            success = data.path("setSavingsGoalBudgetAmount").path("success").asBoolean(false),
        )
}
