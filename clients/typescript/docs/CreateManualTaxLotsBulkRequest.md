# CreateManualTaxLotsBulkRequest

Account id comes from the URL path. Each tax lot row carries its own `holdingId`. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**taxLots** | [**Array&lt;BulkTaxLotInput&gt;**](BulkTaxLotInput.md) |  | [default to undefined]

## Example

```typescript
import { CreateManualTaxLotsBulkRequest } from 'monarch-bridge-client';

const instance: CreateManualTaxLotsBulkRequest = {
    taxLots,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
