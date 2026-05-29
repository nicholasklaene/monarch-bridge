# WebScreenAggregateRequest

Body shape for every `/v1/web/_*` screen-aggregate endpoint. `variables` is forwarded as-is to Monarch\'s GraphQL endpoint as the operation\'s `variables` map. Omit the body or send `{}` for ops that take no vars. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**variables** | **{ [key: string]: any; }** | Free-form pass-through from upstream Monarch. Shape is documented per-endpoint; treat as a typed &#x60;Map&lt;String, Any?&gt;&#x60;. Use this for portions of the response we intentionally leave untyped because the upstream tree is too deep/volatile to model.  | [optional] [default to undefined]

## Example

```typescript
import { WebScreenAggregateRequest } from 'monarch-bridge-client';

const instance: WebScreenAggregateRequest = {
    variables,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
