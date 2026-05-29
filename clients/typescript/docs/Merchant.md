# Merchant

A Monarch merchant. The optional `logoUrl`, `ruleCount`, `canBeDeleted`, `hasActiveRecurringStreams`, and `recurringTransactionStream` are populated by the detail-read variant (`Common_GetEditMerchant`); the search variants only fill `id`, `name`, `transactionCount`, and (with logos) `logoUrl`. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **string** |  | [default to undefined]
**name** | **string** |  | [default to undefined]
**logoUrl** | **string** |  | [optional] [default to undefined]
**transactionCount** | **number** |  | [optional] [default to undefined]
**ruleCount** | **number** |  | [optional] [default to undefined]
**canBeDeleted** | **boolean** |  | [optional] [default to undefined]
**hasActiveRecurringStreams** | **boolean** |  | [optional] [default to undefined]
**recurringTransactionStream** | [**MerchantRecurringStream**](MerchantRecurringStream.md) |  | [optional] [default to undefined]

## Example

```typescript
import { Merchant } from 'monarch-bridge-client';

const instance: Merchant = {
    id,
    name,
    logoUrl,
    transactionCount,
    ruleCount,
    canBeDeleted,
    hasActiveRecurringStreams,
    recurringTransactionStream,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
