# GetAccountTypeOptionsResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetAccountTypeOptionsResponseData**](GetAccountTypeOptionsResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_account_type_options_response import GetAccountTypeOptionsResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetAccountTypeOptionsResponse from a JSON string
get_account_type_options_response_instance = GetAccountTypeOptionsResponse.from_json(json)
# print the JSON string representation of the object
print(GetAccountTypeOptionsResponse.to_json())

# convert the object into a dict
get_account_type_options_response_dict = get_account_type_options_response_instance.to_dict()
# create an instance of GetAccountTypeOptionsResponse from a dict
get_account_type_options_response_from_dict = GetAccountTypeOptionsResponse.from_dict(get_account_type_options_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


