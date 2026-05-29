# MoveTransactionsRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**transactionIds** | **Array&lt;string&gt;** | Transaction ids to move. | [default to undefined]
**toAccountId** | **string** | Destination Monarch account id. | [default to undefined]

## Example

```typescript
import { MoveTransactionsRequest } from 'monarch-bridge-client';

const instance: MoveTransactionsRequest = {
    transactionIds,
    toAccountId,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
