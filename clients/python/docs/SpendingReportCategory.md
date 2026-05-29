# SpendingReportCategory


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**category_id** | **str** |  | 
**name** | **str** |  | 
**amount** | **float** |  | [optional] 
**percent_of_total** | **float** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.spending_report_category import SpendingReportCategory

# TODO update the JSON string below
json = "{}"
# create an instance of SpendingReportCategory from a JSON string
spending_report_category_instance = SpendingReportCategory.from_json(json)
# print the JSON string representation of the object
print(SpendingReportCategory.to_json())

# convert the object into a dict
spending_report_category_dict = spending_report_category_instance.to_dict()
# create an instance of SpendingReportCategory from a dict
spending_report_category_from_dict = SpendingReportCategory.from_dict(spending_report_category_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


