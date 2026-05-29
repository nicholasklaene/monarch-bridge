# BulkDeleteCategoriesResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**deleted** | **Array&lt;string&gt;** | Ids that were deleted successfully. | [default to undefined]
**failed** | [**Array&lt;BulkDeleteFailure&gt;**](BulkDeleteFailure.md) | Per-id failures (the bulk endpoint itself still returns 200). | [default to undefined]

## Example

```typescript
import { BulkDeleteCategoriesResponseData } from 'monarch-bridge-client';

const instance: BulkDeleteCategoriesResponseData = {
    deleted,
    failed,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
