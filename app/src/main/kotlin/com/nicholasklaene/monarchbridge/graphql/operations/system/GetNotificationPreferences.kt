package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetNotificationPreferencesResponseData
import com.nicholasklaene.monarchbridge.generated.model.NotificationPreference
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asBooleanOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/**
 * Per-channel notification preferences (email, push, in-app) grouped by notification type.
 * Backs the web Settings page Notifications tab.
 */
object GetNotificationPreferences : MonarchOperation<Unit, GetNotificationPreferencesResponseData> {
    override val operationName: String = "Common_GetNotificationPreferences"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    override fun variables(input: Unit): Map<String, Any?> = emptyMap()

    override fun parseOutput(data: JsonNode): GetNotificationPreferencesResponseData =
        GetNotificationPreferencesResponseData(
            preferences =
                data.path("notificationPreferences").map { n ->
                    NotificationPreference(
                        id = n.path("id").asText(""),
                        group = n.path("group").asTextOrNull(),
                        type = n.path("type").asTextOrNull(),
                        title = n.path("title").asTextOrNull(),
                        description = n.path("description").asTextOrNull(),
                        emailEnabled = n.path("emailEnabled").asBooleanOrNull(),
                        pushEnabled = n.path("pushEnabled").asBooleanOrNull(),
                        inAppEnabled = n.path("inAppEnabled").asBooleanOrNull(),
                    )
                },
        )
}
