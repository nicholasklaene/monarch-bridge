package com.nicholasklaene.monarchbridge.graphql.operations.transactions

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetTransactionAuditLogResponseData
import com.nicholasklaene.monarchbridge.generated.model.TransactionAuditEntry
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/**
 * History of changes against one transaction. Each entry captures the timestamp, actor,
 * action verb, and old / new value for the field that changed.
 */
object GetTransactionAuditLog :
    MonarchOperation<GetTransactionAuditLog.Input, GetTransactionAuditLogResponseData> {
    override val operationName: String = "Web_GetTransactionAuditLog"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val id: String,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("id" to input.id)

    override fun parseOutput(data: JsonNode): GetTransactionAuditLogResponseData =
        GetTransactionAuditLogResponseData(
            propertyEntries =
                data.path("transactionAuditLog").path("entries").map { e ->
                    TransactionAuditEntry(
                        id = e.path("id").asText(""),
                        timestamp = e.path("timestamp").asTextOrNull(),
                        actor = e.path("actor").asTextOrNull(),
                        action = e.path("action").asTextOrNull(),
                        field = e.path("field").asTextOrNull(),
                        oldValue = e.path("oldValue").asTextOrNull(),
                        newValue = e.path("newValue").asTextOrNull(),
                    )
                },
        )
}
