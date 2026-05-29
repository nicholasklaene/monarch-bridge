# UpdateFlexibleBudgetRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**amount** | **float** |  | 
**start_date** | **str** |  | 
**apply_to_future** | **bool** |  | [optional] [default to False]

## Example

```python
from monarch_bridge_client.models.update_flexible_budget_request import UpdateFlexibleBudgetRequest

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateFlexibleBudgetRequest from a JSON string
update_flexible_budget_request_instance = UpdateFlexibleBudgetRequest.from_json(json)
# print the JSON string representation of the object
print(UpdateFlexibleBudgetRequest.to_json())

# convert the object into a dict
update_flexible_budget_request_dict = update_flexible_budget_request_instance.to_dict()
# create an instance of UpdateFlexibleBudgetRequest from a dict
update_flexible_budget_request_from_dict = UpdateFlexibleBudgetRequest.from_dict(update_flexible_budget_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


