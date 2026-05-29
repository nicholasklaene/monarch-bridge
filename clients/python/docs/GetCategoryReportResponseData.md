# GetCategoryReportResponseData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**report** | [**CategoryReport**](CategoryReport.md) |  | 

## Example

```python
from monarch_bridge_client.models.get_category_report_response_data import GetCategoryReportResponseData

# TODO update the JSON string below
json = "{}"
# create an instance of GetCategoryReportResponseData from a JSON string
get_category_report_response_data_instance = GetCategoryReportResponseData.from_json(json)
# print the JSON string representation of the object
print(GetCategoryReportResponseData.to_json())

# convert the object into a dict
get_category_report_response_data_dict = get_category_report_response_data_instance.to_dict()
# create an instance of GetCategoryReportResponseData from a dict
get_category_report_response_data_from_dict = GetCategoryReportResponseData.from_dict(get_category_report_response_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


