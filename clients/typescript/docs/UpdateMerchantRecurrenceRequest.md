# UpdateMerchantRecurrenceRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **string** | Required by Monarch - pass current name if not changing. | [default to undefined]
**isRecurring** | **boolean** |  | [optional] [default to undefined]
**frequency** | **string** |  | [optional] [default to undefined]
**baseDate** | **string** |  | [optional] [default to undefined]
**amount** | **number** |  | [optional] [default to undefined]
**isActive** | **boolean** |  | [optional] [default to undefined]

## Example

```typescript
import { UpdateMerchantRecurrenceRequest } from 'monarch-bridge-client';

const instance: UpdateMerchantRecurrenceRequest = {
    name,
    isRecurring,
    frequency,
    baseDate,
    amount,
    isActive,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
