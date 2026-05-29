# MarkAsNotRecurringResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**MarkTransactionStreamAsNotRecurringResponseData**](MarkTransactionStreamAsNotRecurringResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.mark_as_not_recurring_response import MarkAsNotRecurringResponse

# TODO update the JSON string below
json = "{}"
# create an instance of MarkAsNotRecurringResponse from a JSON string
mark_as_not_recurring_response_instance = MarkAsNotRecurringResponse.from_json(json)
# print the JSON string representation of the object
print(MarkAsNotRecurringResponse.to_json())

# convert the object into a dict
mark_as_not_recurring_response_dict = mark_as_not_recurring_response_instance.to_dict()
# create an instance of MarkAsNotRecurringResponse from a dict
mark_as_not_recurring_response_from_dict = MarkAsNotRecurringResponse.from_dict(mark_as_not_recurring_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


