# ResetBudgetRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**start_date** | **str** |  | 

## Example

```python
from monarch_bridge_client.models.reset_budget_request import ResetBudgetRequest

# TODO update the JSON string below
json = "{}"
# create an instance of ResetBudgetRequest from a JSON string
reset_budget_request_instance = ResetBudgetRequest.from_json(json)
# print the JSON string representation of the object
print(ResetBudgetRequest.to_json())

# convert the object into a dict
reset_budget_request_dict = reset_budget_request_instance.to_dict()
# create an instance of ResetBudgetRequest from a dict
reset_budget_request_from_dict = ResetBudgetRequest.from_dict(reset_budget_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


