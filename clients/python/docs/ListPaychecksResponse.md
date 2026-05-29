# ListPaychecksResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**ListPaychecksResponseData**](ListPaychecksResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.list_paychecks_response import ListPaychecksResponse

# TODO update the JSON string below
json = "{}"
# create an instance of ListPaychecksResponse from a JSON string
list_paychecks_response_instance = ListPaychecksResponse.from_json(json)
# print the JSON string representation of the object
print(ListPaychecksResponse.to_json())

# convert the object into a dict
list_paychecks_response_dict = list_paychecks_response_instance.to_dict()
# create an instance of ListPaychecksResponse from a dict
list_paychecks_response_from_dict = ListPaychecksResponse.from_dict(list_paychecks_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


