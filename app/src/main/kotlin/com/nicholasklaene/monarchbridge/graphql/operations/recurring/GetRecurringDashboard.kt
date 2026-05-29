package com.nicholasklaene.monarchbridge.graphql.operations.recurring

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.DashboardRecurringItem
import com.nicholasklaene.monarchbridge.generated.model.GetRecurringDashboardResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asBooleanOrNull
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import java.time.LocalDate

/**
 * Upcoming recurring transaction items plus a `remainingDueAmount` total over the
 * same window. Shape suited for a "bills due this month" dashboard widget.
 */
object GetRecurringDashboard : MonarchOperation<GetRecurringDashboard.Input, GetRecurringDashboardResponseData> {
    override val operationName: String = "Web_GetDashboardUpcomingRecurringTransactionItems"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val startDate: LocalDate,
        val endDate: LocalDate,
        val includeLiabilities: Boolean?,
    )

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "startDate" to input.startDate.toString(),
            "endDate" to input.endDate.toString(),
            "includeLiabilities" to input.includeLiabilities,
        )

    override fun parseOutput(data: JsonNode): GetRecurringDashboardResponseData =
        GetRecurringDashboardResponseData(
            remainingDueAmount = data.path("recurringRemainingDue").path("amount").asDoubleOrNull(),
            items =
                data.path("recurringTransactionItems").mapNotNull { item ->
                    val day = item.path("date").asText("")
                    if (day.isBlank()) {
                        null
                    } else {
                        DashboardRecurringItem(
                            date = LocalDate.parse(day),
                            amount = item.path("amount").asDoubleOrNull(),
                            isPast = item.path("isPast").asBooleanOrNull(),
                            streamId = item.path("stream").path("id").asTextOrNull(),
                            streamName = item.path("stream").path("name").asTextOrNull(),
                            frequency = item.path("stream").path("frequency").asTextOrNull(),
                            logoUrl = item.path("stream").path("logoUrl").asTextOrNull(),
                            merchantId =
                                item
                                    .path("stream")
                                    .path("merchant")
                                    .path("id")
                                    .asTextOrNull(),
                            accountId = item.path("account").path("id").asTextOrNull(),
                        )
                    }
                },
        )
}
