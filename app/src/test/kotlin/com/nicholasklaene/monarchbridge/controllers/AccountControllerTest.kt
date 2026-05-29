package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.config.GlobalExceptionHandler
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.FAKE_SESSION
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.jsonNode
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.stubExec
import com.nicholasklaene.monarchbridge.exceptions.MonarchSessionMissingException
import com.nicholasklaene.monarchbridge.generated.model.Account
import com.nicholasklaene.monarchbridge.generated.model.AccountSnapshot
import com.nicholasklaene.monarchbridge.generated.model.AccountTypeReference
import com.nicholasklaene.monarchbridge.generated.model.AggregateSnapshot
import com.nicholasklaene.monarchbridge.generated.model.CreateManualAccountResponseData
import com.nicholasklaene.monarchbridge.generated.model.DeleteAccountResponseData
import com.nicholasklaene.monarchbridge.generated.model.DeleteInstitutionResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetAccountHistoryResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetAccountHoldingsResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetAccountTypeOptionsResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetInstitutionsResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetNetworthByTypeResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetNetworthRecentResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetNetworthResponseData
import com.nicholasklaene.monarchbridge.generated.model.Holding
import com.nicholasklaene.monarchbridge.generated.model.ListAccountsResponseData
import com.nicholasklaene.monarchbridge.generated.model.RecentAccountBalances
import com.nicholasklaene.monarchbridge.generated.model.SnapshotByAccountType
import com.nicholasklaene.monarchbridge.generated.model.UpdateAccountResponseData
import com.nicholasklaene.monarchbridge.graphql.MonarchClient
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.operations.accounts.GetUploadBalanceHistorySession
import com.nicholasklaene.monarchbridge.graphql.operations.accounts.ParseUploadBalanceHistorySession
import com.nicholasklaene.monarchbridge.graphql.operations.accounts.SessionStatus
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mockito.doReturn
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.context.annotation.Import
import org.springframework.http.MediaType
import org.springframework.mock.web.MockMultipartFile
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.time.LocalDate

/**
 * MockMvc slice for [AccountController]. One happy-path test per endpoint plus a single
 * representative session-missing test (we trust the base [MonarchControllerBase] gate to
 * behave the same on every exec-backed read).
 */
@WebMvcTest(AccountController::class)
@Import(GlobalExceptionHandler::class)
class AccountControllerTest {
    @Autowired private lateinit var mvc: MockMvc

    @MockitoBean private lateinit var sessionService: MonarchSessionService

    @MockitoBean private lateinit var client: MonarchClient

    @Test
    fun `listAccounts returns accounts envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            ListAccountsResponseData(
                accounts =
                    listOf(
                        Account(id = "a1", displayName = "Checking"),
                        Account(id = "a2", displayName = "Savings"),
                    ),
            ),
        )

        mvc
            .perform(get("/v1/accounts"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.accounts[0].id").value("a1"))
            .andExpect(jsonPath("$.data.accounts[0].displayName").value("Checking"))
            .andExpect(jsonPath("$.data.accounts[1].id").value("a2"))
    }

    @Test
    fun `listAccounts returns 503 when session missing`() {
        `when`(sessionService.requireCurrent()).thenThrow(MonarchSessionMissingException())

        mvc
            .perform(get("/v1/accounts"))
            .andExpect(status().isServiceUnavailable)
            .andExpect(jsonPath("$.code").value("session_missing"))
    }

    @Test
    fun `getInstitutions returns credentials and accounts arrays`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetInstitutionsResponseData(
                credentials = listOf(mapOf("id" to "c1", "name" to "Chase")),
                accounts = listOf(mapOf("id" to "a1")),
                subscription = mapOf("tier" to "premium"),
            ),
        )

        mvc
            .perform(get("/v1/institutions"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.credentials[0].id").value("c1"))
            .andExpect(jsonPath("$.data.accounts[0].id").value("a1"))
            .andExpect(jsonPath("$.data.subscription.tier").value("premium"))
    }

    @Test
    fun `getAccountTypeOptions returns options array`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetAccountTypeOptionsResponseData(
                accountTypeOptions = listOf(mapOf("type" to "depository", "subtype" to "savings")),
            ),
        )

        mvc
            .perform(get("/v1/account-type-options"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.accountTypeOptions[0].type").value("depository"))
            .andExpect(jsonPath("$.data.accountTypeOptions[0].subtype").value("savings"))
    }

    @Test
    fun `getAccountHistory returns transactions and snapshots for id`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetAccountHistoryResponseData(
                recentTransactions = emptyList(),
                snapshots =
                    listOf(
                        AccountSnapshot(date = LocalDate.parse("2026-05-01"), balance = 1234.56),
                    ),
                account = Account(id = "acc-1", displayName = "Checking"),
            ),
        )

        mvc
            .perform(get("/v1/account/acc-1/history"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.account.id").value("acc-1"))
            .andExpect(jsonPath("$.data.snapshots[0].balance").value(1234.56))
            .andExpect(jsonPath("$.data.snapshots[0].date").value("2026-05-01"))
    }

    @Test
    fun `getAccountHoldings returns holdings for id`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetAccountHoldingsResponseData(
                holdings =
                    listOf(
                        Holding(
                            id = "h1",
                            ticker = "AAPL",
                            name = "Apple Inc.",
                            type = "equity",
                            totalValue = 10000.0,
                            totalQuantity = 50.0,
                        ),
                    ),
            ),
        )

        mvc
            .perform(get("/v1/account/acc-1/holdings"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.holdings[0].id").value("h1"))
            .andExpect(jsonPath("$.data.holdings[0].ticker").value("AAPL"))
            .andExpect(jsonPath("$.data.holdings[0].totalValue").value(10000.0))
    }

    @Test
    fun `getNetworth returns aggregate snapshots`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetNetworthResponseData(
                aggregateSnapshots =
                    listOf(
                        AggregateSnapshot(balance = 100000.0, assetsBalance = 150000.0, liabilitiesBalance = 50000.0),
                    ),
            ),
        )

        mvc
            .perform(get("/v1/networth").param("start", "2026-04-01").param("end", "2026-05-01"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.aggregateSnapshots[0].balance").value(100000.0))
            .andExpect(jsonPath("$.data.aggregateSnapshots[0].assetsBalance").value(150000.0))
    }

    @Test
    fun `getNetworthRecent returns recent balances`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetNetworthRecentResponseData(
                accounts =
                    listOf(
                        RecentAccountBalances(id = "a1", displayName = "Checking", recentBalances = listOf(100.0, 200.0)),
                    ),
            ),
        )

        mvc
            .perform(get("/v1/networth/recent"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.accounts[0].id").value("a1"))
            .andExpect(jsonPath("$.data.accounts[0].recentBalances[1]").value(200.0))
    }

    @Test
    fun `getNetworthByType returns grouped snapshots`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetNetworthByTypeResponseData(
                snapshotsByAccountType =
                    listOf(
                        SnapshotByAccountType(accountType = "brokerage", balance = 5000.0),
                    ),
                accountTypes =
                    listOf(
                        AccountTypeReference(name = "brokerage", display = "Brokerage", group = "investment"),
                    ),
            ),
        )

        mvc
            .perform(get("/v1/networth/by-type").param("timeframe", "month"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.snapshotsByAccountType[0].accountType").value("brokerage"))
            .andExpect(jsonPath("$.data.accountTypes[0].name").value("brokerage"))
    }

    @Test
    fun `createManualAccount accepts valid body and returns accountId`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, CreateManualAccountResponseData(accountId = "new-acc-1"))

        mvc
            .perform(
                post("/v1/accounts")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(
                        """
                        {
                          "type": "depository",
                          "subtype": "savings",
                          "name": "Vacation Fund",
                          "displayBalance": 500.0,
                          "includeInNetWorth": true
                        }
                        """.trimIndent(),
                    ),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.accountId").value("new-acc-1"))
    }

    @Test
    fun `createManualAccount returns 400 when required field missing`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)

        // `name`, `type`, `subtype` are required. Omit `name` to trigger Jackson
        // MissingKotlinParameterException, which GlobalExceptionHandler maps to 400.
        mvc
            .perform(
                post("/v1/accounts")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(
                        """
                        {
                          "type": "depository",
                          "subtype": "savings"
                        }
                        """.trimIndent(),
                    ),
            ).andExpect(status().isBadRequest)
            .andExpect(jsonPath("$.code").value("invalid_input"))
    }

    @Test
    fun `updateAccount patches account and returns updated entity`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            UpdateAccountResponseData(
                account = Account(id = "acc-1", displayName = "Renamed Checking", displayBalance = 999.99),
            ),
        )

        mvc
            .perform(
                patch("/v1/accounts/acc-1")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"name": "Renamed Checking", "displayBalance": 999.99}"""),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.account.id").value("acc-1"))
            .andExpect(jsonPath("$.data.account.displayName").value("Renamed Checking"))
            .andExpect(jsonPath("$.data.account.displayBalance").value(999.99))
    }

    @Test
    fun `updateAccount accepts empty body since all fields optional`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            UpdateAccountResponseData(account = Account(id = "acc-1", displayName = "Checking")),
        )

        mvc
            .perform(
                patch("/v1/accounts/acc-1")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{}"),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.account.id").value("acc-1"))
    }

    @Test
    fun `deleteAccount returns deleted=true`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, DeleteAccountResponseData(deleted = true))

        mvc
            .perform(delete("/v1/accounts/acc-1"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.deleted").value(true))
    }

    @Test
    fun `bulkUpdateAccounts returns updated accounts list`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            com.nicholasklaene.monarchbridge.generated.model.BulkUpdateAccountsResponseData(
                accounts =
                    listOf(
                        Account(id = "a-1", displayName = "Renamed One"),
                        Account(id = "a-2", displayName = "Renamed Two", hideFromList = true),
                    ),
            ),
        )

        mvc
            .perform(
                patch("/v1/accounts/bulk")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(
                        """
                        {
                          "updates": [
                            {"id": "a-1", "name": "Renamed One"},
                            {"id": "a-2", "name": "Renamed Two", "hideFromList": true}
                          ]
                        }
                        """.trimIndent(),
                    ),
            ).andExpect(status().isOk)
            .andExpect(jsonPath("$.data.accounts.length()").value(2))
            .andExpect(jsonPath("$.data.accounts[0].id").value("a-1"))
            .andExpect(jsonPath("$.data.accounts[0].displayName").value("Renamed One"))
            .andExpect(jsonPath("$.data.accounts[1].hideFromList").value(true))
    }

    @Test
    fun `bulkUpdateAccounts returns 400 when updates is empty`() {
        mvc
            .perform(
                patch("/v1/accounts/bulk")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"updates": []}"""),
            ).andExpect(status().isBadRequest)
            .andExpect(jsonPath("$.code").value("invalid_input"))
    }

    @Test
    fun `bulkUpdateAccounts returns 400 when an entry omits the required id`() {
        mvc
            .perform(
                patch("/v1/accounts/bulk")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"updates": [{"name": "no-id"}]}"""),
            ).andExpect(status().isBadRequest)
            .andExpect(jsonPath("$.code").value("invalid_input"))
    }

    @Test
    fun `deleteInstitution returns deleted=true`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, DeleteInstitutionResponseData(deleted = true))

        mvc
            .perform(delete("/v1/institutions/cred-42"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.deleted").value(true))
    }

    @Test
    fun `uploadAccountBalanceHistory returns 202 with session key and initial status`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        doReturn(jsonNode("""{"session_key": "sess-1"}"""))
            .`when`(client)
            .uploadMultipart(anyStringArg(), anyMapArg())
        doReturn(SessionStatus(sessionKey = "sess-1", status = "processing"))
            .`when`(client)
            .execute(eqOp(ParseUploadBalanceHistorySession), anyInput())

        val file = MockMultipartFile("file", "history.csv", "text/csv", "date,balance\n2026-01-31,100.00".toByteArray())

        mvc
            .perform(multipart("/v1/accounts/acc-1/balance-history").file(file))
            .andExpect(status().isAccepted)
            .andExpect(jsonPath("$.data.sessionKey").value("sess-1"))
            .andExpect(jsonPath("$.data.status").value("processing"))
    }

    @Test
    fun `getBalanceHistoryStatus returns current status`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        doReturn(SessionStatus(sessionKey = "sess-1", status = "completed"))
            .`when`(client)
            .execute(eqOp(GetUploadBalanceHistorySession), anyInput())

        mvc
            .perform(get("/v1/balance-history/sess-1/status"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.sessionKey").value("sess-1"))
            .andExpect(jsonPath("$.data.status").value("completed"))
    }

    @Test
    fun `getBalanceHistoryStatus returns 503 when session missing`() {
        `when`(sessionService.requireCurrent()).thenThrow(MonarchSessionMissingException())

        mvc
            .perform(get("/v1/balance-history/sess-1/status"))
            .andExpect(status().isServiceUnavailable)
            .andExpect(jsonPath("$.code").value("session_missing"))
    }

    /**
     * `ArgumentMatchers.eq(value)` registers the matcher but returns `null` for object types,
     * which crashes Kotlin's non-null call site. Register the matcher, then return the same
     * non-null reference so Mockito's varargs collector accepts it.
     */
    @Suppress("UNCHECKED_CAST")
    private fun <I, O> eqOp(op: MonarchOperation<I, O>): MonarchOperation<Any, Any> {
        ArgumentMatchers.eq(op)
        return op as MonarchOperation<Any, Any>
    }

    /** Same trick for the input arg of [MonarchClient.execute]: register `any`, return non-null sentinel. */
    private fun anyInput(): Any {
        ArgumentMatchers.any<Any>()
        return Unit
    }

    private fun anyStringArg(): String {
        ArgumentMatchers.anyString()
        return ""
    }

    @Suppress("UNCHECKED_CAST")
    private fun anyMapArg(): Map<String, Any> {
        ArgumentMatchers.any<Map<String, Any>>()
        return emptyMap()
    }
}
