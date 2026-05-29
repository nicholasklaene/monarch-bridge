package com.nicholasklaene.monarchbridge.graphql.operations.goals

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GoalPriority
import com.nicholasklaene.monarchbridge.generated.model.UpdateGoalsPrioritiesRequest
import com.nicholasklaene.monarchbridge.generated.model.UpdateGoalsPrioritiesResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asIntOrNull

/**
 * Re-order savings goals. Caller posts the ordered list of goal ids (lower index = higher
 * priority); the operation expands it into Monarch's `{id, priority}` pairs starting at 0.
 *
 * Returns the updated `(goalId, priority)` pairs so the caller can verify ordering applied.
 */
object UpdateGoalsPriorities :
    MonarchOperation<UpdateGoalsPriorities.Input, UpdateGoalsPrioritiesResponseData> {
    override val operationName: String = "Common_UpdateSavingsGoalsPriorities"
    override val query: String by lazy { GraphQLLoader.load(operationName, fragments = listOf("PayloadErrorFields")) }

    data class Input(
        val orderedGoalIds: List<String>,
    ) {
        companion object {
            fun from(req: UpdateGoalsPrioritiesRequest): Input = Input(orderedGoalIds = req.goalIds)
        }
    }

    override fun variables(input: Input): Map<String, Any?> {
        val goals =
            input.orderedGoalIds.mapIndexed { index, id ->
                mapOf("id" to id, "priority" to index)
            }
        return mapOf("input" to mapOf("goals" to goals))
    }

    override fun parseOutput(data: JsonNode): UpdateGoalsPrioritiesResponseData {
        val goals =
            data
                .path("updateSavingsGoalsPriorities")
                .path("goals")
                .takeIf { it.isArray }
                ?.map { node ->
                    GoalPriority(
                        goalId = node.path("id").asText(""),
                        priority = node.path("priority").asIntOrNull(),
                    )
                }.orEmpty()
        return UpdateGoalsPrioritiesResponseData(goals = goals)
    }
}
