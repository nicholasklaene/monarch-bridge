# ForecastApi

All URIs are relative to *http://localhost:9084*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**forecastCreateScenario**](ForecastApi.md#forecastCreateScenario) | **GET** /v1/forecast/scenarios/create | Forward &#x60;Web_CreateForecastScenario&#x60; (opaque pass-through) |
| [**forecastDeleteScenario**](ForecastApi.md#forecastDeleteScenario) | **GET** /v1/forecast/scenarios/delete | Forward &#x60;Web_DeleteForecastScenario&#x60; (opaque pass-through) |
| [**forecastDuplicateScenario**](ForecastApi.md#forecastDuplicateScenario) | **GET** /v1/forecast/scenarios/duplicate | Forward &#x60;Web_DuplicateForecastScenario&#x60; (opaque pass-through) |
| [**forecastInitialize**](ForecastApi.md#forecastInitialize) | **GET** /v1/forecast/initialize | Forward &#x60;Web_InitializeForecast&#x60; (opaque pass-through) |
| [**forecastOnboardingComplete**](ForecastApi.md#forecastOnboardingComplete) | **GET** /v1/forecast/onboarding/complete | Forward &#x60;Web_MarkForecastOnboardingComplete&#x60; (opaque pass-through) |
| [**forecastReplaceEvents**](ForecastApi.md#forecastReplaceEvents) | **GET** /v1/forecast/events/replace | Forward &#x60;Web_ReplaceForecastEvents&#x60; (opaque pass-through) |
| [**forecastResetData**](ForecastApi.md#forecastResetData) | **GET** /v1/forecast/data/reset | Forward &#x60;Web_ResetForecastData&#x60; (opaque pass-through) |
| [**forecastResetOnboarding**](ForecastApi.md#forecastResetOnboarding) | **GET** /v1/forecast/onboarding/reset | Forward &#x60;Web_ResetForecastOnboarding&#x60; (opaque pass-through) |
| [**forecastSaveAccounts**](ForecastApi.md#forecastSaveAccounts) | **GET** /v1/forecast/accounts | Forward &#x60;Web_SaveForecastAccounts&#x60; (opaque pass-through) |
| [**forecastSaveParticipantOverrides**](ForecastApi.md#forecastSaveParticipantOverrides) | **GET** /v1/forecast/participant-overrides | Forward &#x60;Web_SaveForecastParticipantOverrides&#x60; (opaque pass-through) |
| [**forecastSavePriorityRules**](ForecastApi.md#forecastSavePriorityRules) | **GET** /v1/forecast/priority-rules | Forward &#x60;Web_SaveForecastPriorityRules&#x60; (opaque pass-through) |
| [**forecastSaveScenarioKpis**](ForecastApi.md#forecastSaveScenarioKpis) | **GET** /v1/forecast/scenario-kpis | Forward &#x60;Web_SaveForecastScenarioKpis&#x60; (opaque pass-through) |
| [**forecastScenario**](ForecastApi.md#forecastScenario) | **GET** /v1/forecast/scenario | Forward &#x60;Web_ForecastScenario&#x60; (opaque pass-through) |
| [**forecastScenarios**](ForecastApi.md#forecastScenarios) | **GET** /v1/forecast/scenarios | Forward &#x60;Web_ForecastScenarios&#x60; (opaque pass-through) |
| [**forecastUpdateScenario**](ForecastApi.md#forecastUpdateScenario) | **GET** /v1/forecast/scenarios/update | Forward &#x60;Web_UpdateForecastScenario&#x60; (opaque pass-through) |
| [**forecastUpdateScenarioOrder**](ForecastApi.md#forecastUpdateScenarioOrder) | **GET** /v1/forecast/scenarios/order | Forward &#x60;Web_UpdateForecastScenarioOrder&#x60; (opaque pass-through) |
| [**forecastUpdateUserFinancialProfile**](ForecastApi.md#forecastUpdateUserFinancialProfile) | **GET** /v1/forecast/user-financial-profile | Forward &#x60;Web_ForecastUpdateUserFinancialProfile&#x60; (opaque pass-through) |


<a id="forecastCreateScenario"></a>
# **forecastCreateScenario**
> FeatureAreaResponse forecastCreateScenario()

Forward &#x60;Web_CreateForecastScenario&#x60; (opaque pass-through)

Create a forecast scenario. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = ForecastApi()
try {
    val result : FeatureAreaResponse = apiInstance.forecastCreateScenario()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ForecastApi#forecastCreateScenario")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ForecastApi#forecastCreateScenario")
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

<a id="forecastDeleteScenario"></a>
# **forecastDeleteScenario**
> FeatureAreaResponse forecastDeleteScenario()

Forward &#x60;Web_DeleteForecastScenario&#x60; (opaque pass-through)

Delete a forecast scenario. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = ForecastApi()
try {
    val result : FeatureAreaResponse = apiInstance.forecastDeleteScenario()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ForecastApi#forecastDeleteScenario")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ForecastApi#forecastDeleteScenario")
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

<a id="forecastDuplicateScenario"></a>
# **forecastDuplicateScenario**
> FeatureAreaResponse forecastDuplicateScenario()

Forward &#x60;Web_DuplicateForecastScenario&#x60; (opaque pass-through)

Duplicate a forecast scenario. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = ForecastApi()
try {
    val result : FeatureAreaResponse = apiInstance.forecastDuplicateScenario()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ForecastApi#forecastDuplicateScenario")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ForecastApi#forecastDuplicateScenario")
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

<a id="forecastInitialize"></a>
# **forecastInitialize**
> FeatureAreaResponse forecastInitialize()

Forward &#x60;Web_InitializeForecast&#x60; (opaque pass-through)

Initialize forecast feature. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = ForecastApi()
try {
    val result : FeatureAreaResponse = apiInstance.forecastInitialize()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ForecastApi#forecastInitialize")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ForecastApi#forecastInitialize")
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

<a id="forecastOnboardingComplete"></a>
# **forecastOnboardingComplete**
> FeatureAreaResponse forecastOnboardingComplete()

Forward &#x60;Web_MarkForecastOnboardingComplete&#x60; (opaque pass-through)

Mark forecast onboarding complete. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = ForecastApi()
try {
    val result : FeatureAreaResponse = apiInstance.forecastOnboardingComplete()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ForecastApi#forecastOnboardingComplete")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ForecastApi#forecastOnboardingComplete")
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

<a id="forecastReplaceEvents"></a>
# **forecastReplaceEvents**
> FeatureAreaResponse forecastReplaceEvents()

Forward &#x60;Web_ReplaceForecastEvents&#x60; (opaque pass-through)

Replace forecast events. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = ForecastApi()
try {
    val result : FeatureAreaResponse = apiInstance.forecastReplaceEvents()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ForecastApi#forecastReplaceEvents")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ForecastApi#forecastReplaceEvents")
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

<a id="forecastResetData"></a>
# **forecastResetData**
> FeatureAreaResponse forecastResetData()

Forward &#x60;Web_ResetForecastData&#x60; (opaque pass-through)

Reset forecast data. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = ForecastApi()
try {
    val result : FeatureAreaResponse = apiInstance.forecastResetData()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ForecastApi#forecastResetData")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ForecastApi#forecastResetData")
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

<a id="forecastResetOnboarding"></a>
# **forecastResetOnboarding**
> FeatureAreaResponse forecastResetOnboarding()

Forward &#x60;Web_ResetForecastOnboarding&#x60; (opaque pass-through)

Reset forecast onboarding. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = ForecastApi()
try {
    val result : FeatureAreaResponse = apiInstance.forecastResetOnboarding()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ForecastApi#forecastResetOnboarding")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ForecastApi#forecastResetOnboarding")
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

<a id="forecastSaveAccounts"></a>
# **forecastSaveAccounts**
> FeatureAreaResponse forecastSaveAccounts()

Forward &#x60;Web_SaveForecastAccounts&#x60; (opaque pass-through)

Save forecast account selections. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = ForecastApi()
try {
    val result : FeatureAreaResponse = apiInstance.forecastSaveAccounts()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ForecastApi#forecastSaveAccounts")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ForecastApi#forecastSaveAccounts")
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

<a id="forecastSaveParticipantOverrides"></a>
# **forecastSaveParticipantOverrides**
> FeatureAreaResponse forecastSaveParticipantOverrides()

Forward &#x60;Web_SaveForecastParticipantOverrides&#x60; (opaque pass-through)

Save forecast participant overrides. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = ForecastApi()
try {
    val result : FeatureAreaResponse = apiInstance.forecastSaveParticipantOverrides()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ForecastApi#forecastSaveParticipantOverrides")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ForecastApi#forecastSaveParticipantOverrides")
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

<a id="forecastSavePriorityRules"></a>
# **forecastSavePriorityRules**
> FeatureAreaResponse forecastSavePriorityRules()

Forward &#x60;Web_SaveForecastPriorityRules&#x60; (opaque pass-through)

Save forecast priority rules. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = ForecastApi()
try {
    val result : FeatureAreaResponse = apiInstance.forecastSavePriorityRules()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ForecastApi#forecastSavePriorityRules")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ForecastApi#forecastSavePriorityRules")
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

<a id="forecastSaveScenarioKpis"></a>
# **forecastSaveScenarioKpis**
> FeatureAreaResponse forecastSaveScenarioKpis()

Forward &#x60;Web_SaveForecastScenarioKpis&#x60; (opaque pass-through)

Save forecast scenario KPIs. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = ForecastApi()
try {
    val result : FeatureAreaResponse = apiInstance.forecastSaveScenarioKpis()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ForecastApi#forecastSaveScenarioKpis")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ForecastApi#forecastSaveScenarioKpis")
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

<a id="forecastScenario"></a>
# **forecastScenario**
> FeatureAreaResponse forecastScenario()

Forward &#x60;Web_ForecastScenario&#x60; (opaque pass-through)

Single forecast scenario detail. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = ForecastApi()
try {
    val result : FeatureAreaResponse = apiInstance.forecastScenario()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ForecastApi#forecastScenario")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ForecastApi#forecastScenario")
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

<a id="forecastScenarios"></a>
# **forecastScenarios**
> FeatureAreaResponse forecastScenarios()

Forward &#x60;Web_ForecastScenarios&#x60; (opaque pass-through)

List forecast scenarios. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = ForecastApi()
try {
    val result : FeatureAreaResponse = apiInstance.forecastScenarios()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ForecastApi#forecastScenarios")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ForecastApi#forecastScenarios")
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

<a id="forecastUpdateScenario"></a>
# **forecastUpdateScenario**
> FeatureAreaResponse forecastUpdateScenario()

Forward &#x60;Web_UpdateForecastScenario&#x60; (opaque pass-through)

Update a forecast scenario. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = ForecastApi()
try {
    val result : FeatureAreaResponse = apiInstance.forecastUpdateScenario()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ForecastApi#forecastUpdateScenario")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ForecastApi#forecastUpdateScenario")
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

<a id="forecastUpdateScenarioOrder"></a>
# **forecastUpdateScenarioOrder**
> FeatureAreaResponse forecastUpdateScenarioOrder()

Forward &#x60;Web_UpdateForecastScenarioOrder&#x60; (opaque pass-through)

Reorder forecast scenarios. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = ForecastApi()
try {
    val result : FeatureAreaResponse = apiInstance.forecastUpdateScenarioOrder()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ForecastApi#forecastUpdateScenarioOrder")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ForecastApi#forecastUpdateScenarioOrder")
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

<a id="forecastUpdateUserFinancialProfile"></a>
# **forecastUpdateUserFinancialProfile**
> FeatureAreaResponse forecastUpdateUserFinancialProfile()

Forward &#x60;Web_ForecastUpdateUserFinancialProfile&#x60; (opaque pass-through)

Update user financial profile from forecast. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = ForecastApi()
try {
    val result : FeatureAreaResponse = apiInstance.forecastUpdateUserFinancialProfile()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ForecastApi#forecastUpdateUserFinancialProfile")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ForecastApi#forecastUpdateUserFinancialProfile")
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

