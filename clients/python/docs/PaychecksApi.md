# monarch_bridge_client.PaychecksApi

All URIs are relative to *http://localhost:9084*

Method | HTTP request | Description
------------- | ------------- | -------------
[**create_paycheck**](PaychecksApi.md#create_paycheck) | **POST** /v1/paychecks | Record a new paycheck
[**create_paycheck_employer**](PaychecksApi.md#create_paycheck_employer) | **POST** /v1/paycheck-employers | Register a new employer
[**delete_paycheck**](PaychecksApi.md#delete_paycheck) | **DELETE** /v1/paychecks/{id} | Delete a paycheck
[**delete_paycheck_employer**](PaychecksApi.md#delete_paycheck_employer) | **DELETE** /v1/paycheck-employers/{id} | Delete an employer
[**get_paycheck**](PaychecksApi.md#get_paycheck) | **GET** /v1/paychecks/{id} | Single-paycheck full detail
[**get_paychecks_summary**](PaychecksApi.md#get_paychecks_summary) | **GET** /v1/paychecks/summary | Aggregate paycheck stats over a window
[**list_paycheck_employers**](PaychecksApi.md#list_paycheck_employers) | **GET** /v1/paycheck-employers | List paycheck employers
[**list_paychecks**](PaychecksApi.md#list_paychecks) | **GET** /v1/paychecks | List paychecks (with optional date + owner + employer filter)
[**update_paycheck**](PaychecksApi.md#update_paycheck) | **PATCH** /v1/paychecks/{id} | Partial-update a paycheck
[**update_paycheck_employer**](PaychecksApi.md#update_paycheck_employer) | **PATCH** /v1/paycheck-employers/{id} | Rename an employer


# **create_paycheck**
> CreatePaycheckResponse create_paycheck(create_paycheck_request)

Record a new paycheck

Creates a paycheck record from scratch. Required: `employerId`,
`ownerId`, `payDate`, `gross`, `net`. Optional: `deductions[]`
(per-line: taxes, retirement, insurance, etc.) and `deposits[]`
(per-account splits of the net amount).

`employerId` must already exist; register it via
`POST /v1/paycheck-employers` first. Deductions and deposits can be
omitted on create and filled in later via `PATCH /v1/paychecks/{id}`.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.create_paycheck_response import CreatePaycheckResponse
from monarch_bridge_client.models.create_paycheck_request import CreatePaycheckRequest
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
    api_instance = monarch_bridge_client.PaychecksApi(api_client)
    create_paycheck_request = monarch_bridge_client.CreatePaycheckRequest() # CreatePaycheckRequest | 

    try:
        # Record a new paycheck
        api_response = api_instance.create_paycheck(create_paycheck_request)
        print("The response of PaychecksApi->create_paycheck:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling PaychecksApi->create_paycheck: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **create_paycheck_request** | [**CreatePaycheckRequest**](CreatePaycheckRequest.md)|  | 

### Return type

[**CreatePaycheckResponse**](CreatePaycheckResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | New paycheck. |  -  |
**400** | Validation failed. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **create_paycheck_employer**
> CreatePaycheckEmployerResponse create_paycheck_employer(create_paycheck_employer_request)

Register a new employer

Adds an employer to the registry so it can be attached to
paycheck records. Required: `name`. The returned id is the
`employerId` to pass when creating a paycheck via
`POST /v1/paychecks`.

Use once per employer per household member - subsequent paychecks
reference the same id.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.create_paycheck_employer_response import CreatePaycheckEmployerResponse
from monarch_bridge_client.models.create_paycheck_employer_request import CreatePaycheckEmployerRequest
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
    api_instance = monarch_bridge_client.PaychecksApi(api_client)
    create_paycheck_employer_request = monarch_bridge_client.CreatePaycheckEmployerRequest() # CreatePaycheckEmployerRequest | 

    try:
        # Register a new employer
        api_response = api_instance.create_paycheck_employer(create_paycheck_employer_request)
        print("The response of PaychecksApi->create_paycheck_employer:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling PaychecksApi->create_paycheck_employer: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **create_paycheck_employer_request** | [**CreatePaycheckEmployerRequest**](CreatePaycheckEmployerRequest.md)|  | 

### Return type

[**CreatePaycheckEmployerResponse**](CreatePaycheckEmployerResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | New employer. |  -  |
**400** | Validation failed. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_paycheck**
> DeleteAccountResponse delete_paycheck(id)

Delete a paycheck

Removes one paycheck and its deductions/deposits. **Destructive** -
drops the row, future summary calls will no longer count it.

The underlying transaction (the actual paycheck deposit on the bank
side) is not deleted by this call - only the Monarch paycheck
record that links the gross + deductions + deposit structure.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.delete_account_response import DeleteAccountResponse
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
    api_instance = monarch_bridge_client.PaychecksApi(api_client)
    id = 'id_example' # str | Monarch paycheck id.

    try:
        # Delete a paycheck
        api_response = api_instance.delete_paycheck(id)
        print("The response of PaychecksApi->delete_paycheck:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling PaychecksApi->delete_paycheck: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch paycheck id. | 

### Return type

[**DeleteAccountResponse**](DeleteAccountResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Confirmation. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_paycheck_employer**
> DeleteAccountResponse delete_paycheck_employer(id)

Delete an employer

Removes an employer from the registry. **Refuses with 422** if
any paycheck records are still attributed to this employer -
reassign or delete those first.

Use to clean up stale employer entries (e.g. after switching
jobs and deleting the old paychecks). For renames use
`PATCH /v1/paycheck-employers/{id}` instead.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.delete_account_response import DeleteAccountResponse
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
    api_instance = monarch_bridge_client.PaychecksApi(api_client)
    id = 'id_example' # str | Monarch paycheck-employer id.

    try:
        # Delete an employer
        api_response = api_instance.delete_paycheck_employer(id)
        print("The response of PaychecksApi->delete_paycheck_employer:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling PaychecksApi->delete_paycheck_employer: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch paycheck-employer id. | 

### Return type

[**DeleteAccountResponse**](DeleteAccountResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Confirmation. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_paycheck**
> CreatePaycheckResponse get_paycheck(id)

Single-paycheck full detail

Returns the full breakdown for one paycheck: pay date, gross,
net, employer, owner (household member), per-line `deductions`
(taxes, retirement, insurance, etc.) and per-account `deposits`.

Use when surfacing a paycheck in a detail view or before a PATCH
to inspect current state. For the list view use
`GET /v1/paychecks`; for window-level rollups use
`GET /v1/paychecks/summary`.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.create_paycheck_response import CreatePaycheckResponse
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
    api_instance = monarch_bridge_client.PaychecksApi(api_client)
    id = 'id_example' # str | Monarch paycheck id.

    try:
        # Single-paycheck full detail
        api_response = api_instance.get_paycheck(id)
        print("The response of PaychecksApi->get_paycheck:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling PaychecksApi->get_paycheck: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch paycheck id. | 

### Return type

[**CreatePaycheckResponse**](CreatePaycheckResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Full paycheck record with deductions and deposits. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_paychecks_summary**
> GetPaychecksSummaryResponse get_paychecks_summary(start=start, end=end, owner_ids=owner_ids, employer_id=employer_id)

Aggregate paycheck stats over a window

Returns one rollup row over the filtered paycheck set: `count`,
`totalGross`, `totalDeductions`, `totalNet`, `deductionRate`
(deductions divided by gross), plus a breakdown by deduction type
(federal tax, state tax, 401k, health insurance, etc.).

Window is `start` to `end` inclusive on `payDate`. Defaults to
all-time when both omitted. Optional `employerId` scopes to one
employer; optional `ownerIds[]` scopes to one or more household
members.

Use for YTD income/deduction dashboards or to answer "how much have
I contributed to 401k this year". For per-paycheck detail use
`GET /v1/paychecks`.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_paychecks_summary_response import GetPaychecksSummaryResponse
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
    api_instance = monarch_bridge_client.PaychecksApi(api_client)
    start = '2013-10-20' # date | Lower bound (inclusive), `YYYY-MM-DD`. (optional)
    end = '2013-10-20' # date | Upper bound (inclusive), `YYYY-MM-DD`. (optional)
    owner_ids = ['owner_ids_example'] # List[str] | Restrict to one or more household-member ids. (optional)
    employer_id = 'employer_id_example' # str | Filter to one employer id. (optional)

    try:
        # Aggregate paycheck stats over a window
        api_response = api_instance.get_paychecks_summary(start=start, end=end, owner_ids=owner_ids, employer_id=employer_id)
        print("The response of PaychecksApi->get_paychecks_summary:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling PaychecksApi->get_paychecks_summary: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **date**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 
 **end** | **date**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 
 **owner_ids** | [**List[str]**](str.md)| Restrict to one or more household-member ids. | [optional] 
 **employer_id** | **str**| Filter to one employer id. | [optional] 

### Return type

[**GetPaychecksSummaryResponse**](GetPaychecksSummaryResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Aggregate stats over the window. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_paycheck_employers**
> ListPaycheckEmployersResponse list_paycheck_employers(search=search, limit=limit, offset=offset)

List paycheck employers

Returns the named-employer registry. Each entry is a reusable
employer id that paycheck records reference via `employerId`.

Optional free-text `search` matches by name (case-insensitive).
`limit` / `offset` paginate. Use to populate an employer picker
or to resolve a name before creating a paycheck via
`POST /v1/paychecks`.

To add a new employer use `POST /v1/paycheck-employers`; to rename
use `PATCH /v1/paycheck-employers/{id}`.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.list_paycheck_employers_response import ListPaycheckEmployersResponse
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
    api_instance = monarch_bridge_client.PaychecksApi(api_client)
    search = 'search_example' # str | Free-text search against merchant / notes / category. (optional)
    limit = 56 # int | Page size. (optional)
    offset = 56 # int | Page offset. (optional)

    try:
        # List paycheck employers
        api_response = api_instance.list_paycheck_employers(search=search, limit=limit, offset=offset)
        print("The response of PaychecksApi->list_paycheck_employers:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling PaychecksApi->list_paycheck_employers: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **search** | **str**| Free-text search against merchant / notes / category. | [optional] 
 **limit** | **int**| Page size. | [optional] 
 **offset** | **int**| Page offset. | [optional] 

### Return type

[**ListPaycheckEmployersResponse**](ListPaycheckEmployersResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | All matching employers. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_paychecks**
> ListPaychecksResponse list_paychecks(start=start, end=end, owner_id=owner_id, employer_id=employer_id)

List paychecks (with optional date + owner + employer filter)

Returns paycheck records (Monarch's structured paycheck model, not
raw transactions). Each entry has `payDate`, gross, net, employer,
owner (household member), plus the deductions and deposits arrays.

Filter on `payDate` via `start` / `end`; omit both for full
history. Use `ownerId` to scope to one household member,
`employerId` to scope to one employer.

For window-level rollups use `GET /v1/paychecks/summary`. For full
detail on one paycheck use `GET /v1/paychecks/{id}`.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.list_paychecks_response import ListPaychecksResponse
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
    api_instance = monarch_bridge_client.PaychecksApi(api_client)
    start = '2013-10-20' # date | Lower bound (inclusive), `YYYY-MM-DD`. (optional)
    end = '2013-10-20' # date | Upper bound (inclusive), `YYYY-MM-DD`. (optional)
    owner_id = 'owner_id_example' # str | Filter to one household-member id. (optional)
    employer_id = 'employer_id_example' # str | Filter to one employer id. (optional)

    try:
        # List paychecks (with optional date + owner + employer filter)
        api_response = api_instance.list_paychecks(start=start, end=end, owner_id=owner_id, employer_id=employer_id)
        print("The response of PaychecksApi->list_paychecks:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling PaychecksApi->list_paychecks: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **date**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 
 **end** | **date**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 
 **owner_id** | **str**| Filter to one household-member id. | [optional] 
 **employer_id** | **str**| Filter to one employer id. | [optional] 

### Return type

[**ListPaychecksResponse**](ListPaychecksResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | All paychecks matching the filter. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_paycheck**
> CreatePaycheckResponse update_paycheck(id, update_paycheck_request)

Partial-update a paycheck

Patches one paycheck. Only fields present in the body are forwarded
to Monarch; omit a field to leave it untouched.

**Gotcha**: the `deductions` and `deposits` arrays are NOT delta
updates. When either array is present in the body it WHOLESALE
REPLACES the existing list (Monarch's `UpdatePaycheckInput`
semantics). To add a single deduction, fetch the current list via
`GET /v1/paychecks/{id}` first then send the merged list back.

Common edits: rename via `description`, change `payDate` if logged
on the wrong day, or fill in deductions/deposits after creating
with a bare gross+net.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.create_paycheck_response import CreatePaycheckResponse
from monarch_bridge_client.models.update_paycheck_request import UpdatePaycheckRequest
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
    api_instance = monarch_bridge_client.PaychecksApi(api_client)
    id = 'id_example' # str | Monarch paycheck id.
    update_paycheck_request = monarch_bridge_client.UpdatePaycheckRequest() # UpdatePaycheckRequest | 

    try:
        # Partial-update a paycheck
        api_response = api_instance.update_paycheck(id, update_paycheck_request)
        print("The response of PaychecksApi->update_paycheck:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling PaychecksApi->update_paycheck: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch paycheck id. | 
 **update_paycheck_request** | [**UpdatePaycheckRequest**](UpdatePaycheckRequest.md)|  | 

### Return type

[**CreatePaycheckResponse**](CreatePaycheckResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Updated paycheck. |  -  |
**400** | Validation failed. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_paycheck_employer**
> CreatePaycheckEmployerResponse update_paycheck_employer(id, update_paycheck_employer_request)

Rename an employer

Updates the display name on a registered employer. The new name
propagates to every paycheck record attributed to this employer
(since paychecks reference employer by id, not by name).

Required: `name` in the request body. Use when a company rebrands
or when normalizing names imported from payroll data.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.create_paycheck_employer_response import CreatePaycheckEmployerResponse
from monarch_bridge_client.models.update_paycheck_employer_request import UpdatePaycheckEmployerRequest
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
    api_instance = monarch_bridge_client.PaychecksApi(api_client)
    id = 'id_example' # str | Monarch paycheck-employer id.
    update_paycheck_employer_request = monarch_bridge_client.UpdatePaycheckEmployerRequest() # UpdatePaycheckEmployerRequest | 

    try:
        # Rename an employer
        api_response = api_instance.update_paycheck_employer(id, update_paycheck_employer_request)
        print("The response of PaychecksApi->update_paycheck_employer:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling PaychecksApi->update_paycheck_employer: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch paycheck-employer id. | 
 **update_paycheck_employer_request** | [**UpdatePaycheckEmployerRequest**](UpdatePaycheckEmployerRequest.md)|  | 

### Return type

[**CreatePaycheckEmployerResponse**](CreatePaycheckEmployerResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Updated employer. |  -  |
**400** | Validation failed. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

