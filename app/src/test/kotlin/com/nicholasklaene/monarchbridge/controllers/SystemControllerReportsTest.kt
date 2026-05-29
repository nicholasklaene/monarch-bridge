package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.config.GlobalExceptionHandler
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.FAKE_SESSION
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.stubExec
import com.nicholasklaene.monarchbridge.exceptions.MonarchSessionMissingException
import com.nicholasklaene.monarchbridge.generated.model.CalendarEvent
import com.nicholasklaene.monarchbridge.generated.model.GetCalendarEventsResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetIncomeReportResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetMonthlyReportSummaryResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetNetWorthReportResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetSavingsRateReportResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetSpendingReportResponseData
import com.nicholasklaene.monarchbridge.generated.model.IncomeReport
import com.nicholasklaene.monarchbridge.generated.model.MonthlyReportSummary
import com.nicholasklaene.monarchbridge.generated.model.NetWorthReport
import com.nicholasklaene.monarchbridge.generated.model.NetWorthReportPoint
import com.nicholasklaene.monarchbridge.generated.model.SavingsRateMonth
import com.nicholasklaene.monarchbridge.generated.model.SavingsRateReport
import com.nicholasklaene.monarchbridge.generated.model.SpendingReport
import com.nicholasklaene.monarchbridge.generated.model.SpendingReportCategory
import com.nicholasklaene.monarchbridge.graphql.MonarchClient
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.time.LocalDate

/**
 * WebMvc slice for the R6 reports + calendar endpoints on [SystemController]:
 *  GET /v1/reports/spending          getSpendingReport
 *  GET /v1/reports/income            getIncomeReport
 *  GET /v1/reports/net-worth         getNetWorthReport
 *  GET /v1/reports/savings-rate      getSavingsRateReport
 *  GET /v1/reports/monthly-summary   getMonthlyReportSummary
 *  GET /v1/calendar/events           getCalendarEvents
 */
@WebMvcTest(SystemController::class)
@Import(GlobalExceptionHandler::class)
class SystemControllerReportsTest {
    @Autowired private lateinit var mvc: MockMvc

    @MockitoBean private lateinit var sessionService: MonarchSessionService

    @MockitoBean private lateinit var client: MonarchClient

    @Test
    fun `getSpendingReport wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetSpendingReportResponseData(
                report =
                    SpendingReport(
                        totalSpend = 4321.0,
                        totalBudget = 5000.0,
                        percentOfBudget = 0.86,
                        topCategories =
                            listOf(
                                SpendingReportCategory(categoryId = "c-1", name = "Groceries", amount = 800.0),
                            ),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/reports/spending?start=2026-05-01&end=2026-05-31"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.report.totalSpend").value(4321.0))
            .andExpect(jsonPath("$.data.report.topCategories[0].name").value("Groceries"))
    }

    @Test
    fun `getSpendingReport returns 503 when session missing`() {
        `when`(sessionService.requireCurrent()).thenThrow(MonarchSessionMissingException())
        mvc
            .perform(get("/v1/reports/spending"))
            .andExpect(status().isServiceUnavailable)
            .andExpect(jsonPath("$.code").value("session_missing"))
    }

    @Test
    fun `getIncomeReport wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetIncomeReportResponseData(
                report =
                    IncomeReport(
                        totalIncome = 10000.0,
                        averageMonthlyIncome = 5000.0,
                        sources = emptyList(),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/reports/income"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.report.totalIncome").value(10000.0))
            .andExpect(jsonPath("$.data.report.averageMonthlyIncome").value(5000.0))
    }

    @Test
    fun `getNetWorthReport wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetNetWorthReportResponseData(
                report =
                    NetWorthReport(
                        currentNetWorth = 50000.0,
                        startingNetWorth = 40000.0,
                        changeAmount = 10000.0,
                        changePercent = 0.25,
                        series =
                            listOf(
                                NetWorthReportPoint(date = LocalDate.parse("2026-01-01"), balance = 40000.0),
                            ),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/reports/net-worth"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.report.currentNetWorth").value(50000.0))
            .andExpect(jsonPath("$.data.report.series[0].balance").value(40000.0))
    }

    @Test
    fun `getSavingsRateReport wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetSavingsRateReportResponseData(
                report =
                    SavingsRateReport(
                        overallSavingsRate = 0.32,
                        monthlyRates =
                            listOf(
                                SavingsRateMonth(
                                    month = "2026-04",
                                    savingsRate = 0.35,
                                    income = 5000.0,
                                    expense = -3250.0,
                                ),
                            ),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/reports/savings-rate"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.report.overallSavingsRate").value(0.32))
            .andExpect(jsonPath("$.data.report.monthlyRates[0].month").value("2026-04"))
    }

    @Test
    fun `getMonthlyReportSummary requires month parameter`() {
        mvc
            .perform(get("/v1/reports/monthly-summary"))
            .andExpect(status().isBadRequest)
    }

    @Test
    fun `getMonthlyReportSummary wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetMonthlyReportSummaryResponseData(
                summary =
                    MonthlyReportSummary(
                        month = "2026-04",
                        netIncome = 2500.0,
                        totalSpending = 3000.0,
                        totalIncome = 5500.0,
                        savingsRate = 0.45,
                    ),
            ),
        )
        mvc
            .perform(get("/v1/reports/monthly-summary?month=2026-04-01"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.summary.month").value("2026-04"))
            .andExpect(jsonPath("$.data.summary.netIncome").value(2500.0))
    }

    @Test
    fun `getCalendarEvents wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetCalendarEventsResponseData(
                events =
                    listOf(
                        CalendarEvent(
                            date = LocalDate.parse("2026-05-15"),
                            type = "bill",
                            title = "Comcast",
                            amount = -85.0,
                            referenceId = "r-1",
                        ),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/calendar/events?start=2026-05-01&end=2026-05-31"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.events[0].title").value("Comcast"))
            .andExpect(jsonPath("$.data.events[0].amount").value(-85.0))
            .andExpect(jsonPath("$.data.events[0].referenceId").value("r-1"))
    }
}
