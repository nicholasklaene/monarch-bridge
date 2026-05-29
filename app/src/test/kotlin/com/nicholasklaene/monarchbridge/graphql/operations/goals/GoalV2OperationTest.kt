package com.nicholasklaene.monarchbridge.graphql.operations.goals

import com.nicholasklaene.monarchbridge.controllers.TestFixtures.jsonNode
import com.nicholasklaene.monarchbridge.generated.model.LinkTransactionToGoalRequest
import com.nicholasklaene.monarchbridge.generated.model.SpendFromGoalRequest
import com.nicholasklaene.monarchbridge.generated.model.WithdrawFromGoalRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDate

class GoalV2OperationTest {
    @Test
    fun `MarkGoalComplete parses goal id and completedAt`() {
        val out =
            MarkGoalComplete.parseOutput(
                jsonNode("""{"markGoalComplete": {"goal": {"id": "g-1", "completedAt": "2026-05-26T00:00:00Z"}}}"""),
            )
        assertThat(out.id).isEqualTo("g-1")
        assertThat(out.completedAt).isEqualTo("2026-05-26T00:00:00Z")
    }

    @Test
    fun `MarkGoalIncomplete parses null completedAt`() {
        val out =
            MarkGoalIncomplete.parseOutput(
                jsonNode("""{"markGoalIncomplete": {"goal": {"id": "g-1", "completedAt": null}}}"""),
            )
        assertThat(out.id).isEqualTo("g-1")
        assertThat(out.completedAt).isNull()
    }

    @Test
    fun `MarkGoalComplete wraps id in input map`() {
        val vars = MarkGoalComplete.variables(MarkGoalComplete.Input(id = "g-1"))

        @Suppress("UNCHECKED_CAST")
        val inputMap = vars["input"] as Map<String, Any?>
        assertThat(inputMap).containsEntry("id", "g-1")
    }

    @Test
    fun `DeleteGoalV2 parses success boolean`() {
        val out = DeleteGoalV2.parseOutput(jsonNode("""{"deleteGoalV2": {"success": true}}"""))
        assertThat(out.success).isTrue()
    }

    @Test
    fun `DeleteGoalV2 returns false when missing`() {
        val out = DeleteGoalV2.parseOutput(jsonNode("""{"deleteGoalV2": {}}"""))
        assertThat(out.success).isFalse()
    }

    @Test
    fun `SpendFromGoal extracts goalEvent id`() {
        val out =
            SpendFromGoal.parseOutput(
                jsonNode("""{"spendFromGoal": {"goalEvent": {"id": "e-1"}}}"""),
            )
        assertThat(out.goalEventId).isEqualTo("e-1")
    }

    @Test
    fun `SpendFromGoal Input from request and variables only forward non-null`() {
        val input =
            SpendFromGoal.Input.from(
                "g-1",
                SpendFromGoalRequest(amount = 12.34, date = LocalDate.parse("2026-05-26"), notes = null),
            )
        val vars = SpendFromGoal.variables(input)

        @Suppress("UNCHECKED_CAST")
        val inputMap = vars["input"] as Map<String, Any?>
        assertThat(inputMap).containsEntry("goalId", "g-1")
        assertThat(inputMap).containsEntry("amount", 12.34)
        assertThat(inputMap).containsEntry("date", "2026-05-26")
        assertThat(inputMap).doesNotContainKey("notes")
    }

    @Test
    fun `WithdrawFromGoal parses goal + account snapshot`() {
        val out =
            WithdrawFromGoal.parseOutput(
                jsonNode(
                    """
                    {"createSavingsGoalWithdrawal": {"goalEvent": {
                      "id": "e-1",
                      "goal": {"id": "g-1", "currentBalance": 500.0, "progress": 0.5, "status": "in_progress"},
                      "account": {"id": "a-1", "availableBalanceForGoalsUnmemoized": 1000.0, "includeInGoalContributions": true}
                    }}}
                    """.trimIndent(),
                ),
            )
        assertThat(out.goalEventId).isEqualTo("e-1")
        assertThat(out.goalId).isEqualTo("g-1")
        assertThat(out.goalCurrentBalance).isEqualTo(500.0)
        assertThat(out.goalProgress).isEqualTo(0.5)
        assertThat(out.goalStatus).isEqualTo("in_progress")
        assertThat(out.accountId).isEqualTo("a-1")
        assertThat(out.accountAvailableBalanceForGoals).isEqualTo(1000.0)
    }

    @Test
    fun `WithdrawFromGoal Input from request and variables`() {
        val input =
            WithdrawFromGoal.Input.from(
                "g-1",
                WithdrawFromGoalRequest(amount = 50.0, accountId = "a-1", date = null),
            )
        val vars = WithdrawFromGoal.variables(input)

        @Suppress("UNCHECKED_CAST")
        val inputMap = vars["input"] as Map<String, Any?>
        assertThat(inputMap).containsEntry("amount", 50.0)
        assertThat(inputMap).containsEntry("accountId", "a-1")
        assertThat(inputMap).doesNotContainKey("date")
    }

    @Test
    fun `LinkTransactionToGoal parses event id and traverses to goal id`() {
        val out =
            LinkTransactionToGoal.parseOutput(
                jsonNode(
                    """
                    {"linkTransactionToGoal": {"goalEvent": {
                      "id": "e-1",
                      "transaction": {"id": "t-1", "savingsGoalEvent": {"id": "se-1", "goal": {"id": "g-1"}}}
                    }}}
                    """.trimIndent(),
                ),
            )
        assertThat(out.goalEventId).isEqualTo("e-1")
        assertThat(out.transactionId).isEqualTo("t-1")
        assertThat(out.goalId).isEqualTo("g-1")
    }

    @Test
    fun `LinkTransactionToGoal Input from request and variables`() {
        val input =
            LinkTransactionToGoal.Input.from("t-1", LinkTransactionToGoalRequest(goalId = "g-1"))
        val vars = LinkTransactionToGoal.variables(input)

        @Suppress("UNCHECKED_CAST")
        val inputMap = vars["input"] as Map<String, Any?>
        assertThat(inputMap).containsEntry("transactionId", "t-1").containsEntry("goalId", "g-1")
    }

    @Test
    fun `UnlinkTransactionGoalRecords parses success`() {
        val out =
            UnlinkTransactionGoalRecords.parseOutput(
                jsonNode("""{"deleteGoalReconciliationRecordsForTransaction": {"success": true}}"""),
            )
        assertThat(out.success).isTrue()
    }

    @Test
    fun `UnlinkTransactionGoalRecords variables passes transactionId at top level`() {
        val vars = UnlinkTransactionGoalRecords.variables(UnlinkTransactionGoalRecords.Input(transactionId = "t-1"))
        assertThat(vars).containsEntry("transactionId", "t-1")
        assertThat(vars).doesNotContainKey("input")
    }

    @Test
    fun `operation names match the bundle`() {
        assertThat(MarkGoalComplete.operationName).isEqualTo("Common_MarkGoalComplete")
        assertThat(MarkGoalIncomplete.operationName).isEqualTo("Common_MarkGoalIncomplete")
        assertThat(DeleteGoalV2.operationName).isEqualTo("Common_DeleteGoalV2")
        assertThat(SpendFromGoal.operationName).isEqualTo("Common_SpendFromGoal")
        assertThat(WithdrawFromGoal.operationName).isEqualTo("Common_WithdrawFromSavingsGoal")
        assertThat(LinkTransactionToGoal.operationName).isEqualTo("Common_LinkTransactionToGoal")
        assertThat(UnlinkTransactionGoalRecords.operationName)
            .isEqualTo("Common_DeleteGoalReconciliationRecordsForTransaction")
    }
}
