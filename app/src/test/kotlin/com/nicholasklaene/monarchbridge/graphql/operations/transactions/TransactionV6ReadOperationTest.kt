package com.nicholasklaene.monarchbridge.graphql.operations.transactions

import com.nicholasklaene.monarchbridge.controllers.TestFixtures.jsonNode
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDate

/**
 * parseOutput + variables coverage for the R6 transaction-read endpoints:
 * - GetTransactionNotes: standalone notes accessor
 * - GetTransactionAuditLog: history of changes
 * - GetSpendingDashboard: home-tab spending widget
 */
class TransactionV6ReadOperationTest {
    // -- GetTransactionNotes ---------------------------------------------

    @Test
    fun `GetTransactionNotes parses note fields`() {
        val data =
            jsonNode(
                """
                {
                  "getTransaction": {
                    "id": "t-1",
                    "notes": "Reimburse Pat",
                    "updatedAt": "2026-05-26T10:00:00Z"
                  }
                }
                """.trimIndent(),
            )
        val out = GetTransactionNotes.parseOutput(data)
        assertThat(out.note.id).isEqualTo("t-1")
        assertThat(out.note.note).isEqualTo("Reimburse Pat")
        assertThat(out.note.updatedAt).isEqualTo("2026-05-26T10:00:00Z")
    }

    @Test
    fun `GetTransactionNotes tolerates missing fields`() {
        val out = GetTransactionNotes.parseOutput(jsonNode("""{"getTransaction": {}}"""))
        assertThat(out.note.id).isEqualTo("")
        assertThat(out.note.note).isNull()
        assertThat(out.note.updatedAt).isNull()
    }

    @Test
    fun `GetTransactionNotes variables wrap id verbatim`() {
        val vars = GetTransactionNotes.variables(GetTransactionNotes.Input(id = "t-1"))
        assertThat(vars).containsEntry("id", "t-1")
    }

    @Test
    fun `GetTransactionNotes operation name matches the bundle`() {
        assertThat(GetTransactionNotes.operationName).isEqualTo("Web_GetTransactionNotes")
    }

    // -- GetTransactionAuditLog ------------------------------------------

    @Test
    fun `GetTransactionAuditLog parses entries with all optional fields`() {
        val data =
            jsonNode(
                """
                {
                  "transactionAuditLog": {
                    "entries": [
                      {
                        "id": "e-1",
                        "timestamp": "2026-05-26T10:00:00Z",
                        "actor": "nick@x.com",
                        "action": "update",
                        "field": "category",
                        "oldValue": "Groceries",
                        "newValue": "Restaurants"
                      },
                      {"id": "e-2"}
                    ]
                  }
                }
                """.trimIndent(),
            )
        val out = GetTransactionAuditLog.parseOutput(data)
        assertThat(out.propertyEntries).hasSize(2)
        val first = out.propertyEntries[0]
        assertThat(first.id).isEqualTo("e-1")
        assertThat(first.timestamp).isEqualTo("2026-05-26T10:00:00Z")
        assertThat(first.actor).isEqualTo("nick@x.com")
        assertThat(first.action).isEqualTo("update")
        assertThat(first.field).isEqualTo("category")
        assertThat(first.oldValue).isEqualTo("Groceries")
        assertThat(first.newValue).isEqualTo("Restaurants")
        val second = out.propertyEntries[1]
        assertThat(second.id).isEqualTo("e-2")
        assertThat(second.timestamp).isNull()
        assertThat(second.actor).isNull()
    }

    @Test
    fun `GetTransactionAuditLog returns empty list when entries missing`() {
        val out = GetTransactionAuditLog.parseOutput(jsonNode("""{}"""))
        assertThat(out.propertyEntries).isEmpty()
    }

    @Test
    fun `GetTransactionAuditLog variables wrap id verbatim`() {
        val vars = GetTransactionAuditLog.variables(GetTransactionAuditLog.Input(id = "t-99"))
        assertThat(vars).containsEntry("id", "t-99")
    }

    @Test
    fun `GetTransactionAuditLog operation name matches the bundle`() {
        assertThat(GetTransactionAuditLog.operationName).isEqualTo("Web_GetTransactionAuditLog")
    }

    // -- GetSpendingDashboard --------------------------------------------

    @Test
    fun `GetSpendingDashboard parses totals and top categories`() {
        val data =
            jsonNode(
                """
                {
                  "spendingDashboard": {
                    "totalSpend": 3200.0,
                    "budgetRemaining": 1800.0,
                    "topCategories": [
                      {"categoryId": "c-1", "name": "Groceries", "amount": 850.0},
                      {"categoryId": "c-2", "name": null, "amount": null}
                    ]
                  }
                }
                """.trimIndent(),
            )
        val out = GetSpendingDashboard.parseOutput(data)
        assertThat(out.dashboard.totalSpend).isEqualTo(3200.0)
        assertThat(out.dashboard.budgetRemaining).isEqualTo(1800.0)
        assertThat(out.dashboard.topCategories).hasSize(2)
        assertThat(out.dashboard.topCategories[0].categoryId).isEqualTo("c-1")
        assertThat(out.dashboard.topCategories[0].name).isEqualTo("Groceries")
        assertThat(out.dashboard.topCategories[0].amount).isEqualTo(850.0)
        assertThat(out.dashboard.topCategories[1].name).isNull()
        assertThat(out.dashboard.topCategories[1].amount).isNull()
    }

    @Test
    fun `GetSpendingDashboard tolerates missing fields`() {
        val out = GetSpendingDashboard.parseOutput(jsonNode("""{}"""))
        assertThat(out.dashboard.totalSpend).isNull()
        assertThat(out.dashboard.budgetRemaining).isNull()
        assertThat(out.dashboard.topCategories).isEmpty()
    }

    @Test
    fun `GetSpendingDashboard variables include both dates when provided`() {
        val vars =
            GetSpendingDashboard.variables(
                GetSpendingDashboard.Input(
                    startDate = LocalDate.parse("2026-05-01"),
                    endDate = LocalDate.parse("2026-05-31"),
                ),
            )
        assertThat(vars["startDate"]).isEqualTo("2026-05-01")
        assertThat(vars["endDate"]).isEqualTo("2026-05-31")
    }

    @Test
    fun `GetSpendingDashboard variables forward nulls when dates absent`() {
        val vars = GetSpendingDashboard.variables(GetSpendingDashboard.Input())
        assertThat(vars["startDate"]).isNull()
        assertThat(vars["endDate"]).isNull()
    }

    @Test
    fun `GetSpendingDashboard operation name matches the bundle`() {
        assertThat(GetSpendingDashboard.operationName).isEqualTo("Web_GetSpendingDashboard")
    }
}
