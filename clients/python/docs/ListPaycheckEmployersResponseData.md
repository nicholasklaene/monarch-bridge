# ListPaycheckEmployersResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**employers** | [**List[PaycheckEmployer]**](PaycheckEmployer.md) |  | 
**total_count** | **int** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.list_paycheck_employers_response_data import ListPaycheckEmployersResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of ListPaycheckEmployersResponseData from a JSON string
list_paycheck_employers_response_data_instance = ListPaycheckEmployersResponseData.from_json(json)
# print the JSON string representation of the object
print(ListPaycheckEmployersResponseData.to_json())

# convert the object into a dict
list_paycheck_employers_response_data_dict = list_paycheck_employers_response_data_instance.to_dict()
# create an instance of ListPaycheckEmployersResponseData from a dict
list_paycheck_employers_response_data_from_dict = ListPaycheckEmployersResponseData.from_dict(list_paycheck_employers_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


