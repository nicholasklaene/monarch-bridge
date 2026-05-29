# GetCashflowEntitiesResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**byCategory** | [**Array&lt;CashflowEntityCategoryRow&gt;**](CashflowEntityCategoryRow.md) |  | [default to undefined]
**byCategoryGroup** | [**Array&lt;CashflowCategoryGroupRow&gt;**](CashflowCategoryGroupRow.md) |  | [default to undefined]
**byMerchant** | [**Array&lt;CashflowMerchantRow&gt;**](CashflowMerchantRow.md) |  | [default to undefined]
**summary** | [**CashflowSummary**](CashflowSummary.md) |  | [optional] [default to undefined]

## Example

```typescript
import { GetCashflowEntitiesResponseData } from 'monarch-bridge-client';

const instance: GetCashflowEntitiesResponseData = {
    byCategory,
    byCategoryGroup,
    byMerchant,
    summary,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
