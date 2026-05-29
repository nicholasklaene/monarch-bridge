# GetIncomeVsExpenseYoyResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**points** | [**List[YoyPoint]**](YoyPoint.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_income_vs_expense_yoy_response_data import GetIncomeVsExpenseYoyResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetIncomeVsExpenseYoyResponseData from a JSON string
get_income_vs_expense_yoy_response_data_instance = GetIncomeVsExpenseYoyResponseData.from_json(json)
# print the JSON string representation of the object
print(GetIncomeVsExpenseYoyResponseData.to_json())

# convert the object into a dict
get_income_vs_expense_yoy_response_data_dict = get_income_vs_expense_yoy_response_data_instance.to_dict()
# create an instance of GetIncomeVsExpenseYoyResponseData from a dict
get_income_vs_expense_yoy_response_data_from_dict = GetIncomeVsExpenseYoyResponseData.from_dict(get_income_vs_expense_yoy_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


