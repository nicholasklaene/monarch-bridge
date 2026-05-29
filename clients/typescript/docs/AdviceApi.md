# AdviceApi

All URIs are relative to *http://localhost:9084*

|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|[**advice**](#advice) | **GET** /v1/advice | Forward &#x60;AdviceQuery_Web&#x60; (opaque pass-through)|
|[**adviceDashboardWidget**](#advicedashboardwidget) | **GET** /v1/advice/dashboard-widget | Forward &#x60;Web_GetAdviceDashboardWidget&#x60; (opaque pass-through)|
|[**adviceItemDrawer**](#adviceitemdrawer) | **GET** /v1/advice/item-drawer | Forward &#x60;AdviceItemDrawerQuery_Web&#x60; (opaque pass-through)|
|[**adviceQuestionnaire**](#advicequestionnaire) | **GET** /v1/advice/questionnaire | Forward &#x60;Web_AdviceQuestionnaire&#x60; (opaque pass-through)|
|[**adviceTaskComplete**](#advicetaskcomplete) | **GET** /v1/advice/task/complete | Forward &#x60;Web_MarkAdviceTaskComplete&#x60; (opaque pass-through)|
|[**adviceTaskDrawer**](#advicetaskdrawer) | **GET** /v1/advice/task-drawer | Forward &#x60;AdviceTaskDrawerQuery_Web&#x60; (opaque pass-through)|
|[**adviceTaskIncomplete**](#advicetaskincomplete) | **GET** /v1/advice/task/incomplete | Forward &#x60;Web_MarkAdviceTaskIncomplete&#x60; (opaque pass-through)|

# **advice**
> FeatureAreaResponse advice()

Advice landing query. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    AdviceApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new AdviceApi(configuration);

const { status, data } = await apiInstance.advice();
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

# **adviceDashboardWidget**
> FeatureAreaResponse adviceDashboardWidget()

Dashboard advice widget snapshot. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    AdviceApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new AdviceApi(configuration);

const { status, data } = await apiInstance.adviceDashboardWidget();
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

# **adviceItemDrawer**
> FeatureAreaResponse adviceItemDrawer()

Advice item-drawer detail query. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    AdviceApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new AdviceApi(configuration);

const { status, data } = await apiInstance.adviceItemDrawer();
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

# **adviceQuestionnaire**
> FeatureAreaResponse adviceQuestionnaire()

Advice onboarding questionnaire. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    AdviceApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new AdviceApi(configuration);

const { status, data } = await apiInstance.adviceQuestionnaire();
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

# **adviceTaskComplete**
> FeatureAreaResponse adviceTaskComplete()

Mark an advice task complete. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    AdviceApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new AdviceApi(configuration);

const { status, data } = await apiInstance.adviceTaskComplete();
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

# **adviceTaskDrawer**
> FeatureAreaResponse adviceTaskDrawer()

Advice task-drawer detail query. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    AdviceApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new AdviceApi(configuration);

const { status, data } = await apiInstance.adviceTaskDrawer();
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

# **adviceTaskIncomplete**
> FeatureAreaResponse adviceTaskIncomplete()

Mark an advice task incomplete. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    AdviceApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new AdviceApi(configuration);

const { status, data } = await apiInstance.adviceTaskIncomplete();
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

