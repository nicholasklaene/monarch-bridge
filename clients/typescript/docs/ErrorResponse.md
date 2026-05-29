# ErrorResponse

Uniform error shape for every non-2xx response. `code` is one of the canonical machine-readable values (`invalid_input`, `invalid_param`, `session_missing`, `session_expired`, `rate_limited`, `monarch_request_failed`, `payload_error`, `not_found`, `internal_error`) OR - when forwarded from a Monarch PayloadError - the upstream error code verbatim. Modeled as `string` to keep the forwarded case open-ended. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**code** | **string** | Stable machine-readable error code. | [default to undefined]
**message** | **string** | Human-readable explanation. | [default to undefined]
**details** | **{ [key: string]: any; }** | Free-form structured detail (field errors, upstream payload error, etc.). | [optional] [default to undefined]

## Example

```typescript
import { ErrorResponse } from 'monarch-bridge-client';

const instance: ErrorResponse = {
    code,
    message,
    details,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
