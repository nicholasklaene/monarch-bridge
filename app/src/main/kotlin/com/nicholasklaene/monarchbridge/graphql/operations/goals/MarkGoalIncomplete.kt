package com.nicholasklaene.monarchbridge.graphql.operations.goals

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.MarkGoalCompleteResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/** Clear `completedAt` on a savings goal. Inverse of [MarkGoalComplete]. */
object MarkGoalIncomplete :
    MonarchOperation<MarkGoalIncomplete.Input, MarkGoalCompleteResponseData> {
    override val operationName: String = "Common_MarkGoalIncomplete"
    override val query: String by lazy { GraphQLLoader.load(operationName, fragments = listOf("PayloadErrorFields")) }

    data class Input(
        val id: String,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("input" to mapOf("id" to input.id))

    override fun parseOutput(data: JsonNode): MarkGoalCompleteResponseData {
        val node = data.path("markGoalIncomplete").path("goal")
        return MarkGoalCompleteResponseData(
            id = node.path("id").asText(""),
            completedAt = node.path("completedAt").asTextOrNull(),
        )
    }
}
