package com.nicholasklaene.monarchbridge.graphql.operations.categories

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.CategoryDeletionInfo
import com.nicholasklaene.monarchbridge.generated.model.GetCategoryDeletionInfoResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asBooleanOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import com.nicholasklaene.monarchbridge.graphql.pathOrNull

/** Slim category snapshot for the delete-confirm dialog. */
object GetCategoryDeletionInfo : MonarchOperation<GetCategoryDeletionInfo.Input, GetCategoryDeletionInfoResponseData> {
    override val operationName: String = "Web_GetCategoryForDeletion"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val id: String,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("id" to input.id)

    override fun parseOutput(data: JsonNode): GetCategoryDeletionInfoResponseData =
        GetCategoryDeletionInfoResponseData(
            category =
                data.pathOrNull("category")?.let { c ->
                    CategoryDeletionInfo(
                        id = c.path("id").asText(""),
                        name = c.path("name").asTextOrNull(),
                        icon = c.path("icon").asTextOrNull(),
                        isSystemCategory = c.path("isSystemCategory").asBooleanOrNull(),
                    )
                },
        )
}
