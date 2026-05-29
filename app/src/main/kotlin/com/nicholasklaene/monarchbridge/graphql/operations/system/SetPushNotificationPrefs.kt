package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetEmailNotificationPrefsResponseData
import com.nicholasklaene.monarchbridge.generated.model.SetEmailNotificationPrefsRequest
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.mapOfNotNull

/** Patch any subset of the push-channel toggles. Shares request + response shape with the email-channel set op (generator dedupes). */
object SetPushNotificationPrefs :
    MonarchOperation<SetPushNotificationPrefs.Input, GetEmailNotificationPrefsResponseData> {
    override val operationName: String = "Common_SetPushNotificationPrefs"
    override val query: String by lazy { GraphQLLoader.load(operationName, fragments = listOf("PayloadErrorFields")) }

    data class Input(
        val weeklyRecap: Boolean? = null,
        val budgetAlerts: Boolean? = null,
        val billReminders: Boolean? = null,
        val goalUpdates: Boolean? = null,
        val marketingTips: Boolean? = null,
    ) {
        companion object {
            fun from(req: SetEmailNotificationPrefsRequest): Input =
                Input(
                    weeklyRecap = req.weeklyRecap,
                    budgetAlerts = req.budgetAlerts,
                    billReminders = req.billReminders,
                    goalUpdates = req.goalUpdates,
                    marketingTips = req.marketingTips,
                )
        }
    }

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "input" to
                mapOfNotNull(
                    "weeklyRecap" to input.weeklyRecap,
                    "budgetAlerts" to input.budgetAlerts,
                    "billReminders" to input.billReminders,
                    "goalUpdates" to input.goalUpdates,
                    "marketingTips" to input.marketingTips,
                ),
        )

    override fun parseOutput(data: JsonNode): GetEmailNotificationPrefsResponseData {
        val node = data.path("setPushNotificationPreferences").path("preferences")
        return GetEmailNotificationPrefsResponseData(
            prefs = GetEmailNotificationPrefs.parseChannelPrefs(node),
        )
    }
}
