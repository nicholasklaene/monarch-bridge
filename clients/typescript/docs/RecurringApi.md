# RecurringApi

All URIs are relative to *http://localhost:9084*

|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|[**getRecurringDashboard**](#getrecurringdashboard) | **GET** /v1/recurring/dashboard | Dashboard view of upcoming recurring items + total due|
|[**getRecurringForecast**](#getrecurringforecast) | **GET** /v1/recurring/forecast | Recurring transaction forecast|
|[**listAllRecurring**](#listallrecurring) | **GET** /v1/recurring/all | All recurring streams with next-occurrence detail|
|[**listRecurring**](#listrecurring) | **GET** /v1/recurring | Upcoming + recent recurring transaction occurrences|
|[**listRecurringAggregate**](#listrecurringaggregate) | **GET** /v1/recurring/aggregate | Month-by-month aggregate recurring view|
|[**listRecurringStreams**](#listrecurringstreams) | **GET** /v1/recurring/streams | Recurring stream definitions|
|[**mergeRecurringStreams**](#mergerecurringstreams) | **POST** /v1/recurring/streams/merge | Merge recurring streams|
|[**skipRecurringInstance**](#skiprecurringinstance) | **POST** /v1/recurring/{id}/skip | Skip one expected occurrence|
|[**updateMerchantRecurrence**](#updatemerchantrecurrence) | **PATCH** /v1/merchants/{id}/recurrence | Update a merchant\&#39;s recurring-transaction settings|

# **getRecurringDashboard**
> GetRecurringDashboardResponse getRecurringDashboard()

Returns the per-item upcoming recurring transaction stream PLUS the remaining-due dollar total for the same window. Drop-in shape for a \"next 30 days bills\" widget. 

### Example

```typescript
import {
    RecurringApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new RecurringApi(configuration);

let start: string; //Lower bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)
let end: string; //Upper bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)
let includeLiabilities: boolean; //Include liability payments (credit cards, loans) in the list. (optional) (default to undefined)

const { status, data } = await apiInstance.getRecurringDashboard(
    start,
    end,
    includeLiabilities
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **start** | [**string**] | Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|
| **end** | [**string**] | Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|
| **includeLiabilities** | [**boolean**] | Include liability payments (credit cards, loans) in the list. | (optional) defaults to undefined|


### Return type

**GetRecurringDashboardResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Upcoming items + remaining-due summary. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getRecurringForecast**
> GetRecurringForecastResponse getRecurringForecast()

Forward calendar of forecast recurring occurrences for a date window. One entry per occurrence with date, amount, merchant, and linked stream id. 

### Example

```typescript
import {
    RecurringApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new RecurringApi(configuration);

let start: string; //Lower bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)
let end: string; //Upper bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)

const { status, data } = await apiInstance.getRecurringForecast(
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

**GetRecurringForecastResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Forecast occurrences. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listAllRecurring**
> ListAllRecurringResponse listAllRecurring()

Stream-shaped recurring view: one entry per recurring transaction stream (NOT per occurrence; see `GET /v1/recurring` for the per-date calendar view). Each entry carries the stream definition, the next forecasted occurrence, plus the merchant, category, and account references resolved to full objects.  Use for a \"all my subscriptions and bills\" view. Toggle `includeLiabilities` to add credit-report-derived streams (loans, credit-card minimum payments). Toggle `includePending` to include streams Monarch hasn\'t yet confirmed as recurring. 

### Example

```typescript
import {
    RecurringApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new RecurringApi(configuration);

let includeLiabilities: boolean; //Include liability-account-derived streams. (optional) (default to undefined)
let includePending: boolean; //Include pending (not-yet-confirmed) streams. (optional) (default to undefined)

const { status, data } = await apiInstance.listAllRecurring(
    includeLiabilities,
    includePending
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **includeLiabilities** | [**boolean**] | Include liability-account-derived streams. | (optional) defaults to undefined|
| **includePending** | [**boolean**] | Include pending (not-yet-confirmed) streams. | (optional) defaults to undefined|


### Return type

**ListAllRecurringResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | All recurring streams. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listRecurring**
> ListRecurringResponse listRecurring()

Calendar-shaped view: one entry per expected recurring transaction occurrence within `[start, end]`. Each entry has the forecasted date, merchant, category, account, amount, and a `status` (`completed`, `pending`, `predicted`).  Use for a \"what\'s coming up\" subscription/bill view or to reconcile expected vs actual recurring spend. For the stream- shaped view (one row per recurring stream, not per occurrence) use `GET /v1/recurring/all`; for month-level aggregate totals use `GET /v1/recurring/aggregate`. 

### Example

```typescript
import {
    RecurringApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new RecurringApi(configuration);

let start: string; //Lower bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)
let end: string; //Upper bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)

const { status, data } = await apiInstance.listRecurring(
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

**ListRecurringResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | One entry per expected occurrence in the window. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listRecurringAggregate**
> ListRecurringAggregateResponse listRecurringAggregate()

Aggregates recurring-transaction occurrences in the window, grouped by status (`completed`, `remaining`, etc.) and rolled up into `expense` / `creditCard` / `income` totals per-group AND across the whole window.  Use for \"what recurring spend hits this month\" or \"what\'s already happened vs still pending\" summaries. For the per-occurrence calendar view use `GET /v1/recurring`; for stream definitions use `GET /v1/recurring/streams`. 

### Example

```typescript
import {
    RecurringApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new RecurringApi(configuration);

let start: string; //Lower bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)
let end: string; //Upper bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)

const { status, data } = await apiInstance.listRecurringAggregate(
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

**ListRecurringAggregateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Aggregated tree from Monarch (pass-through). |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listRecurringStreams**
> ListRecurringStreamsResponse listRecurringStreams()

Returns the raw recurrence rules behind each stream: review status, base date, frequency (`weekly`, `monthly`, etc.), expected day-of-month, and any linked credit-report liability account.  Lighter than `GET /v1/recurring/all` which adds merchant / category resolution. Use to build an editing UI for recurrence rules; pair with `PATCH /v1/merchants/{id}/recurrence` to mutate the rule for a specific merchant. Toggle `includeLiabilities` to add credit-report-derived streams. 

### Example

```typescript
import {
    RecurringApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new RecurringApi(configuration);

let includeLiabilities: boolean; //Include liability-account-derived streams. (optional) (default to undefined)

const { status, data } = await apiInstance.listRecurringStreams(
    includeLiabilities
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **includeLiabilities** | [**boolean**] | Include liability-account-derived streams. | (optional) defaults to undefined|


### Return type

**ListRecurringStreamsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | All recurring streams. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mergeRecurringStreams**
> MergeRecurringStreamsResponse mergeRecurringStreams(mergeRecurringStreamsRequest)

Collapse two or more recurring streams into one. The `primaryStreamId` survives; all `mergedStreamIds` are absorbed into it (their transactions, history, and rules transfer over). Optional `newName` overrides the merged stream\'s display name.  Used when Monarch detects the same bill from two angles (credit-report liability + transaction-feed merchant) and the user wants one canonical stream. 

### Example

```typescript
import {
    RecurringApi,
    Configuration,
    MergeRecurringStreamsRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new RecurringApi(configuration);

let mergeRecurringStreamsRequest: MergeRecurringStreamsRequest; //

const { status, data } = await apiInstance.mergeRecurringStreams(
    mergeRecurringStreamsRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **mergeRecurringStreamsRequest** | **MergeRecurringStreamsRequest**|  | |


### Return type

**MergeRecurringStreamsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | The surviving stream. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **skipRecurringInstance**
> SkipRecurringInstanceResponse skipRecurringInstance(skipRecurringInstanceRequest)

Dismiss a single expected occurrence of a recurring stream - the \"this month I\'m skipping Netflix\" button on the recurring tab. Subsequent occurrences continue to fire on schedule.  Per-occurrence only. To dismiss the whole stream see the recurring rule editor; to retire it permanently use `POST /v1/transactions/{id}/not-recurring`. 

### Example

```typescript
import {
    RecurringApi,
    Configuration,
    SkipRecurringInstanceRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new RecurringApi(configuration);

let id: string; //Monarch recurring stream id. (default to undefined)
let skipRecurringInstanceRequest: SkipRecurringInstanceRequest; //

const { status, data } = await apiInstance.skipRecurringInstance(
    id,
    skipRecurringInstanceRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **skipRecurringInstanceRequest** | **SkipRecurringInstanceRequest**|  | |
| **id** | [**string**] | Monarch recurring stream id. | defaults to undefined|


### Return type

**SkipRecurringInstanceResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Skipped occurrence confirmation. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updateMerchantRecurrence**
> UpdateMerchantRecurrenceResponse updateMerchantRecurrence(updateMerchantRecurrenceRequest)

Reconfigures the recurring-transaction stream rules tied to a merchant: frequency, expected day-of-month, base date, whether the stream is approved as recurring.  **Gotcha**: Monarch\'s mutation requires `name` even when only changing recurrence fields. Pass the merchant\'s current display name unchanged if you don\'t intend to rename. Use `GET /v1/merchants/{id}` to fetch the current name first.  Pairs with `POST /v1/transactions/{id}/not-recurring` for the \"dismiss this false-positive stream\" workflow. 

### Example

```typescript
import {
    RecurringApi,
    Configuration,
    UpdateMerchantRecurrenceRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new RecurringApi(configuration);

let id: string; //Monarch merchant id. (default to undefined)
let updateMerchantRecurrenceRequest: UpdateMerchantRecurrenceRequest; //

const { status, data } = await apiInstance.updateMerchantRecurrence(
    id,
    updateMerchantRecurrenceRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **updateMerchantRecurrenceRequest** | **UpdateMerchantRecurrenceRequest**|  | |
| **id** | [**string**] | Monarch merchant id. | defaults to undefined|


### Return type

**UpdateMerchantRecurrenceResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Updated merchant with recurrence stream. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

