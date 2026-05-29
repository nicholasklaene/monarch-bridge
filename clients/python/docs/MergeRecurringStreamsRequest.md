# MergeRecurringStreamsRequest

Merge two or more recurring streams into one. `primaryStreamId` survives; all `mergedStreamIds` are absorbed into it. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**primary_stream_id** | **str** |  | 
**merged_stream_ids** | **List[str]** |  | 
**new_name** | **str** | Optional new display name for the merged stream. | [optional] 

## Example

```python
from monarch_bridge_client.models.merge_recurring_streams_request import MergeRecurringStreamsRequest

# TODO update the JSON string below
json = "{}"
# create an instance of MergeRecurringStreamsRequest from a JSON string
merge_recurring_streams_request_instance = MergeRecurringStreamsRequest.from_json(json)
# print the JSON string representation of the object
print(MergeRecurringStreamsRequest.to_json())

# convert the object into a dict
merge_recurring_streams_request_dict = merge_recurring_streams_request_instance.to_dict()
# create an instance of MergeRecurringStreamsRequest from a dict
merge_recurring_streams_request_from_dict = MergeRecurringStreamsRequest.from_dict(merge_recurring_streams_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


