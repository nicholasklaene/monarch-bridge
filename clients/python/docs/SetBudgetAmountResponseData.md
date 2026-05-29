# SetBudgetAmountResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**budget_amount** | **float** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.set_budget_amount_response_data import SetBudgetAmountResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of SetBudgetAmountResponseData from a JSON string
set_budget_amount_response_data_instance = SetBudgetAmountResponseData.from_json(json)
# print the JSON string representation of the object
print(SetBudgetAmountResponseData.to_json())

# convert the object into a dict
set_budget_amount_response_data_dict = set_budget_amount_response_data_instance.to_dict()
# create an instance of SetBudgetAmountResponseData from a dict
set_budget_amount_response_data_from_dict = SetBudgetAmountResponseData.from_dict(set_budget_amount_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


