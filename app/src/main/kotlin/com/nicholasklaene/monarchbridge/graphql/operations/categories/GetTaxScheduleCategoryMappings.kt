package com.nicholasklaene.monarchbridge.graphql.operations.categories

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetTaxScheduleCategoryMappingsResponseData
import com.nicholasklaene.monarchbridge.generated.model.TaxCategoryRef
import com.nicholasklaene.monarchbridge.generated.model.TaxLineItemInfo
import com.nicholasklaene.monarchbridge.generated.model.TaxScheduleCategoryMapping
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asIntOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import com.nicholasklaene.monarchbridge.graphql.pathOrNull

/**
 * Monarch's tax-schedule line-item -> category mappings for a given (schedule, taxYear).
 * Use this as the lookup layer when preparing a tax schedule from category aggregates.
 *
 * Output is the spec-generated inner `data` payload.
 */
object GetTaxScheduleCategoryMappings :
    MonarchOperation<
        GetTaxScheduleCategoryMappings.Input,
        GetTaxScheduleCategoryMappingsResponseData,
    > {
    override val operationName: String = "Web_GetTaxScheduleCategoryMappings"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val schedule: String,
        val taxYear: Int,
    )

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "schedule" to input.schedule,
            "taxYear" to input.taxYear,
        )

    override fun parseOutput(data: JsonNode): GetTaxScheduleCategoryMappingsResponseData =
        GetTaxScheduleCategoryMappingsResponseData(
            mappings =
                data.path("taxScheduleCategoryMappings").map { node ->
                    TaxScheduleCategoryMapping(
                        id = node.path("id").asText(""),
                        lineItem = node.path("lineItem").asTextOrNull(),
                        schedule = node.path("schedule").asTextOrNull(),
                        taxYear = node.path("taxYear").asIntOrNull(),
                        category =
                            node.pathOrNull("category")?.let { c ->
                                TaxCategoryRef(
                                    id = c.path("id").asText(""),
                                    name = c.path("name").asTextOrNull(),
                                    icon = c.path("icon").asTextOrNull(),
                                )
                            },
                        lineItemInfo =
                            node.pathOrNull("lineItemInfo")?.let { l ->
                                TaxLineItemInfo(
                                    key = l.path("key").asText(""),
                                    lineNumber = l.path("lineNumber").asTextOrNull(),
                                    description = l.path("description").asTextOrNull(),
                                    lineType = l.path("lineType").asTextOrNull(),
                                    sortOrder = l.path("sortOrder").asIntOrNull(),
                                )
                            },
                    )
                },
        )
}
