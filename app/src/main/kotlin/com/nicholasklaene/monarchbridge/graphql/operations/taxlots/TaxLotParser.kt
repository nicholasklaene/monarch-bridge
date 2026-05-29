package com.nicholasklaene.monarchbridge.graphql.operations.taxlots

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.TaxLot
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import java.time.LocalDate

/**
 * Shared parser for the `TaxLot` shape that appears under multiple Monarch tax-lot
 * mutations + reads. Centralized so each operation does not re-write the same path walk.
 */
internal object TaxLotParser {
    fun parse(node: JsonNode): TaxLot =
        TaxLot(
            id = node.path("id").asText(""),
            createdAt = node.path("createdAt").asTextOrNull(),
            acquisitionDate = node.path("acquisitionDate").asTextOrNull()?.let { LocalDate.parse(it) },
            acquisitionQuantity = node.path("acquisitionQuantity").asDoubleOrNull(),
            costBasisPerUnit = node.path("costBasisPerUnit").asDoubleOrNull(),
        )
}
