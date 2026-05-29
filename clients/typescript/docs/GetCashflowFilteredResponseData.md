# GetCashflowFilteredResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**summary** | [**CashflowSummary**](CashflowSummary.md) |  | [optional] [default to undefined]
**byYear** | [**Array&lt;CashflowTimeframeBucket&gt;**](CashflowTimeframeBucket.md) |  | [optional] [default to undefined]
**byMonth** | [**Array&lt;CashflowTimeframeBucket&gt;**](CashflowTimeframeBucket.md) |  | [optional] [default to undefined]
**byQuarter** | [**Array&lt;CashflowTimeframeBucket&gt;**](CashflowTimeframeBucket.md) |  | [optional] [default to undefined]
**byCategory** | [**Array&lt;CashflowEntityCategoryRow&gt;**](CashflowEntityCategoryRow.md) |  | [optional] [default to undefined]
**byCategoryGroup** | [**Array&lt;CashflowCategoryGroupRow&gt;**](CashflowCategoryGroupRow.md) |  | [optional] [default to undefined]
**byMerchant** | [**Array&lt;CashflowMerchantRow&gt;**](CashflowMerchantRow.md) |  | [optional] [default to undefined]

## Example

```typescript
import { GetCashflowFilteredResponseData } from 'monarch-bridge-client';

const instance: GetCashflowFilteredResponseData = {
    summary,
    byYear,
    byMonth,
    byQuarter,
    byCategory,
    byCategoryGroup,
    byMerchant,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
