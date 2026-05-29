package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.CurrencyPreferences
import com.nicholasklaene.monarchbridge.generated.model.SetCurrencyRequest
import com.nicholasklaene.monarchbridge.generated.model.SetCurrencyResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import com.nicholasklaene.monarchbridge.graphql.mapOfNotNull

/** Set the user's default display currency (ISO code, with optional symbol-position override). */
object SetCurrency : MonarchOperation<SetCurrency.Input, SetCurrencyResponseData> {
    override val operationName: String = "Common_SetCurrencyPreferences"
    override val query: String by lazy { GraphQLLoader.load(operationName, fragments = listOf("PayloadErrorFields")) }

    data class Input(
        val currency: String,
        val position: String? = null,
    ) {
        companion object {
            fun from(req: SetCurrencyRequest): Input =
                Input(
                    currency = req.currency,
                    position = req.position,
                )
        }
    }

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "input" to
                mapOfNotNull(
                    "currency" to input.currency,
                    "position" to input.position,
                ),
        )

    override fun parseOutput(data: JsonNode): SetCurrencyResponseData {
        val node = data.path("setCurrencyPreferences").path("currencyPreferences")
        return SetCurrencyResponseData(
            currency =
                CurrencyPreferences(
                    currency = node.path("currency").asTextOrNull(),
                    symbol = node.path("symbol").asTextOrNull(),
                    position = node.path("position").asTextOrNull(),
                ),
        )
    }
}
