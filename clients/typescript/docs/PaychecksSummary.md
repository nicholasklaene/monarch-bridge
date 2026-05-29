# PaychecksSummary

Aggregate paycheck stats over a date window.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**count** | **number** | Number of paychecks in the window. | [default to undefined]
**totalGross** | **number** | Sum of &#x60;grossAmount&#x60; across all paychecks in window. | [default to undefined]
**totalDeductions** | **number** |  | [default to undefined]
**totalNet** | **number** | totalGross minus totalDeductions. | [default to undefined]
**deductionRate** | **number** | totalDeductions / totalGross, 0.0 to 1.0. | [optional] [default to undefined]
**deductionsByType** | [**Array&lt;PaychecksSummaryDeduction&gt;**](PaychecksSummaryDeduction.md) |  | [optional] [default to undefined]

## Example

```typescript
import { PaychecksSummary } from 'monarch-bridge-client';

const instance: PaychecksSummary = {
    count,
    totalGross,
    totalDeductions,
    totalNet,
    deductionRate,
    deductionsByType,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
