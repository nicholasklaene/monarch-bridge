package com.nicholasklaene.monarchbridge.graphql.operations.goals

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.MarkGoalCompleteResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/** Stamp `completedAt=now` on a savings goal. Triggers a celebration in the UI. */
object MarkGoalComplete : MonarchOperation<MarkGoalComplete.Input, MarkGoalCompleteResponseData> {
    override val operationName: String = "Common_MarkGoalComplete"
    override val query: String by lazy { GraphQLLoader.load(operationName, fragments = listOf("PayloadErrorFields")) }

    data class Input(
        val id: String,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("input" to mapOf("id" to input.id))

    override fun parseOutput(data: JsonNode): MarkGoalCompleteResponseData {
        val node = data.path("markGoalComplete").path("goal")
        return MarkGoalCompleteResponseData(
            id = node.path("id").asText(""),
            completedAt = node.path("completedAt").asTextOrNull(),
        )
    }
}
