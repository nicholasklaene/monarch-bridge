# TagsApi

All URIs are relative to **

Method | HTTP request | Description
------------- | ------------- | -------------
[**createTag**](TagsApi.md#createTag) | **POST** /v1/tags | Create a tag
[**deleteTag**](TagsApi.md#deleteTag) | **DELETE** /v1/tags/{id} | Delete a tag
[**listTags**](TagsApi.md#listTags) | **GET** /v1/tags | List all transaction tags



## createTag

Create a tag

Adds a new transaction tag. Required: 'name' and 'color' (hex
string like '#7F3F98').

Use to spin up a labeling dimension Monarch's built-in categories
don't cover (e.g. '#reimbursable', '#vacation-2026', '#tax-deductible').
Returns the new tag with its id - pass that id into
'PUT /v1/transactions/{id}/tags' to apply.

### Example

```bash
monarch-api createTag
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createTagRequest** | [**CreateTagRequest**](CreateTagRequest.md) |  |

### Return type

[**CreateTag200Response**](CreateTag200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## deleteTag

Delete a tag

Removes one transaction tag household-wide. **Destructive** - the tag is
detached from every transaction it was attached to and disappears from
the tag picker.

Use to retire labeling dimensions the household no longer needs (stale
project codes, expired test tags). For bulk transaction edits use
'PATCH /v1/transactions/bulk'; this endpoint only deletes the tag
definition itself.

### Example

```bash
monarch-api deleteTag id=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string** | Monarch tag id. | [default to null]

### Return type

[**DeleteTag200Response**](DeleteTag200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## listTags

List all transaction tags

Returns every user-created transaction tag with id, name, color,
and order. Tags are a free-form labeling layer orthogonal to
categories (a transaction can have many tags but exactly one
category).

Use to populate a tag picker, resolve 'tagIds' for the transaction
filter params, or before assigning tags to a transaction via
'PUT /v1/transactions/{id}/tags'.

### Example

```bash
monarch-api listTags
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**ListTags200Response**](ListTags200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

