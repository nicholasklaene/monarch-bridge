# ListAllRecurringResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**ListAllRecurringResponseData**](ListAllRecurringResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.list_all_recurring_response import ListAllRecurringResponse

# TODO update the JSON string below
json = "{}"
# create an instance of ListAllRecurringResponse from a JSON string
list_all_recurring_response_instance = ListAllRecurringResponse.from_json(json)
# print the JSON string representation of the object
print(ListAllRecurringResponse.to_json())

# convert the object into a dict
list_all_recurring_response_dict = list_all_recurring_response_instance.to_dict()
# create an instance of ListAllRecurringResponse from a dict
list_all_recurring_response_from_dict = ListAllRecurringResponse.from_dict(list_all_recurring_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


