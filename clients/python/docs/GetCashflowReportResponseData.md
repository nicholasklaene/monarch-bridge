# GetCashflowReportResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**report** | [**CashflowReport**](CashflowReport.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_cashflow_report_response_data import GetCashflowReportResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetCashflowReportResponseData from a JSON string
get_cashflow_report_response_data_instance = GetCashflowReportResponseData.from_json(json)
# print the JSON string representation of the object
print(GetCashflowReportResponseData.to_json())

# convert the object into a dict
get_cashflow_report_response_data_dict = get_cashflow_report_response_data_instance.to_dict()
# create an instance of GetCashflowReportResponseData from a dict
get_cashflow_report_response_data_from_dict = GetCashflowReportResponseData.from_dict(get_cashflow_report_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


