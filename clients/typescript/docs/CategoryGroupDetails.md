# CategoryGroupDetails


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **string** |  | [default to undefined]
**name** | **string** |  | [optional] [default to undefined]
**order** | **number** |  | [optional] [default to undefined]
**type** | **string** |  | [optional] [default to undefined]
**color** | **string** |  | [optional] [default to undefined]
**groupLevelBudgetingEnabled** | **boolean** |  | [optional] [default to undefined]
**budgetVariability** | **string** |  | [optional] [default to undefined]
**rolloverPeriodId** | **string** |  | [optional] [default to undefined]
**rolloverStartMonth** | **string** |  | [optional] [default to undefined]
**rolloverEndMonth** | **string** |  | [optional] [default to undefined]
**rolloverStartingBalance** | **number** |  | [optional] [default to undefined]
**categories** | [**Array&lt;CategoryGroupChildCategory&gt;**](CategoryGroupChildCategory.md) |  | [optional] [default to undefined]

## Example

```typescript
import { CategoryGroupDetails } from 'monarch-bridge-client';

const instance: CategoryGroupDetails = {
    id,
    name,
    order,
    type,
    color,
    groupLevelBudgetingEnabled,
    budgetVariability,
    rolloverPeriodId,
    rolloverStartMonth,
    rolloverEndMonth,
    rolloverStartingBalance,
    categories,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
