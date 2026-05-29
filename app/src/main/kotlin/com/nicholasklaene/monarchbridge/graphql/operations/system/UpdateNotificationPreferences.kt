package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.NotificationPreference
import com.nicholasklaene.monarchbridge.generated.model.UpdateNotificationPreferencesRequest
import com.nicholasklaene.monarchbridge.generated.model.UpdateNotificationPreferencesResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asBooleanOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/** Toggle email / push / in-app delivery for one notification preference by id. */
object UpdateNotificationPreferences :
    MonarchOperation<UpdateNotificationPreferences.Input, UpdateNotificationPreferencesResponseData> {
    override val operationName: String = "Common_UpdateNotificationPreferences"
    override val query: String by lazy { GraphQLLoader.load(operationName, fragments = listOf("PayloadErrorFields")) }

    data class Input(
        val id: String,
        val emailEnabled: Boolean? = null,
        val pushEnabled: Boolean? = null,
        val inAppEnabled: Boolean? = null,
    ) {
        companion object {
            fun from(req: UpdateNotificationPreferencesRequest): Input =
                Input(
                    id = req.id,
                    emailEnabled = req.emailEnabled,
                    pushEnabled = req.pushEnabled,
                    inAppEnabled = req.inAppEnabled,
                )
        }
    }

    override fun variables(input: Input): Map<String, Any?> {
        val pairs =
            listOfNotNull(
                "id" to input.id,
                input.emailEnabled?.let { "emailEnabled" to it },
                input.pushEnabled?.let { "pushEnabled" to it },
                input.inAppEnabled?.let { "inAppEnabled" to it },
            )
        return mapOf("input" to pairs.toMap())
    }

    override fun parseOutput(data: JsonNode): UpdateNotificationPreferencesResponseData {
        val p = data.path("updateNotificationPreferences").path("notificationPreference")
        return UpdateNotificationPreferencesResponseData(
            preference =
                NotificationPreference(
                    id = p.path("id").asText(""),
                    group = p.path("group").asTextOrNull(),
                    type = p.path("type").asTextOrNull(),
                    title = p.path("title").asTextOrNull(),
                    description = p.path("description").asTextOrNull(),
                    emailEnabled = p.path("emailEnabled").asBooleanOrNull(),
                    pushEnabled = p.path("pushEnabled").asBooleanOrNull(),
                    inAppEnabled = p.path("inAppEnabled").asBooleanOrNull(),
                ),
        )
    }
}
