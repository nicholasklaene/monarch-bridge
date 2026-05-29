# AccountGroup

A visual grouping of accounts under the Accounts tab.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**name** | **str** |  | 
**order** | **int** |  | 
**is_collapsed** | **bool** |  | [optional] 
**account_ids** | **List[str]** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.account_group import AccountGroup

# TODO update the JSON string below
json = "{}"
# create an instance of AccountGroup from a JSON string
account_group_instance = AccountGroup.from_json(json)
# print the JSON string representation of the object
print(AccountGroup.to_json())

# convert the object into a dict
account_group_dict = account_group_instance.to_dict()
# create an instance of AccountGroup from a dict
account_group_from_dict = AccountGroup.from_dict(account_group_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


