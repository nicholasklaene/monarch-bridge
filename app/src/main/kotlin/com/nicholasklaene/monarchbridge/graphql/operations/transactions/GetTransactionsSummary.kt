package com.nicholasklaene.monarchbridge.graphql.operations.transactions

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetTransactionsSummaryResponseData
import com.nicholasklaene.monarchbridge.generated.model.TransactionsSummary
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import java.time.LocalDate

/**
 * Aggregate stats across a transaction filter window — count, sum, avg, min/max, first/last.
 * Cheaper than fetching every transaction when all you want is the totals.
 *
 * Like [GetCashflowSummary], `aggregates(...)` can return either a single object
 * (no fillEmptyValues+groupBy) or an array. Both forms wrap totals under `summary`.
 * Output is the spec-generated [GetTransactionsSummaryResponseData].
 *
 * Accepts the full [TransactionFilters] surface so callers can summarize a slice (e.g. only
 * recurring transactions, or only those for one tag) without round-tripping every row.
 */
object GetTransactionsSummary : MonarchOperation<GetTransactionsSummary.Input, GetTransactionsSummaryResponseData> {
    override val operationName: String = "GetTransactionsPage"

    // The resource file is named after this Kotlin object (not the GraphQL op name), since
    // Monarch reuses `GetTransactionsPage` for multiple queries with different shapes.
    override val query: String by lazy { GraphQLLoader.load("GetTransactionsSummary") }

    data class Input(
        val startDate: String? = null,
        val endDate: String? = null,
        val filters: TransactionFilters = TransactionFilters(),
    )

    override fun variables(input: Input): Map<String, Any?> {
        val withDates = input.filters.copy(startDate = input.startDate, endDate = input.endDate)
        return mapOf("filters" to withDates.toFiltersMap())
    }

    override fun parseOutput(data: JsonNode): GetTransactionsSummaryResponseData {
        val agg = data.path("aggregates")
        val node = if (agg.isArray && agg.size() > 0) agg.get(0).path("summary") else agg.path("summary")
        return GetTransactionsSummaryResponseData(
            summary =
                TransactionsSummary(
                    count = node.path("count").asInt(0),
                    sum = node.path("sum").asDoubleOrNull(),
                    avg = node.path("avg").asDoubleOrNull(),
                    min = node.path("min").asDoubleOrNull(),
                    max = node.path("max").asDoubleOrNull(),
                    first = node.path("first").asTextOrNull()?.let(LocalDate::parse),
                    last = node.path("last").asTextOrNull()?.let(LocalDate::parse),
                ),
        )
    }
}
