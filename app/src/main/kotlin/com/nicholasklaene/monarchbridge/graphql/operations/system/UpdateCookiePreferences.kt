package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.CookiePreferences
import com.nicholasklaene.monarchbridge.generated.model.GetCookiePreferencesResponseData
import com.nicholasklaene.monarchbridge.generated.model.UpdateCookiePreferencesRequest
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asBooleanOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import com.nicholasklaene.monarchbridge.graphql.mapOfNotNull

/** Patch any subset of cookie consents. Returns the same envelope as GetCookiePreferences (generator dedupes). */
object UpdateCookiePreferences :
    MonarchOperation<UpdateCookiePreferences.Input, GetCookiePreferencesResponseData> {
    override val operationName: String = "Common_UpdateCookiePreferences"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val analytics: Boolean? = null,
        val marketing: Boolean? = null,
        val functional: Boolean? = null,
    ) {
        companion object {
            fun from(req: UpdateCookiePreferencesRequest): Input =
                Input(
                    analytics = req.analytics,
                    marketing = req.marketing,
                    functional = req.functional,
                )
        }
    }

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "input" to
                mapOfNotNull(
                    "analytics" to input.analytics,
                    "marketing" to input.marketing,
                    "functional" to input.functional,
                ),
        )

    override fun parseOutput(data: JsonNode): GetCookiePreferencesResponseData {
        val node = data.path("updateCookiePreferences").path("cookiePreferences")
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
