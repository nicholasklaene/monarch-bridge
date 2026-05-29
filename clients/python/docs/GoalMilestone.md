# GoalMilestone


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**target_amount** | **float** |  | [optional] 
**reached_at** | **str** |  | [optional] 
**title** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.goal_milestone import GoalMilestone

# TODO update the JSON string below
json = "{}"
# create an instance of GoalMilestone from a JSON string
goal_milestone_instance = GoalMilestone.from_json(json)
# print the JSON string representation of the object
print(GoalMilestone.to_json())

# convert the object into a dict
goal_milestone_dict = goal_milestone_instance.to_dict()
# create an instance of GoalMilestone from a dict
goal_milestone_from_dict = GoalMilestone.from_dict(goal_milestone_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


