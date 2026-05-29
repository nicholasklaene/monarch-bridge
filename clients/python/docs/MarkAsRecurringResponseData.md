# MarkAsRecurringResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**success** | **bool** |  | 
**stream** | [**RecurringStreamRef**](RecurringStreamRef.md) |  | 

## Example

```python
from monarch_bridge_client.models.mark_as_recurring_response_data import MarkAsRecurringResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of MarkAsRecurringResponseData from a JSON string
mark_as_recurring_response_data_instance = MarkAsRecurringResponseData.from_json(json)
# print the JSON string representation of the object
print(MarkAsRecurringResponseData.to_json())

# convert the object into a dict
mark_as_recurring_response_data_dict = mark_as_recurring_response_data_instance.to_dict()
# create an instance of MarkAsRecurringResponseData from a dict
mark_as_recurring_response_data_from_dict = MarkAsRecurringResponseData.from_dict(mark_as_recurring_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


