# CashflowReportMonth


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**month** | **str** |  | [optional] 
**income** | **float** |  | [optional] 
**expense** | **float** |  | [optional] 
**net** | **float** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.cashflow_report_month import CashflowReportMonth

# TODO update the JSON string below
json = "{}"
# create an instance of CashflowReportMonth from a JSON string
cashflow_report_month_instance = CashflowReportMonth.from_json(json)
# print the JSON string representation of the object
print(CashflowReportMonth.to_json())

# convert the object into a dict
cashflow_report_month_dict = cashflow_report_month_instance.to_dict()
# create an instance of CashflowReportMonth from a dict
cashflow_report_month_from_dict = CashflowReportMonth.from_dict(cashflow_report_month_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


