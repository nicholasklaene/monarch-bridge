package com.nicholasklaene.monarchbridge.graphql.operations.budgets

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.SetBudgetAmountRequest
import com.nicholasklaene.monarchbridge.generated.model.SetBudgetAmountResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/**
 * Set the planned budget amount for a single category OR category-group for a given
 * month. Pass exactly one of [Input.categoryId] / [Input.categoryGroupId] — Monarch
 * rejects both-set and both-null. `amount = 0` clears (un-sets) the budget.
 *
 * `applyToFuture = true` applies the amount to all subsequent months until something
 * else sets a different value.
 *
 * Output is the spec-generated inner `data` payload.
 */
object SetBudgetAmount : MonarchOperation<SetBudgetAmount.Input, SetBudgetAmountResponseData> {
    override val operationName: String = "Common_UpdateBudgetItem"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val amount: Double,
        val categoryId: String? = null,
        val categoryGroupId: String? = null,
        val startDate: String,
        val timeframe: String = "month",
        val applyToFuture: Boolean = false,
    ) {
        init {
            require((categoryId == null) != (categoryGroupId == null)) {
                "Pass exactly one of categoryId / categoryGroupId."
            }
        }

        companion object {
            fun from(req: SetBudgetAmountRequest): Input =
                Input(
                    amount = req.amount,
                    categoryId = req.categoryId,
                    categoryGroupId = req.categoryGroupId,
                    startDate = req.startDate,
                    timeframe = req.timeframe?.value ?: "month",
                    applyToFuture = req.applyToFuture ?: false,
                )
        }
    }

    override fun variables(input: Input): Map<String, Any?> {
        val inner =
            buildMap<String, Any?> {
                put("amount", input.amount)
                put("startDate", input.startDate)
                put("timeframe", input.timeframe)
                put("applyToFuture", input.applyToFuture)
                if (input.categoryId != null) put("categoryId", input.categoryId)
                if (input.categoryGroupId != null) put("categoryGroupId", input.categoryGroupId)
            }
        return mapOf("input" to inner)
    }

    override fun parseOutput(data: JsonNode): SetBudgetAmountResponseData {
        val item = data.path("updateOrCreateBudgetItem").path("budgetItem")
        return SetBudgetAmountResponseData(
            id = item.path("id").asTextOrNull(),
            budgetAmount = item.path("budgetAmount").asDoubleOrNull(),
        )
    }
}
