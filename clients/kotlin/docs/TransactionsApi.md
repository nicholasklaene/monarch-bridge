# TransactionsApi

All URIs are relative to *http://localhost:9084*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**bulkDeleteTransactions**](TransactionsApi.md#bulkDeleteTransactions) | **POST** /v1/transactions/bulk-delete | Bulk-delete transactions |
| [**bulkUpdateTransactions**](TransactionsApi.md#bulkUpdateTransactions) | **PATCH** /v1/transactions/bulk | Bulk-update transactions |
| [**createTransaction**](TransactionsApi.md#createTransaction) | **POST** /v1/transactions | Create a manual transaction |
| [**deleteTransaction**](TransactionsApi.md#deleteTransaction) | **DELETE** /v1/transactions/{id} | Delete a transaction |
| [**explainTransaction**](TransactionsApi.md#explainTransaction) | **GET** /v1/transactions/explain/{id} | AI explanation for one transaction |
| [**explainTransactionByPath**](TransactionsApi.md#explainTransactionByPath) | **GET** /v1/transactions/{id}/explain | AI explanation for one transaction |
| [**getAccountsForTransactionFilter**](TransactionsApi.md#getAccountsForTransactionFilter) | **GET** /v1/transactions/accounts-for-filter | Accounts that match a transaction filter |
| [**getAttachment**](TransactionsApi.md#getAttachment) | **GET** /v1/attachments/{id} | Attachment detail |
| [**getCashflow**](TransactionsApi.md#getCashflow) | **GET** /v1/cashflow | Income, expense, and savings summary for a window |
| [**getCashflowBreakdown**](TransactionsApi.md#getCashflowBreakdown) | **GET** /v1/cashflow/breakdown | Cashflow broken down by category, group, merchant |
| [**getCashflowDashboard**](TransactionsApi.md#getCashflowDashboard) | **GET** /v1/cashflow/dashboard | Day-by-day expense series for a date window |
| [**getCashflowEntities**](TransactionsApi.md#getCashflowEntities) | **GET** /v1/cashflow/entities | Cashflow by category / category-group / merchant |
| [**getCashflowFiltered**](TransactionsApi.md#getCashflowFiltered) | **GET** /v1/cashflow/filtered | Filtered cashflow page (summary + four breakdowns) |
| [**getCashflowTimeframe**](TransactionsApi.md#getCashflowTimeframe) | **GET** /v1/cashflow/timeframe | Year / month / quarter cashflow summaries for a date window |
| [**getDownloadTransactionsSession**](TransactionsApi.md#getDownloadTransactionsSession) | **GET** /v1/transactions/download/{sessionKey} | Poll a transaction download session |
| [**getReviewSummaryByUser**](TransactionsApi.md#getReviewSummaryByUser) | **GET** /v1/transactions/review-summary | Review-queue counts by household user |
| [**getSpendingDashboard**](TransactionsApi.md#getSpendingDashboard) | **GET** /v1/dashboard/spending | Home-tab spending dashboard widget |
| [**getSpendingTrends**](TransactionsApi.md#getSpendingTrends) | **GET** /v1/dashboard/spending/trends | Spending trends (period-over-period) |
| [**getTransactionAuditLog**](TransactionsApi.md#getTransactionAuditLog) | **GET** /v1/transactions/{id}/audit | Transaction audit log |
| [**getTransactionDetail**](TransactionsApi.md#getTransactionDetail) | **GET** /v1/transactions/{id} | Single-transaction full detail |
| [**getTransactionNotes**](TransactionsApi.md#getTransactionNotes) | **GET** /v1/transactions/{id}/notes | Transaction notes |
| [**getTransactionSplitTemplates**](TransactionsApi.md#getTransactionSplitTemplates) | **GET** /v1/transactions/split-templates | Saved split templates |
| [**getTransactionSplits**](TransactionsApi.md#getTransactionSplits) | **GET** /v1/transactions/{id}/splits | Splits of one transaction |
| [**getTransactionsDashboard**](TransactionsApi.md#getTransactionsDashboard) | **GET** /v1/transactions/dashboard | Dashboard transactions list (with totals + rule count) |
| [**getTransactionsDuplicates**](TransactionsApi.md#getTransactionsDuplicates) | **GET** /v1/transactions/duplicates | Groups of likely-duplicate transactions |
| [**getTransactionsSummary**](TransactionsApi.md#getTransactionsSummary) | **GET** /v1/transactions/summary | Aggregate stats across a transaction window |
| [**listTransactions**](TransactionsApi.md#listTransactions) | **GET** /v1/transactions | Search and list transactions with rich filtering |
| [**markAsRecurring**](TransactionsApi.md#markAsRecurring) | **POST** /v1/transactions/{id}/recurring | Mark a transaction as the start of a recurring stream |
| [**markTransactionAsReviewed**](TransactionsApi.md#markTransactionAsReviewed) | **POST** /v1/transactions/{id}/reviewed | Mark a transaction as reviewed |
| [**markTransactionStreamAsNotRecurring**](TransactionsApi.md#markTransactionStreamAsNotRecurring) | **POST** /v1/transactions/{id}/not-recurring | Mark a transaction&#39;s recurring-stream as not-recurring |
| [**matchSearchTransactions**](TransactionsApi.md#matchSearchTransactions) | **GET** /v1/transactions/match-search | Fuzzy transaction search for \&quot;find a match\&quot; |
| [**moveTransactions**](TransactionsApi.md#moveTransactions) | **POST** /v1/transactions/move | Move transactions between accounts |
| [**setTransactionTags**](TransactionsApi.md#setTransactionTags) | **PUT** /v1/transactions/{id}/tags | Overwrite the tag set on a transaction |
| [**startDownloadTransactions**](TransactionsApi.md#startDownloadTransactions) | **POST** /v1/transactions/download | Start a transaction CSV download session |
| [**updateTransaction**](TransactionsApi.md#updateTransaction) | **PATCH** /v1/transactions/{id} | Partial-update a transaction |
| [**updateTransactionSplits**](TransactionsApi.md#updateTransactionSplits) | **POST** /v1/transactions/{id}/splits | Replace the splits on a transaction |
| [**uploadTransactionAttachment**](TransactionsApi.md#uploadTransactionAttachment) | **POST** /v1/transactions/{id}/attachments | Attach a receipt photo or PDF to a transaction |


<a id="bulkDeleteTransactions"></a>
# **bulkDeleteTransactions**
> BulkDeleteTransactionsResponse bulkDeleteTransactions(bulkDeleteTransactionsRequest)

Bulk-delete transactions

Forwards Monarch&#39;s &#x60;bulkDeleteTransactions&#x60; mutation. Same two-mode selection as bulk-update:  - &#x60;allSelected: false&#x60; + &#x60;selectedTransactionIds: [a,b,c]&#x60; to delete exactly N. - &#x60;allSelected: true&#x60; + &#x60;filters: {...}&#x60; + optional &#x60;excludedTransactionIds: [...]&#x60;   to delete everything matching minus a hand-picked exclusion list.  &#x60;expectedAffectedTransactionCount&#x60; is the same race-prevention guard as bulk-update. Destructive: prefer &#x60;tx duplicates&#x60; first to scope the selection. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TransactionsApi()
val bulkDeleteTransactionsRequest : BulkDeleteTransactionsRequest =  // BulkDeleteTransactionsRequest | 
try {
    val result : BulkDeleteTransactionsResponse = apiInstance.bulkDeleteTransactions(bulkDeleteTransactionsRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TransactionsApi#bulkDeleteTransactions")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TransactionsApi#bulkDeleteTransactions")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **bulkDeleteTransactionsRequest** | [**BulkDeleteTransactionsRequest**](BulkDeleteTransactionsRequest.md)|  | |

### Return type

[**BulkDeleteTransactionsResponse**](BulkDeleteTransactionsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="bulkUpdateTransactions"></a>
# **bulkUpdateTransactions**
> BulkUpdateTransactionsResponse bulkUpdateTransactions(bulkUpdateTransactionsRequest)

Bulk-update transactions

Forwards Monarch&#39;s &#x60;bulkUpdateTransactions&#x60; mutation. Two selection modes are supported on the same shape (&#x60;allSelected&#x60; discriminates):  - &#x60;allSelected: false&#x60; + &#x60;selectedTransactionIds: [a,b,c]&#x60; is the common case:   apply &#x60;updates&#x60; to exactly those N transactions. - &#x60;allSelected: true&#x60; + &#x60;filters: {...}&#x60; + optional &#x60;excludedTransactionIds: [...]&#x60;   is the \&quot;select everything matching the filter then minus these\&quot; pattern.  &#x60;expectedAffectedTransactionCount&#x60; is a safety check. Monarch refuses the mutation if its actual affected-row count differs from this number (race-prevention).  The &#x60;updates&#x60; object is Monarch&#39;s &#x60;TransactionUpdateParams&#x60; input shape (same field surface as &#x60;PATCH /v1/transactions/{id}&#x60;: categoryId, merchantName, notes, date, hide, etc.). 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TransactionsApi()
val bulkUpdateTransactionsRequest : BulkUpdateTransactionsRequest =  // BulkUpdateTransactionsRequest | 
try {
    val result : BulkUpdateTransactionsResponse = apiInstance.bulkUpdateTransactions(bulkUpdateTransactionsRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TransactionsApi#bulkUpdateTransactions")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TransactionsApi#bulkUpdateTransactions")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **bulkUpdateTransactionsRequest** | [**BulkUpdateTransactionsRequest**](BulkUpdateTransactionsRequest.md)|  | |

### Return type

[**BulkUpdateTransactionsResponse**](BulkUpdateTransactionsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="createTransaction"></a>
# **createTransaction**
> CreateTransactionResponse createTransaction(createTransactionRequest)

Create a manual transaction

Adds a transaction by hand into a specific account. Typically used for cash spending, manually-tracked accounts, or to record an item Plaid missed.  Required: &#x60;accountId&#x60;, &#x60;date&#x60;, &#x60;amount&#x60; (signed: negative for spending, positive for income/refund), and &#x60;merchantName&#x60;. Optional: &#x60;categoryId&#x60;, &#x60;notes&#x60;, &#x60;hideFromReports&#x60;. Skips Monarch&#39;s auto- categorization rule pass - the new transaction lands with exactly the category you supplied (or uncategorized).  For receipt attachment use &#x60;POST /v1/transactions/{id}/attachment&#x60; after the create. PayloadError yields 422 on Monarch-side rejection. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TransactionsApi()
val createTransactionRequest : CreateTransactionRequest =  // CreateTransactionRequest | 
try {
    val result : CreateTransactionResponse = apiInstance.createTransaction(createTransactionRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TransactionsApi#createTransaction")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TransactionsApi#createTransaction")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **createTransactionRequest** | [**CreateTransactionRequest**](CreateTransactionRequest.md)|  | |

### Return type

[**CreateTransactionResponse**](CreateTransactionResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="deleteTransaction"></a>
# **deleteTransaction**
> DeleteAccountResponse deleteTransaction(id)

Delete a transaction

Removes one transaction. **Destructive** - the row is gone from Monarch, won&#39;t reappear on next sync, and disappears from all aggregates (cashflow, budgets, summaries) for past windows.  Use for cash entries the user wants to undo or for confirmed duplicate Plaid imports. For bulk cleanup use &#x60;POST /v1/transactions/bulk-delete&#x60; (supports filter-based deletes too). For likely-duplicate detection across a window use &#x60;GET /v1/transactions/duplicates&#x60;. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TransactionsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch transaction id.
try {
    val result : DeleteAccountResponse = apiInstance.deleteTransaction(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TransactionsApi#deleteTransaction")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TransactionsApi#deleteTransaction")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **kotlin.String**| Monarch transaction id. | |

### Return type

[**DeleteAccountResponse**](DeleteAccountResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="explainTransaction"></a>
# **explainTransaction**
> ExplainTransactionResponse explainTransaction(id)

AI explanation for one transaction

Monarch&#39;s AI-generated explanation for why a transaction was categorized the way it was. Useful for surfacing context in audit or review flows. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TransactionsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch transaction id.
try {
    val result : ExplainTransactionResponse = apiInstance.explainTransaction(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TransactionsApi#explainTransaction")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TransactionsApi#explainTransaction")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **kotlin.String**| Monarch transaction id. | |

### Return type

[**ExplainTransactionResponse**](ExplainTransactionResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="explainTransactionByPath"></a>
# **explainTransactionByPath**
> ExplainTransactionResponse explainTransactionByPath(id)

AI explanation for one transaction

Monarch&#39;s AI-generated explanation for why a transaction was categorized the way it was. Useful for surfacing context in audit or review flows.  Companion to &#x60;GET /v1/transactions/{id}&#x60; - the detail call returns the raw fields, this call returns Monarch&#39;s narrated rationale. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TransactionsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch transaction id.
try {
    val result : ExplainTransactionResponse = apiInstance.explainTransactionByPath(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TransactionsApi#explainTransactionByPath")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TransactionsApi#explainTransactionByPath")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **kotlin.String**| Monarch transaction id. | |

### Return type

[**ExplainTransactionResponse**](ExplainTransactionResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getAccountsForTransactionFilter"></a>
# **getAccountsForTransactionFilter**
> GetAccountsForTransactionFilterResponse getAccountsForTransactionFilter(start, end)

Accounts that match a transaction filter

Returns the accounts that would be touched by a bulk transaction operation given the supplied filter (date window only here for simplicity; extends to full filter via repeat params). 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TransactionsApi()
val start : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Lower bound (inclusive), `YYYY-MM-DD`.
val end : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Upper bound (inclusive), `YYYY-MM-DD`.
try {
    val result : GetAccountsForTransactionFilterResponse = apiInstance.getAccountsForTransactionFilter(start, end)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TransactionsApi#getAccountsForTransactionFilter")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TransactionsApi#getAccountsForTransactionFilter")
    e.printStackTrace()
}
```

### Parameters
| **start** | **java.time.LocalDate**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **end** | **java.time.LocalDate**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |

### Return type

[**GetAccountsForTransactionFilterResponse**](GetAccountsForTransactionFilterResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getAttachment"></a>
# **getAttachment**
> GetAttachmentResponse getAttachment(id)

Attachment detail

Resolve an attachment id to its &#x60;originalAssetUrl&#x60; (a pre-signed download URL). Use the URL to GET the underlying file from Monarch&#39;s storage backend. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TransactionsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch transaction-attachment id (UUID).
try {
    val result : GetAttachmentResponse = apiInstance.getAttachment(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TransactionsApi#getAttachment")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TransactionsApi#getAttachment")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **kotlin.String**| Monarch transaction-attachment id (UUID). | |

### Return type

[**GetAttachmentResponse**](GetAttachmentResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getCashflow"></a>
# **getCashflow**
> GetCashflowResponse getCashflow(start, end, accountIds, categoryIds, tagIds, search, hasAttachments, hasNotes, hideFromReports, isSplit, isRecurring, importedFromMint, syncedFromInstitution, needsReview, transactionVisibility)

Income, expense, and savings summary for a window

Returns the four headline numbers for a date range: total income, total expense, net savings (income minus expense), and savings rate (net savings divided by income). Single row, no per-category breakdown.  Use for dashboard summary tiles or to drive a savings-rate trend chart by calling repeatedly across months. For the per-category / per-merchant breakdown call &#x60;GET /v1/cashflow/breakdown&#x60; instead.  All the standard transaction filters apply (&#x60;accountIds&#x60;, &#x60;categoryIds&#x60;, &#x60;tagIds&#x60;, &#x60;search&#x60;, etc.) - useful to scope to one account or to exclude transfers. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TransactionsApi()
val start : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Lower bound (inclusive), `YYYY-MM-DD`.
val end : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Upper bound (inclusive), `YYYY-MM-DD`.
val accountIds : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | Filter by one or more Monarch account ids. Repeat the query param for each. Preferred over the legacy single `accountId` param; both are accepted and merged. 
val categoryIds : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | Filter by one or more Monarch category ids. Repeat the query param for each.
val tagIds : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | Filter by one or more transaction tag ids. Repeat the query param for each.
val search : kotlin.String = search_example // kotlin.String | Free-text search against merchant / notes / category.
val hasAttachments : kotlin.Boolean = true // kotlin.Boolean | When set, restrict to transactions that do or do not have attachments. Omit for either.
val hasNotes : kotlin.Boolean = true // kotlin.Boolean | When set, restrict to transactions that do or do not have notes. Omit for either.
val hideFromReports : kotlin.Boolean = true // kotlin.Boolean | When set, restrict to transactions that are or are not hidden from reports. Omit for either.
val isSplit : kotlin.Boolean = true // kotlin.Boolean | When set, restrict to split or non-split transactions. Omit for either.
val isRecurring : kotlin.Boolean = true // kotlin.Boolean | When set, restrict to recurring or non-recurring transactions. Omit for either.
val importedFromMint : kotlin.Boolean = true // kotlin.Boolean | When set, restrict to transactions imported from Mint or not. Omit for either.
val syncedFromInstitution : kotlin.Boolean = true // kotlin.Boolean | When set, restrict to transactions synced from the institution feed or not. Omit for either.
val needsReview : kotlin.Boolean = true // kotlin.Boolean | When set, restrict to transactions that need review or do not. Omit for either.
val transactionVisibility : kotlin.String = transactionVisibility_example // kotlin.String | Scope of transactions to return. Omit (default) for non-hidden only. `hidden_transactions_only` returns only hidden; `all_transactions` returns both. 
try {
    val result : GetCashflowResponse = apiInstance.getCashflow(start, end, accountIds, categoryIds, tagIds, search, hasAttachments, hasNotes, hideFromReports, isSplit, isRecurring, importedFromMint, syncedFromInstitution, needsReview, transactionVisibility)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TransactionsApi#getCashflow")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TransactionsApi#getCashflow")
    e.printStackTrace()
}
```

### Parameters
| **start** | **java.time.LocalDate**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |
| **end** | **java.time.LocalDate**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |
| **accountIds** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| Filter by one or more Monarch account ids. Repeat the query param for each. Preferred over the legacy single &#x60;accountId&#x60; param; both are accepted and merged.  | [optional] |
| **categoryIds** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| Filter by one or more Monarch category ids. Repeat the query param for each. | [optional] |
| **tagIds** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| Filter by one or more transaction tag ids. Repeat the query param for each. | [optional] |
| **search** | **kotlin.String**| Free-text search against merchant / notes / category. | [optional] |
| **hasAttachments** | **kotlin.Boolean**| When set, restrict to transactions that do or do not have attachments. Omit for either. | [optional] |
| **hasNotes** | **kotlin.Boolean**| When set, restrict to transactions that do or do not have notes. Omit for either. | [optional] |
| **hideFromReports** | **kotlin.Boolean**| When set, restrict to transactions that are or are not hidden from reports. Omit for either. | [optional] |
| **isSplit** | **kotlin.Boolean**| When set, restrict to split or non-split transactions. Omit for either. | [optional] |
| **isRecurring** | **kotlin.Boolean**| When set, restrict to recurring or non-recurring transactions. Omit for either. | [optional] |
| **importedFromMint** | **kotlin.Boolean**| When set, restrict to transactions imported from Mint or not. Omit for either. | [optional] |
| **syncedFromInstitution** | **kotlin.Boolean**| When set, restrict to transactions synced from the institution feed or not. Omit for either. | [optional] |
| **needsReview** | **kotlin.Boolean**| When set, restrict to transactions that need review or do not. Omit for either. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **transactionVisibility** | **kotlin.String**| Scope of transactions to return. Omit (default) for non-hidden only. &#x60;hidden_transactions_only&#x60; returns only hidden; &#x60;all_transactions&#x60; returns both.  | [optional] [enum: hidden_transactions_only, all_transactions] |

### Return type

[**GetCashflowResponse**](GetCashflowResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getCashflowBreakdown"></a>
# **getCashflowBreakdown**
> GetCashflowBreakdownResponse getCashflowBreakdown(start, end, accountIds, categoryIds, tagIds, search, hasAttachments, hasNotes, hideFromReports, isSplit, isRecurring, importedFromMint, syncedFromInstitution, needsReview, transactionVisibility)

Cashflow broken down by category, group, merchant

Same date window as &#x60;GET /v1/cashflow&#x60;, but returns four buckets in one call: per-category totals, per-category-group totals, per-merchant totals, and an aggregate summary.  Use to drive a \&quot;where did the money go\&quot; breakdown view, or to find the top N merchants/categories without making three separate transaction queries. All standard transaction filters apply (&#x60;accountIds&#x60;, &#x60;categoryIds&#x60;, &#x60;tagIds&#x60;, &#x60;search&#x60;, etc.) - useful to exclude transfers or scope to one account. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TransactionsApi()
val start : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Lower bound (inclusive), `YYYY-MM-DD`.
val end : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Upper bound (inclusive), `YYYY-MM-DD`.
val accountIds : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | Filter by one or more Monarch account ids. Repeat the query param for each. Preferred over the legacy single `accountId` param; both are accepted and merged. 
val categoryIds : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | Filter by one or more Monarch category ids. Repeat the query param for each.
val tagIds : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | Filter by one or more transaction tag ids. Repeat the query param for each.
val search : kotlin.String = search_example // kotlin.String | Free-text search against merchant / notes / category.
val hasAttachments : kotlin.Boolean = true // kotlin.Boolean | When set, restrict to transactions that do or do not have attachments. Omit for either.
val hasNotes : kotlin.Boolean = true // kotlin.Boolean | When set, restrict to transactions that do or do not have notes. Omit for either.
val hideFromReports : kotlin.Boolean = true // kotlin.Boolean | When set, restrict to transactions that are or are not hidden from reports. Omit for either.
val isSplit : kotlin.Boolean = true // kotlin.Boolean | When set, restrict to split or non-split transactions. Omit for either.
val isRecurring : kotlin.Boolean = true // kotlin.Boolean | When set, restrict to recurring or non-recurring transactions. Omit for either.
val importedFromMint : kotlin.Boolean = true // kotlin.Boolean | When set, restrict to transactions imported from Mint or not. Omit for either.
val syncedFromInstitution : kotlin.Boolean = true // kotlin.Boolean | When set, restrict to transactions synced from the institution feed or not. Omit for either.
val needsReview : kotlin.Boolean = true // kotlin.Boolean | When set, restrict to transactions that need review or do not. Omit for either.
val transactionVisibility : kotlin.String = transactionVisibility_example // kotlin.String | Scope of transactions to return. Omit (default) for non-hidden only. `hidden_transactions_only` returns only hidden; `all_transactions` returns both. 
try {
    val result : GetCashflowBreakdownResponse = apiInstance.getCashflowBreakdown(start, end, accountIds, categoryIds, tagIds, search, hasAttachments, hasNotes, hideFromReports, isSplit, isRecurring, importedFromMint, syncedFromInstitution, needsReview, transactionVisibility)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TransactionsApi#getCashflowBreakdown")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TransactionsApi#getCashflowBreakdown")
    e.printStackTrace()
}
```

### Parameters
| **start** | **java.time.LocalDate**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |
| **end** | **java.time.LocalDate**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |
| **accountIds** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| Filter by one or more Monarch account ids. Repeat the query param for each. Preferred over the legacy single &#x60;accountId&#x60; param; both are accepted and merged.  | [optional] |
| **categoryIds** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| Filter by one or more Monarch category ids. Repeat the query param for each. | [optional] |
| **tagIds** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| Filter by one or more transaction tag ids. Repeat the query param for each. | [optional] |
| **search** | **kotlin.String**| Free-text search against merchant / notes / category. | [optional] |
| **hasAttachments** | **kotlin.Boolean**| When set, restrict to transactions that do or do not have attachments. Omit for either. | [optional] |
| **hasNotes** | **kotlin.Boolean**| When set, restrict to transactions that do or do not have notes. Omit for either. | [optional] |
| **hideFromReports** | **kotlin.Boolean**| When set, restrict to transactions that are or are not hidden from reports. Omit for either. | [optional] |
| **isSplit** | **kotlin.Boolean**| When set, restrict to split or non-split transactions. Omit for either. | [optional] |
| **isRecurring** | **kotlin.Boolean**| When set, restrict to recurring or non-recurring transactions. Omit for either. | [optional] |
| **importedFromMint** | **kotlin.Boolean**| When set, restrict to transactions imported from Mint or not. Omit for either. | [optional] |
| **syncedFromInstitution** | **kotlin.Boolean**| When set, restrict to transactions synced from the institution feed or not. Omit for either. | [optional] |
| **needsReview** | **kotlin.Boolean**| When set, restrict to transactions that need review or do not. Omit for either. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **transactionVisibility** | **kotlin.String**| Scope of transactions to return. Omit (default) for non-hidden only. &#x60;hidden_transactions_only&#x60; returns only hidden; &#x60;all_transactions&#x60; returns both.  | [optional] [enum: hidden_transactions_only, all_transactions] |

### Return type

[**GetCashflowBreakdownResponse**](GetCashflowBreakdownResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getCashflowDashboard"></a>
# **getCashflowDashboard**
> GetCashflowDashboardResponse getCashflowDashboard(start, end)

Day-by-day expense series for a date window

Returns daily-bucket expense totals. Lightweight series for charting spend over a date window. Sparser shape than &#x60;/v1/cashflow&#x60;, with only the day-grain summary. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TransactionsApi()
val start : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Lower bound (inclusive), `YYYY-MM-DD`.
val end : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Upper bound (inclusive), `YYYY-MM-DD`.
try {
    val result : GetCashflowDashboardResponse = apiInstance.getCashflowDashboard(start, end)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TransactionsApi#getCashflowDashboard")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TransactionsApi#getCashflowDashboard")
    e.printStackTrace()
}
```

### Parameters
| **start** | **java.time.LocalDate**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **end** | **java.time.LocalDate**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |

### Return type

[**GetCashflowDashboardResponse**](GetCashflowDashboardResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getCashflowEntities"></a>
# **getCashflowEntities**
> GetCashflowEntitiesResponse getCashflowEntities(start, end)

Cashflow by category / category-group / merchant

Three breakdowns over the same date window: by category, by category group, by merchant. Plus a totals summary (income, expense, savings, savings rate). Great for \&quot;where did my money go\&quot; prompts. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TransactionsApi()
val start : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Lower bound (inclusive), `YYYY-MM-DD`.
val end : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Upper bound (inclusive), `YYYY-MM-DD`.
try {
    val result : GetCashflowEntitiesResponse = apiInstance.getCashflowEntities(start, end)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TransactionsApi#getCashflowEntities")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TransactionsApi#getCashflowEntities")
    e.printStackTrace()
}
```

### Parameters
| **start** | **java.time.LocalDate**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **end** | **java.time.LocalDate**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |

### Return type

[**GetCashflowEntitiesResponse**](GetCashflowEntitiesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getCashflowFiltered"></a>
# **getCashflowFiltered**
> GetCashflowFilteredResponse getCashflowFiltered(start, end, accountId, categoryId, categoryGroupId, merchantId, tagId)

Filtered cashflow page (summary + four breakdowns)

Filterable cashflow query: summary aggregates plus year/month/quarter bucketing AND category/group/merchant breakdowns in one shot. Filter by accounts, categories, category groups, merchants, tags. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TransactionsApi()
val start : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Lower bound (inclusive), `YYYY-MM-DD`.
val end : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Upper bound (inclusive), `YYYY-MM-DD`.
val accountId : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | Filter to one or more account ids (repeat the param).
val categoryId : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | Filter to one or more category ids.
val categoryGroupId : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | Filter to one or more category-group ids.
val merchantId : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | Filter to one or more merchant ids.
val tagId : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | Filter to one or more tag ids.
try {
    val result : GetCashflowFilteredResponse = apiInstance.getCashflowFiltered(start, end, accountId, categoryId, categoryGroupId, merchantId, tagId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TransactionsApi#getCashflowFiltered")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TransactionsApi#getCashflowFiltered")
    e.printStackTrace()
}
```

### Parameters
| **start** | **java.time.LocalDate**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |
| **end** | **java.time.LocalDate**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |
| **accountId** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| Filter to one or more account ids (repeat the param). | [optional] |
| **categoryId** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| Filter to one or more category ids. | [optional] |
| **categoryGroupId** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| Filter to one or more category-group ids. | [optional] |
| **merchantId** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| Filter to one or more merchant ids. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **tagId** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| Filter to one or more tag ids. | [optional] |

### Return type

[**GetCashflowFilteredResponse**](GetCashflowFilteredResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getCashflowTimeframe"></a>
# **getCashflowTimeframe**
> GetCashflowTimeframeResponse getCashflowTimeframe(start, end)

Year / month / quarter cashflow summaries for a date window

Returns income, expense, savings, and savings-rate aggregated three ways: by year, by month, by quarter. Good for \&quot;how does this year compare to last\&quot; prompts. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TransactionsApi()
val start : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Lower bound (inclusive), `YYYY-MM-DD`.
val end : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Upper bound (inclusive), `YYYY-MM-DD`.
try {
    val result : GetCashflowTimeframeResponse = apiInstance.getCashflowTimeframe(start, end)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TransactionsApi#getCashflowTimeframe")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TransactionsApi#getCashflowTimeframe")
    e.printStackTrace()
}
```

### Parameters
| **start** | **java.time.LocalDate**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **end** | **java.time.LocalDate**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |

### Return type

[**GetCashflowTimeframeResponse**](GetCashflowTimeframeResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getDownloadTransactionsSession"></a>
# **getDownloadTransactionsSession**
> GetDownloadTransactionsSessionResponse getDownloadTransactionsSession(sessionKey)

Poll a transaction download session

Poll the async CSV download job started by &#x60;POST /v1/transactions/download&#x60;. Returns the current &#x60;status&#x60; (running / completed / failed) and, when completed, the signed &#x60;url&#x60; to fetch the CSV file from.  Poll cadence is up to the caller; typical clients re-check every 1-2 seconds until &#x60;url&#x60; is non-null. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TransactionsApi()
val sessionKey : kotlin.String = sessionKey_example // kotlin.String | Session key returned by `POST /v1/transactions/download`.
try {
    val result : GetDownloadTransactionsSessionResponse = apiInstance.getDownloadTransactionsSession(sessionKey)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TransactionsApi#getDownloadTransactionsSession")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TransactionsApi#getDownloadTransactionsSession")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **sessionKey** | **kotlin.String**| Session key returned by &#x60;POST /v1/transactions/download&#x60;. | |

### Return type

[**GetDownloadTransactionsSessionResponse**](GetDownloadTransactionsSessionResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getReviewSummaryByUser"></a>
# **getReviewSummaryByUser**
> GetReviewSummaryByUserResponse getReviewSummaryByUser()

Review-queue counts by household user

For each household member, how many transactions are currently flagged as needing review. Empty list &#x3D; nothing in the review queue. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TransactionsApi()
try {
    val result : GetReviewSummaryByUserResponse = apiInstance.getReviewSummaryByUser()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TransactionsApi#getReviewSummaryByUser")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TransactionsApi#getReviewSummaryByUser")
    e.printStackTrace()
}
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

<a id="getSpendingDashboard"></a>
# **getSpendingDashboard**
> GetSpendingDashboardResponse getSpendingDashboard(start, end)

Home-tab spending dashboard widget

Compact spending widget for the home tab: total spend for the window, remaining budget, and the top spending categories. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TransactionsApi()
val start : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Lower bound (inclusive), `YYYY-MM-DD`.
val end : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Upper bound (inclusive), `YYYY-MM-DD`.
try {
    val result : GetSpendingDashboardResponse = apiInstance.getSpendingDashboard(start, end)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TransactionsApi#getSpendingDashboard")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TransactionsApi#getSpendingDashboard")
    e.printStackTrace()
}
```

### Parameters
| **start** | **java.time.LocalDate**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **end** | **java.time.LocalDate**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |

### Return type

[**GetSpendingDashboardResponse**](GetSpendingDashboardResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getSpendingTrends"></a>
# **getSpendingTrends**
> GetSpendingTrendsResponse getSpendingTrends(timeframe)

Spending trends (period-over-period)

Period-over-period spend trend: current vs. previous total plus the top rising / falling categories by percent delta. Backs the \&quot;Spending Trends\&quot; widget under Insights and the dashboard.  &#x60;timeframe&#x60; is &#x60;week&#x60;, &#x60;month&#x60;, or &#x60;quarter&#x60;. Each compares the current period to the matching previous one. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TransactionsApi()
val timeframe : kotlin.String = timeframe_example // kotlin.String | 
try {
    val result : GetSpendingTrendsResponse = apiInstance.getSpendingTrends(timeframe)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TransactionsApi#getSpendingTrends")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TransactionsApi#getSpendingTrends")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **timeframe** | **kotlin.String**|  | [optional] [default to month] [enum: week, month, quarter] |

### Return type

[**GetSpendingTrendsResponse**](GetSpendingTrendsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getTransactionAuditLog"></a>
# **getTransactionAuditLog**
> GetTransactionAuditLogResponse getTransactionAuditLog(id)

Transaction audit log

History of changes against one transaction. Each entry has the timestamp, actor, action, and old / new value for the field that changed. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TransactionsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch transaction id.
try {
    val result : GetTransactionAuditLogResponse = apiInstance.getTransactionAuditLog(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TransactionsApi#getTransactionAuditLog")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TransactionsApi#getTransactionAuditLog")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **kotlin.String**| Monarch transaction id. | |

### Return type

[**GetTransactionAuditLogResponse**](GetTransactionAuditLogResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getTransactionDetail"></a>
# **getTransactionDetail**
> GetTransactionDetailResponse getTransactionDetail(id)

Single-transaction full detail

Returns the full denormalized tree for one transaction: amount, date, merchant (with logo), category, account, notes, tags, splits (if split), attachments, recurring-stream metadata, and review state.  Use when surfacing a transaction in a detail view, or before a PATCH to inspect current state. The list endpoint &#x60;GET /v1/transactions&#x60; returns a leaner shape per row - this endpoint is the right call when you need the full picture for one. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TransactionsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch transaction id.
try {
    val result : GetTransactionDetailResponse = apiInstance.getTransactionDetail(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TransactionsApi#getTransactionDetail")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TransactionsApi#getTransactionDetail")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **kotlin.String**| Monarch transaction id. | |

### Return type

[**GetTransactionDetailResponse**](GetTransactionDetailResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getTransactionNotes"></a>
# **getTransactionNotes**
> GetTransactionNotesResponse getTransactionNotes(id)

Transaction notes

Standalone notes accessor for one transaction. Lighter than &#x60;/v1/transactions/{id}&#x60; when you only need the notes string. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TransactionsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch transaction id.
try {
    val result : GetTransactionNotesResponse = apiInstance.getTransactionNotes(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TransactionsApi#getTransactionNotes")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TransactionsApi#getTransactionNotes")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **kotlin.String**| Monarch transaction id. | |

### Return type

[**GetTransactionNotesResponse**](GetTransactionNotesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getTransactionSplitTemplates"></a>
# **getTransactionSplitTemplates**
> GetTransactionSplitTemplatesResponse getTransactionSplitTemplates()

Saved split templates

Saved reusable percent-based split definitions (\&quot;Costco run: 70% Groceries / 30% Household\&quot;). The web split modal fires this to populate the \&quot;Apply template\&quot; dropdown.  Each template carries a list of percent-of-parent splits. Caller composes the actual &#x60;POST /v1/transactions/{id}/splits&#x60; request by multiplying the parent amount by each &#x60;percent&#x60;. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TransactionsApi()
try {
    val result : GetTransactionSplitTemplatesResponse = apiInstance.getTransactionSplitTemplates()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TransactionsApi#getTransactionSplitTemplates")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TransactionsApi#getTransactionSplitTemplates")
    e.printStackTrace()
}
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

<a id="getTransactionSplits"></a>
# **getTransactionSplits**
> GetTransactionSplitsResponse getTransactionSplits(id)

Splits of one transaction

Returns the child split rows of a parent transaction (e.g. a $120 grocery run split into $90 groceries + $30 household). Each split has its own amount, category, notes, and tags but inherits the parent&#39;s date and account.  Returns an empty &#x60;splits&#x60; array when the transaction isn&#39;t split (no error). The parent transaction summary is included on the response for convenience. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TransactionsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch transaction id.
try {
    val result : GetTransactionSplitsResponse = apiInstance.getTransactionSplits(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TransactionsApi#getTransactionSplits")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TransactionsApi#getTransactionSplits")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **kotlin.String**| Monarch transaction id. | |

### Return type

[**GetTransactionSplitsResponse**](GetTransactionSplitsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getTransactionsDashboard"></a>
# **getTransactionsDashboard**
> GetTransactionsDashboardResponse getTransactionsDashboard(start, end, limit, offset)

Dashboard transactions list (with totals + rule count)

Returns transaction rows scoped to a date window plus pagination, along with a totalCount, totalSelectableCount, and a rule-count sidecar. Lightweight shape suitable for dashboard widgets. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TransactionsApi()
val start : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Lower bound (inclusive), `YYYY-MM-DD`.
val end : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Upper bound (inclusive), `YYYY-MM-DD`.
val limit : kotlin.Int = 56 // kotlin.Int | Page size.
val offset : kotlin.Int = 56 // kotlin.Int | Page offset.
try {
    val result : GetTransactionsDashboardResponse = apiInstance.getTransactionsDashboard(start, end, limit, offset)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TransactionsApi#getTransactionsDashboard")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TransactionsApi#getTransactionsDashboard")
    e.printStackTrace()
}
```

### Parameters
| **start** | **java.time.LocalDate**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |
| **end** | **java.time.LocalDate**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |
| **limit** | **kotlin.Int**| Page size. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **offset** | **kotlin.Int**| Page offset. | [optional] |

### Return type

[**GetTransactionsDashboardResponse**](GetTransactionsDashboardResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getTransactionsDuplicates"></a>
# **getTransactionsDuplicates**
> GetTransactionsDuplicatesResponse getTransactionsDuplicates(start, end, accountId, accountIds)

Groups of likely-duplicate transactions

Server-side composite over &#x60;GET /v1/transactions&#x60;. Pulls the window and groups results by the python-lib &#x60;find_duplicate_transactions&#x60; key: &#x60;(date, amount, plaidName, accountId)&#x60;.  Using &#x60;plaidName&#x60; (the raw Plaid description) rather than &#x60;merchantName&#x60; (Monarch&#39;s normalized display name) avoids false positives: two genuine same-day same-merchant same-amount charges carry different &#x60;plaidName&#x60; reference strings. Only true double-inserts share the exact &#x60;plaidName&#x60;.  Returns only groups with size &gt; 1. Useful for surfacing accidental double-posts after re-linking an institution (a known Monarch issue, particularly for Apple Card / Apple Cash / Apple Savings). 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TransactionsApi()
val start : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Lower bound (inclusive), `YYYY-MM-DD`.
val end : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Upper bound (inclusive), `YYYY-MM-DD`.
val accountId : kotlin.String = accountId_example // kotlin.String | Filter by a single Monarch account id.
val accountIds : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | Filter to multiple accounts. Merged with the legacy single-value `accountId` if both are passed. 
try {
    val result : GetTransactionsDuplicatesResponse = apiInstance.getTransactionsDuplicates(start, end, accountId, accountIds)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TransactionsApi#getTransactionsDuplicates")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TransactionsApi#getTransactionsDuplicates")
    e.printStackTrace()
}
```

### Parameters
| **start** | **java.time.LocalDate**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |
| **end** | **java.time.LocalDate**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |
| **accountId** | **kotlin.String**| Filter by a single Monarch account id. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accountIds** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| Filter to multiple accounts. Merged with the legacy single-value &#x60;accountId&#x60; if both are passed.  | [optional] |

### Return type

[**GetTransactionsDuplicatesResponse**](GetTransactionsDuplicatesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getTransactionsSummary"></a>
# **getTransactionsSummary**
> GetTransactionsSummaryResponse getTransactionsSummary(start, end, accountId, accountIds, categoryIds, tagIds, search, hasAttachments, hasNotes, hideFromReports, isSplit, isRecurring, importedFromMint, syncedFromInstitution, needsReview, transactionVisibility)

Aggregate stats across a transaction window

Returns one summary row over the filtered transaction set: &#x60;count&#x60;, &#x60;sum&#x60;, &#x60;avg&#x60;, &#x60;min&#x60;, &#x60;max&#x60;, &#x60;first&#x60;, &#x60;last&#x60;. Useful for one-shot questions like \&quot;how many Whole Foods runs this year\&quot; or \&quot;what&#39;s my average dining check\&quot; without pulling the full transaction list.  All standard transaction filters apply (&#x60;search&#x60;, &#x60;categoryIds&#x60;, &#x60;accountIds&#x60;, &#x60;tagIds&#x60;, bool flags). For per-category breakdowns use &#x60;GET /v1/cashflow/breakdown&#x60;. For row-level data use &#x60;GET /v1/transactions&#x60;. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TransactionsApi()
val start : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Lower bound (inclusive), `YYYY-MM-DD`.
val end : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Upper bound (inclusive), `YYYY-MM-DD`.
val accountId : kotlin.String = accountId_example // kotlin.String | Filter by a single Monarch account id.
val accountIds : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | Filter by one or more Monarch account ids. Repeat the query param for each. Preferred over the legacy single `accountId` param; both are accepted and merged. 
val categoryIds : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | Filter by one or more Monarch category ids. Repeat the query param for each.
val tagIds : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | Filter by one or more transaction tag ids. Repeat the query param for each.
val search : kotlin.String = search_example // kotlin.String | Free-text search against merchant / notes / category.
val hasAttachments : kotlin.Boolean = true // kotlin.Boolean | When set, restrict to transactions that do or do not have attachments. Omit for either.
val hasNotes : kotlin.Boolean = true // kotlin.Boolean | When set, restrict to transactions that do or do not have notes. Omit for either.
val hideFromReports : kotlin.Boolean = true // kotlin.Boolean | When set, restrict to transactions that are or are not hidden from reports. Omit for either.
val isSplit : kotlin.Boolean = true // kotlin.Boolean | When set, restrict to split or non-split transactions. Omit for either.
val isRecurring : kotlin.Boolean = true // kotlin.Boolean | When set, restrict to recurring or non-recurring transactions. Omit for either.
val importedFromMint : kotlin.Boolean = true // kotlin.Boolean | When set, restrict to transactions imported from Mint or not. Omit for either.
val syncedFromInstitution : kotlin.Boolean = true // kotlin.Boolean | When set, restrict to transactions synced from the institution feed or not. Omit for either.
val needsReview : kotlin.Boolean = true // kotlin.Boolean | When set, restrict to transactions that need review or do not. Omit for either.
val transactionVisibility : kotlin.String = transactionVisibility_example // kotlin.String | Scope of transactions to return. Omit (default) for non-hidden only. `hidden_transactions_only` returns only hidden; `all_transactions` returns both. 
try {
    val result : GetTransactionsSummaryResponse = apiInstance.getTransactionsSummary(start, end, accountId, accountIds, categoryIds, tagIds, search, hasAttachments, hasNotes, hideFromReports, isSplit, isRecurring, importedFromMint, syncedFromInstitution, needsReview, transactionVisibility)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TransactionsApi#getTransactionsSummary")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TransactionsApi#getTransactionsSummary")
    e.printStackTrace()
}
```

### Parameters
| **start** | **java.time.LocalDate**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |
| **end** | **java.time.LocalDate**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |
| **accountId** | **kotlin.String**| Filter by a single Monarch account id. | [optional] |
| **accountIds** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| Filter by one or more Monarch account ids. Repeat the query param for each. Preferred over the legacy single &#x60;accountId&#x60; param; both are accepted and merged.  | [optional] |
| **categoryIds** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| Filter by one or more Monarch category ids. Repeat the query param for each. | [optional] |
| **tagIds** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| Filter by one or more transaction tag ids. Repeat the query param for each. | [optional] |
| **search** | **kotlin.String**| Free-text search against merchant / notes / category. | [optional] |
| **hasAttachments** | **kotlin.Boolean**| When set, restrict to transactions that do or do not have attachments. Omit for either. | [optional] |
| **hasNotes** | **kotlin.Boolean**| When set, restrict to transactions that do or do not have notes. Omit for either. | [optional] |
| **hideFromReports** | **kotlin.Boolean**| When set, restrict to transactions that are or are not hidden from reports. Omit for either. | [optional] |
| **isSplit** | **kotlin.Boolean**| When set, restrict to split or non-split transactions. Omit for either. | [optional] |
| **isRecurring** | **kotlin.Boolean**| When set, restrict to recurring or non-recurring transactions. Omit for either. | [optional] |
| **importedFromMint** | **kotlin.Boolean**| When set, restrict to transactions imported from Mint or not. Omit for either. | [optional] |
| **syncedFromInstitution** | **kotlin.Boolean**| When set, restrict to transactions synced from the institution feed or not. Omit for either. | [optional] |
| **needsReview** | **kotlin.Boolean**| When set, restrict to transactions that need review or do not. Omit for either. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **transactionVisibility** | **kotlin.String**| Scope of transactions to return. Omit (default) for non-hidden only. &#x60;hidden_transactions_only&#x60; returns only hidden; &#x60;all_transactions&#x60; returns both.  | [optional] [enum: hidden_transactions_only, all_transactions] |

### Return type

[**GetTransactionsSummaryResponse**](GetTransactionsSummaryResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="listTransactions"></a>
# **listTransactions**
> ListTransactionsResponse listTransactions(start, end, limit, offset, accountId, accountIds, categoryIds, tagIds, orderBy, search, hasAttachments, hasNotes, hideFromReports, isSplit, isRecurring, importedFromMint, syncedFromInstitution, needsReview, transactionVisibility)

Search and list transactions with rich filtering

Returns transactions matching the filter set, **newest-first** within &#x60;[start, end]&#x60;. Use the &#x60;search&#x60; param for free-text search across merchant + notes + plaid name. Combine with &#x60;categoryIds&#x60;, &#x60;accountIds&#x60;, &#x60;tagIds&#x60; (all multi) to scope.  Date semantics: &#x60;start&#x60; is the **oldest allowed date**, NOT \&quot;scroll forward from here\&quot;. &#x60;?start&#x3D;2026-01-01&amp;limit&#x3D;10&#x60; returns the 10 newest txns on or after Jan 2026 (probably this week). To get January specifically: &#x60;?start&#x3D;2026-01-01&amp;end&#x3D;2026-01-31&#x60;. To get older rows, bound &#x60;end&#x60; earlier or paginate with &#x60;offset&#x60;.  Bool filters (&#x60;hasAttachments&#x60;, &#x60;isRecurring&#x60;, &#x60;hideFromReports&#x60;, &#x60;needsReview&#x60;, etc.) accept true/false; omit to not filter on that dimension. Returns the page plus &#x60;totalCount&#x60; for the filter set. For aggregate stats over the same filter use &#x60;GET /v1/transactions/summary&#x60;; for the single-row detail use &#x60;GET /v1/transactions/{id}&#x60;. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TransactionsApi()
val start : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Lower bound (inclusive), `YYYY-MM-DD`.
val end : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Upper bound (inclusive), `YYYY-MM-DD`.
val limit : kotlin.Int = 56 // kotlin.Int | Page size.
val offset : kotlin.Int = 56 // kotlin.Int | Page offset.
val accountId : kotlin.String = accountId_example // kotlin.String | Filter by a single Monarch account id.
val accountIds : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | Filter by one or more Monarch account ids. Repeat the query param for each. Preferred over the legacy single `accountId` param; both are accepted and merged. 
val categoryIds : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | Filter by one or more Monarch category ids. Repeat the query param for each.
val tagIds : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | Filter by one or more transaction tag ids. Repeat the query param for each.
val orderBy : kotlin.String = orderBy_example // kotlin.String | Monarch sort enum. Both values sort descending.
val search : kotlin.String = search_example // kotlin.String | Free-text search against merchant / notes / category.
val hasAttachments : kotlin.Boolean = true // kotlin.Boolean | When set, restrict to transactions that do or do not have attachments. Omit for either.
val hasNotes : kotlin.Boolean = true // kotlin.Boolean | When set, restrict to transactions that do or do not have notes. Omit for either.
val hideFromReports : kotlin.Boolean = true // kotlin.Boolean | When set, restrict to transactions that are or are not hidden from reports. Omit for either.
val isSplit : kotlin.Boolean = true // kotlin.Boolean | When set, restrict to split or non-split transactions. Omit for either.
val isRecurring : kotlin.Boolean = true // kotlin.Boolean | When set, restrict to recurring or non-recurring transactions. Omit for either.
val importedFromMint : kotlin.Boolean = true // kotlin.Boolean | When set, restrict to transactions imported from Mint or not. Omit for either.
val syncedFromInstitution : kotlin.Boolean = true // kotlin.Boolean | When set, restrict to transactions synced from the institution feed or not. Omit for either.
val needsReview : kotlin.Boolean = true // kotlin.Boolean | When set, restrict to transactions that need review or do not. Omit for either.
val transactionVisibility : kotlin.String = transactionVisibility_example // kotlin.String | Scope of transactions to return. Omit (default) for non-hidden only. `hidden_transactions_only` returns only hidden; `all_transactions` returns both. 
try {
    val result : ListTransactionsResponse = apiInstance.listTransactions(start, end, limit, offset, accountId, accountIds, categoryIds, tagIds, orderBy, search, hasAttachments, hasNotes, hideFromReports, isSplit, isRecurring, importedFromMint, syncedFromInstitution, needsReview, transactionVisibility)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TransactionsApi#listTransactions")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TransactionsApi#listTransactions")
    e.printStackTrace()
}
```

### Parameters
| **start** | **java.time.LocalDate**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |
| **end** | **java.time.LocalDate**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |
| **limit** | **kotlin.Int**| Page size. | [optional] |
| **offset** | **kotlin.Int**| Page offset. | [optional] |
| **accountId** | **kotlin.String**| Filter by a single Monarch account id. | [optional] |
| **accountIds** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| Filter by one or more Monarch account ids. Repeat the query param for each. Preferred over the legacy single &#x60;accountId&#x60; param; both are accepted and merged.  | [optional] |
| **categoryIds** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| Filter by one or more Monarch category ids. Repeat the query param for each. | [optional] |
| **tagIds** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| Filter by one or more transaction tag ids. Repeat the query param for each. | [optional] |
| **orderBy** | **kotlin.String**| Monarch sort enum. Both values sort descending. | [optional] [enum: date, amount] |
| **search** | **kotlin.String**| Free-text search against merchant / notes / category. | [optional] |
| **hasAttachments** | **kotlin.Boolean**| When set, restrict to transactions that do or do not have attachments. Omit for either. | [optional] |
| **hasNotes** | **kotlin.Boolean**| When set, restrict to transactions that do or do not have notes. Omit for either. | [optional] |
| **hideFromReports** | **kotlin.Boolean**| When set, restrict to transactions that are or are not hidden from reports. Omit for either. | [optional] |
| **isSplit** | **kotlin.Boolean**| When set, restrict to split or non-split transactions. Omit for either. | [optional] |
| **isRecurring** | **kotlin.Boolean**| When set, restrict to recurring or non-recurring transactions. Omit for either. | [optional] |
| **importedFromMint** | **kotlin.Boolean**| When set, restrict to transactions imported from Mint or not. Omit for either. | [optional] |
| **syncedFromInstitution** | **kotlin.Boolean**| When set, restrict to transactions synced from the institution feed or not. Omit for either. | [optional] |
| **needsReview** | **kotlin.Boolean**| When set, restrict to transactions that need review or do not. Omit for either. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **transactionVisibility** | **kotlin.String**| Scope of transactions to return. Omit (default) for non-hidden only. &#x60;hidden_transactions_only&#x60; returns only hidden; &#x60;all_transactions&#x60; returns both.  | [optional] [enum: hidden_transactions_only, all_transactions] |

### Return type

[**ListTransactionsResponse**](ListTransactionsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="markAsRecurring"></a>
# **markAsRecurring**
> MarkAsRecurringResponse markAsRecurring(id, markAsRecurringRequest)

Mark a transaction as the start of a recurring stream

The inverse of &#x60;POST /v1/transactions/{id}/not-recurring&#x60;. Tells Monarch the transaction IS the first instance of a recurring stream at the given &#x60;frequency&#x60; (&#x60;monthly&#x60;, &#x60;weekly&#x60;, &#x60;quarterly&#x60;, &#x60;yearly&#x60;, &#x60;biweekly&#x60;). Monarch creates the stream definition and returns its id.  Use to teach Monarch a stream it missed (a new subscription, a private-vendor recurring invoice). 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TransactionsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch transaction id.
val markAsRecurringRequest : MarkAsRecurringRequest =  // MarkAsRecurringRequest | 
try {
    val result : MarkAsRecurringResponse = apiInstance.markAsRecurring(id, markAsRecurringRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TransactionsApi#markAsRecurring")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TransactionsApi#markAsRecurring")
    e.printStackTrace()
}
```

### Parameters
| **id** | **kotlin.String**| Monarch transaction id. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **markAsRecurringRequest** | [**MarkAsRecurringRequest**](MarkAsRecurringRequest.md)|  | |

### Return type

[**MarkAsRecurringResponse**](MarkAsRecurringResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="markTransactionAsReviewed"></a>
# **markTransactionAsReviewed**
> MarkTransactionAsReviewedResponse markTransactionAsReviewed(id)

Mark a transaction as reviewed

Single-shot helper: sets &#x60;reviewed&#x3D;true&#x60; on one transaction. Equivalent to &#x60;PATCH /v1/transactions/{id}&#x60; with &#x60;{\&quot;reviewed\&quot;: true}&#x60; but smaller in input (no body required) and output (only &#x60;id&#x60;, &#x60;reviewedAt&#x60;, &#x60;needsReview&#x60;).  Use from review/triage flows where the assistant just needs to dispatch a mark-as-reviewed without rewriting the whole transaction tree.  To un-mark, send &#x60;PATCH /v1/transactions/{id}&#x60; with &#x60;{\&quot;reviewed\&quot;: false}&#x60;. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TransactionsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch transaction id.
try {
    val result : MarkTransactionAsReviewedResponse = apiInstance.markTransactionAsReviewed(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TransactionsApi#markTransactionAsReviewed")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TransactionsApi#markTransactionAsReviewed")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **kotlin.String**| Monarch transaction id. | |

### Return type

[**MarkTransactionAsReviewedResponse**](MarkTransactionAsReviewedResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="markTransactionStreamAsNotRecurring"></a>
# **markTransactionStreamAsNotRecurring**
> MarkTransactionStreamAsNotRecurringResponse markTransactionStreamAsNotRecurring(id)

Mark a transaction&#39;s recurring-stream as not-recurring

Tells Monarch that the recurring stream a transaction is attached to is NOT actually recurring. Used to dismiss false-positive recurrence detections.  Important: Monarch&#39;s mutation takes a &#x60;streamId&#x60;, NOT a transaction id. Pass the transaction&#39;s &#x60;stream.id&#x60; (visible on the transaction detail) as the path &#x60;{id}&#x60;. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TransactionsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch transaction id.
try {
    val result : MarkTransactionStreamAsNotRecurringResponse = apiInstance.markTransactionStreamAsNotRecurring(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TransactionsApi#markTransactionStreamAsNotRecurring")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TransactionsApi#markTransactionStreamAsNotRecurring")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **kotlin.String**| Monarch transaction id. | |

### Return type

[**MarkTransactionStreamAsNotRecurringResponse**](MarkTransactionStreamAsNotRecurringResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="matchSearchTransactions"></a>
# **matchSearchTransactions**
> MatchSearchTransactionsResponse matchSearchTransactions(search, limit)

Fuzzy transaction search for \&quot;find a match\&quot;

Free-text transaction lookup powering the web \&quot;find a match\&quot; picker (used in split, link-to-goal, and recurring-merge flows). Returns a lean shape per row: id, amount, date, plaid name, merchant + account references.  Different from the canonical &#x60;GET /v1/transactions&#x60; in two ways: only the &#x60;search&#x60; filter is supported, and the result shape is the slim picker shape rather than the full transaction row. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TransactionsApi()
val search : kotlin.String = search_example // kotlin.String | Free-text query against merchant + plaid name.
val limit : kotlin.Int = 56 // kotlin.Int | Max results.
try {
    val result : MatchSearchTransactionsResponse = apiInstance.matchSearchTransactions(search, limit)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TransactionsApi#matchSearchTransactions")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TransactionsApi#matchSearchTransactions")
    e.printStackTrace()
}
```

### Parameters
| **search** | **kotlin.String**| Free-text query against merchant + plaid name. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **limit** | **kotlin.Int**| Max results. | [optional] [default to 20] |

### Return type

[**MatchSearchTransactionsResponse**](MatchSearchTransactionsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="moveTransactions"></a>
# **moveTransactions**
> MoveTransactionsResponse moveTransactions(moveTransactionsRequest)

Move transactions between accounts

Reassign one or more transactions from their current account to a target account. Use when reconciling a mis-categorized import (e.g. Plaid bucketed a charge under the wrong account) or after a manual merge.  Returns the count of transactions Monarch actually moved, plus a flat error array (one message per failed transaction). 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TransactionsApi()
val moveTransactionsRequest : MoveTransactionsRequest =  // MoveTransactionsRequest | 
try {
    val result : MoveTransactionsResponse = apiInstance.moveTransactions(moveTransactionsRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TransactionsApi#moveTransactions")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TransactionsApi#moveTransactions")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **moveTransactionsRequest** | [**MoveTransactionsRequest**](MoveTransactionsRequest.md)|  | |

### Return type

[**MoveTransactionsResponse**](MoveTransactionsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="setTransactionTags"></a>
# **setTransactionTags**
> SetTransactionTagsResponse setTransactionTags(id, setTransactionTagsRequest)

Overwrite the tag set on a transaction

Wholesale-replaces every tag on a transaction. Send the complete final tag id list - this is NOT a delta. To add a tag without losing the existing ones, read current tags first via &#x60;GET /v1/transactions/{id}&#x60; then PUT the merged list.  Empty list &#x60;[]&#x60; clears all tags. Tag ids come from &#x60;GET /v1/tags&#x60;. For bulk tag changes across many transactions use &#x60;PATCH /v1/transactions/bulk&#x60;. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TransactionsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch transaction id.
val setTransactionTagsRequest : SetTransactionTagsRequest =  // SetTransactionTagsRequest | 
try {
    val result : SetTransactionTagsResponse = apiInstance.setTransactionTags(id, setTransactionTagsRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TransactionsApi#setTransactionTags")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TransactionsApi#setTransactionTags")
    e.printStackTrace()
}
```

### Parameters
| **id** | **kotlin.String**| Monarch transaction id. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **setTransactionTagsRequest** | [**SetTransactionTagsRequest**](SetTransactionTagsRequest.md)|  | |

### Return type

[**SetTransactionTagsResponse**](SetTransactionTagsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="startDownloadTransactions"></a>
# **startDownloadTransactions**
> StartDownloadTransactionsResponse startDownloadTransactions(startDownloadTransactionsRequest)

Start a transaction CSV download session

Kick off the async \&quot;download my transactions as CSV\&quot; job Monarch backs the Web download button with. Returns a &#x60;sessionKey&#x60; to poll via &#x60;GET /v1/transactions/download/{sessionKey}&#x60; until the CSV &#x60;url&#x60; is ready.  Filters mirror &#x60;GET /v1/transactions&#x60;: pass a JSON map under &#x60;filters&#x60; (search string, categoryIds, accountIds, date window). 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TransactionsApi()
val startDownloadTransactionsRequest : StartDownloadTransactionsRequest =  // StartDownloadTransactionsRequest | 
try {
    val result : StartDownloadTransactionsResponse = apiInstance.startDownloadTransactions(startDownloadTransactionsRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TransactionsApi#startDownloadTransactions")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TransactionsApi#startDownloadTransactions")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **startDownloadTransactionsRequest** | [**StartDownloadTransactionsRequest**](StartDownloadTransactionsRequest.md)|  | |

### Return type

[**StartDownloadTransactionsResponse**](StartDownloadTransactionsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="updateTransaction"></a>
# **updateTransaction**
> UpdateTransactionResponse updateTransaction(id, updateTransactionRequest)

Partial-update a transaction

Patches one transaction. Only fields present in the body are forwarded to Monarch; omit a field to leave it untouched.  Common edits: &#x60;categoryId&#x60; (re-categorize), &#x60;merchantName&#x60; (rename via the override), &#x60;notes&#x60;, &#x60;date&#x60;, &#x60;amount&#x60; (manual accounts only - Plaid will overwrite on next sync), &#x60;hideFromReports&#x60;, &#x60;needsReview&#x60;.  For tag mutations use &#x60;PUT /v1/transactions/{id}/tags&#x60; instead - tags are stored separately. For wholesale edits across many transactions use &#x60;PATCH /v1/transactions/bulk&#x60;. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TransactionsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch transaction id.
val updateTransactionRequest : UpdateTransactionRequest =  // UpdateTransactionRequest | 
try {
    val result : UpdateTransactionResponse = apiInstance.updateTransaction(id, updateTransactionRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TransactionsApi#updateTransaction")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TransactionsApi#updateTransaction")
    e.printStackTrace()
}
```

### Parameters
| **id** | **kotlin.String**| Monarch transaction id. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **updateTransactionRequest** | [**UpdateTransactionRequest**](UpdateTransactionRequest.md)|  | |

### Return type

[**UpdateTransactionResponse**](UpdateTransactionResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="updateTransactionSplits"></a>
# **updateTransactionSplits**
> UpdateTransactionSplitsResponse updateTransactionSplits(id, updateTransactionSplitsRequest)

Replace the splits on a transaction

Wholesale-replaces the split set on a transaction. Send the complete new list - this is NOT a delta operation. Each split needs &#x60;amount&#x60; (signed, same sign as the parent) plus &#x60;categoryId&#x60; and optional &#x60;notes&#x60; / &#x60;merchantName&#x60;.  Sum of split amounts must equal the parent transaction&#39;s amount exactly - Monarch rejects with 422 PayloadError on any mismatch. Send an empty list to remove all splits and revert the transaction to a single-row entry. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TransactionsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch transaction id.
val updateTransactionSplitsRequest : UpdateTransactionSplitsRequest =  // UpdateTransactionSplitsRequest | 
try {
    val result : UpdateTransactionSplitsResponse = apiInstance.updateTransactionSplits(id, updateTransactionSplitsRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TransactionsApi#updateTransactionSplits")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TransactionsApi#updateTransactionSplits")
    e.printStackTrace()
}
```

### Parameters
| **id** | **kotlin.String**| Monarch transaction id. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **updateTransactionSplitsRequest** | [**UpdateTransactionSplitsRequest**](UpdateTransactionSplitsRequest.md)|  | |

### Return type

[**UpdateTransactionSplitsResponse**](UpdateTransactionSplitsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="uploadTransactionAttachment"></a>
# **uploadTransactionAttachment**
> UploadTransactionAttachmentResponse uploadTransactionAttachment(id, file)

Attach a receipt photo or PDF to a transaction

Three-step flow handled internally by the proxy: (1) asks Monarch for signed Cloudinary upload params, (2) forwards the file to Cloudinary, (3) tells Monarch to link the upload to the transaction. Caller sees a single multipart/form-data POST with the file. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TransactionsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch transaction id.
val file : java.io.File = BINARY_DATA_HERE // java.io.File | Receipt photo, scan, or PDF.
try {
    val result : UploadTransactionAttachmentResponse = apiInstance.uploadTransactionAttachment(id, file)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TransactionsApi#uploadTransactionAttachment")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TransactionsApi#uploadTransactionAttachment")
    e.printStackTrace()
}
```

### Parameters
| **id** | **kotlin.String**| Monarch transaction id. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **file** | **java.io.File**| Receipt photo, scan, or PDF. | |

### Return type

[**UploadTransactionAttachmentResponse**](UploadTransactionAttachmentResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

