package com.nicholasklaene.monarchbridge.graphql.operations.investments

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetSecurityDetailsResponseData
import com.nicholasklaene.monarchbridge.generated.model.SecurityDetails
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/** Full security metadata: ticker, name, sector, industry, fundamentals. */
object GetSecurityDetails : MonarchOperation<GetSecurityDetails.Input, GetSecurityDetailsResponseData> {
    override val operationName: String = "Web_GetSecurityDetails"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val id: String,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("id" to input.id)

    override fun parseOutput(data: JsonNode): GetSecurityDetailsResponseData {
        val node = data.path("security")
        return GetSecurityDetailsResponseData(
            security =
                SecurityDetails(
                    id = node.path("id").asText(""),
                    ticker = node.path("ticker").asTextOrNull(),
                    name = node.path("name").asTextOrNull(),
                    type = node.path("type").asTextOrNull(),
                    currentPrice = node.path("currentPrice").asDoubleOrNull(),
                    closingPrice = node.path("closingPrice").asDoubleOrNull(),
                    sector = node.path("sector").asTextOrNull(),
                    industry = node.path("industry").asTextOrNull(),
                    marketCap = node.path("marketCap").asDoubleOrNull(),
                    peRatio = node.path("peRatio").asDoubleOrNull(),
                    dividendYield = node.path("dividendYield").asDoubleOrNull(),
                ),
        )
    }
}
