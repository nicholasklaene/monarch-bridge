package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.nicholasklaene.monarchbridge.controllers.TestFixtures.jsonNode
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDate

class ReportsV7OperationTest {
    // -- GetCashflowReport ------------------------------------------------

    @Test
    fun `GetCashflowReport parses totals and every month entry`() {
        val data =
            jsonNode(
                """
                {
                  "cashflowReport": {
                    "totalIncome": 12000.0,
                    "totalExpense": -8500.50,
                    "netCashflow": 3499.50,
                    "months": [
                      {"month":"2026-01","income":3000.0,"expense":-2100.0,"net":900.0},
                      {"month":"2026-02","income":3200.0,"expense":-2200.50,"net":999.50},
                      {"month":"2026-03","income":3000.0,"expense":-2100.0,"net":900.0},
                      {"month":"2026-04","income":2800.0,"expense":-2100.0,"net":700.0}
                    ]
                  }
                }
                """.trimIndent(),
            )
        val out = GetCashflowReport.parseOutput(data)
        assertThat(out.report.totalIncome).isEqualTo(12000.0)
        assertThat(out.report.totalExpense).isEqualTo(-8500.50)
        assertThat(out.report.netCashflow).isEqualTo(3499.50)
        assertThat(out.report.months).hasSize(4)
        assertThat(
            out.report.months
                .first()
                .month,
        ).isEqualTo("2026-01")
        assertThat(out.report.months[1].expense).isEqualTo(-2200.50)
        assertThat(
            out.report.months
                .last()
                .net,
        ).isEqualTo(700.0)
    }

    @Test
    fun `GetCashflowReport returns empty months and null totals when payload bare`() {
        val out = GetCashflowReport.parseOutput(jsonNode("""{"cashflowReport": {}}"""))
        assertThat(out.report.totalIncome).isNull()
        assertThat(out.report.totalExpense).isNull()
        assertThat(out.report.netCashflow).isNull()
        assertThat(out.report.months).isEmpty()
    }

    @Test
    fun `GetCashflowReport variables emit null toString-bypass when dates omitted`() {
        val withDates =
            GetCashflowReport.variables(
                GetCashflowReport.Input(
                    startDate = LocalDate.parse("2026-01-01"),
                    endDate = LocalDate.parse("2026-12-31"),
                ),
            )
        assertThat(withDates).containsEntry("startDate", "2026-01-01")
        assertThat(withDates).containsEntry("endDate", "2026-12-31")

        val noDates = GetCashflowReport.variables(GetCashflowReport.Input())
        assertThat(noDates).containsEntry("startDate", null)
        assertThat(noDates).containsEntry("endDate", null)
    }

    // -- GetCategoryReport ------------------------------------------------

    @Test
    fun `GetCategoryReport parses categoryId, name, totals, and per-month points`() {
        val data =
            jsonNode(
                """
                {
                  "categoryReport": {
                    "categoryId":"c1","categoryName":"Groceries",
                    "totalAmount":-1250.0,"averagePerMonth":-104.17,
                    "months":[
                      {"month":"2026-01","amount":-100.0},
                      {"month":"2026-02","amount":-110.0},
                      {"month":"2026-03","amount":-95.0}
                    ]
                  }
                }
                """.trimIndent(),
            )
        val out = GetCategoryReport.parseOutput(data)
        assertThat(out.report.categoryId).isEqualTo("c1")
        assertThat(out.report.categoryName).isEqualTo("Groceries")
        assertThat(out.report.totalAmount).isEqualTo(-1250.0)
        assertThat(out.report.averagePerMonth).isEqualTo(-104.17)
        assertThat(out.report.months).hasSize(3)
        assertThat(out.report.months[0].month).isEqualTo("2026-01")
        assertThat(out.report.months[0].amount).isEqualTo(-100.0)
    }

    @Test
    fun `GetCategoryReport defaults categoryId to empty and nullable fields to null on bare payload`() {
        val out = GetCategoryReport.parseOutput(jsonNode("""{"categoryReport":{}}"""))
        assertThat(out.report.categoryId).isEmpty()
        assertThat(out.report.categoryName).isNull()
        assertThat(out.report.totalAmount).isNull()
        assertThat(out.report.months).isEmpty()
    }

    @Test
    fun `GetCategoryReport variables always include categoryId and pass through dates`() {
        val full =
            GetCategoryReport.variables(
                GetCategoryReport.Input(
                    categoryId = "c1",
                    startDate = LocalDate.parse("2026-01-01"),
                    endDate = LocalDate.parse("2026-06-30"),
                ),
            )
        assertThat(full).containsEntry("categoryId", "c1")
        assertThat(full).containsEntry("startDate", "2026-01-01")
        assertThat(full).containsEntry("endDate", "2026-06-30")
    }

    // -- GetTagReport -----------------------------------------------------

    @Test
    fun `GetTagReport parses tagId, name, totals, count, and per-month rows with both amount and count`() {
        val data =
            jsonNode(
                """
                {
                  "tagReport": {
                    "tagId":"t1","tagName":"Business",
                    "totalAmount":-3200.0,"transactionCount":24,
                    "months":[
                      {"month":"2026-01","amount":-1500.0,"count":12},
                      {"month":"2026-02","amount":-1700.0,"count":12}
                    ]
                  }
                }
                """.trimIndent(),
            )
        val out = GetTagReport.parseOutput(data)
        assertThat(out.report.tagId).isEqualTo("t1")
        assertThat(out.report.tagName).isEqualTo("Business")
        assertThat(out.report.totalAmount).isEqualTo(-3200.0)
        assertThat(out.report.transactionCount).isEqualTo(24)
        assertThat(out.report.months).hasSize(2)
        // The brief calls out that callers may render either spend OR frequency from one response;
        // confirm both axes carry through.
        assertThat(out.report.months[0].amount).isEqualTo(-1500.0)
        assertThat(out.report.months[0].count).isEqualTo(12)
        assertThat(out.report.months[1].amount).isEqualTo(-1700.0)
    }

    @Test
    fun `GetTagReport variables include tagId required, dates optional`() {
        val full =
            GetTagReport.variables(
                GetTagReport.Input(
                    tagId = "t1",
                    startDate = LocalDate.parse("2026-01-01"),
                    endDate = LocalDate.parse("2026-12-31"),
                ),
            )
        assertThat(full["tagId"]).isEqualTo("t1")
        assertThat(full["startDate"]).isEqualTo("2026-01-01")
        assertThat(full["endDate"]).isEqualTo("2026-12-31")
    }

    @Test
    fun `GetTagReport defaults each month's nullable fields to null when missing`() {
        // Useful for newly-tagged months that have no transactions yet but show up as the chart spine.
        val data =
            jsonNode("""{"tagReport":{"tagId":"t","months":[{"month":"2026-01"}]}}""")
        val out = GetTagReport.parseOutput(data)
        assertThat(out.report.months).hasSize(1)
        assertThat(
            out.report.months
                .first()
                .amount,
        ).isNull()
        assertThat(
            out.report.months
                .first()
                .count,
        ).isNull()
    }
}
