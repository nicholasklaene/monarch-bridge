package com.nicholasklaene.monarchbridge.graphql.operations.budgets

import com.nicholasklaene.monarchbridge.controllers.TestFixtures.jsonNode
import com.nicholasklaene.monarchbridge.generated.model.UpdateBudgetSettingsRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UpdateBudgetSettingsOperationTest {
    @Test
    fun `parses budget system and rollover period`() {
        val out =
            UpdateBudgetSettings.parseOutput(
                jsonNode(
                    """
                    {"updateBudgetSettings": {
                      "budgetSystem": "category", "budgetApplyToFutureMonthsDefault": true,
                      "budgetRolloverPeriod": {"id": "r-1", "startMonth": "2026-01-01"}
                    }}
                    """.trimIndent(),
                ),
            )
        assertThat(out.budgetSystem).isEqualTo("category")
        assertThat(out.budgetApplyToFutureMonthsDefault).isTrue()
        assertThat(out.budgetRolloverPeriodId).isEqualTo("r-1")
        assertThat(out.budgetRolloverPeriodStartMonth).isEqualTo("2026-01-01")
    }

    @Test
    fun `null rollover period yields nulls without crashing`() {
        val out =
            UpdateBudgetSettings.parseOutput(
                jsonNode("""{"updateBudgetSettings": {"budgetSystem": "category", "budgetApplyToFutureMonthsDefault": false}}"""),
            )
        assertThat(out.budgetRolloverPeriodId).isNull()
        assertThat(out.budgetRolloverPeriodStartMonth).isNull()
    }

    @Test
    fun `Input from request only forwards non-null fields`() {
        val vars =
            UpdateBudgetSettings.variables(
                UpdateBudgetSettings.Input.from(
                    UpdateBudgetSettingsRequest(budgetSystem = "category", budgetApplyToFutureMonthsDefault = null),
                ),
            )

        @Suppress("UNCHECKED_CAST")
        val inputMap = vars["input"] as Map<String, Any?>
        assertThat(inputMap).containsEntry("budgetSystem", "category")
        assertThat(inputMap).doesNotContainKey("budgetApplyToFutureMonthsDefault")
    }

    @Test
    fun `operation name matches the bundle`() {
        assertThat(UpdateBudgetSettings.operationName).isEqualTo("Common_UpdateBudgetSettings")
    }
}
