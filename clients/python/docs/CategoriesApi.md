# monarch_bridge_client.CategoriesApi

All URIs are relative to *http://localhost:9084*

Method | HTTP request | Description
------------- | ------------- | -------------
[**bulk_delete_categories**](CategoriesApi.md#bulk_delete_categories) | **POST** /v1/categories/bulk-delete | Bulk-delete categories
[**create_category**](CategoriesApi.md#create_category) | **POST** /v1/categories | Create a custom category
[**create_category_group**](CategoriesApi.md#create_category_group) | **POST** /v1/category-groups | Create a category group
[**delete_category**](CategoriesApi.md#delete_category) | **DELETE** /v1/categories/{id} | Delete a category
[**delete_category_group**](CategoriesApi.md#delete_category_group) | **DELETE** /v1/category-groups/{id} | Delete a category group
[**get_category_deletion_info**](CategoriesApi.md#get_category_deletion_info) | **GET** /v1/categories/{id}/deletion-info | Slim category snapshot for the delete-confirm flow
[**get_category_edit**](CategoriesApi.md#get_category_edit) | **GET** /v1/categories/{id}/edit | Category with full edit-form fields
[**get_category_group_details**](CategoriesApi.md#get_category_group_details) | **GET** /v1/category-groups/{id}/details | Category group with its child categories
[**list_categories**](CategoriesApi.md#list_categories) | **GET** /v1/categories | List all transaction categories
[**list_category_groups**](CategoriesApi.md#list_category_groups) | **GET** /v1/category-groups | Parent groups (one tier above individual categories)
[**update_category_group**](CategoriesApi.md#update_category_group) | **PATCH** /v1/category-groups/{id} | Update a category group
[**update_category_group_budget_variability**](CategoriesApi.md#update_category_group_budget_variability) | **PATCH** /v1/category-groups/{id}/budget-variability | Set a category group&#39;s budget-variability (fixed vs flex)


# **bulk_delete_categories**
> BulkDeleteCategoriesResponse bulk_delete_categories(bulk_delete_categories_request)

Bulk-delete categories

Server-side composite over `DELETE /v1/categories/{id}`. Runs the delete for each
id in the request. Always returns 200; per-item failures are surfaced in `failed[]`
with the upstream exception message as `reason`. Optional `moveToCategoryId` is
applied to each per-id delete (transactions assigned to a deleted category are
remapped; omit to leave them uncategorized).


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.bulk_delete_categories_response import BulkDeleteCategoriesResponse
from monarch_bridge_client.models.bulk_delete_categories_request import BulkDeleteCategoriesRequest
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
    api_instance = monarch_bridge_client.CategoriesApi(api_client)
    bulk_delete_categories_request = monarch_bridge_client.BulkDeleteCategoriesRequest() # BulkDeleteCategoriesRequest | 

    try:
        # Bulk-delete categories
        api_response = api_instance.bulk_delete_categories(bulk_delete_categories_request)
        print("The response of CategoriesApi->bulk_delete_categories:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling CategoriesApi->bulk_delete_categories: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **bulk_delete_categories_request** | [**BulkDeleteCategoriesRequest**](BulkDeleteCategoriesRequest.md)|  | 

### Return type

[**BulkDeleteCategoriesResponse**](BulkDeleteCategoriesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Partitioned result of the per-id deletes. |  -  |
**400** | Validation failed. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **create_category**
> CreateCategoryResponse create_category(create_category_request)

Create a custom category

Creates a user-defined category under an existing category group.

Required: `name` and `groupId` (from `GET /v1/category-groups`).
Optional: `icon` (emoji string), `color` (hex), and `orderBefore`
(uuid of an existing category to insert before). The new category
is then available to assign on any transaction via
`PATCH /v1/transactions/{id}` or to bulk-assign via the bulk
transaction endpoints.

System categories are not user-editable - they come from Monarch.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.create_category_response import CreateCategoryResponse
from monarch_bridge_client.models.create_category_request import CreateCategoryRequest
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
    api_instance = monarch_bridge_client.CategoriesApi(api_client)
    create_category_request = monarch_bridge_client.CreateCategoryRequest() # CreateCategoryRequest | 

    try:
        # Create a custom category
        api_response = api_instance.create_category(create_category_request)
        print("The response of CategoriesApi->create_category:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling CategoriesApi->create_category: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **create_category_request** | [**CreateCategoryRequest**](CreateCategoryRequest.md)|  | 

### Return type

[**CreateCategoryResponse**](CreateCategoryResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | New category. |  -  |
**400** | Validation failed. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **create_category_group**
> CreateCategoryGroupResponse create_category_group(create_category_group_request)

Create a category group

Adds a new parent group to organize categories under. Required:
`name`, `type` (`income` / `expense` / `transfer`).

Optional: `orderBefore` is the UUID of an existing group; the new
group is inserted before it. Omit to append at the end.
`budgetVariability` defaults to `flexible` if omitted.

Once created, attach child categories via `POST /v1/categories`
with the new group's id as `groupId`.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.create_category_group_response import CreateCategoryGroupResponse
from monarch_bridge_client.models.create_category_group_request import CreateCategoryGroupRequest
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
    api_instance = monarch_bridge_client.CategoriesApi(api_client)
    create_category_group_request = monarch_bridge_client.CreateCategoryGroupRequest() # CreateCategoryGroupRequest | 

    try:
        # Create a category group
        api_response = api_instance.create_category_group(create_category_group_request)
        print("The response of CategoriesApi->create_category_group:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling CategoriesApi->create_category_group: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **create_category_group_request** | [**CreateCategoryGroupRequest**](CreateCategoryGroupRequest.md)|  | 

### Return type

[**CreateCategoryGroupResponse**](CreateCategoryGroupResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | New category group. |  -  |
**400** | Validation failed. |  -  |
**422** | Monarch PayloadError. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_category**
> DeleteAccountResponse delete_category(id, move_to_category_id=move_to_category_id)

Delete a category

Removes a custom category. **Destructive** for transaction
assignments unless you remap.

Pass `moveToCategoryId` to reassign every transaction (and every
auto-categorization rule) that pointed at this category to a
different category before deletion. Omit to leave the affected
transactions uncategorized.

System categories cannot be deleted (Monarch will reject with 422).
For bulk deletes use `POST /v1/categories/bulk-delete`.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.delete_account_response import DeleteAccountResponse
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
    api_instance = monarch_bridge_client.CategoriesApi(api_client)
    id = 'id_example' # str | Monarch category id.
    move_to_category_id = 'move_to_category_id_example' # str | Remap any transactions assigned to the deleted category to this one. Omit to leave them uncategorized. (optional)

    try:
        # Delete a category
        api_response = api_instance.delete_category(id, move_to_category_id=move_to_category_id)
        print("The response of CategoriesApi->delete_category:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling CategoriesApi->delete_category: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch category id. | 
 **move_to_category_id** | **str**| Remap any transactions assigned to the deleted category to this one. Omit to leave them uncategorized. | [optional] 

### Return type

[**DeleteAccountResponse**](DeleteAccountResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Confirmation. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_category_group**
> DeleteAccountResponse delete_category_group(id, move_to_group_id=move_to_group_id)

Delete a category group

Removes a category group. **Destructive** for orphaned child
categories.

Pass `moveToGroupId` to remap every child category under this
group to another group before deletion. Omit and the orphaned
categories may need manual cleanup (Monarch will leave them
pointing at a no-longer-existing parent).

System groups (the Monarch-built-in ones) cannot be deleted.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.delete_account_response import DeleteAccountResponse
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
    api_instance = monarch_bridge_client.CategoriesApi(api_client)
    id = 'id_example' # str | Category group id.
    move_to_group_id = 'move_to_group_id_example' # str | Remap this group's child categories to this group before deletion. (optional)

    try:
        # Delete a category group
        api_response = api_instance.delete_category_group(id, move_to_group_id=move_to_group_id)
        print("The response of CategoriesApi->delete_category_group:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling CategoriesApi->delete_category_group: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Category group id. | 
 **move_to_group_id** | **str**| Remap this group&#39;s child categories to this group before deletion. | [optional] 

### Return type

[**DeleteAccountResponse**](DeleteAccountResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Confirmation. |  -  |
**422** | Monarch PayloadError. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_category_deletion_info**
> GetCategoryDeletionInfoResponse get_category_deletion_info(id)

Slim category snapshot for the delete-confirm flow

Returns just id, name, icon, and `isSystemCategory`. Use before
showing a delete-confirmation dialog.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_category_deletion_info_response import GetCategoryDeletionInfoResponse
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
    api_instance = monarch_bridge_client.CategoriesApi(api_client)
    id = 'id_example' # str | Monarch category id.

    try:
        # Slim category snapshot for the delete-confirm flow
        api_response = api_instance.get_category_deletion_info(id)
        print("The response of CategoriesApi->get_category_deletion_info:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling CategoriesApi->get_category_deletion_info: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch category id. | 

### Return type

[**GetCategoryDeletionInfoResponse**](GetCategoryDeletionInfoResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Deletion-info snapshot. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_category_edit**
> GetCategoryEditResponse get_category_edit(id)

Category with full edit-form fields

Returns the category enriched with edit-form fields: budget
variability, rollover period, group metadata, system-category flag.
Use as the source of truth before constructing an update payload.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_category_edit_response import GetCategoryEditResponse
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
    api_instance = monarch_bridge_client.CategoriesApi(api_client)
    id = 'id_example' # str | Monarch category id.

    try:
        # Category with full edit-form fields
        api_response = api_instance.get_category_edit(id)
        print("The response of CategoriesApi->get_category_edit:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling CategoriesApi->get_category_edit: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch category id. | 

### Return type

[**GetCategoryEditResponse**](GetCategoryEditResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Category with edit-form fields. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_category_group_details**
> GetCategoryGroupDetailsResponse get_category_group_details(id, include_disabled_system_categories=include_disabled_system_categories)

Category group with its child categories

Category-group detail including each child category (id, name, icon)
and the group-level rollover period config.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.get_category_group_details_response import GetCategoryGroupDetailsResponse
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
    api_instance = monarch_bridge_client.CategoriesApi(api_client)
    id = 'id_example' # str | Monarch category-group id.
    include_disabled_system_categories = True # bool |  (optional)

    try:
        # Category group with its child categories
        api_response = api_instance.get_category_group_details(id, include_disabled_system_categories=include_disabled_system_categories)
        print("The response of CategoriesApi->get_category_group_details:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling CategoriesApi->get_category_group_details: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch category-group id. | 
 **include_disabled_system_categories** | **bool**|  | [optional] 

### Return type

[**GetCategoryGroupDetailsResponse**](GetCategoryGroupDetailsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Category group with child categories. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_categories**
> ListCategoriesResponse list_categories()

List all transaction categories

Returns every category Monarch knows about: built-in system
categories (Groceries, Rent, Income, etc.) plus any custom ones the
user has created. Each entry carries its name, icon, color, parent
group id, `isSystemCategory` flag, and order.

Use to populate a category picker, resolve a `categoryId` to a
display name, or enumerate ids before scoping a transaction query
with `categoryIds`. For the one-level-up grouping see
`GET /v1/category-groups`.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.list_categories_response import ListCategoriesResponse
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
    api_instance = monarch_bridge_client.CategoriesApi(api_client)

    try:
        # List all transaction categories
        api_response = api_instance.list_categories()
        print("The response of CategoriesApi->list_categories:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling CategoriesApi->list_categories: %s\n" % e)
```



### Parameters

This endpoint does not need any parameter.

### Return type

[**ListCategoriesResponse**](ListCategoriesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | All categories (system + custom). |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_category_groups**
> ListCategoryGroupsResponse list_category_groups()

Parent groups (one tier above individual categories)

Returns the top-level grouping that categories roll up into:
Income, Housing, Food, Transportation, etc. Each group carries its
`type` (`income`, `expense`, `transfer`), `budgetVariability`
(`fixed`, `flexible`, `non_monthly`), and display order.

Use to build a two-tier category picker, to look up a group id
before creating a child category via `POST /v1/categories`, or to
aggregate per-group spend in client code (the cashflow endpoint
already does this server-side).


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.list_category_groups_response import ListCategoryGroupsResponse
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
    api_instance = monarch_bridge_client.CategoriesApi(api_client)

    try:
        # Parent groups (one tier above individual categories)
        api_response = api_instance.list_category_groups()
        print("The response of CategoriesApi->list_category_groups:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling CategoriesApi->list_category_groups: %s\n" % e)
```



### Parameters

This endpoint does not need any parameter.

### Return type

[**ListCategoryGroupsResponse**](ListCategoryGroupsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | All category groups. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_category_group**
> CreateCategoryGroupResponse update_category_group(id, update_category_group_request)

Update a category group

Patches a category group. Only non-null fields are forwarded to
Monarch; omit a field to leave it untouched.

Editable: `name`, `type` (`income` / `expense` / `transfer`),
`budgetVariability`, `groupLevelBudgetingEnabled`, icon and color
metadata. For the narrow "just set fixed vs flex" case use the
intent-revealing `PATCH /v1/category-groups/{id}/budget-variability`
endpoint instead.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.create_category_group_response import CreateCategoryGroupResponse
from monarch_bridge_client.models.update_category_group_request import UpdateCategoryGroupRequest
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
    api_instance = monarch_bridge_client.CategoriesApi(api_client)
    id = 'id_example' # str | Category group id.
    update_category_group_request = monarch_bridge_client.UpdateCategoryGroupRequest() # UpdateCategoryGroupRequest | 

    try:
        # Update a category group
        api_response = api_instance.update_category_group(id, update_category_group_request)
        print("The response of CategoriesApi->update_category_group:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling CategoriesApi->update_category_group: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Category group id. | 
 **update_category_group_request** | [**UpdateCategoryGroupRequest**](UpdateCategoryGroupRequest.md)|  | 

### Return type

[**CreateCategoryGroupResponse**](CreateCategoryGroupResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Updated group. |  -  |
**400** | Validation failed. |  -  |
**422** | Monarch PayloadError. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_category_group_budget_variability**
> UpdateCategoryGroupBudgetVariabilityResponse update_category_group_budget_variability(id, update_category_group_budget_variability_request)

Set a category group's budget-variability (fixed vs flex)

Targeted single-field update for `budgetVariability` on a category
group. Values: `fixed` (predictable monthly amount like rent),
`flexible` (variable spend like groceries, rolls into the Flex
bucket), `non_monthly` (irregular like holiday gifts).

The wider `PATCH /v1/category-groups/{id}` can do the same thing;
this endpoint exists as a narrower, intent-revealing call when all
you want to change is the variability classification.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.update_category_group_budget_variability_response import UpdateCategoryGroupBudgetVariabilityResponse
from monarch_bridge_client.models.update_category_group_budget_variability_request import UpdateCategoryGroupBudgetVariabilityRequest
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
    api_instance = monarch_bridge_client.CategoriesApi(api_client)
    id = 'id_example' # str | Category group id.
    update_category_group_budget_variability_request = monarch_bridge_client.UpdateCategoryGroupBudgetVariabilityRequest() # UpdateCategoryGroupBudgetVariabilityRequest | 

    try:
        # Set a category group's budget-variability (fixed vs flex)
        api_response = api_instance.update_category_group_budget_variability(id, update_category_group_budget_variability_request)
        print("The response of CategoriesApi->update_category_group_budget_variability:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling CategoriesApi->update_category_group_budget_variability: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Category group id. | 
 **update_category_group_budget_variability_request** | [**UpdateCategoryGroupBudgetVariabilityRequest**](UpdateCategoryGroupBudgetVariabilityRequest.md)|  | 

### Return type

[**UpdateCategoryGroupBudgetVariabilityResponse**](UpdateCategoryGroupBudgetVariabilityResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Updated group (id + new budgetVariability + updatedAt). |  -  |
**400** | Validation failed. |  -  |
**422** | Monarch PayloadError. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

