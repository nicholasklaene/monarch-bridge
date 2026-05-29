package com.nicholasklaene.monarchbridge.graphql.operations.investments

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetSecurityHistoricalPerformanceResponseData
import com.nicholasklaene.monarchbridge.generated.model.SecurityHistoricalPoint
import com.nicholasklaene.monarchbridge.generated.model.SecurityHistoricalSummary
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import java.time.LocalDate

/**
 * Per-day price and return chart for one security plus its current and closing price.
 * `chart[].returnPercent` is the cumulative return from the window start as a fraction
 * (`0.05` = 5%). Window bounds are optional; Monarch falls back to its own defaults
 * (typically YTD) when omitted.
 */
object GetSecurityHistoricalPerformance :
    MonarchOperation<
        GetSecurityHistoricalPerformance.Input,
        GetSecurityHistoricalPerformanceResponseData,
    > {
    override val operationName: String = "Web_GetHoldingDrawerHistoricalPerformance"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val securityId: String,
        val startDate: LocalDate? = null,
        val endDate: LocalDate? = null,
    )

    override fun variables(input: Input): Map<String, Any?> {
        val nested = mutableMapOf<String, Any?>("securityId" to input.securityId)
        input.startDate?.let { nested["startDate"] = it.toString() }
        input.endDate?.let { nested["endDate"] = it.toString() }
        return mapOf("input" to nested)
    }

    override fun parseOutput(data: JsonNode): GetSecurityHistoricalPerformanceResponseData {
        val payload = data.path("securityHistoricalPerformance")
        val security = payload.path("security")
        return GetSecurityHistoricalPerformanceResponseData(
            security =
                SecurityHistoricalSummary(
                    id = security.path("id").asText(""),
                    currentPrice = security.path("currentPrice").asDoubleOrNull(),
                    closingPrice = security.path("closingPrice").asDoubleOrNull(),
                    currentPriceUpdatedAt = security.path("currentPriceUpdatedAt").asTextOrNull(),
                ),
            chart =
                payload.path("historicalChart").map { node ->
                    SecurityHistoricalPoint(
                        date = LocalDate.parse(node.path("date").asText("1970-01-01")),
                        returnPercent = node.path("returnPercent").asDoubleOrNull(),
                        value = node.path("value").asDoubleOrNull(),
                    )
                },
        )
    }
}
