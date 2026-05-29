# SplitTemplate


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**name** | **str** |  | 
**splits** | [**List[SplitTemplateEntry]**](SplitTemplateEntry.md) |  | 

## Example

```python
from monarch_bridge_client.models.split_template import SplitTemplate

# TODO update the JSON string below
json = "{}"
# create an instance of SplitTemplate from a JSON string
split_template_instance = SplitTemplate.from_json(json)
# print the JSON string representation of the object
print(SplitTemplate.to_json())

# convert the object into a dict
split_template_dict = split_template_instance.to_dict()
# create an instance of SplitTemplate from a dict
split_template_from_dict = SplitTemplate.from_dict(split_template_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


