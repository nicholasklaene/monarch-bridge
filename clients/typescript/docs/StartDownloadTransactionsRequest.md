# StartDownloadTransactionsRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**filters** | **{ [key: string]: any; }** | TransactionFilterInput - passed through verbatim. Common keys, &#x60;search&#x60;, &#x60;categories&#x60;, &#x60;accounts&#x60;, &#x60;tags&#x60;, &#x60;startDate&#x60;, &#x60;endDate&#x60;, &#x60;hideFromReports&#x60;. | [optional] [default to undefined]
**orderBy** | **string** | Sort key (e.g. &#x60;date&#x60; or &#x60;amount&#x60;). Optional. | [optional] [default to undefined]

## Example

```typescript
import { StartDownloadTransactionsRequest } from 'monarch-bridge-client';

const instance: StartDownloadTransactionsRequest = {
    filters,
    orderBy,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
