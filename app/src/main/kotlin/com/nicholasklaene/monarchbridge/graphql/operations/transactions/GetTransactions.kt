package com.nicholasklaene.monarchbridge.graphql.operations.transactions

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.ListTransactionsResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.JsonMappers
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Paginated transactions with full `TransactionFilterInput` parity (see [TransactionFilters]).
 * Output is the spec-generated [ListTransactionsResponseData].
 */
object GetTransactions : MonarchOperation<GetTransactions.Input, ListTransactionsResponseData> {
    override val operationName: String = "GetTransactionsList"
    override val query: String by lazy {
        GraphQLLoader.load(operationName, fragments = listOf("TransactionOverviewFields"))
    }

    data class Input(
        val startDate: String,
        val endDate: String,
        val filters: TransactionFilters = TransactionFilters(),
        val limit: Int? = null,
        val offset: Int? = null,
        /**
         * Monarch's `TransactionOrdering` enum. Known accepted values: `"date"`, `"amount"`.
         * Direction is fixed (always descending) — there is no Monarch-side asc/desc toggle.
         * Null = Monarch's default (`date` desc).
         */
        val orderBy: String? = null,
    )

    override fun variables(input: Input): Map<String, Any?> {
        // Date window lives on the underlying filters map; copy the required dates in.
        val withDates = input.filters.copy(startDate = input.startDate, endDate = input.endDate)
        return buildMap<String, Any?> {
            put("filters", withDates.toFiltersMap())
            if (input.limit != null) put("limit", input.limit)
            if (input.offset != null) put("offset", input.offset)
            if (input.orderBy != null) put("orderBy", input.orderBy)
        }
    }

    override fun parseOutput(data: JsonNode): ListTransactionsResponseData {
        val all = data.path("allTransactions")
        return ListTransactionsResponseData(
            totalCount = all.path("totalCount").asInt(0),
            results = all.path("results").map(JsonMappers::parseTransaction),
        )
    }
}
