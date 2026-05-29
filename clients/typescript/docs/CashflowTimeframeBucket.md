# CashflowTimeframeBucket


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**period** | **string** | The grouping bucket label (year/month/quarter as ISO string). | [default to undefined]
**savings** | **number** |  | [optional] [default to undefined]
**savingsRate** | **number** |  | [optional] [default to undefined]
**sumIncome** | **number** |  | [optional] [default to undefined]
**sumExpense** | **number** |  | [optional] [default to undefined]

## Example

```typescript
import { CashflowTimeframeBucket } from 'monarch-bridge-client';

const instance: CashflowTimeframeBucket = {
    period,
    savings,
    savingsRate,
    sumIncome,
    sumExpense,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
