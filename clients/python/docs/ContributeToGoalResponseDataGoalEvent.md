# ContributeToGoalResponseDataGoalEvent


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**goal** | [**ContributeToGoalResponseDataGoalEventGoal**](ContributeToGoalResponseDataGoalEventGoal.md) |  | [optional] 
**account** | [**ContributeToGoalResponseDataGoalEventAccount**](ContributeToGoalResponseDataGoalEventAccount.md) |  | [optional] 

## Example

```python
from monarch_bridge_client.models.contribute_to_goal_response_data_goal_event import ContributeToGoalResponseDataGoalEvent

# TODO update the JSON string below
json = "{}"
# create an instance of ContributeToGoalResponseDataGoalEvent from a JSON string
contribute_to_goal_response_data_goal_event_instance = ContributeToGoalResponseDataGoalEvent.from_json(json)
# print the JSON string representation of the object
print(ContributeToGoalResponseDataGoalEvent.to_json())

# convert the object into a dict
contribute_to_goal_response_data_goal_event_dict = contribute_to_goal_response_data_goal_event_instance.to_dict()
# create an instance of ContributeToGoalResponseDataGoalEvent from a dict
contribute_to_goal_response_data_goal_event_from_dict = ContributeToGoalResponseDataGoalEvent.from_dict(contribute_to_goal_response_data_goal_event_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


