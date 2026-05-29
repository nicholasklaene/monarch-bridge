# ListAllRecurringResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**items** | **List[Dict[str, object]]** | One entry per recurring transaction stream (NOT per occurrence). | 

## Example

```python
from monarch_bridge_client.models.list_all_recurring_response_data import ListAllRecurringResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of ListAllRecurringResponseData from a JSON string
list_all_recurring_response_data_instance = ListAllRecurringResponseData.from_json(json)
# print the JSON string representation of the object
print(ListAllRecurringResponseData.to_json())

# convert the object into a dict
list_all_recurring_response_data_dict = list_all_recurring_response_data_instance.to_dict()
# create an instance of ListAllRecurringResponseData from a dict
list_all_recurring_response_data_from_dict = ListAllRecurringResponseData.from_dict(list_all_recurring_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


