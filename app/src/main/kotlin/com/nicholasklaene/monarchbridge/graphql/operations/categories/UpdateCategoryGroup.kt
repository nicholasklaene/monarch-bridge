package com.nicholasklaene.monarchbridge.graphql.operations.categories

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.CreateCategoryGroupResponseData
import com.nicholasklaene.monarchbridge.generated.model.UpdateCategoryGroupRequest
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.mapOfNotNull

/**
 * Partial-update a category group. Path `{id}` is injected into the GraphQL `input` map;
 * only non-null Input fields are forwarded so callers can patch one field at a time.
 *
 * Use [UpdateCategoryGroupBudgetVariability] when you only need to flip the fixed/flex
 * classification — that op returns a narrower shape and exists for intent-clarity.
 */
object UpdateCategoryGroup : MonarchOperation<UpdateCategoryGroup.Input, CreateCategoryGroupResponseData> {
    override val operationName: String = "Common_UpdateCategoryGroup"
    override val query: String by lazy {
        GraphQLLoader.load(operationName, fragments = listOf("CategoryGroupFields"))
    }

    data class Input(
        val id: String,
        val name: String? = null,
        val color: String? = null,
        val icon: String? = null,
        val budgetVariability: String? = null,
        val groupLevelBudgetingEnabled: Boolean? = null,
        val rolloverEnabled: Boolean? = null,
        val rolloverType: String? = null,
        val rolloverStartMonth: String? = null,
        val rolloverStartingBalance: Double? = null,
    ) {
        companion object {
            fun from(
                id: String,
                req: UpdateCategoryGroupRequest,
            ): Input =
                Input(
                    id = id,
                    name = req.name,
                    color = req.color,
                    icon = req.icon,
                    budgetVariability = req.budgetVariability,
                    groupLevelBudgetingEnabled = req.groupLevelBudgetingEnabled,
                    rolloverEnabled = req.rolloverEnabled,
                    rolloverType = req.rolloverType,
                    rolloverStartMonth = req.rolloverStartMonth,
                    rolloverStartingBalance = req.rolloverStartingBalance,
                )
        }
    }

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "input" to
                mapOfNotNull(
                    "id" to input.id,
                    "name" to input.name,
                    "color" to input.color,
                    "icon" to input.icon,
                    "budgetVariability" to input.budgetVariability,
                    "groupLevelBudgetingEnabled" to input.groupLevelBudgetingEnabled,
                    "rolloverEnabled" to input.rolloverEnabled,
                    "rolloverType" to input.rolloverType,
                    "rolloverStartMonth" to input.rolloverStartMonth,
                    "rolloverStartingBalance" to input.rolloverStartingBalance,
                ),
        )

    override fun parseOutput(data: JsonNode): CreateCategoryGroupResponseData =
        CreateCategoryGroupResponseData(
            categoryGroup = CategoryGroupMapper.parse(data.path("updateCategoryGroup").path("categoryGroup")),
        )
}
