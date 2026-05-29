# ResetBudgetResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**ResetBudgetResponseData**](ResetBudgetResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.reset_budget_response import ResetBudgetResponse

# TODO update the JSON string below
json = "{}"
# create an instance of ResetBudgetResponse from a JSON string
reset_budget_response_instance = ResetBudgetResponse.from_json(json)
# print the JSON string representation of the object
print(ResetBudgetResponse.to_json())

# convert the object into a dict
reset_budget_response_dict = reset_budget_response_instance.to_dict()
# create an instance of ResetBudgetResponse from a dict
reset_budget_response_from_dict = ResetBudgetResponse.from_dict(reset_budget_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


