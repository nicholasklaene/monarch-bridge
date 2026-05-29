# SubscriptionInvoice

One billing-history row from Monarch\'s subscription system.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **string** |  | [default to undefined]
**date** | **string** |  | [optional] [default to undefined]
**amount** | **number** |  | [optional] [default to undefined]
**status** | **string** | &#x60;paid&#x60;, &#x60;pending&#x60;, &#x60;failed&#x60;, &#x60;refunded&#x60;. | [optional] [default to undefined]
**pdfUrl** | **string** |  | [optional] [default to undefined]
**periodStart** | **string** |  | [optional] [default to undefined]
**periodEnd** | **string** |  | [optional] [default to undefined]

## Example

```typescript
import { SubscriptionInvoice } from 'monarch-bridge-client';

const instance: SubscriptionInvoice = {
    id,
    date,
    amount,
    status,
    pdfUrl,
    periodStart,
    periodEnd,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
