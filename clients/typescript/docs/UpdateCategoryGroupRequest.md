# UpdateCategoryGroupRequest

Body for `PATCH /v1/category-groups/{id}`. Wraps Monarch\'s `UpdateCategoryGroupInput`. Every field is optional; only non-null fields are forwarded. Path `{id}` is injected into the GraphQL `input` automatically. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **string** |  | [optional] [default to undefined]
**color** | **string** |  | [optional] [default to undefined]
**icon** | **string** |  | [optional] [default to undefined]
**budgetVariability** | **string** |  | [optional] [default to undefined]
**groupLevelBudgetingEnabled** | **boolean** |  | [optional] [default to undefined]
**rolloverEnabled** | **boolean** |  | [optional] [default to undefined]
**rolloverType** | **string** |  | [optional] [default to undefined]
**rolloverStartMonth** | **string** |  | [optional] [default to undefined]
**rolloverStartingBalance** | **number** |  | [optional] [default to undefined]

## Example

```typescript
import { UpdateCategoryGroupRequest } from 'monarch-bridge-client';

const instance: UpdateCategoryGroupRequest = {
    name,
    color,
    icon,
    budgetVariability,
    groupLevelBudgetingEnabled,
    rolloverEnabled,
    rolloverType,
    rolloverStartMonth,
    rolloverStartingBalance,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
