package com.nicholasklaene.monarchbridge.graphql.operations.categories

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetTaxCategoryAggregatesResponseData
import com.nicholasklaene.monarchbridge.generated.model.TaxCategoryAggregateRow
import com.nicholasklaene.monarchbridge.generated.model.TaxCategoryWithSystem
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asIntOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import java.time.LocalDate

/**
 * Sum + count of transactions grouped by category for `[start, end]`. Each row carries the
 * category's `systemCategory` so callers can map directly to tax schedules.
 *
 * Output is the spec-generated inner `data` payload.
 */
object GetTaxCategoryAggregates : MonarchOperation<GetTaxCategoryAggregates.Input, GetTaxCategoryAggregatesResponseData> {
    override val operationName: String = "Web_GetTaxPrepCategoryAggregates"
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

    override fun parseOutput(data: JsonNode): GetTaxCategoryAggregatesResponseData =
        GetTaxCategoryAggregatesResponseData(
            rows =
                data.path("aggregates").mapNotNull { agg ->
                    val cat = agg.path("groupBy").path("category")
                    if (cat.isMissingNode || cat.isNull) {
                        null
                    } else {
                        val summary = agg.path("summary")
                        TaxCategoryAggregateRow(
                            category =
                                TaxCategoryWithSystem(
                                    id = cat.path("id").asText(""),
                                    name = cat.path("name").asTextOrNull(),
                                    icon = cat.path("icon").asTextOrNull(),
                                    systemCategory = cat.path("systemCategory").asTextOrNull(),
                                ),
                            sum = summary.path("sum").asDoubleOrNull(),
                            count = summary.path("count").asIntOrNull(),
                        )
                    }
                },
        )
}
