package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetSavingsRateReportResponseData
import com.nicholasklaene.monarchbridge.generated.model.SavingsRateMonth
import com.nicholasklaene.monarchbridge.generated.model.SavingsRateReport
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import java.time.LocalDate

/**
 * Month-over-month savings rate report. `overallSavingsRate` is the window aggregate
 * (income - expense) / income; `monthlyRates` is the per-month series. All rates are
 * fractions (`0.42` = 42%).
 */
object GetSavingsRateReport : MonarchOperation<GetSavingsRateReport.Input, GetSavingsRateReportResponseData> {
    override val operationName: String = "Web_GetSavingsRateReport"
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

    override fun parseOutput(data: JsonNode): GetSavingsRateReportResponseData {
        val node = data.path("savingsRateReport")
        return GetSavingsRateReportResponseData(
            report =
                SavingsRateReport(
                    overallSavingsRate = node.path("overallSavingsRate").asDoubleOrNull(),
                    monthlyRates =
                        node.path("monthlyRates").map { m ->
                            SavingsRateMonth(
                                month = m.path("month").asTextOrNull(),
                                savingsRate = m.path("savingsRate").asDoubleOrNull(),
                                income = m.path("income").asDoubleOrNull(),
                                expense = m.path("expense").asDoubleOrNull(),
                            )
                        },
                ),
        )
    }
}
