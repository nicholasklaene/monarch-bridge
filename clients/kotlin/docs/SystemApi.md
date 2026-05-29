# SystemApi

All URIs are relative to *http://localhost:9084*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**clearAllNotifications**](SystemApi.md#clearAllNotifications) | **POST** /v1/notifications/clear-all | Clear all notifications |
| [**dismissNotification**](SystemApi.md#dismissNotification) | **POST** /v1/notifications/{id}/dismiss | Dismiss one notification |
| [**getAppVersion**](SystemApi.md#getAppVersion) | **GET** /v1/app/version | App version info |
| [**getAuthStatus**](SystemApi.md#getAuthStatus) | **GET** /v1/auth/status | Whether a Monarch session is currently loaded |
| [**getBetaFeatures**](SystemApi.md#getBetaFeatures) | **GET** /v1/app/beta-features | Beta features the account can opt into |
| [**getCalendarEvents**](SystemApi.md#getCalendarEvents) | **GET** /v1/calendar/events | Calendar events |
| [**getCashflowReport**](SystemApi.md#getCashflowReport) | **GET** /v1/reports/cashflow | Cashflow report |
| [**getCategoryReport**](SystemApi.md#getCategoryReport) | **GET** /v1/reports/category | Per-category historical report |
| [**getCreditHistory**](SystemApi.md#getCreditHistory) | **GET** /v1/credit/history | Credit-score snapshots over time |
| [**getEntitlements**](SystemApi.md#getEntitlements) | **GET** /v1/entitlements | Subscription entitlements |
| [**getExpenseByCategory**](SystemApi.md#getExpenseByCategory) | **GET** /v1/reports/expense-by-category | Expense breakdown grouped by category |
| [**getExpenseByMerchant**](SystemApi.md#getExpenseByMerchant) | **GET** /v1/reports/expense-by-merchant | Expense breakdown grouped by merchant |
| [**getExpenseByTag**](SystemApi.md#getExpenseByTag) | **GET** /v1/reports/expense-by-tag | Expense breakdown grouped by tag |
| [**getFeatureFlags**](SystemApi.md#getFeatureFlags) | **GET** /v1/app/feature-flags | Feature flags for this account |
| [**getFinancialInsight**](SystemApi.md#getFinancialInsight) | **GET** /v1/insights/{id} | Single AI savings insight |
| [**getHealth**](SystemApi.md#getHealth) | **GET** /healthz | Liveness probe with auth-presence hint |
| [**getIncomeReport**](SystemApi.md#getIncomeReport) | **GET** /v1/reports/income | Income report |
| [**getIncomeVsExpenseYoy**](SystemApi.md#getIncomeVsExpenseYoy) | **GET** /v1/reports/income-vs-expense-yoy | Income vs. expense year-over-year |
| [**getIntegrationStatus**](SystemApi.md#getIntegrationStatus) | **GET** /v1/integrations/status | Per-credential integration health |
| [**getLatestInsightRun**](SystemApi.md#getLatestInsightRun) | **GET** /v1/insights/latest-run | Latest financial-insight run + insights count |
| [**getLatestRefreshOperation**](SystemApi.md#getLatestRefreshOperation) | **GET** /v1/refresh/latest | Latest force-refresh operation |
| [**getLookup**](SystemApi.md#getLookup) | **GET** /v1/lookup | Cross-entity fuzzy lookup |
| [**getMonthlyReportSummary**](SystemApi.md#getMonthlyReportSummary) | **GET** /v1/reports/monthly-summary | Monthly report summary |
| [**getNetWorthReport**](SystemApi.md#getNetWorthReport) | **GET** /v1/reports/net-worth | Net-worth report |
| [**getNotifications**](SystemApi.md#getNotifications) | **GET** /v1/notifications | Notification center (activity events) |
| [**getPlatformConfig**](SystemApi.md#getPlatformConfig) | **GET** /v1/app/platform-config | Platform configuration |
| [**getPlusTierAccess**](SystemApi.md#getPlusTierAccess) | **GET** /v1/plus-tier | Plus-tier access info |
| [**getRefreshStatus**](SystemApi.md#getRefreshStatus) | **GET** /v1/refresh/status | Poll per-account sync status |
| [**getSavingsRateReport**](SystemApi.md#getSavingsRateReport) | **GET** /v1/reports/savings-rate | Savings-rate report |
| [**getSavingsRateTrends**](SystemApi.md#getSavingsRateTrends) | **GET** /v1/reports/savings-rate-trends | Savings-rate trend series |
| [**getSpendingReport**](SystemApi.md#getSpendingReport) | **GET** /v1/reports/spending | Spending report |
| [**getSubscription**](SystemApi.md#getSubscription) | **GET** /v1/subscription | Monarch subscription tier + payment source |
| [**getSubscriptionDetails**](SystemApi.md#getSubscriptionDetails) | **GET** /v1/subscription/details | Detailed subscription info |
| [**getSubscriptionInvoices**](SystemApi.md#getSubscriptionInvoices) | **GET** /v1/subscription/invoices | Subscription invoice history |
| [**getSubscriptionReceipts**](SystemApi.md#getSubscriptionReceipts) | **GET** /v1/subscription/receipts | Subscription payment receipts |
| [**getTagReport**](SystemApi.md#getTagReport) | **GET** /v1/reports/tag | Per-tag historical report |
| [**getWeeklyRecap**](SystemApi.md#getWeeklyRecap) | **GET** /v1/recap/weekly | Weekly recap |
| [**getZestimate**](SystemApi.md#getZestimate) | **POST** /v1/zillow/zestimate | Zillow Zestimate lookup |
| [**initiatePasswordChange**](SystemApi.md#initiatePasswordChange) | **POST** /v1/me/password-change/initiate | Initiate password change |
| [**listFinancialInsights**](SystemApi.md#listFinancialInsights) | **GET** /v1/insights | List AI savings insights |
| [**markAllNotificationsAsRead**](SystemApi.md#markAllNotificationsAsRead) | **POST** /v1/notifications/read-all | Mark all notifications as read |
| [**markNotificationAsRead**](SystemApi.md#markNotificationAsRead) | **POST** /v1/notifications/{id}/read | Mark one notification as read |
| [**pauseSubscription**](SystemApi.md#pauseSubscription) | **POST** /v1/subscription/pause | Pause the subscription |
| [**previewSubscriptionPlanChange**](SystemApi.md#previewSubscriptionPlanChange) | **POST** /v1/subscription/plan-preview | Preview a plan-change charge |
| [**refreshAuth**](SystemApi.md#refreshAuth) | **POST** /v1/auth/refresh | Reload session JSON from disk |
| [**requestRefresh**](SystemApi.md#requestRefresh) | **POST** /v1/refresh | Force Monarch to re-poll Plaid (async) |
| [**requestRefreshAndWait**](SystemApi.md#requestRefreshAndWait) | **POST** /v1/refresh/wait | Force Monarch to re-poll Plaid and wait until every account has finished |
| [**resumeSubscription**](SystemApi.md#resumeSubscription) | **POST** /v1/subscription/resume | Resume a paused subscription |


<a id="clearAllNotifications"></a>
# **clearAllNotifications**
> MarkTransactionStreamAsNotRecurringResponse clearAllNotifications()

Clear all notifications

Bulk-dismiss every activity event in the bell. Returns a simple success boolean. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SystemApi()
try {
    val result : MarkTransactionStreamAsNotRecurringResponse = apiInstance.clearAllNotifications()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SystemApi#clearAllNotifications")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SystemApi#clearAllNotifications")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**MarkTransactionStreamAsNotRecurringResponse**](MarkTransactionStreamAsNotRecurringResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="dismissNotification"></a>
# **dismissNotification**
> DismissNotificationResponse dismissNotification(id)

Dismiss one notification

Permanently dismiss a single activity event. Distinct from &#x60;read&#x60; - dismissed events are hidden entirely (will not reappear even if unread). 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SystemApi()
val id : kotlin.String = id_example // kotlin.String | Monarch activity-event id.
try {
    val result : DismissNotificationResponse = apiInstance.dismissNotification(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SystemApi#dismissNotification")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SystemApi#dismissNotification")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **kotlin.String**| Monarch activity-event id. | |

### Return type

[**DismissNotificationResponse**](DismissNotificationResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getAppVersion"></a>
# **getAppVersion**
> GetAppVersionResponse getAppVersion()

App version info

Current build version, the minimum supported version (older clients are blocked), and the recommended version. Use to drive \&quot;please update your app\&quot; prompts. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SystemApi()
try {
    val result : GetAppVersionResponse = apiInstance.getAppVersion()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SystemApi#getAppVersion")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SystemApi#getAppVersion")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**GetAppVersionResponse**](GetAppVersionResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getAuthStatus"></a>
# **getAuthStatus**
> GetAuthStatusResponse getAuthStatus()

Whether a Monarch session is currently loaded

Reports whether the proxy has a valid Monarch session token in memory. Use as a precondition before calling any data endpoint: a missing session yields 503 on every other route.  No session required to call this endpoint (unlike most others). The response includes a coarse loaded/not-loaded flag plus the session&#39;s expiry hint. If the session is missing or expired, run the bootstrap CLI to re-auth then call &#x60;POST /v1/auth/refresh&#x60; to swap in the new token. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SystemApi()
try {
    val result : GetAuthStatusResponse = apiInstance.getAuthStatus()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SystemApi#getAuthStatus")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SystemApi#getAuthStatus")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**GetAuthStatusResponse**](GetAuthStatusResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getBetaFeatures"></a>
# **getBetaFeatures**
> GetBetaFeaturesResponse getBetaFeatures()

Beta features the account can opt into

Beta program list. Each entry has a name, short description, and whether the household is currently enrolled. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SystemApi()
try {
    val result : GetBetaFeaturesResponse = apiInstance.getBetaFeatures()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SystemApi#getBetaFeatures")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SystemApi#getBetaFeatures")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**GetBetaFeaturesResponse**](GetBetaFeaturesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getCalendarEvents"></a>
# **getCalendarEvents**
> GetCalendarEventsResponse getCalendarEvents(start, end)

Calendar events

Bills, recurring transactions, and paychecks projected onto a calendar shape for a date window. One entry per event with date, type (&#x60;bill&#x60;, &#x60;recurring&#x60;, &#x60;paycheck&#x60;), title, amount, and the id of the underlying source record. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SystemApi()
val start : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Lower bound (inclusive), `YYYY-MM-DD`.
val end : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Upper bound (inclusive), `YYYY-MM-DD`.
try {
    val result : GetCalendarEventsResponse = apiInstance.getCalendarEvents(start, end)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SystemApi#getCalendarEvents")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SystemApi#getCalendarEvents")
    e.printStackTrace()
}
```

### Parameters
| **start** | **java.time.LocalDate**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **end** | **java.time.LocalDate**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |

### Return type

[**GetCalendarEventsResponse**](GetCalendarEventsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getCashflowReport"></a>
# **getCashflowReport**
> GetCashflowReportResponse getCashflowReport(start, end)

Cashflow report

Full cashflow report: total income / expense / net for the window plus a per-month series. Distinct from &#x60;GET /v1/cashflow&#x60; (a lighter summary view); this is the per-month chart shape the web Reports tab fires. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SystemApi()
val start : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Lower bound (inclusive), `YYYY-MM-DD`.
val end : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Upper bound (inclusive), `YYYY-MM-DD`.
try {
    val result : GetCashflowReportResponse = apiInstance.getCashflowReport(start, end)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SystemApi#getCashflowReport")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SystemApi#getCashflowReport")
    e.printStackTrace()
}
```

### Parameters
| **start** | **java.time.LocalDate**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **end** | **java.time.LocalDate**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |

### Return type

[**GetCashflowReportResponse**](GetCashflowReportResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getCategoryReport"></a>
# **getCategoryReport**
> GetCategoryReportResponse getCategoryReport(categoryId, start, end)

Per-category historical report

Per-month sum series for one category across a window. Backs the \&quot;click category → drill down\&quot; view in the web Reports tab. Returns &#x60;totalAmount&#x60; and &#x60;averagePerMonth&#x60; for convenience. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SystemApi()
val categoryId : kotlin.String = categoryId_example // kotlin.String | Monarch category id.
val start : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Lower bound (inclusive), `YYYY-MM-DD`.
val end : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Upper bound (inclusive), `YYYY-MM-DD`.
try {
    val result : GetCategoryReportResponse = apiInstance.getCategoryReport(categoryId, start, end)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SystemApi#getCategoryReport")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SystemApi#getCategoryReport")
    e.printStackTrace()
}
```

### Parameters
| **categoryId** | **kotlin.String**| Monarch category id. | |
| **start** | **java.time.LocalDate**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **end** | **java.time.LocalDate**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |

### Return type

[**GetCategoryReportResponse**](GetCategoryReportResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getCreditHistory"></a>
# **getCreditHistory**
> GetCreditHistoryResponse getCreditHistory()

Credit-score snapshots over time

Returns the user&#39;s credit-score history series from Monarch&#39;s Spinwheel integration. Each entry has a date, score, and the reporting bureau (typically TransUnion).  Use for credit-trend charts or to surface the most recent score. Empty list when Spinwheel is not enabled on the user&#39;s account (no error, just zero entries). Premium-tier feature on Monarch&#39;s side - tier check via &#x60;GET /v1/subscription&#x60; if needed. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SystemApi()
try {
    val result : GetCreditHistoryResponse = apiInstance.getCreditHistory()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SystemApi#getCreditHistory")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SystemApi#getCreditHistory")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**GetCreditHistoryResponse**](GetCreditHistoryResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getEntitlements"></a>
# **getEntitlements**
> GetEntitlementsResponse getEntitlements()

Subscription entitlements

Feature entitlements granted by the active subscription. Returns the raw entitlement-key array Monarch ships, plus the subscription id for cross-reference with &#x60;/v1/subscription&#x60;. Used to gate Plus-only flows on the client side without an extra round-trip. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SystemApi()
try {
    val result : GetEntitlementsResponse = apiInstance.getEntitlements()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SystemApi#getEntitlements")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SystemApi#getEntitlements")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**GetEntitlementsResponse**](GetEntitlementsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getExpenseByCategory"></a>
# **getExpenseByCategory**
> GetExpenseByCategoryResponse getExpenseByCategory(start, end)

Expense breakdown grouped by category

Expense rollup with one row per category over the given window. Drives the \&quot;Top categories\&quot; report card and the legacy CSV export. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SystemApi()
val start : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | 
val end : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | 
try {
    val result : GetExpenseByCategoryResponse = apiInstance.getExpenseByCategory(start, end)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SystemApi#getExpenseByCategory")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SystemApi#getExpenseByCategory")
    e.printStackTrace()
}
```

### Parameters
| **start** | **java.time.LocalDate**|  | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **end** | **java.time.LocalDate**|  | [optional] |

### Return type

[**GetExpenseByCategoryResponse**](GetExpenseByCategoryResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getExpenseByMerchant"></a>
# **getExpenseByMerchant**
> GetExpenseByMerchantResponse getExpenseByMerchant(start, end)

Expense breakdown grouped by merchant

Expense rollup with one row per merchant over the given window. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SystemApi()
val start : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | 
val end : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | 
try {
    val result : GetExpenseByMerchantResponse = apiInstance.getExpenseByMerchant(start, end)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SystemApi#getExpenseByMerchant")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SystemApi#getExpenseByMerchant")
    e.printStackTrace()
}
```

### Parameters
| **start** | **java.time.LocalDate**|  | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **end** | **java.time.LocalDate**|  | [optional] |

### Return type

[**GetExpenseByMerchantResponse**](GetExpenseByMerchantResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getExpenseByTag"></a>
# **getExpenseByTag**
> GetExpenseByTagResponse getExpenseByTag(start, end)

Expense breakdown grouped by tag

Expense rollup with one row per transaction tag over the given window. Only transactions that carry at least one tag contribute. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SystemApi()
val start : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | 
val end : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | 
try {
    val result : GetExpenseByTagResponse = apiInstance.getExpenseByTag(start, end)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SystemApi#getExpenseByTag")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SystemApi#getExpenseByTag")
    e.printStackTrace()
}
```

### Parameters
| **start** | **java.time.LocalDate**|  | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **end** | **java.time.LocalDate**|  | [optional] |

### Return type

[**GetExpenseByTagResponse**](GetExpenseByTagResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getFeatureFlags"></a>
# **getFeatureFlags**
> GetFeatureFlagsResponse getFeatureFlags()

Feature flags for this account

The feature-flag matrix this account currently sees. Each entry carries the flag name, on/off, and an optional variant string for A/B experiments. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SystemApi()
try {
    val result : GetFeatureFlagsResponse = apiInstance.getFeatureFlags()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SystemApi#getFeatureFlags")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SystemApi#getFeatureFlags")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**GetFeatureFlagsResponse**](GetFeatureFlagsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getFinancialInsight"></a>
# **getFinancialInsight**
> GetFinancialInsightResponse getFinancialInsight(id)

Single AI savings insight

Detail view of one insight, including the optional &#x60;playbook.diySteps&#x60; (do-it-yourself walkthrough text) and &#x60;paymentAccount&#x60; label when relevant. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SystemApi()
val id : kotlin.String = id_example // kotlin.String | Monarch financial insight id.
try {
    val result : GetFinancialInsightResponse = apiInstance.getFinancialInsight(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SystemApi#getFinancialInsight")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SystemApi#getFinancialInsight")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **kotlin.String**| Monarch financial insight id. | |

### Return type

[**GetFinancialInsightResponse**](GetFinancialInsightResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getHealth"></a>
# **getHealth**
> GetHealthResponse getHealth()

Liveness probe with auth-presence hint

Cheap liveness check for the proxy itself. Always returns 200 if the HTTP server is up. Body includes a &#x60;monarchAuthLoaded&#x60; flag so callers can distinguish \&quot;service alive but unauthenticated\&quot; from \&quot;service alive and ready\&quot;. No session required.  Use for uptime monitoring, LaunchAgent readiness checks, or as a first-call probe before calling any data endpoint. For richer auth detail use &#x60;GET /v1/auth/status&#x60;. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SystemApi()
try {
    val result : GetHealthResponse = apiInstance.getHealth()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SystemApi#getHealth")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SystemApi#getHealth")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**GetHealthResponse**](GetHealthResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getIncomeReport"></a>
# **getIncomeReport**
> GetIncomeReportResponse getIncomeReport(start, end)

Income report

Income breakdown for a date window: total income, average monthly income, and per-source split. Backs the web Reports page Income tab. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SystemApi()
val start : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Lower bound (inclusive), `YYYY-MM-DD`.
val end : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Upper bound (inclusive), `YYYY-MM-DD`.
try {
    val result : GetIncomeReportResponse = apiInstance.getIncomeReport(start, end)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SystemApi#getIncomeReport")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SystemApi#getIncomeReport")
    e.printStackTrace()
}
```

### Parameters
| **start** | **java.time.LocalDate**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **end** | **java.time.LocalDate**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |

### Return type

[**GetIncomeReportResponse**](GetIncomeReportResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getIncomeVsExpenseYoy"></a>
# **getIncomeVsExpenseYoy**
> GetIncomeVsExpenseYoyResponse getIncomeVsExpenseYoy(years)

Income vs. expense year-over-year

Compares income vs. expense across years. Each point carries a period label (typically a month) plus the income and expense totals for that period. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SystemApi()
val years : kotlin.Int = 56 // kotlin.Int | How many years of history to include; defaults to 2.
try {
    val result : GetIncomeVsExpenseYoyResponse = apiInstance.getIncomeVsExpenseYoy(years)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SystemApi#getIncomeVsExpenseYoy")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SystemApi#getIncomeVsExpenseYoy")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **years** | **kotlin.Int**| How many years of history to include; defaults to 2. | [optional] [default to 2] |

### Return type

[**GetIncomeVsExpenseYoyResponse**](GetIncomeVsExpenseYoyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getIntegrationStatus"></a>
# **getIntegrationStatus**
> GetIntegrationStatusResponse getIntegrationStatus()

Per-credential integration health

Per-credential health for each linked provider (Plaid / MX / Finicity / manual). The web app&#39;s \&quot;Connection issues\&quot; banner walks this list and surfaces any row with &#x60;needsReauth&#x3D;true&#x60; or a non-null &#x60;errorCode&#x60;.  &#x60;status&#x60; values: &#x60;connected&#x60;, &#x60;syncing&#x60;, &#x60;error&#x60;, &#x60;disconnected&#x60;. &#x60;provider&#x60; values: &#x60;plaid&#x60;, &#x60;mx&#x60;, &#x60;finicity&#x60;, &#x60;manual&#x60;. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SystemApi()
try {
    val result : GetIntegrationStatusResponse = apiInstance.getIntegrationStatus()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SystemApi#getIntegrationStatus")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SystemApi#getIntegrationStatus")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**GetIntegrationStatusResponse**](GetIntegrationStatusResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getLatestInsightRun"></a>
# **getLatestInsightRun**
> GetLatestInsightRunResponse getLatestInsightRun()

Latest financial-insight run + insights count

Returns just the latest run metadata (id, status, errorMessage, insightsGeneratedCount) and the current total insights count. Faster than &#x60;/v1/insights&#x60; when all you need is freshness. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SystemApi()
try {
    val result : GetLatestInsightRunResponse = apiInstance.getLatestInsightRun()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SystemApi#getLatestInsightRun")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SystemApi#getLatestInsightRun")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**GetLatestInsightRunResponse**](GetLatestInsightRunResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getLatestRefreshOperation"></a>
# **getLatestRefreshOperation**
> GetLatestRefreshOperationResponse getLatestRefreshOperation()

Latest force-refresh operation

Single global force-refresh request from this user (id + state). Useful as a lightweight alternative to &#x60;/v1/refresh/status&#x60; when you only need to know \&quot;is a refresh currently running\&quot; rather than per-account breakdown.  States observed in the wild: &#x60;IN_PROGRESS&#x60;, &#x60;COMPLETED&#x60;, &#x60;FAILED&#x60;. May return null when the user has never triggered a force refresh. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SystemApi()
try {
    val result : GetLatestRefreshOperationResponse = apiInstance.getLatestRefreshOperation()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SystemApi#getLatestRefreshOperation")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SystemApi#getLatestRefreshOperation")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**GetLatestRefreshOperationResponse**](GetLatestRefreshOperationResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getLookup"></a>
# **getLookup**
> GetLookupResponse getLookup(q)

Cross-entity fuzzy lookup

One-shot semantic search across accounts + categories + tags + merchants. Backs Monarch&#39;s web command palette. Each result is tagged with its &#x60;type&#x60; so the caller can route to the right resource.  Cuts the typical \&quot;search accounts then categories then tags then merchants\&quot; round-trip dance to one. Use from AI assistants that need to resolve a free-form user reference (\&quot;my Chase card\&quot;, \&quot;the Coffee category\&quot;) to a Monarch entity id. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SystemApi()
val q : kotlin.String = q_example // kotlin.String | Free-text query - matches across all entity types Monarch indexes for the palette.
try {
    val result : GetLookupResponse = apiInstance.getLookup(q)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SystemApi#getLookup")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SystemApi#getLookup")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **q** | **kotlin.String**| Free-text query - matches across all entity types Monarch indexes for the palette. | |

### Return type

[**GetLookupResponse**](GetLookupResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getMonthlyReportSummary"></a>
# **getMonthlyReportSummary**
> GetMonthlyReportSummaryResponse getMonthlyReportSummary(month)

Monthly report summary

One-month summary bundle Monarch sends to the monthly-recap email and the web monthly-summary widget. Single-row aggregate covering net income, total spending, total income, savings rate, and the top merchant / category callouts. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SystemApi()
val month : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | First-of-month date, e.g. `2026-05-01`.
try {
    val result : GetMonthlyReportSummaryResponse = apiInstance.getMonthlyReportSummary(month)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SystemApi#getMonthlyReportSummary")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SystemApi#getMonthlyReportSummary")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **month** | **java.time.LocalDate**| First-of-month date, e.g. &#x60;2026-05-01&#x60;. | |

### Return type

[**GetMonthlyReportSummaryResponse**](GetMonthlyReportSummaryResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getNetWorthReport"></a>
# **getNetWorthReport**
> GetNetWorthReportResponse getNetWorthReport(start, end)

Net-worth report

Net-worth chart series for the requested window plus starting and current totals and absolute / percent change. Backs the web Reports page Net Worth tab. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SystemApi()
val start : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Lower bound (inclusive), `YYYY-MM-DD`.
val end : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Upper bound (inclusive), `YYYY-MM-DD`.
try {
    val result : GetNetWorthReportResponse = apiInstance.getNetWorthReport(start, end)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SystemApi#getNetWorthReport")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SystemApi#getNetWorthReport")
    e.printStackTrace()
}
```

### Parameters
| **start** | **java.time.LocalDate**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **end** | **java.time.LocalDate**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |

### Return type

[**GetNetWorthReportResponse**](GetNetWorthReportResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getNotifications"></a>
# **getNotifications**
> GetNotificationsResponse getNotifications(first, afterCursor)

Notification center (activity events)

Paginated activity-event stream backing the in-app bell. Each event has a title/body, an action link (&#x60;action&#x60;, &#x60;actionLabel&#x60;, &#x60;secondaryUrl&#x60;), a priority bucket, read state (&#x60;readAt&#x60;), and a pinned/dismissed flag pair. Returns &#x60;pageInfo.endCursor&#x60; for the next page via &#x60;?afterCursor&#x3D;&#x60;. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SystemApi()
val first : kotlin.Int = 56 // kotlin.Int | Max number of events to return.
val afterCursor : kotlin.String = afterCursor_example // kotlin.String | Pagination cursor from previous response's `pageInfo.endCursor`.
try {
    val result : GetNotificationsResponse = apiInstance.getNotifications(first, afterCursor)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SystemApi#getNotifications")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SystemApi#getNotifications")
    e.printStackTrace()
}
```

### Parameters
| **first** | **kotlin.Int**| Max number of events to return. | [optional] [default to 20] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **afterCursor** | **kotlin.String**| Pagination cursor from previous response&#39;s &#x60;pageInfo.endCursor&#x60;. | [optional] |

### Return type

[**GetNotificationsResponse**](GetNotificationsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getPlatformConfig"></a>
# **getPlatformConfig**
> GetPlatformConfigResponse getPlatformConfig()

Platform configuration

Per-platform config blob: API base URL, config version, plus arbitrary additional settings the client honors. Used by the web app on boot to hydrate its environment. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SystemApi()
try {
    val result : GetPlatformConfigResponse = apiInstance.getPlatformConfig()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SystemApi#getPlatformConfig")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SystemApi#getPlatformConfig")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**GetPlatformConfigResponse**](GetPlatformConfigResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getPlusTierAccess"></a>
# **getPlusTierAccess**
> GetPlusTierAccessResponse getPlusTierAccess()

Plus-tier access info

Subscription entitlements plus Plus-trial window endpoints (&#x60;plusTrialEndsAt&#x60;, &#x60;canceledPlusTrialAt&#x60;). Use to gate \&quot;you are in your trial\&quot; banners and Plus-feature promotional copy. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SystemApi()
try {
    val result : GetPlusTierAccessResponse = apiInstance.getPlusTierAccess()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SystemApi#getPlusTierAccess")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SystemApi#getPlusTierAccess")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**GetPlusTierAccessResponse**](GetPlusTierAccessResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getRefreshStatus"></a>
# **getRefreshStatus**
> GetRefreshStatusResponse getRefreshStatus()

Poll per-account sync status

Snapshot of Monarch&#39;s per-account sync state. Use after firing &#x60;POST /v1/refresh&#x60; to know when the re-poll is done: keep calling until &#x60;data.allComplete&#x60; is true (typically 5-60s depending on institution).  Returns each account&#39;s &#x60;hasSyncInProgress&#x60; flag plus an aggregate &#x60;allComplete&#x60; rollup. For the synchronous \&quot;fire-and-wait\&quot; version that blocks until done, use &#x60;POST /v1/refresh/wait&#x60; instead. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SystemApi()
try {
    val result : GetRefreshStatusResponse = apiInstance.getRefreshStatus()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SystemApi#getRefreshStatus")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SystemApi#getRefreshStatus")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**GetRefreshStatusResponse**](GetRefreshStatusResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getSavingsRateReport"></a>
# **getSavingsRateReport**
> GetSavingsRateReportResponse getSavingsRateReport(start, end)

Savings-rate report

Month-over-month savings rate report. Rates are fractions (&#x60;0.42&#x60; &#x3D; 42%). &#x60;overallSavingsRate&#x60; is the window aggregate; &#x60;monthlyRates&#x60; is the per-month series. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SystemApi()
val start : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Lower bound (inclusive), `YYYY-MM-DD`.
val end : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Upper bound (inclusive), `YYYY-MM-DD`.
try {
    val result : GetSavingsRateReportResponse = apiInstance.getSavingsRateReport(start, end)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SystemApi#getSavingsRateReport")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SystemApi#getSavingsRateReport")
    e.printStackTrace()
}
```

### Parameters
| **start** | **java.time.LocalDate**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **end** | **java.time.LocalDate**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |

### Return type

[**GetSavingsRateReportResponse**](GetSavingsRateReportResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getSavingsRateTrends"></a>
# **getSavingsRateTrends**
> GetSavingsRateTrendsResponse getSavingsRateTrends(months)

Savings-rate trend series

Savings rate (income minus expense divided by income) plotted per period. Each point carries the period label, the savings rate, and the underlying income and expense totals. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SystemApi()
val months : kotlin.Int = 56 // kotlin.Int | How many months of history; defaults to 12.
try {
    val result : GetSavingsRateTrendsResponse = apiInstance.getSavingsRateTrends(months)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SystemApi#getSavingsRateTrends")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SystemApi#getSavingsRateTrends")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **months** | **kotlin.Int**| How many months of history; defaults to 12. | [optional] [default to 12] |

### Return type

[**GetSavingsRateTrendsResponse**](GetSavingsRateTrendsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getSpendingReport"></a>
# **getSpendingReport**
> GetSpendingReportResponse getSpendingReport(start, end)

Spending report

High-level spending vs. budget summary for a date window with the top-N category breakdown. Backs the web Reports page Spending tab. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SystemApi()
val start : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Lower bound (inclusive), `YYYY-MM-DD`.
val end : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Upper bound (inclusive), `YYYY-MM-DD`.
try {
    val result : GetSpendingReportResponse = apiInstance.getSpendingReport(start, end)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SystemApi#getSpendingReport")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SystemApi#getSpendingReport")
    e.printStackTrace()
}
```

### Parameters
| **start** | **java.time.LocalDate**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **end** | **java.time.LocalDate**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |

### Return type

[**GetSpendingReportResponse**](GetSpendingReportResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getSubscription"></a>
# **getSubscription**
> GetSubscriptionResponse getSubscription()

Monarch subscription tier + payment source

Returns the household&#39;s Monarch subscription details: current plan (Plus, Premium, etc.), trial state, renewal date, and the payment source (Stripe / Apple App Store / Play Store).  Useful for checking entitlement before calling tier-gated endpoints (some richer reporting features fall back to empty responses on free tier) or for surfacing renewal warnings to the user. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SystemApi()
try {
    val result : GetSubscriptionResponse = apiInstance.getSubscription()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SystemApi#getSubscription")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SystemApi#getSubscription")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**GetSubscriptionResponse**](GetSubscriptionResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getSubscriptionDetails"></a>
# **getSubscriptionDetails**
> GetSubscriptionDetailsResponse getSubscriptionDetails()

Detailed subscription info

Full subscription detail beyond &#x60;GET /v1/subscription&#x60;: tier, renewal date, billing frequency, amount, payment method, trial dates. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SystemApi()
try {
    val result : GetSubscriptionDetailsResponse = apiInstance.getSubscriptionDetails()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SystemApi#getSubscriptionDetails")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SystemApi#getSubscriptionDetails")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**GetSubscriptionDetailsResponse**](GetSubscriptionDetailsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getSubscriptionInvoices"></a>
# **getSubscriptionInvoices**
> GetSubscriptionInvoicesResponse getSubscriptionInvoices()

Subscription invoice history

Billing-history rows shown on the Settings → Billing page. Each row is one charge (monthly / annual / proration) with status, amount, PDF receipt URL, and the period it covered.  &#x60;status&#x60; values seen in production: &#x60;paid&#x60;, &#x60;pending&#x60;, &#x60;failed&#x60;, &#x60;refunded&#x60;. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SystemApi()
try {
    val result : GetSubscriptionInvoicesResponse = apiInstance.getSubscriptionInvoices()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SystemApi#getSubscriptionInvoices")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SystemApi#getSubscriptionInvoices")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**GetSubscriptionInvoicesResponse**](GetSubscriptionInvoicesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getSubscriptionReceipts"></a>
# **getSubscriptionReceipts**
> GetSubscriptionReceiptsResponse getSubscriptionReceipts()

Subscription payment receipts

All payment receipts for the current subscription, with download URLs. Used at tax time for proof of expense. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SystemApi()
try {
    val result : GetSubscriptionReceiptsResponse = apiInstance.getSubscriptionReceipts()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SystemApi#getSubscriptionReceipts")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SystemApi#getSubscriptionReceipts")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**GetSubscriptionReceiptsResponse**](GetSubscriptionReceiptsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getTagReport"></a>
# **getTagReport**
> GetTagReportResponse getTagReport(tagId, start, end)

Per-tag historical report

Per-month series for one transaction tag across a window. Backs the \&quot;view tag\&quot; drill-down in the web Reports tab. Each month carries both the sum amount and the transaction count, so callers can render either a spend chart or a frequency chart from one response. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SystemApi()
val tagId : kotlin.String = tagId_example // kotlin.String | Monarch tag id.
val start : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Lower bound (inclusive), `YYYY-MM-DD`.
val end : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Upper bound (inclusive), `YYYY-MM-DD`.
try {
    val result : GetTagReportResponse = apiInstance.getTagReport(tagId, start, end)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SystemApi#getTagReport")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SystemApi#getTagReport")
    e.printStackTrace()
}
```

### Parameters
| **tagId** | **kotlin.String**| Monarch tag id. | |
| **start** | **java.time.LocalDate**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **end** | **java.time.LocalDate**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |

### Return type

[**GetTagReportResponse**](GetTagReportResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getWeeklyRecap"></a>
# **getWeeklyRecap**
> GetWeeklyRecapResponse getWeeklyRecap(start, end)

Weekly recap

AI-generated narrative recap for one week. Monarch backfills this on a schedule. Pick &#x60;start&#x60; &#x3D; Monday, &#x60;end&#x60; &#x3D; Sunday of the target week. Returns &#x60;null&#x60; recap if Monarch has not generated one for that window yet.  Includes a top-level &#x60;summary&#x60; plus per-module &#x60;cards&#x60; (cashflow card, biggest spend, savings progress, etc.) with both rich-block JSON and markdown variants. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SystemApi()
val start : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Week start (inclusive), `YYYY-MM-DD`. Typically a Monday.
val end : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Week end (inclusive), `YYYY-MM-DD`. Typically a Sunday.
try {
    val result : GetWeeklyRecapResponse = apiInstance.getWeeklyRecap(start, end)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SystemApi#getWeeklyRecap")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SystemApi#getWeeklyRecap")
    e.printStackTrace()
}
```

### Parameters
| **start** | **java.time.LocalDate**| Week start (inclusive), &#x60;YYYY-MM-DD&#x60;. Typically a Monday. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **end** | **java.time.LocalDate**| Week end (inclusive), &#x60;YYYY-MM-DD&#x60;. Typically a Sunday. | |

### Return type

[**GetWeeklyRecapResponse**](GetWeeklyRecapResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getZestimate"></a>
# **getZestimate**
> GetZestimateResponse getZestimate(getZestimateRequest)

Zillow Zestimate lookup

Resolve a free-form street address to one or more Zillow &#x60;Zestimate&#x60; rows (Zillow property id + parsed address + dollar estimate). Used by the real-estate account creation flow to pre-fill home value.  Returns an empty array if Zillow has no match. A free-form address can return multiple Zestimates when the property has been split or Zillow has near-duplicate records. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SystemApi()
val getZestimateRequest : GetZestimateRequest =  // GetZestimateRequest | 
try {
    val result : GetZestimateResponse = apiInstance.getZestimate(getZestimateRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SystemApi#getZestimate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SystemApi#getZestimate")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **getZestimateRequest** | [**GetZestimateRequest**](GetZestimateRequest.md)|  | |

### Return type

[**GetZestimateResponse**](GetZestimateResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="initiatePasswordChange"></a>
# **initiatePasswordChange**
> InitiatePasswordChangeResponse initiatePasswordChange()

Initiate password change

Trigger Monarch&#39;s password-change flow. No body required. Monarch emails a reset link to the account&#39;s verified email; the response echoes back the &#x60;requestId&#x60; + &#x60;email&#x60; for client-side confirmation. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SystemApi()
try {
    val result : InitiatePasswordChangeResponse = apiInstance.initiatePasswordChange()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SystemApi#initiatePasswordChange")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SystemApi#initiatePasswordChange")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**InitiatePasswordChangeResponse**](InitiatePasswordChangeResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="listFinancialInsights"></a>
# **listFinancialInsights**
> ListFinancialInsightsResponse listFinancialInsights(status, summaryStart, summaryEnd)

List AI savings insights

Monarch&#39;s AI-driven money-saving opportunities (subscription audits, bill negotiation candidates, etc.). Each insight has a savings estimate range, effort tag, and current annual cost. Filter by status (e.g. &#x60;NEW&#x60;, &#x60;ACCEPTED&#x60;).  Also returns an aggregate &#x60;summary&#x60; over the window (counts + identified savings totals) and the &#x60;latestRun&#x60; metadata to gauge freshness. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SystemApi()
val status : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | Filter to one or more `InsightStatusEnum` values. Repeat the param for each.
val summaryStart : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Lower bound for the `summary` aggregate window.
val summaryEnd : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Upper bound for the `summary` aggregate window.
try {
    val result : ListFinancialInsightsResponse = apiInstance.listFinancialInsights(status, summaryStart, summaryEnd)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SystemApi#listFinancialInsights")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SystemApi#listFinancialInsights")
    e.printStackTrace()
}
```

### Parameters
| **status** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| Filter to one or more &#x60;InsightStatusEnum&#x60; values. Repeat the param for each. | [optional] |
| **summaryStart** | **java.time.LocalDate**| Lower bound for the &#x60;summary&#x60; aggregate window. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **summaryEnd** | **java.time.LocalDate**| Upper bound for the &#x60;summary&#x60; aggregate window. | [optional] |

### Return type

[**ListFinancialInsightsResponse**](ListFinancialInsightsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="markAllNotificationsAsRead"></a>
# **markAllNotificationsAsRead**
> MarkAllNotificationsAsReadResponse markAllNotificationsAsRead(first)

Mark all notifications as read

Bulk-flip &#x60;readAt&#x60; for every activity event in the bell. Echoes back the first page of events (so the client can refresh state without a second round-trip). 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SystemApi()
val first : kotlin.Int = 56 // kotlin.Int | Page size for the echoed event list.
try {
    val result : MarkAllNotificationsAsReadResponse = apiInstance.markAllNotificationsAsRead(first)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SystemApi#markAllNotificationsAsRead")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SystemApi#markAllNotificationsAsRead")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **first** | **kotlin.Int**| Page size for the echoed event list. | [optional] [default to 20] |

### Return type

[**MarkAllNotificationsAsReadResponse**](MarkAllNotificationsAsReadResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="markNotificationAsRead"></a>
# **markNotificationAsRead**
> MarkNotificationAsReadResponse markNotificationAsRead(id)

Mark one notification as read

Flip a single activity event&#39;s &#x60;readAt&#x60; to now. Used by the bell UI when an event is opened or clicked. Idempotent. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SystemApi()
val id : kotlin.String = id_example // kotlin.String | Monarch activity-event id.
try {
    val result : MarkNotificationAsReadResponse = apiInstance.markNotificationAsRead(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SystemApi#markNotificationAsRead")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SystemApi#markNotificationAsRead")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **kotlin.String**| Monarch activity-event id. | |

### Return type

[**MarkNotificationAsReadResponse**](MarkNotificationAsReadResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="pauseSubscription"></a>
# **pauseSubscription**
> PauseSubscriptionResponse pauseSubscription(pauseSubscriptionRequest)

Pause the subscription

Suspends billing without canceling. Provide &#x60;resumeAt&#x60; to auto-resume on a date; omit for indefinite pause. Read-only data access remains during a pause. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SystemApi()
val pauseSubscriptionRequest : PauseSubscriptionRequest =  // PauseSubscriptionRequest | 
try {
    val result : PauseSubscriptionResponse = apiInstance.pauseSubscription(pauseSubscriptionRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SystemApi#pauseSubscription")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SystemApi#pauseSubscription")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **pauseSubscriptionRequest** | [**PauseSubscriptionRequest**](PauseSubscriptionRequest.md)|  | [optional] |

### Return type

[**PauseSubscriptionResponse**](PauseSubscriptionResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="previewSubscriptionPlanChange"></a>
# **previewSubscriptionPlanChange**
> PreviewSubscriptionPlanChangeResponse previewSubscriptionPlanChange(previewSubscriptionPlanChangeRequest)

Preview a plan-change charge

Computes the prorated charge for switching to &#x60;targetTier&#x60; (and optionally &#x60;billingFrequency&#x60;). Does NOT mutate the subscription. Use to show \&quot;you will be charged USD X today\&quot; before the user confirms. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SystemApi()
val previewSubscriptionPlanChangeRequest : PreviewSubscriptionPlanChangeRequest =  // PreviewSubscriptionPlanChangeRequest | 
try {
    val result : PreviewSubscriptionPlanChangeResponse = apiInstance.previewSubscriptionPlanChange(previewSubscriptionPlanChangeRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SystemApi#previewSubscriptionPlanChange")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SystemApi#previewSubscriptionPlanChange")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **previewSubscriptionPlanChangeRequest** | [**PreviewSubscriptionPlanChangeRequest**](PreviewSubscriptionPlanChangeRequest.md)|  | |

### Return type

[**PreviewSubscriptionPlanChangeResponse**](PreviewSubscriptionPlanChangeResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="refreshAuth"></a>
# **refreshAuth**
> GetAuthStatusResponse refreshAuth()

Reload session JSON from disk

Re-reads &#x60;~/.config/monarch-bridge/.mm-session.json&#x60; and swaps in the new token without a service restart.  Use after running the bootstrap CLI&#39;s re-auth flow (&#x60;mb auth login&#x60;) to pick up freshly-issued credentials. Cheap call: just hits the local filesystem and updates an in-memory atomic reference. Returns the post-reload auth status so the caller knows immediately whether the new session is loaded. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SystemApi()
try {
    val result : GetAuthStatusResponse = apiInstance.refreshAuth()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SystemApi#refreshAuth")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SystemApi#refreshAuth")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**GetAuthStatusResponse**](GetAuthStatusResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="requestRefresh"></a>
# **requestRefresh**
> requestRefresh(accountIds)

Force Monarch to re-poll Plaid (async)

Triggers Monarch to re-poll Plaid for account balance and transaction updates. Fire-and-forget: returns 202 immediately after queueing the refresh.  Without &#x60;accountIds&#x60;, refreshes **every** linked account. Pass one or more &#x60;accountIds&#x60; to scope. Poll progress with &#x60;GET /v1/refresh/status&#x60; until &#x60;data.allComplete&#x60; is true (5-60s typically depending on institution).  For a synchronous version that blocks until done, use &#x60;POST /v1/refresh/wait&#x60;. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SystemApi()
val accountIds : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | Optional list of Monarch account ids. Omit to refresh all accounts.
try {
    apiInstance.requestRefresh(accountIds)
} catch (e: ClientException) {
    println("4xx response calling SystemApi#requestRefresh")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SystemApi#requestRefresh")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accountIds** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| Optional list of Monarch account ids. Omit to refresh all accounts. | [optional] |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="requestRefreshAndWait"></a>
# **requestRefreshAndWait**
> GetRefreshStatusResponse requestRefreshAndWait(timeoutSeconds, accountIds)

Force Monarch to re-poll Plaid and wait until every account has finished

Synchronous version of &#x60;POST /v1/refresh&#x60; + polling &#x60;GET /v1/refresh/status&#x60;. Fires the refresh and blocks until every account reports &#x60;hasSyncInProgress: false&#x60; or the timeout elapses (default 60s, max 300s; cap via &#x60;timeoutSeconds&#x60;). Without &#x60;accountIds&#x60;, refreshes **every** linked account. Pass one or more &#x60;accountIds&#x60; to scope the refresh. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SystemApi()
val timeoutSeconds : kotlin.Int = 56 // kotlin.Int | Max time to poll before returning the last-seen status.
val accountIds : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | Optional list of Monarch account ids. Omit to refresh all accounts.
try {
    val result : GetRefreshStatusResponse = apiInstance.requestRefreshAndWait(timeoutSeconds, accountIds)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SystemApi#requestRefreshAndWait")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SystemApi#requestRefreshAndWait")
    e.printStackTrace()
}
```

### Parameters
| **timeoutSeconds** | **kotlin.Int**| Max time to poll before returning the last-seen status. | [optional] [default to 60] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accountIds** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| Optional list of Monarch account ids. Omit to refresh all accounts. | [optional] |

### Return type

[**GetRefreshStatusResponse**](GetRefreshStatusResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="resumeSubscription"></a>
# **resumeSubscription**
> ResumeSubscriptionResponse resumeSubscription()

Resume a paused subscription

Lifts a pause and resumes billing immediately. No-op if the subscription is already active. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = SystemApi()
try {
    val result : ResumeSubscriptionResponse = apiInstance.resumeSubscription()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SystemApi#resumeSubscription")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SystemApi#resumeSubscription")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ResumeSubscriptionResponse**](ResumeSubscriptionResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

