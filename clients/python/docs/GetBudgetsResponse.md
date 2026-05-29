# GetBudgetsResponse

`budgetData` is a deep Monarch tree (planned vs actual per category/group/flex/month) left free-form to track upstream changes. `categoryGroups` is also passed through. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetBudgetsResponseData**](GetBudgetsResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_budgets_response import GetBudgetsResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetBudgetsResponse from a JSON string
get_budgets_response_instance = GetBudgetsResponse.from_json(json)
# print the JSON string representation of the object
print(GetBudgetsResponse.to_json())

# convert the object into a dict
get_budgets_response_dict = get_budgets_response_instance.to_dict()
# create an instance of GetBudgetsResponse from a dict
get_budgets_response_from_dict = GetBudgetsResponse.from_dict(get_budgets_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


