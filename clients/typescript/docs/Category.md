# Category

A transaction category. System and user-created categories share this shape.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **string** |  | [default to undefined]
**name** | **string** |  | [default to undefined]
**icon** | **string** |  | [optional] [default to undefined]
**order** | **number** |  | [optional] [default to undefined]
**systemCategory** | **string** |  | [optional] [default to undefined]
**isSystemCategory** | **boolean** |  | [optional] [default to undefined]
**group** | [**CategoryGroupRef**](CategoryGroupRef.md) |  | [optional] [default to undefined]

## Example

```typescript
import { Category } from 'monarch-bridge-client';

const instance: Category = {
    id,
    name,
    icon,
    order,
    systemCategory,
    isSystemCategory,
    group,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
