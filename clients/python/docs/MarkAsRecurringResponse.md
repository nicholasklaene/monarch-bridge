# MarkAsRecurringResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**MarkAsRecurringResponseData**](MarkAsRecurringResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.mark_as_recurring_response import MarkAsRecurringResponse

# TODO update the JSON string below
json = "{}"
# create an instance of MarkAsRecurringResponse from a JSON string
mark_as_recurring_response_instance = MarkAsRecurringResponse.from_json(json)
# print the JSON string representation of the object
print(MarkAsRecurringResponse.to_json())

# convert the object into a dict
mark_as_recurring_response_dict = mark_as_recurring_response_instance.to_dict()
# create an instance of MarkAsRecurringResponse from a dict
mark_as_recurring_response_from_dict = MarkAsRecurringResponse.from_dict(mark_as_recurring_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


