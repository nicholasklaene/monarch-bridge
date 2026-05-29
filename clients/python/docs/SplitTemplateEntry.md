# SplitTemplateEntry


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**category_id** | **str** |  | 
**category_name** | **str** |  | [optional] 
**percent** | **float** | Percent of parent amount (0-100). | [optional] 

## Example

```python
from monarch_bridge_client.models.split_template_entry import SplitTemplateEntry

# TODO update the JSON string below
json = "{}"
# create an instance of SplitTemplateEntry from a JSON string
split_template_entry_instance = SplitTemplateEntry.from_json(json)
# print the JSON string representation of the object
print(SplitTemplateEntry.to_json())

# convert the object into a dict
split_template_entry_dict = split_template_entry_instance.to_dict()
# create an instance of SplitTemplateEntry from a dict
split_template_entry_from_dict = SplitTemplateEntry.from_dict(split_template_entry_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


