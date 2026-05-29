# TargetAllocationEntry


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**classification** | **str** |  | 
**target_percent** | **float** |  | [optional] 
**current_percent** | **float** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.target_allocation_entry import TargetAllocationEntry

# TODO update the JSON string below
json = "{}"
# create an instance of TargetAllocationEntry from a JSON string
target_allocation_entry_instance = TargetAllocationEntry.from_json(json)
# print the JSON string representation of the object
print(TargetAllocationEntry.to_json())

# convert the object into a dict
target_allocation_entry_dict = target_allocation_entry_instance.to_dict()
# create an instance of TargetAllocationEntry from a dict
target_allocation_entry_from_dict = TargetAllocationEntry.from_dict(target_allocation_entry_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


