# WithdrawFromGoalRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**amount** | **number** | Dollar amount to withdraw (positive). | [default to undefined]
**accountId** | **string** | Source account id (where the goal balance is parked). | [default to undefined]
**date** | **string** | Withdrawal date. Defaults to today. | [optional] [default to undefined]

## Example

```typescript
import { WithdrawFromGoalRequest } from 'monarch-bridge-client';

const instance: WithdrawFromGoalRequest = {
    amount,
    accountId,
    date,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
