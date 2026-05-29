# UpdatePaycheckEmployerResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**CreatePaycheckEmployerResponseData**](CreatePaycheckEmployerResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.update_paycheck_employer_response import UpdatePaycheckEmployerResponse

# TODO update the JSON string below
json = "{}"
# create an instance of UpdatePaycheckEmployerResponse from a JSON string
update_paycheck_employer_response_instance = UpdatePaycheckEmployerResponse.from_json(json)
# print the JSON string representation of the object
print(UpdatePaycheckEmployerResponse.to_json())

# convert the object into a dict
update_paycheck_employer_response_dict = update_paycheck_employer_response_instance.to_dict()
# create an instance of UpdatePaycheckEmployerResponse from a dict
update_paycheck_employer_response_from_dict = UpdatePaycheckEmployerResponse.from_dict(update_paycheck_employer_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


