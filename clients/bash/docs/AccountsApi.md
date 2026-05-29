# AccountsApi

All URIs are relative to **

Method | HTTP request | Description
------------- | ------------- | -------------
[**bulkUpdateAccounts**](AccountsApi.md#bulkUpdateAccounts) | **PATCH** /v1/accounts/bulk | Bulk-update accounts
[**createManualAccount**](AccountsApi.md#createManualAccount) | **POST** /v1/accounts | Create a manual (non-Plaid) account
[**deleteAccount**](AccountsApi.md#deleteAccount) | **DELETE** /v1/accounts/{id} | Delete an account
[**deleteInstitution**](AccountsApi.md#deleteInstitution) | **DELETE** /v1/institutions/{id} | Delete a Plaid credential (institution connection)
[**getAccountBalanceAtDate**](AccountsApi.md#getAccountBalanceAtDate) | **GET** /v1/accounts/{id}/balance/at | Account display balance at a specific date
[**getAccountGroups**](AccountsApi.md#getAccountGroups) | **GET** /v1/account-groups | Account groups
[**getAccountHistory**](AccountsApi.md#getAccountHistory) | **GET** /v1/account/{id}/history | Daily balance snapshots for one account
[**getAccountHoldings**](AccountsApi.md#getAccountHoldings) | **GET** /v1/account/{id}/holdings | Investment positions in one account
[**getAccountTypeOptions**](AccountsApi.md#getAccountTypeOptions) | **GET** /v1/account-type-options | Valid (type, subtype) combinations for manual accounts
[**getBalanceHistoryStatus**](AccountsApi.md#getBalanceHistoryStatus) | **GET** /v1/balance-history/{sessionKey}/status | Poll the parse status of a balance-history upload
[**getCredentialInstitutions**](AccountsApi.md#getCredentialInstitutions) | **GET** /v1/credentials/institutions | Linked credentials with their institution metadata
[**getInstitutionByPlaidId**](AccountsApi.md#getInstitutionByPlaidId) | **GET** /v1/institutions/by-plaid/{plaidId} | Institution lookup by Plaid id
[**getInstitutions**](AccountsApi.md#getInstitutions) | **GET** /v1/institutions | Linked institution credentials (Plaid connection pipes)
[**getNetworth**](AccountsApi.md#getNetworth) | **GET** /v1/networth | Net-worth snapshots over time
[**getNetworthByType**](AccountsApi.md#getNetworthByType) | **GET** /v1/networth/by-type | Balance history grouped by account-type
[**getNetworthRecent**](AccountsApi.md#getNetworthRecent) | **GET** /v1/networth/recent | Per-account recent balance fluctuations
[**getTopInstitutionGroups**](AccountsApi.md#getTopInstitutionGroups) | **GET** /v1/institutions/top-groups | Top institution groups (popular providers by category)
[**listAccounts**](AccountsApi.md#listAccounts) | **GET** /v1/accounts | List all linked + manual accounts
[**listLinkedCredentials**](AccountsApi.md#listLinkedCredentials) | **GET** /v1/credentials | List linked credentials
[**previewAccountBalance**](AccountsApi.md#previewAccountBalance) | **GET** /v1/accounts/{id}/balance/preview | Preview an account display balance under edit options
[**updateAccount**](AccountsApi.md#updateAccount) | **PATCH** /v1/accounts/{id} | Partial-update an account
[**updateAccountGroupOrder**](AccountsApi.md#updateAccountGroupOrder) | **PUT** /v1/account-groups/order | Reorder account groups
[**uploadAccountBalanceHistory**](AccountsApi.md#uploadAccountBalanceHistory) | **POST** /v1/accounts/{id}/balance-history | Bulk-backfill balance history for a manual account from a CSV



## bulkUpdateAccounts

Bulk-update accounts

Forwards Monarch's 'updateAccounts' mutation. Send one or more
'UpdateAccountsMutationInput' entries; each must include 'id' plus any subset of
the patchable fields. Returns every updated account.

Use for \"rename three accounts at once\" / \"hide a set of accounts\" / \"flip
includeInNetWorth on a list\" without firing N single 'PATCH /v1/accounts/{id}'
calls.

### Example

```bash
monarch-api bulkUpdateAccounts
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **bulkUpdateAccountsRequest** | [**BulkUpdateAccountsRequest**](BulkUpdateAccountsRequest.md) |  |

### Return type

[**BulkUpdateAccounts200Response**](BulkUpdateAccounts200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## createManualAccount

Create a manual (non-Plaid) account

Creates an account Monarch will not auto-sync. Use for cash, foreign
accounts, employer 401k where Plaid has no coverage, real-estate holdings,
or any other balance the user wants tracked in net worth.

Required: 'name', 'type', 'subtype', 'displayBalance'. Use
'GET /v1/account-type-options' to enumerate the valid '(type, subtype)'
pairs. For brokerage-style accounts with per-security holdings, use
'POST /v1/accounts/manual-investments' instead.

Returns the new account id. After creation, set up balance history via
'POST /v1/accounts/{id}/balance-history' (CSV upload) or just let the
daily snapshots accumulate from this point forward.

### Example

```bash
monarch-api createManualAccount
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createManualAccountRequest** | [**CreateManualAccountRequest**](CreateManualAccountRequest.md) |  |

### Return type

[**CreateManualAccount200Response**](CreateManualAccount200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## deleteAccount

Delete an account

**Destructive**: removes the account AND every transaction Monarch
associated with it. Balance-history snapshots are also discarded.

Use to clean up a manual account that's no longer relevant, or to
fully purge a Plaid-linked account whose credential was already
unlinked via 'DELETE /v1/institutions/{id}'. There is no undo and
no soft-delete fallback for this endpoint - the institution-level
delete soft-deletes accounts; this one hard-deletes a single one.

### Example

```bash
monarch-api deleteAccount id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch account id. | [default to null]

### Return type

[**DeleteAccount200Response**](DeleteAccount200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## deleteInstitution

Delete a Plaid credential (institution connection)

Unlinks an institution from Monarch by deleting its Plaid credential.
Equivalent to Monarch web UI: Settings -> Data Sources -> unlink.

The associated accounts get **soft-deleted**: they still appear in
'GET /v1/institutions' under 'accounts[]' with a non-null 'deletedAt',
but are excluded from default 'GET /v1/accounts' results.

Use this to clean up stale credentials with 'updateRequired: true' that
no longer authenticate (the equivalent of a dead Plaid connection).
Credential IDs come from 'GET /v1/institutions' 'credentials[].id'.

### Example

```bash
monarch-api deleteInstitution id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Credential ID from '/v1/institutions' 'credentials[].id'. | [default to null]

### Return type

[**DeleteInstitution200Response**](DeleteInstitution200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getAccountBalanceAtDate

Account display balance at a specific date

\"What was this account worth on YYYY-MM-DD.\" Walks back through Monarch's
daily snapshot series and returns the displayed (sign-adjusted) balance
as of the requested date.

Use for point-in-time reporting (year-end statements, lookback charts) when
you need one date for one account. For the full series use
'GET /v1/account/{id}/history'; for aggregate net worth at a date use
'GET /v1/networth'.

### Example

```bash
monarch-api getAccountBalanceAtDate id=value  date=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch account id. | [default to null]
 **date** | **string** | Lookback date, 'YYYY-MM-DD'. | [default to null]

### Return type

[**GetAccountBalanceAtDate200Response**](GetAccountBalanceAtDate200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getAccountGroups

Account groups

Visual groupings of accounts under the Accounts tab. Each group has a
display order, an optional collapsed flag, and the ids of accounts it
contains. Pure read - the web tab fires this on mount.

Pair with 'PUT /v1/account-groups/order' to persist a new ordering.

### Example

```bash
monarch-api getAccountGroups
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**GetAccountGroups200Response**](GetAccountGroups200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getAccountHistory

Daily balance snapshots for one account

Returns the full daily balance series for a single account: one snapshot
per day from the link date (or first manual entry) through today.

Use for per-account trend charts, drift analysis between two accounts, or
to reconstruct a balance at a specific point in time. For aggregated
net-worth across accounts use 'GET /v1/networth' instead.

Series is chronologically ascending. Each entry is '(date, signedBalance)'
where the sign matches the account type (loans/credit are negative). For
type-grouped or recent-only views see 'GET /v1/networth/by-type' and
'GET /v1/networth/recent'.

### Example

```bash
monarch-api getAccountHistory id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch account id. | [default to null]

### Return type

[**GetAccountHistory200Response**](GetAccountHistory200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getAccountHoldings

Investment positions in one account

Returns every security position Monarch tracks inside the account:
quantity, value, cost basis, security metadata (ticker, name, type),
and last-updated timestamp.

Brokerage/retirement accounts only. Returns an empty list for
depository, credit, and loan accounts (no error). For the full security
catalog lookup use 'GET /v1/securities/search'; to mutate a single
holding use 'PATCH /v1/holdings/{id}' or 'DELETE /v1/holdings/{id}'.

### Example

```bash
monarch-api getAccountHoldings id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch account id. | [default to null]

### Return type

[**GetAccountHoldings200Response**](GetAccountHoldings200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getAccountTypeOptions

Valid (type, subtype) combinations for manual accounts

Enumerates the '(type, subtype)' pairs Monarch accepts when creating a
manual account. Use before calling 'POST /v1/accounts' to confirm the
pair is supported (e.g. '(depository, checking)', '(loan, auto)',
'(real_estate, residential)').

Static catalog: the response shape is stable across users and rarely
changes, so it's safe to cache for the session. Returns each type
bundled with its supported subtypes plus display names.

### Example

```bash
monarch-api getAccountTypeOptions
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**GetAccountTypeOptions200Response**](GetAccountTypeOptions200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getBalanceHistoryStatus

Poll the parse status of a balance-history upload

Polls the async parse job kicked off by 'POST /v1/accounts/{id}/balance-history'.
Returns Monarch's current 'status' for the session ('pending',
'processing', 'completed', 'failed').

Typical flow: upload the CSV, grab the 'sessionKey' from that 202
response, then call this endpoint every few seconds until 'status'
reaches 'completed' (usually under 10 seconds for a year of monthly
snapshots). On 'failed', the response includes a Monarch-side error
string explaining the parse problem.

### Example

```bash
monarch-api getBalanceHistoryStatus sessionKey=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sessionKey** | **string** | Session key returned from the upload call. | [default to null]

### Return type

[**GetBalanceHistoryStatus200Response**](GetBalanceHistoryStatus200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getCredentialInstitutions

Linked credentials with their institution metadata

List of credentials with their institutions and the per-credential
'preferredDataProvider'. Richer than '/v1/credentials' because it
includes per-provider institution ids (Plaid, Finicity, MX).

### Example

```bash
monarch-api getCredentialInstitutions
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**GetCredentialInstitutions200Response**](GetCredentialInstitutions200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getInstitutionByPlaidId

Institution lookup by Plaid id

Look up institution metadata (logo, status, connection health) by
its Plaid institution id.

### Example

```bash
monarch-api getInstitutionByPlaidId plaidId=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **plaidId** | **string** | The Plaid institution id (e.g. 'ins_3'). | [default to null]

### Return type

[**GetInstitutionByPlaidId200Response**](GetInstitutionByPlaidId200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getInstitutions

Linked institution credentials (Plaid connection pipes)

Returns every Plaid credential the user has linked, plus the
accounts behind each one and Monarch's subscription summary.
Credentials are the \"pipes\" - one per institution per Plaid item -
that supply accounts on the other side.

Use to surface connection health: each credential carries
'updateRequired', 'disconnectedFromDataProviderAt', and last-sync
timestamps so you can detect dead Plaid links. Includes
soft-deleted accounts under 'accounts[]' (filter by 'deletedAt').

To unlink an institution use 'DELETE /v1/institutions/{id}' where
'{id}' is the credential id from 'credentials[].id' here.

### Example

```bash
monarch-api getInstitutions
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**GetInstitutions200Response**](GetInstitutions200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getNetworth

Net-worth snapshots over time

Returns the user's aggregate net-worth series for the date window:
one row per day with total assets, total liabilities, and net
(assets minus liabilities).

'start' is the oldest date in the window; omit for full history
back to the first account link. 'accountType' optionally scopes the
series to one account type (e.g. only 'brokerage' to chart investments
in isolation).

Use for top-of-dashboard net-worth charts or trend analysis. For
a per-account-type breakdown see 'GET /v1/networth/by-type'; for
per-account recent fluctuations see 'GET /v1/networth/recent'. For
a single account's history use 'GET /v1/account/{id}/history'.

### Example

```bash
monarch-api getNetworth  start=value  end=value  accountType=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **string** | Lower bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]
 **end** | **string** | Upper bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]
 **accountType** | **string** | Filter to one Monarch account type (e.g. 'brokerage', 'real_estate'). | [optional] [default to null]

### Return type

[**GetNetworth200Response**](GetNetworth200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getNetworthByType

Balance history grouped by account-type

Returns balance snapshots aggregated per account type (depository,
credit, brokerage, loan, real_estate, etc.) instead of one combined
total. Each type gets its own series plus the catalog of account
types is included for convenience.

Use for stacked-area net-worth charts that show how the composition
of net worth has shifted over time (e.g. \"cash share is shrinking as
brokerage grows\"). 'timeframe' controls bucketing ('day' / 'week' /
'month' / 'year').

### Example

```bash
monarch-api getNetworthByType  start=value  timeframe=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **string** | Lower bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]
 **timeframe** | **string** | Bucket size for grouped snapshots. | [optional] [default to month]

### Return type

[**GetNetworthByType200Response**](GetNetworthByType200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getNetworthRecent

Per-account recent balance fluctuations

Returns a short recent-balances series for **each account**,
starting at 'start' (typically a week or month back). Lighter than
pulling each account's full history one-by-one when all you need is
a recent sparkline.

Use for a \"what changed lately\" dashboard view that highlights
accounts with non-trivial movement. For the full per-account series
use 'GET /v1/account/{id}/history'; for the household-aggregate
series use 'GET /v1/networth'.

### Example

```bash
monarch-api getNetworthRecent  start=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **string** | Lower bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]

### Return type

[**GetNetworthRecent200Response**](GetNetworthRecent200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getTopInstitutionGroups

Top institution groups (popular providers by category)

Monarch's top-N institutions grouped by category, scoped to the
requested data providers. Used by the Add-Account UI.

### Example

```bash
monarch-api getTopInstitutionGroups  Specify as:  dataProvider=value1 dataProvider=value2 dataProvider=...
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **dataProvider** | [**array[string]**](string.md) | One or more data providers ('PLAID', 'FINICITY', 'MX'). | [optional] [default to null]

### Return type

[**GetTopInstitutionGroups200Response**](GetTopInstitutionGroups200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## listAccounts

List all linked + manual accounts

Returns every account the user has in Monarch: Plaid-linked depository,
credit, loan, brokerage accounts plus any manually-created accounts.

Use this to enumerate accounts before scoping a transaction query, or to
grab 'account.id' values for filter params like 'accountIds'. The shape
includes 'displayName', 'type', 'subtype', 'currentBalance', 'institution',
'includeInNetWorth', and timestamps.

No filtering on the wire: hidden accounts and accounts with
'isAsset: false' come back too. Filter client-side on 'includeInNetWorth'
or 'hideFromList' if needed. For institution-scoped views use
'GET /v1/institutions'.

### Example

```bash
monarch-api listAccounts
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**ListAccounts200Response**](ListAccounts200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## listLinkedCredentials

List linked credentials

Lightweight list of every linked data-provider credential plus its institution
(id, name, logo). For richer per-credential settings, use the existing
institution-settings endpoint instead.

### Example

```bash
monarch-api listLinkedCredentials
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**ListLinkedCredentials200Response**](ListLinkedCredentials200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## previewAccountBalance

Preview an account display balance under edit options

Returns the 'displayBalance' Monarch would show for an account if
'invertSyncedBalance' and/or 'useAvailableBalance' were toggled.
Used by the \"edit account\" form to live-preview the effect of those
settings without committing the change.

Pure read-only - no state is mutated.

### Example

```bash
monarch-api previewAccountBalance id=value  invertSyncedBalance=value  useAvailableBalance=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch account id. | [default to null]
 **invertSyncedBalance** | **boolean** | Preview what the displayed balance would be if synced balances were sign-flipped. | [optional] [default to null]
 **useAvailableBalance** | **boolean** | Preview what the displayed balance would be using the available (vs current) balance. | [optional] [default to null]

### Return type

[**PreviewAccountBalance200Response**](PreviewAccountBalance200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## updateAccount

Partial-update an account

Patches an existing account. Only fields present in the body are
forwarded to Monarch; omit a field to leave it untouched.

Common edits: rename via 'name', toggle visibility with
'includeInNetWorth' / 'hideFromList', override the institution-reported
'displayBalance' for manual accounts, or change 'type'/'subtype'.

Works on both Plaid-linked and manual accounts, but balance edits only
persist on manual accounts (Plaid will overwrite on next sync). Use
'PATCH /v1/accounts/bulk' to update several at once.

### Example

```bash
monarch-api updateAccount id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch account id. | [default to null]
 **updateAccountRequest** | [**UpdateAccountRequest**](UpdateAccountRequest.md) |  |

### Return type

[**UpdateAccount200Response**](UpdateAccount200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## updateAccountGroupOrder

Reorder account groups

Persist a new ordering for account groups. Send the FULL ordered list of
group ids; Monarch assigns sequential 'order' values from the array index
and returns the resulting '(id, order)' pairs.

Whole-set replace: omitting an id from the list does not delete the group
but leaves its 'order' undefined relative to the rest.

### Example

```bash
monarch-api updateAccountGroupOrder
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **updateAccountGroupOrderRequest** | [**UpdateAccountGroupOrderRequest**](UpdateAccountGroupOrderRequest.md) |  |

### Return type

[**UpdateAccountGroupOrder200Response**](UpdateAccountGroupOrder200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## uploadAccountBalanceHistory

Bulk-backfill balance history for a manual account from a CSV

Two-step flow: (1) the proxy forwards the CSV to Monarch's
'/account-balance-history/upload/' endpoint, (2) it triggers a parse via the
'parseBalanceHistory' GraphQL mutation, then returns the session key. Poll
'GET /v1/balance-history/{sessionKey}/status' until 'status == \"completed\"'.

CSV format (matching Monarch's UI uploader): one header row 'date,balance', then
one row per snapshot ('2026-01-31,12345.67'). Negative balances OK for
credit/loan accounts.

### Example

```bash
monarch-api uploadAccountBalanceHistory id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch account id. | [default to null]
 **file** | **binary** | CSV with 'date,balance' rows. UTF-8. | [default to null]

### Return type

[**UploadAccountBalanceHistory202Response**](UploadAccountBalanceHistory202Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: multipart/form-data
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

