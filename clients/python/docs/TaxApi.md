# monarch_bridge_client.TaxApi

All URIs are relative to *http://localhost:9084*

Method | HTTP request | Description
------------- | ------------- | -------------
[**get_tax_bracket_estimates**](TaxApi.md#get_tax_bracket_estimates) | **GET** /v1/tax/bracket-estimates | Tax bracket estimates
[**get_tax_categories**](TaxApi.md#get_tax_categories) | **GET** /v1/tax/categories | All categories including &#x60;systemCategory&#x60; (for tax-prep)
[**get_tax_category_aggregates**](TaxApi.md#get_tax_category_aggregates) | **GET** /v1/tax/category-aggregates | Sum + count of transactions by category for a date window
[**get_tax_schedule_category_mappings**](TaxApi.md#get_tax_schedule_category_mappings) | **GET** /v1/tax/schedule-mappings | Tax-schedule line-item to category mappings
[**get_tax_year_overview**](TaxApi.md#get_tax_year_overview) | **GET** /v1/tax/year-overview | Tax year overview


# **get_tax_bracket_estimates**
> GetTaxBracketEstimatesResponse get_tax_bracket_estimates(tax_year, filing_status=filing_status)

Tax bracket estimates

Per-bracket estimated federal tax for a given filing status and
projected AGI. Backs the "what bracket am I in" widget on the web
Tax tab.

`filingStatus` is one of `single`, `married_jointly`,
`married_separately`, `head_of_household`. Omit to use the
household's saved filing status.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_tax_bracket_estimates_response import GetTaxBracketEstimatesResponse
from monarch_bridge_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:9084
# See configuration.py for a list of all supported configuration parameters.
configuration = monarch_bridge_client.Configuration(
    host = "http://localhost:9084"
)


# Enter a context with an instance of the API client
with monarch_bridge_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = monarch_bridge_client.TaxApi(api_client)
    tax_year = 56 # int | Tax year (e.g. 2025).
    filing_status = 'filing_status_example' # str | Federal filing status; omit to use the household default. (optional)

    try:
        # Tax bracket estimates
        api_response = api_instance.get_tax_bracket_estimates(tax_year, filing_status=filing_status)
        print("The response of TaxApi->get_tax_bracket_estimates:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TaxApi->get_tax_bracket_estimates: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tax_year** | **int**| Tax year (e.g. 2025). | 
 **filing_status** | **str**| Federal filing status; omit to use the household default. | [optional] 

### Return type

[**GetTaxBracketEstimatesResponse**](GetTaxBracketEstimatesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Marginal / effective rates + per-bracket breakdown. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_tax_categories**
> GetTaxCategoriesResponse get_tax_categories()

All categories including `systemCategory` (for tax-prep)

Returns every category with its `systemCategory` tag (so callers can
map to tax schedules without re-querying per category).


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_tax_categories_response import GetTaxCategoriesResponse
from monarch_bridge_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:9084
# See configuration.py for a list of all supported configuration parameters.
configuration = monarch_bridge_client.Configuration(
    host = "http://localhost:9084"
)


# Enter a context with an instance of the API client
with monarch_bridge_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = monarch_bridge_client.TaxApi(api_client)

    try:
        # All categories including `systemCategory` (for tax-prep)
        api_response = api_instance.get_tax_categories()
        print("The response of TaxApi->get_tax_categories:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TaxApi->get_tax_categories: %s\n" % e)
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

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | All categories with system-category tags. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_tax_category_aggregates**
> GetTaxCategoryAggregatesResponse get_tax_category_aggregates(start=start, end=end)

Sum + count of transactions by category for a date window

Groups all transactions in `[start, end]` by category and returns
`{sum, count}` per row. Same shape as cashflow-by-category but with
`systemCategory` so callers can map directly to tax schedules.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_tax_category_aggregates_response import GetTaxCategoryAggregatesResponse
from monarch_bridge_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:9084
# See configuration.py for a list of all supported configuration parameters.
configuration = monarch_bridge_client.Configuration(
    host = "http://localhost:9084"
)


# Enter a context with an instance of the API client
with monarch_bridge_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = monarch_bridge_client.TaxApi(api_client)
    start = '2013-10-20' # date | Lower bound (inclusive), `YYYY-MM-DD`. (optional)
    end = '2013-10-20' # date | Upper bound (inclusive), `YYYY-MM-DD`. (optional)

    try:
        # Sum + count of transactions by category for a date window
        api_response = api_instance.get_tax_category_aggregates(start=start, end=end)
        print("The response of TaxApi->get_tax_category_aggregates:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TaxApi->get_tax_category_aggregates: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **date**| Lower bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 
 **end** | **date**| Upper bound (inclusive), &#x60;YYYY-MM-DD&#x60;. | [optional] 

### Return type

[**GetTaxCategoryAggregatesResponse**](GetTaxCategoryAggregatesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Aggregates by category. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_tax_schedule_category_mappings**
> GetTaxScheduleCategoryMappingsResponse get_tax_schedule_category_mappings(schedule, tax_year)

Tax-schedule line-item to category mappings

Returns Monarch's mappings from tax-schedule line items (e.g. Schedule C)
to user categories for a given `taxYear`. Use as the lookup layer when
preparing Schedule C from transaction aggregates.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_tax_schedule_category_mappings_response import GetTaxScheduleCategoryMappingsResponse
from monarch_bridge_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:9084
# See configuration.py for a list of all supported configuration parameters.
configuration = monarch_bridge_client.Configuration(
    host = "http://localhost:9084"
)


# Enter a context with an instance of the API client
with monarch_bridge_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = monarch_bridge_client.TaxApi(api_client)
    schedule = 'schedule_example' # str | Tax schedule, e.g. `SCHEDULE_C`.
    tax_year = 56 # int | Four-digit tax year.

    try:
        # Tax-schedule line-item to category mappings
        api_response = api_instance.get_tax_schedule_category_mappings(schedule, tax_year)
        print("The response of TaxApi->get_tax_schedule_category_mappings:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TaxApi->get_tax_schedule_category_mappings: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **schedule** | **str**| Tax schedule, e.g. &#x60;SCHEDULE_C&#x60;. | 
 **tax_year** | **int**| Four-digit tax year. | 

### Return type

[**GetTaxScheduleCategoryMappingsResponse**](GetTaxScheduleCategoryMappingsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | List of mappings. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_tax_year_overview**
> GetTaxYearOverviewResponse get_tax_year_overview(tax_year)

Tax year overview

Top-level tax overview for one calendar year: total income / deductions
/ estimated tax plus per-schedule (`SCHEDULE_C`, `SCHEDULE_E`, etc.)
summaries. The landing card on the web Tax tab fires this on mount.

Pairs with `GET /v1/tax/category-aggregates` for the per-category
drill-in.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_tax_year_overview_response import GetTaxYearOverviewResponse
from monarch_bridge_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:9084
# See configuration.py for a list of all supported configuration parameters.
configuration = monarch_bridge_client.Configuration(
    host = "http://localhost:9084"
)


# Enter a context with an instance of the API client
with monarch_bridge_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = monarch_bridge_client.TaxApi(api_client)
    tax_year = 56 # int | Tax year (e.g. 2025).

    try:
        # Tax year overview
        api_response = api_instance.get_tax_year_overview(tax_year)
        print("The response of TaxApi->get_tax_year_overview:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TaxApi->get_tax_year_overview: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tax_year** | **int**| Tax year (e.g. 2025). | 

### Return type

[**GetTaxYearOverviewResponse**](GetTaxYearOverviewResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Overview totals + per-schedule summaries. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

