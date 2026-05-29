# GetChannelNotificationPrefsResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetEmailNotificationPrefsResponseData**](GetEmailNotificationPrefsResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_channel_notification_prefs_response import GetChannelNotificationPrefsResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetChannelNotificationPrefsResponse from a JSON string
get_channel_notification_prefs_response_instance = GetChannelNotificationPrefsResponse.from_json(json)
# print the JSON string representation of the object
print(GetChannelNotificationPrefsResponse.to_json())

# convert the object into a dict
get_channel_notification_prefs_response_dict = get_channel_notification_prefs_response_instance.to_dict()
# create an instance of GetChannelNotificationPrefsResponse from a dict
get_channel_notification_prefs_response_from_dict = GetChannelNotificationPrefsResponse.from_dict(get_channel_notification_prefs_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


