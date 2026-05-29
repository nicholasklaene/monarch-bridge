package com.nicholasklaene.monarchbridge.graphql.operations.taxlots

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetTaxLotPerformanceResponseData
import com.nicholasklaene.monarchbridge.generated.model.TaxLotPerformancePoint
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import java.time.LocalDate

/** Per-holding tax-lot performance chart. */
object GetTaxLotPerformance : MonarchOperation<GetTaxLotPerformance.Input, GetTaxLotPerformanceResponseData> {
    override val operationName: String = "Web_GetTaxLotPerformance"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val holdingId: String,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("holdingId" to input.holdingId)

    override fun parseOutput(data: JsonNode): GetTaxLotPerformanceResponseData {
        val node = data.path("taxLotPerformance")
        return GetTaxLotPerformanceResponseData(
            holdingId = node.path("holdingId").asTextOrNull(),
            historicalChart =
                node.path("historicalChart").map { p ->
                    TaxLotPerformancePoint(
                        date = p.path("date").asTextOrNull()?.let { LocalDate.parse(it) },
                        unrealizedGains = p.path("unrealizedGains").asDoubleOrNull(),
                        returnPercent = p.path("returnPercent").asDoubleOrNull(),
                        costBasis = p.path("costBasis").asDoubleOrNull(),
                    )
                },
        )
    }
}
