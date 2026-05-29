package com.nicholasklaene.monarchbridge.graphql.operations.goals

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.GetGoalProjectionResponseData
import com.nicholasklaene.monarchbridge.generated.model.GoalProjection
import com.nicholasklaene.monarchbridge.generated.model.GoalProjectionPoint
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asIntOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import java.time.LocalDate

/**
 * Forward projection of a goal's balance at the current planned contribution rate. Returns
 * the projected completion date, months to target, and a per-month projected-balance series.
 */
object GetGoalProjection : MonarchOperation<GetGoalProjection.Input, GetGoalProjectionResponseData> {
    override val operationName: String = "Web_GetGoalProjection"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val goalId: String,
    )

    override fun variables(input: Input): Map<String, Any?> = mapOf("id" to input.goalId)

    override fun parseOutput(data: JsonNode): GetGoalProjectionResponseData {
        val node = data.path("savingsGoalProjection")
        return GetGoalProjectionResponseData(
            projection =
                GoalProjection(
                    projectedCompletionDate = node.path("projectedCompletionDate").asTextOrNull(),
                    monthsToTarget = node.path("monthsToTarget").asIntOrNull(),
                    series =
                        node.path("series").map { p ->
                            GoalProjectionPoint(
                                date = LocalDate.parse(p.path("date").asText("1970-01-01")),
                                projectedBalance = p.path("projectedBalance").asDoubleOrNull(),
                            )
                        },
                ),
        )
    }
}
