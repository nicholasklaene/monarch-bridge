# GetNotificationPreferencesResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetNotificationPreferencesResponseData**](GetNotificationPreferencesResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_notification_preferences_response import GetNotificationPreferencesResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetNotificationPreferencesResponse from a JSON string
get_notification_preferences_response_instance = GetNotificationPreferencesResponse.from_json(json)
# print the JSON string representation of the object
print(GetNotificationPreferencesResponse.to_json())

# convert the object into a dict
get_notification_preferences_response_dict = get_notification_preferences_response_instance.to_dict()
# create an instance of GetNotificationPreferencesResponse from a dict
get_notification_preferences_response_from_dict = GetNotificationPreferencesResponse.from_dict(get_notification_preferences_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


