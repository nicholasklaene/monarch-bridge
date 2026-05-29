# ListRecurringAggregateResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**ListRecurringAggregateResponseData**](ListRecurringAggregateResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.list_recurring_aggregate_response import ListRecurringAggregateResponse

# TODO update the JSON string below
json = "{}"
# create an instance of ListRecurringAggregateResponse from a JSON string
list_recurring_aggregate_response_instance = ListRecurringAggregateResponse.from_json(json)
# print the JSON string representation of the object
print(ListRecurringAggregateResponse.to_json())

# convert the object into a dict
list_recurring_aggregate_response_dict = list_recurring_aggregate_response_instance.to_dict()
# create an instance of ListRecurringAggregateResponse from a dict
list_recurring_aggregate_response_from_dict = ListRecurringAggregateResponse.from_dict(list_recurring_aggregate_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


