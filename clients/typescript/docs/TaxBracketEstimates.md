# TaxBracketEstimates


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**taxYear** | **number** |  | [default to undefined]
**filingStatus** | **string** |  | [optional] [default to undefined]
**estimatedAgi** | **number** |  | [optional] [default to undefined]
**marginalRate** | **number** |  | [optional] [default to undefined]
**effectiveRate** | **number** |  | [optional] [default to undefined]
**brackets** | [**Array&lt;TaxBracket&gt;**](TaxBracket.md) |  | [default to undefined]

## Example

```typescript
import { TaxBracketEstimates } from 'monarch-bridge-client';

const instance: TaxBracketEstimates = {
    taxYear,
    filingStatus,
    estimatedAgi,
    marginalRate,
    effectiveRate,
    brackets,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
