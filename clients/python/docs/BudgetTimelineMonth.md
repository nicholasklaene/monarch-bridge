# BudgetTimelineMonth


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**month** | **str** |  | [optional] 
**total_budget** | **float** |  | [optional] 
**total_actual** | **float** |  | [optional] 
**variance_amount** | **float** |  | [optional] 
**variance_percent** | **float** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.budget_timeline_month import BudgetTimelineMonth

# TODO update the JSON string below
json = "{}"
# create an instance of BudgetTimelineMonth from a JSON string
budget_timeline_month_instance = BudgetTimelineMonth.from_json(json)
# print the JSON string representation of the object
print(BudgetTimelineMonth.to_json())

# convert the object into a dict
budget_timeline_month_dict = budget_timeline_month_instance.to_dict()
# create an instance of BudgetTimelineMonth from a dict
budget_timeline_month_from_dict = BudgetTimelineMonth.from_dict(budget_timeline_month_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


