# GetCashflowResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetCashflowResponseData**](GetCashflowResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_cashflow_response import GetCashflowResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetCashflowResponse from a JSON string
get_cashflow_response_instance = GetCashflowResponse.from_json(json)
# print the JSON string representation of the object
print(GetCashflowResponse.to_json())

# convert the object into a dict
get_cashflow_response_dict = get_cashflow_response_instance.to_dict()
# create an instance of GetCashflowResponse from a dict
get_cashflow_response_from_dict = GetCashflowResponse.from_dict(get_cashflow_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


