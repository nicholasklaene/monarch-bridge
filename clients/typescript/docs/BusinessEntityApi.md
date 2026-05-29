# BusinessEntityApi

All URIs are relative to *http://localhost:9084*

|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|[**businessEntitiesDelete**](#businessentitiesdelete) | **GET** /v1/business-entities/delete | Forward &#x60;Common_DeleteBusinessEntity&#x60; (opaque pass-through)|
|[**businessEntitiesDeleteLogo**](#businessentitiesdeletelogo) | **GET** /v1/business-entities/logo/delete | Forward &#x60;Common_DeleteBusinessEntityLogo&#x60; (opaque pass-through)|
|[**businessEntitiesDemoPopulate**](#businessentitiesdemopopulate) | **GET** /v1/business-entities/demo/populate | Forward &#x60;Web_PopulateBusinessEntityDemo&#x60; (opaque pass-through)|
|[**businessEntitiesDemoScenarios**](#businessentitiesdemoscenarios) | **GET** /v1/business-entities/demo/scenarios | Forward &#x60;Web_AvailableBusinessEntityDemoScenarios&#x60; (opaque pass-through)|
|[**businessEntitiesDetail**](#businessentitiesdetail) | **GET** /v1/business-entities/detail | Forward &#x60;Common_GetBusinessEntity&#x60; (opaque pass-through)|
|[**businessEntitiesFinancials**](#businessentitiesfinancials) | **GET** /v1/business-entities/financials | Forward &#x60;Common_GetBusinessEntityFinancials&#x60; (opaque pass-through)|
|[**businessEntitiesReportsByCategory**](#businessentitiesreportsbycategory) | **GET** /v1/business-entities/reports/by-category | Forward &#x60;Common_GetBusinessEntityReportsDataByCategory&#x60; (opaque pass-through)|
|[**businessEntitiesReportsByGroup**](#businessentitiesreportsbygroup) | **GET** /v1/business-entities/reports/by-group | Forward &#x60;Common_GetBusinessEntityReportsDataByGroup&#x60; (opaque pass-through)|
|[**businessEntitiesUpsert**](#businessentitiesupsert) | **GET** /v1/business-entities/upsert | Forward &#x60;Common_UpsertBusinessEntity&#x60; (opaque pass-through)|

# **businessEntitiesDelete**
> FeatureAreaResponse businessEntitiesDelete()

Delete a business entity. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    BusinessEntityApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new BusinessEntityApi(configuration);

const { status, data } = await apiInstance.businessEntitiesDelete();
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

# **businessEntitiesDeleteLogo**
> FeatureAreaResponse businessEntitiesDeleteLogo()

Delete a business entity logo. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    BusinessEntityApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new BusinessEntityApi(configuration);

const { status, data } = await apiInstance.businessEntitiesDeleteLogo();
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

# **businessEntitiesDemoPopulate**
> FeatureAreaResponse businessEntitiesDemoPopulate()

Populate a business entity with demo data. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    BusinessEntityApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new BusinessEntityApi(configuration);

const { status, data } = await apiInstance.businessEntitiesDemoPopulate();
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

# **businessEntitiesDemoScenarios**
> FeatureAreaResponse businessEntitiesDemoScenarios()

List demo scenarios available for business entity onboarding. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    BusinessEntityApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new BusinessEntityApi(configuration);

const { status, data } = await apiInstance.businessEntitiesDemoScenarios();
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

# **businessEntitiesDetail**
> FeatureAreaResponse businessEntitiesDetail()

Get business entity detail. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    BusinessEntityApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new BusinessEntityApi(configuration);

const { status, data } = await apiInstance.businessEntitiesDetail();
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

# **businessEntitiesFinancials**
> FeatureAreaResponse businessEntitiesFinancials()

Get business entity financials. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    BusinessEntityApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new BusinessEntityApi(configuration);

const { status, data } = await apiInstance.businessEntitiesFinancials();
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

# **businessEntitiesReportsByCategory**
> FeatureAreaResponse businessEntitiesReportsByCategory()

Business entity reports broken down by category. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    BusinessEntityApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new BusinessEntityApi(configuration);

const { status, data } = await apiInstance.businessEntitiesReportsByCategory();
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

# **businessEntitiesReportsByGroup**
> FeatureAreaResponse businessEntitiesReportsByGroup()

Business entity reports broken down by group. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    BusinessEntityApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new BusinessEntityApi(configuration);

const { status, data } = await apiInstance.businessEntitiesReportsByGroup();
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

# **businessEntitiesUpsert**
> FeatureAreaResponse businessEntitiesUpsert()

Upsert a business entity. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    BusinessEntityApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new BusinessEntityApi(configuration);

const { status, data } = await apiInstance.businessEntitiesUpsert();
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

