# ChannelNotificationPrefs


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
from monarch_bridge_client.models.channel_notification_prefs import ChannelNotificationPrefs

# TODO update the JSON string below
json = "{}"
# create an instance of ChannelNotificationPrefs from a JSON string
channel_notification_prefs_instance = ChannelNotificationPrefs.from_json(json)
# print the JSON string representation of the object
print(ChannelNotificationPrefs.to_json())

# convert the object into a dict
channel_notification_prefs_dict = channel_notification_prefs_instance.to_dict()
# create an instance of ChannelNotificationPrefs from a dict
channel_notification_prefs_from_dict = ChannelNotificationPrefs.from_dict(channel_notification_prefs_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


