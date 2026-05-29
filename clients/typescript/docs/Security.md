# Security

A row from Monarch\'s security catalog. `currentPrice` and friends may be null for thinly-traded or manual securities.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **string** |  | [default to undefined]
**name** | **string** |  | [optional] [default to undefined]
**ticker** | **string** |  | [optional] [default to undefined]
**type** | **string** |  | [optional] [default to undefined]
**typeDisplay** | **string** |  | [optional] [default to undefined]
**logo** | **string** |  | [optional] [default to undefined]
**currentPrice** | **number** |  | [optional] [default to undefined]
**closingPrice** | **number** |  | [optional] [default to undefined]
**oneDayChangeDollars** | **number** |  | [optional] [default to undefined]
**oneDayChangePercent** | **number** |  | [optional] [default to undefined]

## Example

```typescript
import { Security } from 'monarch-bridge-client';

const instance: Security = {
    id,
    name,
    ticker,
    type,
    typeDisplay,
    logo,
    currentPrice,
    closingPrice,
    oneDayChangeDollars,
    oneDayChangePercent,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
