package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.ExpenseByTagRow
import com.nicholasklaene.monarchbridge.generated.model.GetExpenseByTagResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asIntOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import com.nicholasklaene.monarchbridge.graphql.mapOfNotNull
import java.time.LocalDate

/**
 * Expense rollup grouped by transaction tag over the requested window. Empty
 * `tagId` strings are skipped at the source - every row has a real tag id.
 */
object GetExpenseByTag : MonarchOperation<GetExpenseByTag.Input, GetExpenseByTagResponseData> {
    override val operationName: String = "Common_GetExpenseByTagReport"
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

    override fun parseOutput(data: JsonNode): GetExpenseByTagResponseData =
        GetExpenseByTagResponseData(
            rows =
                data.path("expenseByTagReport").path("rows").map { r ->
                    ExpenseByTagRow(
                        tagId = r.path("tagId").asText(""),
                        tagName = r.path("tagName").asTextOrNull(),
                        amount = r.path("amount").asDoubleOrNull(),
                        transactionCount = r.path("transactionCount").asIntOrNull(),
                    )
                },
        )
}
