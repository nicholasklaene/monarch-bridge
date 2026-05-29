# RecurringResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**ListRecurringResponseData**](ListRecurringResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.recurring_response import RecurringResponse

# TODO update the JSON string below
json = "{}"
# create an instance of RecurringResponse from a JSON string
recurring_response_instance = RecurringResponse.from_json(json)
# print the JSON string representation of the object
print(RecurringResponse.to_json())

# convert the object into a dict
recurring_response_dict = recurring_response_instance.to_dict()
# create an instance of RecurringResponse from a dict
recurring_response_from_dict = RecurringResponse.from_dict(recurring_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


