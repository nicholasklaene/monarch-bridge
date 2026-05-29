# CategoryReport


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**category_id** | **str** |  | 
**category_name** | **str** |  | [optional] 
**total_amount** | **float** |  | [optional] 
**average_per_month** | **float** |  | [optional] 
**months** | [**List[CategoryReportMonth]**](CategoryReportMonth.md) |  | 

## Example

```python
from monarch_bridge_client.models.category_report import CategoryReport

# TODO update the JSON string below
json = "{}"
# create an instance of CategoryReport from a JSON string
category_report_instance = CategoryReport.from_json(json)
# print the JSON string representation of the object
print(CategoryReport.to_json())

# convert the object into a dict
category_report_dict = category_report_instance.to_dict()
# create an instance of CategoryReport from a dict
category_report_from_dict = CategoryReport.from_dict(category_report_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


