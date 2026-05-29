package com.nicholasklaene.monarchbridge.graphql.operations.investments

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetPortfolioAllocationByHoldingsResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Allocation breakdown grouped per investments account (rather than per security). Each
 * row is one account with its percent of portfolio and total dollar value. The
 * `ResponseData` is the same shape Monarch returns for by-holdings (the OpenAPI
 * generator deduplicated the two identical envelopes into one type).
 */
object GetPortfolioAllocationByAccount :
    MonarchOperation<
        GetPortfolioAllocationByAccount.Input,
        GetPortfolioAllocationByHoldingsResponseData,
    > {
    override val operationName: String = "Web_GetAllocationByAccount"
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
