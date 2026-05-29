# GoalCurrentMonthTotal

Per-goal planned-contribution total for a month window.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**goal_id** | **str** |  | 
**total_planned_amount** | **float** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.goal_current_month_total import GoalCurrentMonthTotal

# TODO update the JSON string below
json = "{}"
# create an instance of GoalCurrentMonthTotal from a JSON string
goal_current_month_total_instance = GoalCurrentMonthTotal.from_json(json)
# print the JSON string representation of the object
print(GoalCurrentMonthTotal.to_json())

# convert the object into a dict
goal_current_month_total_dict = goal_current_month_total_instance.to_dict()
# create an instance of GoalCurrentMonthTotal from a dict
goal_current_month_total_from_dict = GoalCurrentMonthTotal.from_dict(goal_current_month_total_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


