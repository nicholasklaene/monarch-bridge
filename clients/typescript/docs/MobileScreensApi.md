# MobileScreensApi

All URIs are relative to *http://localhost:9084*

|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|[**mobileAccountsMessageBlock**](#mobileaccountsmessageblock) | **GET** /v1/mobile/accounts-message-block | Mobile screen aggregate &#x60;Mobile_AccountsMessageBlock&#x60; (opaque pass-through)|
|[**mobileAddCategoryGroupMutation**](#mobileaddcategorygroupmutation) | **GET** /v1/mobile/add-category-group-mutation | Mobile screen aggregate &#x60;Mobile_AddCategoryGroupMutation&#x60; (opaque pass-through)|
|[**mobileCategoryDetailQuery**](#mobilecategorydetailquery) | **GET** /v1/mobile/category-detail-query | Mobile screen aggregate &#x60;Mobile_CategoryDetailQuery&#x60; (opaque pass-through)|
|[**mobileCategoryGroupDetailChartQuery**](#mobilecategorygroupdetailchartquery) | **GET** /v1/mobile/category-group-detail-chart-query | Mobile screen aggregate &#x60;Mobile_CategoryGroupDetailChartQuery&#x60; (opaque pass-through)|
|[**mobileCategoryGroupDetailContainerQuery**](#mobilecategorygroupdetailcontainerquery) | **GET** /v1/mobile/category-group-detail-container-query | Mobile screen aggregate &#x60;Mobile_CategoryGroupDetailContainerQuery&#x60; (opaque pass-through)|
|[**mobileCategoryRecommendationForTransaction**](#mobilecategoryrecommendationfortransaction) | **GET** /v1/mobile/category-recommendation-for-transaction | Mobile screen aggregate &#x60;Mobile_CategoryRecommendationForTransaction&#x60; (opaque pass-through)|
|[**mobileCreateAppleCardAccount**](#mobilecreateapplecardaccount) | **GET** /v1/mobile/create-apple-card-account | Mobile screen aggregate &#x60;Mobile_CreateAppleCardAccount&#x60; (opaque pass-through)|
|[**mobileCreateCoinbaseAccount**](#mobilecreatecoinbaseaccount) | **GET** /v1/mobile/create-coinbase-account | Mobile screen aggregate &#x60;Mobile_CreateCoinbaseAccount&#x60; (opaque pass-through)|
|[**mobileCreateEditRuleSettings**](#mobilecreateeditrulesettings) | **GET** /v1/mobile/create-edit-rule-settings | Mobile screen aggregate &#x60;Mobile_CreateEditRuleSettings&#x60; (opaque pass-through)|
|[**mobileCreateHouseholdAccessGrant**](#mobilecreatehouseholdaccessgrant) | **GET** /v1/mobile/create-household-access-grant | Mobile screen aggregate &#x60;Mobile_CreateHouseholdAccessGrant&#x60; (opaque pass-through)|
|[**mobileCreateReviewCheckinMutation**](#mobilecreatereviewcheckinmutation) | **GET** /v1/mobile/create-review-checkin-mutation | Mobile screen aggregate &#x60;Mobile_CreateReviewCheckinMutation&#x60; (opaque pass-through)|
|[**mobileCreateSyncedVehicleAccount**](#mobilecreatesyncedvehicleaccount) | **GET** /v1/mobile/create-synced-vehicle-account | Mobile screen aggregate &#x60;Mobile_CreateSyncedVehicleAccount&#x60; (opaque pass-through)|
|[**mobileCreateZillowAccount**](#mobilecreatezillowaccount) | **GET** /v1/mobile/create-zillow-account | Mobile screen aggregate &#x60;Mobile_CreateZillowAccount&#x60; (opaque pass-through)|
|[**mobileCustomizeGoalScreen**](#mobilecustomizegoalscreen) | **GET** /v1/mobile/customize-goal-screen | Mobile screen aggregate &#x60;Mobile_CustomizeGoalScreen&#x60; (opaque pass-through)|
|[**mobileDebugGetFinancialInsightIds**](#mobiledebuggetfinancialinsightids) | **GET** /v1/mobile/debug-get-financial-insight-ids | Mobile screen aggregate &#x60;Mobile_DebugGetFinancialInsightIds&#x60; (opaque pass-through)|
|[**mobileDebugSoftDeleteFinancialInsight**](#mobiledebugsoftdeletefinancialinsight) | **GET** /v1/mobile/debug-soft-delete-financial-insight | Mobile screen aggregate &#x60;Mobile_DebugSoftDeleteFinancialInsight&#x60; (opaque pass-through)|
|[**mobileDeleteAccountLogo**](#mobiledeleteaccountlogo) | **GET** /v1/mobile/delete-account-logo | Mobile screen aggregate &#x60;Mobile_DeleteAccountLogo&#x60; (opaque pass-through)|
|[**mobileDeleteAttachment**](#mobiledeleteattachment) | **GET** /v1/mobile/delete-attachment | Mobile screen aggregate &#x60;Mobile_DeleteAttachment&#x60; (opaque pass-through)|
|[**mobileDeleteUserFromHousehold**](#mobiledeleteuserfromhousehold) | **GET** /v1/mobile/delete-user-from-household | Mobile screen aggregate &#x60;Mobile_DeleteUserFromHousehold&#x60; (opaque pass-through)|
|[**mobileDeleteUserProfilePicture**](#mobiledeleteuserprofilepicture) | **GET** /v1/mobile/delete-user-profile-picture | Mobile screen aggregate &#x60;Mobile_DeleteUserProfilePicture&#x60; (opaque pass-through)|
|[**mobileDidRequestReviewMutation**](#mobiledidrequestreviewmutation) | **GET** /v1/mobile/did-request-review-mutation | Mobile screen aggregate &#x60;Mobile_DidRequestReviewMutation&#x60; (opaque pass-through)|
|[**mobileDirectLinkInstitutionModal**](#mobiledirectlinkinstitutionmodal) | **GET** /v1/mobile/direct-link-institution-modal | Mobile screen aggregate &#x60;Mobile_DirectLinkInstitutionModal&#x60; (opaque pass-through)|
|[**mobileDrawerMenu**](#mobiledrawermenu) | **GET** /v1/mobile/drawer-menu | Mobile screen aggregate &#x60;Mobile_DrawerMenu&#x60; (opaque pass-through)|
|[**mobileGetAccount**](#mobilegetaccount) | **GET** /v1/mobile/get-account | Mobile screen aggregate &#x60;Mobile_GetAccount&#x60; (opaque pass-through)|
|[**mobileGetAccountDetailScreen**](#mobilegetaccountdetailscreen) | **GET** /v1/mobile/get-account-detail-screen | Mobile screen aggregate &#x60;Mobile_GetAccountDetailScreen&#x60; (opaque pass-through)|
|[**mobileGetAccountOptions**](#mobilegetaccountoptions) | **GET** /v1/mobile/get-account-options | Mobile screen aggregate &#x60;Mobile_GetAccountOptions&#x60; (opaque pass-through)|
|[**mobileGetAccountsListBlock**](#mobilegetaccountslistblock) | **GET** /v1/mobile/get-accounts-list-block | Mobile screen aggregate &#x60;Mobile_GetAccountsListBlock&#x60; (opaque pass-through)|
|[**mobileGetAddTransactionScreen**](#mobilegetaddtransactionscreen) | **GET** /v1/mobile/get-add-transaction-screen | Mobile screen aggregate &#x60;Mobile_GetAddTransactionScreen&#x60; (opaque pass-through)|
|[**mobileGetCategoryDeletionInfo**](#mobilegetcategorydeletioninfo) | **GET** /v1/mobile/get-category-deletion-info | Mobile screen aggregate &#x60;Mobile_GetCategoryDeletionInfo&#x60; (opaque pass-through)|
|[**mobileGetCategoryGroupsWithCategories**](#mobilegetcategorygroupswithcategories) | **GET** /v1/mobile/get-category-groups-with-categories | Mobile screen aggregate &#x60;Mobile_GetCategoryGroupsWithCategories&#x60; (opaque pass-through)|
|[**mobileGetDuplicateCredentials**](#mobilegetduplicatecredentials) | **GET** /v1/mobile/get-duplicate-credentials | Mobile screen aggregate &#x60;Mobile_GetDuplicateCredentials&#x60; (opaque pass-through)|
|[**mobileGetEditAccountScreen**](#mobilegeteditaccountscreen) | **GET** /v1/mobile/get-edit-account-screen | Mobile screen aggregate &#x60;Mobile_GetEditAccountScreen&#x60; (opaque pass-through)|
|[**mobileGetEventPopoverTransactions**](#mobilegeteventpopovertransactions) | **GET** /v1/mobile/get-event-popover-transactions | Mobile screen aggregate &#x60;Mobile_GetEventPopoverTransactions&#x60; (opaque pass-through)|
|[**mobileGetInvestmentsAccounts**](#mobilegetinvestmentsaccounts) | **GET** /v1/mobile/get-investments-accounts | Mobile screen aggregate &#x60;Mobile_GetInvestmentsAccounts&#x60; (opaque pass-through)|
|[**mobileGetInvestmentsDashboardCard**](#mobilegetinvestmentsdashboardcard) | **GET** /v1/mobile/get-investments-dashboard-card | Mobile screen aggregate &#x60;Mobile_GetInvestmentsDashboardCard&#x60; (opaque pass-through)|
|[**mobileGetInvestmentsHoldingsList**](#mobilegetinvestmentsholdingslist) | **GET** /v1/mobile/get-investments-holdings-list | Mobile screen aggregate &#x60;Mobile_GetInvestmentsHoldingsList&#x60; (opaque pass-through)|
|[**mobileGetInvestmentsPortfolio**](#mobilegetinvestmentsportfolio) | **GET** /v1/mobile/get-investments-portfolio | Mobile screen aggregate &#x60;Mobile_GetInvestmentsPortfolio&#x60; (opaque pass-through)|
|[**mobileGetInvestmentsWidgetData**](#mobilegetinvestmentswidgetdata) | **GET** /v1/mobile/get-investments-widget-data | Mobile screen aggregate &#x60;Mobile_GetInvestmentsWidgetData&#x60; (opaque pass-through)|
|[**mobileGetMerchantsListScreen**](#mobilegetmerchantslistscreen) | **GET** /v1/mobile/get-merchants-list-screen | Mobile screen aggregate &#x60;Mobile_GetMerchantsListScreen&#x60; (opaque pass-through)|
|[**mobileGetPastSplits**](#mobilegetpastsplits) | **GET** /v1/mobile/get-past-splits | Mobile screen aggregate &#x60;Mobile_GetPastSplits&#x60; (opaque pass-through)|
|[**mobileGetPortfolioBenchmarks**](#mobilegetportfoliobenchmarks) | **GET** /v1/mobile/get-portfolio-benchmarks | Mobile screen aggregate &#x60;Mobile_GetPortfolioBenchmarks&#x60; (opaque pass-through)|
|[**mobileGetSecuritiesHistoricalChart**](#mobilegetsecuritieshistoricalchart) | **GET** /v1/mobile/get-securities-historical-chart | Mobile screen aggregate &#x60;Mobile_GetSecuritiesHistoricalChart&#x60; (opaque pass-through)|
|[**mobileGetSecuritiesHistoricalPerformance**](#mobilegetsecuritieshistoricalperformance) | **GET** /v1/mobile/get-securities-historical-performance | Mobile screen aggregate &#x60;Mobile_GetSecuritiesHistoricalPerformance&#x60; (opaque pass-through)|
|[**mobileGetSelectCategoryScreen**](#mobilegetselectcategoryscreen) | **GET** /v1/mobile/get-select-category-screen | Mobile screen aggregate &#x60;Mobile_GetSelectCategoryScreen&#x60; (opaque pass-through)|
|[**mobileGetSelectMerchantScreenHouseholdMerchants**](#mobilegetselectmerchantscreenhouseholdmerchants) | **GET** /v1/mobile/get-select-merchant-screen-household-merchants | Mobile screen aggregate &#x60;Mobile_GetSelectMerchantScreenHouseholdMerchants&#x60; (opaque pass-through)|
|[**mobileGetSelectMerchantScreenRecommendedMerchants**](#mobilegetselectmerchantscreenrecommendedmerchants) | **GET** /v1/mobile/get-select-merchant-screen-recommended-merchants | Mobile screen aggregate &#x60;Mobile_GetSelectMerchantScreenRecommendedMerchants&#x60; (opaque pass-through)|
|[**mobileGetSelectMerchantScreenTransactionDetails**](#mobilegetselectmerchantscreentransactiondetails) | **GET** /v1/mobile/get-select-merchant-screen-transaction-details | Mobile screen aggregate &#x60;Mobile_GetSelectMerchantScreenTransactionDetails&#x60; (opaque pass-through)|
|[**mobileGetTransactionDetailScreen**](#mobilegettransactiondetailscreen) | **GET** /v1/mobile/get-transaction-detail-screen | Mobile screen aggregate &#x60;Mobile_GetTransactionDetailScreen&#x60; (opaque pass-through)|
|[**mobileGetTransactionsAndCategoriesForWidget**](#mobilegettransactionsandcategoriesforwidget) | **GET** /v1/mobile/get-transactions-and-categories-for-widget | Mobile screen aggregate &#x60;Mobile_GetTransactionsAndCategoriesForWidget&#x60; (opaque pass-through)|
|[**mobileGoalDetailScreenV2**](#mobilegoaldetailscreenv2) | **GET** /v1/mobile/goal-detail-screen-v2 | Mobile screen aggregate &#x60;Mobile_GoalDetailScreenV2&#x60; (opaque pass-through)|
|[**mobileGoalSelectGoals**](#mobilegoalselectgoals) | **GET** /v1/mobile/goal-select-goals | Mobile screen aggregate &#x60;Mobile_GoalSelectGoals&#x60; (opaque pass-through)|
|[**mobileGoalsAllocateBalanceScreen**](#mobilegoalsallocatebalancescreen) | **GET** /v1/mobile/goals-allocate-balance-screen | Mobile screen aggregate &#x60;Mobile_GoalsAllocateBalanceScreen&#x60; (opaque pass-through)|
|[**mobileGoalsDashboardCardV2**](#mobilegoalsdashboardcardv2) | **GET** /v1/mobile/goals-dashboard-card-v2 | Mobile screen aggregate &#x60;Mobile_GoalsDashboardCardV2&#x60; (opaque pass-through)|
|[**mobileGoalsMapAccountsScreen**](#mobilegoalsmapaccountsscreen) | **GET** /v1/mobile/goals-map-accounts-screen | Mobile screen aggregate &#x60;Mobile_GoalsMapAccountsScreen&#x60; (opaque pass-through)|
|[**mobileGoalsMessageBlock**](#mobilegoalsmessageblock) | **GET** /v1/mobile/goals-message-block | Mobile screen aggregate &#x60;Mobile_GoalsMessageBlock&#x60; (opaque pass-through)|
|[**mobileGoalsMonthlyBudgetsScreen**](#mobilegoalsmonthlybudgetsscreen) | **GET** /v1/mobile/goals-monthly-budgets-screen | Mobile screen aggregate &#x60;Mobile_GoalsMonthlyBudgetsScreen&#x60; (opaque pass-through)|
|[**mobileGoalsPreTaxBudgetsScreen**](#mobilegoalspretaxbudgetsscreen) | **GET** /v1/mobile/goals-pre-tax-budgets-screen | Mobile screen aggregate &#x60;Mobile_GoalsPreTaxBudgetsScreen&#x60; (opaque pass-through)|
|[**mobileGoalsScreenV2**](#mobilegoalsscreenv2) | **GET** /v1/mobile/goals-screen-v2 | Mobile screen aggregate &#x60;Mobile_GoalsScreenV2&#x60; (opaque pass-through)|
|[**mobileGoalsTargetAmountsScreen**](#mobilegoalstargetamountsscreen) | **GET** /v1/mobile/goals-target-amounts-screen | Mobile screen aggregate &#x60;Mobile_GoalsTargetAmountsScreen&#x60; (opaque pass-through)|
|[**mobileInitialPermissionRequestModal**](#mobileinitialpermissionrequestmodal) | **GET** /v1/mobile/initial-permission-request-modal | Mobile screen aggregate &#x60;Mobile_InitialPermissionRequestModal&#x60; (opaque pass-through)|
|[**mobileInviteEmail**](#mobileinviteemail) | **GET** /v1/mobile/invite-email | Mobile screen aggregate &#x60;Mobile_InviteEmail&#x60; (opaque pass-through)|
|[**mobileInvitePartner**](#mobileinvitepartner) | **GET** /v1/mobile/invite-partner | Mobile screen aggregate &#x60;Mobile_InvitePartner&#x60; (opaque pass-through)|
|[**mobileLinkGoalOptions**](#mobilelinkgoaloptions) | **GET** /v1/mobile/link-goal-options | Mobile screen aggregate &#x60;Mobile_LinkGoalOptions&#x60; (opaque pass-through)|
|[**mobileLinkSearchInstitutionsQuery**](#mobilelinksearchinstitutionsquery) | **GET** /v1/mobile/link-search-institutions-query | Mobile screen aggregate &#x60;Mobile_LinkSearchInstitutionsQuery&#x60; (opaque pass-through)|
|[**mobileMerchantChartQuery**](#mobilemerchantchartquery) | **GET** /v1/mobile/merchant-chart-query | Mobile screen aggregate &#x60;Mobile_MerchantChartQuery&#x60; (opaque pass-through)|
|[**mobileMerchantDetailContainerQuery**](#mobilemerchantdetailcontainerquery) | **GET** /v1/mobile/merchant-detail-container-query | Mobile screen aggregate &#x60;Mobile_MerchantDetailContainerQuery&#x60; (opaque pass-through)|
|[**mobileMoveMoneyScreenMutation**](#mobilemovemoneyscreenmutation) | **GET** /v1/mobile/move-money-screen-mutation | Mobile screen aggregate &#x60;Mobile_MoveMoneyScreenMutation&#x60; (opaque pass-through)|
|[**mobileNetWorthChartOverlyQuery**](#mobilenetworthchartoverlyquery) | **GET** /v1/mobile/net-worth-chart-overly-query | Mobile screen aggregate &#x60;Mobile_NetWorthChartOverlyQuery&#x60; (opaque pass-through)|
|[**mobileOldestDeletableSyncedSnapshotDate**](#mobileoldestdeletablesyncedsnapshotdate) | **GET** /v1/mobile/oldest-deletable-synced-snapshot-date | Mobile screen aggregate &#x60;Mobile_OldestDeletableSyncedSnapshotDate&#x60; (opaque pass-through)|
|[**mobilePreviewDeleteSyncedSnapshots**](#mobilepreviewdeletesyncedsnapshots) | **GET** /v1/mobile/preview-delete-synced-snapshots | Mobile screen aggregate &#x60;Mobile_PreviewDeleteSyncedSnapshots&#x60; (opaque pass-through)|
|[**mobileRankGoalsScreen**](#mobilerankgoalsscreen) | **GET** /v1/mobile/rank-goals-screen | Mobile screen aggregate &#x60;Mobile_RankGoalsScreen&#x60; (opaque pass-through)|
|[**mobileRapidTransactionReviewFormContainer**](#mobilerapidtransactionreviewformcontainer) | **GET** /v1/mobile/rapid-transaction-review-form-container | Mobile screen aggregate &#x60;Mobile_RapidTransactionReviewFormContainer&#x60; (opaque pass-through)|
|[**mobileRapidTransactionReviewScreen**](#mobilerapidtransactionreviewscreen) | **GET** /v1/mobile/rapid-transaction-review-screen | Mobile screen aggregate &#x60;Mobile_RapidTransactionReviewScreen&#x60; (opaque pass-through)|
|[**mobileResetHouseholdRecurringMerchantSearch**](#mobileresethouseholdrecurringmerchantsearch) | **GET** /v1/mobile/reset-household-recurring-merchant-search | Mobile screen aggregate &#x60;Mobile_ResetHouseholdRecurringMerchantSearch&#x60; (opaque pass-through)|
|[**mobileResetRolloverMutation**](#mobileresetrollovermutation) | **GET** /v1/mobile/reset-rollover-mutation | Mobile screen aggregate &#x60;Mobile_ResetRolloverMutation&#x60; (opaque pass-through)|
|[**mobileRestoreCategoryMutation**](#mobilerestorecategorymutation) | **GET** /v1/mobile/restore-category-mutation | Mobile screen aggregate &#x60;Mobile_RestoreCategoryMutation&#x60; (opaque pass-through)|
|[**mobileReviewDashboardQuery**](#mobilereviewdashboardquery) | **GET** /v1/mobile/review-dashboard-query | Mobile screen aggregate &#x60;Mobile_ReviewDashboardQuery&#x60; (opaque pass-through)|
|[**mobileReviewTransactionsDashboardButton**](#mobilereviewtransactionsdashboardbutton) | **GET** /v1/mobile/review-transactions-dashboard-button | Mobile screen aggregate &#x60;Mobile_ReviewTransactionsDashboardButton&#x60; (opaque pass-through)|
|[**mobileRulesSettingsScreenQuery**](#mobilerulessettingsscreenquery) | **GET** /v1/mobile/rules-settings-screen-query | Mobile screen aggregate &#x60;Mobile_RulesSettingsScreenQuery&#x60; (opaque pass-through)|
|[**mobileSavingsGoalFilterOptions**](#mobilesavingsgoalfilteroptions) | **GET** /v1/mobile/savings-goal-filter-options | Mobile screen aggregate &#x60;Mobile_SavingsGoalFilterOptions&#x60; (opaque pass-through)|
|[**mobileSearchInstitutionsQuery**](#mobilesearchinstitutionsquery) | **GET** /v1/mobile/search-institutions-query | Mobile screen aggregate &#x60;Mobile_SearchInstitutionsQuery&#x60; (opaque pass-through)|
|[**mobileSearchMerchants**](#mobilesearchmerchants) | **GET** /v1/mobile/search-merchants | Mobile screen aggregate &#x60;Mobile_SearchMerchants&#x60; (opaque pass-through)|
|[**mobileSearchVehiclesQuery**](#mobilesearchvehiclesquery) | **GET** /v1/mobile/search-vehicles-query | Mobile screen aggregate &#x60;Mobile_SearchVehiclesQuery&#x60; (opaque pass-through)|
|[**mobileSelectGoalsScreen**](#mobileselectgoalsscreen) | **GET** /v1/mobile/select-goals-screen | Mobile screen aggregate &#x60;Mobile_SelectGoalsScreen&#x60; (opaque pass-through)|
|[**mobileSetTransactionTagsRapidReview**](#mobilesettransactiontagsrapidreview) | **GET** /v1/mobile/set-transaction-tags-rapid-review | Mobile screen aggregate &#x60;Mobile_SetTransactionTagsRapidReview&#x60; (opaque pass-through)|
|[**mobileToggleSupportAccountAccess**](#mobiletogglesupportaccountaccess) | **GET** /v1/mobile/toggle-support-account-access | Mobile screen aggregate &#x60;Mobile_ToggleSupportAccountAccess&#x60; (opaque pass-through)|
|[**mobileTransactionsMessageBlock**](#mobiletransactionsmessageblock) | **GET** /v1/mobile/transactions-message-block | Mobile screen aggregate &#x60;Mobile_TransactionsMessageBlock&#x60; (opaque pass-through)|
|[**mobileUpdateCategoryGroupOrderMutation**](#mobileupdatecategorygroupordermutation) | **GET** /v1/mobile/update-category-group-order-mutation | Mobile screen aggregate &#x60;Mobile_UpdateCategoryGroupOrderMutation&#x60; (opaque pass-through)|
|[**mobileUpdateCategoryMutation**](#mobileupdatecategorymutation) | **GET** /v1/mobile/update-category-mutation | Mobile screen aggregate &#x60;Mobile_UpdateCategoryMutation&#x60; (opaque pass-through)|
|[**mobileUpdateCategoryOrderMutation**](#mobileupdatecategoryordermutation) | **GET** /v1/mobile/update-category-order-mutation | Mobile screen aggregate &#x60;Mobile_UpdateCategoryOrderMutation&#x60; (opaque pass-through)|
|[**mobileUpdateGoalV2**](#mobileupdategoalv2) | **GET** /v1/mobile/update-goal-v2 | Mobile screen aggregate &#x60;Mobile_UpdateGoalV2&#x60; (opaque pass-through)|
|[**mobileUpdateGoalsPriorities**](#mobileupdategoalspriorities) | **GET** /v1/mobile/update-goals-priorities | Mobile screen aggregate &#x60;Mobile_UpdateGoalsPriorities&#x60; (opaque pass-through)|
|[**mobileUpdateNonMonthlyCategory**](#mobileupdatenonmonthlycategory) | **GET** /v1/mobile/update-non-monthly-category | Mobile screen aggregate &#x60;Mobile_UpdateNonMonthlyCategory&#x60; (opaque pass-through)|
|[**mobileUpdateReviewCheckinMutation**](#mobileupdatereviewcheckinmutation) | **GET** /v1/mobile/update-review-checkin-mutation | Mobile screen aggregate &#x60;Mobile_UpdateReviewCheckinMutation&#x60; (opaque pass-through)|
|[**mobileUpdateTransactionDetailScreen**](#mobileupdatetransactiondetailscreen) | **GET** /v1/mobile/update-transaction-detail-screen | Mobile screen aggregate &#x60;Mobile_UpdateTransactionDetailScreen&#x60; (opaque pass-through)|
|[**mobileUpdateTransactionRapidReview**](#mobileupdatetransactionrapidreview) | **GET** /v1/mobile/update-transaction-rapid-review | Mobile screen aggregate &#x60;Mobile_UpdateTransactionRapidReview&#x60; (opaque pass-through)|
|[**mobileUpdateUserFinancialProfile**](#mobileupdateuserfinancialprofile) | **GET** /v1/mobile/update-user-financial-profile | Mobile screen aggregate &#x60;Mobile_UpdateUserFinancialProfile&#x60; (opaque pass-through)|
|[**mobileUpsellPostalCode**](#mobileupsellpostalcode) | **GET** /v1/mobile/upsell-postal-code | Mobile screen aggregate &#x60;Mobile_Upsell_PostalCode&#x60; (opaque pass-through)|
|[**mobileUserAvatar**](#mobileuseravatar) | **GET** /v1/mobile/user-avatar | Mobile screen aggregate &#x60;Mobile_UserAvatar&#x60; (opaque pass-through)|

# **mobileAccountsMessageBlock**
> MobileScreenAggregateResponse mobileAccountsMessageBlock()

Forwards Monarch\'s `Mobile_AccountsMessageBlock` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileAccountsMessageBlock();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileAddCategoryGroupMutation**
> MobileScreenAggregateResponse mobileAddCategoryGroupMutation()

Forwards Monarch\'s `Mobile_AddCategoryGroupMutation` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileAddCategoryGroupMutation();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileCategoryDetailQuery**
> MobileScreenAggregateResponse mobileCategoryDetailQuery()

Forwards Monarch\'s `Mobile_CategoryDetailQuery` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileCategoryDetailQuery();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileCategoryGroupDetailChartQuery**
> MobileScreenAggregateResponse mobileCategoryGroupDetailChartQuery()

Forwards Monarch\'s `Mobile_CategoryGroupDetailChartQuery` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileCategoryGroupDetailChartQuery();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileCategoryGroupDetailContainerQuery**
> MobileScreenAggregateResponse mobileCategoryGroupDetailContainerQuery()

Forwards Monarch\'s `Mobile_CategoryGroupDetailContainerQuery` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileCategoryGroupDetailContainerQuery();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileCategoryRecommendationForTransaction**
> MobileScreenAggregateResponse mobileCategoryRecommendationForTransaction()

Forwards Monarch\'s `Mobile_CategoryRecommendationForTransaction` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileCategoryRecommendationForTransaction();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileCreateAppleCardAccount**
> MobileScreenAggregateResponse mobileCreateAppleCardAccount()

Forwards Monarch\'s `Mobile_CreateAppleCardAccount` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileCreateAppleCardAccount();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileCreateCoinbaseAccount**
> MobileScreenAggregateResponse mobileCreateCoinbaseAccount()

Forwards Monarch\'s `Mobile_CreateCoinbaseAccount` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileCreateCoinbaseAccount();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileCreateEditRuleSettings**
> MobileScreenAggregateResponse mobileCreateEditRuleSettings()

Forwards Monarch\'s `Mobile_CreateEditRuleSettings` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileCreateEditRuleSettings();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileCreateHouseholdAccessGrant**
> MobileScreenAggregateResponse mobileCreateHouseholdAccessGrant()

Forwards Monarch\'s `Mobile_CreateHouseholdAccessGrant` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileCreateHouseholdAccessGrant();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileCreateReviewCheckinMutation**
> MobileScreenAggregateResponse mobileCreateReviewCheckinMutation()

Forwards Monarch\'s `Mobile_CreateReviewCheckinMutation` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileCreateReviewCheckinMutation();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileCreateSyncedVehicleAccount**
> MobileScreenAggregateResponse mobileCreateSyncedVehicleAccount()

Forwards Monarch\'s `Mobile_CreateSyncedVehicleAccount` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileCreateSyncedVehicleAccount();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileCreateZillowAccount**
> MobileScreenAggregateResponse mobileCreateZillowAccount()

Forwards Monarch\'s `Mobile_CreateZillowAccount` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileCreateZillowAccount();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileCustomizeGoalScreen**
> MobileScreenAggregateResponse mobileCustomizeGoalScreen()

Forwards Monarch\'s `Mobile_CustomizeGoalScreen` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileCustomizeGoalScreen();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileDebugGetFinancialInsightIds**
> MobileScreenAggregateResponse mobileDebugGetFinancialInsightIds()

Forwards Monarch\'s `Mobile_DebugGetFinancialInsightIds` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileDebugGetFinancialInsightIds();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileDebugSoftDeleteFinancialInsight**
> MobileScreenAggregateResponse mobileDebugSoftDeleteFinancialInsight()

Forwards Monarch\'s `Mobile_DebugSoftDeleteFinancialInsight` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileDebugSoftDeleteFinancialInsight();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileDeleteAccountLogo**
> MobileScreenAggregateResponse mobileDeleteAccountLogo()

Forwards Monarch\'s `Mobile_DeleteAccountLogo` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileDeleteAccountLogo();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileDeleteAttachment**
> MobileScreenAggregateResponse mobileDeleteAttachment()

Forwards Monarch\'s `Mobile_DeleteAttachment` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileDeleteAttachment();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileDeleteUserFromHousehold**
> MobileScreenAggregateResponse mobileDeleteUserFromHousehold()

Forwards Monarch\'s `Mobile_DeleteUserFromHousehold` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileDeleteUserFromHousehold();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileDeleteUserProfilePicture**
> MobileScreenAggregateResponse mobileDeleteUserProfilePicture()

Forwards Monarch\'s `Mobile_DeleteUserProfilePicture` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileDeleteUserProfilePicture();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileDidRequestReviewMutation**
> MobileScreenAggregateResponse mobileDidRequestReviewMutation()

Forwards Monarch\'s `Mobile_DidRequestReviewMutation` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileDidRequestReviewMutation();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileDirectLinkInstitutionModal**
> MobileScreenAggregateResponse mobileDirectLinkInstitutionModal()

Forwards Monarch\'s `Mobile_DirectLinkInstitutionModal` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileDirectLinkInstitutionModal();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileDrawerMenu**
> MobileScreenAggregateResponse mobileDrawerMenu()

Forwards Monarch\'s `Mobile_DrawerMenu` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileDrawerMenu();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileGetAccount**
> MobileScreenAggregateResponse mobileGetAccount()

Forwards Monarch\'s `Mobile_GetAccount` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileGetAccount();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileGetAccountDetailScreen**
> MobileScreenAggregateResponse mobileGetAccountDetailScreen()

Forwards Monarch\'s `Mobile_GetAccountDetailScreen` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileGetAccountDetailScreen();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileGetAccountOptions**
> MobileScreenAggregateResponse mobileGetAccountOptions()

Forwards Monarch\'s `Mobile_GetAccountOptions` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileGetAccountOptions();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileGetAccountsListBlock**
> MobileScreenAggregateResponse mobileGetAccountsListBlock()

Forwards Monarch\'s `Mobile_GetAccountsListBlock` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileGetAccountsListBlock();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileGetAddTransactionScreen**
> MobileScreenAggregateResponse mobileGetAddTransactionScreen()

Forwards Monarch\'s `Mobile_GetAddTransactionScreen` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileGetAddTransactionScreen();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileGetCategoryDeletionInfo**
> MobileScreenAggregateResponse mobileGetCategoryDeletionInfo()

Forwards Monarch\'s `Mobile_GetCategoryDeletionInfo` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileGetCategoryDeletionInfo();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileGetCategoryGroupsWithCategories**
> MobileScreenAggregateResponse mobileGetCategoryGroupsWithCategories()

Forwards Monarch\'s `Mobile_GetCategoryGroupsWithCategories` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileGetCategoryGroupsWithCategories();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileGetDuplicateCredentials**
> MobileScreenAggregateResponse mobileGetDuplicateCredentials()

Forwards Monarch\'s `Mobile_GetDuplicateCredentials` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileGetDuplicateCredentials();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileGetEditAccountScreen**
> MobileScreenAggregateResponse mobileGetEditAccountScreen()

Forwards Monarch\'s `Mobile_GetEditAccountScreen` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileGetEditAccountScreen();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileGetEventPopoverTransactions**
> MobileScreenAggregateResponse mobileGetEventPopoverTransactions()

Forwards Monarch\'s `Mobile_GetEventPopoverTransactions` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileGetEventPopoverTransactions();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileGetInvestmentsAccounts**
> MobileScreenAggregateResponse mobileGetInvestmentsAccounts()

Forwards Monarch\'s `Mobile_GetInvestmentsAccounts` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileGetInvestmentsAccounts();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileGetInvestmentsDashboardCard**
> MobileScreenAggregateResponse mobileGetInvestmentsDashboardCard()

Forwards Monarch\'s `Mobile_GetInvestmentsDashboardCard` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileGetInvestmentsDashboardCard();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileGetInvestmentsHoldingsList**
> MobileScreenAggregateResponse mobileGetInvestmentsHoldingsList()

Forwards Monarch\'s `Mobile_GetInvestmentsHoldingsList` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileGetInvestmentsHoldingsList();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileGetInvestmentsPortfolio**
> MobileScreenAggregateResponse mobileGetInvestmentsPortfolio()

Forwards Monarch\'s `Mobile_GetInvestmentsPortfolio` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileGetInvestmentsPortfolio();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileGetInvestmentsWidgetData**
> MobileScreenAggregateResponse mobileGetInvestmentsWidgetData()

Forwards Monarch\'s `Mobile_GetInvestmentsWidgetData` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileGetInvestmentsWidgetData();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileGetMerchantsListScreen**
> MobileScreenAggregateResponse mobileGetMerchantsListScreen()

Forwards Monarch\'s `Mobile_GetMerchantsListScreen` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileGetMerchantsListScreen();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileGetPastSplits**
> MobileScreenAggregateResponse mobileGetPastSplits()

Forwards Monarch\'s `Mobile_GetPastSplits` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileGetPastSplits();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileGetPortfolioBenchmarks**
> MobileScreenAggregateResponse mobileGetPortfolioBenchmarks()

Forwards Monarch\'s `Mobile_GetPortfolioBenchmarks` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileGetPortfolioBenchmarks();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileGetSecuritiesHistoricalChart**
> MobileScreenAggregateResponse mobileGetSecuritiesHistoricalChart()

Forwards Monarch\'s `Mobile_GetSecuritiesHistoricalChart` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileGetSecuritiesHistoricalChart();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileGetSecuritiesHistoricalPerformance**
> MobileScreenAggregateResponse mobileGetSecuritiesHistoricalPerformance()

Forwards Monarch\'s `Mobile_GetSecuritiesHistoricalPerformance` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileGetSecuritiesHistoricalPerformance();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileGetSelectCategoryScreen**
> MobileScreenAggregateResponse mobileGetSelectCategoryScreen()

Forwards Monarch\'s `Mobile_GetSelectCategoryScreen` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileGetSelectCategoryScreen();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileGetSelectMerchantScreenHouseholdMerchants**
> MobileScreenAggregateResponse mobileGetSelectMerchantScreenHouseholdMerchants()

Forwards Monarch\'s `Mobile_GetSelectMerchantScreenHouseholdMerchants` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileGetSelectMerchantScreenHouseholdMerchants();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileGetSelectMerchantScreenRecommendedMerchants**
> MobileScreenAggregateResponse mobileGetSelectMerchantScreenRecommendedMerchants()

Forwards Monarch\'s `Mobile_GetSelectMerchantScreenRecommendedMerchants` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileGetSelectMerchantScreenRecommendedMerchants();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileGetSelectMerchantScreenTransactionDetails**
> MobileScreenAggregateResponse mobileGetSelectMerchantScreenTransactionDetails()

Forwards Monarch\'s `Mobile_GetSelectMerchantScreenTransactionDetails` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileGetSelectMerchantScreenTransactionDetails();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileGetTransactionDetailScreen**
> MobileScreenAggregateResponse mobileGetTransactionDetailScreen()

Forwards Monarch\'s `Mobile_GetTransactionDetailScreen` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileGetTransactionDetailScreen();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileGetTransactionsAndCategoriesForWidget**
> MobileScreenAggregateResponse mobileGetTransactionsAndCategoriesForWidget()

Forwards Monarch\'s `Mobile_GetTransactionsAndCategoriesForWidget` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileGetTransactionsAndCategoriesForWidget();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileGoalDetailScreenV2**
> MobileScreenAggregateResponse mobileGoalDetailScreenV2()

Forwards Monarch\'s `Mobile_GoalDetailScreenV2` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileGoalDetailScreenV2();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileGoalSelectGoals**
> MobileScreenAggregateResponse mobileGoalSelectGoals()

Forwards Monarch\'s `Mobile_GoalSelectGoals` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileGoalSelectGoals();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileGoalsAllocateBalanceScreen**
> MobileScreenAggregateResponse mobileGoalsAllocateBalanceScreen()

Forwards Monarch\'s `Mobile_GoalsAllocateBalanceScreen` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileGoalsAllocateBalanceScreen();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileGoalsDashboardCardV2**
> MobileScreenAggregateResponse mobileGoalsDashboardCardV2()

Forwards Monarch\'s `Mobile_GoalsDashboardCardV2` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileGoalsDashboardCardV2();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileGoalsMapAccountsScreen**
> MobileScreenAggregateResponse mobileGoalsMapAccountsScreen()

Forwards Monarch\'s `Mobile_GoalsMapAccountsScreen` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileGoalsMapAccountsScreen();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileGoalsMessageBlock**
> MobileScreenAggregateResponse mobileGoalsMessageBlock()

Forwards Monarch\'s `Mobile_GoalsMessageBlock` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileGoalsMessageBlock();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileGoalsMonthlyBudgetsScreen**
> MobileScreenAggregateResponse mobileGoalsMonthlyBudgetsScreen()

Forwards Monarch\'s `Mobile_GoalsMonthlyBudgetsScreen` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileGoalsMonthlyBudgetsScreen();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileGoalsPreTaxBudgetsScreen**
> MobileScreenAggregateResponse mobileGoalsPreTaxBudgetsScreen()

Forwards Monarch\'s `Mobile_GoalsPreTaxBudgetsScreen` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileGoalsPreTaxBudgetsScreen();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileGoalsScreenV2**
> MobileScreenAggregateResponse mobileGoalsScreenV2()

Forwards Monarch\'s `Mobile_GoalsScreenV2` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileGoalsScreenV2();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileGoalsTargetAmountsScreen**
> MobileScreenAggregateResponse mobileGoalsTargetAmountsScreen()

Forwards Monarch\'s `Mobile_GoalsTargetAmountsScreen` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileGoalsTargetAmountsScreen();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileInitialPermissionRequestModal**
> MobileScreenAggregateResponse mobileInitialPermissionRequestModal()

Forwards Monarch\'s `Mobile_InitialPermissionRequestModal` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileInitialPermissionRequestModal();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileInviteEmail**
> MobileScreenAggregateResponse mobileInviteEmail()

Forwards Monarch\'s `Mobile_InviteEmail` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileInviteEmail();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileInvitePartner**
> MobileScreenAggregateResponse mobileInvitePartner()

Forwards Monarch\'s `Mobile_InvitePartner` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileInvitePartner();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileLinkGoalOptions**
> MobileScreenAggregateResponse mobileLinkGoalOptions()

Forwards Monarch\'s `Mobile_LinkGoalOptions` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileLinkGoalOptions();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileLinkSearchInstitutionsQuery**
> MobileScreenAggregateResponse mobileLinkSearchInstitutionsQuery()

Forwards Monarch\'s `Mobile_LinkSearchInstitutionsQuery` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileLinkSearchInstitutionsQuery();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileMerchantChartQuery**
> MobileScreenAggregateResponse mobileMerchantChartQuery()

Forwards Monarch\'s `Mobile_MerchantChartQuery` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileMerchantChartQuery();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileMerchantDetailContainerQuery**
> MobileScreenAggregateResponse mobileMerchantDetailContainerQuery()

Forwards Monarch\'s `Mobile_MerchantDetailContainerQuery` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileMerchantDetailContainerQuery();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileMoveMoneyScreenMutation**
> MobileScreenAggregateResponse mobileMoveMoneyScreenMutation()

Forwards Monarch\'s `Mobile_MoveMoneyScreenMutation` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileMoveMoneyScreenMutation();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileNetWorthChartOverlyQuery**
> MobileScreenAggregateResponse mobileNetWorthChartOverlyQuery()

Forwards Monarch\'s `Mobile_NetWorthChartOverlyQuery` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileNetWorthChartOverlyQuery();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileOldestDeletableSyncedSnapshotDate**
> MobileScreenAggregateResponse mobileOldestDeletableSyncedSnapshotDate()

Forwards Monarch\'s `Mobile_OldestDeletableSyncedSnapshotDate` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileOldestDeletableSyncedSnapshotDate();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobilePreviewDeleteSyncedSnapshots**
> MobileScreenAggregateResponse mobilePreviewDeleteSyncedSnapshots()

Forwards Monarch\'s `Mobile_PreviewDeleteSyncedSnapshots` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobilePreviewDeleteSyncedSnapshots();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileRankGoalsScreen**
> MobileScreenAggregateResponse mobileRankGoalsScreen()

Forwards Monarch\'s `Mobile_RankGoalsScreen` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileRankGoalsScreen();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileRapidTransactionReviewFormContainer**
> MobileScreenAggregateResponse mobileRapidTransactionReviewFormContainer()

Forwards Monarch\'s `Mobile_RapidTransactionReviewFormContainer` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileRapidTransactionReviewFormContainer();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileRapidTransactionReviewScreen**
> MobileScreenAggregateResponse mobileRapidTransactionReviewScreen()

Forwards Monarch\'s `Mobile_RapidTransactionReviewScreen` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileRapidTransactionReviewScreen();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileResetHouseholdRecurringMerchantSearch**
> MobileScreenAggregateResponse mobileResetHouseholdRecurringMerchantSearch()

Forwards Monarch\'s `Mobile_ResetHouseholdRecurringMerchantSearch` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileResetHouseholdRecurringMerchantSearch();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileResetRolloverMutation**
> MobileScreenAggregateResponse mobileResetRolloverMutation()

Forwards Monarch\'s `Mobile_ResetRolloverMutation` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileResetRolloverMutation();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileRestoreCategoryMutation**
> MobileScreenAggregateResponse mobileRestoreCategoryMutation()

Forwards Monarch\'s `Mobile_RestoreCategoryMutation` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileRestoreCategoryMutation();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileReviewDashboardQuery**
> MobileScreenAggregateResponse mobileReviewDashboardQuery()

Forwards Monarch\'s `Mobile_ReviewDashboardQuery` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileReviewDashboardQuery();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileReviewTransactionsDashboardButton**
> MobileScreenAggregateResponse mobileReviewTransactionsDashboardButton()

Forwards Monarch\'s `Mobile_ReviewTransactionsDashboardButton` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileReviewTransactionsDashboardButton();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileRulesSettingsScreenQuery**
> MobileScreenAggregateResponse mobileRulesSettingsScreenQuery()

Forwards Monarch\'s `Mobile_RulesSettingsScreenQuery` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileRulesSettingsScreenQuery();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileSavingsGoalFilterOptions**
> MobileScreenAggregateResponse mobileSavingsGoalFilterOptions()

Forwards Monarch\'s `Mobile_SavingsGoalFilterOptions` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileSavingsGoalFilterOptions();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileSearchInstitutionsQuery**
> MobileScreenAggregateResponse mobileSearchInstitutionsQuery()

Forwards Monarch\'s `Mobile_SearchInstitutionsQuery` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileSearchInstitutionsQuery();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileSearchMerchants**
> MobileScreenAggregateResponse mobileSearchMerchants()

Forwards Monarch\'s `Mobile_SearchMerchants` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileSearchMerchants();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileSearchVehiclesQuery**
> MobileScreenAggregateResponse mobileSearchVehiclesQuery()

Forwards Monarch\'s `Mobile_SearchVehiclesQuery` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileSearchVehiclesQuery();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileSelectGoalsScreen**
> MobileScreenAggregateResponse mobileSelectGoalsScreen()

Forwards Monarch\'s `Mobile_SelectGoalsScreen` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileSelectGoalsScreen();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileSetTransactionTagsRapidReview**
> MobileScreenAggregateResponse mobileSetTransactionTagsRapidReview()

Forwards Monarch\'s `Mobile_SetTransactionTagsRapidReview` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileSetTransactionTagsRapidReview();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileToggleSupportAccountAccess**
> MobileScreenAggregateResponse mobileToggleSupportAccountAccess()

Forwards Monarch\'s `Mobile_ToggleSupportAccountAccess` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileToggleSupportAccountAccess();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileTransactionsMessageBlock**
> MobileScreenAggregateResponse mobileTransactionsMessageBlock()

Forwards Monarch\'s `Mobile_TransactionsMessageBlock` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileTransactionsMessageBlock();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileUpdateCategoryGroupOrderMutation**
> MobileScreenAggregateResponse mobileUpdateCategoryGroupOrderMutation()

Forwards Monarch\'s `Mobile_UpdateCategoryGroupOrderMutation` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileUpdateCategoryGroupOrderMutation();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileUpdateCategoryMutation**
> MobileScreenAggregateResponse mobileUpdateCategoryMutation()

Forwards Monarch\'s `Mobile_UpdateCategoryMutation` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileUpdateCategoryMutation();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileUpdateCategoryOrderMutation**
> MobileScreenAggregateResponse mobileUpdateCategoryOrderMutation()

Forwards Monarch\'s `Mobile_UpdateCategoryOrderMutation` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileUpdateCategoryOrderMutation();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileUpdateGoalV2**
> MobileScreenAggregateResponse mobileUpdateGoalV2()

Forwards Monarch\'s `Mobile_UpdateGoalV2` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileUpdateGoalV2();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileUpdateGoalsPriorities**
> MobileScreenAggregateResponse mobileUpdateGoalsPriorities()

Forwards Monarch\'s `Mobile_UpdateGoalsPriorities` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileUpdateGoalsPriorities();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileUpdateNonMonthlyCategory**
> MobileScreenAggregateResponse mobileUpdateNonMonthlyCategory()

Forwards Monarch\'s `Mobile_UpdateNonMonthlyCategory` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileUpdateNonMonthlyCategory();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileUpdateReviewCheckinMutation**
> MobileScreenAggregateResponse mobileUpdateReviewCheckinMutation()

Forwards Monarch\'s `Mobile_UpdateReviewCheckinMutation` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileUpdateReviewCheckinMutation();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileUpdateTransactionDetailScreen**
> MobileScreenAggregateResponse mobileUpdateTransactionDetailScreen()

Forwards Monarch\'s `Mobile_UpdateTransactionDetailScreen` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileUpdateTransactionDetailScreen();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileUpdateTransactionRapidReview**
> MobileScreenAggregateResponse mobileUpdateTransactionRapidReview()

Forwards Monarch\'s `Mobile_UpdateTransactionRapidReview` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileUpdateTransactionRapidReview();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileUpdateUserFinancialProfile**
> MobileScreenAggregateResponse mobileUpdateUserFinancialProfile()

Forwards Monarch\'s `Mobile_UpdateUserFinancialProfile` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileUpdateUserFinancialProfile();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileUpsellPostalCode**
> MobileScreenAggregateResponse mobileUpsellPostalCode()

Forwards Monarch\'s `Mobile_Upsell_PostalCode` mutation and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileUpsellPostalCode();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mobileUserAvatar**
> MobileScreenAggregateResponse mobileUserAvatar()

Forwards Monarch\'s `Mobile_UserAvatar` query and returns the raw `data` tree as FreeForm. Wiring-only endpoint; shape is volatile across mobile-app releases. 

### Example

```typescript
import {
    MobileScreensApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MobileScreensApi(configuration);

const { status, data } = await apiInstance.mobileUserAvatar();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MobileScreenAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

