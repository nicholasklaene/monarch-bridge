# HoldingsApi

All URIs are relative to *http://localhost:9084*

|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|[**bulkUpdateHoldings**](#bulkupdateholdings) | **PATCH** /v1/holdings/bulk | Bulk reprice manual holdings|
|[**createManualHolding**](#createmanualholding) | **POST** /v1/account/{id}/holdings | Add a manual holding to an account|
|[**createManualInvestmentsAccount**](#createmanualinvestmentsaccount) | **POST** /v1/accounts/manual-investments | Create a manual investments account|
|[**deleteHolding**](#deleteholding) | **DELETE** /v1/holdings/{id} | Delete a holding|
|[**getHoldingHistory**](#getholdinghistory) | **GET** /v1/holdings/{id}/history | Holding value history|
|[**getHoldingTransactions**](#getholdingtransactions) | **GET** /v1/holdings/{id}/transactions | Holding transactions (buys, sells, dividends)|
|[**getPortfolioAllocation**](#getportfolioallocation) | **GET** /v1/portfolio/allocation | Portfolio allocation by classification|
|[**getPortfolioAllocationByAccount**](#getportfolioallocationbyaccount) | **GET** /v1/portfolio/allocation/by-account | Portfolio allocation grouped by account|
|[**getPortfolioAllocationByHoldings**](#getportfolioallocationbyholdings) | **GET** /v1/portfolio/allocation/by-holdings | Portfolio allocation grouped by holding|
|[**getPortfolioAllocationHoldingsDetail**](#getportfolioallocationholdingsdetail) | **GET** /v1/portfolio/allocation/holdings-detail | Holdings within one allocation bucket|
|[**getSecurityDetails**](#getsecuritydetails) | **GET** /v1/securities/{id} | Security details|
|[**getSecurityDividends**](#getsecuritydividends) | **GET** /v1/securities/{id}/dividends | Security dividend history|
|[**getSecurityHistoricalPerformance**](#getsecurityhistoricalperformance) | **GET** /v1/securities/{id}/performance | Historical performance for one security|
|[**searchSecurities**](#searchsecurities) | **GET** /v1/securities/search | Search the security catalog|
|[**updateHolding**](#updateholding) | **PATCH** /v1/holdings/{id} | Update a holding|

# **bulkUpdateHoldings**
> BulkUpdateHoldingsResponse bulkUpdateHoldings(bulkUpdateHoldingsRequest)

Reprice many manual holdings in one round trip. Each entry carries the holding id plus optional new `quantity` and `costBasis`. Monarch processes each row independently and returns the success / failure counts plus per-row failure reasons.  Bulk-best-effort: partial success returns 200 with `failedCount > 0`. A blanket failure (auth, malformed request) returns the usual error envelope. 

### Example

```typescript
import {
    HoldingsApi,
    Configuration,
    BulkUpdateHoldingsRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new HoldingsApi(configuration);

let bulkUpdateHoldingsRequest: BulkUpdateHoldingsRequest; //

const { status, data } = await apiInstance.bulkUpdateHoldings(
    bulkUpdateHoldingsRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **bulkUpdateHoldingsRequest** | **BulkUpdateHoldingsRequest**|  | |


### Return type

**BulkUpdateHoldingsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Counts plus any per-row failures. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **createManualHolding**
> CreateManualHoldingResponse createManualHolding(createManualHoldingRequest)

Tracks a security position inside a brokerage account that Monarch can\'t auto-sync (e.g. employer 401k, private fund). `securityId` must be a real Monarch security id; use `GET /v1/securities/search` to look one up by ticker or name. 

### Example

```typescript
import {
    HoldingsApi,
    Configuration,
    CreateManualHoldingRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new HoldingsApi(configuration);

let id: string; //Monarch account id. (default to undefined)
let createManualHoldingRequest: CreateManualHoldingRequest; //

const { status, data } = await apiInstance.createManualHolding(
    id,
    createManualHoldingRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **createManualHoldingRequest** | **CreateManualHoldingRequest**|  | |
| **id** | [**string**] | Monarch account id. | defaults to undefined|


### Return type

**CreateManualHoldingResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | New holding id. |  -  |
|**400** | Validation failed. |  -  |
|**422** | Monarch PayloadError. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **createManualInvestmentsAccount**
> CreateManualAccountResponse createManualInvestmentsAccount(createManualInvestmentsAccountRequest)

Creates a brokerage-style account Monarch cannot auto-sync (e.g. employer 401k where Plaid lacks coverage). Two tracking methods:    - `balances`: single account-level balance, no per-security detail.   - `holdings`: per-security positions (seed via `initialHoldings`).  Defaults: `trackingMethod` is omitted (Monarch chooses based on whether `initialHoldings` is present). Use the dedicated holdings endpoints later to add or update positions. 

### Example

```typescript
import {
    HoldingsApi,
    Configuration,
    CreateManualInvestmentsAccountRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new HoldingsApi(configuration);

let createManualInvestmentsAccountRequest: CreateManualInvestmentsAccountRequest; //

const { status, data } = await apiInstance.createManualInvestmentsAccount(
    createManualInvestmentsAccountRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **createManualInvestmentsAccountRequest** | **CreateManualInvestmentsAccountRequest**|  | |


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

# **deleteHolding**
> DeleteAccountResponse deleteHolding()

Removes one security position from its account. **Destructive** - no soft-delete. Use to clean up a stale manual holding or one Monarch double-imported.  On Plaid-synced brokerage accounts the holding may re-appear on next sync if the position still exists at the data provider. For manual investments accounts the delete sticks. 

### Example

```typescript
import {
    HoldingsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new HoldingsApi(configuration);

let id: string; //Monarch holding id. (default to undefined)

const { status, data } = await apiInstance.deleteHolding(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch holding id. | defaults to undefined|


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

# **getHoldingHistory**
> GetHoldingHistoryResponse getHoldingHistory()

Per-day value, quantity, and price series for one holding. Backs the holding drawer chart in the web Investments tab. 

### Example

```typescript
import {
    HoldingsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new HoldingsApi(configuration);

let id: string; //Monarch holding id. (default to undefined)
let start: string; //Lower bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)
let end: string; //Upper bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)

const { status, data } = await apiInstance.getHoldingHistory(
    id,
    start,
    end
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch holding id. | defaults to undefined|
| **start** | [**string**] | Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|
| **end** | [**string**] | Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|


### Return type

**GetHoldingHistoryResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Per-day points. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getHoldingTransactions**
> GetHoldingTransactionsResponse getHoldingTransactions()

Discrete cost-basis events for one holding across a window. Different from `GET /v1/holdings/{id}/history` which returns the per-day price / value series - this returns the buys, sells, dividends, and transfers that actually moved the position.  `type` is one of `buy`, `sell`, `dividend`, `transfer_in`, `transfer_out`. 

### Example

```typescript
import {
    HoldingsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new HoldingsApi(configuration);

let id: string; //Monarch holding id. (default to undefined)
let start: string; //Lower bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)
let end: string; //Upper bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)
let limit: number; //Page size. (optional) (default to undefined)
let offset: number; //Page offset. (optional) (default to undefined)

const { status, data } = await apiInstance.getHoldingTransactions(
    id,
    start,
    end,
    limit,
    offset
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch holding id. | defaults to undefined|
| **start** | [**string**] | Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|
| **end** | [**string**] | Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|
| **limit** | [**number**] | Page size. | (optional) defaults to undefined|
| **offset** | [**number**] | Page offset. | (optional) defaults to undefined|


### Return type

**GetHoldingTransactionsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Holding transactions in the window. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getPortfolioAllocation**
> GetPortfolioAllocationResponse getPortfolioAllocation()

Pie-chart-style allocation breakdown for the portfolio (or a subset filtered via `accountIds`). Pass `classificationField` to bucket by security type, asset class, or sector. Returns each bucket\'s percent + dollar value, plus the total portfolio value. 

### Example

```typescript
import {
    HoldingsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new HoldingsApi(configuration);

let accountIds: Array<string>; //Filter by one or more Monarch account ids. Repeat the query param for each. Preferred over the legacy single `accountId` param; both are accepted and merged.  (optional) (default to undefined)
let classificationField: string; //Monarch\'s `PortfolioAllocationClassificationField` enum value (e.g. `SECURITY_TYPE`). Omit to use Monarch\'s default classification.  (optional) (default to undefined)

const { status, data } = await apiInstance.getPortfolioAllocation(
    accountIds,
    classificationField
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **accountIds** | **Array&lt;string&gt;** | Filter by one or more Monarch account ids. Repeat the query param for each. Preferred over the legacy single &#x60;accountId&#x60; param; both are accepted and merged.  | (optional) defaults to undefined|
| **classificationField** | [**string**] | Monarch\&#39;s &#x60;PortfolioAllocationClassificationField&#x60; enum value (e.g. &#x60;SECURITY_TYPE&#x60;). Omit to use Monarch\&#39;s default classification.  | (optional) defaults to undefined|


### Return type

**GetPortfolioAllocationResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Allocation breakdown. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getPortfolioAllocationByAccount**
> GetPortfolioAllocationByHoldingsResponse getPortfolioAllocationByAccount()

Allocation breakdown bucketed per investments account (rather than per security). Each row is one account with its percent of portfolio and total dollar value. 

### Example

```typescript
import {
    HoldingsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new HoldingsApi(configuration);

let accountIds: Array<string>; //Filter by one or more Monarch account ids. Repeat the query param for each. Preferred over the legacy single `accountId` param; both are accepted and merged.  (optional) (default to undefined)
let limit: number; //Page size. (optional) (default to undefined)

const { status, data } = await apiInstance.getPortfolioAllocationByAccount(
    accountIds,
    limit
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **accountIds** | **Array&lt;string&gt;** | Filter by one or more Monarch account ids. Repeat the query param for each. Preferred over the legacy single &#x60;accountId&#x60; param; both are accepted and merged.  | (optional) defaults to undefined|
| **limit** | [**number**] | Page size. | (optional) defaults to undefined|


### Return type

**GetPortfolioAllocationByHoldingsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Per-account allocation rows. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getPortfolioAllocationByHoldings**
> GetPortfolioAllocationByHoldingsResponse getPortfolioAllocationByHoldings()

Allocation breakdown bucketed per holding (ticker / security name), capped at `limit` rows. Each row is one security with its percent of portfolio and total dollar value. 

### Example

```typescript
import {
    HoldingsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new HoldingsApi(configuration);

let accountIds: Array<string>; //Filter by one or more Monarch account ids. Repeat the query param for each. Preferred over the legacy single `accountId` param; both are accepted and merged.  (optional) (default to undefined)
let limit: number; //Page size. (optional) (default to undefined)

const { status, data } = await apiInstance.getPortfolioAllocationByHoldings(
    accountIds,
    limit
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **accountIds** | **Array&lt;string&gt;** | Filter by one or more Monarch account ids. Repeat the query param for each. Preferred over the legacy single &#x60;accountId&#x60; param; both are accepted and merged.  | (optional) defaults to undefined|
| **limit** | [**number**] | Page size. | (optional) defaults to undefined|


### Return type

**GetPortfolioAllocationByHoldingsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Per-holding allocation rows. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getPortfolioAllocationHoldingsDetail**
> GetPortfolioAllocationHoldingsDetailResponse getPortfolioAllocationHoldingsDetail()

Drill-down: lists the individual holdings inside one classification bucket (e.g. every equity inside the \"Equities\" classification value). Requires `classificationField` + `classificationValue` plus optional pagination. 

### Example

```typescript
import {
    HoldingsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new HoldingsApi(configuration);

let classificationField: string; //Monarch\'s `PortfolioAllocationClassificationField` enum value. (default to undefined)
let classificationValue: string; //The specific bucket value within `classificationField` to drill into. (default to undefined)
let accountIds: Array<string>; //Filter by one or more Monarch account ids. Repeat the query param for each. Preferred over the legacy single `accountId` param; both are accepted and merged.  (optional) (default to undefined)
let limit: number; //Page size. (optional) (default to undefined)
let offset: number; //Page offset. (optional) (default to undefined)

const { status, data } = await apiInstance.getPortfolioAllocationHoldingsDetail(
    classificationField,
    classificationValue,
    accountIds,
    limit,
    offset
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **classificationField** | [**string**] | Monarch\&#39;s &#x60;PortfolioAllocationClassificationField&#x60; enum value. | defaults to undefined|
| **classificationValue** | [**string**] | The specific bucket value within &#x60;classificationField&#x60; to drill into. | defaults to undefined|
| **accountIds** | **Array&lt;string&gt;** | Filter by one or more Monarch account ids. Repeat the query param for each. Preferred over the legacy single &#x60;accountId&#x60; param; both are accepted and merged.  | (optional) defaults to undefined|
| **limit** | [**number**] | Page size. | (optional) defaults to undefined|
| **offset** | [**number**] | Page offset. | (optional) defaults to undefined|


### Return type

**GetPortfolioAllocationHoldingsDetailResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Holdings inside the requested bucket. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getSecurityDetails**
> GetSecurityDetailsResponse getSecurityDetails()

Full security metadata: ticker, name, type, sector, industry, market cap, P/E ratio, dividend yield, current and closing price. 

### Example

```typescript
import {
    HoldingsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new HoldingsApi(configuration);

let id: string; //Monarch security id. (default to undefined)

const { status, data } = await apiInstance.getSecurityDetails(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch security id. | defaults to undefined|


### Return type

**GetSecurityDetailsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Security details. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getSecurityDividends**
> GetSecurityDividendsResponse getSecurityDividends()

Dividend payment history for one security. Each entry has the payment date, per-share amount, and dividend type (regular, special, etc.). 

### Example

```typescript
import {
    HoldingsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new HoldingsApi(configuration);

let id: string; //Monarch security id. (default to undefined)
let start: string; //Lower bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)
let end: string; //Upper bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)

const { status, data } = await apiInstance.getSecurityDividends(
    id,
    start,
    end
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch security id. | defaults to undefined|
| **start** | [**string**] | Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|
| **end** | [**string**] | Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|


### Return type

**GetSecurityDividendsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Dividend history. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getSecurityHistoricalPerformance**
> GetSecurityHistoricalPerformanceResponse getSecurityHistoricalPerformance()

Per-day price history for one security plus its current and closing price. `historicalChart` is a list of `(date, returnPercent, value)` points where `returnPercent` is the cumulative return from the window start. 

### Example

```typescript
import {
    HoldingsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new HoldingsApi(configuration);

let id: string; //Monarch security id. (default to undefined)
let start: string; //Window start (inclusive). (optional) (default to undefined)
let end: string; //Window end (inclusive). (optional) (default to undefined)

const { status, data } = await apiInstance.getSecurityHistoricalPerformance(
    id,
    start,
    end
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch security id. | defaults to undefined|
| **start** | [**string**] | Window start (inclusive). | (optional) defaults to undefined|
| **end** | [**string**] | Window end (inclusive). | (optional) defaults to undefined|


### Return type

**GetSecurityHistoricalPerformanceResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Historical price + return chart. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **searchSecurities**
> SearchSecuritiesResponse searchSecurities()

Free-text search across Monarch\'s security catalog (Plaid-backed plus user-added). Use to resolve a ticker or company name to the `securityId` required by the manual holding endpoints (`POST /v1/account/{id}/holdings`).  `q` is required and matches ticker, name, or partial substring. `orderByPopularity: true` ranks by Monarch-wide holding popularity instead of relevance (handy when you know the ticker is common but the search returns less-traded names first). 

### Example

```typescript
import {
    HoldingsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new HoldingsApi(configuration);

let q: string; //Search text (ticker, name, partial match). (default to undefined)
let limit: number; //Cap the result count. Monarch defaults to a small page when omitted. (optional) (default to undefined)
let orderByPopularity: boolean; //When true, Monarch ranks by popularity instead of relevance. (optional) (default to undefined)

const { status, data } = await apiInstance.searchSecurities(
    q,
    limit,
    orderByPopularity
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **q** | [**string**] | Search text (ticker, name, partial match). | defaults to undefined|
| **limit** | [**number**] | Cap the result count. Monarch defaults to a small page when omitted. | (optional) defaults to undefined|
| **orderByPopularity** | [**boolean**] | When true, Monarch ranks by popularity instead of relevance. | (optional) defaults to undefined|


### Return type

**SearchSecuritiesResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Matching securities. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updateHolding**
> UpdateHoldingResponse updateHolding(updateHoldingRequest)

Partial-update a holding. Fields are independent: pass only what changed. `userCostBasis` is stored separately from any data-provider basis, so setting it overrides for display only. 

### Example

```typescript
import {
    HoldingsApi,
    Configuration,
    UpdateHoldingRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new HoldingsApi(configuration);

let id: string; //Monarch holding id. (default to undefined)
let updateHoldingRequest: UpdateHoldingRequest; //

const { status, data } = await apiInstance.updateHolding(
    id,
    updateHoldingRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **updateHoldingRequest** | **UpdateHoldingRequest**|  | |
| **id** | [**string**] | Monarch holding id. | defaults to undefined|


### Return type

**UpdateHoldingResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Updated holding id. |  -  |
|**400** | Validation failed. |  -  |
|**422** | Monarch PayloadError. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

