# GetCashflowReportResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetCashflowReportResponseData**](GetCashflowReportResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_cashflow_report_response import GetCashflowReportResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetCashflowReportResponse from a JSON string
get_cashflow_report_response_instance = GetCashflowReportResponse.from_json(json)
# print the JSON string representation of the object
print(GetCashflowReportResponse.to_json())

# convert the object into a dict
get_cashflow_report_response_dict = get_cashflow_report_response_instance.to_dict()
# create an instance of GetCashflowReportResponse from a dict
get_cashflow_report_response_from_dict = GetCashflowReportResponse.from_dict(get_cashflow_report_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


