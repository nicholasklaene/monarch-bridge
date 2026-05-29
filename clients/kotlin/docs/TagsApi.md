# TagsApi

All URIs are relative to *http://localhost:9084*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**createTag**](TagsApi.md#createTag) | **POST** /v1/tags | Create a tag |
| [**deleteTag**](TagsApi.md#deleteTag) | **DELETE** /v1/tags/{id} | Delete a tag |
| [**listTags**](TagsApi.md#listTags) | **GET** /v1/tags | List all transaction tags |


<a id="createTag"></a>
# **createTag**
> CreateTagResponse createTag(createTagRequest)

Create a tag

Adds a new transaction tag. Required: &#x60;name&#x60; and &#x60;color&#x60; (hex string like &#x60;#7F3F98&#x60;).  Use to spin up a labeling dimension Monarch&#39;s built-in categories don&#39;t cover (e.g. &#x60;#reimbursable&#x60;, &#x60;#vacation-2026&#x60;, &#x60;#tax-deductible&#x60;). Returns the new tag with its id - pass that id into &#x60;PUT /v1/transactions/{id}/tags&#x60; to apply. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TagsApi()
val createTagRequest : CreateTagRequest =  // CreateTagRequest | 
try {
    val result : CreateTagResponse = apiInstance.createTag(createTagRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TagsApi#createTag")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TagsApi#createTag")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **createTagRequest** | [**CreateTagRequest**](CreateTagRequest.md)|  | |

### Return type

[**CreateTagResponse**](CreateTagResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="deleteTag"></a>
# **deleteTag**
> DeleteTagResponse deleteTag(id)

Delete a tag

Removes one transaction tag household-wide. **Destructive** - the tag is detached from every transaction it was attached to and disappears from the tag picker.  Use to retire labeling dimensions the household no longer needs (stale project codes, expired test tags). For bulk transaction edits use &#x60;PATCH /v1/transactions/bulk&#x60;; this endpoint only deletes the tag definition itself. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TagsApi()
val id : kotlin.String = id_example // kotlin.String | Monarch tag id.
try {
    val result : DeleteTagResponse = apiInstance.deleteTag(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TagsApi#deleteTag")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TagsApi#deleteTag")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **kotlin.String**| Monarch tag id. | |

### Return type

[**DeleteTagResponse**](DeleteTagResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="listTags"></a>
# **listTags**
> ListTagsResponse listTags()

List all transaction tags

Returns every user-created transaction tag with id, name, color, and order. Tags are a free-form labeling layer orthogonal to categories (a transaction can have many tags but exactly one category).  Use to populate a tag picker, resolve &#x60;tagIds&#x60; for the transaction filter params, or before assigning tags to a transaction via &#x60;PUT /v1/transactions/{id}/tags&#x60;. 

### Example
```kotlin
// Import classes:
//import com.nicholasklaene.monarchbridge.client.infrastructure.*
//import com.nicholasklaene.monarchbridge.client.models.*

val apiInstance = TagsApi()
try {
    val result : ListTagsResponse = apiInstance.listTags()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TagsApi#listTags")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TagsApi#listTags")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ListTagsResponse**](ListTagsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

