# GetEmailNotificationPrefsResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**prefs** | [**ChannelNotificationPrefs**](ChannelNotificationPrefs.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_email_notification_prefs_response_data import GetEmailNotificationPrefsResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetEmailNotificationPrefsResponseData from a JSON string
get_email_notification_prefs_response_data_instance = GetEmailNotificationPrefsResponseData.from_json(json)
# print the JSON string representation of the object
print(GetEmailNotificationPrefsResponseData.to_json())

# convert the object into a dict
get_email_notification_prefs_response_data_dict = get_email_notification_prefs_response_data_instance.to_dict()
# create an instance of GetEmailNotificationPrefsResponseData from a dict
get_email_notification_prefs_response_data_from_dict = GetEmailNotificationPrefsResponseData.from_dict(get_email_notification_prefs_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


