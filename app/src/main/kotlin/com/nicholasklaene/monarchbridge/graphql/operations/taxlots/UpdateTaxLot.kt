package com.nicholasklaene.monarchbridge.graphql.operations.taxlots

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.CreateManualTaxLotResponseData
import com.nicholasklaene.monarchbridge.generated.model.UpdateTaxLotRequest
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import java.time.LocalDate

/** Partial-update one manual tax lot. Returns the spec-deduped `CreateManualTaxLotResponseData` envelope. */
object UpdateTaxLot : MonarchOperation<UpdateTaxLot.Input, CreateManualTaxLotResponseData> {
    override val operationName: String = "Web_UpdateTaxLot"
    override val query: String by lazy {
        GraphQLLoader.load(operationName, fragments = listOf("PayloadErrorFields"))
    }

    data class Input(
        val id: String,
        val acquisitionDate: LocalDate? = null,
        val acquisitionQuantity: Double? = null,
        val costBasisPerUnit: Double? = null,
    ) {
        companion object {
            fun from(
                id: String,
                req: UpdateTaxLotRequest,
            ): Input =
                Input(
                    id = id,
                    acquisitionDate = req.acquisitionDate,
                    acquisitionQuantity = req.acquisitionQuantity,
                    costBasisPerUnit = req.costBasisPerUnit,
                )
        }
    }

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "input" to
                buildMap<String, Any?> {
                    put("id", input.id)
                    if (input.acquisitionDate != null) put("acquisitionDate", input.acquisitionDate.toString())
                    if (input.acquisitionQuantity != null) put("acquisitionQuantity", input.acquisitionQuantity)
                    if (input.costBasisPerUnit != null) put("costBasisPerUnit", input.costBasisPerUnit)
                },
        )

    override fun parseOutput(data: JsonNode): CreateManualTaxLotResponseData =
        CreateManualTaxLotResponseData(taxLot = TaxLotParser.parse(data.path("updateTaxLot").path("taxLot")))
}
