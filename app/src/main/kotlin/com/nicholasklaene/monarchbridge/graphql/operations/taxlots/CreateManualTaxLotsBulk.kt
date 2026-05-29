package com.nicholasklaene.monarchbridge.graphql.operations.taxlots

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.BulkTaxLotRowError
import com.nicholasklaene.monarchbridge.generated.model.CreateManualTaxLotsBulkRequest
import com.nicholasklaene.monarchbridge.generated.model.CreateManualTaxLotsBulkResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asIntOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import java.time.LocalDate

/** Bulk-create manual tax lots under one investments account. */
object CreateManualTaxLotsBulk :
    MonarchOperation<CreateManualTaxLotsBulk.Input, CreateManualTaxLotsBulkResponseData> {
    override val operationName: String = "Web_CreateManualTaxLotsBulk"
    override val query: String by lazy {
        GraphQLLoader.load(operationName, fragments = listOf("PayloadErrorFields"))
    }

    /** One per-lot row that goes on the wire. */
    data class Row(
        val holdingId: String,
        val acquisitionDate: LocalDate,
        val acquisitionQuantity: Double,
        val costBasisPerUnit: Double,
    )

    data class Input(
        val accountId: String,
        val rows: List<Row>,
    ) {
        companion object {
            fun from(
                accountId: String,
                req: CreateManualTaxLotsBulkRequest,
            ): Input =
                Input(
                    accountId = accountId,
                    rows =
                        req.taxLots.map { r ->
                            Row(
                                holdingId = r.holdingId,
                                acquisitionDate = r.acquisitionDate,
                                acquisitionQuantity = r.acquisitionQuantity,
                                costBasisPerUnit = r.costBasisPerUnit,
                            )
                        },
                )
        }
    }

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "input" to
                mapOf(
                    "accountId" to input.accountId,
                    "taxLots" to
                        input.rows.map { r ->
                            mapOf(
                                "holdingId" to r.holdingId,
                                "acquisitionDate" to r.acquisitionDate.toString(),
                                "acquisitionQuantity" to r.acquisitionQuantity,
                                "costBasisPerUnit" to r.costBasisPerUnit,
                            )
                        },
                ),
        )

    override fun parseOutput(data: JsonNode): CreateManualTaxLotsBulkResponseData {
        val node = data.path("createManualTaxLotsBulk")
        return CreateManualTaxLotsBulkResponseData(
            taxLots = node.path("taxLots").map { TaxLotParser.parse(it) },
            errors =
                node.path("errors").takeIf { it.isArray }?.map { e ->
                    BulkTaxLotRowError(
                        index = e.path("index").asIntOrNull(),
                        error = e.path("error").asTextOrNull(),
                    )
                },
        )
    }
}
