# BusinessEntityApi

All URIs are relative to *http://localhost:9084*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**businessEntitiesDelete**](BusinessEntityApi.md#businessEntitiesDelete) | **GET** /v1/business-entities/delete | Forward &#x60;Common_DeleteBusinessEntity&#x60; (opaque pass-through) |
| [**businessEntitiesDeleteLogo**](BusinessEntityApi.md#businessEntitiesDeleteLogo) | **GET** /v1/business-entities/logo/delete | Forward &#x60;Common_DeleteBusinessEntityLogo&#x60; (opaque pass-through) |
| [**businessEntitiesDemoPopulate**](BusinessEntityApi.md#businessEntitiesDemoPopulate) | **GET** /v1/business-entities/demo/populate | Forward &#x60;Web_PopulateBusinessEntityDemo&#x60; (opaque pass-through) |
| [**businessEntitiesDemoScenarios**](BusinessEntityApi.md#businessEntitiesDemoScenarios) | **GET** /v1/business-entities/demo/scenarios | Forward &#x60;Web_AvailableBusinessEntityDemoScenarios&#x60; (opaque pass-through) |
| [**businessEntitiesDetail**](BusinessEntityApi.md#businessEntitiesDetail) | **GET** /v1/business-entities/detail | Forward &#x60;Common_GetBusinessEntity&#x60; (opaque pass-through) |
| [**businessEntitiesFinancials**](BusinessEntityApi.md#businessEntitiesFinancials) | **GET** /v1/business-entities/financials | Forward &#x60;Common_GetBusinessEntityFinancials&#x60; (opaque pass-through) |
| [**businessEntitiesReportsByCategory**](BusinessEntityApi.md#businessEntitiesReportsByCategory) | **GET** /v1/business-entities/reports/by-category | Forward &#x60;Common_GetBusinessEntityReportsDataByCategory&#x60; (opaque pass-through) |
| [**businessEntitiesReportsByGroup**](BusinessEntityApi.md#businessEntitiesReportsByGroup) | **GET** /v1/business-entities/reports/by-group | Forward &#x60;Common_GetBusinessEntityReportsDataByGroup&#x60; (opaque pass-through) |
| [**businessEntitiesUpsert**](BusinessEntityApi.md#businessEntitiesUpsert) | **GET** /v1/business-entities/upsert | Forward &#x60;Common_UpsertBusinessEntity&#x60; (opaque pass-through) |


<a id="businessEntitiesDelete"></a>
# **businessEntitiesDelete**
> FeatureAreaResponse businessEntitiesDelete()

Forward &#x60;Common_DeleteBusinessEntity&#x60; (opaque pass-through)

Delete a business entity. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = BusinessEntityApi()
try {
    val result : FeatureAreaResponse = apiInstance.businessEntitiesDelete()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BusinessEntityApi#businessEntitiesDelete")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BusinessEntityApi#businessEntitiesDelete")
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

<a id="businessEntitiesDeleteLogo"></a>
# **businessEntitiesDeleteLogo**
> FeatureAreaResponse businessEntitiesDeleteLogo()

Forward &#x60;Common_DeleteBusinessEntityLogo&#x60; (opaque pass-through)

Delete a business entity logo. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = BusinessEntityApi()
try {
    val result : FeatureAreaResponse = apiInstance.businessEntitiesDeleteLogo()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BusinessEntityApi#businessEntitiesDeleteLogo")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BusinessEntityApi#businessEntitiesDeleteLogo")
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

<a id="businessEntitiesDemoPopulate"></a>
# **businessEntitiesDemoPopulate**
> FeatureAreaResponse businessEntitiesDemoPopulate()

Forward &#x60;Web_PopulateBusinessEntityDemo&#x60; (opaque pass-through)

Populate a business entity with demo data. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = BusinessEntityApi()
try {
    val result : FeatureAreaResponse = apiInstance.businessEntitiesDemoPopulate()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BusinessEntityApi#businessEntitiesDemoPopulate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BusinessEntityApi#businessEntitiesDemoPopulate")
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

<a id="businessEntitiesDemoScenarios"></a>
# **businessEntitiesDemoScenarios**
> FeatureAreaResponse businessEntitiesDemoScenarios()

Forward &#x60;Web_AvailableBusinessEntityDemoScenarios&#x60; (opaque pass-through)

List demo scenarios available for business entity onboarding. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = BusinessEntityApi()
try {
    val result : FeatureAreaResponse = apiInstance.businessEntitiesDemoScenarios()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BusinessEntityApi#businessEntitiesDemoScenarios")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BusinessEntityApi#businessEntitiesDemoScenarios")
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

<a id="businessEntitiesDetail"></a>
# **businessEntitiesDetail**
> FeatureAreaResponse businessEntitiesDetail()

Forward &#x60;Common_GetBusinessEntity&#x60; (opaque pass-through)

Get business entity detail. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = BusinessEntityApi()
try {
    val result : FeatureAreaResponse = apiInstance.businessEntitiesDetail()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BusinessEntityApi#businessEntitiesDetail")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BusinessEntityApi#businessEntitiesDetail")
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

<a id="businessEntitiesFinancials"></a>
# **businessEntitiesFinancials**
> FeatureAreaResponse businessEntitiesFinancials()

Forward &#x60;Common_GetBusinessEntityFinancials&#x60; (opaque pass-through)

Get business entity financials. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = BusinessEntityApi()
try {
    val result : FeatureAreaResponse = apiInstance.businessEntitiesFinancials()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BusinessEntityApi#businessEntitiesFinancials")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BusinessEntityApi#businessEntitiesFinancials")
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

<a id="businessEntitiesReportsByCategory"></a>
# **businessEntitiesReportsByCategory**
> FeatureAreaResponse businessEntitiesReportsByCategory()

Forward &#x60;Common_GetBusinessEntityReportsDataByCategory&#x60; (opaque pass-through)

Business entity reports broken down by category. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = BusinessEntityApi()
try {
    val result : FeatureAreaResponse = apiInstance.businessEntitiesReportsByCategory()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BusinessEntityApi#businessEntitiesReportsByCategory")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BusinessEntityApi#businessEntitiesReportsByCategory")
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

<a id="businessEntitiesReportsByGroup"></a>
# **businessEntitiesReportsByGroup**
> FeatureAreaResponse businessEntitiesReportsByGroup()

Forward &#x60;Common_GetBusinessEntityReportsDataByGroup&#x60; (opaque pass-through)

Business entity reports broken down by group. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = BusinessEntityApi()
try {
    val result : FeatureAreaResponse = apiInstance.businessEntitiesReportsByGroup()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BusinessEntityApi#businessEntitiesReportsByGroup")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BusinessEntityApi#businessEntitiesReportsByGroup")
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

<a id="businessEntitiesUpsert"></a>
# **businessEntitiesUpsert**
> FeatureAreaResponse businessEntitiesUpsert()

Forward &#x60;Common_UpsertBusinessEntity&#x60; (opaque pass-through)

Upsert a business entity. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = BusinessEntityApi()
try {
    val result : FeatureAreaResponse = apiInstance.businessEntitiesUpsert()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BusinessEntityApi#businessEntitiesUpsert")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BusinessEntityApi#businessEntitiesUpsert")
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

