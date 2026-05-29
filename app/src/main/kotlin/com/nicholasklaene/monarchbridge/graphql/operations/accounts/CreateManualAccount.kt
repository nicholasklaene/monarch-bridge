package com.nicholasklaene.monarchbridge.graphql.operations.accounts

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.CreateManualAccountRequest
import com.nicholasklaene.monarchbridge.generated.model.CreateManualAccountResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/** Create a manual (non-Plaid-synced) account. Output is the spec-generated [CreateManualAccountResponseData]. */
object CreateManualAccount : MonarchOperation<CreateManualAccount.Input, CreateManualAccountResponseData> {
    override val operationName: String = "Web_CreateManualAccount"
    override val query: String by lazy {
        GraphQLLoader.load(operationName, fragments = listOf("PayloadErrorFields"))
    }

    data class Input(
        val type: String,
        val subtype: String,
        val name: String,
        val displayBalance: Double = 0.0,
        val includeInNetWorth: Boolean = true,
    ) {
        companion object {
            fun from(req: CreateManualAccountRequest): Input =
                Input(
                    type = req.type,
                    subtype = req.subtype,
                    name = req.name,
                    displayBalance = req.displayBalance ?: 0.0,
                    includeInNetWorth = req.includeInNetWorth ?: true,
                )
        }
    }

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "input" to
                mapOf(
                    "type" to input.type,
                    "subtype" to input.subtype,
                    "name" to input.name,
                    "displayBalance" to input.displayBalance,
                    "includeInNetWorth" to input.includeInNetWorth,
                ),
        )

    override fun parseOutput(data: JsonNode): CreateManualAccountResponseData =
        CreateManualAccountResponseData(
            accountId =
                data
                    .path("createManualAccount")
                    .path("account")
                    .path("id")
                    .asText(""),
        )
}
