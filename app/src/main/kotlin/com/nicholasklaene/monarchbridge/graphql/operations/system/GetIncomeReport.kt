package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetIncomeReportResponseData
import com.nicholasklaene.monarchbridge.generated.model.IncomeReport
import com.nicholasklaene.monarchbridge.generated.model.IncomeReportSource
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import java.time.LocalDate

/**
 * Income breakdown for a date window: total income, average per month, and per-source split.
 * Wraps Monarch's `incomeReport` query (web Reports page, Income tab).
 */
object GetIncomeReport : MonarchOperation<GetIncomeReport.Input, GetIncomeReportResponseData> {
    override val operationName: String = "Web_GetIncomeReport"
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

    override fun parseOutput(data: JsonNode): GetIncomeReportResponseData {
        val node = data.path("incomeReport")
        return GetIncomeReportResponseData(
            report =
                IncomeReport(
                    totalIncome = node.path("totalIncome").asDoubleOrNull(),
                    averageMonthlyIncome = node.path("averageMonthlyIncome").asDoubleOrNull(),
                    sources =
                        node.path("sources").map { s ->
                            IncomeReportSource(
                                categoryId = s.path("categoryId").asText(""),
                                name = s.path("name").asText(""),
                                amount = s.path("amount").asDoubleOrNull(),
                                percentOfTotal = s.path("percentOfTotal").asDoubleOrNull(),
                            )
                        },
                ),
        )
    }
}
