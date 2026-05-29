package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.MarkTransactionStreamAsNotRecurringResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Bulk-dismiss every activity event. Output type comes from the spec dedupe pool
 * (`{success: boolean}` is generated under `MarkTransactionStreamAsNotRecurringResponseData`).
 */
object ClearAllNotifications :
    MonarchOperation<Unit, MarkTransactionStreamAsNotRecurringResponseData> {
    override val operationName: String = "Common_ClearAllActivities"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    override fun variables(input: Unit): Map<String, Any?> = emptyMap()

    override fun parseOutput(data: JsonNode): MarkTransactionStreamAsNotRecurringResponseData =
        MarkTransactionStreamAsNotRecurringResponseData(
            success = data.path("clearAllActivities").path("success").asBoolean(false),
        )
}
