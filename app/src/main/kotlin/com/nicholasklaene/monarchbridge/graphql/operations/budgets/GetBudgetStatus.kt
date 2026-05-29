package com.nicholasklaene.monarchbridge.graphql.operations.budgets

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.BudgetStatus
import com.nicholasklaene.monarchbridge.generated.model.GetBudgetStatusResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asBooleanOrNull

/** Budget status flags: has-budget, has-transactions, bootstrap-path. */
object GetBudgetStatus : MonarchOperation<Unit, GetBudgetStatusResponseData> {
    override val operationName: String = "Common_GetBudgetStatus"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    override fun variables(input: Unit): Map<String, Any?> = emptyMap()

    override fun parseOutput(data: JsonNode): GetBudgetStatusResponseData {
        val node = data.path("budgetStatus")
        return GetBudgetStatusResponseData(
            status =
                BudgetStatus(
                    hasBudget = node.path("hasBudget").asBooleanOrNull(),
                    hasTransactions = node.path("hasTransactions").asBooleanOrNull(),
                    willCreateBudgetFromEmptyDefaultCategories =
                        node.path("willCreateBudgetFromEmptyDefaultCategories").asBooleanOrNull(),
                ),
        )
    }
}
