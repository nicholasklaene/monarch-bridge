package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.FinancialInsightDetail
import com.nicholasklaene.monarchbridge.generated.model.FinancialInsightPlaybook
import com.nicholasklaene.monarchbridge.generated.model.GetFinancialInsightResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asBooleanOrNull
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import com.nicholasklaene.monarchbridge.graphql.pathOrNull
import java.time.LocalDate

/**
 * Single insight detail, including the optional `playbook.diySteps` (DIY walkthrough text)
 * and `paymentAccountLabel` (flattened from `paymentAccount.label`). Returns null `insight`
 * when the id is unknown.
 */
object GetFinancialInsight : MonarchOperation<GetFinancialInsight.Input, GetFinancialInsightResponseData> {
    override val operationName: String = "Common_GetFinancialInsight"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val id: String,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("id" to input.id)

    @Suppress("LongMethod")
    override fun parseOutput(data: JsonNode): GetFinancialInsightResponseData {
        val node = data.pathOrNull("financialInsight") ?: return GetFinancialInsightResponseData(insight = null)
        return GetFinancialInsightResponseData(
            insight =
                FinancialInsightDetail(
                    id = node.path("id").asText(""),
                    merchantNameDisplay = node.path("merchantNameDisplay").asTextOrNull(),
                    merchantLogoUrl = node.path("merchantLogoUrl").asTextOrNull(),
                    productNameDisplay = node.path("productNameDisplay").asTextOrNull(),
                    description = node.path("description").asTextOrNull(),
                    reasoning = node.path("reasoning").asTextOrNull(),
                    effort = node.path("effort").asTextOrNull(),
                    status = node.path("status").asTextOrNull(),
                    suggestedActionType = node.path("suggestedActionType").asTextOrNull(),
                    executionMethod = node.path("executionMethod").asTextOrNull(),
                    canUseBrowserAutomation = node.path("canUseBrowserAutomation").asBooleanOrNull(),
                    savingsEstimateLow = node.path("savingsEstimateLow").asDoubleOrNull(),
                    savingsEstimateHigh = node.path("savingsEstimateHigh").asDoubleOrNull(),
                    capturedSavingsLow = node.path("capturedSavingsLow").asDoubleOrNull(),
                    currentAnnualCost = node.path("currentAnnualCost").asDoubleOrNull(),
                    nextChargeDate = node.path("nextChargeDate").asTextOrNull()?.let(LocalDate::parse),
                    score = node.path("score").asDoubleOrNull(),
                    opportunityType = node.path("opportunityType").asTextOrNull(),
                    paymentAccountLabel = node.pathOrNull("paymentAccount")?.path("label")?.asTextOrNull(),
                    recurringStreamSnapshot = GetFinancialInsights.freeForm(node.pathOrNull("recurringStreamSnapshot")),
                    playbook =
                        node.pathOrNull("playbook")?.let {
                            FinancialInsightPlaybook(
                                id = it.path("id").asTextOrNull(),
                                diySteps = it.path("diySteps").asTextOrNull(),
                            )
                        },
                    relatedMerchants =
                        node.pathOrNull("relatedMerchants")?.map(GetFinancialInsights::parseRelatedMerchant),
                ),
        )
    }
}
