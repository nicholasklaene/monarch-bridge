# ListRecurringAggregateResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**aggregate** | **Dict[str, object]** | Pass-through from Monarch&#39;s &#x60;aggregatedRecurringItems&#x60; - &#x60;groups[]&#x60; (per status) plus &#x60;aggregatedSummary&#x60; (expense/creditCard/income totals across the window).  | [optional] 

## Example

```python
from monarch_bridge_client.models.list_recurring_aggregate_response_data import ListRecurringAggregateResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of ListRecurringAggregateResponseData from a JSON string
list_recurring_aggregate_response_data_instance = ListRecurringAggregateResponseData.from_json(json)
# print the JSON string representation of the object
print(ListRecurringAggregateResponseData.to_json())

# convert the object into a dict
list_recurring_aggregate_response_data_dict = list_recurring_aggregate_response_data_instance.to_dict()
# create an instance of ListRecurringAggregateResponseData from a dict
list_recurring_aggregate_response_data_from_dict = ListRecurringAggregateResponseData.from_dict(list_recurring_aggregate_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


