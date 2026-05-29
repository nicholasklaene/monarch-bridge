package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetHouseholdPreferencesResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asBooleanOrNull

/** Household-wide feature-flag bundle (review settings, AI assistant toggle, etc.). */
object GetHouseholdPreferences : MonarchOperation<Unit, GetHouseholdPreferencesResponseData> {
    override val operationName: String = "Common_GetHouseholdPreferences"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    override fun variables(input: Unit): Map<String, Any?> = emptyMap()

    override fun parseOutput(data: JsonNode): GetHouseholdPreferencesResponseData {
        val p = data.path("householdPreferences")
        return GetHouseholdPreferencesResponseData(
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
            eligibleForFinancialInsights = p.path("eligibleForFinancialInsights").asBooleanOrNull(),
        )
    }
}
