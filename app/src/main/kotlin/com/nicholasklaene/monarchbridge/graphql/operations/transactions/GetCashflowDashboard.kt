package com.nicholasklaene.monarchbridge.graphql.operations.transactions

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.CashflowDayPoint
import com.nicholasklaene.monarchbridge.generated.model.GetCashflowDashboardResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import java.time.LocalDate

/**
 * Day-by-day expense series for a date window. Monarch returns summary-per-day
 * with `sumExpense` only; we lift each day's bucket into a flat CashflowDayPoint.
 */
object GetCashflowDashboard : MonarchOperation<GetCashflowDashboard.Input, GetCashflowDashboardResponseData> {
    override val operationName: String = "Common_GetCashFlowDashboard"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val startDate: LocalDate?,
        val endDate: LocalDate?,
    )

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "filters" to
                mutableMapOf<String, Any?>().apply {
                    input.startDate?.let { put("startDate", it.toString()) }
                    input.endDate?.let { put("endDate", it.toString()) }
                },
        )

    override fun parseOutput(data: JsonNode): GetCashflowDashboardResponseData =
        GetCashflowDashboardResponseData(
            byDay =
                data.path("byDay").mapNotNull { agg ->
                    val day = agg.path("groupBy").path("day").asText("")
                    if (day.isBlank()) {
                        null
                    } else {
                        CashflowDayPoint(
                            day = LocalDate.parse(day),
                            sumExpense = agg.path("summary").path("sumExpense").asDoubleOrNull(),
                        )
                    }
                },
        )
}
