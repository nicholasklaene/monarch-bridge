# MarkTransactionAsReviewedResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **string** |  | [default to undefined]
**reviewedAt** | **string** | ISO timestamp when Monarch flipped the review flag. | [optional] [default to undefined]
**needsReview** | **boolean** |  | [default to undefined]

## Example

```typescript
import { MarkTransactionAsReviewedResponseData } from 'monarch-bridge-client';

const instance: MarkTransactionAsReviewedResponseData = {
    id,
    reviewedAt,
    needsReview,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
