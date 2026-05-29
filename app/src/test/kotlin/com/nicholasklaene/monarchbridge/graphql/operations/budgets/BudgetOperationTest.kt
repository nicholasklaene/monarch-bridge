package com.nicholasklaene.monarchbridge.graphql.operations.budgets

import com.nicholasklaene.monarchbridge.controllers.TestFixtures.jsonNode
import com.nicholasklaene.monarchbridge.generated.model.SetBudgetAmountRequest
import com.nicholasklaene.monarchbridge.generated.model.UpdateFlexRolloverSettingsRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BudgetOperationTest {
    // -- GetBudgets --------------------------------------------------------

    @Test
    fun `GetBudgets parses budgetData and categoryGroups`() {
        val data =
            jsonNode(
                """
                {
                  "budgetData": {
                    "monthlyAmountsByCategory": [
                      {"category": {"id": "c1"}, "monthlyAmounts": [{"month":"2026-05-01","plannedCashFlowAmount":500.0}]}
                    ]
                  },
                  "categoryGroups": [
                    {"id": "g1", "name": "Food", "order": 1},
                    {"id": "g2", "name": "Transport", "order": 2}
                  ]
                }
                """.trimIndent(),
            )
        val out = GetBudgets.parseOutput(data)
        assertThat(out.budgetData).isNotNull
        assertThat(out.budgetData?.get("monthlyAmountsByCategory")).isInstanceOf(List::class.java)
        assertThat(out.categoryGroups).hasSize(2)
        assertThat(out.categoryGroups[0]["id"]).isEqualTo("g1")
        assertThat(out.categoryGroups[1]["name"]).isEqualTo("Transport")
    }

    @Test
    fun `GetBudgets returns null budgetData when missing`() {
        val data = jsonNode("""{"categoryGroups": []}""")
        val out = GetBudgets.parseOutput(data)
        assertThat(out.budgetData).isNull()
        assertThat(out.categoryGroups).isEmpty()
        assertThat(out.categoryGroups).isInstanceOf(List::class.java)
    }

    @Test
    fun `GetBudgets treats explicit null budgetData as null`() {
        val data = jsonNode("""{"budgetData": null, "categoryGroups": [{"id": "g1"}]}""")
        val out = GetBudgets.parseOutput(data)
        assertThat(out.budgetData).isNull()
        assertThat(out.categoryGroups).hasSize(1)
        assertThat(out.categoryGroups[0]["id"]).isEqualTo("g1")
    }

    // -- SetBudgetAmount ---------------------------------------------------

    @Test
    fun `SetBudgetAmount parses id and budgetAmount from updateOrCreateBudgetItem`() {
        val data =
            jsonNode(
                """
                {
                  "updateOrCreateBudgetItem": {
                    "budgetItem": {"id": "bi-123", "budgetAmount": 250.5}
                  }
                }
                """.trimIndent(),
            )
        val out = SetBudgetAmount.parseOutput(data)
        assertThat(out.id).isEqualTo("bi-123")
        assertThat(out.budgetAmount).isEqualTo(250.5)
    }

    @Test
    fun `SetBudgetAmount returns nulls when budgetItem missing`() {
        val data = jsonNode("""{"updateOrCreateBudgetItem": {}}""")
        val out = SetBudgetAmount.parseOutput(data)
        assertThat(out.id).isNull()
        assertThat(out.budgetAmount).isNull()
    }

    @Test
    fun `SetBudgetAmount returns nulls when entire mutation key missing`() {
        val data = jsonNode("""{}""")
        val out = SetBudgetAmount.parseOutput(data)
        assertThat(out.id).isNull()
        assertThat(out.budgetAmount).isNull()
    }

    // -- ResetBudget -------------------------------------------------------

    @Test
    fun `ResetBudget returns reset true on populated response`() {
        val data = jsonNode("""{"resetBudget": {"errors": null}}""")
        val out = ResetBudget.parseOutput(data)
        assertThat(out.reset).isTrue()
    }

    @Test
    fun `ResetBudget returns reset true on empty data`() {
        val data = jsonNode("""{}""")
        val out = ResetBudget.parseOutput(data)
        assertThat(out.reset).isTrue()
        assertThat(out).isInstanceOf(com.nicholasklaene.monarchbridge.generated.model.ResetBudgetResponseData::class.java)
    }

    // -- UpdateFlexibleBudget ---------------------------------------------

    @Test
    fun `UpdateFlexibleBudget parses id and budgetAmount from updateOrCreateFlexBudgetItem`() {
        val data =
            jsonNode(
                """
                {
                  "updateOrCreateFlexBudgetItem": {
                    "budgetItem": {"id": "flex-9", "budgetAmount": 1234.0}
                  }
                }
                """.trimIndent(),
            )
        val out = UpdateFlexibleBudget.parseOutput(data)
        assertThat(out.id).isEqualTo("flex-9")
        assertThat(out.budgetAmount).isEqualTo(1234.0)
    }

    @Test
    fun `UpdateFlexibleBudget returns nulls when budgetItem missing`() {
        val data = jsonNode("""{"updateOrCreateFlexBudgetItem": {}}""")
        val out = UpdateFlexibleBudget.parseOutput(data)
        assertThat(out.id).isNull()
        assertThat(out.budgetAmount).isNull()
    }

    @Test
    fun `UpdateFlexibleBudget reads from flex path not regular budget path`() {
        // If parser mistakenly read updateOrCreateBudgetItem, this would also return nulls;
        // by populating only the flex path we prove it reads the correct key.
        val data =
            jsonNode(
                """
                {
                  "updateOrCreateBudgetItem": {"budgetItem": {"id": "wrong", "budgetAmount": 0.0}},
                  "updateOrCreateFlexBudgetItem": {"budgetItem": {"id": "right", "budgetAmount": 99.0}}
                }
                """.trimIndent(),
            )
        val out = UpdateFlexibleBudget.parseOutput(data)
        assertThat(out.id).isEqualTo("right")
        assertThat(out.budgetAmount).isEqualTo(99.0)
    }

    // -- UpdateFlexRolloverSettings ---------------------------------------

    @Test
    fun `UpdateFlexRolloverSettings parses rollover period fields`() {
        val data =
            jsonNode(
                """
                {
                  "updateBudgetSettings": {
                    "budgetRolloverPeriod": {
                      "id": "brp-1",
                      "startMonth": "2026-05-01",
                      "startingBalance": 0.0
                    }
                  }
                }
                """.trimIndent(),
            )
        val out = UpdateFlexRolloverSettings.parseOutput(data)
        assertThat(out.id).isEqualTo("brp-1")
        assertThat(out.startMonth).isEqualTo("2026-05-01")
        assertThat(out.startingBalance).isEqualTo(0.0)
    }

    @Test
    fun `UpdateFlexRolloverSettings handles negative startingBalance`() {
        val data =
            jsonNode(
                """
                {
                  "updateBudgetSettings": {
                    "budgetRolloverPeriod": {
                      "id": "brp-2",
                      "startMonth": "2026-04-01",
                      "startingBalance": -125.75
                    }
                  }
                }
                """.trimIndent(),
            )
        val out = UpdateFlexRolloverSettings.parseOutput(data)
        assertThat(out.id).isEqualTo("brp-2")
        assertThat(out.startMonth).isEqualTo("2026-04-01")
        assertThat(out.startingBalance).isEqualTo(-125.75)
    }

    @Test
    fun `UpdateFlexRolloverSettings returns nulls when budgetRolloverPeriod missing`() {
        val data = jsonNode("""{"updateBudgetSettings": {}}""")
        val out = UpdateFlexRolloverSettings.parseOutput(data)
        assertThat(out.id).isNull()
        assertThat(out.startMonth).isNull()
        assertThat(out.startingBalance).isNull()
    }

    // -- SetBudgetAmount variables + Input.from -----------------------------

    @Test
    fun `SetBudgetAmount Input from defaults timeframe and applyToFuture when null`() {
        val populated =
            SetBudgetAmountRequest(
                amount = 500.0,
                startDate = "2026-05-01",
                categoryId = "c-1",
                categoryGroupId = null,
                timeframe = SetBudgetAmountRequest.Timeframe.MONTH,
                applyToFuture = true,
            )
        val in1 = SetBudgetAmount.Input.from(populated)
        assertThat(in1.amount).isEqualTo(500.0)
        assertThat(in1.startDate).isEqualTo("2026-05-01")
        assertThat(in1.categoryId).isEqualTo("c-1")
        assertThat(in1.timeframe).isEqualTo("month")
        assertThat(in1.applyToFuture).isTrue

        val sparse =
            SetBudgetAmountRequest(
                amount = 100.0,
                startDate = "2026-06-01",
                categoryGroupId = "g-1",
                timeframe = null,
                applyToFuture = null,
            )
        val in2 = SetBudgetAmount.Input.from(sparse)
        assertThat(in2.timeframe).isEqualTo("month")
        assertThat(in2.applyToFuture).isFalse
    }

    @Test
    fun `SetBudgetAmount variables emit categoryId when set and skip categoryGroupId`() {
        val withCategory =
            SetBudgetAmount.variables(
                SetBudgetAmount.Input(
                    amount = 200.0,
                    categoryId = "c-1",
                    startDate = "2026-05-01",
                    applyToFuture = true,
                ),
            )

        @Suppress("UNCHECKED_CAST")
        val inner = withCategory["input"] as Map<String, Any?>
        assertThat(inner["amount"]).isEqualTo(200.0)
        assertThat(inner["categoryId"]).isEqualTo("c-1")
        assertThat(inner).doesNotContainKey("categoryGroupId")
        assertThat(inner["startDate"]).isEqualTo("2026-05-01")
        assertThat(inner["timeframe"]).isEqualTo("month")
        assertThat(inner["applyToFuture"]).isEqualTo(true)
    }

    @Test
    fun `SetBudgetAmount variables emit categoryGroupId when set and skip categoryId`() {
        val withGroup =
            SetBudgetAmount.variables(
                SetBudgetAmount.Input(
                    amount = 300.0,
                    categoryGroupId = "g-1",
                    startDate = "2026-05-01",
                ),
            )

        @Suppress("UNCHECKED_CAST")
        val inner = withGroup["input"] as Map<String, Any?>
        assertThat(inner["categoryGroupId"]).isEqualTo("g-1")
        assertThat(inner).doesNotContainKey("categoryId")
    }

    @Test
    fun `SetBudgetAmount Input rejects both-null and both-set`() {
        org.junit.jupiter.api.Assertions
            .assertThrows(IllegalArgumentException::class.java) {
                SetBudgetAmount.Input(amount = 100.0, startDate = "2026-05-01")
            }
        org.junit.jupiter.api.Assertions
            .assertThrows(IllegalArgumentException::class.java) {
                SetBudgetAmount.Input(
                    amount = 100.0,
                    categoryId = "c-1",
                    categoryGroupId = "g-1",
                    startDate = "2026-05-01",
                )
            }
    }

    // -- UpdateFlexRolloverSettings variables + Input.from ------------------

    @Test
    fun `UpdateFlexRolloverSettings Input from defaults all optional fields`() {
        val populated =
            UpdateFlexRolloverSettingsRequest(
                rolloverStartMonth = "2026-05-01",
                rolloverStartingBalance = -50.0,
                rolloverEnabled = false,
                budgetSystem = "envelope",
            )
        val in1 = UpdateFlexRolloverSettings.Input.from(populated)
        assertThat(in1.rolloverStartMonth).isEqualTo("2026-05-01")
        assertThat(in1.rolloverStartingBalance).isEqualTo(-50.0)
        assertThat(in1.rolloverEnabled).isFalse
        assertThat(in1.budgetSystem).isEqualTo("envelope")

        val sparse = UpdateFlexRolloverSettingsRequest(rolloverStartMonth = "2026-05-01")
        val in2 = UpdateFlexRolloverSettings.Input.from(sparse)
        assertThat(in2.rolloverStartingBalance).isEqualTo(0.0)
        assertThat(in2.rolloverEnabled).isTrue
        assertThat(in2.budgetSystem).isEqualTo("fixed_and_flex")
    }

    @Test
    fun `UpdateFlexRolloverSettings variables nest all four fields under input`() {
        val vars =
            UpdateFlexRolloverSettings.variables(
                UpdateFlexRolloverSettings.Input(
                    rolloverStartMonth = "2026-05-01",
                    rolloverStartingBalance = 0.0,
                    rolloverEnabled = true,
                    budgetSystem = "fixed_and_flex",
                ),
            )

        @Suppress("UNCHECKED_CAST")
        val inner = vars["input"] as Map<String, Any?>
        assertThat(inner["rolloverStartMonth"]).isEqualTo("2026-05-01")
        assertThat(inner["rolloverStartingBalance"]).isEqualTo(0.0)
        assertThat(inner["rolloverEnabled"]).isEqualTo(true)
        assertThat(inner["budgetSystem"]).isEqualTo("fixed_and_flex")
    }

    // -- GetBudgetStatus -----------------------------------------------------

    @Test
    fun `GetBudgetStatus parses every flag`() {
        val data =
            jsonNode(
                """
                {
                  "budgetStatus": {
                    "hasBudget": true,
                    "hasTransactions": true,
                    "willCreateBudgetFromEmptyDefaultCategories": false
                  }
                }
                """.trimIndent(),
            )
        val out = GetBudgetStatus.parseOutput(data)
        assertThat(out.status.hasBudget).isTrue
        assertThat(out.status.hasTransactions).isTrue
        assertThat(out.status.willCreateBudgetFromEmptyDefaultCategories).isFalse
    }

    @Test
    fun `GetBudgetStatus defaults to null flags when payload empty`() {
        val out = GetBudgetStatus.parseOutput(jsonNode("""{"budgetStatus": {}}"""))
        assertThat(out.status.hasBudget).isNull()
        assertThat(out.status.hasTransactions).isNull()
        assertThat(out.status.willCreateBudgetFromEmptyDefaultCategories).isNull()
    }

    @Test
    fun `GetBudgetStatus variables is empty map`() {
        assertThat(GetBudgetStatus.variables(Unit)).isEmpty()
    }

    // -- GetBudgetMonth -----------------------------------------------------

    @Test
    fun `GetBudgetMonth parses budget system and per-category monthly amounts`() {
        val data =
            jsonNode(
                """
                {
                  "budgetSystem": "fixed_and_flex",
                  "budgetData": {
                    "monthlyAmountsByCategory": [
                      {
                        "category": {"id": "c-1"},
                        "monthlyAmounts": [
                          {
                            "month": "2026-05-01",
                            "plannedCashFlowAmount": 500.0,
                            "plannedSetAsideAmount": 100.0,
                            "actualAmount": 425.5,
                            "remainingAmount": 174.5,
                            "previousMonthRolloverAmount": -50.0,
                            "rolloverType": "monthly",
                            "cumulativeActualAmount": 425.5,
                            "rolloverTargetAmount": 600.0
                          }
                        ]
                      }
                    ]
                  }
                }
                """.trimIndent(),
            )
        val out = GetBudgetMonth.parseOutput(data)
        assertThat(out.budgetSystem).isEqualTo("fixed_and_flex")
        assertThat(out.byCategory).hasSize(1)
        val byCat = out.byCategory!![0]
        assertThat(byCat.categoryId).isEqualTo("c-1")
        assertThat(byCat.monthlyAmounts).hasSize(1)
        val month = byCat.monthlyAmounts!![0]
        assertThat(month.month).isEqualTo(java.time.LocalDate.of(2026, 5, 1))
        assertThat(month.plannedCashFlowAmount).isEqualTo(500.0)
        assertThat(month.plannedSetAsideAmount).isEqualTo(100.0)
        assertThat(month.actualAmount).isEqualTo(425.5)
        assertThat(month.remainingAmount).isEqualTo(174.5)
        assertThat(month.previousMonthRolloverAmount).isEqualTo(-50.0)
        assertThat(month.rolloverType).isEqualTo("monthly")
        assertThat(month.cumulativeActualAmount).isEqualTo(425.5)
        assertThat(month.rolloverTargetAmount).isEqualTo(600.0)
    }

    @Test
    fun `GetBudgetMonth skips monthly amount entries with blank month`() {
        val data =
            jsonNode(
                """
                {
                  "budgetData": {
                    "monthlyAmountsByCategory": [
                      {
                        "category": {"id": "c-1"},
                        "monthlyAmounts": [
                          {"month": "", "plannedCashFlowAmount": 100.0},
                          {"month": "2026-05-01", "plannedCashFlowAmount": 200.0}
                        ]
                      }
                    ]
                  }
                }
                """.trimIndent(),
            )
        val out = GetBudgetMonth.parseOutput(data)
        assertThat(out.byCategory!![0].monthlyAmounts).hasSize(1)
        assertThat(out.byCategory[0].monthlyAmounts!![0].plannedCashFlowAmount).isEqualTo(200.0)
    }

    @Test
    fun `GetBudgetMonth defaults to nulls when payload empty`() {
        val out = GetBudgetMonth.parseOutput(jsonNode("""{}"""))
        assertThat(out.budgetSystem).isNull()
        assertThat(out.byCategory).isEmpty()
    }

    @Test
    fun `GetBudgetMonth variables emit startDate and endDate both equal to month`() {
        val vars = GetBudgetMonth.variables(GetBudgetMonth.Input(month = java.time.LocalDate.of(2026, 5, 1)))
        assertThat(vars["startDate"]).isEqualTo("2026-05-01")
        assertThat(vars["endDate"]).isEqualTo("2026-05-01")
    }
}
