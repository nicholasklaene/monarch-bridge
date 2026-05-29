package com.nicholasklaene.monarchbridge.graphql.operations.budgets

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.nicholasklaene.monarchbridge.generated.model.GetBudgetsResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Monthly budget data + actuals across a date range. Returns the full Monarch
 * budgetData tree (per-category, per-group, per-flex, monthly totals) plus the
 * categoryGroups tree (the budget configuration scaffold).
 *
 * Date range defaults to last-month → next-month when both are omitted (Monarch's
 * convention). For a single month, pass `startDate=YYYY-MM-01&endDate=YYYY-MM-01`.
 *
 * Output is the spec-generated inner `data` payload (BudgetsResponse-shaped).
 */
object GetBudgets : MonarchOperation<GetBudgets.Input, GetBudgetsResponseData> {
    override val operationName: String = "GetJointPlanningData"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val startDate: String,
        val endDate: String,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("startDate" to input.startDate, "endDate" to input.endDate)

    override fun parseOutput(data: JsonNode): GetBudgetsResponseData {
        val mapper = ObjectMapper()
        @Suppress("UNCHECKED_CAST")
        return GetBudgetsResponseData(
            categoryGroups = data.path("categoryGroups").map { mapper.convertValue(it, Map::class.java) as Map<String, Any> },
            budgetData =
                data
                    .path("budgetData")
                    .takeIf {
                        !it.isMissingNode && !it.isNull
                    }?.let { mapper.convertValue(it, Map::class.java) as Map<String, Any> },
        )
    }
}
