# GetEmailNotificationPrefsResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetEmailNotificationPrefsResponseData**](GetEmailNotificationPrefsResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_email_notification_prefs_response import GetEmailNotificationPrefsResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetEmailNotificationPrefsResponse from a JSON string
get_email_notification_prefs_response_instance = GetEmailNotificationPrefsResponse.from_json(json)
# print the JSON string representation of the object
print(GetEmailNotificationPrefsResponse.to_json())

# convert the object into a dict
get_email_notification_prefs_response_dict = get_email_notification_prefs_response_instance.to_dict()
# create an instance of GetEmailNotificationPrefsResponse from a dict
get_email_notification_prefs_response_from_dict = GetEmailNotificationPrefsResponse.from_dict(get_email_notification_prefs_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


