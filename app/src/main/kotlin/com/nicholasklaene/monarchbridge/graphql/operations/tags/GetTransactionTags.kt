package com.nicholasklaene.monarchbridge.graphql.operations.tags

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.ListTagsResponseData
import com.nicholasklaene.monarchbridge.generated.model.Tag
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * All household transaction tags.
 *
 * Output is the spec-generated inner `data` payload.
 */
object GetTransactionTags : MonarchOperation<Unit, ListTagsResponseData> {
    override val operationName: String = "GetHouseholdTransactionTags"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    override fun variables(input: Unit): Map<String, Any?> = emptyMap()

    override fun parseOutput(data: JsonNode): ListTagsResponseData =
        ListTagsResponseData(
            tags =
                data.path("householdTransactionTags").map {
                    Tag(
                        id = it.path("id").asText(""),
                        name = it.path("name").asText(""),
                        color = it.path("color").asText(""),
                        order = it.path("order").asInt(0),
                        transactionCount = it.path("transactionCount").asInt(0),
                    )
                },
        )
}
