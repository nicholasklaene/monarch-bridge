package com.nicholasklaene.monarchbridge.graphql.operations.goals

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GoalEvent
import com.nicholasklaene.monarchbridge.generated.model.GoalEventAccountRef
import com.nicholasklaene.monarchbridge.generated.model.GoalEventTransactionRef
import com.nicholasklaene.monarchbridge.generated.model.ListGoalEventsResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asBooleanOrNull
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import com.nicholasklaene.monarchbridge.graphql.pathOrNull

/**
 * Fetch the event log for one savings goal — every contribution, withdrawal, or transaction
 * linked to the goal. Each event optionally references the source account and / or backing
 * transaction.
 */
object GetGoalEvents : MonarchOperation<GetGoalEvents.Input, ListGoalEventsResponseData> {
    override val operationName: String = "Common_SavingsGoalEvents"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val goalId: String,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("id" to input.goalId)

    override fun parseOutput(data: JsonNode): ListGoalEventsResponseData {
        val events =
            data
                .path("savingsGoal")
                .path("goalEvents")
                .takeIf { it.isArray }
                ?.map(::parseGoalEvent)
                .orEmpty()
        return ListGoalEventsResponseData(events = events)
    }

    private fun parseGoalEvent(node: JsonNode): GoalEvent =
        GoalEvent(
            id = node.path("id").asText(""),
            date = node.path("date").asTextOrNull(),
            amount = node.path("amount").asDoubleOrNull(),
            type = node.path("type").asTextOrNull(),
            createdAt = node.path("createdAt").asTextOrNull(),
            canDelete = node.path("canDelete").asBooleanOrNull(),
            includeInBudget = node.path("includeInBudget").asBooleanOrNull(),
            notes = node.path("notes").asTextOrNull(),
            account =
                node.pathOrNull("account")?.let { a ->
                    GoalEventAccountRef(
                        id = a.path("id").asTextOrNull(),
                        displayName = a.path("displayName").asTextOrNull(),
                    )
                },
            transaction =
                node.pathOrNull("transaction")?.let { t ->
                    GoalEventTransactionRef(
                        id = t.path("id").asTextOrNull(),
                        amount = t.path("amount").asDoubleOrNull(),
                        date = t.path("date").asTextOrNull(),
                    )
                },
        )
}
