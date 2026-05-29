# CategoryGroupRolloverPeriod

Current rollover window for a category group; null when rollover is disabled.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **string** |  | [optional] [default to undefined]
**startMonth** | **string** | ISO date &#x60;YYYY-MM-DD&#x60; of the first month in the current rollover window. | [optional] [default to undefined]
**endMonth** | **string** | ISO date &#x60;YYYY-MM-DD&#x60; of the last month in the current rollover window. | [optional] [default to undefined]
**startingBalance** | **number** |  | [optional] [default to undefined]

## Example

```typescript
import { CategoryGroupRolloverPeriod } from 'monarch-bridge-client';

const instance: CategoryGroupRolloverPeriod = {
    id,
    startMonth,
    endMonth,
    startingBalance,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
