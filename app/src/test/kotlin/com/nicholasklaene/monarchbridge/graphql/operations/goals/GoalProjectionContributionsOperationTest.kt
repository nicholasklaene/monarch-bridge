package com.nicholasklaene.monarchbridge.graphql.operations.goals

import com.nicholasklaene.monarchbridge.controllers.TestFixtures.jsonNode
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDate

/**
 * parseOutput + variables coverage for the R6 goal-history endpoints:
 * - GetGoalContributionHistory: contributions ledger
 * - GetGoalProjection: forward balance projection
 *
 * Both operations live under `graphql.operations.goals/`. They mirror the
 * existing GoalOperationTest style: build a typed input via `Input(...)`,
 * parse a JSON fixture via `TestFixtures.jsonNode(...)`, then assert on
 * the resulting model.
 */
class GoalProjectionContributionsOperationTest {
    // -- GetGoalContributionHistory --------------------------------------

    @Test
    fun `GetGoalContributionHistory parses contributions list`() {
        val data =
            jsonNode(
                """
                {
                  "savingsGoalContributions": {
                    "contributions": [
                      {"id": "k-1", "date": "2026-04-15", "amount": 250.0, "accountId": "a-1", "notes": "April"},
                      {"id": "k-2", "date": "2026-05-15", "amount": 250.0, "accountId": "a-1", "notes": null}
                    ]
                  }
                }
                """.trimIndent(),
            )
        val out = GetGoalContributionHistory.parseOutput(data)
        assertThat(out.contributions).hasSize(2)
        assertThat(out.contributions[0].id).isEqualTo("k-1")
        assertThat(out.contributions[0].date).isEqualTo("2026-04-15")
        assertThat(out.contributions[0].amount).isEqualTo(250.0)
        assertThat(out.contributions[0].accountId).isEqualTo("a-1")
        assertThat(out.contributions[0].notes).isEqualTo("April")
        assertThat(out.contributions[1].notes).isNull()
    }

    @Test
    fun `GetGoalContributionHistory tolerates empty payload`() {
        val out = GetGoalContributionHistory.parseOutput(jsonNode("""{}"""))
        assertThat(out.contributions).isEmpty()
    }

    @Test
    fun `GetGoalContributionHistory variables map goalId to id`() {
        val vars = GetGoalContributionHistory.variables(GetGoalContributionHistory.Input(goalId = "g-1"))
        assertThat(vars).containsEntry("id", "g-1")
    }

    @Test
    fun `GetGoalContributionHistory operation name matches the bundle`() {
        assertThat(GetGoalContributionHistory.operationName).isEqualTo("Web_GetGoalContributionHistory")
    }

    // -- GetGoalProjection ----------------------------------------------

    @Test
    fun `GetGoalProjection parses series and headline fields`() {
        val data =
            jsonNode(
                """
                {
                  "savingsGoalProjection": {
                    "projectedCompletionDate": "2027-01-15",
                    "monthsToTarget": 8,
                    "series": [
                      {"date": "2026-06-01", "projectedBalance": 1500.0},
                      {"date": "2026-07-01", "projectedBalance": 1750.0}
                    ]
                  }
                }
                """.trimIndent(),
            )
        val out = GetGoalProjection.parseOutput(data)
        assertThat(out.projection.projectedCompletionDate).isEqualTo("2027-01-15")
        assertThat(out.projection.monthsToTarget).isEqualTo(8)
        assertThat(out.projection.series).hasSize(2)
        assertThat(out.projection.series[0].date).isEqualTo(LocalDate.parse("2026-06-01"))
        assertThat(out.projection.series[0].projectedBalance).isEqualTo(1500.0)
        assertThat(out.projection.series[1].projectedBalance).isEqualTo(1750.0)
    }

    @Test
    fun `GetGoalProjection tolerates missing nested fields`() {
        val out = GetGoalProjection.parseOutput(jsonNode("""{"savingsGoalProjection": {}}"""))
        assertThat(out.projection.projectedCompletionDate).isNull()
        assertThat(out.projection.monthsToTarget).isNull()
        assertThat(out.projection.series).isEmpty()
    }

    @Test
    fun `GetGoalProjection variables map goalId to id`() {
        val vars = GetGoalProjection.variables(GetGoalProjection.Input(goalId = "g-9"))
        assertThat(vars).containsEntry("id", "g-9")
    }

    @Test
    fun `GetGoalProjection operation name matches the bundle`() {
        assertThat(GetGoalProjection.operationName).isEqualTo("Web_GetGoalProjection")
    }
}
