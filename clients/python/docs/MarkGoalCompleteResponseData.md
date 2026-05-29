# MarkGoalCompleteResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**completed_at** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.mark_goal_complete_response_data import MarkGoalCompleteResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of MarkGoalCompleteResponseData from a JSON string
mark_goal_complete_response_data_instance = MarkGoalCompleteResponseData.from_json(json)
# print the JSON string representation of the object
print(MarkGoalCompleteResponseData.to_json())

# convert the object into a dict
mark_goal_complete_response_data_dict = mark_goal_complete_response_data_instance.to_dict()
# create an instance of MarkGoalCompleteResponseData from a dict
mark_goal_complete_response_data_from_dict = MarkGoalCompleteResponseData.from_dict(mark_goal_complete_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


