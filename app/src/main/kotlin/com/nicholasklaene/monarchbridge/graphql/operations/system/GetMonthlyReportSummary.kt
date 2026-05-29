package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetMonthlyReportSummaryResponseData
import com.nicholasklaene.monarchbridge.generated.model.MonthlyReportSummary
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import java.time.LocalDate

/**
 * One-month summary bundle Monarch sends to the "monthly recap" email and the web
 * monthly-summary widget. Single-row aggregate covering income, spending, savings rate,
 * and the top merchant/category callouts.
 */
object GetMonthlyReportSummary :
    MonarchOperation<GetMonthlyReportSummary.Input, GetMonthlyReportSummaryResponseData> {
    override val operationName: String = "Web_GetMonthlyReportSummary"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val month: LocalDate,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("month" to input.month.toString())

    override fun parseOutput(data: JsonNode): GetMonthlyReportSummaryResponseData {
        val node = data.path("monthlyReportSummary")
        return GetMonthlyReportSummaryResponseData(
            summary =
                MonthlyReportSummary(
                    month = node.path("month").asTextOrNull(),
                    netIncome = node.path("netIncome").asDoubleOrNull(),
                    totalSpending = node.path("totalSpending").asDoubleOrNull(),
                    totalIncome = node.path("totalIncome").asDoubleOrNull(),
                    savingsRate = node.path("savingsRate").asDoubleOrNull(),
                    topMerchant = node.path("topMerchant").asTextOrNull(),
                    topCategory = node.path("topCategory").asTextOrNull(),
                    biggestSpend = node.path("biggestSpend").asDoubleOrNull(),
                ),
        )
    }
}
