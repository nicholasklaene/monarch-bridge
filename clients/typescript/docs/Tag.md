# Tag

A user-defined transaction tag.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **string** |  | [default to undefined]
**name** | **string** |  | [default to undefined]
**color** | **string** | 6-digit RGB hex with leading &#x60;#&#x60;. | [default to undefined]
**order** | **number** |  | [optional] [default to undefined]
**transactionCount** | **number** |  | [optional] [default to undefined]

## Example

```typescript
import { Tag } from 'monarch-bridge-client';

const instance: Tag = {
    id,
    name,
    color,
    order,
    transactionCount,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
