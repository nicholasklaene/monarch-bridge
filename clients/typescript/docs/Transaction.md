# Transaction

A Monarch transaction.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **string** |  | [default to undefined]
**date** | **string** |  | [default to undefined]
**amount** | **number** | Signed. Negative &#x3D; expense, positive &#x3D; income. | [default to undefined]
**pending** | **boolean** |  | [optional] [default to undefined]
**plaidName** | **string** |  | [optional] [default to undefined]
**notes** | **string** |  | [optional] [default to undefined]
**hideFromReports** | **boolean** |  | [optional] [default to undefined]
**needsReview** | **boolean** |  | [optional] [default to undefined]
**isRecurring** | **boolean** |  | [optional] [default to undefined]
**isSplitTransaction** | **boolean** |  | [optional] [default to undefined]
**createdAt** | **string** |  | [optional] [default to undefined]
**updatedAt** | **string** |  | [optional] [default to undefined]
**account** | [**TransactionAccountRef**](TransactionAccountRef.md) |  | [optional] [default to undefined]
**merchant** | [**MerchantRef**](MerchantRef.md) |  | [optional] [default to undefined]
**category** | [**Ref**](Ref.md) |  | [optional] [default to undefined]
**tags** | [**Array&lt;TagRef&gt;**](TagRef.md) |  | [optional] [default to undefined]

## Example

```typescript
import { Transaction } from 'monarch-bridge-client';

const instance: Transaction = {
    id,
    date,
    amount,
    pending,
    plaidName,
    notes,
    hideFromReports,
    needsReview,
    isRecurring,
    isSplitTransaction,
    createdAt,
    updatedAt,
    account,
    merchant,
    category,
    tags,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
