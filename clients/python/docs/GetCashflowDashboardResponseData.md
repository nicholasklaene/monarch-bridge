# GetCashflowDashboardResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**by_day** | [**List[CashflowDayPoint]**](CashflowDayPoint.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_cashflow_dashboard_response_data import GetCashflowDashboardResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetCashflowDashboardResponseData from a JSON string
get_cashflow_dashboard_response_data_instance = GetCashflowDashboardResponseData.from_json(json)
# print the JSON string representation of the object
print(GetCashflowDashboardResponseData.to_json())

# convert the object into a dict
get_cashflow_dashboard_response_data_dict = get_cashflow_dashboard_response_data_instance.to_dict()
# create an instance of GetCashflowDashboardResponseData from a dict
get_cashflow_dashboard_response_data_from_dict = GetCashflowDashboardResponseData.from_dict(get_cashflow_dashboard_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


