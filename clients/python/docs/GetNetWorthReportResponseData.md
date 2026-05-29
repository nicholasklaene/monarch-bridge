# GetNetWorthReportResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**report** | [**NetWorthReport**](NetWorthReport.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_net_worth_report_response_data import GetNetWorthReportResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetNetWorthReportResponseData from a JSON string
get_net_worth_report_response_data_instance = GetNetWorthReportResponseData.from_json(json)
# print the JSON string representation of the object
print(GetNetWorthReportResponseData.to_json())

# convert the object into a dict
get_net_worth_report_response_data_dict = get_net_worth_report_response_data_instance.to_dict()
# create an instance of GetNetWorthReportResponseData from a dict
get_net_worth_report_response_data_from_dict = GetNetWorthReportResponseData.from_dict(get_net_worth_report_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


