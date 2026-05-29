# PaychecksApi

All URIs are relative to *http://localhost:9084*

|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|[**createPaycheck**](#createpaycheck) | **POST** /v1/paychecks | Record a new paycheck|
|[**createPaycheckEmployer**](#createpaycheckemployer) | **POST** /v1/paycheck-employers | Register a new employer|
|[**deletePaycheck**](#deletepaycheck) | **DELETE** /v1/paychecks/{id} | Delete a paycheck|
|[**deletePaycheckEmployer**](#deletepaycheckemployer) | **DELETE** /v1/paycheck-employers/{id} | Delete an employer|
|[**getPaycheck**](#getpaycheck) | **GET** /v1/paychecks/{id} | Single-paycheck full detail|
|[**getPaychecksSummary**](#getpaycheckssummary) | **GET** /v1/paychecks/summary | Aggregate paycheck stats over a window|
|[**listPaycheckEmployers**](#listpaycheckemployers) | **GET** /v1/paycheck-employers | List paycheck employers|
|[**listPaychecks**](#listpaychecks) | **GET** /v1/paychecks | List paychecks (with optional date + owner + employer filter)|
|[**updatePaycheck**](#updatepaycheck) | **PATCH** /v1/paychecks/{id} | Partial-update a paycheck|
|[**updatePaycheckEmployer**](#updatepaycheckemployer) | **PATCH** /v1/paycheck-employers/{id} | Rename an employer|

# **createPaycheck**
> CreatePaycheckResponse createPaycheck(createPaycheckRequest)

Creates a paycheck record from scratch. Required: `employerId`, `ownerId`, `payDate`, `gross`, `net`. Optional: `deductions[]` (per-line: taxes, retirement, insurance, etc.) and `deposits[]` (per-account splits of the net amount).  `employerId` must already exist; register it via `POST /v1/paycheck-employers` first. Deductions and deposits can be omitted on create and filled in later via `PATCH /v1/paychecks/{id}`. 

### Example

```typescript
import {
    PaychecksApi,
    Configuration,
    CreatePaycheckRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new PaychecksApi(configuration);

let createPaycheckRequest: CreatePaycheckRequest; //

const { status, data } = await apiInstance.createPaycheck(
    createPaycheckRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **createPaycheckRequest** | **CreatePaycheckRequest**|  | |


### Return type

**CreatePaycheckResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | New paycheck. |  -  |
|**400** | Validation failed. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **createPaycheckEmployer**
> CreatePaycheckEmployerResponse createPaycheckEmployer(createPaycheckEmployerRequest)

Adds an employer to the registry so it can be attached to paycheck records. Required: `name`. The returned id is the `employerId` to pass when creating a paycheck via `POST /v1/paychecks`.  Use once per employer per household member - subsequent paychecks reference the same id. 

### Example

```typescript
import {
    PaychecksApi,
    Configuration,
    CreatePaycheckEmployerRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new PaychecksApi(configuration);

let createPaycheckEmployerRequest: CreatePaycheckEmployerRequest; //

const { status, data } = await apiInstance.createPaycheckEmployer(
    createPaycheckEmployerRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **createPaycheckEmployerRequest** | **CreatePaycheckEmployerRequest**|  | |


### Return type

**CreatePaycheckEmployerResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | New employer. |  -  |
|**400** | Validation failed. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **deletePaycheck**
> DeleteAccountResponse deletePaycheck()

Removes one paycheck and its deductions/deposits. **Destructive** - drops the row, future summary calls will no longer count it.  The underlying transaction (the actual paycheck deposit on the bank side) is not deleted by this call - only the Monarch paycheck record that links the gross + deductions + deposit structure. 

### Example

```typescript
import {
    PaychecksApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new PaychecksApi(configuration);

let id: string; //Monarch paycheck id. (default to undefined)

const { status, data } = await apiInstance.deletePaycheck(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch paycheck id. | defaults to undefined|


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

# **deletePaycheckEmployer**
> DeleteAccountResponse deletePaycheckEmployer()

Removes an employer from the registry. **Refuses with 422** if any paycheck records are still attributed to this employer - reassign or delete those first.  Use to clean up stale employer entries (e.g. after switching jobs and deleting the old paychecks). For renames use `PATCH /v1/paycheck-employers/{id}` instead. 

### Example

```typescript
import {
    PaychecksApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new PaychecksApi(configuration);

let id: string; //Monarch paycheck-employer id. (default to undefined)

const { status, data } = await apiInstance.deletePaycheckEmployer(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch paycheck-employer id. | defaults to undefined|


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

# **getPaycheck**
> CreatePaycheckResponse getPaycheck()

Returns the full breakdown for one paycheck: pay date, gross, net, employer, owner (household member), per-line `deductions` (taxes, retirement, insurance, etc.) and per-account `deposits`.  Use when surfacing a paycheck in a detail view or before a PATCH to inspect current state. For the list view use `GET /v1/paychecks`; for window-level rollups use `GET /v1/paychecks/summary`. 

### Example

```typescript
import {
    PaychecksApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new PaychecksApi(configuration);

let id: string; //Monarch paycheck id. (default to undefined)

const { status, data } = await apiInstance.getPaycheck(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch paycheck id. | defaults to undefined|


### Return type

**CreatePaycheckResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Full paycheck record with deductions and deposits. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getPaychecksSummary**
> GetPaychecksSummaryResponse getPaychecksSummary()

Returns one rollup row over the filtered paycheck set: `count`, `totalGross`, `totalDeductions`, `totalNet`, `deductionRate` (deductions divided by gross), plus a breakdown by deduction type (federal tax, state tax, 401k, health insurance, etc.).  Window is `start` to `end` inclusive on `payDate`. Defaults to all-time when both omitted. Optional `employerId` scopes to one employer; optional `ownerIds[]` scopes to one or more household members.  Use for YTD income/deduction dashboards or to answer \"how much have I contributed to 401k this year\". For per-paycheck detail use `GET /v1/paychecks`. 

### Example

```typescript
import {
    PaychecksApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new PaychecksApi(configuration);

let start: string; //Lower bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)
let end: string; //Upper bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)
let ownerIds: Array<string>; //Restrict to one or more household-member ids. (optional) (default to undefined)
let employerId: string; //Filter to one employer id. (optional) (default to undefined)

const { status, data } = await apiInstance.getPaychecksSummary(
    start,
    end,
    ownerIds,
    employerId
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **start** | [**string**] | Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|
| **end** | [**string**] | Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|
| **ownerIds** | **Array&lt;string&gt;** | Restrict to one or more household-member ids. | (optional) defaults to undefined|
| **employerId** | [**string**] | Filter to one employer id. | (optional) defaults to undefined|


### Return type

**GetPaychecksSummaryResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Aggregate stats over the window. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listPaycheckEmployers**
> ListPaycheckEmployersResponse listPaycheckEmployers()

Returns the named-employer registry. Each entry is a reusable employer id that paycheck records reference via `employerId`.  Optional free-text `search` matches by name (case-insensitive). `limit` / `offset` paginate. Use to populate an employer picker or to resolve a name before creating a paycheck via `POST /v1/paychecks`.  To add a new employer use `POST /v1/paycheck-employers`; to rename use `PATCH /v1/paycheck-employers/{id}`. 

### Example

```typescript
import {
    PaychecksApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new PaychecksApi(configuration);

let search: string; //Free-text search against merchant / notes / category. (optional) (default to undefined)
let limit: number; //Page size. (optional) (default to undefined)
let offset: number; //Page offset. (optional) (default to undefined)

const { status, data } = await apiInstance.listPaycheckEmployers(
    search,
    limit,
    offset
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **search** | [**string**] | Free-text search against merchant / notes / category. | (optional) defaults to undefined|
| **limit** | [**number**] | Page size. | (optional) defaults to undefined|
| **offset** | [**number**] | Page offset. | (optional) defaults to undefined|


### Return type

**ListPaycheckEmployersResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | All matching employers. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listPaychecks**
> ListPaychecksResponse listPaychecks()

Returns paycheck records (Monarch\'s structured paycheck model, not raw transactions). Each entry has `payDate`, gross, net, employer, owner (household member), plus the deductions and deposits arrays.  Filter on `payDate` via `start` / `end`; omit both for full history. Use `ownerId` to scope to one household member, `employerId` to scope to one employer.  For window-level rollups use `GET /v1/paychecks/summary`. For full detail on one paycheck use `GET /v1/paychecks/{id}`. 

### Example

```typescript
import {
    PaychecksApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new PaychecksApi(configuration);

let start: string; //Lower bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)
let end: string; //Upper bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)
let ownerId: string; //Filter to one household-member id. (optional) (default to undefined)
let employerId: string; //Filter to one employer id. (optional) (default to undefined)

const { status, data } = await apiInstance.listPaychecks(
    start,
    end,
    ownerId,
    employerId
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **start** | [**string**] | Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|
| **end** | [**string**] | Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|
| **ownerId** | [**string**] | Filter to one household-member id. | (optional) defaults to undefined|
| **employerId** | [**string**] | Filter to one employer id. | (optional) defaults to undefined|


### Return type

**ListPaychecksResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | All paychecks matching the filter. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updatePaycheck**
> CreatePaycheckResponse updatePaycheck(updatePaycheckRequest)

Patches one paycheck. Only fields present in the body are forwarded to Monarch; omit a field to leave it untouched.  **Gotcha**: the `deductions` and `deposits` arrays are NOT delta updates. When either array is present in the body it WHOLESALE REPLACES the existing list (Monarch\'s `UpdatePaycheckInput` semantics). To add a single deduction, fetch the current list via `GET /v1/paychecks/{id}` first then send the merged list back.  Common edits: rename via `description`, change `payDate` if logged on the wrong day, or fill in deductions/deposits after creating with a bare gross+net. 

### Example

```typescript
import {
    PaychecksApi,
    Configuration,
    UpdatePaycheckRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new PaychecksApi(configuration);

let id: string; //Monarch paycheck id. (default to undefined)
let updatePaycheckRequest: UpdatePaycheckRequest; //

const { status, data } = await apiInstance.updatePaycheck(
    id,
    updatePaycheckRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **updatePaycheckRequest** | **UpdatePaycheckRequest**|  | |
| **id** | [**string**] | Monarch paycheck id. | defaults to undefined|


### Return type

**CreatePaycheckResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Updated paycheck. |  -  |
|**400** | Validation failed. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updatePaycheckEmployer**
> CreatePaycheckEmployerResponse updatePaycheckEmployer(updatePaycheckEmployerRequest)

Updates the display name on a registered employer. The new name propagates to every paycheck record attributed to this employer (since paychecks reference employer by id, not by name).  Required: `name` in the request body. Use when a company rebrands or when normalizing names imported from payroll data. 

### Example

```typescript
import {
    PaychecksApi,
    Configuration,
    UpdatePaycheckEmployerRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new PaychecksApi(configuration);

let id: string; //Monarch paycheck-employer id. (default to undefined)
let updatePaycheckEmployerRequest: UpdatePaycheckEmployerRequest; //

const { status, data } = await apiInstance.updatePaycheckEmployer(
    id,
    updatePaycheckEmployerRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **updatePaycheckEmployerRequest** | **UpdatePaycheckEmployerRequest**|  | |
| **id** | [**string**] | Monarch paycheck-employer id. | defaults to undefined|


### Return type

**CreatePaycheckEmployerResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Updated employer. |  -  |
|**400** | Validation failed. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

