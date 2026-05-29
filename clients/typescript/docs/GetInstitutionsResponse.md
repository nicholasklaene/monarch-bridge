# GetInstitutionsResponse

Linked institution credentials + their accounts + the subscription summary. `credentials` and `accounts` are upstream free-form; clients should iterate by name. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetInstitutionsResponseData**](GetInstitutionsResponseData.md) |  | [default to undefined]

## Example

```typescript
import { GetInstitutionsResponse } from 'monarch-bridge-client';

const instance: GetInstitutionsResponse = {
    data,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
