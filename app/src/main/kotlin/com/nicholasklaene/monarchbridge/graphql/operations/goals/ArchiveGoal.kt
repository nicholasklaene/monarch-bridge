package com.nicholasklaene.monarchbridge.graphql.operations.goals

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.CreateGoalResponseData
import com.nicholasklaene.monarchbridge.generated.model.Goal
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/**
 * Archive (soft-delete) a savings goal. Sets `archivedAt` upstream; the goal still appears
 * in `listGoals` but with `status="archived"`.
 *
 * The mutation returns a small subset of fields (`id`, `archivedAt`, `status`); we fold that
 * into the shared [Goal] DTO so the response shape stays consistent with create + list.
 */
object ArchiveGoal : MonarchOperation<ArchiveGoal.Input, CreateGoalResponseData> {
    override val operationName: String = "Common_ArchiveSavingsGoal"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val goalId: String,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("input" to mapOf("id" to input.goalId))

    override fun parseOutput(data: JsonNode): CreateGoalResponseData {
        val node = data.path("archiveSavingsGoal").path("savingsGoal")
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
