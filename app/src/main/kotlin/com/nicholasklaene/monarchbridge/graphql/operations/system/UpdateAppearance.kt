package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.Appearance
import com.nicholasklaene.monarchbridge.generated.model.GetAppearanceResponseData
import com.nicholasklaene.monarchbridge.generated.model.UpdateAppearanceRequest
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asBooleanOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/** Patch any subset of appearance settings; only populated fields forwarded. */
object UpdateAppearance : MonarchOperation<UpdateAppearance.Input, GetAppearanceResponseData> {
    override val operationName: String = "Common_UpdateAppearance"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val theme: String? = null,
        val accentColor: String? = null,
        val compactMode: Boolean? = null,
    ) {
        companion object {
            fun from(req: UpdateAppearanceRequest): Input =
                Input(
                    theme = req.theme,
                    accentColor = req.accentColor,
                    compactMode = req.compactMode,
                )
        }
    }

    override fun variables(input: Input): Map<String, Any?> {
        val pairs =
            listOfNotNull(
                input.theme?.let { "theme" to it },
                input.accentColor?.let { "accentColor" to it },
                input.compactMode?.let { "compactMode" to it },
            )
        return mapOf("input" to pairs.toMap())
    }

    override fun parseOutput(data: JsonNode): GetAppearanceResponseData {
        val node = data.path("updateAppearance").path("appearance")
        return GetAppearanceResponseData(
            appearance =
                Appearance(
                    theme = node.path("theme").asTextOrNull(),
                    accentColor = node.path("accentColor").asTextOrNull(),
                    compactMode = node.path("compactMode").asBooleanOrNull(),
                ),
        )
    }
}
