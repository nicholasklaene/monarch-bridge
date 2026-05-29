# HealthResponse

Body of `GET /healthz`. Self-contained - not wrapped in a `data` envelope so health checks stay zero-parse.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**status** | **string** |  | [default to undefined]
**authenticated** | **boolean** | Whether a Monarch session is currently loaded. | [default to undefined]
**lastVerifiedAt** | **string** | Last time the loaded session was confirmed valid against Monarch. | [optional] [default to undefined]

## Example

```typescript
import { HealthResponse } from 'monarch-bridge-client';

const instance: HealthResponse = {
    status,
    authenticated,
    lastVerifiedAt,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
