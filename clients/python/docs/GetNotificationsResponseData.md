# GetNotificationsResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**has_next_page** | **bool** |  | [optional] 
**end_cursor** | **str** |  | [optional] 
**edges** | [**List[GetNotificationsResponseDataEdgesInner]**](GetNotificationsResponseDataEdgesInner.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_notifications_response_data import GetNotificationsResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetNotificationsResponseData from a JSON string
get_notifications_response_data_instance = GetNotificationsResponseData.from_json(json)
# print the JSON string representation of the object
print(GetNotificationsResponseData.to_json())

# convert the object into a dict
get_notifications_response_data_dict = get_notifications_response_data_instance.to_dict()
# create an instance of GetNotificationsResponseData from a dict
get_notifications_response_data_from_dict = GetNotificationsResponseData.from_dict(get_notifications_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


