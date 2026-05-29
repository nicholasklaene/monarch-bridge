# GetSpendingReportResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetSpendingReportResponseData**](GetSpendingReportResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_spending_report_response import GetSpendingReportResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetSpendingReportResponse from a JSON string
get_spending_report_response_instance = GetSpendingReportResponse.from_json(json)
# print the JSON string representation of the object
print(GetSpendingReportResponse.to_json())

# convert the object into a dict
get_spending_report_response_dict = get_spending_report_response_instance.to_dict()
# create an instance of GetSpendingReportResponse from a dict
get_spending_report_response_from_dict = GetSpendingReportResponse.from_dict(get_spending_report_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


