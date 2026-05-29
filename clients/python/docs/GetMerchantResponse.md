# GetMerchantResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetMerchantResponseData**](GetMerchantResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_merchant_response import GetMerchantResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetMerchantResponse from a JSON string
get_merchant_response_instance = GetMerchantResponse.from_json(json)
# print the JSON string representation of the object
print(GetMerchantResponse.to_json())

# convert the object into a dict
get_merchant_response_dict = get_merchant_response_instance.to_dict()
# create an instance of GetMerchantResponse from a dict
get_merchant_response_from_dict = GetMerchantResponse.from_dict(get_merchant_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


