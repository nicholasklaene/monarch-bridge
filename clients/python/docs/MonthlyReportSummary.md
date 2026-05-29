# MonthlyReportSummary


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**month** | **str** |  | [optional] 
**net_income** | **float** |  | [optional] 
**total_spending** | **float** |  | [optional] 
**total_income** | **float** |  | [optional] 
**savings_rate** | **float** |  | [optional] 
**top_merchant** | **str** |  | [optional] 
**top_category** | **str** |  | [optional] 
**biggest_spend** | **float** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.monthly_report_summary import MonthlyReportSummary

# TODO update the JSON string below
json = "{}"
# create an instance of MonthlyReportSummary from a JSON string
monthly_report_summary_instance = MonthlyReportSummary.from_json(json)
# print the JSON string representation of the object
print(MonthlyReportSummary.to_json())

# convert the object into a dict
monthly_report_summary_dict = monthly_report_summary_instance.to_dict()
# create an instance of MonthlyReportSummary from a dict
monthly_report_summary_from_dict = MonthlyReportSummary.from_dict(monthly_report_summary_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


