# SetChannelNotificationPrefsRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**weekly_recap** | **bool** |  | [optional] 
**budget_alerts** | **bool** |  | [optional] 
**bill_reminders** | **bool** |  | [optional] 
**goal_updates** | **bool** |  | [optional] 
**marketing_tips** | **bool** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.set_channel_notification_prefs_request import SetChannelNotificationPrefsRequest

# TODO update the JSON string below
json = "{}"
# create an instance of SetChannelNotificationPrefsRequest from a JSON string
set_channel_notification_prefs_request_instance = SetChannelNotificationPrefsRequest.from_json(json)
# print the JSON string representation of the object
print(SetChannelNotificationPrefsRequest.to_json())

# convert the object into a dict
set_channel_notification_prefs_request_dict = set_channel_notification_prefs_request_instance.to_dict()
# create an instance of SetChannelNotificationPrefsRequest from a dict
set_channel_notification_prefs_request_from_dict = SetChannelNotificationPrefsRequest.from_dict(set_channel_notification_prefs_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


