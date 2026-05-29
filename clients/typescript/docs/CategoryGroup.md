# CategoryGroup

A parent category group (one tier above individual categories).

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **string** |  | [default to undefined]
**name** | **string** |  | [default to undefined]
**order** | **number** |  | [optional] [default to undefined]
**type** | **string** | One of &#x60;income&#x60;, &#x60;expense&#x60;, &#x60;transfer&#x60;. | [optional] [default to undefined]
**updatedAt** | **string** |  | [optional] [default to undefined]
**createdAt** | **string** |  | [optional] [default to undefined]
**color** | **string** | Display color hex (sent by &#x60;CategoryGroupFields&#x60;). | [optional] [default to undefined]
**groupLevelBudgetingEnabled** | **boolean** | True when the user budgets at group level rather than per-category. | [optional] [default to undefined]
**budgetVariability** | **string** | One of &#x60;fixed&#x60;, &#x60;flexible&#x60;, &#x60;non_monthly&#x60;. Drives fixed-vs-flex bucket classification. | [optional] [default to undefined]
**rolloverPeriod** | [**CategoryGroupRolloverPeriod**](CategoryGroupRolloverPeriod.md) |  | [optional] [default to undefined]

## Example

```typescript
import { CategoryGroup } from 'monarch-bridge-client';

const instance: CategoryGroup = {
    id,
    name,
    order,
    type,
    updatedAt,
    createdAt,
    color,
    groupLevelBudgetingEnabled,
    budgetVariability,
    rolloverPeriod,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
