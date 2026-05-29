package com.nicholasklaene.monarchbridge.graphql.operations.budgets

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.BudgetMonthCategoryAmounts
import com.nicholasklaene.monarchbridge.generated.model.BudgetMonthMonthlyAmount
import com.nicholasklaene.monarchbridge.generated.model.GetBudgetMonthResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import java.time.LocalDate

/**
 * Slim single-month budget data: returns budget system + per-category monthly amounts
 * for one month. Lighter than `/v1/budgets` (which pulls the full categoryGroups tree).
 *
 * Upstream-shape note: Monarch rejects the query with HTTP 400
 * `Something went wrong while processing: None on request_id: None.` when a
 * declared variable (e.g. `$endDate: Date!`) is never referenced in the query
 * body. Keep `endMonth: $endDate` in the .graphql file so both declared
 * variables are consumed.
 */
object GetBudgetMonth : MonarchOperation<GetBudgetMonth.Input, GetBudgetMonthResponseData> {
    override val operationName: String = "Common_BudgetDataQuery"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val month: LocalDate,
    )

    override fun variables(input: Input): Map<String, Any?> =
        mapOf("startDate" to input.month.toString(), "endDate" to input.month.toString())

    override fun parseOutput(data: JsonNode): GetBudgetMonthResponseData =
        GetBudgetMonthResponseData(
            budgetSystem = data.path("budgetSystem").asTextOrNull(),
            byCategory =
                data.path("budgetData").path("monthlyAmountsByCategory").map { entry ->
                    BudgetMonthCategoryAmounts(
                        categoryId = entry.path("category").path("id").asText(""),
                        monthlyAmounts =
                            entry.path("monthlyAmounts").mapNotNull { ma ->
                                val month = ma.path("month").asText("")
                                if (month.isBlank()) {
                                    null
                                } else {
                                    BudgetMonthMonthlyAmount(
                                        month = LocalDate.parse(month),
                                        plannedCashFlowAmount = ma.path("plannedCashFlowAmount").asDoubleOrNull(),
                                        plannedSetAsideAmount = ma.path("plannedSetAsideAmount").asDoubleOrNull(),
                                        actualAmount = ma.path("actualAmount").asDoubleOrNull(),
                                        remainingAmount = ma.path("remainingAmount").asDoubleOrNull(),
                                        previousMonthRolloverAmount = ma.path("previousMonthRolloverAmount").asDoubleOrNull(),
                                        rolloverType = ma.path("rolloverType").asTextOrNull(),
                                        cumulativeActualAmount = ma.path("cumulativeActualAmount").asDoubleOrNull(),
                                        rolloverTargetAmount = ma.path("rolloverTargetAmount").asDoubleOrNull(),
                                    )
                                }
                            },
                    )
                },
        )
}
