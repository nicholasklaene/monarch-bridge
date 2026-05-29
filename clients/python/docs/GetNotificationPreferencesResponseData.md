# GetNotificationPreferencesResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**preferences** | [**List[NotificationPreference]**](NotificationPreference.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_notification_preferences_response_data import GetNotificationPreferencesResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetNotificationPreferencesResponseData from a JSON string
get_notification_preferences_response_data_instance = GetNotificationPreferencesResponseData.from_json(json)
# print the JSON string representation of the object
print(GetNotificationPreferencesResponseData.to_json())

# convert the object into a dict
get_notification_preferences_response_data_dict = get_notification_preferences_response_data_instance.to_dict()
# create an instance of GetNotificationPreferencesResponseData from a dict
get_notification_preferences_response_data_from_dict = GetNotificationPreferencesResponseData.from_dict(get_notification_preferences_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


