# TagReportMonth


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**month** | **str** |  | [optional] 
**amount** | **float** |  | [optional] 
**count** | **int** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.tag_report_month import TagReportMonth

# TODO update the JSON string below
json = "{}"
# create an instance of TagReportMonth from a JSON string
tag_report_month_instance = TagReportMonth.from_json(json)
# print the JSON string representation of the object
print(TagReportMonth.to_json())

# convert the object into a dict
tag_report_month_dict = tag_report_month_instance.to_dict()
# create an instance of TagReportMonth from a dict
tag_report_month_from_dict = TagReportMonth.from_dict(tag_report_month_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


