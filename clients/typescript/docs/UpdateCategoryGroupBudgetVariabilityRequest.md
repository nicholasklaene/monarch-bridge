# UpdateCategoryGroupBudgetVariabilityRequest

Body for `PATCH /v1/category-groups/{id}/budget-variability`. Narrowly scoped to flip the fixed-vs-flex classification. Common values: `fixed`, `flexible`, `non_monthly`. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**budgetVariability** | **string** |  | [default to undefined]

## Example

```typescript
import { UpdateCategoryGroupBudgetVariabilityRequest } from 'monarch-bridge-client';

const instance: UpdateCategoryGroupBudgetVariabilityRequest = {
    budgetVariability,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
