# CreatePaycheckEmployerRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **str** |  | 

## Example

```python
from monarch_bridge_client.models.create_paycheck_employer_request import CreatePaycheckEmployerRequest

# TODO update the JSON string below
json = "{}"
# create an instance of CreatePaycheckEmployerRequest from a JSON string
create_paycheck_employer_request_instance = CreatePaycheckEmployerRequest.from_json(json)
# print the JSON string representation of the object
print(CreatePaycheckEmployerRequest.to_json())

# convert the object into a dict
create_paycheck_employer_request_dict = create_paycheck_employer_request_instance.to_dict()
# create an instance of CreatePaycheckEmployerRequest from a dict
create_paycheck_employer_request_from_dict = CreatePaycheckEmployerRequest.from_dict(create_paycheck_employer_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


