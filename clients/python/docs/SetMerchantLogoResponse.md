# SetMerchantLogoResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetMerchantResponseData**](GetMerchantResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.set_merchant_logo_response import SetMerchantLogoResponse

# TODO update the JSON string below
json = "{}"
# create an instance of SetMerchantLogoResponse from a JSON string
set_merchant_logo_response_instance = SetMerchantLogoResponse.from_json(json)
# print the JSON string representation of the object
print(SetMerchantLogoResponse.to_json())

# convert the object into a dict
set_merchant_logo_response_dict = set_merchant_logo_response_instance.to_dict()
# create an instance of SetMerchantLogoResponse from a dict
set_merchant_logo_response_from_dict = SetMerchantLogoResponse.from_dict(set_merchant_logo_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


