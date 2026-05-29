# AccountsApi

All URIs are relative to *http://localhost:9084*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**bulkUpdateAccounts**](AccountsApi.md#bulkUpdateAccounts) | **PATCH** /v1/accounts/bulk | Bulk-update accounts |
| [**createManualAccount**](AccountsApi.md#createManualAccount) | **POST** /v1/accounts | Create a manual (non-Plaid) account |
| [**deleteAccount**](AccountsApi.md#deleteAccount) | **DELETE** /v1/accounts/{id} | Delete an account |
| [**deleteInstitution**](AccountsApi.md#deleteInstitution) | **DELETE** /v1/institutions/{id} | Delete a Plaid credential (institution connection) |
| [**getAccountBalanceAtDate**](AccountsApi.md#getAccountBalanceAtDate) | **GET** /v1/accounts/{id}/balance/at | Account display balance at a specific date |
| [**getAccountGroups**](AccountsApi.md#getAccountGroups) | **GET** /v1/account-groups | Account groups |
| [**getAccountHistory**](AccountsApi.md#getAccountHistory) | **GET** /v1/account/{id}/history | Daily balance snapshots for one account |
| [**getAccountHoldings**](AccountsApi.md#getAccountHoldings) | **GET** /v1/account/{id}/holdings | Investment positions in one account |
| [**getAccountTypeOptions**](AccountsApi.md#getAccountTypeOptions) | **GET** /v1/account-type-options | Valid (type, subtype) combinations for manual accounts |
| [**getBalanceHistoryStatus**](AccountsApi.md#getBalanceHistoryStatus) | **GET** /v1/balance-history/{sessionKey}/status | Poll the parse status of a balance-history upload |
| [**getCredentialInstitutions**](AccountsApi.md#getCredentialInstitutions) | **GET** /v1/credentials/institutions | Linked credentials with their institution metadata |
| [**getInstitutionByPlaidId**](AccountsApi.md#getInstitutionByPlaidId) | **GET** /v1/institutions/by-plaid/{plaidId} | Institution lookup by Plaid id |
| [**getInstitutions**](AccountsApi.md#getInstitutions) | **GET** /v1/institutions | Linked institution credentials (Plaid connection pipes) |
| [**getNetworth**](AccountsApi.md#getNetworth) | **GET** /v1/networth | Net-worth snapshots over time |
| [**getNetworthByType**](AccountsApi.md#getNetworthByType) | **GET** /v1/networth/by-type | Balance history grouped by account-type |
| [**getNetworthRecent**](AccountsApi.md#getNetworthRecent) | **GET** /v1/networth/recent | Per-account recent balance fluctuations |
| [**getTopInstitutionGroups**](AccountsApi.md#getTopInstitutionGroups) | **GET** /v1/institutions/top-groups | Top institution groups (popular providers by category) |
| [**listAccounts**](AccountsApi.md#listAccounts) | **GET** /v1/accounts | List all linked + manual accounts |
| [**listLinkedCredentials**](AccountsApi.md#listLinkedCredentials) | **GET** /v1/credentials | List linked credentials |
| [**previewAccountBalance**](AccountsApi.md#previewAccountBalance) | **GET** /v1/accounts/{id}/balance/preview | Preview an account display balance under edit options |
| [**updateAccount**](AccountsApi.md#updateAccount) | **PATCH** /v1/accounts/{id} | Partial-update an account |
| [**updateAccountGroupOrder**](AccountsApi.md#updateAccountGroupOrder) | **PUT** /v1/account-groups/order | Reorder account groups |
| [**uploadAccountBalanceHistory**](AccountsApi.md#uploadAccountBalanceHistory) | **POST** /v1/accounts/{id}/balance-history | Bulk-backfill balance history for a manual account from a CSV |


<a id="bulkUpdateAccounts"></a>
# **bulkUpdateAccounts**
> BulkUpdateAccountsResponse bulkUpdateAccounts(bulkUpdateAccountsRequest)

Bulk-update accounts

Forwards Monarch&#39;s &#x60;updateAccounts&#x60; mutation. Send one or more &#x60;UpdateAccountsMutationInput&#x60; entries; each must include &#x60;id&#x60; plus any subset of the patchable fields. Returns every updated account.  Use for \&quot;rename three accounts at once\&quot; / \&quot;hide a set of accounts\&quot; / \&quot;flip includeInNetWorth on a list\&quot; without firing N single &#x60;PATCH /v1/accounts/{id}&#x60; calls. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = AccountsApi()
val bulkUpdateAccountsRequest : BulkUpdateAccountsRequest =  // BulkUpdateAccountsRequest | 
try {
    val result : BulkUpdateAccountsResponse = apiInstance.bulkUpdateAccounts(bulkUpdateAccountsRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AccountsApi#bulkUpdateAccounts")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AccountsApi#bulkUpdateAccounts")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **bulkUpdateAccountsRequest** | [**BulkUpdateAccountsRequest**](BulkUpdateAccountsRequest.md)|  | |

### Return type

[**BulkUpdateAccountsResponse**](BulkUpdateAccountsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="createManualAccount"></a>
# **createManualAccount**
> CreateManualAccountResponse createManualAccount(createManualAccountRequest)

Create a manual (non-Plaid) account

Creates an account Monarch will not auto-sync. Use for cash, foreign accounts, employer 401k where Plaid has no coverage, real-estate holdings, or any other balance the user wants tracked in net worth.  Required: &#x60;name&#x60;, &#x60;type&#x60;, &#x60;subtype&#x60;, &#x60;displayBalance&#x60;. Use &#x60;GET /v1/account-type-options&#x60; to enumerate the valid &#x60;(type, subtype)&#x60; pairs. For brokerage-style accounts with per-security holdings, use &#x60;POST /v1/accounts/manual-investments&#x60; instead.  Returns the new account id. After creation, set up balance history via &#x60;POST /v1/accounts/{id}/balance-history&#x60; (CSV upload) or just let the daily snapshots accumulate from this point forward. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = AccountsApi()
val createManualAccountRequest : CreateManualAccountRequest =  // CreateManualAccountRequest | 
try {
    val result : CreateManualAccountResponse = apiInstance.createManualAccount(createManualAccountRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AccountsApi#createManualAccount")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AccountsApi#createManualAccount")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **createManualAccountRequest** | [**CreateManualAccountRequest**](CreateManualAccountRequest.md)|  | |

### Return type

[**CreateManualAccountResponse**](CreateManualAccountResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="deleteAccount"></a>
# **deleteAccount**
> DeleteAccountResponse deleteAccount(id)

Delete an account

**Destructive**: removes the account AND every transaction Monarch associated with it. Balance-history snapshots are also discarded.  Use to clean up a manual account that&#39;s no longer relevant, or to fully purge a Plaid-linked account whose credential was already unlinked via &#x60;DELETE /v1/institutions/{id}&#x60;. There is no undo and no soft-delete fallback for this endpoint - the institution-level delete soft-deletes accounts; this one hard-deletes a single one. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = AccountsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch account id.
try {
    val result : DeleteAccountResponse = apiInstance.deleteAccount(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AccountsApi#deleteAccount")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AccountsApi#deleteAccount")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **kotlin.String**| Monarch account id. | |

### Return type

[**DeleteAccountResponse**](DeleteAccountResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="deleteInstitution"></a>
# **deleteInstitution**
> DeleteInstitutionResponse deleteInstitution(id)

Delete a Plaid credential (institution connection)

Unlinks an institution from Monarch by deleting its Plaid credential. Equivalent to Monarch web UI: Settings -&gt; Data Sources -&gt; unlink.  The associated accounts get **soft-deleted**: they still appear in &#x60;GET /v1/institutions&#x60; under &#x60;accounts[]&#x60; with a non-null &#x60;deletedAt&#x60;, but are excluded from default &#x60;GET /v1/accounts&#x60; results.  Use this to clean up stale credentials with &#x60;updateRequired: true&#x60; that no longer authenticate (the equivalent of a dead Plaid connection). Credential IDs come from &#x60;GET /v1/institutions&#x60; &#x60;credentials[].id&#x60;. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = AccountsApi()
val id : kotlin.String = id_example // kotlin.String | Credential ID from `/v1/institutions` `credentials[].id`.
try {
    val result : DeleteInstitutionResponse = apiInstance.deleteInstitution(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AccountsApi#deleteInstitution")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AccountsApi#deleteInstitution")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **kotlin.String**| Credential ID from &#x60;/v1/institutions&#x60; &#x60;credentials[].id&#x60;. | |

### Return type

[**DeleteInstitutionResponse**](DeleteInstitutionResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getAccountBalanceAtDate"></a>
# **getAccountBalanceAtDate**
> GetAccountBalanceAtDateResponse getAccountBalanceAtDate(id, date)

Account display balance at a specific date

\&quot;What was this account worth on YYYY-MM-DD.\&quot; Walks back through Monarch&#39;s daily snapshot series and returns the displayed (sign-adjusted) balance as of the requested date.  Use for point-in-time reporting (year-end statements, lookback charts) when you need one date for one account. For the full series use &#x60;GET /v1/account/{id}/history&#x60;; for aggregate net worth at a date use &#x60;GET /v1/networth&#x60;. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = AccountsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch account id.
val date : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Lookback date, `YYYY-MM-DD`.
try {
    val result : GetAccountBalanceAtDateResponse = apiInstance.getAccountBalanceAtDate(id, date)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AccountsApi#getAccountBalanceAtDate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AccountsApi#getAccountBalanceAtDate")
    e.printStackTrace()
}
```

### Parameters
| **id** | **kotlin.String**| Monarch account id. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **date** | **java.time.LocalDate**| Lookback date, &#x60;YYYY-MM-DD&#x60;. | |

### Return type

[**GetAccountBalanceAtDateResponse**](GetAccountBalanceAtDateResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getAccountGroups"></a>
# **getAccountGroups**
> GetAccountGroupsResponse getAccountGroups()

Account groups

Visual groupings of accounts under the Accounts tab. Each group has a display order, an optional collapsed flag, and the ids of accounts it contains. Pure read - the web tab fires this on mount.  Pair with &#x60;PUT /v1/account-groups/order&#x60; to persist a new ordering. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = AccountsApi()
try {
    val result : GetAccountGroupsResponse = apiInstance.getAccountGroups()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AccountsApi#getAccountGroups")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AccountsApi#getAccountGroups")
    e.printStackTrace()
}
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

<a id="getAccountHistory"></a>
# **getAccountHistory**
> GetAccountHistoryResponse getAccountHistory(id)

Daily balance snapshots for one account

Returns the full daily balance series for a single account: one snapshot per day from the link date (or first manual entry) through today.  Use for per-account trend charts, drift analysis between two accounts, or to reconstruct a balance at a specific point in time. For aggregated net-worth across accounts use &#x60;GET /v1/networth&#x60; instead.  Series is chronologically ascending. Each entry is &#x60;(date, signedBalance)&#x60; where the sign matches the account type (loans/credit are negative). For type-grouped or recent-only views see &#x60;GET /v1/networth/by-type&#x60; and &#x60;GET /v1/networth/recent&#x60;. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = AccountsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch account id.
try {
    val result : GetAccountHistoryResponse = apiInstance.getAccountHistory(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AccountsApi#getAccountHistory")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AccountsApi#getAccountHistory")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **kotlin.String**| Monarch account id. | |

### Return type

[**GetAccountHistoryResponse**](GetAccountHistoryResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getAccountHoldings"></a>
# **getAccountHoldings**
> GetAccountHoldingsResponse getAccountHoldings(id)

Investment positions in one account

Returns every security position Monarch tracks inside the account: quantity, value, cost basis, security metadata (ticker, name, type), and last-updated timestamp.  Brokerage/retirement accounts only. Returns an empty list for depository, credit, and loan accounts (no error). For the full security catalog lookup use &#x60;GET /v1/securities/search&#x60;; to mutate a single holding use &#x60;PATCH /v1/holdings/{id}&#x60; or &#x60;DELETE /v1/holdings/{id}&#x60;. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = AccountsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch account id.
try {
    val result : GetAccountHoldingsResponse = apiInstance.getAccountHoldings(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AccountsApi#getAccountHoldings")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AccountsApi#getAccountHoldings")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **kotlin.String**| Monarch account id. | |

### Return type

[**GetAccountHoldingsResponse**](GetAccountHoldingsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getAccountTypeOptions"></a>
# **getAccountTypeOptions**
> GetAccountTypeOptionsResponse getAccountTypeOptions()

Valid (type, subtype) combinations for manual accounts

Enumerates the &#x60;(type, subtype)&#x60; pairs Monarch accepts when creating a manual account. Use before calling &#x60;POST /v1/accounts&#x60; to confirm the pair is supported (e.g. &#x60;(depository, checking)&#x60;, &#x60;(loan, auto)&#x60;, &#x60;(real_estate, residential)&#x60;).  Static catalog: the response shape is stable across users and rarely changes, so it&#39;s safe to cache for the session. Returns each type bundled with its supported subtypes plus display names. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = AccountsApi()
try {
    val result : GetAccountTypeOptionsResponse = apiInstance.getAccountTypeOptions()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AccountsApi#getAccountTypeOptions")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AccountsApi#getAccountTypeOptions")
    e.printStackTrace()
}
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

<a id="getBalanceHistoryStatus"></a>
# **getBalanceHistoryStatus**
> GetBalanceHistoryStatusResponse getBalanceHistoryStatus(sessionKey)

Poll the parse status of a balance-history upload

Polls the async parse job kicked off by &#x60;POST /v1/accounts/{id}/balance-history&#x60;. Returns Monarch&#39;s current &#x60;status&#x60; for the session (&#x60;pending&#x60;, &#x60;processing&#x60;, &#x60;completed&#x60;, &#x60;failed&#x60;).  Typical flow: upload the CSV, grab the &#x60;sessionKey&#x60; from that 202 response, then call this endpoint every few seconds until &#x60;status&#x60; reaches &#x60;completed&#x60; (usually under 10 seconds for a year of monthly snapshots). On &#x60;failed&#x60;, the response includes a Monarch-side error string explaining the parse problem. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = AccountsApi()
val sessionKey : kotlin.String = sessionKey_example // kotlin.String | Session key returned from the upload call.
try {
    val result : GetBalanceHistoryStatusResponse = apiInstance.getBalanceHistoryStatus(sessionKey)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AccountsApi#getBalanceHistoryStatus")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AccountsApi#getBalanceHistoryStatus")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **sessionKey** | **kotlin.String**| Session key returned from the upload call. | |

### Return type

[**GetBalanceHistoryStatusResponse**](GetBalanceHistoryStatusResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getCredentialInstitutions"></a>
# **getCredentialInstitutions**
> GetCredentialInstitutionsResponse getCredentialInstitutions()

Linked credentials with their institution metadata

List of credentials with their institutions and the per-credential &#x60;preferredDataProvider&#x60;. Richer than &#x60;/v1/credentials&#x60; because it includes per-provider institution ids (Plaid, Finicity, MX). 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = AccountsApi()
try {
    val result : GetCredentialInstitutionsResponse = apiInstance.getCredentialInstitutions()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AccountsApi#getCredentialInstitutions")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AccountsApi#getCredentialInstitutions")
    e.printStackTrace()
}
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

<a id="getInstitutionByPlaidId"></a>
# **getInstitutionByPlaidId**
> GetInstitutionByPlaidIdResponse getInstitutionByPlaidId(plaidId)

Institution lookup by Plaid id

Look up institution metadata (logo, status, connection health) by its Plaid institution id. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = AccountsApi()
val plaidId : kotlin.String = plaidId_example // kotlin.String | The Plaid institution id (e.g. `ins_3`).
try {
    val result : GetInstitutionByPlaidIdResponse = apiInstance.getInstitutionByPlaidId(plaidId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AccountsApi#getInstitutionByPlaidId")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AccountsApi#getInstitutionByPlaidId")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **plaidId** | **kotlin.String**| The Plaid institution id (e.g. &#x60;ins_3&#x60;). | |

### Return type

[**GetInstitutionByPlaidIdResponse**](GetInstitutionByPlaidIdResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getInstitutions"></a>
# **getInstitutions**
> GetInstitutionsResponse getInstitutions()

Linked institution credentials (Plaid connection pipes)

Returns every Plaid credential the user has linked, plus the accounts behind each one and Monarch&#39;s subscription summary. Credentials are the \&quot;pipes\&quot; - one per institution per Plaid item - that supply accounts on the other side.  Use to surface connection health: each credential carries &#x60;updateRequired&#x60;, &#x60;disconnectedFromDataProviderAt&#x60;, and last-sync timestamps so you can detect dead Plaid links. Includes soft-deleted accounts under &#x60;accounts[]&#x60; (filter by &#x60;deletedAt&#x60;).  To unlink an institution use &#x60;DELETE /v1/institutions/{id}&#x60; where &#x60;{id}&#x60; is the credential id from &#x60;credentials[].id&#x60; here. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = AccountsApi()
try {
    val result : GetInstitutionsResponse = apiInstance.getInstitutions()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AccountsApi#getInstitutions")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AccountsApi#getInstitutions")
    e.printStackTrace()
}
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

<a id="getNetworth"></a>
# **getNetworth**
> GetNetworthResponse getNetworth(start, end, accountType)

Net-worth snapshots over time

Returns the user&#39;s aggregate net-worth series for the date window: one row per day with total assets, total liabilities, and net (assets minus liabilities).  &#x60;start&#x60; is the oldest date in the window; omit for full history back to the first account link. &#x60;accountType&#x60; optionally scopes the series to one account type (e.g. only &#x60;brokerage&#x60; to chart investments in isolation).  Use for top-of-dashboard net-worth charts or trend analysis. For a per-account-type breakdown see &#x60;GET /v1/networth/by-type&#x60;; for per-account recent fluctuations see &#x60;GET /v1/networth/recent&#x60;. For a single account&#39;s history use &#x60;GET /v1/account/{id}/history&#x60;. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = AccountsApi()
val start : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Lower bound (inclusive), `YYYY-MM-DD`.
val end : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Upper bound (inclusive), `YYYY-MM-DD`.
val accountType : kotlin.String = accountType_example // kotlin.String | Filter to one Monarch account type (e.g. `brokerage`, `real_estate`).
try {
    val result : GetNetworthResponse = apiInstance.getNetworth(start, end, accountType)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AccountsApi#getNetworth")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AccountsApi#getNetworth")
    e.printStackTrace()
}
```

### Parameters
| **start** | **java.time.LocalDate**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |
| **end** | **java.time.LocalDate**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accountType** | **kotlin.String**| Filter to one Monarch account type (e.g. &#x60;brokerage&#x60;, &#x60;real_estate&#x60;). | [optional] |

### Return type

[**GetNetworthResponse**](GetNetworthResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getNetworthByType"></a>
# **getNetworthByType**
> GetNetworthByTypeResponse getNetworthByType(start, timeframe)

Balance history grouped by account-type

Returns balance snapshots aggregated per account type (depository, credit, brokerage, loan, real_estate, etc.) instead of one combined total. Each type gets its own series plus the catalog of account types is included for convenience.  Use for stacked-area net-worth charts that show how the composition of net worth has shifted over time (e.g. \&quot;cash share is shrinking as brokerage grows\&quot;). &#x60;timeframe&#x60; controls bucketing (&#x60;day&#x60; / &#x60;week&#x60; / &#x60;month&#x60; / &#x60;year&#x60;). 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = AccountsApi()
val start : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Lower bound (inclusive), `YYYY-MM-DD`.
val timeframe : kotlin.String = timeframe_example // kotlin.String | Bucket size for grouped snapshots.
try {
    val result : GetNetworthByTypeResponse = apiInstance.getNetworthByType(start, timeframe)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AccountsApi#getNetworthByType")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AccountsApi#getNetworthByType")
    e.printStackTrace()
}
```

### Parameters
| **start** | **java.time.LocalDate**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **timeframe** | **kotlin.String**| Bucket size for grouped snapshots. | [optional] [default to month] [enum: day, month, year] |

### Return type

[**GetNetworthByTypeResponse**](GetNetworthByTypeResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getNetworthRecent"></a>
# **getNetworthRecent**
> GetNetworthRecentResponse getNetworthRecent(start)

Per-account recent balance fluctuations

Returns a short recent-balances series for **each account**, starting at &#x60;start&#x60; (typically a week or month back). Lighter than pulling each account&#39;s full history one-by-one when all you need is a recent sparkline.  Use for a \&quot;what changed lately\&quot; dashboard view that highlights accounts with non-trivial movement. For the full per-account series use &#x60;GET /v1/account/{id}/history&#x60;; for the household-aggregate series use &#x60;GET /v1/networth&#x60;. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = AccountsApi()
val start : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Lower bound (inclusive), `YYYY-MM-DD`.
try {
    val result : GetNetworthRecentResponse = apiInstance.getNetworthRecent(start)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AccountsApi#getNetworthRecent")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AccountsApi#getNetworthRecent")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **start** | **java.time.LocalDate**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |

### Return type

[**GetNetworthRecentResponse**](GetNetworthRecentResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getTopInstitutionGroups"></a>
# **getTopInstitutionGroups**
> GetTopInstitutionGroupsResponse getTopInstitutionGroups(dataProvider)

Top institution groups (popular providers by category)

Monarch&#39;s top-N institutions grouped by category, scoped to the requested data providers. Used by the Add-Account UI. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = AccountsApi()
val dataProvider : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | One or more data providers (`PLAID`, `FINICITY`, `MX`).
try {
    val result : GetTopInstitutionGroupsResponse = apiInstance.getTopInstitutionGroups(dataProvider)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AccountsApi#getTopInstitutionGroups")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AccountsApi#getTopInstitutionGroups")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **dataProvider** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| One or more data providers (&#x60;PLAID&#x60;, &#x60;FINICITY&#x60;, &#x60;MX&#x60;). | [optional] |

### Return type

[**GetTopInstitutionGroupsResponse**](GetTopInstitutionGroupsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="listAccounts"></a>
# **listAccounts**
> ListAccountsResponse listAccounts()

List all linked + manual accounts

Returns every account the user has in Monarch: Plaid-linked depository, credit, loan, brokerage accounts plus any manually-created accounts.  Use this to enumerate accounts before scoping a transaction query, or to grab &#x60;account.id&#x60; values for filter params like &#x60;accountIds&#x60;. The shape includes &#x60;displayName&#x60;, &#x60;type&#x60;, &#x60;subtype&#x60;, &#x60;currentBalance&#x60;, &#x60;institution&#x60;, &#x60;includeInNetWorth&#x60;, and timestamps.  No filtering on the wire: hidden accounts and accounts with &#x60;isAsset: false&#x60; come back too. Filter client-side on &#x60;includeInNetWorth&#x60; or &#x60;hideFromList&#x60; if needed. For institution-scoped views use &#x60;GET /v1/institutions&#x60;. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = AccountsApi()
try {
    val result : ListAccountsResponse = apiInstance.listAccounts()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AccountsApi#listAccounts")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AccountsApi#listAccounts")
    e.printStackTrace()
}
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

<a id="listLinkedCredentials"></a>
# **listLinkedCredentials**
> ListLinkedCredentialsResponse listLinkedCredentials()

List linked credentials

Lightweight list of every linked data-provider credential plus its institution (id, name, logo). For richer per-credential settings, use the existing institution-settings endpoint instead. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = AccountsApi()
try {
    val result : ListLinkedCredentialsResponse = apiInstance.listLinkedCredentials()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AccountsApi#listLinkedCredentials")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AccountsApi#listLinkedCredentials")
    e.printStackTrace()
}
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

<a id="previewAccountBalance"></a>
# **previewAccountBalance**
> PreviewAccountBalanceResponse previewAccountBalance(id, invertSyncedBalance, useAvailableBalance)

Preview an account display balance under edit options

Returns the &#x60;displayBalance&#x60; Monarch would show for an account if &#x60;invertSyncedBalance&#x60; and/or &#x60;useAvailableBalance&#x60; were toggled. Used by the \&quot;edit account\&quot; form to live-preview the effect of those settings without committing the change.  Pure read-only - no state is mutated. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = AccountsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch account id.
val invertSyncedBalance : kotlin.Boolean = true // kotlin.Boolean | Preview what the displayed balance would be if synced balances were sign-flipped.
val useAvailableBalance : kotlin.Boolean = true // kotlin.Boolean | Preview what the displayed balance would be using the available (vs current) balance.
try {
    val result : PreviewAccountBalanceResponse = apiInstance.previewAccountBalance(id, invertSyncedBalance, useAvailableBalance)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AccountsApi#previewAccountBalance")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AccountsApi#previewAccountBalance")
    e.printStackTrace()
}
```

### Parameters
| **id** | **kotlin.String**| Monarch account id. | |
| **invertSyncedBalance** | **kotlin.Boolean**| Preview what the displayed balance would be if synced balances were sign-flipped. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **useAvailableBalance** | **kotlin.Boolean**| Preview what the displayed balance would be using the available (vs current) balance. | [optional] |

### Return type

[**PreviewAccountBalanceResponse**](PreviewAccountBalanceResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="updateAccount"></a>
# **updateAccount**
> UpdateAccountResponse updateAccount(id, updateAccountRequest)

Partial-update an account

Patches an existing account. Only fields present in the body are forwarded to Monarch; omit a field to leave it untouched.  Common edits: rename via &#x60;name&#x60;, toggle visibility with &#x60;includeInNetWorth&#x60; / &#x60;hideFromList&#x60;, override the institution-reported &#x60;displayBalance&#x60; for manual accounts, or change &#x60;type&#x60;/&#x60;subtype&#x60;.  Works on both Plaid-linked and manual accounts, but balance edits only persist on manual accounts (Plaid will overwrite on next sync). Use &#x60;PATCH /v1/accounts/bulk&#x60; to update several at once. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = AccountsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch account id.
val updateAccountRequest : UpdateAccountRequest =  // UpdateAccountRequest | 
try {
    val result : UpdateAccountResponse = apiInstance.updateAccount(id, updateAccountRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AccountsApi#updateAccount")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AccountsApi#updateAccount")
    e.printStackTrace()
}
```

### Parameters
| **id** | **kotlin.String**| Monarch account id. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **updateAccountRequest** | [**UpdateAccountRequest**](UpdateAccountRequest.md)|  | |

### Return type

[**UpdateAccountResponse**](UpdateAccountResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="updateAccountGroupOrder"></a>
# **updateAccountGroupOrder**
> UpdateAccountGroupOrderResponse updateAccountGroupOrder(updateAccountGroupOrderRequest)

Reorder account groups

Persist a new ordering for account groups. Send the FULL ordered list of group ids; Monarch assigns sequential &#x60;order&#x60; values from the array index and returns the resulting &#x60;(id, order)&#x60; pairs.  Whole-set replace: omitting an id from the list does not delete the group but leaves its &#x60;order&#x60; undefined relative to the rest. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = AccountsApi()
val updateAccountGroupOrderRequest : UpdateAccountGroupOrderRequest =  // UpdateAccountGroupOrderRequest | 
try {
    val result : UpdateAccountGroupOrderResponse = apiInstance.updateAccountGroupOrder(updateAccountGroupOrderRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AccountsApi#updateAccountGroupOrder")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AccountsApi#updateAccountGroupOrder")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **updateAccountGroupOrderRequest** | [**UpdateAccountGroupOrderRequest**](UpdateAccountGroupOrderRequest.md)|  | |

### Return type

[**UpdateAccountGroupOrderResponse**](UpdateAccountGroupOrderResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="uploadAccountBalanceHistory"></a>
# **uploadAccountBalanceHistory**
> UploadAccountBalanceHistory202Response uploadAccountBalanceHistory(id, file)

Bulk-backfill balance history for a manual account from a CSV

Two-step flow: (1) the proxy forwards the CSV to Monarch&#39;s &#x60;/account-balance-history/upload/&#x60; endpoint, (2) it triggers a parse via the &#x60;parseBalanceHistory&#x60; GraphQL mutation, then returns the session key. Poll &#x60;GET /v1/balance-history/{sessionKey}/status&#x60; until &#x60;status &#x3D;&#x3D; \&quot;completed\&quot;&#x60;.  CSV format (matching Monarch&#39;s UI uploader): one header row &#x60;date,balance&#x60;, then one row per snapshot (&#x60;2026-01-31,12345.67&#x60;). Negative balances OK for credit/loan accounts. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = AccountsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch account id.
val file : java.io.File = BINARY_DATA_HERE // java.io.File | CSV with `date,balance` rows. UTF-8.
try {
    val result : UploadAccountBalanceHistory202Response = apiInstance.uploadAccountBalanceHistory(id, file)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AccountsApi#uploadAccountBalanceHistory")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AccountsApi#uploadAccountBalanceHistory")
    e.printStackTrace()
}
```

### Parameters
| **id** | **kotlin.String**| Monarch account id. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **file** | **java.io.File**| CSV with &#x60;date,balance&#x60; rows. UTF-8. | |

### Return type

[**UploadAccountBalanceHistory202Response**](UploadAccountBalanceHistory202Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

