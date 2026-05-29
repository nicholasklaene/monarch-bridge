# CategoryGroupRolloverPeriod

Current rollover window for a category group; null when rollover is disabled.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**start_month** | **str** | ISO date &#x60;YYYY-MM-DD&#x60; of the first month in the current rollover window. | [optional] 
**end_month** | **str** | ISO date &#x60;YYYY-MM-DD&#x60; of the last month in the current rollover window. | [optional] 
**starting_balance** | **float** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.category_group_rollover_period import CategoryGroupRolloverPeriod

# TODO update the JSON string below
json = "{}"
# create an instance of CategoryGroupRolloverPeriod from a JSON string
category_group_rollover_period_instance = CategoryGroupRolloverPeriod.from_json(json)
# print the JSON string representation of the object
print(CategoryGroupRolloverPeriod.to_json())

# convert the object into a dict
category_group_rollover_period_dict = category_group_rollover_period_instance.to_dict()
# create an instance of CategoryGroupRolloverPeriod from a dict
category_group_rollover_period_from_dict = CategoryGroupRolloverPeriod.from_dict(category_group_rollover_period_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


