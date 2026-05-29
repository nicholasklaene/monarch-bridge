# MarkNotificationAsReadResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**MarkNotificationAsReadResponseData**](MarkNotificationAsReadResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.mark_notification_as_read_response import MarkNotificationAsReadResponse

# TODO update the JSON string below
json = "{}"
# create an instance of MarkNotificationAsReadResponse from a JSON string
mark_notification_as_read_response_instance = MarkNotificationAsReadResponse.from_json(json)
# print the JSON string representation of the object
print(MarkNotificationAsReadResponse.to_json())

# convert the object into a dict
mark_notification_as_read_response_dict = mark_notification_as_read_response_instance.to_dict()
# create an instance of MarkNotificationAsReadResponse from a dict
mark_notification_as_read_response_from_dict = MarkNotificationAsReadResponse.from_dict(mark_notification_as_read_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


