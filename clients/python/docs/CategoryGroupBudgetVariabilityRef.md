# CategoryGroupBudgetVariabilityRef

Minimal response shape for the budget-variability update endpoint.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**budget_variability** | **str** |  | [optional] 
**updated_at** | **str** |  | [optional] 

## Example

```python
from monarch_bridge_client.models.category_group_budget_variability_ref import CategoryGroupBudgetVariabilityRef

# TODO update the JSON string below
json = "{}"
# create an instance of CategoryGroupBudgetVariabilityRef from a JSON string
category_group_budget_variability_ref_instance = CategoryGroupBudgetVariabilityRef.from_json(json)
# print the JSON string representation of the object
print(CategoryGroupBudgetVariabilityRef.to_json())

# convert the object into a dict
category_group_budget_variability_ref_dict = category_group_budget_variability_ref_instance.to_dict()
# create an instance of CategoryGroupBudgetVariabilityRef from a dict
category_group_budget_variability_ref_from_dict = CategoryGroupBudgetVariabilityRef.from_dict(category_group_budget_variability_ref_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


