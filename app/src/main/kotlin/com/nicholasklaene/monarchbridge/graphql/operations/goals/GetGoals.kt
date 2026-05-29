package com.nicholasklaene.monarchbridge.graphql.operations.goals

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.Goal
import com.nicholasklaene.monarchbridge.generated.model.ListGoalsResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asBooleanOrNull
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asIntOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/**
 * List all v2 savings goals (active + archived). Output is the spec-generated [ListGoalsResponseData].
 *
 * The full `GoalSummaryFields` fragment from Monarch's web bundle includes ~25 additional fields
 * (per-account allocation breakdowns, monthly contribution summaries, etc.); we lift only what
 * a CLI list view needs. Power users wanting deeper detail can switch to per-goal queries later.
 */
object GetGoals : MonarchOperation<Unit, ListGoalsResponseData> {
    override val operationName: String = "Common_SavingsGoals"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    override fun variables(input: Unit): Map<String, Any?> = emptyMap()

    override fun parseOutput(data: JsonNode): ListGoalsResponseData =
        ListGoalsResponseData(
            goals = data.path("savingsGoals").map(::parseGoal),
        )

    fun parseGoal(node: JsonNode): Goal =
        Goal(
            id = node.path("id").asText(""),
            name = node.path("name").asText(""),
            type = node.path("type").asTextOrNull(),
            status = node.path("status").asTextOrNull(),
            progress = node.path("progress").asDoubleOrNull(),
            currentBalance = node.path("currentBalance").asDoubleOrNull(),
            targetAmount = node.path("targetAmount").asDoubleOrNull(),
            targetDate = node.path("targetDate").asTextOrNull(),
            archivedAt = node.path("archivedAt").asTextOrNull(),
            createdAt = node.path("createdAt").asTextOrNull(),
            priority = node.path("priority").asIntOrNull(),
            isSinkingFund = node.path("isSinkingFund").asBooleanOrNull(),
            plannedMonthlyContribution = node.path("plannedMonthlyContribution").asDoubleOrNull(),
            estimatedMonthsUntilCompletion = node.path("estimatedMonthsUntilCompletion").asIntOrNull(),
            forecastedCompletionDate = node.path("forecastedCompletionDate").asTextOrNull(),
            imageStorageProvider = node.path("imageStorageProvider").asTextOrNull(),
            imageStorageProviderId = node.path("imageStorageProviderId").asTextOrNull(),
        )
}
