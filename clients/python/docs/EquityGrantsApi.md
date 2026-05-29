# monarch_bridge_client.EquityGrantsApi

All URIs are relative to *http://localhost:9084*

Method | HTTP request | Description
------------- | ------------- | -------------
[**equity_grants_create**](EquityGrantsApi.md#equity_grants_create) | **GET** /v1/equity-grants/create | Forward &#x60;Web_CreateEquityGrant&#x60; (opaque pass-through)
[**equity_grants_delete**](EquityGrantsApi.md#equity_grants_delete) | **GET** /v1/equity-grants/delete | Forward &#x60;Web_DeleteEquityGrant&#x60; (opaque pass-through)
[**equity_grants_edit_modal**](EquityGrantsApi.md#equity_grants_edit_modal) | **GET** /v1/equity-grants/edit-modal/detail | Forward &#x60;Web_EditEquityGrantModal_GetEquityGrant&#x60; (opaque pass-through)
[**equity_grants_list**](EquityGrantsApi.md#equity_grants_list) | **GET** /v1/equity-grants | Forward &#x60;Web_GetEquityGrants&#x60; (opaque pass-through)
[**equity_grants_manage_holdings_modal**](EquityGrantsApi.md#equity_grants_manage_holdings_modal) | **GET** /v1/equity-grants/manage-holdings-modal | Forward &#x60;Web_ManageEquityHoldingsModal_GetEquityGrants&#x60; (opaque pass-through)
[**equity_grants_preview**](EquityGrantsApi.md#equity_grants_preview) | **GET** /v1/equity-grants/preview | Forward &#x60;Web_PreviewEquityGrant&#x60; (opaque pass-through)
[**equity_grants_update**](EquityGrantsApi.md#equity_grants_update) | **GET** /v1/equity-grants/update | Forward &#x60;Web_UpdateEquityGrant&#x60; (opaque pass-through)


# **equity_grants_create**
> FeatureAreaResponse equity_grants_create()

Forward `Web_CreateEquityGrant` (opaque pass-through)

Create an equity grant. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.EquityGrantsApi(api_client)

    try:
        # Forward `Web_CreateEquityGrant` (opaque pass-through)
        api_response = api_instance.equity_grants_create()
        print("The response of EquityGrantsApi->equity_grants_create:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling EquityGrantsApi->equity_grants_create: %s\n" % e)
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

# **equity_grants_delete**
> FeatureAreaResponse equity_grants_delete()

Forward `Web_DeleteEquityGrant` (opaque pass-through)

Delete an equity grant. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.EquityGrantsApi(api_client)

    try:
        # Forward `Web_DeleteEquityGrant` (opaque pass-through)
        api_response = api_instance.equity_grants_delete()
        print("The response of EquityGrantsApi->equity_grants_delete:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling EquityGrantsApi->equity_grants_delete: %s\n" % e)
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

# **equity_grants_edit_modal**
> FeatureAreaResponse equity_grants_edit_modal()

Forward `Web_EditEquityGrantModal_GetEquityGrant` (opaque pass-through)

Get an equity grant detail for the edit modal. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.EquityGrantsApi(api_client)

    try:
        # Forward `Web_EditEquityGrantModal_GetEquityGrant` (opaque pass-through)
        api_response = api_instance.equity_grants_edit_modal()
        print("The response of EquityGrantsApi->equity_grants_edit_modal:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling EquityGrantsApi->equity_grants_edit_modal: %s\n" % e)
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

# **equity_grants_list**
> FeatureAreaResponse equity_grants_list()

Forward `Web_GetEquityGrants` (opaque pass-through)

List equity grants. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.EquityGrantsApi(api_client)

    try:
        # Forward `Web_GetEquityGrants` (opaque pass-through)
        api_response = api_instance.equity_grants_list()
        print("The response of EquityGrantsApi->equity_grants_list:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling EquityGrantsApi->equity_grants_list: %s\n" % e)
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

# **equity_grants_manage_holdings_modal**
> FeatureAreaResponse equity_grants_manage_holdings_modal()

Forward `Web_ManageEquityHoldingsModal_GetEquityGrants` (opaque pass-through)

Get equity grants for the manage-holdings modal. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.EquityGrantsApi(api_client)

    try:
        # Forward `Web_ManageEquityHoldingsModal_GetEquityGrants` (opaque pass-through)
        api_response = api_instance.equity_grants_manage_holdings_modal()
        print("The response of EquityGrantsApi->equity_grants_manage_holdings_modal:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling EquityGrantsApi->equity_grants_manage_holdings_modal: %s\n" % e)
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

# **equity_grants_preview**
> FeatureAreaResponse equity_grants_preview()

Forward `Web_PreviewEquityGrant` (opaque pass-through)

Preview an equity grant. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.EquityGrantsApi(api_client)

    try:
        # Forward `Web_PreviewEquityGrant` (opaque pass-through)
        api_response = api_instance.equity_grants_preview()
        print("The response of EquityGrantsApi->equity_grants_preview:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling EquityGrantsApi->equity_grants_preview: %s\n" % e)
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

# **equity_grants_update**
> FeatureAreaResponse equity_grants_update()

Forward `Web_UpdateEquityGrant` (opaque pass-through)

Update an equity grant. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.EquityGrantsApi(api_client)

    try:
        # Forward `Web_UpdateEquityGrant` (opaque pass-through)
        api_response = api_instance.equity_grants_update()
        print("The response of EquityGrantsApi->equity_grants_update:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling EquityGrantsApi->equity_grants_update: %s\n" % e)
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

