package com.nicholasklaene.monarchbridge.graphql.operations.goals

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.LinkTransactionToGoalRequest
import com.nicholasklaene.monarchbridge.generated.model.LinkTransactionToGoalResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/** Tie one transaction to a savings goal so its balance reconciliation picks it up. */
object LinkTransactionToGoal :
    MonarchOperation<LinkTransactionToGoal.Input, LinkTransactionToGoalResponseData> {
    override val operationName: String = "Common_LinkTransactionToGoal"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val transactionId: String,
        val goalId: String,
    ) {
        companion object {
            fun from(
                id: String,
                req: LinkTransactionToGoalRequest,
            ): Input = Input(transactionId = id, goalId = req.goalId)
        }
    }

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "input" to
                mapOf(
                    "transactionId" to input.transactionId,
                    "goalId" to input.goalId,
                ),
        )

    override fun parseOutput(data: JsonNode): LinkTransactionToGoalResponseData {
        val event = data.path("linkTransactionToGoal").path("goalEvent")
        val tx = event.path("transaction")
        return LinkTransactionToGoalResponseData(
            goalEventId = event.path("id").asText(""),
            transactionId = tx.path("id").asTextOrNull(),
            goalId =
                tx
                    .path("savingsGoalEvent")
                    .path("goal")
                    .path("id")
                    .asTextOrNull(),
        )
    }
}
