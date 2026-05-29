package com.nicholasklaene.monarchbridge.graphql.operations.merchants

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetMerchantStatsResponseData
import com.nicholasklaene.monarchbridge.generated.model.MerchantStats
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asIntOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import java.time.LocalDate

/** Aggregated stats for one merchant over a window. */
object GetMerchantStats : MonarchOperation<GetMerchantStats.Input, GetMerchantStatsResponseData> {
    override val operationName: String = "Web_GetMerchantStats"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val merchantId: String,
        val startDate: LocalDate? = null,
        val endDate: LocalDate? = null,
    )

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "merchantId" to input.merchantId,
            "startDate" to input.startDate?.toString(),
            "endDate" to input.endDate?.toString(),
        )

    override fun parseOutput(data: JsonNode): GetMerchantStatsResponseData {
        val node = data.path("merchantStats")
        return GetMerchantStatsResponseData(
            stats =
                MerchantStats(
                    merchantId = node.path("merchantId").asText(""),
                    totalSpend = node.path("totalSpend").asDoubleOrNull(),
                    transactionCount = node.path("transactionCount").asIntOrNull(),
                    averageTransaction = node.path("averageTransaction").asDoubleOrNull(),
                    firstSeen = node.path("firstSeen").asTextOrNull(),
                    lastSeen = node.path("lastSeen").asTextOrNull(),
                    monthsActive = node.path("monthsActive").asIntOrNull(),
                ),
        )
    }
}
