# MergeRecurringStreamsResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**stream** | [**RecurringStreamRef**](RecurringStreamRef.md) |  | 

## Example

```python
from monarch_bridge_client.models.merge_recurring_streams_response_data import MergeRecurringStreamsResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of MergeRecurringStreamsResponseData from a JSON string
merge_recurring_streams_response_data_instance = MergeRecurringStreamsResponseData.from_json(json)
# print the JSON string representation of the object
print(MergeRecurringStreamsResponseData.to_json())

# convert the object into a dict
merge_recurring_streams_response_data_dict = merge_recurring_streams_response_data_instance.to_dict()
# create an instance of MergeRecurringStreamsResponseData from a dict
merge_recurring_streams_response_data_from_dict = MergeRecurringStreamsResponseData.from_dict(merge_recurring_streams_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


