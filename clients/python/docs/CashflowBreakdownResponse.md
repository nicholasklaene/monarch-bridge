# CashflowBreakdownResponse

Cashflow broken down into four buckets. The bucket arrays are free-form Monarch trees (category / group / merchant aggregates); summary is also free-form. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetCashflowBreakdownResponseData**](GetCashflowBreakdownResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.cashflow_breakdown_response import CashflowBreakdownResponse

# TODO update the JSON string below
json = "{}"
# create an instance of CashflowBreakdownResponse from a JSON string
cashflow_breakdown_response_instance = CashflowBreakdownResponse.from_json(json)
# print the JSON string representation of the object
print(CashflowBreakdownResponse.to_json())

# convert the object into a dict
cashflow_breakdown_response_dict = cashflow_breakdown_response_instance.to_dict()
# create an instance of CashflowBreakdownResponse from a dict
cashflow_breakdown_response_from_dict = CashflowBreakdownResponse.from_dict(cashflow_breakdown_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


