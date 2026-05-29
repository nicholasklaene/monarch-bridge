# MerchantRecurringStream

Recurring-transaction stream associated with a merchant; null when none.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **string** |  | [optional] [default to undefined]
**frequency** | **string** |  | [optional] [default to undefined]
**amount** | **number** |  | [optional] [default to undefined]
**baseDate** | **string** | ISO date &#x60;YYYY-MM-DD&#x60;. | [optional] [default to undefined]
**isActive** | **boolean** |  | [optional] [default to undefined]

## Example

```typescript
import { MerchantRecurringStream } from 'monarch-bridge-client';

const instance: MerchantRecurringStream = {
    id,
    frequency,
    amount,
    baseDate,
    isActive,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
