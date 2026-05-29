# UpdateNotificationPreferencesRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**email_enabled** | **bool** |  | [optional] 
**push_enabled** | **bool** |  | [optional] 
**in_app_enabled** | **bool** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.update_notification_preferences_request import UpdateNotificationPreferencesRequest

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateNotificationPreferencesRequest from a JSON string
update_notification_preferences_request_instance = UpdateNotificationPreferencesRequest.from_json(json)
# print the JSON string representation of the object
print(UpdateNotificationPreferencesRequest.to_json())

# convert the object into a dict
update_notification_preferences_request_dict = update_notification_preferences_request_instance.to_dict()
# create an instance of UpdateNotificationPreferencesRequest from a dict
update_notification_preferences_request_from_dict = UpdateNotificationPreferencesRequest.from_dict(update_notification_preferences_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


