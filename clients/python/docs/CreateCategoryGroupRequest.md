# CreateCategoryGroupRequest

Body for `POST /v1/category-groups`. Wraps Monarch's `CreateCategoryGroupInput`. `name` and `type` are required. `type` is one of `income`, `expense`, `transfer`. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **str** |  | 
**type** | **str** | One of &#x60;income&#x60;, &#x60;expense&#x60;, &#x60;transfer&#x60;. | 
**color** | **str** | Display color hex (with or without leading &#x60;#&#x60;). | [optional] 
**icon** | **str** |  | [optional] 
**budget_variability** | **str** | One of &#x60;fixed&#x60;, &#x60;flexible&#x60;, &#x60;non_monthly&#x60;. | [optional] 
**group_level_budgeting_enabled** | **bool** |  | [optional] 
**order_before** | **str** | UUID of an existing group; the new group is inserted before it. Omit to append at the end. | [optional] 
**rollover_enabled** | **bool** |  | [optional] 
**rollover_type** | **str** |  | [optional] 
**rollover_start_month** | **str** | ISO date &#x60;YYYY-MM-DD&#x60; of the first month in the initial rollover window. | [optional] 
**rollover_starting_balance** | **float** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.create_category_group_request import CreateCategoryGroupRequest

# TODO update the JSON string below
json = "{}"
# create an instance of CreateCategoryGroupRequest from a JSON string
create_category_group_request_instance = CreateCategoryGroupRequest.from_json(json)
# print the JSON string representation of the object
print(CreateCategoryGroupRequest.to_json())

# convert the object into a dict
create_category_group_request_dict = create_category_group_request_instance.to_dict()
# create an instance of CreateCategoryGroupRequest from a dict
create_category_group_request_from_dict = CreateCategoryGroupRequest.from_dict(create_category_group_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


