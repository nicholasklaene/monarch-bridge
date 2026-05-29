# GetBudgetStatusResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**status** | [**BudgetStatus**](BudgetStatus.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_budget_status_response_data import GetBudgetStatusResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetBudgetStatusResponseData from a JSON string
get_budget_status_response_data_instance = GetBudgetStatusResponseData.from_json(json)
# print the JSON string representation of the object
print(GetBudgetStatusResponseData.to_json())

# convert the object into a dict
get_budget_status_response_data_dict = get_budget_status_response_data_instance.to_dict()
# create an instance of GetBudgetStatusResponseData from a dict
get_budget_status_response_data_from_dict = GetBudgetStatusResponseData.from_dict(get_budget_status_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


