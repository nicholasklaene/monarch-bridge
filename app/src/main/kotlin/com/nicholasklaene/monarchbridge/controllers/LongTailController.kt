package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.generated.api.LongTailApi
import com.nicholasklaene.monarchbridge.generated.model.LongTailRequest
import com.nicholasklaene.monarchbridge.generated.model.LongTailResponse
import com.nicholasklaene.monarchbridge.generated.model.LongTailResponseData
import com.nicholasklaene.monarchbridge.graphql.MonarchClient
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.AccountTransferResultQuery
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.AccountTransferStatusQuery
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.AccountsTransferEligibility
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.AllActiveInstitutionNotices
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.ArchiveGoal
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.CancelMessageThread
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.CancelSubscriptionForHousehold
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.CategoryDeletionInfo
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.CheckActivityMutation
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.CompleteRetailSync
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.CompleteSavingsGoalsMigration
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.CreateAccountsFromPlaidToken
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.CreateBudgetForHousehold
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.CreateBulkRetailSync
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.CreateGoalAccountAllocation
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.CreateGoals
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.CreateHouseholdAccessGrant
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.CreateInstitutionIssueReportMutation
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.CreateOrUpdateGoalV2PlannedContributionMutation
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.CreatePromoCodeCheckoutSession
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.CreateRetailSync
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.CreateSavingsGoalAccountInitialContributions
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.CreateThreadMutation
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.DebtPaydown
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.DebtPaydownAccounts
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.DeleteAllMessageThreads
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.DeleteGoalAccountAllocation
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.DeleteHousehold
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.DeleteMessageThread
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.DeleteRetailSync
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.DeleteSavingsGoalEvent
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.DeleteSyncedSnapshotsMutation
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.DeleteSyncedTransactionsMutation
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.DeleteTransactionsMutation
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.DisableCredentialAndDeleteFromDataProvider
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.DisconnectSpinwheel
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.DismissBusinessEntitiesBanner
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.DispatchSavingsGoalMigration
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.FixCoinbaseCredential
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.ForceRefreshAccountMutation
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.ForceRefreshAccountQuery
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.ForceRefreshOperationQuery
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetAccount
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetAccountsForEditingEntities
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetAccountsForEditingOwnership
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetActAsUserExternalId
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetAggregatesGraph
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetAggregatesGraphCategoryGroup
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetAggregatesGraphFlexExpense
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetAssistantFeedback
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetBusinessEntities
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetBusinessEntitiesBannerProfile
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetBusinessEntitiesSummary
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetCanRequestReview
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetCanSkipPremiumUpsell
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetCategoryDetails
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetCategoryEntity
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetCategoryGroup
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetCategoryGroups
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetCloudinaryUploadInfo
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetContactSupportFormRecommendedResolution
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetDashboardConfig
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetDebtAccountsForMigration
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetDecagonInstitutionsStatus
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetDecagonLinkedCredentials
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetDecagonSubscriptionStatus
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetDecagonToken
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetFeatureEntitlementParams
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetGiftedSubscriptions
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetGoalsV2
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetHasAccounts
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetHasSpinwheelUser
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetHasSyncedAccounts
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetHoldingDetailsFormSecurityDetails
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetHoldingSummarySecurityDetails
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetHouseHoldMemberSettings
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetInstitutionByProviderId
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetInstitutionLogoByPlaidId
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetMerchant
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetMerchantDetails
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetMerchantEntity
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetMessageThread
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetMessageThreads
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetMobileSubscriptionOffering
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetNotificationPreference
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetOnboardingFinancialGoals
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetPlanOnboardingState
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetPremiumUpgradePlans
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetReferralConstants
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetReferralSettings
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetReportsData
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetRetailExtensionSettings
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetReviewedAccountLastStatements
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetReviewedMerchantLastTransactions
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetSmartPrompts
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetSpinwheelCreditReport
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetSubscriptionHasEntitlementAfterSync
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetSubscriptionStatus
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetTransactionFiltersCard
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetTransactions
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetTrialStatus
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetUploadStatementSession
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetUserReportedOnboardingAttributionChannels
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GetYearlyReviewStatus
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GoalAccountsForInitialContribution
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GoalOptions
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GoalReconciliationHistory
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GoalReconciliationTransactionInfo
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GoalSelectAccounts
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.GoalsV2MigrationQuery
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.HasActivity
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.InitializeFlexBudget
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.LegacyGoalsMigrationQuery
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.MarkRecurringLiabilityStatementAsPaid
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.MatchRetailTransaction
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.MigratedToSavingsGoals
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.MigratedToSavingsGoalsAt
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.MoveMoneyScreenQuery
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.OldestDeletableTransactionDate
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.OnboardingChecklist
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.PreviewDeleteTransactions
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.QuestionnaireIntroQuery
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.ReconcileAccountGoalSpendingForTransactions
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.ReconcileExternalSpending
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.RecordBusinessEntitiesBannerImpression
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.RecordSmartPromptClick
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.RecordSmartPromptImpressions
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.RecurringMerchantSearch
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.RecurringUpdateLiabilityStatement
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.RecurringUpdateMerchant
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.RedeemTrustAndWill
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.RequestInstitution
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.ResendInviteToHousehold
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.ResendReferralRewardEmail
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.RetailSyncQuery
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.RetailSyncsQueryWithTotal
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.ReviewQuery
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.ReviewStream
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.RevokeHouseholdAccessGrant
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.RevokeInviteToHousehold
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.SaveDebtPaydownProjectionToBudget
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.SavingsGoalAccount
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.SavingsGoalAccounts
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.SavingsGoalAccountsAllocationSummary
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.SavingsGoalBudgetAmounts
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.SavingsGoalBudgetAmountsWithRecommendation
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.SavingsGoalEditAccounts
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.SavingsGoalMigrationStatus
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.SavingsGoalReconciliationAccount
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.SavingsGoalsAllocationAmountsByAccount
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.SavingsGoalsPrioritizeList
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.SavingsGoalsTypes
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.SavingsGoalsWithThisMonthBalances
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.SelectBudgetCategoryScreenQuery
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.SendMessage
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.SetAccountLogo
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.SetDebtPaydownBudgetAmount
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.SetFinancialInsightsEnabled
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.SetHasDismissedYearlyReview
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.SetHasSkippedPremiumUpsell
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.SetOnboardingCompleted
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.SetUserOnboardingFinancialGoals
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.SetUserProfilePicture
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.SetUserReportedAttributionChannels
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.StartRetailSync
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.StartSavingsGoalsMigration
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.SubmitAssistantFeedback
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.SyncCredentialAfterReconnect
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.ToggleCreditScoreTracking
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.TopInstitutionsQuery
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.TransferAccountDataAsync
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.TriggerRecurringMerchantSearch
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.UnarchiveGoal
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.UndeleteAccount
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.UnreconciledSpendingEvents
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.UpdateAccountsForEditingEntities
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.UpdateAccountsForEditingOwnership
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.UpdateAllNotificationPreferencesForPlatform
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.UpdateCategoryBudgetVariability
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.UpdateCategoryExcludeFromBudget
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.UpdateCredential
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.UpdateDashboardConfig
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.UpdateDoNotSellOrShare
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.UpdateFinancialInsightStatus
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.UpdateGoalAccountAllocation
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.UpdateMyHousehold
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.UpdateRetailOrder
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.UpdateRetailVendorSettings
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.UpdateSavingsGoalAccountIncludeInGoalContributions
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.UpdateSavingsGoalAccountLink
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.UpdateSavingsGoalEvent
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.UpdateSponsorshipInvite
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.UpdateTransaction
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.UpdateTransactionTag
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.UpdateTransactionTagOrder
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.UpdateUserProfile
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.UpdateUserProfileFlags
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.UserDevicesUsage
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.UserProfileFlags
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.VehiclesSearch
import com.nicholasklaene.monarchbridge.graphql.operations.longtail.WithdrawAllGoalContributionsFromAccount
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

/**
 * Long-tail Monarch GraphQL operations not yet covered by typed resource controllers.
 *
 * Each route under `/v1/x/` runs one upstream GraphQL operation and returns the raw
 * `data` payload wrapped in the shared [LongTailResponse] envelope. Variables for the
 * operation are forwarded verbatim from the optional [LongTailRequest] body. Shape is
 * opaque; clients should not pin to deep field paths since upstream shape can change.
 *
 * Operations live as one Kotlin `object` per op under
 * `graphql.operations.longtail.<Name>`, each extending `LongTailOperation` and binding
 * the GraphQL operation name. This file is the HTTP-side switchboard, one method per op.
 *
 * Generated as a sweep over the wrappable long-tail surface. To graduate an operation to
 * a typed resource controller, move the Kotlin object, controller method, and spec stanza
 * out of `longtail/` and into the relevant resource package.
 */
@RestController
@Suppress("LargeClass", "TooManyFunctions")
class LongTailController(
    sessionService: MonarchSessionService,
    client: MonarchClient,
) : MonarchControllerBase(sessionService, client),
    LongTailApi {
    override fun longTailCategoryDeletionInfo(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(CategoryDeletionInfo, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailAccountTransferResultQuery(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(AccountTransferResultQuery, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailAccountTransferStatusQuery(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(AccountTransferStatusQuery, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailAccountsTransferEligibility(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(AccountsTransferEligibility, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailAllActiveInstitutionNotices(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(AllActiveInstitutionNotices, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailArchiveGoal(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(ArchiveGoal, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailCancelMessageThread(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(CancelMessageThread, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailCancelSubscriptionForHousehold(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(CancelSubscriptionForHousehold, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailCheckActivityMutation(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(CheckActivityMutation, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailCompleteRetailSync(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(CompleteRetailSync, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailCompleteSavingsGoalsMigration(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(CompleteSavingsGoalsMigration, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailCreateAccountsFromPlaidToken(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(CreateAccountsFromPlaidToken, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailCreateBudgetForHousehold(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(CreateBudgetForHousehold, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailCreateBulkRetailSync(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(CreateBulkRetailSync, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailCreateGoalAccountAllocation(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(CreateGoalAccountAllocation, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailCreateGoals(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(CreateGoals, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailCreateInstitutionIssueReportMutation(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(CreateInstitutionIssueReportMutation, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailCreateOrUpdateGoalV2PlannedContributionMutation(
        longTailRequest: LongTailRequest?,
    ): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data =
                    LongTailResponseData(
                        result = exec(CreateOrUpdateGoalV2PlannedContributionMutation, longTailRequest?.variables.orEmpty()),
                    ),
            ),
        )

    override fun longTailCreateRetailSync(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(CreateRetailSync, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailCreateSavingsGoalAccountInitialContributions(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data =
                    LongTailResponseData(
                        result = exec(CreateSavingsGoalAccountInitialContributions, longTailRequest?.variables.orEmpty()),
                    ),
            ),
        )

    override fun longTailCreateThreadMutation(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(CreateThreadMutation, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailDebtPaydown(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(DebtPaydown, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailDebtPaydownAccounts(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(DebtPaydownAccounts, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailDeleteAllMessageThreads(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(DeleteAllMessageThreads, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailDeleteGoalAccountAllocation(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(DeleteGoalAccountAllocation, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailDeleteHousehold(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(DeleteHousehold, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailDeleteMessageThread(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(DeleteMessageThread, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailDeleteRetailSync(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(DeleteRetailSync, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailDeleteSavingsGoalEvent(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(DeleteSavingsGoalEvent, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailDeleteSyncedSnapshotsMutation(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(DeleteSyncedSnapshotsMutation, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailDeleteSyncedTransactionsMutation(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(DeleteSyncedTransactionsMutation, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailDeleteTransactionsMutation(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(DeleteTransactionsMutation, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailDisableCredentialAndDeleteFromDataProvider(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data =
                    LongTailResponseData(
                        result = exec(DisableCredentialAndDeleteFromDataProvider, longTailRequest?.variables.orEmpty()),
                    ),
            ),
        )

    override fun longTailDisconnectSpinwheel(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(DisconnectSpinwheel, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailDispatchSavingsGoalMigration(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(DispatchSavingsGoalMigration, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailFixCoinbaseCredential(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(FixCoinbaseCredential, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailForceRefreshAccountMutation(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(ForceRefreshAccountMutation, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailForceRefreshAccountQuery(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(ForceRefreshAccountQuery, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailForceRefreshOperationQuery(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(ForceRefreshOperationQuery, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetAccount(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetAccount, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetAccountsForEditingEntities(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetAccountsForEditingEntities, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetAccountsForEditingOwnership(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetAccountsForEditingOwnership, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetActAsUserExternalId(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetActAsUserExternalId, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetAssistantFeedback(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetAssistantFeedback, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetCategoryEntity(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetCategoryEntity, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetCloudinaryUploadInfo(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetCloudinaryUploadInfo, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetDebtAccountsForMigration(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetDebtAccountsForMigration, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetDecagonInstitutionsStatus(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetDecagonInstitutionsStatus, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetDecagonLinkedCredentials(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetDecagonLinkedCredentials, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetDecagonSubscriptionStatus(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetDecagonSubscriptionStatus, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetDecagonToken(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetDecagonToken, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetFeatureEntitlementParams(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetFeatureEntitlementParams, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetGiftedSubscriptions(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetGiftedSubscriptions, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetHasAccounts(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetHasAccounts, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetHasSpinwheelUser(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetHasSpinwheelUser, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetHasSyncedAccounts(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetHasSyncedAccounts, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetHouseHoldMemberSettings(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetHouseHoldMemberSettings, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetMerchant(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetMerchant, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetMerchantEntity(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetMerchantEntity, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetMessageThread(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetMessageThread, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetMessageThreads(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetMessageThreads, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetNotificationPreference(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetNotificationPreference, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetOnboardingFinancialGoals(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetOnboardingFinancialGoals, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetPlanOnboardingState(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetPlanOnboardingState, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetPremiumUpgradePlans(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetPremiumUpgradePlans, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetReferralConstants(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetReferralConstants, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetReferralSettings(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetReferralSettings, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetReportsData(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetReportsData, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetRetailExtensionSettings(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetRetailExtensionSettings, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetReviewedAccountLastStatements(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetReviewedAccountLastStatements, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetReviewedMerchantLastTransactions(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetReviewedMerchantLastTransactions, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetSmartPrompts(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetSmartPrompts, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetSpinwheelCreditReport(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetSpinwheelCreditReport, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetSubscriptionHasEntitlementAfterSync(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetSubscriptionHasEntitlementAfterSync, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetUserReportedOnboardingAttributionChannels(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data =
                    LongTailResponseData(
                        result = exec(GetUserReportedOnboardingAttributionChannels, longTailRequest?.variables.orEmpty()),
                    ),
            ),
        )

    override fun longTailGoalAccountsForInitialContribution(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GoalAccountsForInitialContribution, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGoalOptions(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GoalOptions, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGoalReconciliationHistory(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GoalReconciliationHistory, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGoalReconciliationTransactionInfo(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GoalReconciliationTransactionInfo, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGoalsV2MigrationQuery(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GoalsV2MigrationQuery, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailHasActivity(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(HasActivity, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailInitializeFlexBudget(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(InitializeFlexBudget, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailLegacyGoalsMigrationQuery(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(LegacyGoalsMigrationQuery, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailMarkRecurringLiabilityStatementAsPaid(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(MarkRecurringLiabilityStatementAsPaid, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailMatchRetailTransaction(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(MatchRetailTransaction, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailMigratedToSavingsGoals(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(MigratedToSavingsGoals, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailMigratedToSavingsGoalsAt(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(MigratedToSavingsGoalsAt, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailOldestDeletableTransactionDate(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(OldestDeletableTransactionDate, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailOnboardingChecklist(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(OnboardingChecklist, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailPreviewDeleteTransactions(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(PreviewDeleteTransactions, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailReconcileAccountGoalSpendingForTransactions(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data =
                    LongTailResponseData(
                        result = exec(ReconcileAccountGoalSpendingForTransactions, longTailRequest?.variables.orEmpty()),
                    ),
            ),
        )

    override fun longTailReconcileExternalSpending(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(ReconcileExternalSpending, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailRecordSmartPromptClick(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(RecordSmartPromptClick, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailRecordSmartPromptImpressions(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(RecordSmartPromptImpressions, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailRecurringUpdateLiabilityStatement(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(RecurringUpdateLiabilityStatement, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailRecurringUpdateMerchant(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(RecurringUpdateMerchant, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailRedeemTrustAndWill(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(RedeemTrustAndWill, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailRequestInstitution(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(RequestInstitution, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailResendInviteToHousehold(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(ResendInviteToHousehold, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailResendReferralRewardEmail(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(ResendReferralRewardEmail, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailRetailSyncQuery(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(RetailSyncQuery, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailRetailSyncsQueryWithTotal(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(RetailSyncsQueryWithTotal, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailReviewStream(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(ReviewStream, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailRevokeHouseholdAccessGrant(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(RevokeHouseholdAccessGrant, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailRevokeInviteToHousehold(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(RevokeInviteToHousehold, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailSaveDebtPaydownProjectionToBudget(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(SaveDebtPaydownProjectionToBudget, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailSavingsGoalAccount(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(SavingsGoalAccount, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailSavingsGoalAccounts(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(SavingsGoalAccounts, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailSavingsGoalAccountsAllocationSummary(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(SavingsGoalAccountsAllocationSummary, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailSavingsGoalBudgetAmounts(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(SavingsGoalBudgetAmounts, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailSavingsGoalBudgetAmountsWithRecommendation(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data =
                    LongTailResponseData(
                        result = exec(SavingsGoalBudgetAmountsWithRecommendation, longTailRequest?.variables.orEmpty()),
                    ),
            ),
        )

    override fun longTailSavingsGoalEditAccounts(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(SavingsGoalEditAccounts, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailSavingsGoalMigrationStatus(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(SavingsGoalMigrationStatus, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailSavingsGoalReconciliationAccount(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(SavingsGoalReconciliationAccount, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailSavingsGoalsAllocationAmountsByAccount(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(SavingsGoalsAllocationAmountsByAccount, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailSavingsGoalsPrioritizeList(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(SavingsGoalsPrioritizeList, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailSavingsGoalsTypes(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(SavingsGoalsTypes, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailSavingsGoalsWithThisMonthBalances(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(SavingsGoalsWithThisMonthBalances, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailSendMessage(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(SendMessage, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailSetAccountLogo(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(SetAccountLogo, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailSetDebtPaydownBudgetAmount(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(SetDebtPaydownBudgetAmount, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailSetFinancialInsightsEnabled(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(SetFinancialInsightsEnabled, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailSetHasDismissedYearlyReview(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(SetHasDismissedYearlyReview, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailSetHasSkippedPremiumUpsell(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(SetHasSkippedPremiumUpsell, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailSetOnboardingCompleted(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(SetOnboardingCompleted, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailSetUserOnboardingFinancialGoals(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(SetUserOnboardingFinancialGoals, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailSetUserProfilePicture(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(SetUserProfilePicture, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailSetUserReportedAttributionChannels(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(SetUserReportedAttributionChannels, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailStartRetailSync(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(StartRetailSync, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailStartSavingsGoalsMigration(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(StartSavingsGoalsMigration, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailSubmitAssistantFeedback(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(SubmitAssistantFeedback, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailSyncCredentialAfterReconnect(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(SyncCredentialAfterReconnect, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailToggleCreditScoreTracking(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(ToggleCreditScoreTracking, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailTransferAccountDataAsync(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(TransferAccountDataAsync, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailTriggerRecurringMerchantSearch(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(TriggerRecurringMerchantSearch, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailUnarchiveGoal(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(UnarchiveGoal, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailUndeleteAccount(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(UndeleteAccount, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailUnreconciledSpendingEvents(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(UnreconciledSpendingEvents, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailUpdateAccountsForEditingEntities(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(UpdateAccountsForEditingEntities, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailUpdateAccountsForEditingOwnership(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(UpdateAccountsForEditingOwnership, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailUpdateAllNotificationPreferencesForPlatform(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data =
                    LongTailResponseData(
                        result = exec(UpdateAllNotificationPreferencesForPlatform, longTailRequest?.variables.orEmpty()),
                    ),
            ),
        )

    override fun longTailUpdateCategoryBudgetVariability(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(UpdateCategoryBudgetVariability, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailUpdateCategoryExcludeFromBudget(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(UpdateCategoryExcludeFromBudget, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailUpdateCredential(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(UpdateCredential, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailUpdateDashboardConfig(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(UpdateDashboardConfig, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailUpdateDoNotSellOrShare(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(UpdateDoNotSellOrShare, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailUpdateFinancialInsightStatus(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(UpdateFinancialInsightStatus, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailUpdateGoalAccountAllocation(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(UpdateGoalAccountAllocation, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailUpdateMyHousehold(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(UpdateMyHousehold, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailUpdateRetailOrder(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(UpdateRetailOrder, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailUpdateRetailVendorSettings(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(UpdateRetailVendorSettings, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailUpdateSavingsGoalAccountIncludeInGoalContributions(
        longTailRequest: LongTailRequest?,
    ): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data =
                    LongTailResponseData(
                        result = exec(UpdateSavingsGoalAccountIncludeInGoalContributions, longTailRequest?.variables.orEmpty()),
                    ),
            ),
        )

    override fun longTailUpdateSavingsGoalAccountLink(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(UpdateSavingsGoalAccountLink, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailUpdateSavingsGoalEvent(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(UpdateSavingsGoalEvent, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailUpdateSponsorshipInvite(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(UpdateSponsorshipInvite, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailUpdateTransaction(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(UpdateTransaction, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailUpdateTransactionTag(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(UpdateTransactionTag, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailUpdateTransactionTagOrder(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(UpdateTransactionTagOrder, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailUpdateUserProfile(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(UpdateUserProfile, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailUpdateUserProfileFlags(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(UpdateUserProfileFlags, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailUserDevicesUsage(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(UserDevicesUsage, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailUserProfileFlags(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(UserProfileFlags, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailWithdrawAllGoalContributionsFromAccount(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(WithdrawAllGoalContributionsFromAccount, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailCreateHouseholdAccessGrant(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(CreateHouseholdAccessGrant, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailCreatePromoCodeCheckoutSession(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(CreatePromoCodeCheckoutSession, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailDismissBusinessEntitiesBanner(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(DismissBusinessEntitiesBanner, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetBusinessEntities(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetBusinessEntities, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetBusinessEntitiesBannerProfile(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetBusinessEntitiesBannerProfile, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetBusinessEntitiesSummary(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetBusinessEntitiesSummary, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailRecordBusinessEntitiesBannerImpression(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(RecordBusinessEntitiesBannerImpression, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetAggregatesGraph(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetAggregatesGraph, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetAggregatesGraphCategoryGroup(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetAggregatesGraphCategoryGroup, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetAggregatesGraphFlexExpense(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetAggregatesGraphFlexExpense, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetCanRequestReview(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetCanRequestReview, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetCanSkipPremiumUpsell(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetCanSkipPremiumUpsell, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetCategoryDetails(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetCategoryDetails, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetCategoryGroup(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetCategoryGroup, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetCategoryGroups(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetCategoryGroups, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetContactSupportFormRecommendedResolution(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data =
                    LongTailResponseData(
                        result = exec(GetContactSupportFormRecommendedResolution, longTailRequest?.variables.orEmpty()),
                    ),
            ),
        )

    override fun longTailGetDashboardConfig(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetDashboardConfig, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetGoalsV2(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetGoalsV2, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetHoldingDetailsFormSecurityDetails(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetHoldingDetailsFormSecurityDetails, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetHoldingSummarySecurityDetails(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetHoldingSummarySecurityDetails, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetInstitutionByProviderId(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetInstitutionByProviderId, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetInstitutionLogoByPlaidId(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetInstitutionLogoByPlaidId, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetMerchantDetails(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetMerchantDetails, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetMobileSubscriptionOffering(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetMobileSubscriptionOffering, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetSubscriptionStatus(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetSubscriptionStatus, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetTransactionFiltersCard(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetTransactionFiltersCard, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetTransactions(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetTransactions, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetTrialStatus(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetTrialStatus, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetUploadStatementSession(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetUploadStatementSession, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGetYearlyReviewStatus(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GetYearlyReviewStatus, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailGoalSelectAccounts(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(GoalSelectAccounts, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailMoveMoneyScreenQuery(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(MoveMoneyScreenQuery, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailQuestionnaireIntroQuery(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(QuestionnaireIntroQuery, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailRecurringMerchantSearch(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(RecurringMerchantSearch, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailReviewQuery(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(ReviewQuery, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailSelectBudgetCategoryScreenQuery(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(SelectBudgetCategoryScreenQuery, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailTopInstitutionsQuery(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(TopInstitutionsQuery, longTailRequest?.variables.orEmpty())),
            ),
        )

    override fun longTailVehiclesSearch(longTailRequest: LongTailRequest?): ResponseEntity<LongTailResponse> =
        ResponseEntity.ok(
            LongTailResponse(
                data = LongTailResponseData(result = exec(VehiclesSearch, longTailRequest?.variables.orEmpty())),
            ),
        )
}
