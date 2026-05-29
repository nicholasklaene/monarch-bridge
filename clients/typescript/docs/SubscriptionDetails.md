# SubscriptionDetails

Monarch subscription tier + payment source.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **string** |  | [optional] [default to undefined]
**paymentSource** | **string** |  | [optional] [default to undefined]
**referralCode** | **string** |  | [optional] [default to undefined]
**isOnFreeTrial** | **boolean** |  | [default to undefined]
**hasPremiumEntitlement** | **boolean** |  | [default to undefined]

## Example

```typescript
import { SubscriptionDetails } from 'monarch-bridge-client';

const instance: SubscriptionDetails = {
    id,
    paymentSource,
    referralCode,
    isOnFreeTrial,
    hasPremiumEntitlement,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
