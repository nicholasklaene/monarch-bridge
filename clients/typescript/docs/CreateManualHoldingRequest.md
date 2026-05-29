# CreateManualHoldingRequest

Body for `POST /v1/account/{id}/holdings`. `securityId` comes from `GET /v1/securities/search`; `quantity` is the number of shares/units. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**securityId** | **string** | Monarch security id (resolve via securities search). | [default to undefined]
**quantity** | **number** | Number of shares/units to record. | [default to undefined]

## Example

```typescript
import { CreateManualHoldingRequest } from 'monarch-bridge-client';

const instance: CreateManualHoldingRequest = {
    securityId,
    quantity,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
