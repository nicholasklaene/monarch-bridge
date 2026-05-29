package com.nicholasklaene.monarchbridge.graphql.operations.goals

import com.nicholasklaene.monarchbridge.controllers.TestFixtures.jsonNode
import com.nicholasklaene.monarchbridge.generated.model.ContributeToGoalRequest
import com.nicholasklaene.monarchbridge.generated.model.CreateGoalRequest
import com.nicholasklaene.monarchbridge.generated.model.SetGoalBudgetAmountRequest
import com.nicholasklaene.monarchbridge.generated.model.UpdateGoalRequest
import com.nicholasklaene.monarchbridge.generated.model.UpdateGoalsPrioritiesRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GoalOperationTest {
    // -- GetGoals ----------------------------------------------------------

    @Test
    fun `GetGoals parses every Goal field`() {
        val data =
            jsonNode(
                """
                {
                  "savingsGoals": [
                    {
                      "id": "g-1",
                      "name": "Emergency Fund",
                      "type": "savings",
                      "status": "active",
                      "progress": 0.75,
                      "currentBalance": 7500.0,
                      "targetAmount": 10000.0,
                      "targetDate": "2026-12-31",
                      "archivedAt": null,
                      "createdAt": "2026-01-01T00:00:00Z",
                      "priority": 0,
                      "isSinkingFund": false,
                      "plannedMonthlyContribution": 500.0,
                      "estimatedMonthsUntilCompletion": 5,
                      "forecastedCompletionDate": "2026-10-31",
                      "imageStorageProvider": "monarch",
                      "imageStorageProviderId": "img-1"
                    },
                    {
                      "id": "g-2",
                      "name": "Vacation",
                      "type": "savings",
                      "status": "archived",
                      "currentBalance": 2000.0
                    }
                  ]
                }
                """.trimIndent(),
            )
        val out = GetGoals.parseOutput(data)
        assertThat(out.goals).hasSize(2)
        val g0 = out.goals[0]
        assertThat(g0.id).isEqualTo("g-1")
        assertThat(g0.name).isEqualTo("Emergency Fund")
        assertThat(g0.type).isEqualTo("savings")
        assertThat(g0.status).isEqualTo("active")
        assertThat(g0.progress).isEqualTo(0.75)
        assertThat(g0.currentBalance).isEqualTo(7500.0)
        assertThat(g0.targetAmount).isEqualTo(10000.0)
        assertThat(g0.targetDate).isEqualTo("2026-12-31")
        assertThat(g0.archivedAt).isNull()
        assertThat(g0.createdAt).isEqualTo("2026-01-01T00:00:00Z")
        assertThat(g0.priority).isEqualTo(0)
        assertThat(g0.isSinkingFund).isFalse()
        assertThat(g0.plannedMonthlyContribution).isEqualTo(500.0)
        assertThat(g0.estimatedMonthsUntilCompletion).isEqualTo(5)
        assertThat(g0.forecastedCompletionDate).isEqualTo("2026-10-31")
        assertThat(g0.imageStorageProvider).isEqualTo("monarch")
        assertThat(g0.imageStorageProviderId).isEqualTo("img-1")

        val g1 = out.goals[1]
        assertThat(g1.id).isEqualTo("g-2")
        assertThat(g1.status).isEqualTo("archived")
        assertThat(g1.targetAmount).isNull()
        assertThat(g1.priority).isNull()
    }

    @Test
    fun `GetGoals returns empty list when savingsGoals missing or empty`() {
        val empty = GetGoals.parseOutput(jsonNode("""{"savingsGoals": []}"""))
        assertThat(empty.goals).isEmpty()
    }

    @Test
    fun `GetGoals variables emit empty map`() {
        assertThat(GetGoals.variables(Unit)).isEmpty()
    }

    // -- GetGoal -----------------------------------------------------------

    @Test
    fun `GetGoal parses single goal from savingsGoal root`() {
        val data =
            jsonNode(
                """
                {
                  "savingsGoal": {
                    "id": "g-1",
                    "name": "Down Payment",
                    "type": "savings",
                    "status": "active",
                    "currentBalance": 30000.0,
                    "targetAmount": 60000.0,
                    "priority": 1,
                    "isSinkingFund": true
                  }
                }
                """.trimIndent(),
            )
        val out = GetGoal.parseOutput(data)
        assertThat(out.goal.id).isEqualTo("g-1")
        assertThat(out.goal.name).isEqualTo("Down Payment")
        assertThat(out.goal.currentBalance).isEqualTo(30000.0)
        assertThat(out.goal.targetAmount).isEqualTo(60000.0)
        assertThat(out.goal.isSinkingFund).isTrue()
    }

    @Test
    fun `GetGoal defaults id and name to empty when savingsGoal missing`() {
        val out = GetGoal.parseOutput(jsonNode("""{}"""))
        assertThat(out.goal.id).isEqualTo("")
        assertThat(out.goal.name).isEqualTo("")
        assertThat(out.goal.currentBalance).isNull()
    }

    @Test
    fun `GetGoal variables pass id verbatim`() {
        val vars = GetGoal.variables(GetGoal.Input(goalId = "g-99"))
        assertThat(vars).containsEntry("id", "g-99")
        assertThat(vars).hasSize(1)
    }

    // -- CreateGoal --------------------------------------------------------

    @Test
    fun `CreateGoal parses first goal from createSavingsGoals savingsGoals array`() {
        val data =
            jsonNode(
                """
                {
                  "createSavingsGoals": {
                    "savingsGoals": [
                      {"id": "g-new", "name": "Roth", "type": "savings", "targetAmount": 7000.0}
                    ]
                  }
                }
                """.trimIndent(),
            )
        val out = CreateGoal.parseOutput(data)
        assertThat(out.goal.id).isEqualTo("g-new")
        assertThat(out.goal.name).isEqualTo("Roth")
        assertThat(out.goal.targetAmount).isEqualTo(7000.0)
    }

    @Test
    fun `CreateGoal Input from copies all fields from request and defaults type to savings`() {
        val withType =
            CreateGoal.Input.from(
                CreateGoalRequest(
                    name = "Vacation",
                    type = "debt",
                    targetAmount = 3000.0,
                    targetDate = "2026-12-01",
                    imageStorageProvider = "monarch",
                    imageStorageProviderId = "img-x",
                ),
            )
        assertThat(withType.name).isEqualTo("Vacation")
        assertThat(withType.type).isEqualTo("debt")
        assertThat(withType.targetAmount).isEqualTo(3000.0)
        assertThat(withType.targetDate).isEqualTo("2026-12-01")
        assertThat(withType.imageStorageProvider).isEqualTo("monarch")
        assertThat(withType.imageStorageProviderId).isEqualTo("img-x")

        val defaulted = CreateGoal.Input.from(CreateGoalRequest(name = "Only Name", type = null))
        assertThat(defaulted.name).isEqualTo("Only Name")
        assertThat(defaulted.type).isEqualTo("savings")
        assertThat(defaulted.targetAmount).isNull()
        assertThat(defaulted.targetDate).isNull()
    }

    @Test
    fun `CreateGoal variables wrap goals list in nested input map and drop null optionals`() {
        val vars =
            CreateGoal.variables(
                CreateGoal.Input(name = "Bare", type = "savings"),
            )

        @Suppress("UNCHECKED_CAST")
        val input = vars["input"] as Map<String, Any?>

        @Suppress("UNCHECKED_CAST")
        val goals = input["goals"] as List<Map<String, Any?>>
        assertThat(goals).hasSize(1)
        val goal = goals[0]
        assertThat(goal["name"]).isEqualTo("Bare")
        assertThat(goal["type"]).isEqualTo("savings")
        assertThat(goal).doesNotContainKeys(
            "targetAmount",
            "targetDate",
            "imageStorageProvider",
            "imageStorageProviderId",
        )
    }

    @Test
    fun `CreateGoal variables emit every optional field when set`() {
        val vars =
            CreateGoal.variables(
                CreateGoal.Input(
                    name = "Full",
                    type = "savings",
                    targetAmount = 5000.0,
                    targetDate = "2026-08-01",
                    imageStorageProvider = "monarch",
                    imageStorageProviderId = "img-9",
                ),
            )

        @Suppress("UNCHECKED_CAST")
        val input = vars["input"] as Map<String, Any?>

        @Suppress("UNCHECKED_CAST")
        val goal = (input["goals"] as List<Map<String, Any?>>)[0]
        assertThat(goal["targetAmount"]).isEqualTo(5000.0)
        assertThat(goal["targetDate"]).isEqualTo("2026-08-01")
        assertThat(goal["imageStorageProvider"]).isEqualTo("monarch")
        assertThat(goal["imageStorageProviderId"]).isEqualTo("img-9")
    }

    // -- UpdateGoal --------------------------------------------------------

    @Test
    fun `UpdateGoal parses every selected field from updateSavingsGoal savingsGoal`() {
        val data =
            jsonNode(
                """
                {
                  "updateSavingsGoal": {
                    "savingsGoal": {
                      "id": "g-1",
                      "name": "Renamed Goal",
                      "targetAmount": 12000.0,
                      "targetDate": "2027-01-01",
                      "priority": 2,
                      "status": "active",
                      "progress": 0.6,
                      "forecastedCompletionDate": "2026-11-30",
                      "imageStorageProvider": "monarch",
                      "imageStorageProviderId": "img-22"
                    },
                    "errors": null
                  }
                }
                """.trimIndent(),
            )
        val out = UpdateGoal.parseOutput(data)
        assertThat(out.goal.id).isEqualTo("g-1")
        assertThat(out.goal.name).isEqualTo("Renamed Goal")
        assertThat(out.goal.targetAmount).isEqualTo(12000.0)
        assertThat(out.goal.targetDate).isEqualTo("2027-01-01")
        assertThat(out.goal.priority).isEqualTo(2)
        assertThat(out.goal.status).isEqualTo("active")
        assertThat(out.goal.progress).isEqualTo(0.6)
        assertThat(out.goal.forecastedCompletionDate).isEqualTo("2026-11-30")
        assertThat(out.goal.imageStorageProvider).isEqualTo("monarch")
        assertThat(out.goal.imageStorageProviderId).isEqualTo("img-22")
    }

    @Test
    fun `UpdateGoal defaults id and name to empty when savingsGoal absent`() {
        val out = UpdateGoal.parseOutput(jsonNode("""{"updateSavingsGoal": {}}"""))
        assertThat(out.goal.id).isEqualTo("")
        assertThat(out.goal.name).isEqualTo("")
        assertThat(out.goal.targetAmount).isNull()
    }

    @Test
    fun `UpdateGoal Input from injects goalId and copies request fields`() {
        val req =
            UpdateGoalRequest(
                name = "Renamed",
                targetAmount = 9000.0,
                priority = 1,
                isSinkingFund = true,
            )
        val input = UpdateGoal.Input.from("g-1", req)
        assertThat(input.goalId).isEqualTo("g-1")
        assertThat(input.name).isEqualTo("Renamed")
        assertThat(input.targetAmount).isEqualTo(9000.0)
        assertThat(input.priority).isEqualTo(1)
        assertThat(input.isSinkingFund).isTrue()
        assertThat(input.targetDate).isNull()
    }

    @Test
    fun `UpdateGoal variables always carry id and only the patched fields`() {
        val idOnly = UpdateGoal.variables(UpdateGoal.Input(goalId = "g-1"))

        @Suppress("UNCHECKED_CAST")
        val idOnlyInput = idOnly["input"] as Map<String, Any?>
        assertThat(idOnlyInput).containsEntry("id", "g-1")
        assertThat(idOnlyInput).doesNotContainKeys(
            "name",
            "targetAmount",
            "targetDate",
            "priority",
            "isSinkingFund",
            "imageStorageProvider",
            "imageStorageProviderId",
        )

        val full =
            UpdateGoal.variables(
                UpdateGoal.Input(
                    goalId = "g-2",
                    name = "Renamed",
                    targetAmount = 1234.5,
                    targetDate = "2026-12-01",
                    priority = 3,
                    isSinkingFund = false,
                    imageStorageProvider = "monarch",
                    imageStorageProviderId = "img-1",
                ),
            )

        @Suppress("UNCHECKED_CAST")
        val fullInput = full["input"] as Map<String, Any?>
        assertThat(fullInput["id"]).isEqualTo("g-2")
        assertThat(fullInput["name"]).isEqualTo("Renamed")
        assertThat(fullInput["targetAmount"]).isEqualTo(1234.5)
        assertThat(fullInput["targetDate"]).isEqualTo("2026-12-01")
        assertThat(fullInput["priority"]).isEqualTo(3)
        assertThat(fullInput["isSinkingFund"]).isEqualTo(false)
        assertThat(fullInput["imageStorageProvider"]).isEqualTo("monarch")
        assertThat(fullInput["imageStorageProviderId"]).isEqualTo("img-1")
    }

    // -- ArchiveGoal -------------------------------------------------------

    @Test
    fun `ArchiveGoal parses id, archivedAt, status from archiveSavingsGoal savingsGoal`() {
        val data =
            jsonNode(
                """
                {
                  "archiveSavingsGoal": {
                    "savingsGoal": {
                      "id": "g-1",
                      "name": "Old Goal",
                      "archivedAt": "2026-05-25T12:00:00Z",
                      "status": "archived"
                    }
                  }
                }
                """.trimIndent(),
            )
        val out = ArchiveGoal.parseOutput(data)
        assertThat(out.goal.id).isEqualTo("g-1")
        assertThat(out.goal.name).isEqualTo("Old Goal")
        assertThat(out.goal.archivedAt).isEqualTo("2026-05-25T12:00:00Z")
        assertThat(out.goal.status).isEqualTo("archived")
    }

    @Test
    fun `ArchiveGoal defaults id and name to empty when subtree missing`() {
        val out = ArchiveGoal.parseOutput(jsonNode("""{"archiveSavingsGoal": {}}"""))
        assertThat(out.goal.id).isEqualTo("")
        assertThat(out.goal.name).isEqualTo("")
        assertThat(out.goal.archivedAt).isNull()
    }

    @Test
    fun `ArchiveGoal variables wrap id inside input map`() {
        val vars = ArchiveGoal.variables(ArchiveGoal.Input(goalId = "g-7"))

        @Suppress("UNCHECKED_CAST")
        val input = vars["input"] as Map<String, Any?>
        assertThat(input).containsEntry("id", "g-7")
    }

    // -- UnarchiveGoal -----------------------------------------------------

    @Test
    fun `UnarchiveGoal parses id, archivedAt-null, status from unarchiveSavingsGoal savingsGoal`() {
        val data =
            jsonNode(
                """
                {
                  "unarchiveSavingsGoal": {
                    "savingsGoal": {
                      "id": "g-1",
                      "name": "Restored Goal",
                      "archivedAt": null,
                      "status": "active"
                    }
                  }
                }
                """.trimIndent(),
            )
        val out = UnarchiveGoal.parseOutput(data)
        assertThat(out.goal.id).isEqualTo("g-1")
        assertThat(out.goal.name).isEqualTo("Restored Goal")
        assertThat(out.goal.archivedAt).isNull()
        assertThat(out.goal.status).isEqualTo("active")
    }

    @Test
    fun `UnarchiveGoal defaults id and name to empty when subtree missing`() {
        val out = UnarchiveGoal.parseOutput(jsonNode("""{}"""))
        assertThat(out.goal.id).isEqualTo("")
        assertThat(out.goal.name).isEqualTo("")
    }

    @Test
    fun `UnarchiveGoal variables wrap id inside input map`() {
        val vars = UnarchiveGoal.variables(UnarchiveGoal.Input(goalId = "g-9"))

        @Suppress("UNCHECKED_CAST")
        val input = vars["input"] as Map<String, Any?>
        assertThat(input).containsEntry("id", "g-9")
    }

    // -- DeleteGoal --------------------------------------------------------

    @Test
    fun `DeleteGoal surfaces deleteSavingsGoal success as deleted true`() {
        val data = jsonNode("""{"deleteSavingsGoal": {"success": true, "errors": null}}""")
        val out = DeleteGoal.parseOutput(data)
        assertThat(out.deleted).isTrue()
    }

    @Test
    fun `DeleteGoal defaults to deleted false when success absent or explicit false`() {
        val explicitFalse = DeleteGoal.parseOutput(jsonNode("""{"deleteSavingsGoal": {"success": false}}"""))
        assertThat(explicitFalse.deleted).isFalse()

        val missingFlag = DeleteGoal.parseOutput(jsonNode("""{"deleteSavingsGoal": {}}"""))
        assertThat(missingFlag.deleted).isFalse()

        val missingMutation = DeleteGoal.parseOutput(jsonNode("""{}"""))
        assertThat(missingMutation.deleted).isFalse()
    }

    @Test
    fun `DeleteGoal variables wrap id inside input map`() {
        val vars = DeleteGoal.variables(DeleteGoal.Input(goalId = "g-1"))

        @Suppress("UNCHECKED_CAST")
        val input = vars["input"] as Map<String, Any?>
        assertThat(input).containsEntry("id", "g-1")
    }

    // -- GetGoalEvents -----------------------------------------------------

    @Test
    fun `GetGoalEvents parses every GoalEvent field including account and transaction refs`() {
        val data =
            jsonNode(
                """
                {
                  "savingsGoal": {
                    "id": "g-1",
                    "name": "Emergency Fund",
                    "goalEvents": [
                      {
                        "id": "ev-1",
                        "date": "2026-05-15",
                        "amount": 500.0,
                        "type": "contribution",
                        "createdAt": "2026-05-15T12:00:00Z",
                        "canDelete": true,
                        "includeInBudget": true,
                        "notes": "May contribution",
                        "account": {"id": "a-1", "displayName": "Checking"},
                        "transaction": {"id": "t-1", "amount": -500.0, "date": "2026-05-15"}
                      },
                      {
                        "id": "ev-2",
                        "date": "2026-04-15",
                        "amount": 500.0,
                        "type": "contribution",
                        "canDelete": false,
                        "includeInBudget": false,
                        "notes": null,
                        "account": null,
                        "transaction": null
                      }
                    ]
                  }
                }
                """.trimIndent(),
            )
        val out = GetGoalEvents.parseOutput(data)
        assertThat(out.events).hasSize(2)
        val e0 = out.events[0]
        assertThat(e0.id).isEqualTo("ev-1")
        assertThat(e0.date).isEqualTo("2026-05-15")
        assertThat(e0.amount).isEqualTo(500.0)
        assertThat(e0.type).isEqualTo("contribution")
        assertThat(e0.createdAt).isEqualTo("2026-05-15T12:00:00Z")
        assertThat(e0.canDelete).isTrue()
        assertThat(e0.includeInBudget).isTrue()
        assertThat(e0.notes).isEqualTo("May contribution")
        assertThat(e0.account?.id).isEqualTo("a-1")
        assertThat(e0.account?.displayName).isEqualTo("Checking")
        assertThat(e0.transaction?.id).isEqualTo("t-1")
        assertThat(e0.transaction?.amount).isEqualTo(-500.0)
        assertThat(e0.transaction?.date).isEqualTo("2026-05-15")

        val e1 = out.events[1]
        assertThat(e1.id).isEqualTo("ev-2")
        assertThat(e1.canDelete).isFalse()
        assertThat(e1.includeInBudget).isFalse()
        assertThat(e1.notes).isNull()
        assertThat(e1.account).isNull()
        assertThat(e1.transaction).isNull()
    }

    @Test
    fun `GetGoalEvents returns empty events when goalEvents missing or empty`() {
        val emptyArr = GetGoalEvents.parseOutput(jsonNode("""{"savingsGoal": {"goalEvents": []}}"""))
        assertThat(emptyArr.events).isEmpty()

        val missingArr = GetGoalEvents.parseOutput(jsonNode("""{"savingsGoal": {}}"""))
        assertThat(missingArr.events).isEmpty()

        val missingRoot = GetGoalEvents.parseOutput(jsonNode("""{}"""))
        assertThat(missingRoot.events).isEmpty()
    }

    @Test
    fun `GetGoalEvents variables pass goal id as id`() {
        val vars = GetGoalEvents.variables(GetGoalEvents.Input(goalId = "g-42"))
        assertThat(vars).containsEntry("id", "g-42")
        assertThat(vars).hasSize(1)
    }

    // -- GetGoalsCurrentMonthTotals ---------------------------------------

    @Test
    fun `GetGoalsCurrentMonthTotals sums monthlyBudgetAmounts totalPlannedAmount per goal`() {
        val data =
            jsonNode(
                """
                {
                  "savingsGoals": [
                    {
                      "id": "g-1",
                      "monthlyBudgetAmounts": [
                        {"totalPlannedAmount": 500.0},
                        {"totalPlannedAmount": 500.0}
                      ]
                    },
                    {
                      "id": "g-2",
                      "monthlyBudgetAmounts": [
                        {"totalPlannedAmount": 200.0}
                      ]
                    }
                  ]
                }
                """.trimIndent(),
            )
        val out = GetGoalsCurrentMonthTotals.parseOutput(data)
        assertThat(out.totals).hasSize(2)
        assertThat(out.totals[0].goalId).isEqualTo("g-1")
        assertThat(out.totals[0].totalPlannedAmount).isEqualTo(1000.0)
        assertThat(out.totals[1].goalId).isEqualTo("g-2")
        assertThat(out.totals[1].totalPlannedAmount).isEqualTo(200.0)
    }

    @Test
    fun `GetGoalsCurrentMonthTotals returns goal with zero sum when monthlyBudgetAmounts empty`() {
        val data =
            jsonNode(
                """
                {
                  "savingsGoals": [
                    {"id": "g-1", "monthlyBudgetAmounts": []}
                  ]
                }
                """.trimIndent(),
            )
        val out = GetGoalsCurrentMonthTotals.parseOutput(data)
        assertThat(out.totals).hasSize(1)
        assertThat(out.totals[0].goalId).isEqualTo("g-1")
        assertThat(out.totals[0].totalPlannedAmount).isEqualTo(0.0)
    }

    @Test
    fun `GetGoalsCurrentMonthTotals returns empty totals when savingsGoals missing`() {
        val out = GetGoalsCurrentMonthTotals.parseOutput(jsonNode("""{}"""))
        assertThat(out.totals).isEmpty()
    }

    @Test
    fun `GetGoalsCurrentMonthTotals variables pass startMonth and endMonth`() {
        val vars =
            GetGoalsCurrentMonthTotals.variables(
                GetGoalsCurrentMonthTotals.Input(startMonth = "2026-05-01", endMonth = "2026-05-01"),
            )
        assertThat(vars).containsEntry("startMonth", "2026-05-01")
        assertThat(vars).containsEntry("endMonth", "2026-05-01")
    }

    // -- SetGoalBudgetAmount ----------------------------------------------

    @Test
    fun `SetGoalBudgetAmount surfaces success true`() {
        val data = jsonNode("""{"setSavingsGoalBudgetAmount": {"success": true, "errors": null}}""")
        val out = SetGoalBudgetAmount.parseOutput(data)
        assertThat(out.success).isTrue()
    }

    @Test
    fun `SetGoalBudgetAmount defaults to success false when missing or explicit false`() {
        val explicitFalse =
            SetGoalBudgetAmount.parseOutput(jsonNode("""{"setSavingsGoalBudgetAmount": {"success": false}}"""))
        assertThat(explicitFalse.success).isFalse()

        val missingFlag = SetGoalBudgetAmount.parseOutput(jsonNode("""{"setSavingsGoalBudgetAmount": {}}"""))
        assertThat(missingFlag.success).isFalse()

        val missingMutation = SetGoalBudgetAmount.parseOutput(jsonNode("""{}"""))
        assertThat(missingMutation.success).isFalse()
    }

    @Test
    fun `SetGoalBudgetAmount variables wrap savingsGoalId, month, amount, applyToFuture, accountId in input`() {
        val withAccount =
            SetGoalBudgetAmount.variables(
                SetGoalBudgetAmount.Input(
                    goalId = "g-1",
                    amount = 500.0,
                    month = "2026-06-01",
                    applyToFuture = true,
                    accountId = "a-1",
                ),
            )

        @Suppress("UNCHECKED_CAST")
        val input = withAccount["input"] as Map<String, Any?>
        assertThat(input["savingsGoalId"]).isEqualTo("g-1")
        assertThat(input["month"]).isEqualTo("2026-06-01")
        assertThat(input["amount"]).isEqualTo(500.0)
        assertThat(input["applyToFuture"]).isEqualTo(true)
        assertThat(input["accountId"]).isEqualTo("a-1")

        // Null accountId is forwarded explicitly (household-level).
        val noAccount =
            SetGoalBudgetAmount.variables(
                SetGoalBudgetAmount.Input(goalId = "g-2", amount = 200.0, month = "2026-05-01"),
            )

        @Suppress("UNCHECKED_CAST")
        val noAcctInput = noAccount["input"] as Map<String, Any?>
        assertThat(noAcctInput["accountId"]).isNull()
        assertThat(noAcctInput["applyToFuture"]).isEqualTo(false)
    }

    @Test
    fun `SetGoalBudgetAmount Input from injects goalId and defaults applyToFuture to false when null`() {
        val req =
            SetGoalBudgetAmountRequest(amount = 250.0, month = "2026-05-01", applyToFuture = null, accountId = "a-1")
        val input = SetGoalBudgetAmount.Input.from("g-1", req)
        assertThat(input.goalId).isEqualTo("g-1")
        assertThat(input.amount).isEqualTo(250.0)
        assertThat(input.month).isEqualTo("2026-05-01")
        assertThat(input.applyToFuture).isFalse()
        assertThat(input.accountId).isEqualTo("a-1")
    }

    // -- UpdateGoalsPriorities --------------------------------------------

    @Test
    fun `UpdateGoalsPriorities parses goals list of GoalPriority entries`() {
        val data =
            jsonNode(
                """
                {
                  "updateSavingsGoalsPriorities": {
                    "goals": [
                      {"id": "g-1", "priority": 0},
                      {"id": "g-2", "priority": 1},
                      {"id": "g-3", "priority": 2}
                    ],
                    "errors": null
                  }
                }
                """.trimIndent(),
            )
        val out = UpdateGoalsPriorities.parseOutput(data)
        assertThat(out.goals).hasSize(3)
        assertThat(out.goals[0].goalId).isEqualTo("g-1")
        assertThat(out.goals[0].priority).isEqualTo(0)
        assertThat(out.goals[2].goalId).isEqualTo("g-3")
        assertThat(out.goals[2].priority).isEqualTo(2)
    }

    @Test
    fun `UpdateGoalsPriorities returns empty goals when payload missing`() {
        val missingArr =
            UpdateGoalsPriorities.parseOutput(jsonNode("""{"updateSavingsGoalsPriorities": {}}"""))
        assertThat(missingArr.goals).isEmpty()

        val missingMutation = UpdateGoalsPriorities.parseOutput(jsonNode("""{}"""))
        assertThat(missingMutation.goals).isEmpty()
    }

    @Test
    fun `UpdateGoalsPriorities variables expand orderedGoalIds into id+priority pairs starting at 0`() {
        val vars =
            UpdateGoalsPriorities.variables(
                UpdateGoalsPriorities.Input(orderedGoalIds = listOf("g-3", "g-1", "g-2")),
            )

        @Suppress("UNCHECKED_CAST")
        val input = vars["input"] as Map<String, Any?>

        @Suppress("UNCHECKED_CAST")
        val goals = input["goals"] as List<Map<String, Any?>>
        assertThat(goals).hasSize(3)
        assertThat(goals[0]["id"]).isEqualTo("g-3")
        assertThat(goals[0]["priority"]).isEqualTo(0)
        assertThat(goals[1]["id"]).isEqualTo("g-1")
        assertThat(goals[1]["priority"]).isEqualTo(1)
        assertThat(goals[2]["id"]).isEqualTo("g-2")
        assertThat(goals[2]["priority"]).isEqualTo(2)
    }

    @Test
    fun `UpdateGoalsPriorities Input from copies goalIds list verbatim`() {
        val req = UpdateGoalsPrioritiesRequest(goalIds = listOf("g-a", "g-b"))
        val input = UpdateGoalsPriorities.Input.from(req)
        assertThat(input.orderedGoalIds).containsExactly("g-a", "g-b")
    }

    // -- ContributeToGoal --------------------------------------------------

    @Test
    fun `ContributeToGoal parses userNotice and goalEvent details`() {
        val data =
            jsonNode(
                """
                {
                  "createSavingsGoalContribution": {
                    "userNotice": "Saved $500",
                    "goalEvent": {
                      "id": "ev-1",
                      "goal": {
                        "id": "g-1",
                        "currentBalance": 8000.0,
                        "progress": 0.8,
                        "status": "active"
                      },
                      "account": {
                        "id": "a-1",
                        "availableBalanceForGoalsUnmemoized": 1200.5,
                        "includeInGoalContributions": true
                      }
                    }
                  }
                }
                """.trimIndent(),
            )
        val out = ContributeToGoal.parseOutput(data)
        assertThat(out.userNotice).isEqualTo("Saved $500")
        assertThat(out.goalEvent?.id).isEqualTo("ev-1")
        assertThat(out.goalEvent?.goal?.id).isEqualTo("g-1")
        assertThat(out.goalEvent?.goal?.currentBalance).isEqualTo(8000.0)
        assertThat(out.goalEvent?.goal?.progress).isEqualTo(0.8)
        assertThat(out.goalEvent?.goal?.status).isEqualTo("active")
        assertThat(out.goalEvent?.account?.id).isEqualTo("a-1")
        assertThat(out.goalEvent?.account?.availableBalanceForGoalsUnmemoized).isEqualTo(1200.5)
        assertThat(out.goalEvent?.account?.includeInGoalContributions).isTrue()
    }

    @Test
    fun `ContributeToGoal tolerates missing goal and account subtrees on event`() {
        val data =
            jsonNode(
                """
                {
                  "createSavingsGoalContribution": {
                    "userNotice": null,
                    "goalEvent": {"id": "ev-1"}
                  }
                }
                """.trimIndent(),
            )
        val out = ContributeToGoal.parseOutput(data)
        assertThat(out.userNotice).isNull()
        assertThat(out.goalEvent?.id).isEqualTo("ev-1")
        assertThat(out.goalEvent?.goal).isNull()
        assertThat(out.goalEvent?.account).isNull()
    }

    @Test
    fun `ContributeToGoal Input from injects goalId and defaults date to today when null`() {
        val req = ContributeToGoalRequest(accountId = "a-1", amount = 500.0, date = "2026-05-15")
        val input = ContributeToGoal.Input.from("g-1", req)
        assertThat(input.goalId).isEqualTo("g-1")
        assertThat(input.accountId).isEqualTo("a-1")
        assertThat(input.amount).isEqualTo(500.0)
        assertThat(input.date).isEqualTo("2026-05-15")

        val defaultDate = ContributeToGoal.Input.from("g-2", ContributeToGoalRequest(accountId = "a-9", amount = 50.0))
        assertThat(defaultDate.date).isNotBlank()
        assertThat(defaultDate.date).matches(Regex("\\d{4}-\\d{2}-\\d{2}").toPattern())
    }

    @Test
    fun `ContributeToGoal variables wrap goalId, accountId, amount, date in input`() {
        val vars =
            ContributeToGoal.variables(
                ContributeToGoal.Input(goalId = "g-1", accountId = "a-1", amount = 500.0, date = "2026-05-25"),
            )

        @Suppress("UNCHECKED_CAST")
        val input = vars["input"] as Map<String, Any?>
        assertThat(input["goalId"]).isEqualTo("g-1")
        assertThat(input["accountId"]).isEqualTo("a-1")
        assertThat(input["amount"]).isEqualTo(500.0)
        assertThat(input["date"]).isEqualTo("2026-05-25")
    }
}
