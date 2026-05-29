# GetAuthStatusResponse

Body of `GET /v1/auth/status` and `POST /v1/auth/refresh`. Not data-wrapped.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**authenticated** | **boolean** |  | [default to undefined]
**email** | **string** |  | [optional] [default to undefined]
**lastVerifiedAt** | **string** |  | [optional] [default to undefined]

## Example

```typescript
import { GetAuthStatusResponse } from 'monarch-bridge-client';

const instance: GetAuthStatusResponse = {
    authenticated,
    email,
    lastVerifiedAt,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
