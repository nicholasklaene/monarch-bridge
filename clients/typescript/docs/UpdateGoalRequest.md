# UpdateGoalRequest

Partial update for `PATCH /v1/goals/{id}`. Send only the fields you want to change. Maps to a subset of Monarch\'s `UpdateSavingsGoalInput` (the practical edit surface; deeper account-link + budget-cascade fields have dedicated endpoints). 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **string** |  | [optional] [default to undefined]
**targetAmount** | **number** |  | [optional] [default to undefined]
**targetDate** | **string** | ISO date &#x60;YYYY-MM-DD&#x60;. | [optional] [default to undefined]
**priority** | **number** |  | [optional] [default to undefined]
**isSinkingFund** | **boolean** |  | [optional] [default to undefined]
**imageStorageProvider** | **string** |  | [optional] [default to undefined]
**imageStorageProviderId** | **string** |  | [optional] [default to undefined]

## Example

```typescript
import { UpdateGoalRequest } from 'monarch-bridge-client';

const instance: UpdateGoalRequest = {
    name,
    targetAmount,
    targetDate,
    priority,
    isSinkingFund,
    imageStorageProvider,
    imageStorageProviderId,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
