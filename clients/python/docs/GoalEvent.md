# GoalEvent

One contribution / withdrawal / linked-transaction event against a savings goal.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**var_date** | **str** |  | [optional] 
**amount** | **float** |  | [optional] 
**type** | **str** | Event type (&#x60;contribution&#x60;, &#x60;withdrawal&#x60;, &#x60;transaction&#x60;, etc.). | [optional] 
**created_at** | **str** |  | [optional] 
**can_delete** | **bool** |  | [optional] 
**include_in_budget** | **bool** |  | [optional] 
**notes** | **str** |  | [optional] 
**account** | [**GoalEventAccountRef**](GoalEventAccountRef.md) |  | [optional] 
**transaction** | [**GoalEventTransactionRef**](GoalEventTransactionRef.md) |  | [optional] 

## Example

```python
from monarch_bridge_client.models.goal_event import GoalEvent

# TODO update the JSON string below
json = "{}"
# create an instance of GoalEvent from a JSON string
goal_event_instance = GoalEvent.from_json(json)
# print the JSON string representation of the object
print(GoalEvent.to_json())

# convert the object into a dict
goal_event_dict = goal_event_instance.to_dict()
# create an instance of GoalEvent from a dict
goal_event_from_dict = GoalEvent.from_dict(goal_event_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


