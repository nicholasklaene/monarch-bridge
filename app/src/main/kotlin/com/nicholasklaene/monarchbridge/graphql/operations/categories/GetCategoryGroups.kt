package com.nicholasklaene.monarchbridge.graphql.operations.categories

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.CategoryGroup
import com.nicholasklaene.monarchbridge.generated.model.ListCategoryGroupsResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/**
 * Top-level category groups (parent containers for individual categories).
 *
 * Output is the spec-generated inner `data` payload.
 */
object GetCategoryGroups : MonarchOperation<Unit, ListCategoryGroupsResponseData> {
    override val operationName: String = "ManageGetCategoryGroups"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    override fun variables(input: Unit): Map<String, Any?> = emptyMap()

    override fun parseOutput(data: JsonNode): ListCategoryGroupsResponseData =
        ListCategoryGroupsResponseData(
            categoryGroups =
                data.path("categoryGroups").map {
                    CategoryGroup(
                        id = it.path("id").asText(""),
                        name = it.path("name").asText(""),
                        type = it.path("type").asTextOrNull(),
                    )
                },
        )
}
