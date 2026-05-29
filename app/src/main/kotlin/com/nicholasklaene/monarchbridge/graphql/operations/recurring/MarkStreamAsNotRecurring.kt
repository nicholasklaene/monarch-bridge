package com.nicholasklaene.monarchbridge.graphql.operations.recurring

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.MarkTransactionStreamAsNotRecurringResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Tell Monarch a particular recurring-transaction stream is NOT actually recurring — used
 * to dismiss false-positive recurrence detections.
 *
 * Note: the path on this proxy uses `{id}` from the `transactions` route for ergonomics
 * (the user thinks "I'm here on this transaction, mark it not-recurring"). The GraphQL
 * mutation takes a `streamId` — the caller MUST pass the transaction's `stream.id`, not
 * the transaction id itself. We do not attempt server-side resolution here.
 */
object MarkStreamAsNotRecurring :
    MonarchOperation<MarkStreamAsNotRecurring.Input, MarkTransactionStreamAsNotRecurringResponseData> {
    override val operationName: String = "Common_MarkAsNotRecurring"
    override val query: String by lazy { GraphQLLoader.load(operationName, fragments = listOf("PayloadErrorFields")) }

    data class Input(
        val streamId: String,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("streamId" to input.streamId)

    override fun parseOutput(data: JsonNode): MarkTransactionStreamAsNotRecurringResponseData =
        MarkTransactionStreamAsNotRecurringResponseData(
            success = data.path("markStreamAsNotRecurring").path("success").asBoolean(false),
        )
}
