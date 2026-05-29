# GetSpendingReportResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**report** | [**SpendingReport**](SpendingReport.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_spending_report_response_data import GetSpendingReportResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetSpendingReportResponseData from a JSON string
get_spending_report_response_data_instance = GetSpendingReportResponseData.from_json(json)
# print the JSON string representation of the object
print(GetSpendingReportResponseData.to_json())

# convert the object into a dict
get_spending_report_response_data_dict = get_spending_report_response_data_instance.to_dict()
# create an instance of GetSpendingReportResponseData from a dict
get_spending_report_response_data_from_dict = GetSpendingReportResponseData.from_dict(get_spending_report_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


