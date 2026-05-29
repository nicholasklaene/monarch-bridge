# GetCashflowBreakdownResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**byCategory** | **Array&lt;{ [key: string]: any; }&gt;** |  | [default to undefined]
**byCategoryGroup** | **Array&lt;{ [key: string]: any; }&gt;** |  | [default to undefined]
**byMerchant** | **Array&lt;{ [key: string]: any; }&gt;** |  | [default to undefined]
**summary** | **{ [key: string]: any; }** | Free-form pass-through from upstream Monarch. Shape is documented per-endpoint; treat as a typed &#x60;Map&lt;String, Any?&gt;&#x60;. Use this for portions of the response we intentionally leave untyped because the upstream tree is too deep/volatile to model.  | [optional] [default to undefined]

## Example

```typescript
import { GetCashflowBreakdownResponseData } from 'monarch-bridge-client';

const instance: GetCashflowBreakdownResponseData = {
    byCategory,
    byCategoryGroup,
    byMerchant,
    summary,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
