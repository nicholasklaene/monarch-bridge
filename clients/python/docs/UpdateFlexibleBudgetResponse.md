# UpdateFlexibleBudgetResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**SetBudgetAmountResponseData**](SetBudgetAmountResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.update_flexible_budget_response import UpdateFlexibleBudgetResponse

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateFlexibleBudgetResponse from a JSON string
update_flexible_budget_response_instance = UpdateFlexibleBudgetResponse.from_json(json)
# print the JSON string representation of the object
print(UpdateFlexibleBudgetResponse.to_json())

# convert the object into a dict
update_flexible_budget_response_dict = update_flexible_budget_response_instance.to_dict()
# create an instance of UpdateFlexibleBudgetResponse from a dict
update_flexible_budget_response_from_dict = UpdateFlexibleBudgetResponse.from_dict(update_flexible_budget_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


