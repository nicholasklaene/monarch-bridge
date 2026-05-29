# UpdateCategoryGroupRequest

Body for `PATCH /v1/category-groups/{id}`. Wraps Monarch's `UpdateCategoryGroupInput`. Every field is optional; only non-null fields are forwarded. Path `{id}` is injected into the GraphQL `input` automatically. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **str** |  | [optional] 
**color** | **str** |  | [optional] 
**icon** | **str** |  | [optional] 
**budget_variability** | **str** |  | [optional] 
**group_level_budgeting_enabled** | **bool** |  | [optional] 
**rollover_enabled** | **bool** |  | [optional] 
**rollover_type** | **str** |  | [optional] 
**rollover_start_month** | **str** |  | [optional] 
**rollover_starting_balance** | **float** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.update_category_group_request import UpdateCategoryGroupRequest

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateCategoryGroupRequest from a JSON string
update_category_group_request_instance = UpdateCategoryGroupRequest.from_json(json)
# print the JSON string representation of the object
print(UpdateCategoryGroupRequest.to_json())

# convert the object into a dict
update_category_group_request_dict = update_category_group_request_instance.to_dict()
# create an instance of UpdateCategoryGroupRequest from a dict
update_category_group_request_from_dict = UpdateCategoryGroupRequest.from_dict(update_category_group_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


