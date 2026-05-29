package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.generated.api.WebScreensApi
import com.nicholasklaene.monarchbridge.generated.model.WebScreenAggregateRequest
import com.nicholasklaene.monarchbridge.generated.model.WebScreenAggregateResponse
import com.nicholasklaene.monarchbridge.graphql.MonarchClient
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebAccountDetailsRouterGetAccountType
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebAccountEditModal
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebAccountFilterQuery
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebAccountsMessageBlock
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebAdvisorPortalGetSubscription
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebAnswerQuestionMutation
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebAssignTaxScheduleCategoryMapping
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebBudgetOnboardingGetAccounts
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebCancelSponsorship
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebChangeSubscription
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebClearAllMutation
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebConfirmTotpDevice
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebConvertEmployeeTrial
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebCopySnapshots
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebCreateAIReport
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebCreateAdvisorSubscription
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebCreateCoinbaseAccount
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebCreateEquityAccountWithGrants
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebCreateFeedbackEvent
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebCreatePromoCodeCheckoutSession
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebCreateSpinwheelAccountMapping
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebCreateSubscription
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebCreateSubscriptionSponsorshipInvites
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebCreateUnconfirmedTotpDevice
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebCreateZillowAccount
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebDeleteAccountLogo
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebDeleteAllGoalReconciliationRecords
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebDeleteAllTransactionRulesMutation
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebDeleteTaxScheduleCategoryMapping
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebDeleteUserFromHousehold
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebDirectLinkAccountSelectDataProvider
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebDisableMfa
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebDisconnectCredentialMutation
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebDisconnectDiscord
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebDiscordOAuthCallback
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebEmployeeMenuDeleteCreditScoreSnapshots
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebEmployeeMenuGetFinancialInsightIds
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebEmployeeMenuResetAiAssistantOptIn
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebEmployeeMenuSoftDeleteFinancialInsight
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebEquityAccountDetailsGetAccount
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebEquityAccountDetailsGetLinkedAccount
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebExtendFreeTrialDuration
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGenerateReportName
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGetAccount
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGetAccountTypes
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGetAccountsForTransfer
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGetAccountsPage
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGetAccountsPageRecentBalance
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGetAdvisorClientsPage
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGetAdvisorProfilePage
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGetBalanceHistoryParserColumns
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGetBusinessSetupPriorTracking
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGetCancellationReasonsWithSubreasons
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGetCategorizationDetails
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGetCategoryGroupDetails
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGetCategorySelectOptions
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGetConnectedApps
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGetContactSupportFormData
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGetDiscordConnectionRedirectUrl
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGetDownloadScheduleCSession
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGetEventPopoverTransactions
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGetFilteredAccounts
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGetFlexibleGroupRolloverSettings
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGetGiftedSubscriptionsForPolling
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGetInvestmentsAccounts
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGetInvestmentsDashboardCard
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGetInvestmentsHoldingDrawerHistoricalPerformance
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGetMeCollaborationProfileStep
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGetMerchantSelectHouseholdMerchants
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGetMerchantSelectRecommendedMerchants
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGetMerchantSelectTransactionDetails
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGetMerchantSettingsPage
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGetPlanRecommendationData
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGetPortfolio
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGetPortfolioWithClassification
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGetRecommendedCategories
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGetScheduleCLineItems
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGetSecuritiesHistoricalPerformance
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGetSecuritySettings
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGetSidebarData
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGetStatementParserColumns
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGetSubscription
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGetSubscriptionModal
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGetTaxPrepCategoryTransactions
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGetTaxPrepUnmappedCategoryTransactions
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGetTopInstitutionGroupByType
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGetTransactionFiltersMetadata
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGetTransactionsPage
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGetTransactionsSummaryCard
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGetTrustAndWillSubscription
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGetUserDismissedRetailSyncBanner
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGetUserHasConfiguredExtension
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGetUserPlatforms
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGiveEmployeeInfinitePlusAccess
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGiveEmployeeInfinitePremiumAccess
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGoalDetailV2
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGoalSelectGoals
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGoalSelectTransaction
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGoalsAllocateBalanceModal
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGoalsAllocationCardAccounts
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGoalsDashboardCardV2
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGoalsMapAccounts
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGoalsMapAccountsModal
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGoalsMessageBlock
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGoalsMonthlyBudgets
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebGoalsV2
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebImportStatementGetAccount
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebInitScheduleCDefaultMappings
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebInviteEmail
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebMigrateHouseholdToSavingGoals
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebMintTransactionsCountQuery
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebMonthlyBudgetGoalsModal
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebMoveMoneyMutation
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebOnboardingTopInstitutions
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebParseUploadStatementSession
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebPlusUpgradeTrial
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebPreTaxBudgetGoalsList
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebPreviewAccountDataTransferSnapshots
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebPreviewAccountDataTransferTransactions
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebPreviewCopySnapshots
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebRankGoalsList
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebReactivateSubscription
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebRecalculateBudgetMutation
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebRecommendedAccountDataTransferDates
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebRecommendedAccounts
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebRecurringFilterQuery
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebRecurringPausedBanner
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebRemoveEmployeeEntitlements
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebResetAndSyncAccountMutation
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebResetCategorizationMemory
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebResetEmployeeAndSubscribe
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebResetEmployeeToNoSubscription
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebResetHouseholdRecurringMerchantSearch
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebResetRolloverMutation
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebResetWeeklyRecapMutation
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebRestoreCategory
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebReviewStream
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebRevokeConnectedApp
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebRevokeSponsorshipInvite
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebSearchInstitutionsQuery
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebSearchMerchants
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebSearchSecurities
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebSetEmployeeActiveSubscription
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebSetEmployeeCancellationDiscountUsed
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebSetEmployeeExpiredTrial
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebSetEmployeePlusTrialFields
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebSetEmployeeSubscriptionEnded
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebSnapshotsForAccountCopyBalancePreview
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebStartDownloadScheduleCSession
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebSyncEmployeeSubscription
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebTargetAmountsGoalsList
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebTestCreditScoreChangedNotification
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebToggleSupportAccountAccess
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebTransactionDrawerDeleteAttachment
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebTransactionsFilterQuery
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebTransactionsMessageBlock
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebUndoSavingsGoalMigration
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebUnmatchRetailTransaction
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebUpdateAccountOrder
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebUpdateBusinessTrackingSetupIntent
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebUpdateCategory
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebUpdateCategoryFromBudgetOnboarding
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebUpdateCategoryGroupOrder
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebUpdateCategoryOrder
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebUpdateCompany
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebUpdateDismissedRetailSyncBanner
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebUpdateGoalsPriorities
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebUpdateOrCreateAdvisorStripePaymentMethod
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebUpdateOrCreateStripePaymentMethod
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebUpdateRenewalReminder
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebUpdateRuleOrderMutation
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebUpdateSubscriptionSponsor
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebUpdateTransactionOverview
import com.nicholasklaene.monarchbridge.graphql.operations.web.WebUpdateUserFinancialProfile
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

/**
 * Wraps every `Web_*` screen-aggregate GraphQL operation in Monarch's web bundle that
 * doesn't fit cleanly into a typed resource controller. One method per upstream op;
 * each forwards the request body's `variables` map as-is and returns the raw `data`
 * tree wrapped in a FreeForm envelope.
 *
 * These endpoints are wiring-only: shape is volatile across Monarch releases. Use the
 * typed resource controllers (Account/Transaction/Budget/...) when one covers the
 * same field; reach for these when no typed equivalent exists.
 *
 * All HTTP mapping (path, method, status codes, parameter binding, response shape) is
 * inherited from the spec-generated [WebScreensApi] interface.
 */
@RestController
@Suppress("LargeClass", "TooManyFunctions")
class WebScreensController(
    sessionService: MonarchSessionService,
    client: MonarchClient,
) : MonarchControllerBase(sessionService, client),
    WebScreensApi {
    /** `Web_AccountDetailsRouter_getAccountType` (query) pass-through. */
    override fun webAccountDetailsRouterGetAccountType(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebAccountDetailsRouterGetAccountType,
                        WebAccountDetailsRouterGetAccountType.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_AccountEditModal` (query) pass-through. */
    override fun webAccountEditModal(webScreenAggregateRequest: WebScreenAggregateRequest?): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebAccountEditModal, WebAccountEditModal.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_AccountFilterQuery` (query) pass-through. */
    override fun webAccountFilterQuery(webScreenAggregateRequest: WebScreenAggregateRequest?): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebAccountFilterQuery, WebAccountFilterQuery.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_AccountsMessageBlock` (query) pass-through. */
    override fun webAccountsMessageBlock(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebAccountsMessageBlock, WebAccountsMessageBlock.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_AdvisorPortalGetSubscription` (query) pass-through. */
    override fun webAdvisorPortalGetSubscription(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebAdvisorPortalGetSubscription,
                        WebAdvisorPortalGetSubscription.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_AnswerQuestionMutation` (mutation) pass-through. */
    override fun webAnswerQuestionMutation(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebAnswerQuestionMutation, WebAnswerQuestionMutation.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_AssignTaxScheduleCategoryMapping` (mutation) pass-through. */
    override fun webAssignTaxScheduleCategoryMapping(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebAssignTaxScheduleCategoryMapping,
                        WebAssignTaxScheduleCategoryMapping.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_BudgetOnboardingGetAccounts` (query) pass-through. */
    override fun webBudgetOnboardingGetAccounts(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebBudgetOnboardingGetAccounts,
                        WebBudgetOnboardingGetAccounts.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_CancelSponsorship` (mutation) pass-through. */
    override fun webCancelSponsorship(webScreenAggregateRequest: WebScreenAggregateRequest?): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebCancelSponsorship, WebCancelSponsorship.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_ChangeSubscription` (mutation) pass-through. */
    override fun webChangeSubscription(webScreenAggregateRequest: WebScreenAggregateRequest?): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebChangeSubscription, WebChangeSubscription.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_ClearAllMutation` (mutation) pass-through. */
    override fun webClearAllMutation(webScreenAggregateRequest: WebScreenAggregateRequest?): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebClearAllMutation, WebClearAllMutation.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_ConvertEmployeeTrial` (mutation) pass-through. */
    override fun webConvertEmployeeTrial(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebConvertEmployeeTrial, WebConvertEmployeeTrial.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_CopySnapshots` (mutation) pass-through. */
    override fun webCopySnapshots(webScreenAggregateRequest: WebScreenAggregateRequest?): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebCopySnapshots, WebCopySnapshots.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_CreateAIReport` (mutation) pass-through. */
    override fun webCreateAIReport(webScreenAggregateRequest: WebScreenAggregateRequest?): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebCreateAIReport, WebCreateAIReport.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_CreateAdvisorSubscription` (mutation) pass-through. */
    override fun webCreateAdvisorSubscription(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebCreateAdvisorSubscription,
                        WebCreateAdvisorSubscription.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_CreateCoinbaseAccount` (mutation) pass-through. */
    override fun webCreateCoinbaseAccount(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebCreateCoinbaseAccount, WebCreateCoinbaseAccount.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_CreateEquityAccountWithGrants` (mutation) pass-through. */
    override fun webCreateEquityAccountWithGrants(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebCreateEquityAccountWithGrants,
                        WebCreateEquityAccountWithGrants.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_CreateFeedbackEvent` (mutation) pass-through. */
    override fun webCreateFeedbackEvent(webScreenAggregateRequest: WebScreenAggregateRequest?): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebCreateFeedbackEvent, WebCreateFeedbackEvent.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_CreatePromoCodeCheckoutSession` (mutation) pass-through. */
    override fun webCreatePromoCodeCheckoutSession(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebCreatePromoCodeCheckoutSession,
                        WebCreatePromoCodeCheckoutSession.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_CreateSpinwheelAccountMapping` (mutation) pass-through. */
    override fun webCreateSpinwheelAccountMapping(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebCreateSpinwheelAccountMapping,
                        WebCreateSpinwheelAccountMapping.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_CreateSubscription` (mutation) pass-through. */
    override fun webCreateSubscription(webScreenAggregateRequest: WebScreenAggregateRequest?): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebCreateSubscription, WebCreateSubscription.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_CreateSubscriptionSponsorshipInvites` (mutation) pass-through. */
    override fun webCreateSubscriptionSponsorshipInvites(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebCreateSubscriptionSponsorshipInvites,
                        WebCreateSubscriptionSponsorshipInvites.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_CreateZillowAccount` (mutation) pass-through. */
    override fun webCreateZillowAccount(webScreenAggregateRequest: WebScreenAggregateRequest?): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebCreateZillowAccount, WebCreateZillowAccount.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_DeleteAccountLogo` (mutation) pass-through. */
    override fun webDeleteAccountLogo(webScreenAggregateRequest: WebScreenAggregateRequest?): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebDeleteAccountLogo, WebDeleteAccountLogo.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_DeleteAllGoalReconciliationRecords` (mutation) pass-through. */
    override fun webDeleteAllGoalReconciliationRecords(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebDeleteAllGoalReconciliationRecords,
                        WebDeleteAllGoalReconciliationRecords.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_DeleteAllTransactionRulesMutation` (mutation) pass-through. */
    override fun webDeleteAllTransactionRulesMutation(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebDeleteAllTransactionRulesMutation,
                        WebDeleteAllTransactionRulesMutation.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_DeleteTaxScheduleCategoryMapping` (mutation) pass-through. */
    override fun webDeleteTaxScheduleCategoryMapping(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebDeleteTaxScheduleCategoryMapping,
                        WebDeleteTaxScheduleCategoryMapping.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_DeleteUserFromHousehold` (mutation) pass-through. */
    override fun webDeleteUserFromHousehold(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebDeleteUserFromHousehold, WebDeleteUserFromHousehold.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_DirectLinkAccountSelectDataProvider` (query) pass-through. */
    override fun webDirectLinkAccountSelectDataProvider(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebDirectLinkAccountSelectDataProvider,
                        WebDirectLinkAccountSelectDataProvider.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_DisableMfa` (mutation) pass-through. */
    override fun webDisableMfa(webScreenAggregateRequest: WebScreenAggregateRequest?): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebDisableMfa, WebDisableMfa.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_DisconnectCredentialMutation` (mutation) pass-through. */
    override fun webDisconnectCredentialMutation(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebDisconnectCredentialMutation,
                        WebDisconnectCredentialMutation.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_DisconnectDiscord` (mutation) pass-through. */
    override fun webDisconnectDiscord(webScreenAggregateRequest: WebScreenAggregateRequest?): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebDisconnectDiscord, WebDisconnectDiscord.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_DiscordOAuthCallback` (mutation) pass-through. */
    override fun webDiscordOAuthCallback(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebDiscordOAuthCallback, WebDiscordOAuthCallback.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_EmployeeMenuDeleteCreditScoreSnapshots` (mutation) pass-through. */
    override fun webEmployeeMenuDeleteCreditScoreSnapshots(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebEmployeeMenuDeleteCreditScoreSnapshots,
                        WebEmployeeMenuDeleteCreditScoreSnapshots.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_EmployeeMenuGetFinancialInsightIds` (query) pass-through. */
    override fun webEmployeeMenuGetFinancialInsightIds(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebEmployeeMenuGetFinancialInsightIds,
                        WebEmployeeMenuGetFinancialInsightIds.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_EmployeeMenuResetAiAssistantOptIn` (mutation) pass-through. */
    override fun webEmployeeMenuResetAiAssistantOptIn(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebEmployeeMenuResetAiAssistantOptIn,
                        WebEmployeeMenuResetAiAssistantOptIn.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_EmployeeMenuSoftDeleteFinancialInsight` (mutation) pass-through. */
    override fun webEmployeeMenuSoftDeleteFinancialInsight(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebEmployeeMenuSoftDeleteFinancialInsight,
                        WebEmployeeMenuSoftDeleteFinancialInsight.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_EquityAccountDetails_getAccount` (query) pass-through. */
    override fun webEquityAccountDetailsGetAccount(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebEquityAccountDetailsGetAccount,
                        WebEquityAccountDetailsGetAccount.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_EquityAccountDetails_getLinkedAccount` (query) pass-through. */
    override fun webEquityAccountDetailsGetLinkedAccount(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebEquityAccountDetailsGetLinkedAccount,
                        WebEquityAccountDetailsGetLinkedAccount.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_ExtendFreeTrialDuration` (mutation) pass-through. */
    override fun webExtendFreeTrialDuration(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebExtendFreeTrialDuration, WebExtendFreeTrialDuration.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_GenerateReportName` (query) pass-through. */
    override fun webGenerateReportName(webScreenAggregateRequest: WebScreenAggregateRequest?): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebGenerateReportName, WebGenerateReportName.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_GetAccount` (query) pass-through. */
    override fun webGetAccount(webScreenAggregateRequest: WebScreenAggregateRequest?): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebGetAccount, WebGetAccount.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_GetAccountTypes` (query) pass-through. */
    override fun webGetAccountTypes(webScreenAggregateRequest: WebScreenAggregateRequest?): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebGetAccountTypes, WebGetAccountTypes.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_GetAccountsForTransfer` (query) pass-through. */
    override fun webGetAccountsForTransfer(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebGetAccountsForTransfer, WebGetAccountsForTransfer.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_GetAccountsPage` (query) pass-through. */
    override fun webGetAccountsPage(webScreenAggregateRequest: WebScreenAggregateRequest?): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebGetAccountsPage, WebGetAccountsPage.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_GetAccountsPageRecentBalance` (query) pass-through. */
    override fun webGetAccountsPageRecentBalance(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebGetAccountsPageRecentBalance,
                        WebGetAccountsPageRecentBalance.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_GetAdvisorClientsPage` (query) pass-through. */
    override fun webGetAdvisorClientsPage(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebGetAdvisorClientsPage, WebGetAdvisorClientsPage.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_GetAdvisorProfilePage` (query) pass-through. */
    override fun webGetAdvisorProfilePage(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebGetAdvisorProfilePage, WebGetAdvisorProfilePage.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_GetBalanceHistoryParserColumns` (query) pass-through. */
    override fun webGetBalanceHistoryParserColumns(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebGetBalanceHistoryParserColumns,
                        WebGetBalanceHistoryParserColumns.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_GetBusinessSetupPriorTracking` (query) pass-through. */
    override fun webGetBusinessSetupPriorTracking(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebGetBusinessSetupPriorTracking,
                        WebGetBusinessSetupPriorTracking.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_GetCancellationReasonsWithSubreasons` (query) pass-through. */
    override fun webGetCancellationReasonsWithSubreasons(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebGetCancellationReasonsWithSubreasons,
                        WebGetCancellationReasonsWithSubreasons.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_GetCategorizationDetails` (query) pass-through. */
    override fun webGetCategorizationDetails(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebGetCategorizationDetails,
                        WebGetCategorizationDetails.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_GetCategoryGroupDetails` (query) pass-through. */
    override fun webGetCategoryGroupDetails(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebGetCategoryGroupDetails, WebGetCategoryGroupDetails.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_GetCategorySelectOptions` (query) pass-through. */
    override fun webGetCategorySelectOptions(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebGetCategorySelectOptions,
                        WebGetCategorySelectOptions.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_GetConnectedApps` (query) pass-through. */
    override fun webGetConnectedApps(webScreenAggregateRequest: WebScreenAggregateRequest?): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebGetConnectedApps, WebGetConnectedApps.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_GetContactSupportFormData` (query) pass-through. */
    override fun webGetContactSupportFormData(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebGetContactSupportFormData,
                        WebGetContactSupportFormData.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_GetDiscordConnectionRedirectUrl` (query) pass-through. */
    override fun webGetDiscordConnectionRedirectUrl(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebGetDiscordConnectionRedirectUrl,
                        WebGetDiscordConnectionRedirectUrl.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_GetDownloadScheduleCSession` (query) pass-through. */
    override fun webGetDownloadScheduleCSession(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebGetDownloadScheduleCSession,
                        WebGetDownloadScheduleCSession.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_GetEventPopoverTransactions` (query) pass-through. */
    override fun webGetEventPopoverTransactions(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebGetEventPopoverTransactions,
                        WebGetEventPopoverTransactions.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_GetFilteredAccounts` (query) pass-through. */
    override fun webGetFilteredAccounts(webScreenAggregateRequest: WebScreenAggregateRequest?): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebGetFilteredAccounts, WebGetFilteredAccounts.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_GetFlexibleGroupRolloverSettings` (query) pass-through. */
    override fun webGetFlexibleGroupRolloverSettings(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebGetFlexibleGroupRolloverSettings,
                        WebGetFlexibleGroupRolloverSettings.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_GetGiftedSubscriptionsForPolling` (query) pass-through. */
    override fun webGetGiftedSubscriptionsForPolling(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebGetGiftedSubscriptionsForPolling,
                        WebGetGiftedSubscriptionsForPolling.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_GetInvestmentsAccounts` (query) pass-through. */
    override fun webGetInvestmentsAccounts(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebGetInvestmentsAccounts, WebGetInvestmentsAccounts.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_GetInvestmentsDashboardCard` (query) pass-through. */
    override fun webGetInvestmentsDashboardCard(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebGetInvestmentsDashboardCard,
                        WebGetInvestmentsDashboardCard.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_GetInvestmentsHoldingDrawerHistoricalPerformance` (query) pass-through. */
    override fun webGetInvestmentsHoldingDrawerHistoricalPerformance(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebGetInvestmentsHoldingDrawerHistoricalPerformance,
                        WebGetInvestmentsHoldingDrawerHistoricalPerformance.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_GetMeCollaborationProfileStep` (query) pass-through. */
    override fun webGetMeCollaborationProfileStep(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebGetMeCollaborationProfileStep,
                        WebGetMeCollaborationProfileStep.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_GetMerchantSelectHouseholdMerchants` (query) pass-through. */
    override fun webGetMerchantSelectHouseholdMerchants(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebGetMerchantSelectHouseholdMerchants,
                        WebGetMerchantSelectHouseholdMerchants.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_GetMerchantSelectRecommendedMerchants` (query) pass-through. */
    override fun webGetMerchantSelectRecommendedMerchants(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebGetMerchantSelectRecommendedMerchants,
                        WebGetMerchantSelectRecommendedMerchants.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_GetMerchantSelectTransactionDetails` (query) pass-through. */
    override fun webGetMerchantSelectTransactionDetails(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebGetMerchantSelectTransactionDetails,
                        WebGetMerchantSelectTransactionDetails.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_GetMerchantSettingsPage` (query) pass-through. */
    override fun webGetMerchantSettingsPage(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebGetMerchantSettingsPage, WebGetMerchantSettingsPage.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_GetPlanRecommendationData` (query) pass-through. */
    override fun webGetPlanRecommendationData(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebGetPlanRecommendationData,
                        WebGetPlanRecommendationData.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_GetPortfolio` (query) pass-through. */
    override fun webGetPortfolio(webScreenAggregateRequest: WebScreenAggregateRequest?): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebGetPortfolio, WebGetPortfolio.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_GetPortfolioWithClassification` (query) pass-through. */
    override fun webGetPortfolioWithClassification(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebGetPortfolioWithClassification,
                        WebGetPortfolioWithClassification.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_GetRecommendedCategories` (query) pass-through. */
    override fun webGetRecommendedCategories(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebGetRecommendedCategories,
                        WebGetRecommendedCategories.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_GetScheduleCLineItems` (query) pass-through. */
    override fun webGetScheduleCLineItems(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebGetScheduleCLineItems, WebGetScheduleCLineItems.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_GetSecuritiesHistoricalPerformance` (query) pass-through. */
    override fun webGetSecuritiesHistoricalPerformance(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebGetSecuritiesHistoricalPerformance,
                        WebGetSecuritiesHistoricalPerformance.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_GetSecuritySettings` (query) pass-through. */
    override fun webGetSecuritySettings(webScreenAggregateRequest: WebScreenAggregateRequest?): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebGetSecuritySettings, WebGetSecuritySettings.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_GetSidebarData` (query) pass-through. */
    override fun webGetSidebarData(webScreenAggregateRequest: WebScreenAggregateRequest?): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebGetSidebarData, WebGetSidebarData.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_GetStatementParserColumns` (query) pass-through. */
    override fun webGetStatementParserColumns(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebGetStatementParserColumns,
                        WebGetStatementParserColumns.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_GetSubscription` (query) pass-through. */
    override fun webGetSubscription(webScreenAggregateRequest: WebScreenAggregateRequest?): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebGetSubscription, WebGetSubscription.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_GetSubscriptionModal` (query) pass-through. */
    override fun webGetSubscriptionModal(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebGetSubscriptionModal, WebGetSubscriptionModal.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_GetTaxPrepCategoryTransactions` (query) pass-through. */
    override fun webGetTaxPrepCategoryTransactions(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebGetTaxPrepCategoryTransactions,
                        WebGetTaxPrepCategoryTransactions.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_GetTaxPrepUnmappedCategoryTransactions` (query) pass-through. */
    override fun webGetTaxPrepUnmappedCategoryTransactions(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebGetTaxPrepUnmappedCategoryTransactions,
                        WebGetTaxPrepUnmappedCategoryTransactions.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_GetTopInstitutionGroupByType` (query) pass-through. */
    override fun webGetTopInstitutionGroupByType(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebGetTopInstitutionGroupByType,
                        WebGetTopInstitutionGroupByType.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_GetTransactionFiltersMetadata` (query) pass-through. */
    override fun webGetTransactionFiltersMetadata(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebGetTransactionFiltersMetadata,
                        WebGetTransactionFiltersMetadata.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_GetTransactionsPage` (query) pass-through. */
    override fun webGetTransactionsPage(webScreenAggregateRequest: WebScreenAggregateRequest?): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebGetTransactionsPage, WebGetTransactionsPage.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_GetTransactionsSummaryCard` (query) pass-through. */
    override fun webGetTransactionsSummaryCard(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebGetTransactionsSummaryCard,
                        WebGetTransactionsSummaryCard.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_GetTrustAndWillSubscription` (query) pass-through. */
    override fun webGetTrustAndWillSubscription(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebGetTrustAndWillSubscription,
                        WebGetTrustAndWillSubscription.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_GetUserDismissedRetailSyncBanner` (query) pass-through. */
    override fun webGetUserDismissedRetailSyncBanner(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebGetUserDismissedRetailSyncBanner,
                        WebGetUserDismissedRetailSyncBanner.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_GetUserHasConfiguredExtension` (query) pass-through. */
    override fun webGetUserHasConfiguredExtension(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebGetUserHasConfiguredExtension,
                        WebGetUserHasConfiguredExtension.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_GetUserPlatforms` (query) pass-through. */
    override fun webGetUserPlatforms(webScreenAggregateRequest: WebScreenAggregateRequest?): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebGetUserPlatforms, WebGetUserPlatforms.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_GiveEmployeeInfinitePlusAccess` (mutation) pass-through. */
    override fun webGiveEmployeeInfinitePlusAccess(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebGiveEmployeeInfinitePlusAccess,
                        WebGiveEmployeeInfinitePlusAccess.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_GiveEmployeeInfinitePremiumAccess` (mutation) pass-through. */
    override fun webGiveEmployeeInfinitePremiumAccess(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebGiveEmployeeInfinitePremiumAccess,
                        WebGiveEmployeeInfinitePremiumAccess.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_GoalDetailV2` (query) pass-through. */
    override fun webGoalDetailV2(webScreenAggregateRequest: WebScreenAggregateRequest?): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebGoalDetailV2, WebGoalDetailV2.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_GoalSelectGoals` (query) pass-through. */
    override fun webGoalSelectGoals(webScreenAggregateRequest: WebScreenAggregateRequest?): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebGoalSelectGoals, WebGoalSelectGoals.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_GoalSelectTransaction` (query) pass-through. */
    override fun webGoalSelectTransaction(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebGoalSelectTransaction, WebGoalSelectTransaction.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_GoalsAllocateBalanceModal` (query) pass-through. */
    override fun webGoalsAllocateBalanceModal(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebGoalsAllocateBalanceModal,
                        WebGoalsAllocateBalanceModal.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_GoalsAllocationCardAccounts` (query) pass-through. */
    override fun webGoalsAllocationCardAccounts(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebGoalsAllocationCardAccounts,
                        WebGoalsAllocationCardAccounts.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_GoalsDashboardCardV2` (query) pass-through. */
    override fun webGoalsDashboardCardV2(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebGoalsDashboardCardV2, WebGoalsDashboardCardV2.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_GoalsMapAccounts` (query) pass-through. */
    override fun webGoalsMapAccounts(webScreenAggregateRequest: WebScreenAggregateRequest?): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebGoalsMapAccounts, WebGoalsMapAccounts.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_GoalsMapAccountsModal` (query) pass-through. */
    override fun webGoalsMapAccountsModal(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebGoalsMapAccountsModal, WebGoalsMapAccountsModal.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_GoalsMessageBlock` (query) pass-through. */
    override fun webGoalsMessageBlock(webScreenAggregateRequest: WebScreenAggregateRequest?): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebGoalsMessageBlock, WebGoalsMessageBlock.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_GoalsMonthlyBudgets` (query) pass-through. */
    override fun webGoalsMonthlyBudgets(webScreenAggregateRequest: WebScreenAggregateRequest?): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebGoalsMonthlyBudgets, WebGoalsMonthlyBudgets.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_GoalsV2` (query) pass-through. */
    override fun webGoalsV2(webScreenAggregateRequest: WebScreenAggregateRequest?): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebGoalsV2, WebGoalsV2.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_ImportStatementGetAccount` (query) pass-through. */
    override fun webImportStatementGetAccount(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebImportStatementGetAccount,
                        WebImportStatementGetAccount.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_InitScheduleCDefaultMappings` (mutation) pass-through. */
    override fun webInitScheduleCDefaultMappings(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebInitScheduleCDefaultMappings,
                        WebInitScheduleCDefaultMappings.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_InviteEmail` (mutation) pass-through. */
    override fun webInviteEmail(webScreenAggregateRequest: WebScreenAggregateRequest?): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebInviteEmail, WebInviteEmail.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_MigrateHouseholdToSavingGoals` (mutation) pass-through. */
    override fun webMigrateHouseholdToSavingGoals(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebMigrateHouseholdToSavingGoals,
                        WebMigrateHouseholdToSavingGoals.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_MintTransactionsCountQuery` (query) pass-through. */
    override fun webMintTransactionsCountQuery(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebMintTransactionsCountQuery,
                        WebMintTransactionsCountQuery.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_MonthlyBudgetGoalsModal` (query) pass-through. */
    override fun webMonthlyBudgetGoalsModal(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebMonthlyBudgetGoalsModal, WebMonthlyBudgetGoalsModal.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_MoveMoneyMutation` (mutation) pass-through. */
    override fun webMoveMoneyMutation(webScreenAggregateRequest: WebScreenAggregateRequest?): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebMoveMoneyMutation, WebMoveMoneyMutation.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_OnboardingTopInstitutions` (query) pass-through. */
    override fun webOnboardingTopInstitutions(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebOnboardingTopInstitutions,
                        WebOnboardingTopInstitutions.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_ParseUploadStatementSession` (mutation) pass-through. */
    override fun webParseUploadStatementSession(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebParseUploadStatementSession,
                        WebParseUploadStatementSession.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_PlusUpgradeTrial` (query) pass-through. */
    override fun webPlusUpgradeTrial(webScreenAggregateRequest: WebScreenAggregateRequest?): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebPlusUpgradeTrial, WebPlusUpgradeTrial.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_PreTaxBudgetGoalsList` (query) pass-through. */
    override fun webPreTaxBudgetGoalsList(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebPreTaxBudgetGoalsList, WebPreTaxBudgetGoalsList.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_PreviewAccountDataTransferSnapshots` (query) pass-through. */
    override fun webPreviewAccountDataTransferSnapshots(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebPreviewAccountDataTransferSnapshots,
                        WebPreviewAccountDataTransferSnapshots.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_PreviewAccountDataTransferTransactions` (query) pass-through. */
    override fun webPreviewAccountDataTransferTransactions(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebPreviewAccountDataTransferTransactions,
                        WebPreviewAccountDataTransferTransactions.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_PreviewCopySnapshots` (query) pass-through. */
    override fun webPreviewCopySnapshots(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebPreviewCopySnapshots, WebPreviewCopySnapshots.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_RankGoalsList` (query) pass-through. */
    override fun webRankGoalsList(webScreenAggregateRequest: WebScreenAggregateRequest?): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebRankGoalsList, WebRankGoalsList.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_ReactivateSubscription` (mutation) pass-through. */
    override fun webReactivateSubscription(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebReactivateSubscription, WebReactivateSubscription.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_RecalculateBudgetMutation` (mutation) pass-through. */
    override fun webRecalculateBudgetMutation(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebRecalculateBudgetMutation,
                        WebRecalculateBudgetMutation.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_RecommendedAccountDataTransferDates` (query) pass-through. */
    override fun webRecommendedAccountDataTransferDates(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebRecommendedAccountDataTransferDates,
                        WebRecommendedAccountDataTransferDates.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_RecommendedAccounts` (query) pass-through. */
    override fun webRecommendedAccounts(webScreenAggregateRequest: WebScreenAggregateRequest?): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebRecommendedAccounts, WebRecommendedAccounts.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_RecurringFilterQuery` (query) pass-through. */
    override fun webRecurringFilterQuery(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebRecurringFilterQuery, WebRecurringFilterQuery.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_RecurringPausedBanner` (query) pass-through. */
    override fun webRecurringPausedBanner(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebRecurringPausedBanner, WebRecurringPausedBanner.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_RemoveEmployeeEntitlements` (mutation) pass-through. */
    override fun webRemoveEmployeeEntitlements(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebRemoveEmployeeEntitlements,
                        WebRemoveEmployeeEntitlements.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_ResetAndSyncAccountMutation` (mutation) pass-through. */
    override fun webResetAndSyncAccountMutation(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebResetAndSyncAccountMutation,
                        WebResetAndSyncAccountMutation.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_ResetCategorizationMemory` (mutation) pass-through. */
    override fun webResetCategorizationMemory(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebResetCategorizationMemory,
                        WebResetCategorizationMemory.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_ResetEmployeeAndSubscribe` (mutation) pass-through. */
    override fun webResetEmployeeAndSubscribe(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebResetEmployeeAndSubscribe,
                        WebResetEmployeeAndSubscribe.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_ResetEmployeeToNoSubscription` (mutation) pass-through. */
    override fun webResetEmployeeToNoSubscription(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebResetEmployeeToNoSubscription,
                        WebResetEmployeeToNoSubscription.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_ResetHouseholdRecurringMerchantSearch` (mutation) pass-through. */
    override fun webResetHouseholdRecurringMerchantSearch(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebResetHouseholdRecurringMerchantSearch,
                        WebResetHouseholdRecurringMerchantSearch.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_ResetRolloverMutation` (mutation) pass-through. */
    override fun webResetRolloverMutation(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebResetRolloverMutation, WebResetRolloverMutation.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_ResetWeeklyRecapMutation` (mutation) pass-through. */
    override fun webResetWeeklyRecapMutation(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebResetWeeklyRecapMutation,
                        WebResetWeeklyRecapMutation.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_RestoreCategory` (mutation) pass-through. */
    override fun webRestoreCategory(webScreenAggregateRequest: WebScreenAggregateRequest?): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebRestoreCategory, WebRestoreCategory.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_ReviewStream` (mutation) pass-through. */
    override fun webReviewStream(webScreenAggregateRequest: WebScreenAggregateRequest?): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebReviewStream, WebReviewStream.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_RevokeConnectedApp` (mutation) pass-through. */
    override fun webRevokeConnectedApp(webScreenAggregateRequest: WebScreenAggregateRequest?): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebRevokeConnectedApp, WebRevokeConnectedApp.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_RevokeSponsorshipInvite` (mutation) pass-through. */
    override fun webRevokeSponsorshipInvite(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebRevokeSponsorshipInvite, WebRevokeSponsorshipInvite.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_SearchInstitutionsQuery` (query) pass-through. */
    override fun webSearchInstitutionsQuery(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebSearchInstitutionsQuery, WebSearchInstitutionsQuery.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_SearchMerchants` (query) pass-through. */
    override fun webSearchMerchants(webScreenAggregateRequest: WebScreenAggregateRequest?): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebSearchMerchants, WebSearchMerchants.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_SearchSecurities` (query) pass-through. */
    override fun webSearchSecurities(webScreenAggregateRequest: WebScreenAggregateRequest?): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebSearchSecurities, WebSearchSecurities.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_SetEmployeeActiveSubscription` (mutation) pass-through. */
    override fun webSetEmployeeActiveSubscription(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebSetEmployeeActiveSubscription,
                        WebSetEmployeeActiveSubscription.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_SetEmployeeCancellationDiscountUsed` (mutation) pass-through. */
    override fun webSetEmployeeCancellationDiscountUsed(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebSetEmployeeCancellationDiscountUsed,
                        WebSetEmployeeCancellationDiscountUsed.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_SetEmployeeExpiredTrial` (mutation) pass-through. */
    override fun webSetEmployeeExpiredTrial(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebSetEmployeeExpiredTrial, WebSetEmployeeExpiredTrial.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_SetEmployeePlusTrialFields` (mutation) pass-through. */
    override fun webSetEmployeePlusTrialFields(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebSetEmployeePlusTrialFields,
                        WebSetEmployeePlusTrialFields.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_SetEmployeeSubscriptionEnded` (mutation) pass-through. */
    override fun webSetEmployeeSubscriptionEnded(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebSetEmployeeSubscriptionEnded,
                        WebSetEmployeeSubscriptionEnded.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_SnapshotsForAccountCopyBalancePreview` (query) pass-through. */
    override fun webSnapshotsForAccountCopyBalancePreview(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebSnapshotsForAccountCopyBalancePreview,
                        WebSnapshotsForAccountCopyBalancePreview.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_StartDownloadScheduleCSession` (mutation) pass-through. */
    override fun webStartDownloadScheduleCSession(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebStartDownloadScheduleCSession,
                        WebStartDownloadScheduleCSession.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_SyncEmployeeSubscription` (mutation) pass-through. */
    override fun webSyncEmployeeSubscription(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebSyncEmployeeSubscription,
                        WebSyncEmployeeSubscription.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_TargetAmountsGoalsList` (query) pass-through. */
    override fun webTargetAmountsGoalsList(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebTargetAmountsGoalsList, WebTargetAmountsGoalsList.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_TestCreditScoreChangedNotification` (mutation) pass-through. */
    override fun webTestCreditScoreChangedNotification(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebTestCreditScoreChangedNotification,
                        WebTestCreditScoreChangedNotification.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_ToggleSupportAccountAccess` (mutation) pass-through. */
    override fun webToggleSupportAccountAccess(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebToggleSupportAccountAccess,
                        WebToggleSupportAccountAccess.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_TransactionDrawerDeleteAttachment` (mutation) pass-through. */
    override fun webTransactionDrawerDeleteAttachment(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebTransactionDrawerDeleteAttachment,
                        WebTransactionDrawerDeleteAttachment.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_TransactionsFilterQuery` (query) pass-through. */
    override fun webTransactionsFilterQuery(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebTransactionsFilterQuery, WebTransactionsFilterQuery.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_TransactionsMessageBlock` (query) pass-through. */
    override fun webTransactionsMessageBlock(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebTransactionsMessageBlock,
                        WebTransactionsMessageBlock.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_UndoSavingsGoalMigration` (mutation) pass-through. */
    override fun webUndoSavingsGoalMigration(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebUndoSavingsGoalMigration,
                        WebUndoSavingsGoalMigration.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_UnmatchRetailTransaction` (mutation) pass-through. */
    override fun webUnmatchRetailTransaction(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebUnmatchRetailTransaction,
                        WebUnmatchRetailTransaction.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_UpdateAccountOrder` (mutation) pass-through. */
    override fun webUpdateAccountOrder(webScreenAggregateRequest: WebScreenAggregateRequest?): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebUpdateAccountOrder, WebUpdateAccountOrder.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_UpdateBusinessTrackingSetupIntent` (mutation) pass-through. */
    override fun webUpdateBusinessTrackingSetupIntent(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebUpdateBusinessTrackingSetupIntent,
                        WebUpdateBusinessTrackingSetupIntent.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_UpdateCategory` (mutation) pass-through. */
    override fun webUpdateCategory(webScreenAggregateRequest: WebScreenAggregateRequest?): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebUpdateCategory, WebUpdateCategory.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_UpdateCategoryFromBudgetOnboarding` (mutation) pass-through. */
    override fun webUpdateCategoryFromBudgetOnboarding(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebUpdateCategoryFromBudgetOnboarding,
                        WebUpdateCategoryFromBudgetOnboarding.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_UpdateCategoryGroupOrder` (mutation) pass-through. */
    override fun webUpdateCategoryGroupOrder(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebUpdateCategoryGroupOrder,
                        WebUpdateCategoryGroupOrder.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_UpdateCategoryOrder` (mutation) pass-through. */
    override fun webUpdateCategoryOrder(webScreenAggregateRequest: WebScreenAggregateRequest?): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebUpdateCategoryOrder, WebUpdateCategoryOrder.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_UpdateCompany` (mutation) pass-through. */
    override fun webUpdateCompany(webScreenAggregateRequest: WebScreenAggregateRequest?): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebUpdateCompany, WebUpdateCompany.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_UpdateDismissedRetailSyncBanner` (mutation) pass-through. */
    override fun webUpdateDismissedRetailSyncBanner(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebUpdateDismissedRetailSyncBanner,
                        WebUpdateDismissedRetailSyncBanner.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_UpdateGoalsPriorities` (mutation) pass-through. */
    override fun webUpdateGoalsPriorities(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebUpdateGoalsPriorities, WebUpdateGoalsPriorities.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_UpdateOrCreateAdvisorStripePaymentMethod` (mutation) pass-through. */
    override fun webUpdateOrCreateAdvisorStripePaymentMethod(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebUpdateOrCreateAdvisorStripePaymentMethod,
                        WebUpdateOrCreateAdvisorStripePaymentMethod.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_UpdateOrCreateStripePaymentMethod` (mutation) pass-through. */
    override fun webUpdateOrCreateStripePaymentMethod(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebUpdateOrCreateStripePaymentMethod,
                        WebUpdateOrCreateStripePaymentMethod.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_UpdateRenewalReminder` (mutation) pass-through. */
    override fun webUpdateRenewalReminder(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebUpdateRenewalReminder, WebUpdateRenewalReminder.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_UpdateRuleOrderMutation` (mutation) pass-through. */
    override fun webUpdateRuleOrderMutation(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebUpdateRuleOrderMutation, WebUpdateRuleOrderMutation.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_UpdateSubscriptionSponsor` (mutation) pass-through. */
    override fun webUpdateSubscriptionSponsor(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebUpdateSubscriptionSponsor,
                        WebUpdateSubscriptionSponsor.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_UpdateTransactionOverview` (mutation) pass-through. */
    override fun webUpdateTransactionOverview(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebUpdateTransactionOverview,
                        WebUpdateTransactionOverview.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_UpdateUserFinancialProfile` (mutation) pass-through. */
    override fun webUpdateUserFinancialProfile(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebUpdateUserFinancialProfile,
                        WebUpdateUserFinancialProfile.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )

    /** `Web_confirmTotpDevice` (mutation) pass-through. */
    override fun webConfirmTotpDevice(webScreenAggregateRequest: WebScreenAggregateRequest?): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data = exec(WebConfirmTotpDevice, WebConfirmTotpDevice.Input(variables = webScreenAggregateRequest?.variables)),
            ),
        )

    /** `Web_createUnconfirmedTotpDevice` (mutation) pass-through. */
    override fun webCreateUnconfirmedTotpDevice(
        webScreenAggregateRequest: WebScreenAggregateRequest?,
    ): ResponseEntity<WebScreenAggregateResponse> =
        ResponseEntity.ok(
            WebScreenAggregateResponse(
                data =
                    exec(
                        WebCreateUnconfirmedTotpDevice,
                        WebCreateUnconfirmedTotpDevice.Input(variables = webScreenAggregateRequest?.variables),
                    ),
            ),
        )
}
