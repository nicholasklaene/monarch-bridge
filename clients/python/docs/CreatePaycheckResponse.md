# CreatePaycheckResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**CreatePaycheckResponseData**](CreatePaycheckResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.create_paycheck_response import CreatePaycheckResponse

# TODO update the JSON string below
json = "{}"
# create an instance of CreatePaycheckResponse from a JSON string
create_paycheck_response_instance = CreatePaycheckResponse.from_json(json)
# print the JSON string representation of the object
print(CreatePaycheckResponse.to_json())

# convert the object into a dict
create_paycheck_response_dict = create_paycheck_response_instance.to_dict()
# create an instance of CreatePaycheckResponse from a dict
create_paycheck_response_from_dict = CreatePaycheckResponse.from_dict(create_paycheck_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


