# monarch_bridge_client.BillsApi

All URIs are relative to *http://localhost:9084*

Method | HTTP request | Description
------------- | ------------- | -------------
[**bills_advisor_billing**](BillsApi.md#bills_advisor_billing) | **GET** /v1/bills/advisor-billing | Forward &#x60;Web_GetAdvisorBillingPage&#x60; (opaque pass-through)
[**bills_billing_settings**](BillsApi.md#bills_billing_settings) | **GET** /v1/bills/billing-settings | Forward &#x60;GetBillingSettings&#x60; (opaque pass-through)
[**bills_cancel_sponsorship**](BillsApi.md#bills_cancel_sponsorship) | **GET** /v1/bills/billing/sponsorship/cancel | Forward &#x60;Web_BillingSettingsCancelSponsorship&#x60; (opaque pass-through)
[**bills_claim_item**](BillsApi.md#bills_claim_item) | **GET** /v1/bills/item/claim | Forward &#x60;Web_ClaimBillItem&#x60; (opaque pass-through)
[**bills_detail**](BillsApi.md#bills_detail) | **GET** /v1/bills/detail | Forward &#x60;Web_GetBill&#x60; (opaque pass-through)
[**bills_employee_billing_state**](BillsApi.md#bills_employee_billing_state) | **GET** /v1/bills/employee/billing-state | Forward &#x60;Web_GetEmployeeBillingState&#x60; (opaque pass-through)
[**bills_household_country**](BillsApi.md#bills_household_country) | **GET** /v1/bills/billing/household-country | Forward &#x60;Web_BillingSettings_HouseholdCountry&#x60; (opaque pass-through)
[**bills_mobile_signup_update_postal_code**](BillsApi.md#bills_mobile_signup_update_postal_code) | **GET** /v1/bills/mobile-signup/postal-code | Forward &#x60;Mobile_SignupBillingZip_UpdateBillingPostalCode&#x60; (opaque pass-through)
[**bills_onboarding_get_postal_code**](BillsApi.md#bills_onboarding_get_postal_code) | **GET** /v1/bills/onboarding/postal-code | Forward &#x60;Web_OnboardingBillingZip_GetPostalCode&#x60; (opaque pass-through)
[**bills_onboarding_update_postal_code**](BillsApi.md#bills_onboarding_update_postal_code) | **GET** /v1/bills/onboarding/postal-code/update | Forward &#x60;Web_OnboardingBillingZip_UpdateBillingPostalCode&#x60; (opaque pass-through)
[**bills_register_split_participant**](BillsApi.md#bills_register_split_participant) | **GET** /v1/bills/split/register-participant | Forward &#x60;Web_RegisterBillSplitParticipant&#x60; (opaque pass-through)
[**bills_set_employee_billing_issue**](BillsApi.md#bills_set_employee_billing_issue) | **GET** /v1/bills/employee/billing-issue | Forward &#x60;Web_SetEmployeeBillingIssue&#x60; (opaque pass-through)
[**bills_submit_split_initiator_edit**](BillsApi.md#bills_submit_split_initiator_edit) | **GET** /v1/bills/split/initiator-edit | Forward &#x60;Web_SubmitBillSplitInitiatorEdit&#x60; (opaque pass-through)
[**bills_toggle_sync_tracking**](BillsApi.md#bills_toggle_sync_tracking) | **GET** /v1/bills/sync-tracking | Forward &#x60;Common_ToggleBillSyncTracking&#x60; (opaque pass-through)
[**bills_unclaim_item**](BillsApi.md#bills_unclaim_item) | **GET** /v1/bills/item/unclaim | Forward &#x60;Web_UnclaimBillItem&#x60; (opaque pass-through)
[**bills_update_postal_code**](BillsApi.md#bills_update_postal_code) | **GET** /v1/bills/billing/postal-code | Forward &#x60;Web_BillingZipModal_UpdateBillingPostalCode&#x60; (opaque pass-through)


# **bills_advisor_billing**
> FeatureAreaResponse bills_advisor_billing()

Forward `Web_GetAdvisorBillingPage` (opaque pass-through)

Advisor billing page detail. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.BillsApi(api_client)

    try:
        # Forward `Web_GetAdvisorBillingPage` (opaque pass-through)
        api_response = api_instance.bills_advisor_billing()
        print("The response of BillsApi->bills_advisor_billing:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BillsApi->bills_advisor_billing: %s\n" % e)
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

# **bills_billing_settings**
> FeatureAreaResponse bills_billing_settings()

Forward `GetBillingSettings` (opaque pass-through)

Billing settings snapshot. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.BillsApi(api_client)

    try:
        # Forward `GetBillingSettings` (opaque pass-through)
        api_response = api_instance.bills_billing_settings()
        print("The response of BillsApi->bills_billing_settings:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BillsApi->bills_billing_settings: %s\n" % e)
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

# **bills_cancel_sponsorship**
> FeatureAreaResponse bills_cancel_sponsorship()

Forward `Web_BillingSettingsCancelSponsorship` (opaque pass-through)

Cancel a sponsored billing arrangement. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.BillsApi(api_client)

    try:
        # Forward `Web_BillingSettingsCancelSponsorship` (opaque pass-through)
        api_response = api_instance.bills_cancel_sponsorship()
        print("The response of BillsApi->bills_cancel_sponsorship:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BillsApi->bills_cancel_sponsorship: %s\n" % e)
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

# **bills_claim_item**
> FeatureAreaResponse bills_claim_item()

Forward `Web_ClaimBillItem` (opaque pass-through)

Claim a bill split item. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.BillsApi(api_client)

    try:
        # Forward `Web_ClaimBillItem` (opaque pass-through)
        api_response = api_instance.bills_claim_item()
        print("The response of BillsApi->bills_claim_item:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BillsApi->bills_claim_item: %s\n" % e)
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

# **bills_detail**
> FeatureAreaResponse bills_detail()

Forward `Web_GetBill` (opaque pass-through)

Bill detail. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.BillsApi(api_client)

    try:
        # Forward `Web_GetBill` (opaque pass-through)
        api_response = api_instance.bills_detail()
        print("The response of BillsApi->bills_detail:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BillsApi->bills_detail: %s\n" % e)
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

# **bills_employee_billing_state**
> FeatureAreaResponse bills_employee_billing_state()

Forward `Web_GetEmployeeBillingState` (opaque pass-through)

Get employee billing state. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.BillsApi(api_client)

    try:
        # Forward `Web_GetEmployeeBillingState` (opaque pass-through)
        api_response = api_instance.bills_employee_billing_state()
        print("The response of BillsApi->bills_employee_billing_state:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BillsApi->bills_employee_billing_state: %s\n" % e)
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

# **bills_household_country**
> FeatureAreaResponse bills_household_country()

Forward `Web_BillingSettings_HouseholdCountry` (opaque pass-through)

Update household country in billing. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.BillsApi(api_client)

    try:
        # Forward `Web_BillingSettings_HouseholdCountry` (opaque pass-through)
        api_response = api_instance.bills_household_country()
        print("The response of BillsApi->bills_household_country:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BillsApi->bills_household_country: %s\n" % e)
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

# **bills_mobile_signup_update_postal_code**
> FeatureAreaResponse bills_mobile_signup_update_postal_code()

Forward `Mobile_SignupBillingZip_UpdateBillingPostalCode` (opaque pass-through)

Update billing postal code during mobile signup. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.BillsApi(api_client)

    try:
        # Forward `Mobile_SignupBillingZip_UpdateBillingPostalCode` (opaque pass-through)
        api_response = api_instance.bills_mobile_signup_update_postal_code()
        print("The response of BillsApi->bills_mobile_signup_update_postal_code:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BillsApi->bills_mobile_signup_update_postal_code: %s\n" % e)
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

# **bills_onboarding_get_postal_code**
> FeatureAreaResponse bills_onboarding_get_postal_code()

Forward `Web_OnboardingBillingZip_GetPostalCode` (opaque pass-through)

Get billing postal code during onboarding. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.BillsApi(api_client)

    try:
        # Forward `Web_OnboardingBillingZip_GetPostalCode` (opaque pass-through)
        api_response = api_instance.bills_onboarding_get_postal_code()
        print("The response of BillsApi->bills_onboarding_get_postal_code:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BillsApi->bills_onboarding_get_postal_code: %s\n" % e)
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

# **bills_onboarding_update_postal_code**
> FeatureAreaResponse bills_onboarding_update_postal_code()

Forward `Web_OnboardingBillingZip_UpdateBillingPostalCode` (opaque pass-through)

Update billing postal code during onboarding. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.BillsApi(api_client)

    try:
        # Forward `Web_OnboardingBillingZip_UpdateBillingPostalCode` (opaque pass-through)
        api_response = api_instance.bills_onboarding_update_postal_code()
        print("The response of BillsApi->bills_onboarding_update_postal_code:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BillsApi->bills_onboarding_update_postal_code: %s\n" % e)
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

# **bills_register_split_participant**
> FeatureAreaResponse bills_register_split_participant()

Forward `Web_RegisterBillSplitParticipant` (opaque pass-through)

Register a bill split participant. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.BillsApi(api_client)

    try:
        # Forward `Web_RegisterBillSplitParticipant` (opaque pass-through)
        api_response = api_instance.bills_register_split_participant()
        print("The response of BillsApi->bills_register_split_participant:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BillsApi->bills_register_split_participant: %s\n" % e)
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

# **bills_set_employee_billing_issue**
> FeatureAreaResponse bills_set_employee_billing_issue()

Forward `Web_SetEmployeeBillingIssue` (opaque pass-through)

Set employee billing issue flag. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.BillsApi(api_client)

    try:
        # Forward `Web_SetEmployeeBillingIssue` (opaque pass-through)
        api_response = api_instance.bills_set_employee_billing_issue()
        print("The response of BillsApi->bills_set_employee_billing_issue:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BillsApi->bills_set_employee_billing_issue: %s\n" % e)
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

# **bills_submit_split_initiator_edit**
> FeatureAreaResponse bills_submit_split_initiator_edit()

Forward `Web_SubmitBillSplitInitiatorEdit` (opaque pass-through)

Submit a bill split initiator edit. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.BillsApi(api_client)

    try:
        # Forward `Web_SubmitBillSplitInitiatorEdit` (opaque pass-through)
        api_response = api_instance.bills_submit_split_initiator_edit()
        print("The response of BillsApi->bills_submit_split_initiator_edit:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BillsApi->bills_submit_split_initiator_edit: %s\n" % e)
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

# **bills_toggle_sync_tracking**
> FeatureAreaResponse bills_toggle_sync_tracking()

Forward `Common_ToggleBillSyncTracking` (opaque pass-through)

Toggle bill sync tracking. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.BillsApi(api_client)

    try:
        # Forward `Common_ToggleBillSyncTracking` (opaque pass-through)
        api_response = api_instance.bills_toggle_sync_tracking()
        print("The response of BillsApi->bills_toggle_sync_tracking:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BillsApi->bills_toggle_sync_tracking: %s\n" % e)
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

# **bills_unclaim_item**
> FeatureAreaResponse bills_unclaim_item()

Forward `Web_UnclaimBillItem` (opaque pass-through)

Unclaim a bill split item. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.BillsApi(api_client)

    try:
        # Forward `Web_UnclaimBillItem` (opaque pass-through)
        api_response = api_instance.bills_unclaim_item()
        print("The response of BillsApi->bills_unclaim_item:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BillsApi->bills_unclaim_item: %s\n" % e)
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

# **bills_update_postal_code**
> FeatureAreaResponse bills_update_postal_code()

Forward `Web_BillingZipModal_UpdateBillingPostalCode` (opaque pass-through)

Update billing postal code from zip modal. Returns raw `data` tree as FreeForm.

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
    api_instance = monarch_bridge_client.BillsApi(api_client)

    try:
        # Forward `Web_BillingZipModal_UpdateBillingPostalCode` (opaque pass-through)
        api_response = api_instance.bills_update_postal_code()
        print("The response of BillsApi->bills_update_postal_code:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BillsApi->bills_update_postal_code: %s\n" % e)
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

