# TransactionAuditEntry


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **string** |  | [default to undefined]
**timestamp** | **string** |  | [optional] [default to undefined]
**actor** | **string** |  | [optional] [default to undefined]
**action** | **string** |  | [optional] [default to undefined]
**field** | **string** |  | [optional] [default to undefined]
**oldValue** | **string** |  | [optional] [default to undefined]
**newValue** | **string** |  | [optional] [default to undefined]

## Example

```typescript
import { TransactionAuditEntry } from 'monarch-bridge-client';

const instance: TransactionAuditEntry = {
    id,
    timestamp,
    actor,
    action,
    field,
    oldValue,
    newValue,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
