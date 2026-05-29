package com.nicholasklaene.monarchbridge.graphql.operations.categories

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.CategoryGroupChildCategory
import com.nicholasklaene.monarchbridge.generated.model.CategoryGroupDetails
import com.nicholasklaene.monarchbridge.generated.model.GetCategoryGroupDetailsResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asBooleanOrNull
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asIntOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import com.nicholasklaene.monarchbridge.graphql.pathOrNull
import java.time.LocalDate

/** Category-group detail including child categories and group-level rollover config. */
object GetCategoryGroupDetails :
    MonarchOperation<GetCategoryGroupDetails.Input, GetCategoryGroupDetailsResponseData> {
    override val operationName: String = "Web_GetCategoryGroupModal"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val id: String,
        val includeDisabledSystemCategories: Boolean?,
    )

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "id" to input.id,
            "includeDisabledSystemCategories" to input.includeDisabledSystemCategories,
        )

    @Suppress("LongMethod")
    override fun parseOutput(data: JsonNode): GetCategoryGroupDetailsResponseData =
        GetCategoryGroupDetailsResponseData(
            categoryGroup =
                data.pathOrNull("categoryGroup")?.let { g ->
                    val rollover = g.path("rolloverPeriod")
                    CategoryGroupDetails(
                        id = g.path("id").asText(""),
                        name = g.path("name").asTextOrNull(),
                        order = g.path("order").asIntOrNull(),
                        type = g.path("type").asTextOrNull(),
                        color = g.path("color").asTextOrNull(),
                        groupLevelBudgetingEnabled = g.path("groupLevelBudgetingEnabled").asBooleanOrNull(),
                        budgetVariability = g.path("budgetVariability").asTextOrNull(),
                        rolloverPeriodId = rollover.path("id").asTextOrNull(),
                        rolloverStartMonth = rollover.path("startMonth").asTextOrNull()?.let(LocalDate::parse),
                        rolloverEndMonth = rollover.path("endMonth").asTextOrNull()?.let(LocalDate::parse),
                        rolloverStartingBalance = rollover.path("startingBalance").asDoubleOrNull(),
                        categories =
                            g.path("categories").map { c ->
                                val cr = c.path("rolloverPeriod")
                                CategoryGroupChildCategory(
                                    id = c.path("id").asText(""),
                                    name = c.path("name").asTextOrNull(),
                                    icon = c.path("icon").asTextOrNull(),
                                    rolloverPeriodId = cr.path("id").asTextOrNull(),
                                    rolloverStartMonth = cr.path("startMonth").asTextOrNull()?.let(LocalDate::parse),
                                    rolloverStartingBalance = cr.path("startingBalance").asDoubleOrNull(),
                                )
                            },
                    )
                },
        )
}
