package com.nicholasklaene.monarchbridge.graphql.operations.transactions

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.nicholasklaene.monarchbridge.generated.model.GetCashflowBreakdownResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Cashflow grouped by category, category-group, AND merchant — plus the same overall
 * summary as [GetCashflowSummary]. Use this when you want "where did the money go"
 * not just "how much in/out."
 *
 * Note this hits the SAME GraphQL operation name as GetCashflowSummary
 * (`Web_GetCashFlowPage`) but with a different query body. Monarch resolves by query
 * text; this works fine, just don't be confused by the duplicate operationName.
 *
 * Output is the spec-generated [GetCashflowBreakdownResponseData]; bucket lists and
 * the optional `summary` are free-form `Map<String, Any>` since the upstream shape varies.
 * Accepts the full [TransactionFilters] surface for slicing.
 */
object GetCashflowBreakdown : MonarchOperation<GetCashflowBreakdown.Input, GetCashflowBreakdownResponseData> {
    override val operationName: String = "Web_GetCashFlowPage"
    override val query: String by lazy { GraphQLLoader.load("Web_GetCashFlowBreakdown") }

    data class Input(
        val startDate: String,
        val endDate: String,
        val filters: TransactionFilters = TransactionFilters(),
    )

    override fun variables(input: Input): Map<String, Any?> {
        val withDates = input.filters.copy(startDate = input.startDate, endDate = input.endDate)
        return mapOf("filters" to withDates.toFiltersMap())
    }

    @Suppress("CyclomaticComplexMethod") // Cashflow has 4 result buckets; each adds an if-branch.
    override fun parseOutput(data: JsonNode): GetCashflowBreakdownResponseData {
        val mapper = ObjectMapper()

        @Suppress("UNCHECKED_CAST")
        fun JsonNode.toListOfMaps(): List<Map<String, Any>> =
            if (isArray) map { mapper.convertValue(it, Map::class.java) as Map<String, Any> } else emptyList()
        val sumAgg = data.path("summary")
        val summaryFirst = if (sumAgg.isArray && sumAgg.size() > 0) sumAgg.get(0).path("summary") else sumAgg.path("summary")
        @Suppress("UNCHECKED_CAST")
        return GetCashflowBreakdownResponseData(
            byCategory = data.path("byCategory").toListOfMaps(),
            byCategoryGroup = data.path("byCategoryGroup").toListOfMaps(),
            byMerchant = data.path("byMerchant").toListOfMaps(),
            summary =
                summaryFirst.takeIf { !it.isMissingNode && !it.isNull }?.let {
                    mapper.convertValue(
                        it,
                        Map::class.java,
                    ) as Map<String, Any>
                },
        )
    }
}
