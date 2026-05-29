# DeleteAccountResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**deleted** | **bool** |  | 

## Example

```python
from monarch_bridge_client.models.delete_account_response_data import DeleteAccountResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of DeleteAccountResponseData from a JSON string
delete_account_response_data_instance = DeleteAccountResponseData.from_json(json)
# print the JSON string representation of the object
print(DeleteAccountResponseData.to_json())

# convert the object into a dict
delete_account_response_data_dict = delete_account_response_data_instance.to_dict()
# create an instance of DeleteAccountResponseData from a dict
delete_account_response_data_from_dict = DeleteAccountResponseData.from_dict(delete_account_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


