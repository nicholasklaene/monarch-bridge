# UpdateGoalsPrioritiesRequest

Ordered list of goal ids - index = `priority` (0-based, lower = higher priority). The proxy expands this into Monarch's `[{id, priority}]` shape before mutating. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**goal_ids** | **List[str]** |  | 

## Example

```python
from monarch_bridge_client.models.update_goals_priorities_request import UpdateGoalsPrioritiesRequest

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateGoalsPrioritiesRequest from a JSON string
update_goals_priorities_request_instance = UpdateGoalsPrioritiesRequest.from_json(json)
# print the JSON string representation of the object
print(UpdateGoalsPrioritiesRequest.to_json())

# convert the object into a dict
update_goals_priorities_request_dict = update_goals_priorities_request_instance.to_dict()
# create an instance of UpdateGoalsPrioritiesRequest from a dict
update_goals_priorities_request_from_dict = UpdateGoalsPrioritiesRequest.from_dict(update_goals_priorities_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


