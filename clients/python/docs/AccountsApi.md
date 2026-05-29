# monarch_bridge_client.AccountsApi

All URIs are relative to *http://localhost:9084*

Method | HTTP request | Description
------------- | ------------- | -------------
[**bulk_update_accounts**](AccountsApi.md#bulk_update_accounts) | **PATCH** /v1/accounts/bulk | Bulk-update accounts
[**create_manual_account**](AccountsApi.md#create_manual_account) | **POST** /v1/accounts | Create a manual (non-Plaid) account
[**delete_account**](AccountsApi.md#delete_account) | **DELETE** /v1/accounts/{id} | Delete an account
[**delete_institution**](AccountsApi.md#delete_institution) | **DELETE** /v1/institutions/{id} | Delete a Plaid credential (institution connection)
[**get_account_balance_at_date**](AccountsApi.md#get_account_balance_at_date) | **GET** /v1/accounts/{id}/balance/at | Account display balance at a specific date
[**get_account_groups**](AccountsApi.md#get_account_groups) | **GET** /v1/account-groups | Account groups
[**get_account_history**](AccountsApi.md#get_account_history) | **GET** /v1/account/{id}/history | Daily balance snapshots for one account
[**get_account_holdings**](AccountsApi.md#get_account_holdings) | **GET** /v1/account/{id}/holdings | Investment positions in one account
[**get_account_type_options**](AccountsApi.md#get_account_type_options) | **GET** /v1/account-type-options | Valid (type, subtype) combinations for manual accounts
[**get_balance_history_status**](AccountsApi.md#get_balance_history_status) | **GET** /v1/balance-history/{sessionKey}/status | Poll the parse status of a balance-history upload
[**get_credential_institutions**](AccountsApi.md#get_credential_institutions) | **GET** /v1/credentials/institutions | Linked credentials with their institution metadata
[**get_institution_by_plaid_id**](AccountsApi.md#get_institution_by_plaid_id) | **GET** /v1/institutions/by-plaid/{plaidId} | Institution lookup by Plaid id
[**get_institutions**](AccountsApi.md#get_institutions) | **GET** /v1/institutions | Linked institution credentials (Plaid connection pipes)
[**get_networth**](AccountsApi.md#get_networth) | **GET** /v1/networth | Net-worth snapshots over time
[**get_networth_by_type**](AccountsApi.md#get_networth_by_type) | **GET** /v1/networth/by-type | Balance history grouped by account-type
[**get_networth_recent**](AccountsApi.md#get_networth_recent) | **GET** /v1/networth/recent | Per-account recent balance fluctuations
[**get_top_institution_groups**](AccountsApi.md#get_top_institution_groups) | **GET** /v1/institutions/top-groups | Top institution groups (popular providers by category)
[**list_accounts**](AccountsApi.md#list_accounts) | **GET** /v1/accounts | List all linked + manual accounts
[**list_linked_credentials**](AccountsApi.md#list_linked_credentials) | **GET** /v1/credentials | List linked credentials
[**preview_account_balance**](AccountsApi.md#preview_account_balance) | **GET** /v1/accounts/{id}/balance/preview | Preview an account display balance under edit options
[**update_account**](AccountsApi.md#update_account) | **PATCH** /v1/accounts/{id} | Partial-update an account
[**update_account_group_order**](AccountsApi.md#update_account_group_order) | **PUT** /v1/account-groups/order | Reorder account groups
[**upload_account_balance_history**](AccountsApi.md#upload_account_balance_history) | **POST** /v1/accounts/{id}/balance-history | Bulk-backfill balance history for a manual account from a CSV


# **bulk_update_accounts**
> BulkUpdateAccountsResponse bulk_update_accounts(bulk_update_accounts_request)

Bulk-update accounts

Forwards Monarch's `updateAccounts` mutation. Send one or more
`UpdateAccountsMutationInput` entries; each must include `id` plus any subset of
the patchable fields. Returns every updated account.

Use for "rename three accounts at once" / "hide a set of accounts" / "flip
includeInNetWorth on a list" without firing N single `PATCH /v1/accounts/{id}`
calls.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.bulk_update_accounts_response import BulkUpdateAccountsResponse
from monarch_bridge_client.models.bulk_update_accounts_request import BulkUpdateAccountsRequest
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
    api_instance = monarch_bridge_client.AccountsApi(api_client)
    bulk_update_accounts_request = monarch_bridge_client.BulkUpdateAccountsRequest() # BulkUpdateAccountsRequest | 

    try:
        # Bulk-update accounts
        api_response = api_instance.bulk_update_accounts(bulk_update_accounts_request)
        print("The response of AccountsApi->bulk_update_accounts:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AccountsApi->bulk_update_accounts: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **bulk_update_accounts_request** | [**BulkUpdateAccountsRequest**](BulkUpdateAccountsRequest.md)|  | 

### Return type

[**BulkUpdateAccountsResponse**](BulkUpdateAccountsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Updated accounts (one per input entry). |  -  |
**400** | Validation failed. |  -  |
**422** | Monarch rejected the mutation (PayloadError). |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **create_manual_account**
> CreateManualAccountResponse create_manual_account(create_manual_account_request)

Create a manual (non-Plaid) account

Creates an account Monarch will not auto-sync. Use for cash, foreign
accounts, employer 401k where Plaid has no coverage, real-estate holdings,
or any other balance the user wants tracked in net worth.

Required: `name`, `type`, `subtype`, `displayBalance`. Use
`GET /v1/account-type-options` to enumerate the valid `(type, subtype)`
pairs. For brokerage-style accounts with per-security holdings, use
`POST /v1/accounts/manual-investments` instead.

Returns the new account id. After creation, set up balance history via
`POST /v1/accounts/{id}/balance-history` (CSV upload) or just let the
daily snapshots accumulate from this point forward.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.create_manual_account_response import CreateManualAccountResponse
from monarch_bridge_client.models.create_manual_account_request import CreateManualAccountRequest
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
    api_instance = monarch_bridge_client.AccountsApi(api_client)
    create_manual_account_request = monarch_bridge_client.CreateManualAccountRequest() # CreateManualAccountRequest | 

    try:
        # Create a manual (non-Plaid) account
        api_response = api_instance.create_manual_account(create_manual_account_request)
        print("The response of AccountsApi->create_manual_account:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AccountsApi->create_manual_account: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **create_manual_account_request** | [**CreateManualAccountRequest**](CreateManualAccountRequest.md)|  | 

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

# **delete_account**
> DeleteAccountResponse delete_account(id)

Delete an account

**Destructive**: removes the account AND every transaction Monarch
associated with it. Balance-history snapshots are also discarded.

Use to clean up a manual account that's no longer relevant, or to
fully purge a Plaid-linked account whose credential was already
unlinked via `DELETE /v1/institutions/{id}`. There is no undo and
no soft-delete fallback for this endpoint - the institution-level
delete soft-deletes accounts; this one hard-deletes a single one.


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
    api_instance = monarch_bridge_client.AccountsApi(api_client)
    id = 'id_example' # str | Monarch account id.

    try:
        # Delete an account
        api_response = api_instance.delete_account(id)
        print("The response of AccountsApi->delete_account:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AccountsApi->delete_account: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch account id. | 

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

# **delete_institution**
> DeleteInstitutionResponse delete_institution(id)

Delete a Plaid credential (institution connection)

Unlinks an institution from Monarch by deleting its Plaid credential.
Equivalent to Monarch web UI: Settings -> Data Sources -> unlink.

The associated accounts get **soft-deleted**: they still appear in
`GET /v1/institutions` under `accounts[]` with a non-null `deletedAt`,
but are excluded from default `GET /v1/accounts` results.

Use this to clean up stale credentials with `updateRequired: true` that
no longer authenticate (the equivalent of a dead Plaid connection).
Credential IDs come from `GET /v1/institutions` `credentials[].id`.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.delete_institution_response import DeleteInstitutionResponse
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
    api_instance = monarch_bridge_client.AccountsApi(api_client)
    id = 'id_example' # str | Credential ID from `/v1/institutions` `credentials[].id`.

    try:
        # Delete a Plaid credential (institution connection)
        api_response = api_instance.delete_institution(id)
        print("The response of AccountsApi->delete_institution:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AccountsApi->delete_institution: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Credential ID from &#x60;/v1/institutions&#x60; &#x60;credentials[].id&#x60;. | 

### Return type

[**DeleteInstitutionResponse**](DeleteInstitutionResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Confirmation. |  -  |
**422** | Monarch refused the delete (PayloadError). |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_account_balance_at_date**
> GetAccountBalanceAtDateResponse get_account_balance_at_date(id, var_date)

Account display balance at a specific date

"What was this account worth on YYYY-MM-DD." Walks back through Monarch's
daily snapshot series and returns the displayed (sign-adjusted) balance
as of the requested date.

Use for point-in-time reporting (year-end statements, lookback charts) when
you need one date for one account. For the full series use
`GET /v1/account/{id}/history`; for aggregate net worth at a date use
`GET /v1/networth`.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_account_balance_at_date_response import GetAccountBalanceAtDateResponse
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
    api_instance = monarch_bridge_client.AccountsApi(api_client)
    id = 'id_example' # str | Monarch account id.
    var_date = '2013-10-20' # date | Lookback date, `YYYY-MM-DD`.

    try:
        # Account display balance at a specific date
        api_response = api_instance.get_account_balance_at_date(id, var_date)
        print("The response of AccountsApi->get_account_balance_at_date:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AccountsApi->get_account_balance_at_date: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch account id. | 
 **var_date** | **date**| Lookback date, &#x60;YYYY-MM-DD&#x60;. | 

### Return type

[**GetAccountBalanceAtDateResponse**](GetAccountBalanceAtDateResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Display balance for the account on &#x60;date&#x60;. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_account_groups**
> GetAccountGroupsResponse get_account_groups()

Account groups

Visual groupings of accounts under the Accounts tab. Each group has a
display order, an optional collapsed flag, and the ids of accounts it
contains. Pure read - the web tab fires this on mount.

Pair with `PUT /v1/account-groups/order` to persist a new ordering.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_account_groups_response import GetAccountGroupsResponse
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
    api_instance = monarch_bridge_client.AccountsApi(api_client)

    try:
        # Account groups
        api_response = api_instance.get_account_groups()
        print("The response of AccountsApi->get_account_groups:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AccountsApi->get_account_groups: %s\n" % e)
```



### Parameters

This endpoint does not need any parameter.

### Return type

[**GetAccountGroupsResponse**](GetAccountGroupsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | All account groups for the household. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_account_history**
> GetAccountHistoryResponse get_account_history(id)

Daily balance snapshots for one account

Returns the full daily balance series for a single account: one snapshot
per day from the link date (or first manual entry) through today.

Use for per-account trend charts, drift analysis between two accounts, or
to reconstruct a balance at a specific point in time. For aggregated
net-worth across accounts use `GET /v1/networth` instead.

Series is chronologically ascending. Each entry is `(date, signedBalance)`
where the sign matches the account type (loans/credit are negative). For
type-grouped or recent-only views see `GET /v1/networth/by-type` and
`GET /v1/networth/recent`.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_account_history_response import GetAccountHistoryResponse
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
    api_instance = monarch_bridge_client.AccountsApi(api_client)
    id = 'id_example' # str | Monarch account id.

    try:
        # Daily balance snapshots for one account
        api_response = api_instance.get_account_history(id)
        print("The response of AccountsApi->get_account_history:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AccountsApi->get_account_history: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch account id. | 

### Return type

[**GetAccountHistoryResponse**](GetAccountHistoryResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Chronologically-ascending snapshots starting from the account link date. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_account_holdings**
> GetAccountHoldingsResponse get_account_holdings(id)

Investment positions in one account

Returns every security position Monarch tracks inside the account:
quantity, value, cost basis, security metadata (ticker, name, type),
and last-updated timestamp.

Brokerage/retirement accounts only. Returns an empty list for
depository, credit, and loan accounts (no error). For the full security
catalog lookup use `GET /v1/securities/search`; to mutate a single
holding use `PATCH /v1/holdings/{id}` or `DELETE /v1/holdings/{id}`.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_account_holdings_response import GetAccountHoldingsResponse
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
    api_instance = monarch_bridge_client.AccountsApi(api_client)
    id = 'id_example' # str | Monarch account id.

    try:
        # Investment positions in one account
        api_response = api_instance.get_account_holdings(id)
        print("The response of AccountsApi->get_account_holdings:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AccountsApi->get_account_holdings: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch account id. | 

### Return type

[**GetAccountHoldingsResponse**](GetAccountHoldingsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Holdings list (may be empty). |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_account_type_options**
> GetAccountTypeOptionsResponse get_account_type_options()

Valid (type, subtype) combinations for manual accounts

Enumerates the `(type, subtype)` pairs Monarch accepts when creating a
manual account. Use before calling `POST /v1/accounts` to confirm the
pair is supported (e.g. `(depository, checking)`, `(loan, auto)`,
`(real_estate, residential)`).

Static catalog: the response shape is stable across users and rarely
changes, so it's safe to cache for the session. Returns each type
bundled with its supported subtypes plus display names.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_account_type_options_response import GetAccountTypeOptionsResponse
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
    api_instance = monarch_bridge_client.AccountsApi(api_client)

    try:
        # Valid (type, subtype) combinations for manual accounts
        api_response = api_instance.get_account_type_options()
        print("The response of AccountsApi->get_account_type_options:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AccountsApi->get_account_type_options: %s\n" % e)
```



### Parameters

This endpoint does not need any parameter.

### Return type

[**GetAccountTypeOptionsResponse**](GetAccountTypeOptionsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Account type catalog. Use to populate the type/subtype dropdowns. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_balance_history_status**
> GetBalanceHistoryStatusResponse get_balance_history_status(session_key)

Poll the parse status of a balance-history upload

Polls the async parse job kicked off by `POST /v1/accounts/{id}/balance-history`.
Returns Monarch's current `status` for the session (`pending`,
`processing`, `completed`, `failed`).

Typical flow: upload the CSV, grab the `sessionKey` from that 202
response, then call this endpoint every few seconds until `status`
reaches `completed` (usually under 10 seconds for a year of monthly
snapshots). On `failed`, the response includes a Monarch-side error
string explaining the parse problem.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_balance_history_status_response import GetBalanceHistoryStatusResponse
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
    api_instance = monarch_bridge_client.AccountsApi(api_client)
    session_key = 'session_key_example' # str | Session key returned from the upload call.

    try:
        # Poll the parse status of a balance-history upload
        api_response = api_instance.get_balance_history_status(session_key)
        print("The response of AccountsApi->get_balance_history_status:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AccountsApi->get_balance_history_status: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **session_key** | **str**| Session key returned from the upload call. | 

### Return type

[**GetBalanceHistoryStatusResponse**](GetBalanceHistoryStatusResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Current parse status. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_credential_institutions**
> GetCredentialInstitutionsResponse get_credential_institutions()

Linked credentials with their institution metadata

List of credentials with their institutions and the per-credential
`preferredDataProvider`. Richer than `/v1/credentials` because it
includes per-provider institution ids (Plaid, Finicity, MX).


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_credential_institutions_response import GetCredentialInstitutionsResponse
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
    api_instance = monarch_bridge_client.AccountsApi(api_client)

    try:
        # Linked credentials with their institution metadata
        api_response = api_instance.get_credential_institutions()
        print("The response of AccountsApi->get_credential_institutions:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AccountsApi->get_credential_institutions: %s\n" % e)
```



### Parameters

This endpoint does not need any parameter.

### Return type

[**GetCredentialInstitutionsResponse**](GetCredentialInstitutionsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Credentials with institution metadata. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_institution_by_plaid_id**
> GetInstitutionByPlaidIdResponse get_institution_by_plaid_id(plaid_id)

Institution lookup by Plaid id

Look up institution metadata (logo, status, connection health) by
its Plaid institution id.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_institution_by_plaid_id_response import GetInstitutionByPlaidIdResponse
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
    api_instance = monarch_bridge_client.AccountsApi(api_client)
    plaid_id = 'plaid_id_example' # str | The Plaid institution id (e.g. `ins_3`).

    try:
        # Institution lookup by Plaid id
        api_response = api_instance.get_institution_by_plaid_id(plaid_id)
        print("The response of AccountsApi->get_institution_by_plaid_id:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AccountsApi->get_institution_by_plaid_id: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **plaid_id** | **str**| The Plaid institution id (e.g. &#x60;ins_3&#x60;). | 

### Return type

[**GetInstitutionByPlaidIdResponse**](GetInstitutionByPlaidIdResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Institution detail. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_institutions**
> GetInstitutionsResponse get_institutions()

Linked institution credentials (Plaid connection pipes)

Returns every Plaid credential the user has linked, plus the
accounts behind each one and Monarch's subscription summary.
Credentials are the "pipes" - one per institution per Plaid item -
that supply accounts on the other side.

Use to surface connection health: each credential carries
`updateRequired`, `disconnectedFromDataProviderAt`, and last-sync
timestamps so you can detect dead Plaid links. Includes
soft-deleted accounts under `accounts[]` (filter by `deletedAt`).

To unlink an institution use `DELETE /v1/institutions/{id}` where
`{id}` is the credential id from `credentials[].id` here.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_institutions_response import GetInstitutionsResponse
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
    api_instance = monarch_bridge_client.AccountsApi(api_client)

    try:
        # Linked institution credentials (Plaid connection pipes)
        api_response = api_instance.get_institutions()
        print("The response of AccountsApi->get_institutions:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AccountsApi->get_institutions: %s\n" % e)
```



### Parameters

This endpoint does not need any parameter.

### Return type

[**GetInstitutionsResponse**](GetInstitutionsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Credentials + their accounts + subscription summary. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_networth**
> GetNetworthResponse get_networth(start=start, end=end, account_type=account_type)

Net-worth snapshots over time

Returns the user's aggregate net-worth series for the date window:
one row per day with total assets, total liabilities, and net
(assets minus liabilities).

`start` is the oldest date in the window; omit for full history
back to the first account link. `accountType` optionally scopes the
series to one account type (e.g. only `brokerage` to chart investments
in isolation).

Use for top-of-dashboard net-worth charts or trend analysis. For
a per-account-type breakdown see `GET /v1/networth/by-type`; for
per-account recent fluctuations see `GET /v1/networth/recent`. For
a single account's history use `GET /v1/account/{id}/history`.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_networth_response import GetNetworthResponse
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
    api_instance = monarch_bridge_client.AccountsApi(api_client)
    start = '2013-10-20' # date | Lower bound (inclusive), `YYYY-MM-DD`. (optional)
    end = '2013-10-20' # date | Upper bound (inclusive), `YYYY-MM-DD`. (optional)
    account_type = 'account_type_example' # str | Filter to one Monarch account type (e.g. `brokerage`, `real_estate`). (optional)

    try:
        # Net-worth snapshots over time
        api_response = api_instance.get_networth(start=start, end=end, account_type=account_type)
        print("The response of AccountsApi->get_networth:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AccountsApi->get_networth: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **date**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 
 **end** | **date**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 
 **account_type** | **str**| Filter to one Monarch account type (e.g. &#x60;brokerage&#x60;, &#x60;real_estate&#x60;). | [optional] 

### Return type

[**GetNetworthResponse**](GetNetworthResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Daily snapshots within the window. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_networth_by_type**
> GetNetworthByTypeResponse get_networth_by_type(start=start, timeframe=timeframe)

Balance history grouped by account-type

Returns balance snapshots aggregated per account type (depository,
credit, brokerage, loan, real_estate, etc.) instead of one combined
total. Each type gets its own series plus the catalog of account
types is included for convenience.

Use for stacked-area net-worth charts that show how the composition
of net worth has shifted over time (e.g. "cash share is shrinking as
brokerage grows"). `timeframe` controls bucketing (`day` / `week` /
`month` / `year`).


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_networth_by_type_response import GetNetworthByTypeResponse
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
    api_instance = monarch_bridge_client.AccountsApi(api_client)
    start = '2013-10-20' # date | Lower bound (inclusive), `YYYY-MM-DD`. (optional)
    timeframe = month # str | Bucket size for grouped snapshots. (optional) (default to month)

    try:
        # Balance history grouped by account-type
        api_response = api_instance.get_networth_by_type(start=start, timeframe=timeframe)
        print("The response of AccountsApi->get_networth_by_type:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AccountsApi->get_networth_by_type: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **date**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 
 **timeframe** | **str**| Bucket size for grouped snapshots. | [optional] [default to month]

### Return type

[**GetNetworthByTypeResponse**](GetNetworthByTypeResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Grouped snapshots + the account-type list. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_networth_recent**
> GetNetworthRecentResponse get_networth_recent(start=start)

Per-account recent balance fluctuations

Returns a short recent-balances series for **each account**,
starting at `start` (typically a week or month back). Lighter than
pulling each account's full history one-by-one when all you need is
a recent sparkline.

Use for a "what changed lately" dashboard view that highlights
accounts with non-trivial movement. For the full per-account series
use `GET /v1/account/{id}/history`; for the household-aggregate
series use `GET /v1/networth`.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_networth_recent_response import GetNetworthRecentResponse
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
    api_instance = monarch_bridge_client.AccountsApi(api_client)
    start = '2013-10-20' # date | Lower bound (inclusive), `YYYY-MM-DD`. (optional)

    try:
        # Per-account recent balance fluctuations
        api_response = api_instance.get_networth_recent(start=start)
        print("The response of AccountsApi->get_networth_recent:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AccountsApi->get_networth_recent: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **date**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 

### Return type

[**GetNetworthRecentResponse**](GetNetworthRecentResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Per-account recent-balances arrays. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_top_institution_groups**
> GetTopInstitutionGroupsResponse get_top_institution_groups(data_provider=data_provider)

Top institution groups (popular providers by category)

Monarch's top-N institutions grouped by category, scoped to the
requested data providers. Used by the Add-Account UI.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_top_institution_groups_response import GetTopInstitutionGroupsResponse
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
    api_instance = monarch_bridge_client.AccountsApi(api_client)
    data_provider = ['data_provider_example'] # List[str] | One or more data providers (`PLAID`, `FINICITY`, `MX`). (optional)

    try:
        # Top institution groups (popular providers by category)
        api_response = api_instance.get_top_institution_groups(data_provider=data_provider)
        print("The response of AccountsApi->get_top_institution_groups:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AccountsApi->get_top_institution_groups: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **data_provider** | [**List[str]**](str.md)| One or more data providers (&#x60;PLAID&#x60;, &#x60;FINICITY&#x60;, &#x60;MX&#x60;). | [optional] 

### Return type

[**GetTopInstitutionGroupsResponse**](GetTopInstitutionGroupsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Top institution groups. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_accounts**
> ListAccountsResponse list_accounts()

List all linked + manual accounts

Returns every account the user has in Monarch: Plaid-linked depository,
credit, loan, brokerage accounts plus any manually-created accounts.

Use this to enumerate accounts before scoping a transaction query, or to
grab `account.id` values for filter params like `accountIds`. The shape
includes `displayName`, `type`, `subtype`, `currentBalance`, `institution`,
`includeInNetWorth`, and timestamps.

No filtering on the wire: hidden accounts and accounts with
`isAsset: false` come back too. Filter client-side on `includeInNetWorth`
or `hideFromList` if needed. For institution-scoped views use
`GET /v1/institutions`.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.list_accounts_response import ListAccountsResponse
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
    api_instance = monarch_bridge_client.AccountsApi(api_client)

    try:
        # List all linked + manual accounts
        api_response = api_instance.list_accounts()
        print("The response of AccountsApi->list_accounts:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AccountsApi->list_accounts: %s\n" % e)
```



### Parameters

This endpoint does not need any parameter.

### Return type

[**ListAccountsResponse**](ListAccountsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | All accounts (including hidden; filter client-side). |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_linked_credentials**
> ListLinkedCredentialsResponse list_linked_credentials()

List linked credentials

Lightweight list of every linked data-provider credential plus its institution
(id, name, logo). For richer per-credential settings, use the existing
institution-settings endpoint instead.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.list_linked_credentials_response import ListLinkedCredentialsResponse
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
    api_instance = monarch_bridge_client.AccountsApi(api_client)

    try:
        # List linked credentials
        api_response = api_instance.list_linked_credentials()
        print("The response of AccountsApi->list_linked_credentials:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AccountsApi->list_linked_credentials: %s\n" % e)
```



### Parameters

This endpoint does not need any parameter.

### Return type

[**ListLinkedCredentialsResponse**](ListLinkedCredentialsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Linked credentials. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **preview_account_balance**
> PreviewAccountBalanceResponse preview_account_balance(id, invert_synced_balance=invert_synced_balance, use_available_balance=use_available_balance)

Preview an account display balance under edit options

Returns the `displayBalance` Monarch would show for an account if
`invertSyncedBalance` and/or `useAvailableBalance` were toggled.
Used by the "edit account" form to live-preview the effect of those
settings without committing the change.

Pure read-only - no state is mutated.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.preview_account_balance_response import PreviewAccountBalanceResponse
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
    api_instance = monarch_bridge_client.AccountsApi(api_client)
    id = 'id_example' # str | Monarch account id.
    invert_synced_balance = True # bool | Preview what the displayed balance would be if synced balances were sign-flipped. (optional)
    use_available_balance = True # bool | Preview what the displayed balance would be using the available (vs current) balance. (optional)

    try:
        # Preview an account display balance under edit options
        api_response = api_instance.preview_account_balance(id, invert_synced_balance=invert_synced_balance, use_available_balance=use_available_balance)
        print("The response of AccountsApi->preview_account_balance:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AccountsApi->preview_account_balance: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch account id. | 
 **invert_synced_balance** | **bool**| Preview what the displayed balance would be if synced balances were sign-flipped. | [optional] 
 **use_available_balance** | **bool**| Preview what the displayed balance would be using the available (vs current) balance. | [optional] 

### Return type

[**PreviewAccountBalanceResponse**](PreviewAccountBalanceResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Previewed display balance. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_account**
> UpdateAccountResponse update_account(id, update_account_request)

Partial-update an account

Patches an existing account. Only fields present in the body are
forwarded to Monarch; omit a field to leave it untouched.

Common edits: rename via `name`, toggle visibility with
`includeInNetWorth` / `hideFromList`, override the institution-reported
`displayBalance` for manual accounts, or change `type`/`subtype`.

Works on both Plaid-linked and manual accounts, but balance edits only
persist on manual accounts (Plaid will overwrite on next sync). Use
`PATCH /v1/accounts/bulk` to update several at once.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.update_account_response import UpdateAccountResponse
from monarch_bridge_client.models.update_account_request import UpdateAccountRequest
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
    api_instance = monarch_bridge_client.AccountsApi(api_client)
    id = 'id_example' # str | Monarch account id.
    update_account_request = monarch_bridge_client.UpdateAccountRequest() # UpdateAccountRequest | 

    try:
        # Partial-update an account
        api_response = api_instance.update_account(id, update_account_request)
        print("The response of AccountsApi->update_account:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AccountsApi->update_account: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch account id. | 
 **update_account_request** | [**UpdateAccountRequest**](UpdateAccountRequest.md)|  | 

### Return type

[**UpdateAccountResponse**](UpdateAccountResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Updated account. |  -  |
**400** | Validation failed. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_account_group_order**
> UpdateAccountGroupOrderResponse update_account_group_order(update_account_group_order_request)

Reorder account groups

Persist a new ordering for account groups. Send the FULL ordered list of
group ids; Monarch assigns sequential `order` values from the array index
and returns the resulting `(id, order)` pairs.

Whole-set replace: omitting an id from the list does not delete the group
but leaves its `order` undefined relative to the rest.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.update_account_group_order_response import UpdateAccountGroupOrderResponse
from monarch_bridge_client.models.update_account_group_order_request import UpdateAccountGroupOrderRequest
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
    api_instance = monarch_bridge_client.AccountsApi(api_client)
    update_account_group_order_request = monarch_bridge_client.UpdateAccountGroupOrderRequest() # UpdateAccountGroupOrderRequest | 

    try:
        # Reorder account groups
        api_response = api_instance.update_account_group_order(update_account_group_order_request)
        print("The response of AccountsApi->update_account_group_order:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AccountsApi->update_account_group_order: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **update_account_group_order_request** | [**UpdateAccountGroupOrderRequest**](UpdateAccountGroupOrderRequest.md)|  | 

### Return type

[**UpdateAccountGroupOrderResponse**](UpdateAccountGroupOrderResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Updated &#x60;(id, order)&#x60; pairs. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **upload_account_balance_history**
> UploadAccountBalanceHistory202Response upload_account_balance_history(id, file)

Bulk-backfill balance history for a manual account from a CSV

Two-step flow: (1) the proxy forwards the CSV to Monarch's
`/account-balance-history/upload/` endpoint, (2) it triggers a parse via the
`parseBalanceHistory` GraphQL mutation, then returns the session key. Poll
`GET /v1/balance-history/{sessionKey}/status` until `status == "completed"`.

CSV format (matching Monarch's UI uploader): one header row `date,balance`, then
one row per snapshot (`2026-01-31,12345.67`). Negative balances OK for
credit/loan accounts.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.upload_account_balance_history202_response import UploadAccountBalanceHistory202Response
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
    api_instance = monarch_bridge_client.AccountsApi(api_client)
    id = 'id_example' # str | Monarch account id.
    file = None # bytearray | CSV with `date,balance` rows. UTF-8.

    try:
        # Bulk-backfill balance history for a manual account from a CSV
        api_response = api_instance.upload_account_balance_history(id, file)
        print("The response of AccountsApi->upload_account_balance_history:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AccountsApi->upload_account_balance_history: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch account id. | 
 **file** | **bytearray**| CSV with &#x60;date,balance&#x60; rows. UTF-8. | 

### Return type

[**UploadAccountBalanceHistory202Response**](UploadAccountBalanceHistory202Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**202** | Upload accepted; returns the session key. Poll for completion. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

