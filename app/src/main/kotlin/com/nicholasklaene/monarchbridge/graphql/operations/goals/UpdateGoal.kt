package com.nicholasklaene.monarchbridge.graphql.operations.goals

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.CreateGoalResponseData
import com.nicholasklaene.monarchbridge.generated.model.Goal
import com.nicholasklaene.monarchbridge.generated.model.UpdateGoalRequest
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asIntOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/**
 * Patch a savings goal. All input fields besides `id` are optional; only the populated ones
 * are forwarded to Monarch's `updateSavingsGoal` mutation. Goal id is always passed via the
 * URL path and folded into the input by the operation.
 *
 * Returns the updated goal under the shared [CreateGoalResponseData] envelope so the
 * single-goal response shape stays consistent with create + archive + unarchive.
 */
object UpdateGoal : MonarchOperation<UpdateGoal.Input, CreateGoalResponseData> {
    override val operationName: String = "Common_UpdateSavingsGoal"
    override val query: String by lazy { GraphQLLoader.load(operationName, fragments = listOf("PayloadErrorFields")) }

    data class Input(
        val goalId: String,
        val name: String? = null,
        val targetAmount: Double? = null,
        val targetDate: String? = null,
        val priority: Int? = null,
        val isSinkingFund: Boolean? = null,
        val imageStorageProvider: String? = null,
        val imageStorageProviderId: String? = null,
    ) {
        companion object {
            fun from(
                goalId: String,
                req: UpdateGoalRequest,
            ): Input =
                Input(
                    goalId = goalId,
                    name = req.name,
                    targetAmount = req.targetAmount,
                    targetDate = req.targetDate,
                    priority = req.priority,
                    isSinkingFund = req.isSinkingFund,
                    imageStorageProvider = req.imageStorageProvider,
                    imageStorageProviderId = req.imageStorageProviderId,
                )
        }
    }

    @Suppress("CyclomaticComplexMethod")
    override fun variables(input: Input): Map<String, Any?> {
        val payload =
            buildMap<String, Any?> {
                put("id", input.goalId)
                input.name?.let { put("name", it) }
                input.targetAmount?.let { put("targetAmount", it) }
                input.targetDate?.let { put("targetDate", it) }
                input.priority?.let { put("priority", it) }
                input.isSinkingFund?.let { put("isSinkingFund", it) }
                input.imageStorageProvider?.let { put("imageStorageProvider", it) }
                input.imageStorageProviderId?.let { put("imageStorageProviderId", it) }
            }
        return mapOf("input" to payload)
    }

    override fun parseOutput(data: JsonNode): CreateGoalResponseData {
        val node = data.path("updateSavingsGoal").path("savingsGoal")
        return CreateGoalResponseData(
            goal =
                Goal(
                    id = node.path("id").asText(""),
                    name = node.path("name").asText(""),
                    targetAmount = node.path("targetAmount").asDoubleOrNull(),
                    targetDate = node.path("targetDate").asTextOrNull(),
                    priority = node.path("priority").asIntOrNull(),
                    status = node.path("status").asTextOrNull(),
                    progress = node.path("progress").asDoubleOrNull(),
                    forecastedCompletionDate = node.path("forecastedCompletionDate").asTextOrNull(),
                    imageStorageProvider = node.path("imageStorageProvider").asTextOrNull(),
                    imageStorageProviderId = node.path("imageStorageProviderId").asTextOrNull(),
                ),
        )
    }
}
