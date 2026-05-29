package com.nicholasklaene.monarchbridge.graphql.operations.recurring

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.nicholasklaene.monarchbridge.generated.model.ListAllRecurringResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Detailed stream-shaped recurring view. Returns one entry per recurring transaction stream
 * (NOT per occurrence — see [GetRecurringTransactions] for the per-date calendar view), each
 * carrying the stream definition plus the next forecasted occurrence and the merchant /
 * category / account references.
 *
 * Pass-through Map shape since the stream tree is broad and stable.
 */
object GetAllRecurringTransactionItems :
    MonarchOperation<GetAllRecurringTransactionItems.Input, ListAllRecurringResponseData> {
    override val operationName: String = "Common_GetAllRecurringTransactionItems"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val includeLiabilities: Boolean? = null,
        val includePending: Boolean? = null,
    )

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "filters" to null,
            "includeLiabilities" to input.includeLiabilities,
            "includePending" to input.includePending,
        )

    override fun parseOutput(data: JsonNode): ListAllRecurringResponseData {
        val mapper = ObjectMapper()
        @Suppress("UNCHECKED_CAST")
        return ListAllRecurringResponseData(
            items =
                data.path("recurringTransactionStreams").map {
                    mapper.convertValue(it, Map::class.java) as Map<String, Any>
                },
        )
    }
}
