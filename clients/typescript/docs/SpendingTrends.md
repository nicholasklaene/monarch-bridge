# SpendingTrends


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**timeframe** | **string** |  | [optional] [default to undefined]
**currentPeriodTotal** | **number** |  | [optional] [default to undefined]
**previousPeriodTotal** | **number** |  | [optional] [default to undefined]
**deltaAmount** | **number** |  | [optional] [default to undefined]
**deltaPercent** | **number** |  | [optional] [default to undefined]
**risingCategories** | [**Array&lt;SpendingTrendCategory&gt;**](SpendingTrendCategory.md) |  | [default to undefined]
**fallingCategories** | [**Array&lt;SpendingTrendCategory&gt;**](SpendingTrendCategory.md) |  | [default to undefined]

## Example

```typescript
import { SpendingTrends } from 'monarch-bridge-client';

const instance: SpendingTrends = {
    timeframe,
    currentPeriodTotal,
    previousPeriodTotal,
    deltaAmount,
    deltaPercent,
    risingCategories,
    fallingCategories,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
