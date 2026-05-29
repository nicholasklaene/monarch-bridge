# TaxApi

All URIs are relative to **

Method | HTTP request | Description
------------- | ------------- | -------------
[**getTaxBracketEstimates**](TaxApi.md#getTaxBracketEstimates) | **GET** /v1/tax/bracket-estimates | Tax bracket estimates
[**getTaxCategories**](TaxApi.md#getTaxCategories) | **GET** /v1/tax/categories | All categories including &#39;systemCategory&#39; (for tax-prep)
[**getTaxCategoryAggregates**](TaxApi.md#getTaxCategoryAggregates) | **GET** /v1/tax/category-aggregates | Sum + count of transactions by category for a date window
[**getTaxScheduleCategoryMappings**](TaxApi.md#getTaxScheduleCategoryMappings) | **GET** /v1/tax/schedule-mappings | Tax-schedule line-item to category mappings
[**getTaxYearOverview**](TaxApi.md#getTaxYearOverview) | **GET** /v1/tax/year-overview | Tax year overview



## getTaxBracketEstimates

Tax bracket estimates

Per-bracket estimated federal tax for a given filing status and
projected AGI. Backs the \"what bracket am I in\" widget on the web
Tax tab.

'filingStatus' is one of 'single', 'married_jointly',
'married_separately', 'head_of_household'. Omit to use the
household's saved filing status.

### Example

```bash
monarch-api getTaxBracketEstimates  taxYear=value  filingStatus=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **taxYear** | **integer** | Tax year (e.g. 2025). | [default to null]
 **filingStatus** | **string** | Federal filing status; omit to use the household default. | [optional] [default to null]

### Return type

[**GetTaxBracketEstimates200Response**](GetTaxBracketEstimates200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getTaxCategories

All categories including 'systemCategory' (for tax-prep)

Returns every category with its 'systemCategory' tag (so callers can
map to tax schedules without re-querying per category).

### Example

```bash
monarch-api getTaxCategories
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**GetTaxCategories200Response**](GetTaxCategories200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getTaxCategoryAggregates

Sum + count of transactions by category for a date window

Groups all transactions in '[start, end]' by category and returns
'{sum, count}' per row. Same shape as cashflow-by-category but with
'systemCategory' so callers can map directly to tax schedules.

### Example

```bash
monarch-api getTaxCategoryAggregates  start=value  end=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **string** | Lower bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]
 **end** | **string** | Upper bound (inclusive), 'YYYY-MM-DD'. | [optional] [default to null]

### Return type

[**GetTaxCategoryAggregates200Response**](GetTaxCategoryAggregates200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getTaxScheduleCategoryMappings

Tax-schedule line-item to category mappings

Returns Monarch's mappings from tax-schedule line items (e.g. Schedule C)
to user categories for a given 'taxYear'. Use as the lookup layer when
preparing Schedule C from transaction aggregates.

### Example

```bash
monarch-api getTaxScheduleCategoryMappings  schedule=value  taxYear=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **schedule** | **string** | Tax schedule, e.g. 'SCHEDULE_C'. | [default to null]
 **taxYear** | **integer** | Four-digit tax year. | [default to null]

### Return type

[**GetTaxScheduleCategoryMappings200Response**](GetTaxScheduleCategoryMappings200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getTaxYearOverview

Tax year overview

Top-level tax overview for one calendar year: total income / deductions
/ estimated tax plus per-schedule ('SCHEDULE_C', 'SCHEDULE_E', etc.)
summaries. The landing card on the web Tax tab fires this on mount.

Pairs with 'GET /v1/tax/category-aggregates' for the per-category
drill-in.

### Example

```bash
monarch-api getTaxYearOverview  taxYear=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **taxYear** | **integer** | Tax year (e.g. 2025). | [default to null]

### Return type

[**GetTaxYearOverview200Response**](GetTaxYearOverview200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

