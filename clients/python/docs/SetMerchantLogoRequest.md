# SetMerchantLogoRequest

Body for `PATCH /v1/merchants/{id}/logo`. Wraps Monarch's `SetMerchantLogoInput`. Pass the existing Cloudinary asset's public id; this endpoint does NOT accept a binary upload. Send `cloudinaryPublicId: null` to clear the logo. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**cloudinary_public_id** | **str** | Cloudinary public id of an already-uploaded image asset. Null clears. | [optional] 

## Example

```python
from monarch_bridge_client.models.set_merchant_logo_request import SetMerchantLogoRequest

# TODO update the JSON string below
json = "{}"
# create an instance of SetMerchantLogoRequest from a JSON string
set_merchant_logo_request_instance = SetMerchantLogoRequest.from_json(json)
# print the JSON string representation of the object
print(SetMerchantLogoRequest.to_json())

# convert the object into a dict
set_merchant_logo_request_dict = set_merchant_logo_request_instance.to_dict()
# create an instance of SetMerchantLogoRequest from a dict
set_merchant_logo_request_from_dict = SetMerchantLogoRequest.from_dict(set_merchant_logo_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


