package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetEmailNotificationPrefsResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/** Per-topic push-channel notification toggles. Shares the response envelope with the email-channel op (generator dedupes). */
object GetPushNotificationPrefs : MonarchOperation<Unit, GetEmailNotificationPrefsResponseData> {
    override val operationName: String = "Common_GetPushNotificationPrefs"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    override fun variables(input: Unit): Map<String, Any?> = emptyMap()

    override fun parseOutput(data: JsonNode): GetEmailNotificationPrefsResponseData {
        val node = data.path("pushNotificationPreferences")
        return GetEmailNotificationPrefsResponseData(
            prefs = GetEmailNotificationPrefs.parseChannelPrefs(node),
        )
    }
}
