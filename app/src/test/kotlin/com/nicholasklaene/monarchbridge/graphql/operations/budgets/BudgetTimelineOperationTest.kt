package com.nicholasklaene.monarchbridge.graphql.operations.budgets

import com.nicholasklaene.monarchbridge.controllers.TestFixtures.jsonNode
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDate

class BudgetTimelineOperationTest {
    @Test
    fun `GetBudgetTimeline parses each month with both variance metrics`() {
        val data =
            jsonNode(
                """
                {
                  "budgetTimeline": {
                    "months":[
                      {"month":"2026-01","totalBudget":4000.0,"totalActual":3850.0,
                       "varianceAmount":150.0,"variancePercent":0.0375},
                      {"month":"2026-02","totalBudget":4000.0,"totalActual":4200.0,
                       "varianceAmount":-200.0,"variancePercent":-0.05},
                      {"month":"2026-03","totalBudget":4000.0,"totalActual":4000.0,
                       "varianceAmount":0.0,"variancePercent":0.0}
                    ]
                  }
                }
                """.trimIndent(),
            )
        val out = GetBudgetTimeline.parseOutput(data)
        assertThat(out.months).hasSize(3)
        // Under-budget month: positive variance.
        assertThat(out.months[0].totalBudget).isEqualTo(4000.0)
        assertThat(out.months[0].totalActual).isEqualTo(3850.0)
        assertThat(out.months[0].varianceAmount).isEqualTo(150.0)
        assertThat(out.months[0].variancePercent).isEqualTo(0.0375)
        // Over-budget month: negative variance.
        assertThat(out.months[1].varianceAmount).isEqualTo(-200.0)
        assertThat(out.months[1].variancePercent).isEqualTo(-0.05)
        // On-budget month: zero variance both axes.
        assertThat(out.months[2].varianceAmount).isZero
        assertThat(out.months[2].variancePercent).isZero
    }

    @Test
    fun `GetBudgetTimeline returns empty months array when payload missing data`() {
        val empty = GetBudgetTimeline.parseOutput(jsonNode("""{"budgetTimeline":{"months":[]}}"""))
        assertThat(empty.months).isEmpty()

        val missing = GetBudgetTimeline.parseOutput(jsonNode("""{}"""))
        assertThat(missing.months).isEmpty()
    }

    @Test
    fun `GetBudgetTimeline variables always include startMonth and only set monthCount when provided`() {
        val withCount =
            GetBudgetTimeline.variables(
                GetBudgetTimeline.Input(startMonth = LocalDate.parse("2026-01-01"), monthCount = 6),
            )
        assertThat(withCount).containsEntry("startMonth", "2026-01-01")
        assertThat(withCount).containsEntry("monthCount", 6)

        val defaultCount =
            GetBudgetTimeline.variables(GetBudgetTimeline.Input(startMonth = LocalDate.parse("2026-06-01")))
        assertThat(defaultCount).containsEntry("startMonth", "2026-06-01")
        // mapOfNotNull drops the null monthCount — controller falls back to Monarch's default.
        assertThat(defaultCount).doesNotContainKey("monthCount")
    }
}
