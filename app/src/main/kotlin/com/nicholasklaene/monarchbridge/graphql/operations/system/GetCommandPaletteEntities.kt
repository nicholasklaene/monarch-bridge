package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetLookupResponseData
import com.nicholasklaene.monarchbridge.generated.model.LookupEntity
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/**
 * Cross-entity semantic search backing the web command palette. One call returns
 * accounts + categories + tags + merchants matching the query string, each tagged with
 * its `type` so the caller can route to the right resource. Cuts the typical
 * "search accounts then categories then tags then merchants" round-trip dance to one.
 */
object GetCommandPaletteEntities :
    MonarchOperation<GetCommandPaletteEntities.Input, GetLookupResponseData> {
    override val operationName: String = "Web_GetCommandPaletteEntities"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val query: String,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("query" to input.query)

    override fun parseOutput(data: JsonNode): GetLookupResponseData =
        GetLookupResponseData(
            results =
                data.path("semanticSearch").path("results").map { node ->
                    LookupEntity(
                        id = node.path("id").asText(""),
                        type = node.path("type").asText(""),
                        name = node.path("name").asText(""),
                        icon = node.path("icon").asTextOrNull(),
                        logoUrl = node.path("logoUrl").asTextOrNull(),
                    )
                },
        )
}
