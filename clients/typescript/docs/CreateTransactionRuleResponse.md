# CreateTransactionRuleResponse

Monarch\'s create mutation only returns errors (no rule body). On success we surface a `created: true` flag. To inspect the persisted rule, refetch the list with `GET /v1/transaction-rules`. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**CreateTransactionRuleResponseData**](CreateTransactionRuleResponseData.md) |  | [default to undefined]

## Example

```typescript
import { CreateTransactionRuleResponse } from 'monarch-bridge-client';

const instance: CreateTransactionRuleResponse = {
    data,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
