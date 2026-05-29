# ListRecurringStreamsResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**ListRecurringStreamsResponseData**](ListRecurringStreamsResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.list_recurring_streams_response import ListRecurringStreamsResponse

# TODO update the JSON string below
json = "{}"
# create an instance of ListRecurringStreamsResponse from a JSON string
list_recurring_streams_response_instance = ListRecurringStreamsResponse.from_json(json)
# print the JSON string representation of the object
print(ListRecurringStreamsResponse.to_json())

# convert the object into a dict
list_recurring_streams_response_dict = list_recurring_streams_response_instance.to_dict()
# create an instance of ListRecurringStreamsResponse from a dict
list_recurring_streams_response_from_dict = ListRecurringStreamsResponse.from_dict(list_recurring_streams_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


