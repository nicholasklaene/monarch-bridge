# GetBudgetStatusResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetBudgetStatusResponseData**](GetBudgetStatusResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_budget_status_response import GetBudgetStatusResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetBudgetStatusResponse from a JSON string
get_budget_status_response_instance = GetBudgetStatusResponse.from_json(json)
# print the JSON string representation of the object
print(GetBudgetStatusResponse.to_json())

# convert the object into a dict
get_budget_status_response_dict = get_budget_status_response_instance.to_dict()
# create an instance of GetBudgetStatusResponse from a dict
get_budget_status_response_from_dict = GetBudgetStatusResponse.from_dict(get_budget_status_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


