# CashflowDashboardResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetCashflowDashboardResponseData**](GetCashflowDashboardResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.cashflow_dashboard_response import CashflowDashboardResponse

# TODO update the JSON string below
json = "{}"
# create an instance of CashflowDashboardResponse from a JSON string
cashflow_dashboard_response_instance = CashflowDashboardResponse.from_json(json)
# print the JSON string representation of the object
print(CashflowDashboardResponse.to_json())

# convert the object into a dict
cashflow_dashboard_response_dict = cashflow_dashboard_response_instance.to_dict()
# create an instance of CashflowDashboardResponse from a dict
cashflow_dashboard_response_from_dict = CashflowDashboardResponse.from_dict(cashflow_dashboard_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


