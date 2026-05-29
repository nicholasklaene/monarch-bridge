# GetAccountHistoryResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**account** | [**Account**](Account.md) |  | [optional] [default to undefined]
**recentTransactions** | [**Array&lt;Transaction&gt;**](Transaction.md) |  | [default to undefined]
**snapshots** | [**Array&lt;AccountSnapshot&gt;**](AccountSnapshot.md) |  | [default to undefined]

## Example

```typescript
import { GetAccountHistoryResponseData } from 'monarch-bridge-client';

const instance: GetAccountHistoryResponseData = {
    account,
    recentTransactions,
    snapshots,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
