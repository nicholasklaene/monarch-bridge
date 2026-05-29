package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.config.GlobalExceptionHandler
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.FAKE_SESSION
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.stubExec
import com.nicholasklaene.monarchbridge.generated.model.ExplainTransactionResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetSpendingDashboardResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetTransactionAuditLogResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetTransactionNotesResponseData
import com.nicholasklaene.monarchbridge.generated.model.SpendingDashboard
import com.nicholasklaene.monarchbridge.generated.model.SpendingDashboardCategory
import com.nicholasklaene.monarchbridge.generated.model.TransactionAuditEntry
import com.nicholasklaene.monarchbridge.generated.model.TransactionNote
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

/**
 * R6 transaction read endpoints on [TransactionController]:
 *  GET /v1/transactions/explain/{id}        explainTransaction (legacy path)
 *  GET /v1/transactions/{id}/notes          getTransactionNotes
 *  GET /v1/transactions/{id}/audit          getTransactionAuditLog
 *  GET /v1/dashboard/spending               getSpendingDashboard
 */
@WebMvcTest(TransactionController::class)
@Import(GlobalExceptionHandler::class)
class TransactionControllerV6ReadsTest {
    @Autowired private lateinit var mvc: MockMvc

    @MockitoBean private lateinit var sessionService: MonarchSessionService

    @MockitoBean private lateinit var client: MonarchClient

    @Test
    fun `explainTransaction at legacy path wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            ExplainTransactionResponseData(
                explanation = "Recurring monthly Netflix subscription",
            ),
        )
        mvc
            .perform(get("/v1/transactions/explain/t-1"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.explanation").value("Recurring monthly Netflix subscription"))
    }

    @Test
    fun `getTransactionNotes wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetTransactionNotesResponseData(
                note =
                    TransactionNote(
                        id = "t-1",
                        note = "Reimburse Pat",
                        updatedAt = "2026-05-26T10:00:00Z",
                    ),
            ),
        )
        mvc
            .perform(get("/v1/transactions/t-1/notes"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.note.id").value("t-1"))
            .andExpect(jsonPath("$.data.note.note").value("Reimburse Pat"))
    }

    @Test
    fun `getTransactionAuditLog wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetTransactionAuditLogResponseData(
                propertyEntries =
                    listOf(
                        TransactionAuditEntry(
                            id = "e-1",
                            timestamp = "2026-05-26T10:00:00Z",
                            actor = "nick@x.com",
                            action = "update",
                            field = "category",
                            oldValue = "Groceries",
                            newValue = "Restaurants",
                        ),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/transactions/t-1/audit"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.entries[0].id").value("e-1"))
            .andExpect(jsonPath("$.data.entries[0].field").value("category"))
            .andExpect(jsonPath("$.data.entries[0].newValue").value("Restaurants"))
    }

    @Test
    fun `getSpendingDashboard wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetSpendingDashboardResponseData(
                dashboard =
                    SpendingDashboard(
                        totalSpend = 3200.0,
                        budgetRemaining = 1800.0,
                        topCategories =
                            listOf(
                                SpendingDashboardCategory(categoryId = "c-1", name = "Groceries", amount = 850.0),
                            ),
                    ),
            ),
        )
        mvc
            .perform(get("/v1/dashboard/spending"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.dashboard.totalSpend").value(3200.0))
            .andExpect(jsonPath("$.data.dashboard.topCategories[0].name").value("Groceries"))
    }
}
