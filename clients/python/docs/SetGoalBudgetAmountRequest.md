# SetGoalBudgetAmountRequest

Set monthly planned-contribution allocation for a savings goal. `month` is the first-of-month date (`YYYY-MM-DD`); defaults to current month. `applyToFuture` cascades the amount to all subsequent months. `accountId` is optional - omit for the household-level amount. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**amount** | **float** |  | 
**month** | **str** |  | [optional] 
**apply_to_future** | **bool** |  | [optional] 
**account_id** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.set_goal_budget_amount_request import SetGoalBudgetAmountRequest

# TODO update the JSON string below
json = "{}"
# create an instance of SetGoalBudgetAmountRequest from a JSON string
set_goal_budget_amount_request_instance = SetGoalBudgetAmountRequest.from_json(json)
# print the JSON string representation of the object
print(SetGoalBudgetAmountRequest.to_json())

# convert the object into a dict
set_goal_budget_amount_request_dict = set_goal_budget_amount_request_instance.to_dict()
# create an instance of SetGoalBudgetAmountRequest from a dict
set_goal_budget_amount_request_from_dict = SetGoalBudgetAmountRequest.from_dict(set_goal_budget_amount_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


