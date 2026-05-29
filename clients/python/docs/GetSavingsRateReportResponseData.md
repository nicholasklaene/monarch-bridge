# GetSavingsRateReportResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**report** | [**SavingsRateReport**](SavingsRateReport.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_savings_rate_report_response_data import GetSavingsRateReportResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetSavingsRateReportResponseData from a JSON string
get_savings_rate_report_response_data_instance = GetSavingsRateReportResponseData.from_json(json)
# print the JSON string representation of the object
print(GetSavingsRateReportResponseData.to_json())

# convert the object into a dict
get_savings_rate_report_response_data_dict = get_savings_rate_report_response_data_instance.to_dict()
# create an instance of GetSavingsRateReportResponseData from a dict
get_savings_rate_report_response_data_from_dict = GetSavingsRateReportResponseData.from_dict(get_savings_rate_report_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


