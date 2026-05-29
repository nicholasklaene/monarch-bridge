# IncomeReport


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**total_income** | **float** |  | [optional] 
**average_monthly_income** | **float** |  | [optional] 
**sources** | [**List[IncomeReportSource]**](IncomeReportSource.md) |  | 

## Example

```python
from monarch_bridge_client.models.income_report import IncomeReport

# TODO update the JSON string below
json = "{}"
# create an instance of IncomeReport from a JSON string
income_report_instance = IncomeReport.from_json(json)
# print the JSON string representation of the object
print(IncomeReport.to_json())

# convert the object into a dict
income_report_dict = income_report_instance.to_dict()
# create an instance of IncomeReport from a dict
income_report_from_dict = IncomeReport.from_dict(income_report_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


