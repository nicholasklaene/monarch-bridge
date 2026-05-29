# SetBudgetAmountRequest

Set the planned budget for ONE category OR category-group for a month. Pass exactly one of `categoryId` / `categoryGroupId`. `amount: 0` clears. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**amount** | **float** |  | 
**start_date** | **str** |  | 
**category_id** | **str** |  | [optional] 
**category_group_id** | **str** |  | [optional] 
**timeframe** | **str** |  | [optional] [default to 'month']
**apply_to_future** | **bool** |  | [optional] [default to False]

## Example

```python
from monarch_bridge_client.models.set_budget_amount_request import SetBudgetAmountRequest

# TODO update the JSON string below
json = "{}"
# create an instance of SetBudgetAmountRequest from a JSON string
set_budget_amount_request_instance = SetBudgetAmountRequest.from_json(json)
# print the JSON string representation of the object
print(SetBudgetAmountRequest.to_json())

# convert the object into a dict
set_budget_amount_request_dict = set_budget_amount_request_instance.to_dict()
# create an instance of SetBudgetAmountRequest from a dict
set_budget_amount_request_from_dict = SetBudgetAmountRequest.from_dict(set_budget_amount_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


