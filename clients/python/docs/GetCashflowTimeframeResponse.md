# GetCashflowTimeframeResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetCashflowTimeframeResponseData**](GetCashflowTimeframeResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_cashflow_timeframe_response import GetCashflowTimeframeResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetCashflowTimeframeResponse from a JSON string
get_cashflow_timeframe_response_instance = GetCashflowTimeframeResponse.from_json(json)
# print the JSON string representation of the object
print(GetCashflowTimeframeResponse.to_json())

# convert the object into a dict
get_cashflow_timeframe_response_dict = get_cashflow_timeframe_response_instance.to_dict()
# create an instance of GetCashflowTimeframeResponse from a dict
get_cashflow_timeframe_response_from_dict = GetCashflowTimeframeResponse.from_dict(get_cashflow_timeframe_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


