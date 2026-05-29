# TaxLotsApi

All URIs are relative to **

Method | HTTP request | Description
------------- | ------------- | -------------
[**createManualTaxLot**](TaxLotsApi.md#createManualTaxLot) | **POST** /v1/holdings/{id}/tax-lots/create | Create one manual tax lot under a holding
[**createManualTaxLotsBulk**](TaxLotsApi.md#createManualTaxLotsBulk) | **POST** /v1/accounts/{id}/tax-lots/bulk | Bulk-create tax lots under an account
[**deleteTaxLot**](TaxLotsApi.md#deleteTaxLot) | **DELETE** /v1/tax-lots/{id} | Delete one manual tax lot
[**deleteTaxLotsBulk**](TaxLotsApi.md#deleteTaxLotsBulk) | **POST** /v1/tax-lots/bulk-delete | Bulk-delete tax lots by id
[**getTaxLotPerformance**](TaxLotsApi.md#getTaxLotPerformance) | **GET** /v1/holdings/{id}/tax-lot-performance | Per-holding tax-lot performance chart
[**listTaxLots**](TaxLotsApi.md#listTaxLots) | **GET** /v1/holdings/{id}/tax-lots | List tax lots under a holding
[**updateTaxLot**](TaxLotsApi.md#updateTaxLot) | **PATCH** /v1/tax-lots/{id} | Update one manual tax lot



## createManualTaxLot

Create one manual tax lot under a holding

Adds one manual cost-basis tax lot under the given holding. The Monarch
web client surfaces this when the user edits a manual investments
holding and clicks \"Add a tax lot\".

The lot is independent of any data-provider basis - manual lots
accumulate alongside synced basis, with the user-side total reflected
in the holding's per-lot performance chart.

### Example

```bash
monarch-api createManualTaxLot id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch holding id. | [default to null]
 **createManualTaxLotRequest** | [**CreateManualTaxLotRequest**](CreateManualTaxLotRequest.md) |  |

### Return type

[**CreateManualTaxLot200Response**](CreateManualTaxLot200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## createManualTaxLotsBulk

Bulk-create tax lots under an account

Batch import of manual tax lots scoped to one investments account.
Each row carries its own 'holdingId'. Per-row errors surface in the
'errors' array; successful lots in 'taxLots'. Idempotent on identical
'(holdingId, acquisitionDate, acquisitionQuantity, costBasisPerUnit)'
tuples - Monarch dedupes.

### Example

```bash
monarch-api createManualTaxLotsBulk id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch account id (manual investments account). | [default to null]
 **createManualTaxLotsBulkRequest** | [**CreateManualTaxLotsBulkRequest**](CreateManualTaxLotsBulkRequest.md) |  |

### Return type

[**CreateManualTaxLotsBulk200Response**](CreateManualTaxLotsBulk200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## deleteTaxLot

Delete one manual tax lot

Removes one manual tax lot. **Destructive** - no soft-delete. The
holding's aggregate cost basis re-totals from the remaining lots.

### Example

```bash
monarch-api deleteTaxLot id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch tax-lot id. | [default to null]

### Return type

[**DeleteTaxLot200Response**](DeleteTaxLot200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## deleteTaxLotsBulk

Bulk-delete tax lots by id

One-shot delete of a list of manual tax lots. Returns the deleted
count. Use for cleanup after a wrong bulk import.

### Example

```bash
monarch-api deleteTaxLotsBulk
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **deleteTaxLotsBulkRequest** | [**DeleteTaxLotsBulkRequest**](DeleteTaxLotsBulkRequest.md) |  |

### Return type

[**DeleteTaxLotsBulk200Response**](DeleteTaxLotsBulk200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getTaxLotPerformance

Per-holding tax-lot performance chart

Per-day cost-basis / unrealized-gain / return-percent series across
all tax lots under one holding. Backs the \"Lot performance\" chart
on the holding detail page.

### Example

```bash
monarch-api getTaxLotPerformance id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch holding id. | [default to null]

### Return type

[**GetTaxLotPerformance200Response**](GetTaxLotPerformance200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## listTaxLots

List tax lots under a holding

All manual tax lots attached to one holding. Ordered by
'acquisitionDate' ascending. Pairs with the \"Lot performance\" chart -
one row per lot.

### Example

```bash
monarch-api listTaxLots id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch holding id. | [default to null]

### Return type

[**ListTaxLots200Response**](ListTaxLots200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## updateTaxLot

Update one manual tax lot

Partial-update one tax lot. Only fields present on the request body are
forwarded. Use to fix a fat-finger on cost basis or acquisition date
without recreating the lot.

### Example

```bash
monarch-api updateTaxLot id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch tax-lot id. | [default to null]
 **updateTaxLotRequest** | [**UpdateTaxLotRequest**](UpdateTaxLotRequest.md) |  |

### Return type

[**CreateManualTaxLot200Response**](CreateManualTaxLot200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

