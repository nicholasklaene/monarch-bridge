# GoalsApi

All URIs are relative to *http://localhost:9084*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**archiveGoal**](GoalsApi.md#archiveGoal) | **DELETE** /v1/goals/{id} | Archive a savings goal |
| [**contributeToGoal**](GoalsApi.md#contributeToGoal) | **POST** /v1/goals/{id}/contributions | Record a contribution to a savings goal |
| [**createGoal**](GoalsApi.md#createGoal) | **POST** /v1/goals | Create a new savings or debt-payoff goal |
| [**deleteGoalV2**](GoalsApi.md#deleteGoalV2) | **DELETE** /v1/goals/{id}/v2-delete | Delete a goal (v2 mutation) |
| [**getGoal**](GoalsApi.md#getGoal) | **GET** /v1/goals/{id} | Get one savings goal |
| [**getGoalContributionHistory**](GoalsApi.md#getGoalContributionHistory) | **GET** /v1/goals/{id}/contribution-history | Goal contribution history |
| [**getGoalProjection**](GoalsApi.md#getGoalProjection) | **GET** /v1/goals/{id}/projection | Goal projection chart |
| [**getGoalsCurrentMonthTotals**](GoalsApi.md#getGoalsCurrentMonthTotals) | **GET** /v1/goals/totals/current-month | Current-month planned-contribution totals per goal |
| [**hardDeleteGoal**](GoalsApi.md#hardDeleteGoal) | **DELETE** /v1/goals/{id}/hard | Hard-delete a savings goal |
| [**linkTransactionToGoal**](GoalsApi.md#linkTransactionToGoal) | **POST** /v1/transactions/{id}/goal-link | Link a transaction to a savings goal |
| [**listGoalEvents**](GoalsApi.md#listGoalEvents) | **GET** /v1/goals/{id}/events | Event log for one savings goal |
| [**listGoals**](GoalsApi.md#listGoals) | **GET** /v1/goals | List all savings goals |
| [**markGoalComplete**](GoalsApi.md#markGoalComplete) | **POST** /v1/goals/{id}/complete | Mark a goal complete |
| [**markGoalIncomplete**](GoalsApi.md#markGoalIncomplete) | **POST** /v1/goals/{id}/incomplete | Mark a goal incomplete |
| [**setGoalBudgetAmount**](GoalsApi.md#setGoalBudgetAmount) | **PUT** /v1/goals/{id}/budget | Set monthly budget allocation for a savings goal |
| [**spendFromGoal**](GoalsApi.md#spendFromGoal) | **POST** /v1/goals/{id}/spend | Spend from a savings goal |
| [**unarchiveGoal**](GoalsApi.md#unarchiveGoal) | **POST** /v1/goals/{id}/unarchive | Un-archive a savings goal |
| [**unlinkTransactionGoalRecords**](GoalsApi.md#unlinkTransactionGoalRecords) | **DELETE** /v1/transactions/{id}/goal-link | Unlink any goal-reconciliation records for a transaction |
| [**updateGoal**](GoalsApi.md#updateGoal) | **PATCH** /v1/goals/{id} | Update a savings goal |
| [**updateGoalsPriorities**](GoalsApi.md#updateGoalsPriorities) | **PUT** /v1/goals/priorities | Re-order savings goals by priority |
| [**withdrawFromGoal**](GoalsApi.md#withdrawFromGoal) | **POST** /v1/goals/{id}/withdraw | Withdraw from a savings goal |


<a id="archiveGoal"></a>
# **archiveGoal**
> CreateGoalResponse archiveGoal(id)

Archive a savings goal

**Soft-deletes** the goal by setting its &#x60;archivedAt&#x60; timestamp. The goal remains visible via &#x60;GET /v1/goals&#x60; (filter on &#x60;archivedAt&#x60; to hide) but its &#x60;status&#x60; flips to &#x60;archived&#x60; and it drops out of active-goal aggregates.  Reversible via &#x60;POST /v1/goals/{id}/unarchive&#x60;. For permanent removal use &#x60;DELETE /v1/goals/{id}/hard&#x60; instead. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = GoalsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch savings-goal id.
try {
    val result : CreateGoalResponse = apiInstance.archiveGoal(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GoalsApi#archiveGoal")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GoalsApi#archiveGoal")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **kotlin.String**| Monarch savings-goal id. | |

### Return type

[**CreateGoalResponse**](CreateGoalResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="contributeToGoal"></a>
# **contributeToGoal**
> ContributeToGoalResponse contributeToGoal(id, contributeToGoalRequest)

Record a contribution to a savings goal

Logs a contribution event against a goal from a specific account. Required: &#x60;accountId&#x60; and &#x60;amount&#x60; (in dollars, positive for a contribution, negative for a withdrawal). &#x60;date&#x60; defaults to today if omitted.  Use after a manual transfer the user wants attributed to the goal, or to backfill historical progress. Updates the goal&#39;s &#x60;currentAmount&#x60; and appends to its event log (visible via &#x60;GET /v1/goals/{id}/events&#x60;).  Distinct from &#x60;PUT /v1/goals/{id}/budget&#x60; which sets the planned monthly contribution (forecast) rather than logging an actual one. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = GoalsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch savings-goal id.
val contributeToGoalRequest : ContributeToGoalRequest =  // ContributeToGoalRequest | 
try {
    val result : ContributeToGoalResponse = apiInstance.contributeToGoal(id, contributeToGoalRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GoalsApi#contributeToGoal")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GoalsApi#contributeToGoal")
    e.printStackTrace()
}
```

### Parameters
| **id** | **kotlin.String**| Monarch savings-goal id. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **contributeToGoalRequest** | [**ContributeToGoalRequest**](ContributeToGoalRequest.md)|  | |

### Return type

[**ContributeToGoalResponse**](ContributeToGoalResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="createGoal"></a>
# **createGoal**
> CreateGoalResponse createGoal(createGoalRequest)

Create a new savings or debt-payoff goal

Creates one savings goal. Wraps Monarch&#39;s &#x60;createSavingsGoals&#x60; batch mutation with a single-goal body for ergonomics.  Required: &#x60;name&#x60; and &#x60;targetAmount&#x60;. Optional: &#x60;targetDate&#x60;, &#x60;imageStorageProvider&#x60;/&#x60;imageStorageProviderId&#x60; for an icon, &#x60;accounts&#x60; to pre-link funding accounts. &#x60;type&#x60; defaults to &#x60;\&quot;savings\&quot;&#x60;; pass &#x60;\&quot;debt\&quot;&#x60; for a debt-payoff goal (sign convention flips: progress &#x3D; paying it DOWN).  Once created, set up monthly contributions via &#x60;PUT /v1/goals/{id}/budget&#x60; and log actuals via &#x60;POST /v1/goals/{id}/contributions&#x60;. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = GoalsApi()
val createGoalRequest : CreateGoalRequest =  // CreateGoalRequest | 
try {
    val result : CreateGoalResponse = apiInstance.createGoal(createGoalRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GoalsApi#createGoal")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GoalsApi#createGoal")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **createGoalRequest** | [**CreateGoalRequest**](CreateGoalRequest.md)|  | |

### Return type

[**CreateGoalResponse**](CreateGoalResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="deleteGoalV2"></a>
# **deleteGoalV2**
> MarkTransactionStreamAsNotRecurringResponse deleteGoalV2(id)

Delete a goal (v2 mutation)

Permanently delete a savings goal via the v2 &#x60;deleteGoalV2&#x60; mutation. Distinct from &#x60;DELETE /v1/goals/{id}/hard&#x60; (which uses the legacy &#x60;deleteSavingsGoal&#x60; path); the v2 path is preferred for goals created through the v2 flow.  Returns a flat &#x60;success&#x60; boolean and any payload errors. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = GoalsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch savings-goal id.
try {
    val result : MarkTransactionStreamAsNotRecurringResponse = apiInstance.deleteGoalV2(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GoalsApi#deleteGoalV2")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GoalsApi#deleteGoalV2")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **kotlin.String**| Monarch savings-goal id. | |

### Return type

[**MarkTransactionStreamAsNotRecurringResponse**](MarkTransactionStreamAsNotRecurringResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getGoal"></a>
# **getGoal**
> CreateGoalResponse getGoal(id)

Get one savings goal

Returns the full detail for a single v2 savings goal: name, target amount, current balance, target date, type (savings or debt), priority, linked accounts, and archive state.  Use to surface a goal in a detail view or to inspect state before a PATCH or contribution. For the contribution / withdrawal event log use &#x60;GET /v1/goals/{id}/events&#x60;. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = GoalsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch savings-goal id.
try {
    val result : CreateGoalResponse = apiInstance.getGoal(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GoalsApi#getGoal")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GoalsApi#getGoal")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **kotlin.String**| Monarch savings-goal id. | |

### Return type

[**CreateGoalResponse**](CreateGoalResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getGoalContributionHistory"></a>
# **getGoalContributionHistory**
> GetGoalContributionHistoryResponse getGoalContributionHistory(id)

Goal contribution history

Ledger of contributions logged against one goal: date, amount, source account, optional notes. Distinct from &#x60;/v1/goals/{id}/events&#x60; which includes auto-linked transactions too; this endpoint returns only explicit contributions. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = GoalsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch savings-goal id.
try {
    val result : GetGoalContributionHistoryResponse = apiInstance.getGoalContributionHistory(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GoalsApi#getGoalContributionHistory")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GoalsApi#getGoalContributionHistory")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **kotlin.String**| Monarch savings-goal id. | |

### Return type

[**GetGoalContributionHistoryResponse**](GetGoalContributionHistoryResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getGoalProjection"></a>
# **getGoalProjection**
> GetGoalProjectionResponse getGoalProjection(id)

Goal projection chart

Forward projection of a goal&#39;s balance at the current planned contribution rate. Returns the projected completion date, months to target, and a per-month projected-balance series. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = GoalsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch savings-goal id.
try {
    val result : GetGoalProjectionResponse = apiInstance.getGoalProjection(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GoalsApi#getGoalProjection")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GoalsApi#getGoalProjection")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **kotlin.String**| Monarch savings-goal id. | |

### Return type

[**GetGoalProjectionResponse**](GetGoalProjectionResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getGoalsCurrentMonthTotals"></a>
# **getGoalsCurrentMonthTotals**
> GetGoalsCurrentMonthTotalsResponse getGoalsCurrentMonthTotals(startMonth, endMonth)

Current-month planned-contribution totals per goal

Returns the sum of &#x60;totalPlannedAmount&#x60; across the requested month window, broken out per goal. Used for \&quot;how much am I planning to contribute this month and to which goals\&quot; rollups without pulling each goal&#39;s full plan series.  Defaults to the current calendar month when both params are omitted (&#x60;startMonth &#x3D; first-of-this-month&#x60;, &#x60;endMonth &#x3D; first-of-this-month&#x60;). Pass a wider window to get a multi-month plan summary. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = GoalsApi()
val startMonth : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | First-of-month lower bound (`YYYY-MM-DD`).
val endMonth : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | First-of-month upper bound (`YYYY-MM-DD`).
try {
    val result : GetGoalsCurrentMonthTotalsResponse = apiInstance.getGoalsCurrentMonthTotals(startMonth, endMonth)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GoalsApi#getGoalsCurrentMonthTotals")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GoalsApi#getGoalsCurrentMonthTotals")
    e.printStackTrace()
}
```

### Parameters
| **startMonth** | **java.time.LocalDate**| First-of-month lower bound (&#x60;YYYY-MM-DD&#x60;). | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **endMonth** | **java.time.LocalDate**| First-of-month upper bound (&#x60;YYYY-MM-DD&#x60;). | [optional] |

### Return type

[**GetGoalsCurrentMonthTotalsResponse**](GetGoalsCurrentMonthTotalsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="hardDeleteGoal"></a>
# **hardDeleteGoal**
> HardDeleteGoalResponse hardDeleteGoal(id)

Hard-delete a savings goal

Permanently removes the goal. **No undo**. Distinct from &#x60;DELETE /v1/goals/{id}&#x60; (which archives / soft-deletes and is reversible via the unarchive endpoint).  After this call the goal disappears from &#x60;GET /v1/goals&#x60; entirely and its event log is no longer queryable. Use only when the user explicitly wants to purge a goal, not for routine cleanup. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = GoalsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch savings-goal id.
try {
    val result : HardDeleteGoalResponse = apiInstance.hardDeleteGoal(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GoalsApi#hardDeleteGoal")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GoalsApi#hardDeleteGoal")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **kotlin.String**| Monarch savings-goal id. | |

### Return type

[**HardDeleteGoalResponse**](HardDeleteGoalResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="linkTransactionToGoal"></a>
# **linkTransactionToGoal**
> LinkTransactionToGoalResponse linkTransactionToGoal(id, linkTransactionToGoalRequest)

Link a transaction to a savings goal

Create a goal-event that ties a single transaction to a goal. The transaction&#39;s &#x60;savingsGoalEvent&#x60; becomes non-null and the goal balance reconciliation picks it up. Used to credit a specific purchase (\&quot;plane tickets\&quot;) against the matching goal (\&quot;Vacation\&quot;).  Pair with &#x60;DELETE /v1/transactions/{id}/goal-link&#x60; to unlink. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = GoalsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch transaction id.
val linkTransactionToGoalRequest : LinkTransactionToGoalRequest =  // LinkTransactionToGoalRequest | 
try {
    val result : LinkTransactionToGoalResponse = apiInstance.linkTransactionToGoal(id, linkTransactionToGoalRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GoalsApi#linkTransactionToGoal")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GoalsApi#linkTransactionToGoal")
    e.printStackTrace()
}
```

### Parameters
| **id** | **kotlin.String**| Monarch transaction id. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **linkTransactionToGoalRequest** | [**LinkTransactionToGoalRequest**](LinkTransactionToGoalRequest.md)|  | |

### Return type

[**LinkTransactionToGoalResponse**](LinkTransactionToGoalResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="listGoalEvents"></a>
# **listGoalEvents**
> ListGoalEventsResponse listGoalEvents(id)

Event log for one savings goal

Returns the full event ledger for a single goal: every contribution, withdrawal, and transaction Monarch auto-linked to the goal. Each event has type, amount, date, account, and source transaction id (if any).  Use to surface a \&quot;history\&quot; tab on a goal detail view or to compute actual-vs-planned contribution totals over time. For a quick current-month rollup across all goals use &#x60;GET /v1/goals/current-month-totals&#x60;. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = GoalsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch savings-goal id.
try {
    val result : ListGoalEventsResponse = apiInstance.listGoalEvents(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GoalsApi#listGoalEvents")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GoalsApi#listGoalEvents")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **kotlin.String**| Monarch savings-goal id. | |

### Return type

[**ListGoalEventsResponse**](ListGoalEventsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="listGoals"></a>
# **listGoals**
> ListGoalsResponse listGoals()

List all savings goals

Returns every v2 savings goal: active, archived, hard-deleted-but- soft-still-visible, debt and savings types together. Each entry carries name, target amount, current progress, priority, linked accounts, and &#x60;archivedAt&#x60;.  Filter client-side on &#x60;archivedAt &#x3D;&#x3D; null&#x60; to hide archived. Sort on &#x60;priority&#x60; for the user&#39;s intended display order. For one goal&#39;s detail use &#x60;GET /v1/goals/{id}&#x60;; for the event log use &#x60;GET /v1/goals/{id}/events&#x60;. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = GoalsApi()
try {
    val result : ListGoalsResponse = apiInstance.listGoals()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GoalsApi#listGoals")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GoalsApi#listGoals")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ListGoalsResponse**](ListGoalsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="markGoalComplete"></a>
# **markGoalComplete**
> MarkGoalCompleteResponse markGoalComplete(id)

Mark a goal complete

Stamp a savings goal &#x60;completedAt&#x3D;now&#x60;. Surfaces a celebration in the UI and freezes the goal balance display. Idempotent - replays do not re-trigger the celebration.  Pair with &#x60;POST /v1/goals/{id}/incomplete&#x60; to un-mark a goal that was marked complete by mistake. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = GoalsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch savings-goal id.
try {
    val result : MarkGoalCompleteResponse = apiInstance.markGoalComplete(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GoalsApi#markGoalComplete")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GoalsApi#markGoalComplete")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **kotlin.String**| Monarch savings-goal id. | |

### Return type

[**MarkGoalCompleteResponse**](MarkGoalCompleteResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="markGoalIncomplete"></a>
# **markGoalIncomplete**
> MarkGoalCompleteResponse markGoalIncomplete(id)

Mark a goal incomplete

Clear a savings goal&#39;s &#x60;completedAt&#x60;, reverting it back to \&quot;in progress\&quot;. Used to undo a &#x60;POST /v1/goals/{id}/complete&#x60; performed in error. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = GoalsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch savings-goal id.
try {
    val result : MarkGoalCompleteResponse = apiInstance.markGoalIncomplete(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GoalsApi#markGoalIncomplete")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GoalsApi#markGoalIncomplete")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **kotlin.String**| Monarch savings-goal id. | |

### Return type

[**MarkGoalCompleteResponse**](MarkGoalCompleteResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="setGoalBudgetAmount"></a>
# **setGoalBudgetAmount**
> MarkTransactionStreamAsNotRecurringResponse setGoalBudgetAmount(id, setGoalBudgetAmountRequest)

Set monthly budget allocation for a savings goal

Sets the planned contribution amount for a goal for one month, or (with &#x60;applyToFuture: true&#x60;) cascades the same amount to every subsequent month. This is the FORECAST, not a recorded contribution: use &#x60;POST /v1/goals/{id}/contributions&#x60; to log actual money in.  Required: &#x60;startDate&#x60; (first-of-month) and &#x60;amount&#x60;. &#x60;accountId&#x60; is optional: omit to set the household-level planned amount; supply when the contribution comes from one specific account.  Pairs with &#x60;GET /v1/goals/current-month-totals&#x60; to read back the planned totals. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = GoalsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch savings-goal id.
val setGoalBudgetAmountRequest : SetGoalBudgetAmountRequest =  // SetGoalBudgetAmountRequest | 
try {
    val result : MarkTransactionStreamAsNotRecurringResponse = apiInstance.setGoalBudgetAmount(id, setGoalBudgetAmountRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GoalsApi#setGoalBudgetAmount")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GoalsApi#setGoalBudgetAmount")
    e.printStackTrace()
}
```

### Parameters
| **id** | **kotlin.String**| Monarch savings-goal id. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **setGoalBudgetAmountRequest** | [**SetGoalBudgetAmountRequest**](SetGoalBudgetAmountRequest.md)|  | |

### Return type

[**MarkTransactionStreamAsNotRecurringResponse**](MarkTransactionStreamAsNotRecurringResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="spendFromGoal"></a>
# **spendFromGoal**
> SpendFromGoalResponse spendFromGoal(id, spendFromGoalRequest)

Spend from a savings goal

Record a spend event against a savings goal - i.e. \&quot;I used some of my &#x60;Vacation&#x60; goal balance to pay for the flight\&quot;. Pair with &#x60;POST /v1/goals/{id}/contributions&#x60; (contributions) and &#x60;POST /v1/goals/{id}/withdraw&#x60; (withdrawals back to source account).  Returns the created goal-event id. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = GoalsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch savings-goal id.
val spendFromGoalRequest : SpendFromGoalRequest =  // SpendFromGoalRequest | 
try {
    val result : SpendFromGoalResponse = apiInstance.spendFromGoal(id, spendFromGoalRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GoalsApi#spendFromGoal")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GoalsApi#spendFromGoal")
    e.printStackTrace()
}
```

### Parameters
| **id** | **kotlin.String**| Monarch savings-goal id. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **spendFromGoalRequest** | [**SpendFromGoalRequest**](SpendFromGoalRequest.md)|  | |

### Return type

[**SpendFromGoalResponse**](SpendFromGoalResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="unarchiveGoal"></a>
# **unarchiveGoal**
> CreateGoalResponse unarchiveGoal(id)

Un-archive a savings goal

Restores a previously archived goal back to active state. Inverse of &#x60;DELETE /v1/goals/{id}&#x60;: clears the upstream &#x60;archivedAt&#x60; timestamp and flips &#x60;status&#x60; back to &#x60;active&#x60;.  Use when a user accidentally archived a goal or wants to revive an old one. No-op if the goal is already active. For permanent removal use &#x60;DELETE /v1/goals/{id}/hard&#x60; (no undo). 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = GoalsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch savings-goal id.
try {
    val result : CreateGoalResponse = apiInstance.unarchiveGoal(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GoalsApi#unarchiveGoal")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GoalsApi#unarchiveGoal")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **kotlin.String**| Monarch savings-goal id. | |

### Return type

[**CreateGoalResponse**](CreateGoalResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="unlinkTransactionGoalRecords"></a>
# **unlinkTransactionGoalRecords**
> MarkTransactionStreamAsNotRecurringResponse unlinkTransactionGoalRecords(id)

Unlink any goal-reconciliation records for a transaction

Drops all goal-reconciliation records for one transaction (the inverse of &#x60;POST /v1/transactions/{id}/goal-link&#x60;). The transaction stops being credited against any goal. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = GoalsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch transaction id.
try {
    val result : MarkTransactionStreamAsNotRecurringResponse = apiInstance.unlinkTransactionGoalRecords(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GoalsApi#unlinkTransactionGoalRecords")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GoalsApi#unlinkTransactionGoalRecords")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **kotlin.String**| Monarch transaction id. | |

### Return type

[**MarkTransactionStreamAsNotRecurringResponse**](MarkTransactionStreamAsNotRecurringResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="updateGoal"></a>
# **updateGoal**
> CreateGoalResponse updateGoal(id, updateGoalRequest)

Update a savings goal

Patches one goal. Only populated fields are forwarded to Monarch; omit a field to leave it untouched.  Common edits: rename, change &#x60;targetAmount&#x60; or &#x60;targetDate&#x60;, re-link &#x60;accounts&#x60;, update the icon. To re-order priority across goals use &#x60;PUT /v1/goals/priorities&#x60; instead. To archive use &#x60;DELETE /v1/goals/{id}&#x60; (reversible) or &#x60;DELETE /v1/goals/{id}/hard&#x60; (permanent). 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = GoalsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch savings-goal id.
val updateGoalRequest : UpdateGoalRequest =  // UpdateGoalRequest | 
try {
    val result : CreateGoalResponse = apiInstance.updateGoal(id, updateGoalRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GoalsApi#updateGoal")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GoalsApi#updateGoal")
    e.printStackTrace()
}
```

### Parameters
| **id** | **kotlin.String**| Monarch savings-goal id. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **updateGoalRequest** | [**UpdateGoalRequest**](UpdateGoalRequest.md)|  | |

### Return type

[**CreateGoalResponse**](CreateGoalResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="updateGoalsPriorities"></a>
# **updateGoalsPriorities**
> UpdateGoalsPrioritiesResponse updateGoalsPriorities(updateGoalsPrioritiesRequest)

Re-order savings goals by priority

Reorders goals by sending the full id list in the desired order. The proxy assigns &#x60;priority &#x3D; index&#x60; (0-based) to each id, then calls Monarch&#39;s batch priority mutation in one round-trip.  Send the COMPLETE goal id list, not a delta. Goals missing from the list keep their current priority but end up after all listed goals. Use after a drag-and-drop reorder in a goals UI. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = GoalsApi()
val updateGoalsPrioritiesRequest : UpdateGoalsPrioritiesRequest =  // UpdateGoalsPrioritiesRequest | 
try {
    val result : UpdateGoalsPrioritiesResponse = apiInstance.updateGoalsPriorities(updateGoalsPrioritiesRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GoalsApi#updateGoalsPriorities")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GoalsApi#updateGoalsPriorities")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **updateGoalsPrioritiesRequest** | [**UpdateGoalsPrioritiesRequest**](UpdateGoalsPrioritiesRequest.md)|  | |

### Return type

[**UpdateGoalsPrioritiesResponse**](UpdateGoalsPrioritiesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="withdrawFromGoal"></a>
# **withdrawFromGoal**
> WithdrawFromGoalResponse withdrawFromGoal(id, withdrawFromGoalRequest)

Withdraw from a savings goal

Withdraw money from a savings goal back into a source account. Reverses (in spirit) a prior contribution; the goal balance drops by &#x60;amount&#x60;, and Monarch updates the account&#39;s available-for-goals balance.  Pair with &#x60;POST /v1/goals/{id}/contributions&#x60; to deposit. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = GoalsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch savings-goal id.
val withdrawFromGoalRequest : WithdrawFromGoalRequest =  // WithdrawFromGoalRequest | 
try {
    val result : WithdrawFromGoalResponse = apiInstance.withdrawFromGoal(id, withdrawFromGoalRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GoalsApi#withdrawFromGoal")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GoalsApi#withdrawFromGoal")
    e.printStackTrace()
}
```

### Parameters
| **id** | **kotlin.String**| Monarch savings-goal id. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **withdrawFromGoalRequest** | [**WithdrawFromGoalRequest**](WithdrawFromGoalRequest.md)|  | |

### Return type

[**WithdrawFromGoalResponse**](WithdrawFromGoalResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

