# ForecastApi

All URIs are relative to *http://localhost:9084*

|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|[**forecastCreateScenario**](#forecastcreatescenario) | **GET** /v1/forecast/scenarios/create | Forward &#x60;Web_CreateForecastScenario&#x60; (opaque pass-through)|
|[**forecastDeleteScenario**](#forecastdeletescenario) | **GET** /v1/forecast/scenarios/delete | Forward &#x60;Web_DeleteForecastScenario&#x60; (opaque pass-through)|
|[**forecastDuplicateScenario**](#forecastduplicatescenario) | **GET** /v1/forecast/scenarios/duplicate | Forward &#x60;Web_DuplicateForecastScenario&#x60; (opaque pass-through)|
|[**forecastInitialize**](#forecastinitialize) | **GET** /v1/forecast/initialize | Forward &#x60;Web_InitializeForecast&#x60; (opaque pass-through)|
|[**forecastOnboardingComplete**](#forecastonboardingcomplete) | **GET** /v1/forecast/onboarding/complete | Forward &#x60;Web_MarkForecastOnboardingComplete&#x60; (opaque pass-through)|
|[**forecastReplaceEvents**](#forecastreplaceevents) | **GET** /v1/forecast/events/replace | Forward &#x60;Web_ReplaceForecastEvents&#x60; (opaque pass-through)|
|[**forecastResetData**](#forecastresetdata) | **GET** /v1/forecast/data/reset | Forward &#x60;Web_ResetForecastData&#x60; (opaque pass-through)|
|[**forecastResetOnboarding**](#forecastresetonboarding) | **GET** /v1/forecast/onboarding/reset | Forward &#x60;Web_ResetForecastOnboarding&#x60; (opaque pass-through)|
|[**forecastSaveAccounts**](#forecastsaveaccounts) | **GET** /v1/forecast/accounts | Forward &#x60;Web_SaveForecastAccounts&#x60; (opaque pass-through)|
|[**forecastSaveParticipantOverrides**](#forecastsaveparticipantoverrides) | **GET** /v1/forecast/participant-overrides | Forward &#x60;Web_SaveForecastParticipantOverrides&#x60; (opaque pass-through)|
|[**forecastSavePriorityRules**](#forecastsavepriorityrules) | **GET** /v1/forecast/priority-rules | Forward &#x60;Web_SaveForecastPriorityRules&#x60; (opaque pass-through)|
|[**forecastSaveScenarioKpis**](#forecastsavescenariokpis) | **GET** /v1/forecast/scenario-kpis | Forward &#x60;Web_SaveForecastScenarioKpis&#x60; (opaque pass-through)|
|[**forecastScenario**](#forecastscenario) | **GET** /v1/forecast/scenario | Forward &#x60;Web_ForecastScenario&#x60; (opaque pass-through)|
|[**forecastScenarios**](#forecastscenarios) | **GET** /v1/forecast/scenarios | Forward &#x60;Web_ForecastScenarios&#x60; (opaque pass-through)|
|[**forecastUpdateScenario**](#forecastupdatescenario) | **GET** /v1/forecast/scenarios/update | Forward &#x60;Web_UpdateForecastScenario&#x60; (opaque pass-through)|
|[**forecastUpdateScenarioOrder**](#forecastupdatescenarioorder) | **GET** /v1/forecast/scenarios/order | Forward &#x60;Web_UpdateForecastScenarioOrder&#x60; (opaque pass-through)|
|[**forecastUpdateUserFinancialProfile**](#forecastupdateuserfinancialprofile) | **GET** /v1/forecast/user-financial-profile | Forward &#x60;Web_ForecastUpdateUserFinancialProfile&#x60; (opaque pass-through)|

# **forecastCreateScenario**
> FeatureAreaResponse forecastCreateScenario()

Create a forecast scenario. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    ForecastApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new ForecastApi(configuration);

const { status, data } = await apiInstance.forecastCreateScenario();
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

# **forecastDeleteScenario**
> FeatureAreaResponse forecastDeleteScenario()

Delete a forecast scenario. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    ForecastApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new ForecastApi(configuration);

const { status, data } = await apiInstance.forecastDeleteScenario();
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

# **forecastDuplicateScenario**
> FeatureAreaResponse forecastDuplicateScenario()

Duplicate a forecast scenario. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    ForecastApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new ForecastApi(configuration);

const { status, data } = await apiInstance.forecastDuplicateScenario();
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

# **forecastInitialize**
> FeatureAreaResponse forecastInitialize()

Initialize forecast feature. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    ForecastApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new ForecastApi(configuration);

const { status, data } = await apiInstance.forecastInitialize();
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

# **forecastOnboardingComplete**
> FeatureAreaResponse forecastOnboardingComplete()

Mark forecast onboarding complete. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    ForecastApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new ForecastApi(configuration);

const { status, data } = await apiInstance.forecastOnboardingComplete();
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

# **forecastReplaceEvents**
> FeatureAreaResponse forecastReplaceEvents()

Replace forecast events. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    ForecastApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new ForecastApi(configuration);

const { status, data } = await apiInstance.forecastReplaceEvents();
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

# **forecastResetData**
> FeatureAreaResponse forecastResetData()

Reset forecast data. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    ForecastApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new ForecastApi(configuration);

const { status, data } = await apiInstance.forecastResetData();
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

# **forecastResetOnboarding**
> FeatureAreaResponse forecastResetOnboarding()

Reset forecast onboarding. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    ForecastApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new ForecastApi(configuration);

const { status, data } = await apiInstance.forecastResetOnboarding();
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

# **forecastSaveAccounts**
> FeatureAreaResponse forecastSaveAccounts()

Save forecast account selections. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    ForecastApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new ForecastApi(configuration);

const { status, data } = await apiInstance.forecastSaveAccounts();
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

# **forecastSaveParticipantOverrides**
> FeatureAreaResponse forecastSaveParticipantOverrides()

Save forecast participant overrides. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    ForecastApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new ForecastApi(configuration);

const { status, data } = await apiInstance.forecastSaveParticipantOverrides();
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

# **forecastSavePriorityRules**
> FeatureAreaResponse forecastSavePriorityRules()

Save forecast priority rules. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    ForecastApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new ForecastApi(configuration);

const { status, data } = await apiInstance.forecastSavePriorityRules();
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

# **forecastSaveScenarioKpis**
> FeatureAreaResponse forecastSaveScenarioKpis()

Save forecast scenario KPIs. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    ForecastApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new ForecastApi(configuration);

const { status, data } = await apiInstance.forecastSaveScenarioKpis();
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

# **forecastScenario**
> FeatureAreaResponse forecastScenario()

Single forecast scenario detail. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    ForecastApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new ForecastApi(configuration);

const { status, data } = await apiInstance.forecastScenario();
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

# **forecastScenarios**
> FeatureAreaResponse forecastScenarios()

List forecast scenarios. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    ForecastApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new ForecastApi(configuration);

const { status, data } = await apiInstance.forecastScenarios();
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

# **forecastUpdateScenario**
> FeatureAreaResponse forecastUpdateScenario()

Update a forecast scenario. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    ForecastApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new ForecastApi(configuration);

const { status, data } = await apiInstance.forecastUpdateScenario();
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

# **forecastUpdateScenarioOrder**
> FeatureAreaResponse forecastUpdateScenarioOrder()

Reorder forecast scenarios. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    ForecastApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new ForecastApi(configuration);

const { status, data } = await apiInstance.forecastUpdateScenarioOrder();
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

# **forecastUpdateUserFinancialProfile**
> FeatureAreaResponse forecastUpdateUserFinancialProfile()

Update user financial profile from forecast. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    ForecastApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new ForecastApi(configuration);

const { status, data } = await apiInstance.forecastUpdateUserFinancialProfile();
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

