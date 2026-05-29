package com.nicholasklaene.monarchbridge.graphql.operations.recurring

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetRecurringForecastResponseData
import com.nicholasklaene.monarchbridge.generated.model.RecurringForecastEntry
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import java.time.LocalDate

/**
 * Forward calendar of forecasted recurring occurrences across a date window. One entry per
 * occurrence (not per stream) with date, expected amount, merchant, and linked stream id.
 */
object GetRecurringForecast : MonarchOperation<GetRecurringForecast.Input, GetRecurringForecastResponseData> {
    override val operationName: String = "Web_GetRecurringForecast"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val startDate: LocalDate? = null,
        val endDate: LocalDate? = null,
    )

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "startDate" to input.startDate?.toString(),
            "endDate" to input.endDate?.toString(),
        )

    override fun parseOutput(data: JsonNode): GetRecurringForecastResponseData =
        GetRecurringForecastResponseData(
            forecast =
                data.path("recurringTransactionForecast").path("forecast").map { e ->
                    RecurringForecastEntry(
                        date = LocalDate.parse(e.path("date").asText("1970-01-01")),
                        amount = e.path("amount").asDoubleOrNull(),
                        merchantName = e.path("merchantName").asTextOrNull(),
                        streamId = e.path("streamId").asTextOrNull(),
                    )
                },
        )
}
