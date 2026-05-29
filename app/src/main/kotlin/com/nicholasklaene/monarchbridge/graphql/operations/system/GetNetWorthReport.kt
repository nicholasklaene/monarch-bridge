package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetNetWorthReportResponseData
import com.nicholasklaene.monarchbridge.generated.model.NetWorthReport
import com.nicholasklaene.monarchbridge.generated.model.NetWorthReportPoint
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import java.time.LocalDate

/**
 * Net-worth chart series for the requested window. Includes both the starting + current
 * net-worth and per-date balance series. Mirrors Monarch's web Net Worth tab.
 */
object GetNetWorthReport : MonarchOperation<GetNetWorthReport.Input, GetNetWorthReportResponseData> {
    override val operationName: String = "Web_GetNetWorthReport"
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

    override fun parseOutput(data: JsonNode): GetNetWorthReportResponseData {
        val node = data.path("netWorthReport")
        return GetNetWorthReportResponseData(
            report =
                NetWorthReport(
                    currentNetWorth = node.path("currentNetWorth").asDoubleOrNull(),
                    startingNetWorth = node.path("startingNetWorth").asDoubleOrNull(),
                    changeAmount = node.path("changeAmount").asDoubleOrNull(),
                    changePercent = node.path("changePercent").asDoubleOrNull(),
                    series =
                        node.path("series").map { p ->
                            NetWorthReportPoint(
                                date = LocalDate.parse(p.path("date").asText("1970-01-01")),
                                balance = p.path("balance").asDoubleOrNull(),
                            )
                        },
                ),
        )
    }
}
