package com.nicholasklaene.monarchbridge.graphql.operations.transactions

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetTransactionNotesResponseData
import com.nicholasklaene.monarchbridge.generated.model.TransactionNote
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/** Standalone notes accessor for one transaction (lighter than the full transaction detail). */
object GetTransactionNotes : MonarchOperation<GetTransactionNotes.Input, GetTransactionNotesResponseData> {
    override val operationName: String = "Web_GetTransactionNotes"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val id: String,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("id" to input.id)

    override fun parseOutput(data: JsonNode): GetTransactionNotesResponseData {
        val node = data.path("getTransaction")
        return GetTransactionNotesResponseData(
            note =
                TransactionNote(
                    id = node.path("id").asText(""),
                    note = node.path("notes").asTextOrNull(),
                    updatedAt = node.path("updatedAt").asTextOrNull(),
                ),
        )
    }
}
