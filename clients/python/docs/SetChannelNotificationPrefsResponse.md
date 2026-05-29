# SetChannelNotificationPrefsResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetEmailNotificationPrefsResponseData**](GetEmailNotificationPrefsResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.set_channel_notification_prefs_response import SetChannelNotificationPrefsResponse

# TODO update the JSON string below
json = "{}"
# create an instance of SetChannelNotificationPrefsResponse from a JSON string
set_channel_notification_prefs_response_instance = SetChannelNotificationPrefsResponse.from_json(json)
# print the JSON string representation of the object
print(SetChannelNotificationPrefsResponse.to_json())

# convert the object into a dict
set_channel_notification_prefs_response_dict = set_channel_notification_prefs_response_instance.to_dict()
# create an instance of SetChannelNotificationPrefsResponse from a dict
set_channel_notification_prefs_response_from_dict = SetChannelNotificationPrefsResponse.from_dict(set_channel_notification_prefs_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


