# HoldingTransactionRow

One discrete event that moved a holding (buy, sell, dividend, transfer).

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **string** |  | [default to undefined]
**date** | **string** |  | [optional] [default to undefined]
**type** | **string** | &#x60;buy&#x60;, &#x60;sell&#x60;, &#x60;dividend&#x60;, &#x60;transfer_in&#x60;, &#x60;transfer_out&#x60;. | [optional] [default to undefined]
**quantity** | **number** |  | [optional] [default to undefined]
**price** | **number** |  | [optional] [default to undefined]
**amount** | **number** |  | [optional] [default to undefined]
**fees** | **number** |  | [optional] [default to undefined]
**notes** | **string** |  | [optional] [default to undefined]

## Example

```typescript
import { HoldingTransactionRow } from 'monarch-bridge-client';

const instance: HoldingTransactionRow = {
    id,
    date,
    type,
    quantity,
    price,
    amount,
    fees,
    notes,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
