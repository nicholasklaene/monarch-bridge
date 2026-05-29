package com.nicholasklaene.monarchbridge.graphql.operations.budgets

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.ResetBudgetRequest
import com.nicholasklaene.monarchbridge.generated.model.ResetBudgetResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation

/**
 * Reset the budget for one month — clears all planned amounts back to defaults.
 *
 * Output is the spec-generated inner `data` payload — always `reset = true` on
 * success, since Monarch's mutation only returns `errors`.
 */
object ResetBudget : MonarchOperation<ResetBudget.Input, ResetBudgetResponseData> {
    override val operationName: String = "Common_ResetBudget"
    override val query: String by lazy { GraphQLLoader.load(operationName, fragments = listOf("PayloadErrorFields")) }

    data class Input(
        val startDate: String,
    ) {
        companion object {
            fun from(req: ResetBudgetRequest): Input = Input(startDate = req.startDate)
        }
    }

    override fun variables(input: Input): Map<String, Any?> = mapOf("input" to mapOf("startDate" to input.startDate))

    override fun parseOutput(data: JsonNode): ResetBudgetResponseData = ResetBudgetResponseData(reset = true)
}
