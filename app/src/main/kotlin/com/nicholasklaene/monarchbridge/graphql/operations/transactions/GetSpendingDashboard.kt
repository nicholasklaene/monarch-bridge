package com.nicholasklaene.monarchbridge.graphql.operations.transactions

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetSpendingDashboardResponseData
import com.nicholasklaene.monarchbridge.generated.model.SpendingDashboard
import com.nicholasklaene.monarchbridge.generated.model.SpendingDashboardCategory
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import java.time.LocalDate

/**
 * Compact home-tab spending widget: total spend, remaining budget, top categories. Lighter
 * than the full `/v1/cashflow/breakdown` when you only need the widget data.
 */
object GetSpendingDashboard : MonarchOperation<GetSpendingDashboard.Input, GetSpendingDashboardResponseData> {
    override val operationName: String = "Web_GetSpendingDashboard"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val startDate: LocalDate? = null,
        val endDate: LocalDate? = null,
    )

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "startDate" to input.startDate?.toString(),
            "endDate" to input.endDate?.toString(),
        )

    override fun parseOutput(data: JsonNode): GetSpendingDashboardResponseData {
        val node = data.path("spendingDashboard")
        return GetSpendingDashboardResponseData(
            dashboard =
                SpendingDashboard(
                    totalSpend = node.path("totalSpend").asDoubleOrNull(),
                    budgetRemaining = node.path("budgetRemaining").asDoubleOrNull(),
                    topCategories =
                        node.path("topCategories").map { c ->
                            SpendingDashboardCategory(
                                categoryId = c.path("categoryId").asText(""),
                                name = c.path("name").asTextOrNull(),
                                amount = c.path("amount").asDoubleOrNull(),
                            )
                        },
                ),
        )
    }
}
