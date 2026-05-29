# CreateManualAccountRequest

Body for `POST /v1/accounts`. See `GET /v1/account-type-options` for valid type/subtype pairs.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**type** | **string** |  | [default to undefined]
**subtype** | **string** |  | [default to undefined]
**name** | **string** |  | [default to undefined]
**displayBalance** | **number** |  | [optional] [default to 0.0]
**includeInNetWorth** | **boolean** |  | [optional] [default to true]

## Example

```typescript
import { CreateManualAccountRequest } from 'monarch-bridge-client';

const instance: CreateManualAccountRequest = {
    type,
    subtype,
    name,
    displayBalance,
    includeInNetWorth,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
