# GetAccountGroupsResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**groups** | [**List[AccountGroup]**](AccountGroup.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_account_groups_response_data import GetAccountGroupsResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetAccountGroupsResponseData from a JSON string
get_account_groups_response_data_instance = GetAccountGroupsResponseData.from_json(json)
# print the JSON string representation of the object
print(GetAccountGroupsResponseData.to_json())

# convert the object into a dict
get_account_groups_response_data_dict = get_account_groups_response_data_instance.to_dict()
# create an instance of GetAccountGroupsResponseData from a dict
get_account_groups_response_data_from_dict = GetAccountGroupsResponseData.from_dict(get_account_groups_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


