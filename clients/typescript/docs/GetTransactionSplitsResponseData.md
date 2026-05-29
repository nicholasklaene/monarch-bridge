# GetTransactionSplitsResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **string** |  | [default to undefined]
**amount** | **number** |  | [default to undefined]
**merchant** | [**Ref**](Ref.md) |  | [optional] [default to undefined]
**category** | [**Ref**](Ref.md) |  | [optional] [default to undefined]
**splits** | [**Array&lt;TransactionSplit&gt;**](TransactionSplit.md) |  | [default to undefined]

## Example

```typescript
import { GetTransactionSplitsResponseData } from 'monarch-bridge-client';

const instance: GetTransactionSplitsResponseData = {
    id,
    amount,
    merchant,
    category,
    splits,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
