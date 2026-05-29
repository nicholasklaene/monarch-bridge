package com.nicholasklaene.monarchbridge.graphql.operations.budgets

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.UpdateBudgetSettingsRequest
import com.nicholasklaene.monarchbridge.generated.model.UpdateBudgetSettingsResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asBooleanOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/** Patch household-wide budget settings: budget system + apply-to-future-months default. */
object UpdateBudgetSettings :
    MonarchOperation<UpdateBudgetSettings.Input, UpdateBudgetSettingsResponseData> {
    override val operationName: String = "Common_UpdateBudgetSettings"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val budgetSystem: String?,
        val budgetApplyToFutureMonthsDefault: Boolean?,
    ) {
        companion object {
            fun from(req: UpdateBudgetSettingsRequest): Input =
                Input(
                    budgetSystem = req.budgetSystem,
                    budgetApplyToFutureMonthsDefault = req.budgetApplyToFutureMonthsDefault,
                )
        }
    }

    override fun variables(input: Input): Map<String, Any?> {
        val map = mutableMapOf<String, Any?>()
        input.budgetSystem?.let { map["budgetSystem"] = it }
        input.budgetApplyToFutureMonthsDefault?.let { map["budgetApplyToFutureMonthsDefault"] = it }
        return mapOf("input" to map)
    }

    override fun parseOutput(data: JsonNode): UpdateBudgetSettingsResponseData {
        val node = data.path("updateBudgetSettings")
        val rollover = node.path("budgetRolloverPeriod")
        return UpdateBudgetSettingsResponseData(
            budgetSystem = node.path("budgetSystem").asTextOrNull(),
            budgetApplyToFutureMonthsDefault = node.path("budgetApplyToFutureMonthsDefault").asBooleanOrNull(),
            budgetRolloverPeriodId = rollover.path("id").asTextOrNull(),
            budgetRolloverPeriodStartMonth = rollover.path("startMonth").asTextOrNull(),
        )
    }
}
