## monarch-bridge-client@1.0.0

This generator creates TypeScript/JavaScript client that utilizes [axios](https://github.com/axios/axios). The generated Node module can be used in the following environments:

Environment
* Node.js
* Webpack
* Browserify

Language level
* ES5 - you must have a Promises/A+ library installed
* ES6

Module system
* CommonJS
* ES6 module system

It can be used in both TypeScript and JavaScript. In TypeScript, the definition will be automatically resolved via `package.json`. ([Reference](https://www.typescriptlang.org/docs/handbook/declaration-files/consumption.html))

### Building

To build and compile the typescript sources to javascript use:
```
npm install
npm run build
```

### Publishing

First build the package then run `npm publish`

### Consuming

navigate to the folder of your consuming project and run one of the following commands.

_published:_

```
npm install monarch-bridge-client@1.0.0 --save
```

_unPublished (not recommended):_

```
npm install PATH_TO_GENERATED_PACKAGE --save
```

### Documentation for API Endpoints

All URIs are relative to *http://localhost:9084*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*AccountsApi* | [**bulkUpdateAccounts**](docs/AccountsApi.md#bulkupdateaccounts) | **PATCH** /v1/accounts/bulk | Bulk-update accounts
*AccountsApi* | [**createManualAccount**](docs/AccountsApi.md#createmanualaccount) | **POST** /v1/accounts | Create a manual (non-Plaid) account
*AccountsApi* | [**deleteAccount**](docs/AccountsApi.md#deleteaccount) | **DELETE** /v1/accounts/{id} | Delete an account
*AccountsApi* | [**deleteInstitution**](docs/AccountsApi.md#deleteinstitution) | **DELETE** /v1/institutions/{id} | Delete a Plaid credential (institution connection)
*AccountsApi* | [**getAccountBalanceAtDate**](docs/AccountsApi.md#getaccountbalanceatdate) | **GET** /v1/accounts/{id}/balance/at | Account display balance at a specific date
*AccountsApi* | [**getAccountGroups**](docs/AccountsApi.md#getaccountgroups) | **GET** /v1/account-groups | Account groups
*AccountsApi* | [**getAccountHistory**](docs/AccountsApi.md#getaccounthistory) | **GET** /v1/account/{id}/history | Daily balance snapshots for one account
*AccountsApi* | [**getAccountHoldings**](docs/AccountsApi.md#getaccountholdings) | **GET** /v1/account/{id}/holdings | Investment positions in one account
*AccountsApi* | [**getAccountTypeOptions**](docs/AccountsApi.md#getaccounttypeoptions) | **GET** /v1/account-type-options | Valid (type, subtype) combinations for manual accounts
*AccountsApi* | [**getBalanceHistoryStatus**](docs/AccountsApi.md#getbalancehistorystatus) | **GET** /v1/balance-history/{sessionKey}/status | Poll the parse status of a balance-history upload
*AccountsApi* | [**getCredentialInstitutions**](docs/AccountsApi.md#getcredentialinstitutions) | **GET** /v1/credentials/institutions | Linked credentials with their institution metadata
*AccountsApi* | [**getInstitutionByPlaidId**](docs/AccountsApi.md#getinstitutionbyplaidid) | **GET** /v1/institutions/by-plaid/{plaidId} | Institution lookup by Plaid id
*AccountsApi* | [**getInstitutions**](docs/AccountsApi.md#getinstitutions) | **GET** /v1/institutions | Linked institution credentials (Plaid connection pipes)
*AccountsApi* | [**getNetworth**](docs/AccountsApi.md#getnetworth) | **GET** /v1/networth | Net-worth snapshots over time
*AccountsApi* | [**getNetworthByType**](docs/AccountsApi.md#getnetworthbytype) | **GET** /v1/networth/by-type | Balance history grouped by account-type
*AccountsApi* | [**getNetworthRecent**](docs/AccountsApi.md#getnetworthrecent) | **GET** /v1/networth/recent | Per-account recent balance fluctuations
*AccountsApi* | [**getTopInstitutionGroups**](docs/AccountsApi.md#gettopinstitutiongroups) | **GET** /v1/institutions/top-groups | Top institution groups (popular providers by category)
*AccountsApi* | [**listAccounts**](docs/AccountsApi.md#listaccounts) | **GET** /v1/accounts | List all linked + manual accounts
*AccountsApi* | [**listLinkedCredentials**](docs/AccountsApi.md#listlinkedcredentials) | **GET** /v1/credentials | List linked credentials
*AccountsApi* | [**previewAccountBalance**](docs/AccountsApi.md#previewaccountbalance) | **GET** /v1/accounts/{id}/balance/preview | Preview an account display balance under edit options
*AccountsApi* | [**updateAccount**](docs/AccountsApi.md#updateaccount) | **PATCH** /v1/accounts/{id} | Partial-update an account
*AccountsApi* | [**updateAccountGroupOrder**](docs/AccountsApi.md#updateaccountgrouporder) | **PUT** /v1/account-groups/order | Reorder account groups
*AccountsApi* | [**uploadAccountBalanceHistory**](docs/AccountsApi.md#uploadaccountbalancehistory) | **POST** /v1/accounts/{id}/balance-history | Bulk-backfill balance history for a manual account from a CSV
*AdviceApi* | [**advice**](docs/AdviceApi.md#advice) | **GET** /v1/advice | Forward &#x60;AdviceQuery_Web&#x60; (opaque pass-through)
*AdviceApi* | [**adviceDashboardWidget**](docs/AdviceApi.md#advicedashboardwidget) | **GET** /v1/advice/dashboard-widget | Forward &#x60;Web_GetAdviceDashboardWidget&#x60; (opaque pass-through)
*AdviceApi* | [**adviceItemDrawer**](docs/AdviceApi.md#adviceitemdrawer) | **GET** /v1/advice/item-drawer | Forward &#x60;AdviceItemDrawerQuery_Web&#x60; (opaque pass-through)
*AdviceApi* | [**adviceQuestionnaire**](docs/AdviceApi.md#advicequestionnaire) | **GET** /v1/advice/questionnaire | Forward &#x60;Web_AdviceQuestionnaire&#x60; (opaque pass-through)
*AdviceApi* | [**adviceTaskComplete**](docs/AdviceApi.md#advicetaskcomplete) | **GET** /v1/advice/task/complete | Forward &#x60;Web_MarkAdviceTaskComplete&#x60; (opaque pass-through)
*AdviceApi* | [**adviceTaskDrawer**](docs/AdviceApi.md#advicetaskdrawer) | **GET** /v1/advice/task-drawer | Forward &#x60;AdviceTaskDrawerQuery_Web&#x60; (opaque pass-through)
*AdviceApi* | [**adviceTaskIncomplete**](docs/AdviceApi.md#advicetaskincomplete) | **GET** /v1/advice/task/incomplete | Forward &#x60;Web_MarkAdviceTaskIncomplete&#x60; (opaque pass-through)
*BillsApi* | [**billsAdvisorBilling**](docs/BillsApi.md#billsadvisorbilling) | **GET** /v1/bills/advisor-billing | Forward &#x60;Web_GetAdvisorBillingPage&#x60; (opaque pass-through)
*BillsApi* | [**billsBillingSettings**](docs/BillsApi.md#billsbillingsettings) | **GET** /v1/bills/billing-settings | Forward &#x60;GetBillingSettings&#x60; (opaque pass-through)
*BillsApi* | [**billsCancelSponsorship**](docs/BillsApi.md#billscancelsponsorship) | **GET** /v1/bills/billing/sponsorship/cancel | Forward &#x60;Web_BillingSettingsCancelSponsorship&#x60; (opaque pass-through)
*BillsApi* | [**billsClaimItem**](docs/BillsApi.md#billsclaimitem) | **GET** /v1/bills/item/claim | Forward &#x60;Web_ClaimBillItem&#x60; (opaque pass-through)
*BillsApi* | [**billsDetail**](docs/BillsApi.md#billsdetail) | **GET** /v1/bills/detail | Forward &#x60;Web_GetBill&#x60; (opaque pass-through)
*BillsApi* | [**billsEmployeeBillingState**](docs/BillsApi.md#billsemployeebillingstate) | **GET** /v1/bills/employee/billing-state | Forward &#x60;Web_GetEmployeeBillingState&#x60; (opaque pass-through)
*BillsApi* | [**billsHouseholdCountry**](docs/BillsApi.md#billshouseholdcountry) | **GET** /v1/bills/billing/household-country | Forward &#x60;Web_BillingSettings_HouseholdCountry&#x60; (opaque pass-through)
*BillsApi* | [**billsMobileSignupUpdatePostalCode**](docs/BillsApi.md#billsmobilesignupupdatepostalcode) | **GET** /v1/bills/mobile-signup/postal-code | Forward &#x60;Mobile_SignupBillingZip_UpdateBillingPostalCode&#x60; (opaque pass-through)
*BillsApi* | [**billsOnboardingGetPostalCode**](docs/BillsApi.md#billsonboardinggetpostalcode) | **GET** /v1/bills/onboarding/postal-code | Forward &#x60;Web_OnboardingBillingZip_GetPostalCode&#x60; (opaque pass-through)
*BillsApi* | [**billsOnboardingUpdatePostalCode**](docs/BillsApi.md#billsonboardingupdatepostalcode) | **GET** /v1/bills/onboarding/postal-code/update | Forward &#x60;Web_OnboardingBillingZip_UpdateBillingPostalCode&#x60; (opaque pass-through)
*BillsApi* | [**billsRegisterSplitParticipant**](docs/BillsApi.md#billsregistersplitparticipant) | **GET** /v1/bills/split/register-participant | Forward &#x60;Web_RegisterBillSplitParticipant&#x60; (opaque pass-through)
*BillsApi* | [**billsSetEmployeeBillingIssue**](docs/BillsApi.md#billssetemployeebillingissue) | **GET** /v1/bills/employee/billing-issue | Forward &#x60;Web_SetEmployeeBillingIssue&#x60; (opaque pass-through)
*BillsApi* | [**billsSubmitSplitInitiatorEdit**](docs/BillsApi.md#billssubmitsplitinitiatoredit) | **GET** /v1/bills/split/initiator-edit | Forward &#x60;Web_SubmitBillSplitInitiatorEdit&#x60; (opaque pass-through)
*BillsApi* | [**billsToggleSyncTracking**](docs/BillsApi.md#billstogglesynctracking) | **GET** /v1/bills/sync-tracking | Forward &#x60;Common_ToggleBillSyncTracking&#x60; (opaque pass-through)
*BillsApi* | [**billsUnclaimItem**](docs/BillsApi.md#billsunclaimitem) | **GET** /v1/bills/item/unclaim | Forward &#x60;Web_UnclaimBillItem&#x60; (opaque pass-through)
*BillsApi* | [**billsUpdatePostalCode**](docs/BillsApi.md#billsupdatepostalcode) | **GET** /v1/bills/billing/postal-code | Forward &#x60;Web_BillingZipModal_UpdateBillingPostalCode&#x60; (opaque pass-through)
*BudgetsApi* | [**getBudgetMonth**](docs/BudgetsApi.md#getbudgetmonth) | **GET** /v1/budgets/month | Single-month budget data (slim), per-category amounts only
*BudgetsApi* | [**getBudgetStatus**](docs/BudgetsApi.md#getbudgetstatus) | **GET** /v1/budgets/status | Budget status (initialized? has transactions?)
*BudgetsApi* | [**getBudgetTimeline**](docs/BudgetsApi.md#getbudgettimeline) | **GET** /v1/budgets/timeline | Multi-month budget vs. actual timeline
*BudgetsApi* | [**getBudgets**](docs/BudgetsApi.md#getbudgets) | **GET** /v1/budgets | Monthly budget data + actuals
*BudgetsApi* | [**resetBudget**](docs/BudgetsApi.md#resetbudget) | **POST** /v1/budgets/reset | Reset all planned amounts for one month back to defaults
*BudgetsApi* | [**setBudgetAmount**](docs/BudgetsApi.md#setbudgetamount) | **POST** /v1/budgets/items | Set the planned amount for one category OR category-group for a month
*BudgetsApi* | [**updateBudgetSettings**](docs/BudgetsApi.md#updatebudgetsettings) | **PATCH** /v1/budgets/settings | Update household budget settings
*BudgetsApi* | [**updateFlexRolloverSettings**](docs/BudgetsApi.md#updateflexrolloversettings) | **PUT** /v1/budgets/flex/rollover | Configure / reset the Flex bucket rollover period
*BudgetsApi* | [**updateFlexibleBudget**](docs/BudgetsApi.md#updateflexiblebudget) | **PUT** /v1/budgets/flex | Update the Flex bucket total for a month
*BusinessEntityApi* | [**businessEntitiesDelete**](docs/BusinessEntityApi.md#businessentitiesdelete) | **GET** /v1/business-entities/delete | Forward &#x60;Common_DeleteBusinessEntity&#x60; (opaque pass-through)
*BusinessEntityApi* | [**businessEntitiesDeleteLogo**](docs/BusinessEntityApi.md#businessentitiesdeletelogo) | **GET** /v1/business-entities/logo/delete | Forward &#x60;Common_DeleteBusinessEntityLogo&#x60; (opaque pass-through)
*BusinessEntityApi* | [**businessEntitiesDemoPopulate**](docs/BusinessEntityApi.md#businessentitiesdemopopulate) | **GET** /v1/business-entities/demo/populate | Forward &#x60;Web_PopulateBusinessEntityDemo&#x60; (opaque pass-through)
*BusinessEntityApi* | [**businessEntitiesDemoScenarios**](docs/BusinessEntityApi.md#businessentitiesdemoscenarios) | **GET** /v1/business-entities/demo/scenarios | Forward &#x60;Web_AvailableBusinessEntityDemoScenarios&#x60; (opaque pass-through)
*BusinessEntityApi* | [**businessEntitiesDetail**](docs/BusinessEntityApi.md#businessentitiesdetail) | **GET** /v1/business-entities/detail | Forward &#x60;Common_GetBusinessEntity&#x60; (opaque pass-through)
*BusinessEntityApi* | [**businessEntitiesFinancials**](docs/BusinessEntityApi.md#businessentitiesfinancials) | **GET** /v1/business-entities/financials | Forward &#x60;Common_GetBusinessEntityFinancials&#x60; (opaque pass-through)
*BusinessEntityApi* | [**businessEntitiesReportsByCategory**](docs/BusinessEntityApi.md#businessentitiesreportsbycategory) | **GET** /v1/business-entities/reports/by-category | Forward &#x60;Common_GetBusinessEntityReportsDataByCategory&#x60; (opaque pass-through)
*BusinessEntityApi* | [**businessEntitiesReportsByGroup**](docs/BusinessEntityApi.md#businessentitiesreportsbygroup) | **GET** /v1/business-entities/reports/by-group | Forward &#x60;Common_GetBusinessEntityReportsDataByGroup&#x60; (opaque pass-through)
*BusinessEntityApi* | [**businessEntitiesUpsert**](docs/BusinessEntityApi.md#businessentitiesupsert) | **GET** /v1/business-entities/upsert | Forward &#x60;Common_UpsertBusinessEntity&#x60; (opaque pass-through)
*CategoriesApi* | [**bulkDeleteCategories**](docs/CategoriesApi.md#bulkdeletecategories) | **POST** /v1/categories/bulk-delete | Bulk-delete categories
*CategoriesApi* | [**createCategory**](docs/CategoriesApi.md#createcategory) | **POST** /v1/categories | Create a custom category
*CategoriesApi* | [**createCategoryGroup**](docs/CategoriesApi.md#createcategorygroup) | **POST** /v1/category-groups | Create a category group
*CategoriesApi* | [**deleteCategory**](docs/CategoriesApi.md#deletecategory) | **DELETE** /v1/categories/{id} | Delete a category
*CategoriesApi* | [**deleteCategoryGroup**](docs/CategoriesApi.md#deletecategorygroup) | **DELETE** /v1/category-groups/{id} | Delete a category group
*CategoriesApi* | [**getCategoryDeletionInfo**](docs/CategoriesApi.md#getcategorydeletioninfo) | **GET** /v1/categories/{id}/deletion-info | Slim category snapshot for the delete-confirm flow
*CategoriesApi* | [**getCategoryEdit**](docs/CategoriesApi.md#getcategoryedit) | **GET** /v1/categories/{id}/edit | Category with full edit-form fields
*CategoriesApi* | [**getCategoryGroupDetails**](docs/CategoriesApi.md#getcategorygroupdetails) | **GET** /v1/category-groups/{id}/details | Category group with its child categories
*CategoriesApi* | [**listCategories**](docs/CategoriesApi.md#listcategories) | **GET** /v1/categories | List all transaction categories
*CategoriesApi* | [**listCategoryGroups**](docs/CategoriesApi.md#listcategorygroups) | **GET** /v1/category-groups | Parent groups (one tier above individual categories)
*CategoriesApi* | [**updateCategoryGroup**](docs/CategoriesApi.md#updatecategorygroup) | **PATCH** /v1/category-groups/{id} | Update a category group
*CategoriesApi* | [**updateCategoryGroupBudgetVariability**](docs/CategoriesApi.md#updatecategorygroupbudgetvariability) | **PATCH** /v1/category-groups/{id}/budget-variability | Set a category group\&#39;s budget-variability (fixed vs flex)
*EquityGrantsApi* | [**equityGrantsCreate**](docs/EquityGrantsApi.md#equitygrantscreate) | **GET** /v1/equity-grants/create | Forward &#x60;Web_CreateEquityGrant&#x60; (opaque pass-through)
*EquityGrantsApi* | [**equityGrantsDelete**](docs/EquityGrantsApi.md#equitygrantsdelete) | **GET** /v1/equity-grants/delete | Forward &#x60;Web_DeleteEquityGrant&#x60; (opaque pass-through)
*EquityGrantsApi* | [**equityGrantsEditModal**](docs/EquityGrantsApi.md#equitygrantseditmodal) | **GET** /v1/equity-grants/edit-modal/detail | Forward &#x60;Web_EditEquityGrantModal_GetEquityGrant&#x60; (opaque pass-through)
*EquityGrantsApi* | [**equityGrantsList**](docs/EquityGrantsApi.md#equitygrantslist) | **GET** /v1/equity-grants | Forward &#x60;Web_GetEquityGrants&#x60; (opaque pass-through)
*EquityGrantsApi* | [**equityGrantsManageHoldingsModal**](docs/EquityGrantsApi.md#equitygrantsmanageholdingsmodal) | **GET** /v1/equity-grants/manage-holdings-modal | Forward &#x60;Web_ManageEquityHoldingsModal_GetEquityGrants&#x60; (opaque pass-through)
*EquityGrantsApi* | [**equityGrantsPreview**](docs/EquityGrantsApi.md#equitygrantspreview) | **GET** /v1/equity-grants/preview | Forward &#x60;Web_PreviewEquityGrant&#x60; (opaque pass-through)
*EquityGrantsApi* | [**equityGrantsUpdate**](docs/EquityGrantsApi.md#equitygrantsupdate) | **GET** /v1/equity-grants/update | Forward &#x60;Web_UpdateEquityGrant&#x60; (opaque pass-through)
*ForecastApi* | [**forecastCreateScenario**](docs/ForecastApi.md#forecastcreatescenario) | **GET** /v1/forecast/scenarios/create | Forward &#x60;Web_CreateForecastScenario&#x60; (opaque pass-through)
*ForecastApi* | [**forecastDeleteScenario**](docs/ForecastApi.md#forecastdeletescenario) | **GET** /v1/forecast/scenarios/delete | Forward &#x60;Web_DeleteForecastScenario&#x60; (opaque pass-through)
*ForecastApi* | [**forecastDuplicateScenario**](docs/ForecastApi.md#forecastduplicatescenario) | **GET** /v1/forecast/scenarios/duplicate | Forward &#x60;Web_DuplicateForecastScenario&#x60; (opaque pass-through)
*ForecastApi* | [**forecastInitialize**](docs/ForecastApi.md#forecastinitialize) | **GET** /v1/forecast/initialize | Forward &#x60;Web_InitializeForecast&#x60; (opaque pass-through)
*ForecastApi* | [**forecastOnboardingComplete**](docs/ForecastApi.md#forecastonboardingcomplete) | **GET** /v1/forecast/onboarding/complete | Forward &#x60;Web_MarkForecastOnboardingComplete&#x60; (opaque pass-through)
*ForecastApi* | [**forecastReplaceEvents**](docs/ForecastApi.md#forecastreplaceevents) | **GET** /v1/forecast/events/replace | Forward &#x60;Web_ReplaceForecastEvents&#x60; (opaque pass-through)
*ForecastApi* | [**forecastResetData**](docs/ForecastApi.md#forecastresetdata) | **GET** /v1/forecast/data/reset | Forward &#x60;Web_ResetForecastData&#x60; (opaque pass-through)
*ForecastApi* | [**forecastResetOnboarding**](docs/ForecastApi.md#forecastresetonboarding) | **GET** /v1/forecast/onboarding/reset | Forward &#x60;Web_ResetForecastOnboarding&#x60; (opaque pass-through)
*ForecastApi* | [**forecastSaveAccounts**](docs/ForecastApi.md#forecastsaveaccounts) | **GET** /v1/forecast/accounts | Forward &#x60;Web_SaveForecastAccounts&#x60; (opaque pass-through)
*ForecastApi* | [**forecastSaveParticipantOverrides**](docs/ForecastApi.md#forecastsaveparticipantoverrides) | **GET** /v1/forecast/participant-overrides | Forward &#x60;Web_SaveForecastParticipantOverrides&#x60; (opaque pass-through)
*ForecastApi* | [**forecastSavePriorityRules**](docs/ForecastApi.md#forecastsavepriorityrules) | **GET** /v1/forecast/priority-rules | Forward &#x60;Web_SaveForecastPriorityRules&#x60; (opaque pass-through)
*ForecastApi* | [**forecastSaveScenarioKpis**](docs/ForecastApi.md#forecastsavescenariokpis) | **GET** /v1/forecast/scenario-kpis | Forward &#x60;Web_SaveForecastScenarioKpis&#x60; (opaque pass-through)
*ForecastApi* | [**forecastScenario**](docs/ForecastApi.md#forecastscenario) | **GET** /v1/forecast/scenario | Forward &#x60;Web_ForecastScenario&#x60; (opaque pass-through)
*ForecastApi* | [**forecastScenarios**](docs/ForecastApi.md#forecastscenarios) | **GET** /v1/forecast/scenarios | Forward &#x60;Web_ForecastScenarios&#x60; (opaque pass-through)
*ForecastApi* | [**forecastUpdateScenario**](docs/ForecastApi.md#forecastupdatescenario) | **GET** /v1/forecast/scenarios/update | Forward &#x60;Web_UpdateForecastScenario&#x60; (opaque pass-through)
*ForecastApi* | [**forecastUpdateScenarioOrder**](docs/ForecastApi.md#forecastupdatescenarioorder) | **GET** /v1/forecast/scenarios/order | Forward &#x60;Web_UpdateForecastScenarioOrder&#x60; (opaque pass-through)
*ForecastApi* | [**forecastUpdateUserFinancialProfile**](docs/ForecastApi.md#forecastupdateuserfinancialprofile) | **GET** /v1/forecast/user-financial-profile | Forward &#x60;Web_ForecastUpdateUserFinancialProfile&#x60; (opaque pass-through)
*GoalsApi* | [**archiveGoal**](docs/GoalsApi.md#archivegoal) | **DELETE** /v1/goals/{id} | Archive a savings goal
*GoalsApi* | [**contributeToGoal**](docs/GoalsApi.md#contributetogoal) | **POST** /v1/goals/{id}/contributions | Record a contribution to a savings goal
*GoalsApi* | [**createGoal**](docs/GoalsApi.md#creategoal) | **POST** /v1/goals | Create a new savings or debt-payoff goal
*GoalsApi* | [**deleteGoalV2**](docs/GoalsApi.md#deletegoalv2) | **DELETE** /v1/goals/{id}/v2-delete | Delete a goal (v2 mutation)
*GoalsApi* | [**getGoal**](docs/GoalsApi.md#getgoal) | **GET** /v1/goals/{id} | Get one savings goal
*GoalsApi* | [**getGoalContributionHistory**](docs/GoalsApi.md#getgoalcontributionhistory) | **GET** /v1/goals/{id}/contribution-history | Goal contribution history
*GoalsApi* | [**getGoalProjection**](docs/GoalsApi.md#getgoalprojection) | **GET** /v1/goals/{id}/projection | Goal projection chart
*GoalsApi* | [**getGoalsCurrentMonthTotals**](docs/GoalsApi.md#getgoalscurrentmonthtotals) | **GET** /v1/goals/totals/current-month | Current-month planned-contribution totals per goal
*GoalsApi* | [**hardDeleteGoal**](docs/GoalsApi.md#harddeletegoal) | **DELETE** /v1/goals/{id}/hard | Hard-delete a savings goal
*GoalsApi* | [**linkTransactionToGoal**](docs/GoalsApi.md#linktransactiontogoal) | **POST** /v1/transactions/{id}/goal-link | Link a transaction to a savings goal
*GoalsApi* | [**listGoalEvents**](docs/GoalsApi.md#listgoalevents) | **GET** /v1/goals/{id}/events | Event log for one savings goal
*GoalsApi* | [**listGoals**](docs/GoalsApi.md#listgoals) | **GET** /v1/goals | List all savings goals
*GoalsApi* | [**markGoalComplete**](docs/GoalsApi.md#markgoalcomplete) | **POST** /v1/goals/{id}/complete | Mark a goal complete
*GoalsApi* | [**markGoalIncomplete**](docs/GoalsApi.md#markgoalincomplete) | **POST** /v1/goals/{id}/incomplete | Mark a goal incomplete
*GoalsApi* | [**setGoalBudgetAmount**](docs/GoalsApi.md#setgoalbudgetamount) | **PUT** /v1/goals/{id}/budget | Set monthly budget allocation for a savings goal
*GoalsApi* | [**spendFromGoal**](docs/GoalsApi.md#spendfromgoal) | **POST** /v1/goals/{id}/spend | Spend from a savings goal
*GoalsApi* | [**unarchiveGoal**](docs/GoalsApi.md#unarchivegoal) | **POST** /v1/goals/{id}/unarchive | Un-archive a savings goal
*GoalsApi* | [**unlinkTransactionGoalRecords**](docs/GoalsApi.md#unlinktransactiongoalrecords) | **DELETE** /v1/transactions/{id}/goal-link | Unlink any goal-reconciliation records for a transaction
*GoalsApi* | [**updateGoal**](docs/GoalsApi.md#updategoal) | **PATCH** /v1/goals/{id} | Update a savings goal
*GoalsApi* | [**updateGoalsPriorities**](docs/GoalsApi.md#updategoalspriorities) | **PUT** /v1/goals/priorities | Re-order savings goals by priority
*GoalsApi* | [**withdrawFromGoal**](docs/GoalsApi.md#withdrawfromgoal) | **POST** /v1/goals/{id}/withdraw | Withdraw from a savings goal
*HoldingsApi* | [**bulkUpdateHoldings**](docs/HoldingsApi.md#bulkupdateholdings) | **PATCH** /v1/holdings/bulk | Bulk reprice manual holdings
*HoldingsApi* | [**createManualHolding**](docs/HoldingsApi.md#createmanualholding) | **POST** /v1/account/{id}/holdings | Add a manual holding to an account
*HoldingsApi* | [**createManualInvestmentsAccount**](docs/HoldingsApi.md#createmanualinvestmentsaccount) | **POST** /v1/accounts/manual-investments | Create a manual investments account
*HoldingsApi* | [**deleteHolding**](docs/HoldingsApi.md#deleteholding) | **DELETE** /v1/holdings/{id} | Delete a holding
*HoldingsApi* | [**getHoldingHistory**](docs/HoldingsApi.md#getholdinghistory) | **GET** /v1/holdings/{id}/history | Holding value history
*HoldingsApi* | [**getHoldingTransactions**](docs/HoldingsApi.md#getholdingtransactions) | **GET** /v1/holdings/{id}/transactions | Holding transactions (buys, sells, dividends)
*HoldingsApi* | [**getPortfolioAllocation**](docs/HoldingsApi.md#getportfolioallocation) | **GET** /v1/portfolio/allocation | Portfolio allocation by classification
*HoldingsApi* | [**getPortfolioAllocationByAccount**](docs/HoldingsApi.md#getportfolioallocationbyaccount) | **GET** /v1/portfolio/allocation/by-account | Portfolio allocation grouped by account
*HoldingsApi* | [**getPortfolioAllocationByHoldings**](docs/HoldingsApi.md#getportfolioallocationbyholdings) | **GET** /v1/portfolio/allocation/by-holdings | Portfolio allocation grouped by holding
*HoldingsApi* | [**getPortfolioAllocationHoldingsDetail**](docs/HoldingsApi.md#getportfolioallocationholdingsdetail) | **GET** /v1/portfolio/allocation/holdings-detail | Holdings within one allocation bucket
*HoldingsApi* | [**getSecurityDetails**](docs/HoldingsApi.md#getsecuritydetails) | **GET** /v1/securities/{id} | Security details
*HoldingsApi* | [**getSecurityDividends**](docs/HoldingsApi.md#getsecuritydividends) | **GET** /v1/securities/{id}/dividends | Security dividend history
*HoldingsApi* | [**getSecurityHistoricalPerformance**](docs/HoldingsApi.md#getsecurityhistoricalperformance) | **GET** /v1/securities/{id}/performance | Historical performance for one security
*HoldingsApi* | [**searchSecurities**](docs/HoldingsApi.md#searchsecurities) | **GET** /v1/securities/search | Search the security catalog
*HoldingsApi* | [**updateHolding**](docs/HoldingsApi.md#updateholding) | **PATCH** /v1/holdings/{id} | Update a holding
*LongTailApi* | [**longTailAccountTransferResultQuery**](docs/LongTailApi.md#longtailaccounttransferresultquery) | **POST** /v1/x/account-transfer-result-query | Long-tail wrapper for &#x60;Common_AccountTransferResultQuery&#x60;
*LongTailApi* | [**longTailAccountTransferStatusQuery**](docs/LongTailApi.md#longtailaccounttransferstatusquery) | **POST** /v1/x/account-transfer-status-query | Long-tail wrapper for &#x60;Common_AccountTransferStatusQuery&#x60;
*LongTailApi* | [**longTailAccountsTransferEligibility**](docs/LongTailApi.md#longtailaccountstransfereligibility) | **POST** /v1/x/accounts-transfer-eligibility | Long-tail wrapper for &#x60;Common_AccountsTransferEligibility&#x60;
*LongTailApi* | [**longTailAllActiveInstitutionNotices**](docs/LongTailApi.md#longtailallactiveinstitutionnotices) | **POST** /v1/x/all-active-institution-notices | Long-tail wrapper for &#x60;Common_AllActiveInstitutionNotices&#x60;
*LongTailApi* | [**longTailArchiveGoal**](docs/LongTailApi.md#longtailarchivegoal) | **POST** /v1/x/archive-goal | Long-tail wrapper for &#x60;Common_ArchiveGoal&#x60;
*LongTailApi* | [**longTailCancelMessageThread**](docs/LongTailApi.md#longtailcancelmessagethread) | **POST** /v1/x/cancel-message-thread | Long-tail wrapper for &#x60;Common_CancelMessageThread&#x60;
*LongTailApi* | [**longTailCancelSubscriptionForHousehold**](docs/LongTailApi.md#longtailcancelsubscriptionforhousehold) | **POST** /v1/x/cancel-subscription-for-household | Long-tail wrapper for &#x60;Common_CancelSubscriptionForHousehold&#x60;
*LongTailApi* | [**longTailCategoryDeletionInfo**](docs/LongTailApi.md#longtailcategorydeletioninfo) | **POST** /v1/x/category-deletion-info | Long-tail wrapper for &#x60;CategoryDeletionInfo&#x60;
*LongTailApi* | [**longTailCheckActivityMutation**](docs/LongTailApi.md#longtailcheckactivitymutation) | **POST** /v1/x/check-activity-mutation | Long-tail wrapper for &#x60;Common_CheckActivityMutation&#x60;
*LongTailApi* | [**longTailCompleteRetailSync**](docs/LongTailApi.md#longtailcompleteretailsync) | **POST** /v1/x/complete-retail-sync | Long-tail wrapper for &#x60;Common_CompleteRetailSync&#x60;
*LongTailApi* | [**longTailCompleteSavingsGoalsMigration**](docs/LongTailApi.md#longtailcompletesavingsgoalsmigration) | **POST** /v1/x/complete-savings-goals-migration | Long-tail wrapper for &#x60;Common_CompleteSavingsGoalsMigration&#x60;
*LongTailApi* | [**longTailCreateAccountsFromPlaidToken**](docs/LongTailApi.md#longtailcreateaccountsfromplaidtoken) | **POST** /v1/x/create-accounts-from-plaid-token | Long-tail wrapper for &#x60;Common_CreateAccountsFromPlaidToken&#x60;
*LongTailApi* | [**longTailCreateBudgetForHousehold**](docs/LongTailApi.md#longtailcreatebudgetforhousehold) | **POST** /v1/x/create-budget-for-household | Long-tail wrapper for &#x60;Common_CreateBudgetForHousehold&#x60;
*LongTailApi* | [**longTailCreateBulkRetailSync**](docs/LongTailApi.md#longtailcreatebulkretailsync) | **POST** /v1/x/create-bulk-retail-sync | Long-tail wrapper for &#x60;Common_CreateBulkRetailSync&#x60;
*LongTailApi* | [**longTailCreateGoalAccountAllocation**](docs/LongTailApi.md#longtailcreategoalaccountallocation) | **POST** /v1/x/create-goal-account-allocation | Long-tail wrapper for &#x60;Common_CreateGoalAccountAllocation&#x60;
*LongTailApi* | [**longTailCreateGoals**](docs/LongTailApi.md#longtailcreategoals) | **POST** /v1/x/create-goals | Long-tail wrapper for &#x60;Common_CreateGoals&#x60;
*LongTailApi* | [**longTailCreateHouseholdAccessGrant**](docs/LongTailApi.md#longtailcreatehouseholdaccessgrant) | **POST** /v1/x/create-household-access-grant | Long-tail wrapper for &#x60;CreateHouseholdAccessGrant&#x60;
*LongTailApi* | [**longTailCreateInstitutionIssueReportMutation**](docs/LongTailApi.md#longtailcreateinstitutionissuereportmutation) | **POST** /v1/x/create-institution-issue-report-mutation | Long-tail wrapper for &#x60;Common_CreateInstitutionIssueReportMutation&#x60;
*LongTailApi* | [**longTailCreateOrUpdateGoalV2PlannedContributionMutation**](docs/LongTailApi.md#longtailcreateorupdategoalv2plannedcontributionmutation) | **POST** /v1/x/create-or-update-goal-v2-planned-contribution-mutation | Long-tail wrapper for &#x60;Common_CreateOrUpdateGoalV2PlannedContributionMutation&#x60;
*LongTailApi* | [**longTailCreatePromoCodeCheckoutSession**](docs/LongTailApi.md#longtailcreatepromocodecheckoutsession) | **POST** /v1/x/create-promo-code-checkout-session | Long-tail wrapper for &#x60;CreatePromoCodeCheckoutSession&#x60;
*LongTailApi* | [**longTailCreateRetailSync**](docs/LongTailApi.md#longtailcreateretailsync) | **POST** /v1/x/create-retail-sync | Long-tail wrapper for &#x60;Common_CreateRetailSync&#x60;
*LongTailApi* | [**longTailCreateSavingsGoalAccountInitialContributions**](docs/LongTailApi.md#longtailcreatesavingsgoalaccountinitialcontributions) | **POST** /v1/x/create-savings-goal-account-initial-contributions | Long-tail wrapper for &#x60;Common_CreateSavingsGoalAccountInitialContributions&#x60;
*LongTailApi* | [**longTailCreateThreadMutation**](docs/LongTailApi.md#longtailcreatethreadmutation) | **POST** /v1/x/create-thread-mutation | Long-tail wrapper for &#x60;Common_CreateThreadMutation&#x60;
*LongTailApi* | [**longTailDebtPaydown**](docs/LongTailApi.md#longtaildebtpaydown) | **POST** /v1/x/debt-paydown | Long-tail wrapper for &#x60;Common_DebtPaydown&#x60;
*LongTailApi* | [**longTailDebtPaydownAccounts**](docs/LongTailApi.md#longtaildebtpaydownaccounts) | **POST** /v1/x/debt-paydown-accounts | Long-tail wrapper for &#x60;Common_DebtPaydownAccounts&#x60;
*LongTailApi* | [**longTailDeleteAllMessageThreads**](docs/LongTailApi.md#longtaildeleteallmessagethreads) | **POST** /v1/x/delete-all-message-threads | Long-tail wrapper for &#x60;Common_DeleteAllMessageThreads&#x60;
*LongTailApi* | [**longTailDeleteGoalAccountAllocation**](docs/LongTailApi.md#longtaildeletegoalaccountallocation) | **POST** /v1/x/delete-goal-account-allocation | Long-tail wrapper for &#x60;Common_DeleteGoalAccountAllocation&#x60;
*LongTailApi* | [**longTailDeleteHousehold**](docs/LongTailApi.md#longtaildeletehousehold) | **POST** /v1/x/delete-household | Long-tail wrapper for &#x60;Common_DeleteHousehold&#x60;
*LongTailApi* | [**longTailDeleteMessageThread**](docs/LongTailApi.md#longtaildeletemessagethread) | **POST** /v1/x/delete-message-thread | Long-tail wrapper for &#x60;Common_DeleteMessageThread&#x60;
*LongTailApi* | [**longTailDeleteRetailSync**](docs/LongTailApi.md#longtaildeleteretailsync) | **POST** /v1/x/delete-retail-sync | Long-tail wrapper for &#x60;Common_DeleteRetailSync&#x60;
*LongTailApi* | [**longTailDeleteSavingsGoalEvent**](docs/LongTailApi.md#longtaildeletesavingsgoalevent) | **POST** /v1/x/delete-savings-goal-event | Long-tail wrapper for &#x60;Common_DeleteSavingsGoalEvent&#x60;
*LongTailApi* | [**longTailDeleteSyncedSnapshotsMutation**](docs/LongTailApi.md#longtaildeletesyncedsnapshotsmutation) | **POST** /v1/x/delete-synced-snapshots-mutation | Long-tail wrapper for &#x60;Common_DeleteSyncedSnapshotsMutation&#x60;
*LongTailApi* | [**longTailDeleteSyncedTransactionsMutation**](docs/LongTailApi.md#longtaildeletesyncedtransactionsmutation) | **POST** /v1/x/delete-synced-transactions-mutation | Long-tail wrapper for &#x60;Common_DeleteSyncedTransactionsMutation&#x60;
*LongTailApi* | [**longTailDeleteTransactionsMutation**](docs/LongTailApi.md#longtaildeletetransactionsmutation) | **POST** /v1/x/delete-transactions-mutation | Long-tail wrapper for &#x60;Common_DeleteTransactionsMutation&#x60;
*LongTailApi* | [**longTailDisableCredentialAndDeleteFromDataProvider**](docs/LongTailApi.md#longtaildisablecredentialanddeletefromdataprovider) | **POST** /v1/x/disable-credential-and-delete-from-data-provider | Long-tail wrapper for &#x60;Common_DisableCredentialAndDeleteFromDataProvider&#x60;
*LongTailApi* | [**longTailDisconnectSpinwheel**](docs/LongTailApi.md#longtaildisconnectspinwheel) | **POST** /v1/x/disconnect-spinwheel | Long-tail wrapper for &#x60;Common_DisconnectSpinwheel&#x60;
*LongTailApi* | [**longTailDismissBusinessEntitiesBanner**](docs/LongTailApi.md#longtaildismissbusinessentitiesbanner) | **POST** /v1/x/dismiss-business-entities-banner | Long-tail wrapper for &#x60;Common_DismissBusinessEntitiesBanner&#x60;
*LongTailApi* | [**longTailDispatchSavingsGoalMigration**](docs/LongTailApi.md#longtaildispatchsavingsgoalmigration) | **POST** /v1/x/dispatch-savings-goal-migration | Long-tail wrapper for &#x60;Common_DispatchSavingsGoalMigration&#x60;
*LongTailApi* | [**longTailFixCoinbaseCredential**](docs/LongTailApi.md#longtailfixcoinbasecredential) | **POST** /v1/x/fix-coinbase-credential | Long-tail wrapper for &#x60;Common_FixCoinbaseCredential&#x60;
*LongTailApi* | [**longTailForceRefreshAccountMutation**](docs/LongTailApi.md#longtailforcerefreshaccountmutation) | **POST** /v1/x/force-refresh-account-mutation | Long-tail wrapper for &#x60;Common_ForceRefreshAccountMutation&#x60;
*LongTailApi* | [**longTailForceRefreshAccountQuery**](docs/LongTailApi.md#longtailforcerefreshaccountquery) | **POST** /v1/x/force-refresh-account-query | Long-tail wrapper for &#x60;Common_ForceRefreshAccountQuery&#x60;
*LongTailApi* | [**longTailForceRefreshOperationQuery**](docs/LongTailApi.md#longtailforcerefreshoperationquery) | **POST** /v1/x/force-refresh-operation-query | Long-tail wrapper for &#x60;Common_ForceRefreshOperationQuery&#x60;
*LongTailApi* | [**longTailGetAccount**](docs/LongTailApi.md#longtailgetaccount) | **POST** /v1/x/get-account | Long-tail wrapper for &#x60;Common_GetAccount&#x60;
*LongTailApi* | [**longTailGetAccountsForEditingEntities**](docs/LongTailApi.md#longtailgetaccountsforeditingentities) | **POST** /v1/x/get-accounts-for-editing-entities | Long-tail wrapper for &#x60;Common_GetAccountsForEditingEntities&#x60;
*LongTailApi* | [**longTailGetAccountsForEditingOwnership**](docs/LongTailApi.md#longtailgetaccountsforeditingownership) | **POST** /v1/x/get-accounts-for-editing-ownership | Long-tail wrapper for &#x60;Common_GetAccountsForEditingOwnership&#x60;
*LongTailApi* | [**longTailGetActAsUserExternalId**](docs/LongTailApi.md#longtailgetactasuserexternalid) | **POST** /v1/x/get-act-as-user-external-id | Long-tail wrapper for &#x60;Common_GetActAsUserExternalId&#x60;
*LongTailApi* | [**longTailGetAggregatesGraph**](docs/LongTailApi.md#longtailgetaggregatesgraph) | **POST** /v1/x/get-aggregates-graph | Long-tail wrapper for &#x60;GetAggregatesGraph&#x60;
*LongTailApi* | [**longTailGetAggregatesGraphCategoryGroup**](docs/LongTailApi.md#longtailgetaggregatesgraphcategorygroup) | **POST** /v1/x/get-aggregates-graph-category-group | Long-tail wrapper for &#x60;GetAggregatesGraphCategoryGroup&#x60;
*LongTailApi* | [**longTailGetAggregatesGraphFlexExpense**](docs/LongTailApi.md#longtailgetaggregatesgraphflexexpense) | **POST** /v1/x/get-aggregates-graph-flex-expense | Long-tail wrapper for &#x60;GetAggregatesGraphFlexExpense&#x60;
*LongTailApi* | [**longTailGetAssistantFeedback**](docs/LongTailApi.md#longtailgetassistantfeedback) | **POST** /v1/x/get-assistant-feedback | Long-tail wrapper for &#x60;Common_GetAssistantFeedback&#x60;
*LongTailApi* | [**longTailGetBusinessEntities**](docs/LongTailApi.md#longtailgetbusinessentities) | **POST** /v1/x/get-business-entities | Long-tail wrapper for &#x60;Common_GetBusinessEntities&#x60;
*LongTailApi* | [**longTailGetBusinessEntitiesBannerProfile**](docs/LongTailApi.md#longtailgetbusinessentitiesbannerprofile) | **POST** /v1/x/get-business-entities-banner-profile | Long-tail wrapper for &#x60;Common_GetBusinessEntitiesBannerProfile&#x60;
*LongTailApi* | [**longTailGetBusinessEntitiesSummary**](docs/LongTailApi.md#longtailgetbusinessentitiessummary) | **POST** /v1/x/get-business-entities-summary | Long-tail wrapper for &#x60;Common_GetBusinessEntitiesSummary&#x60;
*LongTailApi* | [**longTailGetCanRequestReview**](docs/LongTailApi.md#longtailgetcanrequestreview) | **POST** /v1/x/get-can-request-review | Long-tail wrapper for &#x60;GetCanRequestReview&#x60;
*LongTailApi* | [**longTailGetCanSkipPremiumUpsell**](docs/LongTailApi.md#longtailgetcanskippremiumupsell) | **POST** /v1/x/get-can-skip-premium-upsell | Long-tail wrapper for &#x60;GetCanSkipPremiumUpsell&#x60;
*LongTailApi* | [**longTailGetCategoryDetails**](docs/LongTailApi.md#longtailgetcategorydetails) | **POST** /v1/x/get-category-details | Long-tail wrapper for &#x60;GetCategoryDetails&#x60;
*LongTailApi* | [**longTailGetCategoryEntity**](docs/LongTailApi.md#longtailgetcategoryentity) | **POST** /v1/x/get-category-entity | Long-tail wrapper for &#x60;Common_GetCategoryEntity&#x60;
*LongTailApi* | [**longTailGetCategoryGroup**](docs/LongTailApi.md#longtailgetcategorygroup) | **POST** /v1/x/get-category-group | Long-tail wrapper for &#x60;GetCategoryGroup&#x60;
*LongTailApi* | [**longTailGetCategoryGroups**](docs/LongTailApi.md#longtailgetcategorygroups) | **POST** /v1/x/get-category-groups | Long-tail wrapper for &#x60;GetCategoryGroups&#x60;
*LongTailApi* | [**longTailGetCloudinaryUploadInfo**](docs/LongTailApi.md#longtailgetcloudinaryuploadinfo) | **POST** /v1/x/get-cloudinary-upload-info | Long-tail wrapper for &#x60;Common_GetCloudinaryUploadInfo&#x60;
*LongTailApi* | [**longTailGetContactSupportFormRecommendedResolution**](docs/LongTailApi.md#longtailgetcontactsupportformrecommendedresolution) | **POST** /v1/x/get-contact-support-form-recommended-resolution | Long-tail wrapper for &#x60;GetContactSupportFormRecommendedResolution&#x60;
*LongTailApi* | [**longTailGetDashboardConfig**](docs/LongTailApi.md#longtailgetdashboardconfig) | **POST** /v1/x/get-dashboard-config | Long-tail wrapper for &#x60;GetDashboardConfig&#x60;
*LongTailApi* | [**longTailGetDebtAccountsForMigration**](docs/LongTailApi.md#longtailgetdebtaccountsformigration) | **POST** /v1/x/get-debt-accounts-for-migration | Long-tail wrapper for &#x60;Common_GetDebtAccountsForMigration&#x60;
*LongTailApi* | [**longTailGetDecagonInstitutionsStatus**](docs/LongTailApi.md#longtailgetdecagoninstitutionsstatus) | **POST** /v1/x/get-decagon-institutions-status | Long-tail wrapper for &#x60;Common_GetDecagonInstitutionsStatus&#x60;
*LongTailApi* | [**longTailGetDecagonLinkedCredentials**](docs/LongTailApi.md#longtailgetdecagonlinkedcredentials) | **POST** /v1/x/get-decagon-linked-credentials | Long-tail wrapper for &#x60;Common_GetDecagonLinkedCredentials&#x60;
*LongTailApi* | [**longTailGetDecagonSubscriptionStatus**](docs/LongTailApi.md#longtailgetdecagonsubscriptionstatus) | **POST** /v1/x/get-decagon-subscription-status | Long-tail wrapper for &#x60;Common_GetDecagonSubscriptionStatus&#x60;
*LongTailApi* | [**longTailGetDecagonToken**](docs/LongTailApi.md#longtailgetdecagontoken) | **POST** /v1/x/get-decagon-token | Long-tail wrapper for &#x60;Common_GetDecagonToken&#x60;
*LongTailApi* | [**longTailGetFeatureEntitlementParams**](docs/LongTailApi.md#longtailgetfeatureentitlementparams) | **POST** /v1/x/get-feature-entitlement-params | Long-tail wrapper for &#x60;Common_GetFeatureEntitlementParams&#x60;
*LongTailApi* | [**longTailGetGiftedSubscriptions**](docs/LongTailApi.md#longtailgetgiftedsubscriptions) | **POST** /v1/x/get-gifted-subscriptions | Long-tail wrapper for &#x60;Common_GetGiftedSubscriptions&#x60;
*LongTailApi* | [**longTailGetGoalsV2**](docs/LongTailApi.md#longtailgetgoalsv2) | **POST** /v1/x/get-goals-v2 | Long-tail wrapper for &#x60;GetGoalsV2&#x60;
*LongTailApi* | [**longTailGetHasAccounts**](docs/LongTailApi.md#longtailgethasaccounts) | **POST** /v1/x/get-has-accounts | Long-tail wrapper for &#x60;Common_GetHasAccounts&#x60;
*LongTailApi* | [**longTailGetHasSpinwheelUser**](docs/LongTailApi.md#longtailgethasspinwheeluser) | **POST** /v1/x/get-has-spinwheel-user | Long-tail wrapper for &#x60;Common_GetHasSpinwheelUser&#x60;
*LongTailApi* | [**longTailGetHasSyncedAccounts**](docs/LongTailApi.md#longtailgethassyncedaccounts) | **POST** /v1/x/get-has-synced-accounts | Long-tail wrapper for &#x60;Common_GetHasSyncedAccounts&#x60;
*LongTailApi* | [**longTailGetHoldingDetailsFormSecurityDetails**](docs/LongTailApi.md#longtailgetholdingdetailsformsecuritydetails) | **POST** /v1/x/get-holding-details-form-security-details | Long-tail wrapper for &#x60;GetHoldingDetailsFormSecurityDetails&#x60;
*LongTailApi* | [**longTailGetHoldingSummarySecurityDetails**](docs/LongTailApi.md#longtailgetholdingsummarysecuritydetails) | **POST** /v1/x/get-holding-summary-security-details | Long-tail wrapper for &#x60;GetHoldingSummarySecurityDetails&#x60;
*LongTailApi* | [**longTailGetHouseHoldMemberSettings**](docs/LongTailApi.md#longtailgethouseholdmembersettings) | **POST** /v1/x/get-house-hold-member-settings | Long-tail wrapper for &#x60;Common_GetHouseHoldMemberSettings&#x60;
*LongTailApi* | [**longTailGetInstitutionByProviderId**](docs/LongTailApi.md#longtailgetinstitutionbyproviderid) | **POST** /v1/x/get-institution-by-provider-id | Long-tail wrapper for &#x60;GetInstitutionByProviderId&#x60;
*LongTailApi* | [**longTailGetInstitutionLogoByPlaidId**](docs/LongTailApi.md#longtailgetinstitutionlogobyplaidid) | **POST** /v1/x/get-institution-logo-by-plaid-id | Long-tail wrapper for &#x60;GetInstitutionLogoByPlaidId&#x60;
*LongTailApi* | [**longTailGetMerchant**](docs/LongTailApi.md#longtailgetmerchant) | **POST** /v1/x/get-merchant | Long-tail wrapper for &#x60;Common_GetMerchant&#x60;
*LongTailApi* | [**longTailGetMerchantDetails**](docs/LongTailApi.md#longtailgetmerchantdetails) | **POST** /v1/x/get-merchant-details | Long-tail wrapper for &#x60;GetMerchantDetails&#x60;
*LongTailApi* | [**longTailGetMerchantEntity**](docs/LongTailApi.md#longtailgetmerchantentity) | **POST** /v1/x/get-merchant-entity | Long-tail wrapper for &#x60;Common_GetMerchantEntity&#x60;
*LongTailApi* | [**longTailGetMessageThread**](docs/LongTailApi.md#longtailgetmessagethread) | **POST** /v1/x/get-message-thread | Long-tail wrapper for &#x60;Common_GetMessageThread&#x60;
*LongTailApi* | [**longTailGetMessageThreads**](docs/LongTailApi.md#longtailgetmessagethreads) | **POST** /v1/x/get-message-threads | Long-tail wrapper for &#x60;Common_GetMessageThreads&#x60;
*LongTailApi* | [**longTailGetMobileSubscriptionOffering**](docs/LongTailApi.md#longtailgetmobilesubscriptionoffering) | **POST** /v1/x/get-mobile-subscription-offering | Long-tail wrapper for &#x60;GetMobileSubscriptionOffering&#x60;
*LongTailApi* | [**longTailGetNotificationPreference**](docs/LongTailApi.md#longtailgetnotificationpreference) | **POST** /v1/x/get-notification-preference | Long-tail wrapper for &#x60;Common_GetNotificationPreference&#x60;
*LongTailApi* | [**longTailGetOnboardingFinancialGoals**](docs/LongTailApi.md#longtailgetonboardingfinancialgoals) | **POST** /v1/x/get-onboarding-financial-goals | Long-tail wrapper for &#x60;Common_GetOnboardingFinancialGoals&#x60;
*LongTailApi* | [**longTailGetPlanOnboardingState**](docs/LongTailApi.md#longtailgetplanonboardingstate) | **POST** /v1/x/get-plan-onboarding-state | Long-tail wrapper for &#x60;Common_GetPlanOnboardingState&#x60;
*LongTailApi* | [**longTailGetPremiumUpgradePlans**](docs/LongTailApi.md#longtailgetpremiumupgradeplans) | **POST** /v1/x/get-premium-upgrade-plans | Long-tail wrapper for &#x60;Common_GetPremiumUpgradePlans&#x60;
*LongTailApi* | [**longTailGetReferralConstants**](docs/LongTailApi.md#longtailgetreferralconstants) | **POST** /v1/x/get-referral-constants | Long-tail wrapper for &#x60;Common_GetReferralConstants&#x60;
*LongTailApi* | [**longTailGetReferralSettings**](docs/LongTailApi.md#longtailgetreferralsettings) | **POST** /v1/x/get-referral-settings | Long-tail wrapper for &#x60;Common_GetReferralSettings&#x60;
*LongTailApi* | [**longTailGetReportsData**](docs/LongTailApi.md#longtailgetreportsdata) | **POST** /v1/x/get-reports-data | Long-tail wrapper for &#x60;Common_GetReportsData&#x60;
*LongTailApi* | [**longTailGetRetailExtensionSettings**](docs/LongTailApi.md#longtailgetretailextensionsettings) | **POST** /v1/x/get-retail-extension-settings | Long-tail wrapper for &#x60;Common_GetRetailExtensionSettings&#x60;
*LongTailApi* | [**longTailGetReviewedAccountLastStatements**](docs/LongTailApi.md#longtailgetreviewedaccountlaststatements) | **POST** /v1/x/get-reviewed-account-last-statements | Long-tail wrapper for &#x60;Common_GetReviewedAccountLastStatements&#x60;
*LongTailApi* | [**longTailGetReviewedMerchantLastTransactions**](docs/LongTailApi.md#longtailgetreviewedmerchantlasttransactions) | **POST** /v1/x/get-reviewed-merchant-last-transactions | Long-tail wrapper for &#x60;Common_GetReviewedMerchantLastTransactions&#x60;
*LongTailApi* | [**longTailGetSmartPrompts**](docs/LongTailApi.md#longtailgetsmartprompts) | **POST** /v1/x/get-smart-prompts | Long-tail wrapper for &#x60;Common_GetSmartPrompts&#x60;
*LongTailApi* | [**longTailGetSpinwheelCreditReport**](docs/LongTailApi.md#longtailgetspinwheelcreditreport) | **POST** /v1/x/get-spinwheel-credit-report | Long-tail wrapper for &#x60;Common_GetSpinwheelCreditReport&#x60;
*LongTailApi* | [**longTailGetSubscriptionHasEntitlementAfterSync**](docs/LongTailApi.md#longtailgetsubscriptionhasentitlementaftersync) | **POST** /v1/x/get-subscription-has-entitlement-after-sync | Long-tail wrapper for &#x60;Common_GetSubscriptionHasEntitlementAfterSync&#x60;
*LongTailApi* | [**longTailGetSubscriptionStatus**](docs/LongTailApi.md#longtailgetsubscriptionstatus) | **POST** /v1/x/get-subscription-status | Long-tail wrapper for &#x60;GetSubscriptionStatus&#x60;
*LongTailApi* | [**longTailGetTransactionFiltersCard**](docs/LongTailApi.md#longtailgettransactionfilterscard) | **POST** /v1/x/get-transaction-filters-card | Long-tail wrapper for &#x60;GetTransactionFiltersCard&#x60;
*LongTailApi* | [**longTailGetTransactions**](docs/LongTailApi.md#longtailgettransactions) | **POST** /v1/x/get-transactions | Long-tail wrapper for &#x60;GetTransactions&#x60;
*LongTailApi* | [**longTailGetTrialStatus**](docs/LongTailApi.md#longtailgettrialstatus) | **POST** /v1/x/get-trial-status | Long-tail wrapper for &#x60;GetTrialStatus&#x60;
*LongTailApi* | [**longTailGetUploadStatementSession**](docs/LongTailApi.md#longtailgetuploadstatementsession) | **POST** /v1/x/get-upload-statement-session | Long-tail wrapper for &#x60;GetUploadStatementSession&#x60;
*LongTailApi* | [**longTailGetUserReportedOnboardingAttributionChannels**](docs/LongTailApi.md#longtailgetuserreportedonboardingattributionchannels) | **POST** /v1/x/get-user-reported-onboarding-attribution-channels | Long-tail wrapper for &#x60;Common_GetUserReportedOnboardingAttributionChannels&#x60;
*LongTailApi* | [**longTailGetYearlyReviewStatus**](docs/LongTailApi.md#longtailgetyearlyreviewstatus) | **POST** /v1/x/get-yearly-review-status | Long-tail wrapper for &#x60;GetYearlyReviewStatus&#x60;
*LongTailApi* | [**longTailGoalAccountsForInitialContribution**](docs/LongTailApi.md#longtailgoalaccountsforinitialcontribution) | **POST** /v1/x/goal-accounts-for-initial-contribution | Long-tail wrapper for &#x60;Common_GoalAccountsForInitialContribution&#x60;
*LongTailApi* | [**longTailGoalOptions**](docs/LongTailApi.md#longtailgoaloptions) | **POST** /v1/x/goal-options | Long-tail wrapper for &#x60;Common_GoalOptions&#x60;
*LongTailApi* | [**longTailGoalReconciliationHistory**](docs/LongTailApi.md#longtailgoalreconciliationhistory) | **POST** /v1/x/goal-reconciliation-history | Long-tail wrapper for &#x60;Common_GoalReconciliationHistory&#x60;
*LongTailApi* | [**longTailGoalReconciliationTransactionInfo**](docs/LongTailApi.md#longtailgoalreconciliationtransactioninfo) | **POST** /v1/x/goal-reconciliation-transaction-info | Long-tail wrapper for &#x60;Common_GoalReconciliationTransactionInfo&#x60;
*LongTailApi* | [**longTailGoalSelectAccounts**](docs/LongTailApi.md#longtailgoalselectaccounts) | **POST** /v1/x/goal-select-accounts | Long-tail wrapper for &#x60;GoalSelectAccounts&#x60;
*LongTailApi* | [**longTailGoalsV2MigrationQuery**](docs/LongTailApi.md#longtailgoalsv2migrationquery) | **POST** /v1/x/goals-v2-migration-query | Long-tail wrapper for &#x60;Common_GoalsV2MigrationQuery&#x60;
*LongTailApi* | [**longTailHasActivity**](docs/LongTailApi.md#longtailhasactivity) | **POST** /v1/x/has-activity | Long-tail wrapper for &#x60;Common_HasActivity&#x60;
*LongTailApi* | [**longTailInitializeFlexBudget**](docs/LongTailApi.md#longtailinitializeflexbudget) | **POST** /v1/x/initialize-flex-budget | Long-tail wrapper for &#x60;Common_InitializeFlexBudget&#x60;
*LongTailApi* | [**longTailLegacyGoalsMigrationQuery**](docs/LongTailApi.md#longtaillegacygoalsmigrationquery) | **POST** /v1/x/legacy-goals-migration-query | Long-tail wrapper for &#x60;Common_LegacyGoalsMigrationQuery&#x60;
*LongTailApi* | [**longTailMarkRecurringLiabilityStatementAsPaid**](docs/LongTailApi.md#longtailmarkrecurringliabilitystatementaspaid) | **POST** /v1/x/mark-recurring-liability-statement-as-paid | Long-tail wrapper for &#x60;Common_MarkRecurringLiabilityStatementAsPaid&#x60;
*LongTailApi* | [**longTailMatchRetailTransaction**](docs/LongTailApi.md#longtailmatchretailtransaction) | **POST** /v1/x/match-retail-transaction | Long-tail wrapper for &#x60;Common_MatchRetailTransaction&#x60;
*LongTailApi* | [**longTailMigratedToSavingsGoals**](docs/LongTailApi.md#longtailmigratedtosavingsgoals) | **POST** /v1/x/migrated-to-savings-goals | Long-tail wrapper for &#x60;Common_MigratedToSavingsGoals&#x60;
*LongTailApi* | [**longTailMigratedToSavingsGoalsAt**](docs/LongTailApi.md#longtailmigratedtosavingsgoalsat) | **POST** /v1/x/migrated-to-savings-goals-at | Long-tail wrapper for &#x60;Common_MigratedToSavingsGoalsAt&#x60;
*LongTailApi* | [**longTailMoveMoneyScreenQuery**](docs/LongTailApi.md#longtailmovemoneyscreenquery) | **POST** /v1/x/move-money-screen-query | Long-tail wrapper for &#x60;MoveMoneyScreenQuery&#x60;
*LongTailApi* | [**longTailOldestDeletableTransactionDate**](docs/LongTailApi.md#longtailoldestdeletabletransactiondate) | **POST** /v1/x/oldest-deletable-transaction-date | Long-tail wrapper for &#x60;Common_OldestDeletableTransactionDate&#x60;
*LongTailApi* | [**longTailOnboardingChecklist**](docs/LongTailApi.md#longtailonboardingchecklist) | **POST** /v1/x/onboarding-checklist | Long-tail wrapper for &#x60;Common_OnboardingChecklist&#x60;
*LongTailApi* | [**longTailPreviewDeleteTransactions**](docs/LongTailApi.md#longtailpreviewdeletetransactions) | **POST** /v1/x/preview-delete-transactions | Long-tail wrapper for &#x60;Common_PreviewDeleteTransactions&#x60;
*LongTailApi* | [**longTailQuestionnaireIntroQuery**](docs/LongTailApi.md#longtailquestionnaireintroquery) | **POST** /v1/x/questionnaire-intro-query | Long-tail wrapper for &#x60;QuestionnaireIntroQuery_Web&#x60;
*LongTailApi* | [**longTailReconcileAccountGoalSpendingForTransactions**](docs/LongTailApi.md#longtailreconcileaccountgoalspendingfortransactions) | **POST** /v1/x/reconcile-account-goal-spending-for-transactions | Long-tail wrapper for &#x60;Common_ReconcileAccountGoalSpendingForTransactions&#x60;
*LongTailApi* | [**longTailReconcileExternalSpending**](docs/LongTailApi.md#longtailreconcileexternalspending) | **POST** /v1/x/reconcile-external-spending | Long-tail wrapper for &#x60;Common_ReconcileExternalSpending&#x60;
*LongTailApi* | [**longTailRecordBusinessEntitiesBannerImpression**](docs/LongTailApi.md#longtailrecordbusinessentitiesbannerimpression) | **POST** /v1/x/record-business-entities-banner-impression | Long-tail wrapper for &#x60;Common_RecordBusinessEntitiesBannerImpression&#x60;
*LongTailApi* | [**longTailRecordSmartPromptClick**](docs/LongTailApi.md#longtailrecordsmartpromptclick) | **POST** /v1/x/record-smart-prompt-click | Long-tail wrapper for &#x60;Common_RecordSmartPromptClick&#x60;
*LongTailApi* | [**longTailRecordSmartPromptImpressions**](docs/LongTailApi.md#longtailrecordsmartpromptimpressions) | **POST** /v1/x/record-smart-prompt-impressions | Long-tail wrapper for &#x60;Common_RecordSmartPromptImpressions&#x60;
*LongTailApi* | [**longTailRecurringMerchantSearch**](docs/LongTailApi.md#longtailrecurringmerchantsearch) | **POST** /v1/x/recurring-merchant-search | Long-tail wrapper for &#x60;RecurringMerchantSearch&#x60;
*LongTailApi* | [**longTailRecurringUpdateLiabilityStatement**](docs/LongTailApi.md#longtailrecurringupdateliabilitystatement) | **POST** /v1/x/recurring-update-liability-statement | Long-tail wrapper for &#x60;Common_RecurringUpdateLiabilityStatement&#x60;
*LongTailApi* | [**longTailRecurringUpdateMerchant**](docs/LongTailApi.md#longtailrecurringupdatemerchant) | **POST** /v1/x/recurring-update-merchant | Long-tail wrapper for &#x60;Common_RecurringUpdateMerchant&#x60;
*LongTailApi* | [**longTailRedeemTrustAndWill**](docs/LongTailApi.md#longtailredeemtrustandwill) | **POST** /v1/x/redeem-trust-and-will | Long-tail wrapper for &#x60;Common_RedeemTrustAndWill&#x60;
*LongTailApi* | [**longTailRequestInstitution**](docs/LongTailApi.md#longtailrequestinstitution) | **POST** /v1/x/request-institution | Long-tail wrapper for &#x60;Common_RequestInstitution&#x60;
*LongTailApi* | [**longTailResendInviteToHousehold**](docs/LongTailApi.md#longtailresendinvitetohousehold) | **POST** /v1/x/resend-invite-to-household | Long-tail wrapper for &#x60;Common_ResendInviteToHousehold&#x60;
*LongTailApi* | [**longTailResendReferralRewardEmail**](docs/LongTailApi.md#longtailresendreferralrewardemail) | **POST** /v1/x/resend-referral-reward-email | Long-tail wrapper for &#x60;Common_ResendReferralRewardEmail&#x60;
*LongTailApi* | [**longTailRetailSyncQuery**](docs/LongTailApi.md#longtailretailsyncquery) | **POST** /v1/x/retail-sync-query | Long-tail wrapper for &#x60;Common_RetailSyncQuery&#x60;
*LongTailApi* | [**longTailRetailSyncsQueryWithTotal**](docs/LongTailApi.md#longtailretailsyncsquerywithtotal) | **POST** /v1/x/retail-syncs-query-with-total | Long-tail wrapper for &#x60;Common_RetailSyncsQueryWithTotal&#x60;
*LongTailApi* | [**longTailReviewQuery**](docs/LongTailApi.md#longtailreviewquery) | **POST** /v1/x/review-query | Long-tail wrapper for &#x60;ReviewQuery&#x60;
*LongTailApi* | [**longTailReviewStream**](docs/LongTailApi.md#longtailreviewstream) | **POST** /v1/x/review-stream | Long-tail wrapper for &#x60;Common_ReviewStream&#x60;
*LongTailApi* | [**longTailRevokeHouseholdAccessGrant**](docs/LongTailApi.md#longtailrevokehouseholdaccessgrant) | **POST** /v1/x/revoke-household-access-grant | Long-tail wrapper for &#x60;Common_RevokeHouseholdAccessGrant&#x60;
*LongTailApi* | [**longTailRevokeInviteToHousehold**](docs/LongTailApi.md#longtailrevokeinvitetohousehold) | **POST** /v1/x/revoke-invite-to-household | Long-tail wrapper for &#x60;Common_RevokeInviteToHousehold&#x60;
*LongTailApi* | [**longTailSaveDebtPaydownProjectionToBudget**](docs/LongTailApi.md#longtailsavedebtpaydownprojectiontobudget) | **POST** /v1/x/save-debt-paydown-projection-to-budget | Long-tail wrapper for &#x60;Common_SaveDebtPaydownProjectionToBudget&#x60;
*LongTailApi* | [**longTailSavingsGoalAccount**](docs/LongTailApi.md#longtailsavingsgoalaccount) | **POST** /v1/x/savings-goal-account | Long-tail wrapper for &#x60;Common_SavingsGoalAccount&#x60;
*LongTailApi* | [**longTailSavingsGoalAccounts**](docs/LongTailApi.md#longtailsavingsgoalaccounts) | **POST** /v1/x/savings-goal-accounts | Long-tail wrapper for &#x60;Common_SavingsGoalAccounts&#x60;
*LongTailApi* | [**longTailSavingsGoalAccountsAllocationSummary**](docs/LongTailApi.md#longtailsavingsgoalaccountsallocationsummary) | **POST** /v1/x/savings-goal-accounts-allocation-summary | Long-tail wrapper for &#x60;Common_SavingsGoalAccountsAllocationSummary&#x60;
*LongTailApi* | [**longTailSavingsGoalBudgetAmounts**](docs/LongTailApi.md#longtailsavingsgoalbudgetamounts) | **POST** /v1/x/savings-goal-budget-amounts | Long-tail wrapper for &#x60;Common_SavingsGoalBudgetAmounts&#x60;
*LongTailApi* | [**longTailSavingsGoalBudgetAmountsWithRecommendation**](docs/LongTailApi.md#longtailsavingsgoalbudgetamountswithrecommendation) | **POST** /v1/x/savings-goal-budget-amounts-with-recommendation | Long-tail wrapper for &#x60;Common_SavingsGoalBudgetAmountsWithRecommendation&#x60;
*LongTailApi* | [**longTailSavingsGoalEditAccounts**](docs/LongTailApi.md#longtailsavingsgoaleditaccounts) | **POST** /v1/x/savings-goal-edit-accounts | Long-tail wrapper for &#x60;Common_SavingsGoalEditAccounts&#x60;
*LongTailApi* | [**longTailSavingsGoalMigrationStatus**](docs/LongTailApi.md#longtailsavingsgoalmigrationstatus) | **POST** /v1/x/savings-goal-migration-status | Long-tail wrapper for &#x60;Common_SavingsGoalMigrationStatus&#x60;
*LongTailApi* | [**longTailSavingsGoalReconciliationAccount**](docs/LongTailApi.md#longtailsavingsgoalreconciliationaccount) | **POST** /v1/x/savings-goal-reconciliation-account | Long-tail wrapper for &#x60;Common_SavingsGoalReconciliationAccount&#x60;
*LongTailApi* | [**longTailSavingsGoalsAllocationAmountsByAccount**](docs/LongTailApi.md#longtailsavingsgoalsallocationamountsbyaccount) | **POST** /v1/x/savings-goals-allocation-amounts-by-account | Long-tail wrapper for &#x60;Common_SavingsGoalsAllocationAmountsByAccount&#x60;
*LongTailApi* | [**longTailSavingsGoalsPrioritizeList**](docs/LongTailApi.md#longtailsavingsgoalsprioritizelist) | **POST** /v1/x/savings-goals-prioritize-list | Long-tail wrapper for &#x60;Common_SavingsGoalsPrioritizeList&#x60;
*LongTailApi* | [**longTailSavingsGoalsTypes**](docs/LongTailApi.md#longtailsavingsgoalstypes) | **POST** /v1/x/savings-goals-types | Long-tail wrapper for &#x60;Common_SavingsGoalsTypes&#x60;
*LongTailApi* | [**longTailSavingsGoalsWithThisMonthBalances**](docs/LongTailApi.md#longtailsavingsgoalswiththismonthbalances) | **POST** /v1/x/savings-goals-with-this-month-balances | Long-tail wrapper for &#x60;Common_SavingsGoalsWithThisMonthBalances&#x60;
*LongTailApi* | [**longTailSelectBudgetCategoryScreenQuery**](docs/LongTailApi.md#longtailselectbudgetcategoryscreenquery) | **POST** /v1/x/select-budget-category-screen-query | Long-tail wrapper for &#x60;SelectBudgetCategoryScreenQuery&#x60;
*LongTailApi* | [**longTailSendMessage**](docs/LongTailApi.md#longtailsendmessage) | **POST** /v1/x/send-message | Long-tail wrapper for &#x60;Common_SendMessage&#x60;
*LongTailApi* | [**longTailSetAccountLogo**](docs/LongTailApi.md#longtailsetaccountlogo) | **POST** /v1/x/set-account-logo | Long-tail wrapper for &#x60;Common_SetAccountLogo&#x60;
*LongTailApi* | [**longTailSetDebtPaydownBudgetAmount**](docs/LongTailApi.md#longtailsetdebtpaydownbudgetamount) | **POST** /v1/x/set-debt-paydown-budget-amount | Long-tail wrapper for &#x60;Common_SetDebtPaydownBudgetAmount&#x60;
*LongTailApi* | [**longTailSetFinancialInsightsEnabled**](docs/LongTailApi.md#longtailsetfinancialinsightsenabled) | **POST** /v1/x/set-financial-insights-enabled | Long-tail wrapper for &#x60;Common_SetFinancialInsightsEnabled&#x60;
*LongTailApi* | [**longTailSetHasDismissedYearlyReview**](docs/LongTailApi.md#longtailsethasdismissedyearlyreview) | **POST** /v1/x/set-has-dismissed-yearly-review | Long-tail wrapper for &#x60;Common_SetHasDismissedYearlyReview&#x60;
*LongTailApi* | [**longTailSetHasSkippedPremiumUpsell**](docs/LongTailApi.md#longtailsethasskippedpremiumupsell) | **POST** /v1/x/set-has-skipped-premium-upsell | Long-tail wrapper for &#x60;Common_SetHasSkippedPremiumUpsell&#x60;
*LongTailApi* | [**longTailSetOnboardingCompleted**](docs/LongTailApi.md#longtailsetonboardingcompleted) | **POST** /v1/x/set-onboarding-completed | Long-tail wrapper for &#x60;Common_SetOnboardingCompleted&#x60;
*LongTailApi* | [**longTailSetUserOnboardingFinancialGoals**](docs/LongTailApi.md#longtailsetuseronboardingfinancialgoals) | **POST** /v1/x/set-user-onboarding-financial-goals | Long-tail wrapper for &#x60;Common_SetUserOnboardingFinancialGoals&#x60;
*LongTailApi* | [**longTailSetUserProfilePicture**](docs/LongTailApi.md#longtailsetuserprofilepicture) | **POST** /v1/x/set-user-profile-picture | Long-tail wrapper for &#x60;Common_SetUserProfilePicture&#x60;
*LongTailApi* | [**longTailSetUserReportedAttributionChannels**](docs/LongTailApi.md#longtailsetuserreportedattributionchannels) | **POST** /v1/x/set-user-reported-attribution-channels | Long-tail wrapper for &#x60;Common_SetUserReportedAttributionChannels&#x60;
*LongTailApi* | [**longTailStartRetailSync**](docs/LongTailApi.md#longtailstartretailsync) | **POST** /v1/x/start-retail-sync | Long-tail wrapper for &#x60;Common_StartRetailSync&#x60;
*LongTailApi* | [**longTailStartSavingsGoalsMigration**](docs/LongTailApi.md#longtailstartsavingsgoalsmigration) | **POST** /v1/x/start-savings-goals-migration | Long-tail wrapper for &#x60;Common_StartSavingsGoalsMigration&#x60;
*LongTailApi* | [**longTailSubmitAssistantFeedback**](docs/LongTailApi.md#longtailsubmitassistantfeedback) | **POST** /v1/x/submit-assistant-feedback | Long-tail wrapper for &#x60;Common_SubmitAssistantFeedback&#x60;
*LongTailApi* | [**longTailSyncCredentialAfterReconnect**](docs/LongTailApi.md#longtailsynccredentialafterreconnect) | **POST** /v1/x/sync-credential-after-reconnect | Long-tail wrapper for &#x60;Common_SyncCredentialAfterReconnect&#x60;
*LongTailApi* | [**longTailToggleCreditScoreTracking**](docs/LongTailApi.md#longtailtogglecreditscoretracking) | **POST** /v1/x/toggle-credit-score-tracking | Long-tail wrapper for &#x60;Common_ToggleCreditScoreTracking&#x60;
*LongTailApi* | [**longTailTopInstitutionsQuery**](docs/LongTailApi.md#longtailtopinstitutionsquery) | **POST** /v1/x/top-institutions-query | Long-tail wrapper for &#x60;TopInstitutionsQuery&#x60;
*LongTailApi* | [**longTailTransferAccountDataAsync**](docs/LongTailApi.md#longtailtransferaccountdataasync) | **POST** /v1/x/transfer-account-data-async | Long-tail wrapper for &#x60;Common_TransferAccountDataAsync&#x60;
*LongTailApi* | [**longTailTriggerRecurringMerchantSearch**](docs/LongTailApi.md#longtailtriggerrecurringmerchantsearch) | **POST** /v1/x/trigger-recurring-merchant-search | Long-tail wrapper for &#x60;Common_TriggerRecurringMerchantSearch&#x60;
*LongTailApi* | [**longTailUnarchiveGoal**](docs/LongTailApi.md#longtailunarchivegoal) | **POST** /v1/x/unarchive-goal | Long-tail wrapper for &#x60;Common_UnarchiveGoal&#x60;
*LongTailApi* | [**longTailUndeleteAccount**](docs/LongTailApi.md#longtailundeleteaccount) | **POST** /v1/x/undelete-account | Long-tail wrapper for &#x60;Common_UndeleteAccount&#x60;
*LongTailApi* | [**longTailUnreconciledSpendingEvents**](docs/LongTailApi.md#longtailunreconciledspendingevents) | **POST** /v1/x/unreconciled-spending-events | Long-tail wrapper for &#x60;Common_UnreconciledSpendingEvents&#x60;
*LongTailApi* | [**longTailUpdateAccountsForEditingEntities**](docs/LongTailApi.md#longtailupdateaccountsforeditingentities) | **POST** /v1/x/update-accounts-for-editing-entities | Long-tail wrapper for &#x60;Common_UpdateAccountsForEditingEntities&#x60;
*LongTailApi* | [**longTailUpdateAccountsForEditingOwnership**](docs/LongTailApi.md#longtailupdateaccountsforeditingownership) | **POST** /v1/x/update-accounts-for-editing-ownership | Long-tail wrapper for &#x60;Common_UpdateAccountsForEditingOwnership&#x60;
*LongTailApi* | [**longTailUpdateAllNotificationPreferencesForPlatform**](docs/LongTailApi.md#longtailupdateallnotificationpreferencesforplatform) | **POST** /v1/x/update-all-notification-preferences-for-platform | Long-tail wrapper for &#x60;Common_UpdateAllNotificationPreferencesForPlatform&#x60;
*LongTailApi* | [**longTailUpdateCategoryBudgetVariability**](docs/LongTailApi.md#longtailupdatecategorybudgetvariability) | **POST** /v1/x/update-category-budget-variability | Long-tail wrapper for &#x60;Common_UpdateCategoryBudgetVariability&#x60;
*LongTailApi* | [**longTailUpdateCategoryExcludeFromBudget**](docs/LongTailApi.md#longtailupdatecategoryexcludefrombudget) | **POST** /v1/x/update-category-exclude-from-budget | Long-tail wrapper for &#x60;Common_UpdateCategoryExcludeFromBudget&#x60;
*LongTailApi* | [**longTailUpdateCredential**](docs/LongTailApi.md#longtailupdatecredential) | **POST** /v1/x/update-credential | Long-tail wrapper for &#x60;Common_UpdateCredential&#x60;
*LongTailApi* | [**longTailUpdateDashboardConfig**](docs/LongTailApi.md#longtailupdatedashboardconfig) | **POST** /v1/x/update-dashboard-config | Long-tail wrapper for &#x60;Common_UpdateDashboardConfig&#x60;
*LongTailApi* | [**longTailUpdateDoNotSellOrShare**](docs/LongTailApi.md#longtailupdatedonotsellorshare) | **POST** /v1/x/update-do-not-sell-or-share | Long-tail wrapper for &#x60;Common_UpdateDoNotSellOrShare&#x60;
*LongTailApi* | [**longTailUpdateFinancialInsightStatus**](docs/LongTailApi.md#longtailupdatefinancialinsightstatus) | **POST** /v1/x/update-financial-insight-status | Long-tail wrapper for &#x60;Common_UpdateFinancialInsightStatus&#x60;
*LongTailApi* | [**longTailUpdateGoalAccountAllocation**](docs/LongTailApi.md#longtailupdategoalaccountallocation) | **POST** /v1/x/update-goal-account-allocation | Long-tail wrapper for &#x60;Common_UpdateGoalAccountAllocation&#x60;
*LongTailApi* | [**longTailUpdateMyHousehold**](docs/LongTailApi.md#longtailupdatemyhousehold) | **POST** /v1/x/update-my-household | Long-tail wrapper for &#x60;Common_UpdateMyHousehold&#x60;
*LongTailApi* | [**longTailUpdateRetailOrder**](docs/LongTailApi.md#longtailupdateretailorder) | **POST** /v1/x/update-retail-order | Long-tail wrapper for &#x60;Common_UpdateRetailOrder&#x60;
*LongTailApi* | [**longTailUpdateRetailVendorSettings**](docs/LongTailApi.md#longtailupdateretailvendorsettings) | **POST** /v1/x/update-retail-vendor-settings | Long-tail wrapper for &#x60;Common_UpdateRetailVendorSettings&#x60;
*LongTailApi* | [**longTailUpdateSavingsGoalAccountIncludeInGoalContributions**](docs/LongTailApi.md#longtailupdatesavingsgoalaccountincludeingoalcontributions) | **POST** /v1/x/update-savings-goal-account-include-in-goal-contributions | Long-tail wrapper for &#x60;Common_UpdateSavingsGoalAccountIncludeInGoalContributions&#x60;
*LongTailApi* | [**longTailUpdateSavingsGoalAccountLink**](docs/LongTailApi.md#longtailupdatesavingsgoalaccountlink) | **POST** /v1/x/update-savings-goal-account-link | Long-tail wrapper for &#x60;Common_UpdateSavingsGoalAccountLink&#x60;
*LongTailApi* | [**longTailUpdateSavingsGoalEvent**](docs/LongTailApi.md#longtailupdatesavingsgoalevent) | **POST** /v1/x/update-savings-goal-event | Long-tail wrapper for &#x60;Common_UpdateSavingsGoalEvent&#x60;
*LongTailApi* | [**longTailUpdateSponsorshipInvite**](docs/LongTailApi.md#longtailupdatesponsorshipinvite) | **POST** /v1/x/update-sponsorship-invite | Long-tail wrapper for &#x60;Common_UpdateSponsorshipInvite&#x60;
*LongTailApi* | [**longTailUpdateTransaction**](docs/LongTailApi.md#longtailupdatetransaction) | **POST** /v1/x/update-transaction | Long-tail wrapper for &#x60;Common_UpdateTransaction&#x60;
*LongTailApi* | [**longTailUpdateTransactionTag**](docs/LongTailApi.md#longtailupdatetransactiontag) | **POST** /v1/x/update-transaction-tag | Long-tail wrapper for &#x60;Common_UpdateTransactionTag&#x60;
*LongTailApi* | [**longTailUpdateTransactionTagOrder**](docs/LongTailApi.md#longtailupdatetransactiontagorder) | **POST** /v1/x/update-transaction-tag-order | Long-tail wrapper for &#x60;Common_UpdateTransactionTagOrder&#x60;
*LongTailApi* | [**longTailUpdateUserProfile**](docs/LongTailApi.md#longtailupdateuserprofile) | **POST** /v1/x/update-user-profile | Long-tail wrapper for &#x60;Common_UpdateUserProfile&#x60;
*LongTailApi* | [**longTailUpdateUserProfileFlags**](docs/LongTailApi.md#longtailupdateuserprofileflags) | **POST** /v1/x/update-user-profile-flags | Long-tail wrapper for &#x60;Common_UpdateUserProfileFlags&#x60;
*LongTailApi* | [**longTailUserDevicesUsage**](docs/LongTailApi.md#longtailuserdevicesusage) | **POST** /v1/x/user-devices-usage | Long-tail wrapper for &#x60;Common_UserDevicesUsage&#x60;
*LongTailApi* | [**longTailUserProfileFlags**](docs/LongTailApi.md#longtailuserprofileflags) | **POST** /v1/x/user-profile-flags | Long-tail wrapper for &#x60;Common_UserProfileFlags&#x60;
*LongTailApi* | [**longTailVehiclesSearch**](docs/LongTailApi.md#longtailvehiclessearch) | **POST** /v1/x/vehicles-search | Long-tail wrapper for &#x60;VehiclesSearch&#x60;
*LongTailApi* | [**longTailWithdrawAllGoalContributionsFromAccount**](docs/LongTailApi.md#longtailwithdrawallgoalcontributionsfromaccount) | **POST** /v1/x/withdraw-all-goal-contributions-from-account | Long-tail wrapper for &#x60;Common_WithdrawAllGoalContributionsFromAccount&#x60;
*MerchantsApi* | [**deleteMerchant**](docs/MerchantsApi.md#deletemerchant) | **DELETE** /v1/merchants/{id} | Delete a merchant
*MerchantsApi* | [**getMerchant**](docs/MerchantsApi.md#getmerchant) | **GET** /v1/merchants/{id} | Get full detail for one merchant
*MerchantsApi* | [**getMerchantStats**](docs/MerchantsApi.md#getmerchantstats) | **GET** /v1/merchants/{id}/stats | Per-merchant aggregate stats
*MerchantsApi* | [**getMerchantTransactions**](docs/MerchantsApi.md#getmerchanttransactions) | **GET** /v1/merchants/{id}/transactions | Transactions for one merchant
*MerchantsApi* | [**searchMerchants**](docs/MerchantsApi.md#searchmerchants) | **GET** /v1/merchants/search | Search merchants by name
*MerchantsApi* | [**setMerchantLogo**](docs/MerchantsApi.md#setmerchantlogo) | **PATCH** /v1/merchants/{id}/logo | Set a merchant\&#39;s logo
*MobileScreensApi* | [**mobileAccountsMessageBlock**](docs/MobileScreensApi.md#mobileaccountsmessageblock) | **GET** /v1/mobile/accounts-message-block | Mobile screen aggregate &#x60;Mobile_AccountsMessageBlock&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileAddCategoryGroupMutation**](docs/MobileScreensApi.md#mobileaddcategorygroupmutation) | **GET** /v1/mobile/add-category-group-mutation | Mobile screen aggregate &#x60;Mobile_AddCategoryGroupMutation&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileCategoryDetailQuery**](docs/MobileScreensApi.md#mobilecategorydetailquery) | **GET** /v1/mobile/category-detail-query | Mobile screen aggregate &#x60;Mobile_CategoryDetailQuery&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileCategoryGroupDetailChartQuery**](docs/MobileScreensApi.md#mobilecategorygroupdetailchartquery) | **GET** /v1/mobile/category-group-detail-chart-query | Mobile screen aggregate &#x60;Mobile_CategoryGroupDetailChartQuery&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileCategoryGroupDetailContainerQuery**](docs/MobileScreensApi.md#mobilecategorygroupdetailcontainerquery) | **GET** /v1/mobile/category-group-detail-container-query | Mobile screen aggregate &#x60;Mobile_CategoryGroupDetailContainerQuery&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileCategoryRecommendationForTransaction**](docs/MobileScreensApi.md#mobilecategoryrecommendationfortransaction) | **GET** /v1/mobile/category-recommendation-for-transaction | Mobile screen aggregate &#x60;Mobile_CategoryRecommendationForTransaction&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileCreateAppleCardAccount**](docs/MobileScreensApi.md#mobilecreateapplecardaccount) | **GET** /v1/mobile/create-apple-card-account | Mobile screen aggregate &#x60;Mobile_CreateAppleCardAccount&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileCreateCoinbaseAccount**](docs/MobileScreensApi.md#mobilecreatecoinbaseaccount) | **GET** /v1/mobile/create-coinbase-account | Mobile screen aggregate &#x60;Mobile_CreateCoinbaseAccount&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileCreateEditRuleSettings**](docs/MobileScreensApi.md#mobilecreateeditrulesettings) | **GET** /v1/mobile/create-edit-rule-settings | Mobile screen aggregate &#x60;Mobile_CreateEditRuleSettings&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileCreateHouseholdAccessGrant**](docs/MobileScreensApi.md#mobilecreatehouseholdaccessgrant) | **GET** /v1/mobile/create-household-access-grant | Mobile screen aggregate &#x60;Mobile_CreateHouseholdAccessGrant&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileCreateReviewCheckinMutation**](docs/MobileScreensApi.md#mobilecreatereviewcheckinmutation) | **GET** /v1/mobile/create-review-checkin-mutation | Mobile screen aggregate &#x60;Mobile_CreateReviewCheckinMutation&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileCreateSyncedVehicleAccount**](docs/MobileScreensApi.md#mobilecreatesyncedvehicleaccount) | **GET** /v1/mobile/create-synced-vehicle-account | Mobile screen aggregate &#x60;Mobile_CreateSyncedVehicleAccount&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileCreateZillowAccount**](docs/MobileScreensApi.md#mobilecreatezillowaccount) | **GET** /v1/mobile/create-zillow-account | Mobile screen aggregate &#x60;Mobile_CreateZillowAccount&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileCustomizeGoalScreen**](docs/MobileScreensApi.md#mobilecustomizegoalscreen) | **GET** /v1/mobile/customize-goal-screen | Mobile screen aggregate &#x60;Mobile_CustomizeGoalScreen&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileDebugGetFinancialInsightIds**](docs/MobileScreensApi.md#mobiledebuggetfinancialinsightids) | **GET** /v1/mobile/debug-get-financial-insight-ids | Mobile screen aggregate &#x60;Mobile_DebugGetFinancialInsightIds&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileDebugSoftDeleteFinancialInsight**](docs/MobileScreensApi.md#mobiledebugsoftdeletefinancialinsight) | **GET** /v1/mobile/debug-soft-delete-financial-insight | Mobile screen aggregate &#x60;Mobile_DebugSoftDeleteFinancialInsight&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileDeleteAccountLogo**](docs/MobileScreensApi.md#mobiledeleteaccountlogo) | **GET** /v1/mobile/delete-account-logo | Mobile screen aggregate &#x60;Mobile_DeleteAccountLogo&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileDeleteAttachment**](docs/MobileScreensApi.md#mobiledeleteattachment) | **GET** /v1/mobile/delete-attachment | Mobile screen aggregate &#x60;Mobile_DeleteAttachment&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileDeleteUserFromHousehold**](docs/MobileScreensApi.md#mobiledeleteuserfromhousehold) | **GET** /v1/mobile/delete-user-from-household | Mobile screen aggregate &#x60;Mobile_DeleteUserFromHousehold&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileDeleteUserProfilePicture**](docs/MobileScreensApi.md#mobiledeleteuserprofilepicture) | **GET** /v1/mobile/delete-user-profile-picture | Mobile screen aggregate &#x60;Mobile_DeleteUserProfilePicture&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileDidRequestReviewMutation**](docs/MobileScreensApi.md#mobiledidrequestreviewmutation) | **GET** /v1/mobile/did-request-review-mutation | Mobile screen aggregate &#x60;Mobile_DidRequestReviewMutation&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileDirectLinkInstitutionModal**](docs/MobileScreensApi.md#mobiledirectlinkinstitutionmodal) | **GET** /v1/mobile/direct-link-institution-modal | Mobile screen aggregate &#x60;Mobile_DirectLinkInstitutionModal&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileDrawerMenu**](docs/MobileScreensApi.md#mobiledrawermenu) | **GET** /v1/mobile/drawer-menu | Mobile screen aggregate &#x60;Mobile_DrawerMenu&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileGetAccount**](docs/MobileScreensApi.md#mobilegetaccount) | **GET** /v1/mobile/get-account | Mobile screen aggregate &#x60;Mobile_GetAccount&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileGetAccountDetailScreen**](docs/MobileScreensApi.md#mobilegetaccountdetailscreen) | **GET** /v1/mobile/get-account-detail-screen | Mobile screen aggregate &#x60;Mobile_GetAccountDetailScreen&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileGetAccountOptions**](docs/MobileScreensApi.md#mobilegetaccountoptions) | **GET** /v1/mobile/get-account-options | Mobile screen aggregate &#x60;Mobile_GetAccountOptions&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileGetAccountsListBlock**](docs/MobileScreensApi.md#mobilegetaccountslistblock) | **GET** /v1/mobile/get-accounts-list-block | Mobile screen aggregate &#x60;Mobile_GetAccountsListBlock&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileGetAddTransactionScreen**](docs/MobileScreensApi.md#mobilegetaddtransactionscreen) | **GET** /v1/mobile/get-add-transaction-screen | Mobile screen aggregate &#x60;Mobile_GetAddTransactionScreen&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileGetCategoryDeletionInfo**](docs/MobileScreensApi.md#mobilegetcategorydeletioninfo) | **GET** /v1/mobile/get-category-deletion-info | Mobile screen aggregate &#x60;Mobile_GetCategoryDeletionInfo&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileGetCategoryGroupsWithCategories**](docs/MobileScreensApi.md#mobilegetcategorygroupswithcategories) | **GET** /v1/mobile/get-category-groups-with-categories | Mobile screen aggregate &#x60;Mobile_GetCategoryGroupsWithCategories&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileGetDuplicateCredentials**](docs/MobileScreensApi.md#mobilegetduplicatecredentials) | **GET** /v1/mobile/get-duplicate-credentials | Mobile screen aggregate &#x60;Mobile_GetDuplicateCredentials&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileGetEditAccountScreen**](docs/MobileScreensApi.md#mobilegeteditaccountscreen) | **GET** /v1/mobile/get-edit-account-screen | Mobile screen aggregate &#x60;Mobile_GetEditAccountScreen&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileGetEventPopoverTransactions**](docs/MobileScreensApi.md#mobilegeteventpopovertransactions) | **GET** /v1/mobile/get-event-popover-transactions | Mobile screen aggregate &#x60;Mobile_GetEventPopoverTransactions&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileGetInvestmentsAccounts**](docs/MobileScreensApi.md#mobilegetinvestmentsaccounts) | **GET** /v1/mobile/get-investments-accounts | Mobile screen aggregate &#x60;Mobile_GetInvestmentsAccounts&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileGetInvestmentsDashboardCard**](docs/MobileScreensApi.md#mobilegetinvestmentsdashboardcard) | **GET** /v1/mobile/get-investments-dashboard-card | Mobile screen aggregate &#x60;Mobile_GetInvestmentsDashboardCard&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileGetInvestmentsHoldingsList**](docs/MobileScreensApi.md#mobilegetinvestmentsholdingslist) | **GET** /v1/mobile/get-investments-holdings-list | Mobile screen aggregate &#x60;Mobile_GetInvestmentsHoldingsList&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileGetInvestmentsPortfolio**](docs/MobileScreensApi.md#mobilegetinvestmentsportfolio) | **GET** /v1/mobile/get-investments-portfolio | Mobile screen aggregate &#x60;Mobile_GetInvestmentsPortfolio&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileGetInvestmentsWidgetData**](docs/MobileScreensApi.md#mobilegetinvestmentswidgetdata) | **GET** /v1/mobile/get-investments-widget-data | Mobile screen aggregate &#x60;Mobile_GetInvestmentsWidgetData&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileGetMerchantsListScreen**](docs/MobileScreensApi.md#mobilegetmerchantslistscreen) | **GET** /v1/mobile/get-merchants-list-screen | Mobile screen aggregate &#x60;Mobile_GetMerchantsListScreen&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileGetPastSplits**](docs/MobileScreensApi.md#mobilegetpastsplits) | **GET** /v1/mobile/get-past-splits | Mobile screen aggregate &#x60;Mobile_GetPastSplits&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileGetPortfolioBenchmarks**](docs/MobileScreensApi.md#mobilegetportfoliobenchmarks) | **GET** /v1/mobile/get-portfolio-benchmarks | Mobile screen aggregate &#x60;Mobile_GetPortfolioBenchmarks&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileGetSecuritiesHistoricalChart**](docs/MobileScreensApi.md#mobilegetsecuritieshistoricalchart) | **GET** /v1/mobile/get-securities-historical-chart | Mobile screen aggregate &#x60;Mobile_GetSecuritiesHistoricalChart&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileGetSecuritiesHistoricalPerformance**](docs/MobileScreensApi.md#mobilegetsecuritieshistoricalperformance) | **GET** /v1/mobile/get-securities-historical-performance | Mobile screen aggregate &#x60;Mobile_GetSecuritiesHistoricalPerformance&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileGetSelectCategoryScreen**](docs/MobileScreensApi.md#mobilegetselectcategoryscreen) | **GET** /v1/mobile/get-select-category-screen | Mobile screen aggregate &#x60;Mobile_GetSelectCategoryScreen&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileGetSelectMerchantScreenHouseholdMerchants**](docs/MobileScreensApi.md#mobilegetselectmerchantscreenhouseholdmerchants) | **GET** /v1/mobile/get-select-merchant-screen-household-merchants | Mobile screen aggregate &#x60;Mobile_GetSelectMerchantScreenHouseholdMerchants&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileGetSelectMerchantScreenRecommendedMerchants**](docs/MobileScreensApi.md#mobilegetselectmerchantscreenrecommendedmerchants) | **GET** /v1/mobile/get-select-merchant-screen-recommended-merchants | Mobile screen aggregate &#x60;Mobile_GetSelectMerchantScreenRecommendedMerchants&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileGetSelectMerchantScreenTransactionDetails**](docs/MobileScreensApi.md#mobilegetselectmerchantscreentransactiondetails) | **GET** /v1/mobile/get-select-merchant-screen-transaction-details | Mobile screen aggregate &#x60;Mobile_GetSelectMerchantScreenTransactionDetails&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileGetTransactionDetailScreen**](docs/MobileScreensApi.md#mobilegettransactiondetailscreen) | **GET** /v1/mobile/get-transaction-detail-screen | Mobile screen aggregate &#x60;Mobile_GetTransactionDetailScreen&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileGetTransactionsAndCategoriesForWidget**](docs/MobileScreensApi.md#mobilegettransactionsandcategoriesforwidget) | **GET** /v1/mobile/get-transactions-and-categories-for-widget | Mobile screen aggregate &#x60;Mobile_GetTransactionsAndCategoriesForWidget&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileGoalDetailScreenV2**](docs/MobileScreensApi.md#mobilegoaldetailscreenv2) | **GET** /v1/mobile/goal-detail-screen-v2 | Mobile screen aggregate &#x60;Mobile_GoalDetailScreenV2&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileGoalSelectGoals**](docs/MobileScreensApi.md#mobilegoalselectgoals) | **GET** /v1/mobile/goal-select-goals | Mobile screen aggregate &#x60;Mobile_GoalSelectGoals&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileGoalsAllocateBalanceScreen**](docs/MobileScreensApi.md#mobilegoalsallocatebalancescreen) | **GET** /v1/mobile/goals-allocate-balance-screen | Mobile screen aggregate &#x60;Mobile_GoalsAllocateBalanceScreen&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileGoalsDashboardCardV2**](docs/MobileScreensApi.md#mobilegoalsdashboardcardv2) | **GET** /v1/mobile/goals-dashboard-card-v2 | Mobile screen aggregate &#x60;Mobile_GoalsDashboardCardV2&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileGoalsMapAccountsScreen**](docs/MobileScreensApi.md#mobilegoalsmapaccountsscreen) | **GET** /v1/mobile/goals-map-accounts-screen | Mobile screen aggregate &#x60;Mobile_GoalsMapAccountsScreen&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileGoalsMessageBlock**](docs/MobileScreensApi.md#mobilegoalsmessageblock) | **GET** /v1/mobile/goals-message-block | Mobile screen aggregate &#x60;Mobile_GoalsMessageBlock&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileGoalsMonthlyBudgetsScreen**](docs/MobileScreensApi.md#mobilegoalsmonthlybudgetsscreen) | **GET** /v1/mobile/goals-monthly-budgets-screen | Mobile screen aggregate &#x60;Mobile_GoalsMonthlyBudgetsScreen&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileGoalsPreTaxBudgetsScreen**](docs/MobileScreensApi.md#mobilegoalspretaxbudgetsscreen) | **GET** /v1/mobile/goals-pre-tax-budgets-screen | Mobile screen aggregate &#x60;Mobile_GoalsPreTaxBudgetsScreen&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileGoalsScreenV2**](docs/MobileScreensApi.md#mobilegoalsscreenv2) | **GET** /v1/mobile/goals-screen-v2 | Mobile screen aggregate &#x60;Mobile_GoalsScreenV2&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileGoalsTargetAmountsScreen**](docs/MobileScreensApi.md#mobilegoalstargetamountsscreen) | **GET** /v1/mobile/goals-target-amounts-screen | Mobile screen aggregate &#x60;Mobile_GoalsTargetAmountsScreen&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileInitialPermissionRequestModal**](docs/MobileScreensApi.md#mobileinitialpermissionrequestmodal) | **GET** /v1/mobile/initial-permission-request-modal | Mobile screen aggregate &#x60;Mobile_InitialPermissionRequestModal&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileInviteEmail**](docs/MobileScreensApi.md#mobileinviteemail) | **GET** /v1/mobile/invite-email | Mobile screen aggregate &#x60;Mobile_InviteEmail&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileInvitePartner**](docs/MobileScreensApi.md#mobileinvitepartner) | **GET** /v1/mobile/invite-partner | Mobile screen aggregate &#x60;Mobile_InvitePartner&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileLinkGoalOptions**](docs/MobileScreensApi.md#mobilelinkgoaloptions) | **GET** /v1/mobile/link-goal-options | Mobile screen aggregate &#x60;Mobile_LinkGoalOptions&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileLinkSearchInstitutionsQuery**](docs/MobileScreensApi.md#mobilelinksearchinstitutionsquery) | **GET** /v1/mobile/link-search-institutions-query | Mobile screen aggregate &#x60;Mobile_LinkSearchInstitutionsQuery&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileMerchantChartQuery**](docs/MobileScreensApi.md#mobilemerchantchartquery) | **GET** /v1/mobile/merchant-chart-query | Mobile screen aggregate &#x60;Mobile_MerchantChartQuery&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileMerchantDetailContainerQuery**](docs/MobileScreensApi.md#mobilemerchantdetailcontainerquery) | **GET** /v1/mobile/merchant-detail-container-query | Mobile screen aggregate &#x60;Mobile_MerchantDetailContainerQuery&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileMoveMoneyScreenMutation**](docs/MobileScreensApi.md#mobilemovemoneyscreenmutation) | **GET** /v1/mobile/move-money-screen-mutation | Mobile screen aggregate &#x60;Mobile_MoveMoneyScreenMutation&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileNetWorthChartOverlyQuery**](docs/MobileScreensApi.md#mobilenetworthchartoverlyquery) | **GET** /v1/mobile/net-worth-chart-overly-query | Mobile screen aggregate &#x60;Mobile_NetWorthChartOverlyQuery&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileOldestDeletableSyncedSnapshotDate**](docs/MobileScreensApi.md#mobileoldestdeletablesyncedsnapshotdate) | **GET** /v1/mobile/oldest-deletable-synced-snapshot-date | Mobile screen aggregate &#x60;Mobile_OldestDeletableSyncedSnapshotDate&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobilePreviewDeleteSyncedSnapshots**](docs/MobileScreensApi.md#mobilepreviewdeletesyncedsnapshots) | **GET** /v1/mobile/preview-delete-synced-snapshots | Mobile screen aggregate &#x60;Mobile_PreviewDeleteSyncedSnapshots&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileRankGoalsScreen**](docs/MobileScreensApi.md#mobilerankgoalsscreen) | **GET** /v1/mobile/rank-goals-screen | Mobile screen aggregate &#x60;Mobile_RankGoalsScreen&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileRapidTransactionReviewFormContainer**](docs/MobileScreensApi.md#mobilerapidtransactionreviewformcontainer) | **GET** /v1/mobile/rapid-transaction-review-form-container | Mobile screen aggregate &#x60;Mobile_RapidTransactionReviewFormContainer&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileRapidTransactionReviewScreen**](docs/MobileScreensApi.md#mobilerapidtransactionreviewscreen) | **GET** /v1/mobile/rapid-transaction-review-screen | Mobile screen aggregate &#x60;Mobile_RapidTransactionReviewScreen&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileResetHouseholdRecurringMerchantSearch**](docs/MobileScreensApi.md#mobileresethouseholdrecurringmerchantsearch) | **GET** /v1/mobile/reset-household-recurring-merchant-search | Mobile screen aggregate &#x60;Mobile_ResetHouseholdRecurringMerchantSearch&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileResetRolloverMutation**](docs/MobileScreensApi.md#mobileresetrollovermutation) | **GET** /v1/mobile/reset-rollover-mutation | Mobile screen aggregate &#x60;Mobile_ResetRolloverMutation&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileRestoreCategoryMutation**](docs/MobileScreensApi.md#mobilerestorecategorymutation) | **GET** /v1/mobile/restore-category-mutation | Mobile screen aggregate &#x60;Mobile_RestoreCategoryMutation&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileReviewDashboardQuery**](docs/MobileScreensApi.md#mobilereviewdashboardquery) | **GET** /v1/mobile/review-dashboard-query | Mobile screen aggregate &#x60;Mobile_ReviewDashboardQuery&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileReviewTransactionsDashboardButton**](docs/MobileScreensApi.md#mobilereviewtransactionsdashboardbutton) | **GET** /v1/mobile/review-transactions-dashboard-button | Mobile screen aggregate &#x60;Mobile_ReviewTransactionsDashboardButton&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileRulesSettingsScreenQuery**](docs/MobileScreensApi.md#mobilerulessettingsscreenquery) | **GET** /v1/mobile/rules-settings-screen-query | Mobile screen aggregate &#x60;Mobile_RulesSettingsScreenQuery&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileSavingsGoalFilterOptions**](docs/MobileScreensApi.md#mobilesavingsgoalfilteroptions) | **GET** /v1/mobile/savings-goal-filter-options | Mobile screen aggregate &#x60;Mobile_SavingsGoalFilterOptions&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileSearchInstitutionsQuery**](docs/MobileScreensApi.md#mobilesearchinstitutionsquery) | **GET** /v1/mobile/search-institutions-query | Mobile screen aggregate &#x60;Mobile_SearchInstitutionsQuery&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileSearchMerchants**](docs/MobileScreensApi.md#mobilesearchmerchants) | **GET** /v1/mobile/search-merchants | Mobile screen aggregate &#x60;Mobile_SearchMerchants&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileSearchVehiclesQuery**](docs/MobileScreensApi.md#mobilesearchvehiclesquery) | **GET** /v1/mobile/search-vehicles-query | Mobile screen aggregate &#x60;Mobile_SearchVehiclesQuery&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileSelectGoalsScreen**](docs/MobileScreensApi.md#mobileselectgoalsscreen) | **GET** /v1/mobile/select-goals-screen | Mobile screen aggregate &#x60;Mobile_SelectGoalsScreen&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileSetTransactionTagsRapidReview**](docs/MobileScreensApi.md#mobilesettransactiontagsrapidreview) | **GET** /v1/mobile/set-transaction-tags-rapid-review | Mobile screen aggregate &#x60;Mobile_SetTransactionTagsRapidReview&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileToggleSupportAccountAccess**](docs/MobileScreensApi.md#mobiletogglesupportaccountaccess) | **GET** /v1/mobile/toggle-support-account-access | Mobile screen aggregate &#x60;Mobile_ToggleSupportAccountAccess&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileTransactionsMessageBlock**](docs/MobileScreensApi.md#mobiletransactionsmessageblock) | **GET** /v1/mobile/transactions-message-block | Mobile screen aggregate &#x60;Mobile_TransactionsMessageBlock&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileUpdateCategoryGroupOrderMutation**](docs/MobileScreensApi.md#mobileupdatecategorygroupordermutation) | **GET** /v1/mobile/update-category-group-order-mutation | Mobile screen aggregate &#x60;Mobile_UpdateCategoryGroupOrderMutation&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileUpdateCategoryMutation**](docs/MobileScreensApi.md#mobileupdatecategorymutation) | **GET** /v1/mobile/update-category-mutation | Mobile screen aggregate &#x60;Mobile_UpdateCategoryMutation&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileUpdateCategoryOrderMutation**](docs/MobileScreensApi.md#mobileupdatecategoryordermutation) | **GET** /v1/mobile/update-category-order-mutation | Mobile screen aggregate &#x60;Mobile_UpdateCategoryOrderMutation&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileUpdateGoalV2**](docs/MobileScreensApi.md#mobileupdategoalv2) | **GET** /v1/mobile/update-goal-v2 | Mobile screen aggregate &#x60;Mobile_UpdateGoalV2&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileUpdateGoalsPriorities**](docs/MobileScreensApi.md#mobileupdategoalspriorities) | **GET** /v1/mobile/update-goals-priorities | Mobile screen aggregate &#x60;Mobile_UpdateGoalsPriorities&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileUpdateNonMonthlyCategory**](docs/MobileScreensApi.md#mobileupdatenonmonthlycategory) | **GET** /v1/mobile/update-non-monthly-category | Mobile screen aggregate &#x60;Mobile_UpdateNonMonthlyCategory&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileUpdateReviewCheckinMutation**](docs/MobileScreensApi.md#mobileupdatereviewcheckinmutation) | **GET** /v1/mobile/update-review-checkin-mutation | Mobile screen aggregate &#x60;Mobile_UpdateReviewCheckinMutation&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileUpdateTransactionDetailScreen**](docs/MobileScreensApi.md#mobileupdatetransactiondetailscreen) | **GET** /v1/mobile/update-transaction-detail-screen | Mobile screen aggregate &#x60;Mobile_UpdateTransactionDetailScreen&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileUpdateTransactionRapidReview**](docs/MobileScreensApi.md#mobileupdatetransactionrapidreview) | **GET** /v1/mobile/update-transaction-rapid-review | Mobile screen aggregate &#x60;Mobile_UpdateTransactionRapidReview&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileUpdateUserFinancialProfile**](docs/MobileScreensApi.md#mobileupdateuserfinancialprofile) | **GET** /v1/mobile/update-user-financial-profile | Mobile screen aggregate &#x60;Mobile_UpdateUserFinancialProfile&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileUpsellPostalCode**](docs/MobileScreensApi.md#mobileupsellpostalcode) | **GET** /v1/mobile/upsell-postal-code | Mobile screen aggregate &#x60;Mobile_Upsell_PostalCode&#x60; (opaque pass-through)
*MobileScreensApi* | [**mobileUserAvatar**](docs/MobileScreensApi.md#mobileuseravatar) | **GET** /v1/mobile/user-avatar | Mobile screen aggregate &#x60;Mobile_UserAvatar&#x60; (opaque pass-through)
*PaychecksApi* | [**createPaycheck**](docs/PaychecksApi.md#createpaycheck) | **POST** /v1/paychecks | Record a new paycheck
*PaychecksApi* | [**createPaycheckEmployer**](docs/PaychecksApi.md#createpaycheckemployer) | **POST** /v1/paycheck-employers | Register a new employer
*PaychecksApi* | [**deletePaycheck**](docs/PaychecksApi.md#deletepaycheck) | **DELETE** /v1/paychecks/{id} | Delete a paycheck
*PaychecksApi* | [**deletePaycheckEmployer**](docs/PaychecksApi.md#deletepaycheckemployer) | **DELETE** /v1/paycheck-employers/{id} | Delete an employer
*PaychecksApi* | [**getPaycheck**](docs/PaychecksApi.md#getpaycheck) | **GET** /v1/paychecks/{id} | Single-paycheck full detail
*PaychecksApi* | [**getPaychecksSummary**](docs/PaychecksApi.md#getpaycheckssummary) | **GET** /v1/paychecks/summary | Aggregate paycheck stats over a window
*PaychecksApi* | [**listPaycheckEmployers**](docs/PaychecksApi.md#listpaycheckemployers) | **GET** /v1/paycheck-employers | List paycheck employers
*PaychecksApi* | [**listPaychecks**](docs/PaychecksApi.md#listpaychecks) | **GET** /v1/paychecks | List paychecks (with optional date + owner + employer filter)
*PaychecksApi* | [**updatePaycheck**](docs/PaychecksApi.md#updatepaycheck) | **PATCH** /v1/paychecks/{id} | Partial-update a paycheck
*PaychecksApi* | [**updatePaycheckEmployer**](docs/PaychecksApi.md#updatepaycheckemployer) | **PATCH** /v1/paycheck-employers/{id} | Rename an employer
*RecurringApi* | [**getRecurringDashboard**](docs/RecurringApi.md#getrecurringdashboard) | **GET** /v1/recurring/dashboard | Dashboard view of upcoming recurring items + total due
*RecurringApi* | [**getRecurringForecast**](docs/RecurringApi.md#getrecurringforecast) | **GET** /v1/recurring/forecast | Recurring transaction forecast
*RecurringApi* | [**listAllRecurring**](docs/RecurringApi.md#listallrecurring) | **GET** /v1/recurring/all | All recurring streams with next-occurrence detail
*RecurringApi* | [**listRecurring**](docs/RecurringApi.md#listrecurring) | **GET** /v1/recurring | Upcoming + recent recurring transaction occurrences
*RecurringApi* | [**listRecurringAggregate**](docs/RecurringApi.md#listrecurringaggregate) | **GET** /v1/recurring/aggregate | Month-by-month aggregate recurring view
*RecurringApi* | [**listRecurringStreams**](docs/RecurringApi.md#listrecurringstreams) | **GET** /v1/recurring/streams | Recurring stream definitions
*RecurringApi* | [**mergeRecurringStreams**](docs/RecurringApi.md#mergerecurringstreams) | **POST** /v1/recurring/streams/merge | Merge recurring streams
*RecurringApi* | [**skipRecurringInstance**](docs/RecurringApi.md#skiprecurringinstance) | **POST** /v1/recurring/{id}/skip | Skip one expected occurrence
*RecurringApi* | [**updateMerchantRecurrence**](docs/RecurringApi.md#updatemerchantrecurrence) | **PATCH** /v1/merchants/{id}/recurrence | Update a merchant\&#39;s recurring-transaction settings
*ReportConfigApi* | [**reportConfigsCommandPalette**](docs/ReportConfigApi.md#reportconfigscommandpalette) | **GET** /v1/report-configs/command-palette | Forward &#x60;Web_GetReportConfigurationsForCommandPalette&#x60; (opaque pass-through)
*ReportConfigApi* | [**reportConfigsCreate**](docs/ReportConfigApi.md#reportconfigscreate) | **GET** /v1/report-configs/create | Forward &#x60;Common_CreateReportConfiguration&#x60; (opaque pass-through)
*ReportConfigApi* | [**reportConfigsDelete**](docs/ReportConfigApi.md#reportconfigsdelete) | **GET** /v1/report-configs/delete | Forward &#x60;Common_DeleteReportConfiguration&#x60; (opaque pass-through)
*ReportConfigApi* | [**reportConfigsList**](docs/ReportConfigApi.md#reportconfigslist) | **GET** /v1/report-configs | Forward &#x60;Common_GetReportConfigurations&#x60; (opaque pass-through)
*ReportConfigApi* | [**reportConfigsUpdate**](docs/ReportConfigApi.md#reportconfigsupdate) | **GET** /v1/report-configs/update | Forward &#x60;Common_UpdateReportConfiguration&#x60; (opaque pass-through)
*RulesApi* | [**createTransactionRule**](docs/RulesApi.md#createtransactionrule) | **POST** /v1/transaction-rules | Create a transaction rule
*RulesApi* | [**deleteTransactionRule**](docs/RulesApi.md#deletetransactionrule) | **DELETE** /v1/transaction-rules/{id} | Delete a transaction rule
*RulesApi* | [**listTransactionRules**](docs/RulesApi.md#listtransactionrules) | **GET** /v1/transaction-rules | List all transaction rules
*RulesApi* | [**previewTransactionRule**](docs/RulesApi.md#previewtransactionrule) | **POST** /v1/transaction-rules/preview | Preview transactions a rule would match (dry-run, no persistence)
*RulesApi* | [**updateTransactionRule**](docs/RulesApi.md#updatetransactionrule) | **PATCH** /v1/transaction-rules/{id} | Update a transaction rule
*SettingsApi* | [**getAppearance**](docs/SettingsApi.md#getappearance) | **GET** /v1/me/appearance | Appearance preferences
*SettingsApi* | [**getCookiePreferences**](docs/SettingsApi.md#getcookiepreferences) | **GET** /v1/me/cookies | Cookie preferences
*SettingsApi* | [**getCurrency**](docs/SettingsApi.md#getcurrency) | **GET** /v1/me/currency | Currency preferences
*SettingsApi* | [**getEmailNotificationPrefs**](docs/SettingsApi.md#getemailnotificationprefs) | **GET** /v1/preferences/notifications/email | Email notification preferences
*SettingsApi* | [**getFiscalYear**](docs/SettingsApi.md#getfiscalyear) | **GET** /v1/household/fiscal-year | Fiscal year preferences
*SettingsApi* | [**getHouseholdMembers**](docs/SettingsApi.md#gethouseholdmembers) | **GET** /v1/household/members | Household members
*SettingsApi* | [**getHouseholdPreferences**](docs/SettingsApi.md#gethouseholdpreferences) | **GET** /v1/household/preferences | Household preferences
*SettingsApi* | [**getMe**](docs/SettingsApi.md#getme) | **GET** /v1/me | Current authenticated user
*SettingsApi* | [**getMyHousehold**](docs/SettingsApi.md#getmyhousehold) | **GET** /v1/household | My household
*SettingsApi* | [**getNotificationPreferences**](docs/SettingsApi.md#getnotificationpreferences) | **GET** /v1/notifications/preferences | Notification preferences
*SettingsApi* | [**getPushNotificationPrefs**](docs/SettingsApi.md#getpushnotificationprefs) | **GET** /v1/preferences/notifications/push | Push notification preferences
*SettingsApi* | [**inviteHouseholdMember**](docs/SettingsApi.md#invitehouseholdmember) | **POST** /v1/household/members/invite | Invite a household member
*SettingsApi* | [**removeHouseholdMember**](docs/SettingsApi.md#removehouseholdmember) | **DELETE** /v1/household/members/{id} | Remove a household member
*SettingsApi* | [**setCurrency**](docs/SettingsApi.md#setcurrency) | **PUT** /v1/me/currency | Update currency preferences
*SettingsApi* | [**setEmailNotificationPrefs**](docs/SettingsApi.md#setemailnotificationprefs) | **PUT** /v1/preferences/notifications/email | Update email notification preferences
*SettingsApi* | [**setFiscalYear**](docs/SettingsApi.md#setfiscalyear) | **PUT** /v1/household/fiscal-year | Update fiscal year preferences
*SettingsApi* | [**setPushNotificationPrefs**](docs/SettingsApi.md#setpushnotificationprefs) | **PUT** /v1/preferences/notifications/push | Update push notification preferences
*SettingsApi* | [**updateAppearance**](docs/SettingsApi.md#updateappearance) | **PATCH** /v1/me/appearance | Update appearance preferences
*SettingsApi* | [**updateCookiePreferences**](docs/SettingsApi.md#updatecookiepreferences) | **PATCH** /v1/me/cookies | Update cookie preferences
*SettingsApi* | [**updateHouseholdName**](docs/SettingsApi.md#updatehouseholdname) | **PUT** /v1/household/name | Update household name
*SettingsApi* | [**updateHouseholdPreferences**](docs/SettingsApi.md#updatehouseholdpreferences) | **PATCH** /v1/household/preferences | Update household preferences
*SettingsApi* | [**updateMe**](docs/SettingsApi.md#updateme) | **PATCH** /v1/me | Update current user profile
*SettingsApi* | [**updateNotificationPreferences**](docs/SettingsApi.md#updatenotificationpreferences) | **PATCH** /v1/notifications/preferences | Update notification preferences
*SystemApi* | [**clearAllNotifications**](docs/SystemApi.md#clearallnotifications) | **POST** /v1/notifications/clear-all | Clear all notifications
*SystemApi* | [**dismissNotification**](docs/SystemApi.md#dismissnotification) | **POST** /v1/notifications/{id}/dismiss | Dismiss one notification
*SystemApi* | [**getAppVersion**](docs/SystemApi.md#getappversion) | **GET** /v1/app/version | App version info
*SystemApi* | [**getAuthStatus**](docs/SystemApi.md#getauthstatus) | **GET** /v1/auth/status | Whether a Monarch session is currently loaded
*SystemApi* | [**getBetaFeatures**](docs/SystemApi.md#getbetafeatures) | **GET** /v1/app/beta-features | Beta features the account can opt into
*SystemApi* | [**getCalendarEvents**](docs/SystemApi.md#getcalendarevents) | **GET** /v1/calendar/events | Calendar events
*SystemApi* | [**getCashflowReport**](docs/SystemApi.md#getcashflowreport) | **GET** /v1/reports/cashflow | Cashflow report
*SystemApi* | [**getCategoryReport**](docs/SystemApi.md#getcategoryreport) | **GET** /v1/reports/category | Per-category historical report
*SystemApi* | [**getCreditHistory**](docs/SystemApi.md#getcredithistory) | **GET** /v1/credit/history | Credit-score snapshots over time
*SystemApi* | [**getEntitlements**](docs/SystemApi.md#getentitlements) | **GET** /v1/entitlements | Subscription entitlements
*SystemApi* | [**getExpenseByCategory**](docs/SystemApi.md#getexpensebycategory) | **GET** /v1/reports/expense-by-category | Expense breakdown grouped by category
*SystemApi* | [**getExpenseByMerchant**](docs/SystemApi.md#getexpensebymerchant) | **GET** /v1/reports/expense-by-merchant | Expense breakdown grouped by merchant
*SystemApi* | [**getExpenseByTag**](docs/SystemApi.md#getexpensebytag) | **GET** /v1/reports/expense-by-tag | Expense breakdown grouped by tag
*SystemApi* | [**getFeatureFlags**](docs/SystemApi.md#getfeatureflags) | **GET** /v1/app/feature-flags | Feature flags for this account
*SystemApi* | [**getFinancialInsight**](docs/SystemApi.md#getfinancialinsight) | **GET** /v1/insights/{id} | Single AI savings insight
*SystemApi* | [**getHealth**](docs/SystemApi.md#gethealth) | **GET** /healthz | Liveness probe with auth-presence hint
*SystemApi* | [**getIncomeReport**](docs/SystemApi.md#getincomereport) | **GET** /v1/reports/income | Income report
*SystemApi* | [**getIncomeVsExpenseYoy**](docs/SystemApi.md#getincomevsexpenseyoy) | **GET** /v1/reports/income-vs-expense-yoy | Income vs. expense year-over-year
*SystemApi* | [**getIntegrationStatus**](docs/SystemApi.md#getintegrationstatus) | **GET** /v1/integrations/status | Per-credential integration health
*SystemApi* | [**getLatestInsightRun**](docs/SystemApi.md#getlatestinsightrun) | **GET** /v1/insights/latest-run | Latest financial-insight run + insights count
*SystemApi* | [**getLatestRefreshOperation**](docs/SystemApi.md#getlatestrefreshoperation) | **GET** /v1/refresh/latest | Latest force-refresh operation
*SystemApi* | [**getLookup**](docs/SystemApi.md#getlookup) | **GET** /v1/lookup | Cross-entity fuzzy lookup
*SystemApi* | [**getMonthlyReportSummary**](docs/SystemApi.md#getmonthlyreportsummary) | **GET** /v1/reports/monthly-summary | Monthly report summary
*SystemApi* | [**getNetWorthReport**](docs/SystemApi.md#getnetworthreport) | **GET** /v1/reports/net-worth | Net-worth report
*SystemApi* | [**getNotifications**](docs/SystemApi.md#getnotifications) | **GET** /v1/notifications | Notification center (activity events)
*SystemApi* | [**getPlatformConfig**](docs/SystemApi.md#getplatformconfig) | **GET** /v1/app/platform-config | Platform configuration
*SystemApi* | [**getPlusTierAccess**](docs/SystemApi.md#getplustieraccess) | **GET** /v1/plus-tier | Plus-tier access info
*SystemApi* | [**getRefreshStatus**](docs/SystemApi.md#getrefreshstatus) | **GET** /v1/refresh/status | Poll per-account sync status
*SystemApi* | [**getSavingsRateReport**](docs/SystemApi.md#getsavingsratereport) | **GET** /v1/reports/savings-rate | Savings-rate report
*SystemApi* | [**getSavingsRateTrends**](docs/SystemApi.md#getsavingsratetrends) | **GET** /v1/reports/savings-rate-trends | Savings-rate trend series
*SystemApi* | [**getSpendingReport**](docs/SystemApi.md#getspendingreport) | **GET** /v1/reports/spending | Spending report
*SystemApi* | [**getSubscription**](docs/SystemApi.md#getsubscription) | **GET** /v1/subscription | Monarch subscription tier + payment source
*SystemApi* | [**getSubscriptionDetails**](docs/SystemApi.md#getsubscriptiondetails) | **GET** /v1/subscription/details | Detailed subscription info
*SystemApi* | [**getSubscriptionInvoices**](docs/SystemApi.md#getsubscriptioninvoices) | **GET** /v1/subscription/invoices | Subscription invoice history
*SystemApi* | [**getSubscriptionReceipts**](docs/SystemApi.md#getsubscriptionreceipts) | **GET** /v1/subscription/receipts | Subscription payment receipts
*SystemApi* | [**getTagReport**](docs/SystemApi.md#gettagreport) | **GET** /v1/reports/tag | Per-tag historical report
*SystemApi* | [**getWeeklyRecap**](docs/SystemApi.md#getweeklyrecap) | **GET** /v1/recap/weekly | Weekly recap
*SystemApi* | [**getZestimate**](docs/SystemApi.md#getzestimate) | **POST** /v1/zillow/zestimate | Zillow Zestimate lookup
*SystemApi* | [**initiatePasswordChange**](docs/SystemApi.md#initiatepasswordchange) | **POST** /v1/me/password-change/initiate | Initiate password change
*SystemApi* | [**listFinancialInsights**](docs/SystemApi.md#listfinancialinsights) | **GET** /v1/insights | List AI savings insights
*SystemApi* | [**markAllNotificationsAsRead**](docs/SystemApi.md#markallnotificationsasread) | **POST** /v1/notifications/read-all | Mark all notifications as read
*SystemApi* | [**markNotificationAsRead**](docs/SystemApi.md#marknotificationasread) | **POST** /v1/notifications/{id}/read | Mark one notification as read
*SystemApi* | [**pauseSubscription**](docs/SystemApi.md#pausesubscription) | **POST** /v1/subscription/pause | Pause the subscription
*SystemApi* | [**previewSubscriptionPlanChange**](docs/SystemApi.md#previewsubscriptionplanchange) | **POST** /v1/subscription/plan-preview | Preview a plan-change charge
*SystemApi* | [**refreshAuth**](docs/SystemApi.md#refreshauth) | **POST** /v1/auth/refresh | Reload session JSON from disk
*SystemApi* | [**requestRefresh**](docs/SystemApi.md#requestrefresh) | **POST** /v1/refresh | Force Monarch to re-poll Plaid (async)
*SystemApi* | [**requestRefreshAndWait**](docs/SystemApi.md#requestrefreshandwait) | **POST** /v1/refresh/wait | Force Monarch to re-poll Plaid and wait until every account has finished
*SystemApi* | [**resumeSubscription**](docs/SystemApi.md#resumesubscription) | **POST** /v1/subscription/resume | Resume a paused subscription
*TagsApi* | [**createTag**](docs/TagsApi.md#createtag) | **POST** /v1/tags | Create a tag
*TagsApi* | [**deleteTag**](docs/TagsApi.md#deletetag) | **DELETE** /v1/tags/{id} | Delete a tag
*TagsApi* | [**listTags**](docs/TagsApi.md#listtags) | **GET** /v1/tags | List all transaction tags
*TaxApi* | [**getTaxBracketEstimates**](docs/TaxApi.md#gettaxbracketestimates) | **GET** /v1/tax/bracket-estimates | Tax bracket estimates
*TaxApi* | [**getTaxCategories**](docs/TaxApi.md#gettaxcategories) | **GET** /v1/tax/categories | All categories including &#x60;systemCategory&#x60; (for tax-prep)
*TaxApi* | [**getTaxCategoryAggregates**](docs/TaxApi.md#gettaxcategoryaggregates) | **GET** /v1/tax/category-aggregates | Sum + count of transactions by category for a date window
*TaxApi* | [**getTaxScheduleCategoryMappings**](docs/TaxApi.md#gettaxschedulecategorymappings) | **GET** /v1/tax/schedule-mappings | Tax-schedule line-item to category mappings
*TaxApi* | [**getTaxYearOverview**](docs/TaxApi.md#gettaxyearoverview) | **GET** /v1/tax/year-overview | Tax year overview
*TaxLotsApi* | [**createManualTaxLot**](docs/TaxLotsApi.md#createmanualtaxlot) | **POST** /v1/holdings/{id}/tax-lots/create | Create one manual tax lot under a holding
*TaxLotsApi* | [**createManualTaxLotsBulk**](docs/TaxLotsApi.md#createmanualtaxlotsbulk) | **POST** /v1/accounts/{id}/tax-lots/bulk | Bulk-create tax lots under an account
*TaxLotsApi* | [**deleteTaxLot**](docs/TaxLotsApi.md#deletetaxlot) | **DELETE** /v1/tax-lots/{id} | Delete one manual tax lot
*TaxLotsApi* | [**deleteTaxLotsBulk**](docs/TaxLotsApi.md#deletetaxlotsbulk) | **POST** /v1/tax-lots/bulk-delete | Bulk-delete tax lots by id
*TaxLotsApi* | [**getTaxLotPerformance**](docs/TaxLotsApi.md#gettaxlotperformance) | **GET** /v1/holdings/{id}/tax-lot-performance | Per-holding tax-lot performance chart
*TaxLotsApi* | [**listTaxLots**](docs/TaxLotsApi.md#listtaxlots) | **GET** /v1/holdings/{id}/tax-lots | List tax lots under a holding
*TaxLotsApi* | [**updateTaxLot**](docs/TaxLotsApi.md#updatetaxlot) | **PATCH** /v1/tax-lots/{id} | Update one manual tax lot
*TransactionsApi* | [**bulkDeleteTransactions**](docs/TransactionsApi.md#bulkdeletetransactions) | **POST** /v1/transactions/bulk-delete | Bulk-delete transactions
*TransactionsApi* | [**bulkUpdateTransactions**](docs/TransactionsApi.md#bulkupdatetransactions) | **PATCH** /v1/transactions/bulk | Bulk-update transactions
*TransactionsApi* | [**createTransaction**](docs/TransactionsApi.md#createtransaction) | **POST** /v1/transactions | Create a manual transaction
*TransactionsApi* | [**deleteTransaction**](docs/TransactionsApi.md#deletetransaction) | **DELETE** /v1/transactions/{id} | Delete a transaction
*TransactionsApi* | [**explainTransaction**](docs/TransactionsApi.md#explaintransaction) | **GET** /v1/transactions/explain/{id} | AI explanation for one transaction
*TransactionsApi* | [**explainTransactionByPath**](docs/TransactionsApi.md#explaintransactionbypath) | **GET** /v1/transactions/{id}/explain | AI explanation for one transaction
*TransactionsApi* | [**getAccountsForTransactionFilter**](docs/TransactionsApi.md#getaccountsfortransactionfilter) | **GET** /v1/transactions/accounts-for-filter | Accounts that match a transaction filter
*TransactionsApi* | [**getAttachment**](docs/TransactionsApi.md#getattachment) | **GET** /v1/attachments/{id} | Attachment detail
*TransactionsApi* | [**getCashflow**](docs/TransactionsApi.md#getcashflow) | **GET** /v1/cashflow | Income, expense, and savings summary for a window
*TransactionsApi* | [**getCashflowBreakdown**](docs/TransactionsApi.md#getcashflowbreakdown) | **GET** /v1/cashflow/breakdown | Cashflow broken down by category, group, merchant
*TransactionsApi* | [**getCashflowDashboard**](docs/TransactionsApi.md#getcashflowdashboard) | **GET** /v1/cashflow/dashboard | Day-by-day expense series for a date window
*TransactionsApi* | [**getCashflowEntities**](docs/TransactionsApi.md#getcashflowentities) | **GET** /v1/cashflow/entities | Cashflow by category / category-group / merchant
*TransactionsApi* | [**getCashflowFiltered**](docs/TransactionsApi.md#getcashflowfiltered) | **GET** /v1/cashflow/filtered | Filtered cashflow page (summary + four breakdowns)
*TransactionsApi* | [**getCashflowTimeframe**](docs/TransactionsApi.md#getcashflowtimeframe) | **GET** /v1/cashflow/timeframe | Year / month / quarter cashflow summaries for a date window
*TransactionsApi* | [**getDownloadTransactionsSession**](docs/TransactionsApi.md#getdownloadtransactionssession) | **GET** /v1/transactions/download/{sessionKey} | Poll a transaction download session
*TransactionsApi* | [**getReviewSummaryByUser**](docs/TransactionsApi.md#getreviewsummarybyuser) | **GET** /v1/transactions/review-summary | Review-queue counts by household user
*TransactionsApi* | [**getSpendingDashboard**](docs/TransactionsApi.md#getspendingdashboard) | **GET** /v1/dashboard/spending | Home-tab spending dashboard widget
*TransactionsApi* | [**getSpendingTrends**](docs/TransactionsApi.md#getspendingtrends) | **GET** /v1/dashboard/spending/trends | Spending trends (period-over-period)
*TransactionsApi* | [**getTransactionAuditLog**](docs/TransactionsApi.md#gettransactionauditlog) | **GET** /v1/transactions/{id}/audit | Transaction audit log
*TransactionsApi* | [**getTransactionDetail**](docs/TransactionsApi.md#gettransactiondetail) | **GET** /v1/transactions/{id} | Single-transaction full detail
*TransactionsApi* | [**getTransactionNotes**](docs/TransactionsApi.md#gettransactionnotes) | **GET** /v1/transactions/{id}/notes | Transaction notes
*TransactionsApi* | [**getTransactionSplitTemplates**](docs/TransactionsApi.md#gettransactionsplittemplates) | **GET** /v1/transactions/split-templates | Saved split templates
*TransactionsApi* | [**getTransactionSplits**](docs/TransactionsApi.md#gettransactionsplits) | **GET** /v1/transactions/{id}/splits | Splits of one transaction
*TransactionsApi* | [**getTransactionsDashboard**](docs/TransactionsApi.md#gettransactionsdashboard) | **GET** /v1/transactions/dashboard | Dashboard transactions list (with totals + rule count)
*TransactionsApi* | [**getTransactionsDuplicates**](docs/TransactionsApi.md#gettransactionsduplicates) | **GET** /v1/transactions/duplicates | Groups of likely-duplicate transactions
*TransactionsApi* | [**getTransactionsSummary**](docs/TransactionsApi.md#gettransactionssummary) | **GET** /v1/transactions/summary | Aggregate stats across a transaction window
*TransactionsApi* | [**listTransactions**](docs/TransactionsApi.md#listtransactions) | **GET** /v1/transactions | Search and list transactions with rich filtering
*TransactionsApi* | [**markAsRecurring**](docs/TransactionsApi.md#markasrecurring) | **POST** /v1/transactions/{id}/recurring | Mark a transaction as the start of a recurring stream
*TransactionsApi* | [**markTransactionAsReviewed**](docs/TransactionsApi.md#marktransactionasreviewed) | **POST** /v1/transactions/{id}/reviewed | Mark a transaction as reviewed
*TransactionsApi* | [**markTransactionStreamAsNotRecurring**](docs/TransactionsApi.md#marktransactionstreamasnotrecurring) | **POST** /v1/transactions/{id}/not-recurring | Mark a transaction\&#39;s recurring-stream as not-recurring
*TransactionsApi* | [**matchSearchTransactions**](docs/TransactionsApi.md#matchsearchtransactions) | **GET** /v1/transactions/match-search | Fuzzy transaction search for \&quot;find a match\&quot;
*TransactionsApi* | [**moveTransactions**](docs/TransactionsApi.md#movetransactions) | **POST** /v1/transactions/move | Move transactions between accounts
*TransactionsApi* | [**setTransactionTags**](docs/TransactionsApi.md#settransactiontags) | **PUT** /v1/transactions/{id}/tags | Overwrite the tag set on a transaction
*TransactionsApi* | [**startDownloadTransactions**](docs/TransactionsApi.md#startdownloadtransactions) | **POST** /v1/transactions/download | Start a transaction CSV download session
*TransactionsApi* | [**updateTransaction**](docs/TransactionsApi.md#updatetransaction) | **PATCH** /v1/transactions/{id} | Partial-update a transaction
*TransactionsApi* | [**updateTransactionSplits**](docs/TransactionsApi.md#updatetransactionsplits) | **POST** /v1/transactions/{id}/splits | Replace the splits on a transaction
*TransactionsApi* | [**uploadTransactionAttachment**](docs/TransactionsApi.md#uploadtransactionattachment) | **POST** /v1/transactions/{id}/attachments | Attach a receipt photo or PDF to a transaction
*WebScreensApi* | [**webAccountDetailsRouterGetAccountType**](docs/WebScreensApi.md#webaccountdetailsroutergetaccounttype) | **POST** /v1/web/screens/account-details-router-get-account-type | Web screen aggregate &#x60;Web_AccountDetailsRouter_getAccountType&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webAccountEditModal**](docs/WebScreensApi.md#webaccounteditmodal) | **POST** /v1/web/screens/account-edit-modal | Web screen aggregate &#x60;Web_AccountEditModal&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webAccountFilterQuery**](docs/WebScreensApi.md#webaccountfilterquery) | **POST** /v1/web/screens/account-filter-query | Web screen aggregate &#x60;Web_AccountFilterQuery&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webAccountsMessageBlock**](docs/WebScreensApi.md#webaccountsmessageblock) | **POST** /v1/web/screens/accounts-message-block | Web screen aggregate &#x60;Web_AccountsMessageBlock&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webAdvisorPortalGetSubscription**](docs/WebScreensApi.md#webadvisorportalgetsubscription) | **POST** /v1/web/screens/advisor-portal-get-subscription | Web screen aggregate &#x60;Web_AdvisorPortalGetSubscription&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webAnswerQuestionMutation**](docs/WebScreensApi.md#webanswerquestionmutation) | **POST** /v1/web/aggregates/answer-question-mutation | Web screen aggregate &#x60;Web_AnswerQuestionMutation&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webAssignTaxScheduleCategoryMapping**](docs/WebScreensApi.md#webassigntaxschedulecategorymapping) | **POST** /v1/web/aggregates/assign-tax-schedule-category-mapping | Web screen aggregate &#x60;Web_AssignTaxScheduleCategoryMapping&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webBudgetOnboardingGetAccounts**](docs/WebScreensApi.md#webbudgetonboardinggetaccounts) | **POST** /v1/web/screens/budget-onboarding-get-accounts | Web screen aggregate &#x60;Web_BudgetOnboardingGetAccounts&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webCancelSponsorship**](docs/WebScreensApi.md#webcancelsponsorship) | **POST** /v1/web/aggregates/cancel-sponsorship | Web screen aggregate &#x60;Web_CancelSponsorship&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webChangeSubscription**](docs/WebScreensApi.md#webchangesubscription) | **POST** /v1/web/aggregates/change-subscription | Web screen aggregate &#x60;Web_ChangeSubscription&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webClearAllMutation**](docs/WebScreensApi.md#webclearallmutation) | **POST** /v1/web/aggregates/clear-all-mutation | Web screen aggregate &#x60;Web_ClearAllMutation&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webConfirmTotpDevice**](docs/WebScreensApi.md#webconfirmtotpdevice) | **POST** /v1/web/aggregates/confirm-totp-device | Web screen aggregate &#x60;Web_confirmTotpDevice&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webConvertEmployeeTrial**](docs/WebScreensApi.md#webconvertemployeetrial) | **POST** /v1/web/aggregates/convert-employee-trial | Web screen aggregate &#x60;Web_ConvertEmployeeTrial&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webCopySnapshots**](docs/WebScreensApi.md#webcopysnapshots) | **POST** /v1/web/aggregates/copy-snapshots | Web screen aggregate &#x60;Web_CopySnapshots&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webCreateAIReport**](docs/WebScreensApi.md#webcreateaireport) | **POST** /v1/web/aggregates/create-a-i-report | Web screen aggregate &#x60;Web_CreateAIReport&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webCreateAdvisorSubscription**](docs/WebScreensApi.md#webcreateadvisorsubscription) | **POST** /v1/web/aggregates/create-advisor-subscription | Web screen aggregate &#x60;Web_CreateAdvisorSubscription&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webCreateCoinbaseAccount**](docs/WebScreensApi.md#webcreatecoinbaseaccount) | **POST** /v1/web/aggregates/create-coinbase-account | Web screen aggregate &#x60;Web_CreateCoinbaseAccount&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webCreateEquityAccountWithGrants**](docs/WebScreensApi.md#webcreateequityaccountwithgrants) | **POST** /v1/web/aggregates/create-equity-account-with-grants | Web screen aggregate &#x60;Web_CreateEquityAccountWithGrants&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webCreateFeedbackEvent**](docs/WebScreensApi.md#webcreatefeedbackevent) | **POST** /v1/web/aggregates/create-feedback-event | Web screen aggregate &#x60;Web_CreateFeedbackEvent&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webCreatePromoCodeCheckoutSession**](docs/WebScreensApi.md#webcreatepromocodecheckoutsession) | **POST** /v1/web/aggregates/create-promo-code-checkout-session | Web screen aggregate &#x60;Web_CreatePromoCodeCheckoutSession&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webCreateSpinwheelAccountMapping**](docs/WebScreensApi.md#webcreatespinwheelaccountmapping) | **POST** /v1/web/aggregates/create-spinwheel-account-mapping | Web screen aggregate &#x60;Web_CreateSpinwheelAccountMapping&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webCreateSubscription**](docs/WebScreensApi.md#webcreatesubscription) | **POST** /v1/web/aggregates/create-subscription | Web screen aggregate &#x60;Web_CreateSubscription&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webCreateSubscriptionSponsorshipInvites**](docs/WebScreensApi.md#webcreatesubscriptionsponsorshipinvites) | **POST** /v1/web/aggregates/create-subscription-sponsorship-invites | Web screen aggregate &#x60;Web_CreateSubscriptionSponsorshipInvites&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webCreateUnconfirmedTotpDevice**](docs/WebScreensApi.md#webcreateunconfirmedtotpdevice) | **POST** /v1/web/aggregates/create-unconfirmed-totp-device | Web screen aggregate &#x60;Web_createUnconfirmedTotpDevice&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webCreateZillowAccount**](docs/WebScreensApi.md#webcreatezillowaccount) | **POST** /v1/web/aggregates/create-zillow-account | Web screen aggregate &#x60;Web_CreateZillowAccount&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webDeleteAccountLogo**](docs/WebScreensApi.md#webdeleteaccountlogo) | **POST** /v1/web/aggregates/delete-account-logo | Web screen aggregate &#x60;Web_DeleteAccountLogo&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webDeleteAllGoalReconciliationRecords**](docs/WebScreensApi.md#webdeleteallgoalreconciliationrecords) | **POST** /v1/web/aggregates/delete-all-goal-reconciliation-records | Web screen aggregate &#x60;Web_DeleteAllGoalReconciliationRecords&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webDeleteAllTransactionRulesMutation**](docs/WebScreensApi.md#webdeletealltransactionrulesmutation) | **POST** /v1/web/aggregates/delete-all-transaction-rules-mutation | Web screen aggregate &#x60;Web_DeleteAllTransactionRulesMutation&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webDeleteTaxScheduleCategoryMapping**](docs/WebScreensApi.md#webdeletetaxschedulecategorymapping) | **POST** /v1/web/aggregates/delete-tax-schedule-category-mapping | Web screen aggregate &#x60;Web_DeleteTaxScheduleCategoryMapping&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webDeleteUserFromHousehold**](docs/WebScreensApi.md#webdeleteuserfromhousehold) | **POST** /v1/web/aggregates/delete-user-from-household | Web screen aggregate &#x60;Web_DeleteUserFromHousehold&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webDirectLinkAccountSelectDataProvider**](docs/WebScreensApi.md#webdirectlinkaccountselectdataprovider) | **POST** /v1/web/screens/direct-link-account-select-data-provider | Web screen aggregate &#x60;Web_DirectLinkAccountSelectDataProvider&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webDisableMfa**](docs/WebScreensApi.md#webdisablemfa) | **POST** /v1/web/aggregates/disable-mfa | Web screen aggregate &#x60;Web_DisableMfa&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webDisconnectCredentialMutation**](docs/WebScreensApi.md#webdisconnectcredentialmutation) | **POST** /v1/web/aggregates/disconnect-credential-mutation | Web screen aggregate &#x60;Web_DisconnectCredentialMutation&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webDisconnectDiscord**](docs/WebScreensApi.md#webdisconnectdiscord) | **POST** /v1/web/aggregates/disconnect-discord | Web screen aggregate &#x60;Web_DisconnectDiscord&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webDiscordOAuthCallback**](docs/WebScreensApi.md#webdiscordoauthcallback) | **POST** /v1/web/aggregates/discord-o-auth-callback | Web screen aggregate &#x60;Web_DiscordOAuthCallback&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webEmployeeMenuDeleteCreditScoreSnapshots**](docs/WebScreensApi.md#webemployeemenudeletecreditscoresnapshots) | **POST** /v1/web/aggregates/employee-menu-delete-credit-score-snapshots | Web screen aggregate &#x60;Web_EmployeeMenuDeleteCreditScoreSnapshots&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webEmployeeMenuGetFinancialInsightIds**](docs/WebScreensApi.md#webemployeemenugetfinancialinsightids) | **POST** /v1/web/screens/employee-menu-get-financial-insight-ids | Web screen aggregate &#x60;Web_EmployeeMenuGetFinancialInsightIds&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webEmployeeMenuResetAiAssistantOptIn**](docs/WebScreensApi.md#webemployeemenuresetaiassistantoptin) | **POST** /v1/web/aggregates/employee-menu-reset-ai-assistant-opt-in | Web screen aggregate &#x60;Web_EmployeeMenuResetAiAssistantOptIn&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webEmployeeMenuSoftDeleteFinancialInsight**](docs/WebScreensApi.md#webemployeemenusoftdeletefinancialinsight) | **POST** /v1/web/aggregates/employee-menu-soft-delete-financial-insight | Web screen aggregate &#x60;Web_EmployeeMenuSoftDeleteFinancialInsight&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webEquityAccountDetailsGetAccount**](docs/WebScreensApi.md#webequityaccountdetailsgetaccount) | **POST** /v1/web/screens/equity-account-details-get-account | Web screen aggregate &#x60;Web_EquityAccountDetails_getAccount&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webEquityAccountDetailsGetLinkedAccount**](docs/WebScreensApi.md#webequityaccountdetailsgetlinkedaccount) | **POST** /v1/web/screens/equity-account-details-get-linked-account | Web screen aggregate &#x60;Web_EquityAccountDetails_getLinkedAccount&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webExtendFreeTrialDuration**](docs/WebScreensApi.md#webextendfreetrialduration) | **POST** /v1/web/aggregates/extend-free-trial-duration | Web screen aggregate &#x60;Web_ExtendFreeTrialDuration&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webGenerateReportName**](docs/WebScreensApi.md#webgeneratereportname) | **POST** /v1/web/screens/generate-report-name | Web screen aggregate &#x60;Web_GenerateReportName&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGetAccount**](docs/WebScreensApi.md#webgetaccount) | **POST** /v1/web/screens/get-account | Web screen aggregate &#x60;Web_GetAccount&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGetAccountTypes**](docs/WebScreensApi.md#webgetaccounttypes) | **POST** /v1/web/screens/get-account-types | Web screen aggregate &#x60;Web_GetAccountTypes&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGetAccountsForTransfer**](docs/WebScreensApi.md#webgetaccountsfortransfer) | **POST** /v1/web/screens/get-accounts-for-transfer | Web screen aggregate &#x60;Web_GetAccountsForTransfer&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGetAccountsPage**](docs/WebScreensApi.md#webgetaccountspage) | **POST** /v1/web/screens/get-accounts-page | Web screen aggregate &#x60;Web_GetAccountsPage&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGetAccountsPageRecentBalance**](docs/WebScreensApi.md#webgetaccountspagerecentbalance) | **POST** /v1/web/screens/get-accounts-page-recent-balance | Web screen aggregate &#x60;Web_GetAccountsPageRecentBalance&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGetAdvisorClientsPage**](docs/WebScreensApi.md#webgetadvisorclientspage) | **POST** /v1/web/screens/get-advisor-clients-page | Web screen aggregate &#x60;Web_GetAdvisorClientsPage&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGetAdvisorProfilePage**](docs/WebScreensApi.md#webgetadvisorprofilepage) | **POST** /v1/web/screens/get-advisor-profile-page | Web screen aggregate &#x60;Web_GetAdvisorProfilePage&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGetBalanceHistoryParserColumns**](docs/WebScreensApi.md#webgetbalancehistoryparsercolumns) | **POST** /v1/web/screens/get-balance-history-parser-columns | Web screen aggregate &#x60;Web_GetBalanceHistoryParserColumns&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGetBusinessSetupPriorTracking**](docs/WebScreensApi.md#webgetbusinesssetuppriortracking) | **POST** /v1/web/screens/get-business-setup-prior-tracking | Web screen aggregate &#x60;Web_GetBusinessSetupPriorTracking&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGetCancellationReasonsWithSubreasons**](docs/WebScreensApi.md#webgetcancellationreasonswithsubreasons) | **POST** /v1/web/screens/get-cancellation-reasons-with-subreasons | Web screen aggregate &#x60;Web_GetCancellationReasonsWithSubreasons&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGetCategorizationDetails**](docs/WebScreensApi.md#webgetcategorizationdetails) | **POST** /v1/web/screens/get-categorization-details | Web screen aggregate &#x60;Web_GetCategorizationDetails&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGetCategoryGroupDetails**](docs/WebScreensApi.md#webgetcategorygroupdetails) | **POST** /v1/web/screens/get-category-group-details | Web screen aggregate &#x60;Web_GetCategoryGroupDetails&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGetCategorySelectOptions**](docs/WebScreensApi.md#webgetcategoryselectoptions) | **POST** /v1/web/screens/get-category-select-options | Web screen aggregate &#x60;Web_GetCategorySelectOptions&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGetConnectedApps**](docs/WebScreensApi.md#webgetconnectedapps) | **POST** /v1/web/screens/get-connected-apps | Web screen aggregate &#x60;Web_GetConnectedApps&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGetContactSupportFormData**](docs/WebScreensApi.md#webgetcontactsupportformdata) | **POST** /v1/web/screens/get-contact-support-form-data | Web screen aggregate &#x60;Web_GetContactSupportFormData&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGetDiscordConnectionRedirectUrl**](docs/WebScreensApi.md#webgetdiscordconnectionredirecturl) | **POST** /v1/web/screens/get-discord-connection-redirect-url | Web screen aggregate &#x60;Web_GetDiscordConnectionRedirectUrl&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGetDownloadScheduleCSession**](docs/WebScreensApi.md#webgetdownloadschedulecsession) | **POST** /v1/web/screens/get-download-schedule-c-session | Web screen aggregate &#x60;Web_GetDownloadScheduleCSession&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGetEventPopoverTransactions**](docs/WebScreensApi.md#webgeteventpopovertransactions) | **POST** /v1/web/screens/get-event-popover-transactions | Web screen aggregate &#x60;Web_GetEventPopoverTransactions&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGetFilteredAccounts**](docs/WebScreensApi.md#webgetfilteredaccounts) | **POST** /v1/web/screens/get-filtered-accounts | Web screen aggregate &#x60;Web_GetFilteredAccounts&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGetFlexibleGroupRolloverSettings**](docs/WebScreensApi.md#webgetflexiblegrouprolloversettings) | **POST** /v1/web/screens/get-flexible-group-rollover-settings | Web screen aggregate &#x60;Web_GetFlexibleGroupRolloverSettings&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGetGiftedSubscriptionsForPolling**](docs/WebScreensApi.md#webgetgiftedsubscriptionsforpolling) | **POST** /v1/web/screens/get-gifted-subscriptions-for-polling | Web screen aggregate &#x60;Web_GetGiftedSubscriptionsForPolling&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGetInvestmentsAccounts**](docs/WebScreensApi.md#webgetinvestmentsaccounts) | **POST** /v1/web/screens/get-investments-accounts | Web screen aggregate &#x60;Web_GetInvestmentsAccounts&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGetInvestmentsDashboardCard**](docs/WebScreensApi.md#webgetinvestmentsdashboardcard) | **POST** /v1/web/screens/get-investments-dashboard-card | Web screen aggregate &#x60;Web_GetInvestmentsDashboardCard&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGetInvestmentsHoldingDrawerHistoricalPerformance**](docs/WebScreensApi.md#webgetinvestmentsholdingdrawerhistoricalperformance) | **POST** /v1/web/screens/get-investments-holding-drawer-historical-performance | Web screen aggregate &#x60;Web_GetInvestmentsHoldingDrawerHistoricalPerformance&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGetMeCollaborationProfileStep**](docs/WebScreensApi.md#webgetmecollaborationprofilestep) | **POST** /v1/web/screens/get-me-collaboration-profile-step | Web screen aggregate &#x60;Web_GetMeCollaborationProfileStep&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGetMerchantSelectHouseholdMerchants**](docs/WebScreensApi.md#webgetmerchantselecthouseholdmerchants) | **POST** /v1/web/screens/get-merchant-select-household-merchants | Web screen aggregate &#x60;Web_GetMerchantSelectHouseholdMerchants&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGetMerchantSelectRecommendedMerchants**](docs/WebScreensApi.md#webgetmerchantselectrecommendedmerchants) | **POST** /v1/web/screens/get-merchant-select-recommended-merchants | Web screen aggregate &#x60;Web_GetMerchantSelectRecommendedMerchants&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGetMerchantSelectTransactionDetails**](docs/WebScreensApi.md#webgetmerchantselecttransactiondetails) | **POST** /v1/web/screens/get-merchant-select-transaction-details | Web screen aggregate &#x60;Web_GetMerchantSelectTransactionDetails&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGetMerchantSettingsPage**](docs/WebScreensApi.md#webgetmerchantsettingspage) | **POST** /v1/web/screens/get-merchant-settings-page | Web screen aggregate &#x60;Web_GetMerchantSettingsPage&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGetPlanRecommendationData**](docs/WebScreensApi.md#webgetplanrecommendationdata) | **POST** /v1/web/screens/get-plan-recommendation-data | Web screen aggregate &#x60;Web_GetPlanRecommendationData&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGetPortfolio**](docs/WebScreensApi.md#webgetportfolio) | **POST** /v1/web/screens/get-portfolio | Web screen aggregate &#x60;Web_GetPortfolio&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGetPortfolioWithClassification**](docs/WebScreensApi.md#webgetportfoliowithclassification) | **POST** /v1/web/screens/get-portfolio-with-classification | Web screen aggregate &#x60;Web_GetPortfolioWithClassification&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGetRecommendedCategories**](docs/WebScreensApi.md#webgetrecommendedcategories) | **POST** /v1/web/screens/get-recommended-categories | Web screen aggregate &#x60;Web_GetRecommendedCategories&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGetScheduleCLineItems**](docs/WebScreensApi.md#webgetscheduleclineitems) | **POST** /v1/web/screens/get-schedule-c-line-items | Web screen aggregate &#x60;Web_GetScheduleCLineItems&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGetSecuritiesHistoricalPerformance**](docs/WebScreensApi.md#webgetsecuritieshistoricalperformance) | **POST** /v1/web/screens/get-securities-historical-performance | Web screen aggregate &#x60;Web_GetSecuritiesHistoricalPerformance&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGetSecuritySettings**](docs/WebScreensApi.md#webgetsecuritysettings) | **POST** /v1/web/screens/get-security-settings | Web screen aggregate &#x60;Web_GetSecuritySettings&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGetSidebarData**](docs/WebScreensApi.md#webgetsidebardata) | **POST** /v1/web/screens/get-sidebar-data | Web screen aggregate &#x60;Web_GetSidebarData&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGetStatementParserColumns**](docs/WebScreensApi.md#webgetstatementparsercolumns) | **POST** /v1/web/screens/get-statement-parser-columns | Web screen aggregate &#x60;Web_GetStatementParserColumns&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGetSubscription**](docs/WebScreensApi.md#webgetsubscription) | **POST** /v1/web/screens/get-subscription | Web screen aggregate &#x60;Web_GetSubscription&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGetSubscriptionModal**](docs/WebScreensApi.md#webgetsubscriptionmodal) | **POST** /v1/web/screens/get-subscription-modal | Web screen aggregate &#x60;Web_GetSubscriptionModal&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGetTaxPrepCategoryTransactions**](docs/WebScreensApi.md#webgettaxprepcategorytransactions) | **POST** /v1/web/screens/get-tax-prep-category-transactions | Web screen aggregate &#x60;Web_GetTaxPrepCategoryTransactions&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGetTaxPrepUnmappedCategoryTransactions**](docs/WebScreensApi.md#webgettaxprepunmappedcategorytransactions) | **POST** /v1/web/screens/get-tax-prep-unmapped-category-transactions | Web screen aggregate &#x60;Web_GetTaxPrepUnmappedCategoryTransactions&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGetTopInstitutionGroupByType**](docs/WebScreensApi.md#webgettopinstitutiongroupbytype) | **POST** /v1/web/screens/get-top-institution-group-by-type | Web screen aggregate &#x60;Web_GetTopInstitutionGroupByType&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGetTransactionFiltersMetadata**](docs/WebScreensApi.md#webgettransactionfiltersmetadata) | **POST** /v1/web/screens/get-transaction-filters-metadata | Web screen aggregate &#x60;Web_GetTransactionFiltersMetadata&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGetTransactionsPage**](docs/WebScreensApi.md#webgettransactionspage) | **POST** /v1/web/screens/get-transactions-page | Web screen aggregate &#x60;Web_GetTransactionsPage&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGetTransactionsSummaryCard**](docs/WebScreensApi.md#webgettransactionssummarycard) | **POST** /v1/web/screens/get-transactions-summary-card | Web screen aggregate &#x60;Web_GetTransactionsSummaryCard&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGetTrustAndWillSubscription**](docs/WebScreensApi.md#webgettrustandwillsubscription) | **POST** /v1/web/screens/get-trust-and-will-subscription | Web screen aggregate &#x60;Web_GetTrustAndWillSubscription&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGetUserDismissedRetailSyncBanner**](docs/WebScreensApi.md#webgetuserdismissedretailsyncbanner) | **POST** /v1/web/screens/get-user-dismissed-retail-sync-banner | Web screen aggregate &#x60;Web_GetUserDismissedRetailSyncBanner&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGetUserHasConfiguredExtension**](docs/WebScreensApi.md#webgetuserhasconfiguredextension) | **POST** /v1/web/screens/get-user-has-configured-extension | Web screen aggregate &#x60;Web_GetUserHasConfiguredExtension&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGetUserPlatforms**](docs/WebScreensApi.md#webgetuserplatforms) | **POST** /v1/web/screens/get-user-platforms | Web screen aggregate &#x60;Web_GetUserPlatforms&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGiveEmployeeInfinitePlusAccess**](docs/WebScreensApi.md#webgiveemployeeinfiniteplusaccess) | **POST** /v1/web/aggregates/give-employee-infinite-plus-access | Web screen aggregate &#x60;Web_GiveEmployeeInfinitePlusAccess&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webGiveEmployeeInfinitePremiumAccess**](docs/WebScreensApi.md#webgiveemployeeinfinitepremiumaccess) | **POST** /v1/web/aggregates/give-employee-infinite-premium-access | Web screen aggregate &#x60;Web_GiveEmployeeInfinitePremiumAccess&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webGoalDetailV2**](docs/WebScreensApi.md#webgoaldetailv2) | **POST** /v1/web/screens/goal-detail-v2 | Web screen aggregate &#x60;Web_GoalDetailV2&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGoalSelectGoals**](docs/WebScreensApi.md#webgoalselectgoals) | **POST** /v1/web/screens/goal-select-goals | Web screen aggregate &#x60;Web_GoalSelectGoals&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGoalSelectTransaction**](docs/WebScreensApi.md#webgoalselecttransaction) | **POST** /v1/web/screens/goal-select-transaction | Web screen aggregate &#x60;Web_GoalSelectTransaction&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGoalsAllocateBalanceModal**](docs/WebScreensApi.md#webgoalsallocatebalancemodal) | **POST** /v1/web/screens/goals-allocate-balance-modal | Web screen aggregate &#x60;Web_GoalsAllocateBalanceModal&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGoalsAllocationCardAccounts**](docs/WebScreensApi.md#webgoalsallocationcardaccounts) | **POST** /v1/web/screens/goals-allocation-card-accounts | Web screen aggregate &#x60;Web_GoalsAllocationCardAccounts&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGoalsDashboardCardV2**](docs/WebScreensApi.md#webgoalsdashboardcardv2) | **POST** /v1/web/screens/goals-dashboard-card-v2 | Web screen aggregate &#x60;Web_GoalsDashboardCardV2&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGoalsMapAccounts**](docs/WebScreensApi.md#webgoalsmapaccounts) | **POST** /v1/web/screens/goals-map-accounts | Web screen aggregate &#x60;Web_GoalsMapAccounts&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGoalsMapAccountsModal**](docs/WebScreensApi.md#webgoalsmapaccountsmodal) | **POST** /v1/web/screens/goals-map-accounts-modal | Web screen aggregate &#x60;Web_GoalsMapAccountsModal&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGoalsMessageBlock**](docs/WebScreensApi.md#webgoalsmessageblock) | **POST** /v1/web/screens/goals-message-block | Web screen aggregate &#x60;Web_GoalsMessageBlock&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGoalsMonthlyBudgets**](docs/WebScreensApi.md#webgoalsmonthlybudgets) | **POST** /v1/web/screens/goals-monthly-budgets | Web screen aggregate &#x60;Web_GoalsMonthlyBudgets&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webGoalsV2**](docs/WebScreensApi.md#webgoalsv2) | **POST** /v1/web/screens/goals-v2 | Web screen aggregate &#x60;Web_GoalsV2&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webImportStatementGetAccount**](docs/WebScreensApi.md#webimportstatementgetaccount) | **POST** /v1/web/screens/import-statement-get-account | Web screen aggregate &#x60;Web_ImportStatementGetAccount&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webInitScheduleCDefaultMappings**](docs/WebScreensApi.md#webinitschedulecdefaultmappings) | **POST** /v1/web/aggregates/init-schedule-c-default-mappings | Web screen aggregate &#x60;Web_InitScheduleCDefaultMappings&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webInviteEmail**](docs/WebScreensApi.md#webinviteemail) | **POST** /v1/web/aggregates/invite-email | Web screen aggregate &#x60;Web_InviteEmail&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webMigrateHouseholdToSavingGoals**](docs/WebScreensApi.md#webmigratehouseholdtosavinggoals) | **POST** /v1/web/aggregates/migrate-household-to-saving-goals | Web screen aggregate &#x60;Web_MigrateHouseholdToSavingGoals&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webMintTransactionsCountQuery**](docs/WebScreensApi.md#webminttransactionscountquery) | **POST** /v1/web/screens/mint-transactions-count-query | Web screen aggregate &#x60;Web_MintTransactionsCountQuery&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webMonthlyBudgetGoalsModal**](docs/WebScreensApi.md#webmonthlybudgetgoalsmodal) | **POST** /v1/web/screens/monthly-budget-goals-modal | Web screen aggregate &#x60;Web_MonthlyBudgetGoalsModal&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webMoveMoneyMutation**](docs/WebScreensApi.md#webmovemoneymutation) | **POST** /v1/web/aggregates/move-money-mutation | Web screen aggregate &#x60;Web_MoveMoneyMutation&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webOnboardingTopInstitutions**](docs/WebScreensApi.md#webonboardingtopinstitutions) | **POST** /v1/web/screens/onboarding-top-institutions | Web screen aggregate &#x60;Web_OnboardingTopInstitutions&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webParseUploadStatementSession**](docs/WebScreensApi.md#webparseuploadstatementsession) | **POST** /v1/web/aggregates/parse-upload-statement-session | Web screen aggregate &#x60;Web_ParseUploadStatementSession&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webPlusUpgradeTrial**](docs/WebScreensApi.md#webplusupgradetrial) | **POST** /v1/web/screens/plus-upgrade-trial | Web screen aggregate &#x60;Web_PlusUpgradeTrial&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webPreTaxBudgetGoalsList**](docs/WebScreensApi.md#webpretaxbudgetgoalslist) | **POST** /v1/web/screens/pre-tax-budget-goals-list | Web screen aggregate &#x60;Web_PreTaxBudgetGoalsList&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webPreviewAccountDataTransferSnapshots**](docs/WebScreensApi.md#webpreviewaccountdatatransfersnapshots) | **POST** /v1/web/screens/preview-account-data-transfer-snapshots | Web screen aggregate &#x60;Web_PreviewAccountDataTransferSnapshots&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webPreviewAccountDataTransferTransactions**](docs/WebScreensApi.md#webpreviewaccountdatatransfertransactions) | **POST** /v1/web/screens/preview-account-data-transfer-transactions | Web screen aggregate &#x60;Web_PreviewAccountDataTransferTransactions&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webPreviewCopySnapshots**](docs/WebScreensApi.md#webpreviewcopysnapshots) | **POST** /v1/web/screens/preview-copy-snapshots | Web screen aggregate &#x60;Web_PreviewCopySnapshots&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webRankGoalsList**](docs/WebScreensApi.md#webrankgoalslist) | **POST** /v1/web/screens/rank-goals-list | Web screen aggregate &#x60;Web_RankGoalsList&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webReactivateSubscription**](docs/WebScreensApi.md#webreactivatesubscription) | **POST** /v1/web/aggregates/reactivate-subscription | Web screen aggregate &#x60;Web_ReactivateSubscription&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webRecalculateBudgetMutation**](docs/WebScreensApi.md#webrecalculatebudgetmutation) | **POST** /v1/web/aggregates/recalculate-budget-mutation | Web screen aggregate &#x60;Web_RecalculateBudgetMutation&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webRecommendedAccountDataTransferDates**](docs/WebScreensApi.md#webrecommendedaccountdatatransferdates) | **POST** /v1/web/screens/recommended-account-data-transfer-dates | Web screen aggregate &#x60;Web_RecommendedAccountDataTransferDates&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webRecommendedAccounts**](docs/WebScreensApi.md#webrecommendedaccounts) | **POST** /v1/web/screens/recommended-accounts | Web screen aggregate &#x60;Web_RecommendedAccounts&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webRecurringFilterQuery**](docs/WebScreensApi.md#webrecurringfilterquery) | **POST** /v1/web/screens/recurring-filter-query | Web screen aggregate &#x60;Web_RecurringFilterQuery&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webRecurringPausedBanner**](docs/WebScreensApi.md#webrecurringpausedbanner) | **POST** /v1/web/screens/recurring-paused-banner | Web screen aggregate &#x60;Web_RecurringPausedBanner&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webRemoveEmployeeEntitlements**](docs/WebScreensApi.md#webremoveemployeeentitlements) | **POST** /v1/web/aggregates/remove-employee-entitlements | Web screen aggregate &#x60;Web_RemoveEmployeeEntitlements&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webResetAndSyncAccountMutation**](docs/WebScreensApi.md#webresetandsyncaccountmutation) | **POST** /v1/web/aggregates/reset-and-sync-account-mutation | Web screen aggregate &#x60;Web_ResetAndSyncAccountMutation&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webResetCategorizationMemory**](docs/WebScreensApi.md#webresetcategorizationmemory) | **POST** /v1/web/aggregates/reset-categorization-memory | Web screen aggregate &#x60;Web_ResetCategorizationMemory&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webResetEmployeeAndSubscribe**](docs/WebScreensApi.md#webresetemployeeandsubscribe) | **POST** /v1/web/aggregates/reset-employee-and-subscribe | Web screen aggregate &#x60;Web_ResetEmployeeAndSubscribe&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webResetEmployeeToNoSubscription**](docs/WebScreensApi.md#webresetemployeetonosubscription) | **POST** /v1/web/aggregates/reset-employee-to-no-subscription | Web screen aggregate &#x60;Web_ResetEmployeeToNoSubscription&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webResetHouseholdRecurringMerchantSearch**](docs/WebScreensApi.md#webresethouseholdrecurringmerchantsearch) | **POST** /v1/web/aggregates/reset-household-recurring-merchant-search | Web screen aggregate &#x60;Web_ResetHouseholdRecurringMerchantSearch&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webResetRolloverMutation**](docs/WebScreensApi.md#webresetrollovermutation) | **POST** /v1/web/aggregates/reset-rollover-mutation | Web screen aggregate &#x60;Web_ResetRolloverMutation&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webResetWeeklyRecapMutation**](docs/WebScreensApi.md#webresetweeklyrecapmutation) | **POST** /v1/web/aggregates/reset-weekly-recap-mutation | Web screen aggregate &#x60;Web_ResetWeeklyRecapMutation&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webRestoreCategory**](docs/WebScreensApi.md#webrestorecategory) | **POST** /v1/web/aggregates/restore-category | Web screen aggregate &#x60;Web_RestoreCategory&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webReviewStream**](docs/WebScreensApi.md#webreviewstream) | **POST** /v1/web/aggregates/review-stream | Web screen aggregate &#x60;Web_ReviewStream&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webRevokeConnectedApp**](docs/WebScreensApi.md#webrevokeconnectedapp) | **POST** /v1/web/aggregates/revoke-connected-app | Web screen aggregate &#x60;Web_RevokeConnectedApp&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webRevokeSponsorshipInvite**](docs/WebScreensApi.md#webrevokesponsorshipinvite) | **POST** /v1/web/aggregates/revoke-sponsorship-invite | Web screen aggregate &#x60;Web_RevokeSponsorshipInvite&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webSearchInstitutionsQuery**](docs/WebScreensApi.md#websearchinstitutionsquery) | **POST** /v1/web/screens/search-institutions-query | Web screen aggregate &#x60;Web_SearchInstitutionsQuery&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webSearchMerchants**](docs/WebScreensApi.md#websearchmerchants) | **POST** /v1/web/screens/search-merchants | Web screen aggregate &#x60;Web_SearchMerchants&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webSearchSecurities**](docs/WebScreensApi.md#websearchsecurities) | **POST** /v1/web/screens/search-securities | Web screen aggregate &#x60;Web_SearchSecurities&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webSetEmployeeActiveSubscription**](docs/WebScreensApi.md#websetemployeeactivesubscription) | **POST** /v1/web/aggregates/set-employee-active-subscription | Web screen aggregate &#x60;Web_SetEmployeeActiveSubscription&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webSetEmployeeCancellationDiscountUsed**](docs/WebScreensApi.md#websetemployeecancellationdiscountused) | **POST** /v1/web/aggregates/set-employee-cancellation-discount-used | Web screen aggregate &#x60;Web_SetEmployeeCancellationDiscountUsed&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webSetEmployeeExpiredTrial**](docs/WebScreensApi.md#websetemployeeexpiredtrial) | **POST** /v1/web/aggregates/set-employee-expired-trial | Web screen aggregate &#x60;Web_SetEmployeeExpiredTrial&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webSetEmployeePlusTrialFields**](docs/WebScreensApi.md#websetemployeeplustrialfields) | **POST** /v1/web/aggregates/set-employee-plus-trial-fields | Web screen aggregate &#x60;Web_SetEmployeePlusTrialFields&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webSetEmployeeSubscriptionEnded**](docs/WebScreensApi.md#websetemployeesubscriptionended) | **POST** /v1/web/aggregates/set-employee-subscription-ended | Web screen aggregate &#x60;Web_SetEmployeeSubscriptionEnded&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webSnapshotsForAccountCopyBalancePreview**](docs/WebScreensApi.md#websnapshotsforaccountcopybalancepreview) | **POST** /v1/web/screens/snapshots-for-account-copy-balance-preview | Web screen aggregate &#x60;Web_SnapshotsForAccountCopyBalancePreview&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webStartDownloadScheduleCSession**](docs/WebScreensApi.md#webstartdownloadschedulecsession) | **POST** /v1/web/aggregates/start-download-schedule-c-session | Web screen aggregate &#x60;Web_StartDownloadScheduleCSession&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webSyncEmployeeSubscription**](docs/WebScreensApi.md#websyncemployeesubscription) | **POST** /v1/web/aggregates/sync-employee-subscription | Web screen aggregate &#x60;Web_SyncEmployeeSubscription&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webTargetAmountsGoalsList**](docs/WebScreensApi.md#webtargetamountsgoalslist) | **POST** /v1/web/screens/target-amounts-goals-list | Web screen aggregate &#x60;Web_TargetAmountsGoalsList&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webTestCreditScoreChangedNotification**](docs/WebScreensApi.md#webtestcreditscorechangednotification) | **POST** /v1/web/aggregates/test-credit-score-changed-notification | Web screen aggregate &#x60;Web_TestCreditScoreChangedNotification&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webToggleSupportAccountAccess**](docs/WebScreensApi.md#webtogglesupportaccountaccess) | **POST** /v1/web/aggregates/toggle-support-account-access | Web screen aggregate &#x60;Web_ToggleSupportAccountAccess&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webTransactionDrawerDeleteAttachment**](docs/WebScreensApi.md#webtransactiondrawerdeleteattachment) | **POST** /v1/web/aggregates/transaction-drawer-delete-attachment | Web screen aggregate &#x60;Web_TransactionDrawerDeleteAttachment&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webTransactionsFilterQuery**](docs/WebScreensApi.md#webtransactionsfilterquery) | **POST** /v1/web/screens/transactions-filter-query | Web screen aggregate &#x60;Web_TransactionsFilterQuery&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webTransactionsMessageBlock**](docs/WebScreensApi.md#webtransactionsmessageblock) | **POST** /v1/web/screens/transactions-message-block | Web screen aggregate &#x60;Web_TransactionsMessageBlock&#x60; (query, opaque pass-through)
*WebScreensApi* | [**webUndoSavingsGoalMigration**](docs/WebScreensApi.md#webundosavingsgoalmigration) | **POST** /v1/web/aggregates/undo-savings-goal-migration | Web screen aggregate &#x60;Web_UndoSavingsGoalMigration&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webUnmatchRetailTransaction**](docs/WebScreensApi.md#webunmatchretailtransaction) | **POST** /v1/web/aggregates/unmatch-retail-transaction | Web screen aggregate &#x60;Web_UnmatchRetailTransaction&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webUpdateAccountOrder**](docs/WebScreensApi.md#webupdateaccountorder) | **POST** /v1/web/aggregates/update-account-order | Web screen aggregate &#x60;Web_UpdateAccountOrder&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webUpdateBusinessTrackingSetupIntent**](docs/WebScreensApi.md#webupdatebusinesstrackingsetupintent) | **POST** /v1/web/aggregates/update-business-tracking-setup-intent | Web screen aggregate &#x60;Web_UpdateBusinessTrackingSetupIntent&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webUpdateCategory**](docs/WebScreensApi.md#webupdatecategory) | **POST** /v1/web/aggregates/update-category | Web screen aggregate &#x60;Web_UpdateCategory&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webUpdateCategoryFromBudgetOnboarding**](docs/WebScreensApi.md#webupdatecategoryfrombudgetonboarding) | **POST** /v1/web/aggregates/update-category-from-budget-onboarding | Web screen aggregate &#x60;Web_UpdateCategoryFromBudgetOnboarding&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webUpdateCategoryGroupOrder**](docs/WebScreensApi.md#webupdatecategorygrouporder) | **POST** /v1/web/aggregates/update-category-group-order | Web screen aggregate &#x60;Web_UpdateCategoryGroupOrder&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webUpdateCategoryOrder**](docs/WebScreensApi.md#webupdatecategoryorder) | **POST** /v1/web/aggregates/update-category-order | Web screen aggregate &#x60;Web_UpdateCategoryOrder&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webUpdateCompany**](docs/WebScreensApi.md#webupdatecompany) | **POST** /v1/web/aggregates/update-company | Web screen aggregate &#x60;Web_UpdateCompany&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webUpdateDismissedRetailSyncBanner**](docs/WebScreensApi.md#webupdatedismissedretailsyncbanner) | **POST** /v1/web/aggregates/update-dismissed-retail-sync-banner | Web screen aggregate &#x60;Web_UpdateDismissedRetailSyncBanner&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webUpdateGoalsPriorities**](docs/WebScreensApi.md#webupdategoalspriorities) | **POST** /v1/web/aggregates/update-goals-priorities | Web screen aggregate &#x60;Web_UpdateGoalsPriorities&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webUpdateOrCreateAdvisorStripePaymentMethod**](docs/WebScreensApi.md#webupdateorcreateadvisorstripepaymentmethod) | **POST** /v1/web/aggregates/update-or-create-advisor-stripe-payment-method | Web screen aggregate &#x60;Web_UpdateOrCreateAdvisorStripePaymentMethod&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webUpdateOrCreateStripePaymentMethod**](docs/WebScreensApi.md#webupdateorcreatestripepaymentmethod) | **POST** /v1/web/aggregates/update-or-create-stripe-payment-method | Web screen aggregate &#x60;Web_UpdateOrCreateStripePaymentMethod&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webUpdateRenewalReminder**](docs/WebScreensApi.md#webupdaterenewalreminder) | **POST** /v1/web/aggregates/update-renewal-reminder | Web screen aggregate &#x60;Web_UpdateRenewalReminder&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webUpdateRuleOrderMutation**](docs/WebScreensApi.md#webupdateruleordermutation) | **POST** /v1/web/aggregates/update-rule-order-mutation | Web screen aggregate &#x60;Web_UpdateRuleOrderMutation&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webUpdateSubscriptionSponsor**](docs/WebScreensApi.md#webupdatesubscriptionsponsor) | **POST** /v1/web/aggregates/update-subscription-sponsor | Web screen aggregate &#x60;Web_UpdateSubscriptionSponsor&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webUpdateTransactionOverview**](docs/WebScreensApi.md#webupdatetransactionoverview) | **POST** /v1/web/aggregates/update-transaction-overview | Web screen aggregate &#x60;Web_UpdateTransactionOverview&#x60; (mutation, opaque pass-through)
*WebScreensApi* | [**webUpdateUserFinancialProfile**](docs/WebScreensApi.md#webupdateuserfinancialprofile) | **POST** /v1/web/aggregates/update-user-financial-profile | Web screen aggregate &#x60;Web_UpdateUserFinancialProfile&#x60; (mutation, opaque pass-through)


### Documentation For Models

 - [Account](docs/Account.md)
 - [AccountForFilterRow](docs/AccountForFilterRow.md)
 - [AccountGroup](docs/AccountGroup.md)
 - [AccountGroupOrderEntry](docs/AccountGroupOrderEntry.md)
 - [AccountHistoryResponse](docs/AccountHistoryResponse.md)
 - [AccountHoldingsResponse](docs/AccountHoldingsResponse.md)
 - [AccountSnapshot](docs/AccountSnapshot.md)
 - [AccountSyncStatus](docs/AccountSyncStatus.md)
 - [AccountTypeReference](docs/AccountTypeReference.md)
 - [AggregateSnapshot](docs/AggregateSnapshot.md)
 - [Appearance](docs/Appearance.md)
 - [ArchiveGoalResponse](docs/ArchiveGoalResponse.md)
 - [AttachmentDetail](docs/AttachmentDetail.md)
 - [AuthStatusResponse](docs/AuthStatusResponse.md)
 - [BalanceHistoryStatusResponse](docs/BalanceHistoryStatusResponse.md)
 - [BalanceHistoryUploadResponse](docs/BalanceHistoryUploadResponse.md)
 - [BenchmarkPoint](docs/BenchmarkPoint.md)
 - [BetaFeature](docs/BetaFeature.md)
 - [BudgetMonthCategoryAmounts](docs/BudgetMonthCategoryAmounts.md)
 - [BudgetMonthMonthlyAmount](docs/BudgetMonthMonthlyAmount.md)
 - [BudgetStatus](docs/BudgetStatus.md)
 - [BudgetTimelineMonth](docs/BudgetTimelineMonth.md)
 - [BudgetsResponse](docs/BudgetsResponse.md)
 - [BulkDeleteCategoriesResponse](docs/BulkDeleteCategoriesResponse.md)
 - [BulkDeleteCategoriesResponseData](docs/BulkDeleteCategoriesResponseData.md)
 - [BulkDeleteCategoriesRequest](docs/BulkDeleteCategoriesRequest.md)
 - [BulkDeleteCategoriesResponse](docs/BulkDeleteCategoriesResponse.md)
 - [BulkDeleteFailure](docs/BulkDeleteFailure.md)
 - [BulkDeleteTransactionsResponse](docs/BulkDeleteTransactionsResponse.md)
 - [BulkDeleteTransactionsResponseData](docs/BulkDeleteTransactionsResponseData.md)
 - [BulkDeleteTransactionsRequest](docs/BulkDeleteTransactionsRequest.md)
 - [BulkDeleteTransactionsResponse](docs/BulkDeleteTransactionsResponse.md)
 - [BulkMutationError](docs/BulkMutationError.md)
 - [BulkTaxLotInput](docs/BulkTaxLotInput.md)
 - [BulkTaxLotRowError](docs/BulkTaxLotRowError.md)
 - [BulkTransactionFilters](docs/BulkTransactionFilters.md)
 - [BulkTransactionUpdates](docs/BulkTransactionUpdates.md)
 - [BulkUpdateAccountsResponse](docs/BulkUpdateAccountsResponse.md)
 - [BulkUpdateAccountsResponseData](docs/BulkUpdateAccountsResponseData.md)
 - [BulkUpdateAccountsEntry](docs/BulkUpdateAccountsEntry.md)
 - [BulkUpdateAccountsRequest](docs/BulkUpdateAccountsRequest.md)
 - [BulkUpdateAccountsResponse](docs/BulkUpdateAccountsResponse.md)
 - [BulkUpdateHoldingsResponse](docs/BulkUpdateHoldingsResponse.md)
 - [BulkUpdateHoldingsResponseData](docs/BulkUpdateHoldingsResponseData.md)
 - [BulkUpdateHoldingsEntry](docs/BulkUpdateHoldingsEntry.md)
 - [BulkUpdateHoldingsFailure](docs/BulkUpdateHoldingsFailure.md)
 - [BulkUpdateHoldingsRequest](docs/BulkUpdateHoldingsRequest.md)
 - [BulkUpdateHoldingsResponse](docs/BulkUpdateHoldingsResponse.md)
 - [BulkUpdateTransactionsResponse](docs/BulkUpdateTransactionsResponse.md)
 - [BulkUpdateTransactionsResponseData](docs/BulkUpdateTransactionsResponseData.md)
 - [BulkUpdateTransactionsRequest](docs/BulkUpdateTransactionsRequest.md)
 - [BulkUpdateTransactionsResponse](docs/BulkUpdateTransactionsResponse.md)
 - [CalendarEvent](docs/CalendarEvent.md)
 - [CashflowBreakdownResponse](docs/CashflowBreakdownResponse.md)
 - [CashflowCategoryGroupRef](docs/CashflowCategoryGroupRef.md)
 - [CashflowCategoryGroupRow](docs/CashflowCategoryGroupRow.md)
 - [CashflowCategoryRef](docs/CashflowCategoryRef.md)
 - [CashflowDashboardResponse](docs/CashflowDashboardResponse.md)
 - [CashflowDayPoint](docs/CashflowDayPoint.md)
 - [CashflowEntitiesResponse](docs/CashflowEntitiesResponse.md)
 - [CashflowEntityCategoryRow](docs/CashflowEntityCategoryRow.md)
 - [CashflowFilteredResponse](docs/CashflowFilteredResponse.md)
 - [CashflowMerchantRef](docs/CashflowMerchantRef.md)
 - [CashflowMerchantRow](docs/CashflowMerchantRow.md)
 - [CashflowReport](docs/CashflowReport.md)
 - [CashflowReportMonth](docs/CashflowReportMonth.md)
 - [CashflowResponse](docs/CashflowResponse.md)
 - [CashflowSummary](docs/CashflowSummary.md)
 - [CashflowTimeframeBucket](docs/CashflowTimeframeBucket.md)
 - [CashflowTimeframeResponse](docs/CashflowTimeframeResponse.md)
 - [Category](docs/Category.md)
 - [CategoryDeletionInfo](docs/CategoryDeletionInfo.md)
 - [CategoryEditFields](docs/CategoryEditFields.md)
 - [CategoryGroup](docs/CategoryGroup.md)
 - [CategoryGroupBudgetVariabilityRef](docs/CategoryGroupBudgetVariabilityRef.md)
 - [CategoryGroupChildCategory](docs/CategoryGroupChildCategory.md)
 - [CategoryGroupDetails](docs/CategoryGroupDetails.md)
 - [CategoryGroupRef](docs/CategoryGroupRef.md)
 - [CategoryGroupRolloverPeriod](docs/CategoryGroupRolloverPeriod.md)
 - [CategoryReport](docs/CategoryReport.md)
 - [CategoryReportMonth](docs/CategoryReportMonth.md)
 - [ChannelNotificationPrefs](docs/ChannelNotificationPrefs.md)
 - [ContributeToGoalResponse](docs/ContributeToGoalResponse.md)
 - [ContributeToGoalResponseData](docs/ContributeToGoalResponseData.md)
 - [ContributeToGoalResponseDataGoalEvent](docs/ContributeToGoalResponseDataGoalEvent.md)
 - [ContributeToGoalResponseDataGoalEventAccount](docs/ContributeToGoalResponseDataGoalEventAccount.md)
 - [ContributeToGoalResponseDataGoalEventGoal](docs/ContributeToGoalResponseDataGoalEventGoal.md)
 - [ContributeToGoalRequest](docs/ContributeToGoalRequest.md)
 - [ContributeToGoalResponse](docs/ContributeToGoalResponse.md)
 - [CookiePreferences](docs/CookiePreferences.md)
 - [CostBasisLot](docs/CostBasisLot.md)
 - [CreateCategoryResponse](docs/CreateCategoryResponse.md)
 - [CreateCategoryResponseData](docs/CreateCategoryResponseData.md)
 - [CreateCategoryGroupResponse](docs/CreateCategoryGroupResponse.md)
 - [CreateCategoryGroupResponseData](docs/CreateCategoryGroupResponseData.md)
 - [CreateCategoryGroupRequest](docs/CreateCategoryGroupRequest.md)
 - [CreateCategoryGroupResponse](docs/CreateCategoryGroupResponse.md)
 - [CreateCategoryRequest](docs/CreateCategoryRequest.md)
 - [CreateCategoryResponse](docs/CreateCategoryResponse.md)
 - [CreateGoalResponse](docs/CreateGoalResponse.md)
 - [CreateGoalResponseData](docs/CreateGoalResponseData.md)
 - [CreateGoalRequest](docs/CreateGoalRequest.md)
 - [CreateGoalResponse](docs/CreateGoalResponse.md)
 - [CreateManualAccountResponse](docs/CreateManualAccountResponse.md)
 - [CreateManualAccountResponseData](docs/CreateManualAccountResponseData.md)
 - [CreateManualAccountRequest](docs/CreateManualAccountRequest.md)
 - [CreateManualAccountResponse](docs/CreateManualAccountResponse.md)
 - [CreateManualHoldingResponse](docs/CreateManualHoldingResponse.md)
 - [CreateManualHoldingResponseData](docs/CreateManualHoldingResponseData.md)
 - [CreateManualHoldingRequest](docs/CreateManualHoldingRequest.md)
 - [CreateManualHoldingResponse](docs/CreateManualHoldingResponse.md)
 - [CreateManualInvestmentsAccountRequest](docs/CreateManualInvestmentsAccountRequest.md)
 - [CreateManualInvestmentsAccountResponse](docs/CreateManualInvestmentsAccountResponse.md)
 - [CreateManualTaxLotResponse](docs/CreateManualTaxLotResponse.md)
 - [CreateManualTaxLotResponseData](docs/CreateManualTaxLotResponseData.md)
 - [CreateManualTaxLotRequest](docs/CreateManualTaxLotRequest.md)
 - [CreateManualTaxLotResponse](docs/CreateManualTaxLotResponse.md)
 - [CreateManualTaxLotsBulkResponse](docs/CreateManualTaxLotsBulkResponse.md)
 - [CreateManualTaxLotsBulkResponseData](docs/CreateManualTaxLotsBulkResponseData.md)
 - [CreateManualTaxLotsBulkRequest](docs/CreateManualTaxLotsBulkRequest.md)
 - [CreateManualTaxLotsBulkResponse](docs/CreateManualTaxLotsBulkResponse.md)
 - [CreatePaycheckResponse](docs/CreatePaycheckResponse.md)
 - [CreatePaycheckResponseData](docs/CreatePaycheckResponseData.md)
 - [CreatePaycheckEmployerResponse](docs/CreatePaycheckEmployerResponse.md)
 - [CreatePaycheckEmployerResponseData](docs/CreatePaycheckEmployerResponseData.md)
 - [CreatePaycheckEmployerRequest](docs/CreatePaycheckEmployerRequest.md)
 - [CreatePaycheckEmployerResponse](docs/CreatePaycheckEmployerResponse.md)
 - [CreatePaycheckRequest](docs/CreatePaycheckRequest.md)
 - [CreatePaycheckResponse](docs/CreatePaycheckResponse.md)
 - [CreateTagResponse](docs/CreateTagResponse.md)
 - [CreateTagResponseData](docs/CreateTagResponseData.md)
 - [CreateTagRequest](docs/CreateTagRequest.md)
 - [CreateTransactionResponse](docs/CreateTransactionResponse.md)
 - [CreateTransactionResponseData](docs/CreateTransactionResponseData.md)
 - [CreateTransactionRequest](docs/CreateTransactionRequest.md)
 - [CreateTransactionResponse](docs/CreateTransactionResponse.md)
 - [CreateTransactionRuleResponse](docs/CreateTransactionRuleResponse.md)
 - [CreateTransactionRuleResponseData](docs/CreateTransactionRuleResponseData.md)
 - [CreateTransactionRuleRequest](docs/CreateTransactionRuleRequest.md)
 - [CreateTransactionRuleResponse](docs/CreateTransactionRuleResponse.md)
 - [CreateTransactionTagResponse](docs/CreateTransactionTagResponse.md)
 - [CredentialInstitutionRow](docs/CredentialInstitutionRow.md)
 - [CreditHistoryResponse](docs/CreditHistoryResponse.md)
 - [CreditScoreSnapshot](docs/CreditScoreSnapshot.md)
 - [CurrencyPreferences](docs/CurrencyPreferences.md)
 - [DashboardRecurringItem](docs/DashboardRecurringItem.md)
 - [DashboardTransactionRow](docs/DashboardTransactionRow.md)
 - [DeleteAccountResponse](docs/DeleteAccountResponse.md)
 - [DeleteAccountResponseData](docs/DeleteAccountResponseData.md)
 - [DeleteAccountResponse](docs/DeleteAccountResponse.md)
 - [DeleteCategoryGroupResponse](docs/DeleteCategoryGroupResponse.md)
 - [DeleteCategoryResponse](docs/DeleteCategoryResponse.md)
 - [DeleteGoalResponse](docs/DeleteGoalResponse.md)
 - [DeleteHoldingResponse](docs/DeleteHoldingResponse.md)
 - [DeleteInstitutionResponse](docs/DeleteInstitutionResponse.md)
 - [DeleteInstitutionResponseData](docs/DeleteInstitutionResponseData.md)
 - [DeleteInstitutionResponse](docs/DeleteInstitutionResponse.md)
 - [DeleteMerchantResponse](docs/DeleteMerchantResponse.md)
 - [DeleteMerchantResponseData](docs/DeleteMerchantResponseData.md)
 - [DeleteMerchantResponse](docs/DeleteMerchantResponse.md)
 - [DeletePaycheckEmployerResponse](docs/DeletePaycheckEmployerResponse.md)
 - [DeletePaycheckResponse](docs/DeletePaycheckResponse.md)
 - [DeleteTagResponse](docs/DeleteTagResponse.md)
 - [DeleteTagResponseData](docs/DeleteTagResponseData.md)
 - [DeleteTagResponse](docs/DeleteTagResponse.md)
 - [DeleteTaxLotResponse](docs/DeleteTaxLotResponse.md)
 - [DeleteTaxLotResponseData](docs/DeleteTaxLotResponseData.md)
 - [DeleteTaxLotResponse](docs/DeleteTaxLotResponse.md)
 - [DeleteTaxLotsBulkResponse](docs/DeleteTaxLotsBulkResponse.md)
 - [DeleteTaxLotsBulkResponseData](docs/DeleteTaxLotsBulkResponseData.md)
 - [DeleteTaxLotsBulkRequest](docs/DeleteTaxLotsBulkRequest.md)
 - [DeleteTaxLotsBulkResponse](docs/DeleteTaxLotsBulkResponse.md)
 - [DeleteTransactionResponse](docs/DeleteTransactionResponse.md)
 - [DeleteTransactionRuleResponse](docs/DeleteTransactionRuleResponse.md)
 - [DismissNotificationResponse](docs/DismissNotificationResponse.md)
 - [DismissNotificationResponseData](docs/DismissNotificationResponseData.md)
 - [DuplicateGroupKey](docs/DuplicateGroupKey.md)
 - [ErrorResponse](docs/ErrorResponse.md)
 - [ExpenseByCategoryRow](docs/ExpenseByCategoryRow.md)
 - [ExpenseByMerchantRow](docs/ExpenseByMerchantRow.md)
 - [ExpenseByTagRow](docs/ExpenseByTagRow.md)
 - [ExplainTransactionResponse](docs/ExplainTransactionResponse.md)
 - [ExplainTransactionResponseData](docs/ExplainTransactionResponseData.md)
 - [ExplainTransactionResponse](docs/ExplainTransactionResponse.md)
 - [FeatureAreaResponse](docs/FeatureAreaResponse.md)
 - [FeatureFlag](docs/FeatureFlag.md)
 - [FinancialInsight](docs/FinancialInsight.md)
 - [FinancialInsightDetail](docs/FinancialInsightDetail.md)
 - [FinancialInsightPlaybook](docs/FinancialInsightPlaybook.md)
 - [FinancialInsightRelatedMerchant](docs/FinancialInsightRelatedMerchant.md)
 - [FinancialInsightRun](docs/FinancialInsightRun.md)
 - [FinancialInsightSummary](docs/FinancialInsightSummary.md)
 - [FiscalYearPreferences](docs/FiscalYearPreferences.md)
 - [FlexExpenseRolloverPeriod](docs/FlexExpenseRolloverPeriod.md)
 - [GetAccountBalanceAtDateResponse](docs/GetAccountBalanceAtDateResponse.md)
 - [GetAccountBalanceAtDateResponseData](docs/GetAccountBalanceAtDateResponseData.md)
 - [GetAccountBalanceAtDateResponse](docs/GetAccountBalanceAtDateResponse.md)
 - [GetAccountGroupsResponse](docs/GetAccountGroupsResponse.md)
 - [GetAccountGroupsResponseData](docs/GetAccountGroupsResponseData.md)
 - [GetAccountGroupsResponse](docs/GetAccountGroupsResponse.md)
 - [GetAccountHistoryResponse](docs/GetAccountHistoryResponse.md)
 - [GetAccountHistoryResponseData](docs/GetAccountHistoryResponseData.md)
 - [GetAccountHoldingsResponse](docs/GetAccountHoldingsResponse.md)
 - [GetAccountHoldingsResponseData](docs/GetAccountHoldingsResponseData.md)
 - [GetAccountTypeOptionsResponse](docs/GetAccountTypeOptionsResponse.md)
 - [GetAccountTypeOptionsResponse](docs/GetAccountTypeOptionsResponse.md)
 - [GetAccountTypeOptionsResponseData](docs/GetAccountTypeOptionsResponseData.md)
 - [GetAccountsForTransactionFilterResponse](docs/GetAccountsForTransactionFilterResponse.md)
 - [GetAccountsForTransactionFilterResponseData](docs/GetAccountsForTransactionFilterResponseData.md)
 - [GetAccountsForTransactionsResponse](docs/GetAccountsForTransactionsResponse.md)
 - [GetAppVersionResponse](docs/GetAppVersionResponse.md)
 - [GetAppVersionResponseData](docs/GetAppVersionResponseData.md)
 - [GetAppVersionResponse](docs/GetAppVersionResponse.md)
 - [GetAppearanceResponse](docs/GetAppearanceResponse.md)
 - [GetAppearanceResponseData](docs/GetAppearanceResponseData.md)
 - [GetAppearanceResponse](docs/GetAppearanceResponse.md)
 - [GetAttachmentResponse](docs/GetAttachmentResponse.md)
 - [GetAttachmentResponseData](docs/GetAttachmentResponseData.md)
 - [GetAttachmentResponse](docs/GetAttachmentResponse.md)
 - [GetAuthStatusResponse](docs/GetAuthStatusResponse.md)
 - [GetBalanceHistoryStatusResponse](docs/GetBalanceHistoryStatusResponse.md)
 - [GetBalanceHistoryStatusResponseData](docs/GetBalanceHistoryStatusResponseData.md)
 - [GetBetaFeaturesResponse](docs/GetBetaFeaturesResponse.md)
 - [GetBetaFeaturesResponseData](docs/GetBetaFeaturesResponseData.md)
 - [GetBetaFeaturesResponse](docs/GetBetaFeaturesResponse.md)
 - [GetBudgetMonthResponse](docs/GetBudgetMonthResponse.md)
 - [GetBudgetMonthResponseData](docs/GetBudgetMonthResponseData.md)
 - [GetBudgetMonthResponse](docs/GetBudgetMonthResponse.md)
 - [GetBudgetStatusResponse](docs/GetBudgetStatusResponse.md)
 - [GetBudgetStatusResponseData](docs/GetBudgetStatusResponseData.md)
 - [GetBudgetStatusResponse](docs/GetBudgetStatusResponse.md)
 - [GetBudgetTimelineResponse](docs/GetBudgetTimelineResponse.md)
 - [GetBudgetTimelineResponseData](docs/GetBudgetTimelineResponseData.md)
 - [GetBudgetTimelineResponse](docs/GetBudgetTimelineResponse.md)
 - [GetBudgetsResponse](docs/GetBudgetsResponse.md)
 - [GetBudgetsResponseData](docs/GetBudgetsResponseData.md)
 - [GetCalendarEventsResponse](docs/GetCalendarEventsResponse.md)
 - [GetCalendarEventsResponseData](docs/GetCalendarEventsResponseData.md)
 - [GetCalendarEventsResponse](docs/GetCalendarEventsResponse.md)
 - [GetCashflowResponse](docs/GetCashflowResponse.md)
 - [GetCashflowResponseData](docs/GetCashflowResponseData.md)
 - [GetCashflowBreakdownResponse](docs/GetCashflowBreakdownResponse.md)
 - [GetCashflowBreakdownResponseData](docs/GetCashflowBreakdownResponseData.md)
 - [GetCashflowDashboardResponse](docs/GetCashflowDashboardResponse.md)
 - [GetCashflowDashboardResponseData](docs/GetCashflowDashboardResponseData.md)
 - [GetCashflowEntitiesResponse](docs/GetCashflowEntitiesResponse.md)
 - [GetCashflowEntitiesResponseData](docs/GetCashflowEntitiesResponseData.md)
 - [GetCashflowFilteredResponse](docs/GetCashflowFilteredResponse.md)
 - [GetCashflowFilteredResponseData](docs/GetCashflowFilteredResponseData.md)
 - [GetCashflowReportResponse](docs/GetCashflowReportResponse.md)
 - [GetCashflowReportResponseData](docs/GetCashflowReportResponseData.md)
 - [GetCashflowReportResponse](docs/GetCashflowReportResponse.md)
 - [GetCashflowTimeframeResponse](docs/GetCashflowTimeframeResponse.md)
 - [GetCashflowTimeframeResponseData](docs/GetCashflowTimeframeResponseData.md)
 - [GetCategoryDeletionInfoResponse](docs/GetCategoryDeletionInfoResponse.md)
 - [GetCategoryDeletionInfoResponseData](docs/GetCategoryDeletionInfoResponseData.md)
 - [GetCategoryDeletionInfoResponse](docs/GetCategoryDeletionInfoResponse.md)
 - [GetCategoryEditResponse](docs/GetCategoryEditResponse.md)
 - [GetCategoryEditResponseData](docs/GetCategoryEditResponseData.md)
 - [GetCategoryEditResponse](docs/GetCategoryEditResponse.md)
 - [GetCategoryGroupDetailsResponse](docs/GetCategoryGroupDetailsResponse.md)
 - [GetCategoryGroupDetailsResponseData](docs/GetCategoryGroupDetailsResponseData.md)
 - [GetCategoryGroupDetailsResponse](docs/GetCategoryGroupDetailsResponse.md)
 - [GetCategoryReportResponse](docs/GetCategoryReportResponse.md)
 - [GetCategoryReportResponseData](docs/GetCategoryReportResponseData.md)
 - [GetCategoryReportResponse](docs/GetCategoryReportResponse.md)
 - [GetChannelNotificationPrefsResponse](docs/GetChannelNotificationPrefsResponse.md)
 - [GetCookiePreferencesResponse](docs/GetCookiePreferencesResponse.md)
 - [GetCookiePreferencesResponseData](docs/GetCookiePreferencesResponseData.md)
 - [GetCookiePreferencesResponse](docs/GetCookiePreferencesResponse.md)
 - [GetCredentialInstitutionsResponse](docs/GetCredentialInstitutionsResponse.md)
 - [GetCredentialInstitutionsResponseData](docs/GetCredentialInstitutionsResponseData.md)
 - [GetCredentialInstitutionsResponse](docs/GetCredentialInstitutionsResponse.md)
 - [GetCreditHistoryResponse](docs/GetCreditHistoryResponse.md)
 - [GetCreditHistoryResponseData](docs/GetCreditHistoryResponseData.md)
 - [GetCurrencyResponse](docs/GetCurrencyResponse.md)
 - [GetCurrencyResponseData](docs/GetCurrencyResponseData.md)
 - [GetCurrencyResponse](docs/GetCurrencyResponse.md)
 - [GetDownloadTransactionsSessionResponse](docs/GetDownloadTransactionsSessionResponse.md)
 - [GetDownloadTransactionsSessionResponseData](docs/GetDownloadTransactionsSessionResponseData.md)
 - [GetEmailNotificationPrefsResponse](docs/GetEmailNotificationPrefsResponse.md)
 - [GetEmailNotificationPrefsResponseData](docs/GetEmailNotificationPrefsResponseData.md)
 - [GetEntitlementsResponse](docs/GetEntitlementsResponse.md)
 - [GetEntitlementsResponseData](docs/GetEntitlementsResponseData.md)
 - [GetExpenseByCategoryResponse](docs/GetExpenseByCategoryResponse.md)
 - [GetExpenseByCategoryResponseData](docs/GetExpenseByCategoryResponseData.md)
 - [GetExpenseByCategoryResponse](docs/GetExpenseByCategoryResponse.md)
 - [GetExpenseByMerchantResponse](docs/GetExpenseByMerchantResponse.md)
 - [GetExpenseByMerchantResponseData](docs/GetExpenseByMerchantResponseData.md)
 - [GetExpenseByMerchantResponse](docs/GetExpenseByMerchantResponse.md)
 - [GetExpenseByTagResponse](docs/GetExpenseByTagResponse.md)
 - [GetExpenseByTagResponseData](docs/GetExpenseByTagResponseData.md)
 - [GetExpenseByTagResponse](docs/GetExpenseByTagResponse.md)
 - [GetFeatureFlagsResponse](docs/GetFeatureFlagsResponse.md)
 - [GetFeatureFlagsResponseData](docs/GetFeatureFlagsResponseData.md)
 - [GetFeatureFlagsResponse](docs/GetFeatureFlagsResponse.md)
 - [GetFinancialInsightResponse](docs/GetFinancialInsightResponse.md)
 - [GetFinancialInsightResponseData](docs/GetFinancialInsightResponseData.md)
 - [GetFinancialInsightResponse](docs/GetFinancialInsightResponse.md)
 - [GetFiscalYearResponse](docs/GetFiscalYearResponse.md)
 - [GetFiscalYearResponseData](docs/GetFiscalYearResponseData.md)
 - [GetFiscalYearResponse](docs/GetFiscalYearResponse.md)
 - [GetGoalContributionHistoryResponse](docs/GetGoalContributionHistoryResponse.md)
 - [GetGoalContributionHistoryResponseData](docs/GetGoalContributionHistoryResponseData.md)
 - [GetGoalContributionHistoryResponse](docs/GetGoalContributionHistoryResponse.md)
 - [GetGoalProjectionResponse](docs/GetGoalProjectionResponse.md)
 - [GetGoalProjectionResponseData](docs/GetGoalProjectionResponseData.md)
 - [GetGoalProjectionResponse](docs/GetGoalProjectionResponse.md)
 - [GetGoalsCurrentMonthTotalsResponse](docs/GetGoalsCurrentMonthTotalsResponse.md)
 - [GetGoalsCurrentMonthTotalsResponseData](docs/GetGoalsCurrentMonthTotalsResponseData.md)
 - [GetGoalsCurrentMonthTotalsResponse](docs/GetGoalsCurrentMonthTotalsResponse.md)
 - [GetHealthResponse](docs/GetHealthResponse.md)
 - [GetHoldingHistoryResponse](docs/GetHoldingHistoryResponse.md)
 - [GetHoldingHistoryResponseData](docs/GetHoldingHistoryResponseData.md)
 - [GetHoldingHistoryResponse](docs/GetHoldingHistoryResponse.md)
 - [GetHoldingTransactionsResponse](docs/GetHoldingTransactionsResponse.md)
 - [GetHoldingTransactionsResponseData](docs/GetHoldingTransactionsResponseData.md)
 - [GetHoldingTransactionsResponse](docs/GetHoldingTransactionsResponse.md)
 - [GetHouseholdMembersResponse](docs/GetHouseholdMembersResponse.md)
 - [GetHouseholdMembersResponseData](docs/GetHouseholdMembersResponseData.md)
 - [GetHouseholdMembersResponseDataMembersInner](docs/GetHouseholdMembersResponseDataMembersInner.md)
 - [GetHouseholdPreferencesResponse](docs/GetHouseholdPreferencesResponse.md)
 - [GetHouseholdPreferencesResponseData](docs/GetHouseholdPreferencesResponseData.md)
 - [GetIncomeReportResponse](docs/GetIncomeReportResponse.md)
 - [GetIncomeReportResponseData](docs/GetIncomeReportResponseData.md)
 - [GetIncomeReportResponse](docs/GetIncomeReportResponse.md)
 - [GetIncomeVsExpenseYoyResponse](docs/GetIncomeVsExpenseYoyResponse.md)
 - [GetIncomeVsExpenseYoyResponseData](docs/GetIncomeVsExpenseYoyResponseData.md)
 - [GetIncomeVsExpenseYoyResponse](docs/GetIncomeVsExpenseYoyResponse.md)
 - [GetInstitutionByPlaidIdResponse](docs/GetInstitutionByPlaidIdResponse.md)
 - [GetInstitutionByPlaidIdResponseData](docs/GetInstitutionByPlaidIdResponseData.md)
 - [GetInstitutionByPlaidResponse](docs/GetInstitutionByPlaidResponse.md)
 - [GetInstitutionsResponse](docs/GetInstitutionsResponse.md)
 - [GetInstitutionsResponseData](docs/GetInstitutionsResponseData.md)
 - [GetIntegrationStatusResponse](docs/GetIntegrationStatusResponse.md)
 - [GetIntegrationStatusResponseData](docs/GetIntegrationStatusResponseData.md)
 - [GetIntegrationStatusResponse](docs/GetIntegrationStatusResponse.md)
 - [GetLatestFinancialInsightRunResponse](docs/GetLatestFinancialInsightRunResponse.md)
 - [GetLatestInsightRunResponse](docs/GetLatestInsightRunResponse.md)
 - [GetLatestInsightRunResponseData](docs/GetLatestInsightRunResponseData.md)
 - [GetLatestRefreshOperationResponse](docs/GetLatestRefreshOperationResponse.md)
 - [GetLatestRefreshOperationResponseData](docs/GetLatestRefreshOperationResponseData.md)
 - [GetLookupResponse](docs/GetLookupResponse.md)
 - [GetLookupResponseData](docs/GetLookupResponseData.md)
 - [GetLookupResponse](docs/GetLookupResponse.md)
 - [GetMeResponse](docs/GetMeResponse.md)
 - [GetMeResponseData](docs/GetMeResponseData.md)
 - [GetMerchantResponse](docs/GetMerchantResponse.md)
 - [GetMerchantResponseData](docs/GetMerchantResponseData.md)
 - [GetMerchantResponse](docs/GetMerchantResponse.md)
 - [GetMerchantStatsResponse](docs/GetMerchantStatsResponse.md)
 - [GetMerchantStatsResponseData](docs/GetMerchantStatsResponseData.md)
 - [GetMerchantStatsResponse](docs/GetMerchantStatsResponse.md)
 - [GetMerchantTransactionsResponse](docs/GetMerchantTransactionsResponse.md)
 - [GetMerchantTransactionsResponseData](docs/GetMerchantTransactionsResponseData.md)
 - [GetMerchantTransactionsResponse](docs/GetMerchantTransactionsResponse.md)
 - [GetMonthlyReportSummaryResponse](docs/GetMonthlyReportSummaryResponse.md)
 - [GetMonthlyReportSummaryResponseData](docs/GetMonthlyReportSummaryResponseData.md)
 - [GetMonthlyReportSummaryResponse](docs/GetMonthlyReportSummaryResponse.md)
 - [GetMyHouseholdResponse](docs/GetMyHouseholdResponse.md)
 - [GetMyHouseholdResponseData](docs/GetMyHouseholdResponseData.md)
 - [GetNetWorthReportResponse](docs/GetNetWorthReportResponse.md)
 - [GetNetWorthReportResponseData](docs/GetNetWorthReportResponseData.md)
 - [GetNetWorthReportResponse](docs/GetNetWorthReportResponse.md)
 - [GetNetworthResponse](docs/GetNetworthResponse.md)
 - [GetNetworthResponseData](docs/GetNetworthResponseData.md)
 - [GetNetworthByTypeResponse](docs/GetNetworthByTypeResponse.md)
 - [GetNetworthByTypeResponseData](docs/GetNetworthByTypeResponseData.md)
 - [GetNetworthRecentResponse](docs/GetNetworthRecentResponse.md)
 - [GetNetworthRecentResponseData](docs/GetNetworthRecentResponseData.md)
 - [GetNotificationPreferencesResponse](docs/GetNotificationPreferencesResponse.md)
 - [GetNotificationPreferencesResponseData](docs/GetNotificationPreferencesResponseData.md)
 - [GetNotificationPreferencesResponse](docs/GetNotificationPreferencesResponse.md)
 - [GetNotificationsResponse](docs/GetNotificationsResponse.md)
 - [GetNotificationsResponseData](docs/GetNotificationsResponseData.md)
 - [GetNotificationsResponseDataEdgesInner](docs/GetNotificationsResponseDataEdgesInner.md)
 - [GetPaycheckResponse](docs/GetPaycheckResponse.md)
 - [GetPaychecksSummaryResponse](docs/GetPaychecksSummaryResponse.md)
 - [GetPaychecksSummaryResponseData](docs/GetPaychecksSummaryResponseData.md)
 - [GetPaychecksSummaryResponse](docs/GetPaychecksSummaryResponse.md)
 - [GetPlatformConfigResponse](docs/GetPlatformConfigResponse.md)
 - [GetPlatformConfigResponseData](docs/GetPlatformConfigResponseData.md)
 - [GetPlatformConfigResponse](docs/GetPlatformConfigResponse.md)
 - [GetPlusTierAccessResponse](docs/GetPlusTierAccessResponse.md)
 - [GetPlusTierAccessResponseData](docs/GetPlusTierAccessResponseData.md)
 - [GetPortfolioAllocationResponse](docs/GetPortfolioAllocationResponse.md)
 - [GetPortfolioAllocationResponseData](docs/GetPortfolioAllocationResponseData.md)
 - [GetPortfolioAllocationByHoldingsResponse](docs/GetPortfolioAllocationByHoldingsResponse.md)
 - [GetPortfolioAllocationByHoldingsResponseData](docs/GetPortfolioAllocationByHoldingsResponseData.md)
 - [GetPortfolioAllocationHoldingsDetailResponse](docs/GetPortfolioAllocationHoldingsDetailResponse.md)
 - [GetPortfolioAllocationHoldingsDetailResponseData](docs/GetPortfolioAllocationHoldingsDetailResponseData.md)
 - [GetRecurringDashboardResponse](docs/GetRecurringDashboardResponse.md)
 - [GetRecurringDashboardResponseData](docs/GetRecurringDashboardResponseData.md)
 - [GetRecurringDashboardResponse](docs/GetRecurringDashboardResponse.md)
 - [GetRecurringForecastResponse](docs/GetRecurringForecastResponse.md)
 - [GetRecurringForecastResponseData](docs/GetRecurringForecastResponseData.md)
 - [GetRecurringForecastResponse](docs/GetRecurringForecastResponse.md)
 - [GetRefreshStatusResponse](docs/GetRefreshStatusResponse.md)
 - [GetRefreshStatusResponseData](docs/GetRefreshStatusResponseData.md)
 - [GetReviewSummaryByUserResponse](docs/GetReviewSummaryByUserResponse.md)
 - [GetReviewSummaryByUserResponseData](docs/GetReviewSummaryByUserResponseData.md)
 - [GetSavingsRateReportResponse](docs/GetSavingsRateReportResponse.md)
 - [GetSavingsRateReportResponseData](docs/GetSavingsRateReportResponseData.md)
 - [GetSavingsRateReportResponse](docs/GetSavingsRateReportResponse.md)
 - [GetSavingsRateTrendsResponse](docs/GetSavingsRateTrendsResponse.md)
 - [GetSavingsRateTrendsResponseData](docs/GetSavingsRateTrendsResponseData.md)
 - [GetSavingsRateTrendsResponse](docs/GetSavingsRateTrendsResponse.md)
 - [GetSecurityDetailsResponse](docs/GetSecurityDetailsResponse.md)
 - [GetSecurityDetailsResponseData](docs/GetSecurityDetailsResponseData.md)
 - [GetSecurityDetailsResponse](docs/GetSecurityDetailsResponse.md)
 - [GetSecurityDividendsResponse](docs/GetSecurityDividendsResponse.md)
 - [GetSecurityDividendsResponseData](docs/GetSecurityDividendsResponseData.md)
 - [GetSecurityDividendsResponse](docs/GetSecurityDividendsResponse.md)
 - [GetSecurityHistoricalPerformanceResponse](docs/GetSecurityHistoricalPerformanceResponse.md)
 - [GetSecurityHistoricalPerformanceResponseData](docs/GetSecurityHistoricalPerformanceResponseData.md)
 - [GetSpendingDashboardResponse](docs/GetSpendingDashboardResponse.md)
 - [GetSpendingDashboardResponseData](docs/GetSpendingDashboardResponseData.md)
 - [GetSpendingDashboardResponse](docs/GetSpendingDashboardResponse.md)
 - [GetSpendingReportResponse](docs/GetSpendingReportResponse.md)
 - [GetSpendingReportResponseData](docs/GetSpendingReportResponseData.md)
 - [GetSpendingReportResponse](docs/GetSpendingReportResponse.md)
 - [GetSpendingTrendsResponse](docs/GetSpendingTrendsResponse.md)
 - [GetSpendingTrendsResponseData](docs/GetSpendingTrendsResponseData.md)
 - [GetSpendingTrendsResponse](docs/GetSpendingTrendsResponse.md)
 - [GetSubscriptionResponse](docs/GetSubscriptionResponse.md)
 - [GetSubscriptionDetailsResponse](docs/GetSubscriptionDetailsResponse.md)
 - [GetSubscriptionDetailsResponseData](docs/GetSubscriptionDetailsResponseData.md)
 - [GetSubscriptionDetailsResponse](docs/GetSubscriptionDetailsResponse.md)
 - [GetSubscriptionInvoicesResponse](docs/GetSubscriptionInvoicesResponse.md)
 - [GetSubscriptionInvoicesResponseData](docs/GetSubscriptionInvoicesResponseData.md)
 - [GetSubscriptionInvoicesResponse](docs/GetSubscriptionInvoicesResponse.md)
 - [GetSubscriptionReceiptsResponse](docs/GetSubscriptionReceiptsResponse.md)
 - [GetSubscriptionReceiptsResponseData](docs/GetSubscriptionReceiptsResponseData.md)
 - [GetSubscriptionReceiptsResponse](docs/GetSubscriptionReceiptsResponse.md)
 - [GetSubscriptionResponse](docs/GetSubscriptionResponse.md)
 - [GetTagReportResponse](docs/GetTagReportResponse.md)
 - [GetTagReportResponseData](docs/GetTagReportResponseData.md)
 - [GetTagReportResponse](docs/GetTagReportResponse.md)
 - [GetTaxBracketEstimatesResponse](docs/GetTaxBracketEstimatesResponse.md)
 - [GetTaxBracketEstimatesResponseData](docs/GetTaxBracketEstimatesResponseData.md)
 - [GetTaxBracketEstimatesResponse](docs/GetTaxBracketEstimatesResponse.md)
 - [GetTaxCategoriesResponse](docs/GetTaxCategoriesResponse.md)
 - [GetTaxCategoriesResponseData](docs/GetTaxCategoriesResponseData.md)
 - [GetTaxCategoriesResponse](docs/GetTaxCategoriesResponse.md)
 - [GetTaxCategoryAggregatesResponse](docs/GetTaxCategoryAggregatesResponse.md)
 - [GetTaxCategoryAggregatesResponseData](docs/GetTaxCategoryAggregatesResponseData.md)
 - [GetTaxCategoryAggregatesResponse](docs/GetTaxCategoryAggregatesResponse.md)
 - [GetTaxLotPerformanceResponse](docs/GetTaxLotPerformanceResponse.md)
 - [GetTaxLotPerformanceResponseData](docs/GetTaxLotPerformanceResponseData.md)
 - [GetTaxLotPerformanceResponse](docs/GetTaxLotPerformanceResponse.md)
 - [GetTaxScheduleCategoryMappingsResponse](docs/GetTaxScheduleCategoryMappingsResponse.md)
 - [GetTaxScheduleCategoryMappingsResponseData](docs/GetTaxScheduleCategoryMappingsResponseData.md)
 - [GetTaxScheduleCategoryMappingsResponse](docs/GetTaxScheduleCategoryMappingsResponse.md)
 - [GetTaxYearOverviewResponse](docs/GetTaxYearOverviewResponse.md)
 - [GetTaxYearOverviewResponseData](docs/GetTaxYearOverviewResponseData.md)
 - [GetTaxYearOverviewResponse](docs/GetTaxYearOverviewResponse.md)
 - [GetTopInstitutionGroupsResponse](docs/GetTopInstitutionGroupsResponse.md)
 - [GetTopInstitutionGroupsResponseData](docs/GetTopInstitutionGroupsResponseData.md)
 - [GetTopInstitutionGroupsResponse](docs/GetTopInstitutionGroupsResponse.md)
 - [GetTransactionAuditLogResponse](docs/GetTransactionAuditLogResponse.md)
 - [GetTransactionAuditLogResponseData](docs/GetTransactionAuditLogResponseData.md)
 - [GetTransactionAuditLogResponse](docs/GetTransactionAuditLogResponse.md)
 - [GetTransactionDetailResponse](docs/GetTransactionDetailResponse.md)
 - [GetTransactionDetailResponseData](docs/GetTransactionDetailResponseData.md)
 - [GetTransactionNotesResponse](docs/GetTransactionNotesResponse.md)
 - [GetTransactionNotesResponseData](docs/GetTransactionNotesResponseData.md)
 - [GetTransactionNotesResponse](docs/GetTransactionNotesResponse.md)
 - [GetTransactionSplitTemplatesResponse](docs/GetTransactionSplitTemplatesResponse.md)
 - [GetTransactionSplitTemplatesResponseData](docs/GetTransactionSplitTemplatesResponseData.md)
 - [GetTransactionSplitTemplatesResponse](docs/GetTransactionSplitTemplatesResponse.md)
 - [GetTransactionSplitsResponse](docs/GetTransactionSplitsResponse.md)
 - [GetTransactionSplitsResponseData](docs/GetTransactionSplitsResponseData.md)
 - [GetTransactionsDashboardResponse](docs/GetTransactionsDashboardResponse.md)
 - [GetTransactionsDashboardResponseData](docs/GetTransactionsDashboardResponseData.md)
 - [GetTransactionsDashboardResponse](docs/GetTransactionsDashboardResponse.md)
 - [GetTransactionsDuplicatesResponse](docs/GetTransactionsDuplicatesResponse.md)
 - [GetTransactionsDuplicatesResponseData](docs/GetTransactionsDuplicatesResponseData.md)
 - [GetTransactionsDuplicatesResponseDataGroupsInner](docs/GetTransactionsDuplicatesResponseDataGroupsInner.md)
 - [GetTransactionsSummaryResponse](docs/GetTransactionsSummaryResponse.md)
 - [GetTransactionsSummaryResponseData](docs/GetTransactionsSummaryResponseData.md)
 - [GetWeeklyRecapResponse](docs/GetWeeklyRecapResponse.md)
 - [GetWeeklyRecapResponseData](docs/GetWeeklyRecapResponseData.md)
 - [GetWeeklyRecapResponse](docs/GetWeeklyRecapResponse.md)
 - [GetZestimateResponse](docs/GetZestimateResponse.md)
 - [GetZestimateResponseData](docs/GetZestimateResponseData.md)
 - [GetZestimateResponseDataZestimatesInner](docs/GetZestimateResponseDataZestimatesInner.md)
 - [GetZestimateRequest](docs/GetZestimateRequest.md)
 - [Goal](docs/Goal.md)
 - [GoalAllocationEntry](docs/GoalAllocationEntry.md)
 - [GoalContribution](docs/GoalContribution.md)
 - [GoalCurrentMonthTotal](docs/GoalCurrentMonthTotal.md)
 - [GoalEvent](docs/GoalEvent.md)
 - [GoalEventAccountRef](docs/GoalEventAccountRef.md)
 - [GoalEventTransactionRef](docs/GoalEventTransactionRef.md)
 - [GoalMilestone](docs/GoalMilestone.md)
 - [GoalPriority](docs/GoalPriority.md)
 - [GoalProjection](docs/GoalProjection.md)
 - [GoalProjectionPoint](docs/GoalProjectionPoint.md)
 - [HardDeleteGoalResponse](docs/HardDeleteGoalResponse.md)
 - [HealthResponse](docs/HealthResponse.md)
 - [Holding](docs/Holding.md)
 - [HoldingHistoryPoint](docs/HoldingHistoryPoint.md)
 - [HoldingTransactionRow](docs/HoldingTransactionRow.md)
 - [Household](docs/Household.md)
 - [HouseholdAccessGrant](docs/HouseholdAccessGrant.md)
 - [HouseholdInvite](docs/HouseholdInvite.md)
 - [HouseholdMember](docs/HouseholdMember.md)
 - [HouseholdPreferences](docs/HouseholdPreferences.md)
 - [IncomeReport](docs/IncomeReport.md)
 - [IncomeReportSource](docs/IncomeReportSource.md)
 - [InitialHoldingInput](docs/InitialHoldingInput.md)
 - [InitiatePasswordChangeResponse](docs/InitiatePasswordChangeResponse.md)
 - [InitiatePasswordChangeResponseData](docs/InitiatePasswordChangeResponseData.md)
 - [InitiatePasswordChangeResponse](docs/InitiatePasswordChangeResponse.md)
 - [Institution](docs/Institution.md)
 - [InstitutionDetail](docs/InstitutionDetail.md)
 - [InstitutionsResponse](docs/InstitutionsResponse.md)
 - [IntegrationStatus](docs/IntegrationStatus.md)
 - [InviteHouseholdMemberResponse](docs/InviteHouseholdMemberResponse.md)
 - [InviteHouseholdMemberResponseData](docs/InviteHouseholdMemberResponseData.md)
 - [InviteHouseholdMemberRequest](docs/InviteHouseholdMemberRequest.md)
 - [InviteHouseholdMemberResponse](docs/InviteHouseholdMemberResponse.md)
 - [LatestFinancialInsightRun](docs/LatestFinancialInsightRun.md)
 - [LatestRefreshOperation](docs/LatestRefreshOperation.md)
 - [LatestRefreshOperationResponse](docs/LatestRefreshOperationResponse.md)
 - [LinkTransactionToGoalResponse](docs/LinkTransactionToGoalResponse.md)
 - [LinkTransactionToGoalResponseData](docs/LinkTransactionToGoalResponseData.md)
 - [LinkTransactionToGoalRequest](docs/LinkTransactionToGoalRequest.md)
 - [LinkedCredential](docs/LinkedCredential.md)
 - [ListAccountsResponse](docs/ListAccountsResponse.md)
 - [ListAccountsResponseData](docs/ListAccountsResponseData.md)
 - [ListAccountsResponse](docs/ListAccountsResponse.md)
 - [ListAllRecurringResponse](docs/ListAllRecurringResponse.md)
 - [ListAllRecurringResponseData](docs/ListAllRecurringResponseData.md)
 - [ListAllRecurringResponse](docs/ListAllRecurringResponse.md)
 - [ListCategoriesResponse](docs/ListCategoriesResponse.md)
 - [ListCategoriesResponseData](docs/ListCategoriesResponseData.md)
 - [ListCategoriesResponse](docs/ListCategoriesResponse.md)
 - [ListCategoryGroupsResponse](docs/ListCategoryGroupsResponse.md)
 - [ListCategoryGroupsResponseData](docs/ListCategoryGroupsResponseData.md)
 - [ListCategoryGroupsResponse](docs/ListCategoryGroupsResponse.md)
 - [ListFinancialInsightsResponse](docs/ListFinancialInsightsResponse.md)
 - [ListFinancialInsightsResponseData](docs/ListFinancialInsightsResponseData.md)
 - [ListFinancialInsightsResponse](docs/ListFinancialInsightsResponse.md)
 - [ListGoalEventsResponse](docs/ListGoalEventsResponse.md)
 - [ListGoalEventsResponseData](docs/ListGoalEventsResponseData.md)
 - [ListGoalEventsResponse](docs/ListGoalEventsResponse.md)
 - [ListGoalsResponse](docs/ListGoalsResponse.md)
 - [ListGoalsResponseData](docs/ListGoalsResponseData.md)
 - [ListGoalsResponse](docs/ListGoalsResponse.md)
 - [ListLinkedCredentialsResponse](docs/ListLinkedCredentialsResponse.md)
 - [ListLinkedCredentialsResponseData](docs/ListLinkedCredentialsResponseData.md)
 - [ListLinkedCredentialsResponse](docs/ListLinkedCredentialsResponse.md)
 - [ListPaycheckEmployersResponse](docs/ListPaycheckEmployersResponse.md)
 - [ListPaycheckEmployersResponseData](docs/ListPaycheckEmployersResponseData.md)
 - [ListPaycheckEmployersResponse](docs/ListPaycheckEmployersResponse.md)
 - [ListPaychecksResponse](docs/ListPaychecksResponse.md)
 - [ListPaychecksResponseData](docs/ListPaychecksResponseData.md)
 - [ListPaychecksResponse](docs/ListPaychecksResponse.md)
 - [ListRecurringResponse](docs/ListRecurringResponse.md)
 - [ListRecurringResponseData](docs/ListRecurringResponseData.md)
 - [ListRecurringAggregateResponse](docs/ListRecurringAggregateResponse.md)
 - [ListRecurringAggregateResponseData](docs/ListRecurringAggregateResponseData.md)
 - [ListRecurringAggregateResponse](docs/ListRecurringAggregateResponse.md)
 - [ListRecurringStreamsResponse](docs/ListRecurringStreamsResponse.md)
 - [ListRecurringStreamsResponseData](docs/ListRecurringStreamsResponseData.md)
 - [ListRecurringStreamsResponse](docs/ListRecurringStreamsResponse.md)
 - [ListTagsResponse](docs/ListTagsResponse.md)
 - [ListTagsResponseData](docs/ListTagsResponseData.md)
 - [ListTagsResponse](docs/ListTagsResponse.md)
 - [ListTaxLotsResponse](docs/ListTaxLotsResponse.md)
 - [ListTaxLotsResponseData](docs/ListTaxLotsResponseData.md)
 - [ListTaxLotsResponse](docs/ListTaxLotsResponse.md)
 - [ListTransactionRulesResponse](docs/ListTransactionRulesResponse.md)
 - [ListTransactionRulesResponseData](docs/ListTransactionRulesResponseData.md)
 - [ListTransactionRulesResponse](docs/ListTransactionRulesResponse.md)
 - [ListTransactionsResponse](docs/ListTransactionsResponse.md)
 - [ListTransactionsResponseData](docs/ListTransactionsResponseData.md)
 - [ListTransactionsResponse](docs/ListTransactionsResponse.md)
 - [LongTailRequest](docs/LongTailRequest.md)
 - [LongTailResponse](docs/LongTailResponse.md)
 - [LongTailResponseData](docs/LongTailResponseData.md)
 - [LookupEntity](docs/LookupEntity.md)
 - [MarkAllNotificationsAsReadResponse](docs/MarkAllNotificationsAsReadResponse.md)
 - [MarkAllNotificationsAsReadResponseData](docs/MarkAllNotificationsAsReadResponseData.md)
 - [MarkAsNotRecurringResponse](docs/MarkAsNotRecurringResponse.md)
 - [MarkAsRecurringResponse](docs/MarkAsRecurringResponse.md)
 - [MarkAsRecurringResponseData](docs/MarkAsRecurringResponseData.md)
 - [MarkAsRecurringRequest](docs/MarkAsRecurringRequest.md)
 - [MarkAsRecurringResponse](docs/MarkAsRecurringResponse.md)
 - [MarkGoalCompleteResponse](docs/MarkGoalCompleteResponse.md)
 - [MarkGoalCompleteResponseData](docs/MarkGoalCompleteResponseData.md)
 - [MarkNotificationAsReadResponse](docs/MarkNotificationAsReadResponse.md)
 - [MarkNotificationAsReadResponseData](docs/MarkNotificationAsReadResponseData.md)
 - [MarkTransactionAsReviewedResponse](docs/MarkTransactionAsReviewedResponse.md)
 - [MarkTransactionAsReviewedResponseData](docs/MarkTransactionAsReviewedResponseData.md)
 - [MarkTransactionAsReviewedResponse](docs/MarkTransactionAsReviewedResponse.md)
 - [MarkTransactionStreamAsNotRecurringResponse](docs/MarkTransactionStreamAsNotRecurringResponse.md)
 - [MarkTransactionStreamAsNotRecurringResponseData](docs/MarkTransactionStreamAsNotRecurringResponseData.md)
 - [MatchSearchTransactionsResponse](docs/MatchSearchTransactionsResponse.md)
 - [MatchSearchTransactionsResponseData](docs/MatchSearchTransactionsResponseData.md)
 - [MatchSearchTransactionsResponseDataResultsInner](docs/MatchSearchTransactionsResponseDataResultsInner.md)
 - [MatchSearchTransactionsResponseDataResultsInnerAccount](docs/MatchSearchTransactionsResponseDataResultsInnerAccount.md)
 - [MatchSearchTransactionsResponseDataResultsInnerMerchant](docs/MatchSearchTransactionsResponseDataResultsInnerMerchant.md)
 - [Merchant](docs/Merchant.md)
 - [MerchantAggregateRow](docs/MerchantAggregateRow.md)
 - [MerchantRecurringStream](docs/MerchantRecurringStream.md)
 - [MerchantRef](docs/MerchantRef.md)
 - [MerchantStats](docs/MerchantStats.md)
 - [MerchantTransactionRow](docs/MerchantTransactionRow.md)
 - [MergeRecurringStreamsResponse](docs/MergeRecurringStreamsResponse.md)
 - [MergeRecurringStreamsResponseData](docs/MergeRecurringStreamsResponseData.md)
 - [MergeRecurringStreamsRequest](docs/MergeRecurringStreamsRequest.md)
 - [MergeRecurringStreamsResponse](docs/MergeRecurringStreamsResponse.md)
 - [MobileScreenAggregateResponse](docs/MobileScreenAggregateResponse.md)
 - [MonthlyReportSummary](docs/MonthlyReportSummary.md)
 - [MoveTransactionsResponse](docs/MoveTransactionsResponse.md)
 - [MoveTransactionsResponseData](docs/MoveTransactionsResponseData.md)
 - [MoveTransactionsResponseDataErrorsInner](docs/MoveTransactionsResponseDataErrorsInner.md)
 - [MoveTransactionsRequest](docs/MoveTransactionsRequest.md)
 - [NetWorthReport](docs/NetWorthReport.md)
 - [NetWorthReportPoint](docs/NetWorthReportPoint.md)
 - [NetworthByTypeResponse](docs/NetworthByTypeResponse.md)
 - [NetworthRecentResponse](docs/NetworthRecentResponse.md)
 - [NetworthResponse](docs/NetworthResponse.md)
 - [NotificationPreference](docs/NotificationPreference.md)
 - [PauseSubscriptionResponse](docs/PauseSubscriptionResponse.md)
 - [PauseSubscriptionResponseData](docs/PauseSubscriptionResponseData.md)
 - [PauseSubscriptionRequest](docs/PauseSubscriptionRequest.md)
 - [PauseSubscriptionResponse](docs/PauseSubscriptionResponse.md)
 - [Paycheck](docs/Paycheck.md)
 - [PaycheckCreatedBy](docs/PaycheckCreatedBy.md)
 - [PaycheckDeduction](docs/PaycheckDeduction.md)
 - [PaycheckDeductionInput](docs/PaycheckDeductionInput.md)
 - [PaycheckDeposit](docs/PaycheckDeposit.md)
 - [PaycheckDepositInput](docs/PaycheckDepositInput.md)
 - [PaycheckDepositTransaction](docs/PaycheckDepositTransaction.md)
 - [PaycheckDepositTransactionAccount](docs/PaycheckDepositTransactionAccount.md)
 - [PaycheckDepositTransactionMerchant](docs/PaycheckDepositTransactionMerchant.md)
 - [PaycheckEmployer](docs/PaycheckEmployer.md)
 - [PaycheckEmployerRef](docs/PaycheckEmployerRef.md)
 - [PaycheckOwner](docs/PaycheckOwner.md)
 - [PaychecksSummary](docs/PaychecksSummary.md)
 - [PaychecksSummaryDeduction](docs/PaychecksSummaryDeduction.md)
 - [PortfolioAllocationBucket](docs/PortfolioAllocationBucket.md)
 - [PortfolioAllocationHolding](docs/PortfolioAllocationHolding.md)
 - [PortfolioAllocationHoldingsDetailResponse](docs/PortfolioAllocationHoldingsDetailResponse.md)
 - [PortfolioAllocationResponse](docs/PortfolioAllocationResponse.md)
 - [PortfolioAllocationSimpleResponse](docs/PortfolioAllocationSimpleResponse.md)
 - [PreviewAccountBalanceResponse](docs/PreviewAccountBalanceResponse.md)
 - [PreviewAccountBalanceResponseData](docs/PreviewAccountBalanceResponseData.md)
 - [PreviewSubscriptionPlanChangeResponse](docs/PreviewSubscriptionPlanChangeResponse.md)
 - [PreviewSubscriptionPlanChangeResponseData](docs/PreviewSubscriptionPlanChangeResponseData.md)
 - [PreviewSubscriptionPlanChangeRequest](docs/PreviewSubscriptionPlanChangeRequest.md)
 - [PreviewSubscriptionPlanChangeResponse](docs/PreviewSubscriptionPlanChangeResponse.md)
 - [PreviewTransactionRuleResponse](docs/PreviewTransactionRuleResponse.md)
 - [PreviewTransactionRuleResponseData](docs/PreviewTransactionRuleResponseData.md)
 - [PreviewTransactionRuleResponse](docs/PreviewTransactionRuleResponse.md)
 - [RecentAccountBalances](docs/RecentAccountBalances.md)
 - [RecurringForecastEntry](docs/RecurringForecastEntry.md)
 - [RecurringResponse](docs/RecurringResponse.md)
 - [RecurringStreamRef](docs/RecurringStreamRef.md)
 - [Ref](docs/Ref.md)
 - [RefreshStatusResponse](docs/RefreshStatusResponse.md)
 - [RemoveHouseholdMemberResponse](docs/RemoveHouseholdMemberResponse.md)
 - [RemoveHouseholdMemberResponseData](docs/RemoveHouseholdMemberResponseData.md)
 - [RemoveHouseholdMemberResponse](docs/RemoveHouseholdMemberResponse.md)
 - [RequestRefresh503Response](docs/RequestRefresh503Response.md)
 - [ResetBudgetResponse](docs/ResetBudgetResponse.md)
 - [ResetBudgetResponseData](docs/ResetBudgetResponseData.md)
 - [ResetBudgetRequest](docs/ResetBudgetRequest.md)
 - [ResetBudgetResponse](docs/ResetBudgetResponse.md)
 - [ResumeSubscriptionResponse](docs/ResumeSubscriptionResponse.md)
 - [ResumeSubscriptionResponseData](docs/ResumeSubscriptionResponseData.md)
 - [ResumeSubscriptionResponse](docs/ResumeSubscriptionResponse.md)
 - [ReviewSummaryByUserResponse](docs/ReviewSummaryByUserResponse.md)
 - [ReviewSummaryByUserRow](docs/ReviewSummaryByUserRow.md)
 - [SavingsRateMonth](docs/SavingsRateMonth.md)
 - [SavingsRateReport](docs/SavingsRateReport.md)
 - [SavingsRateTrendPoint](docs/SavingsRateTrendPoint.md)
 - [SearchMerchantsResponse](docs/SearchMerchantsResponse.md)
 - [SearchMerchantsResponseData](docs/SearchMerchantsResponseData.md)
 - [SearchMerchantsResponse](docs/SearchMerchantsResponse.md)
 - [SearchSecuritiesResponse](docs/SearchSecuritiesResponse.md)
 - [SearchSecuritiesResponseData](docs/SearchSecuritiesResponseData.md)
 - [SearchSecuritiesResponse](docs/SearchSecuritiesResponse.md)
 - [Security](docs/Security.md)
 - [SecurityDetails](docs/SecurityDetails.md)
 - [SecurityDividend](docs/SecurityDividend.md)
 - [SecurityHistoricalPerformanceResponse](docs/SecurityHistoricalPerformanceResponse.md)
 - [SecurityHistoricalPoint](docs/SecurityHistoricalPoint.md)
 - [SecurityHistoricalSummary](docs/SecurityHistoricalSummary.md)
 - [SetBudgetAmountResponse](docs/SetBudgetAmountResponse.md)
 - [SetBudgetAmountResponseData](docs/SetBudgetAmountResponseData.md)
 - [SetBudgetAmountRequest](docs/SetBudgetAmountRequest.md)
 - [SetBudgetAmountResponse](docs/SetBudgetAmountResponse.md)
 - [SetChannelNotificationPrefsRequest](docs/SetChannelNotificationPrefsRequest.md)
 - [SetChannelNotificationPrefsResponse](docs/SetChannelNotificationPrefsResponse.md)
 - [SetCurrencyResponse](docs/SetCurrencyResponse.md)
 - [SetCurrencyResponseData](docs/SetCurrencyResponseData.md)
 - [SetCurrencyRequest](docs/SetCurrencyRequest.md)
 - [SetCurrencyResponse](docs/SetCurrencyResponse.md)
 - [SetEmailNotificationPrefsRequest](docs/SetEmailNotificationPrefsRequest.md)
 - [SetFiscalYearResponse](docs/SetFiscalYearResponse.md)
 - [SetFiscalYearResponseData](docs/SetFiscalYearResponseData.md)
 - [SetFiscalYearRequest](docs/SetFiscalYearRequest.md)
 - [SetFiscalYearResponse](docs/SetFiscalYearResponse.md)
 - [SetGoalBudgetAmountRequest](docs/SetGoalBudgetAmountRequest.md)
 - [SetGoalBudgetAmountResponse](docs/SetGoalBudgetAmountResponse.md)
 - [SetMerchantLogoRequest](docs/SetMerchantLogoRequest.md)
 - [SetMerchantLogoResponse](docs/SetMerchantLogoResponse.md)
 - [SetTagsRequest](docs/SetTagsRequest.md)
 - [SetTransactionTagsResponse](docs/SetTransactionTagsResponse.md)
 - [SetTransactionTagsResponseData](docs/SetTransactionTagsResponseData.md)
 - [SetTransactionTagsRequest](docs/SetTransactionTagsRequest.md)
 - [SetTransactionTagsResponse](docs/SetTransactionTagsResponse.md)
 - [SkipRecurringInstanceResponse](docs/SkipRecurringInstanceResponse.md)
 - [SkipRecurringInstanceResponseData](docs/SkipRecurringInstanceResponseData.md)
 - [SkipRecurringInstanceRequest](docs/SkipRecurringInstanceRequest.md)
 - [SkipRecurringInstanceResponse](docs/SkipRecurringInstanceResponse.md)
 - [SkippedRecurringInstance](docs/SkippedRecurringInstance.md)
 - [SnapshotByAccountType](docs/SnapshotByAccountType.md)
 - [SpendFromGoalResponse](docs/SpendFromGoalResponse.md)
 - [SpendFromGoalResponseData](docs/SpendFromGoalResponseData.md)
 - [SpendFromGoalRequest](docs/SpendFromGoalRequest.md)
 - [SpendingDashboard](docs/SpendingDashboard.md)
 - [SpendingDashboardCategory](docs/SpendingDashboardCategory.md)
 - [SpendingReport](docs/SpendingReport.md)
 - [SpendingReportCategory](docs/SpendingReportCategory.md)
 - [SpendingTrendCategory](docs/SpendingTrendCategory.md)
 - [SpendingTrends](docs/SpendingTrends.md)
 - [Split](docs/Split.md)
 - [SplitTemplate](docs/SplitTemplate.md)
 - [SplitTemplateEntry](docs/SplitTemplateEntry.md)
 - [SplitsRequest](docs/SplitsRequest.md)
 - [StartDownloadTransactionsResponse](docs/StartDownloadTransactionsResponse.md)
 - [StartDownloadTransactionsResponseData](docs/StartDownloadTransactionsResponseData.md)
 - [StartDownloadTransactionsRequest](docs/StartDownloadTransactionsRequest.md)
 - [SubscriptionDetails](docs/SubscriptionDetails.md)
 - [SubscriptionFullDetails](docs/SubscriptionFullDetails.md)
 - [SubscriptionInvoice](docs/SubscriptionInvoice.md)
 - [SubscriptionReceipt](docs/SubscriptionReceipt.md)
 - [Tag](docs/Tag.md)
 - [TagRef](docs/TagRef.md)
 - [TagReport](docs/TagReport.md)
 - [TagReportMonth](docs/TagReportMonth.md)
 - [TargetAllocationEntry](docs/TargetAllocationEntry.md)
 - [TaxBracket](docs/TaxBracket.md)
 - [TaxBracketEstimates](docs/TaxBracketEstimates.md)
 - [TaxCategoryAggregateRow](docs/TaxCategoryAggregateRow.md)
 - [TaxCategoryRef](docs/TaxCategoryRef.md)
 - [TaxCategoryWithSystem](docs/TaxCategoryWithSystem.md)
 - [TaxLineItemInfo](docs/TaxLineItemInfo.md)
 - [TaxLot](docs/TaxLot.md)
 - [TaxLotPerformancePoint](docs/TaxLotPerformancePoint.md)
 - [TaxScheduleCategoryMapping](docs/TaxScheduleCategoryMapping.md)
 - [TaxScheduleSummary](docs/TaxScheduleSummary.md)
 - [TaxYearOverview](docs/TaxYearOverview.md)
 - [TopInstitution](docs/TopInstitution.md)
 - [TopInstitutionGroup](docs/TopInstitutionGroup.md)
 - [Transaction](docs/Transaction.md)
 - [TransactionAccountRef](docs/TransactionAccountRef.md)
 - [TransactionAttachment](docs/TransactionAttachment.md)
 - [TransactionAuditEntry](docs/TransactionAuditEntry.md)
 - [TransactionDetailResponse](docs/TransactionDetailResponse.md)
 - [TransactionNote](docs/TransactionNote.md)
 - [TransactionReminder](docs/TransactionReminder.md)
 - [TransactionRule](docs/TransactionRule.md)
 - [TransactionRuleAmountCriterion](docs/TransactionRuleAmountCriterion.md)
 - [TransactionRuleAmountRange](docs/TransactionRuleAmountRange.md)
 - [TransactionRulePreviewMatch](docs/TransactionRulePreviewMatch.md)
 - [TransactionRuleRequest](docs/TransactionRuleRequest.md)
 - [TransactionRuleSplitAction](docs/TransactionRuleSplitAction.md)
 - [TransactionRuleSplitInfo](docs/TransactionRuleSplitInfo.md)
 - [TransactionRuleStringCriterion](docs/TransactionRuleStringCriterion.md)
 - [TransactionSplit](docs/TransactionSplit.md)
 - [TransactionSplitsResponse](docs/TransactionSplitsResponse.md)
 - [TransactionsDuplicatesResponse](docs/TransactionsDuplicatesResponse.md)
 - [TransactionsSummary](docs/TransactionsSummary.md)
 - [TransactionsSummaryResponse](docs/TransactionsSummaryResponse.md)
 - [UpdateAccountResponse](docs/UpdateAccountResponse.md)
 - [UpdateAccountResponseData](docs/UpdateAccountResponseData.md)
 - [UpdateAccountGroupOrderResponse](docs/UpdateAccountGroupOrderResponse.md)
 - [UpdateAccountGroupOrderResponseData](docs/UpdateAccountGroupOrderResponseData.md)
 - [UpdateAccountGroupOrderRequest](docs/UpdateAccountGroupOrderRequest.md)
 - [UpdateAccountGroupOrderResponse](docs/UpdateAccountGroupOrderResponse.md)
 - [UpdateAccountRequest](docs/UpdateAccountRequest.md)
 - [UpdateAccountResponse](docs/UpdateAccountResponse.md)
 - [UpdateAppearanceRequest](docs/UpdateAppearanceRequest.md)
 - [UpdateAppearanceResponse](docs/UpdateAppearanceResponse.md)
 - [UpdateBudgetSettingsResponse](docs/UpdateBudgetSettingsResponse.md)
 - [UpdateBudgetSettingsResponseData](docs/UpdateBudgetSettingsResponseData.md)
 - [UpdateBudgetSettingsRequest](docs/UpdateBudgetSettingsRequest.md)
 - [UpdateCategoryGroupBudgetVariabilityResponse](docs/UpdateCategoryGroupBudgetVariabilityResponse.md)
 - [UpdateCategoryGroupBudgetVariabilityResponseData](docs/UpdateCategoryGroupBudgetVariabilityResponseData.md)
 - [UpdateCategoryGroupBudgetVariabilityRequest](docs/UpdateCategoryGroupBudgetVariabilityRequest.md)
 - [UpdateCategoryGroupBudgetVariabilityResponse](docs/UpdateCategoryGroupBudgetVariabilityResponse.md)
 - [UpdateCategoryGroupRequest](docs/UpdateCategoryGroupRequest.md)
 - [UpdateCategoryGroupResponse](docs/UpdateCategoryGroupResponse.md)
 - [UpdateCookiePreferencesRequest](docs/UpdateCookiePreferencesRequest.md)
 - [UpdateCookiePreferencesResponse](docs/UpdateCookiePreferencesResponse.md)
 - [UpdateFlexRolloverSettingsResponse](docs/UpdateFlexRolloverSettingsResponse.md)
 - [UpdateFlexRolloverSettingsResponseData](docs/UpdateFlexRolloverSettingsResponseData.md)
 - [UpdateFlexRolloverSettingsRequest](docs/UpdateFlexRolloverSettingsRequest.md)
 - [UpdateFlexRolloverSettingsResponse](docs/UpdateFlexRolloverSettingsResponse.md)
 - [UpdateFlexibleBudgetRequest](docs/UpdateFlexibleBudgetRequest.md)
 - [UpdateFlexibleBudgetResponse](docs/UpdateFlexibleBudgetResponse.md)
 - [UpdateGoalRequest](docs/UpdateGoalRequest.md)
 - [UpdateGoalsPrioritiesResponse](docs/UpdateGoalsPrioritiesResponse.md)
 - [UpdateGoalsPrioritiesResponseData](docs/UpdateGoalsPrioritiesResponseData.md)
 - [UpdateGoalsPrioritiesRequest](docs/UpdateGoalsPrioritiesRequest.md)
 - [UpdateGoalsPrioritiesResponse](docs/UpdateGoalsPrioritiesResponse.md)
 - [UpdateHoldingResponse](docs/UpdateHoldingResponse.md)
 - [UpdateHoldingResponseData](docs/UpdateHoldingResponseData.md)
 - [UpdateHoldingRequest](docs/UpdateHoldingRequest.md)
 - [UpdateHoldingResponse](docs/UpdateHoldingResponse.md)
 - [UpdateHouseholdNameResponse](docs/UpdateHouseholdNameResponse.md)
 - [UpdateHouseholdNameResponseData](docs/UpdateHouseholdNameResponseData.md)
 - [UpdateHouseholdNameRequest](docs/UpdateHouseholdNameRequest.md)
 - [UpdateHouseholdNameResponse](docs/UpdateHouseholdNameResponse.md)
 - [UpdateHouseholdPreferencesResponse](docs/UpdateHouseholdPreferencesResponse.md)
 - [UpdateHouseholdPreferencesResponseData](docs/UpdateHouseholdPreferencesResponseData.md)
 - [UpdateHouseholdPreferencesRequest](docs/UpdateHouseholdPreferencesRequest.md)
 - [UpdateMeResponse](docs/UpdateMeResponse.md)
 - [UpdateMeResponseData](docs/UpdateMeResponseData.md)
 - [UpdateMeRequest](docs/UpdateMeRequest.md)
 - [UpdateMerchantRecurrenceResponse](docs/UpdateMerchantRecurrenceResponse.md)
 - [UpdateMerchantRecurrenceResponseData](docs/UpdateMerchantRecurrenceResponseData.md)
 - [UpdateMerchantRecurrenceRequest](docs/UpdateMerchantRecurrenceRequest.md)
 - [UpdateMerchantRecurrenceResponse](docs/UpdateMerchantRecurrenceResponse.md)
 - [UpdateNotificationPreferencesResponse](docs/UpdateNotificationPreferencesResponse.md)
 - [UpdateNotificationPreferencesResponseData](docs/UpdateNotificationPreferencesResponseData.md)
 - [UpdateNotificationPreferencesRequest](docs/UpdateNotificationPreferencesRequest.md)
 - [UpdateNotificationPreferencesResponse](docs/UpdateNotificationPreferencesResponse.md)
 - [UpdatePaycheckEmployerRequest](docs/UpdatePaycheckEmployerRequest.md)
 - [UpdatePaycheckEmployerResponse](docs/UpdatePaycheckEmployerResponse.md)
 - [UpdatePaycheckRequest](docs/UpdatePaycheckRequest.md)
 - [UpdatePaycheckResponse](docs/UpdatePaycheckResponse.md)
 - [UpdateTaxLotRequest](docs/UpdateTaxLotRequest.md)
 - [UpdateTaxLotResponse](docs/UpdateTaxLotResponse.md)
 - [UpdateTransactionResponse](docs/UpdateTransactionResponse.md)
 - [UpdateTransactionResponseData](docs/UpdateTransactionResponseData.md)
 - [UpdateTransactionRequest](docs/UpdateTransactionRequest.md)
 - [UpdateTransactionResponse](docs/UpdateTransactionResponse.md)
 - [UpdateTransactionRuleResponse](docs/UpdateTransactionRuleResponse.md)
 - [UpdateTransactionRuleResponseData](docs/UpdateTransactionRuleResponseData.md)
 - [UpdateTransactionRuleResponse](docs/UpdateTransactionRuleResponse.md)
 - [UpdateTransactionSplitsResponse](docs/UpdateTransactionSplitsResponse.md)
 - [UpdateTransactionSplitsResponseData](docs/UpdateTransactionSplitsResponseData.md)
 - [UpdateTransactionSplitsRequest](docs/UpdateTransactionSplitsRequest.md)
 - [UpdateTransactionSplitsResponse](docs/UpdateTransactionSplitsResponse.md)
 - [UploadAccountBalanceHistory202Response](docs/UploadAccountBalanceHistory202Response.md)
 - [UploadAccountBalanceHistory202ResponseData](docs/UploadAccountBalanceHistory202ResponseData.md)
 - [UploadTransactionAttachmentResponse](docs/UploadTransactionAttachmentResponse.md)
 - [UploadTransactionAttachmentResponseData](docs/UploadTransactionAttachmentResponseData.md)
 - [UploadTransactionAttachmentResponse](docs/UploadTransactionAttachmentResponse.md)
 - [User](docs/User.md)
 - [UserProfileFlags](docs/UserProfileFlags.md)
 - [WebScreenAggregateRequest](docs/WebScreenAggregateRequest.md)
 - [WebScreenAggregateResponse](docs/WebScreenAggregateResponse.md)
 - [WeeklyRecap](docs/WeeklyRecap.md)
 - [WeeklyRecapCard](docs/WeeklyRecapCard.md)
 - [WithdrawFromGoalResponse](docs/WithdrawFromGoalResponse.md)
 - [WithdrawFromGoalResponseData](docs/WithdrawFromGoalResponseData.md)
 - [WithdrawFromGoalRequest](docs/WithdrawFromGoalRequest.md)
 - [YoyPoint](docs/YoyPoint.md)


<a id="documentation-for-authorization"></a>
## Documentation For Authorization

Endpoints do not require authorization.

