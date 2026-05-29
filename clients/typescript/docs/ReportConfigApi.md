# ReportConfigApi

All URIs are relative to *http://localhost:9084*

|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|[**reportConfigsCommandPalette**](#reportconfigscommandpalette) | **GET** /v1/report-configs/command-palette | Forward &#x60;Web_GetReportConfigurationsForCommandPalette&#x60; (opaque pass-through)|
|[**reportConfigsCreate**](#reportconfigscreate) | **GET** /v1/report-configs/create | Forward &#x60;Common_CreateReportConfiguration&#x60; (opaque pass-through)|
|[**reportConfigsDelete**](#reportconfigsdelete) | **GET** /v1/report-configs/delete | Forward &#x60;Common_DeleteReportConfiguration&#x60; (opaque pass-through)|
|[**reportConfigsList**](#reportconfigslist) | **GET** /v1/report-configs | Forward &#x60;Common_GetReportConfigurations&#x60; (opaque pass-through)|
|[**reportConfigsUpdate**](#reportconfigsupdate) | **GET** /v1/report-configs/update | Forward &#x60;Common_UpdateReportConfiguration&#x60; (opaque pass-through)|

# **reportConfigsCommandPalette**
> FeatureAreaResponse reportConfigsCommandPalette()

List report configurations for the command palette. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    ReportConfigApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new ReportConfigApi(configuration);

const { status, data } = await apiInstance.reportConfigsCommandPalette();
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

# **reportConfigsCreate**
> FeatureAreaResponse reportConfigsCreate()

Create a report configuration. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    ReportConfigApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new ReportConfigApi(configuration);

const { status, data } = await apiInstance.reportConfigsCreate();
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

# **reportConfigsDelete**
> FeatureAreaResponse reportConfigsDelete()

Delete a report configuration. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    ReportConfigApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new ReportConfigApi(configuration);

const { status, data } = await apiInstance.reportConfigsDelete();
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

# **reportConfigsList**
> FeatureAreaResponse reportConfigsList()

List report configurations. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    ReportConfigApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new ReportConfigApi(configuration);

const { status, data } = await apiInstance.reportConfigsList();
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

# **reportConfigsUpdate**
> FeatureAreaResponse reportConfigsUpdate()

Update a report configuration. Returns raw `data` tree as FreeForm.

### Example

```typescript
import {
    ReportConfigApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new ReportConfigApi(configuration);

const { status, data } = await apiInstance.reportConfigsUpdate();
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

