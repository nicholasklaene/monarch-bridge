package com.nicholasklaene.monarchbridge.graphql.operations.system

import com.nicholasklaene.monarchbridge.controllers.TestFixtures.jsonNode
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDate

/**
 * parseOutput + variables coverage for the five v6 report endpoints plus calendar events.
 */
class ReportsOperationTest {
    // -- GetSpendingReport -------------------------------------------------

    @Test
    fun `GetSpendingReport parses summary and category list`() {
        val data =
            jsonNode(
                """
                {
                  "spendingReport": {
                    "totalSpend": 4321.0,
                    "totalBudget": 5000.0,
                    "percentOfBudget": 0.86,
                    "topCategories": [
                      {"categoryId": "c-1", "name": "Groceries", "amount": 800.0, "percentOfTotal": 0.18}
                    ]
                  }
                }
                """.trimIndent(),
            )
        val out = GetSpendingReport.parseOutput(data)
        assertThat(out.report.totalSpend).isEqualTo(4321.0)
        assertThat(out.report.totalBudget).isEqualTo(5000.0)
        assertThat(out.report.percentOfBudget).isEqualTo(0.86)
        assertThat(out.report.topCategories).hasSize(1)
        assertThat(out.report.topCategories[0].categoryId).isEqualTo("c-1")
        assertThat(out.report.topCategories[0].percentOfTotal).isEqualTo(0.18)
    }

    @Test
    fun `GetSpendingReport tolerates missing fields`() {
        val out = GetSpendingReport.parseOutput(jsonNode("""{}"""))
        assertThat(out.report.totalSpend).isNull()
        assertThat(out.report.topCategories).isEmpty()
    }

    @Test
    fun `GetSpendingReport variables include both dates when provided`() {
        val vars =
            GetSpendingReport.variables(
                GetSpendingReport.Input(startDate = LocalDate.parse("2026-04-01"), endDate = LocalDate.parse("2026-04-30")),
            )
        assertThat(vars["startDate"]).isEqualTo("2026-04-01")
        assertThat(vars["endDate"]).isEqualTo("2026-04-30")
    }

    @Test
    fun `GetSpendingReport variables drop dates when null`() {
        val vars = GetSpendingReport.variables(GetSpendingReport.Input())
        assertThat(vars["startDate"]).isNull()
        assertThat(vars["endDate"]).isNull()
    }

    // -- GetIncomeReport ---------------------------------------------------

    @Test
    fun `GetIncomeReport parses totals and sources`() {
        val data =
            jsonNode(
                """
                {
                  "incomeReport": {
                    "totalIncome": 10000.0,
                    "averageMonthlyIncome": 5000.0,
                    "sources": [
                      {"categoryId": "s-1", "name": "Salary", "amount": 9000.0, "percentOfTotal": 0.9}
                    ]
                  }
                }
                """.trimIndent(),
            )
        val out = GetIncomeReport.parseOutput(data)
        assertThat(out.report.totalIncome).isEqualTo(10000.0)
        assertThat(out.report.averageMonthlyIncome).isEqualTo(5000.0)
        assertThat(out.report.sources).hasSize(1)
        assertThat(out.report.sources[0].name).isEqualTo("Salary")
    }

    @Test
    fun `GetIncomeReport returns defaults on empty payload`() {
        val out = GetIncomeReport.parseOutput(jsonNode("""{}"""))
        assertThat(out.report.totalIncome).isNull()
        assertThat(out.report.sources).isEmpty()
    }

    @Test
    fun `GetIncomeReport variables emit dates`() {
        val vars =
            GetIncomeReport.variables(
                GetIncomeReport.Input(startDate = LocalDate.parse("2026-03-01"), endDate = LocalDate.parse("2026-03-31")),
            )
        assertThat(vars["startDate"]).isEqualTo("2026-03-01")
        assertThat(vars["endDate"]).isEqualTo("2026-03-31")
    }

    // -- GetNetWorthReport ------------------------------------------------

    @Test
    fun `GetNetWorthReport parses totals and series`() {
        val data =
            jsonNode(
                """
                {
                  "netWorthReport": {
                    "currentNetWorth": 50000.0,
                    "startingNetWorth": 40000.0,
                    "changeAmount": 10000.0,
                    "changePercent": 0.25,
                    "series": [
                      {"date": "2026-01-01", "balance": 40000.0},
                      {"date": "2026-05-01", "balance": 50000.0}
                    ]
                  }
                }
                """.trimIndent(),
            )
        val out = GetNetWorthReport.parseOutput(data)
        assertThat(out.report.currentNetWorth).isEqualTo(50000.0)
        assertThat(out.report.startingNetWorth).isEqualTo(40000.0)
        assertThat(out.report.changeAmount).isEqualTo(10000.0)
        assertThat(out.report.changePercent).isEqualTo(0.25)
        assertThat(out.report.series).hasSize(2)
        assertThat(out.report.series[0].date).isEqualTo(LocalDate.parse("2026-01-01"))
        assertThat(out.report.series[1].balance).isEqualTo(50000.0)
    }

    @Test
    fun `GetNetWorthReport tolerates missing fields and empty series`() {
        val out = GetNetWorthReport.parseOutput(jsonNode("""{"netWorthReport": {}}"""))
        assertThat(out.report.currentNetWorth).isNull()
        assertThat(out.report.series).isEmpty()
    }

    @Test
    fun `GetNetWorthReport variables emit both dates`() {
        val vars =
            GetNetWorthReport.variables(
                GetNetWorthReport.Input(startDate = LocalDate.parse("2026-01-01"), endDate = LocalDate.parse("2026-05-31")),
            )
        assertThat(vars["startDate"]).isEqualTo("2026-01-01")
        assertThat(vars["endDate"]).isEqualTo("2026-05-31")
    }

    // -- GetSavingsRateReport --------------------------------------------

    @Test
    fun `GetSavingsRateReport parses overall and monthly rates`() {
        val data =
            jsonNode(
                """
                {
                  "savingsRateReport": {
                    "overallSavingsRate": 0.32,
                    "monthlyRates": [
                      {"month": "2026-04", "savingsRate": 0.35, "income": 5000.0, "expense": -3250.0}
                    ]
                  }
                }
                """.trimIndent(),
            )
        val out = GetSavingsRateReport.parseOutput(data)
        assertThat(out.report.overallSavingsRate).isEqualTo(0.32)
        assertThat(out.report.monthlyRates).hasSize(1)
        assertThat(out.report.monthlyRates[0].month).isEqualTo("2026-04")
        assertThat(out.report.monthlyRates[0].savingsRate).isEqualTo(0.35)
        assertThat(out.report.monthlyRates[0].income).isEqualTo(5000.0)
        assertThat(out.report.monthlyRates[0].expense).isEqualTo(-3250.0)
    }

    @Test
    fun `GetSavingsRateReport tolerates missing fields`() {
        val out = GetSavingsRateReport.parseOutput(jsonNode("""{}"""))
        assertThat(out.report.overallSavingsRate).isNull()
        assertThat(out.report.monthlyRates).isEmpty()
    }

    @Test
    fun `GetSavingsRateReport variables include dates`() {
        val vars = GetSavingsRateReport.variables(GetSavingsRateReport.Input())
        assertThat(vars).containsEntry("startDate", null)
        assertThat(vars).containsEntry("endDate", null)
    }

    // -- GetMonthlyReportSummary -----------------------------------------

    @Test
    fun `GetMonthlyReportSummary parses all summary fields`() {
        val data =
            jsonNode(
                """
                {
                  "monthlyReportSummary": {
                    "month": "2026-04",
                    "netIncome": 2500.0,
                    "totalSpending": 3000.0,
                    "totalIncome": 5500.0,
                    "savingsRate": 0.45,
                    "topMerchant": "Whole Foods",
                    "topCategory": "Groceries",
                    "biggestSpend": 1200.0
                  }
                }
                """.trimIndent(),
            )
        val out = GetMonthlyReportSummary.parseOutput(data)
        assertThat(out.summary.month).isEqualTo("2026-04")
        assertThat(out.summary.netIncome).isEqualTo(2500.0)
        assertThat(out.summary.totalSpending).isEqualTo(3000.0)
        assertThat(out.summary.totalIncome).isEqualTo(5500.0)
        assertThat(out.summary.savingsRate).isEqualTo(0.45)
        assertThat(out.summary.topMerchant).isEqualTo("Whole Foods")
        assertThat(out.summary.topCategory).isEqualTo("Groceries")
        assertThat(out.summary.biggestSpend).isEqualTo(1200.0)
    }

    @Test
    fun `GetMonthlyReportSummary tolerates empty payload`() {
        val out = GetMonthlyReportSummary.parseOutput(jsonNode("""{}"""))
        assertThat(out.summary.month).isNull()
        assertThat(out.summary.savingsRate).isNull()
    }

    @Test
    fun `GetMonthlyReportSummary variables wrap the month string`() {
        val vars = GetMonthlyReportSummary.variables(GetMonthlyReportSummary.Input(month = LocalDate.parse("2026-04-01")))
        assertThat(vars).containsEntry("month", "2026-04-01")
    }

    // -- GetCalendarEvents -----------------------------------------------

    @Test
    fun `GetCalendarEvents parses event list`() {
        val data =
            jsonNode(
                """
                {
                  "calendarEvents": {
                    "events": [
                      {
                        "date": "2026-05-15",
                        "type": "bill",
                        "title": "Comcast",
                        "amount": -85.0,
                        "referenceId": "r-1"
                      }
                    ]
                  }
                }
                """.trimIndent(),
            )
        val out = GetCalendarEvents.parseOutput(data)
        assertThat(out.events).hasSize(1)
        val e = out.events[0]
        assertThat(e.date).isEqualTo(LocalDate.parse("2026-05-15"))
        assertThat(e.type).isEqualTo("bill")
        assertThat(e.title).isEqualTo("Comcast")
        assertThat(e.amount).isEqualTo(-85.0)
        assertThat(e.referenceId).isEqualTo("r-1")
    }

    @Test
    fun `GetCalendarEvents returns empty list when events missing`() {
        val out = GetCalendarEvents.parseOutput(jsonNode("""{}"""))
        assertThat(out.events).isEmpty()
    }

    @Test
    fun `GetCalendarEvents variables include dates`() {
        val vars =
            GetCalendarEvents.variables(
                GetCalendarEvents.Input(startDate = LocalDate.parse("2026-05-01"), endDate = LocalDate.parse("2026-05-31")),
            )
        assertThat(vars["startDate"]).isEqualTo("2026-05-01")
        assertThat(vars["endDate"]).isEqualTo("2026-05-31")
    }
}
