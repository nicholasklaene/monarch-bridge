# GetTransactionDetailResponseData

`transaction` is the full upstream Monarch transaction tree (splits, attachments, merchant, category, etc.) - left as free-form so new Monarch fields pass through. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**transaction** | **{ [key: string]: any; }** | Free-form pass-through from upstream Monarch. Shape is documented per-endpoint; treat as a typed &#x60;Map&lt;String, Any?&gt;&#x60;. Use this for portions of the response we intentionally leave untyped because the upstream tree is too deep/volatile to model.  | [optional] [default to undefined]

## Example

```typescript
import { GetTransactionDetailResponseData } from 'monarch-bridge-client';

const instance: GetTransactionDetailResponseData = {
    transaction,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
