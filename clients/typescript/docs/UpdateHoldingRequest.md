# UpdateHoldingRequest

Body for `PATCH /v1/holdings/{id}`. All fields optional; only non-null fields are forwarded to Monarch. Pass `userCostBasis` to override the data-provider basis for display purposes (stored separately from any synced basis). 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**quantity** | **number** |  | [optional] [default to undefined]
**securityType** | **string** | Monarch security type string (e.g. &#x60;equity&#x60;, &#x60;etf&#x60;, &#x60;cryptocurrency&#x60;). | [optional] [default to undefined]
**userCostBasis** | **number** | User-provided cost basis. Stored separately from the data-provider value. | [optional] [default to undefined]

## Example

```typescript
import { UpdateHoldingRequest } from 'monarch-bridge-client';

const instance: UpdateHoldingRequest = {
    quantity,
    securityType,
    userCostBasis,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
