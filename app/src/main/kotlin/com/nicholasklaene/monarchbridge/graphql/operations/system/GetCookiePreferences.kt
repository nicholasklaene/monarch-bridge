package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.CookiePreferences
import com.nicholasklaene.monarchbridge.generated.model.GetCookiePreferencesResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asBooleanOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/** Per-category cookie consent (analytics, marketing, functional). */
object GetCookiePreferences : MonarchOperation<Unit, GetCookiePreferencesResponseData> {
    override val operationName: String = "Common_GetCookiePreferences"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    override fun variables(input: Unit): Map<String, Any?> = emptyMap()

    override fun parseOutput(data: JsonNode): GetCookiePreferencesResponseData {
        val node = data.path("cookiePreferences")
        return GetCookiePreferencesResponseData(
            preferences =
                CookiePreferences(
                    analytics = node.path("analytics").asBooleanOrNull(),
                    marketing = node.path("marketing").asBooleanOrNull(),
                    functional = node.path("functional").asBooleanOrNull(),
                    updatedAt = node.path("updatedAt").asTextOrNull(),
                ),
        )
    }
}
