# ListGoalEventsResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**events** | [**List[GoalEvent]**](GoalEvent.md) |  | 

## Example

```python
from monarch_bridge_client.models.list_goal_events_response_data import ListGoalEventsResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of ListGoalEventsResponseData from a JSON string
list_goal_events_response_data_instance = ListGoalEventsResponseData.from_json(json)
# print the JSON string representation of the object
print(ListGoalEventsResponseData.to_json())

# convert the object into a dict
list_goal_events_response_data_dict = list_goal_events_response_data_instance.to_dict()
# create an instance of ListGoalEventsResponseData from a dict
list_goal_events_response_data_from_dict = ListGoalEventsResponseData.from_dict(list_goal_events_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


