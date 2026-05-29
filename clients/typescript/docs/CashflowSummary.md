# CashflowSummary

Aggregate cashflow totals for a window.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**sumIncome** | **number** |  | [optional] [default to undefined]
**sumExpense** | **number** | Signed (negative). | [optional] [default to undefined]
**savings** | **number** |  | [optional] [default to undefined]
**savingsRate** | **number** |  | [optional] [default to undefined]

## Example

```typescript
import { CashflowSummary } from 'monarch-bridge-client';

const instance: CashflowSummary = {
    sumIncome,
    sumExpense,
    savings,
    savingsRate,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
