# AdviceApi

All URIs are relative to *http://localhost:9084*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**advice**](AdviceApi.md#advice) | **GET** /v1/advice | Forward &#x60;AdviceQuery_Web&#x60; (opaque pass-through) |
| [**adviceDashboardWidget**](AdviceApi.md#adviceDashboardWidget) | **GET** /v1/advice/dashboard-widget | Forward &#x60;Web_GetAdviceDashboardWidget&#x60; (opaque pass-through) |
| [**adviceItemDrawer**](AdviceApi.md#adviceItemDrawer) | **GET** /v1/advice/item-drawer | Forward &#x60;AdviceItemDrawerQuery_Web&#x60; (opaque pass-through) |
| [**adviceQuestionnaire**](AdviceApi.md#adviceQuestionnaire) | **GET** /v1/advice/questionnaire | Forward &#x60;Web_AdviceQuestionnaire&#x60; (opaque pass-through) |
| [**adviceTaskComplete**](AdviceApi.md#adviceTaskComplete) | **GET** /v1/advice/task/complete | Forward &#x60;Web_MarkAdviceTaskComplete&#x60; (opaque pass-through) |
| [**adviceTaskDrawer**](AdviceApi.md#adviceTaskDrawer) | **GET** /v1/advice/task-drawer | Forward &#x60;AdviceTaskDrawerQuery_Web&#x60; (opaque pass-through) |
| [**adviceTaskIncomplete**](AdviceApi.md#adviceTaskIncomplete) | **GET** /v1/advice/task/incomplete | Forward &#x60;Web_MarkAdviceTaskIncomplete&#x60; (opaque pass-through) |


<a id="advice"></a>
# **advice**
> FeatureAreaResponse advice()

Forward &#x60;AdviceQuery_Web&#x60; (opaque pass-through)

Advice landing query. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = AdviceApi()
try {
    val result : FeatureAreaResponse = apiInstance.advice()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AdviceApi#advice")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AdviceApi#advice")
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

<a id="adviceDashboardWidget"></a>
# **adviceDashboardWidget**
> FeatureAreaResponse adviceDashboardWidget()

Forward &#x60;Web_GetAdviceDashboardWidget&#x60; (opaque pass-through)

Dashboard advice widget snapshot. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = AdviceApi()
try {
    val result : FeatureAreaResponse = apiInstance.adviceDashboardWidget()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AdviceApi#adviceDashboardWidget")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AdviceApi#adviceDashboardWidget")
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

<a id="adviceItemDrawer"></a>
# **adviceItemDrawer**
> FeatureAreaResponse adviceItemDrawer()

Forward &#x60;AdviceItemDrawerQuery_Web&#x60; (opaque pass-through)

Advice item-drawer detail query. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = AdviceApi()
try {
    val result : FeatureAreaResponse = apiInstance.adviceItemDrawer()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AdviceApi#adviceItemDrawer")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AdviceApi#adviceItemDrawer")
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

<a id="adviceQuestionnaire"></a>
# **adviceQuestionnaire**
> FeatureAreaResponse adviceQuestionnaire()

Forward &#x60;Web_AdviceQuestionnaire&#x60; (opaque pass-through)

Advice onboarding questionnaire. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = AdviceApi()
try {
    val result : FeatureAreaResponse = apiInstance.adviceQuestionnaire()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AdviceApi#adviceQuestionnaire")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AdviceApi#adviceQuestionnaire")
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

<a id="adviceTaskComplete"></a>
# **adviceTaskComplete**
> FeatureAreaResponse adviceTaskComplete()

Forward &#x60;Web_MarkAdviceTaskComplete&#x60; (opaque pass-through)

Mark an advice task complete. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = AdviceApi()
try {
    val result : FeatureAreaResponse = apiInstance.adviceTaskComplete()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AdviceApi#adviceTaskComplete")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AdviceApi#adviceTaskComplete")
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

<a id="adviceTaskDrawer"></a>
# **adviceTaskDrawer**
> FeatureAreaResponse adviceTaskDrawer()

Forward &#x60;AdviceTaskDrawerQuery_Web&#x60; (opaque pass-through)

Advice task-drawer detail query. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = AdviceApi()
try {
    val result : FeatureAreaResponse = apiInstance.adviceTaskDrawer()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AdviceApi#adviceTaskDrawer")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AdviceApi#adviceTaskDrawer")
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

<a id="adviceTaskIncomplete"></a>
# **adviceTaskIncomplete**
> FeatureAreaResponse adviceTaskIncomplete()

Forward &#x60;Web_MarkAdviceTaskIncomplete&#x60; (opaque pass-through)

Mark an advice task incomplete. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = AdviceApi()
try {
    val result : FeatureAreaResponse = apiInstance.adviceTaskIncomplete()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AdviceApi#adviceTaskIncomplete")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AdviceApi#adviceTaskIncomplete")
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

