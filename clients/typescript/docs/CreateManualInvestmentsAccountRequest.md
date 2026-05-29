# CreateManualInvestmentsAccountRequest

Body for `POST /v1/accounts/manual-investments`. Two tracking methods:    - `balances` - single account-level balance (set via `initialBalance`).   - `holdings` - per-security positions (seed via `initialHoldings`).  `trackingMethod` is optional; if omitted Monarch infers from which seed field is present. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **string** |  | [default to undefined]
**subtype** | **string** | Account subtype string (e.g. &#x60;401k&#x60;, &#x60;ira&#x60;, &#x60;brokerage&#x60;). | [default to undefined]
**trackingMethod** | **string** | One of &#x60;balances&#x60;, &#x60;holdings&#x60;. Maps to Monarch\&#39;s &#x60;manualInvestmentsTrackingMethod&#x60;. | [optional] [default to undefined]
**initialBalance** | **number** | Seed balance for balance-tracked accounts. | [optional] [default to undefined]
**initialHoldings** | [**Array&lt;InitialHoldingInput&gt;**](InitialHoldingInput.md) | Seed holdings for holdings-tracked accounts. | [optional] [default to undefined]

## Example

```typescript
import { CreateManualInvestmentsAccountRequest } from 'monarch-bridge-client';

const instance: CreateManualInvestmentsAccountRequest = {
    name,
    subtype,
    trackingMethod,
    initialBalance,
    initialHoldings,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
