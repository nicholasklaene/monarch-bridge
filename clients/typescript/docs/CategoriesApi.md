# CategoriesApi

All URIs are relative to *http://localhost:9084*

|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|[**bulkDeleteCategories**](#bulkdeletecategories) | **POST** /v1/categories/bulk-delete | Bulk-delete categories|
|[**createCategory**](#createcategory) | **POST** /v1/categories | Create a custom category|
|[**createCategoryGroup**](#createcategorygroup) | **POST** /v1/category-groups | Create a category group|
|[**deleteCategory**](#deletecategory) | **DELETE** /v1/categories/{id} | Delete a category|
|[**deleteCategoryGroup**](#deletecategorygroup) | **DELETE** /v1/category-groups/{id} | Delete a category group|
|[**getCategoryDeletionInfo**](#getcategorydeletioninfo) | **GET** /v1/categories/{id}/deletion-info | Slim category snapshot for the delete-confirm flow|
|[**getCategoryEdit**](#getcategoryedit) | **GET** /v1/categories/{id}/edit | Category with full edit-form fields|
|[**getCategoryGroupDetails**](#getcategorygroupdetails) | **GET** /v1/category-groups/{id}/details | Category group with its child categories|
|[**listCategories**](#listcategories) | **GET** /v1/categories | List all transaction categories|
|[**listCategoryGroups**](#listcategorygroups) | **GET** /v1/category-groups | Parent groups (one tier above individual categories)|
|[**updateCategoryGroup**](#updatecategorygroup) | **PATCH** /v1/category-groups/{id} | Update a category group|
|[**updateCategoryGroupBudgetVariability**](#updatecategorygroupbudgetvariability) | **PATCH** /v1/category-groups/{id}/budget-variability | Set a category group\&#39;s budget-variability (fixed vs flex)|

# **bulkDeleteCategories**
> BulkDeleteCategoriesResponse bulkDeleteCategories(bulkDeleteCategoriesRequest)

Server-side composite over `DELETE /v1/categories/{id}`. Runs the delete for each id in the request. Always returns 200; per-item failures are surfaced in `failed[]` with the upstream exception message as `reason`. Optional `moveToCategoryId` is applied to each per-id delete (transactions assigned to a deleted category are remapped; omit to leave them uncategorized). 

### Example

```typescript
import {
    CategoriesApi,
    Configuration,
    BulkDeleteCategoriesRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new CategoriesApi(configuration);

let bulkDeleteCategoriesRequest: BulkDeleteCategoriesRequest; //

const { status, data } = await apiInstance.bulkDeleteCategories(
    bulkDeleteCategoriesRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **bulkDeleteCategoriesRequest** | **BulkDeleteCategoriesRequest**|  | |


### Return type

**BulkDeleteCategoriesResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Partitioned result of the per-id deletes. |  -  |
|**400** | Validation failed. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **createCategory**
> CreateCategoryResponse createCategory(createCategoryRequest)

Creates a user-defined category under an existing category group.  Required: `name` and `groupId` (from `GET /v1/category-groups`). Optional: `icon` (emoji string), `color` (hex), and `orderBefore` (uuid of an existing category to insert before). The new category is then available to assign on any transaction via `PATCH /v1/transactions/{id}` or to bulk-assign via the bulk transaction endpoints.  System categories are not user-editable - they come from Monarch. 

### Example

```typescript
import {
    CategoriesApi,
    Configuration,
    CreateCategoryRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new CategoriesApi(configuration);

let createCategoryRequest: CreateCategoryRequest; //

const { status, data } = await apiInstance.createCategory(
    createCategoryRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **createCategoryRequest** | **CreateCategoryRequest**|  | |


### Return type

**CreateCategoryResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | New category. |  -  |
|**400** | Validation failed. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **createCategoryGroup**
> CreateCategoryGroupResponse createCategoryGroup(createCategoryGroupRequest)

Adds a new parent group to organize categories under. Required: `name`, `type` (`income` / `expense` / `transfer`).  Optional: `orderBefore` is the UUID of an existing group; the new group is inserted before it. Omit to append at the end. `budgetVariability` defaults to `flexible` if omitted.  Once created, attach child categories via `POST /v1/categories` with the new group\'s id as `groupId`. 

### Example

```typescript
import {
    CategoriesApi,
    Configuration,
    CreateCategoryGroupRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new CategoriesApi(configuration);

let createCategoryGroupRequest: CreateCategoryGroupRequest; //

const { status, data } = await apiInstance.createCategoryGroup(
    createCategoryGroupRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **createCategoryGroupRequest** | **CreateCategoryGroupRequest**|  | |


### Return type

**CreateCategoryGroupResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | New category group. |  -  |
|**400** | Validation failed. |  -  |
|**422** | Monarch PayloadError. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **deleteCategory**
> DeleteAccountResponse deleteCategory()

Removes a custom category. **Destructive** for transaction assignments unless you remap.  Pass `moveToCategoryId` to reassign every transaction (and every auto-categorization rule) that pointed at this category to a different category before deletion. Omit to leave the affected transactions uncategorized.  System categories cannot be deleted (Monarch will reject with 422). For bulk deletes use `POST /v1/categories/bulk-delete`. 

### Example

```typescript
import {
    CategoriesApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new CategoriesApi(configuration);

let id: string; //Monarch category id. (default to undefined)
let moveToCategoryId: string; //Remap any transactions assigned to the deleted category to this one. Omit to leave them uncategorized. (optional) (default to undefined)

const { status, data } = await apiInstance.deleteCategory(
    id,
    moveToCategoryId
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch category id. | defaults to undefined|
| **moveToCategoryId** | [**string**] | Remap any transactions assigned to the deleted category to this one. Omit to leave them uncategorized. | (optional) defaults to undefined|


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

# **deleteCategoryGroup**
> DeleteAccountResponse deleteCategoryGroup()

Removes a category group. **Destructive** for orphaned child categories.  Pass `moveToGroupId` to remap every child category under this group to another group before deletion. Omit and the orphaned categories may need manual cleanup (Monarch will leave them pointing at a no-longer-existing parent).  System groups (the Monarch-built-in ones) cannot be deleted. 

### Example

```typescript
import {
    CategoriesApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new CategoriesApi(configuration);

let id: string; //Category group id. (default to undefined)
let moveToGroupId: string; //Remap this group\'s child categories to this group before deletion. (optional) (default to undefined)

const { status, data } = await apiInstance.deleteCategoryGroup(
    id,
    moveToGroupId
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Category group id. | defaults to undefined|
| **moveToGroupId** | [**string**] | Remap this group\&#39;s child categories to this group before deletion. | (optional) defaults to undefined|


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
|**422** | Monarch PayloadError. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getCategoryDeletionInfo**
> GetCategoryDeletionInfoResponse getCategoryDeletionInfo()

Returns just id, name, icon, and `isSystemCategory`. Use before showing a delete-confirmation dialog. 

### Example

```typescript
import {
    CategoriesApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new CategoriesApi(configuration);

let id: string; //Monarch category id. (default to undefined)

const { status, data } = await apiInstance.getCategoryDeletionInfo(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch category id. | defaults to undefined|


### Return type

**GetCategoryDeletionInfoResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Deletion-info snapshot. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getCategoryEdit**
> GetCategoryEditResponse getCategoryEdit()

Returns the category enriched with edit-form fields: budget variability, rollover period, group metadata, system-category flag. Use as the source of truth before constructing an update payload. 

### Example

```typescript
import {
    CategoriesApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new CategoriesApi(configuration);

let id: string; //Monarch category id. (default to undefined)

const { status, data } = await apiInstance.getCategoryEdit(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch category id. | defaults to undefined|


### Return type

**GetCategoryEditResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Category with edit-form fields. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getCategoryGroupDetails**
> GetCategoryGroupDetailsResponse getCategoryGroupDetails()

Category-group detail including each child category (id, name, icon) and the group-level rollover period config. 

### Example

```typescript
import {
    CategoriesApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new CategoriesApi(configuration);

let id: string; //Monarch category-group id. (default to undefined)
let includeDisabledSystemCategories: boolean; // (optional) (default to undefined)

const { status, data } = await apiInstance.getCategoryGroupDetails(
    id,
    includeDisabledSystemCategories
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch category-group id. | defaults to undefined|
| **includeDisabledSystemCategories** | [**boolean**] |  | (optional) defaults to undefined|


### Return type

**GetCategoryGroupDetailsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Category group with child categories. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listCategories**
> ListCategoriesResponse listCategories()

Returns every category Monarch knows about: built-in system categories (Groceries, Rent, Income, etc.) plus any custom ones the user has created. Each entry carries its name, icon, color, parent group id, `isSystemCategory` flag, and order.  Use to populate a category picker, resolve a `categoryId` to a display name, or enumerate ids before scoping a transaction query with `categoryIds`. For the one-level-up grouping see `GET /v1/category-groups`. 

### Example

```typescript
import {
    CategoriesApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new CategoriesApi(configuration);

const { status, data } = await apiInstance.listCategories();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**ListCategoriesResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | All categories (system + custom). |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listCategoryGroups**
> ListCategoryGroupsResponse listCategoryGroups()

Returns the top-level grouping that categories roll up into: Income, Housing, Food, Transportation, etc. Each group carries its `type` (`income`, `expense`, `transfer`), `budgetVariability` (`fixed`, `flexible`, `non_monthly`), and display order.  Use to build a two-tier category picker, to look up a group id before creating a child category via `POST /v1/categories`, or to aggregate per-group spend in client code (the cashflow endpoint already does this server-side). 

### Example

```typescript
import {
    CategoriesApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new CategoriesApi(configuration);

const { status, data } = await apiInstance.listCategoryGroups();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**ListCategoryGroupsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | All category groups. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updateCategoryGroup**
> CreateCategoryGroupResponse updateCategoryGroup(updateCategoryGroupRequest)

Patches a category group. Only non-null fields are forwarded to Monarch; omit a field to leave it untouched.  Editable: `name`, `type` (`income` / `expense` / `transfer`), `budgetVariability`, `groupLevelBudgetingEnabled`, icon and color metadata. For the narrow \"just set fixed vs flex\" case use the intent-revealing `PATCH /v1/category-groups/{id}/budget-variability` endpoint instead. 

### Example

```typescript
import {
    CategoriesApi,
    Configuration,
    UpdateCategoryGroupRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new CategoriesApi(configuration);

let id: string; //Category group id. (default to undefined)
let updateCategoryGroupRequest: UpdateCategoryGroupRequest; //

const { status, data } = await apiInstance.updateCategoryGroup(
    id,
    updateCategoryGroupRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **updateCategoryGroupRequest** | **UpdateCategoryGroupRequest**|  | |
| **id** | [**string**] | Category group id. | defaults to undefined|


### Return type

**CreateCategoryGroupResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Updated group. |  -  |
|**400** | Validation failed. |  -  |
|**422** | Monarch PayloadError. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updateCategoryGroupBudgetVariability**
> UpdateCategoryGroupBudgetVariabilityResponse updateCategoryGroupBudgetVariability(updateCategoryGroupBudgetVariabilityRequest)

Targeted single-field update for `budgetVariability` on a category group. Values: `fixed` (predictable monthly amount like rent), `flexible` (variable spend like groceries, rolls into the Flex bucket), `non_monthly` (irregular like holiday gifts).  The wider `PATCH /v1/category-groups/{id}` can do the same thing; this endpoint exists as a narrower, intent-revealing call when all you want to change is the variability classification. 

### Example

```typescript
import {
    CategoriesApi,
    Configuration,
    UpdateCategoryGroupBudgetVariabilityRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new CategoriesApi(configuration);

let id: string; //Category group id. (default to undefined)
let updateCategoryGroupBudgetVariabilityRequest: UpdateCategoryGroupBudgetVariabilityRequest; //

const { status, data } = await apiInstance.updateCategoryGroupBudgetVariability(
    id,
    updateCategoryGroupBudgetVariabilityRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **updateCategoryGroupBudgetVariabilityRequest** | **UpdateCategoryGroupBudgetVariabilityRequest**|  | |
| **id** | [**string**] | Category group id. | defaults to undefined|


### Return type

**UpdateCategoryGroupBudgetVariabilityResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Updated group (id + new budgetVariability + updatedAt). |  -  |
|**400** | Validation failed. |  -  |
|**422** | Monarch PayloadError. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

