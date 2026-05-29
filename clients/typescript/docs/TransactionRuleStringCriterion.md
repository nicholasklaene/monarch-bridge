# TransactionRuleStringCriterion

One operator-value pair for a text criterion (merchant / original-statement / merchant-name).

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**operator** | **string** | Comparison operator (e.g. &#x60;equals&#x60;, &#x60;contains&#x60;, &#x60;starts_with&#x60;, &#x60;ends_with&#x60;). Forwarded verbatim. | [optional] [default to undefined]
**value** | **string** |  | [optional] [default to undefined]

## Example

```typescript
import { TransactionRuleStringCriterion } from 'monarch-bridge-client';

const instance: TransactionRuleStringCriterion = {
    operator,
    value,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
