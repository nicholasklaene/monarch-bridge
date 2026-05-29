# GoalProjection


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**projected_completion_date** | **str** |  | [optional] 
**months_to_target** | **int** |  | [optional] 
**series** | [**List[GoalProjectionPoint]**](GoalProjectionPoint.md) |  | 

## Example

```python
from monarch_bridge_client.models.goal_projection import GoalProjection

# TODO update the JSON string below
json = "{}"
# create an instance of GoalProjection from a JSON string
goal_projection_instance = GoalProjection.from_json(json)
# print the JSON string representation of the object
print(GoalProjection.to_json())

# convert the object into a dict
goal_projection_dict = goal_projection_instance.to_dict()
# create an instance of GoalProjection from a dict
goal_projection_from_dict = GoalProjection.from_dict(goal_projection_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


