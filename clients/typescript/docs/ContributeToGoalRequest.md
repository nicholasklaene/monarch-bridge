# ContributeToGoalRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accountId** | **string** | Monarch account id the contribution is drawn from. | [default to undefined]
**amount** | **number** | Dollars (positive &#x3D; contribution, negative &#x3D; withdrawal). | [default to undefined]
**date** | **string** | ISO date &#x60;YYYY-MM-DD&#x60;; defaults to today. | [optional] [default to undefined]

## Example

```typescript
import { ContributeToGoalRequest } from 'monarch-bridge-client';

const instance: ContributeToGoalRequest = {
    accountId,
    amount,
    date,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
