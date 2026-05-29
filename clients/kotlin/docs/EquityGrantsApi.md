# EquityGrantsApi

All URIs are relative to *http://localhost:9084*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**equityGrantsCreate**](EquityGrantsApi.md#equityGrantsCreate) | **GET** /v1/equity-grants/create | Forward &#x60;Web_CreateEquityGrant&#x60; (opaque pass-through) |
| [**equityGrantsDelete**](EquityGrantsApi.md#equityGrantsDelete) | **GET** /v1/equity-grants/delete | Forward &#x60;Web_DeleteEquityGrant&#x60; (opaque pass-through) |
| [**equityGrantsEditModal**](EquityGrantsApi.md#equityGrantsEditModal) | **GET** /v1/equity-grants/edit-modal/detail | Forward &#x60;Web_EditEquityGrantModal_GetEquityGrant&#x60; (opaque pass-through) |
| [**equityGrantsList**](EquityGrantsApi.md#equityGrantsList) | **GET** /v1/equity-grants | Forward &#x60;Web_GetEquityGrants&#x60; (opaque pass-through) |
| [**equityGrantsManageHoldingsModal**](EquityGrantsApi.md#equityGrantsManageHoldingsModal) | **GET** /v1/equity-grants/manage-holdings-modal | Forward &#x60;Web_ManageEquityHoldingsModal_GetEquityGrants&#x60; (opaque pass-through) |
| [**equityGrantsPreview**](EquityGrantsApi.md#equityGrantsPreview) | **GET** /v1/equity-grants/preview | Forward &#x60;Web_PreviewEquityGrant&#x60; (opaque pass-through) |
| [**equityGrantsUpdate**](EquityGrantsApi.md#equityGrantsUpdate) | **GET** /v1/equity-grants/update | Forward &#x60;Web_UpdateEquityGrant&#x60; (opaque pass-through) |


<a id="equityGrantsCreate"></a>
# **equityGrantsCreate**
> FeatureAreaResponse equityGrantsCreate()

Forward &#x60;Web_CreateEquityGrant&#x60; (opaque pass-through)

Create an equity grant. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = EquityGrantsApi()
try {
    val result : FeatureAreaResponse = apiInstance.equityGrantsCreate()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling EquityGrantsApi#equityGrantsCreate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EquityGrantsApi#equityGrantsCreate")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**FeatureAreaResponse**](FeatureAreaResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="equityGrantsDelete"></a>
# **equityGrantsDelete**
> FeatureAreaResponse equityGrantsDelete()

Forward &#x60;Web_DeleteEquityGrant&#x60; (opaque pass-through)

Delete an equity grant. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = EquityGrantsApi()
try {
    val result : FeatureAreaResponse = apiInstance.equityGrantsDelete()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling EquityGrantsApi#equityGrantsDelete")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EquityGrantsApi#equityGrantsDelete")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**FeatureAreaResponse**](FeatureAreaResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="equityGrantsEditModal"></a>
# **equityGrantsEditModal**
> FeatureAreaResponse equityGrantsEditModal()

Forward &#x60;Web_EditEquityGrantModal_GetEquityGrant&#x60; (opaque pass-through)

Get an equity grant detail for the edit modal. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = EquityGrantsApi()
try {
    val result : FeatureAreaResponse = apiInstance.equityGrantsEditModal()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling EquityGrantsApi#equityGrantsEditModal")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EquityGrantsApi#equityGrantsEditModal")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**FeatureAreaResponse**](FeatureAreaResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="equityGrantsList"></a>
# **equityGrantsList**
> FeatureAreaResponse equityGrantsList()

Forward &#x60;Web_GetEquityGrants&#x60; (opaque pass-through)

List equity grants. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = EquityGrantsApi()
try {
    val result : FeatureAreaResponse = apiInstance.equityGrantsList()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling EquityGrantsApi#equityGrantsList")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EquityGrantsApi#equityGrantsList")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**FeatureAreaResponse**](FeatureAreaResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="equityGrantsManageHoldingsModal"></a>
# **equityGrantsManageHoldingsModal**
> FeatureAreaResponse equityGrantsManageHoldingsModal()

Forward &#x60;Web_ManageEquityHoldingsModal_GetEquityGrants&#x60; (opaque pass-through)

Get equity grants for the manage-holdings modal. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = EquityGrantsApi()
try {
    val result : FeatureAreaResponse = apiInstance.equityGrantsManageHoldingsModal()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling EquityGrantsApi#equityGrantsManageHoldingsModal")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EquityGrantsApi#equityGrantsManageHoldingsModal")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**FeatureAreaResponse**](FeatureAreaResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="equityGrantsPreview"></a>
# **equityGrantsPreview**
> FeatureAreaResponse equityGrantsPreview()

Forward &#x60;Web_PreviewEquityGrant&#x60; (opaque pass-through)

Preview an equity grant. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = EquityGrantsApi()
try {
    val result : FeatureAreaResponse = apiInstance.equityGrantsPreview()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling EquityGrantsApi#equityGrantsPreview")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EquityGrantsApi#equityGrantsPreview")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**FeatureAreaResponse**](FeatureAreaResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="equityGrantsUpdate"></a>
# **equityGrantsUpdate**
> FeatureAreaResponse equityGrantsUpdate()

Forward &#x60;Web_UpdateEquityGrant&#x60; (opaque pass-through)

Update an equity grant. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = EquityGrantsApi()
try {
    val result : FeatureAreaResponse = apiInstance.equityGrantsUpdate()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling EquityGrantsApi#equityGrantsUpdate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EquityGrantsApi#equityGrantsUpdate")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**FeatureAreaResponse**](FeatureAreaResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

