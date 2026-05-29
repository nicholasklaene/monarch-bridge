package com.nicholasklaene.monarchbridge.graphql.operations.taxlots

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.DeleteTaxLotResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asBooleanOrNull

/** Delete one manual tax lot. */
object DeleteTaxLot : MonarchOperation<DeleteTaxLot.Input, DeleteTaxLotResponseData> {
    override val operationName: String = "Web_DeleteTaxLot"
    override val query: String by lazy {
        GraphQLLoader.load(operationName, fragments = listOf("PayloadErrorFields"))
    }

    data class Input(
        val id: String,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("input" to mapOf("id" to input.id))

    override fun parseOutput(data: JsonNode): DeleteTaxLotResponseData =
        DeleteTaxLotResponseData(
            deleted = data.path("deleteTaxLot").path("deleted").asBooleanOrNull(),
        )
}
