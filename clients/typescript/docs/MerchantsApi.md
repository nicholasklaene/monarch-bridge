# MerchantsApi

All URIs are relative to *http://localhost:9084*

|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|[**deleteMerchant**](#deletemerchant) | **DELETE** /v1/merchants/{id} | Delete a merchant|
|[**getMerchant**](#getmerchant) | **GET** /v1/merchants/{id} | Get full detail for one merchant|
|[**getMerchantStats**](#getmerchantstats) | **GET** /v1/merchants/{id}/stats | Per-merchant aggregate stats|
|[**getMerchantTransactions**](#getmerchanttransactions) | **GET** /v1/merchants/{id}/transactions | Transactions for one merchant|
|[**searchMerchants**](#searchmerchants) | **GET** /v1/merchants/search | Search merchants by name|
|[**setMerchantLogo**](#setmerchantlogo) | **PATCH** /v1/merchants/{id}/logo | Set a merchant\&#39;s logo|

# **deleteMerchant**
> DeleteMerchantResponse deleteMerchant()

Removes a merchant from the catalog. **Destructive** for any transactions and rules that referenced this merchant unless you remap.  Pass `moveToId` to reassign every transaction and every auto-categorization rule that pointed at this merchant to a different merchant before deletion. Omit to orphan them (the transactions will fall back to displaying the raw `plaidName`).  Use `GET /v1/merchants/{id}` first to check `canBeDeleted` and `transactionCount`. 

### Example

```typescript
import {
    MerchantsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MerchantsApi(configuration);

let id: string; //Monarch merchant id. (default to undefined)
let moveToId: string; //Reassign this merchant\'s transactions and rules to this merchant before deletion. (optional) (default to undefined)

const { status, data } = await apiInstance.deleteMerchant(
    id,
    moveToId
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch merchant id. | defaults to undefined|
| **moveToId** | [**string**] | Reassign this merchant\&#39;s transactions and rules to this merchant before deletion. | (optional) defaults to undefined|


### Return type

**DeleteMerchantResponse**

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

# **getMerchant**
> GetMerchantResponse getMerchant()

Returns the rich single-merchant view: id, name, `logoUrl`, `transactionCount`, `ruleCount`, `canBeDeleted`, `hasActiveRecurringStreams`, plus the merchant\'s recurring stream definition when present.  Wraps Monarch\'s `Common_GetEditMerchant` query, the richest single-merchant read in the bundle. Use before a delete to check `canBeDeleted`, before a rename to read the current name (required by `PATCH /v1/merchants/{id}/recurrence`), or in a detail view. 

### Example

```typescript
import {
    MerchantsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MerchantsApi(configuration);

let id: string; //Monarch merchant id. (default to undefined)

const { status, data } = await apiInstance.getMerchant(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch merchant id. | defaults to undefined|


### Return type

**GetMerchantResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Merchant detail. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getMerchantStats**
> GetMerchantStatsResponse getMerchantStats()

Aggregate stats for one merchant across a window: total spend, transaction count, average ticket, first / last seen, and the count of distinct months with activity. Backs the merchant detail page\'s \"Activity\" card.  Use `GET /v1/merchants/{id}/transactions` for the row-level transactions list. 

### Example

```typescript
import {
    MerchantsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MerchantsApi(configuration);

let id: string; //Monarch merchant id. (default to undefined)
let start: string; //Lower bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)
let end: string; //Upper bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)

const { status, data } = await apiInstance.getMerchantStats(
    id,
    start,
    end
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch merchant id. | defaults to undefined|
| **start** | [**string**] | Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|
| **end** | [**string**] | Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|


### Return type

**GetMerchantStatsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Stats for the merchant. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getMerchantTransactions**
> GetMerchantTransactionsResponse getMerchantTransactions()

Transaction list scoped to a single merchant. Lighter than calling `/v1/transactions?search=<merchant>` when you already have the merchant id. Returns date, amount, merchant, and category per row. 

### Example

```typescript
import {
    MerchantsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MerchantsApi(configuration);

let id: string; //Monarch merchant id. (default to undefined)
let limit: number; //Page size. (optional) (default to undefined)
let offset: number; //Page offset. (optional) (default to undefined)

const { status, data } = await apiInstance.getMerchantTransactions(
    id,
    limit,
    offset
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch merchant id. | defaults to undefined|
| **limit** | [**number**] | Page size. | (optional) defaults to undefined|
| **offset** | [**number**] | Page offset. | (optional) defaults to undefined|


### Return type

**GetMerchantTransactionsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Merchant transaction list. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **searchMerchants**
> SearchMerchantsResponse searchMerchants()

Free-text search across merchant names, ordered by transaction count (most-used first). Use to populate a merchant picker, resolve a merchant id by name, or browse the merchant catalog.  Two backing queries via the `withLogo` flag:  - `withLogo: false` (default): faster, omits `logoUrl`, but   supports the `includeIds` filter (repeat the query param to pin   specific merchants into the result set even if they don\'t match   the search text). - `withLogo: true`: includes `logoUrl` per merchant; supports   `offset` pagination but drops `includeIds`. 

### Example

```typescript
import {
    MerchantsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MerchantsApi(configuration);

let q: string; //Free-text search across merchant names. (optional) (default to undefined)
let limit: number; //Max number of merchants to return. (optional) (default to undefined)
let offset: number; //Page offset. Only respected when `withLogo` is true. (optional) (default to undefined)
let withLogo: boolean; //When true, switch to the logo-enabled variant of the query. (optional) (default to false)
let includeIds: Array<string>; //Pin specific merchant ids into the result set. Repeat the query param for each id. Only respected when `withLogo` is false.  (optional) (default to undefined)

const { status, data } = await apiInstance.searchMerchants(
    q,
    limit,
    offset,
    withLogo,
    includeIds
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **q** | [**string**] | Free-text search across merchant names. | (optional) defaults to undefined|
| **limit** | [**number**] | Max number of merchants to return. | (optional) defaults to undefined|
| **offset** | [**number**] | Page offset. Only respected when &#x60;withLogo&#x60; is true. | (optional) defaults to undefined|
| **withLogo** | [**boolean**] | When true, switch to the logo-enabled variant of the query. | (optional) defaults to false|
| **includeIds** | **Array&lt;string&gt;** | Pin specific merchant ids into the result set. Repeat the query param for each id. Only respected when &#x60;withLogo&#x60; is false.  | (optional) defaults to undefined|


### Return type

**SearchMerchantsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Matching merchants. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **setMerchantLogo**
> GetMerchantResponse setMerchantLogo(setMerchantLogoRequest)

Points the merchant at an existing Cloudinary asset by public id.  **Gotcha**: Monarch\'s `setMerchantLogo` mutation does NOT accept a binary upload. The asset must already exist on Cloudinary (typically uploaded via Monarch\'s web UI). Pass the asset\'s `cloudinaryPublicId`; send `null` or omit to clear the logo.  To upload a fresh logo you\'d need to upload to Cloudinary out-of-band first and then call this endpoint with the resulting public id (Monarch does not expose its Cloudinary signing for this use-case). 

### Example

```typescript
import {
    MerchantsApi,
    Configuration,
    SetMerchantLogoRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new MerchantsApi(configuration);

let id: string; //Monarch merchant id. (default to undefined)
let setMerchantLogoRequest: SetMerchantLogoRequest; //

const { status, data } = await apiInstance.setMerchantLogo(
    id,
    setMerchantLogoRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **setMerchantLogoRequest** | **SetMerchantLogoRequest**|  | |
| **id** | [**string**] | Monarch merchant id. | defaults to undefined|


### Return type

**GetMerchantResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Updated merchant (id, name, logoUrl). |  -  |
|**400** | Validation failed. |  -  |
|**422** | Monarch PayloadError. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

