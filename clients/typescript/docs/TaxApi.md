# TaxApi

All URIs are relative to *http://localhost:9084*

|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|[**getTaxBracketEstimates**](#gettaxbracketestimates) | **GET** /v1/tax/bracket-estimates | Tax bracket estimates|
|[**getTaxCategories**](#gettaxcategories) | **GET** /v1/tax/categories | All categories including &#x60;systemCategory&#x60; (for tax-prep)|
|[**getTaxCategoryAggregates**](#gettaxcategoryaggregates) | **GET** /v1/tax/category-aggregates | Sum + count of transactions by category for a date window|
|[**getTaxScheduleCategoryMappings**](#gettaxschedulecategorymappings) | **GET** /v1/tax/schedule-mappings | Tax-schedule line-item to category mappings|
|[**getTaxYearOverview**](#gettaxyearoverview) | **GET** /v1/tax/year-overview | Tax year overview|

# **getTaxBracketEstimates**
> GetTaxBracketEstimatesResponse getTaxBracketEstimates()

Per-bracket estimated federal tax for a given filing status and projected AGI. Backs the \"what bracket am I in\" widget on the web Tax tab.  `filingStatus` is one of `single`, `married_jointly`, `married_separately`, `head_of_household`. Omit to use the household\'s saved filing status. 

### Example

```typescript
import {
    TaxApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TaxApi(configuration);

let taxYear: number; //Tax year (e.g. 2025). (default to undefined)
let filingStatus: 'single' | 'married_jointly' | 'married_separately' | 'head_of_household'; //Federal filing status; omit to use the household default. (optional) (default to undefined)

const { status, data } = await apiInstance.getTaxBracketEstimates(
    taxYear,
    filingStatus
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **taxYear** | [**number**] | Tax year (e.g. 2025). | defaults to undefined|
| **filingStatus** | [**&#39;single&#39; | &#39;married_jointly&#39; | &#39;married_separately&#39; | &#39;head_of_household&#39;**]**Array<&#39;single&#39; &#124; &#39;married_jointly&#39; &#124; &#39;married_separately&#39; &#124; &#39;head_of_household&#39;>** | Federal filing status; omit to use the household default. | (optional) defaults to undefined|


### Return type

**GetTaxBracketEstimatesResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Marginal / effective rates + per-bracket breakdown. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getTaxCategories**
> GetTaxCategoriesResponse getTaxCategories()

Returns every category with its `systemCategory` tag (so callers can map to tax schedules without re-querying per category). 

### Example

```typescript
import {
    TaxApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TaxApi(configuration);

const { status, data } = await apiInstance.getTaxCategories();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**GetTaxCategoriesResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | All categories with system-category tags. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getTaxCategoryAggregates**
> GetTaxCategoryAggregatesResponse getTaxCategoryAggregates()

Groups all transactions in `[start, end]` by category and returns `{sum, count}` per row. Same shape as cashflow-by-category but with `systemCategory` so callers can map directly to tax schedules. 

### Example

```typescript
import {
    TaxApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TaxApi(configuration);

let start: string; //Lower bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)
let end: string; //Upper bound (inclusive), `YYYY-MM-DD`. (optional) (default to undefined)

const { status, data } = await apiInstance.getTaxCategoryAggregates(
    start,
    end
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **start** | [**string**] | Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|
| **end** | [**string**] | Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | (optional) defaults to undefined|


### Return type

**GetTaxCategoryAggregatesResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Aggregates by category. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getTaxScheduleCategoryMappings**
> GetTaxScheduleCategoryMappingsResponse getTaxScheduleCategoryMappings()

Returns Monarch\'s mappings from tax-schedule line items (e.g. Schedule C) to user categories for a given `taxYear`. Use as the lookup layer when preparing Schedule C from transaction aggregates. 

### Example

```typescript
import {
    TaxApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TaxApi(configuration);

let schedule: string; //Tax schedule, e.g. `SCHEDULE_C`. (default to undefined)
let taxYear: number; //Four-digit tax year. (default to undefined)

const { status, data } = await apiInstance.getTaxScheduleCategoryMappings(
    schedule,
    taxYear
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **schedule** | [**string**] | Tax schedule, e.g. &#x60;SCHEDULE_C&#x60;. | defaults to undefined|
| **taxYear** | [**number**] | Four-digit tax year. | defaults to undefined|


### Return type

**GetTaxScheduleCategoryMappingsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | List of mappings. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getTaxYearOverview**
> GetTaxYearOverviewResponse getTaxYearOverview()

Top-level tax overview for one calendar year: total income / deductions / estimated tax plus per-schedule (`SCHEDULE_C`, `SCHEDULE_E`, etc.) summaries. The landing card on the web Tax tab fires this on mount.  Pairs with `GET /v1/tax/category-aggregates` for the per-category drill-in. 

### Example

```typescript
import {
    TaxApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TaxApi(configuration);

let taxYear: number; //Tax year (e.g. 2025). (default to undefined)

const { status, data } = await apiInstance.getTaxYearOverview(
    taxYear
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **taxYear** | [**number**] | Tax year (e.g. 2025). | defaults to undefined|


### Return type

**GetTaxYearOverviewResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Overview totals + per-schedule summaries. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

