# GetBudgetMonthResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetBudgetMonthResponseData**](GetBudgetMonthResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_budget_month_response import GetBudgetMonthResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetBudgetMonthResponse from a JSON string
get_budget_month_response_instance = GetBudgetMonthResponse.from_json(json)
# print the JSON string representation of the object
print(GetBudgetMonthResponse.to_json())

# convert the object into a dict
get_budget_month_response_dict = get_budget_month_response_instance.to_dict()
# create an instance of GetBudgetMonthResponse from a dict
get_budget_month_response_from_dict = GetBudgetMonthResponse.from_dict(get_budget_month_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


