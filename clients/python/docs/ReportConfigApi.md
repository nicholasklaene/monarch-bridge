# monarch_bridge_client.ReportConfigApi

All URIs are relative to *http://localhost:9084*

Method | HTTP request | Description
------------- | ------------- | -------------
[**report_configs_command_palette**](ReportConfigApi.md#report_configs_command_palette) | **GET** /v1/report-configs/command-palette | Forward &#x60;Web_GetReportConfigurationsForCommandPalette&#x60; (opaque pass-through)
[**report_configs_create**](ReportConfigApi.md#report_configs_create) | **GET** /v1/report-configs/create | Forward &#x60;Common_CreateReportConfiguration&#x60; (opaque pass-through)
[**report_configs_delete**](ReportConfigApi.md#report_configs_delete) | **GET** /v1/report-configs/delete | Forward &#x60;Common_DeleteReportConfiguration&#x60; (opaque pass-through)
[**report_configs_list**](ReportConfigApi.md#report_configs_list) | **GET** /v1/report-configs | Forward &#x60;Common_GetReportConfigurations&#x60; (opaque pass-through)
[**report_configs_update**](ReportConfigApi.md#report_configs_update) | **GET** /v1/report-configs/update | Forward &#x60;Common_UpdateReportConfiguration&#x60; (opaque pass-through)


# **report_configs_command_palette**
> FeatureAreaResponse report_configs_command_palette()

Forward `Web_GetReportConfigurationsForCommandPalette` (opaque pass-through)

List report configurations for the command palette. Returns raw `data` tree as FreeForm.

### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.feature_area_response import FeatureAreaResponse
from monarch_bridge_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:9084
# See configuration.py for a list of all supported configuration parameters.
configuration = monarch_bridge_client.Configuration(
    host = "http://localhost:9084"
)


# Enter a context with an instance of the API client
with monarch_bridge_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = monarch_bridge_client.ReportConfigApi(api_client)

    try:
        # Forward `Web_GetReportConfigurationsForCommandPalette` (opaque pass-through)
        api_response = api_instance.report_configs_command_palette()
        print("The response of ReportConfigApi->report_configs_command_palette:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ReportConfigApi->report_configs_command_palette: %s\n" % e)
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

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **report_configs_create**
> FeatureAreaResponse report_configs_create()

Forward `Common_CreateReportConfiguration` (opaque pass-through)

Create a report configuration. Returns raw `data` tree as FreeForm.

### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.feature_area_response import FeatureAreaResponse
from monarch_bridge_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:9084
# See configuration.py for a list of all supported configuration parameters.
configuration = monarch_bridge_client.Configuration(
    host = "http://localhost:9084"
)


# Enter a context with an instance of the API client
with monarch_bridge_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = monarch_bridge_client.ReportConfigApi(api_client)

    try:
        # Forward `Common_CreateReportConfiguration` (opaque pass-through)
        api_response = api_instance.report_configs_create()
        print("The response of ReportConfigApi->report_configs_create:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ReportConfigApi->report_configs_create: %s\n" % e)
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

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **report_configs_delete**
> FeatureAreaResponse report_configs_delete()

Forward `Common_DeleteReportConfiguration` (opaque pass-through)

Delete a report configuration. Returns raw `data` tree as FreeForm.

### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.feature_area_response import FeatureAreaResponse
from monarch_bridge_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:9084
# See configuration.py for a list of all supported configuration parameters.
configuration = monarch_bridge_client.Configuration(
    host = "http://localhost:9084"
)


# Enter a context with an instance of the API client
with monarch_bridge_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = monarch_bridge_client.ReportConfigApi(api_client)

    try:
        # Forward `Common_DeleteReportConfiguration` (opaque pass-through)
        api_response = api_instance.report_configs_delete()
        print("The response of ReportConfigApi->report_configs_delete:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ReportConfigApi->report_configs_delete: %s\n" % e)
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

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **report_configs_list**
> FeatureAreaResponse report_configs_list()

Forward `Common_GetReportConfigurations` (opaque pass-through)

List report configurations. Returns raw `data` tree as FreeForm.

### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.feature_area_response import FeatureAreaResponse
from monarch_bridge_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:9084
# See configuration.py for a list of all supported configuration parameters.
configuration = monarch_bridge_client.Configuration(
    host = "http://localhost:9084"
)


# Enter a context with an instance of the API client
with monarch_bridge_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = monarch_bridge_client.ReportConfigApi(api_client)

    try:
        # Forward `Common_GetReportConfigurations` (opaque pass-through)
        api_response = api_instance.report_configs_list()
        print("The response of ReportConfigApi->report_configs_list:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ReportConfigApi->report_configs_list: %s\n" % e)
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

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **report_configs_update**
> FeatureAreaResponse report_configs_update()

Forward `Common_UpdateReportConfiguration` (opaque pass-through)

Update a report configuration. Returns raw `data` tree as FreeForm.

### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.feature_area_response import FeatureAreaResponse
from monarch_bridge_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:9084
# See configuration.py for a list of all supported configuration parameters.
configuration = monarch_bridge_client.Configuration(
    host = "http://localhost:9084"
)


# Enter a context with an instance of the API client
with monarch_bridge_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = monarch_bridge_client.ReportConfigApi(api_client)

    try:
        # Forward `Common_UpdateReportConfiguration` (opaque pass-through)
        api_response = api_instance.report_configs_update()
        print("The response of ReportConfigApi->report_configs_update:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ReportConfigApi->report_configs_update: %s\n" % e)
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

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Raw &#x60;data&#x60; payload from Monarch wrapped in FreeForm. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

