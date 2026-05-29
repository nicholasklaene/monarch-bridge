# TransactionSplit

One split row inside a transaction\'s split set.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **string** |  | [optional] [default to undefined]
**amount** | **number** | Signed. | [optional] [default to undefined]
**notes** | **string** |  | [optional] [default to undefined]
**merchantName** | **string** |  | [optional] [default to undefined]
**categoryName** | **string** |  | [optional] [default to undefined]

## Example

```typescript
import { TransactionSplit } from 'monarch-bridge-client';

const instance: TransactionSplit = {
    id,
    amount,
    notes,
    merchantName,
    categoryName,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
