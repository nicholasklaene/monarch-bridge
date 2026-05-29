# ListPaycheckEmployersResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**ListPaycheckEmployersResponseData**](ListPaycheckEmployersResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.list_paycheck_employers_response import ListPaycheckEmployersResponse

# TODO update the JSON string below
json = "{}"
# create an instance of ListPaycheckEmployersResponse from a JSON string
list_paycheck_employers_response_instance = ListPaycheckEmployersResponse.from_json(json)
# print the JSON string representation of the object
print(ListPaycheckEmployersResponse.to_json())

# convert the object into a dict
list_paycheck_employers_response_dict = list_paycheck_employers_response_instance.to_dict()
# create an instance of ListPaycheckEmployersResponse from a dict
list_paycheck_employers_response_from_dict = ListPaycheckEmployersResponse.from_dict(list_paycheck_employers_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


