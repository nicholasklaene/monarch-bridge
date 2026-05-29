package com.nicholasklaene.monarchbridge.graphql.operations.accounts

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.UpdateHoldingRequest
import com.nicholasklaene.monarchbridge.generated.model.UpdateHoldingResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.mapOfNotNull

/**
 * Patch a holding's quantity, security type, or user-provided cost basis. All Input fields
 * except `id` are optional. Output is the spec-generated [UpdateHoldingResponseData].
 */
object UpdateHolding : MonarchOperation<UpdateHolding.Input, UpdateHoldingResponseData> {
    override val operationName: String = "Common_UpdateHolding"
    override val query: String by lazy {
        GraphQLLoader.load(operationName, fragments = listOf("PayloadErrorFields"))
    }

    data class Input(
        val id: String,
        val quantity: Double? = null,
        val securityType: String? = null,
        val userCostBasis: Double? = null,
    ) {
        companion object {
            fun from(
                id: String,
                req: UpdateHoldingRequest,
            ): Input =
                Input(
                    id = id,
                    quantity = req.quantity,
                    securityType = req.securityType,
                    userCostBasis = req.userCostBasis,
                )
        }
    }

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "input" to
                mapOfNotNull(
                    "id" to input.id,
                    "quantity" to input.quantity,
                    "securityType" to input.securityType,
                    "userCostBasis" to input.userCostBasis,
                ),
        )

    override fun parseOutput(data: JsonNode): UpdateHoldingResponseData =
        UpdateHoldingResponseData(
            holdingId =
                data
                    .path("updateHolding")
                    .path("holding")
                    .path("id")
                    .asText(""),
        )
}
