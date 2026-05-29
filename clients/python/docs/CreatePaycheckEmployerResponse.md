# CreatePaycheckEmployerResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**CreatePaycheckEmployerResponseData**](CreatePaycheckEmployerResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.create_paycheck_employer_response import CreatePaycheckEmployerResponse

# TODO update the JSON string below
json = "{}"
# create an instance of CreatePaycheckEmployerResponse from a JSON string
create_paycheck_employer_response_instance = CreatePaycheckEmployerResponse.from_json(json)
# print the JSON string representation of the object
print(CreatePaycheckEmployerResponse.to_json())

# convert the object into a dict
create_paycheck_employer_response_dict = create_paycheck_employer_response_instance.to_dict()
# create an instance of CreatePaycheckEmployerResponse from a dict
create_paycheck_employer_response_from_dict = CreatePaycheckEmployerResponse.from_dict(create_paycheck_employer_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


