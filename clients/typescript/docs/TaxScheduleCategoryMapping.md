# TaxScheduleCategoryMapping


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **string** |  | [default to undefined]
**lineItem** | **string** |  | [optional] [default to undefined]
**schedule** | **string** |  | [optional] [default to undefined]
**taxYear** | **number** |  | [optional] [default to undefined]
**category** | [**TaxCategoryRef**](TaxCategoryRef.md) |  | [optional] [default to undefined]
**lineItemInfo** | [**TaxLineItemInfo**](TaxLineItemInfo.md) |  | [optional] [default to undefined]

## Example

```typescript
import { TaxScheduleCategoryMapping } from 'monarch-bridge-client';

const instance: TaxScheduleCategoryMapping = {
    id,
    lineItem,
    schedule,
    taxYear,
    category,
    lineItemInfo,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
