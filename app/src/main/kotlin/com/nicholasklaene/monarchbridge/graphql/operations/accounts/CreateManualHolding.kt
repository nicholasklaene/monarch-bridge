package com.nicholasklaene.monarchbridge.graphql.operations.accounts

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.CreateManualHoldingRequest
import com.nicholasklaene.monarchbridge.generated.model.CreateManualHoldingResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/**
 * Add a manual holding (security position) to a brokerage account. Used for accounts where Monarch
 * cannot auto-sync holdings (e.g. employer 401k, private equity tracker). Output is the
 * spec-generated [CreateManualHoldingResponseData].
 */
object CreateManualHolding : MonarchOperation<CreateManualHolding.Input, CreateManualHoldingResponseData> {
    override val operationName: String = "Common_CreateManualHolding"
    override val query: String by lazy {
        GraphQLLoader.load(operationName, fragments = listOf("PayloadErrorFields"))
    }

    data class Input(
        val accountId: String,
        val securityId: String,
        val quantity: Double,
    ) {
        companion object {
            fun from(
                accountId: String,
                req: CreateManualHoldingRequest,
            ): Input =
                Input(
                    accountId = accountId,
                    securityId = req.securityId,
                    quantity = req.quantity,
                )
        }
    }

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "input" to
                mapOf(
                    "accountId" to input.accountId,
                    "securityId" to input.securityId,
                    "quantity" to input.quantity,
                ),
        )

    override fun parseOutput(data: JsonNode): CreateManualHoldingResponseData {
        val holding = data.path("createManualHolding").path("holding")
        return CreateManualHoldingResponseData(
            holdingId = holding.path("id").asText(""),
            ticker = holding.path("ticker").asTextOrNull(),
        )
    }
}
