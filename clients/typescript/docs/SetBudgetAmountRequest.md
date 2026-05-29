# SetBudgetAmountRequest

Set the planned budget for ONE category OR category-group for a month. Pass exactly one of `categoryId` / `categoryGroupId`. `amount: 0` clears. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**amount** | **number** |  | [default to undefined]
**startDate** | **string** |  | [default to undefined]
**categoryId** | **string** |  | [optional] [default to undefined]
**categoryGroupId** | **string** |  | [optional] [default to undefined]
**timeframe** | **string** |  | [optional] [default to TimeframeEnum_Month]
**applyToFuture** | **boolean** |  | [optional] [default to false]

## Example

```typescript
import { SetBudgetAmountRequest } from 'monarch-bridge-client';

const instance: SetBudgetAmountRequest = {
    amount,
    startDate,
    categoryId,
    categoryGroupId,
    timeframe,
    applyToFuture,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
