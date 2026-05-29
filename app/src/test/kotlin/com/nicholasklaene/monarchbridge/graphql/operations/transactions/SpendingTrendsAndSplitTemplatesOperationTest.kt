package com.nicholasklaene.monarchbridge.graphql.operations.transactions

import com.nicholasklaene.monarchbridge.controllers.TestFixtures.jsonNode
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SpendingTrendsAndSplitTemplatesOperationTest {
    // -- GetSpendingTrends ------------------------------------------------

    @Test
    fun `GetSpendingTrends parses totals plus rising and falling category lists`() {
        val data =
            jsonNode(
                """
                {
                  "spendingTrends":{
                    "timeframe":"month",
                    "currentPeriodTotal":-3200.0,
                    "previousPeriodTotal":-2800.0,
                    "deltaAmount":-400.0,
                    "deltaPercent":0.142,
                    "risingCategories":[
                      {"categoryId":"c1","name":"Dining","deltaPercent":0.35},
                      {"categoryId":"c2","name":"Travel","deltaPercent":0.20}
                    ],
                    "fallingCategories":[
                      {"categoryId":"c3","name":"Subscriptions","deltaPercent":-0.50}
                    ]
                  }
                }
                """.trimIndent(),
            )
        val out = GetSpendingTrends.parseOutput(data)
        assertThat(out.trends.timeframe).isEqualTo("month")
        assertThat(out.trends.currentPeriodTotal).isEqualTo(-3200.0)
        assertThat(out.trends.previousPeriodTotal).isEqualTo(-2800.0)
        assertThat(out.trends.deltaAmount).isEqualTo(-400.0)
        assertThat(out.trends.deltaPercent).isEqualTo(0.142)
        assertThat(out.trends.risingCategories).hasSize(2)
        assertThat(out.trends.risingCategories[0].name).isEqualTo("Dining")
        assertThat(out.trends.risingCategories[0].deltaPercent).isEqualTo(0.35)
        assertThat(out.trends.fallingCategories).hasSize(1)
        assertThat(out.trends.fallingCategories[0].deltaPercent).isEqualTo(-0.50)
    }

    @Test
    fun `GetSpendingTrends returns empty category lists when no movement detected`() {
        val out = GetSpendingTrends.parseOutput(jsonNode("""{"spendingTrends":{}}"""))
        assertThat(out.trends.timeframe).isNull()
        assertThat(out.trends.risingCategories).isEmpty()
        assertThat(out.trends.fallingCategories).isEmpty()
    }

    @Test
    fun `GetSpendingTrends parses rows with only categoryId (no name yet)`() {
        // Newly-created categories sometimes hit the trends endpoint before they have a name.
        val data =
            jsonNode("""{"spendingTrends":{"risingCategories":[{"categoryId":"c-new"}]}}""")
        val out = GetSpendingTrends.parseOutput(data)
        assertThat(out.trends.risingCategories).hasSize(1)
        assertThat(
            out.trends.risingCategories
                .first()
                .categoryId,
        ).isEqualTo("c-new")
        assertThat(
            out.trends.risingCategories
                .first()
                .name,
        ).isNull()
        assertThat(
            out.trends.risingCategories
                .first()
                .deltaPercent,
        ).isNull()
    }

    @Test
    fun `GetSpendingTrends variables include timeframe only when set`() {
        val withTimeframe = GetSpendingTrends.variables(GetSpendingTrends.Input(timeframe = "quarter"))
        assertThat(withTimeframe).containsEntry("timeframe", "quarter")

        val noTimeframe = GetSpendingTrends.variables(GetSpendingTrends.Input())
        // mapOfNotNull drops it — Monarch falls back to its default.
        assertThat(noTimeframe).doesNotContainKey("timeframe")
    }

    // -- GetTransactionSplitTemplates -------------------------------------

    @Test
    fun `GetTransactionSplitTemplates parses each template with its percent-based splits`() {
        val data =
            jsonNode(
                """
                {
                  "transactionSplitTemplates":[
                    {"id":"tpl-1","name":"Costco run",
                     "splits":[
                       {"categoryId":"c-grocery","categoryName":"Groceries","percent":70.0},
                       {"categoryId":"c-household","categoryName":"Household","percent":30.0}
                     ]},
                    {"id":"tpl-2","name":"Amazon order",
                     "splits":[
                       {"categoryId":"c-misc","categoryName":"Misc","percent":100.0}
                     ]}
                  ]
                }
                """.trimIndent(),
            )
        val out = GetTransactionSplitTemplates.parseOutput(data)
        assertThat(out.templates).hasSize(2)
        assertThat(out.templates[0].id).isEqualTo("tpl-1")
        assertThat(out.templates[0].name).isEqualTo("Costco run")
        assertThat(out.templates[0].splits).hasSize(2)
        assertThat(out.templates[0].splits[0].categoryId).isEqualTo("c-grocery")
        assertThat(out.templates[0].splits[0].percent).isEqualTo(70.0)
        assertThat(out.templates[1].splits).hasSize(1)
        assertThat(
            out.templates[1]
                .splits
                .first()
                .percent,
        ).isEqualTo(100.0)
    }

    @Test
    fun `GetTransactionSplitTemplates returns empty list for users who haven't saved any`() {
        val out =
            GetTransactionSplitTemplates.parseOutput(jsonNode("""{"transactionSplitTemplates":[]}"""))
        assertThat(out.templates).isEmpty()
    }

    @Test
    fun `GetTransactionSplitTemplates defaults split with missing categoryName to null`() {
        // Defensive: a category that was renamed / archived might come back without a name.
        val data =
            jsonNode(
                """{"transactionSplitTemplates":[{"id":"tpl","name":"X",
                 "splits":[{"categoryId":"c","percent":50.0}]}]}""",
            )
        val out = GetTransactionSplitTemplates.parseOutput(data)
        assertThat(
            out.templates
                .first()
                .splits
                .first()
                .categoryName,
        ).isNull()
    }

    @Test
    fun `GetTransactionSplitTemplates variables are empty`() {
        assertThat(GetTransactionSplitTemplates.variables(Unit)).isEmpty()
    }
}
