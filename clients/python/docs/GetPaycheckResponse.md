# GetPaycheckResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**CreatePaycheckResponseData**](CreatePaycheckResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_paycheck_response import GetPaycheckResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetPaycheckResponse from a JSON string
get_paycheck_response_instance = GetPaycheckResponse.from_json(json)
# print the JSON string representation of the object
print(GetPaycheckResponse.to_json())

# convert the object into a dict
get_paycheck_response_dict = get_paycheck_response_instance.to_dict()
# create an instance of GetPaycheckResponse from a dict
get_paycheck_response_from_dict = GetPaycheckResponse.from_dict(get_paycheck_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


