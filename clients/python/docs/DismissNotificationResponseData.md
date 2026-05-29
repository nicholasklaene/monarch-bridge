# DismissNotificationResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**dismissed_at** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.dismiss_notification_response_data import DismissNotificationResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of DismissNotificationResponseData from a JSON string
dismiss_notification_response_data_instance = DismissNotificationResponseData.from_json(json)
# print the JSON string representation of the object
print(DismissNotificationResponseData.to_json())

# convert the object into a dict
dismiss_notification_response_data_dict = dismiss_notification_response_data_instance.to_dict()
# create an instance of DismissNotificationResponseData from a dict
dismiss_notification_response_data_from_dict = DismissNotificationResponseData.from_dict(dismiss_notification_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


