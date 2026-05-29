package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.UpdateHouseholdPreferencesRequest
import com.nicholasklaene.monarchbridge.generated.model.UpdateHouseholdPreferencesResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asBooleanOrNull

/** Patch household preference flags (only fields provided are forwarded). */
object UpdateHouseholdPreferences :
    MonarchOperation<UpdateHouseholdPreferences.Input, UpdateHouseholdPreferencesResponseData> {
    override val operationName: String = "Common_UpdateHouseholdPreferences"
    override val query: String by lazy { GraphQLLoader.load(operationName, fragments = listOf("PayloadErrorFields")) }

    data class Input(
        val newTransactionsNeedReview: Boolean?,
        val uncategorizedTransactionsNeedReview: Boolean?,
        val pendingTransactionsCanBeEdited: Boolean?,
        val aiAssistantEnabled: Boolean?,
        val llmEnrichmentEnabled: Boolean?,
        val investmentTransactionsEnabled: Boolean?,
        val budgetApplyToFutureMonthsDefault: Boolean?,
        val hiddenTransactionsBetaEnabled: Boolean?,
        val collaborationToolsEnabled: Boolean?,
        val aggDataSharingEnabled: Boolean?,
        val aiModelTrainingOnUserDataEnabled: Boolean?,
        val excludeBusinessFromBudget: Boolean?,
        val continuousFinancialMonitoringEnabled: Boolean?,
    ) {
        companion object {
            fun from(req: UpdateHouseholdPreferencesRequest): Input =
                Input(
                    newTransactionsNeedReview = req.newTransactionsNeedReview,
                    uncategorizedTransactionsNeedReview = req.uncategorizedTransactionsNeedReview,
                    pendingTransactionsCanBeEdited = req.pendingTransactionsCanBeEdited,
                    aiAssistantEnabled = req.aiAssistantEnabled,
                    llmEnrichmentEnabled = req.llmEnrichmentEnabled,
                    investmentTransactionsEnabled = req.investmentTransactionsEnabled,
                    budgetApplyToFutureMonthsDefault = req.budgetApplyToFutureMonthsDefault,
                    hiddenTransactionsBetaEnabled = req.hiddenTransactionsBetaEnabled,
                    collaborationToolsEnabled = req.collaborationToolsEnabled,
                    aggDataSharingEnabled = req.aggDataSharingEnabled,
                    aiModelTrainingOnUserDataEnabled = req.aiModelTrainingOnUserDataEnabled,
                    excludeBusinessFromBudget = req.excludeBusinessFromBudget,
                    continuousFinancialMonitoringEnabled = req.continuousFinancialMonitoringEnabled,
                )
        }
    }

    override fun variables(input: Input): Map<String, Any?> {
        val pairs =
            listOf(
                "newTransactionsNeedReview" to input.newTransactionsNeedReview,
                "uncategorizedTransactionsNeedReview" to input.uncategorizedTransactionsNeedReview,
                "pendingTransactionsCanBeEdited" to input.pendingTransactionsCanBeEdited,
                "aiAssistantEnabled" to input.aiAssistantEnabled,
                "llmEnrichmentEnabled" to input.llmEnrichmentEnabled,
                "investmentTransactionsEnabled" to input.investmentTransactionsEnabled,
                "budgetApplyToFutureMonthsDefault" to input.budgetApplyToFutureMonthsDefault,
                "hiddenTransactionsBetaEnabled" to input.hiddenTransactionsBetaEnabled,
                "collaborationToolsEnabled" to input.collaborationToolsEnabled,
                "aggDataSharingEnabled" to input.aggDataSharingEnabled,
                "aiModelTrainingOnUserDataEnabled" to input.aiModelTrainingOnUserDataEnabled,
                "excludeBusinessFromBudget" to input.excludeBusinessFromBudget,
                "continuousFinancialMonitoringEnabled" to input.continuousFinancialMonitoringEnabled,
            )
        return mapOf("input" to pairs.filter { it.second != null }.toMap())
    }

    override fun parseOutput(data: JsonNode): UpdateHouseholdPreferencesResponseData {
        val p = data.path("updateHouseholdPreferences").path("householdPreferences")
        return UpdateHouseholdPreferencesResponseData(
            id = p.path("id").asText(""),
            newTransactionsNeedReview = p.path("newTransactionsNeedReview").asBooleanOrNull(),
            uncategorizedTransactionsNeedReview = p.path("uncategorizedTransactionsNeedReview").asBooleanOrNull(),
            pendingTransactionsCanBeEdited = p.path("pendingTransactionsCanBeEdited").asBooleanOrNull(),
            aiAssistantEnabled = p.path("aiAssistantEnabled").asBooleanOrNull(),
            llmEnrichmentEnabled = p.path("llmEnrichmentEnabled").asBooleanOrNull(),
            investmentTransactionsEnabled = p.path("investmentTransactionsEnabled").asBooleanOrNull(),
            budgetApplyToFutureMonthsDefault = p.path("budgetApplyToFutureMonthsDefault").asBooleanOrNull(),
            hiddenTransactionsBetaEnabled = p.path("hiddenTransactionsBetaEnabled").asBooleanOrNull(),
            collaborationToolsEnabled = p.path("collaborationToolsEnabled").asBooleanOrNull(),
            aggDataSharingEnabled = p.path("aggDataSharingEnabled").asBooleanOrNull(),
            aiModelTrainingOnUserDataEnabled = p.path("aiModelTrainingOnUserDataEnabled").asBooleanOrNull(),
            excludeBusinessFromBudget = p.path("excludeBusinessFromBudget").asBooleanOrNull(),
            continuousFinancialMonitoringEnabled = p.path("continuousFinancialMonitoringEnabled").asBooleanOrNull(),
        )
    }
}
