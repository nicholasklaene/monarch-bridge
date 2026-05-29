# GetMonthlyReportSummaryResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**summary** | [**MonthlyReportSummary**](MonthlyReportSummary.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_monthly_report_summary_response_data import GetMonthlyReportSummaryResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetMonthlyReportSummaryResponseData from a JSON string
get_monthly_report_summary_response_data_instance = GetMonthlyReportSummaryResponseData.from_json(json)
# print the JSON string representation of the object
print(GetMonthlyReportSummaryResponseData.to_json())

# convert the object into a dict
get_monthly_report_summary_response_data_dict = get_monthly_report_summary_response_data_instance.to_dict()
# create an instance of GetMonthlyReportSummaryResponseData from a dict
get_monthly_report_summary_response_data_from_dict = GetMonthlyReportSummaryResponseData.from_dict(get_monthly_report_summary_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


