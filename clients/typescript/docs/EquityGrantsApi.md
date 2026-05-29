# EquityGrantsApi

All URIs are relative to *http://localhost:9084*

|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|[**equityGrantsCreate**](#equitygrantscreate) | **GET** /v1/equity-grants/create | Forward &#x60;Web_CreateEquityGrant&#x60; (opaque pass-through)|
|[**equityGrantsDelete**](#equitygrantsdelete) | **GET** /v1/equity-grants/delete | Forward &#x60;Web_DeleteEquityGrant&#x60; (opaque pass-through)|
|[**equityGrantsEditModal**](#equitygrantseditmodal) | **GET** /v1/equity-grants/edit-modal/detail | Forward &#x60;Web_EditEquityGrantModal_GetEquityGrant&#x60; (opaque pass-through)|
|[**equityGrantsList**](#equitygrantslist) | **GET** /v1/equity-grants | Forward &#x60;Web_GetEquityGrants&#x60; (opaque pass-through)|
|[**equityGrantsManageHoldingsModal**](#equitygrantsmanageholdingsmodal) | **GET** /v1/equity-grants/manage-holdings-modal | Forward &#x60;Web_ManageEquityHoldingsModal_GetEquityGrants&#x60; (opaque pass-through)|
|[**equityGrantsPreview**](#equitygrantspreview) | **GET** /v1/equity-grants/preview | Forward &#x60;Web_PreviewEquityGrant&#x60; (opaque pass-through)|
|[**equityGrantsUpdate**](#equitygrantsupdate) | **GET** /v1/equity-grants/update | Forward &#x60;Web_UpdateEquityGrant&#x60; (opaque pass-through)|

# **equityGrantsCreate**
> FeatureAreaResponse equityGrantsCreate()

Create an equity grant. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    EquityGrantsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new EquityGrantsApi(configuration);

const { status, data } = await apiInstance.equityGrantsCreate();
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

# **equityGrantsDelete**
> FeatureAreaResponse equityGrantsDelete()

Delete an equity grant. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    EquityGrantsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new EquityGrantsApi(configuration);

const { status, data } = await apiInstance.equityGrantsDelete();
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

# **equityGrantsEditModal**
> FeatureAreaResponse equityGrantsEditModal()

Get an equity grant detail for the edit modal. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    EquityGrantsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new EquityGrantsApi(configuration);

const { status, data } = await apiInstance.equityGrantsEditModal();
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

# **equityGrantsList**
> FeatureAreaResponse equityGrantsList()

List equity grants. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    EquityGrantsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new EquityGrantsApi(configuration);

const { status, data } = await apiInstance.equityGrantsList();
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

# **equityGrantsManageHoldingsModal**
> FeatureAreaResponse equityGrantsManageHoldingsModal()

Get equity grants for the manage-holdings modal. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    EquityGrantsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new EquityGrantsApi(configuration);

const { status, data } = await apiInstance.equityGrantsManageHoldingsModal();
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

# **equityGrantsPreview**
> FeatureAreaResponse equityGrantsPreview()

Preview an equity grant. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    EquityGrantsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new EquityGrantsApi(configuration);

const { status, data } = await apiInstance.equityGrantsPreview();
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

# **equityGrantsUpdate**
> FeatureAreaResponse equityGrantsUpdate()

Update an equity grant. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    EquityGrantsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new EquityGrantsApi(configuration);

const { status, data } = await apiInstance.equityGrantsUpdate();
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

