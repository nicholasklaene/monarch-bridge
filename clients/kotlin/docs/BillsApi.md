# BillsApi

All URIs are relative to *http://localhost:9084*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**billsAdvisorBilling**](BillsApi.md#billsAdvisorBilling) | **GET** /v1/bills/advisor-billing | Forward &#x60;Web_GetAdvisorBillingPage&#x60; (opaque pass-through) |
| [**billsBillingSettings**](BillsApi.md#billsBillingSettings) | **GET** /v1/bills/billing-settings | Forward &#x60;GetBillingSettings&#x60; (opaque pass-through) |
| [**billsCancelSponsorship**](BillsApi.md#billsCancelSponsorship) | **GET** /v1/bills/billing/sponsorship/cancel | Forward &#x60;Web_BillingSettingsCancelSponsorship&#x60; (opaque pass-through) |
| [**billsClaimItem**](BillsApi.md#billsClaimItem) | **GET** /v1/bills/item/claim | Forward &#x60;Web_ClaimBillItem&#x60; (opaque pass-through) |
| [**billsDetail**](BillsApi.md#billsDetail) | **GET** /v1/bills/detail | Forward &#x60;Web_GetBill&#x60; (opaque pass-through) |
| [**billsEmployeeBillingState**](BillsApi.md#billsEmployeeBillingState) | **GET** /v1/bills/employee/billing-state | Forward &#x60;Web_GetEmployeeBillingState&#x60; (opaque pass-through) |
| [**billsHouseholdCountry**](BillsApi.md#billsHouseholdCountry) | **GET** /v1/bills/billing/household-country | Forward &#x60;Web_BillingSettings_HouseholdCountry&#x60; (opaque pass-through) |
| [**billsMobileSignupUpdatePostalCode**](BillsApi.md#billsMobileSignupUpdatePostalCode) | **GET** /v1/bills/mobile-signup/postal-code | Forward &#x60;Mobile_SignupBillingZip_UpdateBillingPostalCode&#x60; (opaque pass-through) |
| [**billsOnboardingGetPostalCode**](BillsApi.md#billsOnboardingGetPostalCode) | **GET** /v1/bills/onboarding/postal-code | Forward &#x60;Web_OnboardingBillingZip_GetPostalCode&#x60; (opaque pass-through) |
| [**billsOnboardingUpdatePostalCode**](BillsApi.md#billsOnboardingUpdatePostalCode) | **GET** /v1/bills/onboarding/postal-code/update | Forward &#x60;Web_OnboardingBillingZip_UpdateBillingPostalCode&#x60; (opaque pass-through) |
| [**billsRegisterSplitParticipant**](BillsApi.md#billsRegisterSplitParticipant) | **GET** /v1/bills/split/register-participant | Forward &#x60;Web_RegisterBillSplitParticipant&#x60; (opaque pass-through) |
| [**billsSetEmployeeBillingIssue**](BillsApi.md#billsSetEmployeeBillingIssue) | **GET** /v1/bills/employee/billing-issue | Forward &#x60;Web_SetEmployeeBillingIssue&#x60; (opaque pass-through) |
| [**billsSubmitSplitInitiatorEdit**](BillsApi.md#billsSubmitSplitInitiatorEdit) | **GET** /v1/bills/split/initiator-edit | Forward &#x60;Web_SubmitBillSplitInitiatorEdit&#x60; (opaque pass-through) |
| [**billsToggleSyncTracking**](BillsApi.md#billsToggleSyncTracking) | **GET** /v1/bills/sync-tracking | Forward &#x60;Common_ToggleBillSyncTracking&#x60; (opaque pass-through) |
| [**billsUnclaimItem**](BillsApi.md#billsUnclaimItem) | **GET** /v1/bills/item/unclaim | Forward &#x60;Web_UnclaimBillItem&#x60; (opaque pass-through) |
| [**billsUpdatePostalCode**](BillsApi.md#billsUpdatePostalCode) | **GET** /v1/bills/billing/postal-code | Forward &#x60;Web_BillingZipModal_UpdateBillingPostalCode&#x60; (opaque pass-through) |


<a id="billsAdvisorBilling"></a>
# **billsAdvisorBilling**
> FeatureAreaResponse billsAdvisorBilling()

Forward &#x60;Web_GetAdvisorBillingPage&#x60; (opaque pass-through)

Advisor billing page detail. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = BillsApi()
try {
    val result : FeatureAreaResponse = apiInstance.billsAdvisorBilling()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BillsApi#billsAdvisorBilling")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BillsApi#billsAdvisorBilling")
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

<a id="billsBillingSettings"></a>
# **billsBillingSettings**
> FeatureAreaResponse billsBillingSettings()

Forward &#x60;GetBillingSettings&#x60; (opaque pass-through)

Billing settings snapshot. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = BillsApi()
try {
    val result : FeatureAreaResponse = apiInstance.billsBillingSettings()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BillsApi#billsBillingSettings")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BillsApi#billsBillingSettings")
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

<a id="billsCancelSponsorship"></a>
# **billsCancelSponsorship**
> FeatureAreaResponse billsCancelSponsorship()

Forward &#x60;Web_BillingSettingsCancelSponsorship&#x60; (opaque pass-through)

Cancel a sponsored billing arrangement. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = BillsApi()
try {
    val result : FeatureAreaResponse = apiInstance.billsCancelSponsorship()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BillsApi#billsCancelSponsorship")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BillsApi#billsCancelSponsorship")
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

<a id="billsClaimItem"></a>
# **billsClaimItem**
> FeatureAreaResponse billsClaimItem()

Forward &#x60;Web_ClaimBillItem&#x60; (opaque pass-through)

Claim a bill split item. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = BillsApi()
try {
    val result : FeatureAreaResponse = apiInstance.billsClaimItem()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BillsApi#billsClaimItem")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BillsApi#billsClaimItem")
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

<a id="billsDetail"></a>
# **billsDetail**
> FeatureAreaResponse billsDetail()

Forward &#x60;Web_GetBill&#x60; (opaque pass-through)

Bill detail. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = BillsApi()
try {
    val result : FeatureAreaResponse = apiInstance.billsDetail()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BillsApi#billsDetail")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BillsApi#billsDetail")
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

<a id="billsEmployeeBillingState"></a>
# **billsEmployeeBillingState**
> FeatureAreaResponse billsEmployeeBillingState()

Forward &#x60;Web_GetEmployeeBillingState&#x60; (opaque pass-through)

Get employee billing state. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = BillsApi()
try {
    val result : FeatureAreaResponse = apiInstance.billsEmployeeBillingState()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BillsApi#billsEmployeeBillingState")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BillsApi#billsEmployeeBillingState")
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

<a id="billsHouseholdCountry"></a>
# **billsHouseholdCountry**
> FeatureAreaResponse billsHouseholdCountry()

Forward &#x60;Web_BillingSettings_HouseholdCountry&#x60; (opaque pass-through)

Update household country in billing. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = BillsApi()
try {
    val result : FeatureAreaResponse = apiInstance.billsHouseholdCountry()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BillsApi#billsHouseholdCountry")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BillsApi#billsHouseholdCountry")
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

<a id="billsMobileSignupUpdatePostalCode"></a>
# **billsMobileSignupUpdatePostalCode**
> FeatureAreaResponse billsMobileSignupUpdatePostalCode()

Forward &#x60;Mobile_SignupBillingZip_UpdateBillingPostalCode&#x60; (opaque pass-through)

Update billing postal code during mobile signup. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = BillsApi()
try {
    val result : FeatureAreaResponse = apiInstance.billsMobileSignupUpdatePostalCode()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BillsApi#billsMobileSignupUpdatePostalCode")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BillsApi#billsMobileSignupUpdatePostalCode")
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

<a id="billsOnboardingGetPostalCode"></a>
# **billsOnboardingGetPostalCode**
> FeatureAreaResponse billsOnboardingGetPostalCode()

Forward &#x60;Web_OnboardingBillingZip_GetPostalCode&#x60; (opaque pass-through)

Get billing postal code during onboarding. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = BillsApi()
try {
    val result : FeatureAreaResponse = apiInstance.billsOnboardingGetPostalCode()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BillsApi#billsOnboardingGetPostalCode")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BillsApi#billsOnboardingGetPostalCode")
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

<a id="billsOnboardingUpdatePostalCode"></a>
# **billsOnboardingUpdatePostalCode**
> FeatureAreaResponse billsOnboardingUpdatePostalCode()

Forward &#x60;Web_OnboardingBillingZip_UpdateBillingPostalCode&#x60; (opaque pass-through)

Update billing postal code during onboarding. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = BillsApi()
try {
    val result : FeatureAreaResponse = apiInstance.billsOnboardingUpdatePostalCode()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BillsApi#billsOnboardingUpdatePostalCode")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BillsApi#billsOnboardingUpdatePostalCode")
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

<a id="billsRegisterSplitParticipant"></a>
# **billsRegisterSplitParticipant**
> FeatureAreaResponse billsRegisterSplitParticipant()

Forward &#x60;Web_RegisterBillSplitParticipant&#x60; (opaque pass-through)

Register a bill split participant. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = BillsApi()
try {
    val result : FeatureAreaResponse = apiInstance.billsRegisterSplitParticipant()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BillsApi#billsRegisterSplitParticipant")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BillsApi#billsRegisterSplitParticipant")
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

<a id="billsSetEmployeeBillingIssue"></a>
# **billsSetEmployeeBillingIssue**
> FeatureAreaResponse billsSetEmployeeBillingIssue()

Forward &#x60;Web_SetEmployeeBillingIssue&#x60; (opaque pass-through)

Set employee billing issue flag. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = BillsApi()
try {
    val result : FeatureAreaResponse = apiInstance.billsSetEmployeeBillingIssue()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BillsApi#billsSetEmployeeBillingIssue")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BillsApi#billsSetEmployeeBillingIssue")
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

<a id="billsSubmitSplitInitiatorEdit"></a>
# **billsSubmitSplitInitiatorEdit**
> FeatureAreaResponse billsSubmitSplitInitiatorEdit()

Forward &#x60;Web_SubmitBillSplitInitiatorEdit&#x60; (opaque pass-through)

Submit a bill split initiator edit. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = BillsApi()
try {
    val result : FeatureAreaResponse = apiInstance.billsSubmitSplitInitiatorEdit()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BillsApi#billsSubmitSplitInitiatorEdit")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BillsApi#billsSubmitSplitInitiatorEdit")
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

<a id="billsToggleSyncTracking"></a>
# **billsToggleSyncTracking**
> FeatureAreaResponse billsToggleSyncTracking()

Forward &#x60;Common_ToggleBillSyncTracking&#x60; (opaque pass-through)

Toggle bill sync tracking. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = BillsApi()
try {
    val result : FeatureAreaResponse = apiInstance.billsToggleSyncTracking()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BillsApi#billsToggleSyncTracking")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BillsApi#billsToggleSyncTracking")
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

<a id="billsUnclaimItem"></a>
# **billsUnclaimItem**
> FeatureAreaResponse billsUnclaimItem()

Forward &#x60;Web_UnclaimBillItem&#x60; (opaque pass-through)

Unclaim a bill split item. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = BillsApi()
try {
    val result : FeatureAreaResponse = apiInstance.billsUnclaimItem()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BillsApi#billsUnclaimItem")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BillsApi#billsUnclaimItem")
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

<a id="billsUpdatePostalCode"></a>
# **billsUpdatePostalCode**
> FeatureAreaResponse billsUpdatePostalCode()

Forward &#x60;Web_BillingZipModal_UpdateBillingPostalCode&#x60; (opaque pass-through)

Update billing postal code from zip modal. Returns raw &#x60;data&#x60; tree as FreeForm.

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = BillsApi()
try {
    val result : FeatureAreaResponse = apiInstance.billsUpdatePostalCode()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BillsApi#billsUpdatePostalCode")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BillsApi#billsUpdatePostalCode")
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

