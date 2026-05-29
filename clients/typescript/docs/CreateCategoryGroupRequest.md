# CreateCategoryGroupRequest

Body for `POST /v1/category-groups`. Wraps Monarch\'s `CreateCategoryGroupInput`. `name` and `type` are required. `type` is one of `income`, `expense`, `transfer`. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **string** |  | [default to undefined]
**type** | **string** | One of &#x60;income&#x60;, &#x60;expense&#x60;, &#x60;transfer&#x60;. | [default to undefined]
**color** | **string** | Display color hex (with or without leading &#x60;#&#x60;). | [optional] [default to undefined]
**icon** | **string** |  | [optional] [default to undefined]
**budgetVariability** | **string** | One of &#x60;fixed&#x60;, &#x60;flexible&#x60;, &#x60;non_monthly&#x60;. | [optional] [default to undefined]
**groupLevelBudgetingEnabled** | **boolean** |  | [optional] [default to undefined]
**orderBefore** | **string** | UUID of an existing group; the new group is inserted before it. Omit to append at the end. | [optional] [default to undefined]
**rolloverEnabled** | **boolean** |  | [optional] [default to undefined]
**rolloverType** | **string** |  | [optional] [default to undefined]
**rolloverStartMonth** | **string** | ISO date &#x60;YYYY-MM-DD&#x60; of the first month in the initial rollover window. | [optional] [default to undefined]
**rolloverStartingBalance** | **number** |  | [optional] [default to undefined]

## Example

```typescript
import { CreateCategoryGroupRequest } from 'monarch-bridge-client';

const instance: CreateCategoryGroupRequest = {
    name,
    type,
    color,
    icon,
    budgetVariability,
    groupLevelBudgetingEnabled,
    orderBefore,
    rolloverEnabled,
    rolloverType,
    rolloverStartMonth,
    rolloverStartingBalance,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
