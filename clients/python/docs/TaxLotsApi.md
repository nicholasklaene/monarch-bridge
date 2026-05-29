# monarch_bridge_client.TaxLotsApi

All URIs are relative to *http://localhost:9084*

Method | HTTP request | Description
------------- | ------------- | -------------
[**create_manual_tax_lot**](TaxLotsApi.md#create_manual_tax_lot) | **POST** /v1/holdings/{id}/tax-lots/create | Create one manual tax lot under a holding
[**create_manual_tax_lots_bulk**](TaxLotsApi.md#create_manual_tax_lots_bulk) | **POST** /v1/accounts/{id}/tax-lots/bulk | Bulk-create tax lots under an account
[**delete_tax_lot**](TaxLotsApi.md#delete_tax_lot) | **DELETE** /v1/tax-lots/{id} | Delete one manual tax lot
[**delete_tax_lots_bulk**](TaxLotsApi.md#delete_tax_lots_bulk) | **POST** /v1/tax-lots/bulk-delete | Bulk-delete tax lots by id
[**get_tax_lot_performance**](TaxLotsApi.md#get_tax_lot_performance) | **GET** /v1/holdings/{id}/tax-lot-performance | Per-holding tax-lot performance chart
[**list_tax_lots**](TaxLotsApi.md#list_tax_lots) | **GET** /v1/holdings/{id}/tax-lots | List tax lots under a holding
[**update_tax_lot**](TaxLotsApi.md#update_tax_lot) | **PATCH** /v1/tax-lots/{id} | Update one manual tax lot


# **create_manual_tax_lot**
> CreateManualTaxLotResponse create_manual_tax_lot(id, create_manual_tax_lot_request)

Create one manual tax lot under a holding

Adds one manual cost-basis tax lot under the given holding. The Monarch
web client surfaces this when the user edits a manual investments
holding and clicks "Add a tax lot".

The lot is independent of any data-provider basis - manual lots
accumulate alongside synced basis, with the user-side total reflected
in the holding's per-lot performance chart.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.create_manual_tax_lot_response import CreateManualTaxLotResponse
from monarch_bridge_client.models.create_manual_tax_lot_request import CreateManualTaxLotRequest
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
    api_instance = monarch_bridge_client.TaxLotsApi(api_client)
    id = 'id_example' # str | Monarch holding id.
    create_manual_tax_lot_request = monarch_bridge_client.CreateManualTaxLotRequest() # CreateManualTaxLotRequest | 

    try:
        # Create one manual tax lot under a holding
        api_response = api_instance.create_manual_tax_lot(id, create_manual_tax_lot_request)
        print("The response of TaxLotsApi->create_manual_tax_lot:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TaxLotsApi->create_manual_tax_lot: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch holding id. | 
 **create_manual_tax_lot_request** | [**CreateManualTaxLotRequest**](CreateManualTaxLotRequest.md)|  | 

### Return type

[**CreateManualTaxLotResponse**](CreateManualTaxLotResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The created tax lot. |  -  |
**422** | Monarch PayloadError. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **create_manual_tax_lots_bulk**
> CreateManualTaxLotsBulkResponse create_manual_tax_lots_bulk(id, create_manual_tax_lots_bulk_request)

Bulk-create tax lots under an account

Batch import of manual tax lots scoped to one investments account.
Each row carries its own `holdingId`. Per-row errors surface in the
`errors` array; successful lots in `taxLots`. Idempotent on identical
`(holdingId, acquisitionDate, acquisitionQuantity, costBasisPerUnit)`
tuples - Monarch dedupes.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.create_manual_tax_lots_bulk_response import CreateManualTaxLotsBulkResponse
from monarch_bridge_client.models.create_manual_tax_lots_bulk_request import CreateManualTaxLotsBulkRequest
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
    api_instance = monarch_bridge_client.TaxLotsApi(api_client)
    id = 'id_example' # str | Monarch account id (manual investments account).
    create_manual_tax_lots_bulk_request = monarch_bridge_client.CreateManualTaxLotsBulkRequest() # CreateManualTaxLotsBulkRequest | 

    try:
        # Bulk-create tax lots under an account
        api_response = api_instance.create_manual_tax_lots_bulk(id, create_manual_tax_lots_bulk_request)
        print("The response of TaxLotsApi->create_manual_tax_lots_bulk:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TaxLotsApi->create_manual_tax_lots_bulk: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch account id (manual investments account). | 
 **create_manual_tax_lots_bulk_request** | [**CreateManualTaxLotsBulkRequest**](CreateManualTaxLotsBulkRequest.md)|  | 

### Return type

[**CreateManualTaxLotsBulkResponse**](CreateManualTaxLotsBulkResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Created tax lots plus per-row error rows. |  -  |
**422** | Monarch PayloadError. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_tax_lot**
> DeleteTaxLotResponse delete_tax_lot(id)

Delete one manual tax lot

Removes one manual tax lot. **Destructive** - no soft-delete. The
holding's aggregate cost basis re-totals from the remaining lots.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.delete_tax_lot_response import DeleteTaxLotResponse
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
    api_instance = monarch_bridge_client.TaxLotsApi(api_client)
    id = 'id_example' # str | Monarch tax-lot id.

    try:
        # Delete one manual tax lot
        api_response = api_instance.delete_tax_lot(id)
        print("The response of TaxLotsApi->delete_tax_lot:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TaxLotsApi->delete_tax_lot: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch tax-lot id. | 

### Return type

[**DeleteTaxLotResponse**](DeleteTaxLotResponse.md)

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

# **delete_tax_lots_bulk**
> DeleteTaxLotsBulkResponse delete_tax_lots_bulk(delete_tax_lots_bulk_request)

Bulk-delete tax lots by id

One-shot delete of a list of manual tax lots. Returns the deleted
count. Use for cleanup after a wrong bulk import.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.delete_tax_lots_bulk_response import DeleteTaxLotsBulkResponse
from monarch_bridge_client.models.delete_tax_lots_bulk_request import DeleteTaxLotsBulkRequest
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
    api_instance = monarch_bridge_client.TaxLotsApi(api_client)
    delete_tax_lots_bulk_request = monarch_bridge_client.DeleteTaxLotsBulkRequest() # DeleteTaxLotsBulkRequest | 

    try:
        # Bulk-delete tax lots by id
        api_response = api_instance.delete_tax_lots_bulk(delete_tax_lots_bulk_request)
        print("The response of TaxLotsApi->delete_tax_lots_bulk:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TaxLotsApi->delete_tax_lots_bulk: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **delete_tax_lots_bulk_request** | [**DeleteTaxLotsBulkRequest**](DeleteTaxLotsBulkRequest.md)|  | 

### Return type

[**DeleteTaxLotsBulkResponse**](DeleteTaxLotsBulkResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Deleted count. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_tax_lot_performance**
> GetTaxLotPerformanceResponse get_tax_lot_performance(id)

Per-holding tax-lot performance chart

Per-day cost-basis / unrealized-gain / return-percent series across
all tax lots under one holding. Backs the "Lot performance" chart
on the holding detail page.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_tax_lot_performance_response import GetTaxLotPerformanceResponse
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
    api_instance = monarch_bridge_client.TaxLotsApi(api_client)
    id = 'id_example' # str | Monarch holding id.

    try:
        # Per-holding tax-lot performance chart
        api_response = api_instance.get_tax_lot_performance(id)
        print("The response of TaxLotsApi->get_tax_lot_performance:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TaxLotsApi->get_tax_lot_performance: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch holding id. | 

### Return type

[**GetTaxLotPerformanceResponse**](GetTaxLotPerformanceResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Per-day performance points. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_tax_lots**
> ListTaxLotsResponse list_tax_lots(id)

List tax lots under a holding

All manual tax lots attached to one holding. Ordered by
`acquisitionDate` ascending. Pairs with the "Lot performance" chart -
one row per lot.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.list_tax_lots_response import ListTaxLotsResponse
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
    api_instance = monarch_bridge_client.TaxLotsApi(api_client)
    id = 'id_example' # str | Monarch holding id.

    try:
        # List tax lots under a holding
        api_response = api_instance.list_tax_lots(id)
        print("The response of TaxLotsApi->list_tax_lots:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TaxLotsApi->list_tax_lots: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch holding id. | 

### Return type

[**ListTaxLotsResponse**](ListTaxLotsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | All tax lots for this holding. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_tax_lot**
> CreateManualTaxLotResponse update_tax_lot(id, update_tax_lot_request)

Update one manual tax lot

Partial-update one tax lot. Only fields present on the request body are
forwarded. Use to fix a fat-finger on cost basis or acquisition date
without recreating the lot.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.create_manual_tax_lot_response import CreateManualTaxLotResponse
from monarch_bridge_client.models.update_tax_lot_request import UpdateTaxLotRequest
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
    api_instance = monarch_bridge_client.TaxLotsApi(api_client)
    id = 'id_example' # str | Monarch tax-lot id.
    update_tax_lot_request = monarch_bridge_client.UpdateTaxLotRequest() # UpdateTaxLotRequest | 

    try:
        # Update one manual tax lot
        api_response = api_instance.update_tax_lot(id, update_tax_lot_request)
        print("The response of TaxLotsApi->update_tax_lot:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TaxLotsApi->update_tax_lot: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch tax-lot id. | 
 **update_tax_lot_request** | [**UpdateTaxLotRequest**](UpdateTaxLotRequest.md)|  | 

### Return type

[**CreateManualTaxLotResponse**](CreateManualTaxLotResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The updated tax lot. |  -  |
**422** | Monarch PayloadError. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

