package com.nicholasklaene.monarchbridge.graphql.operations.goals

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.SpendFromGoalRequest
import com.nicholasklaene.monarchbridge.generated.model.SpendFromGoalResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import java.time.LocalDate

/** Record a spend event against a savings goal. */
object SpendFromGoal : MonarchOperation<SpendFromGoal.Input, SpendFromGoalResponseData> {
    override val operationName: String = "Common_SpendFromGoal"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val goalId: String,
        val amount: Double,
        val date: LocalDate?,
        val notes: String?,
    ) {
        companion object {
            fun from(
                id: String,
                req: SpendFromGoalRequest,
            ): Input = Input(goalId = id, amount = req.amount, date = req.date, notes = req.notes)
        }
    }

    override fun variables(input: Input): Map<String, Any?> {
        val map =
            mutableMapOf<String, Any?>(
                "goalId" to input.goalId,
                "amount" to input.amount,
            )
        input.date?.let { map["date"] = it.toString() }
        input.notes?.let { map["notes"] = it }
        return mapOf("input" to map)
    }

    override fun parseOutput(data: JsonNode): SpendFromGoalResponseData =
        SpendFromGoalResponseData(
            goalEventId =
                data
                    .path("spendFromGoal")
                    .path("goalEvent")
                    .path("id")
                    .asText(""),
        )
}
