# MerchantsApi

All URIs are relative to *http://localhost:9084*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**deleteMerchant**](MerchantsApi.md#deleteMerchant) | **DELETE** /v1/merchants/{id} | Delete a merchant |
| [**getMerchant**](MerchantsApi.md#getMerchant) | **GET** /v1/merchants/{id} | Get full detail for one merchant |
| [**getMerchantStats**](MerchantsApi.md#getMerchantStats) | **GET** /v1/merchants/{id}/stats | Per-merchant aggregate stats |
| [**getMerchantTransactions**](MerchantsApi.md#getMerchantTransactions) | **GET** /v1/merchants/{id}/transactions | Transactions for one merchant |
| [**searchMerchants**](MerchantsApi.md#searchMerchants) | **GET** /v1/merchants/search | Search merchants by name |
| [**setMerchantLogo**](MerchantsApi.md#setMerchantLogo) | **PATCH** /v1/merchants/{id}/logo | Set a merchant&#39;s logo |


<a id="deleteMerchant"></a>
# **deleteMerchant**
> DeleteMerchantResponse deleteMerchant(id, moveToId)

Delete a merchant

Removes a merchant from the catalog. **Destructive** for any transactions and rules that referenced this merchant unless you remap.  Pass &#x60;moveToId&#x60; to reassign every transaction and every auto-categorization rule that pointed at this merchant to a different merchant before deletion. Omit to orphan them (the transactions will fall back to displaying the raw &#x60;plaidName&#x60;).  Use &#x60;GET /v1/merchants/{id}&#x60; first to check &#x60;canBeDeleted&#x60; and &#x60;transactionCount&#x60;. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = MerchantsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch merchant id.
val moveToId : kotlin.String = moveToId_example // kotlin.String | Reassign this merchant's transactions and rules to this merchant before deletion.
try {
    val result : DeleteMerchantResponse = apiInstance.deleteMerchant(id, moveToId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling MerchantsApi#deleteMerchant")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling MerchantsApi#deleteMerchant")
    e.printStackTrace()
}
```

### Parameters
| **id** | **kotlin.String**| Monarch merchant id. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **moveToId** | **kotlin.String**| Reassign this merchant&#39;s transactions and rules to this merchant before deletion. | [optional] |

### Return type

[**DeleteMerchantResponse**](DeleteMerchantResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getMerchant"></a>
# **getMerchant**
> GetMerchantResponse getMerchant(id)

Get full detail for one merchant

Returns the rich single-merchant view: id, name, &#x60;logoUrl&#x60;, &#x60;transactionCount&#x60;, &#x60;ruleCount&#x60;, &#x60;canBeDeleted&#x60;, &#x60;hasActiveRecurringStreams&#x60;, plus the merchant&#39;s recurring stream definition when present.  Wraps Monarch&#39;s &#x60;Common_GetEditMerchant&#x60; query, the richest single-merchant read in the bundle. Use before a delete to check &#x60;canBeDeleted&#x60;, before a rename to read the current name (required by &#x60;PATCH /v1/merchants/{id}/recurrence&#x60;), or in a detail view. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = MerchantsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch merchant id.
try {
    val result : GetMerchantResponse = apiInstance.getMerchant(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling MerchantsApi#getMerchant")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling MerchantsApi#getMerchant")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **kotlin.String**| Monarch merchant id. | |

### Return type

[**GetMerchantResponse**](GetMerchantResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getMerchantStats"></a>
# **getMerchantStats**
> GetMerchantStatsResponse getMerchantStats(id, start, end)

Per-merchant aggregate stats

Aggregate stats for one merchant across a window: total spend, transaction count, average ticket, first / last seen, and the count of distinct months with activity. Backs the merchant detail page&#39;s \&quot;Activity\&quot; card.  Use &#x60;GET /v1/merchants/{id}/transactions&#x60; for the row-level transactions list. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = MerchantsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch merchant id.
val start : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Lower bound (inclusive), `YYYY-MM-DD`.
val end : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Upper bound (inclusive), `YYYY-MM-DD`.
try {
    val result : GetMerchantStatsResponse = apiInstance.getMerchantStats(id, start, end)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling MerchantsApi#getMerchantStats")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling MerchantsApi#getMerchantStats")
    e.printStackTrace()
}
```

### Parameters
| **id** | **kotlin.String**| Monarch merchant id. | |
| **start** | **java.time.LocalDate**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **end** | **java.time.LocalDate**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |

### Return type

[**GetMerchantStatsResponse**](GetMerchantStatsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getMerchantTransactions"></a>
# **getMerchantTransactions**
> GetMerchantTransactionsResponse getMerchantTransactions(id, limit, offset)

Transactions for one merchant

Transaction list scoped to a single merchant. Lighter than calling &#x60;/v1/transactions?search&#x3D;&lt;merchant&gt;&#x60; when you already have the merchant id. Returns date, amount, merchant, and category per row. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = MerchantsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch merchant id.
val limit : kotlin.Int = 56 // kotlin.Int | Page size.
val offset : kotlin.Int = 56 // kotlin.Int | Page offset.
try {
    val result : GetMerchantTransactionsResponse = apiInstance.getMerchantTransactions(id, limit, offset)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling MerchantsApi#getMerchantTransactions")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling MerchantsApi#getMerchantTransactions")
    e.printStackTrace()
}
```

### Parameters
| **id** | **kotlin.String**| Monarch merchant id. | |
| **limit** | **kotlin.Int**| Page size. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **offset** | **kotlin.Int**| Page offset. | [optional] |

### Return type

[**GetMerchantTransactionsResponse**](GetMerchantTransactionsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="searchMerchants"></a>
# **searchMerchants**
> SearchMerchantsResponse searchMerchants(q, limit, offset, withLogo, includeIds)

Search merchants by name

Free-text search across merchant names, ordered by transaction count (most-used first). Use to populate a merchant picker, resolve a merchant id by name, or browse the merchant catalog.  Two backing queries via the &#x60;withLogo&#x60; flag:  - &#x60;withLogo: false&#x60; (default): faster, omits &#x60;logoUrl&#x60;, but   supports the &#x60;includeIds&#x60; filter (repeat the query param to pin   specific merchants into the result set even if they don&#39;t match   the search text). - &#x60;withLogo: true&#x60;: includes &#x60;logoUrl&#x60; per merchant; supports   &#x60;offset&#x60; pagination but drops &#x60;includeIds&#x60;. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = MerchantsApi()
val q : kotlin.String = q_example // kotlin.String | Free-text search across merchant names.
val limit : kotlin.Int = 56 // kotlin.Int | Max number of merchants to return.
val offset : kotlin.Int = 56 // kotlin.Int | Page offset. Only respected when `withLogo` is true.
val withLogo : kotlin.Boolean = true // kotlin.Boolean | When true, switch to the logo-enabled variant of the query.
val includeIds : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | Pin specific merchant ids into the result set. Repeat the query param for each id. Only respected when `withLogo` is false. 
try {
    val result : SearchMerchantsResponse = apiInstance.searchMerchants(q, limit, offset, withLogo, includeIds)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling MerchantsApi#searchMerchants")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling MerchantsApi#searchMerchants")
    e.printStackTrace()
}
```

### Parameters
| **q** | **kotlin.String**| Free-text search across merchant names. | [optional] |
| **limit** | **kotlin.Int**| Max number of merchants to return. | [optional] |
| **offset** | **kotlin.Int**| Page offset. Only respected when &#x60;withLogo&#x60; is true. | [optional] |
| **withLogo** | **kotlin.Boolean**| When true, switch to the logo-enabled variant of the query. | [optional] [default to false] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **includeIds** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| Pin specific merchant ids into the result set. Repeat the query param for each id. Only respected when &#x60;withLogo&#x60; is false.  | [optional] |

### Return type

[**SearchMerchantsResponse**](SearchMerchantsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="setMerchantLogo"></a>
# **setMerchantLogo**
> GetMerchantResponse setMerchantLogo(id, setMerchantLogoRequest)

Set a merchant&#39;s logo

Points the merchant at an existing Cloudinary asset by public id.  **Gotcha**: Monarch&#39;s &#x60;setMerchantLogo&#x60; mutation does NOT accept a binary upload. The asset must already exist on Cloudinary (typically uploaded via Monarch&#39;s web UI). Pass the asset&#39;s &#x60;cloudinaryPublicId&#x60;; send &#x60;null&#x60; or omit to clear the logo.  To upload a fresh logo you&#39;d need to upload to Cloudinary out-of-band first and then call this endpoint with the resulting public id (Monarch does not expose its Cloudinary signing for this use-case). 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = MerchantsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch merchant id.
val setMerchantLogoRequest : SetMerchantLogoRequest =  // SetMerchantLogoRequest | 
try {
    val result : GetMerchantResponse = apiInstance.setMerchantLogo(id, setMerchantLogoRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling MerchantsApi#setMerchantLogo")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling MerchantsApi#setMerchantLogo")
    e.printStackTrace()
}
```

### Parameters
| **id** | **kotlin.String**| Monarch merchant id. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **setMerchantLogoRequest** | [**SetMerchantLogoRequest**](SetMerchantLogoRequest.md)|  | |

### Return type

[**GetMerchantResponse**](GetMerchantResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

