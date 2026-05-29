# LookupEntity

One semantic-search hit returned by `/v1/lookup`.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **string** |  | [default to undefined]
**type** | **string** | Entity kind - one of &#x60;account&#x60;, &#x60;category&#x60;, &#x60;tag&#x60;, &#x60;merchant&#x60;, etc. | [default to undefined]
**name** | **string** |  | [default to undefined]
**icon** | **string** |  | [optional] [default to undefined]
**logoUrl** | **string** |  | [optional] [default to undefined]

## Example

```typescript
import { LookupEntity } from 'monarch-bridge-client';

const instance: LookupEntity = {
    id,
    type,
    name,
    icon,
    logoUrl,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
