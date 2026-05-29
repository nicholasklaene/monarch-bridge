package com.nicholasklaene.monarchbridge.graphql.operations.transactions

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.DeleteAccountResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Remove a transaction. Output is the spec-generated [DeleteAccountResponseData]
 * (the generator dedupes since deleteAccount and deleteTransaction have identical
 * `{deleted: Boolean}` shape).
 */
object DeleteTransaction : MonarchOperation<DeleteTransaction.Input, DeleteAccountResponseData> {
    override val operationName: String = "Common_DeleteTransactionMutation"
    override val query: String by lazy {
        GraphQLLoader.load(operationName, fragments = listOf("PayloadErrorFields"))
    }

    data class Input(
        val transactionId: String,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("input" to mapOf("transactionId" to input.transactionId))

    override fun parseOutput(data: JsonNode): DeleteAccountResponseData =
        DeleteAccountResponseData(deleted = data.path("deleteTransaction").path("deleted").asBoolean(false))
}
