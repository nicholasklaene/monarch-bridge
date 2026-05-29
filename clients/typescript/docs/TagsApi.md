# TagsApi

All URIs are relative to *http://localhost:9084*

|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|[**createTag**](#createtag) | **POST** /v1/tags | Create a tag|
|[**deleteTag**](#deletetag) | **DELETE** /v1/tags/{id} | Delete a tag|
|[**listTags**](#listtags) | **GET** /v1/tags | List all transaction tags|

# **createTag**
> CreateTagResponse createTag(createTagRequest)

Adds a new transaction tag. Required: `name` and `color` (hex string like `#7F3F98`).  Use to spin up a labeling dimension Monarch\'s built-in categories don\'t cover (e.g. `#reimbursable`, `#vacation-2026`, `#tax-deductible`). Returns the new tag with its id - pass that id into `PUT /v1/transactions/{id}/tags` to apply. 

### Example

```typescript
import {
    TagsApi,
    Configuration,
    CreateTagRequest
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TagsApi(configuration);

let createTagRequest: CreateTagRequest; //

const { status, data } = await apiInstance.createTag(
    createTagRequest
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **createTagRequest** | **CreateTagRequest**|  | |


### Return type

**CreateTagResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | New tag. |  -  |
|**400** | Validation failed (bad name or bad color). |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **deleteTag**
> DeleteTagResponse deleteTag()

Removes one transaction tag household-wide. **Destructive** - the tag is detached from every transaction it was attached to and disappears from the tag picker.  Use to retire labeling dimensions the household no longer needs (stale project codes, expired test tags). For bulk transaction edits use `PATCH /v1/transactions/bulk`; this endpoint only deletes the tag definition itself. 

### Example

```typescript
import {
    TagsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TagsApi(configuration);

let id: string; //Monarch tag id. (default to undefined)

const { status, data } = await apiInstance.deleteTag(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**string**] | Monarch tag id. | defaults to undefined|


### Return type

**DeleteTagResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Confirmation - &#x60;deleted&#x3D;true&#x60; on success, &#x60;false&#x60; when Monarch reports a payload error. |  -  |
|**404** | Tag not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listTags**
> ListTagsResponse listTags()

Returns every user-created transaction tag with id, name, color, and order. Tags are a free-form labeling layer orthogonal to categories (a transaction can have many tags but exactly one category).  Use to populate a tag picker, resolve `tagIds` for the transaction filter params, or before assigning tags to a transaction via `PUT /v1/transactions/{id}/tags`. 

### Example

```typescript
import {
    TagsApi,
    Configuration
} from 'monarch-bridge-client';

const configuration = new Configuration();
const apiInstance = new TagsApi(configuration);

const { status, data } = await apiInstance.listTags();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**ListTagsResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | All tags. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

