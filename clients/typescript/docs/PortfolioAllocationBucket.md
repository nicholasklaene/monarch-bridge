# PortfolioAllocationBucket

One row in a portfolio allocation breakdown.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**type** | **string** | Bucket key (security type, account id, etc.). | [default to undefined]
**typeDisplay** | **string** |  | [optional] [default to undefined]
**allocationPercent** | **number** |  | [default to undefined]
**totalValue** | **number** |  | [default to undefined]

## Example

```typescript
import { PortfolioAllocationBucket } from 'monarch-bridge-client';

const instance: PortfolioAllocationBucket = {
    type,
    typeDisplay,
    allocationPercent,
    totalValue,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
