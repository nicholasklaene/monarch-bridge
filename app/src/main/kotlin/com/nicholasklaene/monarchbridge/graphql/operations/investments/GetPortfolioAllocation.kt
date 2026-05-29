package com.nicholasklaene.monarchbridge.graphql.operations.investments

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetPortfolioAllocationResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull

/**
 * Pie-chart-style allocation breakdown for the portfolio (or a subset filtered via
 * `accountIds`). Each bucket is one classification value (security type, asset class,
 * sector) with its percent of portfolio and total dollar value. Also surfaces the
 * portfolio total value for downstream rebalancing math.
 */
object GetPortfolioAllocation : MonarchOperation<GetPortfolioAllocation.Input, GetPortfolioAllocationResponseData> {
    override val operationName: String = "Web_GetAllocation"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val accountIds: List<String>? = null,
        val classificationField: String? = null,
    )

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "porfolioInput" to PortfolioAllocationParsers.buildPortfolioInput(input.accountIds),
            "classificationField" to input.classificationField,
        )

    override fun parseOutput(data: JsonNode): GetPortfolioAllocationResponseData {
        val portfolio = data.path("portfolio")
        return GetPortfolioAllocationResponseData(
            buckets = portfolio.path("allocationSimple").map(PortfolioAllocationParsers::parseBucket),
            totalValue = portfolio.path("performance").path("totalValue").asDoubleOrNull(),
        )
    }
}
