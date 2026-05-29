package com.nicholasklaene.monarchbridge.graphql.operations.goals

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetGoalsCurrentMonthTotalsResponseData
import com.nicholasklaene.monarchbridge.generated.model.GoalCurrentMonthTotal
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import java.time.LocalDate

/**
 * Per-goal current-month planned-contribution totals. Reuses Monarch's
 * `savingsGoals.monthlyBudgetAmounts` window — the operation defaults to the current
 * calendar month if the caller omits dates.
 *
 * The `monthlyBudgetAmounts` field is itself an array (one entry per month in the window);
 * we sum `totalPlannedAmount` across the window per goal so the response is one entry per
 * goal regardless of window size.
 */
object GetGoalsCurrentMonthTotals :
    MonarchOperation<GetGoalsCurrentMonthTotals.Input, GetGoalsCurrentMonthTotalsResponseData> {
    override val operationName: String = "Common_SavingsGoalsCurrentMonthTotals"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val startMonth: String = LocalDate.now().withDayOfMonth(1).toString(),
        val endMonth: String = LocalDate.now().withDayOfMonth(1).toString(),
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("startMonth" to input.startMonth, "endMonth" to input.endMonth)

    override fun parseOutput(data: JsonNode): GetGoalsCurrentMonthTotalsResponseData {
        val totals =
            data
                .path("savingsGoals")
                .takeIf { it.isArray }
                ?.map { goalNode ->
                    val sum =
                        goalNode
                            .path("monthlyBudgetAmounts")
                            .takeIf { it.isArray }
                            ?.mapNotNull { it.path("totalPlannedAmount").asDoubleOrNull() }
                            ?.sum()
                    GoalCurrentMonthTotal(
                        goalId = goalNode.path("id").asText(""),
                        totalPlannedAmount = sum,
                    )
                }.orEmpty()
        return GetGoalsCurrentMonthTotalsResponseData(totals = totals)
    }
}
