package com.nicholasklaene.monarchbridge.graphql.operations.accounts

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.DeleteAccountResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Remove a holding. Destructive. Output is the spec-generated [DeleteAccountResponseData]
 * (reused by the OpenAPI generator because the response shape `{deleted: boolean}` is identical
 * to delete-account; the controller still returns the `DeleteHoldingResponse` envelope).
 */
object DeleteHolding : MonarchOperation<DeleteHolding.Input, DeleteAccountResponseData> {
    override val operationName: String = "Common_DeleteHolding"
    override val query: String by lazy {
        GraphQLLoader.load(operationName, fragments = listOf("PayloadErrorFields"))
    }

    data class Input(
        val holdingId: String,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("id" to input.holdingId)

    override fun parseOutput(data: JsonNode): DeleteAccountResponseData =
        DeleteAccountResponseData(
            deleted = data.path("deleteHolding").path("deleted").asBoolean(false),
        )
}
