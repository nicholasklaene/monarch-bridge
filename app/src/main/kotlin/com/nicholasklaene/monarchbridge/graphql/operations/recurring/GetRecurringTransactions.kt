package com.nicholasklaene.monarchbridge.graphql.operations.recurring

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.nicholasklaene.monarchbridge.generated.model.ListRecurringResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Upcoming + recent recurring transaction occurrences (subscriptions, recurring
 * bills, regular paychecks). Returns one entry per expected occurrence in the
 * date window — each links back to its stream (the recurring rule).
 *
 * Output is the spec-generated inner `data` payload (RecurringResponse-shaped).
 */
object GetRecurringTransactions : MonarchOperation<GetRecurringTransactions.Input, ListRecurringResponseData> {
    override val operationName: String = "Web_GetUpcomingRecurringTransactionItems"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val startDate: String,
        val endDate: String,
    )

    override fun variables(input: Input): Map<String, Any?> =
        mapOf("startDate" to input.startDate, "endDate" to input.endDate, "filters" to null)

    override fun parseOutput(data: JsonNode): ListRecurringResponseData {
        val mapper = ObjectMapper()
        @Suppress("UNCHECKED_CAST")
        return ListRecurringResponseData(
            items = data.path("recurringTransactionItems").map { mapper.convertValue(it, Map::class.java) as Map<String, Any> },
        )
    }
}
