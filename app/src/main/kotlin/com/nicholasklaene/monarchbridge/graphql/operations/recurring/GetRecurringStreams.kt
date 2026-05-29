package com.nicholasklaene.monarchbridge.graphql.operations.recurring

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.nicholasklaene.monarchbridge.generated.model.ListRecurringStreamsResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Underlying recurring-transaction stream definitions — the parent rules that drive each
 * upcoming occurrence. Includes review status, base date, frequency, and any linked
 * credit-report liability account. Use this to inspect or build editing UIs for recurrence
 * rules; pair with [UpdateMerchantRecurrence] to mutate.
 */
object GetRecurringStreams :
    MonarchOperation<GetRecurringStreams.Input, ListRecurringStreamsResponseData> {
    override val operationName: String = "Common_GetRecurringStreams"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val includeLiabilities: Boolean? = null,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("includeLiabilities" to input.includeLiabilities)

    override fun parseOutput(data: JsonNode): ListRecurringStreamsResponseData {
        val mapper = ObjectMapper()
        @Suppress("UNCHECKED_CAST")
        return ListRecurringStreamsResponseData(
            streams =
                data.path("recurringTransactionStreams").map {
                    mapper.convertValue(it, Map::class.java) as Map<String, Any>
                },
        )
    }
}
