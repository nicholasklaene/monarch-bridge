package com.nicholasklaene.monarchbridge.graphql.operations.holdings

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.BulkUpdateHoldingsFailure
import com.nicholasklaene.monarchbridge.generated.model.BulkUpdateHoldingsRequest
import com.nicholasklaene.monarchbridge.generated.model.BulkUpdateHoldingsResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/**
 * Multi-holding update in one round-trip. Monarch only patches fields that are present in
 * each update row, so we strip null entries before serialization.
 */
object BulkUpdateHoldings :
    MonarchOperation<BulkUpdateHoldings.Input, BulkUpdateHoldingsResponseData> {
    override val operationName: String = "Web_BulkUpdateHoldings"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    /** One per-holding patch. Null fields are dropped from the wire payload. */
    data class Update(
        val holdingId: String,
        val quantity: Double? = null,
        val costBasis: Double? = null,
    )

    data class Input(
        val updates: List<Update>,
    ) {
        companion object {
            fun from(req: BulkUpdateHoldingsRequest): Input =
                Input(
                    updates =
                        req.updates.map { e ->
                            Update(
                                holdingId = e.holdingId,
                                quantity = e.quantity,
                                costBasis = e.costBasis,
                            )
                        },
                )
        }
    }

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "input" to
                mapOf(
                    "updates" to
                        input.updates.map { u ->
                            buildMap<String, Any?> {
                                put("holdingId", u.holdingId)
                                if (u.quantity != null) put("quantity", u.quantity)
                                if (u.costBasis != null) put("costBasis", u.costBasis)
                            }
                        },
                ),
        )

    override fun parseOutput(data: JsonNode): BulkUpdateHoldingsResponseData {
        val node = data.path("bulkUpdateHoldings")
        return BulkUpdateHoldingsResponseData(
            updatedCount = node.path("updatedCount").asInt(0),
            failedCount = node.path("failedCount").asInt(0),
            failures =
                node.path("failures").map { f ->
                    BulkUpdateHoldingsFailure(
                        holdingId = f.path("holdingId").asText(""),
                        reason = f.path("reason").asTextOrNull(),
                    )
                },
        )
    }
}
