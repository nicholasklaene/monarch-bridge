# monarch_bridge_client.TagsApi

All URIs are relative to *http://localhost:9084*

Method | HTTP request | Description
------------- | ------------- | -------------
[**create_tag**](TagsApi.md#create_tag) | **POST** /v1/tags | Create a tag
[**delete_tag**](TagsApi.md#delete_tag) | **DELETE** /v1/tags/{id} | Delete a tag
[**list_tags**](TagsApi.md#list_tags) | **GET** /v1/tags | List all transaction tags


# **create_tag**
> CreateTagResponse create_tag(create_tag_request)

Create a tag

Adds a new transaction tag. Required: `name` and `color` (hex
string like `#7F3F98`).

Use to spin up a labeling dimension Monarch's built-in categories
don't cover (e.g. `#reimbursable`, `#vacation-2026`, `#tax-deductible`).
Returns the new tag with its id - pass that id into
`PUT /v1/transactions/{id}/tags` to apply.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.create_tag_response import CreateTagResponse
from monarch_bridge_client.models.create_tag_request import CreateTagRequest
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
    api_instance = monarch_bridge_client.TagsApi(api_client)
    create_tag_request = monarch_bridge_client.CreateTagRequest() # CreateTagRequest | 

    try:
        # Create a tag
        api_response = api_instance.create_tag(create_tag_request)
        print("The response of TagsApi->create_tag:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TagsApi->create_tag: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **create_tag_request** | [**CreateTagRequest**](CreateTagRequest.md)|  | 

### Return type

[**CreateTagResponse**](CreateTagResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | New tag. |  -  |
**400** | Validation failed (bad name or bad color). |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_tag**
> DeleteTagResponse delete_tag(id)

Delete a tag

Removes one transaction tag household-wide. **Destructive** - the tag is
detached from every transaction it was attached to and disappears from
the tag picker.

Use to retire labeling dimensions the household no longer needs (stale
project codes, expired test tags). For bulk transaction edits use
`PATCH /v1/transactions/bulk`; this endpoint only deletes the tag
definition itself.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.delete_tag_response import DeleteTagResponse
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
    api_instance = monarch_bridge_client.TagsApi(api_client)
    id = 'id_example' # str | Monarch tag id.

    try:
        # Delete a tag
        api_response = api_instance.delete_tag(id)
        print("The response of TagsApi->delete_tag:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TagsApi->delete_tag: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| Monarch tag id. | 

### Return type

[**DeleteTagResponse**](DeleteTagResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Confirmation - &#x60;deleted&#x3D;true&#x60; on success, &#x60;false&#x60; when Monarch reports a payload error. |  -  |
**404** | Tag not found. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_tags**
> ListTagsResponse list_tags()

List all transaction tags

Returns every user-created transaction tag with id, name, color,
and order. Tags are a free-form labeling layer orthogonal to
categories (a transaction can have many tags but exactly one
category).

Use to populate a tag picker, resolve `tagIds` for the transaction
filter params, or before assigning tags to a transaction via
`PUT /v1/transactions/{id}/tags`.


### Example


```python
import monarch_bridge_client
from monarch_bridge_client.models.list_tags_response import ListTagsResponse
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
    api_instance = monarch_bridge_client.TagsApi(api_client)

    try:
        # List all transaction tags
        api_response = api_instance.list_tags()
        print("The response of TagsApi->list_tags:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling TagsApi->list_tags: %s\n" % e)
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

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | All tags. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

