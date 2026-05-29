# GetAccountGroupsResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetAccountGroupsResponseData**](GetAccountGroupsResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_account_groups_response import GetAccountGroupsResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetAccountGroupsResponse from a JSON string
get_account_groups_response_instance = GetAccountGroupsResponse.from_json(json)
# print the JSON string representation of the object
print(GetAccountGroupsResponse.to_json())

# convert the object into a dict
get_account_groups_response_dict = get_account_groups_response_instance.to_dict()
# create an instance of GetAccountGroupsResponse from a dict
get_account_groups_response_from_dict = GetAccountGroupsResponse.from_dict(get_account_groups_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


