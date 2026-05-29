# CategoryGroup

A parent category group (one tier above individual categories).

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**name** | **str** |  | 
**order** | **int** |  | [optional] 
**type** | **str** | One of &#x60;income&#x60;, &#x60;expense&#x60;, &#x60;transfer&#x60;. | [optional] 
**updated_at** | **str** |  | [optional] 
**created_at** | **str** |  | [optional] 
**color** | **str** | Display color hex (sent by &#x60;CategoryGroupFields&#x60;). | [optional] 
**group_level_budgeting_enabled** | **bool** | True when the user budgets at group level rather than per-category. | [optional] 
**budget_variability** | **str** | One of &#x60;fixed&#x60;, &#x60;flexible&#x60;, &#x60;non_monthly&#x60;. Drives fixed-vs-flex bucket classification. | [optional] 
**rollover_period** | [**CategoryGroupRolloverPeriod**](CategoryGroupRolloverPeriod.md) |  | [optional] 

## Example

```python
from monarch_bridge_client.models.category_group import CategoryGroup

# TODO update the JSON string below
json = "{}"
# create an instance of CategoryGroup from a JSON string
category_group_instance = CategoryGroup.from_json(json)
# print the JSON string representation of the object
print(CategoryGroup.to_json())

# convert the object into a dict
category_group_dict = category_group_instance.to_dict()
# create an instance of CategoryGroup from a dict
category_group_from_dict = CategoryGroup.from_dict(category_group_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


