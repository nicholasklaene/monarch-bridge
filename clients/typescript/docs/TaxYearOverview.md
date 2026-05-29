# TaxYearOverview


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**taxYear** | **number** |  | [default to undefined]
**totalIncome** | **number** |  | [optional] [default to undefined]
**totalDeductions** | **number** |  | [optional] [default to undefined]
**estimatedTax** | **number** |  | [optional] [default to undefined]
**transactionCount** | **number** |  | [optional] [default to undefined]
**scheduleSummaries** | [**Array&lt;TaxScheduleSummary&gt;**](TaxScheduleSummary.md) |  | [default to undefined]

## Example

```typescript
import { TaxYearOverview } from 'monarch-bridge-client';

const instance: TaxYearOverview = {
    taxYear,
    totalIncome,
    totalDeductions,
    estimatedTax,
    transactionCount,
    scheduleSummaries,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
