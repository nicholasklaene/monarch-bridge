# BulkDeleteCategoriesRequest

Body for `POST /v1/categories/bulk-delete`. Each id in `ids` is forwarded to the existing single-id delete operation. `moveToCategoryId`, if present, is applied to every per-id delete. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**ids** | **Array&lt;string&gt;** | Category ids to delete. | [default to undefined]
**moveToCategoryId** | **string** | Optional remap target applied to each per-id delete. | [optional] [default to undefined]

## Example

```typescript
import { BulkDeleteCategoriesRequest } from 'monarch-bridge-client';

const instance: BulkDeleteCategoriesRequest = {
    ids,
    moveToCategoryId,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
