# CategoryGroupChildCategory


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**name** | **str** |  | [optional] 
**icon** | **str** |  | [optional] 
**rollover_period_id** | **str** |  | [optional] 
**rollover_start_month** | **date** |  | [optional] 
**rollover_starting_balance** | **float** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.category_group_child_category import CategoryGroupChildCategory

# TODO update the JSON string below
json = "{}"
# create an instance of CategoryGroupChildCategory from a JSON string
category_group_child_category_instance = CategoryGroupChildCategory.from_json(json)
# print the JSON string representation of the object
print(CategoryGroupChildCategory.to_json())

# convert the object into a dict
category_group_child_category_dict = category_group_child_category_instance.to_dict()
# create an instance of CategoryGroupChildCategory from a dict
category_group_child_category_from_dict = CategoryGroupChildCategory.from_dict(category_group_child_category_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


