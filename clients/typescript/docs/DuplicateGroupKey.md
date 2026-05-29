# DuplicateGroupKey

Tuple identifying one duplicate group. Composite key over `(date, amount, plaidName, accountId)` per the python lib\'s `find_duplicate_transactions` semantics. Any field can be null when the source transaction omits it; null values still group together. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**date** | **string** |  | [optional] [default to undefined]
**amount** | **number** | Signed. | [optional] [default to undefined]
**accountId** | **string** |  | [optional] [default to undefined]
**plaidName** | **string** | Raw Plaid description string. Distinguishes true double-inserts (identical plaidName) from coincidental same-day same-amount same-merchant charges (different plaidName).  | [optional] [default to undefined]

## Example

```typescript
import { DuplicateGroupKey } from 'monarch-bridge-client';

const instance: DuplicateGroupKey = {
    date,
    amount,
    accountId,
    plaidName,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
