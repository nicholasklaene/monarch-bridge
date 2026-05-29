# BudgetStatus


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**has_budget** | **bool** |  | [optional] 
**has_transactions** | **bool** |  | [optional] 
**will_create_budget_from_empty_default_categories** | **bool** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.budget_status import BudgetStatus

# TODO update the JSON string below
json = "{}"
# create an instance of BudgetStatus from a JSON string
budget_status_instance = BudgetStatus.from_json(json)
# print the JSON string representation of the object
print(BudgetStatus.to_json())

# convert the object into a dict
budget_status_dict = budget_status_instance.to_dict()
# create an instance of BudgetStatus from a dict
budget_status_from_dict = BudgetStatus.from_dict(budget_status_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


