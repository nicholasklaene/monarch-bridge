# SystemApi

All URIs are relative to **

Method | HTTP request | Description
------------- | ------------- | -------------
[**clearAllNotifications**](SystemApi.md#clearAllNotifications) | **POST** /v1/notifications/clear-all | Clear all notifications
[**dismissNotification**](SystemApi.md#dismissNotification) | **POST** /v1/notifications/{id}/dismiss | Dismiss one notification
[**getAppVersion**](SystemApi.md#getAppVersion) | **GET** /v1/app/version | App version info
[**getAuthStatus**](SystemApi.md#getAuthStatus) | **GET** /v1/auth/status | Whether a Monarch session is currently loaded
[**getBetaFeatures**](SystemApi.md#getBetaFeatures) | **GET** /v1/app/beta-features | Beta features the account can opt into
[**getCalendarEvents**](SystemApi.md#getCalendarEvents) | **GET** /v1/calendar/events | Calendar events
[**getCashflowReport**](SystemApi.md#getCashflowReport) | **GET** /v1/reports/cashflow | Cashflow report
[**getCategoryReport**](SystemApi.md#getCategoryReport) | **GET** /v1/reports/category | Per-category historical report
[**getCreditHistory**](SystemApi.md#getCreditHistory) | **GET** /v1/credit/history | Credit-score snapshots over time
[**getEntitlements**](SystemApi.md#getEntitlements) | **GET** /v1/entitlements | Subscription entitlements
[**getExpenseByCategory**](SystemApi.md#getExpenseByCategory) | **GET** /v1/reports/expense-by-category | Expense breakdown grouped by category
[**getExpenseByMerchant**](SystemApi.md#getExpenseByMerchant) | **GET** /v1/reports/expense-by-merchant | Expense breakdown grouped by merchant
[**getExpenseByTag**](SystemApi.md#getExpenseByTag) | **GET** /v1/reports/expense-by-tag | Expense breakdown grouped by tag
[**getFeatureFlags**](SystemApi.md#getFeatureFlags) | **GET** /v1/app/feature-flags | Feature flags for this account
[**getFinancialInsight**](SystemApi.md#getFinancialInsight) | **GET** /v1/insights/{id} | Single AI savings insight
[**getHealth**](SystemApi.md#getHealth) | **GET** /healthz | Liveness probe with auth-presence hint
[**getIncomeReport**](SystemApi.md#getIncomeReport) | **GET** /v1/reports/income | Income report
[**getIncomeVsExpenseYoy**](SystemApi.md#getIncomeVsExpenseYoy) | **GET** /v1/reports/income-vs-expense-yoy | Income vs. expense year-over-year
[**getIntegrationStatus**](SystemApi.md#getIntegrationStatus) | **GET** /v1/integrations/status | Per-credential integration health
[**getLatestInsightRun**](SystemApi.md#getLatestInsightRun) | **GET** /v1/insights/latest-run | Latest financial-insight run + insights count
[**getLatestRefreshOperation**](SystemApi.md#getLatestRefreshOperation) | **GET** /v1/refresh/latest | Latest force-refresh operation
[**getLookup**](SystemApi.md#getLookup) | **GET** /v1/lookup | Cross-entity fuzzy lookup
[**getMonthlyReportSummary**](SystemApi.md#getMonthlyReportSummary) | **GET** /v1/reports/monthly-summary | Monthly report summary
[**getNetWorthReport**](SystemApi.md#getNetWorthReport) | **GET** /v1/reports/net-worth | Net-worth report
[**getNotifications**](SystemApi.md#getNotifications) | **GET** /v1/notifications | Notification center (activity events)
[**getPlatformConfig**](SystemApi.md#getPlatformConfig) | **GET** /v1/app/platform-config | Platform configuration
[**getPlusTierAccess**](SystemApi.md#getPlusTierAccess) | **GET** /v1/plus-tier | Plus-tier access info
[**getRefreshStatus**](SystemApi.md#getRefreshStatus) | **GET** /v1/refresh/status | Poll per-account sync status
[**getSavingsRateReport**](SystemApi.md#getSavingsRateReport) | **GET** /v1/reports/savings-rate | Savings-rate report
[**getSavingsRateTrends**](SystemApi.md#getSavingsRateTrends) | **GET** /v1/reports/savings-rate-trends | Savings-rate trend series
[**getSpendingReport**](SystemApi.md#getSpendingReport) | **GET** /v1/reports/spending | Spending report
[**getSubscription**](SystemApi.md#getSubscription) | **GET** /v1/subscription | Monarch subscription tier + payment source
[**getSubscriptionDetails**](SystemApi.md#getSubscriptionDetails) | **GET** /v1/subscription/details | Detailed subscription info
[**getSubscriptionInvoices**](SystemApi.md#getSubscriptionInvoices) | **GET** /v1/subscription/invoices | Subscription invoice history
[**getSubscriptionReceipts**](SystemApi.md#getSubscriptionReceipts) | **GET** /v1/subscription/receipts | Subscription payment receipts
[**getTagReport**](SystemApi.md#getTagReport) | **GET** /v1/reports/tag | Per-tag historical report
[**getWeeklyRecap**](SystemApi.md#getWeeklyRecap) | **GET** /v1/recap/weekly | Weekly recap
[**getZestimate**](SystemApi.md#getZestimate) | **POST** /v1/zillow/zestimate | Zillow Zestimate lookup
[**initiatePasswordChange**](SystemApi.md#initiatePasswordChange) | **POST** /v1/me/password-change/initiate | Initiate password change
[**listFinancialInsights**](SystemApi.md#listFinancialInsights) | **GET** /v1/insights | List AI savings insights
[**markAllNotificationsAsRead**](SystemApi.md#markAllNotificationsAsRead) | **POST** /v1/notifications/read-all | Mark all notifications as read
[**markNotificationAsRead**](SystemApi.md#markNotificationAsRead) | **POST** /v1/notifications/{id}/read | Mark one notification as read
[**pauseSubscription**](SystemApi.md#pauseSubscription) | **POST** /v1/subscription/pause | Pause the subscription
[**previewSubscriptionPlanChange**](SystemApi.md#previewSubscriptionPlanChange) | **POST** /v1/subscription/plan-preview | Preview a plan-change charge
[**refreshAuth**](SystemApi.md#refreshAuth) | **POST** /v1/auth/refresh | Reload session JSON from disk
[**requestRefresh**](SystemApi.md#requestRefresh) | **POST** /v1/refresh | Force Monarch to re-poll Plaid (async)
[**requestRefreshAndWait**](SystemApi.md#requestRefreshAndWait) | **POST** /v1/refresh/wait | Force Monarch to re-poll Plaid and wait until every account has finished
[**resumeSubscription**](SystemApi.md#resumeSubscription) | **POST** /v1/subscription/resume | Resume a paused subscription



## clearAllNotifications

Clear all notifications

Bulk-dismiss every activity event in the bell. Returns a simple
success boolean.

### Example

```bash
monarch-api clearAllNotifications
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**MarkTransactionStreamAsNotRecurring200Response**](MarkTransactionStreamAsNotRecurring200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## dismissNotification

Dismiss one notification

Permanently dismiss a single activity event. Distinct from
'read' - dismissed events are hidden entirely (will not reappear
even if unread).

### Example

```bash
monarch-api dismissNotification id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch activity-event id. | [default to null]

### Return type

[**DismissNotification200Response**](DismissNotification200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getAppVersion

App version info

Current build version, the minimum supported version (older
clients are blocked), and the recommended version. Use to drive
\"please update your app\" prompts.

### Example

```bash
monarch-api getAppVersion
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**GetAppVersion200Response**](GetAppVersion200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getAuthStatus

Whether a Monarch session is currently loaded

Reports whether the proxy has a valid Monarch session token in memory.
Use as a precondition before calling any data endpoint: a missing
session yields 503 on every other route.

No session required to call this endpoint (unlike most others). The
response includes a coarse loaded/not-loaded flag plus the session's
expiry hint. If the session is missing or expired, run the bootstrap
CLI to re-auth then call 'POST /v1/auth/refresh' to swap in the new
token.

### Example

```bash
monarch-api getAuthStatus
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**GetAuthStatus200Response**](GetAuthStatus200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getBetaFeatures

Beta features the account can opt into

Beta program list. Each entry has a name, short description, and
whether the household is currently enrolled.

### Example

```bash
monarch-api getBetaFeatures
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**GetBetaFeatures200Response**](GetBetaFeatures200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getCalendarEvents

Calendar events

Bills, recurring transactions, and paychecks projected onto a
calendar shape for a date window. One entry per event with date,
type ('bill', 'recurring', 'paycheck'), title, amount, and the id
of the underlying source record.

### Example

```bash
monarch-api getCalendarEvents  start=value  end=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **string** | Lower bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]
 **end** | **string** | Upper bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]

### Return type

[**GetCalendarEvents200Response**](GetCalendarEvents200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getCashflowReport

Cashflow report

Full cashflow report: total income / expense / net for the window
plus a per-month series. Distinct from 'GET /v1/cashflow' (a lighter
summary view); this is the per-month chart shape the web Reports tab
fires.

### Example

```bash
monarch-api getCashflowReport  start=value  end=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **string** | Lower bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]
 **end** | **string** | Upper bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]

### Return type

[**GetCashflowReport200Response**](GetCashflowReport200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getCategoryReport

Per-category historical report

Per-month sum series for one category across a window. Backs the
\"click category → drill down\" view in the web Reports tab. Returns
'totalAmount' and 'averagePerMonth' for convenience.

### Example

```bash
monarch-api getCategoryReport  categoryId=value  start=value  end=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **categoryId** | **string** | Monarch category id. | [default to null]
 **start** | **string** | Lower bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]
 **end** | **string** | Upper bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]

### Return type

[**GetCategoryReport200Response**](GetCategoryReport200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getCreditHistory

Credit-score snapshots over time

Returns the user's credit-score history series from Monarch's
Spinwheel integration. Each entry has a date, score, and the
reporting bureau (typically TransUnion).

Use for credit-trend charts or to surface the most recent score.
Empty list when Spinwheel is not enabled on the user's account
(no error, just zero entries). Premium-tier feature on Monarch's
side - tier check via 'GET /v1/subscription' if needed.

### Example

```bash
monarch-api getCreditHistory
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**GetCreditHistory200Response**](GetCreditHistory200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getEntitlements

Subscription entitlements

Feature entitlements granted by the active subscription. Returns the raw
entitlement-key array Monarch ships, plus the subscription id for
cross-reference with '/v1/subscription'. Used to gate Plus-only flows
on the client side without an extra round-trip.

### Example

```bash
monarch-api getEntitlements
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**GetEntitlements200Response**](GetEntitlements200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getExpenseByCategory

Expense breakdown grouped by category

Expense rollup with one row per category over the given window.
Drives the \"Top categories\" report card and the legacy CSV export.

### Example

```bash
monarch-api getExpenseByCategory  start=value  end=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **string** |  | [optional] [default to null]
 **end** | **string** |  | [optional] [default to null]

### Return type

[**GetExpenseByCategory200Response**](GetExpenseByCategory200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getExpenseByMerchant

Expense breakdown grouped by merchant

Expense rollup with one row per merchant over the given window.

### Example

```bash
monarch-api getExpenseByMerchant  start=value  end=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **string** |  | [optional] [default to null]
 **end** | **string** |  | [optional] [default to null]

### Return type

[**GetExpenseByMerchant200Response**](GetExpenseByMerchant200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getExpenseByTag

Expense breakdown grouped by tag

Expense rollup with one row per transaction tag over the given
window. Only transactions that carry at least one tag contribute.

### Example

```bash
monarch-api getExpenseByTag  start=value  end=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **string** |  | [optional] [default to null]
 **end** | **string** |  | [optional] [default to null]

### Return type

[**GetExpenseByTag200Response**](GetExpenseByTag200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getFeatureFlags

Feature flags for this account

The feature-flag matrix this account currently sees. Each entry
carries the flag name, on/off, and an optional variant string for
A/B experiments.

### Example

```bash
monarch-api getFeatureFlags
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**GetFeatureFlags200Response**](GetFeatureFlags200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getFinancialInsight

Single AI savings insight

Detail view of one insight, including the optional 'playbook.diySteps'
(do-it-yourself walkthrough text) and 'paymentAccount' label when relevant.

### Example

```bash
monarch-api getFinancialInsight id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch financial insight id. | [default to null]

### Return type

[**GetFinancialInsight200Response**](GetFinancialInsight200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getHealth

Liveness probe with auth-presence hint

Cheap liveness check for the proxy itself. Always returns 200 if the
HTTP server is up. Body includes a 'monarchAuthLoaded' flag so callers
can distinguish \"service alive but unauthenticated\" from \"service
alive and ready\". No session required.

Use for uptime monitoring, LaunchAgent readiness checks, or as a
first-call probe before calling any data endpoint. For richer auth
detail use 'GET /v1/auth/status'.

### Example

```bash
monarch-api getHealth
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**GetHealth200Response**](GetHealth200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getIncomeReport

Income report

Income breakdown for a date window: total income, average monthly
income, and per-source split. Backs the web Reports page Income tab.

### Example

```bash
monarch-api getIncomeReport  start=value  end=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **string** | Lower bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]
 **end** | **string** | Upper bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]

### Return type

[**GetIncomeReport200Response**](GetIncomeReport200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getIncomeVsExpenseYoy

Income vs. expense year-over-year

Compares income vs. expense across years. Each point carries a
period label (typically a month) plus the income and expense
totals for that period.

### Example

```bash
monarch-api getIncomeVsExpenseYoy  years=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **years** | **integer** | How many years of history to include; defaults to 2. | [optional] [default to 2]

### Return type

[**GetIncomeVsExpenseYoy200Response**](GetIncomeVsExpenseYoy200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getIntegrationStatus

Per-credential integration health

Per-credential health for each linked provider (Plaid / MX /
Finicity / manual). The web app's \"Connection issues\" banner walks
this list and surfaces any row with 'needsReauth=true' or a non-null
'errorCode'.

'status' values: 'connected', 'syncing', 'error', 'disconnected'.
'provider' values: 'plaid', 'mx', 'finicity', 'manual'.

### Example

```bash
monarch-api getIntegrationStatus
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**GetIntegrationStatus200Response**](GetIntegrationStatus200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getLatestInsightRun

Latest financial-insight run + insights count

Returns just the latest run metadata (id, status, errorMessage,
insightsGeneratedCount) and the current total insights count.
Faster than '/v1/insights' when all you need is freshness.

### Example

```bash
monarch-api getLatestInsightRun
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**GetLatestInsightRun200Response**](GetLatestInsightRun200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getLatestRefreshOperation

Latest force-refresh operation

Single global force-refresh request from this user (id + state). Useful as a
lightweight alternative to '/v1/refresh/status' when you only need to know
\"is a refresh currently running\" rather than per-account breakdown.

States observed in the wild: 'IN_PROGRESS', 'COMPLETED', 'FAILED'. May return
null when the user has never triggered a force refresh.

### Example

```bash
monarch-api getLatestRefreshOperation
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**GetLatestRefreshOperation200Response**](GetLatestRefreshOperation200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getLookup

Cross-entity fuzzy lookup

One-shot semantic search across accounts + categories + tags + merchants.
Backs Monarch's web command palette. Each result is tagged with its
'type' so the caller can route to the right resource.

Cuts the typical \"search accounts then categories then tags then merchants\"
round-trip dance to one. Use from AI assistants that need to resolve a
free-form user reference (\"my Chase card\", \"the Coffee category\") to a
Monarch entity id.

### Example

```bash
monarch-api getLookup  q=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **q** | **string** | Free-text query - matches across all entity types Monarch indexes for the palette. | [default to null]

### Return type

[**GetLookup200Response**](GetLookup200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getMonthlyReportSummary

Monthly report summary

One-month summary bundle Monarch sends to the monthly-recap email
and the web monthly-summary widget. Single-row aggregate covering
net income, total spending, total income, savings rate, and the top
merchant / category callouts.

### Example

```bash
monarch-api getMonthlyReportSummary  month=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **month** | **string** | First-of-month date, e.g. '2026-05-01'. | [default to null]

### Return type

[**GetMonthlyReportSummary200Response**](GetMonthlyReportSummary200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getNetWorthReport

Net-worth report

Net-worth chart series for the requested window plus starting and
current totals and absolute / percent change. Backs the web Reports
page Net Worth tab.

### Example

```bash
monarch-api getNetWorthReport  start=value  end=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **string** | Lower bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]
 **end** | **string** | Upper bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]

### Return type

[**GetNetWorthReport200Response**](GetNetWorthReport200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getNotifications

Notification center (activity events)

Paginated activity-event stream backing the in-app bell. Each event
has a title/body, an action link ('action', 'actionLabel',
'secondaryUrl'), a priority bucket, read state ('readAt'), and a
pinned/dismissed flag pair. Returns 'pageInfo.endCursor' for the next
page via '?afterCursor='.

### Example

```bash
monarch-api getNotifications  first=value  afterCursor=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **first** | **integer** | Max number of events to return. | [optional] [default to 20]
 **afterCursor** | **string** | Pagination cursor from previous response's 'pageInfo.endCursor'. | [optional] [default to null]

### Return type

[**GetNotifications200Response**](GetNotifications200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getPlatformConfig

Platform configuration

Per-platform config blob: API base URL, config version, plus
arbitrary additional settings the client honors. Used by the web
app on boot to hydrate its environment.

### Example

```bash
monarch-api getPlatformConfig
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**GetPlatformConfig200Response**](GetPlatformConfig200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getPlusTierAccess

Plus-tier access info

Subscription entitlements plus Plus-trial window endpoints
('plusTrialEndsAt', 'canceledPlusTrialAt'). Use to gate \"you are in
your trial\" banners and Plus-feature promotional copy.

### Example

```bash
monarch-api getPlusTierAccess
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**GetPlusTierAccess200Response**](GetPlusTierAccess200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getRefreshStatus

Poll per-account sync status

Snapshot of Monarch's per-account sync state. Use after firing
'POST /v1/refresh' to know when the re-poll is done: keep calling until
'data.allComplete' is true (typically 5-60s depending on institution).

Returns each account's 'hasSyncInProgress' flag plus an aggregate
'allComplete' rollup. For the synchronous \"fire-and-wait\" version
that blocks until done, use 'POST /v1/refresh/wait' instead.

### Example

```bash
monarch-api getRefreshStatus
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**GetRefreshStatus200Response**](GetRefreshStatus200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getSavingsRateReport

Savings-rate report

Month-over-month savings rate report. Rates are fractions
('0.42' = 42%). 'overallSavingsRate' is the window aggregate;
'monthlyRates' is the per-month series.

### Example

```bash
monarch-api getSavingsRateReport  start=value  end=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **string** | Lower bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]
 **end** | **string** | Upper bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]

### Return type

[**GetSavingsRateReport200Response**](GetSavingsRateReport200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getSavingsRateTrends

Savings-rate trend series

Savings rate (income minus expense divided by income) plotted per
period. Each point carries the period label, the savings rate, and
the underlying income and expense totals.

### Example

```bash
monarch-api getSavingsRateTrends  months=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **months** | **integer** | How many months of history; defaults to 12. | [optional] [default to 12]

### Return type

[**GetSavingsRateTrends200Response**](GetSavingsRateTrends200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getSpendingReport

Spending report

High-level spending vs. budget summary for a date window with the
top-N category breakdown. Backs the web Reports page Spending tab.

### Example

```bash
monarch-api getSpendingReport  start=value  end=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **string** | Lower bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]
 **end** | **string** | Upper bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]

### Return type

[**GetSpendingReport200Response**](GetSpendingReport200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getSubscription

Monarch subscription tier + payment source

Returns the household's Monarch subscription details: current plan
(Plus, Premium, etc.), trial state, renewal date, and the payment
source (Stripe / Apple App Store / Play Store).

Useful for checking entitlement before calling tier-gated endpoints
(some richer reporting features fall back to empty responses on free
tier) or for surfacing renewal warnings to the user.

### Example

```bash
monarch-api getSubscription
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**GetSubscription200Response**](GetSubscription200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getSubscriptionDetails

Detailed subscription info

Full subscription detail beyond 'GET /v1/subscription': tier, renewal
date, billing frequency, amount, payment method, trial dates.

### Example

```bash
monarch-api getSubscriptionDetails
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**GetSubscriptionDetails200Response**](GetSubscriptionDetails200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getSubscriptionInvoices

Subscription invoice history

Billing-history rows shown on the Settings → Billing page. Each row
is one charge (monthly / annual / proration) with status, amount,
PDF receipt URL, and the period it covered.

'status' values seen in production: 'paid', 'pending', 'failed',
'refunded'.

### Example

```bash
monarch-api getSubscriptionInvoices
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**GetSubscriptionInvoices200Response**](GetSubscriptionInvoices200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getSubscriptionReceipts

Subscription payment receipts

All payment receipts for the current subscription, with download
URLs. Used at tax time for proof of expense.

### Example

```bash
monarch-api getSubscriptionReceipts
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**GetSubscriptionReceipts200Response**](GetSubscriptionReceipts200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getTagReport

Per-tag historical report

Per-month series for one transaction tag across a window. Backs the
\"view tag\" drill-down in the web Reports tab. Each month carries both
the sum amount and the transaction count, so callers can render either
a spend chart or a frequency chart from one response.

### Example

```bash
monarch-api getTagReport  tagId=value  start=value  end=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tagId** | **string** | Monarch tag id. | [default to null]
 **start** | **string** | Lower bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]
 **end** | **string** | Upper bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]

### Return type

[**GetTagReport200Response**](GetTagReport200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getWeeklyRecap

Weekly recap

AI-generated narrative recap for one week. Monarch backfills this on a schedule.
Pick 'start' = Monday, 'end' = Sunday of the target week. Returns 'null' recap if
Monarch has not generated one for that window yet.

Includes a top-level 'summary' plus per-module 'cards' (cashflow card, biggest
spend, savings progress, etc.) with both rich-block JSON and markdown variants.

### Example

```bash
monarch-api getWeeklyRecap  start=value  end=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **string** | Week start (inclusive), 'YYYY-MM-DD'. Typically a Monday. | [default to null]
 **end** | **string** | Week end (inclusive), 'YYYY-MM-DD'. Typically a Sunday. | [default to null]

### Return type

[**GetWeeklyRecap200Response**](GetWeeklyRecap200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getZestimate

Zillow Zestimate lookup

Resolve a free-form street address to one or more Zillow 'Zestimate'
rows (Zillow property id + parsed address + dollar estimate). Used by
the real-estate account creation flow to pre-fill home value.

Returns an empty array if Zillow has no match. A free-form address
can return multiple Zestimates when the property has been split or
Zillow has near-duplicate records.

### Example

```bash
monarch-api getZestimate
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **getZestimateRequest** | [**GetZestimateRequest**](GetZestimateRequest.md) |  |

### Return type

[**GetZestimate200Response**](GetZestimate200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## initiatePasswordChange

Initiate password change

Trigger Monarch's password-change flow. No body required. Monarch
emails a reset link to the account's verified email; the response
echoes back the 'requestId' + 'email' for client-side confirmation.

### Example

```bash
monarch-api initiatePasswordChange
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**InitiatePasswordChange200Response**](InitiatePasswordChange200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## listFinancialInsights

List AI savings insights

Monarch's AI-driven money-saving opportunities (subscription audits, bill
negotiation candidates, etc.). Each insight has a savings estimate range,
effort tag, and current annual cost. Filter by status (e.g. 'NEW', 'ACCEPTED').

Also returns an aggregate 'summary' over the window (counts + identified
savings totals) and the 'latestRun' metadata to gauge freshness.

### Example

```bash
monarch-api listFinancialInsights  Specify as:  status=value1 status=value2 status=...  summaryStart=value  summaryEnd=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **status** | [**array[string]**](string.md) | Filter to one or more 'InsightStatusEnum' values. Repeat the param for each. | [optional] [default to null]
 **summaryStart** | **string** | Lower bound for the 'summary' aggregate window. | [optional] [default to null]
 **summaryEnd** | **string** | Upper bound for the 'summary' aggregate window. | [optional] [default to null]

### Return type

[**ListFinancialInsights200Response**](ListFinancialInsights200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## markAllNotificationsAsRead

Mark all notifications as read

Bulk-flip 'readAt' for every activity event in the bell. Echoes back
the first page of events (so the client can refresh state without a
second round-trip).

### Example

```bash
monarch-api markAllNotificationsAsRead  first=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **first** | **integer** | Page size for the echoed event list. | [optional] [default to 20]

### Return type

[**MarkAllNotificationsAsRead200Response**](MarkAllNotificationsAsRead200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## markNotificationAsRead

Mark one notification as read

Flip a single activity event's 'readAt' to now. Used by the bell UI
when an event is opened or clicked. Idempotent.

### Example

```bash
monarch-api markNotificationAsRead id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch activity-event id. | [default to null]

### Return type

[**MarkNotificationAsRead200Response**](MarkNotificationAsRead200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## pauseSubscription

Pause the subscription

Suspends billing without canceling. Provide 'resumeAt' to auto-resume
on a date; omit for indefinite pause. Read-only data access remains
during a pause.

### Example

```bash
monarch-api pauseSubscription
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **pauseSubscriptionRequest** | [**PauseSubscriptionRequest**](PauseSubscriptionRequest.md) |  | [optional]

### Return type

[**PauseSubscription200Response**](PauseSubscription200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## previewSubscriptionPlanChange

Preview a plan-change charge

Computes the prorated charge for switching to 'targetTier' (and
optionally 'billingFrequency'). Does NOT mutate the subscription.
Use to show \"you will be charged USD X today\" before the user confirms.

### Example

```bash
monarch-api previewSubscriptionPlanChange
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **previewSubscriptionPlanChangeRequest** | [**PreviewSubscriptionPlanChangeRequest**](PreviewSubscriptionPlanChangeRequest.md) |  |

### Return type

[**PreviewSubscriptionPlanChange200Response**](PreviewSubscriptionPlanChange200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## refreshAuth

Reload session JSON from disk

Re-reads '~/.config/monarch-bridge/.mm-session.json' and swaps in the new
token without a service restart.

Use after running the bootstrap CLI's re-auth flow ('mb auth login') to
pick up freshly-issued credentials. Cheap call: just hits the local
filesystem and updates an in-memory atomic reference. Returns the
post-reload auth status so the caller knows immediately whether the new
session is loaded.

### Example

```bash
monarch-api refreshAuth
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**GetAuthStatus200Response**](GetAuthStatus200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## requestRefresh

Force Monarch to re-poll Plaid (async)

Triggers Monarch to re-poll Plaid for account balance and
transaction updates. Fire-and-forget: returns 202 immediately
after queueing the refresh.

Without 'accountIds', refreshes **every** linked account. Pass one
or more 'accountIds' to scope. Poll progress with
'GET /v1/refresh/status' until 'data.allComplete' is true (5-60s
typically depending on institution).

For a synchronous version that blocks until done, use
'POST /v1/refresh/wait'.

### Example

```bash
monarch-api requestRefresh  Specify as:  accountIds=value1 accountIds=value2 accountIds=...
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountIds** | [**array[string]**](string.md) | Optional list of Monarch account ids. Omit to refresh all accounts. | [optional] [default to null]

### Return type

(empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## requestRefreshAndWait

Force Monarch to re-poll Plaid and wait until every account has finished

Synchronous version of 'POST /v1/refresh' + polling 'GET /v1/refresh/status'.
Fires the refresh and blocks until every account reports 'hasSyncInProgress: false'
or the timeout elapses (default 60s, max 300s; cap via 'timeoutSeconds').
Without 'accountIds', refreshes **every** linked account. Pass one or more
'accountIds' to scope the refresh.

### Example

```bash
monarch-api requestRefreshAndWait  timeoutSeconds=value  Specify as:  accountIds=value1 accountIds=value2 accountIds=...
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **timeoutSeconds** | **integer** | Max time to poll before returning the last-seen status. | [optional] [default to 60]
 **accountIds** | [**array[string]**](string.md) | Optional list of Monarch account ids. Omit to refresh all accounts. | [optional] [default to null]

### Return type

[**GetRefreshStatus200Response**](GetRefreshStatus200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## resumeSubscription

Resume a paused subscription

Lifts a pause and resumes billing immediately. No-op if the
subscription is already active.

### Example

```bash
monarch-api resumeSubscription
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**ResumeSubscription200Response**](ResumeSubscription200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

