package com.nicholasklaene.monarchbridge.graphql.operations.accounts

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetAccountHoldingsResponseData
import com.nicholasklaene.monarchbridge.generated.model.Holding
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import java.time.LocalDate

/** Aggregated investment positions for an account at today's date. Output is the spec-generated [GetAccountHoldingsResponseData]. */
object GetAccountHoldings : MonarchOperation<GetAccountHoldings.Input, GetAccountHoldingsResponseData> {
    override val operationName: String = "Web_GetHoldings"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val accountId: String,
        val asOfDate: String = LocalDate.now().toString(),
        val includeHidden: Boolean = true,
    )

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "input" to
                mapOf(
                    "accountIds" to listOf(input.accountId),
                    "startDate" to input.asOfDate,
                    "endDate" to input.asOfDate,
                    "includeHiddenHoldings" to input.includeHidden,
                ),
        )

    override fun parseOutput(data: JsonNode): GetAccountHoldingsResponseData {
        val edges = data.path("portfolio").path("aggregateHoldings").path("edges")
        return GetAccountHoldingsResponseData(
            holdings =
                edges.map { edge ->
                    val node = edge.path("node")
                    val security = node.path("security")
                    Holding(
                        id = node.path("id").asTextOrNull(),
                        ticker = security.path("ticker").asTextOrNull(),
                        name = security.path("name").asTextOrNull(),
                        type = security.path("type").asTextOrNull(),
                        totalValue = node.path("totalValue").asDoubleOrNull(),
                        totalQuantity = node.path("quantity").asDoubleOrNull(),
                        costBasis = node.path("basis").asDoubleOrNull(),
                        lastPrice = security.path("currentPrice").asDoubleOrNull(),
                    )
                },
        )
    }
}
