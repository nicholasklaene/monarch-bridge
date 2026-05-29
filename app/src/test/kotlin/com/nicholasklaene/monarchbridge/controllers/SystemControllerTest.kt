package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.config.GlobalExceptionHandler
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.FAKE_SESSION
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.stubExec
import com.nicholasklaene.monarchbridge.exceptions.MonarchSessionMissingException
import com.nicholasklaene.monarchbridge.generated.model.AccountSyncStatus
import com.nicholasklaene.monarchbridge.generated.model.CreditScoreSnapshot
import com.nicholasklaene.monarchbridge.generated.model.FinancialInsight
import com.nicholasklaene.monarchbridge.generated.model.FinancialInsightDetail
import com.nicholasklaene.monarchbridge.generated.model.FinancialInsightRun
import com.nicholasklaene.monarchbridge.generated.model.FinancialInsightSummary
import com.nicholasklaene.monarchbridge.generated.model.GetCreditHistoryResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetFinancialInsightResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetLatestInsightRunResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetLatestRefreshOperationResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetRefreshStatusResponseData
import com.nicholasklaene.monarchbridge.generated.model.GetWeeklyRecapResponseData
import com.nicholasklaene.monarchbridge.generated.model.LatestFinancialInsightRun
import com.nicholasklaene.monarchbridge.generated.model.LatestRefreshOperation
import com.nicholasklaene.monarchbridge.generated.model.ListFinancialInsightsResponseData
import com.nicholasklaene.monarchbridge.generated.model.SubscriptionDetails
import com.nicholasklaene.monarchbridge.generated.model.WeeklyRecap
import com.nicholasklaene.monarchbridge.graphql.MonarchClient
import com.nicholasklaene.monarchbridge.graphql.MonarchOperation
import com.nicholasklaene.monarchbridge.graphql.operations.system.ForceRefreshAccounts
import com.nicholasklaene.monarchbridge.graphql.operations.system.GetAccountsRefreshStatus
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.time.LocalDate

/**
 * MockMvc slice for [SystemController]. Covers each endpoint method, including the
 * with-session vs no-session permutations on the read endpoints that tolerate an
 * unauthenticated state ([SystemController.getHealth], [SystemController.getAuthStatus]).
 */
@WebMvcTest(SystemController::class)
@Import(GlobalExceptionHandler::class)
// Shrink the requestRefreshAndWait poll cadence so the timeout-path test finishes in well
// under a second (vs the 2s prod default). The success-path test is poll-free regardless.
@TestPropertySource(properties = ["monarch.refresh.poll-interval-ms=10"])
class SystemControllerTest {
    @Autowired private lateinit var mvc: MockMvc

    @MockitoBean private lateinit var sessionService: MonarchSessionService

    @MockitoBean private lateinit var client: MonarchClient

    @Test
    fun `getHealth returns UP with session fields when authenticated`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)

        mvc
            .perform(get("/healthz"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.status").value("UP"))
            .andExpect(jsonPath("$.authenticated").value(true))
            .andExpect(jsonPath("$.lastVerifiedAt").exists())
    }

    @Test
    fun `getHealth returns UP with authenticated=false when no session`() {
        `when`(sessionService.current()).thenReturn(null)

        mvc
            .perform(get("/healthz"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.status").value("UP"))
            .andExpect(jsonPath("$.authenticated").value(false))
            .andExpect(jsonPath("$.lastVerifiedAt").doesNotExist())
    }

    @Test
    fun `getAuthStatus returns authenticated + email when session loaded`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)

        mvc
            .perform(get("/v1/auth/status"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.authenticated").value(true))
            .andExpect(jsonPath("$.email").value("test@example.com"))
    }

    @Test
    fun `getAuthStatus returns authenticated=false when no session`() {
        `when`(sessionService.current()).thenReturn(null)

        mvc
            .perform(get("/v1/auth/status"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.authenticated").value(false))
            .andExpect(jsonPath("$.email").doesNotExist())
    }

    @Test
    fun `refreshAuth reloads session and returns auth status`() {
        `when`(sessionService.reload()).thenReturn(FAKE_SESSION)

        mvc
            .perform(post("/v1/auth/refresh"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.authenticated").value(true))
            .andExpect(jsonPath("$.email").value("test@example.com"))

        verify(sessionService).reload()
    }

    @Test
    fun `requestRefresh returns 202 and dispatches ForceRefreshAccounts`() {
        `when`(sessionService.requireCurrent()).thenReturn(FAKE_SESSION)

        // Capture the dispatched op argument via doAnswer. The capturing pattern dodges
        // Mockito's typed matchers, which are brittle around the type-erased generics on
        // MonarchClient.execute<I, O>(...) in Kotlin (any() returns null → NPE on cast).
        val dispatchedOps = mutableListOf<Any?>()
        org.mockito.Mockito
            .doAnswer { invocation ->
                dispatchedOps.add(invocation.getArgument(0))
                null
            }.`when`(client)
            .execute<Any, Any>(
                anyOp(),
                anyOrUnit(),
            )

        mvc
            .perform(post("/v1/refresh"))
            .andExpect(status().isAccepted)

        org.assertj.core.api.Assertions
            .assertThat(dispatchedOps)
            .containsExactly(ForceRefreshAccounts)
    }

    @Test
    fun `requestRefresh returns 503 when session missing`() {
        `when`(sessionService.requireCurrent()).thenThrow(MonarchSessionMissingException())

        mvc
            .perform(post("/v1/refresh"))
            .andExpect(status().isServiceUnavailable)
            .andExpect(jsonPath("$.code").value("session_missing"))

        // Once the session gate threw, the controller must never reach the dispatch.
        // verifyNoInteractions is matcher-free, so it sidesteps generic-method gymnastics.
        org.mockito.Mockito.verifyNoInteractions(client)
    }

    /**
     * Registers an [ArgumentMatchers.any] matcher for a `MonarchOperation<*, *>` and returns
     * a non-null sentinel so Kotlin's non-null call chain doesn't NPE. The actual value
     * returned is unused — the matcher state is what drives Mockito's resolution.
     */
    @Suppress("UNCHECKED_CAST")
    private fun anyOp(): MonarchOperation<Any, Any> {
        ArgumentMatchers.any<MonarchOperation<Any, Any>>()
        return ForceRefreshAccounts as MonarchOperation<Any, Any>
    }

    /**
     * Same trick for the second arg: register an `any()` matcher and return a non-null
     * sentinel ([Unit]) so Mockito's varargs collector accepts it.
     */
    private fun anyOrUnit(): Any {
        ArgumentMatchers.any<Any>()
        return Unit
    }

    @Test
    fun `getRefreshStatus wraps data in 200 response envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetRefreshStatusResponseData(
                accounts =
                    listOf(
                        AccountSyncStatus(id = "a1", hasSyncInProgress = false),
                        AccountSyncStatus(id = "a2", hasSyncInProgress = true),
                    ),
                allComplete = false,
            ),
        )

        mvc
            .perform(get("/v1/refresh/status"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.allComplete").value(false))
            .andExpect(jsonPath("$.data.accounts[0].id").value("a1"))
            .andExpect(jsonPath("$.data.accounts[0].hasSyncInProgress").value(false))
            .andExpect(jsonPath("$.data.accounts[1].id").value("a2"))
    }

    @Test
    fun `getRefreshStatus returns 503 when session missing`() {
        `when`(sessionService.requireCurrent()).thenThrow(MonarchSessionMissingException())

        mvc
            .perform(get("/v1/refresh/status"))
            .andExpect(status().isServiceUnavailable)
            .andExpect(jsonPath("$.code").value("session_missing"))
    }

    @Test
    fun `requestRefreshAndWait returns 200 with allComplete=true on the first poll`() {
        `when`(sessionService.requireCurrent()).thenReturn(FAKE_SESSION)
        // Dispatch by op identity. ForceRefreshAccounts returns its small Output; the
        // status query reports allComplete=true so the controller exits without sleeping.
        `when`(client.execute(anyOp(), anyOrUnit())).thenAnswer { inv ->
            when (inv.getArgument<Any>(0)) {
                ForceRefreshAccounts -> {
                    ForceRefreshAccounts.Output(success = true)
                }

                GetAccountsRefreshStatus -> {
                    GetRefreshStatusResponseData(
                        accounts = listOf(AccountSyncStatus(id = "a1", hasSyncInProgress = false)),
                        allComplete = true,
                    )
                }

                else -> {
                    error("unexpected op: ${inv.getArgument<Any>(0)}")
                }
            }
        }

        mvc
            .perform(post("/v1/refresh/wait?timeoutSeconds=5"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.allComplete").value(true))
            .andExpect(jsonPath("$.data.accounts[0].id").value("a1"))
            .andExpect(jsonPath("$.data.accounts[0].hasSyncInProgress").value(false))
    }

    @Test
    fun `requestRefreshAndWait returns last status when timeout elapses`() {
        `when`(sessionService.requireCurrent()).thenReturn(FAKE_SESSION)
        // Count GetAccountsRefreshStatus invocations so we can assert the controller actually
        // polled (rather than asserting wall-clock elapsed, which flaked under CI load).
        val statusPollCount =
            java.util.concurrent.atomic
                .AtomicInteger(0)
        `when`(client.execute(anyOp(), anyOrUnit())).thenAnswer { inv ->
            when (inv.getArgument<Any>(0)) {
                ForceRefreshAccounts -> {
                    ForceRefreshAccounts.Output(success = true)
                }

                GetAccountsRefreshStatus -> {
                    statusPollCount.incrementAndGet()
                    GetRefreshStatusResponseData(
                        accounts = listOf(AccountSyncStatus(id = "a1", hasSyncInProgress = true)),
                        allComplete = false,
                    )
                }

                else -> {
                    error("unexpected op: ${inv.getArgument<Any>(0)}")
                }
            }
        }

        mvc
            .perform(post("/v1/refresh/wait?timeoutSeconds=5"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.allComplete").value(false))
            .andExpect(jsonPath("$.data.accounts[0].hasSyncInProgress").value(true))

        // Behavioral check: the controller must poll at least twice (the initial fetch +
        // at least one sleep+repoll iteration) before bailing on the deadline. This proves
        // the timeout loop ran without relying on wall-clock bounds, which flaked when CI
        // runners were loaded.
        assertThat(statusPollCount.get()).isGreaterThanOrEqualTo(2)
    }

    @Test
    fun `requestRefreshAndWait returns 503 when session missing`() {
        `when`(sessionService.requireCurrent()).thenThrow(MonarchSessionMissingException())

        mvc
            .perform(post("/v1/refresh/wait?timeoutSeconds=5"))
            .andExpect(status().isServiceUnavailable)
            .andExpect(jsonPath("$.code").value("session_missing"))
    }

    @Test
    fun `getSubscription wraps SubscriptionDetails in envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            SubscriptionDetails(
                isOnFreeTrial = false,
                hasPremiumEntitlement = true,
                id = "sub-123",
                paymentSource = "stripe",
                referralCode = null,
            ),
        )

        mvc
            .perform(get("/v1/subscription"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.isOnFreeTrial").value(false))
            .andExpect(jsonPath("$.data.hasPremiumEntitlement").value(true))
            .andExpect(jsonPath("$.data.id").value("sub-123"))
            .andExpect(jsonPath("$.data.paymentSource").value("stripe"))
    }

    @Test
    fun `getSubscription returns 503 when session missing`() {
        `when`(sessionService.requireCurrent()).thenThrow(MonarchSessionMissingException())

        mvc
            .perform(get("/v1/subscription"))
            .andExpect(status().isServiceUnavailable)
            .andExpect(jsonPath("$.code").value("session_missing"))
    }

    @Test
    fun `getCreditHistory returns snapshots array`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetCreditHistoryResponseData(
                snapshots =
                    listOf(
                        CreditScoreSnapshot(
                            reportedDate = LocalDate.parse("2026-05-01"),
                            score = 780,
                            userId = "u-1",
                        ),
                    ),
            ),
        )

        mvc
            .perform(get("/v1/credit/history"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.snapshots[0].score").value(780))
            .andExpect(jsonPath("$.data.snapshots[0].reportedDate").value("2026-05-01"))
            .andExpect(jsonPath("$.data.snapshots[0].userId").value("u-1"))
    }

    @Test
    fun `getCreditHistory returns 503 when session missing`() {
        `when`(sessionService.requireCurrent()).thenThrow(MonarchSessionMissingException())

        mvc
            .perform(get("/v1/credit/history"))
            .andExpect(status().isServiceUnavailable)
            .andExpect(jsonPath("$.code").value("session_missing"))
    }

    @Test
    fun `getWeeklyRecap wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetWeeklyRecapResponseData(
                recap =
                    WeeklyRecap(
                        id = "rec-1",
                        dateRangeStart = LocalDate.parse("2026-05-18"),
                        dateRangeEnd = LocalDate.parse("2026-05-24"),
                        summary = "Spent less than usual.",
                    ),
            ),
        )
        mvc
            .perform(get("/v1/recap/weekly").param("start", "2026-05-18").param("end", "2026-05-24"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.recap.id").value("rec-1"))
            .andExpect(jsonPath("$.data.recap.summary").value("Spent less than usual."))
            .andExpect(jsonPath("$.data.recap.dateRangeStart").value("2026-05-18"))
    }

    @Test
    fun `listFinancialInsights wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            ListFinancialInsightsResponseData(
                insights = listOf(FinancialInsight(id = "ins-1", merchantNameDisplay = "Netflix")),
                summary = FinancialInsightSummary(newCount = 3, completedCount = 2),
                latestRun = FinancialInsightRun(id = "run-1", status = "complete", insightsGeneratedCount = 4),
            ),
        )
        mvc
            .perform(get("/v1/insights").param("status", "NEW"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.insights[0].id").value("ins-1"))
            .andExpect(jsonPath("$.data.summary.newCount").value(3))
            .andExpect(jsonPath("$.data.latestRun.id").value("run-1"))
    }

    @Test
    fun `listFinancialInsights with no params returns 200`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            ListFinancialInsightsResponseData(insights = emptyList(), summary = null, latestRun = null),
        )
        mvc
            .perform(get("/v1/insights"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.insights").isArray)
    }

    @Test
    fun `getFinancialInsight wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetFinancialInsightResponseData(
                insight = FinancialInsightDetail(id = "ins-2", merchantNameDisplay = "Spotify"),
            ),
        )
        mvc
            .perform(get("/v1/insights/ins-2"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.insight.id").value("ins-2"))
            .andExpect(jsonPath("$.data.insight.merchantNameDisplay").value("Spotify"))
    }

    @Test
    fun `getLatestRefreshOperation wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetLatestRefreshOperationResponseData(
                operation = LatestRefreshOperation(id = "op-1", state = "COMPLETE"),
            ),
        )
        mvc
            .perform(get("/v1/refresh/latest"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.operation.id").value("op-1"))
            .andExpect(jsonPath("$.data.operation.state").value("COMPLETE"))
    }

    @Test
    fun `getLatestInsightRun wraps payload in data envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(
            client,
            GetLatestInsightRunResponseData(
                latestRun = LatestFinancialInsightRun(id = "run-9", status = "complete", insightsGeneratedCount = 5),
                insightsCount = 12,
            ),
        )
        mvc
            .perform(get("/v1/insights/latest-run"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.latestRun.id").value("run-9"))
            .andExpect(jsonPath("$.data.latestRun.insightsGeneratedCount").value(5))
            .andExpect(jsonPath("$.data.insightsCount").value(12))
    }

    private companion object {
        /**
         * Wall-clock ceiling for the requestRefreshAndWait timeout-path test. The spec's
         * minimum timeoutSeconds is 5, so the controller spins for ~5s before bailing; 7s
         * leaves 2s of slack for CI variability without masking a regression that hangs.
         */
        private const val TIMEOUT_TEST_MAX_MS = 7000L
    }
}
