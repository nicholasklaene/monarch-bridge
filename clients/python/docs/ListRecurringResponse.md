# ListRecurringResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**ListRecurringResponseData**](ListRecurringResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.list_recurring_response import ListRecurringResponse

# TODO update the JSON string below
json = "{}"
# create an instance of ListRecurringResponse from a JSON string
list_recurring_response_instance = ListRecurringResponse.from_json(json)
# print the JSON string representation of the object
print(ListRecurringResponse.to_json())

# convert the object into a dict
list_recurring_response_dict = list_recurring_response_instance.to_dict()
# create an instance of ListRecurringResponse from a dict
list_recurring_response_from_dict = ListRecurringResponse.from_dict(list_recurring_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


