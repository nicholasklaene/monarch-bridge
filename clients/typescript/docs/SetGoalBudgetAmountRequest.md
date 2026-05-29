# SetGoalBudgetAmountRequest

Set monthly planned-contribution allocation for a savings goal. `month` is the first-of-month date (`YYYY-MM-DD`); defaults to current month. `applyToFuture` cascades the amount to all subsequent months. `accountId` is optional - omit for the household-level amount. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**amount** | **number** |  | [default to undefined]
**month** | **string** |  | [optional] [default to undefined]
**applyToFuture** | **boolean** |  | [optional] [default to undefined]
**accountId** | **string** |  | [optional] [default to undefined]

## Example

```typescript
import { SetGoalBudgetAmountRequest } from 'monarch-bridge-client';

const instance: SetGoalBudgetAmountRequest = {
    amount,
    month,
    applyToFuture,
    accountId,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
