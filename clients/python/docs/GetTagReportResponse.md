# GetTagReportResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetTagReportResponseData**](GetTagReportResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_tag_report_response import GetTagReportResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetTagReportResponse from a JSON string
get_tag_report_response_instance = GetTagReportResponse.from_json(json)
# print the JSON string representation of the object
print(GetTagReportResponse.to_json())

# convert the object into a dict
get_tag_report_response_dict = get_tag_report_response_instance.to_dict()
# create an instance of GetTagReportResponse from a dict
get_tag_report_response_from_dict = GetTagReportResponse.from_dict(get_tag_report_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


