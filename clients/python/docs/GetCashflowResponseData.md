# GetCashflowResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**summary** | [**CashflowSummary**](CashflowSummary.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_cashflow_response_data import GetCashflowResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetCashflowResponseData from a JSON string
get_cashflow_response_data_instance = GetCashflowResponseData.from_json(json)
# print the JSON string representation of the object
print(GetCashflowResponseData.to_json())

# convert the object into a dict
get_cashflow_response_data_dict = get_cashflow_response_data_instance.to_dict()
# create an instance of GetCashflowResponseData from a dict
get_cashflow_response_data_from_dict = GetCashflowResponseData.from_dict(get_cashflow_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


