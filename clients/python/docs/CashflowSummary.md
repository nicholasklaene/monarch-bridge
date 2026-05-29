# CashflowSummary

Aggregate cashflow totals for a window.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**sum_income** | **float** |  | [optional] 
**sum_expense** | **float** | Signed (negative). | [optional] 
**savings** | **float** |  | [optional] 
**savings_rate** | **float** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.cashflow_summary import CashflowSummary

# TODO update the JSON string below
json = "{}"
# create an instance of CashflowSummary from a JSON string
cashflow_summary_instance = CashflowSummary.from_json(json)
# print the JSON string representation of the object
print(CashflowSummary.to_json())

# convert the object into a dict
cashflow_summary_dict = cashflow_summary_instance.to_dict()
# create an instance of CashflowSummary from a dict
cashflow_summary_from_dict = CashflowSummary.from_dict(cashflow_summary_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


