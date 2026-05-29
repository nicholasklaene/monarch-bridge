package com.nicholasklaene.monarchbridge.graphql.operations.transactions

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.MarkTransactionAsReviewedResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/**
 * Single-shot "mark this transaction as reviewed". Wraps the same Monarch
 * `updateTransaction` mutation as [UpdateTransaction] but with a narrowed input
 * (`id` + `reviewed = true`) and a slim output projection (`id`, `reviewedAt`,
 * `needsReview`) - useful when an assistant just wants to dispatch the review-state
 * change without round-tripping the whole transaction tree.
 */
object MarkTransactionAsReviewed :
    MonarchOperation<MarkTransactionAsReviewed.Input, MarkTransactionAsReviewedResponseData> {
    override val operationName: String = "Common_MarkTransactionAsReviewed"
    override val query: String by lazy {
        GraphQLLoader.load(operationName, fragments = listOf("PayloadErrorFields"))
    }

    data class Input(
        val id: String,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("input" to mapOf("id" to input.id, "reviewed" to true))

    override fun parseOutput(data: JsonNode): MarkTransactionAsReviewedResponseData {
        val txn = data.path("updateTransaction").path("transaction")
        return MarkTransactionAsReviewedResponseData(
            id = txn.path("id").asText(""),
            reviewedAt = txn.path("reviewedAt").asTextOrNull(),
            needsReview = txn.path("needsReview").asBoolean(false),
        )
    }
}
