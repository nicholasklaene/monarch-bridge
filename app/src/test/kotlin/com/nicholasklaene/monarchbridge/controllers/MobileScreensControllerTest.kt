package com.nicholasklaene.monarchbridge.controllers

import com.nicholasklaene.monarchbridge.auth.MonarchSessionService
import com.nicholasklaene.monarchbridge.config.GlobalExceptionHandler
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.FAKE_SESSION
import com.nicholasklaene.monarchbridge.controllers.TestFixtures.stubExec
import com.nicholasklaene.monarchbridge.exceptions.MonarchSessionMissingException
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

@WebMvcTest(MobileScreensController::class)
@Import(GlobalExceptionHandler::class)
@Suppress("LargeClass")
class MobileScreensControllerTest {
    @Autowired private lateinit var mvc: MockMvc

    @MockitoBean private lateinit var sessionService: MonarchSessionService

    @MockitoBean private lateinit var client: MonarchClient

    @Test
    fun `mobileAccountsMessageBlock returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/accounts-message-block"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileAddCategoryGroupMutation returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/add-category-group-mutation"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileCategoryDetailQuery returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/category-detail-query"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileCategoryGroupDetailChartQuery returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/category-group-detail-chart-query"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileCategoryGroupDetailContainerQuery returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/category-group-detail-container-query"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileCategoryRecommendationForTransaction returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/category-recommendation-for-transaction"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileCreateAppleCardAccount returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/create-apple-card-account"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileCreateCoinbaseAccount returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/create-coinbase-account"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileCreateEditRuleSettings returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/create-edit-rule-settings"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileCreateHouseholdAccessGrant returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/create-household-access-grant"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileCreateReviewCheckinMutation returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/create-review-checkin-mutation"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileCreateSyncedVehicleAccount returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/create-synced-vehicle-account"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileCreateZillowAccount returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/create-zillow-account"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileCustomizeGoalScreen returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/customize-goal-screen"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileDebugGetFinancialInsightIds returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/debug-get-financial-insight-ids"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileDebugSoftDeleteFinancialInsight returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/debug-soft-delete-financial-insight"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileDeleteAccountLogo returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/delete-account-logo"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileDeleteAttachment returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/delete-attachment"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileDeleteUserFromHousehold returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/delete-user-from-household"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileDeleteUserProfilePicture returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/delete-user-profile-picture"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileDidRequestReviewMutation returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/did-request-review-mutation"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileDirectLinkInstitutionModal returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/direct-link-institution-modal"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileDrawerMenu returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/drawer-menu"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileGetAccount returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/get-account"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileGetAccountDetailScreen returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/get-account-detail-screen"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileGetAccountOptions returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/get-account-options"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileGetAccountsListBlock returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/get-accounts-list-block"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileGetAddTransactionScreen returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/get-add-transaction-screen"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileGetCategoryDeletionInfo returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/get-category-deletion-info"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileGetCategoryGroupsWithCategories returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/get-category-groups-with-categories"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileGetDuplicateCredentials returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/get-duplicate-credentials"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileGetEditAccountScreen returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/get-edit-account-screen"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileGetEventPopoverTransactions returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/get-event-popover-transactions"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileGetInvestmentsAccounts returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/get-investments-accounts"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileGetInvestmentsDashboardCard returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/get-investments-dashboard-card"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileGetInvestmentsHoldingsList returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/get-investments-holdings-list"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileGetInvestmentsPortfolio returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/get-investments-portfolio"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileGetInvestmentsWidgetData returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/get-investments-widget-data"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileGetMerchantsListScreen returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/get-merchants-list-screen"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileGetPastSplits returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/get-past-splits"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileGetPortfolioBenchmarks returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/get-portfolio-benchmarks"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileGetSecuritiesHistoricalChart returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/get-securities-historical-chart"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileGetSecuritiesHistoricalPerformance returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/get-securities-historical-performance"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileGetSelectCategoryScreen returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/get-select-category-screen"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileGetSelectMerchantScreenHouseholdMerchants returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/get-select-merchant-screen-household-merchants"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileGetSelectMerchantScreenRecommendedMerchants returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/get-select-merchant-screen-recommended-merchants"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileGetSelectMerchantScreenTransactionDetails returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/get-select-merchant-screen-transaction-details"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileGetTransactionDetailScreen returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/get-transaction-detail-screen"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileGetTransactionsAndCategoriesForWidget returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/get-transactions-and-categories-for-widget"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileGoalDetailScreenV2 returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/goal-detail-screen-v2"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileGoalSelectGoals returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/goal-select-goals"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileGoalsAllocateBalanceScreen returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/goals-allocate-balance-screen"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileGoalsDashboardCardV2 returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/goals-dashboard-card-v2"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileGoalsMapAccountsScreen returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/goals-map-accounts-screen"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileGoalsMessageBlock returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/goals-message-block"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileGoalsMonthlyBudgetsScreen returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/goals-monthly-budgets-screen"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileGoalsPreTaxBudgetsScreen returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/goals-pre-tax-budgets-screen"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileGoalsScreenV2 returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/goals-screen-v2"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileGoalsTargetAmountsScreen returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/goals-target-amounts-screen"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileInitialPermissionRequestModal returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/initial-permission-request-modal"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileInviteEmail returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/invite-email"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileInvitePartner returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/invite-partner"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileLinkGoalOptions returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/link-goal-options"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileLinkSearchInstitutionsQuery returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/link-search-institutions-query"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileMerchantChartQuery returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/merchant-chart-query"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileMerchantDetailContainerQuery returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/merchant-detail-container-query"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileMoveMoneyScreenMutation returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/move-money-screen-mutation"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileNetWorthChartOverlyQuery returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/net-worth-chart-overly-query"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileOldestDeletableSyncedSnapshotDate returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/oldest-deletable-synced-snapshot-date"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobilePreviewDeleteSyncedSnapshots returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/preview-delete-synced-snapshots"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileRankGoalsScreen returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/rank-goals-screen"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileRapidTransactionReviewFormContainer returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/rapid-transaction-review-form-container"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileRapidTransactionReviewScreen returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/rapid-transaction-review-screen"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileResetHouseholdRecurringMerchantSearch returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/reset-household-recurring-merchant-search"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileResetRolloverMutation returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/reset-rollover-mutation"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileRestoreCategoryMutation returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/restore-category-mutation"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileReviewDashboardQuery returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/review-dashboard-query"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileReviewTransactionsDashboardButton returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/review-transactions-dashboard-button"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileRulesSettingsScreenQuery returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/rules-settings-screen-query"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileSavingsGoalFilterOptions returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/savings-goal-filter-options"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileSearchInstitutionsQuery returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/search-institutions-query"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileSearchMerchants returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/search-merchants"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileSearchVehiclesQuery returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/search-vehicles-query"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileSelectGoalsScreen returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/select-goals-screen"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileSetTransactionTagsRapidReview returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/set-transaction-tags-rapid-review"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileToggleSupportAccountAccess returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/toggle-support-account-access"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileTransactionsMessageBlock returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/transactions-message-block"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileUpdateCategoryGroupOrderMutation returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/update-category-group-order-mutation"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileUpdateCategoryMutation returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/update-category-mutation"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileUpdateCategoryOrderMutation returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/update-category-order-mutation"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileUpdateGoalV2 returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/update-goal-v2"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileUpdateGoalsPriorities returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/update-goals-priorities"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileUpdateNonMonthlyCategory returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/update-non-monthly-category"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileUpdateReviewCheckinMutation returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/update-review-checkin-mutation"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileUpdateTransactionDetailScreen returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/update-transaction-detail-screen"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileUpdateTransactionRapidReview returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/update-transaction-rapid-review"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileUpdateUserFinancialProfile returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/update-user-financial-profile"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileUpsellPostalCode returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/upsell-postal-code"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `mobileUserAvatar returns FreeForm envelope`() {
        `when`(sessionService.current()).thenReturn(FAKE_SESSION)
        stubExec(client, emptyMap<String, Any?>())
        mvc
            .perform(get("/v1/mobile/user-avatar"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data").exists())
    }

    @Test
    fun `returns 503 when session missing`() {
        `when`(sessionService.requireCurrent()).thenThrow(MonarchSessionMissingException())
        mvc
            .perform(get("/v1/mobile/accounts-message-block"))
            .andExpect(status().isServiceUnavailable)
            .andExpect(jsonPath("$.code").value("session_missing"))
    }
}
