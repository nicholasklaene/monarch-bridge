package com.nicholasklaene.monarchbridge.graphql.operations.recurring

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.nicholasklaene.monarchbridge.generated.model.ListRecurringAggregateResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Month-by-month aggregate recurring view. Groups occurrences by status (`completed`,
 * `remaining`, etc.) within the window and rolls up `expense`/`creditCard`/`income` totals
 * both per-group and across the whole window.
 *
 * Pass-through Map shape since the aggregation tree is broad.
 */
object GetAggregatedRecurringItems :
    MonarchOperation<GetAggregatedRecurringItems.Input, ListRecurringAggregateResponseData> {
    override val operationName: String = "Common_GetAggregatedRecurringItems"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val startDate: String,
        val endDate: String,
    )

    override fun variables(input: Input): Map<String, Any?> =
        mapOf("startDate" to input.startDate, "endDate" to input.endDate, "filters" to null)

    override fun parseOutput(data: JsonNode): ListRecurringAggregateResponseData {
        val node = data.path("aggregatedRecurringItems")
        if (node.isMissingNode || node.isNull) {
            return ListRecurringAggregateResponseData(aggregate = null)
        }
        val mapper = ObjectMapper()
        @Suppress("UNCHECKED_CAST")
        return ListRecurringAggregateResponseData(
            aggregate = mapper.convertValue(node, Map::class.java) as Map<String, Any>,
        )
    }
}
