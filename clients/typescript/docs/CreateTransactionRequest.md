# CreateTransactionRequest

Body for `POST /v1/transactions`. `amount` is signed - negative for expenses, positive for income. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**date** | **string** |  | [default to undefined]
**accountId** | **string** |  | [default to undefined]
**amount** | **number** | Signed amount. | [default to undefined]
**merchantName** | **string** |  | [default to undefined]
**categoryId** | **string** |  | [default to undefined]
**notes** | **string** |  | [optional] [default to '']
**shouldUpdateBalance** | **boolean** | If true, Monarch re-syncs the affected account\&#39;s balance after creation. | [optional] [default to false]

## Example

```typescript
import { CreateTransactionRequest } from 'monarch-bridge-client';

const instance: CreateTransactionRequest = {
    date,
    accountId,
    amount,
    merchantName,
    categoryId,
    notes,
    shouldUpdateBalance,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
