# BulkTransactionFilters

Subset of Monarch\'s `TransactionFilterInput` accepted by the bulk-transaction mutations. Mirrors the read-side filter shape (search + id lists + nullable booleans) but is passed through verbatim to Monarch on writes. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**startDate** | **string** |  | [optional] [default to undefined]
**endDate** | **string** |  | [optional] [default to undefined]
**search** | **string** |  | [optional] [default to undefined]
**categories** | **Array&lt;string&gt;** |  | [optional] [default to undefined]
**accounts** | **Array&lt;string&gt;** |  | [optional] [default to undefined]
**tags** | **Array&lt;string&gt;** |  | [optional] [default to undefined]
**hasAttachments** | **boolean** |  | [optional] [default to undefined]
**hasNotes** | **boolean** |  | [optional] [default to undefined]
**hideFromReports** | **boolean** |  | [optional] [default to undefined]
**isSplit** | **boolean** |  | [optional] [default to undefined]
**isRecurring** | **boolean** |  | [optional] [default to undefined]
**importedFromMint** | **boolean** |  | [optional] [default to undefined]
**syncedFromInstitution** | **boolean** |  | [optional] [default to undefined]
**needsReview** | **boolean** |  | [optional] [default to undefined]
**transactionVisibility** | **string** |  | [optional] [default to undefined]

## Example

```typescript
import { BulkTransactionFilters } from 'monarch-bridge-client';

const instance: BulkTransactionFilters = {
    startDate,
    endDate,
    search,
    categories,
    accounts,
    tags,
    hasAttachments,
    hasNotes,
    hideFromReports,
    isSplit,
    isRecurring,
    importedFromMint,
    syncedFromInstitution,
    needsReview,
    transactionVisibility,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
