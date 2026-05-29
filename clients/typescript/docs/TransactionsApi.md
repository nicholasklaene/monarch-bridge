# TransactionsApi

All URIs are relative to *http://localhost:9084*

|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|[**bulkDeleteTransactions**](#bulkdeletetransactions) | **POST** /v1/transactions/bulk-delete | Bulk-delete transactions|
|[**bulkUpdateTransactions**](#bulkupdatetransactions) | **PATCH** /v1/transactions/bulk | Bulk-update transactions|
|[**createTransaction**](#createtransaction) | **POST** /v1/transactions | Create a manual transaction|
|[**deleteTransaction**](#deletetransaction) | **DELETE** /v1/transactions/{id} | Delete a transaction|
|[**explainTransaction**](#explaintransaction) | **GET** /v1/transactions/explain/{id} | AI explanation for one transaction|
|[**explainTransactionByPath**](#explaintransactionbypath) | **GET** /v1/transactions/{id}/explain | AI explanation for one transaction|
|[**getAccountsForTransactionFilter**](#getaccountsfortransactionfilter) | **GET** /v1/transactions/accounts-for-filter | Accounts that match a transaction filter|
|[**getAttachment**](#getattachment) | **GET** /v1/attachments/{id} | Attachment detail|
|[**getCashflow**](#getcashflow) | **GET** /v1/cashflow | Income, expense, and savings summary for a window|
|[**getCashflowBreakdown**](#getcashflowbreakdown) | **GET** /v1/cashflow/breakdown | Cashflow broken down by category, group, merchant|
|[**getCashflowDashboard**](#getcashflowdashboard) | **GET** /v1/cashflow/dashboard | Day-by-day expense series for a date window|
|[**getCashflowEntities**](#getcashflowentities) | **GET** /v1/cashflow/entities | Cashflow by category / category-group / merchant|
|[**getCashflowFiltered**](#getcashflowfiltered) | **GET** /v1/cashflow/filtered | Filtered cashflow page (summary + four breakdowns)|
|[**getCashflowTimeframe**](#getcashflowtimeframe) | **GET** /v1/cashflow/timeframe | Year / month / quarter cashflow summaries for a date window|
|[**getDownloadTransactionsSession**](#getdownloadtransactionssession) | **GET** /v1/transactions/download/{sessionKey} | Poll a transaction download session|
|[**getReviewSummaryByUser**](#getreviewsummarybyuser) | **GET** /v1/transactions/review-summary | Review-queue counts by household user|
|[**getSpendingDashboard**](#getspendingdashboard) | **GET** /v1/dashboard/spending | Home-tab spending dashboard widget|
|[**getSpendingTrends**](#getspendingtrends) | **GET** /v1/dashboard/spending/trends | Spending trends (period-over-period)|
|[**getTransactionAuditLog**](#gettransactionauditlog) | **GET** /v1/transactions/{id}/audit | Transaction audit log|
|[**getTransactionDetail**](#gettransactiondetail) | **GET** /v1/transactions/{id} | Single-transaction full detail|
|[**getTransactionNotes**](#gettransactionnotes) | **GET** /v1/transactions/{id}/notes | Transaction notes|
|[**getTransactionSplitTemplates**](#gettransactionsplittemplates) | **GET** /v1/transactions/split-templates | Saved split templates|
|[**getTransactionSplits**](#gettransactionsplits) | **GET** /v1/transactions/{id}/splits | Splits of one transaction|
|[**getTransactionsDashboard**](#gettransactionsdashboard) | **GET** /v1/transactions/dashboard | Dashboard transactions list (with totals + rule count)|
|[**getTransactionsDuplicates**](#gettransactionsduplicates) | **GET** /v1/transactions/duplicates | Groups of likely-duplicate transactions|
|[**getTransactionsSummary**](#gettransactionssummary) | **GET** /v1/transactions/summary | Aggregate stats across a transaction window|
|[**listTransactions**](#listtransactions) | **GET** /v1/transactions | Search and list transactions with rich filtering|
|[**markAsRecurring**](#markasrecurring) | **POST** /v1/transactions/{id}/recurring | Mark a transaction as the start of a recurring stream|
|[**markTransactionAsReviewed**](#marktransactionasreviewed) | **POST** /v1/transactions/{id}/reviewed | Mark a transaction as reviewed|
|[**markTransactionStreamAsNotRecurring**](#marktransactionstreamasnotrecurring) | **POST** /v1/transactions/{id}/not-recurring | Mark a transaction\&#39;s recurring-stream as not-recurring|
|[**matchSearchTransactions**](#matchsearchtransactions) | **GET** /v1/transactions/match-search | Fuzzy transaction search for \&quot;find a match\&quot;|
|[**moveTransactions**](#movetransactions) | **POST** /v1/transactions/move | Move transactions between accounts|
|[**setTransactionTags**](#settransactiontags) | **PUT** /v1/transactions/{id}/tags | Overwrite the tag set on a transaction|
|[**startDownloadTransactions**](#startdownloadtransactions) | **POST** /v1/transactions/download | Start a transaction CSV download session|
|[**updateTransaction**](#updatetransaction) | **PATCH** /v1/transactions/{id} | Partial-update a transaction|
|[**updateTransactionSplits**](#updatetransactionsplits) | **POST** /v1/transactions/{id}/splits | Replace the splits on a transaction|
|[**uploadTransactionAttachment**](#uploadtransactionattachment) | **POST** /v1/transactions/{id}/attachments | Attach a receipt photo or PDF to a transaction|

# **bulkDeleteTransactions**
> BulkDeleteTransactionsResponse bulkDeleteTransactions(bulkDeleteTransactionsRequest)

Forwards Monarch\'s `bulkDeleteTransactions` mutation. Same two-mode selection as bulk-update:  - `allSelected: false` + `selectedTransactionIds: [a,b,c]` to delete exactly N. - `allSelected: true` + `filters: {...}` + optional `excludedTransactionIds: [...]`   to delete everything matching minus a hand-picked exclusion list.  `expectedAffectedTransactionCount` is the same race-prevention guard as bulk-update. Destructive: prefer `tx duplicates` first to scope the selection. 

### Example

```typescript
import {
    TransactionsApi,
    Configuration,
    BulkDeleteTransactionsRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TransactionsApi(configuration);

let bulkDeleteTransactionsRequest: BulkDeleteTransactionsRequest; //

const { status, data } = await apiInstance.bulkDeleteTransactions(
    bulkDeleteTransactionsRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **bulkDeleteTransactionsRequest** | **BulkDeleteTransactionsRequest**|  | |


### Return type

**BulkDeleteTransactionsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Monarch reports success plus the affected-row count. |  -  |
|**400** | Validation failed. |  -  |
|**422** | Monarch rejected the mutation (e.g. expected-count mismatch). |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **bulkUpdateTransactions**
> BulkUpdateTransactionsResponse bulkUpdateTransactions(bulkUpdateTransactionsRequest)

Forwards Monarch\'s `bulkUpdateTransactions` mutation. Two selection modes are supported on the same shape (`allSelected` discriminates):  - `allSelected: false` + `selectedTransactionIds: [a,b,c]` is the common case:   apply `updates` to exactly those N transactions. - `allSelected: true` + `filters: {...}` + optional `excludedTransactionIds: [...]`   is the \"select everything matching the filter then minus these\" pattern.  `expectedAffectedTransactionCount` is a safety check. Monarch refuses the mutation if its actual affected-row count differs from this number (race-prevention).  The `updates` object is Monarch\'s `TransactionUpdateParams` input shape (same field surface as `PATCH /v1/transactions/{id}`: categoryId, merchantName, notes, date, hide, etc.). 

### Example

```typescript
import {
    TransactionsApi,
    Configuration,
    BulkUpdateTransactionsRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TransactionsApi(configuration);

let bulkUpdateTransactionsRequest: BulkUpdateTransactionsRequest; //

const { status, data } = await apiInstance.bulkUpdateTransactions(
    bulkUpdateTransactionsRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **bulkUpdateTransactionsRequest** | **BulkUpdateTransactionsRequest**|  | |


### Return type

**BulkUpdateTransactionsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Monarch reports success plus the affected-row count. |  -  |
|**400** | Validation failed. |  -  |
|**422** | Monarch rejected the mutation (e.g. expected-count mismatch). |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **createTransaction**
> CreateTransactionResponse createTransaction(createTransactionRequest)

Adds a transaction by hand into a specific account. Typically used for cash spending, manually-tracked accounts, or to record an item Plaid missed.  Required: `accountId`, `date`, `amount` (signed: negative for spending, positive for income/refund), and `merchantName`. Optional: `categoryId`, `notes`, `hideFromReports`. Skips Monarch\'s auto- categorization rule pass - the new transaction lands with exactly the category you supplied (or uncategorized).  For receipt attachment use `POST /v1/transactions/{id}/attachment` after the create. PayloadError yields 422 on Monarch-side rejection. 

### Example

```typescript
import {
    TransactionsApi,
    Configuration,
    CreateTransactionRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TransactionsApi(configuration);

let createTransactionRequest: CreateTransactionRequest; //

const { status, data } = await apiInstance.createTransaction(
    createTransactionRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **createTransactionRequest** | **CreateTransactionRequest**|  | |


### Return type

**CreateTransactionResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | New transaction id. |  -  |
|**400** | Validation failed. |  -  |
|**422** | Monarch PayloadError. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **deleteTransaction**
> DeleteAccountResponse deleteTransaction()

Removes one transaction. **Destructive** - the row is gone from Monarch, won\'t reappear on next sync, and disappears from all aggregates (cashflow, budgets, summaries) for past windows.  Use for cash entries the user wants to undo or for confirmed duplicate Plaid imports. For bulk cleanup use `POST /v1/transactions/bulk-delete` (supports filter-based deletes too). For likely-duplicate detection across a window use `GET /v1/transactions/duplicates`. 

### Example

```typescript
import {
    TransactionsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TransactionsApi(configuration);

let id: string; //Monarch transaction id. (default to undefined)

const { status, data } = await apiInstance.deleteTransaction(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch transaction id. | defaults to undefined|


### Return type

**DeleteAccountResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Confirmation. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **explainTransaction**
> ExplainTransactionResponse explainTransaction()

Monarch\'s AI-generated explanation for why a transaction was categorized the way it was. Useful for surfacing context in audit or review flows. 

### Example

```typescript
import {
    TransactionsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TransactionsApi(configuration);

let id: string; //Monarch transaction id. (default to undefined)

const { status, data } = await apiInstance.explainTransaction(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch transaction id. | defaults to undefined|


### Return type

**ExplainTransactionResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Explanation string (may be null). |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **explainTransactionByPath**
> ExplainTransactionResponse explainTransactionByPath()

Monarch\'s AI-generated explanation for why a transaction was categorized the way it was. Useful for surfacing context in audit or review flows.  Companion to `GET /v1/transactions/{id}` - the detail call returns the raw fields, this call returns Monarch\'s narrated rationale. 

### Example

```typescript
import {
    TransactionsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TransactionsApi(configuration);

let id: string; //Monarch transaction id. (default to undefined)

const { status, data } = await apiInstance.explainTransactionByPath(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch transaction id. | defaults to undefined|


### Return type

**ExplainTransactionResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Explanation string (may be null). |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getAccountsForTransactionFilter**
> GetAccountsForTransactionFilterResponse getAccountsForTransactionFilter()

Returns the accounts that would be touched by a bulk transaction operation given the supplied filter (date window only here for simplicity; extends to full filter via repeat params). 

### Example

```typescript
import {
    TransactionsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TransactionsApi(configuration);

let start: string; //Lower bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)
let end: string; //Upper bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)

const { status, data } = await apiInstance.getAccountsForTransactionFilter(
    start,
    end
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **start** | [**string**] | Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|
| **end** | [**string**] | Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|


### Return type

**GetAccountsForTransactionFilterResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Matching accounts (display + provider metadata). |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getAttachment**
> GetAttachmentResponse getAttachment()

Resolve an attachment id to its `originalAssetUrl` (a pre-signed download URL). Use the URL to GET the underlying file from Monarch\'s storage backend. 

### Example

```typescript
import {
    TransactionsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TransactionsApi(configuration);

let id: string; //Monarch transaction-attachment id (UUID). (default to undefined)

const { status, data } = await apiInstance.getAttachment(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch transaction-attachment id (UUID). | defaults to undefined|


### Return type

**GetAttachmentResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Attachment detail. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getCashflow**
> GetCashflowResponse getCashflow()

Returns the four headline numbers for a date range: total income, total expense, net savings (income minus expense), and savings rate (net savings divided by income). Single row, no per-category breakdown.  Use for dashboard summary tiles or to drive a savings-rate trend chart by calling repeatedly across months. For the per-category / per-merchant breakdown call `GET /v1/cashflow/breakdown` instead.  All the standard transaction filters apply (`accountIds`, `categoryIds`, `tagIds`, `search`, etc.) - useful to scope to one account or to exclude transfers. 

### Example

```typescript
import {
    TransactionsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TransactionsApi(configuration);

let start: string; //Lower bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)
let end: string; //Upper bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)
let accountIds: Array<string>; //Filter by one or more Monarch account ids. Repeat the query param for each. Preferred over the legacy single `accountId` param; both are accepted and merged.  (optional) (default to undefined)
let categoryIds: Array<string>; //Filter by one or more Monarch category ids. Repeat the query param for each. (optional) (default to undefined)
let tagIds: Array<string>; //Filter by one or more transaction tag ids. Repeat the query param for each. (optional) (default to undefined)
let search: string; //Free-text search against merchant / notes / category. (optional) (default to undefined)
let hasAttachments: boolean; //When set, restrict to transactions that do or do not have attachments. Omit for either. (optional) (default to undefined)
let hasNotes: boolean; //When set, restrict to transactions that do or do not have notes. Omit for either. (optional) (default to undefined)
let hideFromReports: boolean; //When set, restrict to transactions that are or are not hidden from reports. Omit for either. (optional) (default to undefined)
let isSplit: boolean; //When set, restrict to split or non-split transactions. Omit for either. (optional) (default to undefined)
let isRecurring: boolean; //When set, restrict to recurring or non-recurring transactions. Omit for either. (optional) (default to undefined)
let importedFromMint: boolean; //When set, restrict to transactions imported from Mint or not. Omit for either. (optional) (default to undefined)
let syncedFromInstitution: boolean; //When set, restrict to transactions synced from the institution feed or not. Omit for either. (optional) (default to undefined)
let needsReview: boolean; //When set, restrict to transactions that need review or do not. Omit for either. (optional) (default to undefined)
let transactionVisibility: 'hidden_transactions_only' | 'all_transactions'; //Scope of transactions to return. Omit (default) for non-hidden only. `hidden_transactions_only` returns only hidden; `all_transactions` returns both.  (optional) (default to undefined)

const { status, data } = await apiInstance.getCashflow(
    start,
    end,
    accountIds,
    categoryIds,
    tagIds,
    search,
    hasAttachments,
    hasNotes,
    hideFromReports,
    isSplit,
    isRecurring,
    importedFromMint,
    syncedFromInstitution,
    needsReview,
    transactionVisibility
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **start** | [**string**] | Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|
| **end** | [**string**] | Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|
| **accountIds** | **Array&lt;string&gt;** | Filter by one or more Monarch account ids. Repeat the query param for each. Preferred over the legacy single &#x60;accountId&#x60; param; both are accepted and merged.  | (optional) defaults to undefined|
| **categoryIds** | **Array&lt;string&gt;** | Filter by one or more Monarch category ids. Repeat the query param for each. | (optional) defaults to undefined|
| **tagIds** | **Array&lt;string&gt;** | Filter by one or more transaction tag ids. Repeat the query param for each. | (optional) defaults to undefined|
| **search** | [**string**] | Free-text search against merchant / notes / category. | (optional) defaults to undefined|
| **hasAttachments** | [**boolean**] | When set, restrict to transactions that do or do not have attachments. Omit for either. | (optional) defaults to undefined|
| **hasNotes** | [**boolean**] | When set, restrict to transactions that do or do not have notes. Omit for either. | (optional) defaults to undefined|
| **hideFromReports** | [**boolean**] | When set, restrict to transactions that are or are not hidden from reports. Omit for either. | (optional) defaults to undefined|
| **isSplit** | [**boolean**] | When set, restrict to split or non-split transactions. Omit for either. | (optional) defaults to undefined|
| **isRecurring** | [**boolean**] | When set, restrict to recurring or non-recurring transactions. Omit for either. | (optional) defaults to undefined|
| **importedFromMint** | [**boolean**] | When set, restrict to transactions imported from Mint or not. Omit for either. | (optional) defaults to undefined|
| **syncedFromInstitution** | [**boolean**] | When set, restrict to transactions synced from the institution feed or not. Omit for either. | (optional) defaults to undefined|
| **needsReview** | [**boolean**] | When set, restrict to transactions that need review or do not. Omit for either. | (optional) defaults to undefined|
| **transactionVisibility** | [**&#39;hidden_transactions_only&#39; | &#39;all_transactions&#39;**]**Array<&#39;hidden_transactions_only&#39; &#124; &#39;all_transactions&#39;>** | Scope of transactions to return. Omit (default) for non-hidden only. &#x60;hidden_transactions_only&#x60; returns only hidden; &#x60;all_transactions&#x60; returns both.  | (optional) defaults to undefined|


### Return type

**GetCashflowResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Aggregate summary for the window. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getCashflowBreakdown**
> GetCashflowBreakdownResponse getCashflowBreakdown()

Same date window as `GET /v1/cashflow`, but returns four buckets in one call: per-category totals, per-category-group totals, per-merchant totals, and an aggregate summary.  Use to drive a \"where did the money go\" breakdown view, or to find the top N merchants/categories without making three separate transaction queries. All standard transaction filters apply (`accountIds`, `categoryIds`, `tagIds`, `search`, etc.) - useful to exclude transfers or scope to one account. 

### Example

```typescript
import {
    TransactionsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TransactionsApi(configuration);

let start: string; //Lower bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)
let end: string; //Upper bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)
let accountIds: Array<string>; //Filter by one or more Monarch account ids. Repeat the query param for each. Preferred over the legacy single `accountId` param; both are accepted and merged.  (optional) (default to undefined)
let categoryIds: Array<string>; //Filter by one or more Monarch category ids. Repeat the query param for each. (optional) (default to undefined)
let tagIds: Array<string>; //Filter by one or more transaction tag ids. Repeat the query param for each. (optional) (default to undefined)
let search: string; //Free-text search against merchant / notes / category. (optional) (default to undefined)
let hasAttachments: boolean; //When set, restrict to transactions that do or do not have attachments. Omit for either. (optional) (default to undefined)
let hasNotes: boolean; //When set, restrict to transactions that do or do not have notes. Omit for either. (optional) (default to undefined)
let hideFromReports: boolean; //When set, restrict to transactions that are or are not hidden from reports. Omit for either. (optional) (default to undefined)
let isSplit: boolean; //When set, restrict to split or non-split transactions. Omit for either. (optional) (default to undefined)
let isRecurring: boolean; //When set, restrict to recurring or non-recurring transactions. Omit for either. (optional) (default to undefined)
let importedFromMint: boolean; //When set, restrict to transactions imported from Mint or not. Omit for either. (optional) (default to undefined)
let syncedFromInstitution: boolean; //When set, restrict to transactions synced from the institution feed or not. Omit for either. (optional) (default to undefined)
let needsReview: boolean; //When set, restrict to transactions that need review or do not. Omit for either. (optional) (default to undefined)
let transactionVisibility: 'hidden_transactions_only' | 'all_transactions'; //Scope of transactions to return. Omit (default) for non-hidden only. `hidden_transactions_only` returns only hidden; `all_transactions` returns both.  (optional) (default to undefined)

const { status, data } = await apiInstance.getCashflowBreakdown(
    start,
    end,
    accountIds,
    categoryIds,
    tagIds,
    search,
    hasAttachments,
    hasNotes,
    hideFromReports,
    isSplit,
    isRecurring,
    importedFromMint,
    syncedFromInstitution,
    needsReview,
    transactionVisibility
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **start** | [**string**] | Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|
| **end** | [**string**] | Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|
| **accountIds** | **Array&lt;string&gt;** | Filter by one or more Monarch account ids. Repeat the query param for each. Preferred over the legacy single &#x60;accountId&#x60; param; both are accepted and merged.  | (optional) defaults to undefined|
| **categoryIds** | **Array&lt;string&gt;** | Filter by one or more Monarch category ids. Repeat the query param for each. | (optional) defaults to undefined|
| **tagIds** | **Array&lt;string&gt;** | Filter by one or more transaction tag ids. Repeat the query param for each. | (optional) defaults to undefined|
| **search** | [**string**] | Free-text search against merchant / notes / category. | (optional) defaults to undefined|
| **hasAttachments** | [**boolean**] | When set, restrict to transactions that do or do not have attachments. Omit for either. | (optional) defaults to undefined|
| **hasNotes** | [**boolean**] | When set, restrict to transactions that do or do not have notes. Omit for either. | (optional) defaults to undefined|
| **hideFromReports** | [**boolean**] | When set, restrict to transactions that are or are not hidden from reports. Omit for either. | (optional) defaults to undefined|
| **isSplit** | [**boolean**] | When set, restrict to split or non-split transactions. Omit for either. | (optional) defaults to undefined|
| **isRecurring** | [**boolean**] | When set, restrict to recurring or non-recurring transactions. Omit for either. | (optional) defaults to undefined|
| **importedFromMint** | [**boolean**] | When set, restrict to transactions imported from Mint or not. Omit for either. | (optional) defaults to undefined|
| **syncedFromInstitution** | [**boolean**] | When set, restrict to transactions synced from the institution feed or not. Omit for either. | (optional) defaults to undefined|
| **needsReview** | [**boolean**] | When set, restrict to transactions that need review or do not. Omit for either. | (optional) defaults to undefined|
| **transactionVisibility** | [**&#39;hidden_transactions_only&#39; | &#39;all_transactions&#39;**]**Array<&#39;hidden_transactions_only&#39; &#124; &#39;all_transactions&#39;>** | Scope of transactions to return. Omit (default) for non-hidden only. &#x60;hidden_transactions_only&#x60; returns only hidden; &#x60;all_transactions&#x60; returns both.  | (optional) defaults to undefined|


### Return type

**GetCashflowBreakdownResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Four buckets - byCategory / byCategoryGroup / byMerchant / summary. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getCashflowDashboard**
> GetCashflowDashboardResponse getCashflowDashboard()

Returns daily-bucket expense totals. Lightweight series for charting spend over a date window. Sparser shape than `/v1/cashflow`, with only the day-grain summary. 

### Example

```typescript
import {
    TransactionsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TransactionsApi(configuration);

let start: string; //Lower bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)
let end: string; //Upper bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)

const { status, data } = await apiInstance.getCashflowDashboard(
    start,
    end
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **start** | [**string**] | Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|
| **end** | [**string**] | Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|


### Return type

**GetCashflowDashboardResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Day-by-day expense totals. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getCashflowEntities**
> GetCashflowEntitiesResponse getCashflowEntities()

Three breakdowns over the same date window: by category, by category group, by merchant. Plus a totals summary (income, expense, savings, savings rate). Great for \"where did my money go\" prompts. 

### Example

```typescript
import {
    TransactionsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TransactionsApi(configuration);

let start: string; //Lower bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)
let end: string; //Upper bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)

const { status, data } = await apiInstance.getCashflowEntities(
    start,
    end
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **start** | [**string**] | Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|
| **end** | [**string**] | Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|


### Return type

**GetCashflowEntitiesResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Three breakdowns plus summary. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getCashflowFiltered**
> GetCashflowFilteredResponse getCashflowFiltered()

Filterable cashflow query: summary aggregates plus year/month/quarter bucketing AND category/group/merchant breakdowns in one shot. Filter by accounts, categories, category groups, merchants, tags. 

### Example

```typescript
import {
    TransactionsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TransactionsApi(configuration);

let start: string; //Lower bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)
let end: string; //Upper bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)
let accountId: Array<string>; //Filter to one or more account ids (repeat the param). (optional) (default to undefined)
let categoryId: Array<string>; //Filter to one or more category ids. (optional) (default to undefined)
let categoryGroupId: Array<string>; //Filter to one or more category-group ids. (optional) (default to undefined)
let merchantId: Array<string>; //Filter to one or more merchant ids. (optional) (default to undefined)
let tagId: Array<string>; //Filter to one or more tag ids. (optional) (default to undefined)

const { status, data } = await apiInstance.getCashflowFiltered(
    start,
    end,
    accountId,
    categoryId,
    categoryGroupId,
    merchantId,
    tagId
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **start** | [**string**] | Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|
| **end** | [**string**] | Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|
| **accountId** | **Array&lt;string&gt;** | Filter to one or more account ids (repeat the param). | (optional) defaults to undefined|
| **categoryId** | **Array&lt;string&gt;** | Filter to one or more category ids. | (optional) defaults to undefined|
| **categoryGroupId** | **Array&lt;string&gt;** | Filter to one or more category-group ids. | (optional) defaults to undefined|
| **merchantId** | **Array&lt;string&gt;** | Filter to one or more merchant ids. | (optional) defaults to undefined|
| **tagId** | **Array&lt;string&gt;** | Filter to one or more tag ids. | (optional) defaults to undefined|


### Return type

**GetCashflowFilteredResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Summary + bucketed + entity-grouped cashflow. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getCashflowTimeframe**
> GetCashflowTimeframeResponse getCashflowTimeframe()

Returns income, expense, savings, and savings-rate aggregated three ways: by year, by month, by quarter. Good for \"how does this year compare to last\" prompts. 

### Example

```typescript
import {
    TransactionsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TransactionsApi(configuration);

let start: string; //Lower bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)
let end: string; //Upper bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)

const { status, data } = await apiInstance.getCashflowTimeframe(
    start,
    end
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **start** | [**string**] | Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|
| **end** | [**string**] | Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|


### Return type

**GetCashflowTimeframeResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Timeframe summaries. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getDownloadTransactionsSession**
> GetDownloadTransactionsSessionResponse getDownloadTransactionsSession()

Poll the async CSV download job started by `POST /v1/transactions/download`. Returns the current `status` (running / completed / failed) and, when completed, the signed `url` to fetch the CSV file from.  Poll cadence is up to the caller; typical clients re-check every 1-2 seconds until `url` is non-null. 

### Example

```typescript
import {
    TransactionsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TransactionsApi(configuration);

let sessionKey: string; //Session key returned by `POST /v1/transactions/download`. (default to undefined)

const { status, data } = await apiInstance.getDownloadTransactionsSession(
    sessionKey
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **sessionKey** | [**string**] | Session key returned by &#x60;POST /v1/transactions/download&#x60;. | defaults to undefined|


### Return type

**GetDownloadTransactionsSessionResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Current session state. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getReviewSummaryByUser**
> GetReviewSummaryByUserResponse getReviewSummaryByUser()

For each household member, how many transactions are currently flagged as needing review. Empty list = nothing in the review queue. 

### Example

```typescript
import {
    TransactionsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TransactionsApi(configuration);

const { status, data } = await apiInstance.getReviewSummaryByUser();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**GetReviewSummaryByUserResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Per-user review counts. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getSpendingDashboard**
> GetSpendingDashboardResponse getSpendingDashboard()

Compact spending widget for the home tab: total spend for the window, remaining budget, and the top spending categories. 

### Example

```typescript
import {
    TransactionsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TransactionsApi(configuration);

let start: string; //Lower bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)
let end: string; //Upper bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)

const { status, data } = await apiInstance.getSpendingDashboard(
    start,
    end
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **start** | [**string**] | Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|
| **end** | [**string**] | Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|


### Return type

**GetSpendingDashboardResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Dashboard widget data. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getSpendingTrends**
> GetSpendingTrendsResponse getSpendingTrends()

Period-over-period spend trend: current vs. previous total plus the top rising / falling categories by percent delta. Backs the \"Spending Trends\" widget under Insights and the dashboard.  `timeframe` is `week`, `month`, or `quarter`. Each compares the current period to the matching previous one. 

### Example

```typescript
import {
    TransactionsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TransactionsApi(configuration);

let timeframe: 'week' | 'month' | 'quarter'; // (optional) (default to 'month')

const { status, data } = await apiInstance.getSpendingTrends(
    timeframe
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **timeframe** | [**&#39;week&#39; | &#39;month&#39; | &#39;quarter&#39;**]**Array<&#39;week&#39; &#124; &#39;month&#39; &#124; &#39;quarter&#39;>** |  | (optional) defaults to 'month'|


### Return type

**GetSpendingTrendsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Current / previous totals + rising / falling categories. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getTransactionAuditLog**
> GetTransactionAuditLogResponse getTransactionAuditLog()

History of changes against one transaction. Each entry has the timestamp, actor, action, and old / new value for the field that changed. 

### Example

```typescript
import {
    TransactionsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TransactionsApi(configuration);

let id: string; //Monarch transaction id. (default to undefined)

const { status, data } = await apiInstance.getTransactionAuditLog(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch transaction id. | defaults to undefined|


### Return type

**GetTransactionAuditLogResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Audit entries (oldest first). |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getTransactionDetail**
> GetTransactionDetailResponse getTransactionDetail()

Returns the full denormalized tree for one transaction: amount, date, merchant (with logo), category, account, notes, tags, splits (if split), attachments, recurring-stream metadata, and review state.  Use when surfacing a transaction in a detail view, or before a PATCH to inspect current state. The list endpoint `GET /v1/transactions` returns a leaner shape per row - this endpoint is the right call when you need the full picture for one. 

### Example

```typescript
import {
    TransactionsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TransactionsApi(configuration);

let id: string; //Monarch transaction id. (default to undefined)

const { status, data } = await apiInstance.getTransactionDetail(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch transaction id. | defaults to undefined|


### Return type

**GetTransactionDetailResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Full transaction tree: splits, attachments, merchant, category. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getTransactionNotes**
> GetTransactionNotesResponse getTransactionNotes()

Standalone notes accessor for one transaction. Lighter than `/v1/transactions/{id}` when you only need the notes string. 

### Example

```typescript
import {
    TransactionsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TransactionsApi(configuration);

let id: string; //Monarch transaction id. (default to undefined)

const { status, data } = await apiInstance.getTransactionNotes(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch transaction id. | defaults to undefined|


### Return type

**GetTransactionNotesResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Note value. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getTransactionSplitTemplates**
> GetTransactionSplitTemplatesResponse getTransactionSplitTemplates()

Saved reusable percent-based split definitions (\"Costco run: 70% Groceries / 30% Household\"). The web split modal fires this to populate the \"Apply template\" dropdown.  Each template carries a list of percent-of-parent splits. Caller composes the actual `POST /v1/transactions/{id}/splits` request by multiplying the parent amount by each `percent`. 

### Example

```typescript
import {
    TransactionsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TransactionsApi(configuration);

const { status, data } = await apiInstance.getTransactionSplitTemplates();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**GetTransactionSplitTemplatesResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | All saved split templates. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getTransactionSplits**
> GetTransactionSplitsResponse getTransactionSplits()

Returns the child split rows of a parent transaction (e.g. a $120 grocery run split into $90 groceries + $30 household). Each split has its own amount, category, notes, and tags but inherits the parent\'s date and account.  Returns an empty `splits` array when the transaction isn\'t split (no error). The parent transaction summary is included on the response for convenience. 

### Example

```typescript
import {
    TransactionsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TransactionsApi(configuration);

let id: string; //Monarch transaction id. (default to undefined)

const { status, data } = await apiInstance.getTransactionSplits(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch transaction id. | defaults to undefined|


### Return type

**GetTransactionSplitsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Splits + parent transaction summary. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getTransactionsDashboard**
> GetTransactionsDashboardResponse getTransactionsDashboard()

Returns transaction rows scoped to a date window plus pagination, along with a totalCount, totalSelectableCount, and a rule-count sidecar. Lightweight shape suitable for dashboard widgets. 

### Example

```typescript
import {
    TransactionsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TransactionsApi(configuration);

let start: string; //Lower bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)
let end: string; //Upper bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)
let limit: number; //Page size. (optional) (default to undefined)
let offset: number; //Page offset. (optional) (default to undefined)

const { status, data } = await apiInstance.getTransactionsDashboard(
    start,
    end,
    limit,
    offset
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **start** | [**string**] | Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|
| **end** | [**string**] | Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|
| **limit** | [**number**] | Page size. | (optional) defaults to undefined|
| **offset** | [**number**] | Page offset. | (optional) defaults to undefined|


### Return type

**GetTransactionsDashboardResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Paginated transactions with totals. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getTransactionsDuplicates**
> GetTransactionsDuplicatesResponse getTransactionsDuplicates()

Server-side composite over `GET /v1/transactions`. Pulls the window and groups results by the python-lib `find_duplicate_transactions` key: `(date, amount, plaidName, accountId)`.  Using `plaidName` (the raw Plaid description) rather than `merchantName` (Monarch\'s normalized display name) avoids false positives: two genuine same-day same-merchant same-amount charges carry different `plaidName` reference strings. Only true double-inserts share the exact `plaidName`.  Returns only groups with size > 1. Useful for surfacing accidental double-posts after re-linking an institution (a known Monarch issue, particularly for Apple Card / Apple Cash / Apple Savings). 

### Example

```typescript
import {
    TransactionsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TransactionsApi(configuration);

let start: string; //Lower bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)
let end: string; //Upper bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)
let accountId: string; //Filter by a single Monarch account id. (optional) (default to undefined)
let accountIds: Array<string>; //Filter to multiple accounts. Merged with the legacy single-value `accountId` if both are passed.  (optional) (default to undefined)

const { status, data } = await apiInstance.getTransactionsDuplicates(
    start,
    end,
    accountId,
    accountIds
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **start** | [**string**] | Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|
| **end** | [**string**] | Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|
| **accountId** | [**string**] | Filter by a single Monarch account id. | (optional) defaults to undefined|
| **accountIds** | **Array&lt;string&gt;** | Filter to multiple accounts. Merged with the legacy single-value &#x60;accountId&#x60; if both are passed.  | (optional) defaults to undefined|


### Return type

**GetTransactionsDuplicatesResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Groups of likely-duplicate transactions in the window. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getTransactionsSummary**
> GetTransactionsSummaryResponse getTransactionsSummary()

Returns one summary row over the filtered transaction set: `count`, `sum`, `avg`, `min`, `max`, `first`, `last`. Useful for one-shot questions like \"how many Whole Foods runs this year\" or \"what\'s my average dining check\" without pulling the full transaction list.  All standard transaction filters apply (`search`, `categoryIds`, `accountIds`, `tagIds`, bool flags). For per-category breakdowns use `GET /v1/cashflow/breakdown`. For row-level data use `GET /v1/transactions`. 

### Example

```typescript
import {
    TransactionsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TransactionsApi(configuration);

let start: string; //Lower bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)
let end: string; //Upper bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)
let accountId: string; //Filter by a single Monarch account id. (optional) (default to undefined)
let accountIds: Array<string>; //Filter by one or more Monarch account ids. Repeat the query param for each. Preferred over the legacy single `accountId` param; both are accepted and merged.  (optional) (default to undefined)
let categoryIds: Array<string>; //Filter by one or more Monarch category ids. Repeat the query param for each. (optional) (default to undefined)
let tagIds: Array<string>; //Filter by one or more transaction tag ids. Repeat the query param for each. (optional) (default to undefined)
let search: string; //Free-text search against merchant / notes / category. (optional) (default to undefined)
let hasAttachments: boolean; //When set, restrict to transactions that do or do not have attachments. Omit for either. (optional) (default to undefined)
let hasNotes: boolean; //When set, restrict to transactions that do or do not have notes. Omit for either. (optional) (default to undefined)
let hideFromReports: boolean; //When set, restrict to transactions that are or are not hidden from reports. Omit for either. (optional) (default to undefined)
let isSplit: boolean; //When set, restrict to split or non-split transactions. Omit for either. (optional) (default to undefined)
let isRecurring: boolean; //When set, restrict to recurring or non-recurring transactions. Omit for either. (optional) (default to undefined)
let importedFromMint: boolean; //When set, restrict to transactions imported from Mint or not. Omit for either. (optional) (default to undefined)
let syncedFromInstitution: boolean; //When set, restrict to transactions synced from the institution feed or not. Omit for either. (optional) (default to undefined)
let needsReview: boolean; //When set, restrict to transactions that need review or do not. Omit for either. (optional) (default to undefined)
let transactionVisibility: 'hidden_transactions_only' | 'all_transactions'; //Scope of transactions to return. Omit (default) for non-hidden only. `hidden_transactions_only` returns only hidden; `all_transactions` returns both.  (optional) (default to undefined)

const { status, data } = await apiInstance.getTransactionsSummary(
    start,
    end,
    accountId,
    accountIds,
    categoryIds,
    tagIds,
    search,
    hasAttachments,
    hasNotes,
    hideFromReports,
    isSplit,
    isRecurring,
    importedFromMint,
    syncedFromInstitution,
    needsReview,
    transactionVisibility
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **start** | [**string**] | Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|
| **end** | [**string**] | Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|
| **accountId** | [**string**] | Filter by a single Monarch account id. | (optional) defaults to undefined|
| **accountIds** | **Array&lt;string&gt;** | Filter by one or more Monarch account ids. Repeat the query param for each. Preferred over the legacy single &#x60;accountId&#x60; param; both are accepted and merged.  | (optional) defaults to undefined|
| **categoryIds** | **Array&lt;string&gt;** | Filter by one or more Monarch category ids. Repeat the query param for each. | (optional) defaults to undefined|
| **tagIds** | **Array&lt;string&gt;** | Filter by one or more transaction tag ids. Repeat the query param for each. | (optional) defaults to undefined|
| **search** | [**string**] | Free-text search against merchant / notes / category. | (optional) defaults to undefined|
| **hasAttachments** | [**boolean**] | When set, restrict to transactions that do or do not have attachments. Omit for either. | (optional) defaults to undefined|
| **hasNotes** | [**boolean**] | When set, restrict to transactions that do or do not have notes. Omit for either. | (optional) defaults to undefined|
| **hideFromReports** | [**boolean**] | When set, restrict to transactions that are or are not hidden from reports. Omit for either. | (optional) defaults to undefined|
| **isSplit** | [**boolean**] | When set, restrict to split or non-split transactions. Omit for either. | (optional) defaults to undefined|
| **isRecurring** | [**boolean**] | When set, restrict to recurring or non-recurring transactions. Omit for either. | (optional) defaults to undefined|
| **importedFromMint** | [**boolean**] | When set, restrict to transactions imported from Mint or not. Omit for either. | (optional) defaults to undefined|
| **syncedFromInstitution** | [**boolean**] | When set, restrict to transactions synced from the institution feed or not. Omit for either. | (optional) defaults to undefined|
| **needsReview** | [**boolean**] | When set, restrict to transactions that need review or do not. Omit for either. | (optional) defaults to undefined|
| **transactionVisibility** | [**&#39;hidden_transactions_only&#39; | &#39;all_transactions&#39;**]**Array<&#39;hidden_transactions_only&#39; &#124; &#39;all_transactions&#39;>** | Scope of transactions to return. Omit (default) for non-hidden only. &#x60;hidden_transactions_only&#x60; returns only hidden; &#x60;all_transactions&#x60; returns both.  | (optional) defaults to undefined|


### Return type

**GetTransactionsSummaryResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | count / sum / avg / min-max / first-last. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listTransactions**
> ListTransactionsResponse listTransactions()

Returns transactions matching the filter set, **newest-first** within `[start, end]`. Use the `search` param for free-text search across merchant + notes + plaid name. Combine with `categoryIds`, `accountIds`, `tagIds` (all multi) to scope.  Date semantics: `start` is the **oldest allowed date**, NOT \"scroll forward from here\". `?start=2026-01-01&limit=10` returns the 10 newest txns on or after Jan 2026 (probably this week). To get January specifically: `?start=2026-01-01&end=2026-01-31`. To get older rows, bound `end` earlier or paginate with `offset`.  Bool filters (`hasAttachments`, `isRecurring`, `hideFromReports`, `needsReview`, etc.) accept true/false; omit to not filter on that dimension. Returns the page plus `totalCount` for the filter set. For aggregate stats over the same filter use `GET /v1/transactions/summary`; for the single-row detail use `GET /v1/transactions/{id}`. 

### Example

```typescript
import {
    TransactionsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TransactionsApi(configuration);

let start: string; //Lower bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)
let end: string; //Upper bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)
let limit: number; //Page size. (optional) (default to undefined)
let offset: number; //Page offset. (optional) (default to undefined)
let accountId: string; //Filter by a single Monarch account id. (optional) (default to undefined)
let accountIds: Array<string>; //Filter by one or more Monarch account ids. Repeat the query param for each. Preferred over the legacy single `accountId` param; both are accepted and merged.  (optional) (default to undefined)
let categoryIds: Array<string>; //Filter by one or more Monarch category ids. Repeat the query param for each. (optional) (default to undefined)
let tagIds: Array<string>; //Filter by one or more transaction tag ids. Repeat the query param for each. (optional) (default to undefined)
let orderBy: 'date' | 'amount'; //Monarch sort enum. Both values sort descending. (optional) (default to undefined)
let search: string; //Free-text search against merchant / notes / category. (optional) (default to undefined)
let hasAttachments: boolean; //When set, restrict to transactions that do or do not have attachments. Omit for either. (optional) (default to undefined)
let hasNotes: boolean; //When set, restrict to transactions that do or do not have notes. Omit for either. (optional) (default to undefined)
let hideFromReports: boolean; //When set, restrict to transactions that are or are not hidden from reports. Omit for either. (optional) (default to undefined)
let isSplit: boolean; //When set, restrict to split or non-split transactions. Omit for either. (optional) (default to undefined)
let isRecurring: boolean; //When set, restrict to recurring or non-recurring transactions. Omit for either. (optional) (default to undefined)
let importedFromMint: boolean; //When set, restrict to transactions imported from Mint or not. Omit for either. (optional) (default to undefined)
let syncedFromInstitution: boolean; //When set, restrict to transactions synced from the institution feed or not. Omit for either. (optional) (default to undefined)
let needsReview: boolean; //When set, restrict to transactions that need review or do not. Omit for either. (optional) (default to undefined)
let transactionVisibility: 'hidden_transactions_only' | 'all_transactions'; //Scope of transactions to return. Omit (default) for non-hidden only. `hidden_transactions_only` returns only hidden; `all_transactions` returns both.  (optional) (default to undefined)

const { status, data } = await apiInstance.listTransactions(
    start,
    end,
    limit,
    offset,
    accountId,
    accountIds,
    categoryIds,
    tagIds,
    orderBy,
    search,
    hasAttachments,
    hasNotes,
    hideFromReports,
    isSplit,
    isRecurring,
    importedFromMint,
    syncedFromInstitution,
    needsReview,
    transactionVisibility
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **start** | [**string**] | Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|
| **end** | [**string**] | Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|
| **limit** | [**number**] | Page size. | (optional) defaults to undefined|
| **offset** | [**number**] | Page offset. | (optional) defaults to undefined|
| **accountId** | [**string**] | Filter by a single Monarch account id. | (optional) defaults to undefined|
| **accountIds** | **Array&lt;string&gt;** | Filter by one or more Monarch account ids. Repeat the query param for each. Preferred over the legacy single &#x60;accountId&#x60; param; both are accepted and merged.  | (optional) defaults to undefined|
| **categoryIds** | **Array&lt;string&gt;** | Filter by one or more Monarch category ids. Repeat the query param for each. | (optional) defaults to undefined|
| **tagIds** | **Array&lt;string&gt;** | Filter by one or more transaction tag ids. Repeat the query param for each. | (optional) defaults to undefined|
| **orderBy** | [**&#39;date&#39; | &#39;amount&#39;**]**Array<&#39;date&#39; &#124; &#39;amount&#39;>** | Monarch sort enum. Both values sort descending. | (optional) defaults to undefined|
| **search** | [**string**] | Free-text search against merchant / notes / category. | (optional) defaults to undefined|
| **hasAttachments** | [**boolean**] | When set, restrict to transactions that do or do not have attachments. Omit for either. | (optional) defaults to undefined|
| **hasNotes** | [**boolean**] | When set, restrict to transactions that do or do not have notes. Omit for either. | (optional) defaults to undefined|
| **hideFromReports** | [**boolean**] | When set, restrict to transactions that are or are not hidden from reports. Omit for either. | (optional) defaults to undefined|
| **isSplit** | [**boolean**] | When set, restrict to split or non-split transactions. Omit for either. | (optional) defaults to undefined|
| **isRecurring** | [**boolean**] | When set, restrict to recurring or non-recurring transactions. Omit for either. | (optional) defaults to undefined|
| **importedFromMint** | [**boolean**] | When set, restrict to transactions imported from Mint or not. Omit for either. | (optional) defaults to undefined|
| **syncedFromInstitution** | [**boolean**] | When set, restrict to transactions synced from the institution feed or not. Omit for either. | (optional) defaults to undefined|
| **needsReview** | [**boolean**] | When set, restrict to transactions that need review or do not. Omit for either. | (optional) defaults to undefined|
| **transactionVisibility** | [**&#39;hidden_transactions_only&#39; | &#39;all_transactions&#39;**]**Array<&#39;hidden_transactions_only&#39; &#124; &#39;all_transactions&#39;>** | Scope of transactions to return. Omit (default) for non-hidden only. &#x60;hidden_transactions_only&#x60; returns only hidden; &#x60;all_transactions&#x60; returns both.  | (optional) defaults to undefined|


### Return type

**ListTransactionsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Page of transactions + totalCount. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **markAsRecurring**
> MarkAsRecurringResponse markAsRecurring(markAsRecurringRequest)

The inverse of `POST /v1/transactions/{id}/not-recurring`. Tells Monarch the transaction IS the first instance of a recurring stream at the given `frequency` (`monthly`, `weekly`, `quarterly`, `yearly`, `biweekly`). Monarch creates the stream definition and returns its id.  Use to teach Monarch a stream it missed (a new subscription, a private-vendor recurring invoice). 

### Example

```typescript
import {
    TransactionsApi,
    Configuration,
    MarkAsRecurringRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TransactionsApi(configuration);

let id: string; //Monarch transaction id. (default to undefined)
let markAsRecurringRequest: MarkAsRecurringRequest; //

const { status, data } = await apiInstance.markAsRecurring(
    id,
    markAsRecurringRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **markAsRecurringRequest** | **MarkAsRecurringRequest**|  | |
| **id** | [**string**] | Monarch transaction id. | defaults to undefined|


### Return type

**MarkAsRecurringResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Confirmation + the new stream ref. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **markTransactionAsReviewed**
> MarkTransactionAsReviewedResponse markTransactionAsReviewed()

Single-shot helper: sets `reviewed=true` on one transaction. Equivalent to `PATCH /v1/transactions/{id}` with `{\"reviewed\": true}` but smaller in input (no body required) and output (only `id`, `reviewedAt`, `needsReview`).  Use from review/triage flows where the assistant just needs to dispatch a mark-as-reviewed without rewriting the whole transaction tree.  To un-mark, send `PATCH /v1/transactions/{id}` with `{\"reviewed\": false}`. 

### Example

```typescript
import {
    TransactionsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TransactionsApi(configuration);

let id: string; //Monarch transaction id. (default to undefined)

const { status, data } = await apiInstance.markTransactionAsReviewed(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch transaction id. | defaults to undefined|


### Return type

**MarkTransactionAsReviewedResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Updated review-state fields. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **markTransactionStreamAsNotRecurring**
> MarkTransactionStreamAsNotRecurringResponse markTransactionStreamAsNotRecurring()

Tells Monarch that the recurring stream a transaction is attached to is NOT actually recurring. Used to dismiss false-positive recurrence detections.  Important: Monarch\'s mutation takes a `streamId`, NOT a transaction id. Pass the transaction\'s `stream.id` (visible on the transaction detail) as the path `{id}`. 

### Example

```typescript
import {
    TransactionsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TransactionsApi(configuration);

let id: string; //Monarch transaction id. (default to undefined)

const { status, data } = await apiInstance.markTransactionStreamAsNotRecurring(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch transaction id. | defaults to undefined|


### Return type

**MarkTransactionStreamAsNotRecurringResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Confirmation flag from Monarch. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **matchSearchTransactions**
> MatchSearchTransactionsResponse matchSearchTransactions()

Free-text transaction lookup powering the web \"find a match\" picker (used in split, link-to-goal, and recurring-merge flows). Returns a lean shape per row: id, amount, date, plaid name, merchant + account references.  Different from the canonical `GET /v1/transactions` in two ways: only the `search` filter is supported, and the result shape is the slim picker shape rather than the full transaction row. 

### Example

```typescript
import {
    TransactionsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TransactionsApi(configuration);

let search: string; //Free-text query against merchant + plaid name. (optional) (default to undefined)
let limit: number; //Max results. (optional) (default to 20)

const { status, data } = await apiInstance.matchSearchTransactions(
    search,
    limit
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **search** | [**string**] | Free-text query against merchant + plaid name. | (optional) defaults to undefined|
| **limit** | [**number**] | Max results. | (optional) defaults to 20|


### Return type

**MatchSearchTransactionsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Match candidates. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **moveTransactions**
> MoveTransactionsResponse moveTransactions(moveTransactionsRequest)

Reassign one or more transactions from their current account to a target account. Use when reconciling a mis-categorized import (e.g. Plaid bucketed a charge under the wrong account) or after a manual merge.  Returns the count of transactions Monarch actually moved, plus a flat error array (one message per failed transaction). 

### Example

```typescript
import {
    TransactionsApi,
    Configuration,
    MoveTransactionsRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TransactionsApi(configuration);

let moveTransactionsRequest: MoveTransactionsRequest; //

const { status, data } = await apiInstance.moveTransactions(
    moveTransactionsRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **moveTransactionsRequest** | **MoveTransactionsRequest**|  | |


### Return type

**MoveTransactionsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Move result. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **setTransactionTags**
> SetTransactionTagsResponse setTransactionTags(setTransactionTagsRequest)

Wholesale-replaces every tag on a transaction. Send the complete final tag id list - this is NOT a delta. To add a tag without losing the existing ones, read current tags first via `GET /v1/transactions/{id}` then PUT the merged list.  Empty list `[]` clears all tags. Tag ids come from `GET /v1/tags`. For bulk tag changes across many transactions use `PATCH /v1/transactions/bulk`. 

### Example

```typescript
import {
    TransactionsApi,
    Configuration,
    SetTransactionTagsRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TransactionsApi(configuration);

let id: string; //Monarch transaction id. (default to undefined)
let setTransactionTagsRequest: SetTransactionTagsRequest; //

const { status, data } = await apiInstance.setTransactionTags(
    id,
    setTransactionTagsRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **setTransactionTagsRequest** | **SetTransactionTagsRequest**|  | |
| **id** | [**string**] | Monarch transaction id. | defaults to undefined|


### Return type

**SetTransactionTagsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Tag set after the overwrite. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **startDownloadTransactions**
> StartDownloadTransactionsResponse startDownloadTransactions(startDownloadTransactionsRequest)

Kick off the async \"download my transactions as CSV\" job Monarch backs the Web download button with. Returns a `sessionKey` to poll via `GET /v1/transactions/download/{sessionKey}` until the CSV `url` is ready.  Filters mirror `GET /v1/transactions`: pass a JSON map under `filters` (search string, categoryIds, accountIds, date window). 

### Example

```typescript
import {
    TransactionsApi,
    Configuration,
    StartDownloadTransactionsRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TransactionsApi(configuration);

let startDownloadTransactionsRequest: StartDownloadTransactionsRequest; //

const { status, data } = await apiInstance.startDownloadTransactions(
    startDownloadTransactionsRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **startDownloadTransactionsRequest** | **StartDownloadTransactionsRequest**|  | |


### Return type

**StartDownloadTransactionsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Session key + initial status. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updateTransaction**
> UpdateTransactionResponse updateTransaction(updateTransactionRequest)

Patches one transaction. Only fields present in the body are forwarded to Monarch; omit a field to leave it untouched.  Common edits: `categoryId` (re-categorize), `merchantName` (rename via the override), `notes`, `date`, `amount` (manual accounts only - Plaid will overwrite on next sync), `hideFromReports`, `needsReview`.  For tag mutations use `PUT /v1/transactions/{id}/tags` instead - tags are stored separately. For wholesale edits across many transactions use `PATCH /v1/transactions/bulk`. 

### Example

```typescript
import {
    TransactionsApi,
    Configuration,
    UpdateTransactionRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TransactionsApi(configuration);

let id: string; //Monarch transaction id. (default to undefined)
let updateTransactionRequest: UpdateTransactionRequest; //

const { status, data } = await apiInstance.updateTransaction(
    id,
    updateTransactionRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **updateTransactionRequest** | **UpdateTransactionRequest**|  | |
| **id** | [**string**] | Monarch transaction id. | defaults to undefined|


### Return type

**UpdateTransactionResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Updated transaction. |  -  |
|**400** | Validation failed. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updateTransactionSplits**
> UpdateTransactionSplitsResponse updateTransactionSplits(updateTransactionSplitsRequest)

Wholesale-replaces the split set on a transaction. Send the complete new list - this is NOT a delta operation. Each split needs `amount` (signed, same sign as the parent) plus `categoryId` and optional `notes` / `merchantName`.  Sum of split amounts must equal the parent transaction\'s amount exactly - Monarch rejects with 422 PayloadError on any mismatch. Send an empty list to remove all splits and revert the transaction to a single-row entry. 

### Example

```typescript
import {
    TransactionsApi,
    Configuration,
    UpdateTransactionSplitsRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TransactionsApi(configuration);

let id: string; //Monarch transaction id. (default to undefined)
let updateTransactionSplitsRequest: UpdateTransactionSplitsRequest; //

const { status, data } = await apiInstance.updateTransactionSplits(
    id,
    updateTransactionSplitsRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **updateTransactionSplitsRequest** | **UpdateTransactionSplitsRequest**|  | |
| **id** | [**string**] | Monarch transaction id. | defaults to undefined|


### Return type

**UpdateTransactionSplitsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | New split set. |  -  |
|**422** | Sum mismatch or other PayloadError. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **uploadTransactionAttachment**
> UploadTransactionAttachmentResponse uploadTransactionAttachment()

Three-step flow handled internally by the proxy: (1) asks Monarch for signed Cloudinary upload params, (2) forwards the file to Cloudinary, (3) tells Monarch to link the upload to the transaction. Caller sees a single multipart/form-data POST with the file. 

### Example

```typescript
import {
    TransactionsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TransactionsApi(configuration);

let id: string; //Monarch transaction id. (default to undefined)
let file: File; //Receipt photo, scan, or PDF. (default to undefined)

const { status, data } = await apiInstance.uploadTransactionAttachment(
    id,
    file
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch transaction id. | defaults to undefined|
| **file** | [**File**] | Receipt photo, scan, or PDF. | defaults to undefined|


### Return type

**UploadTransactionAttachmentResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | The created attachment. |  -  |
|**422** | Monarch rejected the upload (PayloadError). |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

