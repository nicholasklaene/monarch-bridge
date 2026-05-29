# MarkAsRecurringRequest

Tell Monarch a transaction IS the start of a recurring stream. `frequency` is one of `monthly`, `weekly`, `quarterly`, `yearly`. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**frequency** | **string** |  | [default to undefined]

## Example

```typescript
import { MarkAsRecurringRequest } from 'monarch-bridge-client';

const instance: MarkAsRecurringRequest = {
    frequency,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
