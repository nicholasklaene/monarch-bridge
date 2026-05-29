# TransactionRuleSplitAction

Auto-split action. Break the matched transaction into N children by amount or percentage.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**amountType** | **string** | One of &#x60;ABSOLUTE&#x60;, &#x60;PERCENTAGE&#x60;. Drives interpretation of each &#x60;splitsInfo[].amount&#x60;. | [optional] [default to undefined]
**splitsInfo** | [**Array&lt;TransactionRuleSplitInfo&gt;**](TransactionRuleSplitInfo.md) |  | [optional] [default to undefined]

## Example

```typescript
import { TransactionRuleSplitAction } from 'monarch-bridge-client';

const instance: TransactionRuleSplitAction = {
    amountType,
    splitsInfo,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
