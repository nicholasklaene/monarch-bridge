# GetGoalProjectionResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetGoalProjectionResponseData**](GetGoalProjectionResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_goal_projection_response import GetGoalProjectionResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetGoalProjectionResponse from a JSON string
get_goal_projection_response_instance = GetGoalProjectionResponse.from_json(json)
# print the JSON string representation of the object
print(GetGoalProjectionResponse.to_json())

# convert the object into a dict
get_goal_projection_response_dict = get_goal_projection_response_instance.to_dict()
# create an instance of GetGoalProjectionResponse from a dict
get_goal_projection_response_from_dict = GetGoalProjectionResponse.from_dict(get_goal_projection_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


