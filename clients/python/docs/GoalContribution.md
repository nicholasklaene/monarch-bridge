# GoalContribution


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**var_date** | **str** |  | [optional] 
**amount** | **float** |  | [optional] 
**account_id** | **str** |  | [optional] 
**notes** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.goal_contribution import GoalContribution

# TODO update the JSON string below
json = "{}"
# create an instance of GoalContribution from a JSON string
goal_contribution_instance = GoalContribution.from_json(json)
# print the JSON string representation of the object
print(GoalContribution.to_json())

# convert the object into a dict
goal_contribution_dict = goal_contribution_instance.to_dict()
# create an instance of GoalContribution from a dict
goal_contribution_from_dict = GoalContribution.from_dict(goal_contribution_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


