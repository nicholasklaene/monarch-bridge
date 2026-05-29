# GetIncomeReportResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**report** | [**IncomeReport**](IncomeReport.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_income_report_response_data import GetIncomeReportResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetIncomeReportResponseData from a JSON string
get_income_report_response_data_instance = GetIncomeReportResponseData.from_json(json)
# print the JSON string representation of the object
print(GetIncomeReportResponseData.to_json())

# convert the object into a dict
get_income_report_response_data_dict = get_income_report_response_data_instance.to_dict()
# create an instance of GetIncomeReportResponseData from a dict
get_income_report_response_data_from_dict = GetIncomeReportResponseData.from_dict(get_income_report_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


