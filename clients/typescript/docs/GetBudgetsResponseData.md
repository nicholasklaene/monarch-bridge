# GetBudgetsResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**budgetData** | **{ [key: string]: any; }** | Free-form pass-through from upstream Monarch. Shape is documented per-endpoint; treat as a typed &#x60;Map&lt;String, Any?&gt;&#x60;. Use this for portions of the response we intentionally leave untyped because the upstream tree is too deep/volatile to model.  | [optional] [default to undefined]
**categoryGroups** | **Array&lt;{ [key: string]: any; }&gt;** |  | [default to undefined]

## Example

```typescript
import { GetBudgetsResponseData } from 'monarch-bridge-client';

const instance: GetBudgetsResponseData = {
    budgetData,
    categoryGroups,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
