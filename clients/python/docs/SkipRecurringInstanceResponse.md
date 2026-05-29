# SkipRecurringInstanceResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**SkipRecurringInstanceResponseData**](SkipRecurringInstanceResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.skip_recurring_instance_response import SkipRecurringInstanceResponse

# TODO update the JSON string below
json = "{}"
# create an instance of SkipRecurringInstanceResponse from a JSON string
skip_recurring_instance_response_instance = SkipRecurringInstanceResponse.from_json(json)
# print the JSON string representation of the object
print(SkipRecurringInstanceResponse.to_json())

# convert the object into a dict
skip_recurring_instance_response_dict = skip_recurring_instance_response_instance.to_dict()
# create an instance of SkipRecurringInstanceResponse from a dict
skip_recurring_instance_response_from_dict = SkipRecurringInstanceResponse.from_dict(skip_recurring_instance_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


