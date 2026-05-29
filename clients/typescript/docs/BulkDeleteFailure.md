# BulkDeleteFailure


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **string** | Category id that failed to delete. | [default to undefined]
**reason** | **string** | Upstream exception message captured from the per-id delete. | [default to undefined]

## Example

```typescript
import { BulkDeleteFailure } from 'monarch-bridge-client';

const instance: BulkDeleteFailure = {
    id,
    reason,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
