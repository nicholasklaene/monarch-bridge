# BulkDeleteTransactionsResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**success** | **boolean** | Monarch\&#39;s mutation-level success flag. | [default to undefined]
**affectedCount** | **number** | Number of rows Monarch actually deleted. | [default to undefined]
**errors** | [**Array&lt;BulkMutationError&gt;**](BulkMutationError.md) | Per-row error messages (typically null on success). | [optional] [default to undefined]

## Example

```typescript
import { BulkDeleteTransactionsResponseData } from 'monarch-bridge-client';

const instance: BulkDeleteTransactionsResponseData = {
    success,
    affectedCount,
    errors,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
