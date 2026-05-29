package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetSavingsRateTrendsResponseData
import com.nicholasklaene.monarchbridge.generated.model.SavingsRateTrendPoint
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/**
 * Savings-rate trend series. Each point carries a period label (month),
 * the savings rate fraction (`0.42` = 42%), and the underlying income
 * and expense totals that produced it.
 */
object GetSavingsRateTrends : MonarchOperation<GetSavingsRateTrends.Input, GetSavingsRateTrendsResponseData> {
    override val operationName: String = "Common_GetSavingsRateTrends"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val months: Int,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("months" to input.months)

    override fun parseOutput(data: JsonNode): GetSavingsRateTrendsResponseData =
        GetSavingsRateTrendsResponseData(
            points =
                data.path("savingsRateTrends").path("points").map { p ->
                    SavingsRateTrendPoint(
                        period = p.path("period").asTextOrNull(),
                        savingsRate = p.path("savingsRate").asDoubleOrNull(),
                        income = p.path("income").asDoubleOrNull(),
                        expense = p.path("expense").asDoubleOrNull(),
                    )
                },
        )
}
