package com.nicholasklaene.monarchbridge.graphql.operations.categories

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetTaxYearOverviewResponseData
import com.nicholasklaene.monarchbridge.generated.model.TaxScheduleSummary
import com.nicholasklaene.monarchbridge.generated.model.TaxYearOverview
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asIntOrNull

/** Top-level tax overview for one calendar year. */
object GetTaxYearOverview : MonarchOperation<GetTaxYearOverview.Input, GetTaxYearOverviewResponseData> {
    override val operationName: String = "Web_GetTaxYearOverview"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val taxYear: Int,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("taxYear" to input.taxYear)

    override fun parseOutput(data: JsonNode): GetTaxYearOverviewResponseData {
        val node = data.path("taxYearOverview")
        return GetTaxYearOverviewResponseData(
            overview =
                TaxYearOverview(
                    taxYear = node.path("taxYear").asInt(0),
                    totalIncome = node.path("totalIncome").asDoubleOrNull(),
                    totalDeductions = node.path("totalDeductions").asDoubleOrNull(),
                    estimatedTax = node.path("estimatedTax").asDoubleOrNull(),
                    transactionCount = node.path("transactionCount").asIntOrNull(),
                    scheduleSummaries =
                        node.path("scheduleSummaries").map { s ->
                            TaxScheduleSummary(
                                schedule = s.path("schedule").asText(""),
                                total = s.path("total").asDoubleOrNull(),
                                lineItemCount = s.path("lineItemCount").asIntOrNull(),
                            )
                        },
                ),
        )
    }
}
