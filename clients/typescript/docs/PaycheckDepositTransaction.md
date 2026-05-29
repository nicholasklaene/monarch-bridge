# PaycheckDepositTransaction

The matched bank-side transaction that funded one paycheck deposit.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **string** |  | [default to undefined]
**amount** | **number** |  | [optional] [default to undefined]
**date** | **string** |  | [optional] [default to undefined]
**merchant** | [**PaycheckDepositTransactionMerchant**](PaycheckDepositTransactionMerchant.md) |  | [optional] [default to undefined]
**account** | [**PaycheckDepositTransactionAccount**](PaycheckDepositTransactionAccount.md) |  | [optional] [default to undefined]

## Example

```typescript
import { PaycheckDepositTransaction } from 'monarch-bridge-client';

const instance: PaycheckDepositTransaction = {
    id,
    amount,
    date,
    merchant,
    account,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
