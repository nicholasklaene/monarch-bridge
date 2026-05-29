# BulkUpdateAccountsEntry

One entry in `BulkUpdateAccountsRequest.updates`. `id` is required; other fields are optional and only non-null fields are forwarded to Monarch. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **string** |  | [default to undefined]
**name** | **string** |  | [optional] [default to undefined]
**displayBalance** | **number** |  | [optional] [default to undefined]
**type** | **string** |  | [optional] [default to undefined]
**subtype** | **string** |  | [optional] [default to undefined]
**includeInNetWorth** | **boolean** |  | [optional] [default to undefined]
**hideFromList** | **boolean** |  | [optional] [default to undefined]
**hideTransactionsFromReports** | **boolean** |  | [optional] [default to undefined]
**excludeFromDebtPaydown** | **boolean** |  | [optional] [default to undefined]
**includeInGoalBalance** | **boolean** |  | [optional] [default to undefined]
**invertSyncedBalance** | **boolean** |  | [optional] [default to undefined]
**currentBalance** | **number** |  | [optional] [default to undefined]
**apr** | **number** |  | [optional] [default to undefined]
**interestRate** | **number** |  | [optional] [default to undefined]
**limit** | **number** |  | [optional] [default to undefined]
**minimumPayment** | **number** |  | [optional] [default to undefined]
**plannedPayment** | **number** |  | [optional] [default to undefined]
**useAvailableBalance** | **boolean** |  | [optional] [default to undefined]

## Example

```typescript
import { BulkUpdateAccountsEntry } from 'monarch-bridge-client';

const instance: BulkUpdateAccountsEntry = {
    id,
    name,
    displayBalance,
    type,
    subtype,
    includeInNetWorth,
    hideFromList,
    hideTransactionsFromReports,
    excludeFromDebtPaydown,
    includeInGoalBalance,
    invertSyncedBalance,
    currentBalance,
    apr,
    interestRate,
    limit,
    minimumPayment,
    plannedPayment,
    useAvailableBalance,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
