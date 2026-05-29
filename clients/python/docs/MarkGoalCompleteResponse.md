# MarkGoalCompleteResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**MarkGoalCompleteResponseData**](MarkGoalCompleteResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.mark_goal_complete_response import MarkGoalCompleteResponse

# TODO update the JSON string below
json = "{}"
# create an instance of MarkGoalCompleteResponse from a JSON string
mark_goal_complete_response_instance = MarkGoalCompleteResponse.from_json(json)
# print the JSON string representation of the object
print(MarkGoalCompleteResponse.to_json())

# convert the object into a dict
mark_goal_complete_response_dict = mark_goal_complete_response_instance.to_dict()
# create an instance of MarkGoalCompleteResponse from a dict
mark_goal_complete_response_from_dict = MarkGoalCompleteResponse.from_dict(mark_goal_complete_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


