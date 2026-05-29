package com.nicholasklaene.monarchbridge.graphql.operations.mobile

import com.nicholasklaene.monarchbridge.controllers.TestFixtures.jsonNode
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
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

@Suppress("LargeClass")
class MobileOperationsTest {
    @Test
    fun `AccountsMessageBlock round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = AccountsMessageBlock.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(AccountsMessageBlock.operationName).isEqualTo("Mobile_AccountsMessageBlock")
        assertThat(AccountsMessageBlock.variables(Unit)).isEmpty()
    }

    @Test
    fun `AddCategoryGroupMutation round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = AddCategoryGroupMutation.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(AddCategoryGroupMutation.operationName).isEqualTo("Mobile_AddCategoryGroupMutation")
        assertThat(AddCategoryGroupMutation.variables(Unit)).isEmpty()
    }

    @Test
    fun `CategoryDetailQuery round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = CategoryDetailQuery.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(CategoryDetailQuery.operationName).isEqualTo("Mobile_CategoryDetailQuery")
        assertThat(CategoryDetailQuery.variables(Unit)).isEmpty()
    }

    @Test
    fun `CategoryGroupDetailChartQuery round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = CategoryGroupDetailChartQuery.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(CategoryGroupDetailChartQuery.operationName).isEqualTo("Mobile_CategoryGroupDetailChartQuery")
        assertThat(CategoryGroupDetailChartQuery.variables(Unit)).isEmpty()
    }

    @Test
    fun `CategoryGroupDetailContainerQuery round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = CategoryGroupDetailContainerQuery.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(CategoryGroupDetailContainerQuery.operationName).isEqualTo("Mobile_CategoryGroupDetailContainerQuery")
        assertThat(CategoryGroupDetailContainerQuery.variables(Unit)).isEmpty()
    }

    @Test
    fun `CategoryRecommendationForTransaction round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = CategoryRecommendationForTransaction.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(CategoryRecommendationForTransaction.operationName).isEqualTo("Mobile_CategoryRecommendationForTransaction")
        assertThat(CategoryRecommendationForTransaction.variables(Unit)).isEmpty()
    }

    @Test
    fun `CreateAppleCardAccount round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = CreateAppleCardAccount.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(CreateAppleCardAccount.operationName).isEqualTo("Mobile_CreateAppleCardAccount")
        assertThat(CreateAppleCardAccount.variables(Unit)).isEmpty()
    }

    @Test
    fun `CreateCoinbaseAccount round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = CreateCoinbaseAccount.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(CreateCoinbaseAccount.operationName).isEqualTo("Mobile_CreateCoinbaseAccount")
        assertThat(CreateCoinbaseAccount.variables(Unit)).isEmpty()
    }

    @Test
    fun `CreateEditRuleSettings round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = CreateEditRuleSettings.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(CreateEditRuleSettings.operationName).isEqualTo("Mobile_CreateEditRuleSettings")
        assertThat(CreateEditRuleSettings.variables(Unit)).isEmpty()
    }

    @Test
    fun `CreateHouseholdAccessGrant round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = CreateHouseholdAccessGrant.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(CreateHouseholdAccessGrant.operationName).isEqualTo("Mobile_CreateHouseholdAccessGrant")
        assertThat(CreateHouseholdAccessGrant.variables(Unit)).isEmpty()
    }

    @Test
    fun `CreateReviewCheckinMutation round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = CreateReviewCheckinMutation.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(CreateReviewCheckinMutation.operationName).isEqualTo("Mobile_CreateReviewCheckinMutation")
        assertThat(CreateReviewCheckinMutation.variables(Unit)).isEmpty()
    }

    @Test
    fun `CreateSyncedVehicleAccount round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = CreateSyncedVehicleAccount.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(CreateSyncedVehicleAccount.operationName).isEqualTo("Mobile_CreateSyncedVehicleAccount")
        assertThat(CreateSyncedVehicleAccount.variables(Unit)).isEmpty()
    }

    @Test
    fun `CreateZillowAccount round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = CreateZillowAccount.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(CreateZillowAccount.operationName).isEqualTo("Mobile_CreateZillowAccount")
        assertThat(CreateZillowAccount.variables(Unit)).isEmpty()
    }

    @Test
    fun `CustomizeGoalScreen round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = CustomizeGoalScreen.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(CustomizeGoalScreen.operationName).isEqualTo("Mobile_CustomizeGoalScreen")
        assertThat(CustomizeGoalScreen.variables(Unit)).isEmpty()
    }

    @Test
    fun `DebugGetFinancialInsightIds round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = DebugGetFinancialInsightIds.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(DebugGetFinancialInsightIds.operationName).isEqualTo("Mobile_DebugGetFinancialInsightIds")
        assertThat(DebugGetFinancialInsightIds.variables(Unit)).isEmpty()
    }

    @Test
    fun `DebugSoftDeleteFinancialInsight round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = DebugSoftDeleteFinancialInsight.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(DebugSoftDeleteFinancialInsight.operationName).isEqualTo("Mobile_DebugSoftDeleteFinancialInsight")
        assertThat(DebugSoftDeleteFinancialInsight.variables(Unit)).isEmpty()
    }

    @Test
    fun `DeleteAccountLogo round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = DeleteAccountLogo.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(DeleteAccountLogo.operationName).isEqualTo("Mobile_DeleteAccountLogo")
        assertThat(DeleteAccountLogo.variables(Unit)).isEmpty()
    }

    @Test
    fun `DeleteAttachment round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = DeleteAttachment.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(DeleteAttachment.operationName).isEqualTo("Mobile_DeleteAttachment")
        assertThat(DeleteAttachment.variables(Unit)).isEmpty()
    }

    @Test
    fun `DeleteUserFromHousehold round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = DeleteUserFromHousehold.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(DeleteUserFromHousehold.operationName).isEqualTo("Mobile_DeleteUserFromHousehold")
        assertThat(DeleteUserFromHousehold.variables(Unit)).isEmpty()
    }

    @Test
    fun `DeleteUserProfilePicture round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = DeleteUserProfilePicture.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(DeleteUserProfilePicture.operationName).isEqualTo("Mobile_DeleteUserProfilePicture")
        assertThat(DeleteUserProfilePicture.variables(Unit)).isEmpty()
    }

    @Test
    fun `DidRequestReviewMutation round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = DidRequestReviewMutation.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(DidRequestReviewMutation.operationName).isEqualTo("Mobile_DidRequestReviewMutation")
        assertThat(DidRequestReviewMutation.variables(Unit)).isEmpty()
    }

    @Test
    fun `DirectLinkInstitutionModal round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = DirectLinkInstitutionModal.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(DirectLinkInstitutionModal.operationName).isEqualTo("Mobile_DirectLinkInstitutionModal")
        assertThat(DirectLinkInstitutionModal.variables(Unit)).isEmpty()
    }

    @Test
    fun `DrawerMenu round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = DrawerMenu.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(DrawerMenu.operationName).isEqualTo("Mobile_DrawerMenu")
        assertThat(DrawerMenu.variables(Unit)).isEmpty()
    }

    @Test
    fun `GetAccount round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = GetAccount.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(GetAccount.operationName).isEqualTo("Mobile_GetAccount")
        assertThat(GetAccount.variables(Unit)).isEmpty()
    }

    @Test
    fun `GetAccountDetailScreen round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = GetAccountDetailScreen.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(GetAccountDetailScreen.operationName).isEqualTo("Mobile_GetAccountDetailScreen")
        assertThat(GetAccountDetailScreen.variables(Unit)).isEmpty()
    }

    @Test
    fun `GetAccountOptions round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = GetAccountOptions.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(GetAccountOptions.operationName).isEqualTo("Mobile_GetAccountOptions")
        assertThat(GetAccountOptions.variables(Unit)).isEmpty()
    }

    @Test
    fun `GetAccountsListBlock round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = GetAccountsListBlock.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(GetAccountsListBlock.operationName).isEqualTo("Mobile_GetAccountsListBlock")
        assertThat(GetAccountsListBlock.variables(Unit)).isEmpty()
    }

    @Test
    fun `GetAddTransactionScreen round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = GetAddTransactionScreen.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(GetAddTransactionScreen.operationName).isEqualTo("Mobile_GetAddTransactionScreen")
        assertThat(GetAddTransactionScreen.variables(Unit)).isEmpty()
    }

    @Test
    fun `GetCategoryDeletionInfo round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = GetCategoryDeletionInfo.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(GetCategoryDeletionInfo.operationName).isEqualTo("Mobile_GetCategoryDeletionInfo")
        assertThat(GetCategoryDeletionInfo.variables(Unit)).isEmpty()
    }

    @Test
    fun `GetCategoryGroupsWithCategories round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = GetCategoryGroupsWithCategories.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(GetCategoryGroupsWithCategories.operationName).isEqualTo("Mobile_GetCategoryGroupsWithCategories")
        assertThat(GetCategoryGroupsWithCategories.variables(Unit)).isEmpty()
    }

    @Test
    fun `GetDuplicateCredentials round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = GetDuplicateCredentials.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(GetDuplicateCredentials.operationName).isEqualTo("Mobile_GetDuplicateCredentials")
        assertThat(GetDuplicateCredentials.variables(Unit)).isEmpty()
    }

    @Test
    fun `GetEditAccountScreen round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = GetEditAccountScreen.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(GetEditAccountScreen.operationName).isEqualTo("Mobile_GetEditAccountScreen")
        assertThat(GetEditAccountScreen.variables(Unit)).isEmpty()
    }

    @Test
    fun `GetEventPopoverTransactions round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = GetEventPopoverTransactions.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(GetEventPopoverTransactions.operationName).isEqualTo("Mobile_GetEventPopoverTransactions")
        assertThat(GetEventPopoverTransactions.variables(Unit)).isEmpty()
    }

    @Test
    fun `GetInvestmentsAccounts round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = GetInvestmentsAccounts.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(GetInvestmentsAccounts.operationName).isEqualTo("Mobile_GetInvestmentsAccounts")
        assertThat(GetInvestmentsAccounts.variables(Unit)).isEmpty()
    }

    @Test
    fun `GetInvestmentsDashboardCard round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = GetInvestmentsDashboardCard.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(GetInvestmentsDashboardCard.operationName).isEqualTo("Mobile_GetInvestmentsDashboardCard")
        assertThat(GetInvestmentsDashboardCard.variables(Unit)).isEmpty()
    }

    @Test
    fun `GetInvestmentsHoldingsList round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = GetInvestmentsHoldingsList.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(GetInvestmentsHoldingsList.operationName).isEqualTo("Mobile_GetInvestmentsHoldingsList")
        assertThat(GetInvestmentsHoldingsList.variables(Unit)).isEmpty()
    }

    @Test
    fun `GetInvestmentsPortfolio round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = GetInvestmentsPortfolio.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(GetInvestmentsPortfolio.operationName).isEqualTo("Mobile_GetInvestmentsPortfolio")
        assertThat(GetInvestmentsPortfolio.variables(Unit)).isEmpty()
    }

    @Test
    fun `GetInvestmentsWidgetData round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = GetInvestmentsWidgetData.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(GetInvestmentsWidgetData.operationName).isEqualTo("Mobile_GetInvestmentsWidgetData")
        assertThat(GetInvestmentsWidgetData.variables(Unit)).isEmpty()
    }

    @Test
    fun `GetMerchantsListScreen round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = GetMerchantsListScreen.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(GetMerchantsListScreen.operationName).isEqualTo("Mobile_GetMerchantsListScreen")
        assertThat(GetMerchantsListScreen.variables(Unit)).isEmpty()
    }

    @Test
    fun `GetPastSplits round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = GetPastSplits.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(GetPastSplits.operationName).isEqualTo("Mobile_GetPastSplits")
        assertThat(GetPastSplits.variables(Unit)).isEmpty()
    }

    @Test
    fun `GetPortfolioBenchmarks round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = GetPortfolioBenchmarks.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(GetPortfolioBenchmarks.operationName).isEqualTo("Mobile_GetPortfolioBenchmarks")
        assertThat(GetPortfolioBenchmarks.variables(Unit)).isEmpty()
    }

    @Test
    fun `GetSecuritiesHistoricalChart round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = GetSecuritiesHistoricalChart.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(GetSecuritiesHistoricalChart.operationName).isEqualTo("Mobile_GetSecuritiesHistoricalChart")
        assertThat(GetSecuritiesHistoricalChart.variables(Unit)).isEmpty()
    }

    @Test
    fun `GetSecuritiesHistoricalPerformance round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = GetSecuritiesHistoricalPerformance.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(GetSecuritiesHistoricalPerformance.operationName).isEqualTo("Mobile_GetSecuritiesHistoricalPerformance")
        assertThat(GetSecuritiesHistoricalPerformance.variables(Unit)).isEmpty()
    }

    @Test
    fun `GetSelectCategoryScreen round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = GetSelectCategoryScreen.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(GetSelectCategoryScreen.operationName).isEqualTo("Mobile_GetSelectCategoryScreen")
        assertThat(GetSelectCategoryScreen.variables(Unit)).isEmpty()
    }

    @Test
    fun `GetSelectMerchantScreenHouseholdMerchants round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = GetSelectMerchantScreenHouseholdMerchants.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(GetSelectMerchantScreenHouseholdMerchants.operationName).isEqualTo("Mobile_GetSelectMerchantScreenHouseholdMerchants")
        assertThat(GetSelectMerchantScreenHouseholdMerchants.variables(Unit)).isEmpty()
    }

    @Test
    fun `GetSelectMerchantScreenRecommendedMerchants round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = GetSelectMerchantScreenRecommendedMerchants.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(
            GetSelectMerchantScreenRecommendedMerchants.operationName,
        ).isEqualTo("Mobile_GetSelectMerchantScreenRecommendedMerchants")
        assertThat(GetSelectMerchantScreenRecommendedMerchants.variables(Unit)).isEmpty()
    }

    @Test
    fun `GetSelectMerchantScreenTransactionDetails round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = GetSelectMerchantScreenTransactionDetails.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(GetSelectMerchantScreenTransactionDetails.operationName).isEqualTo("Mobile_GetSelectMerchantScreenTransactionDetails")
        assertThat(GetSelectMerchantScreenTransactionDetails.variables(Unit)).isEmpty()
    }

    @Test
    fun `GetTransactionDetailScreen round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = GetTransactionDetailScreen.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(GetTransactionDetailScreen.operationName).isEqualTo("Mobile_GetTransactionDetailScreen")
        assertThat(GetTransactionDetailScreen.variables(Unit)).isEmpty()
    }

    @Test
    fun `GetTransactionsAndCategoriesForWidget round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = GetTransactionsAndCategoriesForWidget.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(GetTransactionsAndCategoriesForWidget.operationName).isEqualTo("Mobile_GetTransactionsAndCategoriesForWidget")
        assertThat(GetTransactionsAndCategoriesForWidget.variables(Unit)).isEmpty()
    }

    @Test
    fun `GoalDetailScreenV2 round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = GoalDetailScreenV2.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(GoalDetailScreenV2.operationName).isEqualTo("Mobile_GoalDetailScreenV2")
        assertThat(GoalDetailScreenV2.variables(Unit)).isEmpty()
    }

    @Test
    fun `GoalSelectGoals round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = GoalSelectGoals.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(GoalSelectGoals.operationName).isEqualTo("Mobile_GoalSelectGoals")
        assertThat(GoalSelectGoals.variables(Unit)).isEmpty()
    }

    @Test
    fun `GoalsAllocateBalanceScreen round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = GoalsAllocateBalanceScreen.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(GoalsAllocateBalanceScreen.operationName).isEqualTo("Mobile_GoalsAllocateBalanceScreen")
        assertThat(GoalsAllocateBalanceScreen.variables(Unit)).isEmpty()
    }

    @Test
    fun `GoalsDashboardCardV2 round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = GoalsDashboardCardV2.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(GoalsDashboardCardV2.operationName).isEqualTo("Mobile_GoalsDashboardCardV2")
        assertThat(GoalsDashboardCardV2.variables(Unit)).isEmpty()
    }

    @Test
    fun `GoalsMapAccountsScreen round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = GoalsMapAccountsScreen.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(GoalsMapAccountsScreen.operationName).isEqualTo("Mobile_GoalsMapAccountsScreen")
        assertThat(GoalsMapAccountsScreen.variables(Unit)).isEmpty()
    }

    @Test
    fun `GoalsMessageBlock round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = GoalsMessageBlock.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(GoalsMessageBlock.operationName).isEqualTo("Mobile_GoalsMessageBlock")
        assertThat(GoalsMessageBlock.variables(Unit)).isEmpty()
    }

    @Test
    fun `GoalsMonthlyBudgetsScreen round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = GoalsMonthlyBudgetsScreen.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(GoalsMonthlyBudgetsScreen.operationName).isEqualTo("Mobile_GoalsMonthlyBudgetsScreen")
        assertThat(GoalsMonthlyBudgetsScreen.variables(Unit)).isEmpty()
    }

    @Test
    fun `GoalsPreTaxBudgetsScreen round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = GoalsPreTaxBudgetsScreen.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(GoalsPreTaxBudgetsScreen.operationName).isEqualTo("Mobile_GoalsPreTaxBudgetsScreen")
        assertThat(GoalsPreTaxBudgetsScreen.variables(Unit)).isEmpty()
    }

    @Test
    fun `GoalsScreenV2 round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = GoalsScreenV2.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(GoalsScreenV2.operationName).isEqualTo("Mobile_GoalsScreenV2")
        assertThat(GoalsScreenV2.variables(Unit)).isEmpty()
    }

    @Test
    fun `GoalsTargetAmountsScreen round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = GoalsTargetAmountsScreen.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(GoalsTargetAmountsScreen.operationName).isEqualTo("Mobile_GoalsTargetAmountsScreen")
        assertThat(GoalsTargetAmountsScreen.variables(Unit)).isEmpty()
    }

    @Test
    fun `InitialPermissionRequestModal round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = InitialPermissionRequestModal.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(InitialPermissionRequestModal.operationName).isEqualTo("Mobile_InitialPermissionRequestModal")
        assertThat(InitialPermissionRequestModal.variables(Unit)).isEmpty()
    }

    @Test
    fun `InviteEmail round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = InviteEmail.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(InviteEmail.operationName).isEqualTo("Mobile_InviteEmail")
        assertThat(InviteEmail.variables(Unit)).isEmpty()
    }

    @Test
    fun `InvitePartner round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = InvitePartner.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(InvitePartner.operationName).isEqualTo("Mobile_InvitePartner")
        assertThat(InvitePartner.variables(Unit)).isEmpty()
    }

    @Test
    fun `LinkGoalOptions round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = LinkGoalOptions.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(LinkGoalOptions.operationName).isEqualTo("Mobile_LinkGoalOptions")
        assertThat(LinkGoalOptions.variables(Unit)).isEmpty()
    }

    @Test
    fun `LinkSearchInstitutionsQuery round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = LinkSearchInstitutionsQuery.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(LinkSearchInstitutionsQuery.operationName).isEqualTo("Mobile_LinkSearchInstitutionsQuery")
        assertThat(LinkSearchInstitutionsQuery.variables(Unit)).isEmpty()
    }

    @Test
    fun `MerchantChartQuery round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = MerchantChartQuery.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(MerchantChartQuery.operationName).isEqualTo("Mobile_MerchantChartQuery")
        assertThat(MerchantChartQuery.variables(Unit)).isEmpty()
    }

    @Test
    fun `MerchantDetailContainerQuery round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = MerchantDetailContainerQuery.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(MerchantDetailContainerQuery.operationName).isEqualTo("Mobile_MerchantDetailContainerQuery")
        assertThat(MerchantDetailContainerQuery.variables(Unit)).isEmpty()
    }

    @Test
    fun `MoveMoneyScreenMutation round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = MoveMoneyScreenMutation.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(MoveMoneyScreenMutation.operationName).isEqualTo("Mobile_MoveMoneyScreenMutation")
        assertThat(MoveMoneyScreenMutation.variables(Unit)).isEmpty()
    }

    @Test
    fun `NetWorthChartOverlyQuery round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = NetWorthChartOverlyQuery.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(NetWorthChartOverlyQuery.operationName).isEqualTo("Mobile_NetWorthChartOverlyQuery")
        assertThat(NetWorthChartOverlyQuery.variables(Unit)).isEmpty()
    }

    @Test
    fun `OldestDeletableSyncedSnapshotDate round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = OldestDeletableSyncedSnapshotDate.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(OldestDeletableSyncedSnapshotDate.operationName).isEqualTo("Mobile_OldestDeletableSyncedSnapshotDate")
        assertThat(OldestDeletableSyncedSnapshotDate.variables(Unit)).isEmpty()
    }

    @Test
    fun `PreviewDeleteSyncedSnapshots round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = PreviewDeleteSyncedSnapshots.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(PreviewDeleteSyncedSnapshots.operationName).isEqualTo("Mobile_PreviewDeleteSyncedSnapshots")
        assertThat(PreviewDeleteSyncedSnapshots.variables(Unit)).isEmpty()
    }

    @Test
    fun `RankGoalsScreen round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = RankGoalsScreen.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(RankGoalsScreen.operationName).isEqualTo("Mobile_RankGoalsScreen")
        assertThat(RankGoalsScreen.variables(Unit)).isEmpty()
    }

    @Test
    fun `RapidTransactionReviewFormContainer round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = RapidTransactionReviewFormContainer.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(RapidTransactionReviewFormContainer.operationName).isEqualTo("Mobile_RapidTransactionReviewFormContainer")
        assertThat(RapidTransactionReviewFormContainer.variables(Unit)).isEmpty()
    }

    @Test
    fun `RapidTransactionReviewScreen round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = RapidTransactionReviewScreen.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(RapidTransactionReviewScreen.operationName).isEqualTo("Mobile_RapidTransactionReviewScreen")
        assertThat(RapidTransactionReviewScreen.variables(Unit)).isEmpty()
    }

    @Test
    fun `ResetHouseholdRecurringMerchantSearch round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = ResetHouseholdRecurringMerchantSearch.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(ResetHouseholdRecurringMerchantSearch.operationName).isEqualTo("Mobile_ResetHouseholdRecurringMerchantSearch")
        assertThat(ResetHouseholdRecurringMerchantSearch.variables(Unit)).isEmpty()
    }

    @Test
    fun `ResetRolloverMutation round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = ResetRolloverMutation.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(ResetRolloverMutation.operationName).isEqualTo("Mobile_ResetRolloverMutation")
        assertThat(ResetRolloverMutation.variables(Unit)).isEmpty()
    }

    @Test
    fun `RestoreCategoryMutation round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = RestoreCategoryMutation.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(RestoreCategoryMutation.operationName).isEqualTo("Mobile_RestoreCategoryMutation")
        assertThat(RestoreCategoryMutation.variables(Unit)).isEmpty()
    }

    @Test
    fun `ReviewDashboardQuery round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = ReviewDashboardQuery.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(ReviewDashboardQuery.operationName).isEqualTo("Mobile_ReviewDashboardQuery")
        assertThat(ReviewDashboardQuery.variables(Unit)).isEmpty()
    }

    @Test
    fun `ReviewTransactionsDashboardButton round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = ReviewTransactionsDashboardButton.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(ReviewTransactionsDashboardButton.operationName).isEqualTo("Mobile_ReviewTransactionsDashboardButton")
        assertThat(ReviewTransactionsDashboardButton.variables(Unit)).isEmpty()
    }

    @Test
    fun `RulesSettingsScreenQuery round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = RulesSettingsScreenQuery.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(RulesSettingsScreenQuery.operationName).isEqualTo("Mobile_RulesSettingsScreenQuery")
        assertThat(RulesSettingsScreenQuery.variables(Unit)).isEmpty()
    }

    @Test
    fun `SavingsGoalFilterOptions round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = SavingsGoalFilterOptions.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(SavingsGoalFilterOptions.operationName).isEqualTo("Mobile_SavingsGoalFilterOptions")
        assertThat(SavingsGoalFilterOptions.variables(Unit)).isEmpty()
    }

    @Test
    fun `SearchInstitutionsQuery round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = SearchInstitutionsQuery.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(SearchInstitutionsQuery.operationName).isEqualTo("Mobile_SearchInstitutionsQuery")
        assertThat(SearchInstitutionsQuery.variables(Unit)).isEmpty()
    }

    @Test
    fun `SearchMerchants round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = SearchMerchants.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(SearchMerchants.operationName).isEqualTo("Mobile_SearchMerchants")
        assertThat(SearchMerchants.variables(Unit)).isEmpty()
    }

    @Test
    fun `SearchVehiclesQuery round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = SearchVehiclesQuery.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(SearchVehiclesQuery.operationName).isEqualTo("Mobile_SearchVehiclesQuery")
        assertThat(SearchVehiclesQuery.variables(Unit)).isEmpty()
    }

    @Test
    fun `SelectGoalsScreen round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = SelectGoalsScreen.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(SelectGoalsScreen.operationName).isEqualTo("Mobile_SelectGoalsScreen")
        assertThat(SelectGoalsScreen.variables(Unit)).isEmpty()
    }

    @Test
    fun `SetTransactionTagsRapidReview round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = SetTransactionTagsRapidReview.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(SetTransactionTagsRapidReview.operationName).isEqualTo("Mobile_SetTransactionTagsRapidReview")
        assertThat(SetTransactionTagsRapidReview.variables(Unit)).isEmpty()
    }

    @Test
    fun `ToggleSupportAccountAccess round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = ToggleSupportAccountAccess.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(ToggleSupportAccountAccess.operationName).isEqualTo("Mobile_ToggleSupportAccountAccess")
        assertThat(ToggleSupportAccountAccess.variables(Unit)).isEmpty()
    }

    @Test
    fun `TransactionsMessageBlock round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = TransactionsMessageBlock.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(TransactionsMessageBlock.operationName).isEqualTo("Mobile_TransactionsMessageBlock")
        assertThat(TransactionsMessageBlock.variables(Unit)).isEmpty()
    }

    @Test
    fun `UpdateCategoryGroupOrderMutation round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = UpdateCategoryGroupOrderMutation.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(UpdateCategoryGroupOrderMutation.operationName).isEqualTo("Mobile_UpdateCategoryGroupOrderMutation")
        assertThat(UpdateCategoryGroupOrderMutation.variables(Unit)).isEmpty()
    }

    @Test
    fun `UpdateCategoryMutation round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = UpdateCategoryMutation.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(UpdateCategoryMutation.operationName).isEqualTo("Mobile_UpdateCategoryMutation")
        assertThat(UpdateCategoryMutation.variables(Unit)).isEmpty()
    }

    @Test
    fun `UpdateCategoryOrderMutation round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = UpdateCategoryOrderMutation.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(UpdateCategoryOrderMutation.operationName).isEqualTo("Mobile_UpdateCategoryOrderMutation")
        assertThat(UpdateCategoryOrderMutation.variables(Unit)).isEmpty()
    }

    @Test
    fun `UpdateGoalV2 round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = UpdateGoalV2.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(UpdateGoalV2.operationName).isEqualTo("Mobile_UpdateGoalV2")
        assertThat(UpdateGoalV2.variables(Unit)).isEmpty()
    }

    @Test
    fun `UpdateGoalsPriorities round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = UpdateGoalsPriorities.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(UpdateGoalsPriorities.operationName).isEqualTo("Mobile_UpdateGoalsPriorities")
        assertThat(UpdateGoalsPriorities.variables(Unit)).isEmpty()
    }

    @Test
    fun `UpdateNonMonthlyCategory round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = UpdateNonMonthlyCategory.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(UpdateNonMonthlyCategory.operationName).isEqualTo("Mobile_UpdateNonMonthlyCategory")
        assertThat(UpdateNonMonthlyCategory.variables(Unit)).isEmpty()
    }

    @Test
    fun `UpdateReviewCheckinMutation round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = UpdateReviewCheckinMutation.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(UpdateReviewCheckinMutation.operationName).isEqualTo("Mobile_UpdateReviewCheckinMutation")
        assertThat(UpdateReviewCheckinMutation.variables(Unit)).isEmpty()
    }

    @Test
    fun `UpdateTransactionDetailScreen round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = UpdateTransactionDetailScreen.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(UpdateTransactionDetailScreen.operationName).isEqualTo("Mobile_UpdateTransactionDetailScreen")
        assertThat(UpdateTransactionDetailScreen.variables(Unit)).isEmpty()
    }

    @Test
    fun `UpdateTransactionRapidReview round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = UpdateTransactionRapidReview.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(UpdateTransactionRapidReview.operationName).isEqualTo("Mobile_UpdateTransactionRapidReview")
        assertThat(UpdateTransactionRapidReview.variables(Unit)).isEmpty()
    }

    @Test
    fun `UpdateUserFinancialProfile round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = UpdateUserFinancialProfile.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(UpdateUserFinancialProfile.operationName).isEqualTo("Mobile_UpdateUserFinancialProfile")
        assertThat(UpdateUserFinancialProfile.variables(Unit)).isEmpty()
    }

    @Test
    fun `UpsellPostalCode round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = UpsellPostalCode.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(UpsellPostalCode.operationName).isEqualTo("Mobile_Upsell_PostalCode")
        assertThat(UpsellPostalCode.variables(Unit)).isEmpty()
    }

    @Test
    fun `UserAvatar round-trips opaque payload`() {
        val data = jsonNode("""{"sample": {"id": "x"}}""")
        val out = UserAvatar.parseOutput(data)
        assertThat(out).isNotNull
        assertThat(UserAvatar.operationName).isEqualTo("Mobile_UserAvatar")
        assertThat(UserAvatar.variables(Unit)).isEmpty()
    }
}
