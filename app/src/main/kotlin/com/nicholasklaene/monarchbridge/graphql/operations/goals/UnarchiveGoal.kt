package com.nicholasklaene.monarchbridge.graphql.operations.goals

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.CreateGoalResponseData
import com.nicholasklaene.monarchbridge.generated.model.Goal
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/**
 * Un-archive (restore) a savings goal — inverse of [ArchiveGoal]. Clears `archivedAt` upstream
 * and flips status back to `active`.
 *
 * Returns the restored goal under the shared [CreateGoalResponseData] envelope.
 */
object UnarchiveGoal : MonarchOperation<UnarchiveGoal.Input, CreateGoalResponseData> {
    override val operationName: String = "Common_UnarchiveSavingsGoal"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val goalId: String,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("input" to mapOf("id" to input.goalId))

    override fun parseOutput(data: JsonNode): CreateGoalResponseData {
        val node = data.path("unarchiveSavingsGoal").path("savingsGoal")
        return CreateGoalResponseData(
            goal =
                Goal(
                    id = node.path("id").asText(""),
                    name = node.path("name").asText(""),
                    archivedAt = node.path("archivedAt").asTextOrNull(),
                    status = node.path("status").asTextOrNull(),
                ),
        )
    }
}
