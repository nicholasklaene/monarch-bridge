package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetSpendingReportResponseData
import com.nicholasklaene.monarchbridge.generated.model.SpendingReport
import com.nicholasklaene.monarchbridge.generated.model.SpendingReportCategory
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import java.time.LocalDate

/**
 * High-level spending vs. budget summary for a date window with top-N category breakdown.
 * Wraps Monarch's `spendingReport` query (fired by the web Reports page).
 */
object GetSpendingReport : MonarchOperation<GetSpendingReport.Input, GetSpendingReportResponseData> {
    override val operationName: String = "Web_GetSpendingReport"
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

    override fun parseOutput(data: JsonNode): GetSpendingReportResponseData {
        val node = data.path("spendingReport")
        return GetSpendingReportResponseData(
            report =
                SpendingReport(
                    totalSpend = node.path("totalSpend").asDoubleOrNull(),
                    totalBudget = node.path("totalBudget").asDoubleOrNull(),
                    percentOfBudget = node.path("percentOfBudget").asDoubleOrNull(),
                    topCategories =
                        node.path("topCategories").map { c ->
                            SpendingReportCategory(
                                categoryId = c.path("categoryId").asText(""),
                                name = c.path("name").asText(""),
                                amount = c.path("amount").asDoubleOrNull(),
                                percentOfTotal = c.path("percentOfTotal").asDoubleOrNull(),
                            )
                        },
                ),
        )
    }
}
