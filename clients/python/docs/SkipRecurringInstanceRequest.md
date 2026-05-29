# SkipRecurringInstanceRequest

Skip one expected occurrence of a recurring stream.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**skip_date** | **date** |  | 

## Example

```python
from monarch_bridge_client.models.skip_recurring_instance_request import SkipRecurringInstanceRequest

# TODO update the JSON string below
json = "{}"
# create an instance of SkipRecurringInstanceRequest from a JSON string
skip_recurring_instance_request_instance = SkipRecurringInstanceRequest.from_json(json)
# print the JSON string representation of the object
print(SkipRecurringInstanceRequest.to_json())

# convert the object into a dict
skip_recurring_instance_request_dict = skip_recurring_instance_request_instance.to_dict()
# create an instance of SkipRecurringInstanceRequest from a dict
skip_recurring_instance_request_from_dict = SkipRecurringInstanceRequest.from_dict(skip_recurring_instance_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


