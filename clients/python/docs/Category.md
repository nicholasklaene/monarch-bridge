# Category

A transaction category. System and user-created categories share this shape.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**name** | **str** |  | 
**icon** | **str** |  | [optional] 
**order** | **int** |  | [optional] 
**system_category** | **str** |  | [optional] 
**is_system_category** | **bool** |  | [optional] 
**group** | [**CategoryGroupRef**](CategoryGroupRef.md) |  | [optional] 

## Example

```python
from monarch_bridge_client.models.category import Category

# TODO update the JSON string below
json = "{}"
# create an instance of Category from a JSON string
category_instance = Category.from_json(json)
# print the JSON string representation of the object
print(Category.to_json())

# convert the object into a dict
category_dict = category_instance.to_dict()
# create an instance of Category from a dict
category_from_dict = Category.from_dict(category_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


