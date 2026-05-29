# HoldingsApi

All URIs are relative to **

Method | HTTP request | Description
------------- | ------------- | -------------
[**bulkUpdateHoldings**](HoldingsApi.md#bulkUpdateHoldings) | **PATCH** /v1/holdings/bulk | Bulk reprice manual holdings
[**createManualHolding**](HoldingsApi.md#createManualHolding) | **POST** /v1/account/{id}/holdings | Add a manual holding to an account
[**createManualInvestmentsAccount**](HoldingsApi.md#createManualInvestmentsAccount) | **POST** /v1/accounts/manual-investments | Create a manual investments account
[**deleteHolding**](HoldingsApi.md#deleteHolding) | **DELETE** /v1/holdings/{id} | Delete a holding
[**getHoldingHistory**](HoldingsApi.md#getHoldingHistory) | **GET** /v1/holdings/{id}/history | Holding value history
[**getHoldingTransactions**](HoldingsApi.md#getHoldingTransactions) | **GET** /v1/holdings/{id}/transactions | Holding transactions (buys, sells, dividends)
[**getPortfolioAllocation**](HoldingsApi.md#getPortfolioAllocation) | **GET** /v1/portfolio/allocation | Portfolio allocation by classification
[**getPortfolioAllocationByAccount**](HoldingsApi.md#getPortfolioAllocationByAccount) | **GET** /v1/portfolio/allocation/by-account | Portfolio allocation grouped by account
[**getPortfolioAllocationByHoldings**](HoldingsApi.md#getPortfolioAllocationByHoldings) | **GET** /v1/portfolio/allocation/by-holdings | Portfolio allocation grouped by holding
[**getPortfolioAllocationHoldingsDetail**](HoldingsApi.md#getPortfolioAllocationHoldingsDetail) | **GET** /v1/portfolio/allocation/holdings-detail | Holdings within one allocation bucket
[**getSecurityDetails**](HoldingsApi.md#getSecurityDetails) | **GET** /v1/securities/{id} | Security details
[**getSecurityDividends**](HoldingsApi.md#getSecurityDividends) | **GET** /v1/securities/{id}/dividends | Security dividend history
[**getSecurityHistoricalPerformance**](HoldingsApi.md#getSecurityHistoricalPerformance) | **GET** /v1/securities/{id}/performance | Historical performance for one security
[**searchSecurities**](HoldingsApi.md#searchSecurities) | **GET** /v1/securities/search | Search the security catalog
[**updateHolding**](HoldingsApi.md#updateHolding) | **PATCH** /v1/holdings/{id} | Update a holding



## bulkUpdateHoldings

Bulk reprice manual holdings

Reprice many manual holdings in one round trip. Each entry carries the
holding id plus optional new 'quantity' and 'costBasis'. Monarch
processes each row independently and returns the success / failure
counts plus per-row failure reasons.

Bulk-best-effort: partial success returns 200 with 'failedCount > 0'.
A blanket failure (auth, malformed request) returns the usual error
envelope.

### Example

```bash
monarch-api bulkUpdateHoldings
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **bulkUpdateHoldingsRequest** | [**BulkUpdateHoldingsRequest**](BulkUpdateHoldingsRequest.md) |  |

### Return type

[**BulkUpdateHoldings200Response**](BulkUpdateHoldings200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## createManualHolding

Add a manual holding to an account

Tracks a security position inside a brokerage account that Monarch can't auto-sync
(e.g. employer 401k, private fund). 'securityId' must be a real Monarch security id;
use 'GET /v1/securities/search' to look one up by ticker or name.

### Example

```bash
monarch-api createManualHolding id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch account id. | [default to null]
 **createManualHoldingRequest** | [**CreateManualHoldingRequest**](CreateManualHoldingRequest.md) |  |

### Return type

[**CreateManualHolding200Response**](CreateManualHolding200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## createManualInvestmentsAccount

Create a manual investments account

Creates a brokerage-style account Monarch cannot auto-sync (e.g. employer 401k where
Plaid lacks coverage). Two tracking methods:

  - 'balances': single account-level balance, no per-security detail.
  - 'holdings': per-security positions (seed via 'initialHoldings').

Defaults: 'trackingMethod' is omitted (Monarch chooses based on whether 'initialHoldings'
is present). Use the dedicated holdings endpoints later to add or update positions.

### Example

```bash
monarch-api createManualInvestmentsAccount
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createManualInvestmentsAccountRequest** | [**CreateManualInvestmentsAccountRequest**](CreateManualInvestmentsAccountRequest.md) |  |

### Return type

[**CreateManualAccount200Response**](CreateManualAccount200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## deleteHolding

Delete a holding

Removes one security position from its account. **Destructive** -
no soft-delete. Use to clean up a stale manual holding or one
Monarch double-imported.

On Plaid-synced brokerage accounts the holding may re-appear on
next sync if the position still exists at the data provider. For
manual investments accounts the delete sticks.

### Example

```bash
monarch-api deleteHolding id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch holding id. | [default to null]

### Return type

[**DeleteAccount200Response**](DeleteAccount200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getHoldingHistory

Holding value history

Per-day value, quantity, and price series for one holding. Backs
the holding drawer chart in the web Investments tab.

### Example

```bash
monarch-api getHoldingHistory id=value  start=value  end=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch holding id. | [default to null]
 **start** | **string** | Lower bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]
 **end** | **string** | Upper bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]

### Return type

[**GetHoldingHistory200Response**](GetHoldingHistory200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getHoldingTransactions

Holding transactions (buys, sells, dividends)

Discrete cost-basis events for one holding across a window.
Different from 'GET /v1/holdings/{id}/history' which returns the
per-day price / value series - this returns the buys, sells,
dividends, and transfers that actually moved the position.

'type' is one of 'buy', 'sell', 'dividend', 'transfer_in',
'transfer_out'.

### Example

```bash
monarch-api getHoldingTransactions id=value  start=value  end=value  limit=value  offset=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch holding id. | [default to null]
 **start** | **string** | Lower bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]
 **end** | **string** | Upper bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]
 **limit** | **integer** | Page size. | [optional] [default to null]
 **offset** | **integer** | Page offset. | [optional] [default to null]

### Return type

[**GetHoldingTransactions200Response**](GetHoldingTransactions200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getPortfolioAllocation

Portfolio allocation by classification

Pie-chart-style allocation breakdown for the portfolio (or a subset filtered
via 'accountIds'). Pass 'classificationField' to bucket by security type, asset
class, or sector. Returns each bucket's percent + dollar value, plus the total
portfolio value.

### Example

```bash
monarch-api getPortfolioAllocation  Specify as:  accountIds=value1 accountIds=value2 accountIds=...  classificationField=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountIds** | [**array[string]**](string.md) | Filter by one or more Monarch account ids. Repeat the query param for each.
Preferred over the legacy single 'accountId' param; both are accepted and merged. | [optional] [default to null]
 **classificationField** | **string** | Monarch's 'PortfolioAllocationClassificationField' enum value (e.g. 'SECURITY_TYPE').
Omit to use Monarch's default classification. | [optional] [default to null]

### Return type

[**GetPortfolioAllocation200Response**](GetPortfolioAllocation200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getPortfolioAllocationByAccount

Portfolio allocation grouped by account

Allocation breakdown bucketed per investments account (rather than per security).
Each row is one account with its percent of portfolio and total dollar value.

### Example

```bash
monarch-api getPortfolioAllocationByAccount  Specify as:  accountIds=value1 accountIds=value2 accountIds=...  limit=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountIds** | [**array[string]**](string.md) | Filter by one or more Monarch account ids. Repeat the query param for each.
Preferred over the legacy single 'accountId' param; both are accepted and merged. | [optional] [default to null]
 **limit** | **integer** | Page size. | [optional] [default to null]

### Return type

[**GetPortfolioAllocationByHoldings200Response**](GetPortfolioAllocationByHoldings200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getPortfolioAllocationByHoldings

Portfolio allocation grouped by holding

Allocation breakdown bucketed per holding (ticker / security name), capped at
'limit' rows. Each row is one security with its percent of portfolio and total
dollar value.

### Example

```bash
monarch-api getPortfolioAllocationByHoldings  Specify as:  accountIds=value1 accountIds=value2 accountIds=...  limit=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountIds** | [**array[string]**](string.md) | Filter by one or more Monarch account ids. Repeat the query param for each.
Preferred over the legacy single 'accountId' param; both are accepted and merged. | [optional] [default to null]
 **limit** | **integer** | Page size. | [optional] [default to null]

### Return type

[**GetPortfolioAllocationByHoldings200Response**](GetPortfolioAllocationByHoldings200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getPortfolioAllocationHoldingsDetail

Holdings within one allocation bucket

Drill-down: lists the individual holdings inside one classification bucket (e.g.
every equity inside the \"Equities\" classification value). Requires
'classificationField' + 'classificationValue' plus optional pagination.

### Example

```bash
monarch-api getPortfolioAllocationHoldingsDetail  classificationField=value  classificationValue=value  Specify as:  accountIds=value1 accountIds=value2 accountIds=...  limit=value  offset=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **classificationField** | **string** | Monarch's 'PortfolioAllocationClassificationField' enum value. | [default to null]
 **classificationValue** | **string** | The specific bucket value within 'classificationField' to drill into. | [default to null]
 **accountIds** | [**array[string]**](string.md) | Filter by one or more Monarch account ids. Repeat the query param for each.
Preferred over the legacy single 'accountId' param; both are accepted and merged. | [optional] [default to null]
 **limit** | **integer** | Page size. | [optional] [default to null]
 **offset** | **integer** | Page offset. | [optional] [default to null]

### Return type

[**GetPortfolioAllocationHoldingsDetail200Response**](GetPortfolioAllocationHoldingsDetail200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getSecurityDetails

Security details

Full security metadata: ticker, name, type, sector, industry, market
cap, P/E ratio, dividend yield, current and closing price.

### Example

```bash
monarch-api getSecurityDetails id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch security id. | [default to null]

### Return type

[**GetSecurityDetails200Response**](GetSecurityDetails200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getSecurityDividends

Security dividend history

Dividend payment history for one security. Each entry has the
payment date, per-share amount, and dividend type (regular,
special, etc.).

### Example

```bash
monarch-api getSecurityDividends id=value  start=value  end=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch security id. | [default to null]
 **start** | **string** | Lower bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]
 **end** | **string** | Upper bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]

### Return type

[**GetSecurityDividends200Response**](GetSecurityDividends200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getSecurityHistoricalPerformance

Historical performance for one security

Per-day price history for one security plus its current and closing price.
'historicalChart' is a list of '(date, returnPercent, value)' points where
'returnPercent' is the cumulative return from the window start.

### Example

```bash
monarch-api getSecurityHistoricalPerformance id=value  start=value  end=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch security id. | [default to null]
 **start** | **string** | Window start (inclusive). | [optional] [default to null]
 **end** | **string** | Window end (inclusive). | [optional] [default to null]

### Return type

[**GetSecurityHistoricalPerformance200Response**](GetSecurityHistoricalPerformance200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## searchSecurities

Search the security catalog

Free-text search across Monarch's security catalog (Plaid-backed
plus user-added). Use to resolve a ticker or company name to the
'securityId' required by the manual holding endpoints
('POST /v1/account/{id}/holdings').

'q' is required and matches ticker, name, or partial substring.
'orderByPopularity: true' ranks by Monarch-wide holding popularity
instead of relevance (handy when you know the ticker is common but
the search returns less-traded names first).

### Example

```bash
monarch-api searchSecurities  q=value  limit=value  orderByPopularity=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **q** | **string** | Search text (ticker, name, partial match). | [default to null]
 **limit** | **integer** | Cap the result count. Monarch defaults to a small page when omitted. | [optional] [default to null]
 **orderByPopularity** | **boolean** | When true, Monarch ranks by popularity instead of relevance. | [optional] [default to null]

### Return type

[**SearchSecurities200Response**](SearchSecurities200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## updateHolding

Update a holding

Partial-update a holding. Fields are independent: pass only what changed.
'userCostBasis' is stored separately from any data-provider basis, so setting it
overrides for display only.

### Example

```bash
monarch-api updateHolding id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch holding id. | [default to null]
 **updateHoldingRequest** | [**UpdateHoldingRequest**](UpdateHoldingRequest.md) |  |

### Return type

[**UpdateHolding200Response**](UpdateHolding200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

