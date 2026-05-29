# monarch_bridge_client.MerchantsApi

All URIs are relative to *http://localhost:9084*

Method | HTTP request | Description
------------- | ------------- | -------------
[**delete_merchant**](MerchantsApi.md#delete_merchant) | **DELETE** /v1/merchants/{id} | Delete a merchant
[**get_merchant**](MerchantsApi.md#get_merchant) | **GET** /v1/merchants/{id} | Get full detail for one merchant
[**get_merchant_stats**](MerchantsApi.md#get_merchant_stats) | **GET** /v1/merchants/{id}/stats | Per-merchant aggregate stats
[**get_merchant_transactions**](MerchantsApi.md#get_merchant_transactions) | **GET** /v1/merchants/{id}/transactions | Transactions for one merchant
[**search_merchants**](MerchantsApi.md#search_merchants) | **GET** /v1/merchants/search | Search merchants by name
[**set_merchant_logo**](MerchantsApi.md#set_merchant_logo) | **PATCH** /v1/merchants/{id}/logo | Set a merchant&#39;s logo


# **delete_merchant**
> DeleteMerchantResponse delete_merchant(id, move_to_id=move_to_id)

Delete a merchant

Removes a merchant from the catalog. **Destructive** for any
transactions and rules that referenced this merchant unless you
remap.

Pass `moveToId` to reassign every transaction and every
auto-categorization rule that pointed at this merchant to a
different merchant before deletion. Omit to orphan them (the
transactions will fall back to displaying the raw `plaidName`).

Use `GET /v1/merchants/{id}` first to check `canBeDeleted` and
`transactionCount`.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.delete_merchant_response import DeleteMerchantResponse
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
    api_instance = monarch_bridge_client.MerchantsApi(api_client)
    id = 'id_example' # str | Monarch merchant id.
    move_to_id = 'move_to_id_example' # str | Reassign this merchant's transactions and rules to this merchant before deletion. (optional)

    try:
        # Delete a merchant
        api_response = api_instance.delete_merchant(id, move_to_id=move_to_id)
        print("The response of MerchantsApi->delete_merchant:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling MerchantsApi->delete_merchant: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch merchant id. | 
 **move_to_id** | **str**| Reassign this merchant&#39;s transactions and rules to this merchant before deletion. | [optional] 

### Return type

[**DeleteMerchantResponse**](DeleteMerchantResponse.md)

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

# **get_merchant**
> GetMerchantResponse get_merchant(id)

Get full detail for one merchant

Returns the rich single-merchant view: id, name, `logoUrl`,
`transactionCount`, `ruleCount`, `canBeDeleted`,
`hasActiveRecurringStreams`, plus the merchant's recurring stream
definition when present.

Wraps Monarch's `Common_GetEditMerchant` query, the richest
single-merchant read in the bundle. Use before a delete to check
`canBeDeleted`, before a rename to read the current name (required
by `PATCH /v1/merchants/{id}/recurrence`), or in a detail view.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_merchant_response import GetMerchantResponse
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
    api_instance = monarch_bridge_client.MerchantsApi(api_client)
    id = 'id_example' # str | Monarch merchant id.

    try:
        # Get full detail for one merchant
        api_response = api_instance.get_merchant(id)
        print("The response of MerchantsApi->get_merchant:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling MerchantsApi->get_merchant: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch merchant id. | 

### Return type

[**GetMerchantResponse**](GetMerchantResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Merchant detail. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_merchant_stats**
> GetMerchantStatsResponse get_merchant_stats(id, start=start, end=end)

Per-merchant aggregate stats

Aggregate stats for one merchant across a window: total spend,
transaction count, average ticket, first / last seen, and the count
of distinct months with activity. Backs the merchant detail page's
"Activity" card.

Use `GET /v1/merchants/{id}/transactions` for the row-level
transactions list.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_merchant_stats_response import GetMerchantStatsResponse
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
    api_instance = monarch_bridge_client.MerchantsApi(api_client)
    id = 'id_example' # str | Monarch merchant id.
    start = '2013-10-20' # date | Lower bound (inclusive), `YYYY-MM-DD`. (optional)
    end = '2013-10-20' # date | Upper bound (inclusive), `YYYY-MM-DD`. (optional)

    try:
        # Per-merchant aggregate stats
        api_response = api_instance.get_merchant_stats(id, start=start, end=end)
        print("The response of MerchantsApi->get_merchant_stats:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling MerchantsApi->get_merchant_stats: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch merchant id. | 
 **start** | **date**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 
 **end** | **date**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 

### Return type

[**GetMerchantStatsResponse**](GetMerchantStatsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Stats for the merchant. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_merchant_transactions**
> GetMerchantTransactionsResponse get_merchant_transactions(id, limit=limit, offset=offset)

Transactions for one merchant

Transaction list scoped to a single merchant. Lighter than calling
`/v1/transactions?search=<merchant>` when you already have the
merchant id. Returns date, amount, merchant, and category per row.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_merchant_transactions_response import GetMerchantTransactionsResponse
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
    api_instance = monarch_bridge_client.MerchantsApi(api_client)
    id = 'id_example' # str | Monarch merchant id.
    limit = 56 # int | Page size. (optional)
    offset = 56 # int | Page offset. (optional)

    try:
        # Transactions for one merchant
        api_response = api_instance.get_merchant_transactions(id, limit=limit, offset=offset)
        print("The response of MerchantsApi->get_merchant_transactions:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling MerchantsApi->get_merchant_transactions: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch merchant id. | 
 **limit** | **int**| Page size. | [optional] 
 **offset** | **int**| Page offset. | [optional] 

### Return type

[**GetMerchantTransactionsResponse**](GetMerchantTransactionsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Merchant transaction list. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **search_merchants**
> SearchMerchantsResponse search_merchants(q=q, limit=limit, offset=offset, with_logo=with_logo, include_ids=include_ids)

Search merchants by name

Free-text search across merchant names, ordered by transaction
count (most-used first). Use to populate a merchant picker, resolve
a merchant id by name, or browse the merchant catalog.

Two backing queries via the `withLogo` flag:

- `withLogo: false` (default): faster, omits `logoUrl`, but
  supports the `includeIds` filter (repeat the query param to pin
  specific merchants into the result set even if they don't match
  the search text).
- `withLogo: true`: includes `logoUrl` per merchant; supports
  `offset` pagination but drops `includeIds`.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.search_merchants_response import SearchMerchantsResponse
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
    api_instance = monarch_bridge_client.MerchantsApi(api_client)
    q = 'q_example' # str | Free-text search across merchant names. (optional)
    limit = 56 # int | Max number of merchants to return. (optional)
    offset = 56 # int | Page offset. Only respected when `withLogo` is true. (optional)
    with_logo = False # bool | When true, switch to the logo-enabled variant of the query. (optional) (default to False)
    include_ids = ['include_ids_example'] # List[str] | Pin specific merchant ids into the result set. Repeat the query param for each id. Only respected when `withLogo` is false.  (optional)

    try:
        # Search merchants by name
        api_response = api_instance.search_merchants(q=q, limit=limit, offset=offset, with_logo=with_logo, include_ids=include_ids)
        print("The response of MerchantsApi->search_merchants:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling MerchantsApi->search_merchants: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **q** | **str**| Free-text search across merchant names. | [optional] 
 **limit** | **int**| Max number of merchants to return. | [optional] 
 **offset** | **int**| Page offset. Only respected when &#x60;withLogo&#x60; is true. | [optional] 
 **with_logo** | **bool**| When true, switch to the logo-enabled variant of the query. | [optional] [default to False]
 **include_ids** | [**List[str]**](str.md)| Pin specific merchant ids into the result set. Repeat the query param for each id. Only respected when &#x60;withLogo&#x60; is false.  | [optional] 

### Return type

[**SearchMerchantsResponse**](SearchMerchantsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Matching merchants. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **set_merchant_logo**
> GetMerchantResponse set_merchant_logo(id, set_merchant_logo_request)

Set a merchant's logo

Points the merchant at an existing Cloudinary asset by public id.

**Gotcha**: Monarch's `setMerchantLogo` mutation does NOT accept a
binary upload. The asset must already exist on Cloudinary
(typically uploaded via Monarch's web UI). Pass the asset's
`cloudinaryPublicId`; send `null` or omit to clear the logo.

To upload a fresh logo you'd need to upload to Cloudinary
out-of-band first and then call this endpoint with the resulting
public id (Monarch does not expose its Cloudinary signing for this
use-case).


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_merchant_response import GetMerchantResponse
from monarch_bridge_client.models.set_merchant_logo_request import SetMerchantLogoRequest
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
    api_instance = monarch_bridge_client.MerchantsApi(api_client)
    id = 'id_example' # str | Monarch merchant id.
    set_merchant_logo_request = monarch_bridge_client.SetMerchantLogoRequest() # SetMerchantLogoRequest | 

    try:
        # Set a merchant's logo
        api_response = api_instance.set_merchant_logo(id, set_merchant_logo_request)
        print("The response of MerchantsApi->set_merchant_logo:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling MerchantsApi->set_merchant_logo: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch merchant id. | 
 **set_merchant_logo_request** | [**SetMerchantLogoRequest**](SetMerchantLogoRequest.md)|  | 

### Return type

[**GetMerchantResponse**](GetMerchantResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Updated merchant (id, name, logoUrl). |  -  |
**400** | Validation failed. |  -  |
**422** | Monarch PayloadError. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

