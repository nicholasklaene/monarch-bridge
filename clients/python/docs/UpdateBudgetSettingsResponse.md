# UpdateBudgetSettingsResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**UpdateBudgetSettingsResponseData**](UpdateBudgetSettingsResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.update_budget_settings_response import UpdateBudgetSettingsResponse

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateBudgetSettingsResponse from a JSON string
update_budget_settings_response_instance = UpdateBudgetSettingsResponse.from_json(json)
# print the JSON string representation of the object
print(UpdateBudgetSettingsResponse.to_json())

# convert the object into a dict
update_budget_settings_response_dict = update_budget_settings_response_instance.to_dict()
# create an instance of UpdateBudgetSettingsResponse from a dict
update_budget_settings_response_from_dict = UpdateBudgetSettingsResponse.from_dict(update_budget_settings_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


