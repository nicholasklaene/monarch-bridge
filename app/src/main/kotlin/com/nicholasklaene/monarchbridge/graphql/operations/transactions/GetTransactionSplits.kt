package com.nicholasklaene.monarchbridge.graphql.operations.transactions

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetTransactionSplitsResponseData
import com.nicholasklaene.monarchbridge.generated.model.Ref
import com.nicholasklaene.monarchbridge.generated.model.TransactionSplit
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import com.nicholasklaene.monarchbridge.graphql.pathOrNull

/**
 * Splits of one transaction (no attachments, no metadata — just the split breakdown).
 * Output is the spec-generated [GetTransactionSplitsResponseData].
 */
object GetTransactionSplits : MonarchOperation<GetTransactionSplits.Input, GetTransactionSplitsResponseData> {
    override val operationName: String = "TransactionSplitQuery"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val id: String,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("id" to input.id)

    override fun parseOutput(data: JsonNode): GetTransactionSplitsResponseData {
        val t = data.path("getTransaction")
        return GetTransactionSplitsResponseData(
            id = t.path("id").asText(""),
            amount = t.path("amount").asDouble(0.0),
            merchant = t.pathOrNull("merchant")?.let { parseRef(it) },
            category = t.pathOrNull("category")?.let { parseRef(it) },
            splits = t.path("splitTransactions").map(::parseSplit),
        )
    }

    private fun parseRef(node: JsonNode): Ref =
        Ref(
            id = node.path("id").asText(""),
            name = node.path("name").asText(""),
        )

    private fun parseSplit(node: JsonNode): TransactionSplit =
        TransactionSplit(
            id = node.path("id").asText(""),
            amount = node.path("amount").asDouble(0.0),
            notes = node.path("notes").asTextOrNull(),
            merchantName = node.path("merchant").path("name").asTextOrNull(),
            categoryName = node.path("category").path("name").asTextOrNull(),
        )
}
