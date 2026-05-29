# monarch_bridge_client.AdviceApi

All URIs are relative to *http://localhost:9084*

Method | HTTP request | Description
------------- | ------------- | -------------
[**advice**](AdviceApi.md#advice) | **GET** /v1/advice | Forward &#x60;AdviceQuery_Web&#x60; (opaque pass-through)
[**advice_dashboard_widget**](AdviceApi.md#advice_dashboard_widget) | **GET** /v1/advice/dashboard-widget | Forward &#x60;Web_GetAdviceDashboardWidget&#x60; (opaque pass-through)
[**advice_item_drawer**](AdviceApi.md#advice_item_drawer) | **GET** /v1/advice/item-drawer | Forward &#x60;AdviceItemDrawerQuery_Web&#x60; (opaque pass-through)
[**advice_questionnaire**](AdviceApi.md#advice_questionnaire) | **GET** /v1/advice/questionnaire | Forward &#x60;Web_AdviceQuestionnaire&#x60; (opaque pass-through)
[**advice_task_complete**](AdviceApi.md#advice_task_complete) | **GET** /v1/advice/task/complete | Forward &#x60;Web_MarkAdviceTaskComplete&#x60; (opaque pass-through)
[**advice_task_drawer**](AdviceApi.md#advice_task_drawer) | **GET** /v1/advice/task-drawer | Forward &#x60;AdviceTaskDrawerQuery_Web&#x60; (opaque pass-through)
[**advice_task_incomplete**](AdviceApi.md#advice_task_incomplete) | **GET** /v1/advice/task/incomplete | Forward &#x60;Web_MarkAdviceTaskIncomplete&#x60; (opaque pass-through)


# **advice**
> FeatureAreaResponse advice()

Forward `AdviceQuery_Web` (opaque pass-through)

Advice landing query. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.AdviceApi(api_client)

    try:
        # Forward `AdviceQuery_Web` (opaque pass-through)
        api_response = api_instance.advice()
        print("The response of AdviceApi->advice:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AdviceApi->advice: %s\n" % e)
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

# **advice_dashboard_widget**
> FeatureAreaResponse advice_dashboard_widget()

Forward `Web_GetAdviceDashboardWidget` (opaque pass-through)

Dashboard advice widget snapshot. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.AdviceApi(api_client)

    try:
        # Forward `Web_GetAdviceDashboardWidget` (opaque pass-through)
        api_response = api_instance.advice_dashboard_widget()
        print("The response of AdviceApi->advice_dashboard_widget:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AdviceApi->advice_dashboard_widget: %s\n" % e)
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

# **advice_item_drawer**
> FeatureAreaResponse advice_item_drawer()

Forward `AdviceItemDrawerQuery_Web` (opaque pass-through)

Advice item-drawer detail query. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.AdviceApi(api_client)

    try:
        # Forward `AdviceItemDrawerQuery_Web` (opaque pass-through)
        api_response = api_instance.advice_item_drawer()
        print("The response of AdviceApi->advice_item_drawer:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AdviceApi->advice_item_drawer: %s\n" % e)
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

# **advice_questionnaire**
> FeatureAreaResponse advice_questionnaire()

Forward `Web_AdviceQuestionnaire` (opaque pass-through)

Advice onboarding questionnaire. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.AdviceApi(api_client)

    try:
        # Forward `Web_AdviceQuestionnaire` (opaque pass-through)
        api_response = api_instance.advice_questionnaire()
        print("The response of AdviceApi->advice_questionnaire:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AdviceApi->advice_questionnaire: %s\n" % e)
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

# **advice_task_complete**
> FeatureAreaResponse advice_task_complete()

Forward `Web_MarkAdviceTaskComplete` (opaque pass-through)

Mark an advice task complete. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.AdviceApi(api_client)

    try:
        # Forward `Web_MarkAdviceTaskComplete` (opaque pass-through)
        api_response = api_instance.advice_task_complete()
        print("The response of AdviceApi->advice_task_complete:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AdviceApi->advice_task_complete: %s\n" % e)
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

# **advice_task_drawer**
> FeatureAreaResponse advice_task_drawer()

Forward `AdviceTaskDrawerQuery_Web` (opaque pass-through)

Advice task-drawer detail query. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.AdviceApi(api_client)

    try:
        # Forward `AdviceTaskDrawerQuery_Web` (opaque pass-through)
        api_response = api_instance.advice_task_drawer()
        print("The response of AdviceApi->advice_task_drawer:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AdviceApi->advice_task_drawer: %s\n" % e)
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

# **advice_task_incomplete**
> FeatureAreaResponse advice_task_incomplete()

Forward `Web_MarkAdviceTaskIncomplete` (opaque pass-through)

Mark an advice task incomplete. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.AdviceApi(api_client)

    try:
        # Forward `Web_MarkAdviceTaskIncomplete` (opaque pass-through)
        api_response = api_instance.advice_task_incomplete()
        print("The response of AdviceApi->advice_task_incomplete:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AdviceApi->advice_task_incomplete: %s\n" % e)
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

