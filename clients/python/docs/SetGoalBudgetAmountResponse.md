# SetGoalBudgetAmountResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**MarkTransactionStreamAsNotRecurringResponseData**](MarkTransactionStreamAsNotRecurringResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.set_goal_budget_amount_response import SetGoalBudgetAmountResponse

# TODO update the JSON string below
json = "{}"
# create an instance of SetGoalBudgetAmountResponse from a JSON string
set_goal_budget_amount_response_instance = SetGoalBudgetAmountResponse.from_json(json)
# print the JSON string representation of the object
print(SetGoalBudgetAmountResponse.to_json())

# convert the object into a dict
set_goal_budget_amount_response_dict = set_goal_budget_amount_response_instance.to_dict()
# create an instance of SetGoalBudgetAmountResponse from a dict
set_goal_budget_amount_response_from_dict = SetGoalBudgetAmountResponse.from_dict(set_goal_budget_amount_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


