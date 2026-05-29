# BudgetMonthMonthlyAmount


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**month** | **date** |  | 
**planned_cash_flow_amount** | **float** |  | [optional] 
**planned_set_aside_amount** | **float** |  | [optional] 
**actual_amount** | **float** |  | [optional] 
**remaining_amount** | **float** |  | [optional] 
**previous_month_rollover_amount** | **float** |  | [optional] 
**rollover_type** | **str** |  | [optional] 
**cumulative_actual_amount** | **float** |  | [optional] 
**rollover_target_amount** | **float** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.budget_month_monthly_amount import BudgetMonthMonthlyAmount

# TODO update the JSON string below
json = "{}"
# create an instance of BudgetMonthMonthlyAmount from a JSON string
budget_month_monthly_amount_instance = BudgetMonthMonthlyAmount.from_json(json)
# print the JSON string representation of the object
print(BudgetMonthMonthlyAmount.to_json())

# convert the object into a dict
budget_month_monthly_amount_dict = budget_month_monthly_amount_instance.to_dict()
# create an instance of BudgetMonthMonthlyAmount from a dict
budget_month_monthly_amount_from_dict = BudgetMonthMonthlyAmount.from_dict(budget_month_monthly_amount_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


