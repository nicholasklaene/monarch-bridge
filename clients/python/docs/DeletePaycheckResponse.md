# DeletePaycheckResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**DeleteAccountResponseData**](DeleteAccountResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.delete_paycheck_response import DeletePaycheckResponse

# TODO update the JSON string below
json = "{}"
# create an instance of DeletePaycheckResponse from a JSON string
delete_paycheck_response_instance = DeletePaycheckResponse.from_json(json)
# print the JSON string representation of the object
print(DeletePaycheckResponse.to_json())

# convert the object into a dict
delete_paycheck_response_dict = delete_paycheck_response_instance.to_dict()
# create an instance of DeletePaycheckResponse from a dict
delete_paycheck_response_from_dict = DeletePaycheckResponse.from_dict(delete_paycheck_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


