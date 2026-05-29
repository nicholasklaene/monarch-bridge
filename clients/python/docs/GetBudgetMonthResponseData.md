# GetBudgetMonthResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**budget_system** | **str** |  | [optional] 
**by_category** | [**List[BudgetMonthCategoryAmounts]**](BudgetMonthCategoryAmounts.md) |  | [optional] 

## Example

```python
from monarch_bridge_client.models.get_budget_month_response_data import GetBudgetMonthResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetBudgetMonthResponseData from a JSON string
get_budget_month_response_data_instance = GetBudgetMonthResponseData.from_json(json)
# print the JSON string representation of the object
print(GetBudgetMonthResponseData.to_json())

# convert the object into a dict
get_budget_month_response_data_dict = get_budget_month_response_data_instance.to_dict()
# create an instance of GetBudgetMonthResponseData from a dict
get_budget_month_response_data_from_dict = GetBudgetMonthResponseData.from_dict(get_budget_month_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


