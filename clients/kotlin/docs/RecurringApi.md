# RecurringApi

All URIs are relative to *http://localhost:9084*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**getRecurringDashboard**](RecurringApi.md#getRecurringDashboard) | **GET** /v1/recurring/dashboard | Dashboard view of upcoming recurring items + total due |
| [**getRecurringForecast**](RecurringApi.md#getRecurringForecast) | **GET** /v1/recurring/forecast | Recurring transaction forecast |
| [**listAllRecurring**](RecurringApi.md#listAllRecurring) | **GET** /v1/recurring/all | All recurring streams with next-occurrence detail |
| [**listRecurring**](RecurringApi.md#listRecurring) | **GET** /v1/recurring | Upcoming + recent recurring transaction occurrences |
| [**listRecurringAggregate**](RecurringApi.md#listRecurringAggregate) | **GET** /v1/recurring/aggregate | Month-by-month aggregate recurring view |
| [**listRecurringStreams**](RecurringApi.md#listRecurringStreams) | **GET** /v1/recurring/streams | Recurring stream definitions |
| [**mergeRecurringStreams**](RecurringApi.md#mergeRecurringStreams) | **POST** /v1/recurring/streams/merge | Merge recurring streams |
| [**skipRecurringInstance**](RecurringApi.md#skipRecurringInstance) | **POST** /v1/recurring/{id}/skip | Skip one expected occurrence |
| [**updateMerchantRecurrence**](RecurringApi.md#updateMerchantRecurrence) | **PATCH** /v1/merchants/{id}/recurrence | Update a merchant&#39;s recurring-transaction settings |


<a id="getRecurringDashboard"></a>
# **getRecurringDashboard**
> GetRecurringDashboardResponse getRecurringDashboard(start, end, includeLiabilities)

Dashboard view of upcoming recurring items + total due

Returns the per-item upcoming recurring transaction stream PLUS the remaining-due dollar total for the same window. Drop-in shape for a \&quot;next 30 days bills\&quot; widget. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = RecurringApi()
val start : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Lower bound (inclusive), `YYYY-MM-DD`.
val end : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Upper bound (inclusive), `YYYY-MM-DD`.
val includeLiabilities : kotlin.Boolean = true // kotlin.Boolean | Include liability payments (credit cards, loans) in the list.
try {
    val result : GetRecurringDashboardResponse = apiInstance.getRecurringDashboard(start, end, includeLiabilities)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling RecurringApi#getRecurringDashboard")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling RecurringApi#getRecurringDashboard")
    e.printStackTrace()
}
```

### Parameters
| **start** | **java.time.LocalDate**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |
| **end** | **java.time.LocalDate**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **includeLiabilities** | **kotlin.Boolean**| Include liability payments (credit cards, loans) in the list. | [optional] |

### Return type

[**GetRecurringDashboardResponse**](GetRecurringDashboardResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getRecurringForecast"></a>
# **getRecurringForecast**
> GetRecurringForecastResponse getRecurringForecast(start, end)

Recurring transaction forecast

Forward calendar of forecast recurring occurrences for a date window. One entry per occurrence with date, amount, merchant, and linked stream id. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = RecurringApi()
val start : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Lower bound (inclusive), `YYYY-MM-DD`.
val end : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Upper bound (inclusive), `YYYY-MM-DD`.
try {
    val result : GetRecurringForecastResponse = apiInstance.getRecurringForecast(start, end)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling RecurringApi#getRecurringForecast")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling RecurringApi#getRecurringForecast")
    e.printStackTrace()
}
```

### Parameters
| **start** | **java.time.LocalDate**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **end** | **java.time.LocalDate**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |

### Return type

[**GetRecurringForecastResponse**](GetRecurringForecastResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="listAllRecurring"></a>
# **listAllRecurring**
> ListAllRecurringResponse listAllRecurring(includeLiabilities, includePending)

All recurring streams with next-occurrence detail

Stream-shaped recurring view: one entry per recurring transaction stream (NOT per occurrence; see &#x60;GET /v1/recurring&#x60; for the per-date calendar view). Each entry carries the stream definition, the next forecasted occurrence, plus the merchant, category, and account references resolved to full objects.  Use for a \&quot;all my subscriptions and bills\&quot; view. Toggle &#x60;includeLiabilities&#x60; to add credit-report-derived streams (loans, credit-card minimum payments). Toggle &#x60;includePending&#x60; to include streams Monarch hasn&#39;t yet confirmed as recurring. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = RecurringApi()
val includeLiabilities : kotlin.Boolean = true // kotlin.Boolean | Include liability-account-derived streams.
val includePending : kotlin.Boolean = true // kotlin.Boolean | Include pending (not-yet-confirmed) streams.
try {
    val result : ListAllRecurringResponse = apiInstance.listAllRecurring(includeLiabilities, includePending)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling RecurringApi#listAllRecurring")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling RecurringApi#listAllRecurring")
    e.printStackTrace()
}
```

### Parameters
| **includeLiabilities** | **kotlin.Boolean**| Include liability-account-derived streams. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **includePending** | **kotlin.Boolean**| Include pending (not-yet-confirmed) streams. | [optional] |

### Return type

[**ListAllRecurringResponse**](ListAllRecurringResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="listRecurring"></a>
# **listRecurring**
> ListRecurringResponse listRecurring(start, end)

Upcoming + recent recurring transaction occurrences

Calendar-shaped view: one entry per expected recurring transaction occurrence within &#x60;[start, end]&#x60;. Each entry has the forecasted date, merchant, category, account, amount, and a &#x60;status&#x60; (&#x60;completed&#x60;, &#x60;pending&#x60;, &#x60;predicted&#x60;).  Use for a \&quot;what&#39;s coming up\&quot; subscription/bill view or to reconcile expected vs actual recurring spend. For the stream- shaped view (one row per recurring stream, not per occurrence) use &#x60;GET /v1/recurring/all&#x60;; for month-level aggregate totals use &#x60;GET /v1/recurring/aggregate&#x60;. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = RecurringApi()
val start : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Lower bound (inclusive), `YYYY-MM-DD`.
val end : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Upper bound (inclusive), `YYYY-MM-DD`.
try {
    val result : ListRecurringResponse = apiInstance.listRecurring(start, end)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling RecurringApi#listRecurring")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling RecurringApi#listRecurring")
    e.printStackTrace()
}
```

### Parameters
| **start** | **java.time.LocalDate**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **end** | **java.time.LocalDate**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |

### Return type

[**ListRecurringResponse**](ListRecurringResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="listRecurringAggregate"></a>
# **listRecurringAggregate**
> ListRecurringAggregateResponse listRecurringAggregate(start, end)

Month-by-month aggregate recurring view

Aggregates recurring-transaction occurrences in the window, grouped by status (&#x60;completed&#x60;, &#x60;remaining&#x60;, etc.) and rolled up into &#x60;expense&#x60; / &#x60;creditCard&#x60; / &#x60;income&#x60; totals per-group AND across the whole window.  Use for \&quot;what recurring spend hits this month\&quot; or \&quot;what&#39;s already happened vs still pending\&quot; summaries. For the per-occurrence calendar view use &#x60;GET /v1/recurring&#x60;; for stream definitions use &#x60;GET /v1/recurring/streams&#x60;. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = RecurringApi()
val start : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Lower bound (inclusive), `YYYY-MM-DD`.
val end : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Upper bound (inclusive), `YYYY-MM-DD`.
try {
    val result : ListRecurringAggregateResponse = apiInstance.listRecurringAggregate(start, end)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling RecurringApi#listRecurringAggregate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling RecurringApi#listRecurringAggregate")
    e.printStackTrace()
}
```

### Parameters
| **start** | **java.time.LocalDate**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **end** | **java.time.LocalDate**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |

### Return type

[**ListRecurringAggregateResponse**](ListRecurringAggregateResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="listRecurringStreams"></a>
# **listRecurringStreams**
> ListRecurringStreamsResponse listRecurringStreams(includeLiabilities)

Recurring stream definitions

Returns the raw recurrence rules behind each stream: review status, base date, frequency (&#x60;weekly&#x60;, &#x60;monthly&#x60;, etc.), expected day-of-month, and any linked credit-report liability account.  Lighter than &#x60;GET /v1/recurring/all&#x60; which adds merchant / category resolution. Use to build an editing UI for recurrence rules; pair with &#x60;PATCH /v1/merchants/{id}/recurrence&#x60; to mutate the rule for a specific merchant. Toggle &#x60;includeLiabilities&#x60; to add credit-report-derived streams. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = RecurringApi()
val includeLiabilities : kotlin.Boolean = true // kotlin.Boolean | Include liability-account-derived streams.
try {
    val result : ListRecurringStreamsResponse = apiInstance.listRecurringStreams(includeLiabilities)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling RecurringApi#listRecurringStreams")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling RecurringApi#listRecurringStreams")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **includeLiabilities** | **kotlin.Boolean**| Include liability-account-derived streams. | [optional] |

### Return type

[**ListRecurringStreamsResponse**](ListRecurringStreamsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="mergeRecurringStreams"></a>
# **mergeRecurringStreams**
> MergeRecurringStreamsResponse mergeRecurringStreams(mergeRecurringStreamsRequest)

Merge recurring streams

Collapse two or more recurring streams into one. The &#x60;primaryStreamId&#x60; survives; all &#x60;mergedStreamIds&#x60; are absorbed into it (their transactions, history, and rules transfer over). Optional &#x60;newName&#x60; overrides the merged stream&#39;s display name.  Used when Monarch detects the same bill from two angles (credit-report liability + transaction-feed merchant) and the user wants one canonical stream. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = RecurringApi()
val mergeRecurringStreamsRequest : MergeRecurringStreamsRequest =  // MergeRecurringStreamsRequest | 
try {
    val result : MergeRecurringStreamsResponse = apiInstance.mergeRecurringStreams(mergeRecurringStreamsRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling RecurringApi#mergeRecurringStreams")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling RecurringApi#mergeRecurringStreams")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **mergeRecurringStreamsRequest** | [**MergeRecurringStreamsRequest**](MergeRecurringStreamsRequest.md)|  | |

### Return type

[**MergeRecurringStreamsResponse**](MergeRecurringStreamsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="skipRecurringInstance"></a>
# **skipRecurringInstance**
> SkipRecurringInstanceResponse skipRecurringInstance(id, skipRecurringInstanceRequest)

Skip one expected occurrence

Dismiss a single expected occurrence of a recurring stream - the \&quot;this month I&#39;m skipping Netflix\&quot; button on the recurring tab. Subsequent occurrences continue to fire on schedule.  Per-occurrence only. To dismiss the whole stream see the recurring rule editor; to retire it permanently use &#x60;POST /v1/transactions/{id}/not-recurring&#x60;. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = RecurringApi()
val id : kotlin.String = id_example // kotlin.String | Monarch recurring stream id.
val skipRecurringInstanceRequest : SkipRecurringInstanceRequest =  // SkipRecurringInstanceRequest | 
try {
    val result : SkipRecurringInstanceResponse = apiInstance.skipRecurringInstance(id, skipRecurringInstanceRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling RecurringApi#skipRecurringInstance")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling RecurringApi#skipRecurringInstance")
    e.printStackTrace()
}
```

### Parameters
| **id** | **kotlin.String**| Monarch recurring stream id. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **skipRecurringInstanceRequest** | [**SkipRecurringInstanceRequest**](SkipRecurringInstanceRequest.md)|  | |

### Return type

[**SkipRecurringInstanceResponse**](SkipRecurringInstanceResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="updateMerchantRecurrence"></a>
# **updateMerchantRecurrence**
> UpdateMerchantRecurrenceResponse updateMerchantRecurrence(id, updateMerchantRecurrenceRequest)

Update a merchant&#39;s recurring-transaction settings

Reconfigures the recurring-transaction stream rules tied to a merchant: frequency, expected day-of-month, base date, whether the stream is approved as recurring.  **Gotcha**: Monarch&#39;s mutation requires &#x60;name&#x60; even when only changing recurrence fields. Pass the merchant&#39;s current display name unchanged if you don&#39;t intend to rename. Use &#x60;GET /v1/merchants/{id}&#x60; to fetch the current name first.  Pairs with &#x60;POST /v1/transactions/{id}/not-recurring&#x60; for the \&quot;dismiss this false-positive stream\&quot; workflow. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = RecurringApi()
val id : kotlin.String = id_example // kotlin.String | Monarch merchant id.
val updateMerchantRecurrenceRequest : UpdateMerchantRecurrenceRequest =  // UpdateMerchantRecurrenceRequest | 
try {
    val result : UpdateMerchantRecurrenceResponse = apiInstance.updateMerchantRecurrence(id, updateMerchantRecurrenceRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling RecurringApi#updateMerchantRecurrence")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling RecurringApi#updateMerchantRecurrence")
    e.printStackTrace()
}
```

### Parameters
| **id** | **kotlin.String**| Monarch merchant id. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **updateMerchantRecurrenceRequest** | [**UpdateMerchantRecurrenceRequest**](UpdateMerchantRecurrenceRequest.md)|  | |

### Return type

[**UpdateMerchantRecurrenceResponse**](UpdateMerchantRecurrenceResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

