# UpdateGoalsPrioritiesRequest

Ordered list of goal ids - index = `priority` (0-based, lower = higher priority). The proxy expands this into Monarch\'s `[{id, priority}]` shape before mutating. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**goalIds** | **Array&lt;string&gt;** |  | [default to undefined]

## Example

```typescript
import { UpdateGoalsPrioritiesRequest } from 'monarch-bridge-client';

const instance: UpdateGoalsPrioritiesRequest = {
    goalIds,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
