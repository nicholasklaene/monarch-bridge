# PaychecksApi

All URIs are relative to *http://localhost:9084*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**createPaycheck**](PaychecksApi.md#createPaycheck) | **POST** /v1/paychecks | Record a new paycheck |
| [**createPaycheckEmployer**](PaychecksApi.md#createPaycheckEmployer) | **POST** /v1/paycheck-employers | Register a new employer |
| [**deletePaycheck**](PaychecksApi.md#deletePaycheck) | **DELETE** /v1/paychecks/{id} | Delete a paycheck |
| [**deletePaycheckEmployer**](PaychecksApi.md#deletePaycheckEmployer) | **DELETE** /v1/paycheck-employers/{id} | Delete an employer |
| [**getPaycheck**](PaychecksApi.md#getPaycheck) | **GET** /v1/paychecks/{id} | Single-paycheck full detail |
| [**getPaychecksSummary**](PaychecksApi.md#getPaychecksSummary) | **GET** /v1/paychecks/summary | Aggregate paycheck stats over a window |
| [**listPaycheckEmployers**](PaychecksApi.md#listPaycheckEmployers) | **GET** /v1/paycheck-employers | List paycheck employers |
| [**listPaychecks**](PaychecksApi.md#listPaychecks) | **GET** /v1/paychecks | List paychecks (with optional date + owner + employer filter) |
| [**updatePaycheck**](PaychecksApi.md#updatePaycheck) | **PATCH** /v1/paychecks/{id} | Partial-update a paycheck |
| [**updatePaycheckEmployer**](PaychecksApi.md#updatePaycheckEmployer) | **PATCH** /v1/paycheck-employers/{id} | Rename an employer |


<a id="createPaycheck"></a>
# **createPaycheck**
> CreatePaycheckResponse createPaycheck(createPaycheckRequest)

Record a new paycheck

Creates a paycheck record from scratch. Required: &#x60;employerId&#x60;, &#x60;ownerId&#x60;, &#x60;payDate&#x60;, &#x60;gross&#x60;, &#x60;net&#x60;. Optional: &#x60;deductions[]&#x60; (per-line: taxes, retirement, insurance, etc.) and &#x60;deposits[]&#x60; (per-account splits of the net amount).  &#x60;employerId&#x60; must already exist; register it via &#x60;POST /v1/paycheck-employers&#x60; first. Deductions and deposits can be omitted on create and filled in later via &#x60;PATCH /v1/paychecks/{id}&#x60;. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = PaychecksApi()
val createPaycheckRequest : CreatePaycheckRequest =  // CreatePaycheckRequest | 
try {
    val result : CreatePaycheckResponse = apiInstance.createPaycheck(createPaycheckRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PaychecksApi#createPaycheck")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PaychecksApi#createPaycheck")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **createPaycheckRequest** | [**CreatePaycheckRequest**](CreatePaycheckRequest.md)|  | |

### Return type

[**CreatePaycheckResponse**](CreatePaycheckResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="createPaycheckEmployer"></a>
# **createPaycheckEmployer**
> CreatePaycheckEmployerResponse createPaycheckEmployer(createPaycheckEmployerRequest)

Register a new employer

Adds an employer to the registry so it can be attached to paycheck records. Required: &#x60;name&#x60;. The returned id is the &#x60;employerId&#x60; to pass when creating a paycheck via &#x60;POST /v1/paychecks&#x60;.  Use once per employer per household member - subsequent paychecks reference the same id. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = PaychecksApi()
val createPaycheckEmployerRequest : CreatePaycheckEmployerRequest =  // CreatePaycheckEmployerRequest | 
try {
    val result : CreatePaycheckEmployerResponse = apiInstance.createPaycheckEmployer(createPaycheckEmployerRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PaychecksApi#createPaycheckEmployer")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PaychecksApi#createPaycheckEmployer")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **createPaycheckEmployerRequest** | [**CreatePaycheckEmployerRequest**](CreatePaycheckEmployerRequest.md)|  | |

### Return type

[**CreatePaycheckEmployerResponse**](CreatePaycheckEmployerResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="deletePaycheck"></a>
# **deletePaycheck**
> DeleteAccountResponse deletePaycheck(id)

Delete a paycheck

Removes one paycheck and its deductions/deposits. **Destructive** - drops the row, future summary calls will no longer count it.  The underlying transaction (the actual paycheck deposit on the bank side) is not deleted by this call - only the Monarch paycheck record that links the gross + deductions + deposit structure. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = PaychecksApi()
val id : kotlin.String = id_example // kotlin.String | Monarch paycheck id.
try {
    val result : DeleteAccountResponse = apiInstance.deletePaycheck(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PaychecksApi#deletePaycheck")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PaychecksApi#deletePaycheck")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **kotlin.String**| Monarch paycheck id. | |

### Return type

[**DeleteAccountResponse**](DeleteAccountResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="deletePaycheckEmployer"></a>
# **deletePaycheckEmployer**
> DeleteAccountResponse deletePaycheckEmployer(id)

Delete an employer

Removes an employer from the registry. **Refuses with 422** if any paycheck records are still attributed to this employer - reassign or delete those first.  Use to clean up stale employer entries (e.g. after switching jobs and deleting the old paychecks). For renames use &#x60;PATCH /v1/paycheck-employers/{id}&#x60; instead. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = PaychecksApi()
val id : kotlin.String = id_example // kotlin.String | Monarch paycheck-employer id.
try {
    val result : DeleteAccountResponse = apiInstance.deletePaycheckEmployer(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PaychecksApi#deletePaycheckEmployer")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PaychecksApi#deletePaycheckEmployer")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **kotlin.String**| Monarch paycheck-employer id. | |

### Return type

[**DeleteAccountResponse**](DeleteAccountResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getPaycheck"></a>
# **getPaycheck**
> CreatePaycheckResponse getPaycheck(id)

Single-paycheck full detail

Returns the full breakdown for one paycheck: pay date, gross, net, employer, owner (household member), per-line &#x60;deductions&#x60; (taxes, retirement, insurance, etc.) and per-account &#x60;deposits&#x60;.  Use when surfacing a paycheck in a detail view or before a PATCH to inspect current state. For the list view use &#x60;GET /v1/paychecks&#x60;; for window-level rollups use &#x60;GET /v1/paychecks/summary&#x60;. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = PaychecksApi()
val id : kotlin.String = id_example // kotlin.String | Monarch paycheck id.
try {
    val result : CreatePaycheckResponse = apiInstance.getPaycheck(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PaychecksApi#getPaycheck")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PaychecksApi#getPaycheck")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **kotlin.String**| Monarch paycheck id. | |

### Return type

[**CreatePaycheckResponse**](CreatePaycheckResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getPaychecksSummary"></a>
# **getPaychecksSummary**
> GetPaychecksSummaryResponse getPaychecksSummary(start, end, ownerIds, employerId)

Aggregate paycheck stats over a window

Returns one rollup row over the filtered paycheck set: &#x60;count&#x60;, &#x60;totalGross&#x60;, &#x60;totalDeductions&#x60;, &#x60;totalNet&#x60;, &#x60;deductionRate&#x60; (deductions divided by gross), plus a breakdown by deduction type (federal tax, state tax, 401k, health insurance, etc.).  Window is &#x60;start&#x60; to &#x60;end&#x60; inclusive on &#x60;payDate&#x60;. Defaults to all-time when both omitted. Optional &#x60;employerId&#x60; scopes to one employer; optional &#x60;ownerIds[]&#x60; scopes to one or more household members.  Use for YTD income/deduction dashboards or to answer \&quot;how much have I contributed to 401k this year\&quot;. For per-paycheck detail use &#x60;GET /v1/paychecks&#x60;. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = PaychecksApi()
val start : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Lower bound (inclusive), `YYYY-MM-DD`.
val end : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Upper bound (inclusive), `YYYY-MM-DD`.
val ownerIds : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | Restrict to one or more household-member ids.
val employerId : kotlin.String = employerId_example // kotlin.String | Filter to one employer id.
try {
    val result : GetPaychecksSummaryResponse = apiInstance.getPaychecksSummary(start, end, ownerIds, employerId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PaychecksApi#getPaychecksSummary")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PaychecksApi#getPaychecksSummary")
    e.printStackTrace()
}
```

### Parameters
| **start** | **java.time.LocalDate**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |
| **end** | **java.time.LocalDate**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |
| **ownerIds** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| Restrict to one or more household-member ids. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **employerId** | **kotlin.String**| Filter to one employer id. | [optional] |

### Return type

[**GetPaychecksSummaryResponse**](GetPaychecksSummaryResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="listPaycheckEmployers"></a>
# **listPaycheckEmployers**
> ListPaycheckEmployersResponse listPaycheckEmployers(search, limit, offset)

List paycheck employers

Returns the named-employer registry. Each entry is a reusable employer id that paycheck records reference via &#x60;employerId&#x60;.  Optional free-text &#x60;search&#x60; matches by name (case-insensitive). &#x60;limit&#x60; / &#x60;offset&#x60; paginate. Use to populate an employer picker or to resolve a name before creating a paycheck via &#x60;POST /v1/paychecks&#x60;.  To add a new employer use &#x60;POST /v1/paycheck-employers&#x60;; to rename use &#x60;PATCH /v1/paycheck-employers/{id}&#x60;. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = PaychecksApi()
val search : kotlin.String = search_example // kotlin.String | Free-text search against merchant / notes / category.
val limit : kotlin.Int = 56 // kotlin.Int | Page size.
val offset : kotlin.Int = 56 // kotlin.Int | Page offset.
try {
    val result : ListPaycheckEmployersResponse = apiInstance.listPaycheckEmployers(search, limit, offset)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PaychecksApi#listPaycheckEmployers")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PaychecksApi#listPaycheckEmployers")
    e.printStackTrace()
}
```

### Parameters
| **search** | **kotlin.String**| Free-text search against merchant / notes / category. | [optional] |
| **limit** | **kotlin.Int**| Page size. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **offset** | **kotlin.Int**| Page offset. | [optional] |

### Return type

[**ListPaycheckEmployersResponse**](ListPaycheckEmployersResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="listPaychecks"></a>
# **listPaychecks**
> ListPaychecksResponse listPaychecks(start, end, ownerId, employerId)

List paychecks (with optional date + owner + employer filter)

Returns paycheck records (Monarch&#39;s structured paycheck model, not raw transactions). Each entry has &#x60;payDate&#x60;, gross, net, employer, owner (household member), plus the deductions and deposits arrays.  Filter on &#x60;payDate&#x60; via &#x60;start&#x60; / &#x60;end&#x60;; omit both for full history. Use &#x60;ownerId&#x60; to scope to one household member, &#x60;employerId&#x60; to scope to one employer.  For window-level rollups use &#x60;GET /v1/paychecks/summary&#x60;. For full detail on one paycheck use &#x60;GET /v1/paychecks/{id}&#x60;. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = PaychecksApi()
val start : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Lower bound (inclusive), `YYYY-MM-DD`.
val end : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Upper bound (inclusive), `YYYY-MM-DD`.
val ownerId : kotlin.String = ownerId_example // kotlin.String | Filter to one household-member id.
val employerId : kotlin.String = employerId_example // kotlin.String | Filter to one employer id.
try {
    val result : ListPaychecksResponse = apiInstance.listPaychecks(start, end, ownerId, employerId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PaychecksApi#listPaychecks")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PaychecksApi#listPaychecks")
    e.printStackTrace()
}
```

### Parameters
| **start** | **java.time.LocalDate**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |
| **end** | **java.time.LocalDate**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |
| **ownerId** | **kotlin.String**| Filter to one household-member id. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **employerId** | **kotlin.String**| Filter to one employer id. | [optional] |

### Return type

[**ListPaychecksResponse**](ListPaychecksResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="updatePaycheck"></a>
# **updatePaycheck**
> CreatePaycheckResponse updatePaycheck(id, updatePaycheckRequest)

Partial-update a paycheck

Patches one paycheck. Only fields present in the body are forwarded to Monarch; omit a field to leave it untouched.  **Gotcha**: the &#x60;deductions&#x60; and &#x60;deposits&#x60; arrays are NOT delta updates. When either array is present in the body it WHOLESALE REPLACES the existing list (Monarch&#39;s &#x60;UpdatePaycheckInput&#x60; semantics). To add a single deduction, fetch the current list via &#x60;GET /v1/paychecks/{id}&#x60; first then send the merged list back.  Common edits: rename via &#x60;description&#x60;, change &#x60;payDate&#x60; if logged on the wrong day, or fill in deductions/deposits after creating with a bare gross+net. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = PaychecksApi()
val id : kotlin.String = id_example // kotlin.String | Monarch paycheck id.
val updatePaycheckRequest : UpdatePaycheckRequest =  // UpdatePaycheckRequest | 
try {
    val result : CreatePaycheckResponse = apiInstance.updatePaycheck(id, updatePaycheckRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PaychecksApi#updatePaycheck")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PaychecksApi#updatePaycheck")
    e.printStackTrace()
}
```

### Parameters
| **id** | **kotlin.String**| Monarch paycheck id. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **updatePaycheckRequest** | [**UpdatePaycheckRequest**](UpdatePaycheckRequest.md)|  | |

### Return type

[**CreatePaycheckResponse**](CreatePaycheckResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="updatePaycheckEmployer"></a>
# **updatePaycheckEmployer**
> CreatePaycheckEmployerResponse updatePaycheckEmployer(id, updatePaycheckEmployerRequest)

Rename an employer

Updates the display name on a registered employer. The new name propagates to every paycheck record attributed to this employer (since paychecks reference employer by id, not by name).  Required: &#x60;name&#x60; in the request body. Use when a company rebrands or when normalizing names imported from payroll data. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = PaychecksApi()
val id : kotlin.String = id_example // kotlin.String | Monarch paycheck-employer id.
val updatePaycheckEmployerRequest : UpdatePaycheckEmployerRequest =  // UpdatePaycheckEmployerRequest | 
try {
    val result : CreatePaycheckEmployerResponse = apiInstance.updatePaycheckEmployer(id, updatePaycheckEmployerRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PaychecksApi#updatePaycheckEmployer")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PaychecksApi#updatePaycheckEmployer")
    e.printStackTrace()
}
```

### Parameters
| **id** | **kotlin.String**| Monarch paycheck-employer id. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **updatePaycheckEmployerRequest** | [**UpdatePaycheckEmployerRequest**](UpdatePaycheckEmployerRequest.md)|  | |

### Return type

[**CreatePaycheckEmployerResponse**](CreatePaycheckEmployerResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

