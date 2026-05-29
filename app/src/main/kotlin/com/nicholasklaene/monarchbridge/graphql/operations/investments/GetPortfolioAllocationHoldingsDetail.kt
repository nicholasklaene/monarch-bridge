package com.nicholasklaene.monarchbridge.graphql.operations.investments

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetPortfolioAllocationHoldingsDetailResponseData
import com.nicholasklaene.monarchbridge.generated.model.PortfolioAllocationHolding
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asIntOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/**
 * Drill-down: lists individual holdings inside one allocation bucket (e.g. every equity
 * in the "Equities" bucket). Pair with [GetPortfolioAllocation] to first identify
 * buckets, then drill into one via `classificationField` + `classificationValue`.
 */
object GetPortfolioAllocationHoldingsDetail :
    MonarchOperation<
        GetPortfolioAllocationHoldingsDetail.Input,
        GetPortfolioAllocationHoldingsDetailResponseData,
    > {
    override val operationName: String = "Web_GetAllocationHoldingsDetail"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val classificationField: String,
        val classificationValue: String,
        val accountIds: List<String>? = null,
        val limit: Int? = null,
        val offset: Int? = null,
    )

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "porfolioInput" to PortfolioAllocationParsers.buildPortfolioInput(input.accountIds),
            "classificationField" to input.classificationField,
            "classificationValue" to input.classificationValue,
            "limit" to input.limit,
            "offset" to input.offset,
        )

    override fun parseOutput(data: JsonNode): GetPortfolioAllocationHoldingsDetailResponseData {
        val detail = data.path("portfolio").path("allocationHoldingsDetail")
        return GetPortfolioAllocationHoldingsDetailResponseData(
            holdings =
                detail.path("holdings").map { node ->
                    PortfolioAllocationHolding(
                        securityName = node.path("securityName").asText(""),
                        holdingIds =
                            node
                                .path("holdingIds")
                                .takeIf { it.isArray }
                                ?.mapNotNull { it.asTextOrNull() },
                        ticker = node.path("ticker").asTextOrNull(),
                        securityType = node.path("securityType").asTextOrNull(),
                        securityTypeDisplay = node.path("securityTypeDisplay").asTextOrNull(),
                        quantity = node.path("quantity").asDoubleOrNull(),
                        value = node.path("value").asDoubleOrNull(),
                    )
                },
            totalCount = detail.path("totalCount").asIntOrNull(),
        )
    }
}
