# RecurringStreamRef


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**name** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.recurring_stream_ref import RecurringStreamRef

# TODO update the JSON string below
json = "{}"
# create an instance of RecurringStreamRef from a JSON string
recurring_stream_ref_instance = RecurringStreamRef.from_json(json)
# print the JSON string representation of the object
print(RecurringStreamRef.to_json())

# convert the object into a dict
recurring_stream_ref_dict = recurring_stream_ref_instance.to_dict()
# create an instance of RecurringStreamRef from a dict
recurring_stream_ref_from_dict = RecurringStreamRef.from_dict(recurring_stream_ref_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


