# BulkUpdateHoldingsEntry

One row in a bulk-update holdings payload.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**holdingId** | **string** |  | [default to undefined]
**quantity** | **number** |  | [optional] [default to undefined]
**costBasis** | **number** |  | [optional] [default to undefined]

## Example

```typescript
import { BulkUpdateHoldingsEntry } from 'monarch-bridge-client';

const instance: BulkUpdateHoldingsEntry = {
    holdingId,
    quantity,
    costBasis,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
