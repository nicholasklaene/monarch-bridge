# CategoryEditFields


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**name** | **str** |  | [optional] 
**order** | **int** |  | [optional] 
**icon** | **str** |  | [optional] 
**system_category** | **str** |  | [optional] 
**system_category_display_name** | **str** |  | [optional] 
**budget_variability** | **str** |  | [optional] 
**exclude_from_budget** | **bool** |  | [optional] 
**is_system_category** | **bool** |  | [optional] 
**is_disabled** | **bool** |  | [optional] 
**is_protected** | **bool** |  | [optional] 
**group_id** | **str** |  | [optional] 
**group_type** | **str** |  | [optional] 
**group_level_budgeting_enabled** | **bool** |  | [optional] 
**rollover_period_id** | **str** |  | [optional] 
**rollover_start_month** | **date** |  | [optional] 
**rollover_starting_balance** | **float** |  | [optional] 
**rollover_type** | **str** |  | [optional] 
**rollover_frequency** | **str** |  | [optional] 
**rollover_target_amount** | **float** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.category_edit_fields import CategoryEditFields

# TODO update the JSON string below
json = "{}"
# create an instance of CategoryEditFields from a JSON string
category_edit_fields_instance = CategoryEditFields.from_json(json)
# print the JSON string representation of the object
print(CategoryEditFields.to_json())

# convert the object into a dict
category_edit_fields_dict = category_edit_fields_instance.to_dict()
# create an instance of CategoryEditFields from a dict
category_edit_fields_from_dict = CategoryEditFields.from_dict(category_edit_fields_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


