# LongTailResponse

Envelope for every `/v1/x/_*` long-tail endpoint. `data.result` holds the raw Monarch GraphQL `data` payload as a free-form map; clients should not pin to deep field paths since upstream shape can change. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**LongTailResponseData**](LongTailResponseData.md) |  | [default to undefined]

## Example

```typescript
import { LongTailResponse } from 'monarch-bridge-client';

const instance: LongTailResponse = {
    data,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
