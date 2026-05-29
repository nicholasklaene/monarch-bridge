# UpdateBudgetSettingsResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**budget_system** | **str** |  | [optional] 
**budget_apply_to_future_months_default** | **bool** |  | [optional] 
**budget_rollover_period_id** | **str** |  | [optional] 
**budget_rollover_period_start_month** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.update_budget_settings_response_data import UpdateBudgetSettingsResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateBudgetSettingsResponseData from a JSON string
update_budget_settings_response_data_instance = UpdateBudgetSettingsResponseData.from_json(json)
# print the JSON string representation of the object
print(UpdateBudgetSettingsResponseData.to_json())

# convert the object into a dict
update_budget_settings_response_data_dict = update_budget_settings_response_data_instance.to_dict()
# create an instance of UpdateBudgetSettingsResponseData from a dict
update_budget_settings_response_data_from_dict = UpdateBudgetSettingsResponseData.from_dict(update_budget_settings_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


