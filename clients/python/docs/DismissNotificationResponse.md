# DismissNotificationResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**DismissNotificationResponseData**](DismissNotificationResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.dismiss_notification_response import DismissNotificationResponse

# TODO update the JSON string below
json = "{}"
# create an instance of DismissNotificationResponse from a JSON string
dismiss_notification_response_instance = DismissNotificationResponse.from_json(json)
# print the JSON string representation of the object
print(DismissNotificationResponse.to_json())

# convert the object into a dict
dismiss_notification_response_dict = dismiss_notification_response_instance.to_dict()
# create an instance of DismissNotificationResponse from a dict
dismiss_notification_response_from_dict = DismissNotificationResponse.from_dict(dismiss_notification_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


