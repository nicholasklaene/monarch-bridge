package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.CurrencyPreferences
import com.nicholasklaene.monarchbridge.generated.model.GetCurrencyResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/** User-scoped default display currency + render hints (symbol + before/after position). */
object GetCurrency : MonarchOperation<Unit, GetCurrencyResponseData> {
    override val operationName: String = "Common_GetCurrencyPreferences"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    override fun variables(input: Unit): Map<String, Any?> = emptyMap()

    override fun parseOutput(data: JsonNode): GetCurrencyResponseData {
        val node = data.path("currencyPreferences")
        return GetCurrencyResponseData(
            currency =
                CurrencyPreferences(
                    currency = node.path("currency").asTextOrNull(),
                    symbol = node.path("symbol").asTextOrNull(),
                    position = node.path("position").asTextOrNull(),
                ),
        )
    }
}
