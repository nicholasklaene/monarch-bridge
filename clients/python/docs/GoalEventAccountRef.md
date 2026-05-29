# GoalEventAccountRef

Minimal account reference attached to a goal event.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**display_name** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.goal_event_account_ref import GoalEventAccountRef

# TODO update the JSON string below
json = "{}"
# create an instance of GoalEventAccountRef from a JSON string
goal_event_account_ref_instance = GoalEventAccountRef.from_json(json)
# print the JSON string representation of the object
print(GoalEventAccountRef.to_json())

# convert the object into a dict
goal_event_account_ref_dict = goal_event_account_ref_instance.to_dict()
# create an instance of GoalEventAccountRef from a dict
goal_event_account_ref_from_dict = GoalEventAccountRef.from_dict(goal_event_account_ref_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


