# BulkUpdateTransactionsRequest

Body for `PATCH /v1/transactions/bulk`. Mirrors Monarch\'s `bulkUpdateTransactions` mutation variables; see `BulkDeleteTransactionsRequest` for the selection-mode semantics.  `updates` is Monarch\'s `TransactionUpdateParams` shape. Only non-null fields are forwarded; pass an empty object to no-op (Monarch will reject if zero fields). 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**selectedTransactionIds** | **Array&lt;string&gt;** | Ids to patch (explicit mode). Ignored when &#x60;allSelected: true&#x60;. | [optional] [default to undefined]
**excludedTransactionIds** | **Array&lt;string&gt;** | Ids to skip (filter mode). Ignored when &#x60;allSelected: false&#x60;. | [optional] [default to undefined]
**allSelected** | **boolean** | Switch between explicit (false) and filter (true) selection. | [optional] [default to false]
**expectedAffectedTransactionCount** | **number** | Safety check. Monarch refuses if actual affected count differs. | [default to undefined]
**updates** | [**BulkTransactionUpdates**](BulkTransactionUpdates.md) |  | [default to undefined]
**filters** | [**BulkTransactionFilters**](BulkTransactionFilters.md) |  | [optional] [default to undefined]

## Example

```typescript
import { BulkUpdateTransactionsRequest } from 'monarch-bridge-client';

const instance: BulkUpdateTransactionsRequest = {
    selectedTransactionIds,
    excludedTransactionIds,
    allSelected,
    expectedAffectedTransactionCount,
    updates,
    filters,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
