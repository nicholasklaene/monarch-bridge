# TagReport


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**tag_id** | **str** |  | 
**tag_name** | **str** |  | [optional] 
**total_amount** | **float** |  | [optional] 
**transaction_count** | **int** |  | [optional] 
**months** | [**List[TagReportMonth]**](TagReportMonth.md) |  | 

## Example

```python
from monarch_bridge_client.models.tag_report import TagReport

# TODO update the JSON string below
json = "{}"
# create an instance of TagReport from a JSON string
tag_report_instance = TagReport.from_json(json)
# print the JSON string representation of the object
print(TagReport.to_json())

# convert the object into a dict
tag_report_dict = tag_report_instance.to_dict()
# create an instance of TagReport from a dict
tag_report_from_dict = TagReport.from_dict(tag_report_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


