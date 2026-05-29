package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetIncomeVsExpenseYoyResponseData
import com.nicholasklaene.monarchbridge.generated.model.YoyPoint
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/**
 * Year-over-year income vs. expense comparison. Each point is one period
 * (typically a month) with income and expense totals over the last `years` years.
 */
object GetIncomeVsExpenseYoy : MonarchOperation<GetIncomeVsExpenseYoy.Input, GetIncomeVsExpenseYoyResponseData> {
    override val operationName: String = "Common_GetIncomeVsExpenseYoy"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val years: Int,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("years" to input.years)

    override fun parseOutput(data: JsonNode): GetIncomeVsExpenseYoyResponseData =
        GetIncomeVsExpenseYoyResponseData(
            points =
                data.path("incomeVsExpenseYoy").path("points").map { p ->
                    YoyPoint(
                        period = p.path("period").asTextOrNull(),
                        income = p.path("income").asDoubleOrNull(),
                        expense = p.path("expense").asDoubleOrNull(),
                    )
                },
        )
}
