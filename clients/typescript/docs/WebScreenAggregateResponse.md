# WebScreenAggregateResponse

Envelope for every `/v1/web/_*` screen-aggregate endpoint. `data` is the raw Monarch GraphQL response tree as a FreeForm map; the proxy does not type the deep shape because web-bundle aggregates churn per release. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | **{ [key: string]: any; }** | Free-form pass-through from upstream Monarch. Shape is documented per-endpoint; treat as a typed &#x60;Map&lt;String, Any?&gt;&#x60;. Use this for portions of the response we intentionally leave untyped because the upstream tree is too deep/volatile to model.  | [default to undefined]

## Example

```typescript
import { WebScreenAggregateResponse } from 'monarch-bridge-client';

const instance: WebScreenAggregateResponse = {
    data,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
