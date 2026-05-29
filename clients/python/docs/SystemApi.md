# monarch_bridge_client.SystemApi

All URIs are relative to *http://localhost:9084*

Method | HTTP request | Description
------------- | ------------- | -------------
[**clear_all_notifications**](SystemApi.md#clear_all_notifications) | **POST** /v1/notifications/clear-all | Clear all notifications
[**dismiss_notification**](SystemApi.md#dismiss_notification) | **POST** /v1/notifications/{id}/dismiss | Dismiss one notification
[**get_app_version**](SystemApi.md#get_app_version) | **GET** /v1/app/version | App version info
[**get_auth_status**](SystemApi.md#get_auth_status) | **GET** /v1/auth/status | Whether a Monarch session is currently loaded
[**get_beta_features**](SystemApi.md#get_beta_features) | **GET** /v1/app/beta-features | Beta features the account can opt into
[**get_calendar_events**](SystemApi.md#get_calendar_events) | **GET** /v1/calendar/events | Calendar events
[**get_cashflow_report**](SystemApi.md#get_cashflow_report) | **GET** /v1/reports/cashflow | Cashflow report
[**get_category_report**](SystemApi.md#get_category_report) | **GET** /v1/reports/category | Per-category historical report
[**get_credit_history**](SystemApi.md#get_credit_history) | **GET** /v1/credit/history | Credit-score snapshots over time
[**get_entitlements**](SystemApi.md#get_entitlements) | **GET** /v1/entitlements | Subscription entitlements
[**get_expense_by_category**](SystemApi.md#get_expense_by_category) | **GET** /v1/reports/expense-by-category | Expense breakdown grouped by category
[**get_expense_by_merchant**](SystemApi.md#get_expense_by_merchant) | **GET** /v1/reports/expense-by-merchant | Expense breakdown grouped by merchant
[**get_expense_by_tag**](SystemApi.md#get_expense_by_tag) | **GET** /v1/reports/expense-by-tag | Expense breakdown grouped by tag
[**get_feature_flags**](SystemApi.md#get_feature_flags) | **GET** /v1/app/feature-flags | Feature flags for this account
[**get_financial_insight**](SystemApi.md#get_financial_insight) | **GET** /v1/insights/{id} | Single AI savings insight
[**get_health**](SystemApi.md#get_health) | **GET** /healthz | Liveness probe with auth-presence hint
[**get_income_report**](SystemApi.md#get_income_report) | **GET** /v1/reports/income | Income report
[**get_income_vs_expense_yoy**](SystemApi.md#get_income_vs_expense_yoy) | **GET** /v1/reports/income-vs-expense-yoy | Income vs. expense year-over-year
[**get_integration_status**](SystemApi.md#get_integration_status) | **GET** /v1/integrations/status | Per-credential integration health
[**get_latest_insight_run**](SystemApi.md#get_latest_insight_run) | **GET** /v1/insights/latest-run | Latest financial-insight run + insights count
[**get_latest_refresh_operation**](SystemApi.md#get_latest_refresh_operation) | **GET** /v1/refresh/latest | Latest force-refresh operation
[**get_lookup**](SystemApi.md#get_lookup) | **GET** /v1/lookup | Cross-entity fuzzy lookup
[**get_monthly_report_summary**](SystemApi.md#get_monthly_report_summary) | **GET** /v1/reports/monthly-summary | Monthly report summary
[**get_net_worth_report**](SystemApi.md#get_net_worth_report) | **GET** /v1/reports/net-worth | Net-worth report
[**get_notifications**](SystemApi.md#get_notifications) | **GET** /v1/notifications | Notification center (activity events)
[**get_platform_config**](SystemApi.md#get_platform_config) | **GET** /v1/app/platform-config | Platform configuration
[**get_plus_tier_access**](SystemApi.md#get_plus_tier_access) | **GET** /v1/plus-tier | Plus-tier access info
[**get_refresh_status**](SystemApi.md#get_refresh_status) | **GET** /v1/refresh/status | Poll per-account sync status
[**get_savings_rate_report**](SystemApi.md#get_savings_rate_report) | **GET** /v1/reports/savings-rate | Savings-rate report
[**get_savings_rate_trends**](SystemApi.md#get_savings_rate_trends) | **GET** /v1/reports/savings-rate-trends | Savings-rate trend series
[**get_spending_report**](SystemApi.md#get_spending_report) | **GET** /v1/reports/spending | Spending report
[**get_subscription**](SystemApi.md#get_subscription) | **GET** /v1/subscription | Monarch subscription tier + payment source
[**get_subscription_details**](SystemApi.md#get_subscription_details) | **GET** /v1/subscription/details | Detailed subscription info
[**get_subscription_invoices**](SystemApi.md#get_subscription_invoices) | **GET** /v1/subscription/invoices | Subscription invoice history
[**get_subscription_receipts**](SystemApi.md#get_subscription_receipts) | **GET** /v1/subscription/receipts | Subscription payment receipts
[**get_tag_report**](SystemApi.md#get_tag_report) | **GET** /v1/reports/tag | Per-tag historical report
[**get_weekly_recap**](SystemApi.md#get_weekly_recap) | **GET** /v1/recap/weekly | Weekly recap
[**get_zestimate**](SystemApi.md#get_zestimate) | **POST** /v1/zillow/zestimate | Zillow Zestimate lookup
[**initiate_password_change**](SystemApi.md#initiate_password_change) | **POST** /v1/me/password-change/initiate | Initiate password change
[**list_financial_insights**](SystemApi.md#list_financial_insights) | **GET** /v1/insights | List AI savings insights
[**mark_all_notifications_as_read**](SystemApi.md#mark_all_notifications_as_read) | **POST** /v1/notifications/read-all | Mark all notifications as read
[**mark_notification_as_read**](SystemApi.md#mark_notification_as_read) | **POST** /v1/notifications/{id}/read | Mark one notification as read
[**pause_subscription**](SystemApi.md#pause_subscription) | **POST** /v1/subscription/pause | Pause the subscription
[**preview_subscription_plan_change**](SystemApi.md#preview_subscription_plan_change) | **POST** /v1/subscription/plan-preview | Preview a plan-change charge
[**refresh_auth**](SystemApi.md#refresh_auth) | **POST** /v1/auth/refresh | Reload session JSON from disk
[**request_refresh**](SystemApi.md#request_refresh) | **POST** /v1/refresh | Force Monarch to re-poll Plaid (async)
[**request_refresh_and_wait**](SystemApi.md#request_refresh_and_wait) | **POST** /v1/refresh/wait | Force Monarch to re-poll Plaid and wait until every account has finished
[**resume_subscription**](SystemApi.md#resume_subscription) | **POST** /v1/subscription/resume | Resume a paused subscription


# **clear_all_notifications**
> MarkTransactionStreamAsNotRecurringResponse clear_all_notifications()

Clear all notifications

Bulk-dismiss every activity event in the bell. Returns a simple
success boolean.


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
    api_instance = monarch_bridge_client.SystemApi(api_client)

    try:
        # Clear all notifications
        api_response = api_instance.clear_all_notifications()
        print("The response of SystemApi->clear_all_notifications:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SystemApi->clear_all_notifications: %s\n" % e)
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

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | True on success. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **dismiss_notification**
> DismissNotificationResponse dismiss_notification(id)

Dismiss one notification

Permanently dismiss a single activity event. Distinct from
`read` - dismissed events are hidden entirely (will not reappear
even if unread).


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.dismiss_notification_response import DismissNotificationResponse
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
    api_instance = monarch_bridge_client.SystemApi(api_client)
    id = 'id_example' # str | Monarch activity-event id.

    try:
        # Dismiss one notification
        api_response = api_instance.dismiss_notification(id)
        print("The response of SystemApi->dismiss_notification:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SystemApi->dismiss_notification: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch activity-event id. | 

### Return type

[**DismissNotificationResponse**](DismissNotificationResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Updated event id + dismissedAt timestamp. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_app_version**
> GetAppVersionResponse get_app_version()

App version info

Current build version, the minimum supported version (older
clients are blocked), and the recommended version. Use to drive
"please update your app" prompts.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_app_version_response import GetAppVersionResponse
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
    api_instance = monarch_bridge_client.SystemApi(api_client)

    try:
        # App version info
        api_response = api_instance.get_app_version()
        print("The response of SystemApi->get_app_version:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SystemApi->get_app_version: %s\n" % e)
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

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Version triple plus optional build SHA. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_auth_status**
> GetAuthStatusResponse get_auth_status()

Whether a Monarch session is currently loaded

Reports whether the proxy has a valid Monarch session token in memory.
Use as a precondition before calling any data endpoint: a missing
session yields 503 on every other route.

No session required to call this endpoint (unlike most others). The
response includes a coarse loaded/not-loaded flag plus the session's
expiry hint. If the session is missing or expired, run the bootstrap
CLI to re-auth then call `POST /v1/auth/refresh` to swap in the new
token.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_auth_status_response import GetAuthStatusResponse
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
    api_instance = monarch_bridge_client.SystemApi(api_client)

    try:
        # Whether a Monarch session is currently loaded
        api_response = api_instance.get_auth_status()
        print("The response of SystemApi->get_auth_status:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SystemApi->get_auth_status: %s\n" % e)
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

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Auth status. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_beta_features**
> GetBetaFeaturesResponse get_beta_features()

Beta features the account can opt into

Beta program list. Each entry has a name, short description, and
whether the household is currently enrolled.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_beta_features_response import GetBetaFeaturesResponse
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
    api_instance = monarch_bridge_client.SystemApi(api_client)

    try:
        # Beta features the account can opt into
        api_response = api_instance.get_beta_features()
        print("The response of SystemApi->get_beta_features:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SystemApi->get_beta_features: %s\n" % e)
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

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Available beta features. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_calendar_events**
> GetCalendarEventsResponse get_calendar_events(start=start, end=end)

Calendar events

Bills, recurring transactions, and paychecks projected onto a
calendar shape for a date window. One entry per event with date,
type (`bill`, `recurring`, `paycheck`), title, amount, and the id
of the underlying source record.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_calendar_events_response import GetCalendarEventsResponse
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
    api_instance = monarch_bridge_client.SystemApi(api_client)
    start = '2013-10-20' # date | Lower bound (inclusive), `YYYY-MM-DD`. (optional)
    end = '2013-10-20' # date | Upper bound (inclusive), `YYYY-MM-DD`. (optional)

    try:
        # Calendar events
        api_response = api_instance.get_calendar_events(start=start, end=end)
        print("The response of SystemApi->get_calendar_events:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SystemApi->get_calendar_events: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **date**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 
 **end** | **date**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 

### Return type

[**GetCalendarEventsResponse**](GetCalendarEventsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Calendar events. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_cashflow_report**
> GetCashflowReportResponse get_cashflow_report(start=start, end=end)

Cashflow report

Full cashflow report: total income / expense / net for the window
plus a per-month series. Distinct from `GET /v1/cashflow` (a lighter
summary view); this is the per-month chart shape the web Reports tab
fires.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_cashflow_report_response import GetCashflowReportResponse
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
    api_instance = monarch_bridge_client.SystemApi(api_client)
    start = '2013-10-20' # date | Lower bound (inclusive), `YYYY-MM-DD`. (optional)
    end = '2013-10-20' # date | Upper bound (inclusive), `YYYY-MM-DD`. (optional)

    try:
        # Cashflow report
        api_response = api_instance.get_cashflow_report(start=start, end=end)
        print("The response of SystemApi->get_cashflow_report:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SystemApi->get_cashflow_report: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **date**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 
 **end** | **date**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 

### Return type

[**GetCashflowReportResponse**](GetCashflowReportResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Per-month cashflow plus totals. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_category_report**
> GetCategoryReportResponse get_category_report(category_id, start=start, end=end)

Per-category historical report

Per-month sum series for one category across a window. Backs the
"click category → drill down" view in the web Reports tab. Returns
`totalAmount` and `averagePerMonth` for convenience.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_category_report_response import GetCategoryReportResponse
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
    api_instance = monarch_bridge_client.SystemApi(api_client)
    category_id = 'category_id_example' # str | Monarch category id.
    start = '2013-10-20' # date | Lower bound (inclusive), `YYYY-MM-DD`. (optional)
    end = '2013-10-20' # date | Upper bound (inclusive), `YYYY-MM-DD`. (optional)

    try:
        # Per-category historical report
        api_response = api_instance.get_category_report(category_id, start=start, end=end)
        print("The response of SystemApi->get_category_report:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SystemApi->get_category_report: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **category_id** | **str**| Monarch category id. | 
 **start** | **date**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 
 **end** | **date**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 

### Return type

[**GetCategoryReportResponse**](GetCategoryReportResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Per-month sums for the category. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_credit_history**
> GetCreditHistoryResponse get_credit_history()

Credit-score snapshots over time

Returns the user's credit-score history series from Monarch's
Spinwheel integration. Each entry has a date, score, and the
reporting bureau (typically TransUnion).

Use for credit-trend charts or to surface the most recent score.
Empty list when Spinwheel is not enabled on the user's account
(no error, just zero entries). Premium-tier feature on Monarch's
side - tier check via `GET /v1/subscription` if needed.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_credit_history_response import GetCreditHistoryResponse
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
    api_instance = monarch_bridge_client.SystemApi(api_client)

    try:
        # Credit-score snapshots over time
        api_response = api_instance.get_credit_history()
        print("The response of SystemApi->get_credit_history:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SystemApi->get_credit_history: %s\n" % e)
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

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Snapshots (may be empty). |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_entitlements**
> GetEntitlementsResponse get_entitlements()

Subscription entitlements

Feature entitlements granted by the active subscription. Returns the raw
entitlement-key array Monarch ships, plus the subscription id for
cross-reference with `/v1/subscription`. Used to gate Plus-only flows
on the client side without an extra round-trip.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_entitlements_response import GetEntitlementsResponse
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
    api_instance = monarch_bridge_client.SystemApi(api_client)

    try:
        # Subscription entitlements
        api_response = api_instance.get_entitlements()
        print("The response of SystemApi->get_entitlements:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SystemApi->get_entitlements: %s\n" % e)
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

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Subscription id + entitlement keys. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_expense_by_category**
> GetExpenseByCategoryResponse get_expense_by_category(start=start, end=end)

Expense breakdown grouped by category

Expense rollup with one row per category over the given window.
Drives the "Top categories" report card and the legacy CSV export.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_expense_by_category_response import GetExpenseByCategoryResponse
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
    api_instance = monarch_bridge_client.SystemApi(api_client)
    start = '2013-10-20' # date |  (optional)
    end = '2013-10-20' # date |  (optional)

    try:
        # Expense breakdown grouped by category
        api_response = api_instance.get_expense_by_category(start=start, end=end)
        print("The response of SystemApi->get_expense_by_category:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SystemApi->get_expense_by_category: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **date**|  | [optional] 
 **end** | **date**|  | [optional] 

### Return type

[**GetExpenseByCategoryResponse**](GetExpenseByCategoryResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Per-category expense rows. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_expense_by_merchant**
> GetExpenseByMerchantResponse get_expense_by_merchant(start=start, end=end)

Expense breakdown grouped by merchant

Expense rollup with one row per merchant over the given window.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_expense_by_merchant_response import GetExpenseByMerchantResponse
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
    api_instance = monarch_bridge_client.SystemApi(api_client)
    start = '2013-10-20' # date |  (optional)
    end = '2013-10-20' # date |  (optional)

    try:
        # Expense breakdown grouped by merchant
        api_response = api_instance.get_expense_by_merchant(start=start, end=end)
        print("The response of SystemApi->get_expense_by_merchant:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SystemApi->get_expense_by_merchant: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **date**|  | [optional] 
 **end** | **date**|  | [optional] 

### Return type

[**GetExpenseByMerchantResponse**](GetExpenseByMerchantResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Per-merchant expense rows. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_expense_by_tag**
> GetExpenseByTagResponse get_expense_by_tag(start=start, end=end)

Expense breakdown grouped by tag

Expense rollup with one row per transaction tag over the given
window. Only transactions that carry at least one tag contribute.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_expense_by_tag_response import GetExpenseByTagResponse
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
    api_instance = monarch_bridge_client.SystemApi(api_client)
    start = '2013-10-20' # date |  (optional)
    end = '2013-10-20' # date |  (optional)

    try:
        # Expense breakdown grouped by tag
        api_response = api_instance.get_expense_by_tag(start=start, end=end)
        print("The response of SystemApi->get_expense_by_tag:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SystemApi->get_expense_by_tag: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **date**|  | [optional] 
 **end** | **date**|  | [optional] 

### Return type

[**GetExpenseByTagResponse**](GetExpenseByTagResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Per-tag expense rows. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_feature_flags**
> GetFeatureFlagsResponse get_feature_flags()

Feature flags for this account

The feature-flag matrix this account currently sees. Each entry
carries the flag name, on/off, and an optional variant string for
A/B experiments.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_feature_flags_response import GetFeatureFlagsResponse
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
    api_instance = monarch_bridge_client.SystemApi(api_client)

    try:
        # Feature flags for this account
        api_response = api_instance.get_feature_flags()
        print("The response of SystemApi->get_feature_flags:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SystemApi->get_feature_flags: %s\n" % e)
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

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | All active feature flags. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_financial_insight**
> GetFinancialInsightResponse get_financial_insight(id)

Single AI savings insight

Detail view of one insight, including the optional `playbook.diySteps`
(do-it-yourself walkthrough text) and `paymentAccount` label when relevant.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_financial_insight_response import GetFinancialInsightResponse
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
    api_instance = monarch_bridge_client.SystemApi(api_client)
    id = 'id_example' # str | Monarch financial insight id.

    try:
        # Single AI savings insight
        api_response = api_instance.get_financial_insight(id)
        print("The response of SystemApi->get_financial_insight:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SystemApi->get_financial_insight: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch financial insight id. | 

### Return type

[**GetFinancialInsightResponse**](GetFinancialInsightResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Insight detail. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_health**
> GetHealthResponse get_health()

Liveness probe with auth-presence hint

Cheap liveness check for the proxy itself. Always returns 200 if the
HTTP server is up. Body includes a `monarchAuthLoaded` flag so callers
can distinguish "service alive but unauthenticated" from "service
alive and ready". No session required.

Use for uptime monitoring, LaunchAgent readiness checks, or as a
first-call probe before calling any data endpoint. For richer auth
detail use `GET /v1/auth/status`.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_health_response import GetHealthResponse
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
    api_instance = monarch_bridge_client.SystemApi(api_client)

    try:
        # Liveness probe with auth-presence hint
        api_response = api_instance.get_health()
        print("The response of SystemApi->get_health:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SystemApi->get_health: %s\n" % e)
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

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Service is up. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_income_report**
> GetIncomeReportResponse get_income_report(start=start, end=end)

Income report

Income breakdown for a date window: total income, average monthly
income, and per-source split. Backs the web Reports page Income tab.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_income_report_response import GetIncomeReportResponse
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
    api_instance = monarch_bridge_client.SystemApi(api_client)
    start = '2013-10-20' # date | Lower bound (inclusive), `YYYY-MM-DD`. (optional)
    end = '2013-10-20' # date | Upper bound (inclusive), `YYYY-MM-DD`. (optional)

    try:
        # Income report
        api_response = api_instance.get_income_report(start=start, end=end)
        print("The response of SystemApi->get_income_report:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SystemApi->get_income_report: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **date**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 
 **end** | **date**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 

### Return type

[**GetIncomeReportResponse**](GetIncomeReportResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Income summary plus source breakdown. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_income_vs_expense_yoy**
> GetIncomeVsExpenseYoyResponse get_income_vs_expense_yoy(years=years)

Income vs. expense year-over-year

Compares income vs. expense across years. Each point carries a
period label (typically a month) plus the income and expense
totals for that period.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_income_vs_expense_yoy_response import GetIncomeVsExpenseYoyResponse
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
    api_instance = monarch_bridge_client.SystemApi(api_client)
    years = 2 # int | How many years of history to include; defaults to 2. (optional) (default to 2)

    try:
        # Income vs. expense year-over-year
        api_response = api_instance.get_income_vs_expense_yoy(years=years)
        print("The response of SystemApi->get_income_vs_expense_yoy:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SystemApi->get_income_vs_expense_yoy: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **years** | **int**| How many years of history to include; defaults to 2. | [optional] [default to 2]

### Return type

[**GetIncomeVsExpenseYoyResponse**](GetIncomeVsExpenseYoyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Period-level income/expense points. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_integration_status**
> GetIntegrationStatusResponse get_integration_status()

Per-credential integration health

Per-credential health for each linked provider (Plaid / MX /
Finicity / manual). The web app's "Connection issues" banner walks
this list and surfaces any row with `needsReauth=true` or a non-null
`errorCode`.

`status` values: `connected`, `syncing`, `error`, `disconnected`.
`provider` values: `plaid`, `mx`, `finicity`, `manual`.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_integration_status_response import GetIntegrationStatusResponse
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
    api_instance = monarch_bridge_client.SystemApi(api_client)

    try:
        # Per-credential integration health
        api_response = api_instance.get_integration_status()
        print("The response of SystemApi->get_integration_status:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SystemApi->get_integration_status: %s\n" % e)
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

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Per-credential health rows. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_latest_insight_run**
> GetLatestInsightRunResponse get_latest_insight_run()

Latest financial-insight run + insights count

Returns just the latest run metadata (id, status, errorMessage,
insightsGeneratedCount) and the current total insights count.
Faster than `/v1/insights` when all you need is freshness.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_latest_insight_run_response import GetLatestInsightRunResponse
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
    api_instance = monarch_bridge_client.SystemApi(api_client)

    try:
        # Latest financial-insight run + insights count
        api_response = api_instance.get_latest_insight_run()
        print("The response of SystemApi->get_latest_insight_run:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SystemApi->get_latest_insight_run: %s\n" % e)
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

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Latest insight run. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_latest_refresh_operation**
> GetLatestRefreshOperationResponse get_latest_refresh_operation()

Latest force-refresh operation

Single global force-refresh request from this user (id + state). Useful as a
lightweight alternative to `/v1/refresh/status` when you only need to know
"is a refresh currently running" rather than per-account breakdown.

States observed in the wild: `IN_PROGRESS`, `COMPLETED`, `FAILED`. May return
null when the user has never triggered a force refresh.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_latest_refresh_operation_response import GetLatestRefreshOperationResponse
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
    api_instance = monarch_bridge_client.SystemApi(api_client)

    try:
        # Latest force-refresh operation
        api_response = api_instance.get_latest_refresh_operation()
        print("The response of SystemApi->get_latest_refresh_operation:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SystemApi->get_latest_refresh_operation: %s\n" % e)
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

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Latest operation snapshot (may be null). |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_lookup**
> GetLookupResponse get_lookup(q)

Cross-entity fuzzy lookup

One-shot semantic search across accounts + categories + tags + merchants.
Backs Monarch's web command palette. Each result is tagged with its
`type` so the caller can route to the right resource.

Cuts the typical "search accounts then categories then tags then merchants"
round-trip dance to one. Use from AI assistants that need to resolve a
free-form user reference ("my Chase card", "the Coffee category") to a
Monarch entity id.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_lookup_response import GetLookupResponse
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
    api_instance = monarch_bridge_client.SystemApi(api_client)
    q = 'q_example' # str | Free-text query - matches across all entity types Monarch indexes for the palette.

    try:
        # Cross-entity fuzzy lookup
        api_response = api_instance.get_lookup(q)
        print("The response of SystemApi->get_lookup:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SystemApi->get_lookup: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **q** | **str**| Free-text query - matches across all entity types Monarch indexes for the palette. | 

### Return type

[**GetLookupResponse**](GetLookupResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Matching entities with &#x60;type&#x60; discriminator. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_monthly_report_summary**
> GetMonthlyReportSummaryResponse get_monthly_report_summary(month)

Monthly report summary

One-month summary bundle Monarch sends to the monthly-recap email
and the web monthly-summary widget. Single-row aggregate covering
net income, total spending, total income, savings rate, and the top
merchant / category callouts.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_monthly_report_summary_response import GetMonthlyReportSummaryResponse
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
    api_instance = monarch_bridge_client.SystemApi(api_client)
    month = '2013-10-20' # date | First-of-month date, e.g. `2026-05-01`.

    try:
        # Monthly report summary
        api_response = api_instance.get_monthly_report_summary(month)
        print("The response of SystemApi->get_monthly_report_summary:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SystemApi->get_monthly_report_summary: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **month** | **date**| First-of-month date, e.g. &#x60;2026-05-01&#x60;. | 

### Return type

[**GetMonthlyReportSummaryResponse**](GetMonthlyReportSummaryResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Monthly summary. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_net_worth_report**
> GetNetWorthReportResponse get_net_worth_report(start=start, end=end)

Net-worth report

Net-worth chart series for the requested window plus starting and
current totals and absolute / percent change. Backs the web Reports
page Net Worth tab.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_net_worth_report_response import GetNetWorthReportResponse
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
    api_instance = monarch_bridge_client.SystemApi(api_client)
    start = '2013-10-20' # date | Lower bound (inclusive), `YYYY-MM-DD`. (optional)
    end = '2013-10-20' # date | Upper bound (inclusive), `YYYY-MM-DD`. (optional)

    try:
        # Net-worth report
        api_response = api_instance.get_net_worth_report(start=start, end=end)
        print("The response of SystemApi->get_net_worth_report:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SystemApi->get_net_worth_report: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **date**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 
 **end** | **date**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 

### Return type

[**GetNetWorthReportResponse**](GetNetWorthReportResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Net-worth totals plus per-date series. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_notifications**
> GetNotificationsResponse get_notifications(first=first, after_cursor=after_cursor)

Notification center (activity events)

Paginated activity-event stream backing the in-app bell. Each event
has a title/body, an action link (`action`, `actionLabel`,
`secondaryUrl`), a priority bucket, read state (`readAt`), and a
pinned/dismissed flag pair. Returns `pageInfo.endCursor` for the next
page via `?afterCursor=`.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_notifications_response import GetNotificationsResponse
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
    api_instance = monarch_bridge_client.SystemApi(api_client)
    first = 20 # int | Max number of events to return. (optional) (default to 20)
    after_cursor = 'after_cursor_example' # str | Pagination cursor from previous response's `pageInfo.endCursor`. (optional)

    try:
        # Notification center (activity events)
        api_response = api_instance.get_notifications(first=first, after_cursor=after_cursor)
        print("The response of SystemApi->get_notifications:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SystemApi->get_notifications: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **first** | **int**| Max number of events to return. | [optional] [default to 20]
 **after_cursor** | **str**| Pagination cursor from previous response&#39;s &#x60;pageInfo.endCursor&#x60;. | [optional] 

### Return type

[**GetNotificationsResponse**](GetNotificationsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | A page of activity events. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_platform_config**
> GetPlatformConfigResponse get_platform_config()

Platform configuration

Per-platform config blob: API base URL, config version, plus
arbitrary additional settings the client honors. Used by the web
app on boot to hydrate its environment.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_platform_config_response import GetPlatformConfigResponse
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
    api_instance = monarch_bridge_client.SystemApi(api_client)

    try:
        # Platform configuration
        api_response = api_instance.get_platform_config()
        print("The response of SystemApi->get_platform_config:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SystemApi->get_platform_config: %s\n" % e)
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

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Platform config object. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_plus_tier_access**
> GetPlusTierAccessResponse get_plus_tier_access()

Plus-tier access info

Subscription entitlements plus Plus-trial window endpoints
(`plusTrialEndsAt`, `canceledPlusTrialAt`). Use to gate "you are in
your trial" banners and Plus-feature promotional copy.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_plus_tier_access_response import GetPlusTierAccessResponse
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
    api_instance = monarch_bridge_client.SystemApi(api_client)

    try:
        # Plus-tier access info
        api_response = api_instance.get_plus_tier_access()
        print("The response of SystemApi->get_plus_tier_access:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SystemApi->get_plus_tier_access: %s\n" % e)
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

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Entitlements + Plus-trial timestamps. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_refresh_status**
> GetRefreshStatusResponse get_refresh_status()

Poll per-account sync status

Snapshot of Monarch's per-account sync state. Use after firing
`POST /v1/refresh` to know when the re-poll is done: keep calling until
`data.allComplete` is true (typically 5-60s depending on institution).

Returns each account's `hasSyncInProgress` flag plus an aggregate
`allComplete` rollup. For the synchronous "fire-and-wait" version
that blocks until done, use `POST /v1/refresh/wait` instead.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_refresh_status_response import GetRefreshStatusResponse
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
    api_instance = monarch_bridge_client.SystemApi(api_client)

    try:
        # Poll per-account sync status
        api_response = api_instance.get_refresh_status()
        print("The response of SystemApi->get_refresh_status:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SystemApi->get_refresh_status: %s\n" % e)
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

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Per-account sync flags. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_savings_rate_report**
> GetSavingsRateReportResponse get_savings_rate_report(start=start, end=end)

Savings-rate report

Month-over-month savings rate report. Rates are fractions
(`0.42` = 42%). `overallSavingsRate` is the window aggregate;
`monthlyRates` is the per-month series.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_savings_rate_report_response import GetSavingsRateReportResponse
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
    api_instance = monarch_bridge_client.SystemApi(api_client)
    start = '2013-10-20' # date | Lower bound (inclusive), `YYYY-MM-DD`. (optional)
    end = '2013-10-20' # date | Upper bound (inclusive), `YYYY-MM-DD`. (optional)

    try:
        # Savings-rate report
        api_response = api_instance.get_savings_rate_report(start=start, end=end)
        print("The response of SystemApi->get_savings_rate_report:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SystemApi->get_savings_rate_report: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **date**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 
 **end** | **date**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 

### Return type

[**GetSavingsRateReportResponse**](GetSavingsRateReportResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Overall savings rate plus per-month series. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_savings_rate_trends**
> GetSavingsRateTrendsResponse get_savings_rate_trends(months=months)

Savings-rate trend series

Savings rate (income minus expense divided by income) plotted per
period. Each point carries the period label, the savings rate, and
the underlying income and expense totals.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_savings_rate_trends_response import GetSavingsRateTrendsResponse
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
    api_instance = monarch_bridge_client.SystemApi(api_client)
    months = 12 # int | How many months of history; defaults to 12. (optional) (default to 12)

    try:
        # Savings-rate trend series
        api_response = api_instance.get_savings_rate_trends(months=months)
        print("The response of SystemApi->get_savings_rate_trends:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SystemApi->get_savings_rate_trends: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **months** | **int**| How many months of history; defaults to 12. | [optional] [default to 12]

### Return type

[**GetSavingsRateTrendsResponse**](GetSavingsRateTrendsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Savings-rate trend points. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_spending_report**
> GetSpendingReportResponse get_spending_report(start=start, end=end)

Spending report

High-level spending vs. budget summary for a date window with the
top-N category breakdown. Backs the web Reports page Spending tab.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_spending_report_response import GetSpendingReportResponse
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
    api_instance = monarch_bridge_client.SystemApi(api_client)
    start = '2013-10-20' # date | Lower bound (inclusive), `YYYY-MM-DD`. (optional)
    end = '2013-10-20' # date | Upper bound (inclusive), `YYYY-MM-DD`. (optional)

    try:
        # Spending report
        api_response = api_instance.get_spending_report(start=start, end=end)
        print("The response of SystemApi->get_spending_report:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SystemApi->get_spending_report: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **date**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 
 **end** | **date**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 

### Return type

[**GetSpendingReportResponse**](GetSpendingReportResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Spending summary plus top categories. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_subscription**
> GetSubscriptionResponse get_subscription()

Monarch subscription tier + payment source

Returns the household's Monarch subscription details: current plan
(Plus, Premium, etc.), trial state, renewal date, and the payment
source (Stripe / Apple App Store / Play Store).

Useful for checking entitlement before calling tier-gated endpoints
(some richer reporting features fall back to empty responses on free
tier) or for surfacing renewal warnings to the user.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_subscription_response import GetSubscriptionResponse
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
    api_instance = monarch_bridge_client.SystemApi(api_client)

    try:
        # Monarch subscription tier + payment source
        api_response = api_instance.get_subscription()
        print("The response of SystemApi->get_subscription:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SystemApi->get_subscription: %s\n" % e)
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

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Subscription details. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_subscription_details**
> GetSubscriptionDetailsResponse get_subscription_details()

Detailed subscription info

Full subscription detail beyond `GET /v1/subscription`: tier, renewal
date, billing frequency, amount, payment method, trial dates.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_subscription_details_response import GetSubscriptionDetailsResponse
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
    api_instance = monarch_bridge_client.SystemApi(api_client)

    try:
        # Detailed subscription info
        api_response = api_instance.get_subscription_details()
        print("The response of SystemApi->get_subscription_details:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SystemApi->get_subscription_details: %s\n" % e)
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

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Subscription detail object. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_subscription_invoices**
> GetSubscriptionInvoicesResponse get_subscription_invoices()

Subscription invoice history

Billing-history rows shown on the Settings → Billing page. Each row
is one charge (monthly / annual / proration) with status, amount,
PDF receipt URL, and the period it covered.

`status` values seen in production: `paid`, `pending`, `failed`,
`refunded`.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_subscription_invoices_response import GetSubscriptionInvoicesResponse
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
    api_instance = monarch_bridge_client.SystemApi(api_client)

    try:
        # Subscription invoice history
        api_response = api_instance.get_subscription_invoices()
        print("The response of SystemApi->get_subscription_invoices:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SystemApi->get_subscription_invoices: %s\n" % e)
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

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | All subscription invoices for the household. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_subscription_receipts**
> GetSubscriptionReceiptsResponse get_subscription_receipts()

Subscription payment receipts

All payment receipts for the current subscription, with download
URLs. Used at tax time for proof of expense.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_subscription_receipts_response import GetSubscriptionReceiptsResponse
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
    api_instance = monarch_bridge_client.SystemApi(api_client)

    try:
        # Subscription payment receipts
        api_response = api_instance.get_subscription_receipts()
        print("The response of SystemApi->get_subscription_receipts:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SystemApi->get_subscription_receipts: %s\n" % e)
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

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Receipts list. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_tag_report**
> GetTagReportResponse get_tag_report(tag_id, start=start, end=end)

Per-tag historical report

Per-month series for one transaction tag across a window. Backs the
"view tag" drill-down in the web Reports tab. Each month carries both
the sum amount and the transaction count, so callers can render either
a spend chart or a frequency chart from one response.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_tag_report_response import GetTagReportResponse
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
    api_instance = monarch_bridge_client.SystemApi(api_client)
    tag_id = 'tag_id_example' # str | Monarch tag id.
    start = '2013-10-20' # date | Lower bound (inclusive), `YYYY-MM-DD`. (optional)
    end = '2013-10-20' # date | Upper bound (inclusive), `YYYY-MM-DD`. (optional)

    try:
        # Per-tag historical report
        api_response = api_instance.get_tag_report(tag_id, start=start, end=end)
        print("The response of SystemApi->get_tag_report:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SystemApi->get_tag_report: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tag_id** | **str**| Monarch tag id. | 
 **start** | **date**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 
 **end** | **date**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 

### Return type

[**GetTagReportResponse**](GetTagReportResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Per-month sums + counts for the tag. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_weekly_recap**
> GetWeeklyRecapResponse get_weekly_recap(start, end)

Weekly recap

AI-generated narrative recap for one week. Monarch backfills this on a schedule.
Pick `start` = Monday, `end` = Sunday of the target week. Returns `null` recap if
Monarch has not generated one for that window yet.

Includes a top-level `summary` plus per-module `cards` (cashflow card, biggest
spend, savings progress, etc.) with both rich-block JSON and markdown variants.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_weekly_recap_response import GetWeeklyRecapResponse
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
    api_instance = monarch_bridge_client.SystemApi(api_client)
    start = '2013-10-20' # date | Week start (inclusive), `YYYY-MM-DD`. Typically a Monday.
    end = '2013-10-20' # date | Week end (inclusive), `YYYY-MM-DD`. Typically a Sunday.

    try:
        # Weekly recap
        api_response = api_instance.get_weekly_recap(start, end)
        print("The response of SystemApi->get_weekly_recap:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SystemApi->get_weekly_recap: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **date**| Week start (inclusive), &#x60;YYYY-MM-DD&#x60;. Typically a Monday. | 
 **end** | **date**| Week end (inclusive), &#x60;YYYY-MM-DD&#x60;. Typically a Sunday. | 

### Return type

[**GetWeeklyRecapResponse**](GetWeeklyRecapResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Recap (may be null). |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_zestimate**
> GetZestimateResponse get_zestimate(get_zestimate_request)

Zillow Zestimate lookup

Resolve a free-form street address to one or more Zillow `Zestimate`
rows (Zillow property id + parsed address + dollar estimate). Used by
the real-estate account creation flow to pre-fill home value.

Returns an empty array if Zillow has no match. A free-form address
can return multiple Zestimates when the property has been split or
Zillow has near-duplicate records.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_zestimate_response import GetZestimateResponse
from monarch_bridge_client.models.get_zestimate_request import GetZestimateRequest
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
    api_instance = monarch_bridge_client.SystemApi(api_client)
    get_zestimate_request = monarch_bridge_client.GetZestimateRequest() # GetZestimateRequest | 

    try:
        # Zillow Zestimate lookup
        api_response = api_instance.get_zestimate(get_zestimate_request)
        print("The response of SystemApi->get_zestimate:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SystemApi->get_zestimate: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **get_zestimate_request** | [**GetZestimateRequest**](GetZestimateRequest.md)|  | 

### Return type

[**GetZestimateResponse**](GetZestimateResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Zero or more Zestimate matches. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **initiate_password_change**
> InitiatePasswordChangeResponse initiate_password_change()

Initiate password change

Trigger Monarch's password-change flow. No body required. Monarch
emails a reset link to the account's verified email; the response
echoes back the `requestId` + `email` for client-side confirmation.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.initiate_password_change_response import InitiatePasswordChangeResponse
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
    api_instance = monarch_bridge_client.SystemApi(api_client)

    try:
        # Initiate password change
        api_response = api_instance.initiate_password_change()
        print("The response of SystemApi->initiate_password_change:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SystemApi->initiate_password_change: %s\n" % e)
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

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Reset-token-issued confirmation. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_financial_insights**
> ListFinancialInsightsResponse list_financial_insights(status=status, summary_start=summary_start, summary_end=summary_end)

List AI savings insights

Monarch's AI-driven money-saving opportunities (subscription audits, bill
negotiation candidates, etc.). Each insight has a savings estimate range,
effort tag, and current annual cost. Filter by status (e.g. `NEW`, `ACCEPTED`).

Also returns an aggregate `summary` over the window (counts + identified
savings totals) and the `latestRun` metadata to gauge freshness.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.list_financial_insights_response import ListFinancialInsightsResponse
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
    api_instance = monarch_bridge_client.SystemApi(api_client)
    status = ['status_example'] # List[str] | Filter to one or more `InsightStatusEnum` values. Repeat the param for each. (optional)
    summary_start = '2013-10-20' # date | Lower bound for the `summary` aggregate window. (optional)
    summary_end = '2013-10-20' # date | Upper bound for the `summary` aggregate window. (optional)

    try:
        # List AI savings insights
        api_response = api_instance.list_financial_insights(status=status, summary_start=summary_start, summary_end=summary_end)
        print("The response of SystemApi->list_financial_insights:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SystemApi->list_financial_insights: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **status** | [**List[str]**](str.md)| Filter to one or more &#x60;InsightStatusEnum&#x60; values. Repeat the param for each. | [optional] 
 **summary_start** | **date**| Lower bound for the &#x60;summary&#x60; aggregate window. | [optional] 
 **summary_end** | **date**| Upper bound for the &#x60;summary&#x60; aggregate window. | [optional] 

### Return type

[**ListFinancialInsightsResponse**](ListFinancialInsightsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Insights plus summary plus latest-run metadata. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mark_all_notifications_as_read**
> MarkAllNotificationsAsReadResponse mark_all_notifications_as_read(first=first)

Mark all notifications as read

Bulk-flip `readAt` for every activity event in the bell. Echoes back
the first page of events (so the client can refresh state without a
second round-trip).


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.mark_all_notifications_as_read_response import MarkAllNotificationsAsReadResponse
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
    api_instance = monarch_bridge_client.SystemApi(api_client)
    first = 20 # int | Page size for the echoed event list. (optional) (default to 20)

    try:
        # Mark all notifications as read
        api_response = api_instance.mark_all_notifications_as_read(first=first)
        print("The response of SystemApi->mark_all_notifications_as_read:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SystemApi->mark_all_notifications_as_read: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **first** | **int**| Page size for the echoed event list. | [optional] [default to 20]

### Return type

[**MarkAllNotificationsAsReadResponse**](MarkAllNotificationsAsReadResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Updated id + readAt for each event in the echoed page. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mark_notification_as_read**
> MarkNotificationAsReadResponse mark_notification_as_read(id)

Mark one notification as read

Flip a single activity event's `readAt` to now. Used by the bell UI
when an event is opened or clicked. Idempotent.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.mark_notification_as_read_response import MarkNotificationAsReadResponse
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
    api_instance = monarch_bridge_client.SystemApi(api_client)
    id = 'id_example' # str | Monarch activity-event id.

    try:
        # Mark one notification as read
        api_response = api_instance.mark_notification_as_read(id)
        print("The response of SystemApi->mark_notification_as_read:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SystemApi->mark_notification_as_read: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch activity-event id. | 

### Return type

[**MarkNotificationAsReadResponse**](MarkNotificationAsReadResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Updated event id + readAt timestamp. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **pause_subscription**
> PauseSubscriptionResponse pause_subscription(pause_subscription_request=pause_subscription_request)

Pause the subscription

Suspends billing without canceling. Provide `resumeAt` to auto-resume
on a date; omit for indefinite pause. Read-only data access remains
during a pause.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.pause_subscription_response import PauseSubscriptionResponse
from monarch_bridge_client.models.pause_subscription_request import PauseSubscriptionRequest
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
    api_instance = monarch_bridge_client.SystemApi(api_client)
    pause_subscription_request = monarch_bridge_client.PauseSubscriptionRequest() # PauseSubscriptionRequest |  (optional)

    try:
        # Pause the subscription
        api_response = api_instance.pause_subscription(pause_subscription_request=pause_subscription_request)
        print("The response of SystemApi->pause_subscription:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SystemApi->pause_subscription: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **pause_subscription_request** | [**PauseSubscriptionRequest**](PauseSubscriptionRequest.md)|  | [optional] 

### Return type

[**PauseSubscriptionResponse**](PauseSubscriptionResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Pause confirmation. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **preview_subscription_plan_change**
> PreviewSubscriptionPlanChangeResponse preview_subscription_plan_change(preview_subscription_plan_change_request)

Preview a plan-change charge

Computes the prorated charge for switching to `targetTier` (and
optionally `billingFrequency`). Does NOT mutate the subscription.
Use to show "you will be charged USD X today" before the user confirms.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.preview_subscription_plan_change_response import PreviewSubscriptionPlanChangeResponse
from monarch_bridge_client.models.preview_subscription_plan_change_request import PreviewSubscriptionPlanChangeRequest
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
    api_instance = monarch_bridge_client.SystemApi(api_client)
    preview_subscription_plan_change_request = monarch_bridge_client.PreviewSubscriptionPlanChangeRequest() # PreviewSubscriptionPlanChangeRequest | 

    try:
        # Preview a plan-change charge
        api_response = api_instance.preview_subscription_plan_change(preview_subscription_plan_change_request)
        print("The response of SystemApi->preview_subscription_plan_change:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SystemApi->preview_subscription_plan_change: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **preview_subscription_plan_change_request** | [**PreviewSubscriptionPlanChangeRequest**](PreviewSubscriptionPlanChangeRequest.md)|  | 

### Return type

[**PreviewSubscriptionPlanChangeResponse**](PreviewSubscriptionPlanChangeResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Preview of prorated charge and new renewal date. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **refresh_auth**
> GetAuthStatusResponse refresh_auth()

Reload session JSON from disk

Re-reads `~/.config/monarch-bridge/.mm-session.json` and swaps in the new
token without a service restart.

Use after running the bootstrap CLI's re-auth flow (`mb auth login`) to
pick up freshly-issued credentials. Cheap call: just hits the local
filesystem and updates an in-memory atomic reference. Returns the
post-reload auth status so the caller knows immediately whether the new
session is loaded.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_auth_status_response import GetAuthStatusResponse
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
    api_instance = monarch_bridge_client.SystemApi(api_client)

    try:
        # Reload session JSON from disk
        api_response = api_instance.refresh_auth()
        print("The response of SystemApi->refresh_auth:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SystemApi->refresh_auth: %s\n" % e)
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

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Session reloaded; returns the new auth status. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **request_refresh**
> request_refresh(account_ids=account_ids)

Force Monarch to re-poll Plaid (async)

Triggers Monarch to re-poll Plaid for account balance and
transaction updates. Fire-and-forget: returns 202 immediately
after queueing the refresh.

Without `accountIds`, refreshes **every** linked account. Pass one
or more `accountIds` to scope. Poll progress with
`GET /v1/refresh/status` until `data.allComplete` is true (5-60s
typically depending on institution).

For a synchronous version that blocks until done, use
`POST /v1/refresh/wait`.


### Example


```python
import monarch_bridge_client
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
    api_instance = monarch_bridge_client.SystemApi(api_client)
    account_ids = ['account_ids_example'] # List[str] | Optional list of Monarch account ids. Omit to refresh all accounts. (optional)

    try:
        # Force Monarch to re-poll Plaid (async)
        api_instance.request_refresh(account_ids=account_ids)
    except Exception as e:
        print("Exception when calling SystemApi->request_refresh: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **account_ids** | [**List[str]**](str.md)| Optional list of Monarch account ids. Omit to refresh all accounts. | [optional] 

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
**202** | Refresh queued. |  -  |
**503** | No session loaded. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **request_refresh_and_wait**
> GetRefreshStatusResponse request_refresh_and_wait(timeout_seconds=timeout_seconds, account_ids=account_ids)

Force Monarch to re-poll Plaid and wait until every account has finished

Synchronous version of `POST /v1/refresh` + polling `GET /v1/refresh/status`.
Fires the refresh and blocks until every account reports `hasSyncInProgress: false`
or the timeout elapses (default 60s, max 300s; cap via `timeoutSeconds`).
Without `accountIds`, refreshes **every** linked account. Pass one or more
`accountIds` to scope the refresh.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_refresh_status_response import GetRefreshStatusResponse
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
    api_instance = monarch_bridge_client.SystemApi(api_client)
    timeout_seconds = 60 # int | Max time to poll before returning the last-seen status. (optional) (default to 60)
    account_ids = ['account_ids_example'] # List[str] | Optional list of Monarch account ids. Omit to refresh all accounts. (optional)

    try:
        # Force Monarch to re-poll Plaid and wait until every account has finished
        api_response = api_instance.request_refresh_and_wait(timeout_seconds=timeout_seconds, account_ids=account_ids)
        print("The response of SystemApi->request_refresh_and_wait:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SystemApi->request_refresh_and_wait: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **timeout_seconds** | **int**| Max time to poll before returning the last-seen status. | [optional] [default to 60]
 **account_ids** | [**List[str]**](str.md)| Optional list of Monarch account ids. Omit to refresh all accounts. | [optional] 

### Return type

[**GetRefreshStatusResponse**](GetRefreshStatusResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Final per-account sync flags after the wait. |  -  |
**503** | No session loaded. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **resume_subscription**
> ResumeSubscriptionResponse resume_subscription()

Resume a paused subscription

Lifts a pause and resumes billing immediately. No-op if the
subscription is already active.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.resume_subscription_response import ResumeSubscriptionResponse
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
    api_instance = monarch_bridge_client.SystemApi(api_client)

    try:
        # Resume a paused subscription
        api_response = api_instance.resume_subscription()
        print("The response of SystemApi->resume_subscription:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SystemApi->resume_subscription: %s\n" % e)
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

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Resume confirmation. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

