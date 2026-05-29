# Holding

An investment position aggregated across one or more accounts.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **string** |  | [optional] [default to undefined]
**ticker** | **string** |  | [optional] [default to undefined]
**name** | **string** |  | [optional] [default to undefined]
**type** | **string** |  | [optional] [default to undefined]
**totalValue** | **number** |  | [optional] [default to undefined]
**totalQuantity** | **number** |  | [optional] [default to undefined]
**costBasis** | **number** |  | [optional] [default to undefined]
**lastPrice** | **number** |  | [optional] [default to undefined]

## Example

```typescript
import { Holding } from 'monarch-bridge-client';

const instance: Holding = {
    id,
    ticker,
    name,
    type,
    totalValue,
    totalQuantity,
    costBasis,
    lastPrice,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
