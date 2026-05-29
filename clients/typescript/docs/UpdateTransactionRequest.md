# UpdateTransactionRequest

Partial update - send only the fields you want to change. Path `{id}` is injected into the GraphQL input by the proxy. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**category** | **string** | New categoryId. | [optional] [default to undefined]
**merchantName** | **string** | New merchant display name. | [optional] [default to undefined]
**amount** | **number** |  | [optional] [default to undefined]
**date** | **string** |  | [optional] [default to undefined]
**notes** | **string** |  | [optional] [default to undefined]
**hideFromReports** | **boolean** |  | [optional] [default to undefined]
**needsReview** | **boolean** |  | [optional] [default to undefined]
**reviewed** | **boolean** |  | [optional] [default to undefined]
**goalId** | **string** |  | [optional] [default to undefined]

## Example

```typescript
import { UpdateTransactionRequest } from 'monarch-bridge-client';

const instance: UpdateTransactionRequest = {
    category,
    merchantName,
    amount,
    date,
    notes,
    hideFromReports,
    needsReview,
    reviewed,
    goalId,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
