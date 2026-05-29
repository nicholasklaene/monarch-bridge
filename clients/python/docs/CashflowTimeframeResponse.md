# CashflowTimeframeResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetCashflowTimeframeResponseData**](GetCashflowTimeframeResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.cashflow_timeframe_response import CashflowTimeframeResponse

# TODO update the JSON string below
json = "{}"
# create an instance of CashflowTimeframeResponse from a JSON string
cashflow_timeframe_response_instance = CashflowTimeframeResponse.from_json(json)
# print the JSON string representation of the object
print(CashflowTimeframeResponse.to_json())

# convert the object into a dict
cashflow_timeframe_response_dict = cashflow_timeframe_response_instance.to_dict()
# create an instance of CashflowTimeframeResponse from a dict
cashflow_timeframe_response_from_dict = CashflowTimeframeResponse.from_dict(cashflow_timeframe_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


