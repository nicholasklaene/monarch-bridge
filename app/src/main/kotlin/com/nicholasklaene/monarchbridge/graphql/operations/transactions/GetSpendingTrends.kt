package com.nicholasklaene.monarchbridge.graphql.operations.transactions

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetSpendingTrendsResponseData
import com.nicholasklaene.monarchbridge.generated.model.SpendingTrendCategory
import com.nicholasklaene.monarchbridge.generated.model.SpendingTrends
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import com.nicholasklaene.monarchbridge.graphql.mapOfNotNull

/** Period-over-period spend trend plus top rising / falling categories. */
object GetSpendingTrends : MonarchOperation<GetSpendingTrends.Input, GetSpendingTrendsResponseData> {
    override val operationName: String = "Web_GetSpendingTrends"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val timeframe: String? = null,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOfNotNull("timeframe" to input.timeframe)

    override fun parseOutput(data: JsonNode): GetSpendingTrendsResponseData {
        val node = data.path("spendingTrends")
        return GetSpendingTrendsResponseData(
            trends =
                SpendingTrends(
                    timeframe = node.path("timeframe").asTextOrNull(),
                    currentPeriodTotal = node.path("currentPeriodTotal").asDoubleOrNull(),
                    previousPeriodTotal = node.path("previousPeriodTotal").asDoubleOrNull(),
                    deltaAmount = node.path("deltaAmount").asDoubleOrNull(),
                    deltaPercent = node.path("deltaPercent").asDoubleOrNull(),
                    risingCategories = node.path("risingCategories").map { parseTrendCategory(it) },
                    fallingCategories = node.path("fallingCategories").map { parseTrendCategory(it) },
                ),
        )
    }

    private fun parseTrendCategory(c: JsonNode): SpendingTrendCategory =
        SpendingTrendCategory(
            categoryId = c.path("categoryId").asText(""),
            name = c.path("name").asTextOrNull(),
            deltaPercent = c.path("deltaPercent").asDoubleOrNull(),
        )
}
