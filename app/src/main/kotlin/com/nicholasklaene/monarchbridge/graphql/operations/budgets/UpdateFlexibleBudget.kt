package com.nicholasklaene.monarchbridge.graphql.operations.budgets

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.SetBudgetAmountResponseData
import com.nicholasklaene.monarchbridge.generated.model.UpdateFlexibleBudgetRequest
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/**
 * Update the Flex bucket total (the "fixed_and_flex" budget system's flexible-expense
 * allowance for a given month). Unlike [SetBudgetAmount] which targets a single category,
 * this sets the bucket-level allowance.
 *
 * Output reuses [SetBudgetAmountResponseData] because the generator dedupes — both
 * responses share the same `{id, budgetAmount}` shape.
 */
object UpdateFlexibleBudget : MonarchOperation<UpdateFlexibleBudget.Input, SetBudgetAmountResponseData> {
    override val operationName: String = "Common_UpdateFlexBudgetMutation"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val amount: Double,
        val startDate: String,
        val applyToFuture: Boolean = false,
    ) {
        companion object {
            fun from(req: UpdateFlexibleBudgetRequest): Input =
                Input(amount = req.amount, startDate = req.startDate, applyToFuture = req.applyToFuture ?: false)
        }
    }

    override fun variables(input: Input): Map<String, Any?> =
        mapOf("input" to mapOf("startDate" to input.startDate, "amount" to input.amount, "applyToFuture" to input.applyToFuture))

    override fun parseOutput(data: JsonNode): SetBudgetAmountResponseData {
        val item = data.path("updateOrCreateFlexBudgetItem").path("budgetItem")
        return SetBudgetAmountResponseData(
            id = item.path("id").asTextOrNull(),
            budgetAmount = item.path("budgetAmount").asDoubleOrNull(),
        )
    }
}
