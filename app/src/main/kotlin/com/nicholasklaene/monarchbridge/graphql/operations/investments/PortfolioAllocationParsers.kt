package com.nicholasklaene.monarchbridge.graphql.operations.investments

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.PortfolioAllocationBucket
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/**
 * Shared parsing for the `allocation*` query family. Every variant (full / by-holdings /
 * by-account) returns the same `{type, typeDisplay, allocationPercent, totalValue}` rows.
 */
internal object PortfolioAllocationParsers {
    fun parseBucket(node: JsonNode): PortfolioAllocationBucket =
        PortfolioAllocationBucket(
            type = node.path("type").asText(""),
            typeDisplay = node.path("typeDisplay").asTextOrNull(),
            allocationPercent = node.path("allocationPercent").asDouble(0.0),
            totalValue = node.path("totalValue").asDouble(0.0),
        )

    fun buildPortfolioInput(accountIds: List<String>?): Map<String, Any?>? =
        accountIds?.takeIf { it.isNotEmpty() }?.let { mapOf("accounts" to it) }
}
