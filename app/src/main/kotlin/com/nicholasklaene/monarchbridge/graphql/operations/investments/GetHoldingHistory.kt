package com.nicholasklaene.monarchbridge.graphql.operations.investments

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetHoldingHistoryResponseData
import com.nicholasklaene.monarchbridge.generated.model.HoldingHistoryPoint
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import java.time.LocalDate

/**
 * Per-day quantity / value / price series for one holding. Backs the holding drawer chart
 * in the web Investments tab.
 */
object GetHoldingHistory : MonarchOperation<GetHoldingHistory.Input, GetHoldingHistoryResponseData> {
    override val operationName: String = "Web_GetHoldingHistory"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val holdingId: String,
        val startDate: LocalDate? = null,
        val endDate: LocalDate? = null,
    )

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "holdingId" to input.holdingId,
            "startDate" to input.startDate?.toString(),
            "endDate" to input.endDate?.toString(),
        )

    override fun parseOutput(data: JsonNode): GetHoldingHistoryResponseData =
        GetHoldingHistoryResponseData(
            history =
                data.path("holdingHistory").path("history").map { p ->
                    HoldingHistoryPoint(
                        date = LocalDate.parse(p.path("date").asText("1970-01-01")),
                        quantity = p.path("quantity").asDoubleOrNull(),
                        value = p.path("value").asDoubleOrNull(),
                        price = p.path("price").asDoubleOrNull(),
                    )
                },
        )
}
