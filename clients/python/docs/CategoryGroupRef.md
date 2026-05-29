# CategoryGroupRef

Minimal group reference embedded inside a `Category`. Use the full [CategoryGroup] schema when reading from `/v1/category-groups` directly. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**name** | **str** |  | [optional] 
**type** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.category_group_ref import CategoryGroupRef

# TODO update the JSON string below
json = "{}"
# create an instance of CategoryGroupRef from a JSON string
category_group_ref_instance = CategoryGroupRef.from_json(json)
# print the JSON string representation of the object
print(CategoryGroupRef.to_json())

# convert the object into a dict
category_group_ref_dict = category_group_ref_instance.to_dict()
# create an instance of CategoryGroupRef from a dict
category_group_ref_from_dict = CategoryGroupRef.from_dict(category_group_ref_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


