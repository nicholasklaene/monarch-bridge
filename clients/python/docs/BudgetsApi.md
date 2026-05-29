# monarch_bridge_client.BudgetsApi

All URIs are relative to *http://localhost:9084*

Method | HTTP request | Description
------------- | ------------- | -------------
[**get_budget_month**](BudgetsApi.md#get_budget_month) | **GET** /v1/budgets/month | Single-month budget data (slim), per-category amounts only
[**get_budget_status**](BudgetsApi.md#get_budget_status) | **GET** /v1/budgets/status | Budget status (initialized? has transactions?)
[**get_budget_timeline**](BudgetsApi.md#get_budget_timeline) | **GET** /v1/budgets/timeline | Multi-month budget vs. actual timeline
[**get_budgets**](BudgetsApi.md#get_budgets) | **GET** /v1/budgets | Monthly budget data + actuals
[**reset_budget**](BudgetsApi.md#reset_budget) | **POST** /v1/budgets/reset | Reset all planned amounts for one month back to defaults
[**set_budget_amount**](BudgetsApi.md#set_budget_amount) | **POST** /v1/budgets/items | Set the planned amount for one category OR category-group for a month
[**update_budget_settings**](BudgetsApi.md#update_budget_settings) | **PATCH** /v1/budgets/settings | Update household budget settings
[**update_flex_rollover_settings**](BudgetsApi.md#update_flex_rollover_settings) | **PUT** /v1/budgets/flex/rollover | Configure / reset the Flex bucket rollover period
[**update_flexible_budget**](BudgetsApi.md#update_flexible_budget) | **PUT** /v1/budgets/flex | Update the Flex bucket total for a month


# **get_budget_month**
> GetBudgetMonthResponse get_budget_month(month)

Single-month budget data (slim), per-category amounts only

A trimmed Common_BudgetDataQuery: returns budget system + the
per-category monthly amounts for one month. Use for a per-category
plan/actual view without pulling the full GetBudgets tree.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_budget_month_response import GetBudgetMonthResponse
from monarch_bridge_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:9084
# See configuration.py for a list of all supported configuration parameters.
configuration = monarch_bridge_client.Configuration(
    host = "http://localhost:9084"
)


# Enter a context with an instance of the API client
with monarch_bridge_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = monarch_bridge_client.BudgetsApi(api_client)
    month = '2013-10-20' # date | First-of-month date, e.g. `2026-05-01`.

    try:
        # Single-month budget data (slim), per-category amounts only
        api_response = api_instance.get_budget_month(month)
        print("The response of BudgetsApi->get_budget_month:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BudgetsApi->get_budget_month: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **month** | **date**| First-of-month date, e.g. &#x60;2026-05-01&#x60;. | 

### Return type

[**GetBudgetMonthResponse**](GetBudgetMonthResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Single-month budget data. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_budget_status**
> GetBudgetStatusResponse get_budget_status()

Budget status (initialized? has transactions?)

Cheap status check: has-budget, has-transactions, and a flag for
Monarch's empty-default-categories bootstrap path.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_budget_status_response import GetBudgetStatusResponse
from monarch_bridge_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:9084
# See configuration.py for a list of all supported configuration parameters.
configuration = monarch_bridge_client.Configuration(
    host = "http://localhost:9084"
)


# Enter a context with an instance of the API client
with monarch_bridge_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = monarch_bridge_client.BudgetsApi(api_client)

    try:
        # Budget status (initialized? has transactions?)
        api_response = api_instance.get_budget_status()
        print("The response of BudgetsApi->get_budget_status:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BudgetsApi->get_budget_status: %s\n" % e)
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

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Budget status flags. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_budget_timeline**
> GetBudgetTimelineResponse get_budget_timeline(start_month, month_count=month_count)

Multi-month budget vs. actual timeline

Forward-looking budget vs. actual series for `monthCount` months
starting at `startMonth`. Backs the "12-month timeline" toggle on
the web Budgets tab.

Each month carries variance amount + percent so the UI can render
either an under / over indicator or a heatmap from one response.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_budget_timeline_response import GetBudgetTimelineResponse
from monarch_bridge_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:9084
# See configuration.py for a list of all supported configuration parameters.
configuration = monarch_bridge_client.Configuration(
    host = "http://localhost:9084"
)


# Enter a context with an instance of the API client
with monarch_bridge_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = monarch_bridge_client.BudgetsApi(api_client)
    start_month = '2013-10-20' # date | First month in the window, `YYYY-MM-01`.
    month_count = 12 # int | Number of months to project; defaults to 12. (optional) (default to 12)

    try:
        # Multi-month budget vs. actual timeline
        api_response = api_instance.get_budget_timeline(start_month, month_count=month_count)
        print("The response of BudgetsApi->get_budget_timeline:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BudgetsApi->get_budget_timeline: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start_month** | **date**| First month in the window, &#x60;YYYY-MM-01&#x60;. | 
 **month_count** | **int**| Number of months to project; defaults to 12. | [optional] [default to 12]

### Return type

[**GetBudgetTimelineResponse**](GetBudgetTimelineResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Per-month budget / actual / variance rows. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_budgets**
> GetBudgetsResponse get_budgets(start=start, end=end)

Monthly budget data + actuals

Returns planned vs actual spend per category, per category-group, and
for the Flex bucket, broken out month-by-month within `[start, end]`.

Defaults to last-month through next-month when both `start` and `end`
are omitted (matches Monarch's web UI default). Pass an explicit window
for historical trend analysis.

Response includes `budgetData` (the planned/actual matrix) plus the
full `categoryGroups` tree so callers don't need a separate list call
to resolve names. For just the totals see `GET /v1/cashflow`.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_budgets_response import GetBudgetsResponse
from monarch_bridge_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:9084
# See configuration.py for a list of all supported configuration parameters.
configuration = monarch_bridge_client.Configuration(
    host = "http://localhost:9084"
)


# Enter a context with an instance of the API client
with monarch_bridge_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = monarch_bridge_client.BudgetsApi(api_client)
    start = '2013-10-20' # date | Lower bound (inclusive), `YYYY-MM-DD`. (optional)
    end = '2013-10-20' # date | Upper bound (inclusive), `YYYY-MM-DD`. (optional)

    try:
        # Monthly budget data + actuals
        api_response = api_instance.get_budgets(start=start, end=end)
        print("The response of BudgetsApi->get_budgets:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BudgetsApi->get_budgets: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **date**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 
 **end** | **date**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 

### Return type

[**GetBudgetsResponse**](GetBudgetsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | budgetData (planned vs actual per category/group/flex/month) + categoryGroups. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **reset_budget**
> ResetBudgetResponse reset_budget(reset_budget_request)

Reset all planned amounts for one month back to defaults

Clears every category and category-group budget line for the target
month and reverts to Monarch's auto-calculated defaults (typically
the trailing-3-month average of actuals).

**Destructive** for that month's plan. Use when a user wants to start
fresh for a new month and have Monarch re-suggest amounts based on
recent spend, instead of carrying over last month's plan.

Required: `startDate` (first-of-month YYYY-MM-01). Operates on a
single month only; loop client-side to reset a range.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.reset_budget_response import ResetBudgetResponse
from monarch_bridge_client.models.reset_budget_request import ResetBudgetRequest
from monarch_bridge_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:9084
# See configuration.py for a list of all supported configuration parameters.
configuration = monarch_bridge_client.Configuration(
    host = "http://localhost:9084"
)


# Enter a context with an instance of the API client
with monarch_bridge_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = monarch_bridge_client.BudgetsApi(api_client)
    reset_budget_request = monarch_bridge_client.ResetBudgetRequest() # ResetBudgetRequest | 

    try:
        # Reset all planned amounts for one month back to defaults
        api_response = api_instance.reset_budget(reset_budget_request)
        print("The response of BudgetsApi->reset_budget:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BudgetsApi->reset_budget: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reset_budget_request** | [**ResetBudgetRequest**](ResetBudgetRequest.md)|  | 

### Return type

[**ResetBudgetResponse**](ResetBudgetResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Confirmation. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **set_budget_amount**
> SetBudgetAmountResponse set_budget_amount(set_budget_amount_request)

Set the planned amount for one category OR category-group for a month

Writes a single budget cell: the planned spend for one category (or one
category group) for one month. Used to fill out the budget grid one
line item at a time.

Pass exactly one of `categoryId` or `categoryGroupId`. `amount: 0`
clears the line. `applyToFuture: true` cascades the same amount to
every subsequent month (useful for fixed line items like rent).

For wider edits use the dedicated Flex endpoints or
`POST /v1/budgets/reset` to wipe a month back to defaults.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.set_budget_amount_response import SetBudgetAmountResponse
from monarch_bridge_client.models.set_budget_amount_request import SetBudgetAmountRequest
from monarch_bridge_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:9084
# See configuration.py for a list of all supported configuration parameters.
configuration = monarch_bridge_client.Configuration(
    host = "http://localhost:9084"
)


# Enter a context with an instance of the API client
with monarch_bridge_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = monarch_bridge_client.BudgetsApi(api_client)
    set_budget_amount_request = monarch_bridge_client.SetBudgetAmountRequest() # SetBudgetAmountRequest | 

    try:
        # Set the planned amount for one category OR category-group for a month
        api_response = api_instance.set_budget_amount(set_budget_amount_request)
        print("The response of BudgetsApi->set_budget_amount:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BudgetsApi->set_budget_amount: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **set_budget_amount_request** | [**SetBudgetAmountRequest**](SetBudgetAmountRequest.md)|  | 

### Return type

[**SetBudgetAmountResponse**](SetBudgetAmountResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Created/updated budget item. |  -  |
**400** | Validation failed. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_budget_settings**
> UpdateBudgetSettingsResponse update_budget_settings(update_budget_settings_request)

Update household budget settings

Change household-wide budget configuration: which budget system is
active (`category` vs `category_group`) and whether budget edits
cascade to future months by default.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.update_budget_settings_response import UpdateBudgetSettingsResponse
from monarch_bridge_client.models.update_budget_settings_request import UpdateBudgetSettingsRequest
from monarch_bridge_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:9084
# See configuration.py for a list of all supported configuration parameters.
configuration = monarch_bridge_client.Configuration(
    host = "http://localhost:9084"
)


# Enter a context with an instance of the API client
with monarch_bridge_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = monarch_bridge_client.BudgetsApi(api_client)
    update_budget_settings_request = monarch_bridge_client.UpdateBudgetSettingsRequest() # UpdateBudgetSettingsRequest | 

    try:
        # Update household budget settings
        api_response = api_instance.update_budget_settings(update_budget_settings_request)
        print("The response of BudgetsApi->update_budget_settings:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BudgetsApi->update_budget_settings: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **update_budget_settings_request** | [**UpdateBudgetSettingsRequest**](UpdateBudgetSettingsRequest.md)|  | 

### Return type

[**UpdateBudgetSettingsResponse**](UpdateBudgetSettingsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Effective budget settings after update. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_flex_rollover_settings**
> UpdateFlexRolloverSettingsResponse update_flex_rollover_settings(update_flex_rollover_settings_request)

Configure / reset the Flex bucket rollover period

Sets how the Flex bucket's leftover (positive or negative) carries
forward month-to-month. `rolloverStartMonth` anchors the rolling
window; `rolloverStartingBalance` seeds the carryover dollar amount.

Common use: point `rolloverStartMonth` at the current month with
`rolloverStartingBalance: 0` to clear accumulated negative rollover
(the classic "I overspent for 6 months, wipe the slate" reset).

Pair with `PUT /v1/budgets/flex` to set the new monthly cap once
rollover is reset.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.update_flex_rollover_settings_response import UpdateFlexRolloverSettingsResponse
from monarch_bridge_client.models.update_flex_rollover_settings_request import UpdateFlexRolloverSettingsRequest
from monarch_bridge_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:9084
# See configuration.py for a list of all supported configuration parameters.
configuration = monarch_bridge_client.Configuration(
    host = "http://localhost:9084"
)


# Enter a context with an instance of the API client
with monarch_bridge_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = monarch_bridge_client.BudgetsApi(api_client)
    update_flex_rollover_settings_request = monarch_bridge_client.UpdateFlexRolloverSettingsRequest() # UpdateFlexRolloverSettingsRequest | 

    try:
        # Configure / reset the Flex bucket rollover period
        api_response = api_instance.update_flex_rollover_settings(update_flex_rollover_settings_request)
        print("The response of BudgetsApi->update_flex_rollover_settings:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BudgetsApi->update_flex_rollover_settings: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **update_flex_rollover_settings_request** | [**UpdateFlexRolloverSettingsRequest**](UpdateFlexRolloverSettingsRequest.md)|  | 

### Return type

[**UpdateFlexRolloverSettingsResponse**](UpdateFlexRolloverSettingsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | New rollover period. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_flexible_budget**
> SetBudgetAmountResponse update_flexible_budget(update_flexible_budget_request)

Update the Flex bucket total for a month

Sets the household's total Flex-bucket budget for a single month.
Flex is Monarch's variable-spending pool (anything tagged as
flexible-variability) that's tracked as one combined cap rather than
per category.

Required: `startDate` (first-of-month) and `amount` in dollars. Pass
`applyToFuture: true` to cascade the new amount to every subsequent
month. To configure how Flex rolls over month-to-month use
`PUT /v1/budgets/flex-rollover` instead.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.set_budget_amount_response import SetBudgetAmountResponse
from monarch_bridge_client.models.update_flexible_budget_request import UpdateFlexibleBudgetRequest
from monarch_bridge_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:9084
# See configuration.py for a list of all supported configuration parameters.
configuration = monarch_bridge_client.Configuration(
    host = "http://localhost:9084"
)


# Enter a context with an instance of the API client
with monarch_bridge_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = monarch_bridge_client.BudgetsApi(api_client)
    update_flexible_budget_request = monarch_bridge_client.UpdateFlexibleBudgetRequest() # UpdateFlexibleBudgetRequest | 

    try:
        # Update the Flex bucket total for a month
        api_response = api_instance.update_flexible_budget(update_flexible_budget_request)
        print("The response of BudgetsApi->update_flexible_budget:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BudgetsApi->update_flexible_budget: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **update_flexible_budget_request** | [**UpdateFlexibleBudgetRequest**](UpdateFlexibleBudgetRequest.md)|  | 

### Return type

[**SetBudgetAmountResponse**](SetBudgetAmountResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Updated flex item. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

