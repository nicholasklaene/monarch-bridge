# GetMonthlyReportSummaryResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetMonthlyReportSummaryResponseData**](GetMonthlyReportSummaryResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_monthly_report_summary_response import GetMonthlyReportSummaryResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetMonthlyReportSummaryResponse from a JSON string
get_monthly_report_summary_response_instance = GetMonthlyReportSummaryResponse.from_json(json)
# print the JSON string representation of the object
print(GetMonthlyReportSummaryResponse.to_json())

# convert the object into a dict
get_monthly_report_summary_response_dict = get_monthly_report_summary_response_instance.to_dict()
# create an instance of GetMonthlyReportSummaryResponse from a dict
get_monthly_report_summary_response_from_dict = GetMonthlyReportSummaryResponse.from_dict(get_monthly_report_summary_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


