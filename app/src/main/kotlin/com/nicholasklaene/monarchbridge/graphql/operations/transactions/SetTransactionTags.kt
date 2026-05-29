package com.nicholasklaene.monarchbridge.graphql.operations.transactions

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.SetTransactionTagsRequest
import com.nicholasklaene.monarchbridge.generated.model.SetTransactionTagsResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Overwrite the entire tag set on a transaction. Empty list removes all tags.
 * Output is the spec-generated [SetTransactionTagsResponseData].
 */
object SetTransactionTags : MonarchOperation<SetTransactionTags.Input, SetTransactionTagsResponseData> {
    override val operationName: String = "Web_SetTransactionTags"
    override val query: String by lazy {
        GraphQLLoader.load(operationName, fragments = listOf("PayloadErrorFields"))
    }

    data class Input(
        val transactionId: String,
        val tagIds: List<String>,
    ) {
        companion object {
            fun from(
                transactionId: String,
                req: SetTransactionTagsRequest,
            ): Input = Input(transactionId, req.tagIds)
        }
    }

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "input" to
                mapOf(
                    "transactionId" to input.transactionId,
                    "tagIds" to input.tagIds,
                ),
        )

    override fun parseOutput(data: JsonNode): SetTransactionTagsResponseData {
        val tx = data.path("setTransactionTags").path("transaction")
        return SetTransactionTagsResponseData(
            transactionId = tx.path("id").asText(""),
            tagIds = tx.path("tags").map { it.path("id").asText("") },
        )
    }
}
