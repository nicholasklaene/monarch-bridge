# MarkAsRecurringRequest

Tell Monarch a transaction IS the start of a recurring stream. `frequency` is one of `monthly`, `weekly`, `quarterly`, `yearly`. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**frequency** | **str** |  | 

## Example

```python
from monarch_bridge_client.models.mark_as_recurring_request import MarkAsRecurringRequest

# TODO update the JSON string below
json = "{}"
# create an instance of MarkAsRecurringRequest from a JSON string
mark_as_recurring_request_instance = MarkAsRecurringRequest.from_json(json)
# print the JSON string representation of the object
print(MarkAsRecurringRequest.to_json())

# convert the object into a dict
mark_as_recurring_request_dict = mark_as_recurring_request_instance.to_dict()
# create an instance of MarkAsRecurringRequest from a dict
mark_as_recurring_request_from_dict = MarkAsRecurringRequest.from_dict(mark_as_recurring_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


