# CashflowReport


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**total_income** | **float** |  | [optional] 
**total_expense** | **float** |  | [optional] 
**net_cashflow** | **float** |  | [optional] 
**months** | [**List[CashflowReportMonth]**](CashflowReportMonth.md) |  | 

## Example

```python
from monarch_bridge_client.models.cashflow_report import CashflowReport

# TODO update the JSON string below
json = "{}"
# create an instance of CashflowReport from a JSON string
cashflow_report_instance = CashflowReport.from_json(json)
# print the JSON string representation of the object
print(CashflowReport.to_json())

# convert the object into a dict
cashflow_report_dict = cashflow_report_instance.to_dict()
# create an instance of CashflowReport from a dict
cashflow_report_from_dict = CashflowReport.from_dict(cashflow_report_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


