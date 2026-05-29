# MarkNotificationAsReadResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**read_at** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.mark_notification_as_read_response_data import MarkNotificationAsReadResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of MarkNotificationAsReadResponseData from a JSON string
mark_notification_as_read_response_data_instance = MarkNotificationAsReadResponseData.from_json(json)
# print the JSON string representation of the object
print(MarkNotificationAsReadResponseData.to_json())

# convert the object into a dict
mark_notification_as_read_response_data_dict = mark_notification_as_read_response_data_instance.to_dict()
# create an instance of MarkNotificationAsReadResponseData from a dict
mark_notification_as_read_response_data_from_dict = MarkNotificationAsReadResponseData.from_dict(mark_notification_as_read_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


