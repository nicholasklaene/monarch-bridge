package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.generated.api.MobileScreensApi
import com.nicholasklaene.monarchbridge.generated.model.MobileScreenAggregateResponse
import com.nicholasklaene.monarchbridge.graphql.MonarchClient
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.AccountsMessageBlock
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.AddCategoryGroupMutation
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.CategoryDetailQuery
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.CategoryGroupDetailChartQuery
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.CategoryGroupDetailContainerQuery
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.CategoryRecommendationForTransaction
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.CreateAppleCardAccount
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.CreateCoinbaseAccount
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.CreateEditRuleSettings
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.CreateHouseholdAccessGrant
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.CreateReviewCheckinMutation
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.CreateSyncedVehicleAccount
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.CreateZillowAccount
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.CustomizeGoalScreen
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.DebugGetFinancialInsightIds
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.DebugSoftDeleteFinancialInsight
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.DeleteAccountLogo
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.DeleteAttachment
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.DeleteUserFromHousehold
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.DeleteUserProfilePicture
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.DidRequestReviewMutation
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.DirectLinkInstitutionModal
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.DrawerMenu
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.GetAccount
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.GetAccountDetailScreen
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.GetAccountOptions
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.GetAccountsListBlock
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.GetAddTransactionScreen
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.GetCategoryDeletionInfo
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.GetCategoryGroupsWithCategories
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.GetDuplicateCredentials
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.GetEditAccountScreen
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.GetEventPopoverTransactions
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.GetInvestmentsAccounts
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.GetInvestmentsDashboardCard
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.GetInvestmentsHoldingsList
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.GetInvestmentsPortfolio
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.GetInvestmentsWidgetData
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.GetMerchantsListScreen
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.GetPastSplits
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.GetPortfolioBenchmarks
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.GetSecuritiesHistoricalChart
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.GetSecuritiesHistoricalPerformance
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.GetSelectCategoryScreen
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.GetSelectMerchantScreenHouseholdMerchants
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.GetSelectMerchantScreenRecommendedMerchants
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.GetSelectMerchantScreenTransactionDetails
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.GetTransactionDetailScreen
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.GetTransactionsAndCategoriesForWidget
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.GoalDetailScreenV2
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.GoalSelectGoals
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.GoalsAllocateBalanceScreen
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.GoalsDashboardCardV2
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.GoalsMapAccountsScreen
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.GoalsMessageBlock
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.GoalsMonthlyBudgetsScreen
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.GoalsPreTaxBudgetsScreen
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.GoalsScreenV2
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.GoalsTargetAmountsScreen
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.InitialPermissionRequestModal
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.InviteEmail
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.InvitePartner
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.LinkGoalOptions
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.LinkSearchInstitutionsQuery
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.MerchantChartQuery
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.MerchantDetailContainerQuery
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.MoveMoneyScreenMutation
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.NetWorthChartOverlyQuery
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.OldestDeletableSyncedSnapshotDate
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.PreviewDeleteSyncedSnapshots
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.RankGoalsScreen
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.RapidTransactionReviewFormContainer
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.RapidTransactionReviewScreen
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.ResetHouseholdRecurringMerchantSearch
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.ResetRolloverMutation
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.RestoreCategoryMutation
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.ReviewDashboardQuery
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.ReviewTransactionsDashboardButton
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.RulesSettingsScreenQuery
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.SavingsGoalFilterOptions
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.SearchInstitutionsQuery
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.SearchMerchants
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.SearchVehiclesQuery
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.SelectGoalsScreen
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.SetTransactionTagsRapidReview
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.ToggleSupportAccountAccess
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.TransactionsMessageBlock
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.UpdateCategoryGroupOrderMutation
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.UpdateCategoryMutation
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.UpdateCategoryOrderMutation
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.UpdateGoalV2
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.UpdateGoalsPriorities
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.UpdateNonMonthlyCategory
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.UpdateReviewCheckinMutation
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.UpdateTransactionDetailScreen
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.UpdateTransactionRapidReview
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.UpdateUserFinancialProfile
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.UpsellPostalCode
import com.nicholasklaene.monarchbridge.graphql.operations.mobile.UserAvatar
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

/**
 * Mobile screen-aggregate endpoints. Each route forwards exactly one Monarch
 * `Mobile_*` GraphQL operation as an opaque FreeForm response. These exist so
 * mobile-bundle parity callers (mirroring native-app screens) can hit a single
 * REST endpoint instead of issuing a raw GraphQL POST.
 *
 * Wiring layer only: the deep response tree is passed through as
 * `Map<String, Any?>`. If a specific screen aggregate becomes load-bearing for
 * a caller, lift it out of here into a dedicated controller + typed response.
 */
@RestController
@Suppress("LargeClass", "TooManyFunctions")
class MobileScreensController(
    sessionService: MonarchSessionService,
    client: MonarchClient,
) : MonarchControllerBase(sessionService, client),
    MobileScreensApi {
    /** Mobile screen query `Mobile_AccountsMessageBlock` */
    override fun mobileAccountsMessageBlock(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(AccountsMessageBlock, Unit)))

    /** Mobile screen mutation `Mobile_AddCategoryGroupMutation` */
    override fun mobileAddCategoryGroupMutation(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(AddCategoryGroupMutation, Unit)))

    /** Mobile screen query `Mobile_CategoryDetailQuery` */
    override fun mobileCategoryDetailQuery(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(CategoryDetailQuery, Unit)))

    /** Mobile screen query `Mobile_CategoryGroupDetailChartQuery` */
    override fun mobileCategoryGroupDetailChartQuery(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(CategoryGroupDetailChartQuery, Unit)))

    /** Mobile screen query `Mobile_CategoryGroupDetailContainerQuery` */
    override fun mobileCategoryGroupDetailContainerQuery(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(CategoryGroupDetailContainerQuery, Unit)))

    /** Mobile screen query `Mobile_CategoryRecommendationForTransaction` */
    override fun mobileCategoryRecommendationForTransaction(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(CategoryRecommendationForTransaction, Unit)))

    /** Mobile screen mutation `Mobile_CreateAppleCardAccount` */
    override fun mobileCreateAppleCardAccount(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(CreateAppleCardAccount, Unit)))

    /** Mobile screen mutation `Mobile_CreateCoinbaseAccount` */
    override fun mobileCreateCoinbaseAccount(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(CreateCoinbaseAccount, Unit)))

    /** Mobile screen mutation `Mobile_CreateEditRuleSettings` */
    override fun mobileCreateEditRuleSettings(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(CreateEditRuleSettings, Unit)))

    /** Mobile screen mutation `Mobile_CreateHouseholdAccessGrant` */
    override fun mobileCreateHouseholdAccessGrant(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(CreateHouseholdAccessGrant, Unit)))

    /** Mobile screen mutation `Mobile_CreateReviewCheckinMutation` */
    override fun mobileCreateReviewCheckinMutation(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(CreateReviewCheckinMutation, Unit)))

    /** Mobile screen mutation `Mobile_CreateSyncedVehicleAccount` */
    override fun mobileCreateSyncedVehicleAccount(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(CreateSyncedVehicleAccount, Unit)))

    /** Mobile screen mutation `Mobile_CreateZillowAccount` */
    override fun mobileCreateZillowAccount(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(CreateZillowAccount, Unit)))

    /** Mobile screen mutation `Mobile_CustomizeGoalScreen` */
    override fun mobileCustomizeGoalScreen(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(CustomizeGoalScreen, Unit)))

    /** Mobile screen query `Mobile_DebugGetFinancialInsightIds` */
    override fun mobileDebugGetFinancialInsightIds(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(DebugGetFinancialInsightIds, Unit)))

    /** Mobile screen mutation `Mobile_DebugSoftDeleteFinancialInsight` */
    override fun mobileDebugSoftDeleteFinancialInsight(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(DebugSoftDeleteFinancialInsight, Unit)))

    /** Mobile screen mutation `Mobile_DeleteAccountLogo` */
    override fun mobileDeleteAccountLogo(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(DeleteAccountLogo, Unit)))

    /** Mobile screen mutation `Mobile_DeleteAttachment` */
    override fun mobileDeleteAttachment(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(DeleteAttachment, Unit)))

    /** Mobile screen mutation `Mobile_DeleteUserFromHousehold` */
    override fun mobileDeleteUserFromHousehold(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(DeleteUserFromHousehold, Unit)))

    /** Mobile screen mutation `Mobile_DeleteUserProfilePicture` */
    override fun mobileDeleteUserProfilePicture(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(DeleteUserProfilePicture, Unit)))

    /** Mobile screen mutation `Mobile_DidRequestReviewMutation` */
    override fun mobileDidRequestReviewMutation(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(DidRequestReviewMutation, Unit)))

    /** Mobile screen query `Mobile_DirectLinkInstitutionModal` */
    override fun mobileDirectLinkInstitutionModal(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(DirectLinkInstitutionModal, Unit)))

    /** Mobile screen query `Mobile_DrawerMenu` */
    override fun mobileDrawerMenu(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(DrawerMenu, Unit)))

    /** Mobile screen query `Mobile_GetAccount` */
    override fun mobileGetAccount(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(GetAccount, Unit)))

    /** Mobile screen query `Mobile_GetAccountDetailScreen` */
    override fun mobileGetAccountDetailScreen(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(GetAccountDetailScreen, Unit)))

    /** Mobile screen query `Mobile_GetAccountOptions` */
    override fun mobileGetAccountOptions(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(GetAccountOptions, Unit)))

    /** Mobile screen query `Mobile_GetAccountsListBlock` */
    override fun mobileGetAccountsListBlock(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(GetAccountsListBlock, Unit)))

    /** Mobile screen query `Mobile_GetAddTransactionScreen` */
    override fun mobileGetAddTransactionScreen(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(GetAddTransactionScreen, Unit)))

    /** Mobile screen query `Mobile_GetCategoryDeletionInfo` */
    override fun mobileGetCategoryDeletionInfo(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(GetCategoryDeletionInfo, Unit)))

    /** Mobile screen query `Mobile_GetCategoryGroupsWithCategories` */
    override fun mobileGetCategoryGroupsWithCategories(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(GetCategoryGroupsWithCategories, Unit)))

    /** Mobile screen query `Mobile_GetDuplicateCredentials` */
    override fun mobileGetDuplicateCredentials(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(GetDuplicateCredentials, Unit)))

    /** Mobile screen query `Mobile_GetEditAccountScreen` */
    override fun mobileGetEditAccountScreen(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(GetEditAccountScreen, Unit)))

    /** Mobile screen query `Mobile_GetEventPopoverTransactions` */
    override fun mobileGetEventPopoverTransactions(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(GetEventPopoverTransactions, Unit)))

    /** Mobile screen query `Mobile_GetInvestmentsAccounts` */
    override fun mobileGetInvestmentsAccounts(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(GetInvestmentsAccounts, Unit)))

    /** Mobile screen query `Mobile_GetInvestmentsDashboardCard` */
    override fun mobileGetInvestmentsDashboardCard(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(GetInvestmentsDashboardCard, Unit)))

    /** Mobile screen query `Mobile_GetInvestmentsHoldingsList` */
    override fun mobileGetInvestmentsHoldingsList(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(GetInvestmentsHoldingsList, Unit)))

    /** Mobile screen query `Mobile_GetInvestmentsPortfolio` */
    override fun mobileGetInvestmentsPortfolio(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(GetInvestmentsPortfolio, Unit)))

    /** Mobile screen query `Mobile_GetInvestmentsWidgetData` */
    override fun mobileGetInvestmentsWidgetData(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(GetInvestmentsWidgetData, Unit)))

    /** Mobile screen query `Mobile_GetMerchantsListScreen` */
    override fun mobileGetMerchantsListScreen(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(GetMerchantsListScreen, Unit)))

    /** Mobile screen query `Mobile_GetPastSplits` */
    override fun mobileGetPastSplits(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(GetPastSplits, Unit)))

    /** Mobile screen query `Mobile_GetPortfolioBenchmarks` */
    override fun mobileGetPortfolioBenchmarks(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(GetPortfolioBenchmarks, Unit)))

    /** Mobile screen query `Mobile_GetSecuritiesHistoricalChart` */
    override fun mobileGetSecuritiesHistoricalChart(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(GetSecuritiesHistoricalChart, Unit)))

    /** Mobile screen query `Mobile_GetSecuritiesHistoricalPerformance` */
    override fun mobileGetSecuritiesHistoricalPerformance(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(GetSecuritiesHistoricalPerformance, Unit)))

    /** Mobile screen query `Mobile_GetSelectCategoryScreen` */
    override fun mobileGetSelectCategoryScreen(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(GetSelectCategoryScreen, Unit)))

    /** Mobile screen query `Mobile_GetSelectMerchantScreenHouseholdMerchants` */
    override fun mobileGetSelectMerchantScreenHouseholdMerchants(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(GetSelectMerchantScreenHouseholdMerchants, Unit)))

    /** Mobile screen query `Mobile_GetSelectMerchantScreenRecommendedMerchants` */
    override fun mobileGetSelectMerchantScreenRecommendedMerchants(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(GetSelectMerchantScreenRecommendedMerchants, Unit)))

    /** Mobile screen query `Mobile_GetSelectMerchantScreenTransactionDetails` */
    override fun mobileGetSelectMerchantScreenTransactionDetails(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(GetSelectMerchantScreenTransactionDetails, Unit)))

    /** Mobile screen query `Mobile_GetTransactionDetailScreen` */
    override fun mobileGetTransactionDetailScreen(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(GetTransactionDetailScreen, Unit)))

    /** Mobile screen query `Mobile_GetTransactionsAndCategoriesForWidget` */
    override fun mobileGetTransactionsAndCategoriesForWidget(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(GetTransactionsAndCategoriesForWidget, Unit)))

    /** Mobile screen query `Mobile_GoalDetailScreenV2` */
    override fun mobileGoalDetailScreenV2(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(GoalDetailScreenV2, Unit)))

    /** Mobile screen query `Mobile_GoalSelectGoals` */
    override fun mobileGoalSelectGoals(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(GoalSelectGoals, Unit)))

    /** Mobile screen mutation `Mobile_GoalsAllocateBalanceScreen` */
    override fun mobileGoalsAllocateBalanceScreen(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(GoalsAllocateBalanceScreen, Unit)))

    /** Mobile screen query `Mobile_GoalsDashboardCardV2` */
    override fun mobileGoalsDashboardCardV2(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(GoalsDashboardCardV2, Unit)))

    /** Mobile screen mutation `Mobile_GoalsMapAccountsScreen` */
    override fun mobileGoalsMapAccountsScreen(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(GoalsMapAccountsScreen, Unit)))

    /** Mobile screen query `Mobile_GoalsMessageBlock` */
    override fun mobileGoalsMessageBlock(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(GoalsMessageBlock, Unit)))

    /** Mobile screen query `Mobile_GoalsMonthlyBudgetsScreen` */
    override fun mobileGoalsMonthlyBudgetsScreen(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(GoalsMonthlyBudgetsScreen, Unit)))

    /** Mobile screen query `Mobile_GoalsPreTaxBudgetsScreen` */
    override fun mobileGoalsPreTaxBudgetsScreen(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(GoalsPreTaxBudgetsScreen, Unit)))

    /** Mobile screen query `Mobile_GoalsScreenV2` */
    override fun mobileGoalsScreenV2(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(GoalsScreenV2, Unit)))

    /** Mobile screen query `Mobile_GoalsTargetAmountsScreen` */
    override fun mobileGoalsTargetAmountsScreen(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(GoalsTargetAmountsScreen, Unit)))

    /** Mobile screen query `Mobile_InitialPermissionRequestModal` */
    override fun mobileInitialPermissionRequestModal(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(InitialPermissionRequestModal, Unit)))

    /** Mobile screen mutation `Mobile_InviteEmail` */
    override fun mobileInviteEmail(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(InviteEmail, Unit)))

    /** Mobile screen mutation `Mobile_InvitePartner` */
    override fun mobileInvitePartner(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(InvitePartner, Unit)))

    /** Mobile screen query `Mobile_LinkGoalOptions` */
    override fun mobileLinkGoalOptions(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(LinkGoalOptions, Unit)))

    /** Mobile screen query `Mobile_LinkSearchInstitutionsQuery` */
    override fun mobileLinkSearchInstitutionsQuery(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(LinkSearchInstitutionsQuery, Unit)))

    /** Mobile screen query `Mobile_MerchantChartQuery` */
    override fun mobileMerchantChartQuery(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(MerchantChartQuery, Unit)))

    /** Mobile screen query `Mobile_MerchantDetailContainerQuery` */
    override fun mobileMerchantDetailContainerQuery(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(MerchantDetailContainerQuery, Unit)))

    /** Mobile screen mutation `Mobile_MoveMoneyScreenMutation` */
    override fun mobileMoveMoneyScreenMutation(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(MoveMoneyScreenMutation, Unit)))

    /** Mobile screen query `Mobile_NetWorthChartOverlyQuery` */
    override fun mobileNetWorthChartOverlyQuery(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(NetWorthChartOverlyQuery, Unit)))

    /** Mobile screen query `Mobile_OldestDeletableSyncedSnapshotDate` */
    override fun mobileOldestDeletableSyncedSnapshotDate(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(OldestDeletableSyncedSnapshotDate, Unit)))

    /** Mobile screen mutation `Mobile_PreviewDeleteSyncedSnapshots` */
    override fun mobilePreviewDeleteSyncedSnapshots(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(PreviewDeleteSyncedSnapshots, Unit)))

    /** Mobile screen mutation `Mobile_RankGoalsScreen` */
    override fun mobileRankGoalsScreen(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(RankGoalsScreen, Unit)))

    /** Mobile screen query `Mobile_RapidTransactionReviewFormContainer` */
    override fun mobileRapidTransactionReviewFormContainer(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(RapidTransactionReviewFormContainer, Unit)))

    /** Mobile screen query `Mobile_RapidTransactionReviewScreen` */
    override fun mobileRapidTransactionReviewScreen(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(RapidTransactionReviewScreen, Unit)))

    /** Mobile screen mutation `Mobile_ResetHouseholdRecurringMerchantSearch` */
    override fun mobileResetHouseholdRecurringMerchantSearch(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(ResetHouseholdRecurringMerchantSearch, Unit)))

    /** Mobile screen mutation `Mobile_ResetRolloverMutation` */
    override fun mobileResetRolloverMutation(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(ResetRolloverMutation, Unit)))

    /** Mobile screen mutation `Mobile_RestoreCategoryMutation` */
    override fun mobileRestoreCategoryMutation(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(RestoreCategoryMutation, Unit)))

    /** Mobile screen query `Mobile_ReviewDashboardQuery` */
    override fun mobileReviewDashboardQuery(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(ReviewDashboardQuery, Unit)))

    /** Mobile screen query `Mobile_ReviewTransactionsDashboardButton` */
    override fun mobileReviewTransactionsDashboardButton(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(ReviewTransactionsDashboardButton, Unit)))

    /** Mobile screen query `Mobile_RulesSettingsScreenQuery` */
    override fun mobileRulesSettingsScreenQuery(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(RulesSettingsScreenQuery, Unit)))

    /** Mobile screen query `Mobile_SavingsGoalFilterOptions` */
    override fun mobileSavingsGoalFilterOptions(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(SavingsGoalFilterOptions, Unit)))

    /** Mobile screen query `Mobile_SearchInstitutionsQuery` */
    override fun mobileSearchInstitutionsQuery(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(SearchInstitutionsQuery, Unit)))

    /** Mobile screen query `Mobile_SearchMerchants` */
    override fun mobileSearchMerchants(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(SearchMerchants, Unit)))

    /** Mobile screen query `Mobile_SearchVehiclesQuery` */
    override fun mobileSearchVehiclesQuery(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(SearchVehiclesQuery, Unit)))

    /** Mobile screen query `Mobile_SelectGoalsScreen` */
    override fun mobileSelectGoalsScreen(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(SelectGoalsScreen, Unit)))

    /** Mobile screen mutation `Mobile_SetTransactionTagsRapidReview` */
    override fun mobileSetTransactionTagsRapidReview(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(SetTransactionTagsRapidReview, Unit)))

    /** Mobile screen mutation `Mobile_ToggleSupportAccountAccess` */
    override fun mobileToggleSupportAccountAccess(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(ToggleSupportAccountAccess, Unit)))

    /** Mobile screen query `Mobile_TransactionsMessageBlock` */
    override fun mobileTransactionsMessageBlock(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(TransactionsMessageBlock, Unit)))

    /** Mobile screen mutation `Mobile_UpdateCategoryGroupOrderMutation` */
    override fun mobileUpdateCategoryGroupOrderMutation(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(UpdateCategoryGroupOrderMutation, Unit)))

    /** Mobile screen mutation `Mobile_UpdateCategoryMutation` */
    override fun mobileUpdateCategoryMutation(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(UpdateCategoryMutation, Unit)))

    /** Mobile screen mutation `Mobile_UpdateCategoryOrderMutation` */
    override fun mobileUpdateCategoryOrderMutation(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(UpdateCategoryOrderMutation, Unit)))

    /** Mobile screen mutation `Mobile_UpdateGoalV2` */
    override fun mobileUpdateGoalV2(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(UpdateGoalV2, Unit)))

    /** Mobile screen mutation `Mobile_UpdateGoalsPriorities` */
    override fun mobileUpdateGoalsPriorities(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(UpdateGoalsPriorities, Unit)))

    /** Mobile screen mutation `Mobile_UpdateNonMonthlyCategory` */
    override fun mobileUpdateNonMonthlyCategory(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(UpdateNonMonthlyCategory, Unit)))

    /** Mobile screen mutation `Mobile_UpdateReviewCheckinMutation` */
    override fun mobileUpdateReviewCheckinMutation(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(UpdateReviewCheckinMutation, Unit)))

    /** Mobile screen mutation `Mobile_UpdateTransactionDetailScreen` */
    override fun mobileUpdateTransactionDetailScreen(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(UpdateTransactionDetailScreen, Unit)))

    /** Mobile screen mutation `Mobile_UpdateTransactionRapidReview` */
    override fun mobileUpdateTransactionRapidReview(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(UpdateTransactionRapidReview, Unit)))

    /** Mobile screen mutation `Mobile_UpdateUserFinancialProfile` */
    override fun mobileUpdateUserFinancialProfile(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(UpdateUserFinancialProfile, Unit)))

    /** Mobile screen mutation `Mobile_Upsell_PostalCode` */
    override fun mobileUpsellPostalCode(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(UpsellPostalCode, Unit)))

    /** Mobile screen query `Mobile_UserAvatar` */
    override fun mobileUserAvatar(): ResponseEntity<MobileScreenAggregateResponse> =
        ResponseEntity.ok(MobileScreenAggregateResponse(data = exec(UserAvatar, Unit)))
}
