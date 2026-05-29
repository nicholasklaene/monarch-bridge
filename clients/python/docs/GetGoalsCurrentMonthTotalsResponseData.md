# GetGoalsCurrentMonthTotalsResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**totals** | [**List[GoalCurrentMonthTotal]**](GoalCurrentMonthTotal.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_goals_current_month_totals_response_data import GetGoalsCurrentMonthTotalsResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetGoalsCurrentMonthTotalsResponseData from a JSON string
get_goals_current_month_totals_response_data_instance = GetGoalsCurrentMonthTotalsResponseData.from_json(json)
# print the JSON string representation of the object
print(GetGoalsCurrentMonthTotalsResponseData.to_json())

# convert the object into a dict
get_goals_current_month_totals_response_data_dict = get_goals_current_month_totals_response_data_instance.to_dict()
# create an instance of GetGoalsCurrentMonthTotalsResponseData from a dict
get_goals_current_month_totals_response_data_from_dict = GetGoalsCurrentMonthTotalsResponseData.from_dict(get_goals_current_month_totals_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


