# BulkTransactionUpdates

Subset of Monarch\'s `TransactionUpdateParams` write-side input shape. Same field set as `PATCH /v1/transactions/{id}` plus the bulk-only `tags` overwrite list. All fields are optional. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**categoryId** | **string** |  | [optional] [default to undefined]
**merchantName** | **string** |  | [optional] [default to undefined]
**date** | **string** |  | [optional] [default to undefined]
**notes** | **string** |  | [optional] [default to undefined]
**hide** | **boolean** |  | [optional] [default to undefined]
**isRecurring** | **boolean** |  | [optional] [default to undefined]
**reviewStatus** | **string** |  | [optional] [default to undefined]
**goalId** | **string** |  | [optional] [default to undefined]
**needsReviewByUserId** | **string** |  | [optional] [default to undefined]
**ownerUserId** | **string** |  | [optional] [default to undefined]
**businessEntityId** | **string** |  | [optional] [default to undefined]
**isLinkedToPaydownBudget** | **boolean** |  | [optional] [default to undefined]
**tags** | **Array&lt;string&gt;** | Tag id list (overwrite). Omit to leave existing tags untouched. | [optional] [default to undefined]

## Example

```typescript
import { BulkTransactionUpdates } from 'monarch-bridge-client';

const instance: BulkTransactionUpdates = {
    categoryId,
    merchantName,
    date,
    notes,
    hide,
    isRecurring,
    reviewStatus,
    goalId,
    needsReviewByUserId,
    ownerUserId,
    businessEntityId,
    isLinkedToPaydownBudget,
    tags,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
