package com.nicholasklaene.monarchbridge.graphql.operations.goals

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetGoalContributionHistoryResponseData
import com.nicholasklaene.monarchbridge.generated.model.GoalContribution
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/**
 * Ledger of contributions explicitly logged against one goal. Distinct from
 * `/v1/goals/{id}/events` which includes auto-linked transactions too.
 */
object GetGoalContributionHistory :
    MonarchOperation<GetGoalContributionHistory.Input, GetGoalContributionHistoryResponseData> {
    override val operationName: String = "Web_GetGoalContributionHistory"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val goalId: String,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("id" to input.goalId)

    override fun parseOutput(data: JsonNode): GetGoalContributionHistoryResponseData =
        GetGoalContributionHistoryResponseData(
            contributions =
                data.path("savingsGoalContributions").path("contributions").map { c ->
                    GoalContribution(
                        id = c.path("id").asText(""),
                        date = c.path("date").asTextOrNull(),
                        amount = c.path("amount").asDoubleOrNull(),
                        accountId = c.path("accountId").asTextOrNull(),
                        notes = c.path("notes").asTextOrNull(),
                    )
                },
        )
}
