# CategoriesApi

All URIs are relative to **

Method | HTTP request | Description
------------- | ------------- | -------------
[**bulkDeleteCategories**](CategoriesApi.md#bulkDeleteCategories) | **POST** /v1/categories/bulk-delete | Bulk-delete categories
[**createCategory**](CategoriesApi.md#createCategory) | **POST** /v1/categories | Create a custom category
[**createCategoryGroup**](CategoriesApi.md#createCategoryGroup) | **POST** /v1/category-groups | Create a category group
[**deleteCategory**](CategoriesApi.md#deleteCategory) | **DELETE** /v1/categories/{id} | Delete a category
[**deleteCategoryGroup**](CategoriesApi.md#deleteCategoryGroup) | **DELETE** /v1/category-groups/{id} | Delete a category group
[**getCategoryDeletionInfo**](CategoriesApi.md#getCategoryDeletionInfo) | **GET** /v1/categories/{id}/deletion-info | Slim category snapshot for the delete-confirm flow
[**getCategoryEdit**](CategoriesApi.md#getCategoryEdit) | **GET** /v1/categories/{id}/edit | Category with full edit-form fields
[**getCategoryGroupDetails**](CategoriesApi.md#getCategoryGroupDetails) | **GET** /v1/category-groups/{id}/details | Category group with its child categories
[**listCategories**](CategoriesApi.md#listCategories) | **GET** /v1/categories | List all transaction categories
[**listCategoryGroups**](CategoriesApi.md#listCategoryGroups) | **GET** /v1/category-groups | Parent groups (one tier above individual categories)
[**updateCategoryGroup**](CategoriesApi.md#updateCategoryGroup) | **PATCH** /v1/category-groups/{id} | Update a category group
[**updateCategoryGroupBudgetVariability**](CategoriesApi.md#updateCategoryGroupBudgetVariability) | **PATCH** /v1/category-groups/{id}/budget-variability | Set a category group&#39;s budget-variability (fixed vs flex)



## bulkDeleteCategories

Bulk-delete categories

Server-side composite over 'DELETE /v1/categories/{id}'. Runs the delete for each
id in the request. Always returns 200; per-item failures are surfaced in 'failed[]'
with the upstream exception message as 'reason'. Optional 'moveToCategoryId' is
applied to each per-id delete (transactions assigned to a deleted category are
remapped; omit to leave them uncategorized).

### Example

```bash
monarch-api bulkDeleteCategories
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **bulkDeleteCategoriesRequest** | [**BulkDeleteCategoriesRequest**](BulkDeleteCategoriesRequest.md) |  |

### Return type

[**BulkDeleteCategories200Response**](BulkDeleteCategories200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## createCategory

Create a custom category

Creates a user-defined category under an existing category group.

Required: 'name' and 'groupId' (from 'GET /v1/category-groups').
Optional: 'icon' (emoji string), 'color' (hex), and 'orderBefore'
(uuid of an existing category to insert before). The new category
is then available to assign on any transaction via
'PATCH /v1/transactions/{id}' or to bulk-assign via the bulk
transaction endpoints.

System categories are not user-editable - they come from Monarch.

### Example

```bash
monarch-api createCategory
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createCategoryRequest** | [**CreateCategoryRequest**](CreateCategoryRequest.md) |  |

### Return type

[**CreateCategory200Response**](CreateCategory200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## createCategoryGroup

Create a category group

Adds a new parent group to organize categories under. Required:
'name', 'type' ('income' / 'expense' / 'transfer').

Optional: 'orderBefore' is the UUID of an existing group; the new
group is inserted before it. Omit to append at the end.
'budgetVariability' defaults to 'flexible' if omitted.

Once created, attach child categories via 'POST /v1/categories'
with the new group's id as 'groupId'.

### Example

```bash
monarch-api createCategoryGroup
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createCategoryGroupRequest** | [**CreateCategoryGroupRequest**](CreateCategoryGroupRequest.md) |  |

### Return type

[**CreateCategoryGroup200Response**](CreateCategoryGroup200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## deleteCategory

Delete a category

Removes a custom category. **Destructive** for transaction
assignments unless you remap.

Pass 'moveToCategoryId' to reassign every transaction (and every
auto-categorization rule) that pointed at this category to a
different category before deletion. Omit to leave the affected
transactions uncategorized.

System categories cannot be deleted (Monarch will reject with 422).
For bulk deletes use 'POST /v1/categories/bulk-delete'.

### Example

```bash
monarch-api deleteCategory id=value  moveToCategoryId=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch category id. | [default to null]
 **moveToCategoryId** | **string** | Remap any transactions assigned to the deleted category to this one. Omit to leave them uncategorized. | [optional] [default to null]

### Return type

[**DeleteAccount200Response**](DeleteAccount200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## deleteCategoryGroup

Delete a category group

Removes a category group. **Destructive** for orphaned child
categories.

Pass 'moveToGroupId' to remap every child category under this
group to another group before deletion. Omit and the orphaned
categories may need manual cleanup (Monarch will leave them
pointing at a no-longer-existing parent).

System groups (the Monarch-built-in ones) cannot be deleted.

### Example

```bash
monarch-api deleteCategoryGroup id=value  moveToGroupId=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Category group id. | [default to null]
 **moveToGroupId** | **string** | Remap this group's child categories to this group before deletion. | [optional] [default to null]

### Return type

[**DeleteAccount200Response**](DeleteAccount200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getCategoryDeletionInfo

Slim category snapshot for the delete-confirm flow

Returns just id, name, icon, and 'isSystemCategory'. Use before
showing a delete-confirmation dialog.

### Example

```bash
monarch-api getCategoryDeletionInfo id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch category id. | [default to null]

### Return type

[**GetCategoryDeletionInfo200Response**](GetCategoryDeletionInfo200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getCategoryEdit

Category with full edit-form fields

Returns the category enriched with edit-form fields: budget
variability, rollover period, group metadata, system-category flag.
Use as the source of truth before constructing an update payload.

### Example

```bash
monarch-api getCategoryEdit id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch category id. | [default to null]

### Return type

[**GetCategoryEdit200Response**](GetCategoryEdit200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## getCategoryGroupDetails

Category group with its child categories

Category-group detail including each child category (id, name, icon)
and the group-level rollover period config.

### Example

```bash
monarch-api getCategoryGroupDetails id=value  includeDisabledSystemCategories=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch category-group id. | [default to null]
 **includeDisabledSystemCategories** | **boolean** |  | [optional] [default to null]

### Return type

[**GetCategoryGroupDetails200Response**](GetCategoryGroupDetails200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## listCategories

List all transaction categories

Returns every category Monarch knows about: built-in system
categories (Groceries, Rent, Income, etc.) plus any custom ones the
user has created. Each entry carries its name, icon, color, parent
group id, 'isSystemCategory' flag, and order.

Use to populate a category picker, resolve a 'categoryId' to a
display name, or enumerate ids before scoping a transaction query
with 'categoryIds'. For the one-level-up grouping see
'GET /v1/category-groups'.

### Example

```bash
monarch-api listCategories
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**ListCategories200Response**](ListCategories200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## listCategoryGroups

Parent groups (one tier above individual categories)

Returns the top-level grouping that categories roll up into:
Income, Housing, Food, Transportation, etc. Each group carries its
'type' ('income', 'expense', 'transfer'), 'budgetVariability'
('fixed', 'flexible', 'non_monthly'), and display order.

Use to build a two-tier category picker, to look up a group id
before creating a child category via 'POST /v1/categories', or to
aggregate per-group spend in client code (the cashflow endpoint
already does this server-side).

### Example

```bash
monarch-api listCategoryGroups
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**ListCategoryGroups200Response**](ListCategoryGroups200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## updateCategoryGroup

Update a category group

Patches a category group. Only non-null fields are forwarded to
Monarch; omit a field to leave it untouched.

Editable: 'name', 'type' ('income' / 'expense' / 'transfer'),
'budgetVariability', 'groupLevelBudgetingEnabled', icon and color
metadata. For the narrow \"just set fixed vs flex\" case use the
intent-revealing 'PATCH /v1/category-groups/{id}/budget-variability'
endpoint instead.

### Example

```bash
monarch-api updateCategoryGroup id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Category group id. | [default to null]
 **updateCategoryGroupRequest** | [**UpdateCategoryGroupRequest**](UpdateCategoryGroupRequest.md) |  |

### Return type

[**CreateCategoryGroup200Response**](CreateCategoryGroup200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## updateCategoryGroupBudgetVariability

Set a category group's budget-variability (fixed vs flex)

Targeted single-field update for 'budgetVariability' on a category
group. Values: 'fixed' (predictable monthly amount like rent),
'flexible' (variable spend like groceries, rolls into the Flex
bucket), 'non_monthly' (irregular like holiday gifts).

The wider 'PATCH /v1/category-groups/{id}' can do the same thing;
this endpoint exists as a narrower, intent-revealing call when all
you want to change is the variability classification.

### Example

```bash
monarch-api updateCategoryGroupBudgetVariability id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Category group id. | [default to null]
 **updateCategoryGroupBudgetVariabilityRequest** | [**UpdateCategoryGroupBudgetVariabilityRequest**](UpdateCategoryGroupBudgetVariabilityRequest.md) |  |

### Return type

[**UpdateCategoryGroupBudgetVariability200Response**](UpdateCategoryGroupBudgetVariability200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

