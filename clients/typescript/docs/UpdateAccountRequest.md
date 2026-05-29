# UpdateAccountRequest

Partial update - send only changing fields. Path `{id}` is injected.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **string** |  | [optional] [default to undefined]
**displayBalance** | **number** |  | [optional] [default to undefined]
**type** | **string** |  | [optional] [default to undefined]
**subtype** | **string** |  | [optional] [default to undefined]
**hideFromList** | **boolean** |  | [optional] [default to undefined]
**includeInNetWorth** | **boolean** |  | [optional] [default to undefined]
**hideTransactionsFromReports** | **boolean** |  | [optional] [default to undefined]

## Example

```typescript
import { UpdateAccountRequest } from 'monarch-bridge-client';

const instance: UpdateAccountRequest = {
    name,
    displayBalance,
    type,
    subtype,
    hideFromList,
    includeInNetWorth,
    hideTransactionsFromReports,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
