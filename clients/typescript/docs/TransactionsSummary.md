# TransactionsSummary

Aggregate stats across a transaction window.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**count** | **number** |  | [optional] [default to undefined]
**sum** | **number** |  | [optional] [default to undefined]
**avg** | **number** |  | [optional] [default to undefined]
**min** | **number** |  | [optional] [default to undefined]
**max** | **number** |  | [optional] [default to undefined]
**first** | **string** |  | [optional] [default to undefined]
**last** | **string** |  | [optional] [default to undefined]

## Example

```typescript
import { TransactionsSummary } from 'monarch-bridge-client';

const instance: TransactionsSummary = {
    count,
    sum,
    avg,
    min,
    max,
    first,
    last,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
