# GetSavingsRateReportResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetSavingsRateReportResponseData**](GetSavingsRateReportResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_savings_rate_report_response import GetSavingsRateReportResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetSavingsRateReportResponse from a JSON string
get_savings_rate_report_response_instance = GetSavingsRateReportResponse.from_json(json)
# print the JSON string representation of the object
print(GetSavingsRateReportResponse.to_json())

# convert the object into a dict
get_savings_rate_report_response_dict = get_savings_rate_report_response_instance.to_dict()
# create an instance of GetSavingsRateReportResponse from a dict
get_savings_rate_report_response_from_dict = GetSavingsRateReportResponse.from_dict(get_savings_rate_report_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


