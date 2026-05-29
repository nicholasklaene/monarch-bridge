# GetGoalsCurrentMonthTotalsResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetGoalsCurrentMonthTotalsResponseData**](GetGoalsCurrentMonthTotalsResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_goals_current_month_totals_response import GetGoalsCurrentMonthTotalsResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetGoalsCurrentMonthTotalsResponse from a JSON string
get_goals_current_month_totals_response_instance = GetGoalsCurrentMonthTotalsResponse.from_json(json)
# print the JSON string representation of the object
print(GetGoalsCurrentMonthTotalsResponse.to_json())

# convert the object into a dict
get_goals_current_month_totals_response_dict = get_goals_current_month_totals_response_instance.to_dict()
# create an instance of GetGoalsCurrentMonthTotalsResponse from a dict
get_goals_current_month_totals_response_from_dict = GetGoalsCurrentMonthTotalsResponse.from_dict(get_goals_current_month_totals_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


