# UpdateBudgetSettingsRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**budget_system** | **str** | One of &#x60;category&#x60;, &#x60;category_group&#x60;. Omit to leave unchanged. | [optional] 
**budget_apply_to_future_months_default** | **bool** | When true, budget-amount edits cascade to future months by default. Omit to leave unchanged. | [optional] 

## Example

```python
from monarch_bridge_client.models.update_budget_settings_request import UpdateBudgetSettingsRequest

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateBudgetSettingsRequest from a JSON string
update_budget_settings_request_instance = UpdateBudgetSettingsRequest.from_json(json)
# print the JSON string representation of the object
print(UpdateBudgetSettingsRequest.to_json())

# convert the object into a dict
update_budget_settings_request_dict = update_budget_settings_request_instance.to_dict()
# create an instance of UpdateBudgetSettingsRequest from a dict
update_budget_settings_request_from_dict = UpdateBudgetSettingsRequest.from_dict(update_budget_settings_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


