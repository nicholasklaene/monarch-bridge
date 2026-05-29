# ListRecurringStreamsResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**streams** | **List[Dict[str, object]]** | Stream definitions backing each recurring rule. | 

## Example

```python
from monarch_bridge_client.models.list_recurring_streams_response_data import ListRecurringStreamsResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of ListRecurringStreamsResponseData from a JSON string
list_recurring_streams_response_data_instance = ListRecurringStreamsResponseData.from_json(json)
# print the JSON string representation of the object
print(ListRecurringStreamsResponseData.to_json())

# convert the object into a dict
list_recurring_streams_response_data_dict = list_recurring_streams_response_data_instance.to_dict()
# create an instance of ListRecurringStreamsResponseData from a dict
list_recurring_streams_response_data_from_dict = ListRecurringStreamsResponseData.from_dict(list_recurring_streams_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


