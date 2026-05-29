# GetIncomeReportResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetIncomeReportResponseData**](GetIncomeReportResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_income_report_response import GetIncomeReportResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetIncomeReportResponse from a JSON string
get_income_report_response_instance = GetIncomeReportResponse.from_json(json)
# print the JSON string representation of the object
print(GetIncomeReportResponse.to_json())

# convert the object into a dict
get_income_report_response_dict = get_income_report_response_instance.to_dict()
# create an instance of GetIncomeReportResponse from a dict
get_income_report_response_from_dict = GetIncomeReportResponse.from_dict(get_income_report_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


