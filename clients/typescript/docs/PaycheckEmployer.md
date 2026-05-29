# PaycheckEmployer

A named employer associated with one or more paychecks.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **string** |  | [default to undefined]
**name** | **string** |  | [default to undefined]
**paycheckCount** | **number** | Number of paychecks currently attributed to this employer. | [optional] [default to undefined]
**createdAt** | **string** |  | [optional] [default to undefined]

## Example

```typescript
import { PaycheckEmployer } from 'monarch-bridge-client';

const instance: PaycheckEmployer = {
    id,
    name,
    paycheckCount,
    createdAt,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
