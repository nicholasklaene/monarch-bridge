# Account

A Monarch account - either Plaid-linked or manually-created.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **string** | Stable Monarch account id. | [default to undefined]
**displayName** | **string** |  | [default to undefined]
**type** | **string** | Top-level account type (e.g. &#x60;depository&#x60;, &#x60;brokerage&#x60;, &#x60;credit&#x60;). | [optional] [default to undefined]
**subtype** | **string** | Subtype within the type (e.g. &#x60;savings&#x60;, &#x60;401k&#x60;). | [optional] [default to undefined]
**mask** | **string** |  | [optional] [default to undefined]
**currentBalance** | **number** | Last-known balance in account currency. May be negative for credit/loan. | [optional] [default to undefined]
**displayBalance** | **number** |  | [optional] [default to undefined]
**isHidden** | **boolean** | Monarch\&#39;s legacy hidden flag. | [optional] [default to undefined]
**hideFromList** | **boolean** | True if the user has hidden this account from the main list. | [optional] [default to undefined]
**includeInNetWorth** | **boolean** |  | [optional] [default to undefined]
**isAsset** | **boolean** |  | [optional] [default to undefined]
**isManual** | **boolean** | True for manually-created (non-Plaid) accounts. | [optional] [default to undefined]
**institution** | [**Institution**](Institution.md) |  | [optional] [default to undefined]

## Example

```typescript
import { Account } from 'monarch-bridge-client';

const instance: Account = {
    id,
    displayName,
    type,
    subtype,
    mask,
    currentBalance,
    displayBalance,
    isHidden,
    hideFromList,
    includeInNetWorth,
    isAsset,
    isManual,
    institution,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
