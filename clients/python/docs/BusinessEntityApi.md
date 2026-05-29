# monarch_bridge_client.BusinessEntityApi

All URIs are relative to *http://localhost:9084*

Method | HTTP request | Description
------------- | ------------- | -------------
[**business_entities_delete**](BusinessEntityApi.md#business_entities_delete) | **GET** /v1/business-entities/delete | Forward &#x60;Common_DeleteBusinessEntity&#x60; (opaque pass-through)
[**business_entities_delete_logo**](BusinessEntityApi.md#business_entities_delete_logo) | **GET** /v1/business-entities/logo/delete | Forward &#x60;Common_DeleteBusinessEntityLogo&#x60; (opaque pass-through)
[**business_entities_demo_populate**](BusinessEntityApi.md#business_entities_demo_populate) | **GET** /v1/business-entities/demo/populate | Forward &#x60;Web_PopulateBusinessEntityDemo&#x60; (opaque pass-through)
[**business_entities_demo_scenarios**](BusinessEntityApi.md#business_entities_demo_scenarios) | **GET** /v1/business-entities/demo/scenarios | Forward &#x60;Web_AvailableBusinessEntityDemoScenarios&#x60; (opaque pass-through)
[**business_entities_detail**](BusinessEntityApi.md#business_entities_detail) | **GET** /v1/business-entities/detail | Forward &#x60;Common_GetBusinessEntity&#x60; (opaque pass-through)
[**business_entities_financials**](BusinessEntityApi.md#business_entities_financials) | **GET** /v1/business-entities/financials | Forward &#x60;Common_GetBusinessEntityFinancials&#x60; (opaque pass-through)
[**business_entities_reports_by_category**](BusinessEntityApi.md#business_entities_reports_by_category) | **GET** /v1/business-entities/reports/by-category | Forward &#x60;Common_GetBusinessEntityReportsDataByCategory&#x60; (opaque pass-through)
[**business_entities_reports_by_group**](BusinessEntityApi.md#business_entities_reports_by_group) | **GET** /v1/business-entities/reports/by-group | Forward &#x60;Common_GetBusinessEntityReportsDataByGroup&#x60; (opaque pass-through)
[**business_entities_upsert**](BusinessEntityApi.md#business_entities_upsert) | **GET** /v1/business-entities/upsert | Forward &#x60;Common_UpsertBusinessEntity&#x60; (opaque pass-through)


# **business_entities_delete**
> FeatureAreaResponse business_entities_delete()

Forward `Common_DeleteBusinessEntity` (opaque pass-through)

Delete a business entity. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.BusinessEntityApi(api_client)

    try:
        # Forward `Common_DeleteBusinessEntity` (opaque pass-through)
        api_response = api_instance.business_entities_delete()
        print("The response of BusinessEntityApi->business_entities_delete:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BusinessEntityApi->business_entities_delete: %s\n" % e)
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

# **business_entities_delete_logo**
> FeatureAreaResponse business_entities_delete_logo()

Forward `Common_DeleteBusinessEntityLogo` (opaque pass-through)

Delete a business entity logo. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.BusinessEntityApi(api_client)

    try:
        # Forward `Common_DeleteBusinessEntityLogo` (opaque pass-through)
        api_response = api_instance.business_entities_delete_logo()
        print("The response of BusinessEntityApi->business_entities_delete_logo:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BusinessEntityApi->business_entities_delete_logo: %s\n" % e)
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

# **business_entities_demo_populate**
> FeatureAreaResponse business_entities_demo_populate()

Forward `Web_PopulateBusinessEntityDemo` (opaque pass-through)

Populate a business entity with demo data. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.BusinessEntityApi(api_client)

    try:
        # Forward `Web_PopulateBusinessEntityDemo` (opaque pass-through)
        api_response = api_instance.business_entities_demo_populate()
        print("The response of BusinessEntityApi->business_entities_demo_populate:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BusinessEntityApi->business_entities_demo_populate: %s\n" % e)
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

# **business_entities_demo_scenarios**
> FeatureAreaResponse business_entities_demo_scenarios()

Forward `Web_AvailableBusinessEntityDemoScenarios` (opaque pass-through)

List demo scenarios available for business entity onboarding. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.BusinessEntityApi(api_client)

    try:
        # Forward `Web_AvailableBusinessEntityDemoScenarios` (opaque pass-through)
        api_response = api_instance.business_entities_demo_scenarios()
        print("The response of BusinessEntityApi->business_entities_demo_scenarios:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BusinessEntityApi->business_entities_demo_scenarios: %s\n" % e)
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

# **business_entities_detail**
> FeatureAreaResponse business_entities_detail()

Forward `Common_GetBusinessEntity` (opaque pass-through)

Get business entity detail. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.BusinessEntityApi(api_client)

    try:
        # Forward `Common_GetBusinessEntity` (opaque pass-through)
        api_response = api_instance.business_entities_detail()
        print("The response of BusinessEntityApi->business_entities_detail:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BusinessEntityApi->business_entities_detail: %s\n" % e)
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

# **business_entities_financials**
> FeatureAreaResponse business_entities_financials()

Forward `Common_GetBusinessEntityFinancials` (opaque pass-through)

Get business entity financials. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.BusinessEntityApi(api_client)

    try:
        # Forward `Common_GetBusinessEntityFinancials` (opaque pass-through)
        api_response = api_instance.business_entities_financials()
        print("The response of BusinessEntityApi->business_entities_financials:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BusinessEntityApi->business_entities_financials: %s\n" % e)
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

# **business_entities_reports_by_category**
> FeatureAreaResponse business_entities_reports_by_category()

Forward `Common_GetBusinessEntityReportsDataByCategory` (opaque pass-through)

Business entity reports broken down by category. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.BusinessEntityApi(api_client)

    try:
        # Forward `Common_GetBusinessEntityReportsDataByCategory` (opaque pass-through)
        api_response = api_instance.business_entities_reports_by_category()
        print("The response of BusinessEntityApi->business_entities_reports_by_category:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BusinessEntityApi->business_entities_reports_by_category: %s\n" % e)
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

# **business_entities_reports_by_group**
> FeatureAreaResponse business_entities_reports_by_group()

Forward `Common_GetBusinessEntityReportsDataByGroup` (opaque pass-through)

Business entity reports broken down by group. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.BusinessEntityApi(api_client)

    try:
        # Forward `Common_GetBusinessEntityReportsDataByGroup` (opaque pass-through)
        api_response = api_instance.business_entities_reports_by_group()
        print("The response of BusinessEntityApi->business_entities_reports_by_group:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BusinessEntityApi->business_entities_reports_by_group: %s\n" % e)
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

# **business_entities_upsert**
> FeatureAreaResponse business_entities_upsert()

Forward `Common_UpsertBusinessEntity` (opaque pass-through)

Upsert a business entity. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.BusinessEntityApi(api_client)

    try:
        # Forward `Common_UpsertBusinessEntity` (opaque pass-through)
        api_response = api_instance.business_entities_upsert()
        print("The response of BusinessEntityApi->business_entities_upsert:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BusinessEntityApi->business_entities_upsert: %s\n" % e)
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

