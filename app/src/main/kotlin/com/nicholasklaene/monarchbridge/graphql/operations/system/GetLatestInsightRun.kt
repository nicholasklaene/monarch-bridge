package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetLatestInsightRunResponseData
import com.nicholasklaene.monarchbridge.generated.model.LatestFinancialInsightRun
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asIntOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/**
 * Latest financial-insight run metadata + total insights count. Lightweight freshness
 * check; full data lives in `/v1/insights`.
 */
object GetLatestInsightRun : MonarchOperation<Unit, GetLatestInsightRunResponseData> {
    override val operationName: String = "Common_GetLatestFinancialInsightRun"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    override fun variables(input: Unit): Map<String, Any?> = emptyMap()

    override fun parseOutput(data: JsonNode): GetLatestInsightRunResponseData =
        GetLatestInsightRunResponseData(
            latestRun =
                data.path("financialInsightRuns").firstOrNull()?.let { r ->
                    LatestFinancialInsightRun(
                        id = r.path("id").asText(""),
                        status = r.path("status").asTextOrNull(),
                        errorMessage = r.path("errorMessage").asTextOrNull(),
                        insightsGeneratedCount = r.path("insightsGeneratedCount").asIntOrNull(),
                    )
                },
            insightsCount = data.path("financialInsights").takeIf { it.isArray }?.size(),
        )
}
