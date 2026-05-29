# AccountsApi

All URIs are relative to *http://localhost:9084*

|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|[**bulkUpdateAccounts**](#bulkupdateaccounts) | **PATCH** /v1/accounts/bulk | Bulk-update accounts|
|[**createManualAccount**](#createmanualaccount) | **POST** /v1/accounts | Create a manual (non-Plaid) account|
|[**deleteAccount**](#deleteaccount) | **DELETE** /v1/accounts/{id} | Delete an account|
|[**deleteInstitution**](#deleteinstitution) | **DELETE** /v1/institutions/{id} | Delete a Plaid credential (institution connection)|
|[**getAccountBalanceAtDate**](#getaccountbalanceatdate) | **GET** /v1/accounts/{id}/balance/at | Account display balance at a specific date|
|[**getAccountGroups**](#getaccountgroups) | **GET** /v1/account-groups | Account groups|
|[**getAccountHistory**](#getaccounthistory) | **GET** /v1/account/{id}/history | Daily balance snapshots for one account|
|[**getAccountHoldings**](#getaccountholdings) | **GET** /v1/account/{id}/holdings | Investment positions in one account|
|[**getAccountTypeOptions**](#getaccounttypeoptions) | **GET** /v1/account-type-options | Valid (type, subtype) combinations for manual accounts|
|[**getBalanceHistoryStatus**](#getbalancehistorystatus) | **GET** /v1/balance-history/{sessionKey}/status | Poll the parse status of a balance-history upload|
|[**getCredentialInstitutions**](#getcredentialinstitutions) | **GET** /v1/credentials/institutions | Linked credentials with their institution metadata|
|[**getInstitutionByPlaidId**](#getinstitutionbyplaidid) | **GET** /v1/institutions/by-plaid/{plaidId} | Institution lookup by Plaid id|
|[**getInstitutions**](#getinstitutions) | **GET** /v1/institutions | Linked institution credentials (Plaid connection pipes)|
|[**getNetworth**](#getnetworth) | **GET** /v1/networth | Net-worth snapshots over time|
|[**getNetworthByType**](#getnetworthbytype) | **GET** /v1/networth/by-type | Balance history grouped by account-type|
|[**getNetworthRecent**](#getnetworthrecent) | **GET** /v1/networth/recent | Per-account recent balance fluctuations|
|[**getTopInstitutionGroups**](#gettopinstitutiongroups) | **GET** /v1/institutions/top-groups | Top institution groups (popular providers by category)|
|[**listAccounts**](#listaccounts) | **GET** /v1/accounts | List all linked + manual accounts|
|[**listLinkedCredentials**](#listlinkedcredentials) | **GET** /v1/credentials | List linked credentials|
|[**previewAccountBalance**](#previewaccountbalance) | **GET** /v1/accounts/{id}/balance/preview | Preview an account display balance under edit options|
|[**updateAccount**](#updateaccount) | **PATCH** /v1/accounts/{id} | Partial-update an account|
|[**updateAccountGroupOrder**](#updateaccountgrouporder) | **PUT** /v1/account-groups/order | Reorder account groups|
|[**uploadAccountBalanceHistory**](#uploadaccountbalancehistory) | **POST** /v1/accounts/{id}/balance-history | Bulk-backfill balance history for a manual account from a CSV|

# **bulkUpdateAccounts**
> BulkUpdateAccountsResponse bulkUpdateAccounts(bulkUpdateAccountsRequest)

Forwards Monarch\'s `updateAccounts` mutation. Send one or more `UpdateAccountsMutationInput` entries; each must include `id` plus any subset of the patchable fields. Returns every updated account.  Use for \"rename three accounts at once\" / \"hide a set of accounts\" / \"flip includeInNetWorth on a list\" without firing N single `PATCH /v1/accounts/{id}` calls. 

### Example

```typescript
import {
    AccountsApi,
    Configuration,
    BulkUpdateAccountsRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new AccountsApi(configuration);

let bulkUpdateAccountsRequest: BulkUpdateAccountsRequest; //

const { status, data } = await apiInstance.bulkUpdateAccounts(
    bulkUpdateAccountsRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **bulkUpdateAccountsRequest** | **BulkUpdateAccountsRequest**|  | |


### Return type

**BulkUpdateAccountsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Updated accounts (one per input entry). |  -  |
|**400** | Validation failed. |  -  |
|**422** | Monarch rejected the mutation (PayloadError). |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **createManualAccount**
> CreateManualAccountResponse createManualAccount(createManualAccountRequest)

Creates an account Monarch will not auto-sync. Use for cash, foreign accounts, employer 401k where Plaid has no coverage, real-estate holdings, or any other balance the user wants tracked in net worth.  Required: `name`, `type`, `subtype`, `displayBalance`. Use `GET /v1/account-type-options` to enumerate the valid `(type, subtype)` pairs. For brokerage-style accounts with per-security holdings, use `POST /v1/accounts/manual-investments` instead.  Returns the new account id. After creation, set up balance history via `POST /v1/accounts/{id}/balance-history` (CSV upload) or just let the daily snapshots accumulate from this point forward. 

### Example

```typescript
import {
    AccountsApi,
    Configuration,
    CreateManualAccountRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new AccountsApi(configuration);

let createManualAccountRequest: CreateManualAccountRequest; //

const { status, data } = await apiInstance.createManualAccount(
    createManualAccountRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **createManualAccountRequest** | **CreateManualAccountRequest**|  | |


### Return type

**CreateManualAccountResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | New account id. |  -  |
|**400** | Validation failed. |  -  |
|**422** | Monarch PayloadError. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **deleteAccount**
> DeleteAccountResponse deleteAccount()

**Destructive**: removes the account AND every transaction Monarch associated with it. Balance-history snapshots are also discarded.  Use to clean up a manual account that\'s no longer relevant, or to fully purge a Plaid-linked account whose credential was already unlinked via `DELETE /v1/institutions/{id}`. There is no undo and no soft-delete fallback for this endpoint - the institution-level delete soft-deletes accounts; this one hard-deletes a single one. 

### Example

```typescript
import {
    AccountsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new AccountsApi(configuration);

let id: string; //Monarch account id. (default to undefined)

const { status, data } = await apiInstance.deleteAccount(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch account id. | defaults to undefined|


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

# **deleteInstitution**
> DeleteInstitutionResponse deleteInstitution()

Unlinks an institution from Monarch by deleting its Plaid credential. Equivalent to Monarch web UI: Settings -> Data Sources -> unlink.  The associated accounts get **soft-deleted**: they still appear in `GET /v1/institutions` under `accounts[]` with a non-null `deletedAt`, but are excluded from default `GET /v1/accounts` results.  Use this to clean up stale credentials with `updateRequired: true` that no longer authenticate (the equivalent of a dead Plaid connection). Credential IDs come from `GET /v1/institutions` `credentials[].id`. 

### Example

```typescript
import {
    AccountsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new AccountsApi(configuration);

let id: string; //Credential ID from `/v1/institutions` `credentials[].id`. (default to undefined)

const { status, data } = await apiInstance.deleteInstitution(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Credential ID from &#x60;/v1/institutions&#x60; &#x60;credentials[].id&#x60;. | defaults to undefined|


### Return type

**DeleteInstitutionResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Confirmation. |  -  |
|**422** | Monarch refused the delete (PayloadError). |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getAccountBalanceAtDate**
> GetAccountBalanceAtDateResponse getAccountBalanceAtDate()

\"What was this account worth on YYYY-MM-DD.\" Walks back through Monarch\'s daily snapshot series and returns the displayed (sign-adjusted) balance as of the requested date.  Use for point-in-time reporting (year-end statements, lookback charts) when you need one date for one account. For the full series use `GET /v1/account/{id}/history`; for aggregate net worth at a date use `GET /v1/networth`. 

### Example

```typescript
import {
    AccountsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new AccountsApi(configuration);

let id: string; //Monarch account id. (default to undefined)
let date: string; //Lookback date, `YYYY-MM-DD`. (default to undefined)

const { status, data } = await apiInstance.getAccountBalanceAtDate(
    id,
    date
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch account id. | defaults to undefined|
| **date** | [**string**] | Lookback date, &#x60;YYYY-MM-DD&#x60;. | defaults to undefined|


### Return type

**GetAccountBalanceAtDateResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Display balance for the account on &#x60;date&#x60;. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getAccountGroups**
> GetAccountGroupsResponse getAccountGroups()

Visual groupings of accounts under the Accounts tab. Each group has a display order, an optional collapsed flag, and the ids of accounts it contains. Pure read - the web tab fires this on mount.  Pair with `PUT /v1/account-groups/order` to persist a new ordering. 

### Example

```typescript
import {
    AccountsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new AccountsApi(configuration);

const { status, data } = await apiInstance.getAccountGroups();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**GetAccountGroupsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | All account groups for the household. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getAccountHistory**
> GetAccountHistoryResponse getAccountHistory()

Returns the full daily balance series for a single account: one snapshot per day from the link date (or first manual entry) through today.  Use for per-account trend charts, drift analysis between two accounts, or to reconstruct a balance at a specific point in time. For aggregated net-worth across accounts use `GET /v1/networth` instead.  Series is chronologically ascending. Each entry is `(date, signedBalance)` where the sign matches the account type (loans/credit are negative). For type-grouped or recent-only views see `GET /v1/networth/by-type` and `GET /v1/networth/recent`. 

### Example

```typescript
import {
    AccountsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new AccountsApi(configuration);

let id: string; //Monarch account id. (default to undefined)

const { status, data } = await apiInstance.getAccountHistory(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch account id. | defaults to undefined|


### Return type

**GetAccountHistoryResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Chronologically-ascending snapshots starting from the account link date. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getAccountHoldings**
> GetAccountHoldingsResponse getAccountHoldings()

Returns every security position Monarch tracks inside the account: quantity, value, cost basis, security metadata (ticker, name, type), and last-updated timestamp.  Brokerage/retirement accounts only. Returns an empty list for depository, credit, and loan accounts (no error). For the full security catalog lookup use `GET /v1/securities/search`; to mutate a single holding use `PATCH /v1/holdings/{id}` or `DELETE /v1/holdings/{id}`. 

### Example

```typescript
import {
    AccountsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new AccountsApi(configuration);

let id: string; //Monarch account id. (default to undefined)

const { status, data } = await apiInstance.getAccountHoldings(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch account id. | defaults to undefined|


### Return type

**GetAccountHoldingsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Holdings list (may be empty). |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getAccountTypeOptions**
> GetAccountTypeOptionsResponse getAccountTypeOptions()

Enumerates the `(type, subtype)` pairs Monarch accepts when creating a manual account. Use before calling `POST /v1/accounts` to confirm the pair is supported (e.g. `(depository, checking)`, `(loan, auto)`, `(real_estate, residential)`).  Static catalog: the response shape is stable across users and rarely changes, so it\'s safe to cache for the session. Returns each type bundled with its supported subtypes plus display names. 

### Example

```typescript
import {
    AccountsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new AccountsApi(configuration);

const { status, data } = await apiInstance.getAccountTypeOptions();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**GetAccountTypeOptionsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Account type catalog. Use to populate the type/subtype dropdowns. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getBalanceHistoryStatus**
> GetBalanceHistoryStatusResponse getBalanceHistoryStatus()

Polls the async parse job kicked off by `POST /v1/accounts/{id}/balance-history`. Returns Monarch\'s current `status` for the session (`pending`, `processing`, `completed`, `failed`).  Typical flow: upload the CSV, grab the `sessionKey` from that 202 response, then call this endpoint every few seconds until `status` reaches `completed` (usually under 10 seconds for a year of monthly snapshots). On `failed`, the response includes a Monarch-side error string explaining the parse problem. 

### Example

```typescript
import {
    AccountsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new AccountsApi(configuration);

let sessionKey: string; //Session key returned from the upload call. (default to undefined)

const { status, data } = await apiInstance.getBalanceHistoryStatus(
    sessionKey
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **sessionKey** | [**string**] | Session key returned from the upload call. | defaults to undefined|


### Return type

**GetBalanceHistoryStatusResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Current parse status. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getCredentialInstitutions**
> GetCredentialInstitutionsResponse getCredentialInstitutions()

List of credentials with their institutions and the per-credential `preferredDataProvider`. Richer than `/v1/credentials` because it includes per-provider institution ids (Plaid, Finicity, MX). 

### Example

```typescript
import {
    AccountsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new AccountsApi(configuration);

const { status, data } = await apiInstance.getCredentialInstitutions();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**GetCredentialInstitutionsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Credentials with institution metadata. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getInstitutionByPlaidId**
> GetInstitutionByPlaidIdResponse getInstitutionByPlaidId()

Look up institution metadata (logo, status, connection health) by its Plaid institution id. 

### Example

```typescript
import {
    AccountsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new AccountsApi(configuration);

let plaidId: string; //The Plaid institution id (e.g. `ins_3`). (default to undefined)

const { status, data } = await apiInstance.getInstitutionByPlaidId(
    plaidId
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **plaidId** | [**string**] | The Plaid institution id (e.g. &#x60;ins_3&#x60;). | defaults to undefined|


### Return type

**GetInstitutionByPlaidIdResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Institution detail. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getInstitutions**
> GetInstitutionsResponse getInstitutions()

Returns every Plaid credential the user has linked, plus the accounts behind each one and Monarch\'s subscription summary. Credentials are the \"pipes\" - one per institution per Plaid item - that supply accounts on the other side.  Use to surface connection health: each credential carries `updateRequired`, `disconnectedFromDataProviderAt`, and last-sync timestamps so you can detect dead Plaid links. Includes soft-deleted accounts under `accounts[]` (filter by `deletedAt`).  To unlink an institution use `DELETE /v1/institutions/{id}` where `{id}` is the credential id from `credentials[].id` here. 

### Example

```typescript
import {
    AccountsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new AccountsApi(configuration);

const { status, data } = await apiInstance.getInstitutions();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**GetInstitutionsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Credentials + their accounts + subscription summary. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getNetworth**
> GetNetworthResponse getNetworth()

Returns the user\'s aggregate net-worth series for the date window: one row per day with total assets, total liabilities, and net (assets minus liabilities).  `start` is the oldest date in the window; omit for full history back to the first account link. `accountType` optionally scopes the series to one account type (e.g. only `brokerage` to chart investments in isolation).  Use for top-of-dashboard net-worth charts or trend analysis. For a per-account-type breakdown see `GET /v1/networth/by-type`; for per-account recent fluctuations see `GET /v1/networth/recent`. For a single account\'s history use `GET /v1/account/{id}/history`. 

### Example

```typescript
import {
    AccountsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new AccountsApi(configuration);

let start: string; //Lower bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)
let end: string; //Upper bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)
let accountType: string; //Filter to one Monarch account type (e.g. `brokerage`, `real_estate`). (optional) (default to undefined)

const { status, data } = await apiInstance.getNetworth(
    start,
    end,
    accountType
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **start** | [**string**] | Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|
| **end** | [**string**] | Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|
| **accountType** | [**string**] | Filter to one Monarch account type (e.g. &#x60;brokerage&#x60;, &#x60;real_estate&#x60;). | (optional) defaults to undefined|


### Return type

**GetNetworthResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Daily snapshots within the window. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getNetworthByType**
> GetNetworthByTypeResponse getNetworthByType()

Returns balance snapshots aggregated per account type (depository, credit, brokerage, loan, real_estate, etc.) instead of one combined total. Each type gets its own series plus the catalog of account types is included for convenience.  Use for stacked-area net-worth charts that show how the composition of net worth has shifted over time (e.g. \"cash share is shrinking as brokerage grows\"). `timeframe` controls bucketing (`day` / `week` / `month` / `year`). 

### Example

```typescript
import {
    AccountsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new AccountsApi(configuration);

let start: string; //Lower bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)
let timeframe: 'day' | 'month' | 'year'; //Bucket size for grouped snapshots. (optional) (default to 'month')

const { status, data } = await apiInstance.getNetworthByType(
    start,
    timeframe
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **start** | [**string**] | Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|
| **timeframe** | [**&#39;day&#39; | &#39;month&#39; | &#39;year&#39;**]**Array<&#39;day&#39; &#124; &#39;month&#39; &#124; &#39;year&#39;>** | Bucket size for grouped snapshots. | (optional) defaults to 'month'|


### Return type

**GetNetworthByTypeResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Grouped snapshots + the account-type list. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getNetworthRecent**
> GetNetworthRecentResponse getNetworthRecent()

Returns a short recent-balances series for **each account**, starting at `start` (typically a week or month back). Lighter than pulling each account\'s full history one-by-one when all you need is a recent sparkline.  Use for a \"what changed lately\" dashboard view that highlights accounts with non-trivial movement. For the full per-account series use `GET /v1/account/{id}/history`; for the household-aggregate series use `GET /v1/networth`. 

### Example

```typescript
import {
    AccountsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new AccountsApi(configuration);

let start: string; //Lower bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)

const { status, data } = await apiInstance.getNetworthRecent(
    start
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **start** | [**string**] | Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|


### Return type

**GetNetworthRecentResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Per-account recent-balances arrays. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getTopInstitutionGroups**
> GetTopInstitutionGroupsResponse getTopInstitutionGroups()

Monarch\'s top-N institutions grouped by category, scoped to the requested data providers. Used by the Add-Account UI. 

### Example

```typescript
import {
    AccountsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new AccountsApi(configuration);

let dataProvider: Array<string>; //One or more data providers (`PLAID`, `FINICITY`, `MX`). (optional) (default to undefined)

const { status, data } = await apiInstance.getTopInstitutionGroups(
    dataProvider
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **dataProvider** | **Array&lt;string&gt;** | One or more data providers (&#x60;PLAID&#x60;, &#x60;FINICITY&#x60;, &#x60;MX&#x60;). | (optional) defaults to undefined|


### Return type

**GetTopInstitutionGroupsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Top institution groups. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listAccounts**
> ListAccountsResponse listAccounts()

Returns every account the user has in Monarch: Plaid-linked depository, credit, loan, brokerage accounts plus any manually-created accounts.  Use this to enumerate accounts before scoping a transaction query, or to grab `account.id` values for filter params like `accountIds`. The shape includes `displayName`, `type`, `subtype`, `currentBalance`, `institution`, `includeInNetWorth`, and timestamps.  No filtering on the wire: hidden accounts and accounts with `isAsset: false` come back too. Filter client-side on `includeInNetWorth` or `hideFromList` if needed. For institution-scoped views use `GET /v1/institutions`. 

### Example

```typescript
import {
    AccountsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new AccountsApi(configuration);

const { status, data } = await apiInstance.listAccounts();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**ListAccountsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | All accounts (including hidden; filter client-side). |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listLinkedCredentials**
> ListLinkedCredentialsResponse listLinkedCredentials()

Lightweight list of every linked data-provider credential plus its institution (id, name, logo). For richer per-credential settings, use the existing institution-settings endpoint instead. 

### Example

```typescript
import {
    AccountsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new AccountsApi(configuration);

const { status, data } = await apiInstance.listLinkedCredentials();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**ListLinkedCredentialsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Linked credentials. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **previewAccountBalance**
> PreviewAccountBalanceResponse previewAccountBalance()

Returns the `displayBalance` Monarch would show for an account if `invertSyncedBalance` and/or `useAvailableBalance` were toggled. Used by the \"edit account\" form to live-preview the effect of those settings without committing the change.  Pure read-only - no state is mutated. 

### Example

```typescript
import {
    AccountsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new AccountsApi(configuration);

let id: string; //Monarch account id. (default to undefined)
let invertSyncedBalance: boolean; //Preview what the displayed balance would be if synced balances were sign-flipped. (optional) (default to undefined)
let useAvailableBalance: boolean; //Preview what the displayed balance would be using the available (vs current) balance. (optional) (default to undefined)

const { status, data } = await apiInstance.previewAccountBalance(
    id,
    invertSyncedBalance,
    useAvailableBalance
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch account id. | defaults to undefined|
| **invertSyncedBalance** | [**boolean**] | Preview what the displayed balance would be if synced balances were sign-flipped. | (optional) defaults to undefined|
| **useAvailableBalance** | [**boolean**] | Preview what the displayed balance would be using the available (vs current) balance. | (optional) defaults to undefined|


### Return type

**PreviewAccountBalanceResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Previewed display balance. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updateAccount**
> UpdateAccountResponse updateAccount(updateAccountRequest)

Patches an existing account. Only fields present in the body are forwarded to Monarch; omit a field to leave it untouched.  Common edits: rename via `name`, toggle visibility with `includeInNetWorth` / `hideFromList`, override the institution-reported `displayBalance` for manual accounts, or change `type`/`subtype`.  Works on both Plaid-linked and manual accounts, but balance edits only persist on manual accounts (Plaid will overwrite on next sync). Use `PATCH /v1/accounts/bulk` to update several at once. 

### Example

```typescript
import {
    AccountsApi,
    Configuration,
    UpdateAccountRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new AccountsApi(configuration);

let id: string; //Monarch account id. (default to undefined)
let updateAccountRequest: UpdateAccountRequest; //

const { status, data } = await apiInstance.updateAccount(
    id,
    updateAccountRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **updateAccountRequest** | **UpdateAccountRequest**|  | |
| **id** | [**string**] | Monarch account id. | defaults to undefined|


### Return type

**UpdateAccountResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Updated account. |  -  |
|**400** | Validation failed. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updateAccountGroupOrder**
> UpdateAccountGroupOrderResponse updateAccountGroupOrder(updateAccountGroupOrderRequest)

Persist a new ordering for account groups. Send the FULL ordered list of group ids; Monarch assigns sequential `order` values from the array index and returns the resulting `(id, order)` pairs.  Whole-set replace: omitting an id from the list does not delete the group but leaves its `order` undefined relative to the rest. 

### Example

```typescript
import {
    AccountsApi,
    Configuration,
    UpdateAccountGroupOrderRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new AccountsApi(configuration);

let updateAccountGroupOrderRequest: UpdateAccountGroupOrderRequest; //

const { status, data } = await apiInstance.updateAccountGroupOrder(
    updateAccountGroupOrderRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **updateAccountGroupOrderRequest** | **UpdateAccountGroupOrderRequest**|  | |


### Return type

**UpdateAccountGroupOrderResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Updated &#x60;(id, order)&#x60; pairs. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **uploadAccountBalanceHistory**
> UploadAccountBalanceHistory202Response uploadAccountBalanceHistory()

Two-step flow: (1) the proxy forwards the CSV to Monarch\'s `/account-balance-history/upload/` endpoint, (2) it triggers a parse via the `parseBalanceHistory` GraphQL mutation, then returns the session key. Poll `GET /v1/balance-history/{sessionKey}/status` until `status == \"completed\"`.  CSV format (matching Monarch\'s UI uploader): one header row `date,balance`, then one row per snapshot (`2026-01-31,12345.67`). Negative balances OK for credit/loan accounts. 

### Example

```typescript
import {
    AccountsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new AccountsApi(configuration);

let id: string; //Monarch account id. (default to undefined)
let file: File; //CSV with `date,balance` rows. UTF-8. (default to undefined)

const { status, data } = await apiInstance.uploadAccountBalanceHistory(
    id,
    file
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch account id. | defaults to undefined|
| **file** | [**File**] | CSV with &#x60;date,balance&#x60; rows. UTF-8. | defaults to undefined|


### Return type

**UploadAccountBalanceHistory202Response**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**202** | Upload accepted; returns the session key. Poll for completion. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

