# PaycheckDeposit

One credit-side transaction recorded against a paycheck (multi-deposit support).

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **string** |  | [default to undefined]
**transaction** | [**PaycheckDepositTransaction**](PaycheckDepositTransaction.md) |  | [optional] [default to undefined]
**createdAt** | **string** |  | [optional] [default to undefined]

## Example

```typescript
import { PaycheckDeposit } from 'monarch-bridge-client';

const instance: PaycheckDeposit = {
    id,
    transaction,
    createdAt,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
