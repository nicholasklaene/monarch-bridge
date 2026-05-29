# GetCashflowTimeframeResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**by_year** | [**List[CashflowTimeframeBucket]**](CashflowTimeframeBucket.md) |  | 
**by_month** | [**List[CashflowTimeframeBucket]**](CashflowTimeframeBucket.md) |  | 
**by_quarter** | [**List[CashflowTimeframeBucket]**](CashflowTimeframeBucket.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_cashflow_timeframe_response_data import GetCashflowTimeframeResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetCashflowTimeframeResponseData from a JSON string
get_cashflow_timeframe_response_data_instance = GetCashflowTimeframeResponseData.from_json(json)
# print the JSON string representation of the object
print(GetCashflowTimeframeResponseData.to_json())

# convert the object into a dict
get_cashflow_timeframe_response_data_dict = get_cashflow_timeframe_response_data_instance.to_dict()
# create an instance of GetCashflowTimeframeResponseData from a dict
get_cashflow_timeframe_response_data_from_dict = GetCashflowTimeframeResponseData.from_dict(get_cashflow_timeframe_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


