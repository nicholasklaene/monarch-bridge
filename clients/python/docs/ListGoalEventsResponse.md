# ListGoalEventsResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**ListGoalEventsResponseData**](ListGoalEventsResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.list_goal_events_response import ListGoalEventsResponse

# TODO update the JSON string below
json = "{}"
# create an instance of ListGoalEventsResponse from a JSON string
list_goal_events_response_instance = ListGoalEventsResponse.from_json(json)
# print the JSON string representation of the object
print(ListGoalEventsResponse.to_json())

# convert the object into a dict
list_goal_events_response_dict = list_goal_events_response_instance.to_dict()
# create an instance of ListGoalEventsResponse from a dict
list_goal_events_response_from_dict = ListGoalEventsResponse.from_dict(list_goal_events_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


