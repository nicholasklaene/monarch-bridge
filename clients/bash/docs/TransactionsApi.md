# TransactionsApi

All URIs are relative to **

Method | HTTP request | Description
------------- | ------------- | -------------
[**bulkDeleteTransactions**](TransactionsApi.md#bulkDeleteTransactions) | **POST** /v1/transactions/bulk-delete | Bulk-delete transactions
[**bulkUpdateTransactions**](TransactionsApi.md#bulkUpdateTransactions) | **PATCH** /v1/transactions/bulk | Bulk-update transactions
[**createTransaction**](TransactionsApi.md#createTransaction) | **POST** /v1/transactions | Create a manual transaction
[**deleteTransaction**](TransactionsApi.md#deleteTransaction) | **DELETE** /v1/transactions/{id} | Delete a transaction
[**explainTransaction**](TransactionsApi.md#explainTransaction) | **GET** /v1/transactions/explain/{id} | AI explanation for one transaction
[**explainTransactionByPath**](TransactionsApi.md#explainTransactionByPath) | **GET** /v1/transactions/{id}/explain | AI explanation for one transaction
[**getAccountsForTransactionFilter**](TransactionsApi.md#getAccountsForTransactionFilter) | **GET** /v1/transactions/accounts-for-filter | Accounts that match a transaction filter
[**getAttachment**](TransactionsApi.md#getAttachment) | **GET** /v1/attachments/{id} | Attachment detail
[**getCashflow**](TransactionsApi.md#getCashflow) | **GET** /v1/cashflow | Income, expense, and savings summary for a window
[**getCashflowBreakdown**](TransactionsApi.md#getCashflowBreakdown) | **GET** /v1/cashflow/breakdown | Cashflow broken down by category, group, merchant
[**getCashflowDashboard**](TransactionsApi.md#getCashflowDashboard) | **GET** /v1/cashflow/dashboard | Day-by-day expense series for a date window
[**getCashflowEntities**](TransactionsApi.md#getCashflowEntities) | **GET** /v1/cashflow/entities | Cashflow by category / category-group / merchant
[**getCashflowFiltered**](TransactionsApi.md#getCashflowFiltered) | **GET** /v1/cashflow/filtered | Filtered cashflow page (summary + four breakdowns)
[**getCashflowTimeframe**](TransactionsApi.md#getCashflowTimeframe) | **GET** /v1/cashflow/timeframe | Year / month / quarter cashflow summaries for a date window
[**getDownloadTransactionsSession**](TransactionsApi.md#getDownloadTransactionsSession) | **GET** /v1/transactions/download/{sessionKey} | Poll a transaction download session
[**getReviewSummaryByUser**](TransactionsApi.md#getReviewSummaryByUser) | **GET** /v1/transactions/review-summary | Review-queue counts by household user
[**getSpendingDashboard**](TransactionsApi.md#getSpendingDashboard) | **GET** /v1/dashboard/spending | Home-tab spending dashboard widget
[**getSpendingTrends**](TransactionsApi.md#getSpendingTrends) | **GET** /v1/dashboard/spending/trends | Spending trends (period-over-period)
[**getTransactionAuditLog**](TransactionsApi.md#getTransactionAuditLog) | **GET** /v1/transactions/{id}/audit | Transaction audit log
[**getTransactionDetail**](TransactionsApi.md#getTransactionDetail) | **GET** /v1/transactions/{id} | Single-transaction full detail
[**getTransactionNotes**](TransactionsApi.md#getTransactionNotes) | **GET** /v1/transactions/{id}/notes | Transaction notes
[**getTransactionSplitTemplates**](TransactionsApi.md#getTransactionSplitTemplates) | **GET** /v1/transactions/split-templates | Saved split templates
[**getTransactionSplits**](TransactionsApi.md#getTransactionSplits) | **GET** /v1/transactions/{id}/splits | Splits of one transaction
[**getTransactionsDashboard**](TransactionsApi.md#getTransactionsDashboard) | **GET** /v1/transactions/dashboard | Dashboard transactions list (with totals + rule count)
[**getTransactionsDuplicates**](TransactionsApi.md#getTransactionsDuplicates) | **GET** /v1/transactions/duplicates | Groups of likely-duplicate transactions
[**getTransactionsSummary**](TransactionsApi.md#getTransactionsSummary) | **GET** /v1/transactions/summary | Aggregate stats across a transaction window
[**listTransactions**](TransactionsApi.md#listTransactions) | **GET** /v1/transactions | Search and list transactions with rich filtering
[**markAsRecurring**](TransactionsApi.md#markAsRecurring) | **POST** /v1/transactions/{id}/recurring | Mark a transaction as the start of a recurring stream
[**markTransactionAsReviewed**](TransactionsApi.md#markTransactionAsReviewed) | **POST** /v1/transactions/{id}/reviewed | Mark a transaction as reviewed
[**markTransactionStreamAsNotRecurring**](TransactionsApi.md#markTransactionStreamAsNotRecurring) | **POST** /v1/transactions/{id}/not-recurring | Mark a transaction&#39;s recurring-stream as not-recurring
[**matchSearchTransactions**](TransactionsApi.md#matchSearchTransactions) | **GET** /v1/transactions/match-search | Fuzzy transaction search for \&quot;find a match\&quot;
[**moveTransactions**](TransactionsApi.md#moveTransactions) | **POST** /v1/transactions/move | Move transactions between accounts
[**setTransactionTags**](TransactionsApi.md#setTransactionTags) | **PUT** /v1/transactions/{id}/tags | Overwrite the tag set on a transaction
[**startDownloadTransactions**](TransactionsApi.md#startDownloadTransactions) | **POST** /v1/transactions/download | Start a transaction CSV download session
[**updateTransaction**](TransactionsApi.md#updateTransaction) | **PATCH** /v1/transactions/{id} | Partial-update a transaction
[**updateTransactionSplits**](TransactionsApi.md#updateTransactionSplits) | **POST** /v1/transactions/{id}/splits | Replace the splits on a transaction
[**uploadTransactionAttachment**](TransactionsApi.md#uploadTransactionAttachment) | **POST** /v1/transactions/{id}/attachments | Attach a receipt photo or PDF to a transaction



## bulkDeleteTransactions

Bulk-delete transactions

Forwards Monarch's 'bulkDeleteTransactions' mutation. Same two-mode selection as
bulk-update:

- 'allSelected: false' + 'selectedTransactionIds: [a,b,c]' to delete exactly N.
- 'allSelected: true' + 'filters: {...}' + optional 'excludedTransactionIds: [...]'
  to delete everything matching minus a hand-picked exclusion list.

'expectedAffectedTransactionCount' is the same race-prevention guard as bulk-update.
Destructive: prefer 'tx duplicates' first to scope the selection.

### Example

```bash
monarch-api bulkDeleteTransactions
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **bulkDeleteTransactionsRequest** | [**BulkDeleteTransactionsRequest**](BulkDeleteTransactionsRequest.md) |  |

### Return type

[**BulkDeleteTransactions200Response**](BulkDeleteTransactions200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## bulkUpdateTransactions

Bulk-update transactions

Forwards Monarch's 'bulkUpdateTransactions' mutation. Two selection modes are
supported on the same shape ('allSelected' discriminates):

- 'allSelected: false' + 'selectedTransactionIds: [a,b,c]' is the common case:
  apply 'updates' to exactly those N transactions.
- 'allSelected: true' + 'filters: {...}' + optional 'excludedTransactionIds: [...]'
  is the \"select everything matching the filter then minus these\" pattern.

'expectedAffectedTransactionCount' is a safety check. Monarch refuses the mutation
if its actual affected-row count differs from this number (race-prevention).

The 'updates' object is Monarch's 'TransactionUpdateParams' input shape (same
field surface as 'PATCH /v1/transactions/{id}': categoryId, merchantName, notes,
date, hide, etc.).

### Example

```bash
monarch-api bulkUpdateTransactions
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **bulkUpdateTransactionsRequest** | [**BulkUpdateTransactionsRequest**](BulkUpdateTransactionsRequest.md) |  |

### Return type

[**BulkUpdateTransactions200Response**](BulkUpdateTransactions200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## createTransaction

Create a manual transaction

Adds a transaction by hand into a specific account. Typically used
for cash spending, manually-tracked accounts, or to record an
item Plaid missed.

Required: 'accountId', 'date', 'amount' (signed: negative for
spending, positive for income/refund), and 'merchantName'. Optional:
'categoryId', 'notes', 'hideFromReports'. Skips Monarch's auto-
categorization rule pass - the new transaction lands with exactly
the category you supplied (or uncategorized).

For receipt attachment use 'POST /v1/transactions/{id}/attachment'
after the create. PayloadError yields 422 on Monarch-side rejection.

### Example

```bash
monarch-api createTransaction
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createTransactionRequest** | [**CreateTransactionRequest**](CreateTransactionRequest.md) |  |

### Return type

[**CreateTransaction200Response**](CreateTransaction200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## deleteTransaction

Delete a transaction

Removes one transaction. **Destructive** - the row is gone from
Monarch, won't reappear on next sync, and disappears from all
aggregates (cashflow, budgets, summaries) for past windows.

Use for cash entries the user wants to undo or for confirmed
duplicate Plaid imports. For bulk cleanup use
'POST /v1/transactions/bulk-delete' (supports filter-based deletes
too). For likely-duplicate detection across a window use
'GET /v1/transactions/duplicates'.

### Example

```bash
monarch-api deleteTransaction id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch transaction id. | [default to null]

### Return type

[**DeleteAccount200Response**](DeleteAccount200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## explainTransaction

AI explanation for one transaction

Monarch's AI-generated explanation for why a transaction was
categorized the way it was. Useful for surfacing context in audit
or review flows.

### Example

```bash
monarch-api explainTransaction id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch transaction id. | [default to null]

### Return type

[**ExplainTransaction200Response**](ExplainTransaction200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## explainTransactionByPath

AI explanation for one transaction

Monarch's AI-generated explanation for why a transaction was
categorized the way it was. Useful for surfacing context in audit
or review flows.

Companion to 'GET /v1/transactions/{id}' - the detail call returns
the raw fields, this call returns Monarch's narrated rationale.

### Example

```bash
monarch-api explainTransactionByPath id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch transaction id. | [default to null]

### Return type

[**ExplainTransaction200Response**](ExplainTransaction200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getAccountsForTransactionFilter

Accounts that match a transaction filter

Returns the accounts that would be touched by a bulk transaction
operation given the supplied filter (date window only here for
simplicity; extends to full filter via repeat params).

### Example

```bash
monarch-api getAccountsForTransactionFilter  start=value  end=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **string** | Lower bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]
 **end** | **string** | Upper bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]

### Return type

[**GetAccountsForTransactionFilter200Response**](GetAccountsForTransactionFilter200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getAttachment

Attachment detail

Resolve an attachment id to its 'originalAssetUrl' (a pre-signed download URL).
Use the URL to GET the underlying file from Monarch's storage backend.

### Example

```bash
monarch-api getAttachment id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch transaction-attachment id (UUID). | [default to null]

### Return type

[**GetAttachment200Response**](GetAttachment200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getCashflow

Income, expense, and savings summary for a window

Returns the four headline numbers for a date range: total income,
total expense, net savings (income minus expense), and savings rate
(net savings divided by income). Single row, no per-category
breakdown.

Use for dashboard summary tiles or to drive a savings-rate trend
chart by calling repeatedly across months. For the per-category /
per-merchant breakdown call 'GET /v1/cashflow/breakdown' instead.

All the standard transaction filters apply ('accountIds',
'categoryIds', 'tagIds', 'search', etc.) - useful to scope to one
account or to exclude transfers.

### Example

```bash
monarch-api getCashflow  start=value  end=value  Specify as:  accountIds=value1 accountIds=value2 accountIds=...  Specify as:  categoryIds=value1 categoryIds=value2 categoryIds=...  Specify as:  tagIds=value1 tagIds=value2 tagIds=...  search=value  hasAttachments=value  hasNotes=value  hideFromReports=value  isSplit=value  isRecurring=value  importedFromMint=value  syncedFromInstitution=value  needsReview=value  transactionVisibility=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **string** | Lower bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]
 **end** | **string** | Upper bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]
 **accountIds** | [**array[string]**](string.md) | Filter by one or more Monarch account ids. Repeat the query param for each.
Preferred over the legacy single 'accountId' param; both are accepted and merged. | [optional] [default to null]
 **categoryIds** | [**array[string]**](string.md) | Filter by one or more Monarch category ids. Repeat the query param for each. | [optional] [default to null]
 **tagIds** | [**array[string]**](string.md) | Filter by one or more transaction tag ids. Repeat the query param for each. | [optional] [default to null]
 **search** | **string** | Free-text search against merchant / notes / category. | [optional] [default to null]
 **hasAttachments** | **boolean** | When set, restrict to transactions that do or do not have attachments. Omit for either. | [optional] [default to null]
 **hasNotes** | **boolean** | When set, restrict to transactions that do or do not have notes. Omit for either. | [optional] [default to null]
 **hideFromReports** | **boolean** | When set, restrict to transactions that are or are not hidden from reports. Omit for either. | [optional] [default to null]
 **isSplit** | **boolean** | When set, restrict to split or non-split transactions. Omit for either. | [optional] [default to null]
 **isRecurring** | **boolean** | When set, restrict to recurring or non-recurring transactions. Omit for either. | [optional] [default to null]
 **importedFromMint** | **boolean** | When set, restrict to transactions imported from Mint or not. Omit for either. | [optional] [default to null]
 **syncedFromInstitution** | **boolean** | When set, restrict to transactions synced from the institution feed or not. Omit for either. | [optional] [default to null]
 **needsReview** | **boolean** | When set, restrict to transactions that need review or do not. Omit for either. | [optional] [default to null]
 **transactionVisibility** | **string** | Scope of transactions to return. Omit (default) for non-hidden only.
'hidden_transactions_only' returns only hidden; 'all_transactions' returns both. | [optional] [default to null]

### Return type

[**GetCashflow200Response**](GetCashflow200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getCashflowBreakdown

Cashflow broken down by category, group, merchant

Same date window as 'GET /v1/cashflow', but returns four buckets in
one call: per-category totals, per-category-group totals,
per-merchant totals, and an aggregate summary.

Use to drive a \"where did the money go\" breakdown view, or to find
the top N merchants/categories without making three separate
transaction queries. All standard transaction filters apply
('accountIds', 'categoryIds', 'tagIds', 'search', etc.) - useful to
exclude transfers or scope to one account.

### Example

```bash
monarch-api getCashflowBreakdown  start=value  end=value  Specify as:  accountIds=value1 accountIds=value2 accountIds=...  Specify as:  categoryIds=value1 categoryIds=value2 categoryIds=...  Specify as:  tagIds=value1 tagIds=value2 tagIds=...  search=value  hasAttachments=value  hasNotes=value  hideFromReports=value  isSplit=value  isRecurring=value  importedFromMint=value  syncedFromInstitution=value  needsReview=value  transactionVisibility=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **string** | Lower bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]
 **end** | **string** | Upper bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]
 **accountIds** | [**array[string]**](string.md) | Filter by one or more Monarch account ids. Repeat the query param for each.
Preferred over the legacy single 'accountId' param; both are accepted and merged. | [optional] [default to null]
 **categoryIds** | [**array[string]**](string.md) | Filter by one or more Monarch category ids. Repeat the query param for each. | [optional] [default to null]
 **tagIds** | [**array[string]**](string.md) | Filter by one or more transaction tag ids. Repeat the query param for each. | [optional] [default to null]
 **search** | **string** | Free-text search against merchant / notes / category. | [optional] [default to null]
 **hasAttachments** | **boolean** | When set, restrict to transactions that do or do not have attachments. Omit for either. | [optional] [default to null]
 **hasNotes** | **boolean** | When set, restrict to transactions that do or do not have notes. Omit for either. | [optional] [default to null]
 **hideFromReports** | **boolean** | When set, restrict to transactions that are or are not hidden from reports. Omit for either. | [optional] [default to null]
 **isSplit** | **boolean** | When set, restrict to split or non-split transactions. Omit for either. | [optional] [default to null]
 **isRecurring** | **boolean** | When set, restrict to recurring or non-recurring transactions. Omit for either. | [optional] [default to null]
 **importedFromMint** | **boolean** | When set, restrict to transactions imported from Mint or not. Omit for either. | [optional] [default to null]
 **syncedFromInstitution** | **boolean** | When set, restrict to transactions synced from the institution feed or not. Omit for either. | [optional] [default to null]
 **needsReview** | **boolean** | When set, restrict to transactions that need review or do not. Omit for either. | [optional] [default to null]
 **transactionVisibility** | **string** | Scope of transactions to return. Omit (default) for non-hidden only.
'hidden_transactions_only' returns only hidden; 'all_transactions' returns both. | [optional] [default to null]

### Return type

[**GetCashflowBreakdown200Response**](GetCashflowBreakdown200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getCashflowDashboard

Day-by-day expense series for a date window

Returns daily-bucket expense totals. Lightweight series for charting
spend over a date window. Sparser shape than '/v1/cashflow', with
only the day-grain summary.

### Example

```bash
monarch-api getCashflowDashboard  start=value  end=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **string** | Lower bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]
 **end** | **string** | Upper bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]

### Return type

[**GetCashflowDashboard200Response**](GetCashflowDashboard200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getCashflowEntities

Cashflow by category / category-group / merchant

Three breakdowns over the same date window: by category, by category
group, by merchant. Plus a totals summary (income, expense, savings,
savings rate). Great for \"where did my money go\" prompts.

### Example

```bash
monarch-api getCashflowEntities  start=value  end=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **string** | Lower bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]
 **end** | **string** | Upper bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]

### Return type

[**GetCashflowEntities200Response**](GetCashflowEntities200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getCashflowFiltered

Filtered cashflow page (summary + four breakdowns)

Filterable cashflow query: summary aggregates plus year/month/quarter
bucketing AND category/group/merchant breakdowns in one shot. Filter
by accounts, categories, category groups, merchants, tags.

### Example

```bash
monarch-api getCashflowFiltered  start=value  end=value  Specify as:  accountId=value1 accountId=value2 accountId=...  Specify as:  categoryId=value1 categoryId=value2 categoryId=...  Specify as:  categoryGroupId=value1 categoryGroupId=value2 categoryGroupId=...  Specify as:  merchantId=value1 merchantId=value2 merchantId=...  Specify as:  tagId=value1 tagId=value2 tagId=...
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **string** | Lower bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]
 **end** | **string** | Upper bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]
 **accountId** | [**array[string]**](string.md) | Filter to one or more account ids (repeat the param). | [optional] [default to null]
 **categoryId** | [**array[string]**](string.md) | Filter to one or more category ids. | [optional] [default to null]
 **categoryGroupId** | [**array[string]**](string.md) | Filter to one or more category-group ids. | [optional] [default to null]
 **merchantId** | [**array[string]**](string.md) | Filter to one or more merchant ids. | [optional] [default to null]
 **tagId** | [**array[string]**](string.md) | Filter to one or more tag ids. | [optional] [default to null]

### Return type

[**GetCashflowFiltered200Response**](GetCashflowFiltered200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getCashflowTimeframe

Year / month / quarter cashflow summaries for a date window

Returns income, expense, savings, and savings-rate aggregated three
ways: by year, by month, by quarter. Good for \"how does this year
compare to last\" prompts.

### Example

```bash
monarch-api getCashflowTimeframe  start=value  end=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **string** | Lower bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]
 **end** | **string** | Upper bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]

### Return type

[**GetCashflowTimeframe200Response**](GetCashflowTimeframe200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getDownloadTransactionsSession

Poll a transaction download session

Poll the async CSV download job started by 'POST /v1/transactions/download'.
Returns the current 'status' (running / completed / failed) and, when
completed, the signed 'url' to fetch the CSV file from.

Poll cadence is up to the caller; typical clients re-check every
1-2 seconds until 'url' is non-null.

### Example

```bash
monarch-api getDownloadTransactionsSession sessionKey=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sessionKey** | **string** | Session key returned by 'POST /v1/transactions/download'. | [default to null]

### Return type

[**GetDownloadTransactionsSession200Response**](GetDownloadTransactionsSession200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getReviewSummaryByUser

Review-queue counts by household user

For each household member, how many transactions are currently flagged as
needing review. Empty list = nothing in the review queue.

### Example

```bash
monarch-api getReviewSummaryByUser
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**GetReviewSummaryByUser200Response**](GetReviewSummaryByUser200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getSpendingDashboard

Home-tab spending dashboard widget

Compact spending widget for the home tab: total spend for the
window, remaining budget, and the top spending categories.

### Example

```bash
monarch-api getSpendingDashboard  start=value  end=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **string** | Lower bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]
 **end** | **string** | Upper bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]

### Return type

[**GetSpendingDashboard200Response**](GetSpendingDashboard200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getSpendingTrends

Spending trends (period-over-period)

Period-over-period spend trend: current vs. previous total plus
the top rising / falling categories by percent delta. Backs the
\"Spending Trends\" widget under Insights and the dashboard.

'timeframe' is 'week', 'month', or 'quarter'. Each compares the
current period to the matching previous one.

### Example

```bash
monarch-api getSpendingTrends  timeframe=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **timeframe** | **string** |  | [optional] [default to month]

### Return type

[**GetSpendingTrends200Response**](GetSpendingTrends200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getTransactionAuditLog

Transaction audit log

History of changes against one transaction. Each entry has the
timestamp, actor, action, and old / new value for the field that
changed.

### Example

```bash
monarch-api getTransactionAuditLog id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch transaction id. | [default to null]

### Return type

[**GetTransactionAuditLog200Response**](GetTransactionAuditLog200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getTransactionDetail

Single-transaction full detail

Returns the full denormalized tree for one transaction: amount,
date, merchant (with logo), category, account, notes, tags, splits
(if split), attachments, recurring-stream metadata, and review
state.

Use when surfacing a transaction in a detail view, or before a
PATCH to inspect current state. The list endpoint
'GET /v1/transactions' returns a leaner shape per row - this
endpoint is the right call when you need the full picture for one.

### Example

```bash
monarch-api getTransactionDetail id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch transaction id. | [default to null]

### Return type

[**GetTransactionDetail200Response**](GetTransactionDetail200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getTransactionNotes

Transaction notes

Standalone notes accessor for one transaction. Lighter than
'/v1/transactions/{id}' when you only need the notes string.

### Example

```bash
monarch-api getTransactionNotes id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch transaction id. | [default to null]

### Return type

[**GetTransactionNotes200Response**](GetTransactionNotes200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getTransactionSplitTemplates

Saved split templates

Saved reusable percent-based split definitions (\"Costco run: 70%
Groceries / 30% Household\"). The web split modal fires this to
populate the \"Apply template\" dropdown.

Each template carries a list of percent-of-parent splits. Caller
composes the actual 'POST /v1/transactions/{id}/splits' request by
multiplying the parent amount by each 'percent'.

### Example

```bash
monarch-api getTransactionSplitTemplates
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**GetTransactionSplitTemplates200Response**](GetTransactionSplitTemplates200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getTransactionSplits

Splits of one transaction

Returns the child split rows of a parent transaction (e.g. a
$120 grocery run split into $90 groceries + $30 household). Each
split has its own amount, category, notes, and tags but inherits
the parent's date and account.

Returns an empty 'splits' array when the transaction isn't split
(no error). The parent transaction summary is included on the
response for convenience.

### Example

```bash
monarch-api getTransactionSplits id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch transaction id. | [default to null]

### Return type

[**GetTransactionSplits200Response**](GetTransactionSplits200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getTransactionsDashboard

Dashboard transactions list (with totals + rule count)

Returns transaction rows scoped to a date window plus pagination,
along with a totalCount, totalSelectableCount, and a rule-count
sidecar. Lightweight shape suitable for dashboard widgets.

### Example

```bash
monarch-api getTransactionsDashboard  start=value  end=value  limit=value  offset=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **string** | Lower bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]
 **end** | **string** | Upper bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]
 **limit** | **integer** | Page size. | [optional] [default to null]
 **offset** | **integer** | Page offset. | [optional] [default to null]

### Return type

[**GetTransactionsDashboard200Response**](GetTransactionsDashboard200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getTransactionsDuplicates

Groups of likely-duplicate transactions

Server-side composite over 'GET /v1/transactions'. Pulls the window and groups
results by the python-lib 'find_duplicate_transactions' key:
'(date, amount, plaidName, accountId)'.

Using 'plaidName' (the raw Plaid description) rather than 'merchantName'
(Monarch's normalized display name) avoids false positives: two genuine
same-day same-merchant same-amount charges carry different 'plaidName'
reference strings. Only true double-inserts share the exact 'plaidName'.

Returns only groups with size > 1. Useful for surfacing accidental
double-posts after re-linking an institution (a known Monarch issue,
particularly for Apple Card / Apple Cash / Apple Savings).

### Example

```bash
monarch-api getTransactionsDuplicates  start=value  end=value  accountId=value  Specify as:  accountIds=value1 accountIds=value2 accountIds=...
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **string** | Lower bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]
 **end** | **string** | Upper bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]
 **accountId** | **string** | Filter by a single Monarch account id. | [optional] [default to null]
 **accountIds** | [**array[string]**](string.md) | Filter to multiple accounts. Merged with the legacy single-value
'accountId' if both are passed. | [optional] [default to null]

### Return type

[**GetTransactionsDuplicates200Response**](GetTransactionsDuplicates200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getTransactionsSummary

Aggregate stats across a transaction window

Returns one summary row over the filtered transaction set:
'count', 'sum', 'avg', 'min', 'max', 'first', 'last'. Useful for
one-shot questions like \"how many Whole Foods runs this year\" or
\"what's my average dining check\" without pulling the full
transaction list.

All standard transaction filters apply ('search', 'categoryIds',
'accountIds', 'tagIds', bool flags). For per-category breakdowns
use 'GET /v1/cashflow/breakdown'. For row-level data use
'GET /v1/transactions'.

### Example

```bash
monarch-api getTransactionsSummary  start=value  end=value  accountId=value  Specify as:  accountIds=value1 accountIds=value2 accountIds=...  Specify as:  categoryIds=value1 categoryIds=value2 categoryIds=...  Specify as:  tagIds=value1 tagIds=value2 tagIds=...  search=value  hasAttachments=value  hasNotes=value  hideFromReports=value  isSplit=value  isRecurring=value  importedFromMint=value  syncedFromInstitution=value  needsReview=value  transactionVisibility=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **string** | Lower bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]
 **end** | **string** | Upper bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]
 **accountId** | **string** | Filter by a single Monarch account id. | [optional] [default to null]
 **accountIds** | [**array[string]**](string.md) | Filter by one or more Monarch account ids. Repeat the query param for each.
Preferred over the legacy single 'accountId' param; both are accepted and merged. | [optional] [default to null]
 **categoryIds** | [**array[string]**](string.md) | Filter by one or more Monarch category ids. Repeat the query param for each. | [optional] [default to null]
 **tagIds** | [**array[string]**](string.md) | Filter by one or more transaction tag ids. Repeat the query param for each. | [optional] [default to null]
 **search** | **string** | Free-text search against merchant / notes / category. | [optional] [default to null]
 **hasAttachments** | **boolean** | When set, restrict to transactions that do or do not have attachments. Omit for either. | [optional] [default to null]
 **hasNotes** | **boolean** | When set, restrict to transactions that do or do not have notes. Omit for either. | [optional] [default to null]
 **hideFromReports** | **boolean** | When set, restrict to transactions that are or are not hidden from reports. Omit for either. | [optional] [default to null]
 **isSplit** | **boolean** | When set, restrict to split or non-split transactions. Omit for either. | [optional] [default to null]
 **isRecurring** | **boolean** | When set, restrict to recurring or non-recurring transactions. Omit for either. | [optional] [default to null]
 **importedFromMint** | **boolean** | When set, restrict to transactions imported from Mint or not. Omit for either. | [optional] [default to null]
 **syncedFromInstitution** | **boolean** | When set, restrict to transactions synced from the institution feed or not. Omit for either. | [optional] [default to null]
 **needsReview** | **boolean** | When set, restrict to transactions that need review or do not. Omit for either. | [optional] [default to null]
 **transactionVisibility** | **string** | Scope of transactions to return. Omit (default) for non-hidden only.
'hidden_transactions_only' returns only hidden; 'all_transactions' returns both. | [optional] [default to null]

### Return type

[**GetTransactionsSummary200Response**](GetTransactionsSummary200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## listTransactions

Search and list transactions with rich filtering

Returns transactions matching the filter set, **newest-first** within
'[start, end]'. Use the 'search' param for free-text search across
merchant + notes + plaid name. Combine with 'categoryIds',
'accountIds', 'tagIds' (all multi) to scope.

Date semantics: 'start' is the **oldest allowed date**, NOT \"scroll
forward from here\". '?start=2026-01-01&limit=10' returns the 10
newest txns on or after Jan 2026 (probably this week). To get January
specifically: '?start=2026-01-01&end=2026-01-31'. To get older rows,
bound 'end' earlier or paginate with 'offset'.

Bool filters ('hasAttachments', 'isRecurring', 'hideFromReports',
'needsReview', etc.) accept true/false; omit to not filter on that
dimension. Returns the page plus 'totalCount' for the filter set.
For aggregate stats over the same filter use
'GET /v1/transactions/summary'; for the single-row detail use
'GET /v1/transactions/{id}'.

### Example

```bash
monarch-api listTransactions  start=value  end=value  limit=value  offset=value  accountId=value  Specify as:  accountIds=value1 accountIds=value2 accountIds=...  Specify as:  categoryIds=value1 categoryIds=value2 categoryIds=...  Specify as:  tagIds=value1 tagIds=value2 tagIds=...  orderBy=value  search=value  hasAttachments=value  hasNotes=value  hideFromReports=value  isSplit=value  isRecurring=value  importedFromMint=value  syncedFromInstitution=value  needsReview=value  transactionVisibility=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **string** | Lower bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]
 **end** | **string** | Upper bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]
 **limit** | **integer** | Page size. | [optional] [default to null]
 **offset** | **integer** | Page offset. | [optional] [default to null]
 **accountId** | **string** | Filter by a single Monarch account id. | [optional] [default to null]
 **accountIds** | [**array[string]**](string.md) | Filter by one or more Monarch account ids. Repeat the query param for each.
Preferred over the legacy single 'accountId' param; both are accepted and merged. | [optional] [default to null]
 **categoryIds** | [**array[string]**](string.md) | Filter by one or more Monarch category ids. Repeat the query param for each. | [optional] [default to null]
 **tagIds** | [**array[string]**](string.md) | Filter by one or more transaction tag ids. Repeat the query param for each. | [optional] [default to null]
 **orderBy** | **string** | Monarch sort enum. Both values sort descending. | [optional] [default to null]
 **search** | **string** | Free-text search against merchant / notes / category. | [optional] [default to null]
 **hasAttachments** | **boolean** | When set, restrict to transactions that do or do not have attachments. Omit for either. | [optional] [default to null]
 **hasNotes** | **boolean** | When set, restrict to transactions that do or do not have notes. Omit for either. | [optional] [default to null]
 **hideFromReports** | **boolean** | When set, restrict to transactions that are or are not hidden from reports. Omit for either. | [optional] [default to null]
 **isSplit** | **boolean** | When set, restrict to split or non-split transactions. Omit for either. | [optional] [default to null]
 **isRecurring** | **boolean** | When set, restrict to recurring or non-recurring transactions. Omit for either. | [optional] [default to null]
 **importedFromMint** | **boolean** | When set, restrict to transactions imported from Mint or not. Omit for either. | [optional] [default to null]
 **syncedFromInstitution** | **boolean** | When set, restrict to transactions synced from the institution feed or not. Omit for either. | [optional] [default to null]
 **needsReview** | **boolean** | When set, restrict to transactions that need review or do not. Omit for either. | [optional] [default to null]
 **transactionVisibility** | **string** | Scope of transactions to return. Omit (default) for non-hidden only.
'hidden_transactions_only' returns only hidden; 'all_transactions' returns both. | [optional] [default to null]

### Return type

[**ListTransactions200Response**](ListTransactions200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## markAsRecurring

Mark a transaction as the start of a recurring stream

The inverse of 'POST /v1/transactions/{id}/not-recurring'. Tells
Monarch the transaction IS the first instance of a recurring stream
at the given 'frequency' ('monthly', 'weekly', 'quarterly', 'yearly',
'biweekly'). Monarch creates the stream definition and returns its id.

Use to teach Monarch a stream it missed (a new subscription, a
private-vendor recurring invoice).

### Example

```bash
monarch-api markAsRecurring id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch transaction id. | [default to null]
 **markAsRecurringRequest** | [**MarkAsRecurringRequest**](MarkAsRecurringRequest.md) |  |

### Return type

[**MarkAsRecurring200Response**](MarkAsRecurring200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## markTransactionAsReviewed

Mark a transaction as reviewed

Single-shot helper: sets 'reviewed=true' on one transaction. Equivalent to
'PATCH /v1/transactions/{id}' with '{\"reviewed\": true}' but smaller in input
(no body required) and output (only 'id', 'reviewedAt', 'needsReview').

Use from review/triage flows where the assistant just needs to dispatch a
mark-as-reviewed without rewriting the whole transaction tree.

To un-mark, send 'PATCH /v1/transactions/{id}' with '{\"reviewed\": false}'.

### Example

```bash
monarch-api markTransactionAsReviewed id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch transaction id. | [default to null]

### Return type

[**MarkTransactionAsReviewed200Response**](MarkTransactionAsReviewed200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## markTransactionStreamAsNotRecurring

Mark a transaction's recurring-stream as not-recurring

Tells Monarch that the recurring stream a transaction is attached to is NOT actually
recurring. Used to dismiss false-positive recurrence detections.

Important: Monarch's mutation takes a 'streamId', NOT a transaction id. Pass the
transaction's 'stream.id' (visible on the transaction detail) as the path '{id}'.

### Example

```bash
monarch-api markTransactionStreamAsNotRecurring id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch transaction id. | [default to null]

### Return type

[**MarkTransactionStreamAsNotRecurring200Response**](MarkTransactionStreamAsNotRecurring200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## matchSearchTransactions

Fuzzy transaction search for \"find a match\"

Free-text transaction lookup powering the web \"find a match\" picker
(used in split, link-to-goal, and recurring-merge flows). Returns a
lean shape per row: id, amount, date, plaid name, merchant + account
references.

Different from the canonical 'GET /v1/transactions' in two ways: only
the 'search' filter is supported, and the result shape is the slim
picker shape rather than the full transaction row.

### Example

```bash
monarch-api matchSearchTransactions  search=value  limit=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **search** | **string** | Free-text query against merchant + plaid name. | [optional] [default to null]
 **limit** | **integer** | Max results. | [optional] [default to 20]

### Return type

[**MatchSearchTransactions200Response**](MatchSearchTransactions200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## moveTransactions

Move transactions between accounts

Reassign one or more transactions from their current account to a
target account. Use when reconciling a mis-categorized import (e.g.
Plaid bucketed a charge under the wrong account) or after a manual
merge.

Returns the count of transactions Monarch actually moved, plus a
flat error array (one message per failed transaction).

### Example

```bash
monarch-api moveTransactions
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **moveTransactionsRequest** | [**MoveTransactionsRequest**](MoveTransactionsRequest.md) |  |

### Return type

[**MoveTransactions200Response**](MoveTransactions200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## setTransactionTags

Overwrite the tag set on a transaction

Wholesale-replaces every tag on a transaction. Send the complete
final tag id list - this is NOT a delta. To add a tag without
losing the existing ones, read current tags first via
'GET /v1/transactions/{id}' then PUT the merged list.

Empty list '[]' clears all tags. Tag ids come from
'GET /v1/tags'. For bulk tag changes across many transactions use
'PATCH /v1/transactions/bulk'.

### Example

```bash
monarch-api setTransactionTags id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch transaction id. | [default to null]
 **setTransactionTagsRequest** | [**SetTransactionTagsRequest**](SetTransactionTagsRequest.md) |  |

### Return type

[**SetTransactionTags200Response**](SetTransactionTags200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## startDownloadTransactions

Start a transaction CSV download session

Kick off the async \"download my transactions as CSV\" job Monarch
backs the Web download button with. Returns a 'sessionKey' to poll
via 'GET /v1/transactions/download/{sessionKey}' until the CSV 'url'
is ready.

Filters mirror 'GET /v1/transactions': pass a JSON map under
'filters' (search string, categoryIds, accountIds, date window).

### Example

```bash
monarch-api startDownloadTransactions
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **startDownloadTransactionsRequest** | [**StartDownloadTransactionsRequest**](StartDownloadTransactionsRequest.md) |  |

### Return type

[**StartDownloadTransactions200Response**](StartDownloadTransactions200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## updateTransaction

Partial-update a transaction

Patches one transaction. Only fields present in the body are
forwarded to Monarch; omit a field to leave it untouched.

Common edits: 'categoryId' (re-categorize), 'merchantName' (rename
via the override), 'notes', 'date', 'amount' (manual accounts only -
Plaid will overwrite on next sync), 'hideFromReports', 'needsReview'.

For tag mutations use 'PUT /v1/transactions/{id}/tags' instead -
tags are stored separately. For wholesale edits across many
transactions use 'PATCH /v1/transactions/bulk'.

### Example

```bash
monarch-api updateTransaction id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch transaction id. | [default to null]
 **updateTransactionRequest** | [**UpdateTransactionRequest**](UpdateTransactionRequest.md) |  |

### Return type

[**UpdateTransaction200Response**](UpdateTransaction200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## updateTransactionSplits

Replace the splits on a transaction

Wholesale-replaces the split set on a transaction. Send the
complete new list - this is NOT a delta operation. Each split needs
'amount' (signed, same sign as the parent) plus 'categoryId' and
optional 'notes' / 'merchantName'.

Sum of split amounts must equal the parent transaction's amount
exactly - Monarch rejects with 422 PayloadError on any mismatch.
Send an empty list to remove all splits and revert the transaction
to a single-row entry.

### Example

```bash
monarch-api updateTransactionSplits id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch transaction id. | [default to null]
 **updateTransactionSplitsRequest** | [**UpdateTransactionSplitsRequest**](UpdateTransactionSplitsRequest.md) |  |

### Return type

[**UpdateTransactionSplits200Response**](UpdateTransactionSplits200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## uploadTransactionAttachment

Attach a receipt photo or PDF to a transaction

Three-step flow handled internally by the proxy: (1) asks Monarch for signed
Cloudinary upload params, (2) forwards the file to Cloudinary, (3) tells
Monarch to link the upload to the transaction. Caller sees a single
multipart/form-data POST with the file.

### Example

```bash
monarch-api uploadTransactionAttachment id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch transaction id. | [default to null]
 **file** | **binary** | Receipt photo, scan, or PDF. | [default to null]

### Return type

[**UploadTransactionAttachment200Response**](UploadTransactionAttachment200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: multipart/form-data
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

