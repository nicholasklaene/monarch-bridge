# ReportConfigApi

All URIs are relative to *http://localhost:9084*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**reportConfigsCommandPalette**](ReportConfigApi.md#reportConfigsCommandPalette) | **GET** /v1/report-configs/command-palette | Forward &#x60;Web_GetReportConfigurationsForCommandPalette&#x60; (opaque pass-through) |
| [**reportConfigsCreate**](ReportConfigApi.md#reportConfigsCreate) | **GET** /v1/report-configs/create | Forward &#x60;Common_CreateReportConfiguration&#x60; (opaque pass-through) |
| [**reportConfigsDelete**](ReportConfigApi.md#reportConfigsDelete) | **GET** /v1/report-configs/delete | Forward &#x60;Common_DeleteReportConfiguration&#x60; (opaque pass-through) |
| [**reportConfigsList**](ReportConfigApi.md#reportConfigsList) | **GET** /v1/report-configs | Forward &#x60;Common_GetReportConfigurations&#x60; (opaque pass-through) |
| [**reportConfigsUpdate**](ReportConfigApi.md#reportConfigsUpdate) | **GET** /v1/report-configs/update | Forward &#x60;Common_UpdateReportConfiguration&#x60; (opaque pass-through) |


<a id="reportConfigsCommandPalette"></a>
# **reportConfigsCommandPalette**
> FeatureAreaResponse reportConfigsCommandPalette()

Forward &#x60;Web_GetReportConfigurationsForCommandPalette&#x60; (opaque pass-through)

List report configurations for the command palette. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = ReportConfigApi()
try {
    val result : FeatureAreaResponse = apiInstance.reportConfigsCommandPalette()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ReportConfigApi#reportConfigsCommandPalette")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ReportConfigApi#reportConfigsCommandPalette")
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

<a id="reportConfigsCreate"></a>
# **reportConfigsCreate**
> FeatureAreaResponse reportConfigsCreate()

Forward &#x60;Common_CreateReportConfiguration&#x60; (opaque pass-through)

Create a report configuration. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = ReportConfigApi()
try {
    val result : FeatureAreaResponse = apiInstance.reportConfigsCreate()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ReportConfigApi#reportConfigsCreate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ReportConfigApi#reportConfigsCreate")
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

<a id="reportConfigsDelete"></a>
# **reportConfigsDelete**
> FeatureAreaResponse reportConfigsDelete()

Forward &#x60;Common_DeleteReportConfiguration&#x60; (opaque pass-through)

Delete a report configuration. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = ReportConfigApi()
try {
    val result : FeatureAreaResponse = apiInstance.reportConfigsDelete()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ReportConfigApi#reportConfigsDelete")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ReportConfigApi#reportConfigsDelete")
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

<a id="reportConfigsList"></a>
# **reportConfigsList**
> FeatureAreaResponse reportConfigsList()

Forward &#x60;Common_GetReportConfigurations&#x60; (opaque pass-through)

List report configurations. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = ReportConfigApi()
try {
    val result : FeatureAreaResponse = apiInstance.reportConfigsList()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ReportConfigApi#reportConfigsList")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ReportConfigApi#reportConfigsList")
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

<a id="reportConfigsUpdate"></a>
# **reportConfigsUpdate**
> FeatureAreaResponse reportConfigsUpdate()

Forward &#x60;Common_UpdateReportConfiguration&#x60; (opaque pass-through)

Update a report configuration. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = ReportConfigApi()
try {
    val result : FeatureAreaResponse = apiInstance.reportConfigsUpdate()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ReportConfigApi#reportConfigsUpdate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ReportConfigApi#reportConfigsUpdate")
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

