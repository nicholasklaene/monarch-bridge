package com.nicholasklaene.monarchbridge.graphql.operations.investments

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetPortfolioAllocationByHoldingsResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Allocation breakdown grouped per holding (ticker / security name). Each row is one
 * security with its percent of portfolio and total dollar value, capped at `limit`.
 */
object GetPortfolioAllocationByHoldings :
    MonarchOperation<
        GetPortfolioAllocationByHoldings.Input,
        GetPortfolioAllocationByHoldingsResponseData,
    > {
    override val operationName: String = "Web_GetAllocationByHoldings"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val accountIds: List<String>? = null,
        val limit: Int? = null,
    )

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "porfolioInput" to PortfolioAllocationParsers.buildPortfolioInput(input.accountIds),
            "limit" to input.limit,
        )

    override fun parseOutput(data: JsonNode): GetPortfolioAllocationByHoldingsResponseData =
        GetPortfolioAllocationByHoldingsResponseData(
            buckets = data.path("portfolio").path("allocationSimple").map(PortfolioAllocationParsers::parseBucket),
        )
}
