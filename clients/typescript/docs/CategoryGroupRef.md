# CategoryGroupRef

Minimal group reference embedded inside a `Category`. Use the full [CategoryGroup] schema when reading from `/v1/category-groups` directly. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **string** |  | [optional] [default to undefined]
**name** | **string** |  | [optional] [default to undefined]
**type** | **string** |  | [optional] [default to undefined]

## Example

```typescript
import { CategoryGroupRef } from 'monarch-bridge-client';

const instance: CategoryGroupRef = {
    id,
    name,
    type,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
