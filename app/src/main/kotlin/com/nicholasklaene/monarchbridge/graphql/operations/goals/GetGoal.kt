package com.nicholasklaene.monarchbridge.graphql.operations.goals

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.CreateGoalResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Fetch one v2 savings goal by id. The upstream `Common_SavingsGoal` query in Monarch's web
 * bundle pulls the deep `GoalSummaryFields` fragment (per-account allocation breakdown,
 * net-contribution series); we lift only the same columns surfaced by [GetGoals] for a
 * consistent shape — power users wanting allocation detail can add a dedicated field set later.
 *
 * Returns under the shared [CreateGoalResponseData] envelope so single-goal endpoints
 * share the same payload type.
 */
object GetGoal : MonarchOperation<GetGoal.Input, CreateGoalResponseData> {
    override val operationName: String = "Common_SavingsGoal"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val goalId: String,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("id" to input.goalId)

    override fun parseOutput(data: JsonNode): CreateGoalResponseData =
        CreateGoalResponseData(goal = GetGoals.parseGoal(data.path("savingsGoal")))
}
