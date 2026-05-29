# MarkAllNotificationsAsReadResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**edges** | [**List[MarkNotificationAsReadResponseData]**](MarkNotificationAsReadResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.mark_all_notifications_as_read_response_data import MarkAllNotificationsAsReadResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of MarkAllNotificationsAsReadResponseData from a JSON string
mark_all_notifications_as_read_response_data_instance = MarkAllNotificationsAsReadResponseData.from_json(json)
# print the JSON string representation of the object
print(MarkAllNotificationsAsReadResponseData.to_json())

# convert the object into a dict
mark_all_notifications_as_read_response_data_dict = mark_all_notifications_as_read_response_data_instance.to_dict()
# create an instance of MarkAllNotificationsAsReadResponseData from a dict
mark_all_notifications_as_read_response_data_from_dict = MarkAllNotificationsAsReadResponseData.from_dict(mark_all_notifications_as_read_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


