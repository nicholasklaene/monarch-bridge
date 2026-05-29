package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.nicholasklaene.monarchbridge.controllers.TestFixtures.jsonNode
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.loadFixture
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDate

class SystemOperationTest {
    @Test
    fun `ForceRefreshAccounts parses success true`() {
        val data = jsonNode("""{"forceRefreshAccounts": {"success": true}}""")
        val out = ForceRefreshAccounts.parseOutput(data)
        assertThat(out.success).isTrue
    }

    @Test
    fun `ForceRefreshAccounts parses success false`() {
        val data = jsonNode("""{"forceRefreshAccounts": {"success": false}}""")
        val out = ForceRefreshAccounts.parseOutput(data)
        assertThat(out.success).isFalse
    }

    @Test
    fun `ForceRefreshAccounts defaults to false when payload absent`() {
        val data = jsonNode("""{"forceRefreshAccounts": {}}""")
        val out = ForceRefreshAccounts.parseOutput(data)
        assertThat(out.success).isFalse
    }

    @Test
    fun `GetAccountsRefreshStatus marks allComplete true when no account syncing`() {
        val data =
            jsonNode(
                """
                {
                  "accounts": [
                    {"id":"a1","hasSyncInProgress":false},
                    {"id":"a2","hasSyncInProgress":false}
                  ]
                }
                """.trimIndent(),
            )
        val out = GetAccountsRefreshStatus.parseOutput(data)
        assertThat(out.accounts).hasSize(2)
        assertThat(out.accounts[0].id).isEqualTo("a1")
        assertThat(out.accounts[0].hasSyncInProgress).isFalse
        assertThat(out.accounts[1].id).isEqualTo("a2")
        assertThat(out.allComplete).isTrue
    }

    @Test
    fun `GetAccountsRefreshStatus marks allComplete false when one account still syncing`() {
        val data =
            jsonNode(
                """
                {
                  "accounts": [
                    {"id":"a1","hasSyncInProgress":false},
                    {"id":"a2","hasSyncInProgress":true},
                    {"id":"a3","hasSyncInProgress":false}
                  ]
                }
                """.trimIndent(),
            )
        val out = GetAccountsRefreshStatus.parseOutput(data)
        assertThat(out.accounts).hasSize(3)
        assertThat(out.accounts[1].hasSyncInProgress).isTrue
        assertThat(out.allComplete).isFalse
    }

    @Test
    fun `GetAccountsRefreshStatus with empty accounts is allComplete true`() {
        val data = jsonNode("""{"accounts": []}""")
        val out = GetAccountsRefreshStatus.parseOutput(data)
        assertThat(out.accounts).isEmpty()
        assertThat(out.allComplete).isTrue
    }

    @Test
    fun `GetCreditHistory parses snapshots with ISO dates and nested user id`() {
        val data =
            jsonNode(
                """
                {
                  "creditScoreSnapshots": [
                    {"reportedDate":"2026-01-15","score":745,"user":{"id":"u1"}},
                    {"reportedDate":"2026-02-15","score":752,"user":{"id":"u1"}}
                  ]
                }
                """.trimIndent(),
            )
        val out = GetCreditHistory.parseOutput(data)
        assertThat(out.snapshots).hasSize(2)
        assertThat(out.snapshots[0].reportedDate).isEqualTo(LocalDate.of(2026, 1, 15))
        assertThat(out.snapshots[0].score).isEqualTo(745)
        assertThat(out.snapshots[0].userId).isEqualTo("u1")
        assertThat(out.snapshots[1].reportedDate).isEqualTo(LocalDate.of(2026, 2, 15))
        assertThat(out.snapshots[1].score).isEqualTo(752)
    }

    @Test
    fun `GetCreditHistory returns empty list when no snapshots`() {
        val data = jsonNode("""{"creditScoreSnapshots": []}""")
        val out = GetCreditHistory.parseOutput(data)
        assertThat(out.snapshots).isEmpty()
    }

    @Test
    fun `GetCreditHistory handles snapshot with missing user`() {
        val data =
            jsonNode(
                """
                {"creditScoreSnapshots": [
                  {"reportedDate":"2026-03-15","score":700}
                ]}
                """.trimIndent(),
            )
        val out = GetCreditHistory.parseOutput(data)
        assertThat(out.snapshots).hasSize(1)
        assertThat(out.snapshots.first().reportedDate).isEqualTo(LocalDate.of(2026, 3, 15))
        assertThat(out.snapshots.first().score).isEqualTo(700)
        assertThat(out.snapshots.first().userId).isNull()
    }

    @Test
    fun `GetSubscriptionDetails parses premium subscriber`() {
        val data =
            jsonNode(
                """
                {
                  "subscription": {
                    "isOnFreeTrial": false,
                    "hasPremiumEntitlement": true,
                    "id": "sub-123",
                    "paymentSource": "stripe",
                    "referralCode": "FRIEND10"
                  }
                }
                """.trimIndent(),
            )
        val out = GetSubscriptionDetails.parseOutput(data)
        assertThat(out.isOnFreeTrial).isFalse
        assertThat(out.hasPremiumEntitlement).isTrue
        assertThat(out.id).isEqualTo("sub-123")
        assertThat(out.paymentSource).isEqualTo("stripe")
        assertThat(out.referralCode).isEqualTo("FRIEND10")
    }

    @Test
    fun `GetSubscriptionDetails parses free trial with nulls`() {
        val data =
            jsonNode(
                """
                {
                  "subscription": {
                    "isOnFreeTrial": true,
                    "hasPremiumEntitlement": false,
                    "id": null,
                    "paymentSource": null,
                    "referralCode": null
                  }
                }
                """.trimIndent(),
            )
        val out = GetSubscriptionDetails.parseOutput(data)
        assertThat(out.isOnFreeTrial).isTrue
        assertThat(out.hasPremiumEntitlement).isFalse
        assertThat(out.id).isNull()
        assertThat(out.paymentSource).isNull()
        assertThat(out.referralCode).isNull()
    }

    @Test
    fun `GetSubscriptionDetails defaults booleans when fields missing`() {
        val data = jsonNode("""{"subscription": {}}""")
        val out = GetSubscriptionDetails.parseOutput(data)
        assertThat(out.isOnFreeTrial).isFalse
        assertThat(out.hasPremiumEntitlement).isFalse
        assertThat(out.id).isNull()
    }

    @Test
    fun `GetWeeklyRecap returns null recap when Monarch has none yet`() {
        val out = GetWeeklyRecap.parseOutput(jsonNode("""{"recap": null}"""))
        assertThat(out.recap).isNull()
    }

    @Test
    fun `GetWeeklyRecap parses recap with cards and free-form metrics`() {
        val data = loadFixture("system/weekly-recap")
        val out = GetWeeklyRecap.parseOutput(data)
        assertThat(out.recap).isNotNull
        assertThat(out.recap!!.id).isEqualTo("rec-1")
        assertThat(out.recap.dateRangeStart).isEqualTo(LocalDate.of(2026, 5, 18))
        assertThat(out.recap.dateRangeEnd).isEqualTo(LocalDate.of(2026, 5, 24))
        assertThat(out.recap.summary).isEqualTo("You spent less than usual.")
        assertThat(out.recap.cards).hasSize(1)
        val card = out.recap.cards!!.first()
        assertThat(card.module).isEqualTo("cashflow")
        assertThat(card.metrics).containsEntry("net", 420.5).containsEntry("income", 5000)
        assertThat(card.richBlocks).containsKey("blocks")
    }

    @Test
    fun `GetFinancialInsights parses insights summary and latestRun`() {
        val data = loadFixture("system/financial-insights")
        val out = GetFinancialInsights.parseOutput(data)
        assertThat(out.insights).hasSize(1)
        val ins = out.insights[0]
        assertThat(ins.id).isEqualTo("ins-1")
        assertThat(ins.merchantNameDisplay).isEqualTo("Netflix")
        assertThat(ins.savingsEstimateLow).isEqualTo(15.99)
        assertThat(ins.nextChargeDate).isEqualTo(LocalDate.of(2026, 6, 1))
        assertThat(ins.recurringStreamSnapshot).containsEntry("frequency", "monthly")
        assertThat(ins.relatedMerchants).hasSize(1)
        assertThat(ins.relatedMerchants!![0].name).isEqualTo("Netflix")
        assertThat(out.summary).isNotNull
        assertThat(out.summary!!.newCount).isEqualTo(3)
        assertThat(out.summary.completedCount).isEqualTo(2)
        assertThat(out.latestRun).isNotNull
        assertThat(out.latestRun!!.id).isEqualTo("run-1")
        assertThat(out.latestRun.insightsGeneratedCount).isEqualTo(4)
    }

    @Test
    fun `GetFinancialInsights handles empty lists`() {
        val data =
            jsonNode(
                """
                {"financialInsights": [], "financialInsightSummary": null, "financialInsightRuns": []}
                """.trimIndent(),
            )
        val out = GetFinancialInsights.parseOutput(data)
        assertThat(out.insights).isEmpty()
        assertThat(out.summary).isNull()
        assertThat(out.latestRun).isNull()
    }

    @Test
    fun `GetFinancialInsight returns null when insight missing`() {
        val out = GetFinancialInsight.parseOutput(jsonNode("""{"financialInsight": null}"""))
        assertThat(out.insight).isNull()
    }

    @Test
    fun `GetFinancialInsight flattens paymentAccount label and parses playbook diySteps`() {
        val data = loadFixture("system/financial-insight-detail")
        val out = GetFinancialInsight.parseOutput(data)
        assertThat(out.insight).isNotNull
        val ins = out.insight!!
        assertThat(ins.id).isEqualTo("ins-2")
        assertThat(ins.canUseBrowserAutomation).isTrue
        assertThat(ins.paymentAccountLabel).isEqualTo("Chase ****1234")
        assertThat(ins.playbook).isNotNull
        assertThat(ins.playbook!!.diySteps).contains("Switch plan")
        assertThat(ins.relatedMerchants).isEmpty()
    }

    @Test
    fun `GetLatestRefreshOperation returns null when none exist`() {
        val out = GetLatestRefreshOperation.parseOutput(jsonNode("""{"latestForceRefreshOperation": null}"""))
        assertThat(out.operation).isNull()
    }

    @Test
    fun `GetLatestRefreshOperation parses id and state`() {
        val data = jsonNode("""{"latestForceRefreshOperation": {"id": "op-1", "state": "IN_PROGRESS"}}""")
        val out = GetLatestRefreshOperation.parseOutput(data)
        assertThat(out.operation).isNotNull
        assertThat(out.operation!!.id).isEqualTo("op-1")
        assertThat(out.operation.state).isEqualTo("IN_PROGRESS")
    }

    @Test
    fun `GetLatestRefreshOperation handles missing state`() {
        val out = GetLatestRefreshOperation.parseOutput(jsonNode("""{"latestForceRefreshOperation": {"id": "op-2"}}"""))
        assertThat(out.operation!!.state).isNull()
    }

    @Test
    fun `GetLatestRefreshOperation variables is empty map`() {
        assertThat(GetLatestRefreshOperation.variables(Unit)).isEmpty()
    }

    @Test
    fun `ForceRefreshAccounts variables wrap accountIds under input`() {
        val withIds = ForceRefreshAccounts.variables(ForceRefreshAccounts.Input(accountIds = listOf("a-1", "a-2")))

        @Suppress("UNCHECKED_CAST")
        val inner = withIds["input"] as Map<String, Any?>
        assertThat(inner["accountIds"]).isEqualTo(listOf("a-1", "a-2"))

        val empty = ForceRefreshAccounts.variables(ForceRefreshAccounts.Input())

        @Suppress("UNCHECKED_CAST")
        val emptyInner = empty["input"] as Map<String, Any?>
        assertThat(emptyInner["accountIds"]).isEqualTo(emptyList<String>())
    }

    @Test
    fun `GetWeeklyRecap variables serialize ISO date range`() {
        val vars =
            GetWeeklyRecap.variables(
                GetWeeklyRecap.Input(
                    startDate = LocalDate.of(2026, 5, 18),
                    endDate = LocalDate.of(2026, 5, 24),
                ),
            )
        assertThat(vars["startDate"]).isEqualTo("2026-05-18")
        assertThat(vars["endDate"]).isEqualTo("2026-05-24")
    }

    @Test
    fun `GetFinancialInsights variables forward statuses and ISO date window`() {
        val all =
            GetFinancialInsights.variables(
                GetFinancialInsights.Input(
                    statuses = listOf("NEW", "ACCEPTED"),
                    summaryStartDate = LocalDate.of(2026, 1, 1),
                    summaryEndDate = LocalDate.of(2026, 5, 1),
                ),
            )
        assertThat(all["statuses"]).isEqualTo(listOf("NEW", "ACCEPTED"))
        assertThat(all["summaryStartDate"]).isEqualTo("2026-01-01")
        assertThat(all["summaryEndDate"]).isEqualTo("2026-05-01")

        val nothing = GetFinancialInsights.variables(GetFinancialInsights.Input())
        assertThat(nothing["statuses"]).isNull()
        assertThat(nothing["summaryStartDate"]).isNull()
        assertThat(nothing["summaryEndDate"]).isNull()
    }

    @Test
    fun `GetFinancialInsight variables forward id`() {
        val vars = GetFinancialInsight.variables(GetFinancialInsight.Input(id = "ins-9"))
        assertThat(vars["id"]).isEqualTo("ins-9")
    }

    @Test
    fun `GetCreditHistory variables is empty map`() {
        assertThat(GetCreditHistory.variables(Unit)).isEmpty()
    }

    @Test
    fun `GetSubscriptionDetails variables is empty map`() {
        assertThat(GetSubscriptionDetails.variables(Unit)).isEmpty()
    }

    @Test
    fun `GetAccountsRefreshStatus variables is empty map`() {
        assertThat(GetAccountsRefreshStatus.variables(Unit)).isEmpty()
    }
}
