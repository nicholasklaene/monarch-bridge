# BulkUpdateAccountsRequest

Body for `PATCH /v1/accounts/bulk`. Each entry in `updates` is one `UpdateAccountsMutationInput`: `id` plus any subset of the patchable fields. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**updates** | [**Array&lt;BulkUpdateAccountsEntry&gt;**](BulkUpdateAccountsEntry.md) |  | [default to undefined]

## Example

```typescript
import { BulkUpdateAccountsRequest } from 'monarch-bridge-client';

const instance: BulkUpdateAccountsRequest = {
    updates,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
