package com.nicholasklaene.monarchbridge.graphql.operations.accounts

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.CreateManualAccountResponseData
import com.nicholasklaene.monarchbridge.generated.model.CreateManualInvestmentsAccountRequest
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.mapOfNotNull

/**
 * Create a manual investments account (brokerage subtype) that Monarch cannot auto-sync.
 * Two tracking methods (Monarch's `ManualInvestmentsAccountTrackingMethod` enum):
 *
 * - `balances` — user enters one balance number; no per-security detail.
 * - `holdings` — user enters per-security positions (optionally seeded via [Input.initialHoldings]).
 *
 * Output is the spec-generated [CreateManualAccountResponseData] (reused by the OpenAPI
 * generator because the response shape `{accountId: string}` is identical to create-manual-account).
 */
object CreateManualInvestmentsAccount :
    MonarchOperation<CreateManualInvestmentsAccount.Input, CreateManualAccountResponseData> {
    override val operationName: String = "Common_CreateManualInvestmentsAccount"
    override val query: String by lazy {
        GraphQLLoader.load(operationName, fragments = listOf("PayloadErrorFields"))
    }

    data class InitialHolding(
        val securityId: String,
        val quantity: Double,
    )

    data class Input(
        val name: String,
        val subtype: String,
        val trackingMethod: String? = null,
        val initialBalance: Double? = null,
        val initialHoldings: List<InitialHolding>? = null,
    ) {
        companion object {
            fun from(req: CreateManualInvestmentsAccountRequest): Input =
                Input(
                    name = req.name,
                    subtype = req.subtype,
                    trackingMethod = req.trackingMethod,
                    initialBalance = req.initialBalance,
                    initialHoldings =
                        req.initialHoldings?.map { h ->
                            InitialHolding(securityId = h.securityId, quantity = h.quantity)
                        },
                )
        }
    }

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "input" to
                mapOfNotNull(
                    "name" to input.name,
                    "subtype" to input.subtype,
                    "manualInvestmentsTrackingMethod" to input.trackingMethod,
                    "initialBalance" to input.initialBalance,
                    "initialHoldings" to
                        input.initialHoldings?.map { h ->
                            mapOf("securityId" to h.securityId, "quantity" to h.quantity)
                        },
                ),
        )

    override fun parseOutput(data: JsonNode): CreateManualAccountResponseData =
        CreateManualAccountResponseData(
            accountId =
                data
                    .path("createManualInvestmentsAccount")
                    .path("account")
                    .path("id")
                    .asText(""),
        )
}
