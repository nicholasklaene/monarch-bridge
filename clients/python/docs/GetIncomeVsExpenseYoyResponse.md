# GetIncomeVsExpenseYoyResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetIncomeVsExpenseYoyResponseData**](GetIncomeVsExpenseYoyResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_income_vs_expense_yoy_response import GetIncomeVsExpenseYoyResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetIncomeVsExpenseYoyResponse from a JSON string
get_income_vs_expense_yoy_response_instance = GetIncomeVsExpenseYoyResponse.from_json(json)
# print the JSON string representation of the object
print(GetIncomeVsExpenseYoyResponse.to_json())

# convert the object into a dict
get_income_vs_expense_yoy_response_dict = get_income_vs_expense_yoy_response_instance.to_dict()
# create an instance of GetIncomeVsExpenseYoyResponse from a dict
get_income_vs_expense_yoy_response_from_dict = GetIncomeVsExpenseYoyResponse.from_dict(get_income_vs_expense_yoy_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


