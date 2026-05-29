package com.nicholasklaene.monarchbridge.graphql.operations.taxlots

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.DeleteTaxLotsBulkRequest
import com.nicholasklaene.monarchbridge.generated.model.DeleteTaxLotsBulkResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asIntOrNull

/** Bulk-delete tax lots by id. */
object DeleteTaxLotsBulk : MonarchOperation<DeleteTaxLotsBulk.Input, DeleteTaxLotsBulkResponseData> {
    override val operationName: String = "Web_DeleteTaxLotsBulk"
    override val query: String by lazy {
        GraphQLLoader.load(operationName, fragments = listOf("PayloadErrorFields"))
    }

    data class Input(
        val ids: List<String>,
    ) {
        companion object {
            fun from(req: DeleteTaxLotsBulkRequest): Input = Input(ids = req.ids)
        }
    }

    override fun variables(input: Input): Map<String, Any?> = mapOf("input" to mapOf("ids" to input.ids))

    override fun parseOutput(data: JsonNode): DeleteTaxLotsBulkResponseData =
        DeleteTaxLotsBulkResponseData(
            deletedCount = data.path("deleteTaxLotsBulk").path("deletedCount").asIntOrNull(),
        )
}
