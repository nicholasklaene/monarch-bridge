# LongTailRequest

Generic request body for `/v1/x/_*` long-tail endpoints. Pass operation variables under `variables`; the proxy forwards them verbatim to Monarch as the GraphQL `variables` map. Omit for operations that take no input. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**variables** | **{ [key: string]: any; }** | GraphQL variables map for the wrapped operation. | [optional] [default to undefined]

## Example

```typescript
import { LongTailRequest } from 'monarch-bridge-client';

const instance: LongTailRequest = {
    variables,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
