# Monarch Bridge Bash client

## Overview

This is a Bash client script for accessing Monarch Bridge service.

The script uses cURL underneath for making all REST calls.

## Usage

```shell
# Make sure the script has executable rights
$ chmod u+x monarch-api

# Print the list of operations available on the service
$ ./monarch-api -h

# Print the service description
$ ./monarch-api --about

# Print detailed information about specific operation
$ ./monarch-api <operationId> -h

# Make GET request
./monarch-api --host http://<hostname>:<port> --accept xml <operationId> <queryParam1>=<value1> <header_key1>:<header_value2>

# Make GET request using arbitrary curl options (must be passed before <operationId>) to an SSL service using username:password
monarch-api -k -sS --tlsv1.2 --host https://<hostname> -u <user>:<password> --accept xml <operationId> <queryParam1>=<value1> <header_key1>:<header_value2>

# Make POST request
$ echo '<body_content>' | monarch-api --host <hostname> --content-type json <operationId> -

# Make POST request with simple JSON content, e.g.:
# {
#   "key1": "value1",
#   "key2": "value2",
#   "key3": 23
# }
$ echo '<body_content>' | monarch-api --host <hostname> --content-type json <operationId> key1==value1 key2=value2 key3:=23 -

# Make POST request with form data
$ monarch-api --host <hostname> <operationId> key1:=value1 key2:=value2 key3:=23

# Preview the cURL command without actually executing it
$ monarch-api --host http://<hostname>:<port> --dry-run <operationid>

```

## Docker image

You can easily create a Docker image containing a preconfigured environment
for using the REST Bash client including working autocompletion and short
welcome message with basic instructions, using the generated Dockerfile:

```shell
docker build -t my-rest-client .
docker run -it my-rest-client
```

By default you will be logged into a Zsh environment which has much more
advanced auto completion, but you can switch to Bash, where basic autocompletion
is also available.

## Shell completion

### Bash

The generated bash-completion script can be either directly loaded to the current Bash session using:

```shell
source monarch-api.bash-completion
```

Alternatively, the script can be copied to the `/etc/bash-completion.d` (or on OSX with Homebrew to `/usr/local/etc/bash-completion.d`):

```shell
sudo cp monarch-api.bash-completion /etc/bash-completion.d/monarch-api
```

#### OS X

On OSX you might need to install bash-completion using Homebrew:

```shell
brew install bash-completion
```

and add the following to the `~/.bashrc`:

```shell
if [ -f $(brew --prefix)/etc/bash_completion ]; then
  . $(brew --prefix)/etc/bash_completion
fi
```

### Zsh

In Zsh, the generated `_monarch-api` Zsh completion file must be copied to one of the folders under `$FPATH` variable.

## Documentation for API Endpoints

All URIs are relative to **

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
*AdviceApi* | [**advice**](docs/AdviceApi.md#advice) | **GET** /v1/advice | Forward &#39;AdviceQuery_Web&#39; (opaque pass-through)
*AdviceApi* | [**adviceDashboardWidget**](docs/AdviceApi.md#advicedashboardwidget) | **GET** /v1/advice/dashboard-widget | Forward &#39;Web_GetAdviceDashboardWidget&#39; (opaque pass-through)
*AdviceApi* | [**adviceItemDrawer**](docs/AdviceApi.md#adviceitemdrawer) | **GET** /v1/advice/item-drawer | Forward &#39;AdviceItemDrawerQuery_Web&#39; (opaque pass-through)
*AdviceApi* | [**adviceQuestionnaire**](docs/AdviceApi.md#advicequestionnaire) | **GET** /v1/advice/questionnaire | Forward &#39;Web_AdviceQuestionnaire&#39; (opaque pass-through)
*AdviceApi* | [**adviceTaskComplete**](docs/AdviceApi.md#advicetaskcomplete) | **GET** /v1/advice/task/complete | Forward &#39;Web_MarkAdviceTaskComplete&#39; (opaque pass-through)
*AdviceApi* | [**adviceTaskDrawer**](docs/AdviceApi.md#advicetaskdrawer) | **GET** /v1/advice/task-drawer | Forward &#39;AdviceTaskDrawerQuery_Web&#39; (opaque pass-through)
*AdviceApi* | [**adviceTaskIncomplete**](docs/AdviceApi.md#advicetaskincomplete) | **GET** /v1/advice/task/incomplete | Forward &#39;Web_MarkAdviceTaskIncomplete&#39; (opaque pass-through)
*BillsApi* | [**billsAdvisorBilling**](docs/BillsApi.md#billsadvisorbilling) | **GET** /v1/bills/advisor-billing | Forward &#39;Web_GetAdvisorBillingPage&#39; (opaque pass-through)
*BillsApi* | [**billsBillingSettings**](docs/BillsApi.md#billsbillingsettings) | **GET** /v1/bills/billing-settings | Forward &#39;GetBillingSettings&#39; (opaque pass-through)
*BillsApi* | [**billsCancelSponsorship**](docs/BillsApi.md#billscancelsponsorship) | **GET** /v1/bills/billing/sponsorship/cancel | Forward &#39;Web_BillingSettingsCancelSponsorship&#39; (opaque pass-through)
*BillsApi* | [**billsClaimItem**](docs/BillsApi.md#billsclaimitem) | **GET** /v1/bills/item/claim | Forward &#39;Web_ClaimBillItem&#39; (opaque pass-through)
*BillsApi* | [**billsDetail**](docs/BillsApi.md#billsdetail) | **GET** /v1/bills/detail | Forward &#39;Web_GetBill&#39; (opaque pass-through)
*BillsApi* | [**billsEmployeeBillingState**](docs/BillsApi.md#billsemployeebillingstate) | **GET** /v1/bills/employee/billing-state | Forward &#39;Web_GetEmployeeBillingState&#39; (opaque pass-through)
*BillsApi* | [**billsHouseholdCountry**](docs/BillsApi.md#billshouseholdcountry) | **GET** /v1/bills/billing/household-country | Forward &#39;Web_BillingSettings_HouseholdCountry&#39; (opaque pass-through)
*BillsApi* | [**billsMobileSignupUpdatePostalCode**](docs/BillsApi.md#billsmobilesignupupdatepostalcode) | **GET** /v1/bills/mobile-signup/postal-code | Forward &#39;Mobile_SignupBillingZip_UpdateBillingPostalCode&#39; (opaque pass-through)
*BillsApi* | [**billsOnboardingGetPostalCode**](docs/BillsApi.md#billsonboardinggetpostalcode) | **GET** /v1/bills/onboarding/postal-code | Forward &#39;Web_OnboardingBillingZip_GetPostalCode&#39; (opaque pass-through)
*BillsApi* | [**billsOnboardingUpdatePostalCode**](docs/BillsApi.md#billsonboardingupdatepostalcode) | **GET** /v1/bills/onboarding/postal-code/update | Forward &#39;Web_OnboardingBillingZip_UpdateBillingPostalCode&#39; (opaque pass-through)
*BillsApi* | [**billsRegisterSplitParticipant**](docs/BillsApi.md#billsregistersplitparticipant) | **GET** /v1/bills/split/register-participant | Forward &#39;Web_RegisterBillSplitParticipant&#39; (opaque pass-through)
*BillsApi* | [**billsSetEmployeeBillingIssue**](docs/BillsApi.md#billssetemployeebillingissue) | **GET** /v1/bills/employee/billing-issue | Forward &#39;Web_SetEmployeeBillingIssue&#39; (opaque pass-through)
*BillsApi* | [**billsSubmitSplitInitiatorEdit**](docs/BillsApi.md#billssubmitsplitinitiatoredit) | **GET** /v1/bills/split/initiator-edit | Forward &#39;Web_SubmitBillSplitInitiatorEdit&#39; (opaque pass-through)
*BillsApi* | [**billsToggleSyncTracking**](docs/BillsApi.md#billstogglesynctracking) | **GET** /v1/bills/sync-tracking | Forward &#39;Common_ToggleBillSyncTracking&#39; (opaque pass-through)
*BillsApi* | [**billsUnclaimItem**](docs/BillsApi.md#billsunclaimitem) | **GET** /v1/bills/item/unclaim | Forward &#39;Web_UnclaimBillItem&#39; (opaque pass-through)
*BillsApi* | [**billsUpdatePostalCode**](docs/BillsApi.md#billsupdatepostalcode) | **GET** /v1/bills/billing/postal-code | Forward &#39;Web_BillingZipModal_UpdateBillingPostalCode&#39; (opaque pass-through)
*BudgetsApi* | [**getBudgetMonth**](docs/BudgetsApi.md#getbudgetmonth) | **GET** /v1/budgets/month | Single-month budget data (slim), per-category amounts only
*BudgetsApi* | [**getBudgetStatus**](docs/BudgetsApi.md#getbudgetstatus) | **GET** /v1/budgets/status | Budget status (initialized? has transactions?)
*BudgetsApi* | [**getBudgetTimeline**](docs/BudgetsApi.md#getbudgettimeline) | **GET** /v1/budgets/timeline | Multi-month budget vs. actual timeline
*BudgetsApi* | [**getBudgets**](docs/BudgetsApi.md#getbudgets) | **GET** /v1/budgets | Monthly budget data + actuals
*BudgetsApi* | [**resetBudget**](docs/BudgetsApi.md#resetbudget) | **POST** /v1/budgets/reset | Reset all planned amounts for one month back to defaults
*BudgetsApi* | [**setBudgetAmount**](docs/BudgetsApi.md#setbudgetamount) | **POST** /v1/budgets/items | Set the planned amount for one category OR category-group for a month
*BudgetsApi* | [**updateBudgetSettings**](docs/BudgetsApi.md#updatebudgetsettings) | **PATCH** /v1/budgets/settings | Update household budget settings
*BudgetsApi* | [**updateFlexRolloverSettings**](docs/BudgetsApi.md#updateflexrolloversettings) | **PUT** /v1/budgets/flex/rollover | Configure / reset the Flex bucket rollover period
*BudgetsApi* | [**updateFlexibleBudget**](docs/BudgetsApi.md#updateflexiblebudget) | **PUT** /v1/budgets/flex | Update the Flex bucket total for a month
*BusinessEntityApi* | [**businessEntitiesDelete**](docs/BusinessEntityApi.md#businessentitiesdelete) | **GET** /v1/business-entities/delete | Forward &#39;Common_DeleteBusinessEntity&#39; (opaque pass-through)
*BusinessEntityApi* | [**businessEntitiesDeleteLogo**](docs/BusinessEntityApi.md#businessentitiesdeletelogo) | **GET** /v1/business-entities/logo/delete | Forward &#39;Common_DeleteBusinessEntityLogo&#39; (opaque pass-through)
*BusinessEntityApi* | [**businessEntitiesDemoPopulate**](docs/BusinessEntityApi.md#businessentitiesdemopopulate) | **GET** /v1/business-entities/demo/populate | Forward &#39;Web_PopulateBusinessEntityDemo&#39; (opaque pass-through)
*BusinessEntityApi* | [**businessEntitiesDemoScenarios**](docs/BusinessEntityApi.md#businessentitiesdemoscenarios) | **GET** /v1/business-entities/demo/scenarios | Forward &#39;Web_AvailableBusinessEntityDemoScenarios&#39; (opaque pass-through)
*BusinessEntityApi* | [**businessEntitiesDetail**](docs/BusinessEntityApi.md#businessentitiesdetail) | **GET** /v1/business-entities/detail | Forward &#39;Common_GetBusinessEntity&#39; (opaque pass-through)
*BusinessEntityApi* | [**businessEntitiesFinancials**](docs/BusinessEntityApi.md#businessentitiesfinancials) | **GET** /v1/business-entities/financials | Forward &#39;Common_GetBusinessEntityFinancials&#39; (opaque pass-through)
*BusinessEntityApi* | [**businessEntitiesReportsByCategory**](docs/BusinessEntityApi.md#businessentitiesreportsbycategory) | **GET** /v1/business-entities/reports/by-category | Forward &#39;Common_GetBusinessEntityReportsDataByCategory&#39; (opaque pass-through)
*BusinessEntityApi* | [**businessEntitiesReportsByGroup**](docs/BusinessEntityApi.md#businessentitiesreportsbygroup) | **GET** /v1/business-entities/reports/by-group | Forward &#39;Common_GetBusinessEntityReportsDataByGroup&#39; (opaque pass-through)
*BusinessEntityApi* | [**businessEntitiesUpsert**](docs/BusinessEntityApi.md#businessentitiesupsert) | **GET** /v1/business-entities/upsert | Forward &#39;Common_UpsertBusinessEntity&#39; (opaque pass-through)
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
*CategoriesApi* | [**updateCategoryGroupBudgetVariability**](docs/CategoriesApi.md#updatecategorygroupbudgetvariability) | **PATCH** /v1/category-groups/{id}/budget-variability | Set a category group&#39;s budget-variability (fixed vs flex)
*EquityGrantsApi* | [**equityGrantsCreate**](docs/EquityGrantsApi.md#equitygrantscreate) | **GET** /v1/equity-grants/create | Forward &#39;Web_CreateEquityGrant&#39; (opaque pass-through)
*EquityGrantsApi* | [**equityGrantsDelete**](docs/EquityGrantsApi.md#equitygrantsdelete) | **GET** /v1/equity-grants/delete | Forward &#39;Web_DeleteEquityGrant&#39; (opaque pass-through)
*EquityGrantsApi* | [**equityGrantsEditModal**](docs/EquityGrantsApi.md#equitygrantseditmodal) | **GET** /v1/equity-grants/edit-modal/detail | Forward &#39;Web_EditEquityGrantModal_GetEquityGrant&#39; (opaque pass-through)
*EquityGrantsApi* | [**equityGrantsList**](docs/EquityGrantsApi.md#equitygrantslist) | **GET** /v1/equity-grants | Forward &#39;Web_GetEquityGrants&#39; (opaque pass-through)
*EquityGrantsApi* | [**equityGrantsManageHoldingsModal**](docs/EquityGrantsApi.md#equitygrantsmanageholdingsmodal) | **GET** /v1/equity-grants/manage-holdings-modal | Forward &#39;Web_ManageEquityHoldingsModal_GetEquityGrants&#39; (opaque pass-through)
*EquityGrantsApi* | [**equityGrantsPreview**](docs/EquityGrantsApi.md#equitygrantspreview) | **GET** /v1/equity-grants/preview | Forward &#39;Web_PreviewEquityGrant&#39; (opaque pass-through)
*EquityGrantsApi* | [**equityGrantsUpdate**](docs/EquityGrantsApi.md#equitygrantsupdate) | **GET** /v1/equity-grants/update | Forward &#39;Web_UpdateEquityGrant&#39; (opaque pass-through)
*ForecastApi* | [**forecastCreateScenario**](docs/ForecastApi.md#forecastcreatescenario) | **GET** /v1/forecast/scenarios/create | Forward &#39;Web_CreateForecastScenario&#39; (opaque pass-through)
*ForecastApi* | [**forecastDeleteScenario**](docs/ForecastApi.md#forecastdeletescenario) | **GET** /v1/forecast/scenarios/delete | Forward &#39;Web_DeleteForecastScenario&#39; (opaque pass-through)
*ForecastApi* | [**forecastDuplicateScenario**](docs/ForecastApi.md#forecastduplicatescenario) | **GET** /v1/forecast/scenarios/duplicate | Forward &#39;Web_DuplicateForecastScenario&#39; (opaque pass-through)
*ForecastApi* | [**forecastInitialize**](docs/ForecastApi.md#forecastinitialize) | **GET** /v1/forecast/initialize | Forward &#39;Web_InitializeForecast&#39; (opaque pass-through)
*ForecastApi* | [**forecastOnboardingComplete**](docs/ForecastApi.md#forecastonboardingcomplete) | **GET** /v1/forecast/onboarding/complete | Forward &#39;Web_MarkForecastOnboardingComplete&#39; (opaque pass-through)
*ForecastApi* | [**forecastReplaceEvents**](docs/ForecastApi.md#forecastreplaceevents) | **GET** /v1/forecast/events/replace | Forward &#39;Web_ReplaceForecastEvents&#39; (opaque pass-through)
*ForecastApi* | [**forecastResetData**](docs/ForecastApi.md#forecastresetdata) | **GET** /v1/forecast/data/reset | Forward &#39;Web_ResetForecastData&#39; (opaque pass-through)
*ForecastApi* | [**forecastResetOnboarding**](docs/ForecastApi.md#forecastresetonboarding) | **GET** /v1/forecast/onboarding/reset | Forward &#39;Web_ResetForecastOnboarding&#39; (opaque pass-through)
*ForecastApi* | [**forecastSaveAccounts**](docs/ForecastApi.md#forecastsaveaccounts) | **GET** /v1/forecast/accounts | Forward &#39;Web_SaveForecastAccounts&#39; (opaque pass-through)
*ForecastApi* | [**forecastSaveParticipantOverrides**](docs/ForecastApi.md#forecastsaveparticipantoverrides) | **GET** /v1/forecast/participant-overrides | Forward &#39;Web_SaveForecastParticipantOverrides&#39; (opaque pass-through)
*ForecastApi* | [**forecastSavePriorityRules**](docs/ForecastApi.md#forecastsavepriorityrules) | **GET** /v1/forecast/priority-rules | Forward &#39;Web_SaveForecastPriorityRules&#39; (opaque pass-through)
*ForecastApi* | [**forecastSaveScenarioKpis**](docs/ForecastApi.md#forecastsavescenariokpis) | **GET** /v1/forecast/scenario-kpis | Forward &#39;Web_SaveForecastScenarioKpis&#39; (opaque pass-through)
*ForecastApi* | [**forecastScenario**](docs/ForecastApi.md#forecastscenario) | **GET** /v1/forecast/scenario | Forward &#39;Web_ForecastScenario&#39; (opaque pass-through)
*ForecastApi* | [**forecastScenarios**](docs/ForecastApi.md#forecastscenarios) | **GET** /v1/forecast/scenarios | Forward &#39;Web_ForecastScenarios&#39; (opaque pass-through)
*ForecastApi* | [**forecastUpdateScenario**](docs/ForecastApi.md#forecastupdatescenario) | **GET** /v1/forecast/scenarios/update | Forward &#39;Web_UpdateForecastScenario&#39; (opaque pass-through)
*ForecastApi* | [**forecastUpdateScenarioOrder**](docs/ForecastApi.md#forecastupdatescenarioorder) | **GET** /v1/forecast/scenarios/order | Forward &#39;Web_UpdateForecastScenarioOrder&#39; (opaque pass-through)
*ForecastApi* | [**forecastUpdateUserFinancialProfile**](docs/ForecastApi.md#forecastupdateuserfinancialprofile) | **GET** /v1/forecast/user-financial-profile | Forward &#39;Web_ForecastUpdateUserFinancialProfile&#39; (opaque pass-through)
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
*LongTailApi* | [**longTailAccountTransferResultQuery**](docs/LongTailApi.md#longtailaccounttransferresultquery) | **POST** /v1/x/account-transfer-result-query | Long-tail wrapper for &#39;Common_AccountTransferResultQuery&#39;
*LongTailApi* | [**longTailAccountTransferStatusQuery**](docs/LongTailApi.md#longtailaccounttransferstatusquery) | **POST** /v1/x/account-transfer-status-query | Long-tail wrapper for &#39;Common_AccountTransferStatusQuery&#39;
*LongTailApi* | [**longTailAccountsTransferEligibility**](docs/LongTailApi.md#longtailaccountstransfereligibility) | **POST** /v1/x/accounts-transfer-eligibility | Long-tail wrapper for &#39;Common_AccountsTransferEligibility&#39;
*LongTailApi* | [**longTailAllActiveInstitutionNotices**](docs/LongTailApi.md#longtailallactiveinstitutionnotices) | **POST** /v1/x/all-active-institution-notices | Long-tail wrapper for &#39;Common_AllActiveInstitutionNotices&#39;
*LongTailApi* | [**longTailArchiveGoal**](docs/LongTailApi.md#longtailarchivegoal) | **POST** /v1/x/archive-goal | Long-tail wrapper for &#39;Common_ArchiveGoal&#39;
*LongTailApi* | [**longTailCancelMessageThread**](docs/LongTailApi.md#longtailcancelmessagethread) | **POST** /v1/x/cancel-message-thread | Long-tail wrapper for &#39;Common_CancelMessageThread&#39;
*LongTailApi* | [**longTailCancelSubscriptionForHousehold**](docs/LongTailApi.md#longtailcancelsubscriptionforhousehold) | **POST** /v1/x/cancel-subscription-for-household | Long-tail wrapper for &#39;Common_CancelSubscriptionForHousehold&#39;
*LongTailApi* | [**longTailCategoryDeletionInfo**](docs/LongTailApi.md#longtailcategorydeletioninfo) | **POST** /v1/x/category-deletion-info | Long-tail wrapper for &#39;CategoryDeletionInfo&#39;
*LongTailApi* | [**longTailCheckActivityMutation**](docs/LongTailApi.md#longtailcheckactivitymutation) | **POST** /v1/x/check-activity-mutation | Long-tail wrapper for &#39;Common_CheckActivityMutation&#39;
*LongTailApi* | [**longTailCompleteRetailSync**](docs/LongTailApi.md#longtailcompleteretailsync) | **POST** /v1/x/complete-retail-sync | Long-tail wrapper for &#39;Common_CompleteRetailSync&#39;
*LongTailApi* | [**longTailCompleteSavingsGoalsMigration**](docs/LongTailApi.md#longtailcompletesavingsgoalsmigration) | **POST** /v1/x/complete-savings-goals-migration | Long-tail wrapper for &#39;Common_CompleteSavingsGoalsMigration&#39;
*LongTailApi* | [**longTailCreateAccountsFromPlaidToken**](docs/LongTailApi.md#longtailcreateaccountsfromplaidtoken) | **POST** /v1/x/create-accounts-from-plaid-token | Long-tail wrapper for &#39;Common_CreateAccountsFromPlaidToken&#39;
*LongTailApi* | [**longTailCreateBudgetForHousehold**](docs/LongTailApi.md#longtailcreatebudgetforhousehold) | **POST** /v1/x/create-budget-for-household | Long-tail wrapper for &#39;Common_CreateBudgetForHousehold&#39;
*LongTailApi* | [**longTailCreateBulkRetailSync**](docs/LongTailApi.md#longtailcreatebulkretailsync) | **POST** /v1/x/create-bulk-retail-sync | Long-tail wrapper for &#39;Common_CreateBulkRetailSync&#39;
*LongTailApi* | [**longTailCreateGoalAccountAllocation**](docs/LongTailApi.md#longtailcreategoalaccountallocation) | **POST** /v1/x/create-goal-account-allocation | Long-tail wrapper for &#39;Common_CreateGoalAccountAllocation&#39;
*LongTailApi* | [**longTailCreateGoals**](docs/LongTailApi.md#longtailcreategoals) | **POST** /v1/x/create-goals | Long-tail wrapper for &#39;Common_CreateGoals&#39;
*LongTailApi* | [**longTailCreateHouseholdAccessGrant**](docs/LongTailApi.md#longtailcreatehouseholdaccessgrant) | **POST** /v1/x/create-household-access-grant | Long-tail wrapper for &#39;CreateHouseholdAccessGrant&#39;
*LongTailApi* | [**longTailCreateInstitutionIssueReportMutation**](docs/LongTailApi.md#longtailcreateinstitutionissuereportmutation) | **POST** /v1/x/create-institution-issue-report-mutation | Long-tail wrapper for &#39;Common_CreateInstitutionIssueReportMutation&#39;
*LongTailApi* | [**longTailCreateOrUpdateGoalV2PlannedContributionMutation**](docs/LongTailApi.md#longtailcreateorupdategoalv2plannedcontributionmutation) | **POST** /v1/x/create-or-update-goal-v2-planned-contribution-mutation | Long-tail wrapper for &#39;Common_CreateOrUpdateGoalV2PlannedContributionMutation&#39;
*LongTailApi* | [**longTailCreatePromoCodeCheckoutSession**](docs/LongTailApi.md#longtailcreatepromocodecheckoutsession) | **POST** /v1/x/create-promo-code-checkout-session | Long-tail wrapper for &#39;CreatePromoCodeCheckoutSession&#39;
*LongTailApi* | [**longTailCreateRetailSync**](docs/LongTailApi.md#longtailcreateretailsync) | **POST** /v1/x/create-retail-sync | Long-tail wrapper for &#39;Common_CreateRetailSync&#39;
*LongTailApi* | [**longTailCreateSavingsGoalAccountInitialContributions**](docs/LongTailApi.md#longtailcreatesavingsgoalaccountinitialcontributions) | **POST** /v1/x/create-savings-goal-account-initial-contributions | Long-tail wrapper for &#39;Common_CreateSavingsGoalAccountInitialContributions&#39;
*LongTailApi* | [**longTailCreateThreadMutation**](docs/LongTailApi.md#longtailcreatethreadmutation) | **POST** /v1/x/create-thread-mutation | Long-tail wrapper for &#39;Common_CreateThreadMutation&#39;
*LongTailApi* | [**longTailDebtPaydown**](docs/LongTailApi.md#longtaildebtpaydown) | **POST** /v1/x/debt-paydown | Long-tail wrapper for &#39;Common_DebtPaydown&#39;
*LongTailApi* | [**longTailDebtPaydownAccounts**](docs/LongTailApi.md#longtaildebtpaydownaccounts) | **POST** /v1/x/debt-paydown-accounts | Long-tail wrapper for &#39;Common_DebtPaydownAccounts&#39;
*LongTailApi* | [**longTailDeleteAllMessageThreads**](docs/LongTailApi.md#longtaildeleteallmessagethreads) | **POST** /v1/x/delete-all-message-threads | Long-tail wrapper for &#39;Common_DeleteAllMessageThreads&#39;
*LongTailApi* | [**longTailDeleteGoalAccountAllocation**](docs/LongTailApi.md#longtaildeletegoalaccountallocation) | **POST** /v1/x/delete-goal-account-allocation | Long-tail wrapper for &#39;Common_DeleteGoalAccountAllocation&#39;
*LongTailApi* | [**longTailDeleteHousehold**](docs/LongTailApi.md#longtaildeletehousehold) | **POST** /v1/x/delete-household | Long-tail wrapper for &#39;Common_DeleteHousehold&#39;
*LongTailApi* | [**longTailDeleteMessageThread**](docs/LongTailApi.md#longtaildeletemessagethread) | **POST** /v1/x/delete-message-thread | Long-tail wrapper for &#39;Common_DeleteMessageThread&#39;
*LongTailApi* | [**longTailDeleteRetailSync**](docs/LongTailApi.md#longtaildeleteretailsync) | **POST** /v1/x/delete-retail-sync | Long-tail wrapper for &#39;Common_DeleteRetailSync&#39;
*LongTailApi* | [**longTailDeleteSavingsGoalEvent**](docs/LongTailApi.md#longtaildeletesavingsgoalevent) | **POST** /v1/x/delete-savings-goal-event | Long-tail wrapper for &#39;Common_DeleteSavingsGoalEvent&#39;
*LongTailApi* | [**longTailDeleteSyncedSnapshotsMutation**](docs/LongTailApi.md#longtaildeletesyncedsnapshotsmutation) | **POST** /v1/x/delete-synced-snapshots-mutation | Long-tail wrapper for &#39;Common_DeleteSyncedSnapshotsMutation&#39;
*LongTailApi* | [**longTailDeleteSyncedTransactionsMutation**](docs/LongTailApi.md#longtaildeletesyncedtransactionsmutation) | **POST** /v1/x/delete-synced-transactions-mutation | Long-tail wrapper for &#39;Common_DeleteSyncedTransactionsMutation&#39;
*LongTailApi* | [**longTailDeleteTransactionsMutation**](docs/LongTailApi.md#longtaildeletetransactionsmutation) | **POST** /v1/x/delete-transactions-mutation | Long-tail wrapper for &#39;Common_DeleteTransactionsMutation&#39;
*LongTailApi* | [**longTailDisableCredentialAndDeleteFromDataProvider**](docs/LongTailApi.md#longtaildisablecredentialanddeletefromdataprovider) | **POST** /v1/x/disable-credential-and-delete-from-data-provider | Long-tail wrapper for &#39;Common_DisableCredentialAndDeleteFromDataProvider&#39;
*LongTailApi* | [**longTailDisconnectSpinwheel**](docs/LongTailApi.md#longtaildisconnectspinwheel) | **POST** /v1/x/disconnect-spinwheel | Long-tail wrapper for &#39;Common_DisconnectSpinwheel&#39;
*LongTailApi* | [**longTailDismissBusinessEntitiesBanner**](docs/LongTailApi.md#longtaildismissbusinessentitiesbanner) | **POST** /v1/x/dismiss-business-entities-banner | Long-tail wrapper for &#39;Common_DismissBusinessEntitiesBanner&#39;
*LongTailApi* | [**longTailDispatchSavingsGoalMigration**](docs/LongTailApi.md#longtaildispatchsavingsgoalmigration) | **POST** /v1/x/dispatch-savings-goal-migration | Long-tail wrapper for &#39;Common_DispatchSavingsGoalMigration&#39;
*LongTailApi* | [**longTailFixCoinbaseCredential**](docs/LongTailApi.md#longtailfixcoinbasecredential) | **POST** /v1/x/fix-coinbase-credential | Long-tail wrapper for &#39;Common_FixCoinbaseCredential&#39;
*LongTailApi* | [**longTailForceRefreshAccountMutation**](docs/LongTailApi.md#longtailforcerefreshaccountmutation) | **POST** /v1/x/force-refresh-account-mutation | Long-tail wrapper for &#39;Common_ForceRefreshAccountMutation&#39;
*LongTailApi* | [**longTailForceRefreshAccountQuery**](docs/LongTailApi.md#longtailforcerefreshaccountquery) | **POST** /v1/x/force-refresh-account-query | Long-tail wrapper for &#39;Common_ForceRefreshAccountQuery&#39;
*LongTailApi* | [**longTailForceRefreshOperationQuery**](docs/LongTailApi.md#longtailforcerefreshoperationquery) | **POST** /v1/x/force-refresh-operation-query | Long-tail wrapper for &#39;Common_ForceRefreshOperationQuery&#39;
*LongTailApi* | [**longTailGetAccount**](docs/LongTailApi.md#longtailgetaccount) | **POST** /v1/x/get-account | Long-tail wrapper for &#39;Common_GetAccount&#39;
*LongTailApi* | [**longTailGetAccountsForEditingEntities**](docs/LongTailApi.md#longtailgetaccountsforeditingentities) | **POST** /v1/x/get-accounts-for-editing-entities | Long-tail wrapper for &#39;Common_GetAccountsForEditingEntities&#39;
*LongTailApi* | [**longTailGetAccountsForEditingOwnership**](docs/LongTailApi.md#longtailgetaccountsforeditingownership) | **POST** /v1/x/get-accounts-for-editing-ownership | Long-tail wrapper for &#39;Common_GetAccountsForEditingOwnership&#39;
*LongTailApi* | [**longTailGetActAsUserExternalId**](docs/LongTailApi.md#longtailgetactasuserexternalid) | **POST** /v1/x/get-act-as-user-external-id | Long-tail wrapper for &#39;Common_GetActAsUserExternalId&#39;
*LongTailApi* | [**longTailGetAggregatesGraph**](docs/LongTailApi.md#longtailgetaggregatesgraph) | **POST** /v1/x/get-aggregates-graph | Long-tail wrapper for &#39;GetAggregatesGraph&#39;
*LongTailApi* | [**longTailGetAggregatesGraphCategoryGroup**](docs/LongTailApi.md#longtailgetaggregatesgraphcategorygroup) | **POST** /v1/x/get-aggregates-graph-category-group | Long-tail wrapper for &#39;GetAggregatesGraphCategoryGroup&#39;
*LongTailApi* | [**longTailGetAggregatesGraphFlexExpense**](docs/LongTailApi.md#longtailgetaggregatesgraphflexexpense) | **POST** /v1/x/get-aggregates-graph-flex-expense | Long-tail wrapper for &#39;GetAggregatesGraphFlexExpense&#39;
*LongTailApi* | [**longTailGetAssistantFeedback**](docs/LongTailApi.md#longtailgetassistantfeedback) | **POST** /v1/x/get-assistant-feedback | Long-tail wrapper for &#39;Common_GetAssistantFeedback&#39;
*LongTailApi* | [**longTailGetBusinessEntities**](docs/LongTailApi.md#longtailgetbusinessentities) | **POST** /v1/x/get-business-entities | Long-tail wrapper for &#39;Common_GetBusinessEntities&#39;
*LongTailApi* | [**longTailGetBusinessEntitiesBannerProfile**](docs/LongTailApi.md#longtailgetbusinessentitiesbannerprofile) | **POST** /v1/x/get-business-entities-banner-profile | Long-tail wrapper for &#39;Common_GetBusinessEntitiesBannerProfile&#39;
*LongTailApi* | [**longTailGetBusinessEntitiesSummary**](docs/LongTailApi.md#longtailgetbusinessentitiessummary) | **POST** /v1/x/get-business-entities-summary | Long-tail wrapper for &#39;Common_GetBusinessEntitiesSummary&#39;
*LongTailApi* | [**longTailGetCanRequestReview**](docs/LongTailApi.md#longtailgetcanrequestreview) | **POST** /v1/x/get-can-request-review | Long-tail wrapper for &#39;GetCanRequestReview&#39;
*LongTailApi* | [**longTailGetCanSkipPremiumUpsell**](docs/LongTailApi.md#longtailgetcanskippremiumupsell) | **POST** /v1/x/get-can-skip-premium-upsell | Long-tail wrapper for &#39;GetCanSkipPremiumUpsell&#39;
*LongTailApi* | [**longTailGetCategoryDetails**](docs/LongTailApi.md#longtailgetcategorydetails) | **POST** /v1/x/get-category-details | Long-tail wrapper for &#39;GetCategoryDetails&#39;
*LongTailApi* | [**longTailGetCategoryEntity**](docs/LongTailApi.md#longtailgetcategoryentity) | **POST** /v1/x/get-category-entity | Long-tail wrapper for &#39;Common_GetCategoryEntity&#39;
*LongTailApi* | [**longTailGetCategoryGroup**](docs/LongTailApi.md#longtailgetcategorygroup) | **POST** /v1/x/get-category-group | Long-tail wrapper for &#39;GetCategoryGroup&#39;
*LongTailApi* | [**longTailGetCategoryGroups**](docs/LongTailApi.md#longtailgetcategorygroups) | **POST** /v1/x/get-category-groups | Long-tail wrapper for &#39;GetCategoryGroups&#39;
*LongTailApi* | [**longTailGetCloudinaryUploadInfo**](docs/LongTailApi.md#longtailgetcloudinaryuploadinfo) | **POST** /v1/x/get-cloudinary-upload-info | Long-tail wrapper for &#39;Common_GetCloudinaryUploadInfo&#39;
*LongTailApi* | [**longTailGetContactSupportFormRecommendedResolution**](docs/LongTailApi.md#longtailgetcontactsupportformrecommendedresolution) | **POST** /v1/x/get-contact-support-form-recommended-resolution | Long-tail wrapper for &#39;GetContactSupportFormRecommendedResolution&#39;
*LongTailApi* | [**longTailGetDashboardConfig**](docs/LongTailApi.md#longtailgetdashboardconfig) | **POST** /v1/x/get-dashboard-config | Long-tail wrapper for &#39;GetDashboardConfig&#39;
*LongTailApi* | [**longTailGetDebtAccountsForMigration**](docs/LongTailApi.md#longtailgetdebtaccountsformigration) | **POST** /v1/x/get-debt-accounts-for-migration | Long-tail wrapper for &#39;Common_GetDebtAccountsForMigration&#39;
*LongTailApi* | [**longTailGetDecagonInstitutionsStatus**](docs/LongTailApi.md#longtailgetdecagoninstitutionsstatus) | **POST** /v1/x/get-decagon-institutions-status | Long-tail wrapper for &#39;Common_GetDecagonInstitutionsStatus&#39;
*LongTailApi* | [**longTailGetDecagonLinkedCredentials**](docs/LongTailApi.md#longtailgetdecagonlinkedcredentials) | **POST** /v1/x/get-decagon-linked-credentials | Long-tail wrapper for &#39;Common_GetDecagonLinkedCredentials&#39;
*LongTailApi* | [**longTailGetDecagonSubscriptionStatus**](docs/LongTailApi.md#longtailgetdecagonsubscriptionstatus) | **POST** /v1/x/get-decagon-subscription-status | Long-tail wrapper for &#39;Common_GetDecagonSubscriptionStatus&#39;
*LongTailApi* | [**longTailGetDecagonToken**](docs/LongTailApi.md#longtailgetdecagontoken) | **POST** /v1/x/get-decagon-token | Long-tail wrapper for &#39;Common_GetDecagonToken&#39;
*LongTailApi* | [**longTailGetFeatureEntitlementParams**](docs/LongTailApi.md#longtailgetfeatureentitlementparams) | **POST** /v1/x/get-feature-entitlement-params | Long-tail wrapper for &#39;Common_GetFeatureEntitlementParams&#39;
*LongTailApi* | [**longTailGetGiftedSubscriptions**](docs/LongTailApi.md#longtailgetgiftedsubscriptions) | **POST** /v1/x/get-gifted-subscriptions | Long-tail wrapper for &#39;Common_GetGiftedSubscriptions&#39;
*LongTailApi* | [**longTailGetGoalsV2**](docs/LongTailApi.md#longtailgetgoalsv2) | **POST** /v1/x/get-goals-v2 | Long-tail wrapper for &#39;GetGoalsV2&#39;
*LongTailApi* | [**longTailGetHasAccounts**](docs/LongTailApi.md#longtailgethasaccounts) | **POST** /v1/x/get-has-accounts | Long-tail wrapper for &#39;Common_GetHasAccounts&#39;
*LongTailApi* | [**longTailGetHasSpinwheelUser**](docs/LongTailApi.md#longtailgethasspinwheeluser) | **POST** /v1/x/get-has-spinwheel-user | Long-tail wrapper for &#39;Common_GetHasSpinwheelUser&#39;
*LongTailApi* | [**longTailGetHasSyncedAccounts**](docs/LongTailApi.md#longtailgethassyncedaccounts) | **POST** /v1/x/get-has-synced-accounts | Long-tail wrapper for &#39;Common_GetHasSyncedAccounts&#39;
*LongTailApi* | [**longTailGetHoldingDetailsFormSecurityDetails**](docs/LongTailApi.md#longtailgetholdingdetailsformsecuritydetails) | **POST** /v1/x/get-holding-details-form-security-details | Long-tail wrapper for &#39;GetHoldingDetailsFormSecurityDetails&#39;
*LongTailApi* | [**longTailGetHoldingSummarySecurityDetails**](docs/LongTailApi.md#longtailgetholdingsummarysecuritydetails) | **POST** /v1/x/get-holding-summary-security-details | Long-tail wrapper for &#39;GetHoldingSummarySecurityDetails&#39;
*LongTailApi* | [**longTailGetHouseHoldMemberSettings**](docs/LongTailApi.md#longtailgethouseholdmembersettings) | **POST** /v1/x/get-house-hold-member-settings | Long-tail wrapper for &#39;Common_GetHouseHoldMemberSettings&#39;
*LongTailApi* | [**longTailGetInstitutionByProviderId**](docs/LongTailApi.md#longtailgetinstitutionbyproviderid) | **POST** /v1/x/get-institution-by-provider-id | Long-tail wrapper for &#39;GetInstitutionByProviderId&#39;
*LongTailApi* | [**longTailGetInstitutionLogoByPlaidId**](docs/LongTailApi.md#longtailgetinstitutionlogobyplaidid) | **POST** /v1/x/get-institution-logo-by-plaid-id | Long-tail wrapper for &#39;GetInstitutionLogoByPlaidId&#39;
*LongTailApi* | [**longTailGetMerchant**](docs/LongTailApi.md#longtailgetmerchant) | **POST** /v1/x/get-merchant | Long-tail wrapper for &#39;Common_GetMerchant&#39;
*LongTailApi* | [**longTailGetMerchantDetails**](docs/LongTailApi.md#longtailgetmerchantdetails) | **POST** /v1/x/get-merchant-details | Long-tail wrapper for &#39;GetMerchantDetails&#39;
*LongTailApi* | [**longTailGetMerchantEntity**](docs/LongTailApi.md#longtailgetmerchantentity) | **POST** /v1/x/get-merchant-entity | Long-tail wrapper for &#39;Common_GetMerchantEntity&#39;
*LongTailApi* | [**longTailGetMessageThread**](docs/LongTailApi.md#longtailgetmessagethread) | **POST** /v1/x/get-message-thread | Long-tail wrapper for &#39;Common_GetMessageThread&#39;
*LongTailApi* | [**longTailGetMessageThreads**](docs/LongTailApi.md#longtailgetmessagethreads) | **POST** /v1/x/get-message-threads | Long-tail wrapper for &#39;Common_GetMessageThreads&#39;
*LongTailApi* | [**longTailGetMobileSubscriptionOffering**](docs/LongTailApi.md#longtailgetmobilesubscriptionoffering) | **POST** /v1/x/get-mobile-subscription-offering | Long-tail wrapper for &#39;GetMobileSubscriptionOffering&#39;
*LongTailApi* | [**longTailGetNotificationPreference**](docs/LongTailApi.md#longtailgetnotificationpreference) | **POST** /v1/x/get-notification-preference | Long-tail wrapper for &#39;Common_GetNotificationPreference&#39;
*LongTailApi* | [**longTailGetOnboardingFinancialGoals**](docs/LongTailApi.md#longtailgetonboardingfinancialgoals) | **POST** /v1/x/get-onboarding-financial-goals | Long-tail wrapper for &#39;Common_GetOnboardingFinancialGoals&#39;
*LongTailApi* | [**longTailGetPlanOnboardingState**](docs/LongTailApi.md#longtailgetplanonboardingstate) | **POST** /v1/x/get-plan-onboarding-state | Long-tail wrapper for &#39;Common_GetPlanOnboardingState&#39;
*LongTailApi* | [**longTailGetPremiumUpgradePlans**](docs/LongTailApi.md#longtailgetpremiumupgradeplans) | **POST** /v1/x/get-premium-upgrade-plans | Long-tail wrapper for &#39;Common_GetPremiumUpgradePlans&#39;
*LongTailApi* | [**longTailGetReferralConstants**](docs/LongTailApi.md#longtailgetreferralconstants) | **POST** /v1/x/get-referral-constants | Long-tail wrapper for &#39;Common_GetReferralConstants&#39;
*LongTailApi* | [**longTailGetReferralSettings**](docs/LongTailApi.md#longtailgetreferralsettings) | **POST** /v1/x/get-referral-settings | Long-tail wrapper for &#39;Common_GetReferralSettings&#39;
*LongTailApi* | [**longTailGetReportsData**](docs/LongTailApi.md#longtailgetreportsdata) | **POST** /v1/x/get-reports-data | Long-tail wrapper for &#39;Common_GetReportsData&#39;
*LongTailApi* | [**longTailGetRetailExtensionSettings**](docs/LongTailApi.md#longtailgetretailextensionsettings) | **POST** /v1/x/get-retail-extension-settings | Long-tail wrapper for &#39;Common_GetRetailExtensionSettings&#39;
*LongTailApi* | [**longTailGetReviewedAccountLastStatements**](docs/LongTailApi.md#longtailgetreviewedaccountlaststatements) | **POST** /v1/x/get-reviewed-account-last-statements | Long-tail wrapper for &#39;Common_GetReviewedAccountLastStatements&#39;
*LongTailApi* | [**longTailGetReviewedMerchantLastTransactions**](docs/LongTailApi.md#longtailgetreviewedmerchantlasttransactions) | **POST** /v1/x/get-reviewed-merchant-last-transactions | Long-tail wrapper for &#39;Common_GetReviewedMerchantLastTransactions&#39;
*LongTailApi* | [**longTailGetSmartPrompts**](docs/LongTailApi.md#longtailgetsmartprompts) | **POST** /v1/x/get-smart-prompts | Long-tail wrapper for &#39;Common_GetSmartPrompts&#39;
*LongTailApi* | [**longTailGetSpinwheelCreditReport**](docs/LongTailApi.md#longtailgetspinwheelcreditreport) | **POST** /v1/x/get-spinwheel-credit-report | Long-tail wrapper for &#39;Common_GetSpinwheelCreditReport&#39;
*LongTailApi* | [**longTailGetSubscriptionHasEntitlementAfterSync**](docs/LongTailApi.md#longtailgetsubscriptionhasentitlementaftersync) | **POST** /v1/x/get-subscription-has-entitlement-after-sync | Long-tail wrapper for &#39;Common_GetSubscriptionHasEntitlementAfterSync&#39;
*LongTailApi* | [**longTailGetSubscriptionStatus**](docs/LongTailApi.md#longtailgetsubscriptionstatus) | **POST** /v1/x/get-subscription-status | Long-tail wrapper for &#39;GetSubscriptionStatus&#39;
*LongTailApi* | [**longTailGetTransactionFiltersCard**](docs/LongTailApi.md#longtailgettransactionfilterscard) | **POST** /v1/x/get-transaction-filters-card | Long-tail wrapper for &#39;GetTransactionFiltersCard&#39;
*LongTailApi* | [**longTailGetTransactions**](docs/LongTailApi.md#longtailgettransactions) | **POST** /v1/x/get-transactions | Long-tail wrapper for &#39;GetTransactions&#39;
*LongTailApi* | [**longTailGetTrialStatus**](docs/LongTailApi.md#longtailgettrialstatus) | **POST** /v1/x/get-trial-status | Long-tail wrapper for &#39;GetTrialStatus&#39;
*LongTailApi* | [**longTailGetUploadStatementSession**](docs/LongTailApi.md#longtailgetuploadstatementsession) | **POST** /v1/x/get-upload-statement-session | Long-tail wrapper for &#39;GetUploadStatementSession&#39;
*LongTailApi* | [**longTailGetUserReportedOnboardingAttributionChannels**](docs/LongTailApi.md#longtailgetuserreportedonboardingattributionchannels) | **POST** /v1/x/get-user-reported-onboarding-attribution-channels | Long-tail wrapper for &#39;Common_GetUserReportedOnboardingAttributionChannels&#39;
*LongTailApi* | [**longTailGetYearlyReviewStatus**](docs/LongTailApi.md#longtailgetyearlyreviewstatus) | **POST** /v1/x/get-yearly-review-status | Long-tail wrapper for &#39;GetYearlyReviewStatus&#39;
*LongTailApi* | [**longTailGoalAccountsForInitialContribution**](docs/LongTailApi.md#longtailgoalaccountsforinitialcontribution) | **POST** /v1/x/goal-accounts-for-initial-contribution | Long-tail wrapper for &#39;Common_GoalAccountsForInitialContribution&#39;
*LongTailApi* | [**longTailGoalOptions**](docs/LongTailApi.md#longtailgoaloptions) | **POST** /v1/x/goal-options | Long-tail wrapper for &#39;Common_GoalOptions&#39;
*LongTailApi* | [**longTailGoalReconciliationHistory**](docs/LongTailApi.md#longtailgoalreconciliationhistory) | **POST** /v1/x/goal-reconciliation-history | Long-tail wrapper for &#39;Common_GoalReconciliationHistory&#39;
*LongTailApi* | [**longTailGoalReconciliationTransactionInfo**](docs/LongTailApi.md#longtailgoalreconciliationtransactioninfo) | **POST** /v1/x/goal-reconciliation-transaction-info | Long-tail wrapper for &#39;Common_GoalReconciliationTransactionInfo&#39;
*LongTailApi* | [**longTailGoalSelectAccounts**](docs/LongTailApi.md#longtailgoalselectaccounts) | **POST** /v1/x/goal-select-accounts | Long-tail wrapper for &#39;GoalSelectAccounts&#39;
*LongTailApi* | [**longTailGoalsV2MigrationQuery**](docs/LongTailApi.md#longtailgoalsv2migrationquery) | **POST** /v1/x/goals-v2-migration-query | Long-tail wrapper for &#39;Common_GoalsV2MigrationQuery&#39;
*LongTailApi* | [**longTailHasActivity**](docs/LongTailApi.md#longtailhasactivity) | **POST** /v1/x/has-activity | Long-tail wrapper for &#39;Common_HasActivity&#39;
*LongTailApi* | [**longTailInitializeFlexBudget**](docs/LongTailApi.md#longtailinitializeflexbudget) | **POST** /v1/x/initialize-flex-budget | Long-tail wrapper for &#39;Common_InitializeFlexBudget&#39;
*LongTailApi* | [**longTailLegacyGoalsMigrationQuery**](docs/LongTailApi.md#longtaillegacygoalsmigrationquery) | **POST** /v1/x/legacy-goals-migration-query | Long-tail wrapper for &#39;Common_LegacyGoalsMigrationQuery&#39;
*LongTailApi* | [**longTailMarkRecurringLiabilityStatementAsPaid**](docs/LongTailApi.md#longtailmarkrecurringliabilitystatementaspaid) | **POST** /v1/x/mark-recurring-liability-statement-as-paid | Long-tail wrapper for &#39;Common_MarkRecurringLiabilityStatementAsPaid&#39;
*LongTailApi* | [**longTailMatchRetailTransaction**](docs/LongTailApi.md#longtailmatchretailtransaction) | **POST** /v1/x/match-retail-transaction | Long-tail wrapper for &#39;Common_MatchRetailTransaction&#39;
*LongTailApi* | [**longTailMigratedToSavingsGoals**](docs/LongTailApi.md#longtailmigratedtosavingsgoals) | **POST** /v1/x/migrated-to-savings-goals | Long-tail wrapper for &#39;Common_MigratedToSavingsGoals&#39;
*LongTailApi* | [**longTailMigratedToSavingsGoalsAt**](docs/LongTailApi.md#longtailmigratedtosavingsgoalsat) | **POST** /v1/x/migrated-to-savings-goals-at | Long-tail wrapper for &#39;Common_MigratedToSavingsGoalsAt&#39;
*LongTailApi* | [**longTailMoveMoneyScreenQuery**](docs/LongTailApi.md#longtailmovemoneyscreenquery) | **POST** /v1/x/move-money-screen-query | Long-tail wrapper for &#39;MoveMoneyScreenQuery&#39;
*LongTailApi* | [**longTailOldestDeletableTransactionDate**](docs/LongTailApi.md#longtailoldestdeletabletransactiondate) | **POST** /v1/x/oldest-deletable-transaction-date | Long-tail wrapper for &#39;Common_OldestDeletableTransactionDate&#39;
*LongTailApi* | [**longTailOnboardingChecklist**](docs/LongTailApi.md#longtailonboardingchecklist) | **POST** /v1/x/onboarding-checklist | Long-tail wrapper for &#39;Common_OnboardingChecklist&#39;
*LongTailApi* | [**longTailPreviewDeleteTransactions**](docs/LongTailApi.md#longtailpreviewdeletetransactions) | **POST** /v1/x/preview-delete-transactions | Long-tail wrapper for &#39;Common_PreviewDeleteTransactions&#39;
*LongTailApi* | [**longTailQuestionnaireIntroQuery**](docs/LongTailApi.md#longtailquestionnaireintroquery) | **POST** /v1/x/questionnaire-intro-query | Long-tail wrapper for &#39;QuestionnaireIntroQuery_Web&#39;
*LongTailApi* | [**longTailReconcileAccountGoalSpendingForTransactions**](docs/LongTailApi.md#longtailreconcileaccountgoalspendingfortransactions) | **POST** /v1/x/reconcile-account-goal-spending-for-transactions | Long-tail wrapper for &#39;Common_ReconcileAccountGoalSpendingForTransactions&#39;
*LongTailApi* | [**longTailReconcileExternalSpending**](docs/LongTailApi.md#longtailreconcileexternalspending) | **POST** /v1/x/reconcile-external-spending | Long-tail wrapper for &#39;Common_ReconcileExternalSpending&#39;
*LongTailApi* | [**longTailRecordBusinessEntitiesBannerImpression**](docs/LongTailApi.md#longtailrecordbusinessentitiesbannerimpression) | **POST** /v1/x/record-business-entities-banner-impression | Long-tail wrapper for &#39;Common_RecordBusinessEntitiesBannerImpression&#39;
*LongTailApi* | [**longTailRecordSmartPromptClick**](docs/LongTailApi.md#longtailrecordsmartpromptclick) | **POST** /v1/x/record-smart-prompt-click | Long-tail wrapper for &#39;Common_RecordSmartPromptClick&#39;
*LongTailApi* | [**longTailRecordSmartPromptImpressions**](docs/LongTailApi.md#longtailrecordsmartpromptimpressions) | **POST** /v1/x/record-smart-prompt-impressions | Long-tail wrapper for &#39;Common_RecordSmartPromptImpressions&#39;
*LongTailApi* | [**longTailRecurringMerchantSearch**](docs/LongTailApi.md#longtailrecurringmerchantsearch) | **POST** /v1/x/recurring-merchant-search | Long-tail wrapper for &#39;RecurringMerchantSearch&#39;
*LongTailApi* | [**longTailRecurringUpdateLiabilityStatement**](docs/LongTailApi.md#longtailrecurringupdateliabilitystatement) | **POST** /v1/x/recurring-update-liability-statement | Long-tail wrapper for &#39;Common_RecurringUpdateLiabilityStatement&#39;
*LongTailApi* | [**longTailRecurringUpdateMerchant**](docs/LongTailApi.md#longtailrecurringupdatemerchant) | **POST** /v1/x/recurring-update-merchant | Long-tail wrapper for &#39;Common_RecurringUpdateMerchant&#39;
*LongTailApi* | [**longTailRedeemTrustAndWill**](docs/LongTailApi.md#longtailredeemtrustandwill) | **POST** /v1/x/redeem-trust-and-will | Long-tail wrapper for &#39;Common_RedeemTrustAndWill&#39;
*LongTailApi* | [**longTailRequestInstitution**](docs/LongTailApi.md#longtailrequestinstitution) | **POST** /v1/x/request-institution | Long-tail wrapper for &#39;Common_RequestInstitution&#39;
*LongTailApi* | [**longTailResendInviteToHousehold**](docs/LongTailApi.md#longtailresendinvitetohousehold) | **POST** /v1/x/resend-invite-to-household | Long-tail wrapper for &#39;Common_ResendInviteToHousehold&#39;
*LongTailApi* | [**longTailResendReferralRewardEmail**](docs/LongTailApi.md#longtailresendreferralrewardemail) | **POST** /v1/x/resend-referral-reward-email | Long-tail wrapper for &#39;Common_ResendReferralRewardEmail&#39;
*LongTailApi* | [**longTailRetailSyncQuery**](docs/LongTailApi.md#longtailretailsyncquery) | **POST** /v1/x/retail-sync-query | Long-tail wrapper for &#39;Common_RetailSyncQuery&#39;
*LongTailApi* | [**longTailRetailSyncsQueryWithTotal**](docs/LongTailApi.md#longtailretailsyncsquerywithtotal) | **POST** /v1/x/retail-syncs-query-with-total | Long-tail wrapper for &#39;Common_RetailSyncsQueryWithTotal&#39;
*LongTailApi* | [**longTailReviewQuery**](docs/LongTailApi.md#longtailreviewquery) | **POST** /v1/x/review-query | Long-tail wrapper for &#39;ReviewQuery&#39;
*LongTailApi* | [**longTailReviewStream**](docs/LongTailApi.md#longtailreviewstream) | **POST** /v1/x/review-stream | Long-tail wrapper for &#39;Common_ReviewStream&#39;
*LongTailApi* | [**longTailRevokeHouseholdAccessGrant**](docs/LongTailApi.md#longtailrevokehouseholdaccessgrant) | **POST** /v1/x/revoke-household-access-grant | Long-tail wrapper for &#39;Common_RevokeHouseholdAccessGrant&#39;
*LongTailApi* | [**longTailRevokeInviteToHousehold**](docs/LongTailApi.md#longtailrevokeinvitetohousehold) | **POST** /v1/x/revoke-invite-to-household | Long-tail wrapper for &#39;Common_RevokeInviteToHousehold&#39;
*LongTailApi* | [**longTailSaveDebtPaydownProjectionToBudget**](docs/LongTailApi.md#longtailsavedebtpaydownprojectiontobudget) | **POST** /v1/x/save-debt-paydown-projection-to-budget | Long-tail wrapper for &#39;Common_SaveDebtPaydownProjectionToBudget&#39;
*LongTailApi* | [**longTailSavingsGoalAccount**](docs/LongTailApi.md#longtailsavingsgoalaccount) | **POST** /v1/x/savings-goal-account | Long-tail wrapper for &#39;Common_SavingsGoalAccount&#39;
*LongTailApi* | [**longTailSavingsGoalAccounts**](docs/LongTailApi.md#longtailsavingsgoalaccounts) | **POST** /v1/x/savings-goal-accounts | Long-tail wrapper for &#39;Common_SavingsGoalAccounts&#39;
*LongTailApi* | [**longTailSavingsGoalAccountsAllocationSummary**](docs/LongTailApi.md#longtailsavingsgoalaccountsallocationsummary) | **POST** /v1/x/savings-goal-accounts-allocation-summary | Long-tail wrapper for &#39;Common_SavingsGoalAccountsAllocationSummary&#39;
*LongTailApi* | [**longTailSavingsGoalBudgetAmounts**](docs/LongTailApi.md#longtailsavingsgoalbudgetamounts) | **POST** /v1/x/savings-goal-budget-amounts | Long-tail wrapper for &#39;Common_SavingsGoalBudgetAmounts&#39;
*LongTailApi* | [**longTailSavingsGoalBudgetAmountsWithRecommendation**](docs/LongTailApi.md#longtailsavingsgoalbudgetamountswithrecommendation) | **POST** /v1/x/savings-goal-budget-amounts-with-recommendation | Long-tail wrapper for &#39;Common_SavingsGoalBudgetAmountsWithRecommendation&#39;
*LongTailApi* | [**longTailSavingsGoalEditAccounts**](docs/LongTailApi.md#longtailsavingsgoaleditaccounts) | **POST** /v1/x/savings-goal-edit-accounts | Long-tail wrapper for &#39;Common_SavingsGoalEditAccounts&#39;
*LongTailApi* | [**longTailSavingsGoalMigrationStatus**](docs/LongTailApi.md#longtailsavingsgoalmigrationstatus) | **POST** /v1/x/savings-goal-migration-status | Long-tail wrapper for &#39;Common_SavingsGoalMigrationStatus&#39;
*LongTailApi* | [**longTailSavingsGoalReconciliationAccount**](docs/LongTailApi.md#longtailsavingsgoalreconciliationaccount) | **POST** /v1/x/savings-goal-reconciliation-account | Long-tail wrapper for &#39;Common_SavingsGoalReconciliationAccount&#39;
*LongTailApi* | [**longTailSavingsGoalsAllocationAmountsByAccount**](docs/LongTailApi.md#longtailsavingsgoalsallocationamountsbyaccount) | **POST** /v1/x/savings-goals-allocation-amounts-by-account | Long-tail wrapper for &#39;Common_SavingsGoalsAllocationAmountsByAccount&#39;
*LongTailApi* | [**longTailSavingsGoalsPrioritizeList**](docs/LongTailApi.md#longtailsavingsgoalsprioritizelist) | **POST** /v1/x/savings-goals-prioritize-list | Long-tail wrapper for &#39;Common_SavingsGoalsPrioritizeList&#39;
*LongTailApi* | [**longTailSavingsGoalsTypes**](docs/LongTailApi.md#longtailsavingsgoalstypes) | **POST** /v1/x/savings-goals-types | Long-tail wrapper for &#39;Common_SavingsGoalsTypes&#39;
*LongTailApi* | [**longTailSavingsGoalsWithThisMonthBalances**](docs/LongTailApi.md#longtailsavingsgoalswiththismonthbalances) | **POST** /v1/x/savings-goals-with-this-month-balances | Long-tail wrapper for &#39;Common_SavingsGoalsWithThisMonthBalances&#39;
*LongTailApi* | [**longTailSelectBudgetCategoryScreenQuery**](docs/LongTailApi.md#longtailselectbudgetcategoryscreenquery) | **POST** /v1/x/select-budget-category-screen-query | Long-tail wrapper for &#39;SelectBudgetCategoryScreenQuery&#39;
*LongTailApi* | [**longTailSendMessage**](docs/LongTailApi.md#longtailsendmessage) | **POST** /v1/x/send-message | Long-tail wrapper for &#39;Common_SendMessage&#39;
*LongTailApi* | [**longTailSetAccountLogo**](docs/LongTailApi.md#longtailsetaccountlogo) | **POST** /v1/x/set-account-logo | Long-tail wrapper for &#39;Common_SetAccountLogo&#39;
*LongTailApi* | [**longTailSetDebtPaydownBudgetAmount**](docs/LongTailApi.md#longtailsetdebtpaydownbudgetamount) | **POST** /v1/x/set-debt-paydown-budget-amount | Long-tail wrapper for &#39;Common_SetDebtPaydownBudgetAmount&#39;
*LongTailApi* | [**longTailSetFinancialInsightsEnabled**](docs/LongTailApi.md#longtailsetfinancialinsightsenabled) | **POST** /v1/x/set-financial-insights-enabled | Long-tail wrapper for &#39;Common_SetFinancialInsightsEnabled&#39;
*LongTailApi* | [**longTailSetHasDismissedYearlyReview**](docs/LongTailApi.md#longtailsethasdismissedyearlyreview) | **POST** /v1/x/set-has-dismissed-yearly-review | Long-tail wrapper for &#39;Common_SetHasDismissedYearlyReview&#39;
*LongTailApi* | [**longTailSetHasSkippedPremiumUpsell**](docs/LongTailApi.md#longtailsethasskippedpremiumupsell) | **POST** /v1/x/set-has-skipped-premium-upsell | Long-tail wrapper for &#39;Common_SetHasSkippedPremiumUpsell&#39;
*LongTailApi* | [**longTailSetOnboardingCompleted**](docs/LongTailApi.md#longtailsetonboardingcompleted) | **POST** /v1/x/set-onboarding-completed | Long-tail wrapper for &#39;Common_SetOnboardingCompleted&#39;
*LongTailApi* | [**longTailSetUserOnboardingFinancialGoals**](docs/LongTailApi.md#longtailsetuseronboardingfinancialgoals) | **POST** /v1/x/set-user-onboarding-financial-goals | Long-tail wrapper for &#39;Common_SetUserOnboardingFinancialGoals&#39;
*LongTailApi* | [**longTailSetUserProfilePicture**](docs/LongTailApi.md#longtailsetuserprofilepicture) | **POST** /v1/x/set-user-profile-picture | Long-tail wrapper for &#39;Common_SetUserProfilePicture&#39;
*LongTailApi* | [**longTailSetUserReportedAttributionChannels**](docs/LongTailApi.md#longtailsetuserreportedattributionchannels) | **POST** /v1/x/set-user-reported-attribution-channels | Long-tail wrapper for &#39;Common_SetUserReportedAttributionChannels&#39;
*LongTailApi* | [**longTailStartRetailSync**](docs/LongTailApi.md#longtailstartretailsync) | **POST** /v1/x/start-retail-sync | Long-tail wrapper for &#39;Common_StartRetailSync&#39;
*LongTailApi* | [**longTailStartSavingsGoalsMigration**](docs/LongTailApi.md#longtailstartsavingsgoalsmigration) | **POST** /v1/x/start-savings-goals-migration | Long-tail wrapper for &#39;Common_StartSavingsGoalsMigration&#39;
*LongTailApi* | [**longTailSubmitAssistantFeedback**](docs/LongTailApi.md#longtailsubmitassistantfeedback) | **POST** /v1/x/submit-assistant-feedback | Long-tail wrapper for &#39;Common_SubmitAssistantFeedback&#39;
*LongTailApi* | [**longTailSyncCredentialAfterReconnect**](docs/LongTailApi.md#longtailsynccredentialafterreconnect) | **POST** /v1/x/sync-credential-after-reconnect | Long-tail wrapper for &#39;Common_SyncCredentialAfterReconnect&#39;
*LongTailApi* | [**longTailToggleCreditScoreTracking**](docs/LongTailApi.md#longtailtogglecreditscoretracking) | **POST** /v1/x/toggle-credit-score-tracking | Long-tail wrapper for &#39;Common_ToggleCreditScoreTracking&#39;
*LongTailApi* | [**longTailTopInstitutionsQuery**](docs/LongTailApi.md#longtailtopinstitutionsquery) | **POST** /v1/x/top-institutions-query | Long-tail wrapper for &#39;TopInstitutionsQuery&#39;
*LongTailApi* | [**longTailTransferAccountDataAsync**](docs/LongTailApi.md#longtailtransferaccountdataasync) | **POST** /v1/x/transfer-account-data-async | Long-tail wrapper for &#39;Common_TransferAccountDataAsync&#39;
*LongTailApi* | [**longTailTriggerRecurringMerchantSearch**](docs/LongTailApi.md#longtailtriggerrecurringmerchantsearch) | **POST** /v1/x/trigger-recurring-merchant-search | Long-tail wrapper for &#39;Common_TriggerRecurringMerchantSearch&#39;
*LongTailApi* | [**longTailUnarchiveGoal**](docs/LongTailApi.md#longtailunarchivegoal) | **POST** /v1/x/unarchive-goal | Long-tail wrapper for &#39;Common_UnarchiveGoal&#39;
*LongTailApi* | [**longTailUndeleteAccount**](docs/LongTailApi.md#longtailundeleteaccount) | **POST** /v1/x/undelete-account | Long-tail wrapper for &#39;Common_UndeleteAccount&#39;
*LongTailApi* | [**longTailUnreconciledSpendingEvents**](docs/LongTailApi.md#longtailunreconciledspendingevents) | **POST** /v1/x/unreconciled-spending-events | Long-tail wrapper for &#39;Common_UnreconciledSpendingEvents&#39;
*LongTailApi* | [**longTailUpdateAccountsForEditingEntities**](docs/LongTailApi.md#longtailupdateaccountsforeditingentities) | **POST** /v1/x/update-accounts-for-editing-entities | Long-tail wrapper for &#39;Common_UpdateAccountsForEditingEntities&#39;
*LongTailApi* | [**longTailUpdateAccountsForEditingOwnership**](docs/LongTailApi.md#longtailupdateaccountsforeditingownership) | **POST** /v1/x/update-accounts-for-editing-ownership | Long-tail wrapper for &#39;Common_UpdateAccountsForEditingOwnership&#39;
*LongTailApi* | [**longTailUpdateAllNotificationPreferencesForPlatform**](docs/LongTailApi.md#longtailupdateallnotificationpreferencesforplatform) | **POST** /v1/x/update-all-notification-preferences-for-platform | Long-tail wrapper for &#39;Common_UpdateAllNotificationPreferencesForPlatform&#39;
*LongTailApi* | [**longTailUpdateCategoryBudgetVariability**](docs/LongTailApi.md#longtailupdatecategorybudgetvariability) | **POST** /v1/x/update-category-budget-variability | Long-tail wrapper for &#39;Common_UpdateCategoryBudgetVariability&#39;
*LongTailApi* | [**longTailUpdateCategoryExcludeFromBudget**](docs/LongTailApi.md#longtailupdatecategoryexcludefrombudget) | **POST** /v1/x/update-category-exclude-from-budget | Long-tail wrapper for &#39;Common_UpdateCategoryExcludeFromBudget&#39;
*LongTailApi* | [**longTailUpdateCredential**](docs/LongTailApi.md#longtailupdatecredential) | **POST** /v1/x/update-credential | Long-tail wrapper for &#39;Common_UpdateCredential&#39;
*LongTailApi* | [**longTailUpdateDashboardConfig**](docs/LongTailApi.md#longtailupdatedashboardconfig) | **POST** /v1/x/update-dashboard-config | Long-tail wrapper for &#39;Common_UpdateDashboardConfig&#39;
*LongTailApi* | [**longTailUpdateDoNotSellOrShare**](docs/LongTailApi.md#longtailupdatedonotsellorshare) | **POST** /v1/x/update-do-not-sell-or-share | Long-tail wrapper for &#39;Common_UpdateDoNotSellOrShare&#39;
*LongTailApi* | [**longTailUpdateFinancialInsightStatus**](docs/LongTailApi.md#longtailupdatefinancialinsightstatus) | **POST** /v1/x/update-financial-insight-status | Long-tail wrapper for &#39;Common_UpdateFinancialInsightStatus&#39;
*LongTailApi* | [**longTailUpdateGoalAccountAllocation**](docs/LongTailApi.md#longtailupdategoalaccountallocation) | **POST** /v1/x/update-goal-account-allocation | Long-tail wrapper for &#39;Common_UpdateGoalAccountAllocation&#39;
*LongTailApi* | [**longTailUpdateMyHousehold**](docs/LongTailApi.md#longtailupdatemyhousehold) | **POST** /v1/x/update-my-household | Long-tail wrapper for &#39;Common_UpdateMyHousehold&#39;
*LongTailApi* | [**longTailUpdateRetailOrder**](docs/LongTailApi.md#longtailupdateretailorder) | **POST** /v1/x/update-retail-order | Long-tail wrapper for &#39;Common_UpdateRetailOrder&#39;
*LongTailApi* | [**longTailUpdateRetailVendorSettings**](docs/LongTailApi.md#longtailupdateretailvendorsettings) | **POST** /v1/x/update-retail-vendor-settings | Long-tail wrapper for &#39;Common_UpdateRetailVendorSettings&#39;
*LongTailApi* | [**longTailUpdateSavingsGoalAccountIncludeInGoalContributions**](docs/LongTailApi.md#longtailupdatesavingsgoalaccountincludeingoalcontributions) | **POST** /v1/x/update-savings-goal-account-include-in-goal-contributions | Long-tail wrapper for &#39;Common_UpdateSavingsGoalAccountIncludeInGoalContributions&#39;
*LongTailApi* | [**longTailUpdateSavingsGoalAccountLink**](docs/LongTailApi.md#longtailupdatesavingsgoalaccountlink) | **POST** /v1/x/update-savings-goal-account-link | Long-tail wrapper for &#39;Common_UpdateSavingsGoalAccountLink&#39;
*LongTailApi* | [**longTailUpdateSavingsGoalEvent**](docs/LongTailApi.md#longtailupdatesavingsgoalevent) | **POST** /v1/x/update-savings-goal-event | Long-tail wrapper for &#39;Common_UpdateSavingsGoalEvent&#39;
*LongTailApi* | [**longTailUpdateSponsorshipInvite**](docs/LongTailApi.md#longtailupdatesponsorshipinvite) | **POST** /v1/x/update-sponsorship-invite | Long-tail wrapper for &#39;Common_UpdateSponsorshipInvite&#39;
*LongTailApi* | [**longTailUpdateTransaction**](docs/LongTailApi.md#longtailupdatetransaction) | **POST** /v1/x/update-transaction | Long-tail wrapper for &#39;Common_UpdateTransaction&#39;
*LongTailApi* | [**longTailUpdateTransactionTag**](docs/LongTailApi.md#longtailupdatetransactiontag) | **POST** /v1/x/update-transaction-tag | Long-tail wrapper for &#39;Common_UpdateTransactionTag&#39;
*LongTailApi* | [**longTailUpdateTransactionTagOrder**](docs/LongTailApi.md#longtailupdatetransactiontagorder) | **POST** /v1/x/update-transaction-tag-order | Long-tail wrapper for &#39;Common_UpdateTransactionTagOrder&#39;
*LongTailApi* | [**longTailUpdateUserProfile**](docs/LongTailApi.md#longtailupdateuserprofile) | **POST** /v1/x/update-user-profile | Long-tail wrapper for &#39;Common_UpdateUserProfile&#39;
*LongTailApi* | [**longTailUpdateUserProfileFlags**](docs/LongTailApi.md#longtailupdateuserprofileflags) | **POST** /v1/x/update-user-profile-flags | Long-tail wrapper for &#39;Common_UpdateUserProfileFlags&#39;
*LongTailApi* | [**longTailUserDevicesUsage**](docs/LongTailApi.md#longtailuserdevicesusage) | **POST** /v1/x/user-devices-usage | Long-tail wrapper for &#39;Common_UserDevicesUsage&#39;
*LongTailApi* | [**longTailUserProfileFlags**](docs/LongTailApi.md#longtailuserprofileflags) | **POST** /v1/x/user-profile-flags | Long-tail wrapper for &#39;Common_UserProfileFlags&#39;
*LongTailApi* | [**longTailVehiclesSearch**](docs/LongTailApi.md#longtailvehiclessearch) | **POST** /v1/x/vehicles-search | Long-tail wrapper for &#39;VehiclesSearch&#39;
*LongTailApi* | [**longTailWithdrawAllGoalContributionsFromAccount**](docs/LongTailApi.md#longtailwithdrawallgoalcontributionsfromaccount) | **POST** /v1/x/withdraw-all-goal-contributions-from-account | Long-tail wrapper for &#39;Common_WithdrawAllGoalContributionsFromAccount&#39;
*MerchantsApi* | [**deleteMerchant**](docs/MerchantsApi.md#deletemerchant) | **DELETE** /v1/merchants/{id} | Delete a merchant
*MerchantsApi* | [**getMerchant**](docs/MerchantsApi.md#getmerchant) | **GET** /v1/merchants/{id} | Get full detail for one merchant
*MerchantsApi* | [**getMerchantStats**](docs/MerchantsApi.md#getmerchantstats) | **GET** /v1/merchants/{id}/stats | Per-merchant aggregate stats
*MerchantsApi* | [**getMerchantTransactions**](docs/MerchantsApi.md#getmerchanttransactions) | **GET** /v1/merchants/{id}/transactions | Transactions for one merchant
*MerchantsApi* | [**searchMerchants**](docs/MerchantsApi.md#searchmerchants) | **GET** /v1/merchants/search | Search merchants by name
*MerchantsApi* | [**setMerchantLogo**](docs/MerchantsApi.md#setmerchantlogo) | **PATCH** /v1/merchants/{id}/logo | Set a merchant&#39;s logo
*MobileScreensApi* | [**mobileAccountsMessageBlock**](docs/MobileScreensApi.md#mobileaccountsmessageblock) | **GET** /v1/mobile/accounts-message-block | Mobile screen aggregate &#39;Mobile_AccountsMessageBlock&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileAddCategoryGroupMutation**](docs/MobileScreensApi.md#mobileaddcategorygroupmutation) | **GET** /v1/mobile/add-category-group-mutation | Mobile screen aggregate &#39;Mobile_AddCategoryGroupMutation&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileCategoryDetailQuery**](docs/MobileScreensApi.md#mobilecategorydetailquery) | **GET** /v1/mobile/category-detail-query | Mobile screen aggregate &#39;Mobile_CategoryDetailQuery&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileCategoryGroupDetailChartQuery**](docs/MobileScreensApi.md#mobilecategorygroupdetailchartquery) | **GET** /v1/mobile/category-group-detail-chart-query | Mobile screen aggregate &#39;Mobile_CategoryGroupDetailChartQuery&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileCategoryGroupDetailContainerQuery**](docs/MobileScreensApi.md#mobilecategorygroupdetailcontainerquery) | **GET** /v1/mobile/category-group-detail-container-query | Mobile screen aggregate &#39;Mobile_CategoryGroupDetailContainerQuery&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileCategoryRecommendationForTransaction**](docs/MobileScreensApi.md#mobilecategoryrecommendationfortransaction) | **GET** /v1/mobile/category-recommendation-for-transaction | Mobile screen aggregate &#39;Mobile_CategoryRecommendationForTransaction&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileCreateAppleCardAccount**](docs/MobileScreensApi.md#mobilecreateapplecardaccount) | **GET** /v1/mobile/create-apple-card-account | Mobile screen aggregate &#39;Mobile_CreateAppleCardAccount&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileCreateCoinbaseAccount**](docs/MobileScreensApi.md#mobilecreatecoinbaseaccount) | **GET** /v1/mobile/create-coinbase-account | Mobile screen aggregate &#39;Mobile_CreateCoinbaseAccount&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileCreateEditRuleSettings**](docs/MobileScreensApi.md#mobilecreateeditrulesettings) | **GET** /v1/mobile/create-edit-rule-settings | Mobile screen aggregate &#39;Mobile_CreateEditRuleSettings&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileCreateHouseholdAccessGrant**](docs/MobileScreensApi.md#mobilecreatehouseholdaccessgrant) | **GET** /v1/mobile/create-household-access-grant | Mobile screen aggregate &#39;Mobile_CreateHouseholdAccessGrant&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileCreateReviewCheckinMutation**](docs/MobileScreensApi.md#mobilecreatereviewcheckinmutation) | **GET** /v1/mobile/create-review-checkin-mutation | Mobile screen aggregate &#39;Mobile_CreateReviewCheckinMutation&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileCreateSyncedVehicleAccount**](docs/MobileScreensApi.md#mobilecreatesyncedvehicleaccount) | **GET** /v1/mobile/create-synced-vehicle-account | Mobile screen aggregate &#39;Mobile_CreateSyncedVehicleAccount&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileCreateZillowAccount**](docs/MobileScreensApi.md#mobilecreatezillowaccount) | **GET** /v1/mobile/create-zillow-account | Mobile screen aggregate &#39;Mobile_CreateZillowAccount&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileCustomizeGoalScreen**](docs/MobileScreensApi.md#mobilecustomizegoalscreen) | **GET** /v1/mobile/customize-goal-screen | Mobile screen aggregate &#39;Mobile_CustomizeGoalScreen&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileDebugGetFinancialInsightIds**](docs/MobileScreensApi.md#mobiledebuggetfinancialinsightids) | **GET** /v1/mobile/debug-get-financial-insight-ids | Mobile screen aggregate &#39;Mobile_DebugGetFinancialInsightIds&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileDebugSoftDeleteFinancialInsight**](docs/MobileScreensApi.md#mobiledebugsoftdeletefinancialinsight) | **GET** /v1/mobile/debug-soft-delete-financial-insight | Mobile screen aggregate &#39;Mobile_DebugSoftDeleteFinancialInsight&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileDeleteAccountLogo**](docs/MobileScreensApi.md#mobiledeleteaccountlogo) | **GET** /v1/mobile/delete-account-logo | Mobile screen aggregate &#39;Mobile_DeleteAccountLogo&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileDeleteAttachment**](docs/MobileScreensApi.md#mobiledeleteattachment) | **GET** /v1/mobile/delete-attachment | Mobile screen aggregate &#39;Mobile_DeleteAttachment&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileDeleteUserFromHousehold**](docs/MobileScreensApi.md#mobiledeleteuserfromhousehold) | **GET** /v1/mobile/delete-user-from-household | Mobile screen aggregate &#39;Mobile_DeleteUserFromHousehold&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileDeleteUserProfilePicture**](docs/MobileScreensApi.md#mobiledeleteuserprofilepicture) | **GET** /v1/mobile/delete-user-profile-picture | Mobile screen aggregate &#39;Mobile_DeleteUserProfilePicture&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileDidRequestReviewMutation**](docs/MobileScreensApi.md#mobiledidrequestreviewmutation) | **GET** /v1/mobile/did-request-review-mutation | Mobile screen aggregate &#39;Mobile_DidRequestReviewMutation&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileDirectLinkInstitutionModal**](docs/MobileScreensApi.md#mobiledirectlinkinstitutionmodal) | **GET** /v1/mobile/direct-link-institution-modal | Mobile screen aggregate &#39;Mobile_DirectLinkInstitutionModal&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileDrawerMenu**](docs/MobileScreensApi.md#mobiledrawermenu) | **GET** /v1/mobile/drawer-menu | Mobile screen aggregate &#39;Mobile_DrawerMenu&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileGetAccount**](docs/MobileScreensApi.md#mobilegetaccount) | **GET** /v1/mobile/get-account | Mobile screen aggregate &#39;Mobile_GetAccount&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileGetAccountDetailScreen**](docs/MobileScreensApi.md#mobilegetaccountdetailscreen) | **GET** /v1/mobile/get-account-detail-screen | Mobile screen aggregate &#39;Mobile_GetAccountDetailScreen&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileGetAccountOptions**](docs/MobileScreensApi.md#mobilegetaccountoptions) | **GET** /v1/mobile/get-account-options | Mobile screen aggregate &#39;Mobile_GetAccountOptions&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileGetAccountsListBlock**](docs/MobileScreensApi.md#mobilegetaccountslistblock) | **GET** /v1/mobile/get-accounts-list-block | Mobile screen aggregate &#39;Mobile_GetAccountsListBlock&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileGetAddTransactionScreen**](docs/MobileScreensApi.md#mobilegetaddtransactionscreen) | **GET** /v1/mobile/get-add-transaction-screen | Mobile screen aggregate &#39;Mobile_GetAddTransactionScreen&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileGetCategoryDeletionInfo**](docs/MobileScreensApi.md#mobilegetcategorydeletioninfo) | **GET** /v1/mobile/get-category-deletion-info | Mobile screen aggregate &#39;Mobile_GetCategoryDeletionInfo&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileGetCategoryGroupsWithCategories**](docs/MobileScreensApi.md#mobilegetcategorygroupswithcategories) | **GET** /v1/mobile/get-category-groups-with-categories | Mobile screen aggregate &#39;Mobile_GetCategoryGroupsWithCategories&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileGetDuplicateCredentials**](docs/MobileScreensApi.md#mobilegetduplicatecredentials) | **GET** /v1/mobile/get-duplicate-credentials | Mobile screen aggregate &#39;Mobile_GetDuplicateCredentials&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileGetEditAccountScreen**](docs/MobileScreensApi.md#mobilegeteditaccountscreen) | **GET** /v1/mobile/get-edit-account-screen | Mobile screen aggregate &#39;Mobile_GetEditAccountScreen&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileGetEventPopoverTransactions**](docs/MobileScreensApi.md#mobilegeteventpopovertransactions) | **GET** /v1/mobile/get-event-popover-transactions | Mobile screen aggregate &#39;Mobile_GetEventPopoverTransactions&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileGetInvestmentsAccounts**](docs/MobileScreensApi.md#mobilegetinvestmentsaccounts) | **GET** /v1/mobile/get-investments-accounts | Mobile screen aggregate &#39;Mobile_GetInvestmentsAccounts&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileGetInvestmentsDashboardCard**](docs/MobileScreensApi.md#mobilegetinvestmentsdashboardcard) | **GET** /v1/mobile/get-investments-dashboard-card | Mobile screen aggregate &#39;Mobile_GetInvestmentsDashboardCard&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileGetInvestmentsHoldingsList**](docs/MobileScreensApi.md#mobilegetinvestmentsholdingslist) | **GET** /v1/mobile/get-investments-holdings-list | Mobile screen aggregate &#39;Mobile_GetInvestmentsHoldingsList&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileGetInvestmentsPortfolio**](docs/MobileScreensApi.md#mobilegetinvestmentsportfolio) | **GET** /v1/mobile/get-investments-portfolio | Mobile screen aggregate &#39;Mobile_GetInvestmentsPortfolio&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileGetInvestmentsWidgetData**](docs/MobileScreensApi.md#mobilegetinvestmentswidgetdata) | **GET** /v1/mobile/get-investments-widget-data | Mobile screen aggregate &#39;Mobile_GetInvestmentsWidgetData&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileGetMerchantsListScreen**](docs/MobileScreensApi.md#mobilegetmerchantslistscreen) | **GET** /v1/mobile/get-merchants-list-screen | Mobile screen aggregate &#39;Mobile_GetMerchantsListScreen&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileGetPastSplits**](docs/MobileScreensApi.md#mobilegetpastsplits) | **GET** /v1/mobile/get-past-splits | Mobile screen aggregate &#39;Mobile_GetPastSplits&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileGetPortfolioBenchmarks**](docs/MobileScreensApi.md#mobilegetportfoliobenchmarks) | **GET** /v1/mobile/get-portfolio-benchmarks | Mobile screen aggregate &#39;Mobile_GetPortfolioBenchmarks&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileGetSecuritiesHistoricalChart**](docs/MobileScreensApi.md#mobilegetsecuritieshistoricalchart) | **GET** /v1/mobile/get-securities-historical-chart | Mobile screen aggregate &#39;Mobile_GetSecuritiesHistoricalChart&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileGetSecuritiesHistoricalPerformance**](docs/MobileScreensApi.md#mobilegetsecuritieshistoricalperformance) | **GET** /v1/mobile/get-securities-historical-performance | Mobile screen aggregate &#39;Mobile_GetSecuritiesHistoricalPerformance&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileGetSelectCategoryScreen**](docs/MobileScreensApi.md#mobilegetselectcategoryscreen) | **GET** /v1/mobile/get-select-category-screen | Mobile screen aggregate &#39;Mobile_GetSelectCategoryScreen&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileGetSelectMerchantScreenHouseholdMerchants**](docs/MobileScreensApi.md#mobilegetselectmerchantscreenhouseholdmerchants) | **GET** /v1/mobile/get-select-merchant-screen-household-merchants | Mobile screen aggregate &#39;Mobile_GetSelectMerchantScreenHouseholdMerchants&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileGetSelectMerchantScreenRecommendedMerchants**](docs/MobileScreensApi.md#mobilegetselectmerchantscreenrecommendedmerchants) | **GET** /v1/mobile/get-select-merchant-screen-recommended-merchants | Mobile screen aggregate &#39;Mobile_GetSelectMerchantScreenRecommendedMerchants&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileGetSelectMerchantScreenTransactionDetails**](docs/MobileScreensApi.md#mobilegetselectmerchantscreentransactiondetails) | **GET** /v1/mobile/get-select-merchant-screen-transaction-details | Mobile screen aggregate &#39;Mobile_GetSelectMerchantScreenTransactionDetails&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileGetTransactionDetailScreen**](docs/MobileScreensApi.md#mobilegettransactiondetailscreen) | **GET** /v1/mobile/get-transaction-detail-screen | Mobile screen aggregate &#39;Mobile_GetTransactionDetailScreen&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileGetTransactionsAndCategoriesForWidget**](docs/MobileScreensApi.md#mobilegettransactionsandcategoriesforwidget) | **GET** /v1/mobile/get-transactions-and-categories-for-widget | Mobile screen aggregate &#39;Mobile_GetTransactionsAndCategoriesForWidget&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileGoalDetailScreenV2**](docs/MobileScreensApi.md#mobilegoaldetailscreenv2) | **GET** /v1/mobile/goal-detail-screen-v2 | Mobile screen aggregate &#39;Mobile_GoalDetailScreenV2&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileGoalSelectGoals**](docs/MobileScreensApi.md#mobilegoalselectgoals) | **GET** /v1/mobile/goal-select-goals | Mobile screen aggregate &#39;Mobile_GoalSelectGoals&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileGoalsAllocateBalanceScreen**](docs/MobileScreensApi.md#mobilegoalsallocatebalancescreen) | **GET** /v1/mobile/goals-allocate-balance-screen | Mobile screen aggregate &#39;Mobile_GoalsAllocateBalanceScreen&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileGoalsDashboardCardV2**](docs/MobileScreensApi.md#mobilegoalsdashboardcardv2) | **GET** /v1/mobile/goals-dashboard-card-v2 | Mobile screen aggregate &#39;Mobile_GoalsDashboardCardV2&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileGoalsMapAccountsScreen**](docs/MobileScreensApi.md#mobilegoalsmapaccountsscreen) | **GET** /v1/mobile/goals-map-accounts-screen | Mobile screen aggregate &#39;Mobile_GoalsMapAccountsScreen&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileGoalsMessageBlock**](docs/MobileScreensApi.md#mobilegoalsmessageblock) | **GET** /v1/mobile/goals-message-block | Mobile screen aggregate &#39;Mobile_GoalsMessageBlock&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileGoalsMonthlyBudgetsScreen**](docs/MobileScreensApi.md#mobilegoalsmonthlybudgetsscreen) | **GET** /v1/mobile/goals-monthly-budgets-screen | Mobile screen aggregate &#39;Mobile_GoalsMonthlyBudgetsScreen&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileGoalsPreTaxBudgetsScreen**](docs/MobileScreensApi.md#mobilegoalspretaxbudgetsscreen) | **GET** /v1/mobile/goals-pre-tax-budgets-screen | Mobile screen aggregate &#39;Mobile_GoalsPreTaxBudgetsScreen&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileGoalsScreenV2**](docs/MobileScreensApi.md#mobilegoalsscreenv2) | **GET** /v1/mobile/goals-screen-v2 | Mobile screen aggregate &#39;Mobile_GoalsScreenV2&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileGoalsTargetAmountsScreen**](docs/MobileScreensApi.md#mobilegoalstargetamountsscreen) | **GET** /v1/mobile/goals-target-amounts-screen | Mobile screen aggregate &#39;Mobile_GoalsTargetAmountsScreen&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileInitialPermissionRequestModal**](docs/MobileScreensApi.md#mobileinitialpermissionrequestmodal) | **GET** /v1/mobile/initial-permission-request-modal | Mobile screen aggregate &#39;Mobile_InitialPermissionRequestModal&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileInviteEmail**](docs/MobileScreensApi.md#mobileinviteemail) | **GET** /v1/mobile/invite-email | Mobile screen aggregate &#39;Mobile_InviteEmail&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileInvitePartner**](docs/MobileScreensApi.md#mobileinvitepartner) | **GET** /v1/mobile/invite-partner | Mobile screen aggregate &#39;Mobile_InvitePartner&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileLinkGoalOptions**](docs/MobileScreensApi.md#mobilelinkgoaloptions) | **GET** /v1/mobile/link-goal-options | Mobile screen aggregate &#39;Mobile_LinkGoalOptions&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileLinkSearchInstitutionsQuery**](docs/MobileScreensApi.md#mobilelinksearchinstitutionsquery) | **GET** /v1/mobile/link-search-institutions-query | Mobile screen aggregate &#39;Mobile_LinkSearchInstitutionsQuery&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileMerchantChartQuery**](docs/MobileScreensApi.md#mobilemerchantchartquery) | **GET** /v1/mobile/merchant-chart-query | Mobile screen aggregate &#39;Mobile_MerchantChartQuery&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileMerchantDetailContainerQuery**](docs/MobileScreensApi.md#mobilemerchantdetailcontainerquery) | **GET** /v1/mobile/merchant-detail-container-query | Mobile screen aggregate &#39;Mobile_MerchantDetailContainerQuery&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileMoveMoneyScreenMutation**](docs/MobileScreensApi.md#mobilemovemoneyscreenmutation) | **GET** /v1/mobile/move-money-screen-mutation | Mobile screen aggregate &#39;Mobile_MoveMoneyScreenMutation&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileNetWorthChartOverlyQuery**](docs/MobileScreensApi.md#mobilenetworthchartoverlyquery) | **GET** /v1/mobile/net-worth-chart-overly-query | Mobile screen aggregate &#39;Mobile_NetWorthChartOverlyQuery&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileOldestDeletableSyncedSnapshotDate**](docs/MobileScreensApi.md#mobileoldestdeletablesyncedsnapshotdate) | **GET** /v1/mobile/oldest-deletable-synced-snapshot-date | Mobile screen aggregate &#39;Mobile_OldestDeletableSyncedSnapshotDate&#39; (opaque pass-through)
*MobileScreensApi* | [**mobilePreviewDeleteSyncedSnapshots**](docs/MobileScreensApi.md#mobilepreviewdeletesyncedsnapshots) | **GET** /v1/mobile/preview-delete-synced-snapshots | Mobile screen aggregate &#39;Mobile_PreviewDeleteSyncedSnapshots&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileRankGoalsScreen**](docs/MobileScreensApi.md#mobilerankgoalsscreen) | **GET** /v1/mobile/rank-goals-screen | Mobile screen aggregate &#39;Mobile_RankGoalsScreen&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileRapidTransactionReviewFormContainer**](docs/MobileScreensApi.md#mobilerapidtransactionreviewformcontainer) | **GET** /v1/mobile/rapid-transaction-review-form-container | Mobile screen aggregate &#39;Mobile_RapidTransactionReviewFormContainer&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileRapidTransactionReviewScreen**](docs/MobileScreensApi.md#mobilerapidtransactionreviewscreen) | **GET** /v1/mobile/rapid-transaction-review-screen | Mobile screen aggregate &#39;Mobile_RapidTransactionReviewScreen&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileResetHouseholdRecurringMerchantSearch**](docs/MobileScreensApi.md#mobileresethouseholdrecurringmerchantsearch) | **GET** /v1/mobile/reset-household-recurring-merchant-search | Mobile screen aggregate &#39;Mobile_ResetHouseholdRecurringMerchantSearch&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileResetRolloverMutation**](docs/MobileScreensApi.md#mobileresetrollovermutation) | **GET** /v1/mobile/reset-rollover-mutation | Mobile screen aggregate &#39;Mobile_ResetRolloverMutation&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileRestoreCategoryMutation**](docs/MobileScreensApi.md#mobilerestorecategorymutation) | **GET** /v1/mobile/restore-category-mutation | Mobile screen aggregate &#39;Mobile_RestoreCategoryMutation&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileReviewDashboardQuery**](docs/MobileScreensApi.md#mobilereviewdashboardquery) | **GET** /v1/mobile/review-dashboard-query | Mobile screen aggregate &#39;Mobile_ReviewDashboardQuery&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileReviewTransactionsDashboardButton**](docs/MobileScreensApi.md#mobilereviewtransactionsdashboardbutton) | **GET** /v1/mobile/review-transactions-dashboard-button | Mobile screen aggregate &#39;Mobile_ReviewTransactionsDashboardButton&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileRulesSettingsScreenQuery**](docs/MobileScreensApi.md#mobilerulessettingsscreenquery) | **GET** /v1/mobile/rules-settings-screen-query | Mobile screen aggregate &#39;Mobile_RulesSettingsScreenQuery&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileSavingsGoalFilterOptions**](docs/MobileScreensApi.md#mobilesavingsgoalfilteroptions) | **GET** /v1/mobile/savings-goal-filter-options | Mobile screen aggregate &#39;Mobile_SavingsGoalFilterOptions&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileSearchInstitutionsQuery**](docs/MobileScreensApi.md#mobilesearchinstitutionsquery) | **GET** /v1/mobile/search-institutions-query | Mobile screen aggregate &#39;Mobile_SearchInstitutionsQuery&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileSearchMerchants**](docs/MobileScreensApi.md#mobilesearchmerchants) | **GET** /v1/mobile/search-merchants | Mobile screen aggregate &#39;Mobile_SearchMerchants&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileSearchVehiclesQuery**](docs/MobileScreensApi.md#mobilesearchvehiclesquery) | **GET** /v1/mobile/search-vehicles-query | Mobile screen aggregate &#39;Mobile_SearchVehiclesQuery&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileSelectGoalsScreen**](docs/MobileScreensApi.md#mobileselectgoalsscreen) | **GET** /v1/mobile/select-goals-screen | Mobile screen aggregate &#39;Mobile_SelectGoalsScreen&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileSetTransactionTagsRapidReview**](docs/MobileScreensApi.md#mobilesettransactiontagsrapidreview) | **GET** /v1/mobile/set-transaction-tags-rapid-review | Mobile screen aggregate &#39;Mobile_SetTransactionTagsRapidReview&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileToggleSupportAccountAccess**](docs/MobileScreensApi.md#mobiletogglesupportaccountaccess) | **GET** /v1/mobile/toggle-support-account-access | Mobile screen aggregate &#39;Mobile_ToggleSupportAccountAccess&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileTransactionsMessageBlock**](docs/MobileScreensApi.md#mobiletransactionsmessageblock) | **GET** /v1/mobile/transactions-message-block | Mobile screen aggregate &#39;Mobile_TransactionsMessageBlock&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileUpdateCategoryGroupOrderMutation**](docs/MobileScreensApi.md#mobileupdatecategorygroupordermutation) | **GET** /v1/mobile/update-category-group-order-mutation | Mobile screen aggregate &#39;Mobile_UpdateCategoryGroupOrderMutation&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileUpdateCategoryMutation**](docs/MobileScreensApi.md#mobileupdatecategorymutation) | **GET** /v1/mobile/update-category-mutation | Mobile screen aggregate &#39;Mobile_UpdateCategoryMutation&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileUpdateCategoryOrderMutation**](docs/MobileScreensApi.md#mobileupdatecategoryordermutation) | **GET** /v1/mobile/update-category-order-mutation | Mobile screen aggregate &#39;Mobile_UpdateCategoryOrderMutation&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileUpdateGoalV2**](docs/MobileScreensApi.md#mobileupdategoalv2) | **GET** /v1/mobile/update-goal-v2 | Mobile screen aggregate &#39;Mobile_UpdateGoalV2&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileUpdateGoalsPriorities**](docs/MobileScreensApi.md#mobileupdategoalspriorities) | **GET** /v1/mobile/update-goals-priorities | Mobile screen aggregate &#39;Mobile_UpdateGoalsPriorities&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileUpdateNonMonthlyCategory**](docs/MobileScreensApi.md#mobileupdatenonmonthlycategory) | **GET** /v1/mobile/update-non-monthly-category | Mobile screen aggregate &#39;Mobile_UpdateNonMonthlyCategory&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileUpdateReviewCheckinMutation**](docs/MobileScreensApi.md#mobileupdatereviewcheckinmutation) | **GET** /v1/mobile/update-review-checkin-mutation | Mobile screen aggregate &#39;Mobile_UpdateReviewCheckinMutation&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileUpdateTransactionDetailScreen**](docs/MobileScreensApi.md#mobileupdatetransactiondetailscreen) | **GET** /v1/mobile/update-transaction-detail-screen | Mobile screen aggregate &#39;Mobile_UpdateTransactionDetailScreen&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileUpdateTransactionRapidReview**](docs/MobileScreensApi.md#mobileupdatetransactionrapidreview) | **GET** /v1/mobile/update-transaction-rapid-review | Mobile screen aggregate &#39;Mobile_UpdateTransactionRapidReview&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileUpdateUserFinancialProfile**](docs/MobileScreensApi.md#mobileupdateuserfinancialprofile) | **GET** /v1/mobile/update-user-financial-profile | Mobile screen aggregate &#39;Mobile_UpdateUserFinancialProfile&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileUpsellPostalCode**](docs/MobileScreensApi.md#mobileupsellpostalcode) | **GET** /v1/mobile/upsell-postal-code | Mobile screen aggregate &#39;Mobile_Upsell_PostalCode&#39; (opaque pass-through)
*MobileScreensApi* | [**mobileUserAvatar**](docs/MobileScreensApi.md#mobileuseravatar) | **GET** /v1/mobile/user-avatar | Mobile screen aggregate &#39;Mobile_UserAvatar&#39; (opaque pass-through)
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
*RecurringApi* | [**updateMerchantRecurrence**](docs/RecurringApi.md#updatemerchantrecurrence) | **PATCH** /v1/merchants/{id}/recurrence | Update a merchant&#39;s recurring-transaction settings
*ReportConfigApi* | [**reportConfigsCommandPalette**](docs/ReportConfigApi.md#reportconfigscommandpalette) | **GET** /v1/report-configs/command-palette | Forward &#39;Web_GetReportConfigurationsForCommandPalette&#39; (opaque pass-through)
*ReportConfigApi* | [**reportConfigsCreate**](docs/ReportConfigApi.md#reportconfigscreate) | **GET** /v1/report-configs/create | Forward &#39;Common_CreateReportConfiguration&#39; (opaque pass-through)
*ReportConfigApi* | [**reportConfigsDelete**](docs/ReportConfigApi.md#reportconfigsdelete) | **GET** /v1/report-configs/delete | Forward &#39;Common_DeleteReportConfiguration&#39; (opaque pass-through)
*ReportConfigApi* | [**reportConfigsList**](docs/ReportConfigApi.md#reportconfigslist) | **GET** /v1/report-configs | Forward &#39;Common_GetReportConfigurations&#39; (opaque pass-through)
*ReportConfigApi* | [**reportConfigsUpdate**](docs/ReportConfigApi.md#reportconfigsupdate) | **GET** /v1/report-configs/update | Forward &#39;Common_UpdateReportConfiguration&#39; (opaque pass-through)
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
*TaxApi* | [**getTaxCategories**](docs/TaxApi.md#gettaxcategories) | **GET** /v1/tax/categories | All categories including &#39;systemCategory&#39; (for tax-prep)
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
*TransactionsApi* | [**markTransactionStreamAsNotRecurring**](docs/TransactionsApi.md#marktransactionstreamasnotrecurring) | **POST** /v1/transactions/{id}/not-recurring | Mark a transaction&#39;s recurring-stream as not-recurring
*TransactionsApi* | [**matchSearchTransactions**](docs/TransactionsApi.md#matchsearchtransactions) | **GET** /v1/transactions/match-search | Fuzzy transaction search for \&quot;find a match\&quot;
*TransactionsApi* | [**moveTransactions**](docs/TransactionsApi.md#movetransactions) | **POST** /v1/transactions/move | Move transactions between accounts
*TransactionsApi* | [**setTransactionTags**](docs/TransactionsApi.md#settransactiontags) | **PUT** /v1/transactions/{id}/tags | Overwrite the tag set on a transaction
*TransactionsApi* | [**startDownloadTransactions**](docs/TransactionsApi.md#startdownloadtransactions) | **POST** /v1/transactions/download | Start a transaction CSV download session
*TransactionsApi* | [**updateTransaction**](docs/TransactionsApi.md#updatetransaction) | **PATCH** /v1/transactions/{id} | Partial-update a transaction
*TransactionsApi* | [**updateTransactionSplits**](docs/TransactionsApi.md#updatetransactionsplits) | **POST** /v1/transactions/{id}/splits | Replace the splits on a transaction
*TransactionsApi* | [**uploadTransactionAttachment**](docs/TransactionsApi.md#uploadtransactionattachment) | **POST** /v1/transactions/{id}/attachments | Attach a receipt photo or PDF to a transaction
*WebScreensApi* | [**webAccountDetailsRouterGetAccountType**](docs/WebScreensApi.md#webaccountdetailsroutergetaccounttype) | **POST** /v1/web/screens/account-details-router-get-account-type | Web screen aggregate &#39;Web_AccountDetailsRouter_getAccountType&#39; (query, opaque pass-through)
*WebScreensApi* | [**webAccountEditModal**](docs/WebScreensApi.md#webaccounteditmodal) | **POST** /v1/web/screens/account-edit-modal | Web screen aggregate &#39;Web_AccountEditModal&#39; (query, opaque pass-through)
*WebScreensApi* | [**webAccountFilterQuery**](docs/WebScreensApi.md#webaccountfilterquery) | **POST** /v1/web/screens/account-filter-query | Web screen aggregate &#39;Web_AccountFilterQuery&#39; (query, opaque pass-through)
*WebScreensApi* | [**webAccountsMessageBlock**](docs/WebScreensApi.md#webaccountsmessageblock) | **POST** /v1/web/screens/accounts-message-block | Web screen aggregate &#39;Web_AccountsMessageBlock&#39; (query, opaque pass-through)
*WebScreensApi* | [**webAdvisorPortalGetSubscription**](docs/WebScreensApi.md#webadvisorportalgetsubscription) | **POST** /v1/web/screens/advisor-portal-get-subscription | Web screen aggregate &#39;Web_AdvisorPortalGetSubscription&#39; (query, opaque pass-through)
*WebScreensApi* | [**webAnswerQuestionMutation**](docs/WebScreensApi.md#webanswerquestionmutation) | **POST** /v1/web/aggregates/answer-question-mutation | Web screen aggregate &#39;Web_AnswerQuestionMutation&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webAssignTaxScheduleCategoryMapping**](docs/WebScreensApi.md#webassigntaxschedulecategorymapping) | **POST** /v1/web/aggregates/assign-tax-schedule-category-mapping | Web screen aggregate &#39;Web_AssignTaxScheduleCategoryMapping&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webBudgetOnboardingGetAccounts**](docs/WebScreensApi.md#webbudgetonboardinggetaccounts) | **POST** /v1/web/screens/budget-onboarding-get-accounts | Web screen aggregate &#39;Web_BudgetOnboardingGetAccounts&#39; (query, opaque pass-through)
*WebScreensApi* | [**webCancelSponsorship**](docs/WebScreensApi.md#webcancelsponsorship) | **POST** /v1/web/aggregates/cancel-sponsorship | Web screen aggregate &#39;Web_CancelSponsorship&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webChangeSubscription**](docs/WebScreensApi.md#webchangesubscription) | **POST** /v1/web/aggregates/change-subscription | Web screen aggregate &#39;Web_ChangeSubscription&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webClearAllMutation**](docs/WebScreensApi.md#webclearallmutation) | **POST** /v1/web/aggregates/clear-all-mutation | Web screen aggregate &#39;Web_ClearAllMutation&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webConfirmTotpDevice**](docs/WebScreensApi.md#webconfirmtotpdevice) | **POST** /v1/web/aggregates/confirm-totp-device | Web screen aggregate &#39;Web_confirmTotpDevice&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webConvertEmployeeTrial**](docs/WebScreensApi.md#webconvertemployeetrial) | **POST** /v1/web/aggregates/convert-employee-trial | Web screen aggregate &#39;Web_ConvertEmployeeTrial&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webCopySnapshots**](docs/WebScreensApi.md#webcopysnapshots) | **POST** /v1/web/aggregates/copy-snapshots | Web screen aggregate &#39;Web_CopySnapshots&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webCreateAIReport**](docs/WebScreensApi.md#webcreateaireport) | **POST** /v1/web/aggregates/create-a-i-report | Web screen aggregate &#39;Web_CreateAIReport&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webCreateAdvisorSubscription**](docs/WebScreensApi.md#webcreateadvisorsubscription) | **POST** /v1/web/aggregates/create-advisor-subscription | Web screen aggregate &#39;Web_CreateAdvisorSubscription&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webCreateCoinbaseAccount**](docs/WebScreensApi.md#webcreatecoinbaseaccount) | **POST** /v1/web/aggregates/create-coinbase-account | Web screen aggregate &#39;Web_CreateCoinbaseAccount&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webCreateEquityAccountWithGrants**](docs/WebScreensApi.md#webcreateequityaccountwithgrants) | **POST** /v1/web/aggregates/create-equity-account-with-grants | Web screen aggregate &#39;Web_CreateEquityAccountWithGrants&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webCreateFeedbackEvent**](docs/WebScreensApi.md#webcreatefeedbackevent) | **POST** /v1/web/aggregates/create-feedback-event | Web screen aggregate &#39;Web_CreateFeedbackEvent&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webCreatePromoCodeCheckoutSession**](docs/WebScreensApi.md#webcreatepromocodecheckoutsession) | **POST** /v1/web/aggregates/create-promo-code-checkout-session | Web screen aggregate &#39;Web_CreatePromoCodeCheckoutSession&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webCreateSpinwheelAccountMapping**](docs/WebScreensApi.md#webcreatespinwheelaccountmapping) | **POST** /v1/web/aggregates/create-spinwheel-account-mapping | Web screen aggregate &#39;Web_CreateSpinwheelAccountMapping&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webCreateSubscription**](docs/WebScreensApi.md#webcreatesubscription) | **POST** /v1/web/aggregates/create-subscription | Web screen aggregate &#39;Web_CreateSubscription&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webCreateSubscriptionSponsorshipInvites**](docs/WebScreensApi.md#webcreatesubscriptionsponsorshipinvites) | **POST** /v1/web/aggregates/create-subscription-sponsorship-invites | Web screen aggregate &#39;Web_CreateSubscriptionSponsorshipInvites&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webCreateUnconfirmedTotpDevice**](docs/WebScreensApi.md#webcreateunconfirmedtotpdevice) | **POST** /v1/web/aggregates/create-unconfirmed-totp-device | Web screen aggregate &#39;Web_createUnconfirmedTotpDevice&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webCreateZillowAccount**](docs/WebScreensApi.md#webcreatezillowaccount) | **POST** /v1/web/aggregates/create-zillow-account | Web screen aggregate &#39;Web_CreateZillowAccount&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webDeleteAccountLogo**](docs/WebScreensApi.md#webdeleteaccountlogo) | **POST** /v1/web/aggregates/delete-account-logo | Web screen aggregate &#39;Web_DeleteAccountLogo&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webDeleteAllGoalReconciliationRecords**](docs/WebScreensApi.md#webdeleteallgoalreconciliationrecords) | **POST** /v1/web/aggregates/delete-all-goal-reconciliation-records | Web screen aggregate &#39;Web_DeleteAllGoalReconciliationRecords&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webDeleteAllTransactionRulesMutation**](docs/WebScreensApi.md#webdeletealltransactionrulesmutation) | **POST** /v1/web/aggregates/delete-all-transaction-rules-mutation | Web screen aggregate &#39;Web_DeleteAllTransactionRulesMutation&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webDeleteTaxScheduleCategoryMapping**](docs/WebScreensApi.md#webdeletetaxschedulecategorymapping) | **POST** /v1/web/aggregates/delete-tax-schedule-category-mapping | Web screen aggregate &#39;Web_DeleteTaxScheduleCategoryMapping&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webDeleteUserFromHousehold**](docs/WebScreensApi.md#webdeleteuserfromhousehold) | **POST** /v1/web/aggregates/delete-user-from-household | Web screen aggregate &#39;Web_DeleteUserFromHousehold&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webDirectLinkAccountSelectDataProvider**](docs/WebScreensApi.md#webdirectlinkaccountselectdataprovider) | **POST** /v1/web/screens/direct-link-account-select-data-provider | Web screen aggregate &#39;Web_DirectLinkAccountSelectDataProvider&#39; (query, opaque pass-through)
*WebScreensApi* | [**webDisableMfa**](docs/WebScreensApi.md#webdisablemfa) | **POST** /v1/web/aggregates/disable-mfa | Web screen aggregate &#39;Web_DisableMfa&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webDisconnectCredentialMutation**](docs/WebScreensApi.md#webdisconnectcredentialmutation) | **POST** /v1/web/aggregates/disconnect-credential-mutation | Web screen aggregate &#39;Web_DisconnectCredentialMutation&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webDisconnectDiscord**](docs/WebScreensApi.md#webdisconnectdiscord) | **POST** /v1/web/aggregates/disconnect-discord | Web screen aggregate &#39;Web_DisconnectDiscord&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webDiscordOAuthCallback**](docs/WebScreensApi.md#webdiscordoauthcallback) | **POST** /v1/web/aggregates/discord-o-auth-callback | Web screen aggregate &#39;Web_DiscordOAuthCallback&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webEmployeeMenuDeleteCreditScoreSnapshots**](docs/WebScreensApi.md#webemployeemenudeletecreditscoresnapshots) | **POST** /v1/web/aggregates/employee-menu-delete-credit-score-snapshots | Web screen aggregate &#39;Web_EmployeeMenuDeleteCreditScoreSnapshots&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webEmployeeMenuGetFinancialInsightIds**](docs/WebScreensApi.md#webemployeemenugetfinancialinsightids) | **POST** /v1/web/screens/employee-menu-get-financial-insight-ids | Web screen aggregate &#39;Web_EmployeeMenuGetFinancialInsightIds&#39; (query, opaque pass-through)
*WebScreensApi* | [**webEmployeeMenuResetAiAssistantOptIn**](docs/WebScreensApi.md#webemployeemenuresetaiassistantoptin) | **POST** /v1/web/aggregates/employee-menu-reset-ai-assistant-opt-in | Web screen aggregate &#39;Web_EmployeeMenuResetAiAssistantOptIn&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webEmployeeMenuSoftDeleteFinancialInsight**](docs/WebScreensApi.md#webemployeemenusoftdeletefinancialinsight) | **POST** /v1/web/aggregates/employee-menu-soft-delete-financial-insight | Web screen aggregate &#39;Web_EmployeeMenuSoftDeleteFinancialInsight&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webEquityAccountDetailsGetAccount**](docs/WebScreensApi.md#webequityaccountdetailsgetaccount) | **POST** /v1/web/screens/equity-account-details-get-account | Web screen aggregate &#39;Web_EquityAccountDetails_getAccount&#39; (query, opaque pass-through)
*WebScreensApi* | [**webEquityAccountDetailsGetLinkedAccount**](docs/WebScreensApi.md#webequityaccountdetailsgetlinkedaccount) | **POST** /v1/web/screens/equity-account-details-get-linked-account | Web screen aggregate &#39;Web_EquityAccountDetails_getLinkedAccount&#39; (query, opaque pass-through)
*WebScreensApi* | [**webExtendFreeTrialDuration**](docs/WebScreensApi.md#webextendfreetrialduration) | **POST** /v1/web/aggregates/extend-free-trial-duration | Web screen aggregate &#39;Web_ExtendFreeTrialDuration&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webGenerateReportName**](docs/WebScreensApi.md#webgeneratereportname) | **POST** /v1/web/screens/generate-report-name | Web screen aggregate &#39;Web_GenerateReportName&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGetAccount**](docs/WebScreensApi.md#webgetaccount) | **POST** /v1/web/screens/get-account | Web screen aggregate &#39;Web_GetAccount&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGetAccountTypes**](docs/WebScreensApi.md#webgetaccounttypes) | **POST** /v1/web/screens/get-account-types | Web screen aggregate &#39;Web_GetAccountTypes&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGetAccountsForTransfer**](docs/WebScreensApi.md#webgetaccountsfortransfer) | **POST** /v1/web/screens/get-accounts-for-transfer | Web screen aggregate &#39;Web_GetAccountsForTransfer&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGetAccountsPage**](docs/WebScreensApi.md#webgetaccountspage) | **POST** /v1/web/screens/get-accounts-page | Web screen aggregate &#39;Web_GetAccountsPage&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGetAccountsPageRecentBalance**](docs/WebScreensApi.md#webgetaccountspagerecentbalance) | **POST** /v1/web/screens/get-accounts-page-recent-balance | Web screen aggregate &#39;Web_GetAccountsPageRecentBalance&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGetAdvisorClientsPage**](docs/WebScreensApi.md#webgetadvisorclientspage) | **POST** /v1/web/screens/get-advisor-clients-page | Web screen aggregate &#39;Web_GetAdvisorClientsPage&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGetAdvisorProfilePage**](docs/WebScreensApi.md#webgetadvisorprofilepage) | **POST** /v1/web/screens/get-advisor-profile-page | Web screen aggregate &#39;Web_GetAdvisorProfilePage&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGetBalanceHistoryParserColumns**](docs/WebScreensApi.md#webgetbalancehistoryparsercolumns) | **POST** /v1/web/screens/get-balance-history-parser-columns | Web screen aggregate &#39;Web_GetBalanceHistoryParserColumns&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGetBusinessSetupPriorTracking**](docs/WebScreensApi.md#webgetbusinesssetuppriortracking) | **POST** /v1/web/screens/get-business-setup-prior-tracking | Web screen aggregate &#39;Web_GetBusinessSetupPriorTracking&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGetCancellationReasonsWithSubreasons**](docs/WebScreensApi.md#webgetcancellationreasonswithsubreasons) | **POST** /v1/web/screens/get-cancellation-reasons-with-subreasons | Web screen aggregate &#39;Web_GetCancellationReasonsWithSubreasons&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGetCategorizationDetails**](docs/WebScreensApi.md#webgetcategorizationdetails) | **POST** /v1/web/screens/get-categorization-details | Web screen aggregate &#39;Web_GetCategorizationDetails&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGetCategoryGroupDetails**](docs/WebScreensApi.md#webgetcategorygroupdetails) | **POST** /v1/web/screens/get-category-group-details | Web screen aggregate &#39;Web_GetCategoryGroupDetails&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGetCategorySelectOptions**](docs/WebScreensApi.md#webgetcategoryselectoptions) | **POST** /v1/web/screens/get-category-select-options | Web screen aggregate &#39;Web_GetCategorySelectOptions&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGetConnectedApps**](docs/WebScreensApi.md#webgetconnectedapps) | **POST** /v1/web/screens/get-connected-apps | Web screen aggregate &#39;Web_GetConnectedApps&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGetContactSupportFormData**](docs/WebScreensApi.md#webgetcontactsupportformdata) | **POST** /v1/web/screens/get-contact-support-form-data | Web screen aggregate &#39;Web_GetContactSupportFormData&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGetDiscordConnectionRedirectUrl**](docs/WebScreensApi.md#webgetdiscordconnectionredirecturl) | **POST** /v1/web/screens/get-discord-connection-redirect-url | Web screen aggregate &#39;Web_GetDiscordConnectionRedirectUrl&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGetDownloadScheduleCSession**](docs/WebScreensApi.md#webgetdownloadschedulecsession) | **POST** /v1/web/screens/get-download-schedule-c-session | Web screen aggregate &#39;Web_GetDownloadScheduleCSession&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGetEventPopoverTransactions**](docs/WebScreensApi.md#webgeteventpopovertransactions) | **POST** /v1/web/screens/get-event-popover-transactions | Web screen aggregate &#39;Web_GetEventPopoverTransactions&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGetFilteredAccounts**](docs/WebScreensApi.md#webgetfilteredaccounts) | **POST** /v1/web/screens/get-filtered-accounts | Web screen aggregate &#39;Web_GetFilteredAccounts&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGetFlexibleGroupRolloverSettings**](docs/WebScreensApi.md#webgetflexiblegrouprolloversettings) | **POST** /v1/web/screens/get-flexible-group-rollover-settings | Web screen aggregate &#39;Web_GetFlexibleGroupRolloverSettings&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGetGiftedSubscriptionsForPolling**](docs/WebScreensApi.md#webgetgiftedsubscriptionsforpolling) | **POST** /v1/web/screens/get-gifted-subscriptions-for-polling | Web screen aggregate &#39;Web_GetGiftedSubscriptionsForPolling&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGetInvestmentsAccounts**](docs/WebScreensApi.md#webgetinvestmentsaccounts) | **POST** /v1/web/screens/get-investments-accounts | Web screen aggregate &#39;Web_GetInvestmentsAccounts&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGetInvestmentsDashboardCard**](docs/WebScreensApi.md#webgetinvestmentsdashboardcard) | **POST** /v1/web/screens/get-investments-dashboard-card | Web screen aggregate &#39;Web_GetInvestmentsDashboardCard&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGetInvestmentsHoldingDrawerHistoricalPerformance**](docs/WebScreensApi.md#webgetinvestmentsholdingdrawerhistoricalperformance) | **POST** /v1/web/screens/get-investments-holding-drawer-historical-performance | Web screen aggregate &#39;Web_GetInvestmentsHoldingDrawerHistoricalPerformance&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGetMeCollaborationProfileStep**](docs/WebScreensApi.md#webgetmecollaborationprofilestep) | **POST** /v1/web/screens/get-me-collaboration-profile-step | Web screen aggregate &#39;Web_GetMeCollaborationProfileStep&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGetMerchantSelectHouseholdMerchants**](docs/WebScreensApi.md#webgetmerchantselecthouseholdmerchants) | **POST** /v1/web/screens/get-merchant-select-household-merchants | Web screen aggregate &#39;Web_GetMerchantSelectHouseholdMerchants&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGetMerchantSelectRecommendedMerchants**](docs/WebScreensApi.md#webgetmerchantselectrecommendedmerchants) | **POST** /v1/web/screens/get-merchant-select-recommended-merchants | Web screen aggregate &#39;Web_GetMerchantSelectRecommendedMerchants&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGetMerchantSelectTransactionDetails**](docs/WebScreensApi.md#webgetmerchantselecttransactiondetails) | **POST** /v1/web/screens/get-merchant-select-transaction-details | Web screen aggregate &#39;Web_GetMerchantSelectTransactionDetails&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGetMerchantSettingsPage**](docs/WebScreensApi.md#webgetmerchantsettingspage) | **POST** /v1/web/screens/get-merchant-settings-page | Web screen aggregate &#39;Web_GetMerchantSettingsPage&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGetPlanRecommendationData**](docs/WebScreensApi.md#webgetplanrecommendationdata) | **POST** /v1/web/screens/get-plan-recommendation-data | Web screen aggregate &#39;Web_GetPlanRecommendationData&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGetPortfolio**](docs/WebScreensApi.md#webgetportfolio) | **POST** /v1/web/screens/get-portfolio | Web screen aggregate &#39;Web_GetPortfolio&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGetPortfolioWithClassification**](docs/WebScreensApi.md#webgetportfoliowithclassification) | **POST** /v1/web/screens/get-portfolio-with-classification | Web screen aggregate &#39;Web_GetPortfolioWithClassification&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGetRecommendedCategories**](docs/WebScreensApi.md#webgetrecommendedcategories) | **POST** /v1/web/screens/get-recommended-categories | Web screen aggregate &#39;Web_GetRecommendedCategories&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGetScheduleCLineItems**](docs/WebScreensApi.md#webgetscheduleclineitems) | **POST** /v1/web/screens/get-schedule-c-line-items | Web screen aggregate &#39;Web_GetScheduleCLineItems&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGetSecuritiesHistoricalPerformance**](docs/WebScreensApi.md#webgetsecuritieshistoricalperformance) | **POST** /v1/web/screens/get-securities-historical-performance | Web screen aggregate &#39;Web_GetSecuritiesHistoricalPerformance&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGetSecuritySettings**](docs/WebScreensApi.md#webgetsecuritysettings) | **POST** /v1/web/screens/get-security-settings | Web screen aggregate &#39;Web_GetSecuritySettings&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGetSidebarData**](docs/WebScreensApi.md#webgetsidebardata) | **POST** /v1/web/screens/get-sidebar-data | Web screen aggregate &#39;Web_GetSidebarData&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGetStatementParserColumns**](docs/WebScreensApi.md#webgetstatementparsercolumns) | **POST** /v1/web/screens/get-statement-parser-columns | Web screen aggregate &#39;Web_GetStatementParserColumns&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGetSubscription**](docs/WebScreensApi.md#webgetsubscription) | **POST** /v1/web/screens/get-subscription | Web screen aggregate &#39;Web_GetSubscription&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGetSubscriptionModal**](docs/WebScreensApi.md#webgetsubscriptionmodal) | **POST** /v1/web/screens/get-subscription-modal | Web screen aggregate &#39;Web_GetSubscriptionModal&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGetTaxPrepCategoryTransactions**](docs/WebScreensApi.md#webgettaxprepcategorytransactions) | **POST** /v1/web/screens/get-tax-prep-category-transactions | Web screen aggregate &#39;Web_GetTaxPrepCategoryTransactions&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGetTaxPrepUnmappedCategoryTransactions**](docs/WebScreensApi.md#webgettaxprepunmappedcategorytransactions) | **POST** /v1/web/screens/get-tax-prep-unmapped-category-transactions | Web screen aggregate &#39;Web_GetTaxPrepUnmappedCategoryTransactions&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGetTopInstitutionGroupByType**](docs/WebScreensApi.md#webgettopinstitutiongroupbytype) | **POST** /v1/web/screens/get-top-institution-group-by-type | Web screen aggregate &#39;Web_GetTopInstitutionGroupByType&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGetTransactionFiltersMetadata**](docs/WebScreensApi.md#webgettransactionfiltersmetadata) | **POST** /v1/web/screens/get-transaction-filters-metadata | Web screen aggregate &#39;Web_GetTransactionFiltersMetadata&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGetTransactionsPage**](docs/WebScreensApi.md#webgettransactionspage) | **POST** /v1/web/screens/get-transactions-page | Web screen aggregate &#39;Web_GetTransactionsPage&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGetTransactionsSummaryCard**](docs/WebScreensApi.md#webgettransactionssummarycard) | **POST** /v1/web/screens/get-transactions-summary-card | Web screen aggregate &#39;Web_GetTransactionsSummaryCard&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGetTrustAndWillSubscription**](docs/WebScreensApi.md#webgettrustandwillsubscription) | **POST** /v1/web/screens/get-trust-and-will-subscription | Web screen aggregate &#39;Web_GetTrustAndWillSubscription&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGetUserDismissedRetailSyncBanner**](docs/WebScreensApi.md#webgetuserdismissedretailsyncbanner) | **POST** /v1/web/screens/get-user-dismissed-retail-sync-banner | Web screen aggregate &#39;Web_GetUserDismissedRetailSyncBanner&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGetUserHasConfiguredExtension**](docs/WebScreensApi.md#webgetuserhasconfiguredextension) | **POST** /v1/web/screens/get-user-has-configured-extension | Web screen aggregate &#39;Web_GetUserHasConfiguredExtension&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGetUserPlatforms**](docs/WebScreensApi.md#webgetuserplatforms) | **POST** /v1/web/screens/get-user-platforms | Web screen aggregate &#39;Web_GetUserPlatforms&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGiveEmployeeInfinitePlusAccess**](docs/WebScreensApi.md#webgiveemployeeinfiniteplusaccess) | **POST** /v1/web/aggregates/give-employee-infinite-plus-access | Web screen aggregate &#39;Web_GiveEmployeeInfinitePlusAccess&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webGiveEmployeeInfinitePremiumAccess**](docs/WebScreensApi.md#webgiveemployeeinfinitepremiumaccess) | **POST** /v1/web/aggregates/give-employee-infinite-premium-access | Web screen aggregate &#39;Web_GiveEmployeeInfinitePremiumAccess&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webGoalDetailV2**](docs/WebScreensApi.md#webgoaldetailv2) | **POST** /v1/web/screens/goal-detail-v2 | Web screen aggregate &#39;Web_GoalDetailV2&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGoalSelectGoals**](docs/WebScreensApi.md#webgoalselectgoals) | **POST** /v1/web/screens/goal-select-goals | Web screen aggregate &#39;Web_GoalSelectGoals&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGoalSelectTransaction**](docs/WebScreensApi.md#webgoalselecttransaction) | **POST** /v1/web/screens/goal-select-transaction | Web screen aggregate &#39;Web_GoalSelectTransaction&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGoalsAllocateBalanceModal**](docs/WebScreensApi.md#webgoalsallocatebalancemodal) | **POST** /v1/web/screens/goals-allocate-balance-modal | Web screen aggregate &#39;Web_GoalsAllocateBalanceModal&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGoalsAllocationCardAccounts**](docs/WebScreensApi.md#webgoalsallocationcardaccounts) | **POST** /v1/web/screens/goals-allocation-card-accounts | Web screen aggregate &#39;Web_GoalsAllocationCardAccounts&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGoalsDashboardCardV2**](docs/WebScreensApi.md#webgoalsdashboardcardv2) | **POST** /v1/web/screens/goals-dashboard-card-v2 | Web screen aggregate &#39;Web_GoalsDashboardCardV2&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGoalsMapAccounts**](docs/WebScreensApi.md#webgoalsmapaccounts) | **POST** /v1/web/screens/goals-map-accounts | Web screen aggregate &#39;Web_GoalsMapAccounts&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGoalsMapAccountsModal**](docs/WebScreensApi.md#webgoalsmapaccountsmodal) | **POST** /v1/web/screens/goals-map-accounts-modal | Web screen aggregate &#39;Web_GoalsMapAccountsModal&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGoalsMessageBlock**](docs/WebScreensApi.md#webgoalsmessageblock) | **POST** /v1/web/screens/goals-message-block | Web screen aggregate &#39;Web_GoalsMessageBlock&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGoalsMonthlyBudgets**](docs/WebScreensApi.md#webgoalsmonthlybudgets) | **POST** /v1/web/screens/goals-monthly-budgets | Web screen aggregate &#39;Web_GoalsMonthlyBudgets&#39; (query, opaque pass-through)
*WebScreensApi* | [**webGoalsV2**](docs/WebScreensApi.md#webgoalsv2) | **POST** /v1/web/screens/goals-v2 | Web screen aggregate &#39;Web_GoalsV2&#39; (query, opaque pass-through)
*WebScreensApi* | [**webImportStatementGetAccount**](docs/WebScreensApi.md#webimportstatementgetaccount) | **POST** /v1/web/screens/import-statement-get-account | Web screen aggregate &#39;Web_ImportStatementGetAccount&#39; (query, opaque pass-through)
*WebScreensApi* | [**webInitScheduleCDefaultMappings**](docs/WebScreensApi.md#webinitschedulecdefaultmappings) | **POST** /v1/web/aggregates/init-schedule-c-default-mappings | Web screen aggregate &#39;Web_InitScheduleCDefaultMappings&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webInviteEmail**](docs/WebScreensApi.md#webinviteemail) | **POST** /v1/web/aggregates/invite-email | Web screen aggregate &#39;Web_InviteEmail&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webMigrateHouseholdToSavingGoals**](docs/WebScreensApi.md#webmigratehouseholdtosavinggoals) | **POST** /v1/web/aggregates/migrate-household-to-saving-goals | Web screen aggregate &#39;Web_MigrateHouseholdToSavingGoals&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webMintTransactionsCountQuery**](docs/WebScreensApi.md#webminttransactionscountquery) | **POST** /v1/web/screens/mint-transactions-count-query | Web screen aggregate &#39;Web_MintTransactionsCountQuery&#39; (query, opaque pass-through)
*WebScreensApi* | [**webMonthlyBudgetGoalsModal**](docs/WebScreensApi.md#webmonthlybudgetgoalsmodal) | **POST** /v1/web/screens/monthly-budget-goals-modal | Web screen aggregate &#39;Web_MonthlyBudgetGoalsModal&#39; (query, opaque pass-through)
*WebScreensApi* | [**webMoveMoneyMutation**](docs/WebScreensApi.md#webmovemoneymutation) | **POST** /v1/web/aggregates/move-money-mutation | Web screen aggregate &#39;Web_MoveMoneyMutation&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webOnboardingTopInstitutions**](docs/WebScreensApi.md#webonboardingtopinstitutions) | **POST** /v1/web/screens/onboarding-top-institutions | Web screen aggregate &#39;Web_OnboardingTopInstitutions&#39; (query, opaque pass-through)
*WebScreensApi* | [**webParseUploadStatementSession**](docs/WebScreensApi.md#webparseuploadstatementsession) | **POST** /v1/web/aggregates/parse-upload-statement-session | Web screen aggregate &#39;Web_ParseUploadStatementSession&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webPlusUpgradeTrial**](docs/WebScreensApi.md#webplusupgradetrial) | **POST** /v1/web/screens/plus-upgrade-trial | Web screen aggregate &#39;Web_PlusUpgradeTrial&#39; (query, opaque pass-through)
*WebScreensApi* | [**webPreTaxBudgetGoalsList**](docs/WebScreensApi.md#webpretaxbudgetgoalslist) | **POST** /v1/web/screens/pre-tax-budget-goals-list | Web screen aggregate &#39;Web_PreTaxBudgetGoalsList&#39; (query, opaque pass-through)
*WebScreensApi* | [**webPreviewAccountDataTransferSnapshots**](docs/WebScreensApi.md#webpreviewaccountdatatransfersnapshots) | **POST** /v1/web/screens/preview-account-data-transfer-snapshots | Web screen aggregate &#39;Web_PreviewAccountDataTransferSnapshots&#39; (query, opaque pass-through)
*WebScreensApi* | [**webPreviewAccountDataTransferTransactions**](docs/WebScreensApi.md#webpreviewaccountdatatransfertransactions) | **POST** /v1/web/screens/preview-account-data-transfer-transactions | Web screen aggregate &#39;Web_PreviewAccountDataTransferTransactions&#39; (query, opaque pass-through)
*WebScreensApi* | [**webPreviewCopySnapshots**](docs/WebScreensApi.md#webpreviewcopysnapshots) | **POST** /v1/web/screens/preview-copy-snapshots | Web screen aggregate &#39;Web_PreviewCopySnapshots&#39; (query, opaque pass-through)
*WebScreensApi* | [**webRankGoalsList**](docs/WebScreensApi.md#webrankgoalslist) | **POST** /v1/web/screens/rank-goals-list | Web screen aggregate &#39;Web_RankGoalsList&#39; (query, opaque pass-through)
*WebScreensApi* | [**webReactivateSubscription**](docs/WebScreensApi.md#webreactivatesubscription) | **POST** /v1/web/aggregates/reactivate-subscription | Web screen aggregate &#39;Web_ReactivateSubscription&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webRecalculateBudgetMutation**](docs/WebScreensApi.md#webrecalculatebudgetmutation) | **POST** /v1/web/aggregates/recalculate-budget-mutation | Web screen aggregate &#39;Web_RecalculateBudgetMutation&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webRecommendedAccountDataTransferDates**](docs/WebScreensApi.md#webrecommendedaccountdatatransferdates) | **POST** /v1/web/screens/recommended-account-data-transfer-dates | Web screen aggregate &#39;Web_RecommendedAccountDataTransferDates&#39; (query, opaque pass-through)
*WebScreensApi* | [**webRecommendedAccounts**](docs/WebScreensApi.md#webrecommendedaccounts) | **POST** /v1/web/screens/recommended-accounts | Web screen aggregate &#39;Web_RecommendedAccounts&#39; (query, opaque pass-through)
*WebScreensApi* | [**webRecurringFilterQuery**](docs/WebScreensApi.md#webrecurringfilterquery) | **POST** /v1/web/screens/recurring-filter-query | Web screen aggregate &#39;Web_RecurringFilterQuery&#39; (query, opaque pass-through)
*WebScreensApi* | [**webRecurringPausedBanner**](docs/WebScreensApi.md#webrecurringpausedbanner) | **POST** /v1/web/screens/recurring-paused-banner | Web screen aggregate &#39;Web_RecurringPausedBanner&#39; (query, opaque pass-through)
*WebScreensApi* | [**webRemoveEmployeeEntitlements**](docs/WebScreensApi.md#webremoveemployeeentitlements) | **POST** /v1/web/aggregates/remove-employee-entitlements | Web screen aggregate &#39;Web_RemoveEmployeeEntitlements&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webResetAndSyncAccountMutation**](docs/WebScreensApi.md#webresetandsyncaccountmutation) | **POST** /v1/web/aggregates/reset-and-sync-account-mutation | Web screen aggregate &#39;Web_ResetAndSyncAccountMutation&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webResetCategorizationMemory**](docs/WebScreensApi.md#webresetcategorizationmemory) | **POST** /v1/web/aggregates/reset-categorization-memory | Web screen aggregate &#39;Web_ResetCategorizationMemory&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webResetEmployeeAndSubscribe**](docs/WebScreensApi.md#webresetemployeeandsubscribe) | **POST** /v1/web/aggregates/reset-employee-and-subscribe | Web screen aggregate &#39;Web_ResetEmployeeAndSubscribe&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webResetEmployeeToNoSubscription**](docs/WebScreensApi.md#webresetemployeetonosubscription) | **POST** /v1/web/aggregates/reset-employee-to-no-subscription | Web screen aggregate &#39;Web_ResetEmployeeToNoSubscription&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webResetHouseholdRecurringMerchantSearch**](docs/WebScreensApi.md#webresethouseholdrecurringmerchantsearch) | **POST** /v1/web/aggregates/reset-household-recurring-merchant-search | Web screen aggregate &#39;Web_ResetHouseholdRecurringMerchantSearch&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webResetRolloverMutation**](docs/WebScreensApi.md#webresetrollovermutation) | **POST** /v1/web/aggregates/reset-rollover-mutation | Web screen aggregate &#39;Web_ResetRolloverMutation&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webResetWeeklyRecapMutation**](docs/WebScreensApi.md#webresetweeklyrecapmutation) | **POST** /v1/web/aggregates/reset-weekly-recap-mutation | Web screen aggregate &#39;Web_ResetWeeklyRecapMutation&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webRestoreCategory**](docs/WebScreensApi.md#webrestorecategory) | **POST** /v1/web/aggregates/restore-category | Web screen aggregate &#39;Web_RestoreCategory&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webReviewStream**](docs/WebScreensApi.md#webreviewstream) | **POST** /v1/web/aggregates/review-stream | Web screen aggregate &#39;Web_ReviewStream&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webRevokeConnectedApp**](docs/WebScreensApi.md#webrevokeconnectedapp) | **POST** /v1/web/aggregates/revoke-connected-app | Web screen aggregate &#39;Web_RevokeConnectedApp&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webRevokeSponsorshipInvite**](docs/WebScreensApi.md#webrevokesponsorshipinvite) | **POST** /v1/web/aggregates/revoke-sponsorship-invite | Web screen aggregate &#39;Web_RevokeSponsorshipInvite&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webSearchInstitutionsQuery**](docs/WebScreensApi.md#websearchinstitutionsquery) | **POST** /v1/web/screens/search-institutions-query | Web screen aggregate &#39;Web_SearchInstitutionsQuery&#39; (query, opaque pass-through)
*WebScreensApi* | [**webSearchMerchants**](docs/WebScreensApi.md#websearchmerchants) | **POST** /v1/web/screens/search-merchants | Web screen aggregate &#39;Web_SearchMerchants&#39; (query, opaque pass-through)
*WebScreensApi* | [**webSearchSecurities**](docs/WebScreensApi.md#websearchsecurities) | **POST** /v1/web/screens/search-securities | Web screen aggregate &#39;Web_SearchSecurities&#39; (query, opaque pass-through)
*WebScreensApi* | [**webSetEmployeeActiveSubscription**](docs/WebScreensApi.md#websetemployeeactivesubscription) | **POST** /v1/web/aggregates/set-employee-active-subscription | Web screen aggregate &#39;Web_SetEmployeeActiveSubscription&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webSetEmployeeCancellationDiscountUsed**](docs/WebScreensApi.md#websetemployeecancellationdiscountused) | **POST** /v1/web/aggregates/set-employee-cancellation-discount-used | Web screen aggregate &#39;Web_SetEmployeeCancellationDiscountUsed&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webSetEmployeeExpiredTrial**](docs/WebScreensApi.md#websetemployeeexpiredtrial) | **POST** /v1/web/aggregates/set-employee-expired-trial | Web screen aggregate &#39;Web_SetEmployeeExpiredTrial&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webSetEmployeePlusTrialFields**](docs/WebScreensApi.md#websetemployeeplustrialfields) | **POST** /v1/web/aggregates/set-employee-plus-trial-fields | Web screen aggregate &#39;Web_SetEmployeePlusTrialFields&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webSetEmployeeSubscriptionEnded**](docs/WebScreensApi.md#websetemployeesubscriptionended) | **POST** /v1/web/aggregates/set-employee-subscription-ended | Web screen aggregate &#39;Web_SetEmployeeSubscriptionEnded&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webSnapshotsForAccountCopyBalancePreview**](docs/WebScreensApi.md#websnapshotsforaccountcopybalancepreview) | **POST** /v1/web/screens/snapshots-for-account-copy-balance-preview | Web screen aggregate &#39;Web_SnapshotsForAccountCopyBalancePreview&#39; (query, opaque pass-through)
*WebScreensApi* | [**webStartDownloadScheduleCSession**](docs/WebScreensApi.md#webstartdownloadschedulecsession) | **POST** /v1/web/aggregates/start-download-schedule-c-session | Web screen aggregate &#39;Web_StartDownloadScheduleCSession&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webSyncEmployeeSubscription**](docs/WebScreensApi.md#websyncemployeesubscription) | **POST** /v1/web/aggregates/sync-employee-subscription | Web screen aggregate &#39;Web_SyncEmployeeSubscription&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webTargetAmountsGoalsList**](docs/WebScreensApi.md#webtargetamountsgoalslist) | **POST** /v1/web/screens/target-amounts-goals-list | Web screen aggregate &#39;Web_TargetAmountsGoalsList&#39; (query, opaque pass-through)
*WebScreensApi* | [**webTestCreditScoreChangedNotification**](docs/WebScreensApi.md#webtestcreditscorechangednotification) | **POST** /v1/web/aggregates/test-credit-score-changed-notification | Web screen aggregate &#39;Web_TestCreditScoreChangedNotification&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webToggleSupportAccountAccess**](docs/WebScreensApi.md#webtogglesupportaccountaccess) | **POST** /v1/web/aggregates/toggle-support-account-access | Web screen aggregate &#39;Web_ToggleSupportAccountAccess&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webTransactionDrawerDeleteAttachment**](docs/WebScreensApi.md#webtransactiondrawerdeleteattachment) | **POST** /v1/web/aggregates/transaction-drawer-delete-attachment | Web screen aggregate &#39;Web_TransactionDrawerDeleteAttachment&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webTransactionsFilterQuery**](docs/WebScreensApi.md#webtransactionsfilterquery) | **POST** /v1/web/screens/transactions-filter-query | Web screen aggregate &#39;Web_TransactionsFilterQuery&#39; (query, opaque pass-through)
*WebScreensApi* | [**webTransactionsMessageBlock**](docs/WebScreensApi.md#webtransactionsmessageblock) | **POST** /v1/web/screens/transactions-message-block | Web screen aggregate &#39;Web_TransactionsMessageBlock&#39; (query, opaque pass-through)
*WebScreensApi* | [**webUndoSavingsGoalMigration**](docs/WebScreensApi.md#webundosavingsgoalmigration) | **POST** /v1/web/aggregates/undo-savings-goal-migration | Web screen aggregate &#39;Web_UndoSavingsGoalMigration&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webUnmatchRetailTransaction**](docs/WebScreensApi.md#webunmatchretailtransaction) | **POST** /v1/web/aggregates/unmatch-retail-transaction | Web screen aggregate &#39;Web_UnmatchRetailTransaction&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webUpdateAccountOrder**](docs/WebScreensApi.md#webupdateaccountorder) | **POST** /v1/web/aggregates/update-account-order | Web screen aggregate &#39;Web_UpdateAccountOrder&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webUpdateBusinessTrackingSetupIntent**](docs/WebScreensApi.md#webupdatebusinesstrackingsetupintent) | **POST** /v1/web/aggregates/update-business-tracking-setup-intent | Web screen aggregate &#39;Web_UpdateBusinessTrackingSetupIntent&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webUpdateCategory**](docs/WebScreensApi.md#webupdatecategory) | **POST** /v1/web/aggregates/update-category | Web screen aggregate &#39;Web_UpdateCategory&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webUpdateCategoryFromBudgetOnboarding**](docs/WebScreensApi.md#webupdatecategoryfrombudgetonboarding) | **POST** /v1/web/aggregates/update-category-from-budget-onboarding | Web screen aggregate &#39;Web_UpdateCategoryFromBudgetOnboarding&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webUpdateCategoryGroupOrder**](docs/WebScreensApi.md#webupdatecategorygrouporder) | **POST** /v1/web/aggregates/update-category-group-order | Web screen aggregate &#39;Web_UpdateCategoryGroupOrder&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webUpdateCategoryOrder**](docs/WebScreensApi.md#webupdatecategoryorder) | **POST** /v1/web/aggregates/update-category-order | Web screen aggregate &#39;Web_UpdateCategoryOrder&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webUpdateCompany**](docs/WebScreensApi.md#webupdatecompany) | **POST** /v1/web/aggregates/update-company | Web screen aggregate &#39;Web_UpdateCompany&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webUpdateDismissedRetailSyncBanner**](docs/WebScreensApi.md#webupdatedismissedretailsyncbanner) | **POST** /v1/web/aggregates/update-dismissed-retail-sync-banner | Web screen aggregate &#39;Web_UpdateDismissedRetailSyncBanner&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webUpdateGoalsPriorities**](docs/WebScreensApi.md#webupdategoalspriorities) | **POST** /v1/web/aggregates/update-goals-priorities | Web screen aggregate &#39;Web_UpdateGoalsPriorities&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webUpdateOrCreateAdvisorStripePaymentMethod**](docs/WebScreensApi.md#webupdateorcreateadvisorstripepaymentmethod) | **POST** /v1/web/aggregates/update-or-create-advisor-stripe-payment-method | Web screen aggregate &#39;Web_UpdateOrCreateAdvisorStripePaymentMethod&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webUpdateOrCreateStripePaymentMethod**](docs/WebScreensApi.md#webupdateorcreatestripepaymentmethod) | **POST** /v1/web/aggregates/update-or-create-stripe-payment-method | Web screen aggregate &#39;Web_UpdateOrCreateStripePaymentMethod&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webUpdateRenewalReminder**](docs/WebScreensApi.md#webupdaterenewalreminder) | **POST** /v1/web/aggregates/update-renewal-reminder | Web screen aggregate &#39;Web_UpdateRenewalReminder&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webUpdateRuleOrderMutation**](docs/WebScreensApi.md#webupdateruleordermutation) | **POST** /v1/web/aggregates/update-rule-order-mutation | Web screen aggregate &#39;Web_UpdateRuleOrderMutation&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webUpdateSubscriptionSponsor**](docs/WebScreensApi.md#webupdatesubscriptionsponsor) | **POST** /v1/web/aggregates/update-subscription-sponsor | Web screen aggregate &#39;Web_UpdateSubscriptionSponsor&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webUpdateTransactionOverview**](docs/WebScreensApi.md#webupdatetransactionoverview) | **POST** /v1/web/aggregates/update-transaction-overview | Web screen aggregate &#39;Web_UpdateTransactionOverview&#39; (mutation, opaque pass-through)
*WebScreensApi* | [**webUpdateUserFinancialProfile**](docs/WebScreensApi.md#webupdateuserfinancialprofile) | **POST** /v1/web/aggregates/update-user-financial-profile | Web screen aggregate &#39;Web_UpdateUserFinancialProfile&#39; (mutation, opaque pass-through)


## Documentation For Models

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
 - [BulkDeleteCategories200Response](docs/BulkDeleteCategories200Response.md)
 - [BulkDeleteCategories200ResponseData](docs/BulkDeleteCategories200ResponseData.md)
 - [BulkDeleteCategoriesRequest](docs/BulkDeleteCategoriesRequest.md)
 - [BulkDeleteCategoriesResponse](docs/BulkDeleteCategoriesResponse.md)
 - [BulkDeleteFailure](docs/BulkDeleteFailure.md)
 - [BulkDeleteTransactions200Response](docs/BulkDeleteTransactions200Response.md)
 - [BulkDeleteTransactions200ResponseData](docs/BulkDeleteTransactions200ResponseData.md)
 - [BulkDeleteTransactionsRequest](docs/BulkDeleteTransactionsRequest.md)
 - [BulkDeleteTransactionsResponse](docs/BulkDeleteTransactionsResponse.md)
 - [BulkMutationError](docs/BulkMutationError.md)
 - [BulkTaxLotInput](docs/BulkTaxLotInput.md)
 - [BulkTaxLotRowError](docs/BulkTaxLotRowError.md)
 - [BulkTransactionFilters](docs/BulkTransactionFilters.md)
 - [BulkTransactionUpdates](docs/BulkTransactionUpdates.md)
 - [BulkUpdateAccounts200Response](docs/BulkUpdateAccounts200Response.md)
 - [BulkUpdateAccounts200ResponseData](docs/BulkUpdateAccounts200ResponseData.md)
 - [BulkUpdateAccountsEntry](docs/BulkUpdateAccountsEntry.md)
 - [BulkUpdateAccountsRequest](docs/BulkUpdateAccountsRequest.md)
 - [BulkUpdateAccountsResponse](docs/BulkUpdateAccountsResponse.md)
 - [BulkUpdateHoldings200Response](docs/BulkUpdateHoldings200Response.md)
 - [BulkUpdateHoldings200ResponseData](docs/BulkUpdateHoldings200ResponseData.md)
 - [BulkUpdateHoldingsEntry](docs/BulkUpdateHoldingsEntry.md)
 - [BulkUpdateHoldingsFailure](docs/BulkUpdateHoldingsFailure.md)
 - [BulkUpdateHoldingsRequest](docs/BulkUpdateHoldingsRequest.md)
 - [BulkUpdateHoldingsResponse](docs/BulkUpdateHoldingsResponse.md)
 - [BulkUpdateTransactions200Response](docs/BulkUpdateTransactions200Response.md)
 - [BulkUpdateTransactions200ResponseData](docs/BulkUpdateTransactions200ResponseData.md)
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
 - [ContributeToGoal200Response](docs/ContributeToGoal200Response.md)
 - [ContributeToGoal200ResponseData](docs/ContributeToGoal200ResponseData.md)
 - [ContributeToGoal200ResponseDataGoalEvent](docs/ContributeToGoal200ResponseDataGoalEvent.md)
 - [ContributeToGoal200ResponseDataGoalEventAccount](docs/ContributeToGoal200ResponseDataGoalEventAccount.md)
 - [ContributeToGoal200ResponseDataGoalEventGoal](docs/ContributeToGoal200ResponseDataGoalEventGoal.md)
 - [ContributeToGoalRequest](docs/ContributeToGoalRequest.md)
 - [ContributeToGoalResponse](docs/ContributeToGoalResponse.md)
 - [CookiePreferences](docs/CookiePreferences.md)
 - [CostBasisLot](docs/CostBasisLot.md)
 - [CreateCategory200Response](docs/CreateCategory200Response.md)
 - [CreateCategory200ResponseData](docs/CreateCategory200ResponseData.md)
 - [CreateCategoryGroup200Response](docs/CreateCategoryGroup200Response.md)
 - [CreateCategoryGroup200ResponseData](docs/CreateCategoryGroup200ResponseData.md)
 - [CreateCategoryGroupRequest](docs/CreateCategoryGroupRequest.md)
 - [CreateCategoryGroupResponse](docs/CreateCategoryGroupResponse.md)
 - [CreateCategoryRequest](docs/CreateCategoryRequest.md)
 - [CreateCategoryResponse](docs/CreateCategoryResponse.md)
 - [CreateGoal200Response](docs/CreateGoal200Response.md)
 - [CreateGoal200ResponseData](docs/CreateGoal200ResponseData.md)
 - [CreateGoalRequest](docs/CreateGoalRequest.md)
 - [CreateGoalResponse](docs/CreateGoalResponse.md)
 - [CreateManualAccount200Response](docs/CreateManualAccount200Response.md)
 - [CreateManualAccount200ResponseData](docs/CreateManualAccount200ResponseData.md)
 - [CreateManualAccountRequest](docs/CreateManualAccountRequest.md)
 - [CreateManualAccountResponse](docs/CreateManualAccountResponse.md)
 - [CreateManualHolding200Response](docs/CreateManualHolding200Response.md)
 - [CreateManualHolding200ResponseData](docs/CreateManualHolding200ResponseData.md)
 - [CreateManualHoldingRequest](docs/CreateManualHoldingRequest.md)
 - [CreateManualHoldingResponse](docs/CreateManualHoldingResponse.md)
 - [CreateManualInvestmentsAccountRequest](docs/CreateManualInvestmentsAccountRequest.md)
 - [CreateManualInvestmentsAccountResponse](docs/CreateManualInvestmentsAccountResponse.md)
 - [CreateManualTaxLot200Response](docs/CreateManualTaxLot200Response.md)
 - [CreateManualTaxLot200ResponseData](docs/CreateManualTaxLot200ResponseData.md)
 - [CreateManualTaxLotRequest](docs/CreateManualTaxLotRequest.md)
 - [CreateManualTaxLotResponse](docs/CreateManualTaxLotResponse.md)
 - [CreateManualTaxLotsBulk200Response](docs/CreateManualTaxLotsBulk200Response.md)
 - [CreateManualTaxLotsBulk200ResponseData](docs/CreateManualTaxLotsBulk200ResponseData.md)
 - [CreateManualTaxLotsBulkRequest](docs/CreateManualTaxLotsBulkRequest.md)
 - [CreateManualTaxLotsBulkResponse](docs/CreateManualTaxLotsBulkResponse.md)
 - [CreatePaycheck200Response](docs/CreatePaycheck200Response.md)
 - [CreatePaycheck200ResponseData](docs/CreatePaycheck200ResponseData.md)
 - [CreatePaycheckEmployer200Response](docs/CreatePaycheckEmployer200Response.md)
 - [CreatePaycheckEmployer200ResponseData](docs/CreatePaycheckEmployer200ResponseData.md)
 - [CreatePaycheckEmployerRequest](docs/CreatePaycheckEmployerRequest.md)
 - [CreatePaycheckEmployerResponse](docs/CreatePaycheckEmployerResponse.md)
 - [CreatePaycheckRequest](docs/CreatePaycheckRequest.md)
 - [CreatePaycheckResponse](docs/CreatePaycheckResponse.md)
 - [CreateTag200Response](docs/CreateTag200Response.md)
 - [CreateTag200ResponseData](docs/CreateTag200ResponseData.md)
 - [CreateTagRequest](docs/CreateTagRequest.md)
 - [CreateTransaction200Response](docs/CreateTransaction200Response.md)
 - [CreateTransaction200ResponseData](docs/CreateTransaction200ResponseData.md)
 - [CreateTransactionRequest](docs/CreateTransactionRequest.md)
 - [CreateTransactionResponse](docs/CreateTransactionResponse.md)
 - [CreateTransactionRule200Response](docs/CreateTransactionRule200Response.md)
 - [CreateTransactionRule200ResponseData](docs/CreateTransactionRule200ResponseData.md)
 - [CreateTransactionRuleRequest](docs/CreateTransactionRuleRequest.md)
 - [CreateTransactionRuleResponse](docs/CreateTransactionRuleResponse.md)
 - [CreateTransactionTagResponse](docs/CreateTransactionTagResponse.md)
 - [CredentialInstitutionRow](docs/CredentialInstitutionRow.md)
 - [CreditHistoryResponse](docs/CreditHistoryResponse.md)
 - [CreditScoreSnapshot](docs/CreditScoreSnapshot.md)
 - [CurrencyPreferences](docs/CurrencyPreferences.md)
 - [DashboardRecurringItem](docs/DashboardRecurringItem.md)
 - [DashboardTransactionRow](docs/DashboardTransactionRow.md)
 - [DeleteAccount200Response](docs/DeleteAccount200Response.md)
 - [DeleteAccount200ResponseData](docs/DeleteAccount200ResponseData.md)
 - [DeleteAccountResponse](docs/DeleteAccountResponse.md)
 - [DeleteCategoryGroupResponse](docs/DeleteCategoryGroupResponse.md)
 - [DeleteCategoryResponse](docs/DeleteCategoryResponse.md)
 - [DeleteGoalResponse](docs/DeleteGoalResponse.md)
 - [DeleteHoldingResponse](docs/DeleteHoldingResponse.md)
 - [DeleteInstitution200Response](docs/DeleteInstitution200Response.md)
 - [DeleteInstitution200ResponseData](docs/DeleteInstitution200ResponseData.md)
 - [DeleteInstitutionResponse](docs/DeleteInstitutionResponse.md)
 - [DeleteMerchant200Response](docs/DeleteMerchant200Response.md)
 - [DeleteMerchant200ResponseData](docs/DeleteMerchant200ResponseData.md)
 - [DeleteMerchantResponse](docs/DeleteMerchantResponse.md)
 - [DeletePaycheckEmployerResponse](docs/DeletePaycheckEmployerResponse.md)
 - [DeletePaycheckResponse](docs/DeletePaycheckResponse.md)
 - [DeleteTag200Response](docs/DeleteTag200Response.md)
 - [DeleteTag200ResponseData](docs/DeleteTag200ResponseData.md)
 - [DeleteTagResponse](docs/DeleteTagResponse.md)
 - [DeleteTaxLot200Response](docs/DeleteTaxLot200Response.md)
 - [DeleteTaxLot200ResponseData](docs/DeleteTaxLot200ResponseData.md)
 - [DeleteTaxLotResponse](docs/DeleteTaxLotResponse.md)
 - [DeleteTaxLotsBulk200Response](docs/DeleteTaxLotsBulk200Response.md)
 - [DeleteTaxLotsBulk200ResponseData](docs/DeleteTaxLotsBulk200ResponseData.md)
 - [DeleteTaxLotsBulkRequest](docs/DeleteTaxLotsBulkRequest.md)
 - [DeleteTaxLotsBulkResponse](docs/DeleteTaxLotsBulkResponse.md)
 - [DeleteTransactionResponse](docs/DeleteTransactionResponse.md)
 - [DeleteTransactionRuleResponse](docs/DeleteTransactionRuleResponse.md)
 - [DismissNotification200Response](docs/DismissNotification200Response.md)
 - [DismissNotification200ResponseData](docs/DismissNotification200ResponseData.md)
 - [DuplicateGroupKey](docs/DuplicateGroupKey.md)
 - [ErrorResponse](docs/ErrorResponse.md)
 - [ExpenseByCategoryRow](docs/ExpenseByCategoryRow.md)
 - [ExpenseByMerchantRow](docs/ExpenseByMerchantRow.md)
 - [ExpenseByTagRow](docs/ExpenseByTagRow.md)
 - [ExplainTransaction200Response](docs/ExplainTransaction200Response.md)
 - [ExplainTransaction200ResponseData](docs/ExplainTransaction200ResponseData.md)
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
 - [GetAccountBalanceAtDate200Response](docs/GetAccountBalanceAtDate200Response.md)
 - [GetAccountBalanceAtDate200ResponseData](docs/GetAccountBalanceAtDate200ResponseData.md)
 - [GetAccountBalanceAtDateResponse](docs/GetAccountBalanceAtDateResponse.md)
 - [GetAccountGroups200Response](docs/GetAccountGroups200Response.md)
 - [GetAccountGroups200ResponseData](docs/GetAccountGroups200ResponseData.md)
 - [GetAccountGroupsResponse](docs/GetAccountGroupsResponse.md)
 - [GetAccountHistory200Response](docs/GetAccountHistory200Response.md)
 - [GetAccountHistory200ResponseData](docs/GetAccountHistory200ResponseData.md)
 - [GetAccountHoldings200Response](docs/GetAccountHoldings200Response.md)
 - [GetAccountHoldings200ResponseData](docs/GetAccountHoldings200ResponseData.md)
 - [GetAccountTypeOptions200Response](docs/GetAccountTypeOptions200Response.md)
 - [GetAccountTypeOptionsResponse](docs/GetAccountTypeOptionsResponse.md)
 - [GetAccountTypeOptionsResponseData](docs/GetAccountTypeOptionsResponseData.md)
 - [GetAccountsForTransactionFilter200Response](docs/GetAccountsForTransactionFilter200Response.md)
 - [GetAccountsForTransactionFilter200ResponseData](docs/GetAccountsForTransactionFilter200ResponseData.md)
 - [GetAccountsForTransactionsResponse](docs/GetAccountsForTransactionsResponse.md)
 - [GetAppVersion200Response](docs/GetAppVersion200Response.md)
 - [GetAppVersion200ResponseData](docs/GetAppVersion200ResponseData.md)
 - [GetAppVersionResponse](docs/GetAppVersionResponse.md)
 - [GetAppearance200Response](docs/GetAppearance200Response.md)
 - [GetAppearance200ResponseData](docs/GetAppearance200ResponseData.md)
 - [GetAppearanceResponse](docs/GetAppearanceResponse.md)
 - [GetAttachment200Response](docs/GetAttachment200Response.md)
 - [GetAttachment200ResponseData](docs/GetAttachment200ResponseData.md)
 - [GetAttachmentResponse](docs/GetAttachmentResponse.md)
 - [GetAuthStatus200Response](docs/GetAuthStatus200Response.md)
 - [GetBalanceHistoryStatus200Response](docs/GetBalanceHistoryStatus200Response.md)
 - [GetBalanceHistoryStatus200ResponseData](docs/GetBalanceHistoryStatus200ResponseData.md)
 - [GetBetaFeatures200Response](docs/GetBetaFeatures200Response.md)
 - [GetBetaFeatures200ResponseData](docs/GetBetaFeatures200ResponseData.md)
 - [GetBetaFeaturesResponse](docs/GetBetaFeaturesResponse.md)
 - [GetBudgetMonth200Response](docs/GetBudgetMonth200Response.md)
 - [GetBudgetMonth200ResponseData](docs/GetBudgetMonth200ResponseData.md)
 - [GetBudgetMonthResponse](docs/GetBudgetMonthResponse.md)
 - [GetBudgetStatus200Response](docs/GetBudgetStatus200Response.md)
 - [GetBudgetStatus200ResponseData](docs/GetBudgetStatus200ResponseData.md)
 - [GetBudgetStatusResponse](docs/GetBudgetStatusResponse.md)
 - [GetBudgetTimeline200Response](docs/GetBudgetTimeline200Response.md)
 - [GetBudgetTimeline200ResponseData](docs/GetBudgetTimeline200ResponseData.md)
 - [GetBudgetTimelineResponse](docs/GetBudgetTimelineResponse.md)
 - [GetBudgets200Response](docs/GetBudgets200Response.md)
 - [GetBudgets200ResponseData](docs/GetBudgets200ResponseData.md)
 - [GetCalendarEvents200Response](docs/GetCalendarEvents200Response.md)
 - [GetCalendarEvents200ResponseData](docs/GetCalendarEvents200ResponseData.md)
 - [GetCalendarEventsResponse](docs/GetCalendarEventsResponse.md)
 - [GetCashflow200Response](docs/GetCashflow200Response.md)
 - [GetCashflow200ResponseData](docs/GetCashflow200ResponseData.md)
 - [GetCashflowBreakdown200Response](docs/GetCashflowBreakdown200Response.md)
 - [GetCashflowBreakdown200ResponseData](docs/GetCashflowBreakdown200ResponseData.md)
 - [GetCashflowDashboard200Response](docs/GetCashflowDashboard200Response.md)
 - [GetCashflowDashboard200ResponseData](docs/GetCashflowDashboard200ResponseData.md)
 - [GetCashflowEntities200Response](docs/GetCashflowEntities200Response.md)
 - [GetCashflowEntities200ResponseData](docs/GetCashflowEntities200ResponseData.md)
 - [GetCashflowFiltered200Response](docs/GetCashflowFiltered200Response.md)
 - [GetCashflowFiltered200ResponseData](docs/GetCashflowFiltered200ResponseData.md)
 - [GetCashflowReport200Response](docs/GetCashflowReport200Response.md)
 - [GetCashflowReport200ResponseData](docs/GetCashflowReport200ResponseData.md)
 - [GetCashflowReportResponse](docs/GetCashflowReportResponse.md)
 - [GetCashflowTimeframe200Response](docs/GetCashflowTimeframe200Response.md)
 - [GetCashflowTimeframe200ResponseData](docs/GetCashflowTimeframe200ResponseData.md)
 - [GetCategoryDeletionInfo200Response](docs/GetCategoryDeletionInfo200Response.md)
 - [GetCategoryDeletionInfo200ResponseData](docs/GetCategoryDeletionInfo200ResponseData.md)
 - [GetCategoryDeletionInfoResponse](docs/GetCategoryDeletionInfoResponse.md)
 - [GetCategoryEdit200Response](docs/GetCategoryEdit200Response.md)
 - [GetCategoryEdit200ResponseData](docs/GetCategoryEdit200ResponseData.md)
 - [GetCategoryEditResponse](docs/GetCategoryEditResponse.md)
 - [GetCategoryGroupDetails200Response](docs/GetCategoryGroupDetails200Response.md)
 - [GetCategoryGroupDetails200ResponseData](docs/GetCategoryGroupDetails200ResponseData.md)
 - [GetCategoryGroupDetailsResponse](docs/GetCategoryGroupDetailsResponse.md)
 - [GetCategoryReport200Response](docs/GetCategoryReport200Response.md)
 - [GetCategoryReport200ResponseData](docs/GetCategoryReport200ResponseData.md)
 - [GetCategoryReportResponse](docs/GetCategoryReportResponse.md)
 - [GetChannelNotificationPrefsResponse](docs/GetChannelNotificationPrefsResponse.md)
 - [GetCookiePreferences200Response](docs/GetCookiePreferences200Response.md)
 - [GetCookiePreferences200ResponseData](docs/GetCookiePreferences200ResponseData.md)
 - [GetCookiePreferencesResponse](docs/GetCookiePreferencesResponse.md)
 - [GetCredentialInstitutions200Response](docs/GetCredentialInstitutions200Response.md)
 - [GetCredentialInstitutions200ResponseData](docs/GetCredentialInstitutions200ResponseData.md)
 - [GetCredentialInstitutionsResponse](docs/GetCredentialInstitutionsResponse.md)
 - [GetCreditHistory200Response](docs/GetCreditHistory200Response.md)
 - [GetCreditHistory200ResponseData](docs/GetCreditHistory200ResponseData.md)
 - [GetCurrency200Response](docs/GetCurrency200Response.md)
 - [GetCurrency200ResponseData](docs/GetCurrency200ResponseData.md)
 - [GetCurrencyResponse](docs/GetCurrencyResponse.md)
 - [GetDownloadTransactionsSession200Response](docs/GetDownloadTransactionsSession200Response.md)
 - [GetDownloadTransactionsSession200ResponseData](docs/GetDownloadTransactionsSession200ResponseData.md)
 - [GetEmailNotificationPrefs200Response](docs/GetEmailNotificationPrefs200Response.md)
 - [GetEmailNotificationPrefs200ResponseData](docs/GetEmailNotificationPrefs200ResponseData.md)
 - [GetEntitlements200Response](docs/GetEntitlements200Response.md)
 - [GetEntitlements200ResponseData](docs/GetEntitlements200ResponseData.md)
 - [GetExpenseByCategory200Response](docs/GetExpenseByCategory200Response.md)
 - [GetExpenseByCategory200ResponseData](docs/GetExpenseByCategory200ResponseData.md)
 - [GetExpenseByCategoryResponse](docs/GetExpenseByCategoryResponse.md)
 - [GetExpenseByMerchant200Response](docs/GetExpenseByMerchant200Response.md)
 - [GetExpenseByMerchant200ResponseData](docs/GetExpenseByMerchant200ResponseData.md)
 - [GetExpenseByMerchantResponse](docs/GetExpenseByMerchantResponse.md)
 - [GetExpenseByTag200Response](docs/GetExpenseByTag200Response.md)
 - [GetExpenseByTag200ResponseData](docs/GetExpenseByTag200ResponseData.md)
 - [GetExpenseByTagResponse](docs/GetExpenseByTagResponse.md)
 - [GetFeatureFlags200Response](docs/GetFeatureFlags200Response.md)
 - [GetFeatureFlags200ResponseData](docs/GetFeatureFlags200ResponseData.md)
 - [GetFeatureFlagsResponse](docs/GetFeatureFlagsResponse.md)
 - [GetFinancialInsight200Response](docs/GetFinancialInsight200Response.md)
 - [GetFinancialInsight200ResponseData](docs/GetFinancialInsight200ResponseData.md)
 - [GetFinancialInsightResponse](docs/GetFinancialInsightResponse.md)
 - [GetFiscalYear200Response](docs/GetFiscalYear200Response.md)
 - [GetFiscalYear200ResponseData](docs/GetFiscalYear200ResponseData.md)
 - [GetFiscalYearResponse](docs/GetFiscalYearResponse.md)
 - [GetGoalContributionHistory200Response](docs/GetGoalContributionHistory200Response.md)
 - [GetGoalContributionHistory200ResponseData](docs/GetGoalContributionHistory200ResponseData.md)
 - [GetGoalContributionHistoryResponse](docs/GetGoalContributionHistoryResponse.md)
 - [GetGoalProjection200Response](docs/GetGoalProjection200Response.md)
 - [GetGoalProjection200ResponseData](docs/GetGoalProjection200ResponseData.md)
 - [GetGoalProjectionResponse](docs/GetGoalProjectionResponse.md)
 - [GetGoalsCurrentMonthTotals200Response](docs/GetGoalsCurrentMonthTotals200Response.md)
 - [GetGoalsCurrentMonthTotals200ResponseData](docs/GetGoalsCurrentMonthTotals200ResponseData.md)
 - [GetGoalsCurrentMonthTotalsResponse](docs/GetGoalsCurrentMonthTotalsResponse.md)
 - [GetHealth200Response](docs/GetHealth200Response.md)
 - [GetHoldingHistory200Response](docs/GetHoldingHistory200Response.md)
 - [GetHoldingHistory200ResponseData](docs/GetHoldingHistory200ResponseData.md)
 - [GetHoldingHistoryResponse](docs/GetHoldingHistoryResponse.md)
 - [GetHoldingTransactions200Response](docs/GetHoldingTransactions200Response.md)
 - [GetHoldingTransactions200ResponseData](docs/GetHoldingTransactions200ResponseData.md)
 - [GetHoldingTransactionsResponse](docs/GetHoldingTransactionsResponse.md)
 - [GetHouseholdMembers200Response](docs/GetHouseholdMembers200Response.md)
 - [GetHouseholdMembers200ResponseData](docs/GetHouseholdMembers200ResponseData.md)
 - [GetHouseholdMembers200ResponseDataMembersInner](docs/GetHouseholdMembers200ResponseDataMembersInner.md)
 - [GetHouseholdPreferences200Response](docs/GetHouseholdPreferences200Response.md)
 - [GetHouseholdPreferences200ResponseData](docs/GetHouseholdPreferences200ResponseData.md)
 - [GetIncomeReport200Response](docs/GetIncomeReport200Response.md)
 - [GetIncomeReport200ResponseData](docs/GetIncomeReport200ResponseData.md)
 - [GetIncomeReportResponse](docs/GetIncomeReportResponse.md)
 - [GetIncomeVsExpenseYoy200Response](docs/GetIncomeVsExpenseYoy200Response.md)
 - [GetIncomeVsExpenseYoy200ResponseData](docs/GetIncomeVsExpenseYoy200ResponseData.md)
 - [GetIncomeVsExpenseYoyResponse](docs/GetIncomeVsExpenseYoyResponse.md)
 - [GetInstitutionByPlaidId200Response](docs/GetInstitutionByPlaidId200Response.md)
 - [GetInstitutionByPlaidId200ResponseData](docs/GetInstitutionByPlaidId200ResponseData.md)
 - [GetInstitutionByPlaidResponse](docs/GetInstitutionByPlaidResponse.md)
 - [GetInstitutions200Response](docs/GetInstitutions200Response.md)
 - [GetInstitutions200ResponseData](docs/GetInstitutions200ResponseData.md)
 - [GetIntegrationStatus200Response](docs/GetIntegrationStatus200Response.md)
 - [GetIntegrationStatus200ResponseData](docs/GetIntegrationStatus200ResponseData.md)
 - [GetIntegrationStatusResponse](docs/GetIntegrationStatusResponse.md)
 - [GetLatestFinancialInsightRunResponse](docs/GetLatestFinancialInsightRunResponse.md)
 - [GetLatestInsightRun200Response](docs/GetLatestInsightRun200Response.md)
 - [GetLatestInsightRun200ResponseData](docs/GetLatestInsightRun200ResponseData.md)
 - [GetLatestRefreshOperation200Response](docs/GetLatestRefreshOperation200Response.md)
 - [GetLatestRefreshOperation200ResponseData](docs/GetLatestRefreshOperation200ResponseData.md)
 - [GetLookup200Response](docs/GetLookup200Response.md)
 - [GetLookup200ResponseData](docs/GetLookup200ResponseData.md)
 - [GetLookupResponse](docs/GetLookupResponse.md)
 - [GetMe200Response](docs/GetMe200Response.md)
 - [GetMe200ResponseData](docs/GetMe200ResponseData.md)
 - [GetMerchant200Response](docs/GetMerchant200Response.md)
 - [GetMerchant200ResponseData](docs/GetMerchant200ResponseData.md)
 - [GetMerchantResponse](docs/GetMerchantResponse.md)
 - [GetMerchantStats200Response](docs/GetMerchantStats200Response.md)
 - [GetMerchantStats200ResponseData](docs/GetMerchantStats200ResponseData.md)
 - [GetMerchantStatsResponse](docs/GetMerchantStatsResponse.md)
 - [GetMerchantTransactions200Response](docs/GetMerchantTransactions200Response.md)
 - [GetMerchantTransactions200ResponseData](docs/GetMerchantTransactions200ResponseData.md)
 - [GetMerchantTransactionsResponse](docs/GetMerchantTransactionsResponse.md)
 - [GetMonthlyReportSummary200Response](docs/GetMonthlyReportSummary200Response.md)
 - [GetMonthlyReportSummary200ResponseData](docs/GetMonthlyReportSummary200ResponseData.md)
 - [GetMonthlyReportSummaryResponse](docs/GetMonthlyReportSummaryResponse.md)
 - [GetMyHousehold200Response](docs/GetMyHousehold200Response.md)
 - [GetMyHousehold200ResponseData](docs/GetMyHousehold200ResponseData.md)
 - [GetNetWorthReport200Response](docs/GetNetWorthReport200Response.md)
 - [GetNetWorthReport200ResponseData](docs/GetNetWorthReport200ResponseData.md)
 - [GetNetWorthReportResponse](docs/GetNetWorthReportResponse.md)
 - [GetNetworth200Response](docs/GetNetworth200Response.md)
 - [GetNetworth200ResponseData](docs/GetNetworth200ResponseData.md)
 - [GetNetworthByType200Response](docs/GetNetworthByType200Response.md)
 - [GetNetworthByType200ResponseData](docs/GetNetworthByType200ResponseData.md)
 - [GetNetworthRecent200Response](docs/GetNetworthRecent200Response.md)
 - [GetNetworthRecent200ResponseData](docs/GetNetworthRecent200ResponseData.md)
 - [GetNotificationPreferences200Response](docs/GetNotificationPreferences200Response.md)
 - [GetNotificationPreferences200ResponseData](docs/GetNotificationPreferences200ResponseData.md)
 - [GetNotificationPreferencesResponse](docs/GetNotificationPreferencesResponse.md)
 - [GetNotifications200Response](docs/GetNotifications200Response.md)
 - [GetNotifications200ResponseData](docs/GetNotifications200ResponseData.md)
 - [GetNotifications200ResponseDataEdgesInner](docs/GetNotifications200ResponseDataEdgesInner.md)
 - [GetPaycheckResponse](docs/GetPaycheckResponse.md)
 - [GetPaychecksSummary200Response](docs/GetPaychecksSummary200Response.md)
 - [GetPaychecksSummary200ResponseData](docs/GetPaychecksSummary200ResponseData.md)
 - [GetPaychecksSummaryResponse](docs/GetPaychecksSummaryResponse.md)
 - [GetPlatformConfig200Response](docs/GetPlatformConfig200Response.md)
 - [GetPlatformConfig200ResponseData](docs/GetPlatformConfig200ResponseData.md)
 - [GetPlatformConfigResponse](docs/GetPlatformConfigResponse.md)
 - [GetPlusTierAccess200Response](docs/GetPlusTierAccess200Response.md)
 - [GetPlusTierAccess200ResponseData](docs/GetPlusTierAccess200ResponseData.md)
 - [GetPortfolioAllocation200Response](docs/GetPortfolioAllocation200Response.md)
 - [GetPortfolioAllocation200ResponseData](docs/GetPortfolioAllocation200ResponseData.md)
 - [GetPortfolioAllocationByHoldings200Response](docs/GetPortfolioAllocationByHoldings200Response.md)
 - [GetPortfolioAllocationByHoldings200ResponseData](docs/GetPortfolioAllocationByHoldings200ResponseData.md)
 - [GetPortfolioAllocationHoldingsDetail200Response](docs/GetPortfolioAllocationHoldingsDetail200Response.md)
 - [GetPortfolioAllocationHoldingsDetail200ResponseData](docs/GetPortfolioAllocationHoldingsDetail200ResponseData.md)
 - [GetRecurringDashboard200Response](docs/GetRecurringDashboard200Response.md)
 - [GetRecurringDashboard200ResponseData](docs/GetRecurringDashboard200ResponseData.md)
 - [GetRecurringDashboardResponse](docs/GetRecurringDashboardResponse.md)
 - [GetRecurringForecast200Response](docs/GetRecurringForecast200Response.md)
 - [GetRecurringForecast200ResponseData](docs/GetRecurringForecast200ResponseData.md)
 - [GetRecurringForecastResponse](docs/GetRecurringForecastResponse.md)
 - [GetRefreshStatus200Response](docs/GetRefreshStatus200Response.md)
 - [GetRefreshStatus200ResponseData](docs/GetRefreshStatus200ResponseData.md)
 - [GetReviewSummaryByUser200Response](docs/GetReviewSummaryByUser200Response.md)
 - [GetReviewSummaryByUser200ResponseData](docs/GetReviewSummaryByUser200ResponseData.md)
 - [GetSavingsRateReport200Response](docs/GetSavingsRateReport200Response.md)
 - [GetSavingsRateReport200ResponseData](docs/GetSavingsRateReport200ResponseData.md)
 - [GetSavingsRateReportResponse](docs/GetSavingsRateReportResponse.md)
 - [GetSavingsRateTrends200Response](docs/GetSavingsRateTrends200Response.md)
 - [GetSavingsRateTrends200ResponseData](docs/GetSavingsRateTrends200ResponseData.md)
 - [GetSavingsRateTrendsResponse](docs/GetSavingsRateTrendsResponse.md)
 - [GetSecurityDetails200Response](docs/GetSecurityDetails200Response.md)
 - [GetSecurityDetails200ResponseData](docs/GetSecurityDetails200ResponseData.md)
 - [GetSecurityDetailsResponse](docs/GetSecurityDetailsResponse.md)
 - [GetSecurityDividends200Response](docs/GetSecurityDividends200Response.md)
 - [GetSecurityDividends200ResponseData](docs/GetSecurityDividends200ResponseData.md)
 - [GetSecurityDividendsResponse](docs/GetSecurityDividendsResponse.md)
 - [GetSecurityHistoricalPerformance200Response](docs/GetSecurityHistoricalPerformance200Response.md)
 - [GetSecurityHistoricalPerformance200ResponseData](docs/GetSecurityHistoricalPerformance200ResponseData.md)
 - [GetSpendingDashboard200Response](docs/GetSpendingDashboard200Response.md)
 - [GetSpendingDashboard200ResponseData](docs/GetSpendingDashboard200ResponseData.md)
 - [GetSpendingDashboardResponse](docs/GetSpendingDashboardResponse.md)
 - [GetSpendingReport200Response](docs/GetSpendingReport200Response.md)
 - [GetSpendingReport200ResponseData](docs/GetSpendingReport200ResponseData.md)
 - [GetSpendingReportResponse](docs/GetSpendingReportResponse.md)
 - [GetSpendingTrends200Response](docs/GetSpendingTrends200Response.md)
 - [GetSpendingTrends200ResponseData](docs/GetSpendingTrends200ResponseData.md)
 - [GetSpendingTrendsResponse](docs/GetSpendingTrendsResponse.md)
 - [GetSubscription200Response](docs/GetSubscription200Response.md)
 - [GetSubscriptionDetails200Response](docs/GetSubscriptionDetails200Response.md)
 - [GetSubscriptionDetails200ResponseData](docs/GetSubscriptionDetails200ResponseData.md)
 - [GetSubscriptionDetailsResponse](docs/GetSubscriptionDetailsResponse.md)
 - [GetSubscriptionInvoices200Response](docs/GetSubscriptionInvoices200Response.md)
 - [GetSubscriptionInvoices200ResponseData](docs/GetSubscriptionInvoices200ResponseData.md)
 - [GetSubscriptionInvoicesResponse](docs/GetSubscriptionInvoicesResponse.md)
 - [GetSubscriptionReceipts200Response](docs/GetSubscriptionReceipts200Response.md)
 - [GetSubscriptionReceipts200ResponseData](docs/GetSubscriptionReceipts200ResponseData.md)
 - [GetSubscriptionReceiptsResponse](docs/GetSubscriptionReceiptsResponse.md)
 - [GetSubscriptionResponse](docs/GetSubscriptionResponse.md)
 - [GetTagReport200Response](docs/GetTagReport200Response.md)
 - [GetTagReport200ResponseData](docs/GetTagReport200ResponseData.md)
 - [GetTagReportResponse](docs/GetTagReportResponse.md)
 - [GetTaxBracketEstimates200Response](docs/GetTaxBracketEstimates200Response.md)
 - [GetTaxBracketEstimates200ResponseData](docs/GetTaxBracketEstimates200ResponseData.md)
 - [GetTaxBracketEstimatesResponse](docs/GetTaxBracketEstimatesResponse.md)
 - [GetTaxCategories200Response](docs/GetTaxCategories200Response.md)
 - [GetTaxCategories200ResponseData](docs/GetTaxCategories200ResponseData.md)
 - [GetTaxCategoriesResponse](docs/GetTaxCategoriesResponse.md)
 - [GetTaxCategoryAggregates200Response](docs/GetTaxCategoryAggregates200Response.md)
 - [GetTaxCategoryAggregates200ResponseData](docs/GetTaxCategoryAggregates200ResponseData.md)
 - [GetTaxCategoryAggregatesResponse](docs/GetTaxCategoryAggregatesResponse.md)
 - [GetTaxLotPerformance200Response](docs/GetTaxLotPerformance200Response.md)
 - [GetTaxLotPerformance200ResponseData](docs/GetTaxLotPerformance200ResponseData.md)
 - [GetTaxLotPerformanceResponse](docs/GetTaxLotPerformanceResponse.md)
 - [GetTaxScheduleCategoryMappings200Response](docs/GetTaxScheduleCategoryMappings200Response.md)
 - [GetTaxScheduleCategoryMappings200ResponseData](docs/GetTaxScheduleCategoryMappings200ResponseData.md)
 - [GetTaxScheduleCategoryMappingsResponse](docs/GetTaxScheduleCategoryMappingsResponse.md)
 - [GetTaxYearOverview200Response](docs/GetTaxYearOverview200Response.md)
 - [GetTaxYearOverview200ResponseData](docs/GetTaxYearOverview200ResponseData.md)
 - [GetTaxYearOverviewResponse](docs/GetTaxYearOverviewResponse.md)
 - [GetTopInstitutionGroups200Response](docs/GetTopInstitutionGroups200Response.md)
 - [GetTopInstitutionGroups200ResponseData](docs/GetTopInstitutionGroups200ResponseData.md)
 - [GetTopInstitutionGroupsResponse](docs/GetTopInstitutionGroupsResponse.md)
 - [GetTransactionAuditLog200Response](docs/GetTransactionAuditLog200Response.md)
 - [GetTransactionAuditLog200ResponseData](docs/GetTransactionAuditLog200ResponseData.md)
 - [GetTransactionAuditLogResponse](docs/GetTransactionAuditLogResponse.md)
 - [GetTransactionDetail200Response](docs/GetTransactionDetail200Response.md)
 - [GetTransactionDetail200ResponseData](docs/GetTransactionDetail200ResponseData.md)
 - [GetTransactionNotes200Response](docs/GetTransactionNotes200Response.md)
 - [GetTransactionNotes200ResponseData](docs/GetTransactionNotes200ResponseData.md)
 - [GetTransactionNotesResponse](docs/GetTransactionNotesResponse.md)
 - [GetTransactionSplitTemplates200Response](docs/GetTransactionSplitTemplates200Response.md)
 - [GetTransactionSplitTemplates200ResponseData](docs/GetTransactionSplitTemplates200ResponseData.md)
 - [GetTransactionSplitTemplatesResponse](docs/GetTransactionSplitTemplatesResponse.md)
 - [GetTransactionSplits200Response](docs/GetTransactionSplits200Response.md)
 - [GetTransactionSplits200ResponseData](docs/GetTransactionSplits200ResponseData.md)
 - [GetTransactionsDashboard200Response](docs/GetTransactionsDashboard200Response.md)
 - [GetTransactionsDashboard200ResponseData](docs/GetTransactionsDashboard200ResponseData.md)
 - [GetTransactionsDashboardResponse](docs/GetTransactionsDashboardResponse.md)
 - [GetTransactionsDuplicates200Response](docs/GetTransactionsDuplicates200Response.md)
 - [GetTransactionsDuplicates200ResponseData](docs/GetTransactionsDuplicates200ResponseData.md)
 - [GetTransactionsDuplicates200ResponseDataGroupsInner](docs/GetTransactionsDuplicates200ResponseDataGroupsInner.md)
 - [GetTransactionsSummary200Response](docs/GetTransactionsSummary200Response.md)
 - [GetTransactionsSummary200ResponseData](docs/GetTransactionsSummary200ResponseData.md)
 - [GetWeeklyRecap200Response](docs/GetWeeklyRecap200Response.md)
 - [GetWeeklyRecap200ResponseData](docs/GetWeeklyRecap200ResponseData.md)
 - [GetWeeklyRecapResponse](docs/GetWeeklyRecapResponse.md)
 - [GetZestimate200Response](docs/GetZestimate200Response.md)
 - [GetZestimate200ResponseData](docs/GetZestimate200ResponseData.md)
 - [GetZestimate200ResponseDataZestimatesInner](docs/GetZestimate200ResponseDataZestimatesInner.md)
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
 - [HardDeleteGoal200Response](docs/HardDeleteGoal200Response.md)
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
 - [InitiatePasswordChange200Response](docs/InitiatePasswordChange200Response.md)
 - [InitiatePasswordChange200ResponseData](docs/InitiatePasswordChange200ResponseData.md)
 - [InitiatePasswordChangeResponse](docs/InitiatePasswordChangeResponse.md)
 - [Institution](docs/Institution.md)
 - [InstitutionDetail](docs/InstitutionDetail.md)
 - [InstitutionsResponse](docs/InstitutionsResponse.md)
 - [IntegrationStatus](docs/IntegrationStatus.md)
 - [InviteHouseholdMember200Response](docs/InviteHouseholdMember200Response.md)
 - [InviteHouseholdMember200ResponseData](docs/InviteHouseholdMember200ResponseData.md)
 - [InviteHouseholdMemberRequest](docs/InviteHouseholdMemberRequest.md)
 - [InviteHouseholdMemberResponse](docs/InviteHouseholdMemberResponse.md)
 - [LatestFinancialInsightRun](docs/LatestFinancialInsightRun.md)
 - [LatestRefreshOperation](docs/LatestRefreshOperation.md)
 - [LatestRefreshOperationResponse](docs/LatestRefreshOperationResponse.md)
 - [LinkTransactionToGoal200Response](docs/LinkTransactionToGoal200Response.md)
 - [LinkTransactionToGoal200ResponseData](docs/LinkTransactionToGoal200ResponseData.md)
 - [LinkTransactionToGoalRequest](docs/LinkTransactionToGoalRequest.md)
 - [LinkedCredential](docs/LinkedCredential.md)
 - [ListAccounts200Response](docs/ListAccounts200Response.md)
 - [ListAccounts200ResponseData](docs/ListAccounts200ResponseData.md)
 - [ListAccountsResponse](docs/ListAccountsResponse.md)
 - [ListAllRecurring200Response](docs/ListAllRecurring200Response.md)
 - [ListAllRecurring200ResponseData](docs/ListAllRecurring200ResponseData.md)
 - [ListAllRecurringResponse](docs/ListAllRecurringResponse.md)
 - [ListCategories200Response](docs/ListCategories200Response.md)
 - [ListCategories200ResponseData](docs/ListCategories200ResponseData.md)
 - [ListCategoriesResponse](docs/ListCategoriesResponse.md)
 - [ListCategoryGroups200Response](docs/ListCategoryGroups200Response.md)
 - [ListCategoryGroups200ResponseData](docs/ListCategoryGroups200ResponseData.md)
 - [ListCategoryGroupsResponse](docs/ListCategoryGroupsResponse.md)
 - [ListFinancialInsights200Response](docs/ListFinancialInsights200Response.md)
 - [ListFinancialInsights200ResponseData](docs/ListFinancialInsights200ResponseData.md)
 - [ListFinancialInsightsResponse](docs/ListFinancialInsightsResponse.md)
 - [ListGoalEvents200Response](docs/ListGoalEvents200Response.md)
 - [ListGoalEvents200ResponseData](docs/ListGoalEvents200ResponseData.md)
 - [ListGoalEventsResponse](docs/ListGoalEventsResponse.md)
 - [ListGoals200Response](docs/ListGoals200Response.md)
 - [ListGoals200ResponseData](docs/ListGoals200ResponseData.md)
 - [ListGoalsResponse](docs/ListGoalsResponse.md)
 - [ListLinkedCredentials200Response](docs/ListLinkedCredentials200Response.md)
 - [ListLinkedCredentials200ResponseData](docs/ListLinkedCredentials200ResponseData.md)
 - [ListLinkedCredentialsResponse](docs/ListLinkedCredentialsResponse.md)
 - [ListPaycheckEmployers200Response](docs/ListPaycheckEmployers200Response.md)
 - [ListPaycheckEmployers200ResponseData](docs/ListPaycheckEmployers200ResponseData.md)
 - [ListPaycheckEmployersResponse](docs/ListPaycheckEmployersResponse.md)
 - [ListPaychecks200Response](docs/ListPaychecks200Response.md)
 - [ListPaychecks200ResponseData](docs/ListPaychecks200ResponseData.md)
 - [ListPaychecksResponse](docs/ListPaychecksResponse.md)
 - [ListRecurring200Response](docs/ListRecurring200Response.md)
 - [ListRecurring200ResponseData](docs/ListRecurring200ResponseData.md)
 - [ListRecurringAggregate200Response](docs/ListRecurringAggregate200Response.md)
 - [ListRecurringAggregate200ResponseData](docs/ListRecurringAggregate200ResponseData.md)
 - [ListRecurringAggregateResponse](docs/ListRecurringAggregateResponse.md)
 - [ListRecurringStreams200Response](docs/ListRecurringStreams200Response.md)
 - [ListRecurringStreams200ResponseData](docs/ListRecurringStreams200ResponseData.md)
 - [ListRecurringStreamsResponse](docs/ListRecurringStreamsResponse.md)
 - [ListTags200Response](docs/ListTags200Response.md)
 - [ListTags200ResponseData](docs/ListTags200ResponseData.md)
 - [ListTagsResponse](docs/ListTagsResponse.md)
 - [ListTaxLots200Response](docs/ListTaxLots200Response.md)
 - [ListTaxLots200ResponseData](docs/ListTaxLots200ResponseData.md)
 - [ListTaxLotsResponse](docs/ListTaxLotsResponse.md)
 - [ListTransactionRules200Response](docs/ListTransactionRules200Response.md)
 - [ListTransactionRules200ResponseData](docs/ListTransactionRules200ResponseData.md)
 - [ListTransactionRulesResponse](docs/ListTransactionRulesResponse.md)
 - [ListTransactions200Response](docs/ListTransactions200Response.md)
 - [ListTransactions200ResponseData](docs/ListTransactions200ResponseData.md)
 - [ListTransactionsResponse](docs/ListTransactionsResponse.md)
 - [LongTailRequest](docs/LongTailRequest.md)
 - [LongTailResponse](docs/LongTailResponse.md)
 - [LongTailResponseData](docs/LongTailResponseData.md)
 - [LookupEntity](docs/LookupEntity.md)
 - [MarkAllNotificationsAsRead200Response](docs/MarkAllNotificationsAsRead200Response.md)
 - [MarkAllNotificationsAsRead200ResponseData](docs/MarkAllNotificationsAsRead200ResponseData.md)
 - [MarkAsNotRecurringResponse](docs/MarkAsNotRecurringResponse.md)
 - [MarkAsRecurring200Response](docs/MarkAsRecurring200Response.md)
 - [MarkAsRecurring200ResponseData](docs/MarkAsRecurring200ResponseData.md)
 - [MarkAsRecurringRequest](docs/MarkAsRecurringRequest.md)
 - [MarkAsRecurringResponse](docs/MarkAsRecurringResponse.md)
 - [MarkGoalComplete200Response](docs/MarkGoalComplete200Response.md)
 - [MarkGoalComplete200ResponseData](docs/MarkGoalComplete200ResponseData.md)
 - [MarkNotificationAsRead200Response](docs/MarkNotificationAsRead200Response.md)
 - [MarkNotificationAsRead200ResponseData](docs/MarkNotificationAsRead200ResponseData.md)
 - [MarkTransactionAsReviewed200Response](docs/MarkTransactionAsReviewed200Response.md)
 - [MarkTransactionAsReviewed200ResponseData](docs/MarkTransactionAsReviewed200ResponseData.md)
 - [MarkTransactionAsReviewedResponse](docs/MarkTransactionAsReviewedResponse.md)
 - [MarkTransactionStreamAsNotRecurring200Response](docs/MarkTransactionStreamAsNotRecurring200Response.md)
 - [MarkTransactionStreamAsNotRecurring200ResponseData](docs/MarkTransactionStreamAsNotRecurring200ResponseData.md)
 - [MatchSearchTransactions200Response](docs/MatchSearchTransactions200Response.md)
 - [MatchSearchTransactions200ResponseData](docs/MatchSearchTransactions200ResponseData.md)
 - [MatchSearchTransactions200ResponseDataResultsInner](docs/MatchSearchTransactions200ResponseDataResultsInner.md)
 - [MatchSearchTransactions200ResponseDataResultsInnerAccount](docs/MatchSearchTransactions200ResponseDataResultsInnerAccount.md)
 - [MatchSearchTransactions200ResponseDataResultsInnerMerchant](docs/MatchSearchTransactions200ResponseDataResultsInnerMerchant.md)
 - [Merchant](docs/Merchant.md)
 - [MerchantAggregateRow](docs/MerchantAggregateRow.md)
 - [MerchantRecurringStream](docs/MerchantRecurringStream.md)
 - [MerchantRef](docs/MerchantRef.md)
 - [MerchantStats](docs/MerchantStats.md)
 - [MerchantTransactionRow](docs/MerchantTransactionRow.md)
 - [MergeRecurringStreams200Response](docs/MergeRecurringStreams200Response.md)
 - [MergeRecurringStreams200ResponseData](docs/MergeRecurringStreams200ResponseData.md)
 - [MergeRecurringStreamsRequest](docs/MergeRecurringStreamsRequest.md)
 - [MergeRecurringStreamsResponse](docs/MergeRecurringStreamsResponse.md)
 - [MobileScreenAggregateResponse](docs/MobileScreenAggregateResponse.md)
 - [MonthlyReportSummary](docs/MonthlyReportSummary.md)
 - [MoveTransactions200Response](docs/MoveTransactions200Response.md)
 - [MoveTransactions200ResponseData](docs/MoveTransactions200ResponseData.md)
 - [MoveTransactions200ResponseDataErrorsInner](docs/MoveTransactions200ResponseDataErrorsInner.md)
 - [MoveTransactionsRequest](docs/MoveTransactionsRequest.md)
 - [NetWorthReport](docs/NetWorthReport.md)
 - [NetWorthReportPoint](docs/NetWorthReportPoint.md)
 - [NetworthByTypeResponse](docs/NetworthByTypeResponse.md)
 - [NetworthRecentResponse](docs/NetworthRecentResponse.md)
 - [NetworthResponse](docs/NetworthResponse.md)
 - [NotificationPreference](docs/NotificationPreference.md)
 - [PauseSubscription200Response](docs/PauseSubscription200Response.md)
 - [PauseSubscription200ResponseData](docs/PauseSubscription200ResponseData.md)
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
 - [PreviewAccountBalance200Response](docs/PreviewAccountBalance200Response.md)
 - [PreviewAccountBalance200ResponseData](docs/PreviewAccountBalance200ResponseData.md)
 - [PreviewSubscriptionPlanChange200Response](docs/PreviewSubscriptionPlanChange200Response.md)
 - [PreviewSubscriptionPlanChange200ResponseData](docs/PreviewSubscriptionPlanChange200ResponseData.md)
 - [PreviewSubscriptionPlanChangeRequest](docs/PreviewSubscriptionPlanChangeRequest.md)
 - [PreviewSubscriptionPlanChangeResponse](docs/PreviewSubscriptionPlanChangeResponse.md)
 - [PreviewTransactionRule200Response](docs/PreviewTransactionRule200Response.md)
 - [PreviewTransactionRule200ResponseData](docs/PreviewTransactionRule200ResponseData.md)
 - [PreviewTransactionRuleResponse](docs/PreviewTransactionRuleResponse.md)
 - [RecentAccountBalances](docs/RecentAccountBalances.md)
 - [RecurringForecastEntry](docs/RecurringForecastEntry.md)
 - [RecurringResponse](docs/RecurringResponse.md)
 - [RecurringStreamRef](docs/RecurringStreamRef.md)
 - [Ref](docs/Ref.md)
 - [RefreshStatusResponse](docs/RefreshStatusResponse.md)
 - [RemoveHouseholdMember200Response](docs/RemoveHouseholdMember200Response.md)
 - [RemoveHouseholdMember200ResponseData](docs/RemoveHouseholdMember200ResponseData.md)
 - [RemoveHouseholdMemberResponse](docs/RemoveHouseholdMemberResponse.md)
 - [RequestRefresh503Response](docs/RequestRefresh503Response.md)
 - [ResetBudget200Response](docs/ResetBudget200Response.md)
 - [ResetBudget200ResponseData](docs/ResetBudget200ResponseData.md)
 - [ResetBudgetRequest](docs/ResetBudgetRequest.md)
 - [ResetBudgetResponse](docs/ResetBudgetResponse.md)
 - [ResumeSubscription200Response](docs/ResumeSubscription200Response.md)
 - [ResumeSubscription200ResponseData](docs/ResumeSubscription200ResponseData.md)
 - [ResumeSubscriptionResponse](docs/ResumeSubscriptionResponse.md)
 - [ReviewSummaryByUserResponse](docs/ReviewSummaryByUserResponse.md)
 - [ReviewSummaryByUserRow](docs/ReviewSummaryByUserRow.md)
 - [SavingsRateMonth](docs/SavingsRateMonth.md)
 - [SavingsRateReport](docs/SavingsRateReport.md)
 - [SavingsRateTrendPoint](docs/SavingsRateTrendPoint.md)
 - [SearchMerchants200Response](docs/SearchMerchants200Response.md)
 - [SearchMerchants200ResponseData](docs/SearchMerchants200ResponseData.md)
 - [SearchMerchantsResponse](docs/SearchMerchantsResponse.md)
 - [SearchSecurities200Response](docs/SearchSecurities200Response.md)
 - [SearchSecurities200ResponseData](docs/SearchSecurities200ResponseData.md)
 - [SearchSecuritiesResponse](docs/SearchSecuritiesResponse.md)
 - [Security](docs/Security.md)
 - [SecurityDetails](docs/SecurityDetails.md)
 - [SecurityDividend](docs/SecurityDividend.md)
 - [SecurityHistoricalPerformanceResponse](docs/SecurityHistoricalPerformanceResponse.md)
 - [SecurityHistoricalPoint](docs/SecurityHistoricalPoint.md)
 - [SecurityHistoricalSummary](docs/SecurityHistoricalSummary.md)
 - [SetBudgetAmount200Response](docs/SetBudgetAmount200Response.md)
 - [SetBudgetAmount200ResponseData](docs/SetBudgetAmount200ResponseData.md)
 - [SetBudgetAmountRequest](docs/SetBudgetAmountRequest.md)
 - [SetBudgetAmountResponse](docs/SetBudgetAmountResponse.md)
 - [SetChannelNotificationPrefsRequest](docs/SetChannelNotificationPrefsRequest.md)
 - [SetChannelNotificationPrefsResponse](docs/SetChannelNotificationPrefsResponse.md)
 - [SetCurrency200Response](docs/SetCurrency200Response.md)
 - [SetCurrency200ResponseData](docs/SetCurrency200ResponseData.md)
 - [SetCurrencyRequest](docs/SetCurrencyRequest.md)
 - [SetCurrencyResponse](docs/SetCurrencyResponse.md)
 - [SetEmailNotificationPrefsRequest](docs/SetEmailNotificationPrefsRequest.md)
 - [SetFiscalYear200Response](docs/SetFiscalYear200Response.md)
 - [SetFiscalYear200ResponseData](docs/SetFiscalYear200ResponseData.md)
 - [SetFiscalYearRequest](docs/SetFiscalYearRequest.md)
 - [SetFiscalYearResponse](docs/SetFiscalYearResponse.md)
 - [SetGoalBudgetAmountRequest](docs/SetGoalBudgetAmountRequest.md)
 - [SetGoalBudgetAmountResponse](docs/SetGoalBudgetAmountResponse.md)
 - [SetMerchantLogoRequest](docs/SetMerchantLogoRequest.md)
 - [SetMerchantLogoResponse](docs/SetMerchantLogoResponse.md)
 - [SetTagsRequest](docs/SetTagsRequest.md)
 - [SetTransactionTags200Response](docs/SetTransactionTags200Response.md)
 - [SetTransactionTags200ResponseData](docs/SetTransactionTags200ResponseData.md)
 - [SetTransactionTagsRequest](docs/SetTransactionTagsRequest.md)
 - [SetTransactionTagsResponse](docs/SetTransactionTagsResponse.md)
 - [SkipRecurringInstance200Response](docs/SkipRecurringInstance200Response.md)
 - [SkipRecurringInstance200ResponseData](docs/SkipRecurringInstance200ResponseData.md)
 - [SkipRecurringInstanceRequest](docs/SkipRecurringInstanceRequest.md)
 - [SkipRecurringInstanceResponse](docs/SkipRecurringInstanceResponse.md)
 - [SkippedRecurringInstance](docs/SkippedRecurringInstance.md)
 - [SnapshotByAccountType](docs/SnapshotByAccountType.md)
 - [SpendFromGoal200Response](docs/SpendFromGoal200Response.md)
 - [SpendFromGoal200ResponseData](docs/SpendFromGoal200ResponseData.md)
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
 - [StartDownloadTransactions200Response](docs/StartDownloadTransactions200Response.md)
 - [StartDownloadTransactions200ResponseData](docs/StartDownloadTransactions200ResponseData.md)
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
 - [UpdateAccount200Response](docs/UpdateAccount200Response.md)
 - [UpdateAccount200ResponseData](docs/UpdateAccount200ResponseData.md)
 - [UpdateAccountGroupOrder200Response](docs/UpdateAccountGroupOrder200Response.md)
 - [UpdateAccountGroupOrder200ResponseData](docs/UpdateAccountGroupOrder200ResponseData.md)
 - [UpdateAccountGroupOrderRequest](docs/UpdateAccountGroupOrderRequest.md)
 - [UpdateAccountGroupOrderResponse](docs/UpdateAccountGroupOrderResponse.md)
 - [UpdateAccountRequest](docs/UpdateAccountRequest.md)
 - [UpdateAccountResponse](docs/UpdateAccountResponse.md)
 - [UpdateAppearanceRequest](docs/UpdateAppearanceRequest.md)
 - [UpdateAppearanceResponse](docs/UpdateAppearanceResponse.md)
 - [UpdateBudgetSettings200Response](docs/UpdateBudgetSettings200Response.md)
 - [UpdateBudgetSettings200ResponseData](docs/UpdateBudgetSettings200ResponseData.md)
 - [UpdateBudgetSettingsRequest](docs/UpdateBudgetSettingsRequest.md)
 - [UpdateCategoryGroupBudgetVariability200Response](docs/UpdateCategoryGroupBudgetVariability200Response.md)
 - [UpdateCategoryGroupBudgetVariability200ResponseData](docs/UpdateCategoryGroupBudgetVariability200ResponseData.md)
 - [UpdateCategoryGroupBudgetVariabilityRequest](docs/UpdateCategoryGroupBudgetVariabilityRequest.md)
 - [UpdateCategoryGroupBudgetVariabilityResponse](docs/UpdateCategoryGroupBudgetVariabilityResponse.md)
 - [UpdateCategoryGroupRequest](docs/UpdateCategoryGroupRequest.md)
 - [UpdateCategoryGroupResponse](docs/UpdateCategoryGroupResponse.md)
 - [UpdateCookiePreferencesRequest](docs/UpdateCookiePreferencesRequest.md)
 - [UpdateCookiePreferencesResponse](docs/UpdateCookiePreferencesResponse.md)
 - [UpdateFlexRolloverSettings200Response](docs/UpdateFlexRolloverSettings200Response.md)
 - [UpdateFlexRolloverSettings200ResponseData](docs/UpdateFlexRolloverSettings200ResponseData.md)
 - [UpdateFlexRolloverSettingsRequest](docs/UpdateFlexRolloverSettingsRequest.md)
 - [UpdateFlexRolloverSettingsResponse](docs/UpdateFlexRolloverSettingsResponse.md)
 - [UpdateFlexibleBudgetRequest](docs/UpdateFlexibleBudgetRequest.md)
 - [UpdateFlexibleBudgetResponse](docs/UpdateFlexibleBudgetResponse.md)
 - [UpdateGoalRequest](docs/UpdateGoalRequest.md)
 - [UpdateGoalsPriorities200Response](docs/UpdateGoalsPriorities200Response.md)
 - [UpdateGoalsPriorities200ResponseData](docs/UpdateGoalsPriorities200ResponseData.md)
 - [UpdateGoalsPrioritiesRequest](docs/UpdateGoalsPrioritiesRequest.md)
 - [UpdateGoalsPrioritiesResponse](docs/UpdateGoalsPrioritiesResponse.md)
 - [UpdateHolding200Response](docs/UpdateHolding200Response.md)
 - [UpdateHolding200ResponseData](docs/UpdateHolding200ResponseData.md)
 - [UpdateHoldingRequest](docs/UpdateHoldingRequest.md)
 - [UpdateHoldingResponse](docs/UpdateHoldingResponse.md)
 - [UpdateHouseholdName200Response](docs/UpdateHouseholdName200Response.md)
 - [UpdateHouseholdName200ResponseData](docs/UpdateHouseholdName200ResponseData.md)
 - [UpdateHouseholdNameRequest](docs/UpdateHouseholdNameRequest.md)
 - [UpdateHouseholdNameResponse](docs/UpdateHouseholdNameResponse.md)
 - [UpdateHouseholdPreferences200Response](docs/UpdateHouseholdPreferences200Response.md)
 - [UpdateHouseholdPreferences200ResponseData](docs/UpdateHouseholdPreferences200ResponseData.md)
 - [UpdateHouseholdPreferencesRequest](docs/UpdateHouseholdPreferencesRequest.md)
 - [UpdateMe200Response](docs/UpdateMe200Response.md)
 - [UpdateMe200ResponseData](docs/UpdateMe200ResponseData.md)
 - [UpdateMeRequest](docs/UpdateMeRequest.md)
 - [UpdateMerchantRecurrence200Response](docs/UpdateMerchantRecurrence200Response.md)
 - [UpdateMerchantRecurrence200ResponseData](docs/UpdateMerchantRecurrence200ResponseData.md)
 - [UpdateMerchantRecurrenceRequest](docs/UpdateMerchantRecurrenceRequest.md)
 - [UpdateMerchantRecurrenceResponse](docs/UpdateMerchantRecurrenceResponse.md)
 - [UpdateNotificationPreferences200Response](docs/UpdateNotificationPreferences200Response.md)
 - [UpdateNotificationPreferences200ResponseData](docs/UpdateNotificationPreferences200ResponseData.md)
 - [UpdateNotificationPreferencesRequest](docs/UpdateNotificationPreferencesRequest.md)
 - [UpdateNotificationPreferencesResponse](docs/UpdateNotificationPreferencesResponse.md)
 - [UpdatePaycheckEmployerRequest](docs/UpdatePaycheckEmployerRequest.md)
 - [UpdatePaycheckEmployerResponse](docs/UpdatePaycheckEmployerResponse.md)
 - [UpdatePaycheckRequest](docs/UpdatePaycheckRequest.md)
 - [UpdatePaycheckResponse](docs/UpdatePaycheckResponse.md)
 - [UpdateTaxLotRequest](docs/UpdateTaxLotRequest.md)
 - [UpdateTaxLotResponse](docs/UpdateTaxLotResponse.md)
 - [UpdateTransaction200Response](docs/UpdateTransaction200Response.md)
 - [UpdateTransaction200ResponseData](docs/UpdateTransaction200ResponseData.md)
 - [UpdateTransactionRequest](docs/UpdateTransactionRequest.md)
 - [UpdateTransactionResponse](docs/UpdateTransactionResponse.md)
 - [UpdateTransactionRule200Response](docs/UpdateTransactionRule200Response.md)
 - [UpdateTransactionRule200ResponseData](docs/UpdateTransactionRule200ResponseData.md)
 - [UpdateTransactionRuleResponse](docs/UpdateTransactionRuleResponse.md)
 - [UpdateTransactionSplits200Response](docs/UpdateTransactionSplits200Response.md)
 - [UpdateTransactionSplits200ResponseData](docs/UpdateTransactionSplits200ResponseData.md)
 - [UpdateTransactionSplitsRequest](docs/UpdateTransactionSplitsRequest.md)
 - [UpdateTransactionSplitsResponse](docs/UpdateTransactionSplitsResponse.md)
 - [UploadAccountBalanceHistory202Response](docs/UploadAccountBalanceHistory202Response.md)
 - [UploadAccountBalanceHistory202ResponseData](docs/UploadAccountBalanceHistory202ResponseData.md)
 - [UploadTransactionAttachment200Response](docs/UploadTransactionAttachment200Response.md)
 - [UploadTransactionAttachment200ResponseData](docs/UploadTransactionAttachment200ResponseData.md)
 - [UploadTransactionAttachmentResponse](docs/UploadTransactionAttachmentResponse.md)
 - [User](docs/User.md)
 - [UserProfileFlags](docs/UserProfileFlags.md)
 - [WebScreenAggregateRequest](docs/WebScreenAggregateRequest.md)
 - [WebScreenAggregateResponse](docs/WebScreenAggregateResponse.md)
 - [WeeklyRecap](docs/WeeklyRecap.md)
 - [WeeklyRecapCard](docs/WeeklyRecapCard.md)
 - [WithdrawFromGoal200Response](docs/WithdrawFromGoal200Response.md)
 - [WithdrawFromGoal200ResponseData](docs/WithdrawFromGoal200ResponseData.md)
 - [WithdrawFromGoalRequest](docs/WithdrawFromGoalRequest.md)
 - [YoyPoint](docs/YoyPoint.md)


## Documentation For Authorization

 All endpoints do not require authorization.

