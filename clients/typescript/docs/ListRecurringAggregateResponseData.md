# ListRecurringAggregateResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**aggregate** | **{ [key: string]: any; }** | Pass-through from Monarch\&#39;s &#x60;aggregatedRecurringItems&#x60; - &#x60;groups[]&#x60; (per status) plus &#x60;aggregatedSummary&#x60; (expense/creditCard/income totals across the window).  | [optional] [default to undefined]

## Example

```typescript
import { ListRecurringAggregateResponseData } from 'monarch-bridge-client';

const instance: ListRecurringAggregateResponseData = {
    aggregate,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
