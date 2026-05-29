# GetGoalProjectionResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**projection** | [**GoalProjection**](GoalProjection.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_goal_projection_response_data import GetGoalProjectionResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetGoalProjectionResponseData from a JSON string
get_goal_projection_response_data_instance = GetGoalProjectionResponseData.from_json(json)
# print the JSON string representation of the object
print(GetGoalProjectionResponseData.to_json())

# convert the object into a dict
get_goal_projection_response_data_dict = get_goal_projection_response_data_instance.to_dict()
# create an instance of GetGoalProjectionResponseData from a dict
get_goal_projection_response_data_from_dict = GetGoalProjectionResponseData.from_dict(get_goal_projection_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


