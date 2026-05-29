# RecurringApi

All URIs are relative to **

Method | HTTP request | Description
------------- | ------------- | -------------
[**getRecurringDashboard**](RecurringApi.md#getRecurringDashboard) | **GET** /v1/recurring/dashboard | Dashboard view of upcoming recurring items + total due
[**getRecurringForecast**](RecurringApi.md#getRecurringForecast) | **GET** /v1/recurring/forecast | Recurring transaction forecast
[**listAllRecurring**](RecurringApi.md#listAllRecurring) | **GET** /v1/recurring/all | All recurring streams with next-occurrence detail
[**listRecurring**](RecurringApi.md#listRecurring) | **GET** /v1/recurring | Upcoming + recent recurring transaction occurrences
[**listRecurringAggregate**](RecurringApi.md#listRecurringAggregate) | **GET** /v1/recurring/aggregate | Month-by-month aggregate recurring view
[**listRecurringStreams**](RecurringApi.md#listRecurringStreams) | **GET** /v1/recurring/streams | Recurring stream definitions
[**mergeRecurringStreams**](RecurringApi.md#mergeRecurringStreams) | **POST** /v1/recurring/streams/merge | Merge recurring streams
[**skipRecurringInstance**](RecurringApi.md#skipRecurringInstance) | **POST** /v1/recurring/{id}/skip | Skip one expected occurrence
[**updateMerchantRecurrence**](RecurringApi.md#updateMerchantRecurrence) | **PATCH** /v1/merchants/{id}/recurrence | Update a merchant&#39;s recurring-transaction settings



## getRecurringDashboard

Dashboard view of upcoming recurring items + total due

Returns the per-item upcoming recurring transaction stream PLUS the
remaining-due dollar total for the same window. Drop-in shape for a
\"next 30 days bills\" widget.

### Example

```bash
monarch-api getRecurringDashboard  start=value  end=value  includeLiabilities=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **string** | Lower bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]
 **end** | **string** | Upper bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]
 **includeLiabilities** | **boolean** | Include liability payments (credit cards, loans) in the list. | [optional] [default to null]

### Return type

[**GetRecurringDashboard200Response**](GetRecurringDashboard200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getRecurringForecast

Recurring transaction forecast

Forward calendar of forecast recurring occurrences for a date
window. One entry per occurrence with date, amount, merchant,
and linked stream id.

### Example

```bash
monarch-api getRecurringForecast  start=value  end=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **string** | Lower bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]
 **end** | **string** | Upper bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]

### Return type

[**GetRecurringForecast200Response**](GetRecurringForecast200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## listAllRecurring

All recurring streams with next-occurrence detail

Stream-shaped recurring view: one entry per recurring transaction
stream (NOT per occurrence; see 'GET /v1/recurring' for the
per-date calendar view). Each entry carries the stream definition,
the next forecasted occurrence, plus the merchant, category, and
account references resolved to full objects.

Use for a \"all my subscriptions and bills\" view. Toggle
'includeLiabilities' to add credit-report-derived streams (loans,
credit-card minimum payments). Toggle 'includePending' to include
streams Monarch hasn't yet confirmed as recurring.

### Example

```bash
monarch-api listAllRecurring  includeLiabilities=value  includePending=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **includeLiabilities** | **boolean** | Include liability-account-derived streams. | [optional] [default to null]
 **includePending** | **boolean** | Include pending (not-yet-confirmed) streams. | [optional] [default to null]

### Return type

[**ListAllRecurring200Response**](ListAllRecurring200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## listRecurring

Upcoming + recent recurring transaction occurrences

Calendar-shaped view: one entry per expected recurring
transaction occurrence within '[start, end]'. Each entry has the
forecasted date, merchant, category, account, amount, and a
'status' ('completed', 'pending', 'predicted').

Use for a \"what's coming up\" subscription/bill view or to
reconcile expected vs actual recurring spend. For the stream-
shaped view (one row per recurring stream, not per occurrence)
use 'GET /v1/recurring/all'; for month-level aggregate totals
use 'GET /v1/recurring/aggregate'.

### Example

```bash
monarch-api listRecurring  start=value  end=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **string** | Lower bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]
 **end** | **string** | Upper bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]

### Return type

[**ListRecurring200Response**](ListRecurring200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## listRecurringAggregate

Month-by-month aggregate recurring view

Aggregates recurring-transaction occurrences in the window, grouped
by status ('completed', 'remaining', etc.) and rolled up into
'expense' / 'creditCard' / 'income' totals per-group AND across the
whole window.

Use for \"what recurring spend hits this month\" or \"what's already
happened vs still pending\" summaries. For the per-occurrence
calendar view use 'GET /v1/recurring'; for stream definitions use
'GET /v1/recurring/streams'.

### Example

```bash
monarch-api listRecurringAggregate  start=value  end=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **string** | Lower bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]
 **end** | **string** | Upper bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]

### Return type

[**ListRecurringAggregate200Response**](ListRecurringAggregate200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## listRecurringStreams

Recurring stream definitions

Returns the raw recurrence rules behind each stream: review status,
base date, frequency ('weekly', 'monthly', etc.), expected
day-of-month, and any linked credit-report liability account.

Lighter than 'GET /v1/recurring/all' which adds merchant /
category resolution. Use to build an editing UI for recurrence
rules; pair with 'PATCH /v1/merchants/{id}/recurrence' to mutate
the rule for a specific merchant. Toggle 'includeLiabilities' to
add credit-report-derived streams.

### Example

```bash
monarch-api listRecurringStreams  includeLiabilities=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **includeLiabilities** | **boolean** | Include liability-account-derived streams. | [optional] [default to null]

### Return type

[**ListRecurringStreams200Response**](ListRecurringStreams200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## mergeRecurringStreams

Merge recurring streams

Collapse two or more recurring streams into one. The 'primaryStreamId'
survives; all 'mergedStreamIds' are absorbed into it (their
transactions, history, and rules transfer over). Optional 'newName'
overrides the merged stream's display name.

Used when Monarch detects the same bill from two angles (credit-report
liability + transaction-feed merchant) and the user wants one canonical
stream.

### Example

```bash
monarch-api mergeRecurringStreams
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **mergeRecurringStreamsRequest** | [**MergeRecurringStreamsRequest**](MergeRecurringStreamsRequest.md) |  |

### Return type

[**MergeRecurringStreams200Response**](MergeRecurringStreams200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## skipRecurringInstance

Skip one expected occurrence

Dismiss a single expected occurrence of a recurring stream - the
\"this month I'm skipping Netflix\" button on the recurring tab.
Subsequent occurrences continue to fire on schedule.

Per-occurrence only. To dismiss the whole stream see the recurring
rule editor; to retire it permanently use
'POST /v1/transactions/{id}/not-recurring'.

### Example

```bash
monarch-api skipRecurringInstance id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch recurring stream id. | [default to null]
 **skipRecurringInstanceRequest** | [**SkipRecurringInstanceRequest**](SkipRecurringInstanceRequest.md) |  |

### Return type

[**SkipRecurringInstance200Response**](SkipRecurringInstance200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## updateMerchantRecurrence

Update a merchant's recurring-transaction settings

Reconfigures the recurring-transaction stream rules tied to a
merchant: frequency, expected day-of-month, base date, whether
the stream is approved as recurring.

**Gotcha**: Monarch's mutation requires 'name' even when only
changing recurrence fields. Pass the merchant's current display
name unchanged if you don't intend to rename. Use
'GET /v1/merchants/{id}' to fetch the current name first.

Pairs with 'POST /v1/transactions/{id}/not-recurring' for the
\"dismiss this false-positive stream\" workflow.

### Example

```bash
monarch-api updateMerchantRecurrence id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch merchant id. | [default to null]
 **updateMerchantRecurrenceRequest** | [**UpdateMerchantRecurrenceRequest**](UpdateMerchantRecurrenceRequest.md) |  |

### Return type

[**UpdateMerchantRecurrence200Response**](UpdateMerchantRecurrence200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

