# UploadAccountBalanceHistory202ResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**sessionKey** | **string** | Use to poll &#x60;GET /v1/balance-history/{sessionKey}/status&#x60;. | [default to undefined]
**status** | **string** | Current parse status (&#x60;pending&#x60;, &#x60;processing&#x60;, &#x60;completed&#x60;, &#x60;failed&#x60;). | [default to undefined]

## Example

```typescript
import { UploadAccountBalanceHistory202ResponseData } from 'monarch-bridge-client';

const instance: UploadAccountBalanceHistory202ResponseData = {
    sessionKey,
    status,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
