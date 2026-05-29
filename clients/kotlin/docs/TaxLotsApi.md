# TaxLotsApi

All URIs are relative to *http://localhost:9084*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**createManualTaxLot**](TaxLotsApi.md#createManualTaxLot) | **POST** /v1/holdings/{id}/tax-lots/create | Create one manual tax lot under a holding |
| [**createManualTaxLotsBulk**](TaxLotsApi.md#createManualTaxLotsBulk) | **POST** /v1/accounts/{id}/tax-lots/bulk | Bulk-create tax lots under an account |
| [**deleteTaxLot**](TaxLotsApi.md#deleteTaxLot) | **DELETE** /v1/tax-lots/{id} | Delete one manual tax lot |
| [**deleteTaxLotsBulk**](TaxLotsApi.md#deleteTaxLotsBulk) | **POST** /v1/tax-lots/bulk-delete | Bulk-delete tax lots by id |
| [**getTaxLotPerformance**](TaxLotsApi.md#getTaxLotPerformance) | **GET** /v1/holdings/{id}/tax-lot-performance | Per-holding tax-lot performance chart |
| [**listTaxLots**](TaxLotsApi.md#listTaxLots) | **GET** /v1/holdings/{id}/tax-lots | List tax lots under a holding |
| [**updateTaxLot**](TaxLotsApi.md#updateTaxLot) | **PATCH** /v1/tax-lots/{id} | Update one manual tax lot |


<a id="createManualTaxLot"></a>
# **createManualTaxLot**
> CreateManualTaxLotResponse createManualTaxLot(id, createManualTaxLotRequest)

Create one manual tax lot under a holding

Adds one manual cost-basis tax lot under the given holding. The Monarch web client surfaces this when the user edits a manual investments holding and clicks \&quot;Add a tax lot\&quot;.  The lot is independent of any data-provider basis - manual lots accumulate alongside synced basis, with the user-side total reflected in the holding&#39;s per-lot performance chart. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TaxLotsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch holding id.
val createManualTaxLotRequest : CreateManualTaxLotRequest =  // CreateManualTaxLotRequest | 
try {
    val result : CreateManualTaxLotResponse = apiInstance.createManualTaxLot(id, createManualTaxLotRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TaxLotsApi#createManualTaxLot")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TaxLotsApi#createManualTaxLot")
    e.printStackTrace()
}
```

### Parameters
| **id** | **kotlin.String**| Monarch holding id. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **createManualTaxLotRequest** | [**CreateManualTaxLotRequest**](CreateManualTaxLotRequest.md)|  | |

### Return type

[**CreateManualTaxLotResponse**](CreateManualTaxLotResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="createManualTaxLotsBulk"></a>
# **createManualTaxLotsBulk**
> CreateManualTaxLotsBulkResponse createManualTaxLotsBulk(id, createManualTaxLotsBulkRequest)

Bulk-create tax lots under an account

Batch import of manual tax lots scoped to one investments account. Each row carries its own &#x60;holdingId&#x60;. Per-row errors surface in the &#x60;errors&#x60; array; successful lots in &#x60;taxLots&#x60;. Idempotent on identical &#x60;(holdingId, acquisitionDate, acquisitionQuantity, costBasisPerUnit)&#x60; tuples - Monarch dedupes. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TaxLotsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch account id (manual investments account).
val createManualTaxLotsBulkRequest : CreateManualTaxLotsBulkRequest =  // CreateManualTaxLotsBulkRequest | 
try {
    val result : CreateManualTaxLotsBulkResponse = apiInstance.createManualTaxLotsBulk(id, createManualTaxLotsBulkRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TaxLotsApi#createManualTaxLotsBulk")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TaxLotsApi#createManualTaxLotsBulk")
    e.printStackTrace()
}
```

### Parameters
| **id** | **kotlin.String**| Monarch account id (manual investments account). | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **createManualTaxLotsBulkRequest** | [**CreateManualTaxLotsBulkRequest**](CreateManualTaxLotsBulkRequest.md)|  | |

### Return type

[**CreateManualTaxLotsBulkResponse**](CreateManualTaxLotsBulkResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="deleteTaxLot"></a>
# **deleteTaxLot**
> DeleteTaxLotResponse deleteTaxLot(id)

Delete one manual tax lot

Removes one manual tax lot. **Destructive** - no soft-delete. The holding&#39;s aggregate cost basis re-totals from the remaining lots. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TaxLotsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch tax-lot id.
try {
    val result : DeleteTaxLotResponse = apiInstance.deleteTaxLot(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TaxLotsApi#deleteTaxLot")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TaxLotsApi#deleteTaxLot")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **kotlin.String**| Monarch tax-lot id. | |

### Return type

[**DeleteTaxLotResponse**](DeleteTaxLotResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="deleteTaxLotsBulk"></a>
# **deleteTaxLotsBulk**
> DeleteTaxLotsBulkResponse deleteTaxLotsBulk(deleteTaxLotsBulkRequest)

Bulk-delete tax lots by id

One-shot delete of a list of manual tax lots. Returns the deleted count. Use for cleanup after a wrong bulk import. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TaxLotsApi()
val deleteTaxLotsBulkRequest : DeleteTaxLotsBulkRequest =  // DeleteTaxLotsBulkRequest | 
try {
    val result : DeleteTaxLotsBulkResponse = apiInstance.deleteTaxLotsBulk(deleteTaxLotsBulkRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TaxLotsApi#deleteTaxLotsBulk")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TaxLotsApi#deleteTaxLotsBulk")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **deleteTaxLotsBulkRequest** | [**DeleteTaxLotsBulkRequest**](DeleteTaxLotsBulkRequest.md)|  | |

### Return type

[**DeleteTaxLotsBulkResponse**](DeleteTaxLotsBulkResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="getTaxLotPerformance"></a>
# **getTaxLotPerformance**
> GetTaxLotPerformanceResponse getTaxLotPerformance(id)

Per-holding tax-lot performance chart

Per-day cost-basis / unrealized-gain / return-percent series across all tax lots under one holding. Backs the \&quot;Lot performance\&quot; chart on the holding detail page. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TaxLotsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch holding id.
try {
    val result : GetTaxLotPerformanceResponse = apiInstance.getTaxLotPerformance(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TaxLotsApi#getTaxLotPerformance")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TaxLotsApi#getTaxLotPerformance")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **kotlin.String**| Monarch holding id. | |

### Return type

[**GetTaxLotPerformanceResponse**](GetTaxLotPerformanceResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="listTaxLots"></a>
# **listTaxLots**
> ListTaxLotsResponse listTaxLots(id)

List tax lots under a holding

All manual tax lots attached to one holding. Ordered by &#x60;acquisitionDate&#x60; ascending. Pairs with the \&quot;Lot performance\&quot; chart - one row per lot. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TaxLotsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch holding id.
try {
    val result : ListTaxLotsResponse = apiInstance.listTaxLots(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TaxLotsApi#listTaxLots")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TaxLotsApi#listTaxLots")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **kotlin.String**| Monarch holding id. | |

### Return type

[**ListTaxLotsResponse**](ListTaxLotsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="updateTaxLot"></a>
# **updateTaxLot**
> CreateManualTaxLotResponse updateTaxLot(id, updateTaxLotRequest)

Update one manual tax lot

Partial-update one tax lot. Only fields present on the request body are forwarded. Use to fix a fat-finger on cost basis or acquisition date without recreating the lot. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TaxLotsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch tax-lot id.
val updateTaxLotRequest : UpdateTaxLotRequest =  // UpdateTaxLotRequest | 
try {
    val result : CreateManualTaxLotResponse = apiInstance.updateTaxLot(id, updateTaxLotRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TaxLotsApi#updateTaxLot")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TaxLotsApi#updateTaxLot")
    e.printStackTrace()
}
```

### Parameters
| **id** | **kotlin.String**| Monarch tax-lot id. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **updateTaxLotRequest** | [**UpdateTaxLotRequest**](UpdateTaxLotRequest.md)|  | |

### Return type

[**CreateManualTaxLotResponse**](CreateManualTaxLotResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

