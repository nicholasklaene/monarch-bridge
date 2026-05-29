package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetAppVersionResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/** Monarch web app version metadata: current / minimum-supported / recommended + build sha. */
object GetAppVersion : MonarchOperation<Unit, GetAppVersionResponseData> {
    override val operationName: String = "Web_GetAppVersion"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    override fun variables(input: Unit): Map<String, Any?> = emptyMap()

    override fun parseOutput(data: JsonNode): GetAppVersionResponseData =
        data.path("appVersion").let { v ->
            GetAppVersionResponseData(
                current = v.path("current").asTextOrNull(),
                minimum = v.path("minimum").asTextOrNull(),
                recommended = v.path("recommended").asTextOrNull(),
                buildSha = v.path("buildSha").asTextOrNull(),
            )
        }
}
