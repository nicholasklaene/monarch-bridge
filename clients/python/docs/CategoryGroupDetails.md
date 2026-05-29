# CategoryGroupDetails


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**name** | **str** |  | [optional] 
**order** | **int** |  | [optional] 
**type** | **str** |  | [optional] 
**color** | **str** |  | [optional] 
**group_level_budgeting_enabled** | **bool** |  | [optional] 
**budget_variability** | **str** |  | [optional] 
**rollover_period_id** | **str** |  | [optional] 
**rollover_start_month** | **date** |  | [optional] 
**rollover_end_month** | **date** |  | [optional] 
**rollover_starting_balance** | **float** |  | [optional] 
**categories** | [**List[CategoryGroupChildCategory]**](CategoryGroupChildCategory.md) |  | [optional] 

## Example

```python
from monarch_bridge_client.models.category_group_details import CategoryGroupDetails

# TODO update the JSON string below
json = "{}"
# create an instance of CategoryGroupDetails from a JSON string
category_group_details_instance = CategoryGroupDetails.from_json(json)
# print the JSON string representation of the object
print(CategoryGroupDetails.to_json())

# convert the object into a dict
category_group_details_dict = category_group_details_instance.to_dict()
# create an instance of CategoryGroupDetails from a dict
category_group_details_from_dict = CategoryGroupDetails.from_dict(category_group_details_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


