# monarch_bridge_client.ForecastApi

All URIs are relative to *http://localhost:9084*

Method | HTTP request | Description
------------- | ------------- | -------------
[**forecast_create_scenario**](ForecastApi.md#forecast_create_scenario) | **GET** /v1/forecast/scenarios/create | Forward &#x60;Web_CreateForecastScenario&#x60; (opaque pass-through)
[**forecast_delete_scenario**](ForecastApi.md#forecast_delete_scenario) | **GET** /v1/forecast/scenarios/delete | Forward &#x60;Web_DeleteForecastScenario&#x60; (opaque pass-through)
[**forecast_duplicate_scenario**](ForecastApi.md#forecast_duplicate_scenario) | **GET** /v1/forecast/scenarios/duplicate | Forward &#x60;Web_DuplicateForecastScenario&#x60; (opaque pass-through)
[**forecast_initialize**](ForecastApi.md#forecast_initialize) | **GET** /v1/forecast/initialize | Forward &#x60;Web_InitializeForecast&#x60; (opaque pass-through)
[**forecast_onboarding_complete**](ForecastApi.md#forecast_onboarding_complete) | **GET** /v1/forecast/onboarding/complete | Forward &#x60;Web_MarkForecastOnboardingComplete&#x60; (opaque pass-through)
[**forecast_replace_events**](ForecastApi.md#forecast_replace_events) | **GET** /v1/forecast/events/replace | Forward &#x60;Web_ReplaceForecastEvents&#x60; (opaque pass-through)
[**forecast_reset_data**](ForecastApi.md#forecast_reset_data) | **GET** /v1/forecast/data/reset | Forward &#x60;Web_ResetForecastData&#x60; (opaque pass-through)
[**forecast_reset_onboarding**](ForecastApi.md#forecast_reset_onboarding) | **GET** /v1/forecast/onboarding/reset | Forward &#x60;Web_ResetForecastOnboarding&#x60; (opaque pass-through)
[**forecast_save_accounts**](ForecastApi.md#forecast_save_accounts) | **GET** /v1/forecast/accounts | Forward &#x60;Web_SaveForecastAccounts&#x60; (opaque pass-through)
[**forecast_save_participant_overrides**](ForecastApi.md#forecast_save_participant_overrides) | **GET** /v1/forecast/participant-overrides | Forward &#x60;Web_SaveForecastParticipantOverrides&#x60; (opaque pass-through)
[**forecast_save_priority_rules**](ForecastApi.md#forecast_save_priority_rules) | **GET** /v1/forecast/priority-rules | Forward &#x60;Web_SaveForecastPriorityRules&#x60; (opaque pass-through)
[**forecast_save_scenario_kpis**](ForecastApi.md#forecast_save_scenario_kpis) | **GET** /v1/forecast/scenario-kpis | Forward &#x60;Web_SaveForecastScenarioKpis&#x60; (opaque pass-through)
[**forecast_scenario**](ForecastApi.md#forecast_scenario) | **GET** /v1/forecast/scenario | Forward &#x60;Web_ForecastScenario&#x60; (opaque pass-through)
[**forecast_scenarios**](ForecastApi.md#forecast_scenarios) | **GET** /v1/forecast/scenarios | Forward &#x60;Web_ForecastScenarios&#x60; (opaque pass-through)
[**forecast_update_scenario**](ForecastApi.md#forecast_update_scenario) | **GET** /v1/forecast/scenarios/update | Forward &#x60;Web_UpdateForecastScenario&#x60; (opaque pass-through)
[**forecast_update_scenario_order**](ForecastApi.md#forecast_update_scenario_order) | **GET** /v1/forecast/scenarios/order | Forward &#x60;Web_UpdateForecastScenarioOrder&#x60; (opaque pass-through)
[**forecast_update_user_financial_profile**](ForecastApi.md#forecast_update_user_financial_profile) | **GET** /v1/forecast/user-financial-profile | Forward &#x60;Web_ForecastUpdateUserFinancialProfile&#x60; (opaque pass-through)


# **forecast_create_scenario**
> FeatureAreaResponse forecast_create_scenario()

Forward `Web_CreateForecastScenario` (opaque pass-through)

Create a forecast scenario. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.ForecastApi(api_client)

    try:
        # Forward `Web_CreateForecastScenario` (opaque pass-through)
        api_response = api_instance.forecast_create_scenario()
        print("The response of ForecastApi->forecast_create_scenario:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ForecastApi->forecast_create_scenario: %s\n" % e)
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

# **forecast_delete_scenario**
> FeatureAreaResponse forecast_delete_scenario()

Forward `Web_DeleteForecastScenario` (opaque pass-through)

Delete a forecast scenario. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.ForecastApi(api_client)

    try:
        # Forward `Web_DeleteForecastScenario` (opaque pass-through)
        api_response = api_instance.forecast_delete_scenario()
        print("The response of ForecastApi->forecast_delete_scenario:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ForecastApi->forecast_delete_scenario: %s\n" % e)
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

# **forecast_duplicate_scenario**
> FeatureAreaResponse forecast_duplicate_scenario()

Forward `Web_DuplicateForecastScenario` (opaque pass-through)

Duplicate a forecast scenario. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.ForecastApi(api_client)

    try:
        # Forward `Web_DuplicateForecastScenario` (opaque pass-through)
        api_response = api_instance.forecast_duplicate_scenario()
        print("The response of ForecastApi->forecast_duplicate_scenario:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ForecastApi->forecast_duplicate_scenario: %s\n" % e)
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

# **forecast_initialize**
> FeatureAreaResponse forecast_initialize()

Forward `Web_InitializeForecast` (opaque pass-through)

Initialize forecast feature. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.ForecastApi(api_client)

    try:
        # Forward `Web_InitializeForecast` (opaque pass-through)
        api_response = api_instance.forecast_initialize()
        print("The response of ForecastApi->forecast_initialize:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ForecastApi->forecast_initialize: %s\n" % e)
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

# **forecast_onboarding_complete**
> FeatureAreaResponse forecast_onboarding_complete()

Forward `Web_MarkForecastOnboardingComplete` (opaque pass-through)

Mark forecast onboarding complete. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.ForecastApi(api_client)

    try:
        # Forward `Web_MarkForecastOnboardingComplete` (opaque pass-through)
        api_response = api_instance.forecast_onboarding_complete()
        print("The response of ForecastApi->forecast_onboarding_complete:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ForecastApi->forecast_onboarding_complete: %s\n" % e)
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

# **forecast_replace_events**
> FeatureAreaResponse forecast_replace_events()

Forward `Web_ReplaceForecastEvents` (opaque pass-through)

Replace forecast events. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.ForecastApi(api_client)

    try:
        # Forward `Web_ReplaceForecastEvents` (opaque pass-through)
        api_response = api_instance.forecast_replace_events()
        print("The response of ForecastApi->forecast_replace_events:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ForecastApi->forecast_replace_events: %s\n" % e)
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

# **forecast_reset_data**
> FeatureAreaResponse forecast_reset_data()

Forward `Web_ResetForecastData` (opaque pass-through)

Reset forecast data. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.ForecastApi(api_client)

    try:
        # Forward `Web_ResetForecastData` (opaque pass-through)
        api_response = api_instance.forecast_reset_data()
        print("The response of ForecastApi->forecast_reset_data:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ForecastApi->forecast_reset_data: %s\n" % e)
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

# **forecast_reset_onboarding**
> FeatureAreaResponse forecast_reset_onboarding()

Forward `Web_ResetForecastOnboarding` (opaque pass-through)

Reset forecast onboarding. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.ForecastApi(api_client)

    try:
        # Forward `Web_ResetForecastOnboarding` (opaque pass-through)
        api_response = api_instance.forecast_reset_onboarding()
        print("The response of ForecastApi->forecast_reset_onboarding:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ForecastApi->forecast_reset_onboarding: %s\n" % e)
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

# **forecast_save_accounts**
> FeatureAreaResponse forecast_save_accounts()

Forward `Web_SaveForecastAccounts` (opaque pass-through)

Save forecast account selections. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.ForecastApi(api_client)

    try:
        # Forward `Web_SaveForecastAccounts` (opaque pass-through)
        api_response = api_instance.forecast_save_accounts()
        print("The response of ForecastApi->forecast_save_accounts:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ForecastApi->forecast_save_accounts: %s\n" % e)
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

# **forecast_save_participant_overrides**
> FeatureAreaResponse forecast_save_participant_overrides()

Forward `Web_SaveForecastParticipantOverrides` (opaque pass-through)

Save forecast participant overrides. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.ForecastApi(api_client)

    try:
        # Forward `Web_SaveForecastParticipantOverrides` (opaque pass-through)
        api_response = api_instance.forecast_save_participant_overrides()
        print("The response of ForecastApi->forecast_save_participant_overrides:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ForecastApi->forecast_save_participant_overrides: %s\n" % e)
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

# **forecast_save_priority_rules**
> FeatureAreaResponse forecast_save_priority_rules()

Forward `Web_SaveForecastPriorityRules` (opaque pass-through)

Save forecast priority rules. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.ForecastApi(api_client)

    try:
        # Forward `Web_SaveForecastPriorityRules` (opaque pass-through)
        api_response = api_instance.forecast_save_priority_rules()
        print("The response of ForecastApi->forecast_save_priority_rules:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ForecastApi->forecast_save_priority_rules: %s\n" % e)
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

# **forecast_save_scenario_kpis**
> FeatureAreaResponse forecast_save_scenario_kpis()

Forward `Web_SaveForecastScenarioKpis` (opaque pass-through)

Save forecast scenario KPIs. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.ForecastApi(api_client)

    try:
        # Forward `Web_SaveForecastScenarioKpis` (opaque pass-through)
        api_response = api_instance.forecast_save_scenario_kpis()
        print("The response of ForecastApi->forecast_save_scenario_kpis:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ForecastApi->forecast_save_scenario_kpis: %s\n" % e)
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

# **forecast_scenario**
> FeatureAreaResponse forecast_scenario()

Forward `Web_ForecastScenario` (opaque pass-through)

Single forecast scenario detail. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.ForecastApi(api_client)

    try:
        # Forward `Web_ForecastScenario` (opaque pass-through)
        api_response = api_instance.forecast_scenario()
        print("The response of ForecastApi->forecast_scenario:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ForecastApi->forecast_scenario: %s\n" % e)
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

# **forecast_scenarios**
> FeatureAreaResponse forecast_scenarios()

Forward `Web_ForecastScenarios` (opaque pass-through)

List forecast scenarios. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.ForecastApi(api_client)

    try:
        # Forward `Web_ForecastScenarios` (opaque pass-through)
        api_response = api_instance.forecast_scenarios()
        print("The response of ForecastApi->forecast_scenarios:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ForecastApi->forecast_scenarios: %s\n" % e)
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

# **forecast_update_scenario**
> FeatureAreaResponse forecast_update_scenario()

Forward `Web_UpdateForecastScenario` (opaque pass-through)

Update a forecast scenario. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.ForecastApi(api_client)

    try:
        # Forward `Web_UpdateForecastScenario` (opaque pass-through)
        api_response = api_instance.forecast_update_scenario()
        print("The response of ForecastApi->forecast_update_scenario:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ForecastApi->forecast_update_scenario: %s\n" % e)
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

# **forecast_update_scenario_order**
> FeatureAreaResponse forecast_update_scenario_order()

Forward `Web_UpdateForecastScenarioOrder` (opaque pass-through)

Reorder forecast scenarios. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.ForecastApi(api_client)

    try:
        # Forward `Web_UpdateForecastScenarioOrder` (opaque pass-through)
        api_response = api_instance.forecast_update_scenario_order()
        print("The response of ForecastApi->forecast_update_scenario_order:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ForecastApi->forecast_update_scenario_order: %s\n" % e)
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

# **forecast_update_user_financial_profile**
> FeatureAreaResponse forecast_update_user_financial_profile()

Forward `Web_ForecastUpdateUserFinancialProfile` (opaque pass-through)

Update user financial profile from forecast. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.ForecastApi(api_client)

    try:
        # Forward `Web_ForecastUpdateUserFinancialProfile` (opaque pass-through)
        api_response = api_instance.forecast_update_user_financial_profile()
        print("The response of ForecastApi->forecast_update_user_financial_profile:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ForecastApi->forecast_update_user_financial_profile: %s\n" % e)
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

