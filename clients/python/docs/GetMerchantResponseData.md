# GetMerchantResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**merchant** | [**Merchant**](Merchant.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_merchant_response_data import GetMerchantResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetMerchantResponseData from a JSON string
get_merchant_response_data_instance = GetMerchantResponseData.from_json(json)
# print the JSON string representation of the object
print(GetMerchantResponseData.to_json())

# convert the object into a dict
get_merchant_response_data_dict = get_merchant_response_data_instance.to_dict()
# create an instance of GetMerchantResponseData from a dict
get_merchant_response_data_from_dict = GetMerchantResponseData.from_dict(get_merchant_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


