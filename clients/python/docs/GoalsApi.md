# monarch_bridge_client.GoalsApi

All URIs are relative to *http://localhost:9084*

Method | HTTP request | Description
------------- | ------------- | -------------
[**archive_goal**](GoalsApi.md#archive_goal) | **DELETE** /v1/goals/{id} | Archive a savings goal
[**contribute_to_goal**](GoalsApi.md#contribute_to_goal) | **POST** /v1/goals/{id}/contributions | Record a contribution to a savings goal
[**create_goal**](GoalsApi.md#create_goal) | **POST** /v1/goals | Create a new savings or debt-payoff goal
[**delete_goal_v2**](GoalsApi.md#delete_goal_v2) | **DELETE** /v1/goals/{id}/v2-delete | Delete a goal (v2 mutation)
[**get_goal**](GoalsApi.md#get_goal) | **GET** /v1/goals/{id} | Get one savings goal
[**get_goal_contribution_history**](GoalsApi.md#get_goal_contribution_history) | **GET** /v1/goals/{id}/contribution-history | Goal contribution history
[**get_goal_projection**](GoalsApi.md#get_goal_projection) | **GET** /v1/goals/{id}/projection | Goal projection chart
[**get_goals_current_month_totals**](GoalsApi.md#get_goals_current_month_totals) | **GET** /v1/goals/totals/current-month | Current-month planned-contribution totals per goal
[**hard_delete_goal**](GoalsApi.md#hard_delete_goal) | **DELETE** /v1/goals/{id}/hard | Hard-delete a savings goal
[**link_transaction_to_goal**](GoalsApi.md#link_transaction_to_goal) | **POST** /v1/transactions/{id}/goal-link | Link a transaction to a savings goal
[**list_goal_events**](GoalsApi.md#list_goal_events) | **GET** /v1/goals/{id}/events | Event log for one savings goal
[**list_goals**](GoalsApi.md#list_goals) | **GET** /v1/goals | List all savings goals
[**mark_goal_complete**](GoalsApi.md#mark_goal_complete) | **POST** /v1/goals/{id}/complete | Mark a goal complete
[**mark_goal_incomplete**](GoalsApi.md#mark_goal_incomplete) | **POST** /v1/goals/{id}/incomplete | Mark a goal incomplete
[**set_goal_budget_amount**](GoalsApi.md#set_goal_budget_amount) | **PUT** /v1/goals/{id}/budget | Set monthly budget allocation for a savings goal
[**spend_from_goal**](GoalsApi.md#spend_from_goal) | **POST** /v1/goals/{id}/spend | Spend from a savings goal
[**unarchive_goal**](GoalsApi.md#unarchive_goal) | **POST** /v1/goals/{id}/unarchive | Un-archive a savings goal
[**unlink_transaction_goal_records**](GoalsApi.md#unlink_transaction_goal_records) | **DELETE** /v1/transactions/{id}/goal-link | Unlink any goal-reconciliation records for a transaction
[**update_goal**](GoalsApi.md#update_goal) | **PATCH** /v1/goals/{id} | Update a savings goal
[**update_goals_priorities**](GoalsApi.md#update_goals_priorities) | **PUT** /v1/goals/priorities | Re-order savings goals by priority
[**withdraw_from_goal**](GoalsApi.md#withdraw_from_goal) | **POST** /v1/goals/{id}/withdraw | Withdraw from a savings goal


# **archive_goal**
> CreateGoalResponse archive_goal(id)

Archive a savings goal

**Soft-deletes** the goal by setting its `archivedAt` timestamp.
The goal remains visible via `GET /v1/goals` (filter on
`archivedAt` to hide) but its `status` flips to `archived` and it
drops out of active-goal aggregates.

Reversible via `POST /v1/goals/{id}/unarchive`. For permanent
removal use `DELETE /v1/goals/{id}/hard` instead.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.create_goal_response import CreateGoalResponse
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
    api_instance = monarch_bridge_client.GoalsApi(api_client)
    id = 'id_example' # str | Monarch savings-goal id.

    try:
        # Archive a savings goal
        api_response = api_instance.archive_goal(id)
        print("The response of GoalsApi->archive_goal:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling GoalsApi->archive_goal: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch savings-goal id. | 

### Return type

[**CreateGoalResponse**](CreateGoalResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The archived goal. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **contribute_to_goal**
> ContributeToGoalResponse contribute_to_goal(id, contribute_to_goal_request)

Record a contribution to a savings goal

Logs a contribution event against a goal from a specific account.
Required: `accountId` and `amount` (in dollars, positive for a
contribution, negative for a withdrawal). `date` defaults to today
if omitted.

Use after a manual transfer the user wants attributed to the goal,
or to backfill historical progress. Updates the goal's `currentAmount`
and appends to its event log (visible via
`GET /v1/goals/{id}/events`).

Distinct from `PUT /v1/goals/{id}/budget` which sets the planned
monthly contribution (forecast) rather than logging an actual one.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.contribute_to_goal_response import ContributeToGoalResponse
from monarch_bridge_client.models.contribute_to_goal_request import ContributeToGoalRequest
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
    api_instance = monarch_bridge_client.GoalsApi(api_client)
    id = 'id_example' # str | Monarch savings-goal id.
    contribute_to_goal_request = monarch_bridge_client.ContributeToGoalRequest() # ContributeToGoalRequest | 

    try:
        # Record a contribution to a savings goal
        api_response = api_instance.contribute_to_goal(id, contribute_to_goal_request)
        print("The response of GoalsApi->contribute_to_goal:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling GoalsApi->contribute_to_goal: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch savings-goal id. | 
 **contribute_to_goal_request** | [**ContributeToGoalRequest**](ContributeToGoalRequest.md)|  | 

### Return type

[**ContributeToGoalResponse**](ContributeToGoalResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Updated goal balance + event metadata. |  -  |
**400** | Validation failed. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **create_goal**
> CreateGoalResponse create_goal(create_goal_request)

Create a new savings or debt-payoff goal

Creates one savings goal. Wraps Monarch's `createSavingsGoals`
batch mutation with a single-goal body for ergonomics.

Required: `name` and `targetAmount`. Optional: `targetDate`,
`imageStorageProvider`/`imageStorageProviderId` for an icon,
`accounts` to pre-link funding accounts. `type` defaults to
`"savings"`; pass `"debt"` for a debt-payoff goal (sign
convention flips: progress = paying it DOWN).

Once created, set up monthly contributions via
`PUT /v1/goals/{id}/budget` and log actuals via
`POST /v1/goals/{id}/contributions`.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.create_goal_response import CreateGoalResponse
from monarch_bridge_client.models.create_goal_request import CreateGoalRequest
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
    api_instance = monarch_bridge_client.GoalsApi(api_client)
    create_goal_request = monarch_bridge_client.CreateGoalRequest() # CreateGoalRequest | 

    try:
        # Create a new savings or debt-payoff goal
        api_response = api_instance.create_goal(create_goal_request)
        print("The response of GoalsApi->create_goal:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling GoalsApi->create_goal: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **create_goal_request** | [**CreateGoalRequest**](CreateGoalRequest.md)|  | 

### Return type

[**CreateGoalResponse**](CreateGoalResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | New goal. |  -  |
**400** | Validation failed. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_goal_v2**
> MarkTransactionStreamAsNotRecurringResponse delete_goal_v2(id)

Delete a goal (v2 mutation)

Permanently delete a savings goal via the v2 `deleteGoalV2` mutation.
Distinct from `DELETE /v1/goals/{id}/hard` (which uses the legacy
`deleteSavingsGoal` path); the v2 path is preferred for goals
created through the v2 flow.

Returns a flat `success` boolean and any payload errors.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.mark_transaction_stream_as_not_recurring_response import MarkTransactionStreamAsNotRecurringResponse
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
    api_instance = monarch_bridge_client.GoalsApi(api_client)
    id = 'id_example' # str | Monarch savings-goal id.

    try:
        # Delete a goal (v2 mutation)
        api_response = api_instance.delete_goal_v2(id)
        print("The response of GoalsApi->delete_goal_v2:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling GoalsApi->delete_goal_v2: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch savings-goal id. | 

### Return type

[**MarkTransactionStreamAsNotRecurringResponse**](MarkTransactionStreamAsNotRecurringResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Deletion result. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_goal**
> CreateGoalResponse get_goal(id)

Get one savings goal

Returns the full detail for a single v2 savings goal: name,
target amount, current balance, target date, type (savings or
debt), priority, linked accounts, and archive state.

Use to surface a goal in a detail view or to inspect state before a
PATCH or contribution. For the contribution / withdrawal event log
use `GET /v1/goals/{id}/events`.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.create_goal_response import CreateGoalResponse
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
    api_instance = monarch_bridge_client.GoalsApi(api_client)
    id = 'id_example' # str | Monarch savings-goal id.

    try:
        # Get one savings goal
        api_response = api_instance.get_goal(id)
        print("The response of GoalsApi->get_goal:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling GoalsApi->get_goal: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch savings-goal id. | 

### Return type

[**CreateGoalResponse**](CreateGoalResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The goal. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_goal_contribution_history**
> GetGoalContributionHistoryResponse get_goal_contribution_history(id)

Goal contribution history

Ledger of contributions logged against one goal: date, amount,
source account, optional notes. Distinct from
`/v1/goals/{id}/events` which includes auto-linked transactions
too; this endpoint returns only explicit contributions.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_goal_contribution_history_response import GetGoalContributionHistoryResponse
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
    api_instance = monarch_bridge_client.GoalsApi(api_client)
    id = 'id_example' # str | Monarch savings-goal id.

    try:
        # Goal contribution history
        api_response = api_instance.get_goal_contribution_history(id)
        print("The response of GoalsApi->get_goal_contribution_history:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling GoalsApi->get_goal_contribution_history: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch savings-goal id. | 

### Return type

[**GetGoalContributionHistoryResponse**](GetGoalContributionHistoryResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Contribution ledger. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_goal_projection**
> GetGoalProjectionResponse get_goal_projection(id)

Goal projection chart

Forward projection of a goal's balance at the current planned
contribution rate. Returns the projected completion date, months
to target, and a per-month projected-balance series.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_goal_projection_response import GetGoalProjectionResponse
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
    api_instance = monarch_bridge_client.GoalsApi(api_client)
    id = 'id_example' # str | Monarch savings-goal id.

    try:
        # Goal projection chart
        api_response = api_instance.get_goal_projection(id)
        print("The response of GoalsApi->get_goal_projection:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling GoalsApi->get_goal_projection: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch savings-goal id. | 

### Return type

[**GetGoalProjectionResponse**](GetGoalProjectionResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Projection data. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_goals_current_month_totals**
> GetGoalsCurrentMonthTotalsResponse get_goals_current_month_totals(start_month=start_month, end_month=end_month)

Current-month planned-contribution totals per goal

Returns the sum of `totalPlannedAmount` across the requested month
window, broken out per goal. Used for "how much am I planning to
contribute this month and to which goals" rollups without pulling
each goal's full plan series.

Defaults to the current calendar month when both params are
omitted (`startMonth = first-of-this-month`, `endMonth =
first-of-this-month`). Pass a wider window to get a multi-month
plan summary.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_goals_current_month_totals_response import GetGoalsCurrentMonthTotalsResponse
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
    api_instance = monarch_bridge_client.GoalsApi(api_client)
    start_month = '2013-10-20' # date | First-of-month lower bound (`YYYY-MM-DD`). (optional)
    end_month = '2013-10-20' # date | First-of-month upper bound (`YYYY-MM-DD`). (optional)

    try:
        # Current-month planned-contribution totals per goal
        api_response = api_instance.get_goals_current_month_totals(start_month=start_month, end_month=end_month)
        print("The response of GoalsApi->get_goals_current_month_totals:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling GoalsApi->get_goals_current_month_totals: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start_month** | **date**| First-of-month lower bound (&#x60;YYYY-MM-DD&#x60;). | [optional] 
 **end_month** | **date**| First-of-month upper bound (&#x60;YYYY-MM-DD&#x60;). | [optional] 

### Return type

[**GetGoalsCurrentMonthTotalsResponse**](GetGoalsCurrentMonthTotalsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Per-goal totals for the window. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **hard_delete_goal**
> HardDeleteGoalResponse hard_delete_goal(id)

Hard-delete a savings goal

Permanently removes the goal. **No undo**. Distinct from
`DELETE /v1/goals/{id}` (which archives / soft-deletes and is
reversible via the unarchive endpoint).

After this call the goal disappears from `GET /v1/goals` entirely
and its event log is no longer queryable. Use only when the user
explicitly wants to purge a goal, not for routine cleanup.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.hard_delete_goal_response import HardDeleteGoalResponse
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
    api_instance = monarch_bridge_client.GoalsApi(api_client)
    id = 'id_example' # str | Monarch savings-goal id.

    try:
        # Hard-delete a savings goal
        api_response = api_instance.hard_delete_goal(id)
        print("The response of GoalsApi->hard_delete_goal:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling GoalsApi->hard_delete_goal: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch savings-goal id. | 

### Return type

[**HardDeleteGoalResponse**](HardDeleteGoalResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Confirmation of hard delete. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **link_transaction_to_goal**
> LinkTransactionToGoalResponse link_transaction_to_goal(id, link_transaction_to_goal_request)

Link a transaction to a savings goal

Create a goal-event that ties a single transaction to a goal. The
transaction's `savingsGoalEvent` becomes non-null and the goal
balance reconciliation picks it up. Used to credit a specific
purchase ("plane tickets") against the matching goal ("Vacation").

Pair with `DELETE /v1/transactions/{id}/goal-link` to unlink.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.link_transaction_to_goal_response import LinkTransactionToGoalResponse
from monarch_bridge_client.models.link_transaction_to_goal_request import LinkTransactionToGoalRequest
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
    api_instance = monarch_bridge_client.GoalsApi(api_client)
    id = 'id_example' # str | Monarch transaction id.
    link_transaction_to_goal_request = monarch_bridge_client.LinkTransactionToGoalRequest() # LinkTransactionToGoalRequest | 

    try:
        # Link a transaction to a savings goal
        api_response = api_instance.link_transaction_to_goal(id, link_transaction_to_goal_request)
        print("The response of GoalsApi->link_transaction_to_goal:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling GoalsApi->link_transaction_to_goal: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch transaction id. | 
 **link_transaction_to_goal_request** | [**LinkTransactionToGoalRequest**](LinkTransactionToGoalRequest.md)|  | 

### Return type

[**LinkTransactionToGoalResponse**](LinkTransactionToGoalResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Linkage created. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_goal_events**
> ListGoalEventsResponse list_goal_events(id)

Event log for one savings goal

Returns the full event ledger for a single goal: every
contribution, withdrawal, and transaction Monarch auto-linked to
the goal. Each event has type, amount, date, account, and source
transaction id (if any).

Use to surface a "history" tab on a goal detail view or to compute
actual-vs-planned contribution totals over time. For a quick
current-month rollup across all goals use
`GET /v1/goals/current-month-totals`.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.list_goal_events_response import ListGoalEventsResponse
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
    api_instance = monarch_bridge_client.GoalsApi(api_client)
    id = 'id_example' # str | Monarch savings-goal id.

    try:
        # Event log for one savings goal
        api_response = api_instance.list_goal_events(id)
        print("The response of GoalsApi->list_goal_events:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling GoalsApi->list_goal_events: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch savings-goal id. | 

### Return type

[**ListGoalEventsResponse**](ListGoalEventsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | All goal events, newest-first per upstream order. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_goals**
> ListGoalsResponse list_goals()

List all savings goals

Returns every v2 savings goal: active, archived, hard-deleted-but-
soft-still-visible, debt and savings types together. Each entry
carries name, target amount, current progress, priority, linked
accounts, and `archivedAt`.

Filter client-side on `archivedAt == null` to hide archived. Sort
on `priority` for the user's intended display order. For one goal's
detail use `GET /v1/goals/{id}`; for the event log use
`GET /v1/goals/{id}/events`.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.list_goals_response import ListGoalsResponse
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
    api_instance = monarch_bridge_client.GoalsApi(api_client)

    try:
        # List all savings goals
        api_response = api_instance.list_goals()
        print("The response of GoalsApi->list_goals:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling GoalsApi->list_goals: %s\n" % e)
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

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | All savings goals. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mark_goal_complete**
> MarkGoalCompleteResponse mark_goal_complete(id)

Mark a goal complete

Stamp a savings goal `completedAt=now`. Surfaces a celebration in the
UI and freezes the goal balance display. Idempotent - replays do not
re-trigger the celebration.

Pair with `POST /v1/goals/{id}/incomplete` to un-mark a goal that was
marked complete by mistake.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.mark_goal_complete_response import MarkGoalCompleteResponse
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
    api_instance = monarch_bridge_client.GoalsApi(api_client)
    id = 'id_example' # str | Monarch savings-goal id.

    try:
        # Mark a goal complete
        api_response = api_instance.mark_goal_complete(id)
        print("The response of GoalsApi->mark_goal_complete:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling GoalsApi->mark_goal_complete: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch savings-goal id. | 

### Return type

[**MarkGoalCompleteResponse**](MarkGoalCompleteResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Updated completion state. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mark_goal_incomplete**
> MarkGoalCompleteResponse mark_goal_incomplete(id)

Mark a goal incomplete

Clear a savings goal's `completedAt`, reverting it back to "in
progress". Used to undo a `POST /v1/goals/{id}/complete` performed
in error.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.mark_goal_complete_response import MarkGoalCompleteResponse
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
    api_instance = monarch_bridge_client.GoalsApi(api_client)
    id = 'id_example' # str | Monarch savings-goal id.

    try:
        # Mark a goal incomplete
        api_response = api_instance.mark_goal_incomplete(id)
        print("The response of GoalsApi->mark_goal_incomplete:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling GoalsApi->mark_goal_incomplete: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch savings-goal id. | 

### Return type

[**MarkGoalCompleteResponse**](MarkGoalCompleteResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Updated completion state. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **set_goal_budget_amount**
> MarkTransactionStreamAsNotRecurringResponse set_goal_budget_amount(id, set_goal_budget_amount_request)

Set monthly budget allocation for a savings goal

Sets the planned contribution amount for a goal for one month, or
(with `applyToFuture: true`) cascades the same amount to every
subsequent month. This is the FORECAST, not a recorded contribution:
use `POST /v1/goals/{id}/contributions` to log actual money in.

Required: `startDate` (first-of-month) and `amount`. `accountId` is
optional: omit to set the household-level planned amount; supply
when the contribution comes from one specific account.

Pairs with `GET /v1/goals/current-month-totals` to read back the
planned totals.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.mark_transaction_stream_as_not_recurring_response import MarkTransactionStreamAsNotRecurringResponse
from monarch_bridge_client.models.set_goal_budget_amount_request import SetGoalBudgetAmountRequest
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
    api_instance = monarch_bridge_client.GoalsApi(api_client)
    id = 'id_example' # str | Monarch savings-goal id.
    set_goal_budget_amount_request = monarch_bridge_client.SetGoalBudgetAmountRequest() # SetGoalBudgetAmountRequest | 

    try:
        # Set monthly budget allocation for a savings goal
        api_response = api_instance.set_goal_budget_amount(id, set_goal_budget_amount_request)
        print("The response of GoalsApi->set_goal_budget_amount:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling GoalsApi->set_goal_budget_amount: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch savings-goal id. | 
 **set_goal_budget_amount_request** | [**SetGoalBudgetAmountRequest**](SetGoalBudgetAmountRequest.md)|  | 

### Return type

[**MarkTransactionStreamAsNotRecurringResponse**](MarkTransactionStreamAsNotRecurringResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Confirmation flag from Monarch. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **spend_from_goal**
> SpendFromGoalResponse spend_from_goal(id, spend_from_goal_request)

Spend from a savings goal

Record a spend event against a savings goal - i.e. "I used some of my
`Vacation` goal balance to pay for the flight". Pair with
`POST /v1/goals/{id}/contributions` (contributions) and
`POST /v1/goals/{id}/withdraw` (withdrawals back to source account).

Returns the created goal-event id.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.spend_from_goal_response import SpendFromGoalResponse
from monarch_bridge_client.models.spend_from_goal_request import SpendFromGoalRequest
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
    api_instance = monarch_bridge_client.GoalsApi(api_client)
    id = 'id_example' # str | Monarch savings-goal id.
    spend_from_goal_request = monarch_bridge_client.SpendFromGoalRequest() # SpendFromGoalRequest | 

    try:
        # Spend from a savings goal
        api_response = api_instance.spend_from_goal(id, spend_from_goal_request)
        print("The response of GoalsApi->spend_from_goal:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling GoalsApi->spend_from_goal: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch savings-goal id. | 
 **spend_from_goal_request** | [**SpendFromGoalRequest**](SpendFromGoalRequest.md)|  | 

### Return type

[**SpendFromGoalResponse**](SpendFromGoalResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Created spend event. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **unarchive_goal**
> CreateGoalResponse unarchive_goal(id)

Un-archive a savings goal

Restores a previously archived goal back to active state. Inverse
of `DELETE /v1/goals/{id}`: clears the upstream `archivedAt`
timestamp and flips `status` back to `active`.

Use when a user accidentally archived a goal or wants to revive an
old one. No-op if the goal is already active. For permanent
removal use `DELETE /v1/goals/{id}/hard` (no undo).


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.create_goal_response import CreateGoalResponse
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
    api_instance = monarch_bridge_client.GoalsApi(api_client)
    id = 'id_example' # str | Monarch savings-goal id.

    try:
        # Un-archive a savings goal
        api_response = api_instance.unarchive_goal(id)
        print("The response of GoalsApi->unarchive_goal:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling GoalsApi->unarchive_goal: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch savings-goal id. | 

### Return type

[**CreateGoalResponse**](CreateGoalResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The restored goal. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **unlink_transaction_goal_records**
> MarkTransactionStreamAsNotRecurringResponse unlink_transaction_goal_records(id)

Unlink any goal-reconciliation records for a transaction

Drops all goal-reconciliation records for one transaction (the
inverse of `POST /v1/transactions/{id}/goal-link`). The transaction
stops being credited against any goal.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.mark_transaction_stream_as_not_recurring_response import MarkTransactionStreamAsNotRecurringResponse
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
    api_instance = monarch_bridge_client.GoalsApi(api_client)
    id = 'id_example' # str | Monarch transaction id.

    try:
        # Unlink any goal-reconciliation records for a transaction
        api_response = api_instance.unlink_transaction_goal_records(id)
        print("The response of GoalsApi->unlink_transaction_goal_records:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling GoalsApi->unlink_transaction_goal_records: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch transaction id. | 

### Return type

[**MarkTransactionStreamAsNotRecurringResponse**](MarkTransactionStreamAsNotRecurringResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Deletion result. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_goal**
> CreateGoalResponse update_goal(id, update_goal_request)

Update a savings goal

Patches one goal. Only populated fields are forwarded to Monarch;
omit a field to leave it untouched.

Common edits: rename, change `targetAmount` or `targetDate`,
re-link `accounts`, update the icon. To re-order priority across
goals use `PUT /v1/goals/priorities` instead. To archive use
`DELETE /v1/goals/{id}` (reversible) or `DELETE /v1/goals/{id}/hard`
(permanent).


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.create_goal_response import CreateGoalResponse
from monarch_bridge_client.models.update_goal_request import UpdateGoalRequest
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
    api_instance = monarch_bridge_client.GoalsApi(api_client)
    id = 'id_example' # str | Monarch savings-goal id.
    update_goal_request = monarch_bridge_client.UpdateGoalRequest() # UpdateGoalRequest | 

    try:
        # Update a savings goal
        api_response = api_instance.update_goal(id, update_goal_request)
        print("The response of GoalsApi->update_goal:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling GoalsApi->update_goal: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch savings-goal id. | 
 **update_goal_request** | [**UpdateGoalRequest**](UpdateGoalRequest.md)|  | 

### Return type

[**CreateGoalResponse**](CreateGoalResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The updated goal. |  -  |
**400** | Validation failed. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_goals_priorities**
> UpdateGoalsPrioritiesResponse update_goals_priorities(update_goals_priorities_request)

Re-order savings goals by priority

Reorders goals by sending the full id list in the desired order.
The proxy assigns `priority = index` (0-based) to each id, then
calls Monarch's batch priority mutation in one round-trip.

Send the COMPLETE goal id list, not a delta. Goals missing from
the list keep their current priority but end up after all listed
goals. Use after a drag-and-drop reorder in a goals UI.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.update_goals_priorities_response import UpdateGoalsPrioritiesResponse
from monarch_bridge_client.models.update_goals_priorities_request import UpdateGoalsPrioritiesRequest
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
    api_instance = monarch_bridge_client.GoalsApi(api_client)
    update_goals_priorities_request = monarch_bridge_client.UpdateGoalsPrioritiesRequest() # UpdateGoalsPrioritiesRequest | 

    try:
        # Re-order savings goals by priority
        api_response = api_instance.update_goals_priorities(update_goals_priorities_request)
        print("The response of GoalsApi->update_goals_priorities:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling GoalsApi->update_goals_priorities: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **update_goals_priorities_request** | [**UpdateGoalsPrioritiesRequest**](UpdateGoalsPrioritiesRequest.md)|  | 

### Return type

[**UpdateGoalsPrioritiesResponse**](UpdateGoalsPrioritiesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Updated &#x60;(goalId, priority)&#x60; pairs. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **withdraw_from_goal**
> WithdrawFromGoalResponse withdraw_from_goal(id, withdraw_from_goal_request)

Withdraw from a savings goal

Withdraw money from a savings goal back into a source account.
Reverses (in spirit) a prior contribution; the goal balance drops
by `amount`, and Monarch updates the account's available-for-goals
balance.

Pair with `POST /v1/goals/{id}/contributions` to deposit.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.withdraw_from_goal_response import WithdrawFromGoalResponse
from monarch_bridge_client.models.withdraw_from_goal_request import WithdrawFromGoalRequest
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
    api_instance = monarch_bridge_client.GoalsApi(api_client)
    id = 'id_example' # str | Monarch savings-goal id.
    withdraw_from_goal_request = monarch_bridge_client.WithdrawFromGoalRequest() # WithdrawFromGoalRequest | 

    try:
        # Withdraw from a savings goal
        api_response = api_instance.withdraw_from_goal(id, withdraw_from_goal_request)
        print("The response of GoalsApi->withdraw_from_goal:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling GoalsApi->withdraw_from_goal: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch savings-goal id. | 
 **withdraw_from_goal_request** | [**WithdrawFromGoalRequest**](WithdrawFromGoalRequest.md)|  | 

### Return type

[**WithdrawFromGoalResponse**](WithdrawFromGoalResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Created withdrawal event + updated goal + account snapshot. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

