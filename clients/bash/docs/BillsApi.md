# BillsApi

All URIs are relative to **

Method | HTTP request | Description
------------- | ------------- | -------------
[**billsAdvisorBilling**](BillsApi.md#billsAdvisorBilling) | **GET** /v1/bills/advisor-billing | Forward &#39;Web_GetAdvisorBillingPage&#39; (opaque pass-through)
[**billsBillingSettings**](BillsApi.md#billsBillingSettings) | **GET** /v1/bills/billing-settings | Forward &#39;GetBillingSettings&#39; (opaque pass-through)
[**billsCancelSponsorship**](BillsApi.md#billsCancelSponsorship) | **GET** /v1/bills/billing/sponsorship/cancel | Forward &#39;Web_BillingSettingsCancelSponsorship&#39; (opaque pass-through)
[**billsClaimItem**](BillsApi.md#billsClaimItem) | **GET** /v1/bills/item/claim | Forward &#39;Web_ClaimBillItem&#39; (opaque pass-through)
[**billsDetail**](BillsApi.md#billsDetail) | **GET** /v1/bills/detail | Forward &#39;Web_GetBill&#39; (opaque pass-through)
[**billsEmployeeBillingState**](BillsApi.md#billsEmployeeBillingState) | **GET** /v1/bills/employee/billing-state | Forward &#39;Web_GetEmployeeBillingState&#39; (opaque pass-through)
[**billsHouseholdCountry**](BillsApi.md#billsHouseholdCountry) | **GET** /v1/bills/billing/household-country | Forward &#39;Web_BillingSettings_HouseholdCountry&#39; (opaque pass-through)
[**billsMobileSignupUpdatePostalCode**](BillsApi.md#billsMobileSignupUpdatePostalCode) | **GET** /v1/bills/mobile-signup/postal-code | Forward &#39;Mobile_SignupBillingZip_UpdateBillingPostalCode&#39; (opaque pass-through)
[**billsOnboardingGetPostalCode**](BillsApi.md#billsOnboardingGetPostalCode) | **GET** /v1/bills/onboarding/postal-code | Forward &#39;Web_OnboardingBillingZip_GetPostalCode&#39; (opaque pass-through)
[**billsOnboardingUpdatePostalCode**](BillsApi.md#billsOnboardingUpdatePostalCode) | **GET** /v1/bills/onboarding/postal-code/update | Forward &#39;Web_OnboardingBillingZip_UpdateBillingPostalCode&#39; (opaque pass-through)
[**billsRegisterSplitParticipant**](BillsApi.md#billsRegisterSplitParticipant) | **GET** /v1/bills/split/register-participant | Forward &#39;Web_RegisterBillSplitParticipant&#39; (opaque pass-through)
[**billsSetEmployeeBillingIssue**](BillsApi.md#billsSetEmployeeBillingIssue) | **GET** /v1/bills/employee/billing-issue | Forward &#39;Web_SetEmployeeBillingIssue&#39; (opaque pass-through)
[**billsSubmitSplitInitiatorEdit**](BillsApi.md#billsSubmitSplitInitiatorEdit) | **GET** /v1/bills/split/initiator-edit | Forward &#39;Web_SubmitBillSplitInitiatorEdit&#39; (opaque pass-through)
[**billsToggleSyncTracking**](BillsApi.md#billsToggleSyncTracking) | **GET** /v1/bills/sync-tracking | Forward &#39;Common_ToggleBillSyncTracking&#39; (opaque pass-through)
[**billsUnclaimItem**](BillsApi.md#billsUnclaimItem) | **GET** /v1/bills/item/unclaim | Forward &#39;Web_UnclaimBillItem&#39; (opaque pass-through)
[**billsUpdatePostalCode**](BillsApi.md#billsUpdatePostalCode) | **GET** /v1/bills/billing/postal-code | Forward &#39;Web_BillingZipModal_UpdateBillingPostalCode&#39; (opaque pass-through)



## billsAdvisorBilling

Forward 'Web_GetAdvisorBillingPage' (opaque pass-through)

Advisor billing page detail. Returns raw 'data' tree as FreeForm.

### Example

```bash
monarch-api billsAdvisorBilling
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**FeatureAreaResponse**](FeatureAreaResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## billsBillingSettings

Forward 'GetBillingSettings' (opaque pass-through)

Billing settings snapshot. Returns raw 'data' tree as FreeForm.

### Example

```bash
monarch-api billsBillingSettings
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**FeatureAreaResponse**](FeatureAreaResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## billsCancelSponsorship

Forward 'Web_BillingSettingsCancelSponsorship' (opaque pass-through)

Cancel a sponsored billing arrangement. Returns raw 'data' tree as FreeForm.

### Example

```bash
monarch-api billsCancelSponsorship
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**FeatureAreaResponse**](FeatureAreaResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## billsClaimItem

Forward 'Web_ClaimBillItem' (opaque pass-through)

Claim a bill split item. Returns raw 'data' tree as FreeForm.

### Example

```bash
monarch-api billsClaimItem
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**FeatureAreaResponse**](FeatureAreaResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## billsDetail

Forward 'Web_GetBill' (opaque pass-through)

Bill detail. Returns raw 'data' tree as FreeForm.

### Example

```bash
monarch-api billsDetail
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**FeatureAreaResponse**](FeatureAreaResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## billsEmployeeBillingState

Forward 'Web_GetEmployeeBillingState' (opaque pass-through)

Get employee billing state. Returns raw 'data' tree as FreeForm.

### Example

```bash
monarch-api billsEmployeeBillingState
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**FeatureAreaResponse**](FeatureAreaResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## billsHouseholdCountry

Forward 'Web_BillingSettings_HouseholdCountry' (opaque pass-through)

Update household country in billing. Returns raw 'data' tree as FreeForm.

### Example

```bash
monarch-api billsHouseholdCountry
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**FeatureAreaResponse**](FeatureAreaResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## billsMobileSignupUpdatePostalCode

Forward 'Mobile_SignupBillingZip_UpdateBillingPostalCode' (opaque pass-through)

Update billing postal code during mobile signup. Returns raw 'data' tree as FreeForm.

### Example

```bash
monarch-api billsMobileSignupUpdatePostalCode
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**FeatureAreaResponse**](FeatureAreaResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## billsOnboardingGetPostalCode

Forward 'Web_OnboardingBillingZip_GetPostalCode' (opaque pass-through)

Get billing postal code during onboarding. Returns raw 'data' tree as FreeForm.

### Example

```bash
monarch-api billsOnboardingGetPostalCode
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**FeatureAreaResponse**](FeatureAreaResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## billsOnboardingUpdatePostalCode

Forward 'Web_OnboardingBillingZip_UpdateBillingPostalCode' (opaque pass-through)

Update billing postal code during onboarding. Returns raw 'data' tree as FreeForm.

### Example

```bash
monarch-api billsOnboardingUpdatePostalCode
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**FeatureAreaResponse**](FeatureAreaResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## billsRegisterSplitParticipant

Forward 'Web_RegisterBillSplitParticipant' (opaque pass-through)

Register a bill split participant. Returns raw 'data' tree as FreeForm.

### Example

```bash
monarch-api billsRegisterSplitParticipant
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**FeatureAreaResponse**](FeatureAreaResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## billsSetEmployeeBillingIssue

Forward 'Web_SetEmployeeBillingIssue' (opaque pass-through)

Set employee billing issue flag. Returns raw 'data' tree as FreeForm.

### Example

```bash
monarch-api billsSetEmployeeBillingIssue
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**FeatureAreaResponse**](FeatureAreaResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## billsSubmitSplitInitiatorEdit

Forward 'Web_SubmitBillSplitInitiatorEdit' (opaque pass-through)

Submit a bill split initiator edit. Returns raw 'data' tree as FreeForm.

### Example

```bash
monarch-api billsSubmitSplitInitiatorEdit
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**FeatureAreaResponse**](FeatureAreaResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## billsToggleSyncTracking

Forward 'Common_ToggleBillSyncTracking' (opaque pass-through)

Toggle bill sync tracking. Returns raw 'data' tree as FreeForm.

### Example

```bash
monarch-api billsToggleSyncTracking
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**FeatureAreaResponse**](FeatureAreaResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## billsUnclaimItem

Forward 'Web_UnclaimBillItem' (opaque pass-through)

Unclaim a bill split item. Returns raw 'data' tree as FreeForm.

### Example

```bash
monarch-api billsUnclaimItem
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**FeatureAreaResponse**](FeatureAreaResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## billsUpdatePostalCode

Forward 'Web_BillingZipModal_UpdateBillingPostalCode' (opaque pass-through)

Update billing postal code from zip modal. Returns raw 'data' tree as FreeForm.

### Example

```bash
monarch-api billsUpdatePostalCode
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**FeatureAreaResponse**](FeatureAreaResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

