# monarch_bridge_client.RecurringApi

All URIs are relative to *http://localhost:9084*

Method | HTTP request | Description
------------- | ------------- | -------------
[**get_recurring_dashboard**](RecurringApi.md#get_recurring_dashboard) | **GET** /v1/recurring/dashboard | Dashboard view of upcoming recurring items + total due
[**get_recurring_forecast**](RecurringApi.md#get_recurring_forecast) | **GET** /v1/recurring/forecast | Recurring transaction forecast
[**list_all_recurring**](RecurringApi.md#list_all_recurring) | **GET** /v1/recurring/all | All recurring streams with next-occurrence detail
[**list_recurring**](RecurringApi.md#list_recurring) | **GET** /v1/recurring | Upcoming + recent recurring transaction occurrences
[**list_recurring_aggregate**](RecurringApi.md#list_recurring_aggregate) | **GET** /v1/recurring/aggregate | Month-by-month aggregate recurring view
[**list_recurring_streams**](RecurringApi.md#list_recurring_streams) | **GET** /v1/recurring/streams | Recurring stream definitions
[**merge_recurring_streams**](RecurringApi.md#merge_recurring_streams) | **POST** /v1/recurring/streams/merge | Merge recurring streams
[**skip_recurring_instance**](RecurringApi.md#skip_recurring_instance) | **POST** /v1/recurring/{id}/skip | Skip one expected occurrence
[**update_merchant_recurrence**](RecurringApi.md#update_merchant_recurrence) | **PATCH** /v1/merchants/{id}/recurrence | Update a merchant&#39;s recurring-transaction settings


# **get_recurring_dashboard**
> GetRecurringDashboardResponse get_recurring_dashboard(start=start, end=end, include_liabilities=include_liabilities)

Dashboard view of upcoming recurring items + total due

Returns the per-item upcoming recurring transaction stream PLUS the
remaining-due dollar total for the same window. Drop-in shape for a
"next 30 days bills" widget.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_recurring_dashboard_response import GetRecurringDashboardResponse
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
    api_instance = monarch_bridge_client.RecurringApi(api_client)
    start = '2013-10-20' # date | Lower bound (inclusive), `YYYY-MM-DD`. (optional)
    end = '2013-10-20' # date | Upper bound (inclusive), `YYYY-MM-DD`. (optional)
    include_liabilities = True # bool | Include liability payments (credit cards, loans) in the list. (optional)

    try:
        # Dashboard view of upcoming recurring items + total due
        api_response = api_instance.get_recurring_dashboard(start=start, end=end, include_liabilities=include_liabilities)
        print("The response of RecurringApi->get_recurring_dashboard:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling RecurringApi->get_recurring_dashboard: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **date**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 
 **end** | **date**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 
 **include_liabilities** | **bool**| Include liability payments (credit cards, loans) in the list. | [optional] 

### Return type

[**GetRecurringDashboardResponse**](GetRecurringDashboardResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Upcoming items + remaining-due summary. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_recurring_forecast**
> GetRecurringForecastResponse get_recurring_forecast(start=start, end=end)

Recurring transaction forecast

Forward calendar of forecast recurring occurrences for a date
window. One entry per occurrence with date, amount, merchant,
and linked stream id.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_recurring_forecast_response import GetRecurringForecastResponse
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
    api_instance = monarch_bridge_client.RecurringApi(api_client)
    start = '2013-10-20' # date | Lower bound (inclusive), `YYYY-MM-DD`. (optional)
    end = '2013-10-20' # date | Upper bound (inclusive), `YYYY-MM-DD`. (optional)

    try:
        # Recurring transaction forecast
        api_response = api_instance.get_recurring_forecast(start=start, end=end)
        print("The response of RecurringApi->get_recurring_forecast:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling RecurringApi->get_recurring_forecast: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **date**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 
 **end** | **date**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 

### Return type

[**GetRecurringForecastResponse**](GetRecurringForecastResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Forecast occurrences. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_all_recurring**
> ListAllRecurringResponse list_all_recurring(include_liabilities=include_liabilities, include_pending=include_pending)

All recurring streams with next-occurrence detail

Stream-shaped recurring view: one entry per recurring transaction
stream (NOT per occurrence; see `GET /v1/recurring` for the
per-date calendar view). Each entry carries the stream definition,
the next forecasted occurrence, plus the merchant, category, and
account references resolved to full objects.

Use for a "all my subscriptions and bills" view. Toggle
`includeLiabilities` to add credit-report-derived streams (loans,
credit-card minimum payments). Toggle `includePending` to include
streams Monarch hasn't yet confirmed as recurring.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.list_all_recurring_response import ListAllRecurringResponse
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
    api_instance = monarch_bridge_client.RecurringApi(api_client)
    include_liabilities = True # bool | Include liability-account-derived streams. (optional)
    include_pending = True # bool | Include pending (not-yet-confirmed) streams. (optional)

    try:
        # All recurring streams with next-occurrence detail
        api_response = api_instance.list_all_recurring(include_liabilities=include_liabilities, include_pending=include_pending)
        print("The response of RecurringApi->list_all_recurring:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling RecurringApi->list_all_recurring: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **include_liabilities** | **bool**| Include liability-account-derived streams. | [optional] 
 **include_pending** | **bool**| Include pending (not-yet-confirmed) streams. | [optional] 

### Return type

[**ListAllRecurringResponse**](ListAllRecurringResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | All recurring streams. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_recurring**
> ListRecurringResponse list_recurring(start=start, end=end)

Upcoming + recent recurring transaction occurrences

Calendar-shaped view: one entry per expected recurring
transaction occurrence within `[start, end]`. Each entry has the
forecasted date, merchant, category, account, amount, and a
`status` (`completed`, `pending`, `predicted`).

Use for a "what's coming up" subscription/bill view or to
reconcile expected vs actual recurring spend. For the stream-
shaped view (one row per recurring stream, not per occurrence)
use `GET /v1/recurring/all`; for month-level aggregate totals
use `GET /v1/recurring/aggregate`.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.list_recurring_response import ListRecurringResponse
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
    api_instance = monarch_bridge_client.RecurringApi(api_client)
    start = '2013-10-20' # date | Lower bound (inclusive), `YYYY-MM-DD`. (optional)
    end = '2013-10-20' # date | Upper bound (inclusive), `YYYY-MM-DD`. (optional)

    try:
        # Upcoming + recent recurring transaction occurrences
        api_response = api_instance.list_recurring(start=start, end=end)
        print("The response of RecurringApi->list_recurring:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling RecurringApi->list_recurring: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **date**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 
 **end** | **date**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 

### Return type

[**ListRecurringResponse**](ListRecurringResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | One entry per expected occurrence in the window. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_recurring_aggregate**
> ListRecurringAggregateResponse list_recurring_aggregate(start=start, end=end)

Month-by-month aggregate recurring view

Aggregates recurring-transaction occurrences in the window, grouped
by status (`completed`, `remaining`, etc.) and rolled up into
`expense` / `creditCard` / `income` totals per-group AND across the
whole window.

Use for "what recurring spend hits this month" or "what's already
happened vs still pending" summaries. For the per-occurrence
calendar view use `GET /v1/recurring`; for stream definitions use
`GET /v1/recurring/streams`.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.list_recurring_aggregate_response import ListRecurringAggregateResponse
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
    api_instance = monarch_bridge_client.RecurringApi(api_client)
    start = '2013-10-20' # date | Lower bound (inclusive), `YYYY-MM-DD`. (optional)
    end = '2013-10-20' # date | Upper bound (inclusive), `YYYY-MM-DD`. (optional)

    try:
        # Month-by-month aggregate recurring view
        api_response = api_instance.list_recurring_aggregate(start=start, end=end)
        print("The response of RecurringApi->list_recurring_aggregate:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling RecurringApi->list_recurring_aggregate: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **date**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 
 **end** | **date**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 

### Return type

[**ListRecurringAggregateResponse**](ListRecurringAggregateResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Aggregated tree from Monarch (pass-through). |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_recurring_streams**
> ListRecurringStreamsResponse list_recurring_streams(include_liabilities=include_liabilities)

Recurring stream definitions

Returns the raw recurrence rules behind each stream: review status,
base date, frequency (`weekly`, `monthly`, etc.), expected
day-of-month, and any linked credit-report liability account.

Lighter than `GET /v1/recurring/all` which adds merchant /
category resolution. Use to build an editing UI for recurrence
rules; pair with `PATCH /v1/merchants/{id}/recurrence` to mutate
the rule for a specific merchant. Toggle `includeLiabilities` to
add credit-report-derived streams.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.list_recurring_streams_response import ListRecurringStreamsResponse
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
    api_instance = monarch_bridge_client.RecurringApi(api_client)
    include_liabilities = True # bool | Include liability-account-derived streams. (optional)

    try:
        # Recurring stream definitions
        api_response = api_instance.list_recurring_streams(include_liabilities=include_liabilities)
        print("The response of RecurringApi->list_recurring_streams:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling RecurringApi->list_recurring_streams: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **include_liabilities** | **bool**| Include liability-account-derived streams. | [optional] 

### Return type

[**ListRecurringStreamsResponse**](ListRecurringStreamsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | All recurring streams. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **merge_recurring_streams**
> MergeRecurringStreamsResponse merge_recurring_streams(merge_recurring_streams_request)

Merge recurring streams

Collapse two or more recurring streams into one. The `primaryStreamId`
survives; all `mergedStreamIds` are absorbed into it (their
transactions, history, and rules transfer over). Optional `newName`
overrides the merged stream's display name.

Used when Monarch detects the same bill from two angles (credit-report
liability + transaction-feed merchant) and the user wants one canonical
stream.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.merge_recurring_streams_response import MergeRecurringStreamsResponse
from monarch_bridge_client.models.merge_recurring_streams_request import MergeRecurringStreamsRequest
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
    api_instance = monarch_bridge_client.RecurringApi(api_client)
    merge_recurring_streams_request = monarch_bridge_client.MergeRecurringStreamsRequest() # MergeRecurringStreamsRequest | 

    try:
        # Merge recurring streams
        api_response = api_instance.merge_recurring_streams(merge_recurring_streams_request)
        print("The response of RecurringApi->merge_recurring_streams:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling RecurringApi->merge_recurring_streams: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **merge_recurring_streams_request** | [**MergeRecurringStreamsRequest**](MergeRecurringStreamsRequest.md)|  | 

### Return type

[**MergeRecurringStreamsResponse**](MergeRecurringStreamsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The surviving stream. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **skip_recurring_instance**
> SkipRecurringInstanceResponse skip_recurring_instance(id, skip_recurring_instance_request)

Skip one expected occurrence

Dismiss a single expected occurrence of a recurring stream - the
"this month I'm skipping Netflix" button on the recurring tab.
Subsequent occurrences continue to fire on schedule.

Per-occurrence only. To dismiss the whole stream see the recurring
rule editor; to retire it permanently use
`POST /v1/transactions/{id}/not-recurring`.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.skip_recurring_instance_response import SkipRecurringInstanceResponse
from monarch_bridge_client.models.skip_recurring_instance_request import SkipRecurringInstanceRequest
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
    api_instance = monarch_bridge_client.RecurringApi(api_client)
    id = 'id_example' # str | Monarch recurring stream id.
    skip_recurring_instance_request = monarch_bridge_client.SkipRecurringInstanceRequest() # SkipRecurringInstanceRequest | 

    try:
        # Skip one expected occurrence
        api_response = api_instance.skip_recurring_instance(id, skip_recurring_instance_request)
        print("The response of RecurringApi->skip_recurring_instance:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling RecurringApi->skip_recurring_instance: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch recurring stream id. | 
 **skip_recurring_instance_request** | [**SkipRecurringInstanceRequest**](SkipRecurringInstanceRequest.md)|  | 

### Return type

[**SkipRecurringInstanceResponse**](SkipRecurringInstanceResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Skipped occurrence confirmation. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_merchant_recurrence**
> UpdateMerchantRecurrenceResponse update_merchant_recurrence(id, update_merchant_recurrence_request)

Update a merchant's recurring-transaction settings

Reconfigures the recurring-transaction stream rules tied to a
merchant: frequency, expected day-of-month, base date, whether
the stream is approved as recurring.

**Gotcha**: Monarch's mutation requires `name` even when only
changing recurrence fields. Pass the merchant's current display
name unchanged if you don't intend to rename. Use
`GET /v1/merchants/{id}` to fetch the current name first.

Pairs with `POST /v1/transactions/{id}/not-recurring` for the
"dismiss this false-positive stream" workflow.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.update_merchant_recurrence_response import UpdateMerchantRecurrenceResponse
from monarch_bridge_client.models.update_merchant_recurrence_request import UpdateMerchantRecurrenceRequest
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
    api_instance = monarch_bridge_client.RecurringApi(api_client)
    id = 'id_example' # str | Monarch merchant id.
    update_merchant_recurrence_request = monarch_bridge_client.UpdateMerchantRecurrenceRequest() # UpdateMerchantRecurrenceRequest | 

    try:
        # Update a merchant's recurring-transaction settings
        api_response = api_instance.update_merchant_recurrence(id, update_merchant_recurrence_request)
        print("The response of RecurringApi->update_merchant_recurrence:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling RecurringApi->update_merchant_recurrence: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch merchant id. | 
 **update_merchant_recurrence_request** | [**UpdateMerchantRecurrenceRequest**](UpdateMerchantRecurrenceRequest.md)|  | 

### Return type

[**UpdateMerchantRecurrenceResponse**](UpdateMerchantRecurrenceResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Updated merchant with recurrence stream. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

