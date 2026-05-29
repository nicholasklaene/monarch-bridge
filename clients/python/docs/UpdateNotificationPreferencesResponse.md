# UpdateNotificationPreferencesResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**UpdateNotificationPreferencesResponseData**](UpdateNotificationPreferencesResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.update_notification_preferences_response import UpdateNotificationPreferencesResponse

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateNotificationPreferencesResponse from a JSON string
update_notification_preferences_response_instance = UpdateNotificationPreferencesResponse.from_json(json)
# print the JSON string representation of the object
print(UpdateNotificationPreferencesResponse.to_json())

# convert the object into a dict
update_notification_preferences_response_dict = update_notification_preferences_response_instance.to_dict()
# create an instance of UpdateNotificationPreferencesResponse from a dict
update_notification_preferences_response_from_dict = UpdateNotificationPreferencesResponse.from_dict(update_notification_preferences_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


