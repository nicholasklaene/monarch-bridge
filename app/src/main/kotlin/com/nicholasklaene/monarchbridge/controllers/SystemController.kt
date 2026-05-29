package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSession
import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.generated.api.SystemApi
import com.nicholasklaene.monarchbridge.generated.model.DismissNotificationResponse
import com.nicholasklaene.monarchbridge.generated.model.GetAppVersionResponse
import com.nicholasklaene.monarchbridge.generated.model.GetAuthStatusResponse
import com.nicholasklaene.monarchbridge.generated.model.GetBetaFeaturesResponse
import com.nicholasklaene.monarchbridge.generated.model.GetCalendarEventsResponse
import com.nicholasklaene.monarchbridge.generated.model.GetCashflowReportResponse
import com.nicholasklaene.monarchbridge.generated.model.GetCategoryReportResponse
import com.nicholasklaene.monarchbridge.generated.model.GetCreditHistoryResponse
import com.nicholasklaene.monarchbridge.generated.model.GetEntitlementsResponse
import com.nicholasklaene.monarchbridge.generated.model.GetExpenseByCategoryResponse
import com.nicholasklaene.monarchbridge.generated.model.GetExpenseByMerchantResponse
import com.nicholasklaene.monarchbridge.generated.model.GetExpenseByTagResponse
import com.nicholasklaene.monarchbridge.generated.model.GetFeatureFlagsResponse
import com.nicholasklaene.monarchbridge.generated.model.GetFinancialInsightResponse
import com.nicholasklaene.monarchbridge.generated.model.GetHealthResponse
import com.nicholasklaene.monarchbridge.generated.model.GetIncomeReportResponse
import com.nicholasklaene.monarchbridge.generated.model.GetIncomeVsExpenseYoyResponse
import com.nicholasklaene.monarchbridge.generated.model.GetIntegrationStatusResponse
import com.nicholasklaene.monarchbridge.generated.model.GetLatestInsightRunResponse
import com.nicholasklaene.monarchbridge.generated.model.GetLatestRefreshOperationResponse
import com.nicholasklaene.monarchbridge.generated.model.GetLookupResponse
import com.nicholasklaene.monarchbridge.generated.model.GetMonthlyReportSummaryResponse
import com.nicholasklaene.monarchbridge.generated.model.GetNetWorthReportResponse
import com.nicholasklaene.monarchbridge.generated.model.GetNotificationsResponse
import com.nicholasklaene.monarchbridge.generated.model.GetPlatformConfigResponse
import com.nicholasklaene.monarchbridge.generated.model.GetPlusTierAccessResponse
import com.nicholasklaene.monarchbridge.generated.model.GetRefreshStatusResponse
import com.nicholasklaene.monarchbridge.generated.model.GetSavingsRateReportResponse
import com.nicholasklaene.monarchbridge.generated.model.GetSavingsRateTrendsResponse
import com.nicholasklaene.monarchbridge.generated.model.GetSpendingReportResponse
import com.nicholasklaene.monarchbridge.generated.model.GetSubscriptionDetailsResponse
import com.nicholasklaene.monarchbridge.generated.model.GetSubscriptionInvoicesResponse
import com.nicholasklaene.monarchbridge.generated.model.GetSubscriptionReceiptsResponse
import com.nicholasklaene.monarchbridge.generated.model.GetSubscriptionResponse
import com.nicholasklaene.monarchbridge.generated.model.GetTagReportResponse
import com.nicholasklaene.monarchbridge.generated.model.GetWeeklyRecapResponse
import com.nicholasklaene.monarchbridge.generated.model.GetZestimateRequest
import com.nicholasklaene.monarchbridge.generated.model.GetZestimateResponse
import com.nicholasklaene.monarchbridge.generated.model.InitiatePasswordChangeResponse
import com.nicholasklaene.monarchbridge.generated.model.ListFinancialInsightsResponse
import com.nicholasklaene.monarchbridge.generated.model.MarkAllNotificationsAsReadResponse
import com.nicholasklaene.monarchbridge.generated.model.MarkNotificationAsReadResponse
import com.nicholasklaene.monarchbridge.generated.model.MarkTransactionStreamAsNotRecurringResponse
import com.nicholasklaene.monarchbridge.generated.model.PauseSubscriptionRequest
import com.nicholasklaene.monarchbridge.generated.model.PauseSubscriptionResponse
import com.nicholasklaene.monarchbridge.generated.model.PreviewSubscriptionPlanChangeRequest
import com.nicholasklaene.monarchbridge.generated.model.PreviewSubscriptionPlanChangeResponse
import com.nicholasklaene.monarchbridge.generated.model.ResumeSubscriptionResponse
import com.nicholasklaene.monarchbridge.graphql.MonarchClient
import com.nicholasklaene.monarchbridge.graphql.operations.system.ClearAllNotifications
import com.nicholasklaene.monarchbridge.graphql.operations.system.DismissNotification
import com.nicholasklaene.monarchbridge.graphql.operations.system.ForceRefreshAccounts
import com.nicholasklaene.monarchbridge.graphql.operations.system.GetAccountsRefreshStatus
import com.nicholasklaene.monarchbridge.graphql.operations.system.GetAppVersion
import com.nicholasklaene.monarchbridge.graphql.operations.system.GetBetaFeatures
import com.nicholasklaene.monarchbridge.graphql.operations.system.GetCalendarEvents
import com.nicholasklaene.monarchbridge.graphql.operations.system.GetCashflowReport
import com.nicholasklaene.monarchbridge.graphql.operations.system.GetCategoryReport
import com.nicholasklaene.monarchbridge.graphql.operations.system.GetCommandPaletteEntities
import com.nicholasklaene.monarchbridge.graphql.operations.system.GetCreditHistory
import com.nicholasklaene.monarchbridge.graphql.operations.system.GetEntitlements
import com.nicholasklaene.monarchbridge.graphql.operations.system.GetExpenseByCategory
import com.nicholasklaene.monarchbridge.graphql.operations.system.GetExpenseByMerchant
import com.nicholasklaene.monarchbridge.graphql.operations.system.GetExpenseByTag
import com.nicholasklaene.monarchbridge.graphql.operations.system.GetFeatureFlags
import com.nicholasklaene.monarchbridge.graphql.operations.system.GetFinancialInsight
import com.nicholasklaene.monarchbridge.graphql.operations.system.GetFinancialInsights
import com.nicholasklaene.monarchbridge.graphql.operations.system.GetIncomeReport
import com.nicholasklaene.monarchbridge.graphql.operations.system.GetIncomeVsExpenseYoy
import com.nicholasklaene.monarchbridge.graphql.operations.system.GetIntegrationStatus
import com.nicholasklaene.monarchbridge.graphql.operations.system.GetLatestInsightRun
import com.nicholasklaene.monarchbridge.graphql.operations.system.GetLatestRefreshOperation
import com.nicholasklaene.monarchbridge.graphql.operations.system.GetMonthlyReportSummary
import com.nicholasklaene.monarchbridge.graphql.operations.system.GetNetWorthReport
import com.nicholasklaene.monarchbridge.graphql.operations.system.GetNotifications
import com.nicholasklaene.monarchbridge.graphql.operations.system.GetPlatformConfig
import com.nicholasklaene.monarchbridge.graphql.operations.system.GetPlusTierAccess
import com.nicholasklaene.monarchbridge.graphql.operations.system.GetSavingsRateReport
import com.nicholasklaene.monarchbridge.graphql.operations.system.GetSavingsRateTrends
import com.nicholasklaene.monarchbridge.graphql.operations.system.GetSpendingReport
import com.nicholasklaene.monarchbridge.graphql.operations.system.GetSubscriptionDetails
import com.nicholasklaene.monarchbridge.graphql.operations.system.GetSubscriptionFullDetails
import com.nicholasklaene.monarchbridge.graphql.operations.system.GetSubscriptionInvoices
import com.nicholasklaene.monarchbridge.graphql.operations.system.GetSubscriptionReceipts
import com.nicholasklaene.monarchbridge.graphql.operations.system.GetTagReport
import com.nicholasklaene.monarchbridge.graphql.operations.system.GetWeeklyRecap
import com.nicholasklaene.monarchbridge.graphql.operations.system.GetZestimate
import com.nicholasklaene.monarchbridge.graphql.operations.system.InitiatePasswordChange
import com.nicholasklaene.monarchbridge.graphql.operations.system.MarkAllNotificationsAsRead
import com.nicholasklaene.monarchbridge.graphql.operations.system.MarkNotificationAsRead
import com.nicholasklaene.monarchbridge.graphql.operations.system.PauseSubscription
import com.nicholasklaene.monarchbridge.graphql.operations.system.PreviewSubscriptionPlanChange
import com.nicholasklaene.monarchbridge.graphql.operations.system.ResumeSubscription
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate
import java.time.ZoneOffset

/**
 * Health, auth, and Plaid-refresh — cross-cutting endpoints not tied to a domain resource.
 *
 * All HTTP mapping (path, method, status codes, parameter binding, response shapes) is
 * inherited from the spec-generated [SystemApi] interface. This class only supplies the
 * `how`: gating on a session, dispatching the GraphQL op, wrapping the typed payload in
 * the matching spec-generated `*Response` envelope.
 *
 *  GET  /healthz          getHealth      — health + auth status (no session required)
 *  GET  /v1/auth/status   getAuthStatus  — session presence (no session required)
 *  POST /v1/auth/refresh  refreshAuth    — reload session JSON from disk
 *  POST /v1/refresh       requestRefresh — ask Monarch to re-poll Plaid → 202
 *  GET  /v1/refresh/status getRefreshStatus
 *  GET  /v1/subscription   getSubscription
 *  GET  /v1/credit/history getCreditHistory
 */
@RestController
@Suppress("TooManyFunctions", "LargeClass")
class SystemController(
    sessionService: MonarchSessionService,
    client: MonarchClient,
) : MonarchControllerBase(sessionService, client),
    SystemApi {
    /**
     * Poll interval for [requestRefreshAndWait]. Injected via @Value so WebMvcTests can
     * shrink it (e.g. 50ms) and the timeout-path test runs in well under a second. Defaults
     * to 2000ms in prod, matching the cadence the CLI uses today.
     */
    @Value("\${monarch.refresh.poll-interval-ms:2000}")
    private var pollIntervalMs: Long = 2000L

    override fun getHealth(): ResponseEntity<GetHealthResponse> {
        val session = sessionService.current()
        return ResponseEntity.ok(
            GetHealthResponse(
                status = "UP",
                authenticated = session != null,
                lastVerifiedAt = session?.lastVerifiedAt?.atOffset(ZoneOffset.UTC),
            ),
        )
    }

    override fun getAuthStatus(): ResponseEntity<GetAuthStatusResponse> = ResponseEntity.ok(toAuthStatus(sessionService.current()))

    override fun refreshAuth(): ResponseEntity<GetAuthStatusResponse> = ResponseEntity.ok(toAuthStatus(sessionService.reload()))

    override fun requestRefresh(accountIds: List<String>?): ResponseEntity<Unit> {
        sessionService.requireCurrent()
        client.execute(ForceRefreshAccounts, ForceRefreshAccounts.Input(accountIds.orEmpty()))
        return ResponseEntity.accepted().build()
    }

    /**
     * Pure server-side composite over [ForceRefreshAccounts] + [GetAccountsRefreshStatus]:
     * fire the refresh, then poll until every account reports `hasSyncInProgress=false` or
     * the per-request deadline elapses. Returns the last-seen status either way.
     */
    override fun requestRefreshAndWait(
        timeoutSeconds: Int,
        accountIds: List<String>?,
    ): ResponseEntity<GetRefreshStatusResponse> {
        sessionService.requireCurrent()
        client.execute(ForceRefreshAccounts, ForceRefreshAccounts.Input(accountIds.orEmpty()))

        val deadline = System.currentTimeMillis() + timeoutSeconds * MILLIS_PER_SECOND
        var lastStatus = client.execute(GetAccountsRefreshStatus, Unit)
        while (!lastStatus.allComplete && System.currentTimeMillis() < deadline) {
            Thread.sleep(pollIntervalMs)
            lastStatus = client.execute(GetAccountsRefreshStatus, Unit)
        }
        return ResponseEntity.ok(GetRefreshStatusResponse(data = lastStatus))
    }

    /** Per-account `hasSyncInProgress` flags — poll after /v1/refresh until allComplete=true. */
    override fun getRefreshStatus(): ResponseEntity<GetRefreshStatusResponse> =
        ResponseEntity.ok(GetRefreshStatusResponse(data = exec(GetAccountsRefreshStatus, Unit)))

    /** Monarch subscription tier + payment source. */
    override fun getSubscription(): ResponseEntity<GetSubscriptionResponse> =
        ResponseEntity.ok(GetSubscriptionResponse(data = exec(GetSubscriptionDetails, Unit)))

    /** Credit-score snapshots (Spinwheel integration; empty if not enabled). */
    override fun getCreditHistory(): ResponseEntity<GetCreditHistoryResponse> =
        ResponseEntity.ok(GetCreditHistoryResponse(data = exec(GetCreditHistory, Unit)))

    /** AI-generated weekly recap (summary + per-module cards). Recap is null if Monarch hasn't generated one for the window. */
    override fun getWeeklyRecap(
        start: LocalDate,
        end: LocalDate,
    ): ResponseEntity<GetWeeklyRecapResponse> =
        ResponseEntity.ok(
            GetWeeklyRecapResponse(
                data = exec(GetWeeklyRecap, GetWeeklyRecap.Input(startDate = start, endDate = end)),
            ),
        )

    /** AI-driven savings opportunities + summary + latest-run metadata. Filter by `status` to narrow. */
    override fun listFinancialInsights(
        status: List<String>?,
        summaryStart: LocalDate?,
        summaryEnd: LocalDate?,
    ): ResponseEntity<ListFinancialInsightsResponse> =
        ResponseEntity.ok(
            ListFinancialInsightsResponse(
                data =
                    exec(
                        GetFinancialInsights,
                        GetFinancialInsights.Input(
                            statuses = status?.takeIf { it.isNotEmpty() },
                            summaryStartDate = summaryStart,
                            summaryEndDate = summaryEnd,
                        ),
                    ),
            ),
        )

    /** Single insight detail including DIY playbook steps. */
    override fun getFinancialInsight(id: String): ResponseEntity<GetFinancialInsightResponse> =
        ResponseEntity.ok(
            GetFinancialInsightResponse(data = exec(GetFinancialInsight, GetFinancialInsight.Input(id = id))),
        )

    /** Latest global force-refresh op (id + state). Lightweight alternative to per-account refresh-status. */
    override fun getLatestRefreshOperation(): ResponseEntity<GetLatestRefreshOperationResponse> =
        ResponseEntity.ok(GetLatestRefreshOperationResponse(data = exec(GetLatestRefreshOperation, Unit)))

    /** Latest financial-insight run metadata (id, status, generated count) + total insights count. */
    override fun getLatestInsightRun(): ResponseEntity<GetLatestInsightRunResponse> =
        ResponseEntity.ok(GetLatestInsightRunResponse(data = exec(GetLatestInsightRun, Unit)))

    /** Command-palette semantic search across accounts, categories, tags, and merchants. */
    override fun getLookup(q: String): ResponseEntity<GetLookupResponse> =
        ResponseEntity.ok(GetLookupResponse(data = exec(GetCommandPaletteEntities, GetCommandPaletteEntities.Input(query = q))))

    /** Subscription entitlement keys (Plus-feature gating). */
    override fun getEntitlements(): ResponseEntity<GetEntitlementsResponse> =
        ResponseEntity.ok(GetEntitlementsResponse(data = exec(GetEntitlements, Unit)))

    /** Subscription entitlements plus Plus-trial window timestamps. */
    override fun getPlusTierAccess(): ResponseEntity<GetPlusTierAccessResponse> =
        ResponseEntity.ok(GetPlusTierAccessResponse(data = exec(GetPlusTierAccess, Unit)))

    /** Paginated activity-event stream (in-app notification bell). */
    override fun getNotifications(
        first: Int,
        afterCursor: String?,
    ): ResponseEntity<GetNotificationsResponse> =
        ResponseEntity.ok(
            GetNotificationsResponse(
                data = exec(GetNotifications, GetNotifications.Input(first = first, afterCursor = afterCursor)),
            ),
        )

    /** Flip `readAt=now` on a single activity event. */
    override fun markNotificationAsRead(id: String): ResponseEntity<MarkNotificationAsReadResponse> =
        ResponseEntity.ok(
            MarkNotificationAsReadResponse(data = exec(MarkNotificationAsRead, MarkNotificationAsRead.Input(id = id))),
        )

    /** Hide a single activity event from the bell. */
    override fun dismissNotification(id: String): ResponseEntity<DismissNotificationResponse> =
        ResponseEntity.ok(
            DismissNotificationResponse(data = exec(DismissNotification, DismissNotification.Input(id = id))),
        )

    /** Bulk-flip `readAt` for the first N activity events. */
    override fun markAllNotificationsAsRead(first: Int): ResponseEntity<MarkAllNotificationsAsReadResponse> =
        ResponseEntity.ok(
            MarkAllNotificationsAsReadResponse(
                data = exec(MarkAllNotificationsAsRead, MarkAllNotificationsAsRead.Input(first = first)),
            ),
        )

    /** Bulk-dismiss every activity event. */
    override fun clearAllNotifications(): ResponseEntity<MarkTransactionStreamAsNotRecurringResponse> =
        ResponseEntity.ok(
            MarkTransactionStreamAsNotRecurringResponse(data = exec(ClearAllNotifications, Unit)),
        )

    /** Zillow Zestimate lookup for a free-form address. */
    override fun getZestimate(getZestimateRequest: GetZestimateRequest): ResponseEntity<GetZestimateResponse> =
        ResponseEntity.ok(
            GetZestimateResponse(data = exec(GetZestimate, GetZestimate.Input.from(getZestimateRequest))),
        )

    /** Spending vs. budget summary plus top-N category breakdown (web Reports page). */
    override fun getSpendingReport(
        start: LocalDate?,
        end: LocalDate?,
    ): ResponseEntity<GetSpendingReportResponse> =
        ResponseEntity.ok(
            GetSpendingReportResponse(
                data = exec(GetSpendingReport, GetSpendingReport.Input(startDate = start, endDate = end)),
            ),
        )

    /** Income breakdown with per-source split (web Reports page, Income tab). */
    override fun getIncomeReport(
        start: LocalDate?,
        end: LocalDate?,
    ): ResponseEntity<GetIncomeReportResponse> =
        ResponseEntity.ok(
            GetIncomeReportResponse(
                data = exec(GetIncomeReport, GetIncomeReport.Input(startDate = start, endDate = end)),
            ),
        )

    /** Net-worth chart series for the requested window plus starting / current totals. */
    override fun getNetWorthReport(
        start: LocalDate?,
        end: LocalDate?,
    ): ResponseEntity<GetNetWorthReportResponse> =
        ResponseEntity.ok(
            GetNetWorthReportResponse(
                data = exec(GetNetWorthReport, GetNetWorthReport.Input(startDate = start, endDate = end)),
            ),
        )

    /** Month-over-month savings rate report (fractions; `0.42` = 42%). */
    override fun getSavingsRateReport(
        start: LocalDate?,
        end: LocalDate?,
    ): ResponseEntity<GetSavingsRateReportResponse> =
        ResponseEntity.ok(
            GetSavingsRateReportResponse(
                data = exec(GetSavingsRateReport, GetSavingsRateReport.Input(startDate = start, endDate = end)),
            ),
        )

    /** Monthly-recap summary bundle (single-month aggregate). */
    override fun getMonthlyReportSummary(month: LocalDate): ResponseEntity<GetMonthlyReportSummaryResponse> =
        ResponseEntity.ok(
            GetMonthlyReportSummaryResponse(
                data = exec(GetMonthlyReportSummary, GetMonthlyReportSummary.Input(month = month)),
            ),
        )

    /** Bills + recurring + paychecks projected onto a calendar shape. */
    override fun getCalendarEvents(
        start: LocalDate?,
        end: LocalDate?,
    ): ResponseEntity<GetCalendarEventsResponse> =
        ResponseEntity.ok(
            GetCalendarEventsResponse(
                data = exec(GetCalendarEvents, GetCalendarEvents.Input(startDate = start, endDate = end)),
            ),
        )

    /** Full cashflow report: totals + per-month series. */
    override fun getCashflowReport(
        start: LocalDate?,
        end: LocalDate?,
    ): ResponseEntity<GetCashflowReportResponse> =
        ResponseEntity.ok(
            GetCashflowReportResponse(
                data = exec(GetCashflowReport, GetCashflowReport.Input(startDate = start, endDate = end)),
            ),
        )

    /** Per-month sum series for one category. */
    override fun getCategoryReport(
        categoryId: String,
        start: LocalDate?,
        end: LocalDate?,
    ): ResponseEntity<GetCategoryReportResponse> =
        ResponseEntity.ok(
            GetCategoryReportResponse(
                data =
                    exec(
                        GetCategoryReport,
                        GetCategoryReport.Input(categoryId = categoryId, startDate = start, endDate = end),
                    ),
            ),
        )

    /** Per-month sum + count series for one transaction tag. */
    override fun getTagReport(
        tagId: String,
        start: LocalDate?,
        end: LocalDate?,
    ): ResponseEntity<GetTagReportResponse> =
        ResponseEntity.ok(
            GetTagReportResponse(
                data =
                    exec(
                        GetTagReport,
                        GetTagReport.Input(tagId = tagId, startDate = start, endDate = end),
                    ),
            ),
        )

    /** Billing-history rows from the subscription system. */
    override fun getSubscriptionInvoices(): ResponseEntity<GetSubscriptionInvoicesResponse> =
        ResponseEntity.ok(GetSubscriptionInvoicesResponse(data = exec(GetSubscriptionInvoices, Unit)))

    /** Per-credential provider health (Plaid / MX / Finicity). */
    override fun getIntegrationStatus(): ResponseEntity<GetIntegrationStatusResponse> =
        ResponseEntity.ok(GetIntegrationStatusResponse(data = exec(GetIntegrationStatus, Unit)))

    /** Full subscription detail bundle - tier, status, renewal date, billing frequency. */
    override fun getSubscriptionDetails(): ResponseEntity<GetSubscriptionDetailsResponse> =
        ResponseEntity.ok(GetSubscriptionDetailsResponse(data = exec(GetSubscriptionFullDetails, Unit)))

    /** Pause the subscription. Optional body sets resume date / reason. */
    override fun pauseSubscription(pauseSubscriptionRequest: PauseSubscriptionRequest?): ResponseEntity<PauseSubscriptionResponse> =
        ResponseEntity.ok(
            PauseSubscriptionResponse(data = exec(PauseSubscription, PauseSubscription.Input.from(pauseSubscriptionRequest))),
        )

    /** Resume a paused subscription immediately. */
    override fun resumeSubscription(): ResponseEntity<ResumeSubscriptionResponse> =
        ResponseEntity.ok(ResumeSubscriptionResponse(data = exec(ResumeSubscription, Unit)))

    /** Subscription receipts (issue date, amount, currency, download URL). */
    override fun getSubscriptionReceipts(): ResponseEntity<GetSubscriptionReceiptsResponse> =
        ResponseEntity.ok(GetSubscriptionReceiptsResponse(data = exec(GetSubscriptionReceipts, Unit)))

    /** Preview the prorated charge for a tier change without committing. */
    override fun previewSubscriptionPlanChange(
        previewSubscriptionPlanChangeRequest: PreviewSubscriptionPlanChangeRequest,
    ): ResponseEntity<PreviewSubscriptionPlanChangeResponse> =
        ResponseEntity.ok(
            PreviewSubscriptionPlanChangeResponse(
                data = exec(PreviewSubscriptionPlanChange, PreviewSubscriptionPlanChange.Input.from(previewSubscriptionPlanChangeRequest)),
            ),
        )

    /** Current / minimum / recommended app version (for "please update" prompts). */
    override fun getAppVersion(): ResponseEntity<GetAppVersionResponse> =
        ResponseEntity.ok(GetAppVersionResponse(data = exec(GetAppVersion, Unit)))

    /** Active feature flags + variants for the current user / device. */
    override fun getFeatureFlags(): ResponseEntity<GetFeatureFlagsResponse> =
        ResponseEntity.ok(GetFeatureFlagsResponse(data = exec(GetFeatureFlags, Unit)))

    /** Platform-config bundle for native clients. */
    override fun getPlatformConfig(): ResponseEntity<GetPlatformConfigResponse> =
        ResponseEntity.ok(GetPlatformConfigResponse(data = exec(GetPlatformConfig, Unit)))

    /** Beta-program features the user is eligible to enroll in. */
    override fun getBetaFeatures(): ResponseEntity<GetBetaFeaturesResponse> =
        ResponseEntity.ok(GetBetaFeaturesResponse(data = exec(GetBetaFeatures, Unit)))

    /** Expense rollup grouped by category. */
    override fun getExpenseByCategory(
        start: LocalDate?,
        end: LocalDate?,
    ): ResponseEntity<GetExpenseByCategoryResponse> =
        ResponseEntity.ok(
            GetExpenseByCategoryResponse(
                data = exec(GetExpenseByCategory, GetExpenseByCategory.Input(startDate = start, endDate = end)),
            ),
        )

    /** Expense rollup grouped by merchant. */
    override fun getExpenseByMerchant(
        start: LocalDate?,
        end: LocalDate?,
    ): ResponseEntity<GetExpenseByMerchantResponse> =
        ResponseEntity.ok(
            GetExpenseByMerchantResponse(
                data = exec(GetExpenseByMerchant, GetExpenseByMerchant.Input(startDate = start, endDate = end)),
            ),
        )

    /** Expense rollup grouped by transaction tag. */
    override fun getExpenseByTag(
        start: LocalDate?,
        end: LocalDate?,
    ): ResponseEntity<GetExpenseByTagResponse> =
        ResponseEntity.ok(
            GetExpenseByTagResponse(
                data = exec(GetExpenseByTag, GetExpenseByTag.Input(startDate = start, endDate = end)),
            ),
        )

    /** Year-over-year income vs. expense series. */
    override fun getIncomeVsExpenseYoy(years: Int): ResponseEntity<GetIncomeVsExpenseYoyResponse> =
        ResponseEntity.ok(
            GetIncomeVsExpenseYoyResponse(data = exec(GetIncomeVsExpenseYoy, GetIncomeVsExpenseYoy.Input(years = years))),
        )

    /** Savings-rate trend points over the last N months. */
    override fun getSavingsRateTrends(months: Int): ResponseEntity<GetSavingsRateTrendsResponse> =
        ResponseEntity.ok(
            GetSavingsRateTrendsResponse(data = exec(GetSavingsRateTrends, GetSavingsRateTrends.Input(months = months))),
        )

    /** Kick off Monarch's password-change flow. No body required; Monarch emails a reset link. */
    override fun initiatePasswordChange(): ResponseEntity<InitiatePasswordChangeResponse> =
        ResponseEntity.ok(InitiatePasswordChangeResponse(data = exec(InitiatePasswordChange, Unit)))

    private fun toAuthStatus(session: MonarchSession?): GetAuthStatusResponse =
        GetAuthStatusResponse(
            authenticated = session != null,
            email = session?.email,
            lastVerifiedAt = session?.lastVerifiedAt?.atOffset(ZoneOffset.UTC),
        )

    private companion object {
        private const val MILLIS_PER_SECOND = 1000L
    }
}
