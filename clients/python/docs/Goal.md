# Goal

A v2 savings goal.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**name** | **str** |  | 
**type** | **str** | One of &#x60;savings&#x60;, &#x60;debt&#x60;. | [optional] 
**status** | **str** | Lifecycle status (&#x60;active&#x60;, &#x60;complete&#x60;, &#x60;archived&#x60;, etc.). | [optional] 
**progress** | **float** | 0.0 → 1.0 fraction of &#x60;targetAmount&#x60; reached. | [optional] 
**current_balance** | **float** |  | [optional] 
**target_amount** | **float** |  | [optional] 
**target_date** | **str** | ISO date the user is aiming for (&#x60;YYYY-MM-DD&#x60;); nullable for open-ended goals. | [optional] 
**archived_at** | **str** | ISO timestamp the goal was archived; null for active goals. | [optional] 
**created_at** | **str** |  | [optional] 
**priority** | **int** | User-set ordering (lower &#x3D; higher priority). | [optional] 
**is_sinking_fund** | **bool** |  | [optional] 
**planned_monthly_contribution** | **float** |  | [optional] 
**estimated_months_until_completion** | **int** |  | [optional] 
**forecasted_completion_date** | **str** |  | [optional] 
**image_storage_provider** | **str** |  | [optional] 
**image_storage_provider_id** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.goal import Goal

# TODO update the JSON string below
json = "{}"
# create an instance of Goal from a JSON string
goal_instance = Goal.from_json(json)
# print the JSON string representation of the object
print(Goal.to_json())

# convert the object into a dict
goal_dict = goal_instance.to_dict()
# create an instance of Goal from a dict
goal_from_dict = Goal.from_dict(goal_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


