package com.nicholasklaene.monarchbridge.graphql.operations.transactions

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.TransactionSplit
import com.nicholasklaene.monarchbridge.generated.model.UpdateTransactionSplitsRequest
import com.nicholasklaene.monarchbridge.generated.model.UpdateTransactionSplitsResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/**
 * Replace the split allocations on a transaction. Empty list deletes all splits.
 * `sum(splitData.amount)` MUST equal the original transaction amount. Output is the
 * spec-generated [UpdateTransactionSplitsResponseData].
 */
object UpdateTransactionSplits : MonarchOperation<UpdateTransactionSplits.Input, UpdateTransactionSplitsResponseData> {
    override val operationName: String = "Common_SplitTransactionMutation"
    override val query: String by lazy {
        GraphQLLoader.load(operationName, fragments = listOf("PayloadErrorFields"))
    }

    /** One split — a per-line-item allocation when a transaction is divided. */
    data class Split(
        val merchantName: String,
        val amount: Double,
        val categoryId: String,
    )

    data class Input(
        val transactionId: String,
        val splitData: List<Split>,
    ) {
        companion object {
            fun from(
                transactionId: String,
                req: UpdateTransactionSplitsRequest,
            ): Input =
                Input(
                    transactionId = transactionId,
                    splitData = req.splitData.map { Split(merchantName = it.merchantName, amount = it.amount, categoryId = it.categoryId) },
                )
        }
    }

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "input" to
                mapOf(
                    "transactionId" to input.transactionId,
                    "splitData" to
                        input.splitData.map {
                            mapOf(
                                "merchantName" to it.merchantName,
                                "amount" to it.amount,
                                "categoryId" to it.categoryId,
                            )
                        },
                ),
        )

    override fun parseOutput(data: JsonNode): UpdateTransactionSplitsResponseData {
        val tx = data.path("updateTransactionSplit").path("transaction")
        return UpdateTransactionSplitsResponseData(
            transactionId = tx.path("id").asText(""),
            hasSplitTransactions = tx.path("hasSplitTransactions").asBoolean(false),
            splitTransactions = tx.path("splitTransactions").map(::parseSplit),
        )
    }

    private fun parseSplit(node: JsonNode): TransactionSplit =
        TransactionSplit(
            id = node.path("id").asText(""),
            amount = node.path("amount").asDoubleOrNull(),
            notes = node.path("notes").asTextOrNull(),
            merchantName = node.path("merchant").path("name").asTextOrNull(),
            categoryName = node.path("category").path("name").asTextOrNull(),
        )
}
