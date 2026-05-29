# TransactionsDuplicatesResponse

Groups of likely-duplicate transactions in the requested window. Each group\'s `transactions` list always has length > 1; singletons are filtered out. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetTransactionsDuplicatesResponseData**](GetTransactionsDuplicatesResponseData.md) |  | [default to undefined]

## Example

```typescript
import { TransactionsDuplicatesResponse } from 'monarch-bridge-client';

const instance: TransactionsDuplicatesResponse = {
    data,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
