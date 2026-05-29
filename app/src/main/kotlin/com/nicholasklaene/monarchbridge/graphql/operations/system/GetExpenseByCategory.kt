package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.ExpenseByCategoryRow
import com.nicholasklaene.monarchbridge.generated.model.GetExpenseByCategoryResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asIntOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import com.nicholasklaene.monarchbridge.graphql.mapOfNotNull
import java.time.LocalDate

/**
 * Expense rollup grouped by category over the requested window. Drives the
 * "Top categories" report card; defaults to last-month when both bounds are omitted.
 */
object GetExpenseByCategory : MonarchOperation<GetExpenseByCategory.Input, GetExpenseByCategoryResponseData> {
    override val operationName: String = "Common_GetExpenseByCategoryReport"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val startDate: LocalDate?,
        val endDate: LocalDate?,
    )

    override fun variables(input: Input): Map<String, Any?> =
        mapOfNotNull(
            "startDate" to input.startDate?.toString(),
            "endDate" to input.endDate?.toString(),
        )

    override fun parseOutput(data: JsonNode): GetExpenseByCategoryResponseData =
        GetExpenseByCategoryResponseData(
            rows =
                data.path("expenseByCategoryReport").path("rows").map { r ->
                    ExpenseByCategoryRow(
                        categoryId = r.path("categoryId").asText(""),
                        categoryName = r.path("categoryName").asTextOrNull(),
                        amount = r.path("amount").asDoubleOrNull(),
                        transactionCount = r.path("transactionCount").asIntOrNull(),
                    )
                },
        )
}
