# BudgetsApi

All URIs are relative to **

Method | HTTP request | Description
------------- | ------------- | -------------
[**getBudgetMonth**](BudgetsApi.md#getBudgetMonth) | **GET** /v1/budgets/month | Single-month budget data (slim), per-category amounts only
[**getBudgetStatus**](BudgetsApi.md#getBudgetStatus) | **GET** /v1/budgets/status | Budget status (initialized? has transactions?)
[**getBudgetTimeline**](BudgetsApi.md#getBudgetTimeline) | **GET** /v1/budgets/timeline | Multi-month budget vs. actual timeline
[**getBudgets**](BudgetsApi.md#getBudgets) | **GET** /v1/budgets | Monthly budget data + actuals
[**resetBudget**](BudgetsApi.md#resetBudget) | **POST** /v1/budgets/reset | Reset all planned amounts for one month back to defaults
[**setBudgetAmount**](BudgetsApi.md#setBudgetAmount) | **POST** /v1/budgets/items | Set the planned amount for one category OR category-group for a month
[**updateBudgetSettings**](BudgetsApi.md#updateBudgetSettings) | **PATCH** /v1/budgets/settings | Update household budget settings
[**updateFlexRolloverSettings**](BudgetsApi.md#updateFlexRolloverSettings) | **PUT** /v1/budgets/flex/rollover | Configure / reset the Flex bucket rollover period
[**updateFlexibleBudget**](BudgetsApi.md#updateFlexibleBudget) | **PUT** /v1/budgets/flex | Update the Flex bucket total for a month



## getBudgetMonth

Single-month budget data (slim), per-category amounts only

A trimmed Common_BudgetDataQuery: returns budget system + the
per-category monthly amounts for one month. Use for a per-category
plan/actual view without pulling the full GetBudgets tree.

### Example

```bash
monarch-api getBudgetMonth  month=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **month** | **string** | First-of-month date, e.g. '2026-05-01'. | [default to null]

### Return type

[**GetBudgetMonth200Response**](GetBudgetMonth200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getBudgetStatus

Budget status (initialized? has transactions?)

Cheap status check: has-budget, has-transactions, and a flag for
Monarch's empty-default-categories bootstrap path.

### Example

```bash
monarch-api getBudgetStatus
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**GetBudgetStatus200Response**](GetBudgetStatus200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getBudgetTimeline

Multi-month budget vs. actual timeline

Forward-looking budget vs. actual series for 'monthCount' months
starting at 'startMonth'. Backs the \"12-month timeline\" toggle on
the web Budgets tab.

Each month carries variance amount + percent so the UI can render
either an under / over indicator or a heatmap from one response.

### Example

```bash
monarch-api getBudgetTimeline  startMonth=value  monthCount=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **startMonth** | **string** | First month in the window, 'YYYY-MM-01'. | [default to null]
 **monthCount** | **integer** | Number of months to project; defaults to 12. | [optional] [default to 12]

### Return type

[**GetBudgetTimeline200Response**](GetBudgetTimeline200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getBudgets

Monthly budget data + actuals

Returns planned vs actual spend per category, per category-group, and
for the Flex bucket, broken out month-by-month within '[start, end]'.

Defaults to last-month through next-month when both 'start' and 'end'
are omitted (matches Monarch's web UI default). Pass an explicit window
for historical trend analysis.

Response includes 'budgetData' (the planned/actual matrix) plus the
full 'categoryGroups' tree so callers don't need a separate list call
to resolve names. For just the totals see 'GET /v1/cashflow'.

### Example

```bash
monarch-api getBudgets  start=value  end=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **string** | Lower bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]
 **end** | **string** | Upper bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]

### Return type

[**GetBudgets200Response**](GetBudgets200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## resetBudget

Reset all planned amounts for one month back to defaults

Clears every category and category-group budget line for the target
month and reverts to Monarch's auto-calculated defaults (typically
the trailing-3-month average of actuals).

**Destructive** for that month's plan. Use when a user wants to start
fresh for a new month and have Monarch re-suggest amounts based on
recent spend, instead of carrying over last month's plan.

Required: 'startDate' (first-of-month YYYY-MM-01). Operates on a
single month only; loop client-side to reset a range.

### Example

```bash
monarch-api resetBudget
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **resetBudgetRequest** | [**ResetBudgetRequest**](ResetBudgetRequest.md) |  |

### Return type

[**ResetBudget200Response**](ResetBudget200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## setBudgetAmount

Set the planned amount for one category OR category-group for a month

Writes a single budget cell: the planned spend for one category (or one
category group) for one month. Used to fill out the budget grid one
line item at a time.

Pass exactly one of 'categoryId' or 'categoryGroupId'. 'amount: 0'
clears the line. 'applyToFuture: true' cascades the same amount to
every subsequent month (useful for fixed line items like rent).

For wider edits use the dedicated Flex endpoints or
'POST /v1/budgets/reset' to wipe a month back to defaults.

### Example

```bash
monarch-api setBudgetAmount
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **setBudgetAmountRequest** | [**SetBudgetAmountRequest**](SetBudgetAmountRequest.md) |  |

### Return type

[**SetBudgetAmount200Response**](SetBudgetAmount200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## updateBudgetSettings

Update household budget settings

Change household-wide budget configuration: which budget system is
active ('category' vs 'category_group') and whether budget edits
cascade to future months by default.

### Example

```bash
monarch-api updateBudgetSettings
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **updateBudgetSettingsRequest** | [**UpdateBudgetSettingsRequest**](UpdateBudgetSettingsRequest.md) |  |

### Return type

[**UpdateBudgetSettings200Response**](UpdateBudgetSettings200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## updateFlexRolloverSettings

Configure / reset the Flex bucket rollover period

Sets how the Flex bucket's leftover (positive or negative) carries
forward month-to-month. 'rolloverStartMonth' anchors the rolling
window; 'rolloverStartingBalance' seeds the carryover dollar amount.

Common use: point 'rolloverStartMonth' at the current month with
'rolloverStartingBalance: 0' to clear accumulated negative rollover
(the classic \"I overspent for 6 months, wipe the slate\" reset).

Pair with 'PUT /v1/budgets/flex' to set the new monthly cap once
rollover is reset.

### Example

```bash
monarch-api updateFlexRolloverSettings
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **updateFlexRolloverSettingsRequest** | [**UpdateFlexRolloverSettingsRequest**](UpdateFlexRolloverSettingsRequest.md) |  |

### Return type

[**UpdateFlexRolloverSettings200Response**](UpdateFlexRolloverSettings200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## updateFlexibleBudget

Update the Flex bucket total for a month

Sets the household's total Flex-bucket budget for a single month.
Flex is Monarch's variable-spending pool (anything tagged as
flexible-variability) that's tracked as one combined cap rather than
per category.

Required: 'startDate' (first-of-month) and 'amount' in dollars. Pass
'applyToFuture: true' to cascade the new amount to every subsequent
month. To configure how Flex rolls over month-to-month use
'PUT /v1/budgets/flex-rollover' instead.

### Example

```bash
monarch-api updateFlexibleBudget
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **updateFlexibleBudgetRequest** | [**UpdateFlexibleBudgetRequest**](UpdateFlexibleBudgetRequest.md) |  |

### Return type

[**SetBudgetAmount200Response**](SetBudgetAmount200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

