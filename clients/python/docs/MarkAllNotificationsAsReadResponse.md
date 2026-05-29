# MarkAllNotificationsAsReadResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**MarkAllNotificationsAsReadResponseData**](MarkAllNotificationsAsReadResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.mark_all_notifications_as_read_response import MarkAllNotificationsAsReadResponse

# TODO update the JSON string below
json = "{}"
# create an instance of MarkAllNotificationsAsReadResponse from a JSON string
mark_all_notifications_as_read_response_instance = MarkAllNotificationsAsReadResponse.from_json(json)
# print the JSON string representation of the object
print(MarkAllNotificationsAsReadResponse.to_json())

# convert the object into a dict
mark_all_notifications_as_read_response_dict = mark_all_notifications_as_read_response_instance.to_dict()
# create an instance of MarkAllNotificationsAsReadResponse from a dict
mark_all_notifications_as_read_response_from_dict = MarkAllNotificationsAsReadResponse.from_dict(mark_all_notifications_as_read_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


