# GoalProjectionPoint


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**var_date** | **date** |  | 
**projected_balance** | **float** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.goal_projection_point import GoalProjectionPoint

# TODO update the JSON string below
json = "{}"
# create an instance of GoalProjectionPoint from a JSON string
goal_projection_point_instance = GoalProjectionPoint.from_json(json)
# print the JSON string representation of the object
print(GoalProjectionPoint.to_json())

# convert the object into a dict
goal_projection_point_dict = goal_projection_point_instance.to_dict()
# create an instance of GoalProjectionPoint from a dict
goal_projection_point_from_dict = GoalProjectionPoint.from_dict(goal_projection_point_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


