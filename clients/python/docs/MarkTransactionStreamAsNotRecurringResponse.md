# MarkTransactionStreamAsNotRecurringResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**MarkTransactionStreamAsNotRecurringResponseData**](MarkTransactionStreamAsNotRecurringResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.mark_transaction_stream_as_not_recurring_response import MarkTransactionStreamAsNotRecurringResponse

# TODO update the JSON string below
json = "{}"
# create an instance of MarkTransactionStreamAsNotRecurringResponse from a JSON string
mark_transaction_stream_as_not_recurring_response_instance = MarkTransactionStreamAsNotRecurringResponse.from_json(json)
# print the JSON string representation of the object
print(MarkTransactionStreamAsNotRecurringResponse.to_json())

# convert the object into a dict
mark_transaction_stream_as_not_recurring_response_dict = mark_transaction_stream_as_not_recurring_response_instance.to_dict()
# create an instance of MarkTransactionStreamAsNotRecurringResponse from a dict
mark_transaction_stream_as_not_recurring_response_from_dict = MarkTransactionStreamAsNotRecurringResponse.from_dict(mark_transaction_stream_as_not_recurring_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


