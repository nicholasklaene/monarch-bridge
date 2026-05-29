package com.nicholasklaene.monarchbridge.graphql.operations.transactions

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.ExplainTransactionResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/** AI explanation for one transaction. Returns null if Monarch has not generated one. */
object ExplainTransaction : MonarchOperation<ExplainTransaction.Input, ExplainTransactionResponseData> {
    override val operationName: String = "Common_TransactionExplainQuery"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val id: String,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("id" to input.id)

    override fun parseOutput(data: JsonNode): ExplainTransactionResponseData =
        ExplainTransactionResponseData(
            explanation = data.path("explainTransaction").path("explanation").asTextOrNull(),
        )
}
