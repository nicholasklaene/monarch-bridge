# MergeRecurringStreamsResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**MergeRecurringStreamsResponseData**](MergeRecurringStreamsResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.merge_recurring_streams_response import MergeRecurringStreamsResponse

# TODO update the JSON string below
json = "{}"
# create an instance of MergeRecurringStreamsResponse from a JSON string
merge_recurring_streams_response_instance = MergeRecurringStreamsResponse.from_json(json)
# print the JSON string representation of the object
print(MergeRecurringStreamsResponse.to_json())

# convert the object into a dict
merge_recurring_streams_response_dict = merge_recurring_streams_response_instance.to_dict()
# create an instance of MergeRecurringStreamsResponse from a dict
merge_recurring_streams_response_from_dict = MergeRecurringStreamsResponse.from_dict(merge_recurring_streams_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


