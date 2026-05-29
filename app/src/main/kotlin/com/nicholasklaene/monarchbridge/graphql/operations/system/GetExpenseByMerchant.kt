package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.ExpenseByMerchantRow
import com.nicholasklaene.monarchbridge.generated.model.GetExpenseByMerchantResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asIntOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import com.nicholasklaene.monarchbridge.graphql.mapOfNotNull
import java.time.LocalDate

/**
 * Expense rollup grouped by merchant over the requested window. Powers the
 * "Top merchants" report card and the merchant-spend export.
 */
object GetExpenseByMerchant : MonarchOperation<GetExpenseByMerchant.Input, GetExpenseByMerchantResponseData> {
    override val operationName: String = "Common_GetExpenseByMerchantReport"
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

    override fun parseOutput(data: JsonNode): GetExpenseByMerchantResponseData =
        GetExpenseByMerchantResponseData(
            rows =
                data.path("expenseByMerchantReport").path("rows").map { r ->
                    ExpenseByMerchantRow(
                        merchantId = r.path("merchantId").asText(""),
                        merchantName = r.path("merchantName").asTextOrNull(),
                        amount = r.path("amount").asDoubleOrNull(),
                        transactionCount = r.path("transactionCount").asIntOrNull(),
                    )
                },
        )
}
