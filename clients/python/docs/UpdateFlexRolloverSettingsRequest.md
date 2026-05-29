# UpdateFlexRolloverSettingsRequest

Common use: point `rolloverStartMonth` to the current month with `rolloverStartingBalance: 0` to clear accumulated negative rollover. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**rollover_start_month** | **str** |  | 
**rollover_starting_balance** | **float** |  | [optional] [default to 0.0]
**rollover_enabled** | **bool** |  | [optional] [default to True]
**budget_system** | **str** |  | [optional] [default to 'fixed_and_flex']

## Example

```python
from monarch_bridge_client.models.update_flex_rollover_settings_request import UpdateFlexRolloverSettingsRequest

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateFlexRolloverSettingsRequest from a JSON string
update_flex_rollover_settings_request_instance = UpdateFlexRolloverSettingsRequest.from_json(json)
# print the JSON string representation of the object
print(UpdateFlexRolloverSettingsRequest.to_json())

# convert the object into a dict
update_flex_rollover_settings_request_dict = update_flex_rollover_settings_request_instance.to_dict()
# create an instance of UpdateFlexRolloverSettingsRequest from a dict
update_flex_rollover_settings_request_from_dict = UpdateFlexRolloverSettingsRequest.from_dict(update_flex_rollover_settings_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


