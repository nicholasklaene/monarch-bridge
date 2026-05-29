# TaxLotsApi

All URIs are relative to *http://localhost:9084*

|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|[**createManualTaxLot**](#createmanualtaxlot) | **POST** /v1/holdings/{id}/tax-lots/create | Create one manual tax lot under a holding|
|[**createManualTaxLotsBulk**](#createmanualtaxlotsbulk) | **POST** /v1/accounts/{id}/tax-lots/bulk | Bulk-create tax lots under an account|
|[**deleteTaxLot**](#deletetaxlot) | **DELETE** /v1/tax-lots/{id} | Delete one manual tax lot|
|[**deleteTaxLotsBulk**](#deletetaxlotsbulk) | **POST** /v1/tax-lots/bulk-delete | Bulk-delete tax lots by id|
|[**getTaxLotPerformance**](#gettaxlotperformance) | **GET** /v1/holdings/{id}/tax-lot-performance | Per-holding tax-lot performance chart|
|[**listTaxLots**](#listtaxlots) | **GET** /v1/holdings/{id}/tax-lots | List tax lots under a holding|
|[**updateTaxLot**](#updatetaxlot) | **PATCH** /v1/tax-lots/{id} | Update one manual tax lot|

# **createManualTaxLot**
> CreateManualTaxLotResponse createManualTaxLot(createManualTaxLotRequest)

Adds one manual cost-basis tax lot under the given holding. The Monarch web client surfaces this when the user edits a manual investments holding and clicks \"Add a tax lot\".  The lot is independent of any data-provider basis - manual lots accumulate alongside synced basis, with the user-side total reflected in the holding\'s per-lot performance chart. 

### Example

```typescript
import {
    TaxLotsApi,
    Configuration,
    CreateManualTaxLotRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TaxLotsApi(configuration);

let id: string; //Monarch holding id. (default to undefined)
let createManualTaxLotRequest: CreateManualTaxLotRequest; //

const { status, data } = await apiInstance.createManualTaxLot(
    id,
    createManualTaxLotRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **createManualTaxLotRequest** | **CreateManualTaxLotRequest**|  | |
| **id** | [**string**] | Monarch holding id. | defaults to undefined|


### Return type

**CreateManualTaxLotResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | The created tax lot. |  -  |
|**422** | Monarch PayloadError. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **createManualTaxLotsBulk**
> CreateManualTaxLotsBulkResponse createManualTaxLotsBulk(createManualTaxLotsBulkRequest)

Batch import of manual tax lots scoped to one investments account. Each row carries its own `holdingId`. Per-row errors surface in the `errors` array; successful lots in `taxLots`. Idempotent on identical `(holdingId, acquisitionDate, acquisitionQuantity, costBasisPerUnit)` tuples - Monarch dedupes. 

### Example

```typescript
import {
    TaxLotsApi,
    Configuration,
    CreateManualTaxLotsBulkRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TaxLotsApi(configuration);

let id: string; //Monarch account id (manual investments account). (default to undefined)
let createManualTaxLotsBulkRequest: CreateManualTaxLotsBulkRequest; //

const { status, data } = await apiInstance.createManualTaxLotsBulk(
    id,
    createManualTaxLotsBulkRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **createManualTaxLotsBulkRequest** | **CreateManualTaxLotsBulkRequest**|  | |
| **id** | [**string**] | Monarch account id (manual investments account). | defaults to undefined|


### Return type

**CreateManualTaxLotsBulkResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Created tax lots plus per-row error rows. |  -  |
|**422** | Monarch PayloadError. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **deleteTaxLot**
> DeleteTaxLotResponse deleteTaxLot()

Removes one manual tax lot. **Destructive** - no soft-delete. The holding\'s aggregate cost basis re-totals from the remaining lots. 

### Example

```typescript
import {
    TaxLotsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TaxLotsApi(configuration);

let id: string; //Monarch tax-lot id. (default to undefined)

const { status, data } = await apiInstance.deleteTaxLot(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch tax-lot id. | defaults to undefined|


### Return type

**DeleteTaxLotResponse**

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

# **deleteTaxLotsBulk**
> DeleteTaxLotsBulkResponse deleteTaxLotsBulk(deleteTaxLotsBulkRequest)

One-shot delete of a list of manual tax lots. Returns the deleted count. Use for cleanup after a wrong bulk import. 

### Example

```typescript
import {
    TaxLotsApi,
    Configuration,
    DeleteTaxLotsBulkRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TaxLotsApi(configuration);

let deleteTaxLotsBulkRequest: DeleteTaxLotsBulkRequest; //

const { status, data } = await apiInstance.deleteTaxLotsBulk(
    deleteTaxLotsBulkRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **deleteTaxLotsBulkRequest** | **DeleteTaxLotsBulkRequest**|  | |


### Return type

**DeleteTaxLotsBulkResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Deleted count. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getTaxLotPerformance**
> GetTaxLotPerformanceResponse getTaxLotPerformance()

Per-day cost-basis / unrealized-gain / return-percent series across all tax lots under one holding. Backs the \"Lot performance\" chart on the holding detail page. 

### Example

```typescript
import {
    TaxLotsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TaxLotsApi(configuration);

let id: string; //Monarch holding id. (default to undefined)

const { status, data } = await apiInstance.getTaxLotPerformance(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch holding id. | defaults to undefined|


### Return type

**GetTaxLotPerformanceResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Per-day performance points. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listTaxLots**
> ListTaxLotsResponse listTaxLots()

All manual tax lots attached to one holding. Ordered by `acquisitionDate` ascending. Pairs with the \"Lot performance\" chart - one row per lot. 

### Example

```typescript
import {
    TaxLotsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TaxLotsApi(configuration);

let id: string; //Monarch holding id. (default to undefined)

const { status, data } = await apiInstance.listTaxLots(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch holding id. | defaults to undefined|


### Return type

**ListTaxLotsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | All tax lots for this holding. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updateTaxLot**
> CreateManualTaxLotResponse updateTaxLot(updateTaxLotRequest)

Partial-update one tax lot. Only fields present on the request body are forwarded. Use to fix a fat-finger on cost basis or acquisition date without recreating the lot. 

### Example

```typescript
import {
    TaxLotsApi,
    Configuration,
    UpdateTaxLotRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TaxLotsApi(configuration);

let id: string; //Monarch tax-lot id. (default to undefined)
let updateTaxLotRequest: UpdateTaxLotRequest; //

const { status, data } = await apiInstance.updateTaxLot(
    id,
    updateTaxLotRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **updateTaxLotRequest** | **UpdateTaxLotRequest**|  | |
| **id** | [**string**] | Monarch tax-lot id. | defaults to undefined|


### Return type

**CreateManualTaxLotResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | The updated tax lot. |  -  |
|**422** | Monarch PayloadError. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

