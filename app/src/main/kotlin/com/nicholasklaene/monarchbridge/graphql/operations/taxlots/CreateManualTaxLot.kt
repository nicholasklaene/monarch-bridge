package com.nicholasklaene.monarchbridge.graphql.operations.taxlots

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.CreateManualTaxLotRequest
import com.nicholasklaene.monarchbridge.generated.model.CreateManualTaxLotResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import java.time.LocalDate

/**
 * Create one manual cost-basis tax lot under a holding. Mutation; PayloadErrors map to
 * HTTP 422 via MonarchClient + GlobalExceptionHandler.
 */
object CreateManualTaxLot : MonarchOperation<CreateManualTaxLot.Input, CreateManualTaxLotResponseData> {
    override val operationName: String = "Web_CreateManualTaxLot"
    override val query: String by lazy {
        GraphQLLoader.load(operationName, fragments = listOf("PayloadErrorFields"))
    }

    data class Input(
        val holdingId: String,
        val accountId: String? = null,
        val acquisitionDate: LocalDate,
        val acquisitionQuantity: Double,
        val costBasisPerUnit: Double,
    ) {
        companion object {
            fun from(
                holdingId: String,
                req: CreateManualTaxLotRequest,
            ): Input =
                Input(
                    holdingId = holdingId,
                    accountId = req.accountId,
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
                    put("holdingId", input.holdingId)
                    if (input.accountId != null) put("accountId", input.accountId)
                    put("acquisitionDate", input.acquisitionDate.toString())
                    put("acquisitionQuantity", input.acquisitionQuantity)
                    put("costBasisPerUnit", input.costBasisPerUnit)
                },
        )

    override fun parseOutput(data: JsonNode): CreateManualTaxLotResponseData =
        CreateManualTaxLotResponseData(taxLot = TaxLotParser.parse(data.path("createManualTaxLot").path("taxLot")))
}
