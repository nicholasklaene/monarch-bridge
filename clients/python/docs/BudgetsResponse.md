# BudgetsResponse

`budgetData` is a deep Monarch tree (planned vs actual per category/group/flex/month) left free-form to track upstream changes. `categoryGroups` is also passed through. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetBudgetsResponseData**](GetBudgetsResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.budgets_response import BudgetsResponse

# TODO update the JSON string below
json = "{}"
# create an instance of BudgetsResponse from a JSON string
budgets_response_instance = BudgetsResponse.from_json(json)
# print the JSON string representation of the object
print(BudgetsResponse.to_json())

# convert the object into a dict
budgets_response_dict = budgets_response_instance.to_dict()
# create an instance of BudgetsResponse from a dict
budgets_response_from_dict = BudgetsResponse.from_dict(budgets_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


