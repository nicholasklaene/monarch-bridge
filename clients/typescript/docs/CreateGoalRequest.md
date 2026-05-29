# CreateGoalRequest

Body for `POST /v1/goals`. Wraps Monarch\'s batch `createSavingsGoals` mutation as a single-goal convenience. `imageStorageProvider` + `imageStorageProviderId` are picked from Monarch\'s stock goal-image library; omit for the default fallback. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **string** |  | [default to undefined]
**type** | **string** | One of &#x60;savings&#x60;, &#x60;debt&#x60;. | [optional] [default to 'savings']
**targetAmount** | **number** |  | [optional] [default to undefined]
**targetDate** | **string** | ISO date &#x60;YYYY-MM-DD&#x60;. | [optional] [default to undefined]
**imageStorageProvider** | **string** |  | [optional] [default to undefined]
**imageStorageProviderId** | **string** |  | [optional] [default to undefined]

## Example

```typescript
import { CreateGoalRequest } from 'monarch-bridge-client';

const instance: CreateGoalRequest = {
    name,
    type,
    targetAmount,
    targetDate,
    imageStorageProvider,
    imageStorageProviderId,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
