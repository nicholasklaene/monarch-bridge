package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.Appearance
import com.nicholasklaene.monarchbridge.generated.model.GetAppearanceResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asBooleanOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/** Per-user appearance settings: theme, accent color, compact-mode flag. */
object GetAppearance : MonarchOperation<Unit, GetAppearanceResponseData> {
    override val operationName: String = "Common_GetAppearance"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    override fun variables(input: Unit): Map<String, Any?> = emptyMap()

    override fun parseOutput(data: JsonNode): GetAppearanceResponseData {
        val node = data.path("appearance")
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
