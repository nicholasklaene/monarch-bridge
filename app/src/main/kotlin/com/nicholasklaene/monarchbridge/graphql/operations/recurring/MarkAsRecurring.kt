package com.nicholasklaene.monarchbridge.graphql.operations.recurring

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.MarkAsRecurringRequest
import com.nicholasklaene.monarchbridge.generated.model.MarkAsRecurringResponseData
import com.nicholasklaene.monarchbridge.generated.model.RecurringStreamRef
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/**
 * Tell Monarch a transaction IS the start of a recurring stream - the inverse of
 * [com.nicholasklaene.monarchbridge.graphql.operations.recurring.MarkStreamAsNotRecurring].
 * Caller supplies the transaction id plus the suspected `frequency` (monthly, weekly,
 * quarterly, yearly, biweekly); Monarch creates the stream definition and returns its id.
 */
object MarkAsRecurring :
    MonarchOperation<MarkAsRecurring.Input, MarkAsRecurringResponseData> {
    override val operationName: String = "Web_MarkAsRecurring"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val transactionId: String,
        val frequency: String,
    ) {
        companion object {
            fun from(
                transactionId: String,
                req: MarkAsRecurringRequest,
            ): Input = Input(transactionId = transactionId, frequency = req.frequency.value)
        }
    }

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "input" to
                mapOf(
                    "transactionId" to input.transactionId,
                    "frequency" to input.frequency,
                ),
        )

    override fun parseOutput(data: JsonNode): MarkAsRecurringResponseData {
        val node = data.path("markAsRecurring")
        val stream = node.path("stream")
        return MarkAsRecurringResponseData(
            success = node.path("success").asBoolean(false),
            stream =
                RecurringStreamRef(
                    id = stream.path("id").asText(""),
                    name = stream.path("frequency").asTextOrNull(),
                ),
        )
    }
}
