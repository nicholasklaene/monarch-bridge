# ListRecurringResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**items** | **List[Dict[str, object]]** | One entry per expected recurring-transaction occurrence in the window. | 

## Example

```python
from monarch_bridge_client.models.list_recurring_response_data import ListRecurringResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of ListRecurringResponseData from a JSON string
list_recurring_response_data_instance = ListRecurringResponseData.from_json(json)
# print the JSON string representation of the object
print(ListRecurringResponseData.to_json())

# convert the object into a dict
list_recurring_response_data_dict = list_recurring_response_data_instance.to_dict()
# create an instance of ListRecurringResponseData from a dict
list_recurring_response_data_from_dict = ListRecurringResponseData.from_dict(list_recurring_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


