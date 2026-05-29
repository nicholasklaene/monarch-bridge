# SetMerchantLogoRequest

Body for `PATCH /v1/merchants/{id}/logo`. Wraps Monarch\'s `SetMerchantLogoInput`. Pass the existing Cloudinary asset\'s public id; this endpoint does NOT accept a binary upload. Send `cloudinaryPublicId: null` to clear the logo. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**cloudinaryPublicId** | **string** | Cloudinary public id of an already-uploaded image asset. Null clears. | [optional] [default to undefined]

## Example

```typescript
import { SetMerchantLogoRequest } from 'monarch-bridge-client';

const instance: SetMerchantLogoRequest = {
    cloudinaryPublicId,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
