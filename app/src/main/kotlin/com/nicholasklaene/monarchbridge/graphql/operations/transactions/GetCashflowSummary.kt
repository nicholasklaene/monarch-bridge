package com.nicholasklaene.monarchbridge.graphql.operations.transactions

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.CashflowSummary
import com.nicholasklaene.monarchbridge.generated.model.GetCashflowResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull

/**
 * Income / expense / savings aggregates for a date range, optionally narrowed by the full
 * [TransactionFilters] surface. Output is the spec-generated [GetCashflowResponseData].
 */
object GetCashflowSummary : MonarchOperation<GetCashflowSummary.Input, GetCashflowResponseData> {
    override val operationName: String = "Web_GetCashFlowPage"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val startDate: String,
        val endDate: String,
        val filters: TransactionFilters = TransactionFilters(),
    )

    override fun variables(input: Input): Map<String, Any?> {
        val withDates = input.filters.copy(startDate = input.startDate, endDate = input.endDate)
        return mapOf("filters" to withDates.toFiltersMap())
    }

    /**
     * Monarch's `aggregates(...)` returns either a single object (when fillEmptyValues+groupBy
     * are not set) OR an array (when they are). Both forms wrap the totals in a nested
     * `summary` field. Handle both shapes so the typed Output is consistent regardless of
     * which form Monarch chose for this filter combination.
     */
    override fun parseOutput(data: JsonNode): GetCashflowResponseData {
        val agg = data.path("summary")
        val first = if (agg.isArray && agg.size() > 0) agg.get(0) else agg
        val node = first.path("summary")
        return GetCashflowResponseData(
            summary =
                CashflowSummary(
                    sumIncome = node.path("sumIncome").asDoubleOrNull(),
                    sumExpense = node.path("sumExpense").asDoubleOrNull(),
                    savings = node.path("savings").asDoubleOrNull(),
                    savingsRate = node.path("savingsRate").asDoubleOrNull(),
                ),
        )
    }
}
