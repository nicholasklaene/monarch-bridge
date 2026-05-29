# BulkDeleteTransactionsRequest

Body for `POST /v1/transactions/bulk-delete`. Mirrors Monarch\'s `bulkDeleteTransactions` mutation variables. Two selection modes:  - **Explicit** (`allSelected: false`, default): `selectedTransactionIds`   lists exactly which rows to delete. - **Filter-based** (`allSelected: true`): every row matching `filters` is   deleted, minus the optional `excludedTransactionIds` set.  `expectedAffectedTransactionCount` is required as a safety guard. Pass the number of rows you believe will be affected. Monarch rejects the mutation if the actual count differs (race-prevention). 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**selectedTransactionIds** | **Array&lt;string&gt;** | Ids to delete (explicit mode). Ignored when &#x60;allSelected: true&#x60;. | [optional] [default to undefined]
**excludedTransactionIds** | **Array&lt;string&gt;** | Ids to skip (filter mode). Ignored when &#x60;allSelected: false&#x60;. | [optional] [default to undefined]
**allSelected** | **boolean** | Switch between explicit (false) and filter (true) selection. | [optional] [default to false]
**expectedAffectedTransactionCount** | **number** | Safety check. Monarch refuses if actual affected count differs. | [default to undefined]
**filters** | [**BulkTransactionFilters**](BulkTransactionFilters.md) |  | [optional] [default to undefined]

## Example

```typescript
import { BulkDeleteTransactionsRequest } from 'monarch-bridge-client';

const instance: BulkDeleteTransactionsRequest = {
    selectedTransactionIds,
    excludedTransactionIds,
    allSelected,
    expectedAffectedTransactionCount,
    filters,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
