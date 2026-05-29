# GetNotificationsResponseDataEdgesInner


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**created_at** | **str** |  | [optional] 
**read_at** | **str** |  | [optional] 
**title** | **str** |  | [optional] 
**body** | **str** |  | [optional] 
**action** | **str** |  | [optional] 
**action_label** | **str** |  | [optional] 
**event_priority** | **str** |  | [optional] 
**is_pinned** | **bool** |  | [optional] 
**logo** | **str** |  | [optional] 
**dismissed_at** | **str** |  | [optional] 
**event_type** | **str** |  | [optional] 
**secondary_url** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.get_notifications_response_data_edges_inner import GetNotificationsResponseDataEdgesInner

# TODO update the JSON string below
json = "{}"
# create an instance of GetNotificationsResponseDataEdgesInner from a JSON string
get_notifications_response_data_edges_inner_instance = GetNotificationsResponseDataEdgesInner.from_json(json)
# print the JSON string representation of the object
print(GetNotificationsResponseDataEdgesInner.to_json())

# convert the object into a dict
get_notifications_response_data_edges_inner_dict = get_notifications_response_data_edges_inner_instance.to_dict()
# create an instance of GetNotificationsResponseDataEdgesInner from a dict
get_notifications_response_data_edges_inner_from_dict = GetNotificationsResponseDataEdgesInner.from_dict(get_notifications_response_data_edges_inner_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


