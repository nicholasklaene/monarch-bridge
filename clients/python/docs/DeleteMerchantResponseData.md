# DeleteMerchantResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**deleted** | **bool** | Monarch&#39;s &#x60;success&#x60; flag, surfaced under the common &#x60;deleted&#x60; key. | 

## Example

```python
from monarch_bridge_client.models.delete_merchant_response_data import DeleteMerchantResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of DeleteMerchantResponseData from a JSON string
delete_merchant_response_data_instance = DeleteMerchantResponseData.from_json(json)
# print the JSON string representation of the object
print(DeleteMerchantResponseData.to_json())

# convert the object into a dict
delete_merchant_response_data_dict = delete_merchant_response_data_instance.to_dict()
# create an instance of DeleteMerchantResponseData from a dict
delete_merchant_response_data_from_dict = DeleteMerchantResponseData.from_dict(delete_merchant_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


