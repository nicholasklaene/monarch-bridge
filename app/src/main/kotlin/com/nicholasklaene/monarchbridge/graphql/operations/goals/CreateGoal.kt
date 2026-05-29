package com.nicholasklaene.monarchbridge.graphql.operations.goals

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.CreateGoalRequest
import com.nicholasklaene.monarchbridge.generated.model.CreateGoalResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Create one savings goal. Wraps Monarch's batch `createSavingsGoals` mutation (which accepts
 * a `goals[]` input) by submitting an array of exactly one and unwrapping the first result.
 *
 * The web bundle wraps the inner goal payload with `name`, `type`, `imageStorageProvider`,
 * `imageStorageProviderId`. Optional `targetAmount` + `targetDate` are accepted but not always
 * documented in Monarch's UI flow — we forward them when present.
 */
object CreateGoal : MonarchOperation<CreateGoal.Input, CreateGoalResponseData> {
    override val operationName: String = "Common_CreateSavingsGoals"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val name: String,
        val type: String = "savings",
        val targetAmount: Double? = null,
        val targetDate: String? = null,
        val imageStorageProvider: String? = null,
        val imageStorageProviderId: String? = null,
    ) {
        companion object {
            fun from(req: CreateGoalRequest): Input =
                Input(
                    name = req.name,
                    type = req.type ?: "savings",
                    targetAmount = req.targetAmount,
                    targetDate = req.targetDate,
                    imageStorageProvider = req.imageStorageProvider,
                    imageStorageProviderId = req.imageStorageProviderId,
                )
        }
    }

    override fun variables(input: Input): Map<String, Any?> {
        val goal =
            buildMap<String, Any?> {
                put("name", input.name)
                put("type", input.type)
                input.imageStorageProvider?.let { put("imageStorageProvider", it) }
                input.imageStorageProviderId?.let { put("imageStorageProviderId", it) }
                input.targetAmount?.let { put("targetAmount", it) }
                input.targetDate?.let { put("targetDate", it) }
            }
        return mapOf("input" to mapOf("goals" to listOf(goal)))
    }

    override fun parseOutput(data: JsonNode): CreateGoalResponseData {
        val first =
            data
                .path("createSavingsGoals")
                .path("savingsGoals")
                .takeIf { it.isArray && it.size() > 0 }
                ?.first()
                ?: error("createSavingsGoals returned no savingsGoals (expected exactly one).")
        return CreateGoalResponseData(goal = GetGoals.parseGoal(first))
    }
}
