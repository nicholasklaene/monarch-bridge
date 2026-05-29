# UpdateCookiePreferencesRequest

Patch any subset of cookie consents. Omit a field to leave it untouched.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**analytics** | **boolean** |  | [optional] [default to undefined]
**marketing** | **boolean** |  | [optional] [default to undefined]
**functional** | **boolean** |  | [optional] [default to undefined]

## Example

```typescript
import { UpdateCookiePreferencesRequest } from 'monarch-bridge-client';

const instance: UpdateCookiePreferencesRequest = {
    analytics,
    marketing,
    functional,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
