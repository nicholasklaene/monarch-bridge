# TaxApi

All URIs are relative to *http://localhost:9084*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**getTaxBracketEstimates**](TaxApi.md#getTaxBracketEstimates) | **GET** /v1/tax/bracket-estimates | Tax bracket estimates |
| [**getTaxCategories**](TaxApi.md#getTaxCategories) | **GET** /v1/tax/categories | All categories including &#x60;systemCategory&#x60; (for tax-prep) |
| [**getTaxCategoryAggregates**](TaxApi.md#getTaxCategoryAggregates) | **GET** /v1/tax/category-aggregates | Sum + count of transactions by category for a date window |
| [**getTaxScheduleCategoryMappings**](TaxApi.md#getTaxScheduleCategoryMappings) | **GET** /v1/tax/schedule-mappings | Tax-schedule line-item to category mappings |
| [**getTaxYearOverview**](TaxApi.md#getTaxYearOverview) | **GET** /v1/tax/year-overview | Tax year overview |


<a id="getTaxBracketEstimates"></a>
# **getTaxBracketEstimates**
> GetTaxBracketEstimatesResponse getTaxBracketEstimates(taxYear, filingStatus)

Tax bracket estimates

Per-bracket estimated federal tax for a given filing status and projected AGI. Backs the \&quot;what bracket am I in\&quot; widget on the web Tax tab.  &#x60;filingStatus&#x60; is one of &#x60;single&#x60;, &#x60;married_jointly&#x60;, &#x60;married_separately&#x60;, &#x60;head_of_household&#x60;. Omit to use the household&#39;s saved filing status. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TaxApi()
val taxYear : kotlin.Int = 56 // kotlin.Int | Tax year (e.g. 2025).
val filingStatus : kotlin.String = filingStatus_example // kotlin.String | Federal filing status; omit to use the household default.
try {
    val result : GetTaxBracketEstimatesResponse = apiInstance.getTaxBracketEstimates(taxYear, filingStatus)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TaxApi#getTaxBracketEstimates")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TaxApi#getTaxBracketEstimates")
    e.printStackTrace()
}
```

### Parameters
| **taxYear** | **kotlin.Int**| Tax year (e.g. 2025). | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **filingStatus** | **kotlin.String**| Federal filing status; omit to use the household default. | [optional] [enum: single, married_jointly, married_separately, head_of_household] |

### Return type

[**GetTaxBracketEstimatesResponse**](GetTaxBracketEstimatesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getTaxCategories"></a>
# **getTaxCategories**
> GetTaxCategoriesResponse getTaxCategories()

All categories including &#x60;systemCategory&#x60; (for tax-prep)

Returns every category with its &#x60;systemCategory&#x60; tag (so callers can map to tax schedules without re-querying per category). 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TaxApi()
try {
    val result : GetTaxCategoriesResponse = apiInstance.getTaxCategories()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TaxApi#getTaxCategories")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TaxApi#getTaxCategories")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**GetTaxCategoriesResponse**](GetTaxCategoriesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getTaxCategoryAggregates"></a>
# **getTaxCategoryAggregates**
> GetTaxCategoryAggregatesResponse getTaxCategoryAggregates(start, end)

Sum + count of transactions by category for a date window

Groups all transactions in &#x60;[start, end]&#x60; by category and returns &#x60;{sum, count}&#x60; per row. Same shape as cashflow-by-category but with &#x60;systemCategory&#x60; so callers can map directly to tax schedules. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TaxApi()
val start : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Lower bound (inclusive), `YYYY-MM-DD`.
val end : java.time.LocalDate = 2013-10-20 // java.time.LocalDate | Upper bound (inclusive), `YYYY-MM-DD`.
try {
    val result : GetTaxCategoryAggregatesResponse = apiInstance.getTaxCategoryAggregates(start, end)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TaxApi#getTaxCategoryAggregates")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TaxApi#getTaxCategoryAggregates")
    e.printStackTrace()
}
```

### Parameters
| **start** | **java.time.LocalDate**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **end** | **java.time.LocalDate**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] |

### Return type

[**GetTaxCategoryAggregatesResponse**](GetTaxCategoryAggregatesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getTaxScheduleCategoryMappings"></a>
# **getTaxScheduleCategoryMappings**
> GetTaxScheduleCategoryMappingsResponse getTaxScheduleCategoryMappings(schedule, taxYear)

Tax-schedule line-item to category mappings

Returns Monarch&#39;s mappings from tax-schedule line items (e.g. Schedule C) to user categories for a given &#x60;taxYear&#x60;. Use as the lookup layer when preparing Schedule C from transaction aggregates. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TaxApi()
val schedule : kotlin.String = schedule_example // kotlin.String | Tax schedule, e.g. `SCHEDULE_C`.
val taxYear : kotlin.Int = 56 // kotlin.Int | Four-digit tax year.
try {
    val result : GetTaxScheduleCategoryMappingsResponse = apiInstance.getTaxScheduleCategoryMappings(schedule, taxYear)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TaxApi#getTaxScheduleCategoryMappings")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TaxApi#getTaxScheduleCategoryMappings")
    e.printStackTrace()
}
```

### Parameters
| **schedule** | **kotlin.String**| Tax schedule, e.g. &#x60;SCHEDULE_C&#x60;. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **taxYear** | **kotlin.Int**| Four-digit tax year. | |

### Return type

[**GetTaxScheduleCategoryMappingsResponse**](GetTaxScheduleCategoryMappingsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getTaxYearOverview"></a>
# **getTaxYearOverview**
> GetTaxYearOverviewResponse getTaxYearOverview(taxYear)

Tax year overview

Top-level tax overview for one calendar year: total income / deductions / estimated tax plus per-schedule (&#x60;SCHEDULE_C&#x60;, &#x60;SCHEDULE_E&#x60;, etc.) summaries. The landing card on the web Tax tab fires this on mount.  Pairs with &#x60;GET /v1/tax/category-aggregates&#x60; for the per-category drill-in. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TaxApi()
val taxYear : kotlin.Int = 56 // kotlin.Int | Tax year (e.g. 2025).
try {
    val result : GetTaxYearOverviewResponse = apiInstance.getTaxYearOverview(taxYear)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TaxApi#getTaxYearOverview")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TaxApi#getTaxYearOverview")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **taxYear** | **kotlin.Int**| Tax year (e.g. 2025). | |

### Return type

[**GetTaxYearOverviewResponse**](GetTaxYearOverviewResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

