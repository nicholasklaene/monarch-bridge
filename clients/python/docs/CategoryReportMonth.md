# CategoryReportMonth


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**month** | **str** |  | [optional] 
**amount** | **float** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.category_report_month import CategoryReportMonth

# TODO update the JSON string below
json = "{}"
# create an instance of CategoryReportMonth from a JSON string
category_report_month_instance = CategoryReportMonth.from_json(json)
# print the JSON string representation of the object
print(CategoryReportMonth.to_json())

# convert the object into a dict
category_report_month_dict = category_report_month_instance.to_dict()
# create an instance of CategoryReportMonth from a dict
category_report_month_from_dict = CategoryReportMonth.from_dict(category_report_month_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


