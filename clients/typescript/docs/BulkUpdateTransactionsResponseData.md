# BulkUpdateTransactionsResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**success** | **boolean** |  | [default to undefined]
**affectedCount** | **number** | Number of rows Monarch actually updated. | [default to undefined]
**errors** | [**Array&lt;BulkMutationError&gt;**](BulkMutationError.md) |  | [optional] [default to undefined]

## Example

```typescript
import { BulkUpdateTransactionsResponseData } from 'monarch-bridge-client';

const instance: BulkUpdateTransactionsResponseData = {
    success,
    affectedCount,
    errors,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
