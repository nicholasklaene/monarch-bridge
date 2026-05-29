package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.nicholasklaene.monarchbridge.generated.model.FinancialInsight
import com.nicholasklaene.monarchbridge.generated.model.FinancialInsightRelatedMerchant
import com.nicholasklaene.monarchbridge.generated.model.FinancialInsightRun
import com.nicholasklaene.monarchbridge.generated.model.FinancialInsightSummary
import com.nicholasklaene.monarchbridge.generated.model.ListFinancialInsightsResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asIntOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import com.nicholasklaene.monarchbridge.graphql.pathOrNull
import java.time.LocalDate

/**
 * AI-generated savings opportunities (subscription audits, bill negotiation candidates).
 * Each insight has a savings estimate range, effort tag, and current annual cost.
 *
 * Also returns a `summary` aggregate (counts + savings totals across the window) and
 * `latestRun` metadata for freshness checks. Filter by status to focus on actionable
 * insights (e.g. `NEW` to see only never-actioned ones).
 */
object GetFinancialInsights : MonarchOperation<GetFinancialInsights.Input, ListFinancialInsightsResponseData> {
    override val operationName: String = "Common_GetFinancialInsights"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val statuses: List<String>? = null,
        val summaryStartDate: LocalDate? = null,
        val summaryEndDate: LocalDate? = null,
    )

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "statuses" to input.statuses,
            "summaryStartDate" to input.summaryStartDate?.toString(),
            "summaryEndDate" to input.summaryEndDate?.toString(),
        )

    override fun parseOutput(data: JsonNode): ListFinancialInsightsResponseData =
        ListFinancialInsightsResponseData(
            insights = data.path("financialInsights").map(::parseInsight),
            summary = data.pathOrNull("financialInsightSummary")?.let(::parseSummary),
            latestRun = data.path("financialInsightRuns").firstOrNull()?.let(::parseRun),
        )

    internal fun parseInsight(node: JsonNode): FinancialInsight =
        FinancialInsight(
            id = node.path("id").asText(""),
            merchantNameDisplay = node.path("merchantNameDisplay").asTextOrNull(),
            merchantLogoUrl = node.path("merchantLogoUrl").asTextOrNull(),
            dashboardSubtitle = node.path("dashboardSubtitle").asTextOrNull(),
            description = node.path("description").asTextOrNull(),
            reasoning = node.path("reasoning").asTextOrNull(),
            effort = node.path("effort").asTextOrNull(),
            status = node.path("status").asTextOrNull(),
            savingsEstimateLow = node.path("savingsEstimateLow").asDoubleOrNull(),
            savingsEstimateHigh = node.path("savingsEstimateHigh").asDoubleOrNull(),
            capturedSavingsLow = node.path("capturedSavingsLow").asDoubleOrNull(),
            currentAnnualCost = node.path("currentAnnualCost").asDoubleOrNull(),
            nextChargeDate = node.path("nextChargeDate").asTextOrNull()?.let(LocalDate::parse),
            score = node.path("score").asDoubleOrNull(),
            opportunityType = node.path("opportunityType").asTextOrNull(),
            suggestedActionType = node.path("suggestedActionType").asTextOrNull(),
            recurringStreamSnapshot = freeForm(node.pathOrNull("recurringStreamSnapshot")),
            relatedMerchants = node.pathOrNull("relatedMerchants")?.map(::parseRelatedMerchant),
        )

    internal fun parseRelatedMerchant(node: JsonNode): FinancialInsightRelatedMerchant =
        FinancialInsightRelatedMerchant(
            name = node.path("name").asText(""),
            logoUrl = node.path("logoUrl").asTextOrNull(),
            merchantId = node.path("merchantId").asTextOrNull(),
        )

    private fun parseSummary(node: JsonNode): FinancialInsightSummary =
        FinancialInsightSummary(
            totalCapturedSavings = node.path("totalCapturedSavings").asDoubleOrNull(),
            completedCount = node.path("completedCount").asIntOrNull(),
            totalIdentifiedSavingsLow = node.path("totalIdentifiedSavingsLow").asDoubleOrNull(),
            totalIdentifiedSavingsHigh = node.path("totalIdentifiedSavingsHigh").asDoubleOrNull(),
            acceptedCount = node.path("acceptedCount").asIntOrNull(),
            inProgressCount = node.path("inProgressCount").asIntOrNull(),
            newCount = node.path("newCount").asIntOrNull(),
        )

    private fun parseRun(node: JsonNode): FinancialInsightRun =
        FinancialInsightRun(
            id = node.path("id").asText(""),
            status = node.path("status").asTextOrNull(),
            createdAt = node.path("createdAt").asTextOrNull(),
            insightsGeneratedCount = node.path("insightsGeneratedCount").asIntOrNull(),
        )

    internal fun freeForm(node: JsonNode?): Map<String, Any>? = node?.takeIf { it.isObject }?.let { MAPPER.convertValue(it, MAP_TYPE) }

    private val MAPPER = jacksonObjectMapper()
    private val MAP_TYPE = object : TypeReference<Map<String, Any>>() {}
}
