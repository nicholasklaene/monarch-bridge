# TransactionRuleAmountCriterion

Match transactions whose signed amount satisfies the operator/value pair.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**operator** | **string** | One of &#x60;equals&#x60;, &#x60;not_equals&#x60;, &#x60;greater_than&#x60;, &#x60;less_than&#x60;, &#x60;between&#x60;. Forwarded verbatim. | [optional] [default to undefined]
**isExpense** | **boolean** | When true, scope the comparison to expenses (negative amounts) only. | [optional] [default to undefined]
**value** | **number** |  | [optional] [default to undefined]
**valueRange** | [**TransactionRuleAmountRange**](TransactionRuleAmountRange.md) |  | [optional] [default to undefined]

## Example

```typescript
import { TransactionRuleAmountCriterion } from 'monarch-bridge-client';

const instance: TransactionRuleAmountCriterion = {
    operator,
    isExpense,
    value,
    valueRange,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
