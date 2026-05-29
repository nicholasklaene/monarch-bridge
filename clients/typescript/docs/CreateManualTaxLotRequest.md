# CreateManualTaxLotRequest

Holding id comes from the URL path. The account id is derived server-side from the holding. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accountId** | **string** | Optional override for the account id. If absent the bridge does not forward it (Monarch errors if missing, clients should normally pass it).  | [optional] [default to undefined]
**acquisitionDate** | **string** |  | [default to undefined]
**acquisitionQuantity** | **number** |  | [default to undefined]
**costBasisPerUnit** | **number** |  | [default to undefined]

## Example

```typescript
import { CreateManualTaxLotRequest } from 'monarch-bridge-client';

const instance: CreateManualTaxLotRequest = {
    accountId,
    acquisitionDate,
    acquisitionQuantity,
    costBasisPerUnit,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
