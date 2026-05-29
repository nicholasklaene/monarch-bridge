# CategoryDeletionInfo


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**name** | **str** |  | [optional] 
**icon** | **str** |  | [optional] 
**is_system_category** | **bool** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.category_deletion_info import CategoryDeletionInfo

# TODO update the JSON string below
json = "{}"
# create an instance of CategoryDeletionInfo from a JSON string
category_deletion_info_instance = CategoryDeletionInfo.from_json(json)
# print the JSON string representation of the object
print(CategoryDeletionInfo.to_json())

# convert the object into a dict
category_deletion_info_dict = category_deletion_info_instance.to_dict()
# create an instance of CategoryDeletionInfo from a dict
category_deletion_info_from_dict = CategoryDeletionInfo.from_dict(category_deletion_info_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


