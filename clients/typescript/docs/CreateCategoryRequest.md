# CreateCategoryRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**group** | **string** | categoryGroup id from &#x60;/v1/category-groups&#x60;. | [default to undefined]
**name** | **string** |  | [default to undefined]
**icon** | **string** |  | [optional] [default to '❓']
**rolloverEnabled** | **boolean** |  | [optional] [default to false]
**rolloverType** | **string** |  | [optional] [default to 'monthly']
**rolloverStartMonth** | **string** | Defaults to first of the current month. | [optional] [default to undefined]

## Example

```typescript
import { CreateCategoryRequest } from 'monarch-bridge-client';

const instance: CreateCategoryRequest = {
    group,
    name,
    icon,
    rolloverEnabled,
    rolloverType,
    rolloverStartMonth,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
