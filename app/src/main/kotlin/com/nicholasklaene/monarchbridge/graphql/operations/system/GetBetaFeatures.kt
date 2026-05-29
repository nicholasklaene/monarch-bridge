package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.BetaFeature
import com.nicholasklaene.monarchbridge.generated.model.GetBetaFeaturesResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asBooleanOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/** Opt-in beta features available to this household + the user's current enrollment state. */
object GetBetaFeatures : MonarchOperation<Unit, GetBetaFeaturesResponseData> {
    override val operationName: String = "Web_GetBetaFeatures"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    override fun variables(input: Unit): Map<String, Any?> = emptyMap()

    override fun parseOutput(data: JsonNode): GetBetaFeaturesResponseData =
        GetBetaFeaturesResponseData(
            features =
                data.path("betaFeatures").map { node ->
                    BetaFeature(
                        name = node.path("name").asText(""),
                        description = node.path("description").asTextOrNull(),
                        enrolled = node.path("enrolled").asBooleanOrNull(),
                    )
                },
        )
}
