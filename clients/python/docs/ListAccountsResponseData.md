# ListAccountsResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accounts** | [**List[Account]**](Account.md) |  | 

## Example

```python
from monarch_bridge_client.models.list_accounts_response_data import ListAccountsResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of ListAccountsResponseData from a JSON string
list_accounts_response_data_instance = ListAccountsResponseData.from_json(json)
# print the JSON string representation of the object
print(ListAccountsResponseData.to_json())

# convert the object into a dict
list_accounts_response_data_dict = list_accounts_response_data_instance.to_dict()
# create an instance of ListAccountsResponseData from a dict
list_accounts_response_data_from_dict = ListAccountsResponseData.from_dict(list_accounts_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


