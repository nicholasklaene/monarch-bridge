# ListPaychecksResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**paychecks** | [**List[Paycheck]**](Paycheck.md) |  | 

## Example

```python
from monarch_bridge_client.models.list_paychecks_response_data import ListPaychecksResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of ListPaychecksResponseData from a JSON string
list_paychecks_response_data_instance = ListPaychecksResponseData.from_json(json)
# print the JSON string representation of the object
print(ListPaychecksResponseData.to_json())

# convert the object into a dict
list_paychecks_response_data_dict = list_paychecks_response_data_instance.to_dict()
# create an instance of ListPaychecksResponseData from a dict
list_paychecks_response_data_from_dict = ListPaychecksResponseData.from_dict(list_paychecks_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


