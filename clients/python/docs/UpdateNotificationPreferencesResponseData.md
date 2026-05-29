# UpdateNotificationPreferencesResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**preference** | [**NotificationPreference**](NotificationPreference.md) |  | 

## Example

```python
from monarch_bridge_client.models.update_notification_preferences_response_data import UpdateNotificationPreferencesResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateNotificationPreferencesResponseData from a JSON string
update_notification_preferences_response_data_instance = UpdateNotificationPreferencesResponseData.from_json(json)
# print the JSON string representation of the object
print(UpdateNotificationPreferencesResponseData.to_json())

# convert the object into a dict
update_notification_preferences_response_data_dict = update_notification_preferences_response_data_instance.to_dict()
# create an instance of UpdateNotificationPreferencesResponseData from a dict
update_notification_preferences_response_data_from_dict = UpdateNotificationPreferencesResponseData.from_dict(update_notification_preferences_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


