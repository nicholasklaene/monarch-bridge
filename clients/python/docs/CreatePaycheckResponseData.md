# CreatePaycheckResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**paycheck** | [**Paycheck**](Paycheck.md) |  | 

## Example

```python
from monarch_bridge_client.models.create_paycheck_response_data import CreatePaycheckResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of CreatePaycheckResponseData from a JSON string
create_paycheck_response_data_instance = CreatePaycheckResponseData.from_json(json)
# print the JSON string representation of the object
print(CreatePaycheckResponseData.to_json())

# convert the object into a dict
create_paycheck_response_data_dict = create_paycheck_response_data_instance.to_dict()
# create an instance of CreatePaycheckResponseData from a dict
create_paycheck_response_data_from_dict = CreatePaycheckResponseData.from_dict(create_paycheck_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


