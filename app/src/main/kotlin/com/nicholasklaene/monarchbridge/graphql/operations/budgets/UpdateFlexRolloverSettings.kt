package com.nicholasklaene.monarchbridge.graphql.operations.budgets

import com.fasterxml.jackson.databind.JsonNode
import com.nicholasklaene.monarchbridge.generated.model.UpdateFlexRolloverSettingsRequest
import com.nicholasklaene.monarchbridge.generated.model.UpdateFlexRolloverSettingsResponseData
import com.nicholasklaene.monarchbridge.graphql.GraphQLLoader
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.asDoubleOrNull
import com.nicholasklaene.monarchbridge.graphql.asTextOrNull

/**
 * Reset / configure the Flex bucket rollover. Common use: point the rollover start
 * to the current month with `rolloverStartingBalance = 0` to clear accumulated
 * negative rollover from many over-budget months.
 *
 * Output is the spec-generated inner `data` payload.
 */
object UpdateFlexRolloverSettings : MonarchOperation<UpdateFlexRolloverSettings.Input, UpdateFlexRolloverSettingsResponseData> {
    override val operationName: String = "Web_UpdateFlexibleGroupRolloverSettings"
    override val query: String by lazy { GraphQLLoader.load(operationName) }

    data class Input(
        val rolloverStartMonth: String,
        val rolloverStartingBalance: Double = 0.0,
        val rolloverEnabled: Boolean = true,
        val budgetSystem: String = "fixed_and_flex",
    ) {
        companion object {
            fun from(req: UpdateFlexRolloverSettingsRequest): Input =
                Input(
                    rolloverStartMonth = req.rolloverStartMonth,
                    rolloverStartingBalance = req.rolloverStartingBalance ?: 0.0,
                    rolloverEnabled = req.rolloverEnabled ?: true,
                    budgetSystem = req.budgetSystem ?: "fixed_and_flex",
                )
        }
    }

    override fun variables(input: Input): Map<String, Any?> =
        mapOf(
            "input" to
                mapOf(
                    "rolloverEnabled" to input.rolloverEnabled,
                    "rolloverStartMonth" to input.rolloverStartMonth,
                    "rolloverStartingBalance" to input.rolloverStartingBalance,
                    "budgetSystem" to input.budgetSystem,
                ),
        )

    override fun parseOutput(data: JsonNode): UpdateFlexRolloverSettingsResponseData {
        val p = data.path("updateBudgetSettings").path("budgetRolloverPeriod")
        return UpdateFlexRolloverSettingsResponseData(
            id = p.path("id").asTextOrNull(),
            startMonth = p.path("startMonth").asTextOrNull(),
            startingBalance = p.path("startingBalance").asDoubleOrNull(),
        )
    }
}
