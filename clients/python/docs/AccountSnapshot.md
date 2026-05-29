# AccountSnapshot

One daily balance snapshot.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**var_date** | **date** |  | 
**balance** | **float** |  | 

## Example

```python
from monarch_bridge_client.models.account_snapshot import AccountSnapshot

# TODO update the JSON string below
json = "{}"
# create an instance of AccountSnapshot from a JSON string
account_snapshot_instance = AccountSnapshot.from_json(json)
# print the JSON string representation of the object
print(AccountSnapshot.to_json())

# convert the object into a dict
account_snapshot_dict = account_snapshot_instance.to_dict()
# create an instance of AccountSnapshot from a dict
account_snapshot_from_dict = AccountSnapshot.from_dict(account_snapshot_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


