package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.ChannelNotificationPrefs
import com.nicholasklaene.monarchbridge.generated.model.GetEmailNotificationPrefsResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asBooleanOrNull

/** Per-topic email-channel notification toggles (weeklyRecap, budgetAlerts, etc.). */
object GetEmailNotificationPrefs : MonarchOperation<Unit, GetEmailNotificationPrefsResponseData> {
    override val operationName: String = "Common_GetEmailNotificationPrefs"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    override fun variables(input: Unit): Map<String, Any?> = emptyMap()

    override fun parseOutput(data: JsonNode): GetEmailNotificationPrefsResponseData {
        val node = data.path("emailNotificationPreferences")
        return GetEmailNotificationPrefsResponseData(
            prefs = parseChannelPrefs(node),
        )
    }

    internal fun parseChannelPrefs(node: JsonNode): ChannelNotificationPrefs =
        ChannelNotificationPrefs(
            weeklyRecap = node.path("weeklyRecap").asBooleanOrNull(),
            budgetAlerts = node.path("budgetAlerts").asBooleanOrNull(),
            billReminders = node.path("billReminders").asBooleanOrNull(),
            goalUpdates = node.path("goalUpdates").asBooleanOrNull(),
            marketingTips = node.path("marketingTips").asBooleanOrNull(),
        )
}
