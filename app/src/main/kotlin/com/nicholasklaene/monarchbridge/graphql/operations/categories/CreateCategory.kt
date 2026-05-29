package com.nicholasklaene.monarchbridge.graphql.operations.categories

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.Category
import com.nicholasklaene.monarchbridge.generated.model.CategoryGroupRef
import com.nicholasklaene.monarchbridge.generated.model.CreateCategoryRequest
import com.nicholasklaene.monarchbridge.generated.model.CreateCategoryResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import com.nicholasklaene.monarchbridge.graphql.pathOrNull
import java.time.LocalDate

/**
 * Create a custom category under a group. `rolloverStartMonth` defaults to first of current month.
 *
 * Output is the spec-generated inner `data` payload.
 */
object CreateCategory : MonarchOperation<CreateCategory.Input, CreateCategoryResponseData> {
    override val operationName: String = "Web_CreateCategory"
    override val query: String by lazy {
        GraphQLLoader.load(operationName, fragments = listOf("PayloadErrorFields", "CategoryFormFields"))
    }

    data class Input(
        val group: String,
        val name: String,
        val icon: String = "❓",
        val rolloverEnabled: Boolean = false,
        val rolloverType: String = "monthly",
        val rolloverStartMonth: String = LocalDate.now().withDayOfMonth(1).toString(),
    ) {
        companion object {
            fun from(req: CreateCategoryRequest): Input =
                Input(
                    group = req.group,
                    name = req.name,
                    icon = req.icon ?: "❓",
                    rolloverEnabled = req.rolloverEnabled ?: false,
                    rolloverType = req.rolloverType ?: "monthly",
                    rolloverStartMonth = req.rolloverStartMonth ?: LocalDate.now().withDayOfMonth(1).toString(),
                )
        }
    }

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "input" to
                mapOf(
                    "group" to input.group,
                    "name" to input.name,
                    "icon" to input.icon,
                    "rolloverEnabled" to input.rolloverEnabled,
                    "rolloverType" to input.rolloverType,
                    "rolloverStartMonth" to input.rolloverStartMonth,
                ),
        )

    override fun parseOutput(data: JsonNode): CreateCategoryResponseData {
        val node = data.path("createCategory").path("category")
        return CreateCategoryResponseData(
            category =
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
                ),
        )
    }
}
