# GetCategoryReportResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**GetCategoryReportResponseData**](GetCategoryReportResponseData.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_category_report_response import GetCategoryReportResponse

# TODO update the JSON string below
json = "{}"
# create an instance of GetCategoryReportResponse from a JSON string
get_category_report_response_instance = GetCategoryReportResponse.from_json(json)
# print the JSON string representation of the object
print(GetCategoryReportResponse.to_json())

# convert the object into a dict
get_category_report_response_dict = get_category_report_response_instance.to_dict()
# create an instance of GetCategoryReportResponse from a dict
get_category_report_response_from_dict = GetCategoryReportResponse.from_dict(get_category_report_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


