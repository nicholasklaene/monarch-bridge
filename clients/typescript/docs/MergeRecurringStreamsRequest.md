# MergeRecurringStreamsRequest

Merge two or more recurring streams into one. `primaryStreamId` survives; all `mergedStreamIds` are absorbed into it. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**primaryStreamId** | **string** |  | [default to undefined]
**mergedStreamIds** | **Array&lt;string&gt;** |  | [default to undefined]
**newName** | **string** | Optional new display name for the merged stream. | [optional] [default to undefined]

## Example

```typescript
import { MergeRecurringStreamsRequest } from 'monarch-bridge-client';

const instance: MergeRecurringStreamsRequest = {
    primaryStreamId,
    mergedStreamIds,
    newName,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
