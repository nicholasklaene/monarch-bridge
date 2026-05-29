# GetAccountTypeOptionsResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**account_type_options** | **List[Dict[str, object]]** |  | 

## Example

```python
from monarch_bridge_client.models.get_account_type_options_response_data import GetAccountTypeOptionsResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetAccountTypeOptionsResponseData from a JSON string
get_account_type_options_response_data_instance = GetAccountTypeOptionsResponseData.from_json(json)
# print the JSON string representation of the object
print(GetAccountTypeOptionsResponseData.to_json())

# convert the object into a dict
get_account_type_options_response_data_dict = get_account_type_options_response_data_instance.to_dict()
# create an instance of GetAccountTypeOptionsResponseData from a dict
get_account_type_options_response_data_from_dict = GetAccountTypeOptionsResponseData.from_dict(get_account_type_options_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


