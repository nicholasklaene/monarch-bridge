package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.config.GlobalExceptionHandler
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.FAKE_SESSION
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.stubExec
import com.nicholasklaene.monarchbridge.exceptions.MonarchSessionMissingException
import com.nicholasklaene.monarchbridge.generated.model.CashflowReport
import com.nicholasklaene.monarchbridge.generated.model.CashflowReportMonth
import com.nicholasklaene.monarchbridge.generated.model.CategoryReport
import com.nicholasklaene.monarchbridge.generated.model.CategoryReportMonth
import com.nicholasklaene.monarchbridge.generated.model.GetCashflowReportResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetCategoryReportResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetIntegrationStatusResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetSubscriptionInvoicesResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetTagReportResponseData
import com.nicholasklaene.monarchbridge.generated.model.IntegrationStatus
import com.nicholasklaene.monarchbridge.generated.model.SubscriptionInvoice
import com.nicholasklaene.monarchbridge.generated.model.TagReport
import com.nicholasklaene.monarchbridge.generated.model.TagReportMonth
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

@WebMvcTest(SystemController::class)
@Import(GlobalExceptionHandler::class)
class SystemControllerV7Test {
    @Autowired private lateinit var mvc: MockMvc

    @MockitoBean private lateinit var sessionService: MonarchSessionService

    @MockitoBean private lateinit var client: MonarchClient

    // -- getCashflowReport ------------------------------------------------

    @Test
    fun `getCashflowReport returns totals plus per-month series`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetCashflowReportResponseData(
                report =
                    CashflowReport(
                        totalIncome = 12000.0,
                        totalExpense = -8500.0,
                        netCashflow = 3500.0,
                        months =
                            listOf(
                                CashflowReportMonth("2026-01", 3000.0, -2100.0, 900.0),
                                CashflowReportMonth("2026-02", 3200.0, -2200.0, 1000.0),
                            ),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/reports/cashflow"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.report.totalIncome").value(12000.0))
            .andExpect(jsonPath("$.data.report.netCashflow").value(3500.0))
            .andExpect(jsonPath("$.data.report.months[0].month").value("2026-01"))
            .andExpect(jsonPath("$.data.report.months[1].net").value(1000.0))
    }

    @Test
    fun `getCashflowReport returns 503 when session missing`() {
        `when`(sessionService.requireCurrent()).thenThrow(MonarchSessionMissingException())
        mvc
            .perform(get("/v1/reports/cashflow"))
            .andExpect(status().isServiceUnavailable)
            .andExpect(jsonPath("$.code").value("session_missing"))
    }

    // -- getCategoryReport ------------------------------------------------

    @Test
    fun `getCategoryReport returns per-month sums and totals for one category`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetCategoryReportResponseData(
                report =
                    CategoryReport(
                        categoryId = "c1",
                        categoryName = "Groceries",
                        totalAmount = -300.0,
                        averagePerMonth = -100.0,
                        months =
                            listOf(
                                CategoryReportMonth("2026-01", -100.0),
                                CategoryReportMonth("2026-02", -100.0),
                                CategoryReportMonth("2026-03", -100.0),
                            ),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/reports/category").param("categoryId", "c1"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.report.categoryId").value("c1"))
            .andExpect(jsonPath("$.data.report.categoryName").value("Groceries"))
            .andExpect(jsonPath("$.data.report.totalAmount").value(-300.0))
            .andExpect(jsonPath("$.data.report.months.length()").value(3))
    }

    @Test
    fun `getCategoryReport returns 400 when categoryId missing`() {
        // The spec marks categoryId required for this endpoint.
        mvc
            .perform(get("/v1/reports/category"))
            .andExpect(status().isBadRequest)
    }

    // -- getTagReport -----------------------------------------------------

    @Test
    fun `getTagReport returns per-month rows with both amount and count`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetTagReportResponseData(
                report =
                    TagReport(
                        tagId = "t1",
                        tagName = "Business",
                        totalAmount = -3200.0,
                        transactionCount = 24,
                        months =
                            listOf(
                                TagReportMonth("2026-01", -1500.0, 12),
                                TagReportMonth("2026-02", -1700.0, 12),
                            ),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/reports/tag").param("tagId", "t1"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.report.tagId").value("t1"))
            .andExpect(jsonPath("$.data.report.transactionCount").value(24))
            .andExpect(jsonPath("$.data.report.months[0].amount").value(-1500.0))
            .andExpect(jsonPath("$.data.report.months[0].count").value(12))
    }

    @Test
    fun `getTagReport returns 400 when tagId missing`() {
        mvc
            .perform(get("/v1/reports/tag"))
            .andExpect(status().isBadRequest)
    }

    // -- getSubscriptionInvoices ------------------------------------------

    @Test
    fun `getSubscriptionInvoices returns each invoice with status and pdf url`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetSubscriptionInvoicesResponseData(
                invoices =
                    listOf(
                        SubscriptionInvoice(
                            id = "inv-1",
                            date = "2026-05-01",
                            amount = 99.0,
                            status = "paid",
                            pdfUrl = "https://example.com/inv-1.pdf",
                            periodStart = "2026-05-01",
                            periodEnd = "2026-05-31",
                        ),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/subscription/invoices"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.invoices[0].id").value("inv-1"))
            .andExpect(jsonPath("$.data.invoices[0].status").value("paid"))
            .andExpect(jsonPath("$.data.invoices[0].pdfUrl").value("https://example.com/inv-1.pdf"))
    }

    @Test
    fun `getSubscriptionInvoices returns 503 when session missing`() {
        `when`(sessionService.requireCurrent()).thenThrow(MonarchSessionMissingException())
        mvc
            .perform(get("/v1/subscription/invoices"))
            .andExpect(status().isServiceUnavailable)
            .andExpect(jsonPath("$.code").value("session_missing"))
    }

    // -- getIntegrationStatus ---------------------------------------------

    @Test
    fun `getIntegrationStatus surfaces every row including reauth flags`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetIntegrationStatusResponseData(
                integrations =
                    listOf(
                        IntegrationStatus(
                            credentialId = "c1",
                            institutionName = "Chase",
                            provider = "plaid",
                            status = "connected",
                            lastSyncedAt = "2026-05-26T08:00:00Z",
                            needsReauth = false,
                        ),
                        IntegrationStatus(
                            credentialId = "c2",
                            institutionName = "Fidelity",
                            provider = "mx",
                            status = "error",
                            errorCode = "INVALID_CREDENTIALS",
                            errorMessage = "Password expired",
                            needsReauth = true,
                        ),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/integrations/status"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.integrations[0].status").value("connected"))
            .andExpect(jsonPath("$.data.integrations[0].needsReauth").value(false))
            .andExpect(jsonPath("$.data.integrations[1].errorCode").value("INVALID_CREDENTIALS"))
            .andExpect(jsonPath("$.data.integrations[1].needsReauth").value(true))
    }

    @Test
    fun `getIntegrationStatus returns 503 when session missing`() {
        `when`(sessionService.requireCurrent()).thenThrow(MonarchSessionMissingException())
        mvc
            .perform(get("/v1/integrations/status"))
            .andExpect(status().isServiceUnavailable)
            .andExpect(jsonPath("$.code").value("session_missing"))
    }
}
