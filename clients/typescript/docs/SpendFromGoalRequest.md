# SpendFromGoalRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**amount** | **number** | Dollar amount spent (positive). | [default to undefined]
**date** | **string** | Spend date. Defaults to today. | [optional] [default to undefined]
**notes** | **string** | Optional caller-supplied note for the event. | [optional] [default to undefined]

## Example

```typescript
import { SpendFromGoalRequest } from 'monarch-bridge-client';

const instance: SpendFromGoalRequest = {
    amount,
    date,
    notes,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
