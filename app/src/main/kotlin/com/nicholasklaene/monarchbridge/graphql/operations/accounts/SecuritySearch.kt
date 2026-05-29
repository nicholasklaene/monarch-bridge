package com.nicholasklaene.monarchbridge.graphql.operations.accounts

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.SearchSecuritiesResponseData
import com.nicholasklaene.monarchbridge.generated.model.Security
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/**
 * Search Monarch's security catalog by ticker or name. Powers the "add a holding" picker.
 * Output is the spec-generated [SearchSecuritiesResponseData].
 */
object SecuritySearch : MonarchOperation<SecuritySearch.Input, SearchSecuritiesResponseData> {
    override val operationName: String = "SecuritySearch"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val search: String,
        val limit: Int? = null,
        val orderByPopularity: Boolean? = null,
    )

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "search" to input.search,
            "limit" to input.limit,
            "orderByPopularity" to input.orderByPopularity,
        )

    override fun parseOutput(data: JsonNode): SearchSecuritiesResponseData =
        SearchSecuritiesResponseData(
            securities =
                data.path("securities").map { node ->
                    Security(
                        id = node.path("id").asText(""),
                        name = node.path("name").asTextOrNull(),
                        ticker = node.path("ticker").asTextOrNull(),
                        type = node.path("type").asTextOrNull(),
                        typeDisplay = node.path("typeDisplay").asTextOrNull(),
                        logo = node.path("logo").asTextOrNull(),
                        currentPrice = node.path("currentPrice").asDoubleOrNull(),
                        closingPrice = node.path("closingPrice").asDoubleOrNull(),
                        oneDayChangeDollars = node.path("oneDayChangeDollars").asDoubleOrNull(),
                        oneDayChangePercent = node.path("oneDayChangePercent").asDoubleOrNull(),
                    )
                },
        )
}
