# UpdateFlexRolloverSettingsResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**UpdateFlexRolloverSettingsResponseData**](UpdateFlexRolloverSettingsResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.update_flex_rollover_settings_response import UpdateFlexRolloverSettingsResponse

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateFlexRolloverSettingsResponse from a JSON string
update_flex_rollover_settings_response_instance = UpdateFlexRolloverSettingsResponse.from_json(json)
# print the JSON string representation of the object
print(UpdateFlexRolloverSettingsResponse.to_json())

# convert the object into a dict
update_flex_rollover_settings_response_dict = update_flex_rollover_settings_response_instance.to_dict()
# create an instance of UpdateFlexRolloverSettingsResponse from a dict
update_flex_rollover_settings_response_from_dict = UpdateFlexRolloverSettingsResponse.from_dict(update_flex_rollover_settings_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


