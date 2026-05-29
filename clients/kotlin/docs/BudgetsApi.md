# BudgetsApi

All URIs are relative to *http://localhost:9084*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**getBudgetMonth**](BudgetsApi.md#getBudgetMonth) | **GET** /v1/budgets/month | Single-month budget data (slim), per-category amounts only |
| [**getBudgetStatus**](BudgetsApi.md#getBudgetStatus) | **GET** /v1/budgets/status | Budget status (initialized? has transactions?) |
| [**getBudgetTimeline**](BudgetsApi.md#getBudgetTimeline) | **GET** /v1/budgets/timeline | Multi-month budget vs. actual timeline |
| [**getBudgets**](BudgetsApi.md#getBudgets) | **GET** /v1/budgets | Monthly budget data + actuals |
| [**resetBudget**](BudgetsApi.md#resetBudget) | **POST** /v1/budgets/reset | Reset all planned amounts for one month back to defaults |
| [**setBudgetAmount**](BudgetsApi.md#setBudgetAmount) | **POST** /v1/budgets/items | Set the planned amount for one category OR category-group for a month |
| [**updateBudgetSettings**](BudgetsApi.md#updateBudgetSettings) | **PATCH** /v1/budgets/settings | Update household budget settings |
| [**updateFlexRolloverSettings**](BudgetsApi.md#updateFlexRolloverSettings) | **PUT** /v1/budgets/flex/rollover | Configure / reset the Flex bucket rollover period |
| [**updateFlexibleBudget**](BudgetsApi.md#updateFlexibleBudget) | **PUT** /v1/budgets/flex | Update the Flex bucket total for a month |


<a id="getBudgetMonth"></a>
# **getBudgetMonth**
> GetBudgetMonthResponse getBudgetMonth(month)

Single-month budget data (slim), per-category amounts only

A trimmed Common_BudgetDataQuery: returns budget system + the per-category monthly amounts for one month. Use for a per-category plan/actual view without pulling the full GetBudgets tree. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = BudgetsApi()
val month : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | First-of-month date, e.g. `2026-05-01`.
try {
    val result : GetBudgetMonthResponse = apiInstance.getBudgetMonth(month)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BudgetsApi#getBudgetMonth")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BudgetsApi#getBudgetMonth")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **month** | **java.time.LocalDate**| First-of-month date, e.g. &#x60;2026-05-01&#x60;. | |

### Return type

[**GetBudgetMonthResponse**](GetBudgetMonthResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getBudgetStatus"></a>
# **getBudgetStatus**
> GetBudgetStatusResponse getBudgetStatus()

Budget status (initialized? has transactions?)

Cheap status check: has-budget, has-transactions, and a flag for Monarch&#39;s empty-default-categories bootstrap path. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = BudgetsApi()
try {
    val result : GetBudgetStatusResponse = apiInstance.getBudgetStatus()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BudgetsApi#getBudgetStatus")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BudgetsApi#getBudgetStatus")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**GetBudgetStatusResponse**](GetBudgetStatusResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getBudgetTimeline"></a>
# **getBudgetTimeline**
> GetBudgetTimelineResponse getBudgetTimeline(startMonth, monthCount)

Multi-month budget vs. actual timeline

Forward-looking budget vs. actual series for &#x60;monthCount&#x60; months starting at &#x60;startMonth&#x60;. Backs the \&quot;12-month timeline\&quot; toggle on the web Budgets tab.  Each month carries variance amount + percent so the UI can render either an under / over indicator or a heatmap from one response. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = BudgetsApi()
val startMonth : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | First month in the window, `YYYY-MM-01`.
val monthCount : kotlin.Int = 56 // kotlin.Int | Number of months to project; defaults to 12.
try {
    val result : GetBudgetTimelineResponse = apiInstance.getBudgetTimeline(startMonth, monthCount)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BudgetsApi#getBudgetTimeline")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BudgetsApi#getBudgetTimeline")
    e.printStackTrace()
}
```

### Parameters
| **startMonth** | **java.time.LocalDate**| First month in the window, &#x60;YYYY-MM-01&#x60;. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **monthCount** | **kotlin.Int**| Number of months to project; defaults to 12. | [optional] [default to 12] |

### Return type

[**GetBudgetTimelineResponse**](GetBudgetTimelineResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getBudgets"></a>
# **getBudgets**
> GetBudgetsResponse getBudgets(start, end)

Monthly budget data + actuals

Returns planned vs actual spend per category, per category-group, and for the Flex bucket, broken out month-by-month within &#x60;[start, end]&#x60;.  Defaults to last-month through next-month when both &#x60;start&#x60; and &#x60;end&#x60; are omitted (matches Monarch&#39;s web UI default). Pass an explicit window for historical trend analysis.  Response includes &#x60;budgetData&#x60; (the planned/actual matrix) plus the full &#x60;categoryGroups&#x60; tree so callers don&#39;t need a separate list call to resolve names. For just the totals see &#x60;GET /v1/cashflow&#x60;. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = BudgetsApi()
val start : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Lower bound (inclusive), `YYYY-MM-DD`.
val end : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Upper bound (inclusive), `YYYY-MM-DD`.
try {
    val result : GetBudgetsResponse = apiInstance.getBudgets(start, end)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BudgetsApi#getBudgets")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BudgetsApi#getBudgets")
    e.printStackTrace()
}
```

### Parameters
| **start** | **java.time.LocalDate**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **end** | **java.time.LocalDate**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |

### Return type

[**GetBudgetsResponse**](GetBudgetsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="resetBudget"></a>
# **resetBudget**
> ResetBudgetResponse resetBudget(resetBudgetRequest)

Reset all planned amounts for one month back to defaults

Clears every category and category-group budget line for the target month and reverts to Monarch&#39;s auto-calculated defaults (typically the trailing-3-month average of actuals).  **Destructive** for that month&#39;s plan. Use when a user wants to start fresh for a new month and have Monarch re-suggest amounts based on recent spend, instead of carrying over last month&#39;s plan.  Required: &#x60;startDate&#x60; (first-of-month YYYY-MM-01). Operates on a single month only; loop client-side to reset a range. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = BudgetsApi()
val resetBudgetRequest : ResetBudgetRequest =  // ResetBudgetRequest | 
try {
    val result : ResetBudgetResponse = apiInstance.resetBudget(resetBudgetRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BudgetsApi#resetBudget")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BudgetsApi#resetBudget")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **resetBudgetRequest** | [**ResetBudgetRequest**](ResetBudgetRequest.md)|  | |

### Return type

[**ResetBudgetResponse**](ResetBudgetResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="setBudgetAmount"></a>
# **setBudgetAmount**
> SetBudgetAmountResponse setBudgetAmount(setBudgetAmountRequest)

Set the planned amount for one category OR category-group for a month

Writes a single budget cell: the planned spend for one category (or one category group) for one month. Used to fill out the budget grid one line item at a time.  Pass exactly one of &#x60;categoryId&#x60; or &#x60;categoryGroupId&#x60;. &#x60;amount: 0&#x60; clears the line. &#x60;applyToFuture: true&#x60; cascades the same amount to every subsequent month (useful for fixed line items like rent).  For wider edits use the dedicated Flex endpoints or &#x60;POST /v1/budgets/reset&#x60; to wipe a month back to defaults. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = BudgetsApi()
val setBudgetAmountRequest : SetBudgetAmountRequest =  // SetBudgetAmountRequest | 
try {
    val result : SetBudgetAmountResponse = apiInstance.setBudgetAmount(setBudgetAmountRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BudgetsApi#setBudgetAmount")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BudgetsApi#setBudgetAmount")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **setBudgetAmountRequest** | [**SetBudgetAmountRequest**](SetBudgetAmountRequest.md)|  | |

### Return type

[**SetBudgetAmountResponse**](SetBudgetAmountResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="updateBudgetSettings"></a>
# **updateBudgetSettings**
> UpdateBudgetSettingsResponse updateBudgetSettings(updateBudgetSettingsRequest)

Update household budget settings

Change household-wide budget configuration: which budget system is active (&#x60;category&#x60; vs &#x60;category_group&#x60;) and whether budget edits cascade to future months by default. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = BudgetsApi()
val updateBudgetSettingsRequest : UpdateBudgetSettingsRequest =  // UpdateBudgetSettingsRequest | 
try {
    val result : UpdateBudgetSettingsResponse = apiInstance.updateBudgetSettings(updateBudgetSettingsRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BudgetsApi#updateBudgetSettings")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BudgetsApi#updateBudgetSettings")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **updateBudgetSettingsRequest** | [**UpdateBudgetSettingsRequest**](UpdateBudgetSettingsRequest.md)|  | |

### Return type

[**UpdateBudgetSettingsResponse**](UpdateBudgetSettingsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="updateFlexRolloverSettings"></a>
# **updateFlexRolloverSettings**
> UpdateFlexRolloverSettingsResponse updateFlexRolloverSettings(updateFlexRolloverSettingsRequest)

Configure / reset the Flex bucket rollover period

Sets how the Flex bucket&#39;s leftover (positive or negative) carries forward month-to-month. &#x60;rolloverStartMonth&#x60; anchors the rolling window; &#x60;rolloverStartingBalance&#x60; seeds the carryover dollar amount.  Common use: point &#x60;rolloverStartMonth&#x60; at the current month with &#x60;rolloverStartingBalance: 0&#x60; to clear accumulated negative rollover (the classic \&quot;I overspent for 6 months, wipe the slate\&quot; reset).  Pair with &#x60;PUT /v1/budgets/flex&#x60; to set the new monthly cap once rollover is reset. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = BudgetsApi()
val updateFlexRolloverSettingsRequest : UpdateFlexRolloverSettingsRequest =  // UpdateFlexRolloverSettingsRequest | 
try {
    val result : UpdateFlexRolloverSettingsResponse = apiInstance.updateFlexRolloverSettings(updateFlexRolloverSettingsRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BudgetsApi#updateFlexRolloverSettings")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BudgetsApi#updateFlexRolloverSettings")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **updateFlexRolloverSettingsRequest** | [**UpdateFlexRolloverSettingsRequest**](UpdateFlexRolloverSettingsRequest.md)|  | |

### Return type

[**UpdateFlexRolloverSettingsResponse**](UpdateFlexRolloverSettingsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="updateFlexibleBudget"></a>
# **updateFlexibleBudget**
> SetBudgetAmountResponse updateFlexibleBudget(updateFlexibleBudgetRequest)

Update the Flex bucket total for a month

Sets the household&#39;s total Flex-bucket budget for a single month. Flex is Monarch&#39;s variable-spending pool (anything tagged as flexible-variability) that&#39;s tracked as one combined cap rather than per category.  Required: &#x60;startDate&#x60; (first-of-month) and &#x60;amount&#x60; in dollars. Pass &#x60;applyToFuture: true&#x60; to cascade the new amount to every subsequent month. To configure how Flex rolls over month-to-month use &#x60;PUT /v1/budgets/flex-rollover&#x60; instead. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = BudgetsApi()
val updateFlexibleBudgetRequest : UpdateFlexibleBudgetRequest =  // UpdateFlexibleBudgetRequest | 
try {
    val result : SetBudgetAmountResponse = apiInstance.updateFlexibleBudget(updateFlexibleBudgetRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BudgetsApi#updateFlexibleBudget")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BudgetsApi#updateFlexibleBudget")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **updateFlexibleBudgetRequest** | [**UpdateFlexibleBudgetRequest**](UpdateFlexibleBudgetRequest.md)|  | |

### Return type

[**SetBudgetAmountResponse**](SetBudgetAmountResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

