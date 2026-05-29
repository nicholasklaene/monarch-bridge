# DeletePaycheckEmployerResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**DeleteAccountResponseData**](DeleteAccountResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.delete_paycheck_employer_response import DeletePaycheckEmployerResponse

# TODO update the JSON string below
json = "{}"
# create an instance of DeletePaycheckEmployerResponse from a JSON string
delete_paycheck_employer_response_instance = DeletePaycheckEmployerResponse.from_json(json)
# print the JSON string representation of the object
print(DeletePaycheckEmployerResponse.to_json())

# convert the object into a dict
delete_paycheck_employer_response_dict = delete_paycheck_employer_response_instance.to_dict()
# create an instance of DeletePaycheckEmployerResponse from a dict
delete_paycheck_employer_response_from_dict = DeletePaycheckEmployerResponse.from_dict(delete_paycheck_employer_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


