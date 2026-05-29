# CategoriesApi

All URIs are relative to *http://localhost:9084*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**bulkDeleteCategories**](CategoriesApi.md#bulkDeleteCategories) | **POST** /v1/categories/bulk-delete | Bulk-delete categories |
| [**createCategory**](CategoriesApi.md#createCategory) | **POST** /v1/categories | Create a custom category |
| [**createCategoryGroup**](CategoriesApi.md#createCategoryGroup) | **POST** /v1/category-groups | Create a category group |
| [**deleteCategory**](CategoriesApi.md#deleteCategory) | **DELETE** /v1/categories/{id} | Delete a category |
| [**deleteCategoryGroup**](CategoriesApi.md#deleteCategoryGroup) | **DELETE** /v1/category-groups/{id} | Delete a category group |
| [**getCategoryDeletionInfo**](CategoriesApi.md#getCategoryDeletionInfo) | **GET** /v1/categories/{id}/deletion-info | Slim category snapshot for the delete-confirm flow |
| [**getCategoryEdit**](CategoriesApi.md#getCategoryEdit) | **GET** /v1/categories/{id}/edit | Category with full edit-form fields |
| [**getCategoryGroupDetails**](CategoriesApi.md#getCategoryGroupDetails) | **GET** /v1/category-groups/{id}/details | Category group with its child categories |
| [**listCategories**](CategoriesApi.md#listCategories) | **GET** /v1/categories | List all transaction categories |
| [**listCategoryGroups**](CategoriesApi.md#listCategoryGroups) | **GET** /v1/category-groups | Parent groups (one tier above individual categories) |
| [**updateCategoryGroup**](CategoriesApi.md#updateCategoryGroup) | **PATCH** /v1/category-groups/{id} | Update a category group |
| [**updateCategoryGroupBudgetVariability**](CategoriesApi.md#updateCategoryGroupBudgetVariability) | **PATCH** /v1/category-groups/{id}/budget-variability | Set a category group&#39;s budget-variability (fixed vs flex) |


<a id="bulkDeleteCategories"></a>
# **bulkDeleteCategories**
> BulkDeleteCategoriesResponse bulkDeleteCategories(bulkDeleteCategoriesRequest)

Bulk-delete categories

Server-side composite over &#x60;DELETE /v1/categories/{id}&#x60;. Runs the delete for each id in the request. Always returns 200; per-item failures are surfaced in &#x60;failed[]&#x60; with the upstream exception message as &#x60;reason&#x60;. Optional &#x60;moveToCategoryId&#x60; is applied to each per-id delete (transactions assigned to a deleted category are remapped; omit to leave them uncategorized). 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = CategoriesApi()
val bulkDeleteCategoriesRequest : BulkDeleteCategoriesRequest =  // BulkDeleteCategoriesRequest | 
try {
    val result : BulkDeleteCategoriesResponse = apiInstance.bulkDeleteCategories(bulkDeleteCategoriesRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CategoriesApi#bulkDeleteCategories")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CategoriesApi#bulkDeleteCategories")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **bulkDeleteCategoriesRequest** | [**BulkDeleteCategoriesRequest**](BulkDeleteCategoriesRequest.md)|  | |

### Return type

[**BulkDeleteCategoriesResponse**](BulkDeleteCategoriesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="createCategory"></a>
# **createCategory**
> CreateCategoryResponse createCategory(createCategoryRequest)

Create a custom category

Creates a user-defined category under an existing category group.  Required: &#x60;name&#x60; and &#x60;groupId&#x60; (from &#x60;GET /v1/category-groups&#x60;). Optional: &#x60;icon&#x60; (emoji string), &#x60;color&#x60; (hex), and &#x60;orderBefore&#x60; (uuid of an existing category to insert before). The new category is then available to assign on any transaction via &#x60;PATCH /v1/transactions/{id}&#x60; or to bulk-assign via the bulk transaction endpoints.  System categories are not user-editable - they come from Monarch. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = CategoriesApi()
val createCategoryRequest : CreateCategoryRequest =  // CreateCategoryRequest | 
try {
    val result : CreateCategoryResponse = apiInstance.createCategory(createCategoryRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CategoriesApi#createCategory")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CategoriesApi#createCategory")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **createCategoryRequest** | [**CreateCategoryRequest**](CreateCategoryRequest.md)|  | |

### Return type

[**CreateCategoryResponse**](CreateCategoryResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="createCategoryGroup"></a>
# **createCategoryGroup**
> CreateCategoryGroupResponse createCategoryGroup(createCategoryGroupRequest)

Create a category group

Adds a new parent group to organize categories under. Required: &#x60;name&#x60;, &#x60;type&#x60; (&#x60;income&#x60; / &#x60;expense&#x60; / &#x60;transfer&#x60;).  Optional: &#x60;orderBefore&#x60; is the UUID of an existing group; the new group is inserted before it. Omit to append at the end. &#x60;budgetVariability&#x60; defaults to &#x60;flexible&#x60; if omitted.  Once created, attach child categories via &#x60;POST /v1/categories&#x60; with the new group&#39;s id as &#x60;groupId&#x60;. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = CategoriesApi()
val createCategoryGroupRequest : CreateCategoryGroupRequest =  // CreateCategoryGroupRequest | 
try {
    val result : CreateCategoryGroupResponse = apiInstance.createCategoryGroup(createCategoryGroupRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CategoriesApi#createCategoryGroup")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CategoriesApi#createCategoryGroup")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **createCategoryGroupRequest** | [**CreateCategoryGroupRequest**](CreateCategoryGroupRequest.md)|  | |

### Return type

[**CreateCategoryGroupResponse**](CreateCategoryGroupResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="deleteCategory"></a>
# **deleteCategory**
> DeleteAccountResponse deleteCategory(id, moveToCategoryId)

Delete a category

Removes a custom category. **Destructive** for transaction assignments unless you remap.  Pass &#x60;moveToCategoryId&#x60; to reassign every transaction (and every auto-categorization rule) that pointed at this category to a different category before deletion. Omit to leave the affected transactions uncategorized.  System categories cannot be deleted (Monarch will reject with 422). For bulk deletes use &#x60;POST /v1/categories/bulk-delete&#x60;. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = CategoriesApi()
val id : kotlin.String = id_example // kotlin.String | Monarch category id.
val moveToCategoryId : kotlin.String = moveToCategoryId_example // kotlin.String | Remap any transactions assigned to the deleted category to this one. Omit to leave them uncategorized.
try {
    val result : DeleteAccountResponse = apiInstance.deleteCategory(id, moveToCategoryId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CategoriesApi#deleteCategory")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CategoriesApi#deleteCategory")
    e.printStackTrace()
}
```

### Parameters
| **id** | **kotlin.String**| Monarch category id. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **moveToCategoryId** | **kotlin.String**| Remap any transactions assigned to the deleted category to this one. Omit to leave them uncategorized. | [optional] |

### Return type

[**DeleteAccountResponse**](DeleteAccountResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="deleteCategoryGroup"></a>
# **deleteCategoryGroup**
> DeleteAccountResponse deleteCategoryGroup(id, moveToGroupId)

Delete a category group

Removes a category group. **Destructive** for orphaned child categories.  Pass &#x60;moveToGroupId&#x60; to remap every child category under this group to another group before deletion. Omit and the orphaned categories may need manual cleanup (Monarch will leave them pointing at a no-longer-existing parent).  System groups (the Monarch-built-in ones) cannot be deleted. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = CategoriesApi()
val id : kotlin.String = id_example // kotlin.String | Category group id.
val moveToGroupId : kotlin.String = moveToGroupId_example // kotlin.String | Remap this group's child categories to this group before deletion.
try {
    val result : DeleteAccountResponse = apiInstance.deleteCategoryGroup(id, moveToGroupId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CategoriesApi#deleteCategoryGroup")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CategoriesApi#deleteCategoryGroup")
    e.printStackTrace()
}
```

### Parameters
| **id** | **kotlin.String**| Category group id. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **moveToGroupId** | **kotlin.String**| Remap this group&#39;s child categories to this group before deletion. | [optional] |

### Return type

[**DeleteAccountResponse**](DeleteAccountResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getCategoryDeletionInfo"></a>
# **getCategoryDeletionInfo**
> GetCategoryDeletionInfoResponse getCategoryDeletionInfo(id)

Slim category snapshot for the delete-confirm flow

Returns just id, name, icon, and &#x60;isSystemCategory&#x60;. Use before showing a delete-confirmation dialog. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = CategoriesApi()
val id : kotlin.String = id_example // kotlin.String | Monarch category id.
try {
    val result : GetCategoryDeletionInfoResponse = apiInstance.getCategoryDeletionInfo(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CategoriesApi#getCategoryDeletionInfo")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CategoriesApi#getCategoryDeletionInfo")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **kotlin.String**| Monarch category id. | |

### Return type

[**GetCategoryDeletionInfoResponse**](GetCategoryDeletionInfoResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getCategoryEdit"></a>
# **getCategoryEdit**
> GetCategoryEditResponse getCategoryEdit(id)

Category with full edit-form fields

Returns the category enriched with edit-form fields: budget variability, rollover period, group metadata, system-category flag. Use as the source of truth before constructing an update payload. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = CategoriesApi()
val id : kotlin.String = id_example // kotlin.String | Monarch category id.
try {
    val result : GetCategoryEditResponse = apiInstance.getCategoryEdit(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CategoriesApi#getCategoryEdit")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CategoriesApi#getCategoryEdit")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **kotlin.String**| Monarch category id. | |

### Return type

[**GetCategoryEditResponse**](GetCategoryEditResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getCategoryGroupDetails"></a>
# **getCategoryGroupDetails**
> GetCategoryGroupDetailsResponse getCategoryGroupDetails(id, includeDisabledSystemCategories)

Category group with its child categories

Category-group detail including each child category (id, name, icon) and the group-level rollover period config. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = CategoriesApi()
val id : kotlin.String = id_example // kotlin.String | Monarch category-group id.
val includeDisabledSystemCategories : kotlin.Boolean = true // kotlin.Boolean | 
try {
    val result : GetCategoryGroupDetailsResponse = apiInstance.getCategoryGroupDetails(id, includeDisabledSystemCategories)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CategoriesApi#getCategoryGroupDetails")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CategoriesApi#getCategoryGroupDetails")
    e.printStackTrace()
}
```

### Parameters
| **id** | **kotlin.String**| Monarch category-group id. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **includeDisabledSystemCategories** | **kotlin.Boolean**|  | [optional] |

### Return type

[**GetCategoryGroupDetailsResponse**](GetCategoryGroupDetailsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="listCategories"></a>
# **listCategories**
> ListCategoriesResponse listCategories()

List all transaction categories

Returns every category Monarch knows about: built-in system categories (Groceries, Rent, Income, etc.) plus any custom ones the user has created. Each entry carries its name, icon, color, parent group id, &#x60;isSystemCategory&#x60; flag, and order.  Use to populate a category picker, resolve a &#x60;categoryId&#x60; to a display name, or enumerate ids before scoping a transaction query with &#x60;categoryIds&#x60;. For the one-level-up grouping see &#x60;GET /v1/category-groups&#x60;. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = CategoriesApi()
try {
    val result : ListCategoriesResponse = apiInstance.listCategories()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CategoriesApi#listCategories")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CategoriesApi#listCategories")
    e.printStackTrace()
}
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

<a id="listCategoryGroups"></a>
# **listCategoryGroups**
> ListCategoryGroupsResponse listCategoryGroups()

Parent groups (one tier above individual categories)

Returns the top-level grouping that categories roll up into: Income, Housing, Food, Transportation, etc. Each group carries its &#x60;type&#x60; (&#x60;income&#x60;, &#x60;expense&#x60;, &#x60;transfer&#x60;), &#x60;budgetVariability&#x60; (&#x60;fixed&#x60;, &#x60;flexible&#x60;, &#x60;non_monthly&#x60;), and display order.  Use to build a two-tier category picker, to look up a group id before creating a child category via &#x60;POST /v1/categories&#x60;, or to aggregate per-group spend in client code (the cashflow endpoint already does this server-side). 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = CategoriesApi()
try {
    val result : ListCategoryGroupsResponse = apiInstance.listCategoryGroups()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CategoriesApi#listCategoryGroups")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CategoriesApi#listCategoryGroups")
    e.printStackTrace()
}
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

<a id="updateCategoryGroup"></a>
# **updateCategoryGroup**
> CreateCategoryGroupResponse updateCategoryGroup(id, updateCategoryGroupRequest)

Update a category group

Patches a category group. Only non-null fields are forwarded to Monarch; omit a field to leave it untouched.  Editable: &#x60;name&#x60;, &#x60;type&#x60; (&#x60;income&#x60; / &#x60;expense&#x60; / &#x60;transfer&#x60;), &#x60;budgetVariability&#x60;, &#x60;groupLevelBudgetingEnabled&#x60;, icon and color metadata. For the narrow \&quot;just set fixed vs flex\&quot; case use the intent-revealing &#x60;PATCH /v1/category-groups/{id}/budget-variability&#x60; endpoint instead. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = CategoriesApi()
val id : kotlin.String = id_example // kotlin.String | Category group id.
val updateCategoryGroupRequest : UpdateCategoryGroupRequest =  // UpdateCategoryGroupRequest | 
try {
    val result : CreateCategoryGroupResponse = apiInstance.updateCategoryGroup(id, updateCategoryGroupRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CategoriesApi#updateCategoryGroup")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CategoriesApi#updateCategoryGroup")
    e.printStackTrace()
}
```

### Parameters
| **id** | **kotlin.String**| Category group id. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **updateCategoryGroupRequest** | [**UpdateCategoryGroupRequest**](UpdateCategoryGroupRequest.md)|  | |

### Return type

[**CreateCategoryGroupResponse**](CreateCategoryGroupResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="updateCategoryGroupBudgetVariability"></a>
# **updateCategoryGroupBudgetVariability**
> UpdateCategoryGroupBudgetVariabilityResponse updateCategoryGroupBudgetVariability(id, updateCategoryGroupBudgetVariabilityRequest)

Set a category group&#39;s budget-variability (fixed vs flex)

Targeted single-field update for &#x60;budgetVariability&#x60; on a category group. Values: &#x60;fixed&#x60; (predictable monthly amount like rent), &#x60;flexible&#x60; (variable spend like groceries, rolls into the Flex bucket), &#x60;non_monthly&#x60; (irregular like holiday gifts).  The wider &#x60;PATCH /v1/category-groups/{id}&#x60; can do the same thing; this endpoint exists as a narrower, intent-revealing call when all you want to change is the variability classification. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = CategoriesApi()
val id : kotlin.String = id_example // kotlin.String | Category group id.
val updateCategoryGroupBudgetVariabilityRequest : UpdateCategoryGroupBudgetVariabilityRequest =  // UpdateCategoryGroupBudgetVariabilityRequest | 
try {
    val result : UpdateCategoryGroupBudgetVariabilityResponse = apiInstance.updateCategoryGroupBudgetVariability(id, updateCategoryGroupBudgetVariabilityRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CategoriesApi#updateCategoryGroupBudgetVariability")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CategoriesApi#updateCategoryGroupBudgetVariability")
    e.printStackTrace()
}
```

### Parameters
| **id** | **kotlin.String**| Category group id. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **updateCategoryGroupBudgetVariabilityRequest** | [**UpdateCategoryGroupBudgetVariabilityRequest**](UpdateCategoryGroupBudgetVariabilityRequest.md)|  | |

### Return type

[**UpdateCategoryGroupBudgetVariabilityResponse**](UpdateCategoryGroupBudgetVariabilityResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

