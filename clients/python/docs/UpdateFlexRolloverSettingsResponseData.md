# UpdateFlexRolloverSettingsResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**start_month** | **str** |  | [optional] 
**starting_balance** | **float** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.update_flex_rollover_settings_response_data import UpdateFlexRolloverSettingsResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateFlexRolloverSettingsResponseData from a JSON string
update_flex_rollover_settings_response_data_instance = UpdateFlexRolloverSettingsResponseData.from_json(json)
# print the JSON string representation of the object
print(UpdateFlexRolloverSettingsResponseData.to_json())

# convert the object into a dict
update_flex_rollover_settings_response_data_dict = update_flex_rollover_settings_response_data_instance.to_dict()
# create an instance of UpdateFlexRolloverSettingsResponseData from a dict
update_flex_rollover_settings_response_data_from_dict = UpdateFlexRolloverSettingsResponseData.from_dict(update_flex_rollover_settings_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


