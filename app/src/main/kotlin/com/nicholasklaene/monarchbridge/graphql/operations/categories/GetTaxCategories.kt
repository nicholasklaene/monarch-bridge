package com.nicholasklaene.monarchbridge.graphql.operations.categories

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetTaxCategoriesResponseData
import com.nicholasklaene.monarchbridge.generated.model.TaxCategoryWithSystem
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/**
 * All categories with their `systemCategory` tag attached. Used by the tax-prep flow so
 * callers can map any category to its underlying tax bucket without per-category lookups.
 *
 * Output is the spec-generated inner `data` payload.
 */
object GetTaxCategories : MonarchOperation<Unit, GetTaxCategoriesResponseData> {
    override val operationName: String = "Web_GetAllCategoriesForTaxPrep"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    override fun variables(input: Unit): Map<String, Any?> = emptyMap()

    override fun parseOutput(data: JsonNode): GetTaxCategoriesResponseData =
        GetTaxCategoriesResponseData(
            categories =
                data.path("categories").map { node ->
                    TaxCategoryWithSystem(
                        id = node.path("id").asText(""),
                        name = node.path("name").asTextOrNull(),
                        icon = node.path("icon").asTextOrNull(),
                        systemCategory = node.path("systemCategory").asTextOrNull(),
                    )
                },
        )
}
