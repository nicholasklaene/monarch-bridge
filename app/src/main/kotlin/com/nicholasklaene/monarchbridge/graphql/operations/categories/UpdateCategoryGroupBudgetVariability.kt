package com.nicholasklaene.monarchbridge.graphql.operations.categories

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.CategoryGroupBudgetVariabilityRef
import com.nicholasklaene.monarchbridge.generated.model.UpdateCategoryGroupBudgetVariabilityRequest
import com.nicholasklaene.monarchbridge.generated.model.UpdateCategoryGroupBudgetVariabilityResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/**
 * Narrowly-scoped update that flips a category group's `budgetVariability` (fixed vs flex).
 *
 * Wraps Monarch's `Common_UpdateCategoryGroupBudgetVariability` mutation; the server-side
 * mutation is the same `updateCategoryGroup`, but the response selection set is narrower
 * (id + budgetVariability + updatedAt) so we surface a matching narrower DTO.
 */
object UpdateCategoryGroupBudgetVariability :
    MonarchOperation<UpdateCategoryGroupBudgetVariability.Input, UpdateCategoryGroupBudgetVariabilityResponseData> {
    override val operationName: String = "Common_UpdateCategoryGroupBudgetVariability"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val id: String,
        val budgetVariability: String,
    ) {
        companion object {
            fun from(
                id: String,
                req: UpdateCategoryGroupBudgetVariabilityRequest,
            ): Input = Input(id = id, budgetVariability = req.budgetVariability)
        }
    }

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "input" to
                mapOf(
                    "id" to input.id,
                    "budgetVariability" to input.budgetVariability,
                ),
        )

    override fun parseOutput(data: JsonNode): UpdateCategoryGroupBudgetVariabilityResponseData {
        val node = data.path("updateCategoryGroup").path("categoryGroup")
        return UpdateCategoryGroupBudgetVariabilityResponseData(
            categoryGroup =
                CategoryGroupBudgetVariabilityRef(
                    id = node.path("id").asText(""),
                    budgetVariability = node.path("budgetVariability").asTextOrNull(),
                    updatedAt = node.path("updatedAt").asTextOrNull(),
                ),
        )
    }
}
