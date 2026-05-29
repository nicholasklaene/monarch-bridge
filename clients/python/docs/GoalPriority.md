# GoalPriority

One `(goalId, priority)` pair returned by the priorities mutation.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**goal_id** | **str** |  | 
**priority** | **int** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.goal_priority import GoalPriority

# TODO update the JSON string below
json = "{}"
# create an instance of GoalPriority from a JSON string
goal_priority_instance = GoalPriority.from_json(json)
# print the JSON string representation of the object
print(GoalPriority.to_json())

# convert the object into a dict
goal_priority_dict = goal_priority_instance.to_dict()
# create an instance of GoalPriority from a dict
goal_priority_from_dict = GoalPriority.from_dict(goal_priority_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


