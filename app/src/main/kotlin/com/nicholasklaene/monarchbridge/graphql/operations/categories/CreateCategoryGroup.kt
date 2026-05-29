package com.nicholasklaene.monarchbridge.graphql.operations.categories

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.CategoryGroup
import com.nicholasklaene.monarchbridge.generated.model.CategoryGroupRolloverPeriod
import com.nicholasklaene.monarchbridge.generated.model.CreateCategoryGroupRequest
import com.nicholasklaene.monarchbridge.generated.model.CreateCategoryGroupResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asBooleanOrNull
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asIntOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import com.nicholasklaene.monarchbridge.graphql.mapOfNotNull
import com.nicholasklaene.monarchbridge.graphql.pathOrNull

/**
 * Create a new parent category group. `name` and `type` are required; the rest are
 * optional and only forwarded when non-null. `type` is one of `income`, `expense`, `transfer`.
 *
 * Response carries the freshly-created group via the shared `CategoryGroupFields` fragment.
 */
object CreateCategoryGroup : MonarchOperation<CreateCategoryGroup.Input, CreateCategoryGroupResponseData> {
    override val operationName: String = "Common_CreateCategoryGroup"
    override val query: String by lazy {
        GraphQLLoader.load(operationName, fragments = listOf("CategoryGroupFields"))
    }

    data class Input(
        val name: String,
        val type: String,
        val color: String? = null,
        val icon: String? = null,
        val budgetVariability: String? = null,
        val groupLevelBudgetingEnabled: Boolean? = null,
        val orderBefore: String? = null,
        val rolloverEnabled: Boolean? = null,
        val rolloverType: String? = null,
        val rolloverStartMonth: String? = null,
        val rolloverStartingBalance: Double? = null,
    ) {
        companion object {
            fun from(req: CreateCategoryGroupRequest): Input =
                Input(
                    name = req.name,
                    type = req.type,
                    color = req.color,
                    icon = req.icon,
                    budgetVariability = req.budgetVariability,
                    groupLevelBudgetingEnabled = req.groupLevelBudgetingEnabled,
                    orderBefore = req.orderBefore,
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
                    "name" to input.name,
                    "type" to input.type,
                    "color" to input.color,
                    "icon" to input.icon,
                    "budgetVariability" to input.budgetVariability,
                    "groupLevelBudgetingEnabled" to input.groupLevelBudgetingEnabled,
                    "orderBefore" to input.orderBefore,
                    "rolloverEnabled" to input.rolloverEnabled,
                    "rolloverType" to input.rolloverType,
                    "rolloverStartMonth" to input.rolloverStartMonth,
                    "rolloverStartingBalance" to input.rolloverStartingBalance,
                ),
        )

    override fun parseOutput(data: JsonNode): CreateCategoryGroupResponseData =
        CreateCategoryGroupResponseData(
            categoryGroup = CategoryGroupMapper.parse(data.path("createCategoryGroup").path("categoryGroup")),
        )
}

/**
 * Shared parser for the `CategoryGroupFields` fragment. The create / update mutations both
 * return the same fragment, so the field-by-field mapping lives here once.
 */
internal object CategoryGroupMapper {
    fun parse(node: JsonNode): CategoryGroup =
        CategoryGroup(
            id = node.path("id").asText(""),
            name = node.path("name").asText(""),
            order = node.path("order").asIntOrNull(),
            type = node.path("type").asTextOrNull(),
            color = node.path("color").asTextOrNull(),
            groupLevelBudgetingEnabled = node.path("groupLevelBudgetingEnabled").asBooleanOrNull(),
            budgetVariability = node.path("budgetVariability").asTextOrNull(),
            rolloverPeriod =
                node.pathOrNull("rolloverPeriod")?.let { r ->
                    CategoryGroupRolloverPeriod(
                        id = r.path("id").asTextOrNull(),
                        startMonth = r.path("startMonth").asTextOrNull(),
                        endMonth = r.path("endMonth").asTextOrNull(),
                        startingBalance = r.path("startingBalance").asDoubleOrNull(),
                    )
                },
        )
}
