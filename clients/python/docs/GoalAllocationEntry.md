# GoalAllocationEntry


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**goal_id** | **str** |  | 
**account_id** | **str** |  | [optional] 
**target_percent** | **float** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.goal_allocation_entry import GoalAllocationEntry

# TODO update the JSON string below
json = "{}"
# create an instance of GoalAllocationEntry from a JSON string
goal_allocation_entry_instance = GoalAllocationEntry.from_json(json)
# print the JSON string representation of the object
print(GoalAllocationEntry.to_json())

# convert the object into a dict
goal_allocation_entry_dict = goal_allocation_entry_instance.to_dict()
# create an instance of GoalAllocationEntry from a dict
goal_allocation_entry_from_dict = GoalAllocationEntry.from_dict(goal_allocation_entry_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


