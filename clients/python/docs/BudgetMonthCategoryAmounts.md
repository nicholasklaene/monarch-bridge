# BudgetMonthCategoryAmounts


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**category_id** | **str** |  | 
**monthly_amounts** | [**List[BudgetMonthMonthlyAmount]**](BudgetMonthMonthlyAmount.md) |  | [optional] 

## Example

```python
from monarch_bridge_client.models.budget_month_category_amounts import BudgetMonthCategoryAmounts

# TODO update the JSON string below
json = "{}"
# create an instance of BudgetMonthCategoryAmounts from a JSON string
budget_month_category_amounts_instance = BudgetMonthCategoryAmounts.from_json(json)
# print the JSON string representation of the object
print(BudgetMonthCategoryAmounts.to_json())

# convert the object into a dict
budget_month_category_amounts_dict = budget_month_category_amounts_instance.to_dict()
# create an instance of BudgetMonthCategoryAmounts from a dict
budget_month_category_amounts_from_dict = BudgetMonthCategoryAmounts.from_dict(budget_month_category_amounts_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


