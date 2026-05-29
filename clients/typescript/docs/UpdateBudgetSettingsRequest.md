# UpdateBudgetSettingsRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**budgetSystem** | **string** | One of &#x60;category&#x60;, &#x60;category_group&#x60;. Omit to leave unchanged. | [optional] [default to undefined]
**budgetApplyToFutureMonthsDefault** | **boolean** | When true, budget-amount edits cascade to future months by default. Omit to leave unchanged. | [optional] [default to undefined]

## Example

```typescript
import { UpdateBudgetSettingsRequest } from 'monarch-bridge-client';

const instance: UpdateBudgetSettingsRequest = {
    budgetSystem,
    budgetApplyToFutureMonthsDefault,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
