# monarch_bridge_client.TransactionsApi

All URIs are relative to *http://localhost:9084*

Method | HTTP request | Description
------------- | ------------- | -------------
[**bulk_delete_transactions**](TransactionsApi.md#bulk_delete_transactions) | **POST** /v1/transactions/bulk-delete | Bulk-delete transactions
[**bulk_update_transactions**](TransactionsApi.md#bulk_update_transactions) | **PATCH** /v1/transactions/bulk | Bulk-update transactions
[**create_transaction**](TransactionsApi.md#create_transaction) | **POST** /v1/transactions | Create a manual transaction
[**delete_transaction**](TransactionsApi.md#delete_transaction) | **DELETE** /v1/transactions/{id} | Delete a transaction
[**explain_transaction**](TransactionsApi.md#explain_transaction) | **GET** /v1/transactions/explain/{id} | AI explanation for one transaction
[**explain_transaction_by_path**](TransactionsApi.md#explain_transaction_by_path) | **GET** /v1/transactions/{id}/explain | AI explanation for one transaction
[**get_accounts_for_transaction_filter**](TransactionsApi.md#get_accounts_for_transaction_filter) | **GET** /v1/transactions/accounts-for-filter | Accounts that match a transaction filter
[**get_attachment**](TransactionsApi.md#get_attachment) | **GET** /v1/attachments/{id} | Attachment detail
[**get_cashflow**](TransactionsApi.md#get_cashflow) | **GET** /v1/cashflow | Income, expense, and savings summary for a window
[**get_cashflow_breakdown**](TransactionsApi.md#get_cashflow_breakdown) | **GET** /v1/cashflow/breakdown | Cashflow broken down by category, group, merchant
[**get_cashflow_dashboard**](TransactionsApi.md#get_cashflow_dashboard) | **GET** /v1/cashflow/dashboard | Day-by-day expense series for a date window
[**get_cashflow_entities**](TransactionsApi.md#get_cashflow_entities) | **GET** /v1/cashflow/entities | Cashflow by category / category-group / merchant
[**get_cashflow_filtered**](TransactionsApi.md#get_cashflow_filtered) | **GET** /v1/cashflow/filtered | Filtered cashflow page (summary + four breakdowns)
[**get_cashflow_timeframe**](TransactionsApi.md#get_cashflow_timeframe) | **GET** /v1/cashflow/timeframe | Year / month / quarter cashflow summaries for a date window
[**get_download_transactions_session**](TransactionsApi.md#get_download_transactions_session) | **GET** /v1/transactions/download/{sessionKey} | Poll a transaction download session
[**get_review_summary_by_user**](TransactionsApi.md#get_review_summary_by_user) | **GET** /v1/transactions/review-summary | Review-queue counts by household user
[**get_spending_dashboard**](TransactionsApi.md#get_spending_dashboard) | **GET** /v1/dashboard/spending | Home-tab spending dashboard widget
[**get_spending_trends**](TransactionsApi.md#get_spending_trends) | **GET** /v1/dashboard/spending/trends | Spending trends (period-over-period)
[**get_transaction_audit_log**](TransactionsApi.md#get_transaction_audit_log) | **GET** /v1/transactions/{id}/audit | Transaction audit log
[**get_transaction_detail**](TransactionsApi.md#get_transaction_detail) | **GET** /v1/transactions/{id} | Single-transaction full detail
[**get_transaction_notes**](TransactionsApi.md#get_transaction_notes) | **GET** /v1/transactions/{id}/notes | Transaction notes
[**get_transaction_split_templates**](TransactionsApi.md#get_transaction_split_templates) | **GET** /v1/transactions/split-templates | Saved split templates
[**get_transaction_splits**](TransactionsApi.md#get_transaction_splits) | **GET** /v1/transactions/{id}/splits | Splits of one transaction
[**get_transactions_dashboard**](TransactionsApi.md#get_transactions_dashboard) | **GET** /v1/transactions/dashboard | Dashboard transactions list (with totals + rule count)
[**get_transactions_duplicates**](TransactionsApi.md#get_transactions_duplicates) | **GET** /v1/transactions/duplicates | Groups of likely-duplicate transactions
[**get_transactions_summary**](TransactionsApi.md#get_transactions_summary) | **GET** /v1/transactions/summary | Aggregate stats across a transaction window
[**list_transactions**](TransactionsApi.md#list_transactions) | **GET** /v1/transactions | Search and list transactions with rich filtering
[**mark_as_recurring**](TransactionsApi.md#mark_as_recurring) | **POST** /v1/transactions/{id}/recurring | Mark a transaction as the start of a recurring stream
[**mark_transaction_as_reviewed**](TransactionsApi.md#mark_transaction_as_reviewed) | **POST** /v1/transactions/{id}/reviewed | Mark a transaction as reviewed
[**mark_transaction_stream_as_not_recurring**](TransactionsApi.md#mark_transaction_stream_as_not_recurring) | **POST** /v1/transactions/{id}/not-recurring | Mark a transaction&#39;s recurring-stream as not-recurring
[**match_search_transactions**](TransactionsApi.md#match_search_transactions) | **GET** /v1/transactions/match-search | Fuzzy transaction search for \&quot;find a match\&quot;
[**move_transactions**](TransactionsApi.md#move_transactions) | **POST** /v1/transactions/move | Move transactions between accounts
[**set_transaction_tags**](TransactionsApi.md#set_transaction_tags) | **PUT** /v1/transactions/{id}/tags | Overwrite the tag set on a transaction
[**start_download_transactions**](TransactionsApi.md#start_download_transactions) | **POST** /v1/transactions/download | Start a transaction CSV download session
[**update_transaction**](TransactionsApi.md#update_transaction) | **PATCH** /v1/transactions/{id} | Partial-update a transaction
[**update_transaction_splits**](TransactionsApi.md#update_transaction_splits) | **POST** /v1/transactions/{id}/splits | Replace the splits on a transaction
[**upload_transaction_attachment**](TransactionsApi.md#upload_transaction_attachment) | **POST** /v1/transactions/{id}/attachments | Attach a receipt photo or PDF to a transaction


# **bulk_delete_transactions**
> BulkDeleteTransactionsResponse bulk_delete_transactions(bulk_delete_transactions_request)

Bulk-delete transactions

Forwards Monarch's `bulkDeleteTransactions` mutation. Same two-mode selection as
bulk-update:

- `allSelected: false` + `selectedTransactionIds: [a,b,c]` to delete exactly N.
- `allSelected: true` + `filters: {...}` + optional `excludedTransactionIds: [...]`
  to delete everything matching minus a hand-picked exclusion list.

`expectedAffectedTransactionCount` is the same race-prevention guard as bulk-update.
Destructive: prefer `tx duplicates` first to scope the selection.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.bulk_delete_transactions_response import BulkDeleteTransactionsResponse
from monarch_bridge_client.models.bulk_delete_transactions_request import BulkDeleteTransactionsRequest
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
    api_instance = monarch_bridge_client.TransactionsApi(api_client)
    bulk_delete_transactions_request = monarch_bridge_client.BulkDeleteTransactionsRequest() # BulkDeleteTransactionsRequest | 

    try:
        # Bulk-delete transactions
        api_response = api_instance.bulk_delete_transactions(bulk_delete_transactions_request)
        print("The response of TransactionsApi->bulk_delete_transactions:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TransactionsApi->bulk_delete_transactions: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **bulk_delete_transactions_request** | [**BulkDeleteTransactionsRequest**](BulkDeleteTransactionsRequest.md)|  | 

### Return type

[**BulkDeleteTransactionsResponse**](BulkDeleteTransactionsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Monarch reports success plus the affected-row count. |  -  |
**400** | Validation failed. |  -  |
**422** | Monarch rejected the mutation (e.g. expected-count mismatch). |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **bulk_update_transactions**
> BulkUpdateTransactionsResponse bulk_update_transactions(bulk_update_transactions_request)

Bulk-update transactions

Forwards Monarch's `bulkUpdateTransactions` mutation. Two selection modes are
supported on the same shape (`allSelected` discriminates):

- `allSelected: false` + `selectedTransactionIds: [a,b,c]` is the common case:
  apply `updates` to exactly those N transactions.
- `allSelected: true` + `filters: {...}` + optional `excludedTransactionIds: [...]`
  is the "select everything matching the filter then minus these" pattern.

`expectedAffectedTransactionCount` is a safety check. Monarch refuses the mutation
if its actual affected-row count differs from this number (race-prevention).

The `updates` object is Monarch's `TransactionUpdateParams` input shape (same
field surface as `PATCH /v1/transactions/{id}`: categoryId, merchantName, notes,
date, hide, etc.).


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.bulk_update_transactions_response import BulkUpdateTransactionsResponse
from monarch_bridge_client.models.bulk_update_transactions_request import BulkUpdateTransactionsRequest
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
    api_instance = monarch_bridge_client.TransactionsApi(api_client)
    bulk_update_transactions_request = monarch_bridge_client.BulkUpdateTransactionsRequest() # BulkUpdateTransactionsRequest | 

    try:
        # Bulk-update transactions
        api_response = api_instance.bulk_update_transactions(bulk_update_transactions_request)
        print("The response of TransactionsApi->bulk_update_transactions:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TransactionsApi->bulk_update_transactions: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **bulk_update_transactions_request** | [**BulkUpdateTransactionsRequest**](BulkUpdateTransactionsRequest.md)|  | 

### Return type

[**BulkUpdateTransactionsResponse**](BulkUpdateTransactionsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Monarch reports success plus the affected-row count. |  -  |
**400** | Validation failed. |  -  |
**422** | Monarch rejected the mutation (e.g. expected-count mismatch). |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **create_transaction**
> CreateTransactionResponse create_transaction(create_transaction_request)

Create a manual transaction

Adds a transaction by hand into a specific account. Typically used
for cash spending, manually-tracked accounts, or to record an
item Plaid missed.

Required: `accountId`, `date`, `amount` (signed: negative for
spending, positive for income/refund), and `merchantName`. Optional:
`categoryId`, `notes`, `hideFromReports`. Skips Monarch's auto-
categorization rule pass - the new transaction lands with exactly
the category you supplied (or uncategorized).

For receipt attachment use `POST /v1/transactions/{id}/attachment`
after the create. PayloadError yields 422 on Monarch-side rejection.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.create_transaction_response import CreateTransactionResponse
from monarch_bridge_client.models.create_transaction_request import CreateTransactionRequest
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
    api_instance = monarch_bridge_client.TransactionsApi(api_client)
    create_transaction_request = monarch_bridge_client.CreateTransactionRequest() # CreateTransactionRequest | 

    try:
        # Create a manual transaction
        api_response = api_instance.create_transaction(create_transaction_request)
        print("The response of TransactionsApi->create_transaction:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TransactionsApi->create_transaction: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **create_transaction_request** | [**CreateTransactionRequest**](CreateTransactionRequest.md)|  | 

### Return type

[**CreateTransactionResponse**](CreateTransactionResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | New transaction id. |  -  |
**400** | Validation failed. |  -  |
**422** | Monarch PayloadError. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_transaction**
> DeleteAccountResponse delete_transaction(id)

Delete a transaction

Removes one transaction. **Destructive** - the row is gone from
Monarch, won't reappear on next sync, and disappears from all
aggregates (cashflow, budgets, summaries) for past windows.

Use for cash entries the user wants to undo or for confirmed
duplicate Plaid imports. For bulk cleanup use
`POST /v1/transactions/bulk-delete` (supports filter-based deletes
too). For likely-duplicate detection across a window use
`GET /v1/transactions/duplicates`.


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
    api_instance = monarch_bridge_client.TransactionsApi(api_client)
    id = 'id_example' # str | Monarch transaction id.

    try:
        # Delete a transaction
        api_response = api_instance.delete_transaction(id)
        print("The response of TransactionsApi->delete_transaction:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TransactionsApi->delete_transaction: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch transaction id. | 

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

# **explain_transaction**
> ExplainTransactionResponse explain_transaction(id)

AI explanation for one transaction

Monarch's AI-generated explanation for why a transaction was
categorized the way it was. Useful for surfacing context in audit
or review flows.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.explain_transaction_response import ExplainTransactionResponse
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
    api_instance = monarch_bridge_client.TransactionsApi(api_client)
    id = 'id_example' # str | Monarch transaction id.

    try:
        # AI explanation for one transaction
        api_response = api_instance.explain_transaction(id)
        print("The response of TransactionsApi->explain_transaction:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TransactionsApi->explain_transaction: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch transaction id. | 

### Return type

[**ExplainTransactionResponse**](ExplainTransactionResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Explanation string (may be null). |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **explain_transaction_by_path**
> ExplainTransactionResponse explain_transaction_by_path(id)

AI explanation for one transaction

Monarch's AI-generated explanation for why a transaction was
categorized the way it was. Useful for surfacing context in audit
or review flows.

Companion to `GET /v1/transactions/{id}` - the detail call returns
the raw fields, this call returns Monarch's narrated rationale.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.explain_transaction_response import ExplainTransactionResponse
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
    api_instance = monarch_bridge_client.TransactionsApi(api_client)
    id = 'id_example' # str | Monarch transaction id.

    try:
        # AI explanation for one transaction
        api_response = api_instance.explain_transaction_by_path(id)
        print("The response of TransactionsApi->explain_transaction_by_path:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TransactionsApi->explain_transaction_by_path: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch transaction id. | 

### Return type

[**ExplainTransactionResponse**](ExplainTransactionResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Explanation string (may be null). |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_accounts_for_transaction_filter**
> GetAccountsForTransactionFilterResponse get_accounts_for_transaction_filter(start=start, end=end)

Accounts that match a transaction filter

Returns the accounts that would be touched by a bulk transaction
operation given the supplied filter (date window only here for
simplicity; extends to full filter via repeat params).


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_accounts_for_transaction_filter_response import GetAccountsForTransactionFilterResponse
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
    api_instance = monarch_bridge_client.TransactionsApi(api_client)
    start = '2013-10-20' # date | Lower bound (inclusive), `YYYY-MM-DD`. (optional)
    end = '2013-10-20' # date | Upper bound (inclusive), `YYYY-MM-DD`. (optional)

    try:
        # Accounts that match a transaction filter
        api_response = api_instance.get_accounts_for_transaction_filter(start=start, end=end)
        print("The response of TransactionsApi->get_accounts_for_transaction_filter:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TransactionsApi->get_accounts_for_transaction_filter: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **date**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 
 **end** | **date**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 

### Return type

[**GetAccountsForTransactionFilterResponse**](GetAccountsForTransactionFilterResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Matching accounts (display + provider metadata). |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_attachment**
> GetAttachmentResponse get_attachment(id)

Attachment detail

Resolve an attachment id to its `originalAssetUrl` (a pre-signed download URL).
Use the URL to GET the underlying file from Monarch's storage backend.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_attachment_response import GetAttachmentResponse
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
    api_instance = monarch_bridge_client.TransactionsApi(api_client)
    id = 'id_example' # str | Monarch transaction-attachment id (UUID).

    try:
        # Attachment detail
        api_response = api_instance.get_attachment(id)
        print("The response of TransactionsApi->get_attachment:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TransactionsApi->get_attachment: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch transaction-attachment id (UUID). | 

### Return type

[**GetAttachmentResponse**](GetAttachmentResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Attachment detail. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_cashflow**
> GetCashflowResponse get_cashflow(start=start, end=end, account_ids=account_ids, category_ids=category_ids, tag_ids=tag_ids, search=search, has_attachments=has_attachments, has_notes=has_notes, hide_from_reports=hide_from_reports, is_split=is_split, is_recurring=is_recurring, imported_from_mint=imported_from_mint, synced_from_institution=synced_from_institution, needs_review=needs_review, transaction_visibility=transaction_visibility)

Income, expense, and savings summary for a window

Returns the four headline numbers for a date range: total income,
total expense, net savings (income minus expense), and savings rate
(net savings divided by income). Single row, no per-category
breakdown.

Use for dashboard summary tiles or to drive a savings-rate trend
chart by calling repeatedly across months. For the per-category /
per-merchant breakdown call `GET /v1/cashflow/breakdown` instead.

All the standard transaction filters apply (`accountIds`,
`categoryIds`, `tagIds`, `search`, etc.) - useful to scope to one
account or to exclude transfers.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_cashflow_response import GetCashflowResponse
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
    api_instance = monarch_bridge_client.TransactionsApi(api_client)
    start = '2013-10-20' # date | Lower bound (inclusive), `YYYY-MM-DD`. (optional)
    end = '2013-10-20' # date | Upper bound (inclusive), `YYYY-MM-DD`. (optional)
    account_ids = ['account_ids_example'] # List[str] | Filter by one or more Monarch account ids. Repeat the query param for each. Preferred over the legacy single `accountId` param; both are accepted and merged.  (optional)
    category_ids = ['category_ids_example'] # List[str] | Filter by one or more Monarch category ids. Repeat the query param for each. (optional)
    tag_ids = ['tag_ids_example'] # List[str] | Filter by one or more transaction tag ids. Repeat the query param for each. (optional)
    search = 'search_example' # str | Free-text search against merchant / notes / category. (optional)
    has_attachments = True # bool | When set, restrict to transactions that do or do not have attachments. Omit for either. (optional)
    has_notes = True # bool | When set, restrict to transactions that do or do not have notes. Omit for either. (optional)
    hide_from_reports = True # bool | When set, restrict to transactions that are or are not hidden from reports. Omit for either. (optional)
    is_split = True # bool | When set, restrict to split or non-split transactions. Omit for either. (optional)
    is_recurring = True # bool | When set, restrict to recurring or non-recurring transactions. Omit for either. (optional)
    imported_from_mint = True # bool | When set, restrict to transactions imported from Mint or not. Omit for either. (optional)
    synced_from_institution = True # bool | When set, restrict to transactions synced from the institution feed or not. Omit for either. (optional)
    needs_review = True # bool | When set, restrict to transactions that need review or do not. Omit for either. (optional)
    transaction_visibility = 'transaction_visibility_example' # str | Scope of transactions to return. Omit (default) for non-hidden only. `hidden_transactions_only` returns only hidden; `all_transactions` returns both.  (optional)

    try:
        # Income, expense, and savings summary for a window
        api_response = api_instance.get_cashflow(start=start, end=end, account_ids=account_ids, category_ids=category_ids, tag_ids=tag_ids, search=search, has_attachments=has_attachments, has_notes=has_notes, hide_from_reports=hide_from_reports, is_split=is_split, is_recurring=is_recurring, imported_from_mint=imported_from_mint, synced_from_institution=synced_from_institution, needs_review=needs_review, transaction_visibility=transaction_visibility)
        print("The response of TransactionsApi->get_cashflow:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TransactionsApi->get_cashflow: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **date**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 
 **end** | **date**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 
 **account_ids** | [**List[str]**](str.md)| Filter by one or more Monarch account ids. Repeat the query param for each. Preferred over the legacy single &#x60;accountId&#x60; param; both are accepted and merged.  | [optional] 
 **category_ids** | [**List[str]**](str.md)| Filter by one or more Monarch category ids. Repeat the query param for each. | [optional] 
 **tag_ids** | [**List[str]**](str.md)| Filter by one or more transaction tag ids. Repeat the query param for each. | [optional] 
 **search** | **str**| Free-text search against merchant / notes / category. | [optional] 
 **has_attachments** | **bool**| When set, restrict to transactions that do or do not have attachments. Omit for either. | [optional] 
 **has_notes** | **bool**| When set, restrict to transactions that do or do not have notes. Omit for either. | [optional] 
 **hide_from_reports** | **bool**| When set, restrict to transactions that are or are not hidden from reports. Omit for either. | [optional] 
 **is_split** | **bool**| When set, restrict to split or non-split transactions. Omit for either. | [optional] 
 **is_recurring** | **bool**| When set, restrict to recurring or non-recurring transactions. Omit for either. | [optional] 
 **imported_from_mint** | **bool**| When set, restrict to transactions imported from Mint or not. Omit for either. | [optional] 
 **synced_from_institution** | **bool**| When set, restrict to transactions synced from the institution feed or not. Omit for either. | [optional] 
 **needs_review** | **bool**| When set, restrict to transactions that need review or do not. Omit for either. | [optional] 
 **transaction_visibility** | **str**| Scope of transactions to return. Omit (default) for non-hidden only. &#x60;hidden_transactions_only&#x60; returns only hidden; &#x60;all_transactions&#x60; returns both.  | [optional] 

### Return type

[**GetCashflowResponse**](GetCashflowResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Aggregate summary for the window. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_cashflow_breakdown**
> GetCashflowBreakdownResponse get_cashflow_breakdown(start=start, end=end, account_ids=account_ids, category_ids=category_ids, tag_ids=tag_ids, search=search, has_attachments=has_attachments, has_notes=has_notes, hide_from_reports=hide_from_reports, is_split=is_split, is_recurring=is_recurring, imported_from_mint=imported_from_mint, synced_from_institution=synced_from_institution, needs_review=needs_review, transaction_visibility=transaction_visibility)

Cashflow broken down by category, group, merchant

Same date window as `GET /v1/cashflow`, but returns four buckets in
one call: per-category totals, per-category-group totals,
per-merchant totals, and an aggregate summary.

Use to drive a "where did the money go" breakdown view, or to find
the top N merchants/categories without making three separate
transaction queries. All standard transaction filters apply
(`accountIds`, `categoryIds`, `tagIds`, `search`, etc.) - useful to
exclude transfers or scope to one account.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_cashflow_breakdown_response import GetCashflowBreakdownResponse
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
    api_instance = monarch_bridge_client.TransactionsApi(api_client)
    start = '2013-10-20' # date | Lower bound (inclusive), `YYYY-MM-DD`. (optional)
    end = '2013-10-20' # date | Upper bound (inclusive), `YYYY-MM-DD`. (optional)
    account_ids = ['account_ids_example'] # List[str] | Filter by one or more Monarch account ids. Repeat the query param for each. Preferred over the legacy single `accountId` param; both are accepted and merged.  (optional)
    category_ids = ['category_ids_example'] # List[str] | Filter by one or more Monarch category ids. Repeat the query param for each. (optional)
    tag_ids = ['tag_ids_example'] # List[str] | Filter by one or more transaction tag ids. Repeat the query param for each. (optional)
    search = 'search_example' # str | Free-text search against merchant / notes / category. (optional)
    has_attachments = True # bool | When set, restrict to transactions that do or do not have attachments. Omit for either. (optional)
    has_notes = True # bool | When set, restrict to transactions that do or do not have notes. Omit for either. (optional)
    hide_from_reports = True # bool | When set, restrict to transactions that are or are not hidden from reports. Omit for either. (optional)
    is_split = True # bool | When set, restrict to split or non-split transactions. Omit for either. (optional)
    is_recurring = True # bool | When set, restrict to recurring or non-recurring transactions. Omit for either. (optional)
    imported_from_mint = True # bool | When set, restrict to transactions imported from Mint or not. Omit for either. (optional)
    synced_from_institution = True # bool | When set, restrict to transactions synced from the institution feed or not. Omit for either. (optional)
    needs_review = True # bool | When set, restrict to transactions that need review or do not. Omit for either. (optional)
    transaction_visibility = 'transaction_visibility_example' # str | Scope of transactions to return. Omit (default) for non-hidden only. `hidden_transactions_only` returns only hidden; `all_transactions` returns both.  (optional)

    try:
        # Cashflow broken down by category, group, merchant
        api_response = api_instance.get_cashflow_breakdown(start=start, end=end, account_ids=account_ids, category_ids=category_ids, tag_ids=tag_ids, search=search, has_attachments=has_attachments, has_notes=has_notes, hide_from_reports=hide_from_reports, is_split=is_split, is_recurring=is_recurring, imported_from_mint=imported_from_mint, synced_from_institution=synced_from_institution, needs_review=needs_review, transaction_visibility=transaction_visibility)
        print("The response of TransactionsApi->get_cashflow_breakdown:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TransactionsApi->get_cashflow_breakdown: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **date**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 
 **end** | **date**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 
 **account_ids** | [**List[str]**](str.md)| Filter by one or more Monarch account ids. Repeat the query param for each. Preferred over the legacy single &#x60;accountId&#x60; param; both are accepted and merged.  | [optional] 
 **category_ids** | [**List[str]**](str.md)| Filter by one or more Monarch category ids. Repeat the query param for each. | [optional] 
 **tag_ids** | [**List[str]**](str.md)| Filter by one or more transaction tag ids. Repeat the query param for each. | [optional] 
 **search** | **str**| Free-text search against merchant / notes / category. | [optional] 
 **has_attachments** | **bool**| When set, restrict to transactions that do or do not have attachments. Omit for either. | [optional] 
 **has_notes** | **bool**| When set, restrict to transactions that do or do not have notes. Omit for either. | [optional] 
 **hide_from_reports** | **bool**| When set, restrict to transactions that are or are not hidden from reports. Omit for either. | [optional] 
 **is_split** | **bool**| When set, restrict to split or non-split transactions. Omit for either. | [optional] 
 **is_recurring** | **bool**| When set, restrict to recurring or non-recurring transactions. Omit for either. | [optional] 
 **imported_from_mint** | **bool**| When set, restrict to transactions imported from Mint or not. Omit for either. | [optional] 
 **synced_from_institution** | **bool**| When set, restrict to transactions synced from the institution feed or not. Omit for either. | [optional] 
 **needs_review** | **bool**| When set, restrict to transactions that need review or do not. Omit for either. | [optional] 
 **transaction_visibility** | **str**| Scope of transactions to return. Omit (default) for non-hidden only. &#x60;hidden_transactions_only&#x60; returns only hidden; &#x60;all_transactions&#x60; returns both.  | [optional] 

### Return type

[**GetCashflowBreakdownResponse**](GetCashflowBreakdownResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Four buckets - byCategory / byCategoryGroup / byMerchant / summary. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_cashflow_dashboard**
> GetCashflowDashboardResponse get_cashflow_dashboard(start=start, end=end)

Day-by-day expense series for a date window

Returns daily-bucket expense totals. Lightweight series for charting
spend over a date window. Sparser shape than `/v1/cashflow`, with
only the day-grain summary.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_cashflow_dashboard_response import GetCashflowDashboardResponse
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
    api_instance = monarch_bridge_client.TransactionsApi(api_client)
    start = '2013-10-20' # date | Lower bound (inclusive), `YYYY-MM-DD`. (optional)
    end = '2013-10-20' # date | Upper bound (inclusive), `YYYY-MM-DD`. (optional)

    try:
        # Day-by-day expense series for a date window
        api_response = api_instance.get_cashflow_dashboard(start=start, end=end)
        print("The response of TransactionsApi->get_cashflow_dashboard:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TransactionsApi->get_cashflow_dashboard: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **date**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 
 **end** | **date**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 

### Return type

[**GetCashflowDashboardResponse**](GetCashflowDashboardResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Day-by-day expense totals. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_cashflow_entities**
> GetCashflowEntitiesResponse get_cashflow_entities(start=start, end=end)

Cashflow by category / category-group / merchant

Three breakdowns over the same date window: by category, by category
group, by merchant. Plus a totals summary (income, expense, savings,
savings rate). Great for "where did my money go" prompts.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_cashflow_entities_response import GetCashflowEntitiesResponse
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
    api_instance = monarch_bridge_client.TransactionsApi(api_client)
    start = '2013-10-20' # date | Lower bound (inclusive), `YYYY-MM-DD`. (optional)
    end = '2013-10-20' # date | Upper bound (inclusive), `YYYY-MM-DD`. (optional)

    try:
        # Cashflow by category / category-group / merchant
        api_response = api_instance.get_cashflow_entities(start=start, end=end)
        print("The response of TransactionsApi->get_cashflow_entities:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TransactionsApi->get_cashflow_entities: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **date**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 
 **end** | **date**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 

### Return type

[**GetCashflowEntitiesResponse**](GetCashflowEntitiesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Three breakdowns plus summary. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_cashflow_filtered**
> GetCashflowFilteredResponse get_cashflow_filtered(start=start, end=end, account_id=account_id, category_id=category_id, category_group_id=category_group_id, merchant_id=merchant_id, tag_id=tag_id)

Filtered cashflow page (summary + four breakdowns)

Filterable cashflow query: summary aggregates plus year/month/quarter
bucketing AND category/group/merchant breakdowns in one shot. Filter
by accounts, categories, category groups, merchants, tags.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_cashflow_filtered_response import GetCashflowFilteredResponse
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
    api_instance = monarch_bridge_client.TransactionsApi(api_client)
    start = '2013-10-20' # date | Lower bound (inclusive), `YYYY-MM-DD`. (optional)
    end = '2013-10-20' # date | Upper bound (inclusive), `YYYY-MM-DD`. (optional)
    account_id = ['account_id_example'] # List[str] | Filter to one or more account ids (repeat the param). (optional)
    category_id = ['category_id_example'] # List[str] | Filter to one or more category ids. (optional)
    category_group_id = ['category_group_id_example'] # List[str] | Filter to one or more category-group ids. (optional)
    merchant_id = ['merchant_id_example'] # List[str] | Filter to one or more merchant ids. (optional)
    tag_id = ['tag_id_example'] # List[str] | Filter to one or more tag ids. (optional)

    try:
        # Filtered cashflow page (summary + four breakdowns)
        api_response = api_instance.get_cashflow_filtered(start=start, end=end, account_id=account_id, category_id=category_id, category_group_id=category_group_id, merchant_id=merchant_id, tag_id=tag_id)
        print("The response of TransactionsApi->get_cashflow_filtered:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TransactionsApi->get_cashflow_filtered: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **date**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 
 **end** | **date**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 
 **account_id** | [**List[str]**](str.md)| Filter to one or more account ids (repeat the param). | [optional] 
 **category_id** | [**List[str]**](str.md)| Filter to one or more category ids. | [optional] 
 **category_group_id** | [**List[str]**](str.md)| Filter to one or more category-group ids. | [optional] 
 **merchant_id** | [**List[str]**](str.md)| Filter to one or more merchant ids. | [optional] 
 **tag_id** | [**List[str]**](str.md)| Filter to one or more tag ids. | [optional] 

### Return type

[**GetCashflowFilteredResponse**](GetCashflowFilteredResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Summary + bucketed + entity-grouped cashflow. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_cashflow_timeframe**
> GetCashflowTimeframeResponse get_cashflow_timeframe(start=start, end=end)

Year / month / quarter cashflow summaries for a date window

Returns income, expense, savings, and savings-rate aggregated three
ways: by year, by month, by quarter. Good for "how does this year
compare to last" prompts.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_cashflow_timeframe_response import GetCashflowTimeframeResponse
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
    api_instance = monarch_bridge_client.TransactionsApi(api_client)
    start = '2013-10-20' # date | Lower bound (inclusive), `YYYY-MM-DD`. (optional)
    end = '2013-10-20' # date | Upper bound (inclusive), `YYYY-MM-DD`. (optional)

    try:
        # Year / month / quarter cashflow summaries for a date window
        api_response = api_instance.get_cashflow_timeframe(start=start, end=end)
        print("The response of TransactionsApi->get_cashflow_timeframe:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TransactionsApi->get_cashflow_timeframe: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **date**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 
 **end** | **date**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 

### Return type

[**GetCashflowTimeframeResponse**](GetCashflowTimeframeResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Timeframe summaries. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_download_transactions_session**
> GetDownloadTransactionsSessionResponse get_download_transactions_session(session_key)

Poll a transaction download session

Poll the async CSV download job started by `POST /v1/transactions/download`.
Returns the current `status` (running / completed / failed) and, when
completed, the signed `url` to fetch the CSV file from.

Poll cadence is up to the caller; typical clients re-check every
1-2 seconds until `url` is non-null.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_download_transactions_session_response import GetDownloadTransactionsSessionResponse
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
    api_instance = monarch_bridge_client.TransactionsApi(api_client)
    session_key = 'session_key_example' # str | Session key returned by `POST /v1/transactions/download`.

    try:
        # Poll a transaction download session
        api_response = api_instance.get_download_transactions_session(session_key)
        print("The response of TransactionsApi->get_download_transactions_session:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TransactionsApi->get_download_transactions_session: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **session_key** | **str**| Session key returned by &#x60;POST /v1/transactions/download&#x60;. | 

### Return type

[**GetDownloadTransactionsSessionResponse**](GetDownloadTransactionsSessionResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Current session state. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_review_summary_by_user**
> GetReviewSummaryByUserResponse get_review_summary_by_user()

Review-queue counts by household user

For each household member, how many transactions are currently flagged as
needing review. Empty list = nothing in the review queue.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_review_summary_by_user_response import GetReviewSummaryByUserResponse
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
    api_instance = monarch_bridge_client.TransactionsApi(api_client)

    try:
        # Review-queue counts by household user
        api_response = api_instance.get_review_summary_by_user()
        print("The response of TransactionsApi->get_review_summary_by_user:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TransactionsApi->get_review_summary_by_user: %s\n" % e)
```



### Parameters

This endpoint does not need any parameter.

### Return type

[**GetReviewSummaryByUserResponse**](GetReviewSummaryByUserResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Per-user review counts. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_spending_dashboard**
> GetSpendingDashboardResponse get_spending_dashboard(start=start, end=end)

Home-tab spending dashboard widget

Compact spending widget for the home tab: total spend for the
window, remaining budget, and the top spending categories.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_spending_dashboard_response import GetSpendingDashboardResponse
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
    api_instance = monarch_bridge_client.TransactionsApi(api_client)
    start = '2013-10-20' # date | Lower bound (inclusive), `YYYY-MM-DD`. (optional)
    end = '2013-10-20' # date | Upper bound (inclusive), `YYYY-MM-DD`. (optional)

    try:
        # Home-tab spending dashboard widget
        api_response = api_instance.get_spending_dashboard(start=start, end=end)
        print("The response of TransactionsApi->get_spending_dashboard:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TransactionsApi->get_spending_dashboard: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **date**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 
 **end** | **date**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 

### Return type

[**GetSpendingDashboardResponse**](GetSpendingDashboardResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Dashboard widget data. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_spending_trends**
> GetSpendingTrendsResponse get_spending_trends(timeframe=timeframe)

Spending trends (period-over-period)

Period-over-period spend trend: current vs. previous total plus
the top rising / falling categories by percent delta. Backs the
"Spending Trends" widget under Insights and the dashboard.

`timeframe` is `week`, `month`, or `quarter`. Each compares the
current period to the matching previous one.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_spending_trends_response import GetSpendingTrendsResponse
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
    api_instance = monarch_bridge_client.TransactionsApi(api_client)
    timeframe = month # str |  (optional) (default to month)

    try:
        # Spending trends (period-over-period)
        api_response = api_instance.get_spending_trends(timeframe=timeframe)
        print("The response of TransactionsApi->get_spending_trends:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TransactionsApi->get_spending_trends: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **timeframe** | **str**|  | [optional] [default to month]

### Return type

[**GetSpendingTrendsResponse**](GetSpendingTrendsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Current / previous totals + rising / falling categories. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_transaction_audit_log**
> GetTransactionAuditLogResponse get_transaction_audit_log(id)

Transaction audit log

History of changes against one transaction. Each entry has the
timestamp, actor, action, and old / new value for the field that
changed.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_transaction_audit_log_response import GetTransactionAuditLogResponse
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
    api_instance = monarch_bridge_client.TransactionsApi(api_client)
    id = 'id_example' # str | Monarch transaction id.

    try:
        # Transaction audit log
        api_response = api_instance.get_transaction_audit_log(id)
        print("The response of TransactionsApi->get_transaction_audit_log:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TransactionsApi->get_transaction_audit_log: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch transaction id. | 

### Return type

[**GetTransactionAuditLogResponse**](GetTransactionAuditLogResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Audit entries (oldest first). |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_transaction_detail**
> GetTransactionDetailResponse get_transaction_detail(id)

Single-transaction full detail

Returns the full denormalized tree for one transaction: amount,
date, merchant (with logo), category, account, notes, tags, splits
(if split), attachments, recurring-stream metadata, and review
state.

Use when surfacing a transaction in a detail view, or before a
PATCH to inspect current state. The list endpoint
`GET /v1/transactions` returns a leaner shape per row - this
endpoint is the right call when you need the full picture for one.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_transaction_detail_response import GetTransactionDetailResponse
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
    api_instance = monarch_bridge_client.TransactionsApi(api_client)
    id = 'id_example' # str | Monarch transaction id.

    try:
        # Single-transaction full detail
        api_response = api_instance.get_transaction_detail(id)
        print("The response of TransactionsApi->get_transaction_detail:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TransactionsApi->get_transaction_detail: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch transaction id. | 

### Return type

[**GetTransactionDetailResponse**](GetTransactionDetailResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Full transaction tree: splits, attachments, merchant, category. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_transaction_notes**
> GetTransactionNotesResponse get_transaction_notes(id)

Transaction notes

Standalone notes accessor for one transaction. Lighter than
`/v1/transactions/{id}` when you only need the notes string.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_transaction_notes_response import GetTransactionNotesResponse
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
    api_instance = monarch_bridge_client.TransactionsApi(api_client)
    id = 'id_example' # str | Monarch transaction id.

    try:
        # Transaction notes
        api_response = api_instance.get_transaction_notes(id)
        print("The response of TransactionsApi->get_transaction_notes:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TransactionsApi->get_transaction_notes: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch transaction id. | 

### Return type

[**GetTransactionNotesResponse**](GetTransactionNotesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Note value. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_transaction_split_templates**
> GetTransactionSplitTemplatesResponse get_transaction_split_templates()

Saved split templates

Saved reusable percent-based split definitions ("Costco run: 70%
Groceries / 30% Household"). The web split modal fires this to
populate the "Apply template" dropdown.

Each template carries a list of percent-of-parent splits. Caller
composes the actual `POST /v1/transactions/{id}/splits` request by
multiplying the parent amount by each `percent`.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_transaction_split_templates_response import GetTransactionSplitTemplatesResponse
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
    api_instance = monarch_bridge_client.TransactionsApi(api_client)

    try:
        # Saved split templates
        api_response = api_instance.get_transaction_split_templates()
        print("The response of TransactionsApi->get_transaction_split_templates:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TransactionsApi->get_transaction_split_templates: %s\n" % e)
```



### Parameters

This endpoint does not need any parameter.

### Return type

[**GetTransactionSplitTemplatesResponse**](GetTransactionSplitTemplatesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | All saved split templates. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_transaction_splits**
> GetTransactionSplitsResponse get_transaction_splits(id)

Splits of one transaction

Returns the child split rows of a parent transaction (e.g. a
$120 grocery run split into $90 groceries + $30 household). Each
split has its own amount, category, notes, and tags but inherits
the parent's date and account.

Returns an empty `splits` array when the transaction isn't split
(no error). The parent transaction summary is included on the
response for convenience.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_transaction_splits_response import GetTransactionSplitsResponse
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
    api_instance = monarch_bridge_client.TransactionsApi(api_client)
    id = 'id_example' # str | Monarch transaction id.

    try:
        # Splits of one transaction
        api_response = api_instance.get_transaction_splits(id)
        print("The response of TransactionsApi->get_transaction_splits:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TransactionsApi->get_transaction_splits: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch transaction id. | 

### Return type

[**GetTransactionSplitsResponse**](GetTransactionSplitsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Splits + parent transaction summary. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_transactions_dashboard**
> GetTransactionsDashboardResponse get_transactions_dashboard(start=start, end=end, limit=limit, offset=offset)

Dashboard transactions list (with totals + rule count)

Returns transaction rows scoped to a date window plus pagination,
along with a totalCount, totalSelectableCount, and a rule-count
sidecar. Lightweight shape suitable for dashboard widgets.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_transactions_dashboard_response import GetTransactionsDashboardResponse
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
    api_instance = monarch_bridge_client.TransactionsApi(api_client)
    start = '2013-10-20' # date | Lower bound (inclusive), `YYYY-MM-DD`. (optional)
    end = '2013-10-20' # date | Upper bound (inclusive), `YYYY-MM-DD`. (optional)
    limit = 56 # int | Page size. (optional)
    offset = 56 # int | Page offset. (optional)

    try:
        # Dashboard transactions list (with totals + rule count)
        api_response = api_instance.get_transactions_dashboard(start=start, end=end, limit=limit, offset=offset)
        print("The response of TransactionsApi->get_transactions_dashboard:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TransactionsApi->get_transactions_dashboard: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **date**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 
 **end** | **date**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 
 **limit** | **int**| Page size. | [optional] 
 **offset** | **int**| Page offset. | [optional] 

### Return type

[**GetTransactionsDashboardResponse**](GetTransactionsDashboardResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Paginated transactions with totals. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_transactions_duplicates**
> GetTransactionsDuplicatesResponse get_transactions_duplicates(start=start, end=end, account_id=account_id, account_ids=account_ids)

Groups of likely-duplicate transactions

Server-side composite over `GET /v1/transactions`. Pulls the window and groups
results by the python-lib `find_duplicate_transactions` key:
`(date, amount, plaidName, accountId)`.

Using `plaidName` (the raw Plaid description) rather than `merchantName`
(Monarch's normalized display name) avoids false positives: two genuine
same-day same-merchant same-amount charges carry different `plaidName`
reference strings. Only true double-inserts share the exact `plaidName`.

Returns only groups with size > 1. Useful for surfacing accidental
double-posts after re-linking an institution (a known Monarch issue,
particularly for Apple Card / Apple Cash / Apple Savings).


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_transactions_duplicates_response import GetTransactionsDuplicatesResponse
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
    api_instance = monarch_bridge_client.TransactionsApi(api_client)
    start = '2013-10-20' # date | Lower bound (inclusive), `YYYY-MM-DD`. (optional)
    end = '2013-10-20' # date | Upper bound (inclusive), `YYYY-MM-DD`. (optional)
    account_id = 'account_id_example' # str | Filter by a single Monarch account id. (optional)
    account_ids = ['account_ids_example'] # List[str] | Filter to multiple accounts. Merged with the legacy single-value `accountId` if both are passed.  (optional)

    try:
        # Groups of likely-duplicate transactions
        api_response = api_instance.get_transactions_duplicates(start=start, end=end, account_id=account_id, account_ids=account_ids)
        print("The response of TransactionsApi->get_transactions_duplicates:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TransactionsApi->get_transactions_duplicates: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **date**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 
 **end** | **date**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 
 **account_id** | **str**| Filter by a single Monarch account id. | [optional] 
 **account_ids** | [**List[str]**](str.md)| Filter to multiple accounts. Merged with the legacy single-value &#x60;accountId&#x60; if both are passed.  | [optional] 

### Return type

[**GetTransactionsDuplicatesResponse**](GetTransactionsDuplicatesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Groups of likely-duplicate transactions in the window. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_transactions_summary**
> GetTransactionsSummaryResponse get_transactions_summary(start=start, end=end, account_id=account_id, account_ids=account_ids, category_ids=category_ids, tag_ids=tag_ids, search=search, has_attachments=has_attachments, has_notes=has_notes, hide_from_reports=hide_from_reports, is_split=is_split, is_recurring=is_recurring, imported_from_mint=imported_from_mint, synced_from_institution=synced_from_institution, needs_review=needs_review, transaction_visibility=transaction_visibility)

Aggregate stats across a transaction window

Returns one summary row over the filtered transaction set:
`count`, `sum`, `avg`, `min`, `max`, `first`, `last`. Useful for
one-shot questions like "how many Whole Foods runs this year" or
"what's my average dining check" without pulling the full
transaction list.

All standard transaction filters apply (`search`, `categoryIds`,
`accountIds`, `tagIds`, bool flags). For per-category breakdowns
use `GET /v1/cashflow/breakdown`. For row-level data use
`GET /v1/transactions`.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_transactions_summary_response import GetTransactionsSummaryResponse
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
    api_instance = monarch_bridge_client.TransactionsApi(api_client)
    start = '2013-10-20' # date | Lower bound (inclusive), `YYYY-MM-DD`. (optional)
    end = '2013-10-20' # date | Upper bound (inclusive), `YYYY-MM-DD`. (optional)
    account_id = 'account_id_example' # str | Filter by a single Monarch account id. (optional)
    account_ids = ['account_ids_example'] # List[str] | Filter by one or more Monarch account ids. Repeat the query param for each. Preferred over the legacy single `accountId` param; both are accepted and merged.  (optional)
    category_ids = ['category_ids_example'] # List[str] | Filter by one or more Monarch category ids. Repeat the query param for each. (optional)
    tag_ids = ['tag_ids_example'] # List[str] | Filter by one or more transaction tag ids. Repeat the query param for each. (optional)
    search = 'search_example' # str | Free-text search against merchant / notes / category. (optional)
    has_attachments = True # bool | When set, restrict to transactions that do or do not have attachments. Omit for either. (optional)
    has_notes = True # bool | When set, restrict to transactions that do or do not have notes. Omit for either. (optional)
    hide_from_reports = True # bool | When set, restrict to transactions that are or are not hidden from reports. Omit for either. (optional)
    is_split = True # bool | When set, restrict to split or non-split transactions. Omit for either. (optional)
    is_recurring = True # bool | When set, restrict to recurring or non-recurring transactions. Omit for either. (optional)
    imported_from_mint = True # bool | When set, restrict to transactions imported from Mint or not. Omit for either. (optional)
    synced_from_institution = True # bool | When set, restrict to transactions synced from the institution feed or not. Omit for either. (optional)
    needs_review = True # bool | When set, restrict to transactions that need review or do not. Omit for either. (optional)
    transaction_visibility = 'transaction_visibility_example' # str | Scope of transactions to return. Omit (default) for non-hidden only. `hidden_transactions_only` returns only hidden; `all_transactions` returns both.  (optional)

    try:
        # Aggregate stats across a transaction window
        api_response = api_instance.get_transactions_summary(start=start, end=end, account_id=account_id, account_ids=account_ids, category_ids=category_ids, tag_ids=tag_ids, search=search, has_attachments=has_attachments, has_notes=has_notes, hide_from_reports=hide_from_reports, is_split=is_split, is_recurring=is_recurring, imported_from_mint=imported_from_mint, synced_from_institution=synced_from_institution, needs_review=needs_review, transaction_visibility=transaction_visibility)
        print("The response of TransactionsApi->get_transactions_summary:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TransactionsApi->get_transactions_summary: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **date**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 
 **end** | **date**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 
 **account_id** | **str**| Filter by a single Monarch account id. | [optional] 
 **account_ids** | [**List[str]**](str.md)| Filter by one or more Monarch account ids. Repeat the query param for each. Preferred over the legacy single &#x60;accountId&#x60; param; both are accepted and merged.  | [optional] 
 **category_ids** | [**List[str]**](str.md)| Filter by one or more Monarch category ids. Repeat the query param for each. | [optional] 
 **tag_ids** | [**List[str]**](str.md)| Filter by one or more transaction tag ids. Repeat the query param for each. | [optional] 
 **search** | **str**| Free-text search against merchant / notes / category. | [optional] 
 **has_attachments** | **bool**| When set, restrict to transactions that do or do not have attachments. Omit for either. | [optional] 
 **has_notes** | **bool**| When set, restrict to transactions that do or do not have notes. Omit for either. | [optional] 
 **hide_from_reports** | **bool**| When set, restrict to transactions that are or are not hidden from reports. Omit for either. | [optional] 
 **is_split** | **bool**| When set, restrict to split or non-split transactions. Omit for either. | [optional] 
 **is_recurring** | **bool**| When set, restrict to recurring or non-recurring transactions. Omit for either. | [optional] 
 **imported_from_mint** | **bool**| When set, restrict to transactions imported from Mint or not. Omit for either. | [optional] 
 **synced_from_institution** | **bool**| When set, restrict to transactions synced from the institution feed or not. Omit for either. | [optional] 
 **needs_review** | **bool**| When set, restrict to transactions that need review or do not. Omit for either. | [optional] 
 **transaction_visibility** | **str**| Scope of transactions to return. Omit (default) for non-hidden only. &#x60;hidden_transactions_only&#x60; returns only hidden; &#x60;all_transactions&#x60; returns both.  | [optional] 

### Return type

[**GetTransactionsSummaryResponse**](GetTransactionsSummaryResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | count / sum / avg / min-max / first-last. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_transactions**
> ListTransactionsResponse list_transactions(start=start, end=end, limit=limit, offset=offset, account_id=account_id, account_ids=account_ids, category_ids=category_ids, tag_ids=tag_ids, order_by=order_by, search=search, has_attachments=has_attachments, has_notes=has_notes, hide_from_reports=hide_from_reports, is_split=is_split, is_recurring=is_recurring, imported_from_mint=imported_from_mint, synced_from_institution=synced_from_institution, needs_review=needs_review, transaction_visibility=transaction_visibility)

Search and list transactions with rich filtering

Returns transactions matching the filter set, **newest-first** within
`[start, end]`. Use the `search` param for free-text search across
merchant + notes + plaid name. Combine with `categoryIds`,
`accountIds`, `tagIds` (all multi) to scope.

Date semantics: `start` is the **oldest allowed date**, NOT "scroll
forward from here". `?start=2026-01-01&limit=10` returns the 10
newest txns on or after Jan 2026 (probably this week). To get January
specifically: `?start=2026-01-01&end=2026-01-31`. To get older rows,
bound `end` earlier or paginate with `offset`.

Bool filters (`hasAttachments`, `isRecurring`, `hideFromReports`,
`needsReview`, etc.) accept true/false; omit to not filter on that
dimension. Returns the page plus `totalCount` for the filter set.
For aggregate stats over the same filter use
`GET /v1/transactions/summary`; for the single-row detail use
`GET /v1/transactions/{id}`.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.list_transactions_response import ListTransactionsResponse
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
    api_instance = monarch_bridge_client.TransactionsApi(api_client)
    start = '2013-10-20' # date | Lower bound (inclusive), `YYYY-MM-DD`. (optional)
    end = '2013-10-20' # date | Upper bound (inclusive), `YYYY-MM-DD`. (optional)
    limit = 56 # int | Page size. (optional)
    offset = 56 # int | Page offset. (optional)
    account_id = 'account_id_example' # str | Filter by a single Monarch account id. (optional)
    account_ids = ['account_ids_example'] # List[str] | Filter by one or more Monarch account ids. Repeat the query param for each. Preferred over the legacy single `accountId` param; both are accepted and merged.  (optional)
    category_ids = ['category_ids_example'] # List[str] | Filter by one or more Monarch category ids. Repeat the query param for each. (optional)
    tag_ids = ['tag_ids_example'] # List[str] | Filter by one or more transaction tag ids. Repeat the query param for each. (optional)
    order_by = 'order_by_example' # str | Monarch sort enum. Both values sort descending. (optional)
    search = 'search_example' # str | Free-text search against merchant / notes / category. (optional)
    has_attachments = True # bool | When set, restrict to transactions that do or do not have attachments. Omit for either. (optional)
    has_notes = True # bool | When set, restrict to transactions that do or do not have notes. Omit for either. (optional)
    hide_from_reports = True # bool | When set, restrict to transactions that are or are not hidden from reports. Omit for either. (optional)
    is_split = True # bool | When set, restrict to split or non-split transactions. Omit for either. (optional)
    is_recurring = True # bool | When set, restrict to recurring or non-recurring transactions. Omit for either. (optional)
    imported_from_mint = True # bool | When set, restrict to transactions imported from Mint or not. Omit for either. (optional)
    synced_from_institution = True # bool | When set, restrict to transactions synced from the institution feed or not. Omit for either. (optional)
    needs_review = True # bool | When set, restrict to transactions that need review or do not. Omit for either. (optional)
    transaction_visibility = 'transaction_visibility_example' # str | Scope of transactions to return. Omit (default) for non-hidden only. `hidden_transactions_only` returns only hidden; `all_transactions` returns both.  (optional)

    try:
        # Search and list transactions with rich filtering
        api_response = api_instance.list_transactions(start=start, end=end, limit=limit, offset=offset, account_id=account_id, account_ids=account_ids, category_ids=category_ids, tag_ids=tag_ids, order_by=order_by, search=search, has_attachments=has_attachments, has_notes=has_notes, hide_from_reports=hide_from_reports, is_split=is_split, is_recurring=is_recurring, imported_from_mint=imported_from_mint, synced_from_institution=synced_from_institution, needs_review=needs_review, transaction_visibility=transaction_visibility)
        print("The response of TransactionsApi->list_transactions:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TransactionsApi->list_transactions: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **date**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 
 **end** | **date**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 
 **limit** | **int**| Page size. | [optional] 
 **offset** | **int**| Page offset. | [optional] 
 **account_id** | **str**| Filter by a single Monarch account id. | [optional] 
 **account_ids** | [**List[str]**](str.md)| Filter by one or more Monarch account ids. Repeat the query param for each. Preferred over the legacy single &#x60;accountId&#x60; param; both are accepted and merged.  | [optional] 
 **category_ids** | [**List[str]**](str.md)| Filter by one or more Monarch category ids. Repeat the query param for each. | [optional] 
 **tag_ids** | [**List[str]**](str.md)| Filter by one or more transaction tag ids. Repeat the query param for each. | [optional] 
 **order_by** | **str**| Monarch sort enum. Both values sort descending. | [optional] 
 **search** | **str**| Free-text search against merchant / notes / category. | [optional] 
 **has_attachments** | **bool**| When set, restrict to transactions that do or do not have attachments. Omit for either. | [optional] 
 **has_notes** | **bool**| When set, restrict to transactions that do or do not have notes. Omit for either. | [optional] 
 **hide_from_reports** | **bool**| When set, restrict to transactions that are or are not hidden from reports. Omit for either. | [optional] 
 **is_split** | **bool**| When set, restrict to split or non-split transactions. Omit for either. | [optional] 
 **is_recurring** | **bool**| When set, restrict to recurring or non-recurring transactions. Omit for either. | [optional] 
 **imported_from_mint** | **bool**| When set, restrict to transactions imported from Mint or not. Omit for either. | [optional] 
 **synced_from_institution** | **bool**| When set, restrict to transactions synced from the institution feed or not. Omit for either. | [optional] 
 **needs_review** | **bool**| When set, restrict to transactions that need review or do not. Omit for either. | [optional] 
 **transaction_visibility** | **str**| Scope of transactions to return. Omit (default) for non-hidden only. &#x60;hidden_transactions_only&#x60; returns only hidden; &#x60;all_transactions&#x60; returns both.  | [optional] 

### Return type

[**ListTransactionsResponse**](ListTransactionsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Page of transactions + totalCount. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mark_as_recurring**
> MarkAsRecurringResponse mark_as_recurring(id, mark_as_recurring_request)

Mark a transaction as the start of a recurring stream

The inverse of `POST /v1/transactions/{id}/not-recurring`. Tells
Monarch the transaction IS the first instance of a recurring stream
at the given `frequency` (`monthly`, `weekly`, `quarterly`, `yearly`,
`biweekly`). Monarch creates the stream definition and returns its id.

Use to teach Monarch a stream it missed (a new subscription, a
private-vendor recurring invoice).


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.mark_as_recurring_response import MarkAsRecurringResponse
from monarch_bridge_client.models.mark_as_recurring_request import MarkAsRecurringRequest
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
    api_instance = monarch_bridge_client.TransactionsApi(api_client)
    id = 'id_example' # str | Monarch transaction id.
    mark_as_recurring_request = monarch_bridge_client.MarkAsRecurringRequest() # MarkAsRecurringRequest | 

    try:
        # Mark a transaction as the start of a recurring stream
        api_response = api_instance.mark_as_recurring(id, mark_as_recurring_request)
        print("The response of TransactionsApi->mark_as_recurring:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TransactionsApi->mark_as_recurring: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch transaction id. | 
 **mark_as_recurring_request** | [**MarkAsRecurringRequest**](MarkAsRecurringRequest.md)|  | 

### Return type

[**MarkAsRecurringResponse**](MarkAsRecurringResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Confirmation + the new stream ref. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mark_transaction_as_reviewed**
> MarkTransactionAsReviewedResponse mark_transaction_as_reviewed(id)

Mark a transaction as reviewed

Single-shot helper: sets `reviewed=true` on one transaction. Equivalent to
`PATCH /v1/transactions/{id}` with `{"reviewed": true}` but smaller in input
(no body required) and output (only `id`, `reviewedAt`, `needsReview`).

Use from review/triage flows where the assistant just needs to dispatch a
mark-as-reviewed without rewriting the whole transaction tree.

To un-mark, send `PATCH /v1/transactions/{id}` with `{"reviewed": false}`.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.mark_transaction_as_reviewed_response import MarkTransactionAsReviewedResponse
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
    api_instance = monarch_bridge_client.TransactionsApi(api_client)
    id = 'id_example' # str | Monarch transaction id.

    try:
        # Mark a transaction as reviewed
        api_response = api_instance.mark_transaction_as_reviewed(id)
        print("The response of TransactionsApi->mark_transaction_as_reviewed:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TransactionsApi->mark_transaction_as_reviewed: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch transaction id. | 

### Return type

[**MarkTransactionAsReviewedResponse**](MarkTransactionAsReviewedResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Updated review-state fields. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **mark_transaction_stream_as_not_recurring**
> MarkTransactionStreamAsNotRecurringResponse mark_transaction_stream_as_not_recurring(id)

Mark a transaction's recurring-stream as not-recurring

Tells Monarch that the recurring stream a transaction is attached to is NOT actually
recurring. Used to dismiss false-positive recurrence detections.

Important: Monarch's mutation takes a `streamId`, NOT a transaction id. Pass the
transaction's `stream.id` (visible on the transaction detail) as the path `{id}`.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.mark_transaction_stream_as_not_recurring_response import MarkTransactionStreamAsNotRecurringResponse
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
    api_instance = monarch_bridge_client.TransactionsApi(api_client)
    id = 'id_example' # str | Monarch transaction id.

    try:
        # Mark a transaction's recurring-stream as not-recurring
        api_response = api_instance.mark_transaction_stream_as_not_recurring(id)
        print("The response of TransactionsApi->mark_transaction_stream_as_not_recurring:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TransactionsApi->mark_transaction_stream_as_not_recurring: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch transaction id. | 

### Return type

[**MarkTransactionStreamAsNotRecurringResponse**](MarkTransactionStreamAsNotRecurringResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Confirmation flag from Monarch. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **match_search_transactions**
> MatchSearchTransactionsResponse match_search_transactions(search=search, limit=limit)

Fuzzy transaction search for \"find a match\"

Free-text transaction lookup powering the web "find a match" picker
(used in split, link-to-goal, and recurring-merge flows). Returns a
lean shape per row: id, amount, date, plaid name, merchant + account
references.

Different from the canonical `GET /v1/transactions` in two ways: only
the `search` filter is supported, and the result shape is the slim
picker shape rather than the full transaction row.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.match_search_transactions_response import MatchSearchTransactionsResponse
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
    api_instance = monarch_bridge_client.TransactionsApi(api_client)
    search = 'search_example' # str | Free-text query against merchant + plaid name. (optional)
    limit = 20 # int | Max results. (optional) (default to 20)

    try:
        # Fuzzy transaction search for \"find a match\"
        api_response = api_instance.match_search_transactions(search=search, limit=limit)
        print("The response of TransactionsApi->match_search_transactions:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TransactionsApi->match_search_transactions: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **search** | **str**| Free-text query against merchant + plaid name. | [optional] 
 **limit** | **int**| Max results. | [optional] [default to 20]

### Return type

[**MatchSearchTransactionsResponse**](MatchSearchTransactionsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Match candidates. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **move_transactions**
> MoveTransactionsResponse move_transactions(move_transactions_request)

Move transactions between accounts

Reassign one or more transactions from their current account to a
target account. Use when reconciling a mis-categorized import (e.g.
Plaid bucketed a charge under the wrong account) or after a manual
merge.

Returns the count of transactions Monarch actually moved, plus a
flat error array (one message per failed transaction).


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.move_transactions_response import MoveTransactionsResponse
from monarch_bridge_client.models.move_transactions_request import MoveTransactionsRequest
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
    api_instance = monarch_bridge_client.TransactionsApi(api_client)
    move_transactions_request = monarch_bridge_client.MoveTransactionsRequest() # MoveTransactionsRequest | 

    try:
        # Move transactions between accounts
        api_response = api_instance.move_transactions(move_transactions_request)
        print("The response of TransactionsApi->move_transactions:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TransactionsApi->move_transactions: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **move_transactions_request** | [**MoveTransactionsRequest**](MoveTransactionsRequest.md)|  | 

### Return type

[**MoveTransactionsResponse**](MoveTransactionsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Move result. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **set_transaction_tags**
> SetTransactionTagsResponse set_transaction_tags(id, set_transaction_tags_request)

Overwrite the tag set on a transaction

Wholesale-replaces every tag on a transaction. Send the complete
final tag id list - this is NOT a delta. To add a tag without
losing the existing ones, read current tags first via
`GET /v1/transactions/{id}` then PUT the merged list.

Empty list `[]` clears all tags. Tag ids come from
`GET /v1/tags`. For bulk tag changes across many transactions use
`PATCH /v1/transactions/bulk`.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.set_transaction_tags_response import SetTransactionTagsResponse
from monarch_bridge_client.models.set_transaction_tags_request import SetTransactionTagsRequest
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
    api_instance = monarch_bridge_client.TransactionsApi(api_client)
    id = 'id_example' # str | Monarch transaction id.
    set_transaction_tags_request = monarch_bridge_client.SetTransactionTagsRequest() # SetTransactionTagsRequest | 

    try:
        # Overwrite the tag set on a transaction
        api_response = api_instance.set_transaction_tags(id, set_transaction_tags_request)
        print("The response of TransactionsApi->set_transaction_tags:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TransactionsApi->set_transaction_tags: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch transaction id. | 
 **set_transaction_tags_request** | [**SetTransactionTagsRequest**](SetTransactionTagsRequest.md)|  | 

### Return type

[**SetTransactionTagsResponse**](SetTransactionTagsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Tag set after the overwrite. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **start_download_transactions**
> StartDownloadTransactionsResponse start_download_transactions(start_download_transactions_request)

Start a transaction CSV download session

Kick off the async "download my transactions as CSV" job Monarch
backs the Web download button with. Returns a `sessionKey` to poll
via `GET /v1/transactions/download/{sessionKey}` until the CSV `url`
is ready.

Filters mirror `GET /v1/transactions`: pass a JSON map under
`filters` (search string, categoryIds, accountIds, date window).


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.start_download_transactions_response import StartDownloadTransactionsResponse
from monarch_bridge_client.models.start_download_transactions_request import StartDownloadTransactionsRequest
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
    api_instance = monarch_bridge_client.TransactionsApi(api_client)
    start_download_transactions_request = monarch_bridge_client.StartDownloadTransactionsRequest() # StartDownloadTransactionsRequest | 

    try:
        # Start a transaction CSV download session
        api_response = api_instance.start_download_transactions(start_download_transactions_request)
        print("The response of TransactionsApi->start_download_transactions:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TransactionsApi->start_download_transactions: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start_download_transactions_request** | [**StartDownloadTransactionsRequest**](StartDownloadTransactionsRequest.md)|  | 

### Return type

[**StartDownloadTransactionsResponse**](StartDownloadTransactionsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Session key + initial status. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_transaction**
> UpdateTransactionResponse update_transaction(id, update_transaction_request)

Partial-update a transaction

Patches one transaction. Only fields present in the body are
forwarded to Monarch; omit a field to leave it untouched.

Common edits: `categoryId` (re-categorize), `merchantName` (rename
via the override), `notes`, `date`, `amount` (manual accounts only -
Plaid will overwrite on next sync), `hideFromReports`, `needsReview`.

For tag mutations use `PUT /v1/transactions/{id}/tags` instead -
tags are stored separately. For wholesale edits across many
transactions use `PATCH /v1/transactions/bulk`.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.update_transaction_response import UpdateTransactionResponse
from monarch_bridge_client.models.update_transaction_request import UpdateTransactionRequest
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
    api_instance = monarch_bridge_client.TransactionsApi(api_client)
    id = 'id_example' # str | Monarch transaction id.
    update_transaction_request = monarch_bridge_client.UpdateTransactionRequest() # UpdateTransactionRequest | 

    try:
        # Partial-update a transaction
        api_response = api_instance.update_transaction(id, update_transaction_request)
        print("The response of TransactionsApi->update_transaction:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TransactionsApi->update_transaction: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch transaction id. | 
 **update_transaction_request** | [**UpdateTransactionRequest**](UpdateTransactionRequest.md)|  | 

### Return type

[**UpdateTransactionResponse**](UpdateTransactionResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Updated transaction. |  -  |
**400** | Validation failed. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_transaction_splits**
> UpdateTransactionSplitsResponse update_transaction_splits(id, update_transaction_splits_request)

Replace the splits on a transaction

Wholesale-replaces the split set on a transaction. Send the
complete new list - this is NOT a delta operation. Each split needs
`amount` (signed, same sign as the parent) plus `categoryId` and
optional `notes` / `merchantName`.

Sum of split amounts must equal the parent transaction's amount
exactly - Monarch rejects with 422 PayloadError on any mismatch.
Send an empty list to remove all splits and revert the transaction
to a single-row entry.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.update_transaction_splits_response import UpdateTransactionSplitsResponse
from monarch_bridge_client.models.update_transaction_splits_request import UpdateTransactionSplitsRequest
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
    api_instance = monarch_bridge_client.TransactionsApi(api_client)
    id = 'id_example' # str | Monarch transaction id.
    update_transaction_splits_request = monarch_bridge_client.UpdateTransactionSplitsRequest() # UpdateTransactionSplitsRequest | 

    try:
        # Replace the splits on a transaction
        api_response = api_instance.update_transaction_splits(id, update_transaction_splits_request)
        print("The response of TransactionsApi->update_transaction_splits:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TransactionsApi->update_transaction_splits: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch transaction id. | 
 **update_transaction_splits_request** | [**UpdateTransactionSplitsRequest**](UpdateTransactionSplitsRequest.md)|  | 

### Return type

[**UpdateTransactionSplitsResponse**](UpdateTransactionSplitsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | New split set. |  -  |
**422** | Sum mismatch or other PayloadError. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **upload_transaction_attachment**
> UploadTransactionAttachmentResponse upload_transaction_attachment(id, file)

Attach a receipt photo or PDF to a transaction

Three-step flow handled internally by the proxy: (1) asks Monarch for signed
Cloudinary upload params, (2) forwards the file to Cloudinary, (3) tells
Monarch to link the upload to the transaction. Caller sees a single
multipart/form-data POST with the file.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.upload_transaction_attachment_response import UploadTransactionAttachmentResponse
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
    api_instance = monarch_bridge_client.TransactionsApi(api_client)
    id = 'id_example' # str | Monarch transaction id.
    file = None # bytearray | Receipt photo, scan, or PDF.

    try:
        # Attach a receipt photo or PDF to a transaction
        api_response = api_instance.upload_transaction_attachment(id, file)
        print("The response of TransactionsApi->upload_transaction_attachment:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TransactionsApi->upload_transaction_attachment: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch transaction id. | 
 **file** | **bytearray**| Receipt photo, scan, or PDF. | 

### Return type

[**UploadTransactionAttachmentResponse**](UploadTransactionAttachmentResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The created attachment. |  -  |
**422** | Monarch rejected the upload (PayloadError). |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

