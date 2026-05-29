package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetPlatformConfigResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/** Monarch platform configuration: API base URL, config version, and free-form settings list. */
object GetPlatformConfig : MonarchOperation<Unit, GetPlatformConfigResponseData> {
    override val operationName: String = "Web_GetPlatformConfig"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    override fun variables(input: Unit): Map<String, Any?> = emptyMap()

    @Suppress("UNCHECKED_CAST")
    override fun parseOutput(data: JsonNode): GetPlatformConfigResponseData {
        val cfg = data.path("platformConfig")
        val settingsNode = cfg.path("settings")
        val settings: List<Map<String, Any>>? =
            if (settingsNode.isArray) {
                settingsNode.mapNotNull { item ->
                    if (item.isObject) {
                        item.properties().associate { e -> e.key to (e.value as Any) }
                    } else {
                        null
                    }
                }
            } else {
                null
            }
        return GetPlatformConfigResponseData(
            platform = cfg.path("platform").asTextOrNull(),
            configVersion = cfg.path("configVersion").asTextOrNull(),
            apiBaseUrl = cfg.path("apiBaseUrl").asTextOrNull(),
            settings = settings,
        )
    }
}
