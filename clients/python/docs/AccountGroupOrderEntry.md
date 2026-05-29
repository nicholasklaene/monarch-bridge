# AccountGroupOrderEntry


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**order** | **int** |  | 

## Example

```python
from monarch_bridge_client.models.account_group_order_entry import AccountGroupOrderEntry

# TODO update the JSON string below
json = "{}"
# create an instance of AccountGroupOrderEntry from a JSON string
account_group_order_entry_instance = AccountGroupOrderEntry.from_json(json)
# print the JSON string representation of the object
print(AccountGroupOrderEntry.to_json())

# convert the object into a dict
account_group_order_entry_dict = account_group_order_entry_instance.to_dict()
# create an instance of AccountGroupOrderEntry from a dict
account_group_order_entry_from_dict = AccountGroupOrderEntry.from_dict(account_group_order_entry_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


