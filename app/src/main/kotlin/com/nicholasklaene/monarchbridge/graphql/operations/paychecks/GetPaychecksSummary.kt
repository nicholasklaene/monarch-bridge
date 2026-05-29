package com.nicholasklaene.monarchbridge.graphql.operations.paychecks

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetPaychecksSummaryResponseData
import com.nicholasklaene.monarchbridge.generated.model.PaychecksSummary
import com.nicholasklaene.monarchbridge.generated.model.PaychecksSummaryDeduction
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull

/**
 * Aggregate paycheck stats over a date window. Returns count, totals, deduction rate,
 * and a per-type deduction breakdown. Owner / employer filters are optional.
 */
object GetPaychecksSummary : MonarchOperation<GetPaychecksSummary.Input, GetPaychecksSummaryResponseData> {
    override val operationName: String = "Common_GetPaychecksSummary"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val startDate: String? = null,
        val endDate: String? = null,
        val ownerIds: List<String>? = null,
        val employerId: String? = null,
    )

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "startDate" to input.startDate,
            "endDate" to input.endDate,
            "ownerIds" to input.ownerIds,
            "employerId" to input.employerId,
        )

    override fun parseOutput(data: JsonNode): GetPaychecksSummaryResponseData {
        val node = data.path("paychecksSummary")
        return GetPaychecksSummaryResponseData(
            summary =
                PaychecksSummary(
                    count = node.path("count").asInt(0),
                    totalGross = node.path("totalGross").asDouble(0.0),
                    totalDeductions = node.path("totalDeductions").asDouble(0.0),
                    totalNet = node.path("totalNet").asDouble(0.0),
                    deductionRate = node.path("deductionRate").asDoubleOrNull(),
                    deductionsByType =
                        node.path("deductionsByType").takeIf { it.isArray }?.map { d ->
                            PaychecksSummaryDeduction(
                                deductionType = d.path("deductionType").asText(""),
                                totalAmount = d.path("totalAmount").asDouble(0.0),
                            )
                        } ?: emptyList(),
                ),
        )
    }
}
