# CreatePaycheckEmployerResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**employer** | [**PaycheckEmployer**](PaycheckEmployer.md) |  | 

## Example

```python
from monarch_bridge_client.models.create_paycheck_employer_response_data import CreatePaycheckEmployerResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of CreatePaycheckEmployerResponseData from a JSON string
create_paycheck_employer_response_data_instance = CreatePaycheckEmployerResponseData.from_json(json)
# print the JSON string representation of the object
print(CreatePaycheckEmployerResponseData.to_json())

# convert the object into a dict
create_paycheck_employer_response_data_dict = create_paycheck_employer_response_data_instance.to_dict()
# create an instance of CreatePaycheckEmployerResponseData from a dict
create_paycheck_employer_response_data_from_dict = CreatePaycheckEmployerResponseData.from_dict(create_paycheck_employer_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


