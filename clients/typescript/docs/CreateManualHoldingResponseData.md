# CreateManualHoldingResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**holdingId** | **string** | Id of the newly-created holding. | [default to undefined]
**ticker** | **string** | Echoed back from Monarch when the security has a ticker symbol. | [optional] [default to undefined]

## Example

```typescript
import { CreateManualHoldingResponseData } from 'monarch-bridge-client';

const instance: CreateManualHoldingResponseData = {
    holdingId,
    ticker,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
