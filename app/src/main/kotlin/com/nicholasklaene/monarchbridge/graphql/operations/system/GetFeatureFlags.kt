package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.FeatureFlag
import com.nicholasklaene.monarchbridge.generated.model.GetFeatureFlagsResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asBooleanOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/** All Monarch feature flags + their enabled state + active variant. */
object GetFeatureFlags : MonarchOperation<Unit, GetFeatureFlagsResponseData> {
    override val operationName: String = "Web_GetFeatureFlags"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    override fun variables(input: Unit): Map<String, Any?> = emptyMap()

    override fun parseOutput(data: JsonNode): GetFeatureFlagsResponseData =
        GetFeatureFlagsResponseData(
            flags =
                data.path("featureFlags").map { node ->
                    FeatureFlag(
                        name = node.path("name").asText(""),
                        enabled = node.path("enabled").asBooleanOrNull(),
                        variant = node.path("variant").asTextOrNull(),
                    )
                },
        )
}
