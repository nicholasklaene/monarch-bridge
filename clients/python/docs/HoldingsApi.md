# monarch_bridge_client.HoldingsApi

All URIs are relative to *http://localhost:9084*

Method | HTTP request | Description
------------- | ------------- | -------------
[**bulk_update_holdings**](HoldingsApi.md#bulk_update_holdings) | **PATCH** /v1/holdings/bulk | Bulk reprice manual holdings
[**create_manual_holding**](HoldingsApi.md#create_manual_holding) | **POST** /v1/account/{id}/holdings | Add a manual holding to an account
[**create_manual_investments_account**](HoldingsApi.md#create_manual_investments_account) | **POST** /v1/accounts/manual-investments | Create a manual investments account
[**delete_holding**](HoldingsApi.md#delete_holding) | **DELETE** /v1/holdings/{id} | Delete a holding
[**get_holding_history**](HoldingsApi.md#get_holding_history) | **GET** /v1/holdings/{id}/history | Holding value history
[**get_holding_transactions**](HoldingsApi.md#get_holding_transactions) | **GET** /v1/holdings/{id}/transactions | Holding transactions (buys, sells, dividends)
[**get_portfolio_allocation**](HoldingsApi.md#get_portfolio_allocation) | **GET** /v1/portfolio/allocation | Portfolio allocation by classification
[**get_portfolio_allocation_by_account**](HoldingsApi.md#get_portfolio_allocation_by_account) | **GET** /v1/portfolio/allocation/by-account | Portfolio allocation grouped by account
[**get_portfolio_allocation_by_holdings**](HoldingsApi.md#get_portfolio_allocation_by_holdings) | **GET** /v1/portfolio/allocation/by-holdings | Portfolio allocation grouped by holding
[**get_portfolio_allocation_holdings_detail**](HoldingsApi.md#get_portfolio_allocation_holdings_detail) | **GET** /v1/portfolio/allocation/holdings-detail | Holdings within one allocation bucket
[**get_security_details**](HoldingsApi.md#get_security_details) | **GET** /v1/securities/{id} | Security details
[**get_security_dividends**](HoldingsApi.md#get_security_dividends) | **GET** /v1/securities/{id}/dividends | Security dividend history
[**get_security_historical_performance**](HoldingsApi.md#get_security_historical_performance) | **GET** /v1/securities/{id}/performance | Historical performance for one security
[**search_securities**](HoldingsApi.md#search_securities) | **GET** /v1/securities/search | Search the security catalog
[**update_holding**](HoldingsApi.md#update_holding) | **PATCH** /v1/holdings/{id} | Update a holding


# **bulk_update_holdings**
> BulkUpdateHoldingsResponse bulk_update_holdings(bulk_update_holdings_request)

Bulk reprice manual holdings

Reprice many manual holdings in one round trip. Each entry carries the
holding id plus optional new `quantity` and `costBasis`. Monarch
processes each row independently and returns the success / failure
counts plus per-row failure reasons.

Bulk-best-effort: partial success returns 200 with `failedCount > 0`.
A blanket failure (auth, malformed request) returns the usual error
envelope.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.bulk_update_holdings_response import BulkUpdateHoldingsResponse
from monarch_bridge_client.models.bulk_update_holdings_request import BulkUpdateHoldingsRequest
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
    api_instance = monarch_bridge_client.HoldingsApi(api_client)
    bulk_update_holdings_request = monarch_bridge_client.BulkUpdateHoldingsRequest() # BulkUpdateHoldingsRequest | 

    try:
        # Bulk reprice manual holdings
        api_response = api_instance.bulk_update_holdings(bulk_update_holdings_request)
        print("The response of HoldingsApi->bulk_update_holdings:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling HoldingsApi->bulk_update_holdings: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **bulk_update_holdings_request** | [**BulkUpdateHoldingsRequest**](BulkUpdateHoldingsRequest.md)|  | 

### Return type

[**BulkUpdateHoldingsResponse**](BulkUpdateHoldingsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Counts plus any per-row failures. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **create_manual_holding**
> CreateManualHoldingResponse create_manual_holding(id, create_manual_holding_request)

Add a manual holding to an account

Tracks a security position inside a brokerage account that Monarch can't auto-sync
(e.g. employer 401k, private fund). `securityId` must be a real Monarch security id;
use `GET /v1/securities/search` to look one up by ticker or name.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.create_manual_holding_response import CreateManualHoldingResponse
from monarch_bridge_client.models.create_manual_holding_request import CreateManualHoldingRequest
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
    api_instance = monarch_bridge_client.HoldingsApi(api_client)
    id = 'id_example' # str | Monarch account id.
    create_manual_holding_request = monarch_bridge_client.CreateManualHoldingRequest() # CreateManualHoldingRequest | 

    try:
        # Add a manual holding to an account
        api_response = api_instance.create_manual_holding(id, create_manual_holding_request)
        print("The response of HoldingsApi->create_manual_holding:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling HoldingsApi->create_manual_holding: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch account id. | 
 **create_manual_holding_request** | [**CreateManualHoldingRequest**](CreateManualHoldingRequest.md)|  | 

### Return type

[**CreateManualHoldingResponse**](CreateManualHoldingResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | New holding id. |  -  |
**400** | Validation failed. |  -  |
**422** | Monarch PayloadError. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **create_manual_investments_account**
> CreateManualAccountResponse create_manual_investments_account(create_manual_investments_account_request)

Create a manual investments account

Creates a brokerage-style account Monarch cannot auto-sync (e.g. employer 401k where
Plaid lacks coverage). Two tracking methods:

  - `balances`: single account-level balance, no per-security detail.
  - `holdings`: per-security positions (seed via `initialHoldings`).

Defaults: `trackingMethod` is omitted (Monarch chooses based on whether `initialHoldings`
is present). Use the dedicated holdings endpoints later to add or update positions.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.create_manual_account_response import CreateManualAccountResponse
from monarch_bridge_client.models.create_manual_investments_account_request import CreateManualInvestmentsAccountRequest
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
    api_instance = monarch_bridge_client.HoldingsApi(api_client)
    create_manual_investments_account_request = monarch_bridge_client.CreateManualInvestmentsAccountRequest() # CreateManualInvestmentsAccountRequest | 

    try:
        # Create a manual investments account
        api_response = api_instance.create_manual_investments_account(create_manual_investments_account_request)
        print("The response of HoldingsApi->create_manual_investments_account:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling HoldingsApi->create_manual_investments_account: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **create_manual_investments_account_request** | [**CreateManualInvestmentsAccountRequest**](CreateManualInvestmentsAccountRequest.md)|  | 

### Return type

[**CreateManualAccountResponse**](CreateManualAccountResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | New account id. |  -  |
**400** | Validation failed. |  -  |
**422** | Monarch PayloadError. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_holding**
> DeleteAccountResponse delete_holding(id)

Delete a holding

Removes one security position from its account. **Destructive** -
no soft-delete. Use to clean up a stale manual holding or one
Monarch double-imported.

On Plaid-synced brokerage accounts the holding may re-appear on
next sync if the position still exists at the data provider. For
manual investments accounts the delete sticks.


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
    api_instance = monarch_bridge_client.HoldingsApi(api_client)
    id = 'id_example' # str | Monarch holding id.

    try:
        # Delete a holding
        api_response = api_instance.delete_holding(id)
        print("The response of HoldingsApi->delete_holding:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling HoldingsApi->delete_holding: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch holding id. | 

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

# **get_holding_history**
> GetHoldingHistoryResponse get_holding_history(id, start=start, end=end)

Holding value history

Per-day value, quantity, and price series for one holding. Backs
the holding drawer chart in the web Investments tab.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_holding_history_response import GetHoldingHistoryResponse
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
    api_instance = monarch_bridge_client.HoldingsApi(api_client)
    id = 'id_example' # str | Monarch holding id.
    start = '2013-10-20' # date | Lower bound (inclusive), `YYYY-MM-DD`. (optional)
    end = '2013-10-20' # date | Upper bound (inclusive), `YYYY-MM-DD`. (optional)

    try:
        # Holding value history
        api_response = api_instance.get_holding_history(id, start=start, end=end)
        print("The response of HoldingsApi->get_holding_history:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling HoldingsApi->get_holding_history: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch holding id. | 
 **start** | **date**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 
 **end** | **date**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 

### Return type

[**GetHoldingHistoryResponse**](GetHoldingHistoryResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Per-day points. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_holding_transactions**
> GetHoldingTransactionsResponse get_holding_transactions(id, start=start, end=end, limit=limit, offset=offset)

Holding transactions (buys, sells, dividends)

Discrete cost-basis events for one holding across a window.
Different from `GET /v1/holdings/{id}/history` which returns the
per-day price / value series - this returns the buys, sells,
dividends, and transfers that actually moved the position.

`type` is one of `buy`, `sell`, `dividend`, `transfer_in`,
`transfer_out`.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_holding_transactions_response import GetHoldingTransactionsResponse
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
    api_instance = monarch_bridge_client.HoldingsApi(api_client)
    id = 'id_example' # str | Monarch holding id.
    start = '2013-10-20' # date | Lower bound (inclusive), `YYYY-MM-DD`. (optional)
    end = '2013-10-20' # date | Upper bound (inclusive), `YYYY-MM-DD`. (optional)
    limit = 56 # int | Page size. (optional)
    offset = 56 # int | Page offset. (optional)

    try:
        # Holding transactions (buys, sells, dividends)
        api_response = api_instance.get_holding_transactions(id, start=start, end=end, limit=limit, offset=offset)
        print("The response of HoldingsApi->get_holding_transactions:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling HoldingsApi->get_holding_transactions: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch holding id. | 
 **start** | **date**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 
 **end** | **date**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 
 **limit** | **int**| Page size. | [optional] 
 **offset** | **int**| Page offset. | [optional] 

### Return type

[**GetHoldingTransactionsResponse**](GetHoldingTransactionsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Holding transactions in the window. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_portfolio_allocation**
> GetPortfolioAllocationResponse get_portfolio_allocation(account_ids=account_ids, classification_field=classification_field)

Portfolio allocation by classification

Pie-chart-style allocation breakdown for the portfolio (or a subset filtered
via `accountIds`). Pass `classificationField` to bucket by security type, asset
class, or sector. Returns each bucket's percent + dollar value, plus the total
portfolio value.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_portfolio_allocation_response import GetPortfolioAllocationResponse
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
    api_instance = monarch_bridge_client.HoldingsApi(api_client)
    account_ids = ['account_ids_example'] # List[str] | Filter by one or more Monarch account ids. Repeat the query param for each. Preferred over the legacy single `accountId` param; both are accepted and merged.  (optional)
    classification_field = 'classification_field_example' # str | Monarch's `PortfolioAllocationClassificationField` enum value (e.g. `SECURITY_TYPE`). Omit to use Monarch's default classification.  (optional)

    try:
        # Portfolio allocation by classification
        api_response = api_instance.get_portfolio_allocation(account_ids=account_ids, classification_field=classification_field)
        print("The response of HoldingsApi->get_portfolio_allocation:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling HoldingsApi->get_portfolio_allocation: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **account_ids** | [**List[str]**](str.md)| Filter by one or more Monarch account ids. Repeat the query param for each. Preferred over the legacy single &#x60;accountId&#x60; param; both are accepted and merged.  | [optional] 
 **classification_field** | **str**| Monarch&#39;s &#x60;PortfolioAllocationClassificationField&#x60; enum value (e.g. &#x60;SECURITY_TYPE&#x60;). Omit to use Monarch&#39;s default classification.  | [optional] 

### Return type

[**GetPortfolioAllocationResponse**](GetPortfolioAllocationResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Allocation breakdown. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_portfolio_allocation_by_account**
> GetPortfolioAllocationByHoldingsResponse get_portfolio_allocation_by_account(account_ids=account_ids, limit=limit)

Portfolio allocation grouped by account

Allocation breakdown bucketed per investments account (rather than per security).
Each row is one account with its percent of portfolio and total dollar value.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_portfolio_allocation_by_holdings_response import GetPortfolioAllocationByHoldingsResponse
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
    api_instance = monarch_bridge_client.HoldingsApi(api_client)
    account_ids = ['account_ids_example'] # List[str] | Filter by one or more Monarch account ids. Repeat the query param for each. Preferred over the legacy single `accountId` param; both are accepted and merged.  (optional)
    limit = 56 # int | Page size. (optional)

    try:
        # Portfolio allocation grouped by account
        api_response = api_instance.get_portfolio_allocation_by_account(account_ids=account_ids, limit=limit)
        print("The response of HoldingsApi->get_portfolio_allocation_by_account:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling HoldingsApi->get_portfolio_allocation_by_account: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **account_ids** | [**List[str]**](str.md)| Filter by one or more Monarch account ids. Repeat the query param for each. Preferred over the legacy single &#x60;accountId&#x60; param; both are accepted and merged.  | [optional] 
 **limit** | **int**| Page size. | [optional] 

### Return type

[**GetPortfolioAllocationByHoldingsResponse**](GetPortfolioAllocationByHoldingsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Per-account allocation rows. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_portfolio_allocation_by_holdings**
> GetPortfolioAllocationByHoldingsResponse get_portfolio_allocation_by_holdings(account_ids=account_ids, limit=limit)

Portfolio allocation grouped by holding

Allocation breakdown bucketed per holding (ticker / security name), capped at
`limit` rows. Each row is one security with its percent of portfolio and total
dollar value.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_portfolio_allocation_by_holdings_response import GetPortfolioAllocationByHoldingsResponse
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
    api_instance = monarch_bridge_client.HoldingsApi(api_client)
    account_ids = ['account_ids_example'] # List[str] | Filter by one or more Monarch account ids. Repeat the query param for each. Preferred over the legacy single `accountId` param; both are accepted and merged.  (optional)
    limit = 56 # int | Page size. (optional)

    try:
        # Portfolio allocation grouped by holding
        api_response = api_instance.get_portfolio_allocation_by_holdings(account_ids=account_ids, limit=limit)
        print("The response of HoldingsApi->get_portfolio_allocation_by_holdings:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling HoldingsApi->get_portfolio_allocation_by_holdings: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **account_ids** | [**List[str]**](str.md)| Filter by one or more Monarch account ids. Repeat the query param for each. Preferred over the legacy single &#x60;accountId&#x60; param; both are accepted and merged.  | [optional] 
 **limit** | **int**| Page size. | [optional] 

### Return type

[**GetPortfolioAllocationByHoldingsResponse**](GetPortfolioAllocationByHoldingsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Per-holding allocation rows. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_portfolio_allocation_holdings_detail**
> GetPortfolioAllocationHoldingsDetailResponse get_portfolio_allocation_holdings_detail(classification_field, classification_value, account_ids=account_ids, limit=limit, offset=offset)

Holdings within one allocation bucket

Drill-down: lists the individual holdings inside one classification bucket (e.g.
every equity inside the "Equities" classification value). Requires
`classificationField` + `classificationValue` plus optional pagination.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_portfolio_allocation_holdings_detail_response import GetPortfolioAllocationHoldingsDetailResponse
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
    api_instance = monarch_bridge_client.HoldingsApi(api_client)
    classification_field = 'classification_field_example' # str | Monarch's `PortfolioAllocationClassificationField` enum value.
    classification_value = 'classification_value_example' # str | The specific bucket value within `classificationField` to drill into.
    account_ids = ['account_ids_example'] # List[str] | Filter by one or more Monarch account ids. Repeat the query param for each. Preferred over the legacy single `accountId` param; both are accepted and merged.  (optional)
    limit = 56 # int | Page size. (optional)
    offset = 56 # int | Page offset. (optional)

    try:
        # Holdings within one allocation bucket
        api_response = api_instance.get_portfolio_allocation_holdings_detail(classification_field, classification_value, account_ids=account_ids, limit=limit, offset=offset)
        print("The response of HoldingsApi->get_portfolio_allocation_holdings_detail:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling HoldingsApi->get_portfolio_allocation_holdings_detail: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **classification_field** | **str**| Monarch&#39;s &#x60;PortfolioAllocationClassificationField&#x60; enum value. | 
 **classification_value** | **str**| The specific bucket value within &#x60;classificationField&#x60; to drill into. | 
 **account_ids** | [**List[str]**](str.md)| Filter by one or more Monarch account ids. Repeat the query param for each. Preferred over the legacy single &#x60;accountId&#x60; param; both are accepted and merged.  | [optional] 
 **limit** | **int**| Page size. | [optional] 
 **offset** | **int**| Page offset. | [optional] 

### Return type

[**GetPortfolioAllocationHoldingsDetailResponse**](GetPortfolioAllocationHoldingsDetailResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Holdings inside the requested bucket. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_security_details**
> GetSecurityDetailsResponse get_security_details(id)

Security details

Full security metadata: ticker, name, type, sector, industry, market
cap, P/E ratio, dividend yield, current and closing price.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_security_details_response import GetSecurityDetailsResponse
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
    api_instance = monarch_bridge_client.HoldingsApi(api_client)
    id = 'id_example' # str | Monarch security id.

    try:
        # Security details
        api_response = api_instance.get_security_details(id)
        print("The response of HoldingsApi->get_security_details:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling HoldingsApi->get_security_details: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch security id. | 

### Return type

[**GetSecurityDetailsResponse**](GetSecurityDetailsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Security details. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_security_dividends**
> GetSecurityDividendsResponse get_security_dividends(id, start=start, end=end)

Security dividend history

Dividend payment history for one security. Each entry has the
payment date, per-share amount, and dividend type (regular,
special, etc.).


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_security_dividends_response import GetSecurityDividendsResponse
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
    api_instance = monarch_bridge_client.HoldingsApi(api_client)
    id = 'id_example' # str | Monarch security id.
    start = '2013-10-20' # date | Lower bound (inclusive), `YYYY-MM-DD`. (optional)
    end = '2013-10-20' # date | Upper bound (inclusive), `YYYY-MM-DD`. (optional)

    try:
        # Security dividend history
        api_response = api_instance.get_security_dividends(id, start=start, end=end)
        print("The response of HoldingsApi->get_security_dividends:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling HoldingsApi->get_security_dividends: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch security id. | 
 **start** | **date**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 
 **end** | **date**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 

### Return type

[**GetSecurityDividendsResponse**](GetSecurityDividendsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Dividend history. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_security_historical_performance**
> GetSecurityHistoricalPerformanceResponse get_security_historical_performance(id, start=start, end=end)

Historical performance for one security

Per-day price history for one security plus its current and closing price.
`historicalChart` is a list of `(date, returnPercent, value)` points where
`returnPercent` is the cumulative return from the window start.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_security_historical_performance_response import GetSecurityHistoricalPerformanceResponse
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
    api_instance = monarch_bridge_client.HoldingsApi(api_client)
    id = 'id_example' # str | Monarch security id.
    start = '2013-10-20' # date | Window start (inclusive). (optional)
    end = '2013-10-20' # date | Window end (inclusive). (optional)

    try:
        # Historical performance for one security
        api_response = api_instance.get_security_historical_performance(id, start=start, end=end)
        print("The response of HoldingsApi->get_security_historical_performance:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling HoldingsApi->get_security_historical_performance: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch security id. | 
 **start** | **date**| Window start (inclusive). | [optional] 
 **end** | **date**| Window end (inclusive). | [optional] 

### Return type

[**GetSecurityHistoricalPerformanceResponse**](GetSecurityHistoricalPerformanceResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Historical price + return chart. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **search_securities**
> SearchSecuritiesResponse search_securities(q, limit=limit, order_by_popularity=order_by_popularity)

Search the security catalog

Free-text search across Monarch's security catalog (Plaid-backed
plus user-added). Use to resolve a ticker or company name to the
`securityId` required by the manual holding endpoints
(`POST /v1/account/{id}/holdings`).

`q` is required and matches ticker, name, or partial substring.
`orderByPopularity: true` ranks by Monarch-wide holding popularity
instead of relevance (handy when you know the ticker is common but
the search returns less-traded names first).


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.search_securities_response import SearchSecuritiesResponse
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
    api_instance = monarch_bridge_client.HoldingsApi(api_client)
    q = 'q_example' # str | Search text (ticker, name, partial match).
    limit = 56 # int | Cap the result count. Monarch defaults to a small page when omitted. (optional)
    order_by_popularity = True # bool | When true, Monarch ranks by popularity instead of relevance. (optional)

    try:
        # Search the security catalog
        api_response = api_instance.search_securities(q, limit=limit, order_by_popularity=order_by_popularity)
        print("The response of HoldingsApi->search_securities:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling HoldingsApi->search_securities: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **q** | **str**| Search text (ticker, name, partial match). | 
 **limit** | **int**| Cap the result count. Monarch defaults to a small page when omitted. | [optional] 
 **order_by_popularity** | **bool**| When true, Monarch ranks by popularity instead of relevance. | [optional] 

### Return type

[**SearchSecuritiesResponse**](SearchSecuritiesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Matching securities. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_holding**
> UpdateHoldingResponse update_holding(id, update_holding_request)

Update a holding

Partial-update a holding. Fields are independent: pass only what changed.
`userCostBasis` is stored separately from any data-provider basis, so setting it
overrides for display only.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.update_holding_response import UpdateHoldingResponse
from monarch_bridge_client.models.update_holding_request import UpdateHoldingRequest
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
    api_instance = monarch_bridge_client.HoldingsApi(api_client)
    id = 'id_example' # str | Monarch holding id.
    update_holding_request = monarch_bridge_client.UpdateHoldingRequest() # UpdateHoldingRequest | 

    try:
        # Update a holding
        api_response = api_instance.update_holding(id, update_holding_request)
        print("The response of HoldingsApi->update_holding:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling HoldingsApi->update_holding: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch holding id. | 
 **update_holding_request** | [**UpdateHoldingRequest**](UpdateHoldingRequest.md)|  | 

### Return type

[**UpdateHoldingResponse**](UpdateHoldingResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Updated holding id. |  -  |
**400** | Validation failed. |  -  |
**422** | Monarch PayloadError. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

