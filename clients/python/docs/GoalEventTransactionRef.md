# GoalEventTransactionRef

Minimal transaction reference attached to a goal event.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**amount** | **float** |  | [optional] 
**var_date** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.goal_event_transaction_ref import GoalEventTransactionRef

# TODO update the JSON string below
json = "{}"
# create an instance of GoalEventTransactionRef from a JSON string
goal_event_transaction_ref_instance = GoalEventTransactionRef.from_json(json)
# print the JSON string representation of the object
print(GoalEventTransactionRef.to_json())

# convert the object into a dict
goal_event_transaction_ref_dict = goal_event_transaction_ref_instance.to_dict()
# create an instance of GoalEventTransactionRef from a dict
goal_event_transaction_ref_from_dict = GoalEventTransactionRef.from_dict(goal_event_transaction_ref_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


