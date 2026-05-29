# UpdatePaycheckEmployerRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **str** |  | 

## Example

```python
from monarch_bridge_client.models.update_paycheck_employer_request import UpdatePaycheckEmployerRequest

# TODO update the JSON string below
json = "{}"
# create an instance of UpdatePaycheckEmployerRequest from a JSON string
update_paycheck_employer_request_instance = UpdatePaycheckEmployerRequest.from_json(json)
# print the JSON string representation of the object
print(UpdatePaycheckEmployerRequest.to_json())

# convert the object into a dict
update_paycheck_employer_request_dict = update_paycheck_employer_request_instance.to_dict()
# create an instance of UpdatePaycheckEmployerRequest from a dict
update_paycheck_employer_request_from_dict = UpdatePaycheckEmployerRequest.from_dict(update_paycheck_employer_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


