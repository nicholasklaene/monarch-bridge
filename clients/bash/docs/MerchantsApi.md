# MerchantsApi

All URIs are relative to **

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteMerchant**](MerchantsApi.md#deleteMerchant) | **DELETE** /v1/merchants/{id} | Delete a merchant
[**getMerchant**](MerchantsApi.md#getMerchant) | **GET** /v1/merchants/{id} | Get full detail for one merchant
[**getMerchantStats**](MerchantsApi.md#getMerchantStats) | **GET** /v1/merchants/{id}/stats | Per-merchant aggregate stats
[**getMerchantTransactions**](MerchantsApi.md#getMerchantTransactions) | **GET** /v1/merchants/{id}/transactions | Transactions for one merchant
[**searchMerchants**](MerchantsApi.md#searchMerchants) | **GET** /v1/merchants/search | Search merchants by name
[**setMerchantLogo**](MerchantsApi.md#setMerchantLogo) | **PATCH** /v1/merchants/{id}/logo | Set a merchant&#39;s logo



## deleteMerchant

Delete a merchant

Removes a merchant from the catalog. **Destructive** for any
transactions and rules that referenced this merchant unless you
remap.

Pass 'moveToId' to reassign every transaction and every
auto-categorization rule that pointed at this merchant to a
different merchant before deletion. Omit to orphan them (the
transactions will fall back to displaying the raw 'plaidName').

Use 'GET /v1/merchants/{id}' first to check 'canBeDeleted' and
'transactionCount'.

### Example

```bash
monarch-api deleteMerchant id=value  moveToId=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch merchant id. | [default to null]
 **moveToId** | **string** | Reassign this merchant's transactions and rules to this merchant before deletion. | [optional] [default to null]

### Return type

[**DeleteMerchant200Response**](DeleteMerchant200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getMerchant

Get full detail for one merchant

Returns the rich single-merchant view: id, name, 'logoUrl',
'transactionCount', 'ruleCount', 'canBeDeleted',
'hasActiveRecurringStreams', plus the merchant's recurring stream
definition when present.

Wraps Monarch's 'Common_GetEditMerchant' query, the richest
single-merchant read in the bundle. Use before a delete to check
'canBeDeleted', before a rename to read the current name (required
by 'PATCH /v1/merchants/{id}/recurrence'), or in a detail view.

### Example

```bash
monarch-api getMerchant id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch merchant id. | [default to null]

### Return type

[**GetMerchant200Response**](GetMerchant200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getMerchantStats

Per-merchant aggregate stats

Aggregate stats for one merchant across a window: total spend,
transaction count, average ticket, first / last seen, and the count
of distinct months with activity. Backs the merchant detail page's
\"Activity\" card.

Use 'GET /v1/merchants/{id}/transactions' for the row-level
transactions list.

### Example

```bash
monarch-api getMerchantStats id=value  start=value  end=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch merchant id. | [default to null]
 **start** | **string** | Lower bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]
 **end** | **string** | Upper bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]

### Return type

[**GetMerchantStats200Response**](GetMerchantStats200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getMerchantTransactions

Transactions for one merchant

Transaction list scoped to a single merchant. Lighter than calling
'/v1/transactions?search=<merchant>' when you already have the
merchant id. Returns date, amount, merchant, and category per row.

### Example

```bash
monarch-api getMerchantTransactions id=value  limit=value  offset=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch merchant id. | [default to null]
 **limit** | **integer** | Page size. | [optional] [default to null]
 **offset** | **integer** | Page offset. | [optional] [default to null]

### Return type

[**GetMerchantTransactions200Response**](GetMerchantTransactions200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## searchMerchants

Search merchants by name

Free-text search across merchant names, ordered by transaction
count (most-used first). Use to populate a merchant picker, resolve
a merchant id by name, or browse the merchant catalog.

Two backing queries via the 'withLogo' flag:

- 'withLogo: false' (default): faster, omits 'logoUrl', but
  supports the 'includeIds' filter (repeat the query param to pin
  specific merchants into the result set even if they don't match
  the search text).
- 'withLogo: true': includes 'logoUrl' per merchant; supports
  'offset' pagination but drops 'includeIds'.

### Example

```bash
monarch-api searchMerchants  q=value  limit=value  offset=value  withLogo=value  Specify as:  includeIds=value1 includeIds=value2 includeIds=...
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **q** | **string** | Free-text search across merchant names. | [optional] [default to null]
 **limit** | **integer** | Max number of merchants to return. | [optional] [default to null]
 **offset** | **integer** | Page offset. Only respected when 'withLogo' is true. | [optional] [default to null]
 **withLogo** | **boolean** | When true, switch to the logo-enabled variant of the query. | [optional] [default to false]
 **includeIds** | [**array[string]**](string.md) | Pin specific merchant ids into the result set. Repeat the query param for each id.
Only respected when 'withLogo' is false. | [optional] [default to null]

### Return type

[**SearchMerchants200Response**](SearchMerchants200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## setMerchantLogo

Set a merchant's logo

Points the merchant at an existing Cloudinary asset by public id.

**Gotcha**: Monarch's 'setMerchantLogo' mutation does NOT accept a
binary upload. The asset must already exist on Cloudinary
(typically uploaded via Monarch's web UI). Pass the asset's
'cloudinaryPublicId'; send 'null' or omit to clear the logo.

To upload a fresh logo you'd need to upload to Cloudinary
out-of-band first and then call this endpoint with the resulting
public id (Monarch does not expose its Cloudinary signing for this
use-case).

### Example

```bash
monarch-api setMerchantLogo id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch merchant id. | [default to null]
 **setMerchantLogoRequest** | [**SetMerchantLogoRequest**](SetMerchantLogoRequest.md) |  |

### Return type

[**GetMerchant200Response**](GetMerchant200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

