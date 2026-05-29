package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.CalendarEvent
import com.nicholasklaene.monarchbridge.generated.model.GetCalendarEventsResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import java.time.LocalDate

/**
 * Bills, recurring transactions, and paychecks projected onto a calendar shape. Each entry
 * has the calendar date, event type, title, optional amount, and source-record id.
 */
object GetCalendarEvents : MonarchOperation<GetCalendarEvents.Input, GetCalendarEventsResponseData> {
    override val operationName: String = "Web_GetCalendarEvents"
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

    override fun parseOutput(data: JsonNode): GetCalendarEventsResponseData =
        GetCalendarEventsResponseData(
            events =
                data.path("calendarEvents").path("events").map { e ->
                    CalendarEvent(
                        date = LocalDate.parse(e.path("date").asText("1970-01-01")),
                        type = e.path("type").asTextOrNull(),
                        title = e.path("title").asTextOrNull(),
                        amount = e.path("amount").asDoubleOrNull(),
                        referenceId = e.path("referenceId").asTextOrNull(),
                    )
                },
        )
}
