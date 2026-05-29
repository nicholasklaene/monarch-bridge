package com.nicholasklaene.monarchbridge.graphql.operations.categories

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetTaxBracketEstimatesResponseData
import com.nicholasklaene.monarchbridge.generated.model.TaxBracket
import com.nicholasklaene.monarchbridge.generated.model.TaxBracketEstimates
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import com.nicholasklaene.monarchbridge.graphql.mapOfNotNull

/** Federal bracket estimates for a filing status. */
object GetTaxBracketEstimates : MonarchOperation<GetTaxBracketEstimates.Input, GetTaxBracketEstimatesResponseData> {
    override val operationName: String = "Web_GetTaxBracketEstimates"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val taxYear: Int,
        val filingStatus: String? = null,
    )

    override fun variables(input: Input): Map<String, Any?> =
        mapOfNotNull(
            "taxYear" to input.taxYear,
            "filingStatus" to input.filingStatus,
        )

    override fun parseOutput(data: JsonNode): GetTaxBracketEstimatesResponseData {
        val node = data.path("taxBracketEstimates")
        return GetTaxBracketEstimatesResponseData(
            estimates =
                TaxBracketEstimates(
                    taxYear = node.path("taxYear").asInt(0),
                    filingStatus = node.path("filingStatus").asTextOrNull(),
                    estimatedAgi = node.path("estimatedAgi").asDoubleOrNull(),
                    marginalRate = node.path("marginalRate").asDoubleOrNull(),
                    effectiveRate = node.path("effectiveRate").asDoubleOrNull(),
                    brackets =
                        node.path("brackets").map { b ->
                            TaxBracket(
                                rate = b.path("rate").asDoubleOrNull(),
                                lowerBound = b.path("lowerBound").asDoubleOrNull(),
                                upperBound = b.path("upperBound").asDoubleOrNull(),
                                taxOwed = b.path("taxOwed").asDoubleOrNull(),
                            )
                        },
                ),
        )
    }
}
