# WebScreensApi

All URIs are relative to *http://localhost:9084*

|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|[**webAccountDetailsRouterGetAccountType**](#webaccountdetailsroutergetaccounttype) | **POST** /v1/web/screens/account-details-router-get-account-type | Web screen aggregate &#x60;Web_AccountDetailsRouter_getAccountType&#x60; (query, opaque pass-through)|
|[**webAccountEditModal**](#webaccounteditmodal) | **POST** /v1/web/screens/account-edit-modal | Web screen aggregate &#x60;Web_AccountEditModal&#x60; (query, opaque pass-through)|
|[**webAccountFilterQuery**](#webaccountfilterquery) | **POST** /v1/web/screens/account-filter-query | Web screen aggregate &#x60;Web_AccountFilterQuery&#x60; (query, opaque pass-through)|
|[**webAccountsMessageBlock**](#webaccountsmessageblock) | **POST** /v1/web/screens/accounts-message-block | Web screen aggregate &#x60;Web_AccountsMessageBlock&#x60; (query, opaque pass-through)|
|[**webAdvisorPortalGetSubscription**](#webadvisorportalgetsubscription) | **POST** /v1/web/screens/advisor-portal-get-subscription | Web screen aggregate &#x60;Web_AdvisorPortalGetSubscription&#x60; (query, opaque pass-through)|
|[**webAnswerQuestionMutation**](#webanswerquestionmutation) | **POST** /v1/web/aggregates/answer-question-mutation | Web screen aggregate &#x60;Web_AnswerQuestionMutation&#x60; (mutation, opaque pass-through)|
|[**webAssignTaxScheduleCategoryMapping**](#webassigntaxschedulecategorymapping) | **POST** /v1/web/aggregates/assign-tax-schedule-category-mapping | Web screen aggregate &#x60;Web_AssignTaxScheduleCategoryMapping&#x60; (mutation, opaque pass-through)|
|[**webBudgetOnboardingGetAccounts**](#webbudgetonboardinggetaccounts) | **POST** /v1/web/screens/budget-onboarding-get-accounts | Web screen aggregate &#x60;Web_BudgetOnboardingGetAccounts&#x60; (query, opaque pass-through)|
|[**webCancelSponsorship**](#webcancelsponsorship) | **POST** /v1/web/aggregates/cancel-sponsorship | Web screen aggregate &#x60;Web_CancelSponsorship&#x60; (mutation, opaque pass-through)|
|[**webChangeSubscription**](#webchangesubscription) | **POST** /v1/web/aggregates/change-subscription | Web screen aggregate &#x60;Web_ChangeSubscription&#x60; (mutation, opaque pass-through)|
|[**webClearAllMutation**](#webclearallmutation) | **POST** /v1/web/aggregates/clear-all-mutation | Web screen aggregate &#x60;Web_ClearAllMutation&#x60; (mutation, opaque pass-through)|
|[**webConfirmTotpDevice**](#webconfirmtotpdevice) | **POST** /v1/web/aggregates/confirm-totp-device | Web screen aggregate &#x60;Web_confirmTotpDevice&#x60; (mutation, opaque pass-through)|
|[**webConvertEmployeeTrial**](#webconvertemployeetrial) | **POST** /v1/web/aggregates/convert-employee-trial | Web screen aggregate &#x60;Web_ConvertEmployeeTrial&#x60; (mutation, opaque pass-through)|
|[**webCopySnapshots**](#webcopysnapshots) | **POST** /v1/web/aggregates/copy-snapshots | Web screen aggregate &#x60;Web_CopySnapshots&#x60; (mutation, opaque pass-through)|
|[**webCreateAIReport**](#webcreateaireport) | **POST** /v1/web/aggregates/create-a-i-report | Web screen aggregate &#x60;Web_CreateAIReport&#x60; (mutation, opaque pass-through)|
|[**webCreateAdvisorSubscription**](#webcreateadvisorsubscription) | **POST** /v1/web/aggregates/create-advisor-subscription | Web screen aggregate &#x60;Web_CreateAdvisorSubscription&#x60; (mutation, opaque pass-through)|
|[**webCreateCoinbaseAccount**](#webcreatecoinbaseaccount) | **POST** /v1/web/aggregates/create-coinbase-account | Web screen aggregate &#x60;Web_CreateCoinbaseAccount&#x60; (mutation, opaque pass-through)|
|[**webCreateEquityAccountWithGrants**](#webcreateequityaccountwithgrants) | **POST** /v1/web/aggregates/create-equity-account-with-grants | Web screen aggregate &#x60;Web_CreateEquityAccountWithGrants&#x60; (mutation, opaque pass-through)|
|[**webCreateFeedbackEvent**](#webcreatefeedbackevent) | **POST** /v1/web/aggregates/create-feedback-event | Web screen aggregate &#x60;Web_CreateFeedbackEvent&#x60; (mutation, opaque pass-through)|
|[**webCreatePromoCodeCheckoutSession**](#webcreatepromocodecheckoutsession) | **POST** /v1/web/aggregates/create-promo-code-checkout-session | Web screen aggregate &#x60;Web_CreatePromoCodeCheckoutSession&#x60; (mutation, opaque pass-through)|
|[**webCreateSpinwheelAccountMapping**](#webcreatespinwheelaccountmapping) | **POST** /v1/web/aggregates/create-spinwheel-account-mapping | Web screen aggregate &#x60;Web_CreateSpinwheelAccountMapping&#x60; (mutation, opaque pass-through)|
|[**webCreateSubscription**](#webcreatesubscription) | **POST** /v1/web/aggregates/create-subscription | Web screen aggregate &#x60;Web_CreateSubscription&#x60; (mutation, opaque pass-through)|
|[**webCreateSubscriptionSponsorshipInvites**](#webcreatesubscriptionsponsorshipinvites) | **POST** /v1/web/aggregates/create-subscription-sponsorship-invites | Web screen aggregate &#x60;Web_CreateSubscriptionSponsorshipInvites&#x60; (mutation, opaque pass-through)|
|[**webCreateUnconfirmedTotpDevice**](#webcreateunconfirmedtotpdevice) | **POST** /v1/web/aggregates/create-unconfirmed-totp-device | Web screen aggregate &#x60;Web_createUnconfirmedTotpDevice&#x60; (mutation, opaque pass-through)|
|[**webCreateZillowAccount**](#webcreatezillowaccount) | **POST** /v1/web/aggregates/create-zillow-account | Web screen aggregate &#x60;Web_CreateZillowAccount&#x60; (mutation, opaque pass-through)|
|[**webDeleteAccountLogo**](#webdeleteaccountlogo) | **POST** /v1/web/aggregates/delete-account-logo | Web screen aggregate &#x60;Web_DeleteAccountLogo&#x60; (mutation, opaque pass-through)|
|[**webDeleteAllGoalReconciliationRecords**](#webdeleteallgoalreconciliationrecords) | **POST** /v1/web/aggregates/delete-all-goal-reconciliation-records | Web screen aggregate &#x60;Web_DeleteAllGoalReconciliationRecords&#x60; (mutation, opaque pass-through)|
|[**webDeleteAllTransactionRulesMutation**](#webdeletealltransactionrulesmutation) | **POST** /v1/web/aggregates/delete-all-transaction-rules-mutation | Web screen aggregate &#x60;Web_DeleteAllTransactionRulesMutation&#x60; (mutation, opaque pass-through)|
|[**webDeleteTaxScheduleCategoryMapping**](#webdeletetaxschedulecategorymapping) | **POST** /v1/web/aggregates/delete-tax-schedule-category-mapping | Web screen aggregate &#x60;Web_DeleteTaxScheduleCategoryMapping&#x60; (mutation, opaque pass-through)|
|[**webDeleteUserFromHousehold**](#webdeleteuserfromhousehold) | **POST** /v1/web/aggregates/delete-user-from-household | Web screen aggregate &#x60;Web_DeleteUserFromHousehold&#x60; (mutation, opaque pass-through)|
|[**webDirectLinkAccountSelectDataProvider**](#webdirectlinkaccountselectdataprovider) | **POST** /v1/web/screens/direct-link-account-select-data-provider | Web screen aggregate &#x60;Web_DirectLinkAccountSelectDataProvider&#x60; (query, opaque pass-through)|
|[**webDisableMfa**](#webdisablemfa) | **POST** /v1/web/aggregates/disable-mfa | Web screen aggregate &#x60;Web_DisableMfa&#x60; (mutation, opaque pass-through)|
|[**webDisconnectCredentialMutation**](#webdisconnectcredentialmutation) | **POST** /v1/web/aggregates/disconnect-credential-mutation | Web screen aggregate &#x60;Web_DisconnectCredentialMutation&#x60; (mutation, opaque pass-through)|
|[**webDisconnectDiscord**](#webdisconnectdiscord) | **POST** /v1/web/aggregates/disconnect-discord | Web screen aggregate &#x60;Web_DisconnectDiscord&#x60; (mutation, opaque pass-through)|
|[**webDiscordOAuthCallback**](#webdiscordoauthcallback) | **POST** /v1/web/aggregates/discord-o-auth-callback | Web screen aggregate &#x60;Web_DiscordOAuthCallback&#x60; (mutation, opaque pass-through)|
|[**webEmployeeMenuDeleteCreditScoreSnapshots**](#webemployeemenudeletecreditscoresnapshots) | **POST** /v1/web/aggregates/employee-menu-delete-credit-score-snapshots | Web screen aggregate &#x60;Web_EmployeeMenuDeleteCreditScoreSnapshots&#x60; (mutation, opaque pass-through)|
|[**webEmployeeMenuGetFinancialInsightIds**](#webemployeemenugetfinancialinsightids) | **POST** /v1/web/screens/employee-menu-get-financial-insight-ids | Web screen aggregate &#x60;Web_EmployeeMenuGetFinancialInsightIds&#x60; (query, opaque pass-through)|
|[**webEmployeeMenuResetAiAssistantOptIn**](#webemployeemenuresetaiassistantoptin) | **POST** /v1/web/aggregates/employee-menu-reset-ai-assistant-opt-in | Web screen aggregate &#x60;Web_EmployeeMenuResetAiAssistantOptIn&#x60; (mutation, opaque pass-through)|
|[**webEmployeeMenuSoftDeleteFinancialInsight**](#webemployeemenusoftdeletefinancialinsight) | **POST** /v1/web/aggregates/employee-menu-soft-delete-financial-insight | Web screen aggregate &#x60;Web_EmployeeMenuSoftDeleteFinancialInsight&#x60; (mutation, opaque pass-through)|
|[**webEquityAccountDetailsGetAccount**](#webequityaccountdetailsgetaccount) | **POST** /v1/web/screens/equity-account-details-get-account | Web screen aggregate &#x60;Web_EquityAccountDetails_getAccount&#x60; (query, opaque pass-through)|
|[**webEquityAccountDetailsGetLinkedAccount**](#webequityaccountdetailsgetlinkedaccount) | **POST** /v1/web/screens/equity-account-details-get-linked-account | Web screen aggregate &#x60;Web_EquityAccountDetails_getLinkedAccount&#x60; (query, opaque pass-through)|
|[**webExtendFreeTrialDuration**](#webextendfreetrialduration) | **POST** /v1/web/aggregates/extend-free-trial-duration | Web screen aggregate &#x60;Web_ExtendFreeTrialDuration&#x60; (mutation, opaque pass-through)|
|[**webGenerateReportName**](#webgeneratereportname) | **POST** /v1/web/screens/generate-report-name | Web screen aggregate &#x60;Web_GenerateReportName&#x60; (query, opaque pass-through)|
|[**webGetAccount**](#webgetaccount) | **POST** /v1/web/screens/get-account | Web screen aggregate &#x60;Web_GetAccount&#x60; (query, opaque pass-through)|
|[**webGetAccountTypes**](#webgetaccounttypes) | **POST** /v1/web/screens/get-account-types | Web screen aggregate &#x60;Web_GetAccountTypes&#x60; (query, opaque pass-through)|
|[**webGetAccountsForTransfer**](#webgetaccountsfortransfer) | **POST** /v1/web/screens/get-accounts-for-transfer | Web screen aggregate &#x60;Web_GetAccountsForTransfer&#x60; (query, opaque pass-through)|
|[**webGetAccountsPage**](#webgetaccountspage) | **POST** /v1/web/screens/get-accounts-page | Web screen aggregate &#x60;Web_GetAccountsPage&#x60; (query, opaque pass-through)|
|[**webGetAccountsPageRecentBalance**](#webgetaccountspagerecentbalance) | **POST** /v1/web/screens/get-accounts-page-recent-balance | Web screen aggregate &#x60;Web_GetAccountsPageRecentBalance&#x60; (query, opaque pass-through)|
|[**webGetAdvisorClientsPage**](#webgetadvisorclientspage) | **POST** /v1/web/screens/get-advisor-clients-page | Web screen aggregate &#x60;Web_GetAdvisorClientsPage&#x60; (query, opaque pass-through)|
|[**webGetAdvisorProfilePage**](#webgetadvisorprofilepage) | **POST** /v1/web/screens/get-advisor-profile-page | Web screen aggregate &#x60;Web_GetAdvisorProfilePage&#x60; (query, opaque pass-through)|
|[**webGetBalanceHistoryParserColumns**](#webgetbalancehistoryparsercolumns) | **POST** /v1/web/screens/get-balance-history-parser-columns | Web screen aggregate &#x60;Web_GetBalanceHistoryParserColumns&#x60; (query, opaque pass-through)|
|[**webGetBusinessSetupPriorTracking**](#webgetbusinesssetuppriortracking) | **POST** /v1/web/screens/get-business-setup-prior-tracking | Web screen aggregate &#x60;Web_GetBusinessSetupPriorTracking&#x60; (query, opaque pass-through)|
|[**webGetCancellationReasonsWithSubreasons**](#webgetcancellationreasonswithsubreasons) | **POST** /v1/web/screens/get-cancellation-reasons-with-subreasons | Web screen aggregate &#x60;Web_GetCancellationReasonsWithSubreasons&#x60; (query, opaque pass-through)|
|[**webGetCategorizationDetails**](#webgetcategorizationdetails) | **POST** /v1/web/screens/get-categorization-details | Web screen aggregate &#x60;Web_GetCategorizationDetails&#x60; (query, opaque pass-through)|
|[**webGetCategoryGroupDetails**](#webgetcategorygroupdetails) | **POST** /v1/web/screens/get-category-group-details | Web screen aggregate &#x60;Web_GetCategoryGroupDetails&#x60; (query, opaque pass-through)|
|[**webGetCategorySelectOptions**](#webgetcategoryselectoptions) | **POST** /v1/web/screens/get-category-select-options | Web screen aggregate &#x60;Web_GetCategorySelectOptions&#x60; (query, opaque pass-through)|
|[**webGetConnectedApps**](#webgetconnectedapps) | **POST** /v1/web/screens/get-connected-apps | Web screen aggregate &#x60;Web_GetConnectedApps&#x60; (query, opaque pass-through)|
|[**webGetContactSupportFormData**](#webgetcontactsupportformdata) | **POST** /v1/web/screens/get-contact-support-form-data | Web screen aggregate &#x60;Web_GetContactSupportFormData&#x60; (query, opaque pass-through)|
|[**webGetDiscordConnectionRedirectUrl**](#webgetdiscordconnectionredirecturl) | **POST** /v1/web/screens/get-discord-connection-redirect-url | Web screen aggregate &#x60;Web_GetDiscordConnectionRedirectUrl&#x60; (query, opaque pass-through)|
|[**webGetDownloadScheduleCSession**](#webgetdownloadschedulecsession) | **POST** /v1/web/screens/get-download-schedule-c-session | Web screen aggregate &#x60;Web_GetDownloadScheduleCSession&#x60; (query, opaque pass-through)|
|[**webGetEventPopoverTransactions**](#webgeteventpopovertransactions) | **POST** /v1/web/screens/get-event-popover-transactions | Web screen aggregate &#x60;Web_GetEventPopoverTransactions&#x60; (query, opaque pass-through)|
|[**webGetFilteredAccounts**](#webgetfilteredaccounts) | **POST** /v1/web/screens/get-filtered-accounts | Web screen aggregate &#x60;Web_GetFilteredAccounts&#x60; (query, opaque pass-through)|
|[**webGetFlexibleGroupRolloverSettings**](#webgetflexiblegrouprolloversettings) | **POST** /v1/web/screens/get-flexible-group-rollover-settings | Web screen aggregate &#x60;Web_GetFlexibleGroupRolloverSettings&#x60; (query, opaque pass-through)|
|[**webGetGiftedSubscriptionsForPolling**](#webgetgiftedsubscriptionsforpolling) | **POST** /v1/web/screens/get-gifted-subscriptions-for-polling | Web screen aggregate &#x60;Web_GetGiftedSubscriptionsForPolling&#x60; (query, opaque pass-through)|
|[**webGetInvestmentsAccounts**](#webgetinvestmentsaccounts) | **POST** /v1/web/screens/get-investments-accounts | Web screen aggregate &#x60;Web_GetInvestmentsAccounts&#x60; (query, opaque pass-through)|
|[**webGetInvestmentsDashboardCard**](#webgetinvestmentsdashboardcard) | **POST** /v1/web/screens/get-investments-dashboard-card | Web screen aggregate &#x60;Web_GetInvestmentsDashboardCard&#x60; (query, opaque pass-through)|
|[**webGetInvestmentsHoldingDrawerHistoricalPerformance**](#webgetinvestmentsholdingdrawerhistoricalperformance) | **POST** /v1/web/screens/get-investments-holding-drawer-historical-performance | Web screen aggregate &#x60;Web_GetInvestmentsHoldingDrawerHistoricalPerformance&#x60; (query, opaque pass-through)|
|[**webGetMeCollaborationProfileStep**](#webgetmecollaborationprofilestep) | **POST** /v1/web/screens/get-me-collaboration-profile-step | Web screen aggregate &#x60;Web_GetMeCollaborationProfileStep&#x60; (query, opaque pass-through)|
|[**webGetMerchantSelectHouseholdMerchants**](#webgetmerchantselecthouseholdmerchants) | **POST** /v1/web/screens/get-merchant-select-household-merchants | Web screen aggregate &#x60;Web_GetMerchantSelectHouseholdMerchants&#x60; (query, opaque pass-through)|
|[**webGetMerchantSelectRecommendedMerchants**](#webgetmerchantselectrecommendedmerchants) | **POST** /v1/web/screens/get-merchant-select-recommended-merchants | Web screen aggregate &#x60;Web_GetMerchantSelectRecommendedMerchants&#x60; (query, opaque pass-through)|
|[**webGetMerchantSelectTransactionDetails**](#webgetmerchantselecttransactiondetails) | **POST** /v1/web/screens/get-merchant-select-transaction-details | Web screen aggregate &#x60;Web_GetMerchantSelectTransactionDetails&#x60; (query, opaque pass-through)|
|[**webGetMerchantSettingsPage**](#webgetmerchantsettingspage) | **POST** /v1/web/screens/get-merchant-settings-page | Web screen aggregate &#x60;Web_GetMerchantSettingsPage&#x60; (query, opaque pass-through)|
|[**webGetPlanRecommendationData**](#webgetplanrecommendationdata) | **POST** /v1/web/screens/get-plan-recommendation-data | Web screen aggregate &#x60;Web_GetPlanRecommendationData&#x60; (query, opaque pass-through)|
|[**webGetPortfolio**](#webgetportfolio) | **POST** /v1/web/screens/get-portfolio | Web screen aggregate &#x60;Web_GetPortfolio&#x60; (query, opaque pass-through)|
|[**webGetPortfolioWithClassification**](#webgetportfoliowithclassification) | **POST** /v1/web/screens/get-portfolio-with-classification | Web screen aggregate &#x60;Web_GetPortfolioWithClassification&#x60; (query, opaque pass-through)|
|[**webGetRecommendedCategories**](#webgetrecommendedcategories) | **POST** /v1/web/screens/get-recommended-categories | Web screen aggregate &#x60;Web_GetRecommendedCategories&#x60; (query, opaque pass-through)|
|[**webGetScheduleCLineItems**](#webgetscheduleclineitems) | **POST** /v1/web/screens/get-schedule-c-line-items | Web screen aggregate &#x60;Web_GetScheduleCLineItems&#x60; (query, opaque pass-through)|
|[**webGetSecuritiesHistoricalPerformance**](#webgetsecuritieshistoricalperformance) | **POST** /v1/web/screens/get-securities-historical-performance | Web screen aggregate &#x60;Web_GetSecuritiesHistoricalPerformance&#x60; (query, opaque pass-through)|
|[**webGetSecuritySettings**](#webgetsecuritysettings) | **POST** /v1/web/screens/get-security-settings | Web screen aggregate &#x60;Web_GetSecuritySettings&#x60; (query, opaque pass-through)|
|[**webGetSidebarData**](#webgetsidebardata) | **POST** /v1/web/screens/get-sidebar-data | Web screen aggregate &#x60;Web_GetSidebarData&#x60; (query, opaque pass-through)|
|[**webGetStatementParserColumns**](#webgetstatementparsercolumns) | **POST** /v1/web/screens/get-statement-parser-columns | Web screen aggregate &#x60;Web_GetStatementParserColumns&#x60; (query, opaque pass-through)|
|[**webGetSubscription**](#webgetsubscription) | **POST** /v1/web/screens/get-subscription | Web screen aggregate &#x60;Web_GetSubscription&#x60; (query, opaque pass-through)|
|[**webGetSubscriptionModal**](#webgetsubscriptionmodal) | **POST** /v1/web/screens/get-subscription-modal | Web screen aggregate &#x60;Web_GetSubscriptionModal&#x60; (query, opaque pass-through)|
|[**webGetTaxPrepCategoryTransactions**](#webgettaxprepcategorytransactions) | **POST** /v1/web/screens/get-tax-prep-category-transactions | Web screen aggregate &#x60;Web_GetTaxPrepCategoryTransactions&#x60; (query, opaque pass-through)|
|[**webGetTaxPrepUnmappedCategoryTransactions**](#webgettaxprepunmappedcategorytransactions) | **POST** /v1/web/screens/get-tax-prep-unmapped-category-transactions | Web screen aggregate &#x60;Web_GetTaxPrepUnmappedCategoryTransactions&#x60; (query, opaque pass-through)|
|[**webGetTopInstitutionGroupByType**](#webgettopinstitutiongroupbytype) | **POST** /v1/web/screens/get-top-institution-group-by-type | Web screen aggregate &#x60;Web_GetTopInstitutionGroupByType&#x60; (query, opaque pass-through)|
|[**webGetTransactionFiltersMetadata**](#webgettransactionfiltersmetadata) | **POST** /v1/web/screens/get-transaction-filters-metadata | Web screen aggregate &#x60;Web_GetTransactionFiltersMetadata&#x60; (query, opaque pass-through)|
|[**webGetTransactionsPage**](#webgettransactionspage) | **POST** /v1/web/screens/get-transactions-page | Web screen aggregate &#x60;Web_GetTransactionsPage&#x60; (query, opaque pass-through)|
|[**webGetTransactionsSummaryCard**](#webgettransactionssummarycard) | **POST** /v1/web/screens/get-transactions-summary-card | Web screen aggregate &#x60;Web_GetTransactionsSummaryCard&#x60; (query, opaque pass-through)|
|[**webGetTrustAndWillSubscription**](#webgettrustandwillsubscription) | **POST** /v1/web/screens/get-trust-and-will-subscription | Web screen aggregate &#x60;Web_GetTrustAndWillSubscription&#x60; (query, opaque pass-through)|
|[**webGetUserDismissedRetailSyncBanner**](#webgetuserdismissedretailsyncbanner) | **POST** /v1/web/screens/get-user-dismissed-retail-sync-banner | Web screen aggregate &#x60;Web_GetUserDismissedRetailSyncBanner&#x60; (query, opaque pass-through)|
|[**webGetUserHasConfiguredExtension**](#webgetuserhasconfiguredextension) | **POST** /v1/web/screens/get-user-has-configured-extension | Web screen aggregate &#x60;Web_GetUserHasConfiguredExtension&#x60; (query, opaque pass-through)|
|[**webGetUserPlatforms**](#webgetuserplatforms) | **POST** /v1/web/screens/get-user-platforms | Web screen aggregate &#x60;Web_GetUserPlatforms&#x60; (query, opaque pass-through)|
|[**webGiveEmployeeInfinitePlusAccess**](#webgiveemployeeinfiniteplusaccess) | **POST** /v1/web/aggregates/give-employee-infinite-plus-access | Web screen aggregate &#x60;Web_GiveEmployeeInfinitePlusAccess&#x60; (mutation, opaque pass-through)|
|[**webGiveEmployeeInfinitePremiumAccess**](#webgiveemployeeinfinitepremiumaccess) | **POST** /v1/web/aggregates/give-employee-infinite-premium-access | Web screen aggregate &#x60;Web_GiveEmployeeInfinitePremiumAccess&#x60; (mutation, opaque pass-through)|
|[**webGoalDetailV2**](#webgoaldetailv2) | **POST** /v1/web/screens/goal-detail-v2 | Web screen aggregate &#x60;Web_GoalDetailV2&#x60; (query, opaque pass-through)|
|[**webGoalSelectGoals**](#webgoalselectgoals) | **POST** /v1/web/screens/goal-select-goals | Web screen aggregate &#x60;Web_GoalSelectGoals&#x60; (query, opaque pass-through)|
|[**webGoalSelectTransaction**](#webgoalselecttransaction) | **POST** /v1/web/screens/goal-select-transaction | Web screen aggregate &#x60;Web_GoalSelectTransaction&#x60; (query, opaque pass-through)|
|[**webGoalsAllocateBalanceModal**](#webgoalsallocatebalancemodal) | **POST** /v1/web/screens/goals-allocate-balance-modal | Web screen aggregate &#x60;Web_GoalsAllocateBalanceModal&#x60; (query, opaque pass-through)|
|[**webGoalsAllocationCardAccounts**](#webgoalsallocationcardaccounts) | **POST** /v1/web/screens/goals-allocation-card-accounts | Web screen aggregate &#x60;Web_GoalsAllocationCardAccounts&#x60; (query, opaque pass-through)|
|[**webGoalsDashboardCardV2**](#webgoalsdashboardcardv2) | **POST** /v1/web/screens/goals-dashboard-card-v2 | Web screen aggregate &#x60;Web_GoalsDashboardCardV2&#x60; (query, opaque pass-through)|
|[**webGoalsMapAccounts**](#webgoalsmapaccounts) | **POST** /v1/web/screens/goals-map-accounts | Web screen aggregate &#x60;Web_GoalsMapAccounts&#x60; (query, opaque pass-through)|
|[**webGoalsMapAccountsModal**](#webgoalsmapaccountsmodal) | **POST** /v1/web/screens/goals-map-accounts-modal | Web screen aggregate &#x60;Web_GoalsMapAccountsModal&#x60; (query, opaque pass-through)|
|[**webGoalsMessageBlock**](#webgoalsmessageblock) | **POST** /v1/web/screens/goals-message-block | Web screen aggregate &#x60;Web_GoalsMessageBlock&#x60; (query, opaque pass-through)|
|[**webGoalsMonthlyBudgets**](#webgoalsmonthlybudgets) | **POST** /v1/web/screens/goals-monthly-budgets | Web screen aggregate &#x60;Web_GoalsMonthlyBudgets&#x60; (query, opaque pass-through)|
|[**webGoalsV2**](#webgoalsv2) | **POST** /v1/web/screens/goals-v2 | Web screen aggregate &#x60;Web_GoalsV2&#x60; (query, opaque pass-through)|
|[**webImportStatementGetAccount**](#webimportstatementgetaccount) | **POST** /v1/web/screens/import-statement-get-account | Web screen aggregate &#x60;Web_ImportStatementGetAccount&#x60; (query, opaque pass-through)|
|[**webInitScheduleCDefaultMappings**](#webinitschedulecdefaultmappings) | **POST** /v1/web/aggregates/init-schedule-c-default-mappings | Web screen aggregate &#x60;Web_InitScheduleCDefaultMappings&#x60; (mutation, opaque pass-through)|
|[**webInviteEmail**](#webinviteemail) | **POST** /v1/web/aggregates/invite-email | Web screen aggregate &#x60;Web_InviteEmail&#x60; (mutation, opaque pass-through)|
|[**webMigrateHouseholdToSavingGoals**](#webmigratehouseholdtosavinggoals) | **POST** /v1/web/aggregates/migrate-household-to-saving-goals | Web screen aggregate &#x60;Web_MigrateHouseholdToSavingGoals&#x60; (mutation, opaque pass-through)|
|[**webMintTransactionsCountQuery**](#webminttransactionscountquery) | **POST** /v1/web/screens/mint-transactions-count-query | Web screen aggregate &#x60;Web_MintTransactionsCountQuery&#x60; (query, opaque pass-through)|
|[**webMonthlyBudgetGoalsModal**](#webmonthlybudgetgoalsmodal) | **POST** /v1/web/screens/monthly-budget-goals-modal | Web screen aggregate &#x60;Web_MonthlyBudgetGoalsModal&#x60; (query, opaque pass-through)|
|[**webMoveMoneyMutation**](#webmovemoneymutation) | **POST** /v1/web/aggregates/move-money-mutation | Web screen aggregate &#x60;Web_MoveMoneyMutation&#x60; (mutation, opaque pass-through)|
|[**webOnboardingTopInstitutions**](#webonboardingtopinstitutions) | **POST** /v1/web/screens/onboarding-top-institutions | Web screen aggregate &#x60;Web_OnboardingTopInstitutions&#x60; (query, opaque pass-through)|
|[**webParseUploadStatementSession**](#webparseuploadstatementsession) | **POST** /v1/web/aggregates/parse-upload-statement-session | Web screen aggregate &#x60;Web_ParseUploadStatementSession&#x60; (mutation, opaque pass-through)|
|[**webPlusUpgradeTrial**](#webplusupgradetrial) | **POST** /v1/web/screens/plus-upgrade-trial | Web screen aggregate &#x60;Web_PlusUpgradeTrial&#x60; (query, opaque pass-through)|
|[**webPreTaxBudgetGoalsList**](#webpretaxbudgetgoalslist) | **POST** /v1/web/screens/pre-tax-budget-goals-list | Web screen aggregate &#x60;Web_PreTaxBudgetGoalsList&#x60; (query, opaque pass-through)|
|[**webPreviewAccountDataTransferSnapshots**](#webpreviewaccountdatatransfersnapshots) | **POST** /v1/web/screens/preview-account-data-transfer-snapshots | Web screen aggregate &#x60;Web_PreviewAccountDataTransferSnapshots&#x60; (query, opaque pass-through)|
|[**webPreviewAccountDataTransferTransactions**](#webpreviewaccountdatatransfertransactions) | **POST** /v1/web/screens/preview-account-data-transfer-transactions | Web screen aggregate &#x60;Web_PreviewAccountDataTransferTransactions&#x60; (query, opaque pass-through)|
|[**webPreviewCopySnapshots**](#webpreviewcopysnapshots) | **POST** /v1/web/screens/preview-copy-snapshots | Web screen aggregate &#x60;Web_PreviewCopySnapshots&#x60; (query, opaque pass-through)|
|[**webRankGoalsList**](#webrankgoalslist) | **POST** /v1/web/screens/rank-goals-list | Web screen aggregate &#x60;Web_RankGoalsList&#x60; (query, opaque pass-through)|
|[**webReactivateSubscription**](#webreactivatesubscription) | **POST** /v1/web/aggregates/reactivate-subscription | Web screen aggregate &#x60;Web_ReactivateSubscription&#x60; (mutation, opaque pass-through)|
|[**webRecalculateBudgetMutation**](#webrecalculatebudgetmutation) | **POST** /v1/web/aggregates/recalculate-budget-mutation | Web screen aggregate &#x60;Web_RecalculateBudgetMutation&#x60; (mutation, opaque pass-through)|
|[**webRecommendedAccountDataTransferDates**](#webrecommendedaccountdatatransferdates) | **POST** /v1/web/screens/recommended-account-data-transfer-dates | Web screen aggregate &#x60;Web_RecommendedAccountDataTransferDates&#x60; (query, opaque pass-through)|
|[**webRecommendedAccounts**](#webrecommendedaccounts) | **POST** /v1/web/screens/recommended-accounts | Web screen aggregate &#x60;Web_RecommendedAccounts&#x60; (query, opaque pass-through)|
|[**webRecurringFilterQuery**](#webrecurringfilterquery) | **POST** /v1/web/screens/recurring-filter-query | Web screen aggregate &#x60;Web_RecurringFilterQuery&#x60; (query, opaque pass-through)|
|[**webRecurringPausedBanner**](#webrecurringpausedbanner) | **POST** /v1/web/screens/recurring-paused-banner | Web screen aggregate &#x60;Web_RecurringPausedBanner&#x60; (query, opaque pass-through)|
|[**webRemoveEmployeeEntitlements**](#webremoveemployeeentitlements) | **POST** /v1/web/aggregates/remove-employee-entitlements | Web screen aggregate &#x60;Web_RemoveEmployeeEntitlements&#x60; (mutation, opaque pass-through)|
|[**webResetAndSyncAccountMutation**](#webresetandsyncaccountmutation) | **POST** /v1/web/aggregates/reset-and-sync-account-mutation | Web screen aggregate &#x60;Web_ResetAndSyncAccountMutation&#x60; (mutation, opaque pass-through)|
|[**webResetCategorizationMemory**](#webresetcategorizationmemory) | **POST** /v1/web/aggregates/reset-categorization-memory | Web screen aggregate &#x60;Web_ResetCategorizationMemory&#x60; (mutation, opaque pass-through)|
|[**webResetEmployeeAndSubscribe**](#webresetemployeeandsubscribe) | **POST** /v1/web/aggregates/reset-employee-and-subscribe | Web screen aggregate &#x60;Web_ResetEmployeeAndSubscribe&#x60; (mutation, opaque pass-through)|
|[**webResetEmployeeToNoSubscription**](#webresetemployeetonosubscription) | **POST** /v1/web/aggregates/reset-employee-to-no-subscription | Web screen aggregate &#x60;Web_ResetEmployeeToNoSubscription&#x60; (mutation, opaque pass-through)|
|[**webResetHouseholdRecurringMerchantSearch**](#webresethouseholdrecurringmerchantsearch) | **POST** /v1/web/aggregates/reset-household-recurring-merchant-search | Web screen aggregate &#x60;Web_ResetHouseholdRecurringMerchantSearch&#x60; (mutation, opaque pass-through)|
|[**webResetRolloverMutation**](#webresetrollovermutation) | **POST** /v1/web/aggregates/reset-rollover-mutation | Web screen aggregate &#x60;Web_ResetRolloverMutation&#x60; (mutation, opaque pass-through)|
|[**webResetWeeklyRecapMutation**](#webresetweeklyrecapmutation) | **POST** /v1/web/aggregates/reset-weekly-recap-mutation | Web screen aggregate &#x60;Web_ResetWeeklyRecapMutation&#x60; (mutation, opaque pass-through)|
|[**webRestoreCategory**](#webrestorecategory) | **POST** /v1/web/aggregates/restore-category | Web screen aggregate &#x60;Web_RestoreCategory&#x60; (mutation, opaque pass-through)|
|[**webReviewStream**](#webreviewstream) | **POST** /v1/web/aggregates/review-stream | Web screen aggregate &#x60;Web_ReviewStream&#x60; (mutation, opaque pass-through)|
|[**webRevokeConnectedApp**](#webrevokeconnectedapp) | **POST** /v1/web/aggregates/revoke-connected-app | Web screen aggregate &#x60;Web_RevokeConnectedApp&#x60; (mutation, opaque pass-through)|
|[**webRevokeSponsorshipInvite**](#webrevokesponsorshipinvite) | **POST** /v1/web/aggregates/revoke-sponsorship-invite | Web screen aggregate &#x60;Web_RevokeSponsorshipInvite&#x60; (mutation, opaque pass-through)|
|[**webSearchInstitutionsQuery**](#websearchinstitutionsquery) | **POST** /v1/web/screens/search-institutions-query | Web screen aggregate &#x60;Web_SearchInstitutionsQuery&#x60; (query, opaque pass-through)|
|[**webSearchMerchants**](#websearchmerchants) | **POST** /v1/web/screens/search-merchants | Web screen aggregate &#x60;Web_SearchMerchants&#x60; (query, opaque pass-through)|
|[**webSearchSecurities**](#websearchsecurities) | **POST** /v1/web/screens/search-securities | Web screen aggregate &#x60;Web_SearchSecurities&#x60; (query, opaque pass-through)|
|[**webSetEmployeeActiveSubscription**](#websetemployeeactivesubscription) | **POST** /v1/web/aggregates/set-employee-active-subscription | Web screen aggregate &#x60;Web_SetEmployeeActiveSubscription&#x60; (mutation, opaque pass-through)|
|[**webSetEmployeeCancellationDiscountUsed**](#websetemployeecancellationdiscountused) | **POST** /v1/web/aggregates/set-employee-cancellation-discount-used | Web screen aggregate &#x60;Web_SetEmployeeCancellationDiscountUsed&#x60; (mutation, opaque pass-through)|
|[**webSetEmployeeExpiredTrial**](#websetemployeeexpiredtrial) | **POST** /v1/web/aggregates/set-employee-expired-trial | Web screen aggregate &#x60;Web_SetEmployeeExpiredTrial&#x60; (mutation, opaque pass-through)|
|[**webSetEmployeePlusTrialFields**](#websetemployeeplustrialfields) | **POST** /v1/web/aggregates/set-employee-plus-trial-fields | Web screen aggregate &#x60;Web_SetEmployeePlusTrialFields&#x60; (mutation, opaque pass-through)|
|[**webSetEmployeeSubscriptionEnded**](#websetemployeesubscriptionended) | **POST** /v1/web/aggregates/set-employee-subscription-ended | Web screen aggregate &#x60;Web_SetEmployeeSubscriptionEnded&#x60; (mutation, opaque pass-through)|
|[**webSnapshotsForAccountCopyBalancePreview**](#websnapshotsforaccountcopybalancepreview) | **POST** /v1/web/screens/snapshots-for-account-copy-balance-preview | Web screen aggregate &#x60;Web_SnapshotsForAccountCopyBalancePreview&#x60; (query, opaque pass-through)|
|[**webStartDownloadScheduleCSession**](#webstartdownloadschedulecsession) | **POST** /v1/web/aggregates/start-download-schedule-c-session | Web screen aggregate &#x60;Web_StartDownloadScheduleCSession&#x60; (mutation, opaque pass-through)|
|[**webSyncEmployeeSubscription**](#websyncemployeesubscription) | **POST** /v1/web/aggregates/sync-employee-subscription | Web screen aggregate &#x60;Web_SyncEmployeeSubscription&#x60; (mutation, opaque pass-through)|
|[**webTargetAmountsGoalsList**](#webtargetamountsgoalslist) | **POST** /v1/web/screens/target-amounts-goals-list | Web screen aggregate &#x60;Web_TargetAmountsGoalsList&#x60; (query, opaque pass-through)|
|[**webTestCreditScoreChangedNotification**](#webtestcreditscorechangednotification) | **POST** /v1/web/aggregates/test-credit-score-changed-notification | Web screen aggregate &#x60;Web_TestCreditScoreChangedNotification&#x60; (mutation, opaque pass-through)|
|[**webToggleSupportAccountAccess**](#webtogglesupportaccountaccess) | **POST** /v1/web/aggregates/toggle-support-account-access | Web screen aggregate &#x60;Web_ToggleSupportAccountAccess&#x60; (mutation, opaque pass-through)|
|[**webTransactionDrawerDeleteAttachment**](#webtransactiondrawerdeleteattachment) | **POST** /v1/web/aggregates/transaction-drawer-delete-attachment | Web screen aggregate &#x60;Web_TransactionDrawerDeleteAttachment&#x60; (mutation, opaque pass-through)|
|[**webTransactionsFilterQuery**](#webtransactionsfilterquery) | **POST** /v1/web/screens/transactions-filter-query | Web screen aggregate &#x60;Web_TransactionsFilterQuery&#x60; (query, opaque pass-through)|
|[**webTransactionsMessageBlock**](#webtransactionsmessageblock) | **POST** /v1/web/screens/transactions-message-block | Web screen aggregate &#x60;Web_TransactionsMessageBlock&#x60; (query, opaque pass-through)|
|[**webUndoSavingsGoalMigration**](#webundosavingsgoalmigration) | **POST** /v1/web/aggregates/undo-savings-goal-migration | Web screen aggregate &#x60;Web_UndoSavingsGoalMigration&#x60; (mutation, opaque pass-through)|
|[**webUnmatchRetailTransaction**](#webunmatchretailtransaction) | **POST** /v1/web/aggregates/unmatch-retail-transaction | Web screen aggregate &#x60;Web_UnmatchRetailTransaction&#x60; (mutation, opaque pass-through)|
|[**webUpdateAccountOrder**](#webupdateaccountorder) | **POST** /v1/web/aggregates/update-account-order | Web screen aggregate &#x60;Web_UpdateAccountOrder&#x60; (mutation, opaque pass-through)|
|[**webUpdateBusinessTrackingSetupIntent**](#webupdatebusinesstrackingsetupintent) | **POST** /v1/web/aggregates/update-business-tracking-setup-intent | Web screen aggregate &#x60;Web_UpdateBusinessTrackingSetupIntent&#x60; (mutation, opaque pass-through)|
|[**webUpdateCategory**](#webupdatecategory) | **POST** /v1/web/aggregates/update-category | Web screen aggregate &#x60;Web_UpdateCategory&#x60; (mutation, opaque pass-through)|
|[**webUpdateCategoryFromBudgetOnboarding**](#webupdatecategoryfrombudgetonboarding) | **POST** /v1/web/aggregates/update-category-from-budget-onboarding | Web screen aggregate &#x60;Web_UpdateCategoryFromBudgetOnboarding&#x60; (mutation, opaque pass-through)|
|[**webUpdateCategoryGroupOrder**](#webupdatecategorygrouporder) | **POST** /v1/web/aggregates/update-category-group-order | Web screen aggregate &#x60;Web_UpdateCategoryGroupOrder&#x60; (mutation, opaque pass-through)|
|[**webUpdateCategoryOrder**](#webupdatecategoryorder) | **POST** /v1/web/aggregates/update-category-order | Web screen aggregate &#x60;Web_UpdateCategoryOrder&#x60; (mutation, opaque pass-through)|
|[**webUpdateCompany**](#webupdatecompany) | **POST** /v1/web/aggregates/update-company | Web screen aggregate &#x60;Web_UpdateCompany&#x60; (mutation, opaque pass-through)|
|[**webUpdateDismissedRetailSyncBanner**](#webupdatedismissedretailsyncbanner) | **POST** /v1/web/aggregates/update-dismissed-retail-sync-banner | Web screen aggregate &#x60;Web_UpdateDismissedRetailSyncBanner&#x60; (mutation, opaque pass-through)|
|[**webUpdateGoalsPriorities**](#webupdategoalspriorities) | **POST** /v1/web/aggregates/update-goals-priorities | Web screen aggregate &#x60;Web_UpdateGoalsPriorities&#x60; (mutation, opaque pass-through)|
|[**webUpdateOrCreateAdvisorStripePaymentMethod**](#webupdateorcreateadvisorstripepaymentmethod) | **POST** /v1/web/aggregates/update-or-create-advisor-stripe-payment-method | Web screen aggregate &#x60;Web_UpdateOrCreateAdvisorStripePaymentMethod&#x60; (mutation, opaque pass-through)|
|[**webUpdateOrCreateStripePaymentMethod**](#webupdateorcreatestripepaymentmethod) | **POST** /v1/web/aggregates/update-or-create-stripe-payment-method | Web screen aggregate &#x60;Web_UpdateOrCreateStripePaymentMethod&#x60; (mutation, opaque pass-through)|
|[**webUpdateRenewalReminder**](#webupdaterenewalreminder) | **POST** /v1/web/aggregates/update-renewal-reminder | Web screen aggregate &#x60;Web_UpdateRenewalReminder&#x60; (mutation, opaque pass-through)|
|[**webUpdateRuleOrderMutation**](#webupdateruleordermutation) | **POST** /v1/web/aggregates/update-rule-order-mutation | Web screen aggregate &#x60;Web_UpdateRuleOrderMutation&#x60; (mutation, opaque pass-through)|
|[**webUpdateSubscriptionSponsor**](#webupdatesubscriptionsponsor) | **POST** /v1/web/aggregates/update-subscription-sponsor | Web screen aggregate &#x60;Web_UpdateSubscriptionSponsor&#x60; (mutation, opaque pass-through)|
|[**webUpdateTransactionOverview**](#webupdatetransactionoverview) | **POST** /v1/web/aggregates/update-transaction-overview | Web screen aggregate &#x60;Web_UpdateTransactionOverview&#x60; (mutation, opaque pass-through)|
|[**webUpdateUserFinancialProfile**](#webupdateuserfinancialprofile) | **POST** /v1/web/aggregates/update-user-financial-profile | Web screen aggregate &#x60;Web_UpdateUserFinancialProfile&#x60; (mutation, opaque pass-through)|

# **webAccountDetailsRouterGetAccountType**
> WebScreenAggregateResponse webAccountDetailsRouterGetAccountType()

Forwards Monarch\'s `Web_AccountDetailsRouter_getAccountType` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webAccountDetailsRouterGetAccountType(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webAccountEditModal**
> WebScreenAggregateResponse webAccountEditModal()

Forwards Monarch\'s `Web_AccountEditModal` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webAccountEditModal(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webAccountFilterQuery**
> WebScreenAggregateResponse webAccountFilterQuery()

Forwards Monarch\'s `Web_AccountFilterQuery` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webAccountFilterQuery(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webAccountsMessageBlock**
> WebScreenAggregateResponse webAccountsMessageBlock()

Forwards Monarch\'s `Web_AccountsMessageBlock` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webAccountsMessageBlock(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webAdvisorPortalGetSubscription**
> WebScreenAggregateResponse webAdvisorPortalGetSubscription()

Forwards Monarch\'s `Web_AdvisorPortalGetSubscription` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webAdvisorPortalGetSubscription(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webAnswerQuestionMutation**
> WebScreenAggregateResponse webAnswerQuestionMutation()

Forwards Monarch\'s `Web_AnswerQuestionMutation` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webAnswerQuestionMutation(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webAssignTaxScheduleCategoryMapping**
> WebScreenAggregateResponse webAssignTaxScheduleCategoryMapping()

Forwards Monarch\'s `Web_AssignTaxScheduleCategoryMapping` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webAssignTaxScheduleCategoryMapping(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webBudgetOnboardingGetAccounts**
> WebScreenAggregateResponse webBudgetOnboardingGetAccounts()

Forwards Monarch\'s `Web_BudgetOnboardingGetAccounts` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webBudgetOnboardingGetAccounts(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webCancelSponsorship**
> WebScreenAggregateResponse webCancelSponsorship()

Forwards Monarch\'s `Web_CancelSponsorship` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webCancelSponsorship(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webChangeSubscription**
> WebScreenAggregateResponse webChangeSubscription()

Forwards Monarch\'s `Web_ChangeSubscription` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webChangeSubscription(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webClearAllMutation**
> WebScreenAggregateResponse webClearAllMutation()

Forwards Monarch\'s `Web_ClearAllMutation` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webClearAllMutation(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webConfirmTotpDevice**
> WebScreenAggregateResponse webConfirmTotpDevice()

Forwards Monarch\'s `Web_confirmTotpDevice` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webConfirmTotpDevice(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webConvertEmployeeTrial**
> WebScreenAggregateResponse webConvertEmployeeTrial()

Forwards Monarch\'s `Web_ConvertEmployeeTrial` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webConvertEmployeeTrial(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webCopySnapshots**
> WebScreenAggregateResponse webCopySnapshots()

Forwards Monarch\'s `Web_CopySnapshots` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webCopySnapshots(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webCreateAIReport**
> WebScreenAggregateResponse webCreateAIReport()

Forwards Monarch\'s `Web_CreateAIReport` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webCreateAIReport(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webCreateAdvisorSubscription**
> WebScreenAggregateResponse webCreateAdvisorSubscription()

Forwards Monarch\'s `Web_CreateAdvisorSubscription` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webCreateAdvisorSubscription(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webCreateCoinbaseAccount**
> WebScreenAggregateResponse webCreateCoinbaseAccount()

Forwards Monarch\'s `Web_CreateCoinbaseAccount` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webCreateCoinbaseAccount(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webCreateEquityAccountWithGrants**
> WebScreenAggregateResponse webCreateEquityAccountWithGrants()

Forwards Monarch\'s `Web_CreateEquityAccountWithGrants` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webCreateEquityAccountWithGrants(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webCreateFeedbackEvent**
> WebScreenAggregateResponse webCreateFeedbackEvent()

Forwards Monarch\'s `Web_CreateFeedbackEvent` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webCreateFeedbackEvent(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webCreatePromoCodeCheckoutSession**
> WebScreenAggregateResponse webCreatePromoCodeCheckoutSession()

Forwards Monarch\'s `Web_CreatePromoCodeCheckoutSession` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webCreatePromoCodeCheckoutSession(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webCreateSpinwheelAccountMapping**
> WebScreenAggregateResponse webCreateSpinwheelAccountMapping()

Forwards Monarch\'s `Web_CreateSpinwheelAccountMapping` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webCreateSpinwheelAccountMapping(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webCreateSubscription**
> WebScreenAggregateResponse webCreateSubscription()

Forwards Monarch\'s `Web_CreateSubscription` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webCreateSubscription(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webCreateSubscriptionSponsorshipInvites**
> WebScreenAggregateResponse webCreateSubscriptionSponsorshipInvites()

Forwards Monarch\'s `Web_CreateSubscriptionSponsorshipInvites` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webCreateSubscriptionSponsorshipInvites(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webCreateUnconfirmedTotpDevice**
> WebScreenAggregateResponse webCreateUnconfirmedTotpDevice()

Forwards Monarch\'s `Web_createUnconfirmedTotpDevice` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webCreateUnconfirmedTotpDevice(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webCreateZillowAccount**
> WebScreenAggregateResponse webCreateZillowAccount()

Forwards Monarch\'s `Web_CreateZillowAccount` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webCreateZillowAccount(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webDeleteAccountLogo**
> WebScreenAggregateResponse webDeleteAccountLogo()

Forwards Monarch\'s `Web_DeleteAccountLogo` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webDeleteAccountLogo(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webDeleteAllGoalReconciliationRecords**
> WebScreenAggregateResponse webDeleteAllGoalReconciliationRecords()

Forwards Monarch\'s `Web_DeleteAllGoalReconciliationRecords` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webDeleteAllGoalReconciliationRecords(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webDeleteAllTransactionRulesMutation**
> WebScreenAggregateResponse webDeleteAllTransactionRulesMutation()

Forwards Monarch\'s `Web_DeleteAllTransactionRulesMutation` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webDeleteAllTransactionRulesMutation(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webDeleteTaxScheduleCategoryMapping**
> WebScreenAggregateResponse webDeleteTaxScheduleCategoryMapping()

Forwards Monarch\'s `Web_DeleteTaxScheduleCategoryMapping` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webDeleteTaxScheduleCategoryMapping(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webDeleteUserFromHousehold**
> WebScreenAggregateResponse webDeleteUserFromHousehold()

Forwards Monarch\'s `Web_DeleteUserFromHousehold` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webDeleteUserFromHousehold(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webDirectLinkAccountSelectDataProvider**
> WebScreenAggregateResponse webDirectLinkAccountSelectDataProvider()

Forwards Monarch\'s `Web_DirectLinkAccountSelectDataProvider` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webDirectLinkAccountSelectDataProvider(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webDisableMfa**
> WebScreenAggregateResponse webDisableMfa()

Forwards Monarch\'s `Web_DisableMfa` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webDisableMfa(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webDisconnectCredentialMutation**
> WebScreenAggregateResponse webDisconnectCredentialMutation()

Forwards Monarch\'s `Web_DisconnectCredentialMutation` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webDisconnectCredentialMutation(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webDisconnectDiscord**
> WebScreenAggregateResponse webDisconnectDiscord()

Forwards Monarch\'s `Web_DisconnectDiscord` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webDisconnectDiscord(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webDiscordOAuthCallback**
> WebScreenAggregateResponse webDiscordOAuthCallback()

Forwards Monarch\'s `Web_DiscordOAuthCallback` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webDiscordOAuthCallback(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webEmployeeMenuDeleteCreditScoreSnapshots**
> WebScreenAggregateResponse webEmployeeMenuDeleteCreditScoreSnapshots()

Forwards Monarch\'s `Web_EmployeeMenuDeleteCreditScoreSnapshots` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webEmployeeMenuDeleteCreditScoreSnapshots(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webEmployeeMenuGetFinancialInsightIds**
> WebScreenAggregateResponse webEmployeeMenuGetFinancialInsightIds()

Forwards Monarch\'s `Web_EmployeeMenuGetFinancialInsightIds` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webEmployeeMenuGetFinancialInsightIds(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webEmployeeMenuResetAiAssistantOptIn**
> WebScreenAggregateResponse webEmployeeMenuResetAiAssistantOptIn()

Forwards Monarch\'s `Web_EmployeeMenuResetAiAssistantOptIn` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webEmployeeMenuResetAiAssistantOptIn(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webEmployeeMenuSoftDeleteFinancialInsight**
> WebScreenAggregateResponse webEmployeeMenuSoftDeleteFinancialInsight()

Forwards Monarch\'s `Web_EmployeeMenuSoftDeleteFinancialInsight` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webEmployeeMenuSoftDeleteFinancialInsight(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webEquityAccountDetailsGetAccount**
> WebScreenAggregateResponse webEquityAccountDetailsGetAccount()

Forwards Monarch\'s `Web_EquityAccountDetails_getAccount` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webEquityAccountDetailsGetAccount(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webEquityAccountDetailsGetLinkedAccount**
> WebScreenAggregateResponse webEquityAccountDetailsGetLinkedAccount()

Forwards Monarch\'s `Web_EquityAccountDetails_getLinkedAccount` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webEquityAccountDetailsGetLinkedAccount(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webExtendFreeTrialDuration**
> WebScreenAggregateResponse webExtendFreeTrialDuration()

Forwards Monarch\'s `Web_ExtendFreeTrialDuration` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webExtendFreeTrialDuration(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGenerateReportName**
> WebScreenAggregateResponse webGenerateReportName()

Forwards Monarch\'s `Web_GenerateReportName` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGenerateReportName(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGetAccount**
> WebScreenAggregateResponse webGetAccount()

Forwards Monarch\'s `Web_GetAccount` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGetAccount(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGetAccountTypes**
> WebScreenAggregateResponse webGetAccountTypes()

Forwards Monarch\'s `Web_GetAccountTypes` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGetAccountTypes(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGetAccountsForTransfer**
> WebScreenAggregateResponse webGetAccountsForTransfer()

Forwards Monarch\'s `Web_GetAccountsForTransfer` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGetAccountsForTransfer(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGetAccountsPage**
> WebScreenAggregateResponse webGetAccountsPage()

Forwards Monarch\'s `Web_GetAccountsPage` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGetAccountsPage(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGetAccountsPageRecentBalance**
> WebScreenAggregateResponse webGetAccountsPageRecentBalance()

Forwards Monarch\'s `Web_GetAccountsPageRecentBalance` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGetAccountsPageRecentBalance(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGetAdvisorClientsPage**
> WebScreenAggregateResponse webGetAdvisorClientsPage()

Forwards Monarch\'s `Web_GetAdvisorClientsPage` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGetAdvisorClientsPage(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGetAdvisorProfilePage**
> WebScreenAggregateResponse webGetAdvisorProfilePage()

Forwards Monarch\'s `Web_GetAdvisorProfilePage` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGetAdvisorProfilePage(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGetBalanceHistoryParserColumns**
> WebScreenAggregateResponse webGetBalanceHistoryParserColumns()

Forwards Monarch\'s `Web_GetBalanceHistoryParserColumns` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGetBalanceHistoryParserColumns(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGetBusinessSetupPriorTracking**
> WebScreenAggregateResponse webGetBusinessSetupPriorTracking()

Forwards Monarch\'s `Web_GetBusinessSetupPriorTracking` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGetBusinessSetupPriorTracking(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGetCancellationReasonsWithSubreasons**
> WebScreenAggregateResponse webGetCancellationReasonsWithSubreasons()

Forwards Monarch\'s `Web_GetCancellationReasonsWithSubreasons` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGetCancellationReasonsWithSubreasons(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGetCategorizationDetails**
> WebScreenAggregateResponse webGetCategorizationDetails()

Forwards Monarch\'s `Web_GetCategorizationDetails` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGetCategorizationDetails(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGetCategoryGroupDetails**
> WebScreenAggregateResponse webGetCategoryGroupDetails()

Forwards Monarch\'s `Web_GetCategoryGroupDetails` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGetCategoryGroupDetails(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGetCategorySelectOptions**
> WebScreenAggregateResponse webGetCategorySelectOptions()

Forwards Monarch\'s `Web_GetCategorySelectOptions` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGetCategorySelectOptions(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGetConnectedApps**
> WebScreenAggregateResponse webGetConnectedApps()

Forwards Monarch\'s `Web_GetConnectedApps` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGetConnectedApps(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGetContactSupportFormData**
> WebScreenAggregateResponse webGetContactSupportFormData()

Forwards Monarch\'s `Web_GetContactSupportFormData` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGetContactSupportFormData(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGetDiscordConnectionRedirectUrl**
> WebScreenAggregateResponse webGetDiscordConnectionRedirectUrl()

Forwards Monarch\'s `Web_GetDiscordConnectionRedirectUrl` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGetDiscordConnectionRedirectUrl(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGetDownloadScheduleCSession**
> WebScreenAggregateResponse webGetDownloadScheduleCSession()

Forwards Monarch\'s `Web_GetDownloadScheduleCSession` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGetDownloadScheduleCSession(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGetEventPopoverTransactions**
> WebScreenAggregateResponse webGetEventPopoverTransactions()

Forwards Monarch\'s `Web_GetEventPopoverTransactions` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGetEventPopoverTransactions(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGetFilteredAccounts**
> WebScreenAggregateResponse webGetFilteredAccounts()

Forwards Monarch\'s `Web_GetFilteredAccounts` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGetFilteredAccounts(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGetFlexibleGroupRolloverSettings**
> WebScreenAggregateResponse webGetFlexibleGroupRolloverSettings()

Forwards Monarch\'s `Web_GetFlexibleGroupRolloverSettings` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGetFlexibleGroupRolloverSettings(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGetGiftedSubscriptionsForPolling**
> WebScreenAggregateResponse webGetGiftedSubscriptionsForPolling()

Forwards Monarch\'s `Web_GetGiftedSubscriptionsForPolling` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGetGiftedSubscriptionsForPolling(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGetInvestmentsAccounts**
> WebScreenAggregateResponse webGetInvestmentsAccounts()

Forwards Monarch\'s `Web_GetInvestmentsAccounts` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGetInvestmentsAccounts(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGetInvestmentsDashboardCard**
> WebScreenAggregateResponse webGetInvestmentsDashboardCard()

Forwards Monarch\'s `Web_GetInvestmentsDashboardCard` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGetInvestmentsDashboardCard(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGetInvestmentsHoldingDrawerHistoricalPerformance**
> WebScreenAggregateResponse webGetInvestmentsHoldingDrawerHistoricalPerformance()

Forwards Monarch\'s `Web_GetInvestmentsHoldingDrawerHistoricalPerformance` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGetInvestmentsHoldingDrawerHistoricalPerformance(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGetMeCollaborationProfileStep**
> WebScreenAggregateResponse webGetMeCollaborationProfileStep()

Forwards Monarch\'s `Web_GetMeCollaborationProfileStep` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGetMeCollaborationProfileStep(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGetMerchantSelectHouseholdMerchants**
> WebScreenAggregateResponse webGetMerchantSelectHouseholdMerchants()

Forwards Monarch\'s `Web_GetMerchantSelectHouseholdMerchants` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGetMerchantSelectHouseholdMerchants(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGetMerchantSelectRecommendedMerchants**
> WebScreenAggregateResponse webGetMerchantSelectRecommendedMerchants()

Forwards Monarch\'s `Web_GetMerchantSelectRecommendedMerchants` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGetMerchantSelectRecommendedMerchants(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGetMerchantSelectTransactionDetails**
> WebScreenAggregateResponse webGetMerchantSelectTransactionDetails()

Forwards Monarch\'s `Web_GetMerchantSelectTransactionDetails` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGetMerchantSelectTransactionDetails(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGetMerchantSettingsPage**
> WebScreenAggregateResponse webGetMerchantSettingsPage()

Forwards Monarch\'s `Web_GetMerchantSettingsPage` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGetMerchantSettingsPage(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGetPlanRecommendationData**
> WebScreenAggregateResponse webGetPlanRecommendationData()

Forwards Monarch\'s `Web_GetPlanRecommendationData` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGetPlanRecommendationData(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGetPortfolio**
> WebScreenAggregateResponse webGetPortfolio()

Forwards Monarch\'s `Web_GetPortfolio` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGetPortfolio(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGetPortfolioWithClassification**
> WebScreenAggregateResponse webGetPortfolioWithClassification()

Forwards Monarch\'s `Web_GetPortfolioWithClassification` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGetPortfolioWithClassification(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGetRecommendedCategories**
> WebScreenAggregateResponse webGetRecommendedCategories()

Forwards Monarch\'s `Web_GetRecommendedCategories` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGetRecommendedCategories(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGetScheduleCLineItems**
> WebScreenAggregateResponse webGetScheduleCLineItems()

Forwards Monarch\'s `Web_GetScheduleCLineItems` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGetScheduleCLineItems(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGetSecuritiesHistoricalPerformance**
> WebScreenAggregateResponse webGetSecuritiesHistoricalPerformance()

Forwards Monarch\'s `Web_GetSecuritiesHistoricalPerformance` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGetSecuritiesHistoricalPerformance(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGetSecuritySettings**
> WebScreenAggregateResponse webGetSecuritySettings()

Forwards Monarch\'s `Web_GetSecuritySettings` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGetSecuritySettings(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGetSidebarData**
> WebScreenAggregateResponse webGetSidebarData()

Forwards Monarch\'s `Web_GetSidebarData` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGetSidebarData(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGetStatementParserColumns**
> WebScreenAggregateResponse webGetStatementParserColumns()

Forwards Monarch\'s `Web_GetStatementParserColumns` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGetStatementParserColumns(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGetSubscription**
> WebScreenAggregateResponse webGetSubscription()

Forwards Monarch\'s `Web_GetSubscription` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGetSubscription(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGetSubscriptionModal**
> WebScreenAggregateResponse webGetSubscriptionModal()

Forwards Monarch\'s `Web_GetSubscriptionModal` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGetSubscriptionModal(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGetTaxPrepCategoryTransactions**
> WebScreenAggregateResponse webGetTaxPrepCategoryTransactions()

Forwards Monarch\'s `Web_GetTaxPrepCategoryTransactions` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGetTaxPrepCategoryTransactions(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGetTaxPrepUnmappedCategoryTransactions**
> WebScreenAggregateResponse webGetTaxPrepUnmappedCategoryTransactions()

Forwards Monarch\'s `Web_GetTaxPrepUnmappedCategoryTransactions` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGetTaxPrepUnmappedCategoryTransactions(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGetTopInstitutionGroupByType**
> WebScreenAggregateResponse webGetTopInstitutionGroupByType()

Forwards Monarch\'s `Web_GetTopInstitutionGroupByType` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGetTopInstitutionGroupByType(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGetTransactionFiltersMetadata**
> WebScreenAggregateResponse webGetTransactionFiltersMetadata()

Forwards Monarch\'s `Web_GetTransactionFiltersMetadata` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGetTransactionFiltersMetadata(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGetTransactionsPage**
> WebScreenAggregateResponse webGetTransactionsPage()

Forwards Monarch\'s `Web_GetTransactionsPage` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGetTransactionsPage(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGetTransactionsSummaryCard**
> WebScreenAggregateResponse webGetTransactionsSummaryCard()

Forwards Monarch\'s `Web_GetTransactionsSummaryCard` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGetTransactionsSummaryCard(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGetTrustAndWillSubscription**
> WebScreenAggregateResponse webGetTrustAndWillSubscription()

Forwards Monarch\'s `Web_GetTrustAndWillSubscription` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGetTrustAndWillSubscription(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGetUserDismissedRetailSyncBanner**
> WebScreenAggregateResponse webGetUserDismissedRetailSyncBanner()

Forwards Monarch\'s `Web_GetUserDismissedRetailSyncBanner` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGetUserDismissedRetailSyncBanner(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGetUserHasConfiguredExtension**
> WebScreenAggregateResponse webGetUserHasConfiguredExtension()

Forwards Monarch\'s `Web_GetUserHasConfiguredExtension` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGetUserHasConfiguredExtension(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGetUserPlatforms**
> WebScreenAggregateResponse webGetUserPlatforms()

Forwards Monarch\'s `Web_GetUserPlatforms` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGetUserPlatforms(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGiveEmployeeInfinitePlusAccess**
> WebScreenAggregateResponse webGiveEmployeeInfinitePlusAccess()

Forwards Monarch\'s `Web_GiveEmployeeInfinitePlusAccess` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGiveEmployeeInfinitePlusAccess(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGiveEmployeeInfinitePremiumAccess**
> WebScreenAggregateResponse webGiveEmployeeInfinitePremiumAccess()

Forwards Monarch\'s `Web_GiveEmployeeInfinitePremiumAccess` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGiveEmployeeInfinitePremiumAccess(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGoalDetailV2**
> WebScreenAggregateResponse webGoalDetailV2()

Forwards Monarch\'s `Web_GoalDetailV2` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGoalDetailV2(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGoalSelectGoals**
> WebScreenAggregateResponse webGoalSelectGoals()

Forwards Monarch\'s `Web_GoalSelectGoals` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGoalSelectGoals(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGoalSelectTransaction**
> WebScreenAggregateResponse webGoalSelectTransaction()

Forwards Monarch\'s `Web_GoalSelectTransaction` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGoalSelectTransaction(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGoalsAllocateBalanceModal**
> WebScreenAggregateResponse webGoalsAllocateBalanceModal()

Forwards Monarch\'s `Web_GoalsAllocateBalanceModal` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGoalsAllocateBalanceModal(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGoalsAllocationCardAccounts**
> WebScreenAggregateResponse webGoalsAllocationCardAccounts()

Forwards Monarch\'s `Web_GoalsAllocationCardAccounts` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGoalsAllocationCardAccounts(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGoalsDashboardCardV2**
> WebScreenAggregateResponse webGoalsDashboardCardV2()

Forwards Monarch\'s `Web_GoalsDashboardCardV2` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGoalsDashboardCardV2(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGoalsMapAccounts**
> WebScreenAggregateResponse webGoalsMapAccounts()

Forwards Monarch\'s `Web_GoalsMapAccounts` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGoalsMapAccounts(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGoalsMapAccountsModal**
> WebScreenAggregateResponse webGoalsMapAccountsModal()

Forwards Monarch\'s `Web_GoalsMapAccountsModal` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGoalsMapAccountsModal(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGoalsMessageBlock**
> WebScreenAggregateResponse webGoalsMessageBlock()

Forwards Monarch\'s `Web_GoalsMessageBlock` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGoalsMessageBlock(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGoalsMonthlyBudgets**
> WebScreenAggregateResponse webGoalsMonthlyBudgets()

Forwards Monarch\'s `Web_GoalsMonthlyBudgets` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGoalsMonthlyBudgets(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webGoalsV2**
> WebScreenAggregateResponse webGoalsV2()

Forwards Monarch\'s `Web_GoalsV2` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webGoalsV2(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webImportStatementGetAccount**
> WebScreenAggregateResponse webImportStatementGetAccount()

Forwards Monarch\'s `Web_ImportStatementGetAccount` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webImportStatementGetAccount(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webInitScheduleCDefaultMappings**
> WebScreenAggregateResponse webInitScheduleCDefaultMappings()

Forwards Monarch\'s `Web_InitScheduleCDefaultMappings` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webInitScheduleCDefaultMappings(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webInviteEmail**
> WebScreenAggregateResponse webInviteEmail()

Forwards Monarch\'s `Web_InviteEmail` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webInviteEmail(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webMigrateHouseholdToSavingGoals**
> WebScreenAggregateResponse webMigrateHouseholdToSavingGoals()

Forwards Monarch\'s `Web_MigrateHouseholdToSavingGoals` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webMigrateHouseholdToSavingGoals(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webMintTransactionsCountQuery**
> WebScreenAggregateResponse webMintTransactionsCountQuery()

Forwards Monarch\'s `Web_MintTransactionsCountQuery` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webMintTransactionsCountQuery(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webMonthlyBudgetGoalsModal**
> WebScreenAggregateResponse webMonthlyBudgetGoalsModal()

Forwards Monarch\'s `Web_MonthlyBudgetGoalsModal` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webMonthlyBudgetGoalsModal(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webMoveMoneyMutation**
> WebScreenAggregateResponse webMoveMoneyMutation()

Forwards Monarch\'s `Web_MoveMoneyMutation` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webMoveMoneyMutation(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webOnboardingTopInstitutions**
> WebScreenAggregateResponse webOnboardingTopInstitutions()

Forwards Monarch\'s `Web_OnboardingTopInstitutions` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webOnboardingTopInstitutions(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webParseUploadStatementSession**
> WebScreenAggregateResponse webParseUploadStatementSession()

Forwards Monarch\'s `Web_ParseUploadStatementSession` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webParseUploadStatementSession(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webPlusUpgradeTrial**
> WebScreenAggregateResponse webPlusUpgradeTrial()

Forwards Monarch\'s `Web_PlusUpgradeTrial` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webPlusUpgradeTrial(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webPreTaxBudgetGoalsList**
> WebScreenAggregateResponse webPreTaxBudgetGoalsList()

Forwards Monarch\'s `Web_PreTaxBudgetGoalsList` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webPreTaxBudgetGoalsList(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webPreviewAccountDataTransferSnapshots**
> WebScreenAggregateResponse webPreviewAccountDataTransferSnapshots()

Forwards Monarch\'s `Web_PreviewAccountDataTransferSnapshots` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webPreviewAccountDataTransferSnapshots(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webPreviewAccountDataTransferTransactions**
> WebScreenAggregateResponse webPreviewAccountDataTransferTransactions()

Forwards Monarch\'s `Web_PreviewAccountDataTransferTransactions` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webPreviewAccountDataTransferTransactions(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webPreviewCopySnapshots**
> WebScreenAggregateResponse webPreviewCopySnapshots()

Forwards Monarch\'s `Web_PreviewCopySnapshots` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webPreviewCopySnapshots(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webRankGoalsList**
> WebScreenAggregateResponse webRankGoalsList()

Forwards Monarch\'s `Web_RankGoalsList` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webRankGoalsList(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webReactivateSubscription**
> WebScreenAggregateResponse webReactivateSubscription()

Forwards Monarch\'s `Web_ReactivateSubscription` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webReactivateSubscription(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webRecalculateBudgetMutation**
> WebScreenAggregateResponse webRecalculateBudgetMutation()

Forwards Monarch\'s `Web_RecalculateBudgetMutation` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webRecalculateBudgetMutation(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webRecommendedAccountDataTransferDates**
> WebScreenAggregateResponse webRecommendedAccountDataTransferDates()

Forwards Monarch\'s `Web_RecommendedAccountDataTransferDates` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webRecommendedAccountDataTransferDates(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webRecommendedAccounts**
> WebScreenAggregateResponse webRecommendedAccounts()

Forwards Monarch\'s `Web_RecommendedAccounts` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webRecommendedAccounts(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webRecurringFilterQuery**
> WebScreenAggregateResponse webRecurringFilterQuery()

Forwards Monarch\'s `Web_RecurringFilterQuery` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webRecurringFilterQuery(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webRecurringPausedBanner**
> WebScreenAggregateResponse webRecurringPausedBanner()

Forwards Monarch\'s `Web_RecurringPausedBanner` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webRecurringPausedBanner(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webRemoveEmployeeEntitlements**
> WebScreenAggregateResponse webRemoveEmployeeEntitlements()

Forwards Monarch\'s `Web_RemoveEmployeeEntitlements` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webRemoveEmployeeEntitlements(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webResetAndSyncAccountMutation**
> WebScreenAggregateResponse webResetAndSyncAccountMutation()

Forwards Monarch\'s `Web_ResetAndSyncAccountMutation` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webResetAndSyncAccountMutation(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webResetCategorizationMemory**
> WebScreenAggregateResponse webResetCategorizationMemory()

Forwards Monarch\'s `Web_ResetCategorizationMemory` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webResetCategorizationMemory(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webResetEmployeeAndSubscribe**
> WebScreenAggregateResponse webResetEmployeeAndSubscribe()

Forwards Monarch\'s `Web_ResetEmployeeAndSubscribe` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webResetEmployeeAndSubscribe(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webResetEmployeeToNoSubscription**
> WebScreenAggregateResponse webResetEmployeeToNoSubscription()

Forwards Monarch\'s `Web_ResetEmployeeToNoSubscription` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webResetEmployeeToNoSubscription(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webResetHouseholdRecurringMerchantSearch**
> WebScreenAggregateResponse webResetHouseholdRecurringMerchantSearch()

Forwards Monarch\'s `Web_ResetHouseholdRecurringMerchantSearch` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webResetHouseholdRecurringMerchantSearch(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webResetRolloverMutation**
> WebScreenAggregateResponse webResetRolloverMutation()

Forwards Monarch\'s `Web_ResetRolloverMutation` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webResetRolloverMutation(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webResetWeeklyRecapMutation**
> WebScreenAggregateResponse webResetWeeklyRecapMutation()

Forwards Monarch\'s `Web_ResetWeeklyRecapMutation` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webResetWeeklyRecapMutation(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webRestoreCategory**
> WebScreenAggregateResponse webRestoreCategory()

Forwards Monarch\'s `Web_RestoreCategory` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webRestoreCategory(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webReviewStream**
> WebScreenAggregateResponse webReviewStream()

Forwards Monarch\'s `Web_ReviewStream` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webReviewStream(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webRevokeConnectedApp**
> WebScreenAggregateResponse webRevokeConnectedApp()

Forwards Monarch\'s `Web_RevokeConnectedApp` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webRevokeConnectedApp(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webRevokeSponsorshipInvite**
> WebScreenAggregateResponse webRevokeSponsorshipInvite()

Forwards Monarch\'s `Web_RevokeSponsorshipInvite` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webRevokeSponsorshipInvite(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webSearchInstitutionsQuery**
> WebScreenAggregateResponse webSearchInstitutionsQuery()

Forwards Monarch\'s `Web_SearchInstitutionsQuery` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webSearchInstitutionsQuery(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webSearchMerchants**
> WebScreenAggregateResponse webSearchMerchants()

Forwards Monarch\'s `Web_SearchMerchants` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webSearchMerchants(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webSearchSecurities**
> WebScreenAggregateResponse webSearchSecurities()

Forwards Monarch\'s `Web_SearchSecurities` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webSearchSecurities(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webSetEmployeeActiveSubscription**
> WebScreenAggregateResponse webSetEmployeeActiveSubscription()

Forwards Monarch\'s `Web_SetEmployeeActiveSubscription` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webSetEmployeeActiveSubscription(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webSetEmployeeCancellationDiscountUsed**
> WebScreenAggregateResponse webSetEmployeeCancellationDiscountUsed()

Forwards Monarch\'s `Web_SetEmployeeCancellationDiscountUsed` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webSetEmployeeCancellationDiscountUsed(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webSetEmployeeExpiredTrial**
> WebScreenAggregateResponse webSetEmployeeExpiredTrial()

Forwards Monarch\'s `Web_SetEmployeeExpiredTrial` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webSetEmployeeExpiredTrial(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webSetEmployeePlusTrialFields**
> WebScreenAggregateResponse webSetEmployeePlusTrialFields()

Forwards Monarch\'s `Web_SetEmployeePlusTrialFields` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webSetEmployeePlusTrialFields(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webSetEmployeeSubscriptionEnded**
> WebScreenAggregateResponse webSetEmployeeSubscriptionEnded()

Forwards Monarch\'s `Web_SetEmployeeSubscriptionEnded` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webSetEmployeeSubscriptionEnded(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webSnapshotsForAccountCopyBalancePreview**
> WebScreenAggregateResponse webSnapshotsForAccountCopyBalancePreview()

Forwards Monarch\'s `Web_SnapshotsForAccountCopyBalancePreview` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webSnapshotsForAccountCopyBalancePreview(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webStartDownloadScheduleCSession**
> WebScreenAggregateResponse webStartDownloadScheduleCSession()

Forwards Monarch\'s `Web_StartDownloadScheduleCSession` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webStartDownloadScheduleCSession(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webSyncEmployeeSubscription**
> WebScreenAggregateResponse webSyncEmployeeSubscription()

Forwards Monarch\'s `Web_SyncEmployeeSubscription` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webSyncEmployeeSubscription(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webTargetAmountsGoalsList**
> WebScreenAggregateResponse webTargetAmountsGoalsList()

Forwards Monarch\'s `Web_TargetAmountsGoalsList` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webTargetAmountsGoalsList(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webTestCreditScoreChangedNotification**
> WebScreenAggregateResponse webTestCreditScoreChangedNotification()

Forwards Monarch\'s `Web_TestCreditScoreChangedNotification` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webTestCreditScoreChangedNotification(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webToggleSupportAccountAccess**
> WebScreenAggregateResponse webToggleSupportAccountAccess()

Forwards Monarch\'s `Web_ToggleSupportAccountAccess` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webToggleSupportAccountAccess(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webTransactionDrawerDeleteAttachment**
> WebScreenAggregateResponse webTransactionDrawerDeleteAttachment()

Forwards Monarch\'s `Web_TransactionDrawerDeleteAttachment` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webTransactionDrawerDeleteAttachment(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webTransactionsFilterQuery**
> WebScreenAggregateResponse webTransactionsFilterQuery()

Forwards Monarch\'s `Web_TransactionsFilterQuery` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webTransactionsFilterQuery(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webTransactionsMessageBlock**
> WebScreenAggregateResponse webTransactionsMessageBlock()

Forwards Monarch\'s `Web_TransactionsMessageBlock` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webTransactionsMessageBlock(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webUndoSavingsGoalMigration**
> WebScreenAggregateResponse webUndoSavingsGoalMigration()

Forwards Monarch\'s `Web_UndoSavingsGoalMigration` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webUndoSavingsGoalMigration(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webUnmatchRetailTransaction**
> WebScreenAggregateResponse webUnmatchRetailTransaction()

Forwards Monarch\'s `Web_UnmatchRetailTransaction` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webUnmatchRetailTransaction(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webUpdateAccountOrder**
> WebScreenAggregateResponse webUpdateAccountOrder()

Forwards Monarch\'s `Web_UpdateAccountOrder` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webUpdateAccountOrder(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webUpdateBusinessTrackingSetupIntent**
> WebScreenAggregateResponse webUpdateBusinessTrackingSetupIntent()

Forwards Monarch\'s `Web_UpdateBusinessTrackingSetupIntent` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webUpdateBusinessTrackingSetupIntent(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webUpdateCategory**
> WebScreenAggregateResponse webUpdateCategory()

Forwards Monarch\'s `Web_UpdateCategory` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webUpdateCategory(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webUpdateCategoryFromBudgetOnboarding**
> WebScreenAggregateResponse webUpdateCategoryFromBudgetOnboarding()

Forwards Monarch\'s `Web_UpdateCategoryFromBudgetOnboarding` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webUpdateCategoryFromBudgetOnboarding(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webUpdateCategoryGroupOrder**
> WebScreenAggregateResponse webUpdateCategoryGroupOrder()

Forwards Monarch\'s `Web_UpdateCategoryGroupOrder` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webUpdateCategoryGroupOrder(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webUpdateCategoryOrder**
> WebScreenAggregateResponse webUpdateCategoryOrder()

Forwards Monarch\'s `Web_UpdateCategoryOrder` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webUpdateCategoryOrder(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webUpdateCompany**
> WebScreenAggregateResponse webUpdateCompany()

Forwards Monarch\'s `Web_UpdateCompany` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webUpdateCompany(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webUpdateDismissedRetailSyncBanner**
> WebScreenAggregateResponse webUpdateDismissedRetailSyncBanner()

Forwards Monarch\'s `Web_UpdateDismissedRetailSyncBanner` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webUpdateDismissedRetailSyncBanner(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webUpdateGoalsPriorities**
> WebScreenAggregateResponse webUpdateGoalsPriorities()

Forwards Monarch\'s `Web_UpdateGoalsPriorities` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webUpdateGoalsPriorities(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webUpdateOrCreateAdvisorStripePaymentMethod**
> WebScreenAggregateResponse webUpdateOrCreateAdvisorStripePaymentMethod()

Forwards Monarch\'s `Web_UpdateOrCreateAdvisorStripePaymentMethod` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webUpdateOrCreateAdvisorStripePaymentMethod(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webUpdateOrCreateStripePaymentMethod**
> WebScreenAggregateResponse webUpdateOrCreateStripePaymentMethod()

Forwards Monarch\'s `Web_UpdateOrCreateStripePaymentMethod` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webUpdateOrCreateStripePaymentMethod(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webUpdateRenewalReminder**
> WebScreenAggregateResponse webUpdateRenewalReminder()

Forwards Monarch\'s `Web_UpdateRenewalReminder` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webUpdateRenewalReminder(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webUpdateRuleOrderMutation**
> WebScreenAggregateResponse webUpdateRuleOrderMutation()

Forwards Monarch\'s `Web_UpdateRuleOrderMutation` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webUpdateRuleOrderMutation(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webUpdateSubscriptionSponsor**
> WebScreenAggregateResponse webUpdateSubscriptionSponsor()

Forwards Monarch\'s `Web_UpdateSubscriptionSponsor` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webUpdateSubscriptionSponsor(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webUpdateTransactionOverview**
> WebScreenAggregateResponse webUpdateTransactionOverview()

Forwards Monarch\'s `Web_UpdateTransactionOverview` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webUpdateTransactionOverview(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **webUpdateUserFinancialProfile**
> WebScreenAggregateResponse webUpdateUserFinancialProfile()

Forwards Monarch\'s `Web_UpdateUserFinancialProfile` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across Monarch web bundle releases. Pass operation variables as `{\"variables\": {...}}` in the body. 

### Example

```typescript
import {
    WebScreensApi,
    Configuration,
    WebScreenAggregateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new WebScreensApi(configuration);

let webScreenAggregateRequest: WebScreenAggregateRequest; // (optional)

const { status, data } = await apiInstance.webUpdateUserFinancialProfile(
    webScreenAggregateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **webScreenAggregateRequest** | **WebScreenAggregateRequest**|  | |


### Return type

**WebScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

