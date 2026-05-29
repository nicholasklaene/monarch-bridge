# HoldingsApi

All URIs are relative to *http://localhost:9084*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**bulkUpdateHoldings**](HoldingsApi.md#bulkUpdateHoldings) | **PATCH** /v1/holdings/bulk | Bulk reprice manual holdings |
| [**createManualHolding**](HoldingsApi.md#createManualHolding) | **POST** /v1/account/{id}/holdings | Add a manual holding to an account |
| [**createManualInvestmentsAccount**](HoldingsApi.md#createManualInvestmentsAccount) | **POST** /v1/accounts/manual-investments | Create a manual investments account |
| [**deleteHolding**](HoldingsApi.md#deleteHolding) | **DELETE** /v1/holdings/{id} | Delete a holding |
| [**getHoldingHistory**](HoldingsApi.md#getHoldingHistory) | **GET** /v1/holdings/{id}/history | Holding value history |
| [**getHoldingTransactions**](HoldingsApi.md#getHoldingTransactions) | **GET** /v1/holdings/{id}/transactions | Holding transactions (buys, sells, dividends) |
| [**getPortfolioAllocation**](HoldingsApi.md#getPortfolioAllocation) | **GET** /v1/portfolio/allocation | Portfolio allocation by classification |
| [**getPortfolioAllocationByAccount**](HoldingsApi.md#getPortfolioAllocationByAccount) | **GET** /v1/portfolio/allocation/by-account | Portfolio allocation grouped by account |
| [**getPortfolioAllocationByHoldings**](HoldingsApi.md#getPortfolioAllocationByHoldings) | **GET** /v1/portfolio/allocation/by-holdings | Portfolio allocation grouped by holding |
| [**getPortfolioAllocationHoldingsDetail**](HoldingsApi.md#getPortfolioAllocationHoldingsDetail) | **GET** /v1/portfolio/allocation/holdings-detail | Holdings within one allocation bucket |
| [**getSecurityDetails**](HoldingsApi.md#getSecurityDetails) | **GET** /v1/securities/{id} | Security details |
| [**getSecurityDividends**](HoldingsApi.md#getSecurityDividends) | **GET** /v1/securities/{id}/dividends | Security dividend history |
| [**getSecurityHistoricalPerformance**](HoldingsApi.md#getSecurityHistoricalPerformance) | **GET** /v1/securities/{id}/performance | Historical performance for one security |
| [**searchSecurities**](HoldingsApi.md#searchSecurities) | **GET** /v1/securities/search | Search the security catalog |
| [**updateHolding**](HoldingsApi.md#updateHolding) | **PATCH** /v1/holdings/{id} | Update a holding |


<a id="bulkUpdateHoldings"></a>
# **bulkUpdateHoldings**
> BulkUpdateHoldingsResponse bulkUpdateHoldings(bulkUpdateHoldingsRequest)

Bulk reprice manual holdings

Reprice many manual holdings in one round trip. Each entry carries the holding id plus optional new &#x60;quantity&#x60; and &#x60;costBasis&#x60;. Monarch processes each row independently and returns the success / failure counts plus per-row failure reasons.  Bulk-best-effort: partial success returns 200 with &#x60;failedCount &gt; 0&#x60;. A blanket failure (auth, malformed request) returns the usual error envelope. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = HoldingsApi()
val bulkUpdateHoldingsRequest : BulkUpdateHoldingsRequest =  // BulkUpdateHoldingsRequest | 
try {
    val result : BulkUpdateHoldingsResponse = apiInstance.bulkUpdateHoldings(bulkUpdateHoldingsRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling HoldingsApi#bulkUpdateHoldings")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling HoldingsApi#bulkUpdateHoldings")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **bulkUpdateHoldingsRequest** | [**BulkUpdateHoldingsRequest**](BulkUpdateHoldingsRequest.md)|  | |

### Return type

[**BulkUpdateHoldingsResponse**](BulkUpdateHoldingsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="createManualHolding"></a>
# **createManualHolding**
> CreateManualHoldingResponse createManualHolding(id, createManualHoldingRequest)

Add a manual holding to an account

Tracks a security position inside a brokerage account that Monarch can&#39;t auto-sync (e.g. employer 401k, private fund). &#x60;securityId&#x60; must be a real Monarch security id; use &#x60;GET /v1/securities/search&#x60; to look one up by ticker or name. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = HoldingsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch account id.
val createManualHoldingRequest : CreateManualHoldingRequest =  // CreateManualHoldingRequest | 
try {
    val result : CreateManualHoldingResponse = apiInstance.createManualHolding(id, createManualHoldingRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling HoldingsApi#createManualHolding")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling HoldingsApi#createManualHolding")
    e.printStackTrace()
}
```

### Parameters
| **id** | **kotlin.String**| Monarch account id. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **createManualHoldingRequest** | [**CreateManualHoldingRequest**](CreateManualHoldingRequest.md)|  | |

### Return type

[**CreateManualHoldingResponse**](CreateManualHoldingResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="createManualInvestmentsAccount"></a>
# **createManualInvestmentsAccount**
> CreateManualAccountResponse createManualInvestmentsAccount(createManualInvestmentsAccountRequest)

Create a manual investments account

Creates a brokerage-style account Monarch cannot auto-sync (e.g. employer 401k where Plaid lacks coverage). Two tracking methods:    - &#x60;balances&#x60;: single account-level balance, no per-security detail.   - &#x60;holdings&#x60;: per-security positions (seed via &#x60;initialHoldings&#x60;).  Defaults: &#x60;trackingMethod&#x60; is omitted (Monarch chooses based on whether &#x60;initialHoldings&#x60; is present). Use the dedicated holdings endpoints later to add or update positions. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = HoldingsApi()
val createManualInvestmentsAccountRequest : CreateManualInvestmentsAccountRequest =  // CreateManualInvestmentsAccountRequest | 
try {
    val result : CreateManualAccountResponse = apiInstance.createManualInvestmentsAccount(createManualInvestmentsAccountRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling HoldingsApi#createManualInvestmentsAccount")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling HoldingsApi#createManualInvestmentsAccount")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **createManualInvestmentsAccountRequest** | [**CreateManualInvestmentsAccountRequest**](CreateManualInvestmentsAccountRequest.md)|  | |

### Return type

[**CreateManualAccountResponse**](CreateManualAccountResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="deleteHolding"></a>
# **deleteHolding**
> DeleteAccountResponse deleteHolding(id)

Delete a holding

Removes one security position from its account. **Destructive** - no soft-delete. Use to clean up a stale manual holding or one Monarch double-imported.  On Plaid-synced brokerage accounts the holding may re-appear on next sync if the position still exists at the data provider. For manual investments accounts the delete sticks. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = HoldingsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch holding id.
try {
    val result : DeleteAccountResponse = apiInstance.deleteHolding(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling HoldingsApi#deleteHolding")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling HoldingsApi#deleteHolding")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **kotlin.String**| Monarch holding id. | |

### Return type

[**DeleteAccountResponse**](DeleteAccountResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getHoldingHistory"></a>
# **getHoldingHistory**
> GetHoldingHistoryResponse getHoldingHistory(id, start, end)

Holding value history

Per-day value, quantity, and price series for one holding. Backs the holding drawer chart in the web Investments tab. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = HoldingsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch holding id.
val start : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Lower bound (inclusive), `YYYY-MM-DD`.
val end : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Upper bound (inclusive), `YYYY-MM-DD`.
try {
    val result : GetHoldingHistoryResponse = apiInstance.getHoldingHistory(id, start, end)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling HoldingsApi#getHoldingHistory")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling HoldingsApi#getHoldingHistory")
    e.printStackTrace()
}
```

### Parameters
| **id** | **kotlin.String**| Monarch holding id. | |
| **start** | **java.time.LocalDate**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **end** | **java.time.LocalDate**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |

### Return type

[**GetHoldingHistoryResponse**](GetHoldingHistoryResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getHoldingTransactions"></a>
# **getHoldingTransactions**
> GetHoldingTransactionsResponse getHoldingTransactions(id, start, end, limit, offset)

Holding transactions (buys, sells, dividends)

Discrete cost-basis events for one holding across a window. Different from &#x60;GET /v1/holdings/{id}/history&#x60; which returns the per-day price / value series - this returns the buys, sells, dividends, and transfers that actually moved the position.  &#x60;type&#x60; is one of &#x60;buy&#x60;, &#x60;sell&#x60;, &#x60;dividend&#x60;, &#x60;transfer_in&#x60;, &#x60;transfer_out&#x60;. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = HoldingsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch holding id.
val start : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Lower bound (inclusive), `YYYY-MM-DD`.
val end : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Upper bound (inclusive), `YYYY-MM-DD`.
val limit : kotlin.Int = 56 // kotlin.Int | Page size.
val offset : kotlin.Int = 56 // kotlin.Int | Page offset.
try {
    val result : GetHoldingTransactionsResponse = apiInstance.getHoldingTransactions(id, start, end, limit, offset)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling HoldingsApi#getHoldingTransactions")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling HoldingsApi#getHoldingTransactions")
    e.printStackTrace()
}
```

### Parameters
| **id** | **kotlin.String**| Monarch holding id. | |
| **start** | **java.time.LocalDate**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |
| **end** | **java.time.LocalDate**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |
| **limit** | **kotlin.Int**| Page size. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **offset** | **kotlin.Int**| Page offset. | [optional] |

### Return type

[**GetHoldingTransactionsResponse**](GetHoldingTransactionsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getPortfolioAllocation"></a>
# **getPortfolioAllocation**
> GetPortfolioAllocationResponse getPortfolioAllocation(accountIds, classificationField)

Portfolio allocation by classification

Pie-chart-style allocation breakdown for the portfolio (or a subset filtered via &#x60;accountIds&#x60;). Pass &#x60;classificationField&#x60; to bucket by security type, asset class, or sector. Returns each bucket&#39;s percent + dollar value, plus the total portfolio value. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = HoldingsApi()
val accountIds : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | Filter by one or more Monarch account ids. Repeat the query param for each. Preferred over the legacy single `accountId` param; both are accepted and merged. 
val classificationField : kotlin.String = classificationField_example // kotlin.String | Monarch's `PortfolioAllocationClassificationField` enum value (e.g. `SECURITY_TYPE`). Omit to use Monarch's default classification. 
try {
    val result : GetPortfolioAllocationResponse = apiInstance.getPortfolioAllocation(accountIds, classificationField)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling HoldingsApi#getPortfolioAllocation")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling HoldingsApi#getPortfolioAllocation")
    e.printStackTrace()
}
```

### Parameters
| **accountIds** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| Filter by one or more Monarch account ids. Repeat the query param for each. Preferred over the legacy single &#x60;accountId&#x60; param; both are accepted and merged.  | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **classificationField** | **kotlin.String**| Monarch&#39;s &#x60;PortfolioAllocationClassificationField&#x60; enum value (e.g. &#x60;SECURITY_TYPE&#x60;). Omit to use Monarch&#39;s default classification.  | [optional] |

### Return type

[**GetPortfolioAllocationResponse**](GetPortfolioAllocationResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getPortfolioAllocationByAccount"></a>
# **getPortfolioAllocationByAccount**
> GetPortfolioAllocationByHoldingsResponse getPortfolioAllocationByAccount(accountIds, limit)

Portfolio allocation grouped by account

Allocation breakdown bucketed per investments account (rather than per security). Each row is one account with its percent of portfolio and total dollar value. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = HoldingsApi()
val accountIds : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | Filter by one or more Monarch account ids. Repeat the query param for each. Preferred over the legacy single `accountId` param; both are accepted and merged. 
val limit : kotlin.Int = 56 // kotlin.Int | Page size.
try {
    val result : GetPortfolioAllocationByHoldingsResponse = apiInstance.getPortfolioAllocationByAccount(accountIds, limit)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling HoldingsApi#getPortfolioAllocationByAccount")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling HoldingsApi#getPortfolioAllocationByAccount")
    e.printStackTrace()
}
```

### Parameters
| **accountIds** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| Filter by one or more Monarch account ids. Repeat the query param for each. Preferred over the legacy single &#x60;accountId&#x60; param; both are accepted and merged.  | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **limit** | **kotlin.Int**| Page size. | [optional] |

### Return type

[**GetPortfolioAllocationByHoldingsResponse**](GetPortfolioAllocationByHoldingsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getPortfolioAllocationByHoldings"></a>
# **getPortfolioAllocationByHoldings**
> GetPortfolioAllocationByHoldingsResponse getPortfolioAllocationByHoldings(accountIds, limit)

Portfolio allocation grouped by holding

Allocation breakdown bucketed per holding (ticker / security name), capped at &#x60;limit&#x60; rows. Each row is one security with its percent of portfolio and total dollar value. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = HoldingsApi()
val accountIds : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | Filter by one or more Monarch account ids. Repeat the query param for each. Preferred over the legacy single `accountId` param; both are accepted and merged. 
val limit : kotlin.Int = 56 // kotlin.Int | Page size.
try {
    val result : GetPortfolioAllocationByHoldingsResponse = apiInstance.getPortfolioAllocationByHoldings(accountIds, limit)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling HoldingsApi#getPortfolioAllocationByHoldings")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling HoldingsApi#getPortfolioAllocationByHoldings")
    e.printStackTrace()
}
```

### Parameters
| **accountIds** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| Filter by one or more Monarch account ids. Repeat the query param for each. Preferred over the legacy single &#x60;accountId&#x60; param; both are accepted and merged.  | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **limit** | **kotlin.Int**| Page size. | [optional] |

### Return type

[**GetPortfolioAllocationByHoldingsResponse**](GetPortfolioAllocationByHoldingsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getPortfolioAllocationHoldingsDetail"></a>
# **getPortfolioAllocationHoldingsDetail**
> GetPortfolioAllocationHoldingsDetailResponse getPortfolioAllocationHoldingsDetail(classificationField, classificationValue, accountIds, limit, offset)

Holdings within one allocation bucket

Drill-down: lists the individual holdings inside one classification bucket (e.g. every equity inside the \&quot;Equities\&quot; classification value). Requires &#x60;classificationField&#x60; + &#x60;classificationValue&#x60; plus optional pagination. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = HoldingsApi()
val classificationField : kotlin.String = classificationField_example // kotlin.String | Monarch's `PortfolioAllocationClassificationField` enum value.
val classificationValue : kotlin.String = classificationValue_example // kotlin.String | The specific bucket value within `classificationField` to drill into.
val accountIds : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | Filter by one or more Monarch account ids. Repeat the query param for each. Preferred over the legacy single `accountId` param; both are accepted and merged. 
val limit : kotlin.Int = 56 // kotlin.Int | Page size.
val offset : kotlin.Int = 56 // kotlin.Int | Page offset.
try {
    val result : GetPortfolioAllocationHoldingsDetailResponse = apiInstance.getPortfolioAllocationHoldingsDetail(classificationField, classificationValue, accountIds, limit, offset)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling HoldingsApi#getPortfolioAllocationHoldingsDetail")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling HoldingsApi#getPortfolioAllocationHoldingsDetail")
    e.printStackTrace()
}
```

### Parameters
| **classificationField** | **kotlin.String**| Monarch&#39;s &#x60;PortfolioAllocationClassificationField&#x60; enum value. | |
| **classificationValue** | **kotlin.String**| The specific bucket value within &#x60;classificationField&#x60; to drill into. | |
| **accountIds** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| Filter by one or more Monarch account ids. Repeat the query param for each. Preferred over the legacy single &#x60;accountId&#x60; param; both are accepted and merged.  | [optional] |
| **limit** | **kotlin.Int**| Page size. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **offset** | **kotlin.Int**| Page offset. | [optional] |

### Return type

[**GetPortfolioAllocationHoldingsDetailResponse**](GetPortfolioAllocationHoldingsDetailResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getSecurityDetails"></a>
# **getSecurityDetails**
> GetSecurityDetailsResponse getSecurityDetails(id)

Security details

Full security metadata: ticker, name, type, sector, industry, market cap, P/E ratio, dividend yield, current and closing price. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = HoldingsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch security id.
try {
    val result : GetSecurityDetailsResponse = apiInstance.getSecurityDetails(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling HoldingsApi#getSecurityDetails")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling HoldingsApi#getSecurityDetails")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **kotlin.String**| Monarch security id. | |

### Return type

[**GetSecurityDetailsResponse**](GetSecurityDetailsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getSecurityDividends"></a>
# **getSecurityDividends**
> GetSecurityDividendsResponse getSecurityDividends(id, start, end)

Security dividend history

Dividend payment history for one security. Each entry has the payment date, per-share amount, and dividend type (regular, special, etc.). 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = HoldingsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch security id.
val start : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Lower bound (inclusive), `YYYY-MM-DD`.
val end : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Upper bound (inclusive), `YYYY-MM-DD`.
try {
    val result : GetSecurityDividendsResponse = apiInstance.getSecurityDividends(id, start, end)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling HoldingsApi#getSecurityDividends")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling HoldingsApi#getSecurityDividends")
    e.printStackTrace()
}
```

### Parameters
| **id** | **kotlin.String**| Monarch security id. | |
| **start** | **java.time.LocalDate**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **end** | **java.time.LocalDate**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |

### Return type

[**GetSecurityDividendsResponse**](GetSecurityDividendsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getSecurityHistoricalPerformance"></a>
# **getSecurityHistoricalPerformance**
> GetSecurityHistoricalPerformanceResponse getSecurityHistoricalPerformance(id, start, end)

Historical performance for one security

Per-day price history for one security plus its current and closing price. &#x60;historicalChart&#x60; is a list of &#x60;(date, returnPercent, value)&#x60; points where &#x60;returnPercent&#x60; is the cumulative return from the window start. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = HoldingsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch security id.
val start : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Window start (inclusive).
val end : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Window end (inclusive).
try {
    val result : GetSecurityHistoricalPerformanceResponse = apiInstance.getSecurityHistoricalPerformance(id, start, end)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling HoldingsApi#getSecurityHistoricalPerformance")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling HoldingsApi#getSecurityHistoricalPerformance")
    e.printStackTrace()
}
```

### Parameters
| **id** | **kotlin.String**| Monarch security id. | |
| **start** | **java.time.LocalDate**| Window start (inclusive). | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **end** | **java.time.LocalDate**| Window end (inclusive). | [optional] |

### Return type

[**GetSecurityHistoricalPerformanceResponse**](GetSecurityHistoricalPerformanceResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="searchSecurities"></a>
# **searchSecurities**
> SearchSecuritiesResponse searchSecurities(q, limit, orderByPopularity)

Search the security catalog

Free-text search across Monarch&#39;s security catalog (Plaid-backed plus user-added). Use to resolve a ticker or company name to the &#x60;securityId&#x60; required by the manual holding endpoints (&#x60;POST /v1/account/{id}/holdings&#x60;).  &#x60;q&#x60; is required and matches ticker, name, or partial substring. &#x60;orderByPopularity: true&#x60; ranks by Monarch-wide holding popularity instead of relevance (handy when you know the ticker is common but the search returns less-traded names first). 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = HoldingsApi()
val q : kotlin.String = q_example // kotlin.String | Search text (ticker, name, partial match).
val limit : kotlin.Int = 56 // kotlin.Int | Cap the result count. Monarch defaults to a small page when omitted.
val orderByPopularity : kotlin.Boolean = true // kotlin.Boolean | When true, Monarch ranks by popularity instead of relevance.
try {
    val result : SearchSecuritiesResponse = apiInstance.searchSecurities(q, limit, orderByPopularity)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling HoldingsApi#searchSecurities")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling HoldingsApi#searchSecurities")
    e.printStackTrace()
}
```

### Parameters
| **q** | **kotlin.String**| Search text (ticker, name, partial match). | |
| **limit** | **kotlin.Int**| Cap the result count. Monarch defaults to a small page when omitted. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **orderByPopularity** | **kotlin.Boolean**| When true, Monarch ranks by popularity instead of relevance. | [optional] |

### Return type

[**SearchSecuritiesResponse**](SearchSecuritiesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="updateHolding"></a>
# **updateHolding**
> UpdateHoldingResponse updateHolding(id, updateHoldingRequest)

Update a holding

Partial-update a holding. Fields are independent: pass only what changed. &#x60;userCostBasis&#x60; is stored separately from any data-provider basis, so setting it overrides for display only. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = HoldingsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch holding id.
val updateHoldingRequest : UpdateHoldingRequest =  // UpdateHoldingRequest | 
try {
    val result : UpdateHoldingResponse = apiInstance.updateHolding(id, updateHoldingRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling HoldingsApi#updateHolding")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling HoldingsApi#updateHolding")
    e.printStackTrace()
}
```

### Parameters
| **id** | **kotlin.String**| Monarch holding id. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **updateHoldingRequest** | [**UpdateHoldingRequest**](UpdateHoldingRequest.md)|  | |

### Return type

[**UpdateHoldingResponse**](UpdateHoldingResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

