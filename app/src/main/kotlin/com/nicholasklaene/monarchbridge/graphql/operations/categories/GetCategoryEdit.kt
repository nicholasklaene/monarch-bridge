package com.nicholasklaene.monarchbridge.graphql.operations.categories

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.CategoryEditFields
import com.nicholasklaene.monarchbridge.generated.model.GetCategoryEditResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asBooleanOrNull
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asIntOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import com.nicholasklaene.monarchbridge.graphql.pathOrNull
import java.time.LocalDate

/** One category enriched with edit-form fields (group + rollover period + budget flags). */
object GetCategoryEdit : MonarchOperation<GetCategoryEdit.Input, GetCategoryEditResponseData> {
    override val operationName: String = "Web_GetEditCategory"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val id: String,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("id" to input.id)

    override fun parseOutput(data: JsonNode): GetCategoryEditResponseData =
        GetCategoryEditResponseData(
            category =
                data.pathOrNull("category")?.let { c ->
                    val group = c.path("group")
                    val rollover = c.path("rolloverPeriod")
                    CategoryEditFields(
                        id = c.path("id").asText(""),
                        order = c.path("order").asIntOrNull(),
                        name = c.path("name").asTextOrNull(),
                        icon = c.path("icon").asTextOrNull(),
                        systemCategory = c.path("systemCategory").asTextOrNull(),
                        systemCategoryDisplayName = c.path("systemCategoryDisplayName").asTextOrNull(),
                        budgetVariability = c.path("budgetVariability").asTextOrNull(),
                        excludeFromBudget = c.path("excludeFromBudget").asBooleanOrNull(),
                        isSystemCategory = c.path("isSystemCategory").asBooleanOrNull(),
                        isDisabled = c.path("isDisabled").asBooleanOrNull(),
                        isProtected = c.path("isProtected").asBooleanOrNull(),
                        groupId = group.path("id").asTextOrNull(),
                        groupType = group.path("type").asTextOrNull(),
                        groupLevelBudgetingEnabled = group.path("groupLevelBudgetingEnabled").asBooleanOrNull(),
                        rolloverPeriodId = rollover.path("id").asTextOrNull(),
                        rolloverStartMonth = rollover.path("startMonth").asTextOrNull()?.let(LocalDate::parse),
                        rolloverStartingBalance = rollover.path("startingBalance").asDoubleOrNull(),
                        rolloverType = rollover.path("type").asTextOrNull(),
                        rolloverFrequency = rollover.path("frequency").asTextOrNull(),
                        rolloverTargetAmount = rollover.path("targetAmount").asDoubleOrNull(),
                    )
                },
        )
}
