# SetBudgetAmountResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**SetBudgetAmountResponseData**](SetBudgetAmountResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.set_budget_amount_response import SetBudgetAmountResponse

# TODO update the JSON string below
json = "{}"
# create an instance of SetBudgetAmountResponse from a JSON string
set_budget_amount_response_instance = SetBudgetAmountResponse.from_json(json)
# print the JSON string representation of the object
print(SetBudgetAmountResponse.to_json())

# convert the object into a dict
set_budget_amount_response_dict = set_budget_amount_response_instance.to_dict()
# create an instance of SetBudgetAmountResponse from a dict
set_budget_amount_response_from_dict = SetBudgetAmountResponse.from_dict(set_budget_amount_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


