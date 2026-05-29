# TaxLot

One manual cost-basis tax lot under a holding. `acquisitionQuantity` / `costBasisPerUnit` express the per-share cost basis at acquisition. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **string** |  | [default to undefined]
**createdAt** | **string** |  | [optional] [default to undefined]
**acquisitionDate** | **string** |  | [optional] [default to undefined]
**acquisitionQuantity** | **number** |  | [optional] [default to undefined]
**costBasisPerUnit** | **number** |  | [optional] [default to undefined]

## Example

```typescript
import { TaxLot } from 'monarch-bridge-client';

const instance: TaxLot = {
    id,
    createdAt,
    acquisitionDate,
    acquisitionQuantity,
    costBasisPerUnit,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
