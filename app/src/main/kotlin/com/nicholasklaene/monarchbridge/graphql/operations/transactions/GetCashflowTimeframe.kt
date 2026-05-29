package com.nicholasklaene.monarchbridge.graphql.operations.transactions

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.CashflowTimeframeBucket
import com.nicholasklaene.monarchbridge.generated.model.GetCashflowTimeframeResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import java.time.LocalDate

/**
 * Yearly / monthly / quarterly cashflow summaries. Each bucket has its own period
 * label (year/month/quarter) and a {sumIncome, sumExpense, savings, savingsRate}
 * summary.
 */
object GetCashflowTimeframe : MonarchOperation<GetCashflowTimeframe.Input, GetCashflowTimeframeResponseData> {
    override val operationName: String = "Common_GetCashFlowTimeframeAggregates"
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

    override fun parseOutput(data: JsonNode): GetCashflowTimeframeResponseData =
        GetCashflowTimeframeResponseData(
            byYear = parseBuckets(data.path("byYear"), "year"),
            byMonth = parseBuckets(data.path("byMonth"), "month"),
            byQuarter = parseBuckets(data.path("byQuarter"), "quarter"),
        )

    internal fun parseBuckets(
        node: JsonNode,
        labelKey: String,
    ): List<CashflowTimeframeBucket> =
        node.map { agg ->
            CashflowTimeframeBucket(
                period = agg.path("groupBy").path(labelKey).asText(""),
                savings = agg.path("summary").path("savings").asDoubleOrNull(),
                savingsRate = agg.path("summary").path("savingsRate").asDoubleOrNull(),
                sumIncome = agg.path("summary").path("sumIncome").asDoubleOrNull(),
                sumExpense = agg.path("summary").path("sumExpense").asDoubleOrNull(),
            )
        }
}
