package com.nicholasklaene.monarchbridge.graphql.operations.merchants

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetMerchantTransactionsResponseData
import com.nicholasklaene.monarchbridge.generated.model.MerchantTransactionRow
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/**
 * Transaction list scoped to a single merchant. Lighter than `/v1/transactions?search=…`
 * when you already have the merchant id. Each row: date, amount, merchant, category.
 */
object GetMerchantTransactions :
    MonarchOperation<GetMerchantTransactions.Input, GetMerchantTransactionsResponseData> {
    override val operationName: String = "Web_GetMerchantTransactions"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val merchantId: String,
        val limit: Int? = null,
        val offset: Int? = null,
    )

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "merchantId" to input.merchantId,
            "limit" to input.limit,
            "offset" to input.offset,
        )

    override fun parseOutput(data: JsonNode): GetMerchantTransactionsResponseData =
        GetMerchantTransactionsResponseData(
            transactions =
                data.path("merchantTransactions").path("transactions").map { t ->
                    MerchantTransactionRow(
                        id = t.path("id").asText(""),
                        date = t.path("date").asTextOrNull(),
                        amount = t.path("amount").asDoubleOrNull(),
                        merchantName = t.path("merchantName").asTextOrNull(),
                        categoryName = t.path("categoryName").asTextOrNull(),
                    )
                },
        )
}
