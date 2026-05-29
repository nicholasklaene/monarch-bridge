# GetTagReportResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**report** | [**TagReport**](TagReport.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_tag_report_response_data import GetTagReportResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetTagReportResponseData from a JSON string
get_tag_report_response_data_instance = GetTagReportResponseData.from_json(json)
# print the JSON string representation of the object
print(GetTagReportResponseData.to_json())

# convert the object into a dict
get_tag_report_response_data_dict = get_tag_report_response_data_instance.to_dict()
# create an instance of GetTagReportResponseData from a dict
get_tag_report_response_data_from_dict = GetTagReportResponseData.from_dict(get_tag_report_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


