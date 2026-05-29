package com.nicholasklaene.monarchbridge.graphql.operations.categories

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.Category
import com.nicholasklaene.monarchbridge.generated.model.CategoryGroupRef
import com.nicholasklaene.monarchbridge.generated.model.ListCategoriesResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import com.nicholasklaene.monarchbridge.graphql.pathOrNull

/**
 * All transaction categories (system + custom).
 *
 * Output is the spec-generated inner `data` payload.
 */
object GetCategories : MonarchOperation<Unit, ListCategoriesResponseData> {
    override val operationName: String = "GetCategories"
    override val query: String by lazy {
        GraphQLLoader.load(operationName, fragments = listOf("CategoryFields"))
    }

    override fun variables(input: Unit): Map<String, Any?> = emptyMap()

    override fun parseOutput(data: JsonNode): ListCategoriesResponseData =
        ListCategoriesResponseData(
            categories =
                data.path("categories").map { node ->
                    Category(
                        id = node.path("id").asText(""),
                        name = node.path("name").asText(""),
                        icon = node.path("icon").asTextOrNull(),
                        order = node.path("order").asInt(0),
                        systemCategory = node.path("systemCategory").asTextOrNull(),
                        isSystemCategory = node.path("isSystemCategory").asBoolean(false),
                        group =
                            node.pathOrNull("group")?.let { g ->
                                CategoryGroupRef(
                                    id = g.path("id").asText(""),
                                    name = g.path("name").asText(""),
                                    type = g.path("type").asTextOrNull(),
                                )
                            },
                    )
                },
        )
}
