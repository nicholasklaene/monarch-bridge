# SystemApi

All URIs are relative to *http://localhost:9084*

|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|[**clearAllNotifications**](#clearallnotifications) | **POST** /v1/notifications/clear-all | Clear all notifications|
|[**dismissNotification**](#dismissnotification) | **POST** /v1/notifications/{id}/dismiss | Dismiss one notification|
|[**getAppVersion**](#getappversion) | **GET** /v1/app/version | App version info|
|[**getAuthStatus**](#getauthstatus) | **GET** /v1/auth/status | Whether a Monarch session is currently loaded|
|[**getBetaFeatures**](#getbetafeatures) | **GET** /v1/app/beta-features | Beta features the account can opt into|
|[**getCalendarEvents**](#getcalendarevents) | **GET** /v1/calendar/events | Calendar events|
|[**getCashflowReport**](#getcashflowreport) | **GET** /v1/reports/cashflow | Cashflow report|
|[**getCategoryReport**](#getcategoryreport) | **GET** /v1/reports/category | Per-category historical report|
|[**getCreditHistory**](#getcredithistory) | **GET** /v1/credit/history | Credit-score snapshots over time|
|[**getEntitlements**](#getentitlements) | **GET** /v1/entitlements | Subscription entitlements|
|[**getExpenseByCategory**](#getexpensebycategory) | **GET** /v1/reports/expense-by-category | Expense breakdown grouped by category|
|[**getExpenseByMerchant**](#getexpensebymerchant) | **GET** /v1/reports/expense-by-merchant | Expense breakdown grouped by merchant|
|[**getExpenseByTag**](#getexpensebytag) | **GET** /v1/reports/expense-by-tag | Expense breakdown grouped by tag|
|[**getFeatureFlags**](#getfeatureflags) | **GET** /v1/app/feature-flags | Feature flags for this account|
|[**getFinancialInsight**](#getfinancialinsight) | **GET** /v1/insights/{id} | Single AI savings insight|
|[**getHealth**](#gethealth) | **GET** /healthz | Liveness probe with auth-presence hint|
|[**getIncomeReport**](#getincomereport) | **GET** /v1/reports/income | Income report|
|[**getIncomeVsExpenseYoy**](#getincomevsexpenseyoy) | **GET** /v1/reports/income-vs-expense-yoy | Income vs. expense year-over-year|
|[**getIntegrationStatus**](#getintegrationstatus) | **GET** /v1/integrations/status | Per-credential integration health|
|[**getLatestInsightRun**](#getlatestinsightrun) | **GET** /v1/insights/latest-run | Latest financial-insight run + insights count|
|[**getLatestRefreshOperation**](#getlatestrefreshoperation) | **GET** /v1/refresh/latest | Latest force-refresh operation|
|[**getLookup**](#getlookup) | **GET** /v1/lookup | Cross-entity fuzzy lookup|
|[**getMonthlyReportSummary**](#getmonthlyreportsummary) | **GET** /v1/reports/monthly-summary | Monthly report summary|
|[**getNetWorthReport**](#getnetworthreport) | **GET** /v1/reports/net-worth | Net-worth report|
|[**getNotifications**](#getnotifications) | **GET** /v1/notifications | Notification center (activity events)|
|[**getPlatformConfig**](#getplatformconfig) | **GET** /v1/app/platform-config | Platform configuration|
|[**getPlusTierAccess**](#getplustieraccess) | **GET** /v1/plus-tier | Plus-tier access info|
|[**getRefreshStatus**](#getrefreshstatus) | **GET** /v1/refresh/status | Poll per-account sync status|
|[**getSavingsRateReport**](#getsavingsratereport) | **GET** /v1/reports/savings-rate | Savings-rate report|
|[**getSavingsRateTrends**](#getsavingsratetrends) | **GET** /v1/reports/savings-rate-trends | Savings-rate trend series|
|[**getSpendingReport**](#getspendingreport) | **GET** /v1/reports/spending | Spending report|
|[**getSubscription**](#getsubscription) | **GET** /v1/subscription | Monarch subscription tier + payment source|
|[**getSubscriptionDetails**](#getsubscriptiondetails) | **GET** /v1/subscription/details | Detailed subscription info|
|[**getSubscriptionInvoices**](#getsubscriptioninvoices) | **GET** /v1/subscription/invoices | Subscription invoice history|
|[**getSubscriptionReceipts**](#getsubscriptionreceipts) | **GET** /v1/subscription/receipts | Subscription payment receipts|
|[**getTagReport**](#gettagreport) | **GET** /v1/reports/tag | Per-tag historical report|
|[**getWeeklyRecap**](#getweeklyrecap) | **GET** /v1/recap/weekly | Weekly recap|
|[**getZestimate**](#getzestimate) | **POST** /v1/zillow/zestimate | Zillow Zestimate lookup|
|[**initiatePasswordChange**](#initiatepasswordchange) | **POST** /v1/me/password-change/initiate | Initiate password change|
|[**listFinancialInsights**](#listfinancialinsights) | **GET** /v1/insights | List AI savings insights|
|[**markAllNotificationsAsRead**](#markallnotificationsasread) | **POST** /v1/notifications/read-all | Mark all notifications as read|
|[**markNotificationAsRead**](#marknotificationasread) | **POST** /v1/notifications/{id}/read | Mark one notification as read|
|[**pauseSubscription**](#pausesubscription) | **POST** /v1/subscription/pause | Pause the subscription|
|[**previewSubscriptionPlanChange**](#previewsubscriptionplanchange) | **POST** /v1/subscription/plan-preview | Preview a plan-change charge|
|[**refreshAuth**](#refreshauth) | **POST** /v1/auth/refresh | Reload session JSON from disk|
|[**requestRefresh**](#requestrefresh) | **POST** /v1/refresh | Force Monarch to re-poll Plaid (async)|
|[**requestRefreshAndWait**](#requestrefreshandwait) | **POST** /v1/refresh/wait | Force Monarch to re-poll Plaid and wait until every account has finished|
|[**resumeSubscription**](#resumesubscription) | **POST** /v1/subscription/resume | Resume a paused subscription|

# **clearAllNotifications**
> MarkTransactionStreamAsNotRecurringResponse clearAllNotifications()

Bulk-dismiss every activity event in the bell. Returns a simple success boolean. 

### Example

```typescript
import {
    SystemApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SystemApi(configuration);

const { status, data } = await apiInstance.clearAllNotifications();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**MarkTransactionStreamAsNotRecurringResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | True on success. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **dismissNotification**
> DismissNotificationResponse dismissNotification()

Permanently dismiss a single activity event. Distinct from `read` - dismissed events are hidden entirely (will not reappear even if unread). 

### Example

```typescript
import {
    SystemApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SystemApi(configuration);

let id: string; //Monarch activity-event id. (default to undefined)

const { status, data } = await apiInstance.dismissNotification(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch activity-event id. | defaults to undefined|


### Return type

**DismissNotificationResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Updated event id + dismissedAt timestamp. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getAppVersion**
> GetAppVersionResponse getAppVersion()

Current build version, the minimum supported version (older clients are blocked), and the recommended version. Use to drive \"please update your app\" prompts. 

### Example

```typescript
import {
    SystemApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SystemApi(configuration);

const { status, data } = await apiInstance.getAppVersion();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**GetAppVersionResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Version triple plus optional build SHA. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getAuthStatus**
> GetAuthStatusResponse getAuthStatus()

Reports whether the proxy has a valid Monarch session token in memory. Use as a precondition before calling any data endpoint: a missing session yields 503 on every other route.  No session required to call this endpoint (unlike most others). The response includes a coarse loaded/not-loaded flag plus the session\'s expiry hint. If the session is missing or expired, run the bootstrap CLI to re-auth then call `POST /v1/auth/refresh` to swap in the new token. 

### Example

```typescript
import {
    SystemApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SystemApi(configuration);

const { status, data } = await apiInstance.getAuthStatus();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**GetAuthStatusResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Auth status. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getBetaFeatures**
> GetBetaFeaturesResponse getBetaFeatures()

Beta program list. Each entry has a name, short description, and whether the household is currently enrolled. 

### Example

```typescript
import {
    SystemApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SystemApi(configuration);

const { status, data } = await apiInstance.getBetaFeatures();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**GetBetaFeaturesResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Available beta features. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getCalendarEvents**
> GetCalendarEventsResponse getCalendarEvents()

Bills, recurring transactions, and paychecks projected onto a calendar shape for a date window. One entry per event with date, type (`bill`, `recurring`, `paycheck`), title, amount, and the id of the underlying source record. 

### Example

```typescript
import {
    SystemApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SystemApi(configuration);

let start: string; //Lower bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)
let end: string; //Upper bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)

const { status, data } = await apiInstance.getCalendarEvents(
    start,
    end
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **start** | [**string**] | Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|
| **end** | [**string**] | Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|


### Return type

**GetCalendarEventsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Calendar events. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getCashflowReport**
> GetCashflowReportResponse getCashflowReport()

Full cashflow report: total income / expense / net for the window plus a per-month series. Distinct from `GET /v1/cashflow` (a lighter summary view); this is the per-month chart shape the web Reports tab fires. 

### Example

```typescript
import {
    SystemApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SystemApi(configuration);

let start: string; //Lower bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)
let end: string; //Upper bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)

const { status, data } = await apiInstance.getCashflowReport(
    start,
    end
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **start** | [**string**] | Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|
| **end** | [**string**] | Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|


### Return type

**GetCashflowReportResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Per-month cashflow plus totals. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getCategoryReport**
> GetCategoryReportResponse getCategoryReport()

Per-month sum series for one category across a window. Backs the \"click category → drill down\" view in the web Reports tab. Returns `totalAmount` and `averagePerMonth` for convenience. 

### Example

```typescript
import {
    SystemApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SystemApi(configuration);

let categoryId: string; //Monarch category id. (default to undefined)
let start: string; //Lower bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)
let end: string; //Upper bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)

const { status, data } = await apiInstance.getCategoryReport(
    categoryId,
    start,
    end
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **categoryId** | [**string**] | Monarch category id. | defaults to undefined|
| **start** | [**string**] | Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|
| **end** | [**string**] | Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|


### Return type

**GetCategoryReportResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Per-month sums for the category. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getCreditHistory**
> GetCreditHistoryResponse getCreditHistory()

Returns the user\'s credit-score history series from Monarch\'s Spinwheel integration. Each entry has a date, score, and the reporting bureau (typically TransUnion).  Use for credit-trend charts or to surface the most recent score. Empty list when Spinwheel is not enabled on the user\'s account (no error, just zero entries). Premium-tier feature on Monarch\'s side - tier check via `GET /v1/subscription` if needed. 

### Example

```typescript
import {
    SystemApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SystemApi(configuration);

const { status, data } = await apiInstance.getCreditHistory();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**GetCreditHistoryResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Snapshots (may be empty). |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getEntitlements**
> GetEntitlementsResponse getEntitlements()

Feature entitlements granted by the active subscription. Returns the raw entitlement-key array Monarch ships, plus the subscription id for cross-reference with `/v1/subscription`. Used to gate Plus-only flows on the client side without an extra round-trip. 

### Example

```typescript
import {
    SystemApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SystemApi(configuration);

const { status, data } = await apiInstance.getEntitlements();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**GetEntitlementsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Subscription id + entitlement keys. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getExpenseByCategory**
> GetExpenseByCategoryResponse getExpenseByCategory()

Expense rollup with one row per category over the given window. Drives the \"Top categories\" report card and the legacy CSV export. 

### Example

```typescript
import {
    SystemApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SystemApi(configuration);

let start: string; // (optional) (default to undefined)
let end: string; // (optional) (default to undefined)

const { status, data } = await apiInstance.getExpenseByCategory(
    start,
    end
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **start** | [**string**] |  | (optional) defaults to undefined|
| **end** | [**string**] |  | (optional) defaults to undefined|


### Return type

**GetExpenseByCategoryResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Per-category expense rows. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getExpenseByMerchant**
> GetExpenseByMerchantResponse getExpenseByMerchant()

Expense rollup with one row per merchant over the given window. 

### Example

```typescript
import {
    SystemApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SystemApi(configuration);

let start: string; // (optional) (default to undefined)
let end: string; // (optional) (default to undefined)

const { status, data } = await apiInstance.getExpenseByMerchant(
    start,
    end
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **start** | [**string**] |  | (optional) defaults to undefined|
| **end** | [**string**] |  | (optional) defaults to undefined|


### Return type

**GetExpenseByMerchantResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Per-merchant expense rows. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getExpenseByTag**
> GetExpenseByTagResponse getExpenseByTag()

Expense rollup with one row per transaction tag over the given window. Only transactions that carry at least one tag contribute. 

### Example

```typescript
import {
    SystemApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SystemApi(configuration);

let start: string; // (optional) (default to undefined)
let end: string; // (optional) (default to undefined)

const { status, data } = await apiInstance.getExpenseByTag(
    start,
    end
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **start** | [**string**] |  | (optional) defaults to undefined|
| **end** | [**string**] |  | (optional) defaults to undefined|


### Return type

**GetExpenseByTagResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Per-tag expense rows. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getFeatureFlags**
> GetFeatureFlagsResponse getFeatureFlags()

The feature-flag matrix this account currently sees. Each entry carries the flag name, on/off, and an optional variant string for A/B experiments. 

### Example

```typescript
import {
    SystemApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SystemApi(configuration);

const { status, data } = await apiInstance.getFeatureFlags();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**GetFeatureFlagsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | All active feature flags. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getFinancialInsight**
> GetFinancialInsightResponse getFinancialInsight()

Detail view of one insight, including the optional `playbook.diySteps` (do-it-yourself walkthrough text) and `paymentAccount` label when relevant. 

### Example

```typescript
import {
    SystemApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SystemApi(configuration);

let id: string; //Monarch financial insight id. (default to undefined)

const { status, data } = await apiInstance.getFinancialInsight(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch financial insight id. | defaults to undefined|


### Return type

**GetFinancialInsightResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Insight detail. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getHealth**
> GetHealthResponse getHealth()

Cheap liveness check for the proxy itself. Always returns 200 if the HTTP server is up. Body includes a `monarchAuthLoaded` flag so callers can distinguish \"service alive but unauthenticated\" from \"service alive and ready\". No session required.  Use for uptime monitoring, LaunchAgent readiness checks, or as a first-call probe before calling any data endpoint. For richer auth detail use `GET /v1/auth/status`. 

### Example

```typescript
import {
    SystemApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SystemApi(configuration);

const { status, data } = await apiInstance.getHealth();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**GetHealthResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Service is up. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getIncomeReport**
> GetIncomeReportResponse getIncomeReport()

Income breakdown for a date window: total income, average monthly income, and per-source split. Backs the web Reports page Income tab. 

### Example

```typescript
import {
    SystemApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SystemApi(configuration);

let start: string; //Lower bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)
let end: string; //Upper bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)

const { status, data } = await apiInstance.getIncomeReport(
    start,
    end
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **start** | [**string**] | Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|
| **end** | [**string**] | Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|


### Return type

**GetIncomeReportResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Income summary plus source breakdown. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getIncomeVsExpenseYoy**
> GetIncomeVsExpenseYoyResponse getIncomeVsExpenseYoy()

Compares income vs. expense across years. Each point carries a period label (typically a month) plus the income and expense totals for that period. 

### Example

```typescript
import {
    SystemApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SystemApi(configuration);

let years: number; //How many years of history to include; defaults to 2. (optional) (default to 2)

const { status, data } = await apiInstance.getIncomeVsExpenseYoy(
    years
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **years** | [**number**] | How many years of history to include; defaults to 2. | (optional) defaults to 2|


### Return type

**GetIncomeVsExpenseYoyResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Period-level income/expense points. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getIntegrationStatus**
> GetIntegrationStatusResponse getIntegrationStatus()

Per-credential health for each linked provider (Plaid / MX / Finicity / manual). The web app\'s \"Connection issues\" banner walks this list and surfaces any row with `needsReauth=true` or a non-null `errorCode`.  `status` values: `connected`, `syncing`, `error`, `disconnected`. `provider` values: `plaid`, `mx`, `finicity`, `manual`. 

### Example

```typescript
import {
    SystemApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SystemApi(configuration);

const { status, data } = await apiInstance.getIntegrationStatus();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**GetIntegrationStatusResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Per-credential health rows. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getLatestInsightRun**
> GetLatestInsightRunResponse getLatestInsightRun()

Returns just the latest run metadata (id, status, errorMessage, insightsGeneratedCount) and the current total insights count. Faster than `/v1/insights` when all you need is freshness. 

### Example

```typescript
import {
    SystemApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SystemApi(configuration);

const { status, data } = await apiInstance.getLatestInsightRun();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**GetLatestInsightRunResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Latest insight run. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getLatestRefreshOperation**
> GetLatestRefreshOperationResponse getLatestRefreshOperation()

Single global force-refresh request from this user (id + state). Useful as a lightweight alternative to `/v1/refresh/status` when you only need to know \"is a refresh currently running\" rather than per-account breakdown.  States observed in the wild: `IN_PROGRESS`, `COMPLETED`, `FAILED`. May return null when the user has never triggered a force refresh. 

### Example

```typescript
import {
    SystemApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SystemApi(configuration);

const { status, data } = await apiInstance.getLatestRefreshOperation();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**GetLatestRefreshOperationResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Latest operation snapshot (may be null). |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getLookup**
> GetLookupResponse getLookup()

One-shot semantic search across accounts + categories + tags + merchants. Backs Monarch\'s web command palette. Each result is tagged with its `type` so the caller can route to the right resource.  Cuts the typical \"search accounts then categories then tags then merchants\" round-trip dance to one. Use from AI assistants that need to resolve a free-form user reference (\"my Chase card\", \"the Coffee category\") to a Monarch entity id. 

### Example

```typescript
import {
    SystemApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SystemApi(configuration);

let q: string; //Free-text query - matches across all entity types Monarch indexes for the palette. (default to undefined)

const { status, data } = await apiInstance.getLookup(
    q
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **q** | [**string**] | Free-text query - matches across all entity types Monarch indexes for the palette. | defaults to undefined|


### Return type

**GetLookupResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Matching entities with &#x60;type&#x60; discriminator. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getMonthlyReportSummary**
> GetMonthlyReportSummaryResponse getMonthlyReportSummary()

One-month summary bundle Monarch sends to the monthly-recap email and the web monthly-summary widget. Single-row aggregate covering net income, total spending, total income, savings rate, and the top merchant / category callouts. 

### Example

```typescript
import {
    SystemApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SystemApi(configuration);

let month: string; //First-of-month date, e.g. `2026-05-01`. (default to undefined)

const { status, data } = await apiInstance.getMonthlyReportSummary(
    month
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **month** | [**string**] | First-of-month date, e.g. &#x60;2026-05-01&#x60;. | defaults to undefined|


### Return type

**GetMonthlyReportSummaryResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Monthly summary. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getNetWorthReport**
> GetNetWorthReportResponse getNetWorthReport()

Net-worth chart series for the requested window plus starting and current totals and absolute / percent change. Backs the web Reports page Net Worth tab. 

### Example

```typescript
import {
    SystemApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SystemApi(configuration);

let start: string; //Lower bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)
let end: string; //Upper bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)

const { status, data } = await apiInstance.getNetWorthReport(
    start,
    end
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **start** | [**string**] | Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|
| **end** | [**string**] | Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|


### Return type

**GetNetWorthReportResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Net-worth totals plus per-date series. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getNotifications**
> GetNotificationsResponse getNotifications()

Paginated activity-event stream backing the in-app bell. Each event has a title/body, an action link (`action`, `actionLabel`, `secondaryUrl`), a priority bucket, read state (`readAt`), and a pinned/dismissed flag pair. Returns `pageInfo.endCursor` for the next page via `?afterCursor=`. 

### Example

```typescript
import {
    SystemApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SystemApi(configuration);

let first: number; //Max number of events to return. (optional) (default to 20)
let afterCursor: string; //Pagination cursor from previous response\'s `pageInfo.endCursor`. (optional) (default to undefined)

const { status, data } = await apiInstance.getNotifications(
    first,
    afterCursor
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **first** | [**number**] | Max number of events to return. | (optional) defaults to 20|
| **afterCursor** | [**string**] | Pagination cursor from previous response\&#39;s &#x60;pageInfo.endCursor&#x60;. | (optional) defaults to undefined|


### Return type

**GetNotificationsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | A page of activity events. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getPlatformConfig**
> GetPlatformConfigResponse getPlatformConfig()

Per-platform config blob: API base URL, config version, plus arbitrary additional settings the client honors. Used by the web app on boot to hydrate its environment. 

### Example

```typescript
import {
    SystemApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SystemApi(configuration);

const { status, data } = await apiInstance.getPlatformConfig();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**GetPlatformConfigResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Platform config object. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getPlusTierAccess**
> GetPlusTierAccessResponse getPlusTierAccess()

Subscription entitlements plus Plus-trial window endpoints (`plusTrialEndsAt`, `canceledPlusTrialAt`). Use to gate \"you are in your trial\" banners and Plus-feature promotional copy. 

### Example

```typescript
import {
    SystemApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SystemApi(configuration);

const { status, data } = await apiInstance.getPlusTierAccess();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**GetPlusTierAccessResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Entitlements + Plus-trial timestamps. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getRefreshStatus**
> GetRefreshStatusResponse getRefreshStatus()

Snapshot of Monarch\'s per-account sync state. Use after firing `POST /v1/refresh` to know when the re-poll is done: keep calling until `data.allComplete` is true (typically 5-60s depending on institution).  Returns each account\'s `hasSyncInProgress` flag plus an aggregate `allComplete` rollup. For the synchronous \"fire-and-wait\" version that blocks until done, use `POST /v1/refresh/wait` instead. 

### Example

```typescript
import {
    SystemApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SystemApi(configuration);

const { status, data } = await apiInstance.getRefreshStatus();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**GetRefreshStatusResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Per-account sync flags. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getSavingsRateReport**
> GetSavingsRateReportResponse getSavingsRateReport()

Month-over-month savings rate report. Rates are fractions (`0.42` = 42%). `overallSavingsRate` is the window aggregate; `monthlyRates` is the per-month series. 

### Example

```typescript
import {
    SystemApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SystemApi(configuration);

let start: string; //Lower bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)
let end: string; //Upper bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)

const { status, data } = await apiInstance.getSavingsRateReport(
    start,
    end
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **start** | [**string**] | Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|
| **end** | [**string**] | Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|


### Return type

**GetSavingsRateReportResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Overall savings rate plus per-month series. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getSavingsRateTrends**
> GetSavingsRateTrendsResponse getSavingsRateTrends()

Savings rate (income minus expense divided by income) plotted per period. Each point carries the period label, the savings rate, and the underlying income and expense totals. 

### Example

```typescript
import {
    SystemApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SystemApi(configuration);

let months: number; //How many months of history; defaults to 12. (optional) (default to 12)

const { status, data } = await apiInstance.getSavingsRateTrends(
    months
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **months** | [**number**] | How many months of history; defaults to 12. | (optional) defaults to 12|


### Return type

**GetSavingsRateTrendsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Savings-rate trend points. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getSpendingReport**
> GetSpendingReportResponse getSpendingReport()

High-level spending vs. budget summary for a date window with the top-N category breakdown. Backs the web Reports page Spending tab. 

### Example

```typescript
import {
    SystemApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SystemApi(configuration);

let start: string; //Lower bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)
let end: string; //Upper bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)

const { status, data } = await apiInstance.getSpendingReport(
    start,
    end
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **start** | [**string**] | Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|
| **end** | [**string**] | Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|


### Return type

**GetSpendingReportResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Spending summary plus top categories. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getSubscription**
> GetSubscriptionResponse getSubscription()

Returns the household\'s Monarch subscription details: current plan (Plus, Premium, etc.), trial state, renewal date, and the payment source (Stripe / Apple App Store / Play Store).  Useful for checking entitlement before calling tier-gated endpoints (some richer reporting features fall back to empty responses on free tier) or for surfacing renewal warnings to the user. 

### Example

```typescript
import {
    SystemApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SystemApi(configuration);

const { status, data } = await apiInstance.getSubscription();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**GetSubscriptionResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Subscription details. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getSubscriptionDetails**
> GetSubscriptionDetailsResponse getSubscriptionDetails()

Full subscription detail beyond `GET /v1/subscription`: tier, renewal date, billing frequency, amount, payment method, trial dates. 

### Example

```typescript
import {
    SystemApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SystemApi(configuration);

const { status, data } = await apiInstance.getSubscriptionDetails();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**GetSubscriptionDetailsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Subscription detail object. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getSubscriptionInvoices**
> GetSubscriptionInvoicesResponse getSubscriptionInvoices()

Billing-history rows shown on the Settings → Billing page. Each row is one charge (monthly / annual / proration) with status, amount, PDF receipt URL, and the period it covered.  `status` values seen in production: `paid`, `pending`, `failed`, `refunded`. 

### Example

```typescript
import {
    SystemApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SystemApi(configuration);

const { status, data } = await apiInstance.getSubscriptionInvoices();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**GetSubscriptionInvoicesResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | All subscription invoices for the household. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getSubscriptionReceipts**
> GetSubscriptionReceiptsResponse getSubscriptionReceipts()

All payment receipts for the current subscription, with download URLs. Used at tax time for proof of expense. 

### Example

```typescript
import {
    SystemApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SystemApi(configuration);

const { status, data } = await apiInstance.getSubscriptionReceipts();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**GetSubscriptionReceiptsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Receipts list. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getTagReport**
> GetTagReportResponse getTagReport()

Per-month series for one transaction tag across a window. Backs the \"view tag\" drill-down in the web Reports tab. Each month carries both the sum amount and the transaction count, so callers can render either a spend chart or a frequency chart from one response. 

### Example

```typescript
import {
    SystemApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SystemApi(configuration);

let tagId: string; //Monarch tag id. (default to undefined)
let start: string; //Lower bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)
let end: string; //Upper bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)

const { status, data } = await apiInstance.getTagReport(
    tagId,
    start,
    end
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **tagId** | [**string**] | Monarch tag id. | defaults to undefined|
| **start** | [**string**] | Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|
| **end** | [**string**] | Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|


### Return type

**GetTagReportResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Per-month sums + counts for the tag. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getWeeklyRecap**
> GetWeeklyRecapResponse getWeeklyRecap()

AI-generated narrative recap for one week. Monarch backfills this on a schedule. Pick `start` = Monday, `end` = Sunday of the target week. Returns `null` recap if Monarch has not generated one for that window yet.  Includes a top-level `summary` plus per-module `cards` (cashflow card, biggest spend, savings progress, etc.) with both rich-block JSON and markdown variants. 

### Example

```typescript
import {
    SystemApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SystemApi(configuration);

let start: string; //Week start (inclusive), `YYYY-MM-DD`. Typically a Monday. (default to undefined)
let end: string; //Week end (inclusive), `YYYY-MM-DD`. Typically a Sunday. (default to undefined)

const { status, data } = await apiInstance.getWeeklyRecap(
    start,
    end
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **start** | [**string**] | Week start (inclusive), &#x60;YYYY-MM-DD&#x60;. Typically a Monday. | defaults to undefined|
| **end** | [**string**] | Week end (inclusive), &#x60;YYYY-MM-DD&#x60;. Typically a Sunday. | defaults to undefined|


### Return type

**GetWeeklyRecapResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Recap (may be null). |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getZestimate**
> GetZestimateResponse getZestimate(getZestimateRequest)

Resolve a free-form street address to one or more Zillow `Zestimate` rows (Zillow property id + parsed address + dollar estimate). Used by the real-estate account creation flow to pre-fill home value.  Returns an empty array if Zillow has no match. A free-form address can return multiple Zestimates when the property has been split or Zillow has near-duplicate records. 

### Example

```typescript
import {
    SystemApi,
    Configuration,
    GetZestimateRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SystemApi(configuration);

let getZestimateRequest: GetZestimateRequest; //

const { status, data } = await apiInstance.getZestimate(
    getZestimateRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **getZestimateRequest** | **GetZestimateRequest**|  | |


### Return type

**GetZestimateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Zero or more Zestimate matches. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **initiatePasswordChange**
> InitiatePasswordChangeResponse initiatePasswordChange()

Trigger Monarch\'s password-change flow. No body required. Monarch emails a reset link to the account\'s verified email; the response echoes back the `requestId` + `email` for client-side confirmation. 

### Example

```typescript
import {
    SystemApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SystemApi(configuration);

const { status, data } = await apiInstance.initiatePasswordChange();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**InitiatePasswordChangeResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Reset-token-issued confirmation. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listFinancialInsights**
> ListFinancialInsightsResponse listFinancialInsights()

Monarch\'s AI-driven money-saving opportunities (subscription audits, bill negotiation candidates, etc.). Each insight has a savings estimate range, effort tag, and current annual cost. Filter by status (e.g. `NEW`, `ACCEPTED`).  Also returns an aggregate `summary` over the window (counts + identified savings totals) and the `latestRun` metadata to gauge freshness. 

### Example

```typescript
import {
    SystemApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SystemApi(configuration);

let status: Array<string>; //Filter to one or more `InsightStatusEnum` values. Repeat the param for each. (optional) (default to undefined)
let summaryStart: string; //Lower bound for the `summary` aggregate window. (optional) (default to undefined)
let summaryEnd: string; //Upper bound for the `summary` aggregate window. (optional) (default to undefined)

const { status, data } = await apiInstance.listFinancialInsights(
    status,
    summaryStart,
    summaryEnd
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **status** | **Array&lt;string&gt;** | Filter to one or more &#x60;InsightStatusEnum&#x60; values. Repeat the param for each. | (optional) defaults to undefined|
| **summaryStart** | [**string**] | Lower bound for the &#x60;summary&#x60; aggregate window. | (optional) defaults to undefined|
| **summaryEnd** | [**string**] | Upper bound for the &#x60;summary&#x60; aggregate window. | (optional) defaults to undefined|


### Return type

**ListFinancialInsightsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Insights plus summary plus latest-run metadata. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **markAllNotificationsAsRead**
> MarkAllNotificationsAsReadResponse markAllNotificationsAsRead()

Bulk-flip `readAt` for every activity event in the bell. Echoes back the first page of events (so the client can refresh state without a second round-trip). 

### Example

```typescript
import {
    SystemApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SystemApi(configuration);

let first: number; //Page size for the echoed event list. (optional) (default to 20)

const { status, data } = await apiInstance.markAllNotificationsAsRead(
    first
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **first** | [**number**] | Page size for the echoed event list. | (optional) defaults to 20|


### Return type

**MarkAllNotificationsAsReadResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Updated id + readAt for each event in the echoed page. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **markNotificationAsRead**
> MarkNotificationAsReadResponse markNotificationAsRead()

Flip a single activity event\'s `readAt` to now. Used by the bell UI when an event is opened or clicked. Idempotent. 

### Example

```typescript
import {
    SystemApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SystemApi(configuration);

let id: string; //Monarch activity-event id. (default to undefined)

const { status, data } = await apiInstance.markNotificationAsRead(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch activity-event id. | defaults to undefined|


### Return type

**MarkNotificationAsReadResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Updated event id + readAt timestamp. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **pauseSubscription**
> PauseSubscriptionResponse pauseSubscription()

Suspends billing without canceling. Provide `resumeAt` to auto-resume on a date; omit for indefinite pause. Read-only data access remains during a pause. 

### Example

```typescript
import {
    SystemApi,
    Configuration,
    PauseSubscriptionRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SystemApi(configuration);

let pauseSubscriptionRequest: PauseSubscriptionRequest; // (optional)

const { status, data } = await apiInstance.pauseSubscription(
    pauseSubscriptionRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **pauseSubscriptionRequest** | **PauseSubscriptionRequest**|  | |


### Return type

**PauseSubscriptionResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Pause confirmation. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **previewSubscriptionPlanChange**
> PreviewSubscriptionPlanChangeResponse previewSubscriptionPlanChange(previewSubscriptionPlanChangeRequest)

Computes the prorated charge for switching to `targetTier` (and optionally `billingFrequency`). Does NOT mutate the subscription. Use to show \"you will be charged USD X today\" before the user confirms. 

### Example

```typescript
import {
    SystemApi,
    Configuration,
    PreviewSubscriptionPlanChangeRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SystemApi(configuration);

let previewSubscriptionPlanChangeRequest: PreviewSubscriptionPlanChangeRequest; //

const { status, data } = await apiInstance.previewSubscriptionPlanChange(
    previewSubscriptionPlanChangeRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **previewSubscriptionPlanChangeRequest** | **PreviewSubscriptionPlanChangeRequest**|  | |


### Return type

**PreviewSubscriptionPlanChangeResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Preview of prorated charge and new renewal date. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **refreshAuth**
> GetAuthStatusResponse refreshAuth()

Re-reads `~/.config/monarch-bridge/.mm-session.json` and swaps in the new token without a service restart.  Use after running the bootstrap CLI\'s re-auth flow (`mb auth login`) to pick up freshly-issued credentials. Cheap call: just hits the local filesystem and updates an in-memory atomic reference. Returns the post-reload auth status so the caller knows immediately whether the new session is loaded. 

### Example

```typescript
import {
    SystemApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SystemApi(configuration);

const { status, data } = await apiInstance.refreshAuth();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**GetAuthStatusResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Session reloaded; returns the new auth status. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **requestRefresh**
> requestRefresh()

Triggers Monarch to re-poll Plaid for account balance and transaction updates. Fire-and-forget: returns 202 immediately after queueing the refresh.  Without `accountIds`, refreshes **every** linked account. Pass one or more `accountIds` to scope. Poll progress with `GET /v1/refresh/status` until `data.allComplete` is true (5-60s typically depending on institution).  For a synchronous version that blocks until done, use `POST /v1/refresh/wait`. 

### Example

```typescript
import {
    SystemApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SystemApi(configuration);

let accountIds: Array<string>; //Optional list of Monarch account ids. Omit to refresh all accounts. (optional) (default to undefined)

const { status, data } = await apiInstance.requestRefresh(
    accountIds
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **accountIds** | **Array&lt;string&gt;** | Optional list of Monarch account ids. Omit to refresh all accounts. | (optional) defaults to undefined|


### Return type

void (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**202** | Refresh queued. |  -  |
|**503** | No session loaded. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **requestRefreshAndWait**
> GetRefreshStatusResponse requestRefreshAndWait()

Synchronous version of `POST /v1/refresh` + polling `GET /v1/refresh/status`. Fires the refresh and blocks until every account reports `hasSyncInProgress: false` or the timeout elapses (default 60s, max 300s; cap via `timeoutSeconds`). Without `accountIds`, refreshes **every** linked account. Pass one or more `accountIds` to scope the refresh. 

### Example

```typescript
import {
    SystemApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SystemApi(configuration);

let timeoutSeconds: number; //Max time to poll before returning the last-seen status. (optional) (default to 60)
let accountIds: Array<string>; //Optional list of Monarch account ids. Omit to refresh all accounts. (optional) (default to undefined)

const { status, data } = await apiInstance.requestRefreshAndWait(
    timeoutSeconds,
    accountIds
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **timeoutSeconds** | [**number**] | Max time to poll before returning the last-seen status. | (optional) defaults to 60|
| **accountIds** | **Array&lt;string&gt;** | Optional list of Monarch account ids. Omit to refresh all accounts. | (optional) defaults to undefined|


### Return type

**GetRefreshStatusResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Final per-account sync flags after the wait. |  -  |
|**503** | No session loaded. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **resumeSubscription**
> ResumeSubscriptionResponse resumeSubscription()

Lifts a pause and resumes billing immediately. No-op if the subscription is already active. 

### Example

```typescript
import {
    SystemApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new SystemApi(configuration);

const { status, data } = await apiInstance.resumeSubscription();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**ResumeSubscriptionResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Resume confirmation. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

