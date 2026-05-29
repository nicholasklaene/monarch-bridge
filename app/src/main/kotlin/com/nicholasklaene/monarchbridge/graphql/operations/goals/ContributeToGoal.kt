package com.nicholasklaene.monarchbridge.graphql.operations.goals

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.ContributeToGoalRequest
import com.nicholasklaene.monarchbridge.generated.model.ContributeToGoalResponseData
import com.nicholasklaene.monarchbridge.generated.model.ContributeToGoalResponseDataGoalEvent
import com.nicholasklaene.monarchbridge.generated.model.ContributeToGoalResponseDataGoalEventAccount
import com.nicholasklaene.monarchbridge.generated.model.ContributeToGoalResponseDataGoalEventGoal
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asBooleanOrNull
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull
import com.nicholasklaene.monarchbridge.graphql.pathOrNull
import java.time.LocalDate

/**
 * Record a contribution (or withdrawal) against one savings goal from a specific account.
 *
 * Date defaults to today if the client omits it. Amounts are dollars; negative = withdrawal.
 */
object ContributeToGoal : MonarchOperation<ContributeToGoal.Input, ContributeToGoalResponseData> {
    override val operationName: String = "Common_ContributeToSavingsGoal"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val goalId: String,
        val accountId: String,
        val amount: Double,
        val date: String = LocalDate.now().toString(),
    ) {
        companion object {
            fun from(
                goalId: String,
                req: ContributeToGoalRequest,
            ): Input =
                Input(
                    goalId = goalId,
                    accountId = req.accountId,
                    amount = req.amount,
                    date = req.date ?: LocalDate.now().toString(),
                )
        }
    }

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "input" to
                mapOf(
                    "goalId" to input.goalId,
                    "accountId" to input.accountId,
                    "amount" to input.amount,
                    "date" to input.date,
                ),
        )

    override fun parseOutput(data: JsonNode): ContributeToGoalResponseData {
        val resp = data.path("createSavingsGoalContribution")
        val event = resp.path("goalEvent")
        return ContributeToGoalResponseData(
            userNotice = resp.path("userNotice").asTextOrNull(),
            goalEvent =
                ContributeToGoalResponseDataGoalEvent(
                    id = event.path("id").asText(""),
                    goal =
                        event.pathOrNull("goal")?.let { g ->
                            ContributeToGoalResponseDataGoalEventGoal(
                                id = g.path("id").asTextOrNull(),
                                currentBalance = g.path("currentBalance").asDoubleOrNull(),
                                progress = g.path("progress").asDoubleOrNull(),
                                status = g.path("status").asTextOrNull(),
                            )
                        },
                    account =
                        event.pathOrNull("account")?.let { a ->
                            ContributeToGoalResponseDataGoalEventAccount(
                                id = a.path("id").asTextOrNull(),
                                availableBalanceForGoalsUnmemoized =
                                    a.path("availableBalanceForGoalsUnmemoized").asDoubleOrNull(),
                                includeInGoalContributions = a.path("includeInGoalContributions").asBooleanOrNull(),
                            )
                        },
                ),
        )
    }
}
