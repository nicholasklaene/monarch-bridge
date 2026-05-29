package com.nicholasklaene.monarchbridge.graphql.operations.taxlots

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.ListTaxLotsResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/** List manual tax lots attached to one holding. */
object ListTaxLots : MonarchOperation<ListTaxLots.Input, ListTaxLotsResponseData> {
    override val operationName: String = "Web_ListTaxLots"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val holdingId: String,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("holdingId" to input.holdingId)

    override fun parseOutput(data: JsonNode): ListTaxLotsResponseData =
        ListTaxLotsResponseData(
            taxLots = data.path("taxLots").map { TaxLotParser.parse(it) },
        )
}
