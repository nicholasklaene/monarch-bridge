package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.CashflowReport
import com.nicholasklaene.monarchbridge.generated.model.CashflowReportMonth
import com.nicholasklaene.monarchbridge.generated.model.GetCashflowReportResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import java.time.LocalDate

/**
 * Full cashflow report: total income / expense / net for a window plus per-month series.
 * Distinct from `GET /v1/cashflow` (a lighter summary aggregation); this is the per-month
 * chart shape the web Reports tab fires.
 */
object GetCashflowReport : MonarchOperation<GetCashflowReport.Input, GetCashflowReportResponseData> {
    override val operationName: String = "Web_GetCashflowReport"
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

    override fun parseOutput(data: JsonNode): GetCashflowReportResponseData {
        val node = data.path("cashflowReport")
        return GetCashflowReportResponseData(
            report =
                CashflowReport(
                    totalIncome = node.path("totalIncome").asDoubleOrNull(),
                    totalExpense = node.path("totalExpense").asDoubleOrNull(),
                    netCashflow = node.path("netCashflow").asDoubleOrNull(),
                    months =
                        node.path("months").map { m ->
                            CashflowReportMonth(
                                month = m.path("month").asTextOrNull(),
                                income = m.path("income").asDoubleOrNull(),
                                expense = m.path("expense").asDoubleOrNull(),
                                net = m.path("net").asDoubleOrNull(),
                            )
                        },
                ),
        )
    }
}
