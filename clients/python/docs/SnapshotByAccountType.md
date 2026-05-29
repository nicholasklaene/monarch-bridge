# SnapshotByAccountType

One snapshot bucket within a `networth/by-type` series.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**var_date** | **date** |  | [optional] 
**account_type** | **str** |  | [optional] 
**balance** | **float** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.snapshot_by_account_type import SnapshotByAccountType

# TODO update the JSON string below
json = "{}"
# create an instance of SnapshotByAccountType from a JSON string
snapshot_by_account_type_instance = SnapshotByAccountType.from_json(json)
# print the JSON string representation of the object
print(SnapshotByAccountType.to_json())

# convert the object into a dict
snapshot_by_account_type_dict = snapshot_by_account_type_instance.to_dict()
# create an instance of SnapshotByAccountType from a dict
snapshot_by_account_type_from_dict = SnapshotByAccountType.from_dict(snapshot_by_account_type_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


