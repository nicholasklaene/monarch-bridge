# UpdateTransactionSplitsRequest

Replace the splits on a transaction. Sum of `amount` must equal parent transaction amount.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**splitData** | [**Array&lt;Split&gt;**](Split.md) |  | [default to undefined]

## Example

```typescript
import { UpdateTransactionSplitsRequest } from 'monarch-bridge-client';

const instance: UpdateTransactionSplitsRequest = {
    splitData,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
