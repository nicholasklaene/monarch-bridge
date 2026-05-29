# IntegrationStatus

Per-credential provider health row.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**credentialId** | **string** |  | [default to undefined]
**institutionName** | **string** |  | [optional] [default to undefined]
**provider** | **string** | &#x60;plaid&#x60;, &#x60;mx&#x60;, &#x60;finicity&#x60;, &#x60;manual&#x60;. | [optional] [default to undefined]
**status** | **string** | &#x60;connected&#x60;, &#x60;syncing&#x60;, &#x60;error&#x60;, &#x60;disconnected&#x60;. | [optional] [default to undefined]
**lastSyncedAt** | **string** |  | [optional] [default to undefined]
**errorCode** | **string** |  | [optional] [default to undefined]
**errorMessage** | **string** |  | [optional] [default to undefined]
**needsReauth** | **boolean** |  | [optional] [default to undefined]

## Example

```typescript
import { IntegrationStatus } from 'monarch-bridge-client';

const instance: IntegrationStatus = {
    credentialId,
    institutionName,
    provider,
    status,
    lastSyncedAt,
    errorCode,
    errorMessage,
    needsReauth,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
