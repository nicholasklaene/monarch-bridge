# BillsApi

All URIs are relative to *http://localhost:9084*

|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|[**billsAdvisorBilling**](#billsadvisorbilling) | **GET** /v1/bills/advisor-billing | Forward &#x60;Web_GetAdvisorBillingPage&#x60; (opaque pass-through)|
|[**billsBillingSettings**](#billsbillingsettings) | **GET** /v1/bills/billing-settings | Forward &#x60;GetBillingSettings&#x60; (opaque pass-through)|
|[**billsCancelSponsorship**](#billscancelsponsorship) | **GET** /v1/bills/billing/sponsorship/cancel | Forward &#x60;Web_BillingSettingsCancelSponsorship&#x60; (opaque pass-through)|
|[**billsClaimItem**](#billsclaimitem) | **GET** /v1/bills/item/claim | Forward &#x60;Web_ClaimBillItem&#x60; (opaque pass-through)|
|[**billsDetail**](#billsdetail) | **GET** /v1/bills/detail | Forward &#x60;Web_GetBill&#x60; (opaque pass-through)|
|[**billsEmployeeBillingState**](#billsemployeebillingstate) | **GET** /v1/bills/employee/billing-state | Forward &#x60;Web_GetEmployeeBillingState&#x60; (opaque pass-through)|
|[**billsHouseholdCountry**](#billshouseholdcountry) | **GET** /v1/bills/billing/household-country | Forward &#x60;Web_BillingSettings_HouseholdCountry&#x60; (opaque pass-through)|
|[**billsMobileSignupUpdatePostalCode**](#billsmobilesignupupdatepostalcode) | **GET** /v1/bills/mobile-signup/postal-code | Forward &#x60;Mobile_SignupBillingZip_UpdateBillingPostalCode&#x60; (opaque pass-through)|
|[**billsOnboardingGetPostalCode**](#billsonboardinggetpostalcode) | **GET** /v1/bills/onboarding/postal-code | Forward &#x60;Web_OnboardingBillingZip_GetPostalCode&#x60; (opaque pass-through)|
|[**billsOnboardingUpdatePostalCode**](#billsonboardingupdatepostalcode) | **GET** /v1/bills/onboarding/postal-code/update | Forward &#x60;Web_OnboardingBillingZip_UpdateBillingPostalCode&#x60; (opaque pass-through)|
|[**billsRegisterSplitParticipant**](#billsregistersplitparticipant) | **GET** /v1/bills/split/register-participant | Forward &#x60;Web_RegisterBillSplitParticipant&#x60; (opaque pass-through)|
|[**billsSetEmployeeBillingIssue**](#billssetemployeebillingissue) | **GET** /v1/bills/employee/billing-issue | Forward &#x60;Web_SetEmployeeBillingIssue&#x60; (opaque pass-through)|
|[**billsSubmitSplitInitiatorEdit**](#billssubmitsplitinitiatoredit) | **GET** /v1/bills/split/initiator-edit | Forward &#x60;Web_SubmitBillSplitInitiatorEdit&#x60; (opaque pass-through)|
|[**billsToggleSyncTracking**](#billstogglesynctracking) | **GET** /v1/bills/sync-tracking | Forward &#x60;Common_ToggleBillSyncTracking&#x60; (opaque pass-through)|
|[**billsUnclaimItem**](#billsunclaimitem) | **GET** /v1/bills/item/unclaim | Forward &#x60;Web_UnclaimBillItem&#x60; (opaque pass-through)|
|[**billsUpdatePostalCode**](#billsupdatepostalcode) | **GET** /v1/bills/billing/postal-code | Forward &#x60;Web_BillingZipModal_UpdateBillingPostalCode&#x60; (opaque pass-through)|

# **billsAdvisorBilling**
> FeatureAreaResponse billsAdvisorBilling()

Advisor billing page detail. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    BillsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new BillsApi(configuration);

const { status, data } = await apiInstance.billsAdvisorBilling();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**FeatureAreaResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **billsBillingSettings**
> FeatureAreaResponse billsBillingSettings()

Billing settings snapshot. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    BillsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new BillsApi(configuration);

const { status, data } = await apiInstance.billsBillingSettings();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**FeatureAreaResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **billsCancelSponsorship**
> FeatureAreaResponse billsCancelSponsorship()

Cancel a sponsored billing arrangement. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    BillsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new BillsApi(configuration);

const { status, data } = await apiInstance.billsCancelSponsorship();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**FeatureAreaResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **billsClaimItem**
> FeatureAreaResponse billsClaimItem()

Claim a bill split item. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    BillsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new BillsApi(configuration);

const { status, data } = await apiInstance.billsClaimItem();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**FeatureAreaResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **billsDetail**
> FeatureAreaResponse billsDetail()

Bill detail. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    BillsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new BillsApi(configuration);

const { status, data } = await apiInstance.billsDetail();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**FeatureAreaResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **billsEmployeeBillingState**
> FeatureAreaResponse billsEmployeeBillingState()

Get employee billing state. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    BillsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new BillsApi(configuration);

const { status, data } = await apiInstance.billsEmployeeBillingState();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**FeatureAreaResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **billsHouseholdCountry**
> FeatureAreaResponse billsHouseholdCountry()

Update household country in billing. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    BillsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new BillsApi(configuration);

const { status, data } = await apiInstance.billsHouseholdCountry();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**FeatureAreaResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **billsMobileSignupUpdatePostalCode**
> FeatureAreaResponse billsMobileSignupUpdatePostalCode()

Update billing postal code during mobile signup. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    BillsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new BillsApi(configuration);

const { status, data } = await apiInstance.billsMobileSignupUpdatePostalCode();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**FeatureAreaResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **billsOnboardingGetPostalCode**
> FeatureAreaResponse billsOnboardingGetPostalCode()

Get billing postal code during onboarding. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    BillsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new BillsApi(configuration);

const { status, data } = await apiInstance.billsOnboardingGetPostalCode();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**FeatureAreaResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **billsOnboardingUpdatePostalCode**
> FeatureAreaResponse billsOnboardingUpdatePostalCode()

Update billing postal code during onboarding. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    BillsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new BillsApi(configuration);

const { status, data } = await apiInstance.billsOnboardingUpdatePostalCode();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**FeatureAreaResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **billsRegisterSplitParticipant**
> FeatureAreaResponse billsRegisterSplitParticipant()

Register a bill split participant. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    BillsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new BillsApi(configuration);

const { status, data } = await apiInstance.billsRegisterSplitParticipant();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**FeatureAreaResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **billsSetEmployeeBillingIssue**
> FeatureAreaResponse billsSetEmployeeBillingIssue()

Set employee billing issue flag. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    BillsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new BillsApi(configuration);

const { status, data } = await apiInstance.billsSetEmployeeBillingIssue();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**FeatureAreaResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **billsSubmitSplitInitiatorEdit**
> FeatureAreaResponse billsSubmitSplitInitiatorEdit()

Submit a bill split initiator edit. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    BillsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new BillsApi(configuration);

const { status, data } = await apiInstance.billsSubmitSplitInitiatorEdit();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**FeatureAreaResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **billsToggleSyncTracking**
> FeatureAreaResponse billsToggleSyncTracking()

Toggle bill sync tracking. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    BillsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new BillsApi(configuration);

const { status, data } = await apiInstance.billsToggleSyncTracking();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**FeatureAreaResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **billsUnclaimItem**
> FeatureAreaResponse billsUnclaimItem()

Unclaim a bill split item. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    BillsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new BillsApi(configuration);

const { status, data } = await apiInstance.billsUnclaimItem();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**FeatureAreaResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **billsUpdatePostalCode**
> FeatureAreaResponse billsUpdatePostalCode()

Update billing postal code from zip modal. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    BillsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new BillsApi(configuration);

const { status, data } = await apiInstance.billsUpdatePostalCode();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**FeatureAreaResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

