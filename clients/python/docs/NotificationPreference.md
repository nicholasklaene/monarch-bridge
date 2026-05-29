# NotificationPreference


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**group** | **str** |  | [optional] 
**type** | **str** |  | [optional] 
**title** | **str** |  | [optional] 
**description** | **str** |  | [optional] 
**email_enabled** | **bool** |  | [optional] 
**push_enabled** | **bool** |  | [optional] 
**in_app_enabled** | **bool** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.notification_preference import NotificationPreference

# TODO update the JSON string below
json = "{}"
# create an instance of NotificationPreference from a JSON string
notification_preference_instance = NotificationPreference.from_json(json)
# print the JSON string representation of the object
print(NotificationPreference.to_json())

# convert the object into a dict
notification_preference_dict = notification_preference_instance.to_dict()
# create an instance of NotificationPreference from a dict
notification_preference_from_dict = NotificationPreference.from_dict(notification_preference_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


