package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetMeResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asBooleanOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/** Current authenticated Monarch user (id, email, name, profile metadata). */
object GetMe : MonarchOperation<Unit, GetMeResponseData> {
    override val operationName: String = "Common_GetMe"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    override fun variables(input: Unit): Map<String, Any?> = emptyMap()

    override fun parseOutput(data: JsonNode): GetMeResponseData {
        val me = data.path("me")
        return GetMeResponseData(
            id = me.path("id").asText(""),
            email = me.path("email").asTextOrNull(),
            name = me.path("name").asTextOrNull(),
            displayName = me.path("displayName").asTextOrNull(),
            timezone = me.path("timezone").asTextOrNull(),
            birthday = me.path("birthday").asTextOrNull(),
            hasPassword = me.path("hasPassword").asBooleanOrNull(),
            hasMfaOn = me.path("hasMfaOn").asBooleanOrNull(),
            householdRole = me.path("householdRole").asTextOrNull(),
            createdAt = me.path("createdAt").asTextOrNull(),
        )
    }
}
