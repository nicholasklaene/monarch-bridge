# TagRef

Minimal tag reference embedded in a transaction.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**name** | **str** |  | 
**color** | **str** |  | [optional] 
**order** | **int** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.tag_ref import TagRef

# TODO update the JSON string below
json = "{}"
# create an instance of TagRef from a JSON string
tag_ref_instance = TagRef.from_json(json)
# print the JSON string representation of the object
print(TagRef.to_json())

# convert the object into a dict
tag_ref_dict = tag_ref_instance.to_dict()
# create an instance of TagRef from a dict
tag_ref_from_dict = TagRef.from_dict(tag_ref_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


