# BudgetsApi

All URIs are relative to *http://localhost:9084*

|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|[**getBudgetMonth**](#getbudgetmonth) | **GET** /v1/budgets/month | Single-month budget data (slim), per-category amounts only|
|[**getBudgetStatus**](#getbudgetstatus) | **GET** /v1/budgets/status | Budget status (initialized? has transactions?)|
|[**getBudgetTimeline**](#getbudgettimeline) | **GET** /v1/budgets/timeline | Multi-month budget vs. actual timeline|
|[**getBudgets**](#getbudgets) | **GET** /v1/budgets | Monthly budget data + actuals|
|[**resetBudget**](#resetbudget) | **POST** /v1/budgets/reset | Reset all planned amounts for one month back to defaults|
|[**setBudgetAmount**](#setbudgetamount) | **POST** /v1/budgets/items | Set the planned amount for one category OR category-group for a month|
|[**updateBudgetSettings**](#updatebudgetsettings) | **PATCH** /v1/budgets/settings | Update household budget settings|
|[**updateFlexRolloverSettings**](#updateflexrolloversettings) | **PUT** /v1/budgets/flex/rollover | Configure / reset the Flex bucket rollover period|
|[**updateFlexibleBudget**](#updateflexiblebudget) | **PUT** /v1/budgets/flex | Update the Flex bucket total for a month|

# **getBudgetMonth**
> GetBudgetMonthResponse getBudgetMonth()

A trimmed Common_BudgetDataQuery: returns budget system + the per-category monthly amounts for one month. Use for a per-category plan/actual view without pulling the full GetBudgets tree. 

### Example

```typescript
import {
    BudgetsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new BudgetsApi(configuration);

let month: string; //First-of-month date, e.g. `2026-05-01`. (default to undefined)

const { status, data } = await apiInstance.getBudgetMonth(
    month
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **month** | [**string**] | First-of-month date, e.g. &#x60;2026-05-01&#x60;. | defaults to undefined|


### Return type

**GetBudgetMonthResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Single-month budget data. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getBudgetStatus**
> GetBudgetStatusResponse getBudgetStatus()

Cheap status check: has-budget, has-transactions, and a flag for Monarch\'s empty-default-categories bootstrap path. 

### Example

```typescript
import {
    BudgetsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new BudgetsApi(configuration);

const { status, data } = await apiInstance.getBudgetStatus();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**GetBudgetStatusResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Budget status flags. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getBudgetTimeline**
> GetBudgetTimelineResponse getBudgetTimeline()

Forward-looking budget vs. actual series for `monthCount` months starting at `startMonth`. Backs the \"12-month timeline\" toggle on the web Budgets tab.  Each month carries variance amount + percent so the UI can render either an under / over indicator or a heatmap from one response. 

### Example

```typescript
import {
    BudgetsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new BudgetsApi(configuration);

let startMonth: string; //First month in the window, `YYYY-MM-01`. (default to undefined)
let monthCount: number; //Number of months to project; defaults to 12. (optional) (default to 12)

const { status, data } = await apiInstance.getBudgetTimeline(
    startMonth,
    monthCount
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **startMonth** | [**string**] | First month in the window, &#x60;YYYY-MM-01&#x60;. | defaults to undefined|
| **monthCount** | [**number**] | Number of months to project; defaults to 12. | (optional) defaults to 12|


### Return type

**GetBudgetTimelineResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Per-month budget / actual / variance rows. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getBudgets**
> GetBudgetsResponse getBudgets()

Returns planned vs actual spend per category, per category-group, and for the Flex bucket, broken out month-by-month within `[start, end]`.  Defaults to last-month through next-month when both `start` and `end` are omitted (matches Monarch\'s web UI default). Pass an explicit window for historical trend analysis.  Response includes `budgetData` (the planned/actual matrix) plus the full `categoryGroups` tree so callers don\'t need a separate list call to resolve names. For just the totals see `GET /v1/cashflow`. 

### Example

```typescript
import {
    BudgetsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new BudgetsApi(configuration);

let start: string; //Lower bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)
let end: string; //Upper bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)

const { status, data } = await apiInstance.getBudgets(
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

**GetBudgetsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | budgetData (planned vs actual per category/group/flex/month) + categoryGroups. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **resetBudget**
> ResetBudgetResponse resetBudget(resetBudgetRequest)

Clears every category and category-group budget line for the target month and reverts to Monarch\'s auto-calculated defaults (typically the trailing-3-month average of actuals).  **Destructive** for that month\'s plan. Use when a user wants to start fresh for a new month and have Monarch re-suggest amounts based on recent spend, instead of carrying over last month\'s plan.  Required: `startDate` (first-of-month YYYY-MM-01). Operates on a single month only; loop client-side to reset a range. 

### Example

```typescript
import {
    BudgetsApi,
    Configuration,
    ResetBudgetRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new BudgetsApi(configuration);

let resetBudgetRequest: ResetBudgetRequest; //

const { status, data } = await apiInstance.resetBudget(
    resetBudgetRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **resetBudgetRequest** | **ResetBudgetRequest**|  | |


### Return type

**ResetBudgetResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Confirmation. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **setBudgetAmount**
> SetBudgetAmountResponse setBudgetAmount(setBudgetAmountRequest)

Writes a single budget cell: the planned spend for one category (or one category group) for one month. Used to fill out the budget grid one line item at a time.  Pass exactly one of `categoryId` or `categoryGroupId`. `amount: 0` clears the line. `applyToFuture: true` cascades the same amount to every subsequent month (useful for fixed line items like rent).  For wider edits use the dedicated Flex endpoints or `POST /v1/budgets/reset` to wipe a month back to defaults. 

### Example

```typescript
import {
    BudgetsApi,
    Configuration,
    SetBudgetAmountRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new BudgetsApi(configuration);

let setBudgetAmountRequest: SetBudgetAmountRequest; //

const { status, data } = await apiInstance.setBudgetAmount(
    setBudgetAmountRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **setBudgetAmountRequest** | **SetBudgetAmountRequest**|  | |


### Return type

**SetBudgetAmountResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Created/updated budget item. |  -  |
|**400** | Validation failed. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updateBudgetSettings**
> UpdateBudgetSettingsResponse updateBudgetSettings(updateBudgetSettingsRequest)

Change household-wide budget configuration: which budget system is active (`category` vs `category_group`) and whether budget edits cascade to future months by default. 

### Example

```typescript
import {
    BudgetsApi,
    Configuration,
    UpdateBudgetSettingsRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new BudgetsApi(configuration);

let updateBudgetSettingsRequest: UpdateBudgetSettingsRequest; //

const { status, data } = await apiInstance.updateBudgetSettings(
    updateBudgetSettingsRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **updateBudgetSettingsRequest** | **UpdateBudgetSettingsRequest**|  | |


### Return type

**UpdateBudgetSettingsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Effective budget settings after update. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updateFlexRolloverSettings**
> UpdateFlexRolloverSettingsResponse updateFlexRolloverSettings(updateFlexRolloverSettingsRequest)

Sets how the Flex bucket\'s leftover (positive or negative) carries forward month-to-month. `rolloverStartMonth` anchors the rolling window; `rolloverStartingBalance` seeds the carryover dollar amount.  Common use: point `rolloverStartMonth` at the current month with `rolloverStartingBalance: 0` to clear accumulated negative rollover (the classic \"I overspent for 6 months, wipe the slate\" reset).  Pair with `PUT /v1/budgets/flex` to set the new monthly cap once rollover is reset. 

### Example

```typescript
import {
    BudgetsApi,
    Configuration,
    UpdateFlexRolloverSettingsRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new BudgetsApi(configuration);

let updateFlexRolloverSettingsRequest: UpdateFlexRolloverSettingsRequest; //

const { status, data } = await apiInstance.updateFlexRolloverSettings(
    updateFlexRolloverSettingsRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **updateFlexRolloverSettingsRequest** | **UpdateFlexRolloverSettingsRequest**|  | |


### Return type

**UpdateFlexRolloverSettingsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | New rollover period. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updateFlexibleBudget**
> SetBudgetAmountResponse updateFlexibleBudget(updateFlexibleBudgetRequest)

Sets the household\'s total Flex-bucket budget for a single month. Flex is Monarch\'s variable-spending pool (anything tagged as flexible-variability) that\'s tracked as one combined cap rather than per category.  Required: `startDate` (first-of-month) and `amount` in dollars. Pass `applyToFuture: true` to cascade the new amount to every subsequent month. To configure how Flex rolls over month-to-month use `PUT /v1/budgets/flex-rollover` instead. 

### Example

```typescript
import {
    BudgetsApi,
    Configuration,
    UpdateFlexibleBudgetRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new BudgetsApi(configuration);

let updateFlexibleBudgetRequest: UpdateFlexibleBudgetRequest; //

const { status, data } = await apiInstance.updateFlexibleBudget(
    updateFlexibleBudgetRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **updateFlexibleBudgetRequest** | **UpdateFlexibleBudgetRequest**|  | |


### Return type

**SetBudgetAmountResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Updated flex item. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

